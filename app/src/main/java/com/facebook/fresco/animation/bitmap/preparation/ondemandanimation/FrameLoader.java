package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

import com.facebook.fresco.animation.backend.AnimationInformation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface FrameLoader {

    public static final class DefaultImpls {
        public static void compressToFps(@NotNull FrameLoader frameLoader, int i) {
        }

        public static void onStop(@NotNull FrameLoader frameLoader) {
        }
    }

    void clear();

    void compressToFps(int i);

    AnimationInformation getAnimationInformation();

    FrameResult getFrame(int i, int i2, int i3);

    void onStop();

    void prepareFrames(int i, int i2, @NotNull Function0<Unit> function0);
}
