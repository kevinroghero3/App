package com.facebook.fresco.vito.source;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class DrawableImageSource implements ImageSource {
    private final Drawable drawable;

    public static /* synthetic */ DrawableImageSource copy$default(DrawableImageSource drawableImageSource, Drawable drawable, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = drawableImageSource.drawable;
        }
        return drawableImageSource.copy(drawable);
    }

    public final Drawable component1() {
        return this.drawable;
    }

    public final DrawableImageSource copy(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return new DrawableImageSource(drawable);
    }

    public String toString() {
        return "DrawableImageSource(drawable=" + this.drawable + ")";
    }

    public DrawableImageSource(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.drawable = drawable;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(DrawableImageSource.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.fresco.vito.source.DrawableImageSource");
        return Intrinsics.areEqual(this.drawable, ((DrawableImageSource) obj).drawable);
    }

    public int hashCode() {
        return this.drawable.hashCode();
    }
}
