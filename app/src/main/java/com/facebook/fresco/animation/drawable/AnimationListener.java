package com.facebook.fresco.animation.drawable;

import android.graphics.drawable.Drawable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface AnimationListener {

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void onAnimationLoaded(@NotNull AnimationListener animationListener) {
        }
    }

    void onAnimationFrame(@NotNull Drawable drawable, int i);

    void onAnimationLoaded();

    void onAnimationRepeat(@NotNull Drawable drawable);

    void onAnimationReset(@NotNull Drawable drawable);

    void onAnimationStart(@NotNull Drawable drawable);

    void onAnimationStop(@NotNull Drawable drawable);
}
