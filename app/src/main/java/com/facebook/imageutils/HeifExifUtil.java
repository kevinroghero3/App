package com.facebook.imageutils;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class HeifExifUtil {
    public static final HeifExifUtil INSTANCE = new HeifExifUtil();
    private static final String TAG = "HeifExifUtil";

    private HeifExifUtil() {
    }

    @JvmStatic
    public static final int getOrientation(@Nullable InputStream inputStream) {
        if (inputStream == null) {
            FLog.d(TAG, "Trying to read Heif Exif from null inputStream -> ignoring");
            return 0;
        }
        try {
            return new ExifInterface(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        } catch (IOException e) {
            FLog.d(TAG, "Failed reading Heif Exif orientation -> ignoring", (Throwable) e);
            return 0;
        }
    }
}
