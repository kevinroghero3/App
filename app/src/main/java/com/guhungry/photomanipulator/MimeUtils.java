package com.guhungry.photomanipulator;

import android.graphics.Bitmap;
import android.os.Build;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class MimeUtils {
    public static final MimeUtils INSTANCE = new MimeUtils();
    public static final String JPEG = "image/jpeg";
    public static final String PNG = "image/png";
    public static final String WEBP = "image/webp";

    private MimeUtils() {
    }

    @JvmStatic
    public static final String toExtension(@Nullable String str) {
        if (Intrinsics.areEqual(str, "image/png")) {
            return ".png";
        }
        return Intrinsics.areEqual(str, "image/webp") ? ".webp" : ".jpg";
    }

    @JvmStatic
    public static final Bitmap.CompressFormat toCompressFormat(@NotNull String type) {
        Bitmap.CompressFormat compressFormat;
        Intrinsics.checkNotNullParameter(type, "type");
        if (Build.VERSION.SDK_INT >= 30) {
            compressFormat = Bitmap.CompressFormat.WEBP_LOSSY;
        } else {
            compressFormat = Bitmap.CompressFormat.WEBP;
        }
        if (Intrinsics.areEqual(type, "image/png")) {
            return Bitmap.CompressFormat.PNG;
        }
        return Intrinsics.areEqual(type, "image/webp") ? compressFormat : Bitmap.CompressFormat.JPEG;
    }
}
