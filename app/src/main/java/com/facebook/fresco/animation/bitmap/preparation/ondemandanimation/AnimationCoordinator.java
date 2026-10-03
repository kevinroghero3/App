package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class AnimationCoordinator {
    private static final float FPS_STEP_PERCENTAGE = 0.2f;
    private static final long FREQUENCY_LOADERS_MS = 10000;
    private static final long FREQUENCY_PERFORMANCE_MS = 2000;
    public static final AnimationCoordinator INSTANCE;
    private static final float MIN_RENDERING_FPS_PERCENTAGE = 0.5f;
    private static final Runnable calculatePerformance;
    private static final Runnable clearUnusedFrameLoaders;
    private static final AtomicInteger criticalCounter;
    private static final AtomicInteger failuresCounter;
    private static final Lazy handler$delegate;
    private static final ConcurrentHashMap<DynamicRenderingFps, Integer> runningAnimations;
    private static final AtomicInteger successCounter;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FrameResult.FrameType.values().length];
            try {
                iArr[FrameResult.FrameType.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FrameResult.FrameType.NEAREST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FrameResult.FrameType.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AnimationCoordinator() {
    }

    static {
        AnimationCoordinator animationCoordinator = new AnimationCoordinator();
        INSTANCE = animationCoordinator;
        successCounter = new AtomicInteger(0);
        failuresCounter = new AtomicInteger(0);
        criticalCounter = new AtomicInteger(0);
        runningAnimations = new ConcurrentHashMap<>();
        handler$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AnimationCoordinator.handler_delegate$lambda$0();
            }
        });
        Runnable runnable = new Runnable() { // from class: com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AnimationCoordinator.calculatePerformance$lambda$3();
            }
        };
        calculatePerformance = runnable;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AnimationCoordinator.clearUnusedFrameLoaders$lambda$4();
            }
        };
        clearUnusedFrameLoaders = runnable2;
        animationCoordinator.getHandler().post(runnable);
        animationCoordinator.getHandler().post(runnable2);
    }

    private final Handler getHandler() {
        return (Handler) handler$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler handler_delegate$lambda$0() {
        HandlerThread handlerThread = new HandlerThread("FrescoAnimationWorker");
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void calculatePerformance$lambda$3() {
        float andSet = successCounter.getAndSet(0);
        float andSet2 = failuresCounter.getAndSet(0);
        float andSet3 = criticalCounter.getAndSet(0);
        float f = andSet + andSet2 + andSet3;
        if (f > 0.0f) {
            float f2 = andSet / f;
            float f3 = andSet3 / f;
            if (andSet2 / f > 0.25f || f3 > 0.1f) {
                for (Map.Entry<DynamicRenderingFps, Integer> entry : runningAnimations.entrySet()) {
                    INSTANCE.updateRenderingFps(entry.getKey(), -entry.getValue().intValue());
                }
            } else if (f2 > 0.98f) {
                for (Map.Entry<DynamicRenderingFps, Integer> entry2 : runningAnimations.entrySet()) {
                    INSTANCE.updateRenderingFps(entry2.getKey(), entry2.getValue().intValue());
                }
            }
            runningAnimations.clear();
        }
        INSTANCE.schedulePerformance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearUnusedFrameLoaders$lambda$4() {
        FrameLoaderFactory.Companion.clearUnusedUntil(new Date(System.currentTimeMillis() - 10000));
        INSTANCE.scheduleLoaders();
    }

    private final boolean schedulePerformance() {
        return getHandler().postDelayed(calculatePerformance, FREQUENCY_PERFORMANCE_MS);
    }

    private final boolean scheduleLoaders() {
        return getHandler().postDelayed(clearUnusedFrameLoaders, 10000L);
    }

    private final void updateRenderingFps(DynamicRenderingFps dynamicRenderingFps, int i) {
        int iCoerceIn = RangesKt___RangesKt.coerceIn(dynamicRenderingFps.getRenderingFps() + i, (int) RangesKt___RangesKt.coerceAtLeast(dynamicRenderingFps.getAnimationFps() * 0.5f, 1.0f), dynamicRenderingFps.getAnimationFps());
        if (iCoerceIn != dynamicRenderingFps.getRenderingFps()) {
            dynamicRenderingFps.setRenderingFps(iCoerceIn);
        }
    }

    public final void onRenderFrame(@NotNull DynamicRenderingFps animation, @NotNull FrameResult frameResult) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(frameResult, "frameResult");
        ConcurrentHashMap<DynamicRenderingFps, Integer> concurrentHashMap = runningAnimations;
        if (!concurrentHashMap.contains(animation)) {
            concurrentHashMap.put(animation, Integer.valueOf((int) (animation.getAnimationFps() * 0.2f)));
        }
        int i = WhenMappings.$EnumSwitchMapping$0[frameResult.getType().ordinal()];
        if (i == 1) {
            successCounter.incrementAndGet();
        } else if (i == 2) {
            failuresCounter.incrementAndGet();
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            criticalCounter.incrementAndGet();
        }
    }
}
