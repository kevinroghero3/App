package io.sentry.cache;

import io.sentry.ISerializer;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.clientreport.DiscardReason;
import io.sentry.util.LazyEvaluator;
import io.sentry.util.Objects;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CacheStrategy {
    protected static final Charset UTF_8 = Charset.forName(CharEncoding.UTF_8);
    protected final File directory;
    private final int maxSize;
    protected SentryOptions options;
    protected final LazyEvaluator<ISerializer> serializer = new LazyEvaluator<>(new LazyEvaluator.Evaluator() { // from class: io.sentry.cache.CacheStrategy$$ExternalSyntheticLambda0
        @Override // io.sentry.util.LazyEvaluator.Evaluator
        public final Object evaluate() {
            return this.f$0.lambda$new$0();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ISerializer lambda$new$0() {
        return this.options.getSerializer();
    }

    CacheStrategy(@NotNull SentryOptions sentryOptions, @NotNull String str, int i) {
        Objects.requireNonNull(str, "Directory is required.");
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        this.directory = new File(str);
        this.maxSize = i;
    }

    protected boolean isDirectoryValid() {
        if (this.directory.isDirectory() && this.directory.canWrite() && this.directory.canRead()) {
            return true;
        }
        this.options.getLogger().log(SentryLevel.ERROR, "The directory for caching files is inaccessible.: %s", this.directory.getAbsolutePath());
        return false;
    }

    private void sortFilesOldestToNewest(@NotNull File[] fileArr) {
        if (fileArr.length > 1) {
            Arrays.sort(fileArr, new Comparator() { // from class: io.sentry.cache.CacheStrategy$$ExternalSyntheticLambda1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return CacheStrategy.lambda$sortFilesOldestToNewest$1((File) obj, (File) obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortFilesOldestToNewest$1(File file, File file2) {
        return Long.compare(file.lastModified(), file2.lastModified());
    }

    protected void rotateCacheIfNeeded(@NotNull File[] fileArr) {
        int length = fileArr.length;
        if (length >= this.maxSize) {
            this.options.getLogger().log(SentryLevel.WARNING, "Cache folder if full (respecting maxSize). Rotating files", new Object[0]);
            int i = (length - this.maxSize) + 1;
            sortFilesOldestToNewest(fileArr);
            File[] fileArr2 = (File[]) Arrays.copyOfRange(fileArr, i, length);
            for (int i2 = 0; i2 < i; i2++) {
                File file = fileArr[i2];
                moveInitFlagIfNecessary(file, fileArr2);
                if (!file.delete()) {
                    this.options.getLogger().log(SentryLevel.WARNING, "File can't be deleted: %s", file.getAbsolutePath());
                }
            }
        }
    }

    private void moveInitFlagIfNecessary(@NotNull File file, @NotNull File[] fileArr) {
        Boolean init;
        SentryEnvelopeItem sentryEnvelopeItemFromSession;
        Session session;
        SentryEnvelope envelope = readEnvelope(file);
        if (envelope == null || !isValidEnvelope(envelope)) {
            return;
        }
        this.options.getClientReportRecorder().recordLostEnvelope(DiscardReason.CACHE_OVERFLOW, envelope);
        Session firstSession = getFirstSession(envelope);
        if (firstSession == null || !isValidSession(firstSession) || (init = firstSession.getInit()) == null || !init.booleanValue()) {
            return;
        }
        for (File file2 : fileArr) {
            SentryEnvelope envelope2 = readEnvelope(file2);
            if (envelope2 != null && isValidEnvelope(envelope2)) {
                Iterator<SentryEnvelopeItem> it2 = envelope2.getItems().iterator();
                while (true) {
                    sentryEnvelopeItemFromSession = null;
                    if (!it2.hasNext()) {
                        break;
                    }
                    SentryEnvelopeItem next = it2.next();
                    if (isSessionType(next) && (session = readSession(next)) != null && isValidSession(session)) {
                        Boolean init2 = session.getInit();
                        if (init2 != null && init2.booleanValue()) {
                            this.options.getLogger().log(SentryLevel.ERROR, "Session %s has 2 times the init flag.", firstSession.getSessionId());
                            return;
                        }
                        if (firstSession.getSessionId() != null && firstSession.getSessionId().equals(session.getSessionId())) {
                            session.setInitAsTrue();
                            try {
                                sentryEnvelopeItemFromSession = SentryEnvelopeItem.fromSession(this.serializer.getValue(), session);
                                it2.remove();
                                break;
                            } catch (IOException e) {
                                this.options.getLogger().log(SentryLevel.ERROR, e, "Failed to create new envelope item for the session %s", firstSession.getSessionId());
                                break;
                            }
                        }
                    }
                }
                if (sentryEnvelopeItemFromSession != null) {
                    SentryEnvelope sentryEnvelopeBuildNewEnvelope = buildNewEnvelope(envelope2, sentryEnvelopeItemFromSession);
                    long jLastModified = file2.lastModified();
                    if (!file2.delete()) {
                        this.options.getLogger().log(SentryLevel.WARNING, "File can't be deleted: %s", file2.getAbsolutePath());
                    }
                    saveNewEnvelope(sentryEnvelopeBuildNewEnvelope, file2, jLastModified);
                    return;
                }
            }
        }
    }

    private SentryEnvelope readEnvelope(@NotNull File file) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                SentryEnvelope sentryEnvelopeDeserializeEnvelope = this.serializer.getValue().deserializeEnvelope(bufferedInputStream);
                bufferedInputStream.close();
                return sentryEnvelopeDeserializeEnvelope;
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to deserialize the envelope.", e);
            return null;
        }
    }

    private Session getFirstSession(@NotNull SentryEnvelope sentryEnvelope) {
        for (SentryEnvelopeItem sentryEnvelopeItem : sentryEnvelope.getItems()) {
            if (isSessionType(sentryEnvelopeItem)) {
                return readSession(sentryEnvelopeItem);
            }
        }
        return null;
    }

    private boolean isValidSession(@NotNull Session session) {
        return session.getStatus().equals(Session.State.Ok) && session.getSessionId() != null;
    }

    private boolean isSessionType(@Nullable SentryEnvelopeItem sentryEnvelopeItem) {
        if (sentryEnvelopeItem == null) {
            return false;
        }
        return sentryEnvelopeItem.getHeader().getType().equals(SentryItemType.Session);
    }

    private Session readSession(@NotNull SentryEnvelopeItem sentryEnvelopeItem) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sentryEnvelopeItem.getData()), UTF_8));
            try {
                Session session = (Session) this.serializer.getValue().deserialize(bufferedReader, Session.class);
                bufferedReader.close();
                return session;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to deserialize the session.", th3);
            return null;
        }
    }

    private void saveNewEnvelope(@NotNull SentryEnvelope sentryEnvelope, @NotNull File file, long j) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                this.serializer.getValue().serialize(sentryEnvelope, fileOutputStream);
                file.setLastModified(j);
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to serialize the new envelope to the disk.", th3);
        }
    }

    private SentryEnvelope buildNewEnvelope(@NotNull SentryEnvelope sentryEnvelope, @NotNull SentryEnvelopeItem sentryEnvelopeItem) {
        ArrayList arrayList = new ArrayList();
        Iterator<SentryEnvelopeItem> it2 = sentryEnvelope.getItems().iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        arrayList.add(sentryEnvelopeItem);
        return new SentryEnvelope(sentryEnvelope.getHeader(), arrayList);
    }

    private boolean isValidEnvelope(@NotNull SentryEnvelope sentryEnvelope) {
        return sentryEnvelope.getItems().iterator().hasNext();
    }
}
