package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.common.RotationOptions;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class TiffUtil {
    public static final TiffUtil INSTANCE = new TiffUtil();
    private static final Class<?> TAG = TiffUtil.class;
    public static final int TIFF_BYTE_ORDER_BIG_END = 1296891946;
    public static final int TIFF_BYTE_ORDER_LITTLE_END = 1229531648;
    public static final int TIFF_TAG_ORIENTATION = 274;
    public static final int TIFF_TYPE_SHORT = 3;

    @JvmStatic
    public static final int getAutoRotateAngleFromOrientation(int i) {
        if (i != 0 && i != 1) {
            if (i == 3) {
                return RotationOptions.ROTATE_180;
            }
            if (i == 6) {
                return 90;
            }
            if (i == 8) {
                return RotationOptions.ROTATE_270;
            }
        }
        return 0;
    }

    private TiffUtil() {
    }

    @JvmStatic
    public static final int readOrientationFromTIFF(@NotNull InputStream stream, int i) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        TiffHeader tiffHeader = new TiffHeader();
        TiffUtil tiffUtil = INSTANCE;
        int tiffHeader2 = tiffUtil.readTiffHeader(stream, i, tiffHeader);
        int firstIfdOffset = tiffHeader.getFirstIfdOffset() - 8;
        if (tiffHeader2 == 0 || firstIfdOffset > tiffHeader2) {
            return 0;
        }
        stream.skip(firstIfdOffset);
        return tiffUtil.getOrientationFromTiffEntry(stream, tiffUtil.moveToTiffEntryWithTag(stream, tiffHeader2 - firstIfdOffset, tiffHeader.isLittleEndian(), TIFF_TAG_ORIENTATION), tiffHeader.isLittleEndian());
    }

    private final int readTiffHeader(InputStream inputStream, int i, TiffHeader tiffHeader) throws IOException {
        if (i <= 8) {
            return 0;
        }
        tiffHeader.setByteOrder(StreamProcessor.readPackedInt(inputStream, 4, false));
        if (tiffHeader.getByteOrder() != 1229531648 && tiffHeader.getByteOrder() != 1296891946) {
            FLog.e(TAG, "Invalid TIFF header");
            return 0;
        }
        tiffHeader.setLittleEndian(tiffHeader.getByteOrder() == 1229531648);
        tiffHeader.setFirstIfdOffset(StreamProcessor.readPackedInt(inputStream, 4, tiffHeader.isLittleEndian()));
        int i2 = i - 8;
        if (tiffHeader.getFirstIfdOffset() >= 8 && tiffHeader.getFirstIfdOffset() - 8 <= i2) {
            return i2;
        }
        FLog.e(TAG, "Invalid offset");
        return 0;
    }

    private final int moveToTiffEntryWithTag(InputStream inputStream, int i, boolean z, int i2) throws IOException {
        if (i < 14) {
            return 0;
        }
        int i3 = i - 2;
        for (int packedInt = StreamProcessor.readPackedInt(inputStream, 2, z); packedInt > 0 && i3 >= 12; packedInt--) {
            if (StreamProcessor.readPackedInt(inputStream, 2, z) == i2) {
                return i3 - 2;
            }
            inputStream.skip(10L);
            i3 -= 12;
        }
        return 0;
    }

    private final int getOrientationFromTiffEntry(InputStream inputStream, int i, boolean z) throws IOException {
        if (i >= 10 && StreamProcessor.readPackedInt(inputStream, 2, z) == 3 && StreamProcessor.readPackedInt(inputStream, 4, z) == 1) {
            return StreamProcessor.readPackedInt(inputStream, 2, z);
        }
        return 0;
    }

    static final class TiffHeader {
        private int byteOrder;
        private int firstIfdOffset;
        private boolean isLittleEndian;

        public final boolean isLittleEndian() {
            return this.isLittleEndian;
        }

        public final void setLittleEndian(boolean z) {
            this.isLittleEndian = z;
        }

        public final int getByteOrder() {
            return this.byteOrder;
        }

        public final void setByteOrder(int i) {
            this.byteOrder = i;
        }

        public final int getFirstIfdOffset() {
            return this.firstIfdOffset;
        }

        public final void setFirstIfdOffset(int i) {
            this.firstIfdOffset = i;
        }
    }
}
