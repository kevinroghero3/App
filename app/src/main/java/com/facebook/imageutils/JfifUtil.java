package com.facebook.imageutils;

import com.google.mlkit.common.MlKitException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class JfifUtil {
    public static final int APP1_EXIF_MAGIC = 1165519206;
    public static final JfifUtil INSTANCE = new JfifUtil();
    public static final int MARKER_APP1 = 225;
    public static final int MARKER_EOI = 217;
    public static final int MARKER_ESCAPE_BYTE = 0;
    public static final int MARKER_FIRST_BYTE = 255;
    public static final int MARKER_RST0 = 208;
    public static final int MARKER_RST7 = 215;
    public static final int MARKER_SOFn = 192;
    public static final int MARKER_SOI = 216;
    public static final int MARKER_SOS = 218;
    public static final int MARKER_TEM = 1;

    private final boolean isSOFn(int i) {
        switch (i) {
            case MARKER_SOFn /* 192 */:
            case 193:
            case 194:
            case 195:
            case 197:
            case 198:
            case 199:
            case 201:
            case 202:
            case 203:
            case MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR /* 205 */:
            case 206:
            case 207:
                return true;
            case 196:
            case 200:
            case 204:
            default:
                return false;
        }
    }

    private JfifUtil() {
    }

    @JvmStatic
    public static final int getAutoRotateAngleFromOrientation(int i) {
        return TiffUtil.getAutoRotateAngleFromOrientation(i);
    }

    @JvmStatic
    public static final int getOrientation(@Nullable byte[] bArr) {
        return getOrientation(new ByteArrayInputStream(bArr));
    }

    @JvmStatic
    public static final int getOrientation(@NotNull InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        try {
            int iMoveToAPP1EXIF = INSTANCE.moveToAPP1EXIF(inputStream);
            if (iMoveToAPP1EXIF != 0) {
                return TiffUtil.readOrientationFromTIFF(inputStream, iMoveToAPP1EXIF);
            }
        } catch (IOException unused) {
        }
        return 0;
    }

    @JvmStatic
    public static final boolean moveToMarker(@NotNull InputStream inputStream, int i) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        while (StreamProcessor.readPackedInt(inputStream, 1, false) == 255) {
            int packedInt = 255;
            while (packedInt == 255) {
                packedInt = StreamProcessor.readPackedInt(inputStream, 1, false);
            }
            if ((i == 192 && INSTANCE.isSOFn(packedInt)) || packedInt == i) {
                return true;
            }
            if (packedInt != 1 && packedInt != 216) {
                if (packedInt == 217 || packedInt == 218) {
                    break;
                }
                inputStream.skip(StreamProcessor.readPackedInt(inputStream, 2, false) - 2);
            }
        }
        return false;
    }

    private final int moveToAPP1EXIF(InputStream inputStream) throws IOException {
        if (moveToMarker(inputStream, MARKER_APP1)) {
            int packedInt = StreamProcessor.readPackedInt(inputStream, 2, false);
            if (packedInt - 2 > 6) {
                int packedInt2 = StreamProcessor.readPackedInt(inputStream, 4, false);
                int packedInt3 = StreamProcessor.readPackedInt(inputStream, 2, false);
                if (packedInt2 == 1165519206 && packedInt3 == 0) {
                    return packedInt - 8;
                }
            }
        }
        return 0;
    }
}
