package io.sentry.android.replay;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import io.sentry.DateUtils;
import io.sentry.ISentryLifecycleToken;
import io.sentry.ReplayRecording;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayEvent;
import io.sentry.android.replay.video.MuxerConfig;
import io.sentry.android.replay.video.SimpleVideoEncoder;
import io.sentry.protocol.SentryId;
import io.sentry.rrweb.RRWebEvent;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.FileUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.LongProgression;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class ReplayCache implements Closeable {
    public static final String ONGOING_SEGMENT = ".ongoing_segment";
    public static final String SEGMENT_KEY_BIT_RATE = "config.bit-rate";
    public static final String SEGMENT_KEY_FRAME_RATE = "config.frame-rate";
    public static final String SEGMENT_KEY_HEIGHT = "config.height";
    public static final String SEGMENT_KEY_ID = "segment.id";
    public static final String SEGMENT_KEY_REPLAY_ID = "replay.id";
    public static final String SEGMENT_KEY_REPLAY_RECORDING = "replay.recording";
    public static final String SEGMENT_KEY_REPLAY_SCREEN_AT_START = "replay.screen-at-start";
    public static final String SEGMENT_KEY_REPLAY_TYPE = "replay.type";
    public static final String SEGMENT_KEY_TIMESTAMP = "segment.timestamp";
    public static final String SEGMENT_KEY_WIDTH = "config.width";
    private SimpleVideoEncoder encoder;
    private final AutoClosableReentrantLock encoderLock;
    private final List<ReplayFrame> frames;
    private final AtomicBoolean isClosed;
    private final AutoClosableReentrantLock lock;
    private final LinkedHashMap<String, String> ongoingSegment;
    private final Lazy ongoingSegmentFile$delegate;
    private final SentryOptions options;
    private final Lazy replayCacheDir$delegate;
    private final SentryId replayId;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ReplayCache(@NotNull SentryOptions options, @NotNull SentryId replayId) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(replayId, "replayId");
        this.options = options;
        this.replayId = replayId;
        this.isClosed = new AtomicBoolean(false);
        this.encoderLock = new AutoClosableReentrantLock();
        this.lock = new AutoClosableReentrantLock();
        this.replayCacheDir$delegate = LazyKt__LazyJVMKt.lazy(new Function0<File>() { // from class: io.sentry.android.replay.ReplayCache$replayCacheDir$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return ReplayCache.Companion.makeReplayCacheDir(this.this$0.options, this.this$0.replayId);
            }
        });
        this.frames = new ArrayList();
        this.ongoingSegment = new LinkedHashMap<>();
        this.ongoingSegmentFile$delegate = LazyKt__LazyJVMKt.lazy(new Function0<File>() { // from class: io.sentry.android.replay.ReplayCache$ongoingSegmentFile$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() throws IOException {
                if (this.this$0.getReplayCacheDir$sentry_android_replay_release() == null) {
                    return null;
                }
                File file = new File(this.this$0.getReplayCacheDir$sentry_android_replay_release(), ReplayCache.ONGOING_SEGMENT);
                if (!file.exists()) {
                    file.createNewFile();
                }
                return file;
            }
        });
    }

    public final File getReplayCacheDir$sentry_android_replay_release() {
        return (File) this.replayCacheDir$delegate.getValue();
    }

    public final List<ReplayFrame> getFrames$sentry_android_replay_release() {
        return this.frames;
    }

    public final File getOngoingSegmentFile$sentry_android_replay_release() {
        return (File) this.ongoingSegmentFile$delegate.getValue();
    }

    public static /* synthetic */ void addFrame$sentry_android_replay_release$default(ReplayCache replayCache, Bitmap bitmap, long j, String str, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            str = null;
        }
        replayCache.addFrame$sentry_android_replay_release(bitmap, j, str);
    }

    public final void addFrame$sentry_android_replay_release(@NotNull Bitmap bitmap, long j, @Nullable String str) throws IOException {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (getReplayCacheDir$sentry_android_replay_release() == null || bitmap.isRecycled()) {
            return;
        }
        File replayCacheDir$sentry_android_replay_release = getReplayCacheDir$sentry_android_replay_release();
        if (replayCacheDir$sentry_android_replay_release != null) {
            replayCacheDir$sentry_android_replay_release.mkdirs();
        }
        File file = new File(getReplayCacheDir$sentry_android_replay_release(), j + ".jpg");
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, this.options.getSessionReplay().getQuality().screenshotQuality, fileOutputStream);
            fileOutputStream.flush();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
            addFrame(file, j, str);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void addFrame$default(ReplayCache replayCache, File file, long j, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        replayCache.addFrame(file, j, str);
    }

    public final void addFrame(@NotNull File screenshot, long j, @Nullable String str) {
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        this.frames.add(new ReplayFrame(screenshot, j, str));
    }

    public static /* synthetic */ GeneratedVideo createVideoOf$default(ReplayCache replayCache, long j, long j2, int i, int i2, int i3, int i4, int i5, File file, int i6, Object obj) {
        File file2;
        if ((i6 & 128) != 0) {
            file2 = new File(replayCache.getReplayCacheDir$sentry_android_replay_release(), i + ".mp4");
        } else {
            file2 = file;
        }
        return replayCache.createVideoOf(j, j2, i, i2, i3, i4, i5, file2);
    }

    public final GeneratedVideo createVideoOf(long j, long j2, int i, int i2, int i3, int i4, int i5, @NotNull File videoFile) throws Exception {
        ISentryLifecycleToken iSentryLifecycleToken;
        int i6;
        Intrinsics.checkNotNullParameter(videoFile, "videoFile");
        if (videoFile.exists() && videoFile.length() > 0) {
            videoFile.delete();
        }
        if (this.frames.isEmpty()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "No captured frames, skipping generating a video segment", new Object[0]);
            return null;
        }
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.encoderLock.acquire();
        try {
            iSentryLifecycleToken = iSentryLifecycleTokenAcquire;
            try {
                SimpleVideoEncoder simpleVideoEncoder = new SimpleVideoEncoder(this.options, new MuxerConfig(videoFile, i3, i2, i4, i5, null, 32, null), null, 4, null);
                simpleVideoEncoder.start();
                AutoCloseableKt.closeFinally(iSentryLifecycleToken, null);
                this.encoder = simpleVideoEncoder;
                long j3 = ((long) 1000) / ((long) i4);
                ReplayFrame replayFrame = (ReplayFrame) CollectionsKt___CollectionsKt.first((List) this.frames);
                long j4 = j2 + j;
                LongProgression longProgressionStep = RangesKt___RangesKt.step(RangesKt___RangesKt.until(j2, j4), j3);
                long first = longProgressionStep.getFirst();
                long last = longProgressionStep.getLast();
                long step = longProgressionStep.getStep();
                if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                    i6 = 0;
                } else {
                    int i7 = 0;
                    while (true) {
                        for (ReplayFrame replayFrame2 : this.frames) {
                            long j5 = first + j3;
                            long timestamp = replayFrame2.getTimestamp();
                            if (first <= timestamp && timestamp <= j5) {
                                replayFrame = replayFrame2;
                                break;
                            }
                            if (replayFrame2.getTimestamp() > j5) {
                                break;
                            }
                        }
                        if (encode(replayFrame)) {
                            i7++;
                        } else if (replayFrame != null) {
                            deleteFile(replayFrame.getScreenshot());
                            this.frames.remove(replayFrame);
                            replayFrame = null;
                        }
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                    i6 = i7;
                }
                if (i6 == 0) {
                    this.options.getLogger().log(SentryLevel.DEBUG, "Generated a video with no frames, not capturing a replay segment", new Object[0]);
                    deleteFile(videoFile);
                    return null;
                }
                ISentryLifecycleToken iSentryLifecycleTokenAcquire2 = this.encoderLock.acquire();
                try {
                    SimpleVideoEncoder simpleVideoEncoder2 = this.encoder;
                    if (simpleVideoEncoder2 != null) {
                        simpleVideoEncoder2.release();
                    }
                    SimpleVideoEncoder simpleVideoEncoder3 = this.encoder;
                    long duration = simpleVideoEncoder3 != null ? simpleVideoEncoder3.getDuration() : 0L;
                    this.encoder = null;
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire2, null);
                    rotate$sentry_android_replay_release(j4);
                    return new GeneratedVideo(videoFile, i6, duration);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire2, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                Throwable th4 = th;
                try {
                    throw th4;
                } catch (Throwable th5) {
                    AutoCloseableKt.closeFinally(iSentryLifecycleToken, th4);
                    throw th5;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            iSentryLifecycleToken = iSentryLifecycleTokenAcquire;
        }
    }

    private final boolean encode(ReplayFrame replayFrame) {
        if (replayFrame == null) {
            return false;
        }
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(replayFrame.getScreenshot().getAbsolutePath());
            ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.encoderLock.acquire();
            try {
                SimpleVideoEncoder simpleVideoEncoder = this.encoder;
                if (simpleVideoEncoder != null) {
                    Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                    simpleVideoEncoder.encode(bitmap);
                    Unit unit = Unit.INSTANCE;
                }
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
                bitmap.recycle();
                return true;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            this.options.getLogger().log(SentryLevel.WARNING, "Unable to decode bitmap and encode it into a video, skipping frame", th3);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteFile(File file) {
        try {
            if (file.delete()) {
                return;
            }
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete replay frame: %s", file.getAbsolutePath());
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, th, "Failed to delete replay frame: %s", file.getAbsolutePath());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String rotate$sentry_android_replay_release(final long j) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        CollectionsKt__MutableCollectionsKt.removeAll((List) this.frames, (Function1) new Function1<ReplayFrame, Boolean>() { // from class: io.sentry.android.replay.ReplayCache$rotate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.String] */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(@NotNull ReplayFrame it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                if (it2.getTimestamp() < j) {
                    this.deleteFile(it2.getScreenshot());
                    return Boolean.TRUE;
                }
                Ref.ObjectRef<String> objectRef2 = objectRef;
                if (objectRef2.element == null) {
                    objectRef2.element = it2.getScreen();
                }
                return Boolean.FALSE;
            }
        });
        return (String) objectRef.element;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Exception {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.encoderLock.acquire();
        try {
            SimpleVideoEncoder simpleVideoEncoder = this.encoder;
            if (simpleVideoEncoder != null) {
                simpleVideoEncoder.release();
            }
            this.encoder = null;
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
            this.isClosed.set(true);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th);
                throw th2;
            }
        }
    }

    public final void persistSegmentValues$sentry_android_replay_release(@NotNull String key, @Nullable String str) throws Exception {
        File ongoingSegmentFile$sentry_android_replay_release;
        File ongoingSegmentFile$sentry_android_replay_release2;
        Intrinsics.checkNotNullParameter(key, "key");
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Throwable th = null;
            if (this.isClosed.get()) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
                return;
            }
            File ongoingSegmentFile$sentry_android_replay_release3 = getOngoingSegmentFile$sentry_android_replay_release();
            if ((ongoingSegmentFile$sentry_android_replay_release3 == null || !ongoingSegmentFile$sentry_android_replay_release3.exists()) && (ongoingSegmentFile$sentry_android_replay_release = getOngoingSegmentFile$sentry_android_replay_release()) != null) {
                ongoingSegmentFile$sentry_android_replay_release.createNewFile();
            }
            if (this.ongoingSegment.isEmpty() && (ongoingSegmentFile$sentry_android_replay_release2 = getOngoingSegmentFile$sentry_android_replay_release()) != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(ongoingSegmentFile$sentry_android_replay_release2), Charsets.UTF_8), 8192);
                try {
                    Sequence<String> sequenceLineSequence = TextStreamsKt.lineSequence(bufferedReader);
                    LinkedHashMap<String, String> linkedHashMap = this.ongoingSegment;
                    Iterator<String> it2 = sequenceLineSequence.iterator();
                    while (it2.hasNext()) {
                        List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) it2.next(), new String[]{"="}, false, 2, 2, (Object) null);
                        Pair pair = TuplesKt.to((String) listSplit$default.get(0), (String) listSplit$default.get(1));
                        linkedHashMap.put((String) pair.getFirst(), (String) pair.getSecond());
                        th = null;
                    }
                    CloseableKt.closeFinally(bufferedReader, th);
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(bufferedReader, th2);
                        throw th3;
                    }
                }
            }
            if (str == null) {
                this.ongoingSegment.remove(key);
            } else {
                this.ongoingSegment.put(key, str);
            }
            File ongoingSegmentFile$sentry_android_replay_release4 = getOngoingSegmentFile$sentry_android_replay_release();
            if (ongoingSegmentFile$sentry_android_replay_release4 != null) {
                Set<Map.Entry<String, String>> setEntrySet = this.ongoingSegment.entrySet();
                Intrinsics.checkNotNullExpressionValue(setEntrySet, "ongoingSegment.entries");
                FilesKt__FileReadWriteKt.writeText$default(ongoingSegmentFile$sentry_android_replay_release4, CollectionsKt___CollectionsKt.joinToString$default(setEntrySet, "\n", null, null, 0, null, new Function1<Map.Entry<String, String>, CharSequence>() { // from class: io.sentry.android.replay.ReplayCache$persistSegmentValues$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(@NotNull Map.Entry<String, String> entry) {
                        Intrinsics.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
                        return entry.getKey() + '=' + entry.getValue();
                    }
                }, 30, null), null, 2, null);
                Unit unit = Unit.INSTANCE;
            }
            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th4);
                throw th5;
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final File makeReplayCacheDir(@NotNull SentryOptions options, @NotNull SentryId replayId) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(replayId, "replayId");
            String cacheDirPath = options.getCacheDirPath();
            if (cacheDirPath == null || cacheDirPath.length() == 0) {
                options.getLogger().log(SentryLevel.WARNING, "SentryOptions.cacheDirPath is not set, session replay is no-op", new Object[0]);
                return null;
            }
            String cacheDirPath2 = options.getCacheDirPath();
            Intrinsics.checkNotNull(cacheDirPath2);
            File file = new File(cacheDirPath2, "replay_" + replayId);
            file.mkdirs();
            return file;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LastSegmentData fromDisk$sentry_android_replay_release$default(Companion companion, SentryOptions sentryOptions, SentryId sentryId, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                function1 = null;
            }
            return companion.fromDisk$sentry_android_replay_release(sentryOptions, sentryId, function1);
        }

        /* JADX WARN: Code duplicated, block: B:87:0x0200  */
        public final LastSegmentData fromDisk$sentry_android_replay_release(@NotNull SentryOptions options, @NotNull SentryId replayId, @Nullable Function1<? super SentryId, ReplayCache> function1) {
            Date dateTime;
            SentryReplayEvent.ReplayType replayTypeValueOf;
            final ReplayCache replayCache;
            String str = "";
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(replayId, "replayId");
            File fileMakeReplayCacheDir = makeReplayCacheDir(options, replayId);
            File file = new File(fileMakeReplayCacheDir, ReplayCache.ONGOING_SEGMENT);
            List listEmptyList = null;
            if (!file.exists()) {
                options.getLogger().log(SentryLevel.DEBUG, "No ongoing segment found for replay: %s", replayId);
                FileUtils.deleteRecursively(fileMakeReplayCacheDir);
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charsets.UTF_8), 8192);
            try {
                Iterator<String> it2 = TextStreamsKt.lineSequence(bufferedReader).iterator();
                while (it2.hasNext()) {
                    List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) it2.next(), new String[]{"="}, false, 2, 2, (Object) null);
                    Pair pair = TuplesKt.to((String) listSplit$default.get(0), (String) listSplit$default.get(1));
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                CloseableKt.closeFinally(bufferedReader, null);
                String str2 = (String) linkedHashMap.get(ReplayCache.SEGMENT_KEY_HEIGHT);
                Integer intOrNull = str2 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(str2) : null;
                String str3 = (String) linkedHashMap.get(ReplayCache.SEGMENT_KEY_WIDTH);
                Integer intOrNull2 = str3 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(str3) : null;
                String str4 = (String) linkedHashMap.get(ReplayCache.SEGMENT_KEY_FRAME_RATE);
                Integer intOrNull3 = str4 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(str4) : null;
                String str5 = (String) linkedHashMap.get(ReplayCache.SEGMENT_KEY_BIT_RATE);
                Integer intOrNull4 = str5 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(str5) : null;
                String str6 = (String) linkedHashMap.get(ReplayCache.SEGMENT_KEY_ID);
                Integer intOrNull5 = str6 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(str6) : null;
                try {
                    String str7 = (String) linkedHashMap.get(ReplayCache.SEGMENT_KEY_TIMESTAMP);
                    if (str7 == null) {
                        str7 = "";
                    }
                    dateTime = DateUtils.getDateTime(str7);
                } catch (Throwable unused) {
                    dateTime = null;
                }
                try {
                    String str8 = (String) linkedHashMap.get(ReplayCache.SEGMENT_KEY_REPLAY_TYPE);
                    if (str8 != null) {
                        str = str8;
                    }
                    replayTypeValueOf = SentryReplayEvent.ReplayType.valueOf(str);
                } catch (Throwable unused2) {
                    replayTypeValueOf = null;
                }
                if (intOrNull == null || intOrNull2 == null || intOrNull3 == null || intOrNull4 == null || intOrNull5 == null || intOrNull5.intValue() == -1 || dateTime == null || replayTypeValueOf == null) {
                    options.getLogger().log(SentryLevel.DEBUG, "Incorrect segment values found for replay: %s, deleting the replay", replayId);
                    FileUtils.deleteRecursively(fileMakeReplayCacheDir);
                    return null;
                }
                ScreenshotRecorderConfig screenshotRecorderConfig = new ScreenshotRecorderConfig(intOrNull2.intValue(), intOrNull.intValue(), 1.0f, 1.0f, intOrNull3.intValue(), intOrNull4.intValue());
                if (function1 == null || (replayCache = function1.invoke(replayId)) == null) {
                    replayCache = new ReplayCache(options, replayId);
                }
                File replayCacheDir$sentry_android_replay_release = replayCache.getReplayCacheDir$sentry_android_replay_release();
                if (replayCacheDir$sentry_android_replay_release != null) {
                    replayCacheDir$sentry_android_replay_release.listFiles(new FilenameFilter() { // from class: io.sentry.android.replay.ReplayCache$Companion$$ExternalSyntheticLambda0
                        @Override // java.io.FilenameFilter
                        public final boolean accept(File file2, String str9) {
                            return ReplayCache.Companion.fromDisk$lambda$3(replayCache, file2, str9);
                        }
                    });
                }
                if (replayCache.getFrames$sentry_android_replay_release().isEmpty()) {
                    options.getLogger().log(SentryLevel.DEBUG, "No frames found for replay: %s, deleting the replay", replayId);
                    FileUtils.deleteRecursively(fileMakeReplayCacheDir);
                    return null;
                }
                List<ReplayFrame> frames$sentry_android_replay_release = replayCache.getFrames$sentry_android_replay_release();
                if (frames$sentry_android_replay_release.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(frames$sentry_android_replay_release, new Comparator() { // from class: io.sentry.android.replay.ReplayCache$Companion$fromDisk$$inlined$sortBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((ReplayFrame) t).getTimestamp()), Long.valueOf(((ReplayFrame) t2).getTimestamp()));
                        }
                    });
                }
                SentryReplayEvent.ReplayType replayType = SentryReplayEvent.ReplayType.SESSION;
                int iIntValue = replayTypeValueOf == replayType ? intOrNull5.intValue() : 0;
                if (replayTypeValueOf != replayType) {
                    dateTime = DateUtils.getDateTime(((ReplayFrame) CollectionsKt___CollectionsKt.first((List) replayCache.getFrames$sentry_android_replay_release())).getTimestamp());
                    Intrinsics.checkNotNullExpressionValue(dateTime, "{\n          // in buffer…st().timestamp)\n        }");
                }
                Date date = dateTime;
                long timestamp = ((ReplayFrame) CollectionsKt___CollectionsKt.last((List) replayCache.getFrames$sentry_android_replay_release())).getTimestamp();
                long time = date.getTime();
                long jIntValue = 1000 / intOrNull3.intValue();
                String str9 = (String) linkedHashMap.get(ReplayCache.SEGMENT_KEY_REPLAY_RECORDING);
                if (str9 != null) {
                    ReplayRecording replayRecording = (ReplayRecording) options.getSerializer().deserialize(new StringReader(str9), ReplayRecording.class);
                    if ((replayRecording != null ? replayRecording.getPayload() : null) != null) {
                        List<? extends RRWebEvent> payload = replayRecording.getPayload();
                        Intrinsics.checkNotNull(payload);
                        listEmptyList = new LinkedList(payload);
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt__CollectionsKt.emptyList();
                    }
                } else {
                    listEmptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                return new LastSegmentData(screenshotRecorderConfig, replayCache, date, iIntValue, (timestamp - time) + jIntValue, replayTypeValueOf, (String) linkedHashMap.get(ReplayCache.SEGMENT_KEY_REPLAY_SCREEN_AT_START), CollectionsKt___CollectionsKt.sortedWith(listEmptyList, new Comparator() { // from class: io.sentry.android.replay.ReplayCache$Companion$fromDisk$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((RRWebEvent) t).getTimestamp()), Long.valueOf(((RRWebEvent) t2).getTimestamp()));
                    }
                }));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReader, th);
                    throw th2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean fromDisk$lambda$3(ReplayCache cache, File file, String name) {
            Intrinsics.checkNotNullParameter(cache, "$cache");
            Intrinsics.checkNotNullExpressionValue(name, "name");
            if (StringsKt__StringsJVMKt.endsWith$default(name, ".jpg", false, 2, null)) {
                File file2 = new File(file, name);
                Long longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(FilesKt__UtilsKt.getNameWithoutExtension(file2));
                if (longOrNull != null) {
                    ReplayCache.addFrame$default(cache, file2, longOrNull.longValue(), null, 4, null);
                }
            }
            return false;
        }
    }
}
