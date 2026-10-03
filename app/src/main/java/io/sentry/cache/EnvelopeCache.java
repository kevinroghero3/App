package io.sentry.cache;

import io.sentry.DateUtils;
import io.sentry.Hint;
import io.sentry.ILogger;
import io.sentry.ISentryLifecycleToken;
import io.sentry.SentryCrashLastRunState;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryUUID;
import io.sentry.Session;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.hints.AbnormalExit;
import io.sentry.hints.SessionEnd;
import io.sentry.hints.SessionStart;
import io.sentry.transport.NoOpEnvelopeCache;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public class EnvelopeCache extends CacheStrategy implements IEnvelopeCache {
    public static final String CRASH_MARKER_FILE = "last_crash";
    public static final String NATIVE_CRASH_MARKER_FILE = ".sentry-native/last_crash";
    public static final String PREFIX_CURRENT_SESSION_FILE = "session";
    public static final String PREFIX_PREVIOUS_SESSION_FILE = "previous_session";
    public static final String STARTUP_CRASH_MARKER_FILE = "startup_crash";
    public static final String SUFFIX_ENVELOPE_FILE = ".envelope";
    static final String SUFFIX_SESSION_FILE = ".json";
    protected final AutoClosableReentrantLock cacheLock;
    private final Map<SentryEnvelope, String> fileNameMap;
    private final CountDownLatch previousSessionLatch;
    protected final AutoClosableReentrantLock sessionLock;

    public static IEnvelopeCache create(@NotNull SentryOptions sentryOptions) {
        String cacheDirPath = sentryOptions.getCacheDirPath();
        int maxCacheItems = sentryOptions.getMaxCacheItems();
        if (cacheDirPath == null) {
            sentryOptions.getLogger().log(SentryLevel.WARNING, "cacheDirPath is null, returning NoOpEnvelopeCache", new Object[0]);
            return NoOpEnvelopeCache.getInstance();
        }
        return new EnvelopeCache(sentryOptions, cacheDirPath, maxCacheItems);
    }

    public EnvelopeCache(@NotNull SentryOptions sentryOptions, @NotNull String str, int i) {
        super(sentryOptions, str, i);
        this.fileNameMap = new WeakHashMap();
        this.cacheLock = new AutoClosableReentrantLock();
        this.sessionLock = new AutoClosableReentrantLock();
        this.previousSessionLatch = new CountDownLatch(1);
    }

    public void store(@NotNull SentryEnvelope sentryEnvelope, @NotNull Hint hint) {
        storeInternal(sentryEnvelope, hint);
    }

    public boolean storeEnvelope(@NotNull SentryEnvelope sentryEnvelope, @NotNull Hint hint) {
        return storeInternal(sentryEnvelope, hint);
    }

    private boolean storeInternal(@NotNull SentryEnvelope sentryEnvelope, @NotNull Hint hint) {
        Objects.requireNonNull(sentryEnvelope, "Envelope is required.");
        rotateCacheIfNeeded(allEnvelopeFiles());
        File currentSessionFile = getCurrentSessionFile(this.directory.getAbsolutePath());
        File previousSessionFile = getPreviousSessionFile(this.directory.getAbsolutePath());
        if (HintUtils.hasType(hint, SessionEnd.class) && !currentSessionFile.delete()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Current envelope doesn't exist.", new Object[0]);
        }
        if (HintUtils.hasType(hint, AbnormalExit.class)) {
            tryEndPreviousSession(hint);
        }
        if (HintUtils.hasType(hint, SessionStart.class)) {
            movePreviousSession(currentSessionFile, previousSessionFile);
            updateCurrentSession(currentSessionFile, sentryEnvelope);
            boolean zExists = new File(this.options.getCacheDirPath(), NATIVE_CRASH_MARKER_FILE).exists();
            if (!zExists) {
                File file = new File(this.options.getCacheDirPath(), CRASH_MARKER_FILE);
                if (file.exists()) {
                    this.options.getLogger().log(SentryLevel.INFO, "Crash marker file exists, crashedLastRun will return true.", new Object[0]);
                    if (!file.delete()) {
                        this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete the crash marker file. %s.", file.getAbsolutePath());
                    }
                    zExists = true;
                }
            }
            SentryCrashLastRunState.getInstance().setCrashedLastRun(zExists);
            flushPreviousSession();
        }
        File envelopeFile = getEnvelopeFile(sentryEnvelope);
        if (envelopeFile.exists()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Not adding Envelope to offline storage because it already exists: %s", envelopeFile.getAbsolutePath());
            return true;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Adding Envelope to offline storage: %s", envelopeFile.getAbsolutePath());
        boolean zWriteEnvelopeToDisk = writeEnvelopeToDisk(envelopeFile, sentryEnvelope);
        if (HintUtils.hasType(hint, UncaughtExceptionHandlerIntegration.UncaughtExceptionHint.class)) {
            writeCrashMarkerFile();
        }
        return zWriteEnvelopeToDisk;
    }

    private void tryEndPreviousSession(@NotNull Hint hint) {
        Date dateTime;
        Object sentrySdkHint = HintUtils.getSentrySdkHint(hint);
        if (sentrySdkHint instanceof AbnormalExit) {
            File previousSessionFile = getPreviousSessionFile(this.directory.getAbsolutePath());
            if (previousSessionFile.exists()) {
                ILogger logger = this.options.getLogger();
                SentryLevel sentryLevel = SentryLevel.WARNING;
                logger.log(sentryLevel, "Previous session is not ended, we'd need to end it.", new Object[0]);
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(previousSessionFile), CacheStrategy.UTF_8));
                    try {
                        Session session = (Session) this.serializer.getValue().deserialize(bufferedReader, Session.class);
                        if (session != null) {
                            AbnormalExit abnormalExit = (AbnormalExit) sentrySdkHint;
                            Long lTimestamp = abnormalExit.timestamp();
                            if (lTimestamp != null) {
                                dateTime = DateUtils.getDateTime(lTimestamp.longValue());
                                Date started = session.getStarted();
                                if (started == null || dateTime.before(started)) {
                                    this.options.getLogger().log(sentryLevel, "Abnormal exit happened before previous session start, not ending the session.", new Object[0]);
                                    bufferedReader.close();
                                    return;
                                }
                            } else {
                                dateTime = null;
                            }
                            session.update(Session.State.Abnormal, null, true, abnormalExit.mechanism());
                            session.end(dateTime);
                            writeSessionToDisk(previousSessionFile, session);
                        }
                        bufferedReader.close();
                        return;
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    this.options.getLogger().log(SentryLevel.ERROR, "Error processing previous session.", th3);
                    return;
                }
            }
            this.options.getLogger().log(SentryLevel.DEBUG, "No previous session file to end.", new Object[0]);
        }
    }

    private void writeCrashMarkerFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.options.getCacheDirPath(), CRASH_MARKER_FILE));
            try {
                fileOutputStream.write(DateUtils.getTimestamp(DateUtils.getCurrentDateTime()).getBytes(CacheStrategy.UTF_8));
                fileOutputStream.flush();
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
            this.options.getLogger().log(SentryLevel.ERROR, "Error writing the crash marker file to the disk", th3);
        }
    }

    private void updateCurrentSession(@NotNull File file, @NotNull SentryEnvelope sentryEnvelope) {
        Iterable<SentryEnvelopeItem> items = sentryEnvelope.getItems();
        if (items.iterator().hasNext()) {
            SentryEnvelopeItem next = items.iterator().next();
            if (SentryItemType.Session.equals(next.getHeader().getType())) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(next.getData()), CacheStrategy.UTF_8));
                    try {
                        Session session = (Session) this.serializer.getValue().deserialize(bufferedReader, Session.class);
                        if (session == null) {
                            this.options.getLogger().log(SentryLevel.ERROR, "Item of type %s returned null by the parser.", next.getHeader().getType());
                        } else {
                            writeSessionToDisk(file, session);
                        }
                        bufferedReader.close();
                        return;
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    this.options.getLogger().log(SentryLevel.ERROR, "Item failed to process.", th3);
                    return;
                }
            }
            this.options.getLogger().log(SentryLevel.INFO, "Current envelope has a different envelope type %s", next.getHeader().getType());
            return;
        }
        this.options.getLogger().log(SentryLevel.INFO, "Current envelope %s is empty", file.getAbsolutePath());
    }

    private boolean writeEnvelopeToDisk(@NotNull File file, @NotNull SentryEnvelope sentryEnvelope) {
        if (file.exists()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Overwriting envelope to offline storage: %s", file.getAbsolutePath());
            if (!file.delete()) {
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                this.serializer.getValue().serialize(sentryEnvelope, fileOutputStream);
                fileOutputStream.close();
                return true;
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            this.options.getLogger().log(SentryLevel.ERROR, th3, "Error writing Envelope %s to offline storage", file.getAbsolutePath());
            return false;
        }
    }

    private void writeSessionToDisk(@NotNull File file, @NotNull Session session) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, CacheStrategy.UTF_8));
                try {
                    this.options.getLogger().log(SentryLevel.DEBUG, "Overwriting session to offline storage: %s", session.getSessionId());
                    this.serializer.getValue().serialize(session, bufferedWriter);
                    bufferedWriter.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Throwable th5) {
            this.options.getLogger().log(SentryLevel.ERROR, th5, "Error writing Session to offline storage: %s", session.getSessionId());
        }
    }

    @Override // io.sentry.cache.IEnvelopeCache
    public void discard(@NotNull SentryEnvelope sentryEnvelope) {
        Objects.requireNonNull(sentryEnvelope, "Envelope is required.");
        File envelopeFile = getEnvelopeFile(sentryEnvelope);
        if (envelopeFile.exists()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Discarding envelope from cache: %s", envelopeFile.getAbsolutePath());
            if (envelopeFile.delete()) {
                return;
            }
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete envelope: %s", envelopeFile.getAbsolutePath());
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Envelope was not cached: %s", envelopeFile.getAbsolutePath());
    }

    private File getEnvelopeFile(@NotNull SentryEnvelope sentryEnvelope) {
        String str;
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.cacheLock.acquire();
        try {
            if (this.fileNameMap.containsKey(sentryEnvelope)) {
                str = this.fileNameMap.get(sentryEnvelope);
            } else {
                String str2 = SentryUUID.generateSentryId() + SUFFIX_ENVELOPE_FILE;
                this.fileNameMap.put(sentryEnvelope, str2);
                str = str2;
            }
            File file = new File(this.directory.getAbsolutePath(), str);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return file;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static File getCurrentSessionFile(@NotNull String str) {
        return new File(str, "session.json");
    }

    public static File getPreviousSessionFile(@NotNull String str) {
        return new File(str, "previous_session.json");
    }

    @Override // java.lang.Iterable
    public Iterator<SentryEnvelope> iterator() {
        File[] fileArrAllEnvelopeFiles = allEnvelopeFiles();
        ArrayList arrayList = new ArrayList(fileArrAllEnvelopeFiles.length);
        for (File file : fileArrAllEnvelopeFiles) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    arrayList.add(this.serializer.getValue().deserializeEnvelope(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Envelope file '%s' disappeared while converting all cached files to envelopes.", file.getAbsolutePath());
            } catch (IOException e) {
                this.options.getLogger().log(SentryLevel.ERROR, String.format("Error while reading cached envelope from file %s", file.getAbsolutePath()), e);
            }
        }
        return arrayList.iterator();
    }

    private File[] allEnvelopeFiles() {
        File[] fileArrListFiles;
        return (!isDirectoryValid() || (fileArrListFiles = this.directory.listFiles(new FilenameFilter() { // from class: io.sentry.cache.EnvelopeCache$$ExternalSyntheticLambda0
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return EnvelopeCache.lambda$allEnvelopeFiles$0(file, str);
            }
        })) == null) ? new File[0] : fileArrListFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$allEnvelopeFiles$0(File file, String str) {
        return str.endsWith(SUFFIX_ENVELOPE_FILE);
    }

    public boolean waitPreviousSessionFlush() {
        try {
            return this.previousSessionLatch.await(this.options.getSessionFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            this.options.getLogger().log(SentryLevel.DEBUG, "Timed out waiting for previous session to flush.", new Object[0]);
            return false;
        }
    }

    public void flushPreviousSession() {
        this.previousSessionLatch.countDown();
    }

    public void movePreviousSession(@NotNull File file, @NotNull File file2) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.sessionLock.acquire();
        try {
            if (file2.exists()) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Previous session file already exists, deleting it.", new Object[0]);
                if (!file2.delete()) {
                    this.options.getLogger().log(SentryLevel.WARNING, "Unable to delete previous session file: %s", file2);
                }
            }
            if (file.exists()) {
                this.options.getLogger().log(SentryLevel.INFO, "Moving current session to previous session.", new Object[0]);
                try {
                    if (!file.renameTo(file2)) {
                        this.options.getLogger().log(SentryLevel.WARNING, "Unable to move current session to previous session.", new Object[0]);
                    }
                } catch (Throwable th) {
                    this.options.getLogger().log(SentryLevel.ERROR, "Error moving current session to previous session.", th);
                }
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th2) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }
}
