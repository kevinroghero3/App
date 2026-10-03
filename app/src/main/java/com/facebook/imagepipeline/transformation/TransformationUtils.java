package com.facebook.imagepipeline.transformation;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class TransformationUtils {
    public static final TransformationUtils INSTANCE = new TransformationUtils();

    private TransformationUtils() {
    }

    @JvmStatic
    public static final boolean maybeApplyTransformation(@Nullable BitmapTransformation bitmapTransformation, @Nullable CloseableReference<Bitmap> closeableReference) {
        if (bitmapTransformation == null || closeableReference == null) {
            return false;
        }
        Bitmap bitmap = closeableReference.get();
        Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
        Bitmap bitmap2 = bitmap;
        if (bitmapTransformation.modifiesTransparency()) {
            bitmap2.setHasAlpha(true);
        }
        bitmapTransformation.transform(bitmap2);
        return true;
    }
}
