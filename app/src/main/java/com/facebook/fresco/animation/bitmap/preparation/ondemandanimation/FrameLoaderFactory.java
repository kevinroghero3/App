package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class FrameLoaderFactory {
    public static final Companion Companion = new Companion(null);
    private static final ConcurrentHashMap<String, UnusedFrameLoader> UNUSED_FRAME_LOADERS = new ConcurrentHashMap<>();
    private final int bufferLengthMilliseconds;
    private final int maxFpsRender;
    private final PlatformBitmapFactory platformBitmapFactory;

    public FrameLoaderFactory(@NotNull PlatformBitmapFactory platformBitmapFactory, int i, int i2) {
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        this.platformBitmapFactory = platformBitmapFactory;
        this.maxFpsRender = i;
        this.bufferLengthMilliseconds = i2;
    }

    public final FrameLoader createBufferLoader(@NotNull String cacheKey, @NotNull BitmapFrameRenderer bitmapFrameRenderer, @NotNull AnimationInformation animationInformation) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(bitmapFrameRenderer, "bitmapFrameRenderer");
        Intrinsics.checkNotNullParameter(animationInformation, "animationInformation");
        ConcurrentHashMap<String, UnusedFrameLoader> concurrentHashMap = UNUSED_FRAME_LOADERS;
        synchronized (concurrentHashMap) {
            UnusedFrameLoader unusedFrameLoader = concurrentHashMap.get(cacheKey);
            if (unusedFrameLoader != null) {
                concurrentHashMap.remove(cacheKey);
                return unusedFrameLoader.getFrameLoader();
            }
            Unit unit = Unit.INSTANCE;
            return new BufferFrameLoader(this.platformBitmapFactory, bitmapFrameRenderer, new FpsCompressorInfo(this.maxFpsRender), animationInformation, this.bufferLengthMilliseconds);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void saveUnusedFrame(@NotNull String cacheKey, @NotNull FrameLoader frameLoader) {
            Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
            Intrinsics.checkNotNullParameter(frameLoader, "frameLoader");
            FrameLoaderFactory.UNUSED_FRAME_LOADERS.put(cacheKey, new UnusedFrameLoader(frameLoader, new Date()));
        }

        public final void clearUnusedUntil(@NotNull Date until) {
            Intrinsics.checkNotNullParameter(until, "until");
            synchronized (FrameLoaderFactory.UNUSED_FRAME_LOADERS) {
                ConcurrentHashMap concurrentHashMap = FrameLoaderFactory.UNUSED_FRAME_LOADERS;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                    if (((UnusedFrameLoader) entry.getValue()).getInsertedTime().compareTo(until) < 0) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    ((UnusedFrameLoader) entry2.getValue()).getFrameLoader().clear();
                    FrameLoaderFactory.UNUSED_FRAME_LOADERS.remove(entry2.getKey());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
