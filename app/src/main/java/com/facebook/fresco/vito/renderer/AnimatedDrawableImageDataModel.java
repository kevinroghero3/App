package com.facebook.fresco.vito.renderer;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class AnimatedDrawableImageDataModel extends DrawableImageDataModel {
    private final Animatable animatable;
    private final boolean isAutoPlay;

    public final Animatable getAnimatable() {
        return this.animatable;
    }

    public final boolean isAutoPlay() {
        return this.isAutoPlay;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedDrawableImageDataModel(@NotNull Drawable drawable, @NotNull Animatable animatable, boolean z) {
        super(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(animatable, "animatable");
        this.animatable = animatable;
        this.isAutoPlay = z;
    }

    @Override // com.facebook.fresco.vito.renderer.ImageDataModel
    public void onAttach() {
        if (this.isAutoPlay) {
            this.animatable.start();
        }
    }

    @Override // com.facebook.fresco.vito.renderer.ImageDataModel
    public void onDetach() {
        if (this.isAutoPlay) {
            this.animatable.stop();
        }
    }
}
