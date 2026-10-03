package io.sentry.android.replay.capture;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import io.sentry.DateUtils;
import io.sentry.IScope;
import io.sentry.IScopes;
import io.sentry.ScopeCallback;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayEvent;
import io.sentry.android.replay.ReplayCache;
import io.sentry.android.replay.ReplayFrame;
import io.sentry.android.replay.ScreenshotRecorderConfig;
import io.sentry.android.replay.util.ExecutorsKt;
import io.sentry.android.replay.util.SamplingKt;
import io.sentry.protocol.SentryId;
import io.sentry.transport.ICurrentDateProvider;
import io.sentry.util.FileUtils;
import io.sentry.util.Random;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class BufferCaptureStrategy extends BaseCaptureStrategy {
    private static final long ENVELOPE_PROCESSING_DELAY = 100;
    private static final String TAG = "BufferCaptureStrategy";
    private final List<CaptureStrategy.ReplaySegment.Created> bufferedSegments;
    private final ICurrentDateProvider dateProvider;
    private final SentryOptions options;
    private final Random random;
    private final IScopes scopes;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ BufferCaptureStrategy(SentryOptions sentryOptions, IScopes iScopes, ICurrentDateProvider iCurrentDateProvider, Random random, ScheduledExecutorService scheduledExecutorService, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sentryOptions, iScopes, iCurrentDateProvider, random, scheduledExecutorService, (i & 32) != 0 ? null : function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferCaptureStrategy(@NotNull SentryOptions options, @Nullable IScopes iScopes, @NotNull ICurrentDateProvider dateProvider, @NotNull Random random, @NotNull ScheduledExecutorService executor, @Nullable Function1<? super SentryId, ReplayCache> function1) {
        super(options, iScopes, dateProvider, executor, function1);
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(random, "random");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.options = options;
        this.scopes = iScopes;
        this.dateProvider = dateProvider;
        this.random = random;
        this.bufferedSegments = new ArrayList();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // io.sentry.android.replay.capture.BaseCaptureStrategy, io.sentry.android.replay.capture.CaptureStrategy
    public void pause() {
        createCurrentSegment("pause", new Function1<CaptureStrategy.ReplaySegment, Unit>() { // from class: io.sentry.android.replay.capture.BufferCaptureStrategy.pause.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CaptureStrategy.ReplaySegment replaySegment) {
                invoke2(replaySegment);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull CaptureStrategy.ReplaySegment segment) {
                Intrinsics.checkNotNullParameter(segment, "segment");
                if (segment instanceof CaptureStrategy.ReplaySegment.Created) {
                    BufferCaptureStrategy.this.bufferedSegments.add(segment);
                    BufferCaptureStrategy bufferCaptureStrategy = BufferCaptureStrategy.this;
                    bufferCaptureStrategy.setCurrentSegment(bufferCaptureStrategy.getCurrentSegment() + 1);
                }
            }
        });
        super.pause();
    }

    @Override // io.sentry.android.replay.capture.BaseCaptureStrategy, io.sentry.android.replay.capture.CaptureStrategy
    public void stop() throws Exception {
        ReplayCache cache = getCache();
        final File replayCacheDir$sentry_android_replay_release = cache != null ? cache.getReplayCacheDir$sentry_android_replay_release() : null;
        ExecutorsKt.submitSafely(getReplayExecutor(), this.options, "BufferCaptureStrategy.stop", new Runnable() { // from class: io.sentry.android.replay.capture.BufferCaptureStrategy$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BufferCaptureStrategy.stop$lambda$0(replayCacheDir$sentry_android_replay_release, this);
            }
        });
        super.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stop$lambda$0(File file, BufferCaptureStrategy this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileUtils.deleteRecursively(file);
        this$0.setCurrentSegment(-1);
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public void captureReplay(boolean z, @NotNull final Function1<? super Date, Unit> onSegmentSent) {
        Intrinsics.checkNotNullParameter(onSegmentSent, "onSegmentSent");
        if (!SamplingKt.sample(this.random, this.options.getSessionReplay().getOnErrorSampleRate())) {
            this.options.getLogger().log(SentryLevel.INFO, "Replay wasn't sampled by onErrorSampleRate, not capturing for event", new Object[0]);
            return;
        }
        IScopes iScopes = this.scopes;
        if (iScopes != null) {
            iScopes.configureScope(new ScopeCallback() { // from class: io.sentry.android.replay.capture.BufferCaptureStrategy$$ExternalSyntheticLambda2
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    BufferCaptureStrategy.captureReplay$lambda$1(this.f$0, iScope);
                }
            });
        }
        if (z) {
            isTerminating().set(true);
            this.options.getLogger().log(SentryLevel.DEBUG, "Not capturing replay for crashed event, will be captured on next launch", new Object[0]);
        } else {
            createCurrentSegment("capture_replay", new Function1<CaptureStrategy.ReplaySegment, Unit>() { // from class: io.sentry.android.replay.capture.BufferCaptureStrategy.captureReplay.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CaptureStrategy.ReplaySegment replaySegment) throws InterruptedException {
                    invoke2(replaySegment);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull CaptureStrategy.ReplaySegment segment) throws InterruptedException {
                    Intrinsics.checkNotNullParameter(segment, "segment");
                    BufferCaptureStrategy bufferCaptureStrategy = BufferCaptureStrategy.this;
                    bufferCaptureStrategy.capture(bufferCaptureStrategy.bufferedSegments);
                    if (segment instanceof CaptureStrategy.ReplaySegment.Created) {
                        CaptureStrategy.ReplaySegment.Created created = (CaptureStrategy.ReplaySegment.Created) segment;
                        CaptureStrategy.ReplaySegment.Created.capture$default(created, BufferCaptureStrategy.this.scopes, null, 2, null);
                        Function1<Date, Unit> function1 = onSegmentSent;
                        Date timestamp = created.getReplay().getTimestamp();
                        Intrinsics.checkNotNullExpressionValue(timestamp, "segment.replay.timestamp");
                        function1.invoke(timestamp);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void captureReplay$lambda$1(BufferCaptureStrategy this$0, IScope it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it2, "it");
        it2.setReplayId(this$0.getCurrentReplayId());
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public void onScreenshotRecorded(@Nullable Bitmap bitmap, @NotNull final Function2<? super ReplayCache, ? super Long, Unit> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        final long currentTimeMillis = this.dateProvider.getCurrentTimeMillis();
        ExecutorsKt.submitSafely(getReplayExecutor(), this.options, "BufferCaptureStrategy.add_frame", new Runnable() { // from class: io.sentry.android.replay.capture.BufferCaptureStrategy$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BufferCaptureStrategy.onScreenshotRecorded$lambda$2(this.f$0, store, currentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onScreenshotRecorded$lambda$2(BufferCaptureStrategy this$0, Function2 store, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(store, "$store");
        ReplayCache cache = this$0.getCache();
        if (cache != null) {
            store.invoke(cache, Long.valueOf(j));
        }
        long currentTimeMillis = this$0.dateProvider.getCurrentTimeMillis() - this$0.options.getSessionReplay().getErrorReplayDuration();
        ReplayCache cache2 = this$0.getCache();
        this$0.setScreenAtStart(cache2 != null ? cache2.rotate$sentry_android_replay_release(currentTimeMillis) : null);
        this$0.rotate(this$0.bufferedSegments, currentTimeMillis);
    }

    @Override // io.sentry.android.replay.capture.BaseCaptureStrategy, io.sentry.android.replay.capture.CaptureStrategy
    public void onConfigurationChanged(@NotNull ScreenshotRecorderConfig recorderConfig) {
        Intrinsics.checkNotNullParameter(recorderConfig, "recorderConfig");
        createCurrentSegment("configuration_changed", new Function1<CaptureStrategy.ReplaySegment, Unit>() { // from class: io.sentry.android.replay.capture.BufferCaptureStrategy.onConfigurationChanged.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CaptureStrategy.ReplaySegment replaySegment) {
                invoke2(replaySegment);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull CaptureStrategy.ReplaySegment segment) {
                Intrinsics.checkNotNullParameter(segment, "segment");
                if (segment instanceof CaptureStrategy.ReplaySegment.Created) {
                    BufferCaptureStrategy.this.bufferedSegments.add(segment);
                    BufferCaptureStrategy bufferCaptureStrategy = BufferCaptureStrategy.this;
                    bufferCaptureStrategy.setCurrentSegment(bufferCaptureStrategy.getCurrentSegment() + 1);
                }
            }
        });
        super.onConfigurationChanged(recorderConfig);
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public CaptureStrategy convert() {
        if (isTerminating().get()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Not converting to session mode, because the process is about to terminate", new Object[0]);
            return this;
        }
        SessionCaptureStrategy sessionCaptureStrategy = new SessionCaptureStrategy(this.options, this.scopes, this.dateProvider, getReplayExecutor(), null, 16, null);
        sessionCaptureStrategy.start(getCurrentSegment(), getCurrentReplayId(), SentryReplayEvent.ReplayType.BUFFER);
        return sessionCaptureStrategy;
    }

    @Override // io.sentry.android.replay.capture.BaseCaptureStrategy, io.sentry.android.replay.capture.CaptureStrategy
    public void onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onTouchEvent(event);
        CaptureStrategy.Companion.rotateEvents$sentry_android_replay_release$default(CaptureStrategy.Companion, getCurrentEvents(), this.dateProvider.getCurrentTimeMillis() - this.options.getSessionReplay().getErrorReplayDuration(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteFile(File file) {
        if (file == null) {
            return;
        }
        try {
            if (file.delete()) {
                return;
            }
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete replay segment: %s", file.getAbsolutePath());
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, th, "Failed to delete replay segment: %s", file.getAbsolutePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void capture(List<CaptureStrategy.ReplaySegment.Created> list) throws InterruptedException {
        CaptureStrategy.ReplaySegment.Created created = (CaptureStrategy.ReplaySegment.Created) CollectionsKt__MutableCollectionsKt.removeFirstOrNull(list);
        while (created != null) {
            CaptureStrategy.ReplaySegment.Created.capture$default(created, this.scopes, null, 2, null);
            created = (CaptureStrategy.ReplaySegment.Created) CollectionsKt__MutableCollectionsKt.removeFirstOrNull(list);
            Thread.sleep(ENVELOPE_PROCESSING_DELAY);
        }
    }

    private final void rotate(List<CaptureStrategy.ReplaySegment.Created> list, final long j) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        CollectionsKt__MutableCollectionsKt.removeAll((List) list, (Function1) new Function1<CaptureStrategy.ReplaySegment.Created, Boolean>() { // from class: io.sentry.android.replay.capture.BufferCaptureStrategy.rotate.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(@NotNull CaptureStrategy.ReplaySegment.Created it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                if (it2.getReplay().getTimestamp().getTime() < j) {
                    BufferCaptureStrategy bufferCaptureStrategy = this;
                    bufferCaptureStrategy.setCurrentSegment(bufferCaptureStrategy.getCurrentSegment() - 1);
                    this.deleteFile(it2.getReplay().getVideoFile());
                    booleanRef.element = true;
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
        });
        if (booleanRef.element) {
            int i = 0;
            for (Object obj : list) {
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ((CaptureStrategy.ReplaySegment.Created) obj).setSegmentId(i);
                i++;
            }
        }
    }

    private final void createCurrentSegment(String str, final Function1<? super CaptureStrategy.ReplaySegment, Unit> function1) {
        Date dateTime;
        List<ReplayFrame> frames$sentry_android_replay_release;
        final ScreenshotRecorderConfig recorderConfig = getRecorderConfig();
        if (recorderConfig == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Recorder config is not set, not creating segment for task: " + str, new Object[0]);
            return;
        }
        long errorReplayDuration = this.options.getSessionReplay().getErrorReplayDuration();
        long currentTimeMillis = this.dateProvider.getCurrentTimeMillis();
        ReplayCache cache = getCache();
        if (cache != null && (frames$sentry_android_replay_release = cache.getFrames$sentry_android_replay_release()) != null && (!frames$sentry_android_replay_release.isEmpty())) {
            ReplayCache cache2 = getCache();
            Intrinsics.checkNotNull(cache2);
            dateTime = DateUtils.getDateTime(((ReplayFrame) CollectionsKt___CollectionsKt.first((List) cache2.getFrames$sentry_android_replay_release())).getTimestamp());
        } else {
            dateTime = DateUtils.getDateTime(currentTimeMillis - errorReplayDuration);
        }
        final Date date = dateTime;
        Intrinsics.checkNotNullExpressionValue(date, "if (cache?.frames?.isNot…orReplayDuration)\n      }");
        long time = date.getTime();
        final SentryId currentReplayId = getCurrentReplayId();
        final long j = currentTimeMillis - time;
        ExecutorsKt.submitSafely(getReplayExecutor(), this.options, "BufferCaptureStrategy." + str, new Runnable() { // from class: io.sentry.android.replay.capture.BufferCaptureStrategy$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BufferCaptureStrategy.createCurrentSegment$lambda$4(this.f$0, j, date, currentReplayId, recorderConfig, function1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCurrentSegment$lambda$4(BufferCaptureStrategy this$0, long j, Date currentSegmentTimestamp, SentryId replayId, ScreenshotRecorderConfig screenshotRecorderConfig, Function1 onSegmentCreated) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentSegmentTimestamp, "$currentSegmentTimestamp");
        Intrinsics.checkNotNullParameter(replayId, "$replayId");
        Intrinsics.checkNotNullParameter(onSegmentCreated, "$onSegmentCreated");
        onSegmentCreated.invoke(BaseCaptureStrategy.createSegmentInternal$default(this$0, j, currentSegmentTimestamp, replayId, this$0.getCurrentSegment(), screenshotRecorderConfig.getRecordingHeight(), screenshotRecorderConfig.getRecordingWidth(), screenshotRecorderConfig.getFrameRate(), screenshotRecorderConfig.getBitRate(), null, null, null, null, null, 7936, null));
    }
}
