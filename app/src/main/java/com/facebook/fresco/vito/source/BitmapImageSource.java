package com.facebook.fresco.vito.source;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class BitmapImageSource implements ImageSource {
    private final Bitmap bitmap;

    public static /* synthetic */ BitmapImageSource copy$default(BitmapImageSource bitmapImageSource, Bitmap bitmap, int i, Object obj) {
        if ((i & 1) != 0) {
            bitmap = bitmapImageSource.bitmap;
        }
        return bitmapImageSource.copy(bitmap);
    }

    public final Bitmap component1() {
        return this.bitmap;
    }

    public final BitmapImageSource copy(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return new BitmapImageSource(bitmap);
    }

    public String toString() {
        return "BitmapImageSource(bitmap=" + this.bitmap + ")";
    }

    public BitmapImageSource(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.bitmap = bitmap;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(BitmapImageSource.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Bitmap bitmap = this.bitmap;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.fresco.vito.source.BitmapImageSource");
        return Intrinsics.areEqual(bitmap, ((BitmapImageSource) obj).bitmap);
    }

    public int hashCode() {
        return this.bitmap.hashCode();
    }
}
