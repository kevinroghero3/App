package com.guhungry.rnphotomanipulator.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.guhungry.photomanipulator.BitmapUtils;
import com.guhungry.photomanipulator.FileUtils;
import com.guhungry.photomanipulator.model.CGRect;
import com.guhungry.photomanipulator.model.CGSize;
import java.io.File;
import java.io.InputStream;
import java.util.Locale;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class ImageUtils {
    public static final ImageUtils INSTANCE = new ImageUtils();

    @JvmStatic
    public static final Bitmap bitmapFromUri(@NotNull Context context, @NotNull String uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        return bitmapFromUri$default(context, uri, null, 4, null);
    }

    private ImageUtils() {
    }

    public static /* synthetic */ Bitmap bitmapFromUri$default(Context context, String str, BitmapFactory.Options options, int i, Object obj) {
        if ((i & 4) != 0) {
            options = null;
        }
        return bitmapFromUri(context, str, options);
    }

    @JvmStatic
    public static final Bitmap bitmapFromUri(@NotNull Context context, @NotNull String uri, @Nullable BitmapFactory.Options options) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        ImageUtils imageUtils = INSTANCE;
        InputStream inputStreamOpenBitmapInputStream = imageUtils.openBitmapInputStream(context, uri);
        try {
            InputStream inputStreamOpenBitmapInputStream2 = imageUtils.openBitmapInputStream(context, uri);
            try {
                Matrix correctOrientationMatrix = BitmapUtils.INSTANCE.getCorrectOrientationMatrix(inputStreamOpenBitmapInputStream2);
                CloseableKt.closeFinally(inputStreamOpenBitmapInputStream2, null);
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenBitmapInputStream, null, options);
                Intrinsics.checkNotNull(bitmapDecodeStream);
                if (correctOrientationMatrix != null) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), correctOrientationMatrix, true);
                    Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                    bitmapDecodeStream.recycle();
                    bitmapDecodeStream = bitmapCreateBitmap;
                }
                CloseableKt.closeFinally(inputStreamOpenBitmapInputStream, null);
                return bitmapDecodeStream;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpenBitmapInputStream2, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(inputStreamOpenBitmapInputStream, th3);
                throw th4;
            }
        }
    }

    @JvmStatic
    public static final BitmapFactory.Options mutableOptions() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        return options;
    }

    private final InputStream openBitmapInputStream(Context context, String str) {
        return FileUtils.openBitmapInputStream$default(context, computeUri(context, str), null, 4, null);
    }

    private final String computeUri(Context context, String str) {
        return Uri.parse(str).getScheme() != null ? str : computeDrawableResourceUri(context, str);
    }

    private final String computeDrawableResourceUri(Context context, String str) {
        return "android.resource://" + context.getPackageName() + RemoteSettings.FORWARD_SLASH_STRING + computeDrawableResourceId(context, str);
    }

    private final int computeDrawableResourceId(Context context, String str) {
        if (str.length() == 0) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return context.getResources().getIdentifier(StringsKt__StringsJVMKt.replace$default(lowerCase, "-", "_", false, 4, (Object) null), "drawable", context.getPackageName());
        }
    }

    @JvmStatic
    public static final Bitmap cropBitmapFromUri(@NotNull Context context, @NotNull String uri, @NotNull CGRect cropRegion, @Nullable CGSize cGSize) {
        Bitmap bitmapCropAndResize;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(cropRegion, "cropRegion");
        ImageUtils imageUtils = INSTANCE;
        InputStream inputStreamOpenBitmapInputStream = imageUtils.openBitmapInputStream(context, uri);
        try {
            if (cGSize == null) {
                bitmapCropAndResize = BitmapUtils.crop(inputStreamOpenBitmapInputStream, cropRegion, mutableOptions());
            } else {
                InputStream inputStreamOpenBitmapInputStream2 = imageUtils.openBitmapInputStream(context, uri);
                try {
                    Matrix correctOrientationMatrix = BitmapUtils.INSTANCE.getCorrectOrientationMatrix(inputStreamOpenBitmapInputStream2);
                    CloseableKt.closeFinally(inputStreamOpenBitmapInputStream2, null);
                    bitmapCropAndResize = BitmapUtils.cropAndResize(inputStreamOpenBitmapInputStream, cropRegion, cGSize, mutableOptions(), correctOrientationMatrix);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStreamOpenBitmapInputStream2, th);
                        throw th2;
                    }
                }
            }
            Bitmap bitmapMakeMutable = imageUtils.makeMutable(bitmapCropAndResize);
            CloseableKt.closeFinally(inputStreamOpenBitmapInputStream, null);
            return bitmapMakeMutable;
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(inputStreamOpenBitmapInputStream, th3);
                throw th4;
            }
        }
    }

    private final Bitmap makeMutable(Bitmap bitmap) {
        if (bitmap.isMutable()) {
            return bitmap;
        }
        try {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            Bitmap bitmapCopy = bitmap.copy(config, true);
            bitmap.recycle();
            Intrinsics.checkNotNull(bitmapCopy);
            return bitmapCopy;
        } catch (Throwable th) {
            bitmap.recycle();
            throw th;
        }
    }

    @JvmStatic
    public static final String saveTempFile(@NotNull Context context, @NotNull Bitmap image, @NotNull String mimeType, @NotNull String prefix, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        File fileCreateTempFile$default = FileUtils.createTempFile$default(context, prefix, mimeType, null, 8, null);
        FileUtils.saveImageFile$default(image, mimeType, i, fileCreateTempFile$default, null, 16, null);
        String string = Uri.fromFile(fileCreateTempFile$default).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
