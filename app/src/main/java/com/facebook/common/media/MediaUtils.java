package com.facebook.common.media;

import androidx.annotation.NonNull;
import java.util.Locale;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaUtils {
    public static final MediaUtils INSTANCE = new MediaUtils();
    public static final Map<String, String> ADDITIONAL_ALLOWED_MIME_TYPES = MapsKt__MapsKt.mapOf(TuplesKt.to("mkv", "video/x-matroska"), TuplesKt.to("glb", "model/gltf-binary"));

    private MediaUtils() {
    }

    @JvmStatic
    public static final boolean isPhoto(@Nullable String str) {
        if (str != null) {
            return StringsKt__StringsJVMKt.startsWith$default(str, "image/", false, 2, null);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isVideo(@Nullable String str) {
        if (str != null) {
            return StringsKt__StringsJVMKt.startsWith$default(str, "video/", false, 2, null);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isThreeD(@Nullable String str) {
        return Intrinsics.areEqual(str, "model/gltf-binary");
    }

    @JvmStatic
    public static final String extractMime(@NonNull @NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        String strExtractExtension = INSTANCE.extractExtension(path);
        if (strExtractExtension == null) {
            return null;
        }
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = strExtractExtension.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (lowerCase == null) {
            return null;
        }
        String mimeTypeFromExtension = MimeTypeMapWrapper.getMimeTypeFromExtension(lowerCase);
        return mimeTypeFromExtension == null ? ADDITIONAL_ALLOWED_MIME_TYPES.get(lowerCase) : mimeTypeFromExtension;
    }

    private final String extractExtension(@NonNull String str) {
        int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null);
        if (iLastIndexOf$default < 0 || iLastIndexOf$default == str.length() - 1) {
            return null;
        }
        String strSubstring = str.substring(iLastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @JvmStatic
    public static final boolean isNonNativeSupportedMimeType(@NonNull @NotNull String mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return ADDITIONAL_ALLOWED_MIME_TYPES.containsValue(mimeType);
    }
}
