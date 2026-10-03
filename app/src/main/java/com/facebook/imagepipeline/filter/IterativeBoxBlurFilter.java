package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class IterativeBoxBlurFilter {
    public static final IterativeBoxBlurFilter INSTANCE = new IterativeBoxBlurFilter();
    private static final String TAG = "IterativeBoxBlurFilter";

    private final int bound(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    private IterativeBoxBlurFilter() {
    }

    @JvmStatic
    public static final void boxBlurBitmapInPlace(@NotNull Bitmap bitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Preconditions.checkArgument(Boolean.valueOf(bitmap.isMutable()));
        Preconditions.checkArgument(Boolean.valueOf(((float) bitmap.getHeight()) <= 2048.0f));
        Preconditions.checkArgument(Boolean.valueOf(((float) bitmap.getWidth()) <= 2048.0f));
        Preconditions.checkArgument(Boolean.valueOf(i2 > 0 && i2 <= 25));
        Preconditions.checkArgument(Boolean.valueOf(i > 0));
        try {
            INSTANCE.fastBoxBlur(bitmap, i, i2);
        } catch (OutOfMemoryError e) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(null, "OOM: %d iterations on %dx%d with %d radius", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i2)}, 4));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FLog.e(TAG, str);
            throw e;
        }
    }

    private final void fastBoxBlur(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = i2 + 1;
        int i4 = i3 + i2;
        int[] iArr2 = new int[i4 * 256];
        int i5 = 1;
        while (true) {
            if (i5 >= 256) {
                break;
            }
            for (int i6 = 0; i6 < i4; i6++) {
                iArr2[i3] = i5;
                i3++;
            }
            i5++;
        }
        int[] iArr3 = new int[Math.max(width, height)];
        int i7 = 0;
        while (i7 < i) {
            int i8 = 0;
            while (i8 < height) {
                int i9 = i8;
                internalHorizontalBlur(iArr, iArr3, width, i8, i4, iArr2);
                System.arraycopy(iArr3, 0, iArr, i9 * width, width);
                i8 = i9 + 1;
            }
            int i10 = 0;
            while (i10 < width) {
                int i11 = i10;
                int i12 = i7;
                internalVerticalBlur(iArr, iArr3, width, height, i10, i4, iArr2);
                int i13 = i11;
                for (int i14 = 0; i14 < height; i14++) {
                    iArr[i13] = iArr3[i14];
                    i13 += width;
                }
                i10 = i11 + 1;
                i7 = i12;
            }
            i7++;
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
    }

    private final void internalHorizontalBlur(int[] iArr, int[] iArr2, int i, int i2, int i3, int[] iArr3) {
        int i4 = i * i2;
        int i5 = ((i2 + 1) * i) - 1;
        int i6 = i3 >> 1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = -i6; i11 < i + i6; i11++) {
            int i12 = iArr[bound(i4 + i11, i4, i5)];
            i7 += (i12 >> 16) & 255;
            i8 += (i12 >> 8) & 255;
            i9 += i12 & 255;
            i10 += i12 >>> 24;
            if (i11 >= i6) {
                iArr2[i11 - i6] = (iArr3[i10] << 24) | (iArr3[i7] << 16) | (iArr3[i8] << 8) | iArr3[i9];
                int i13 = iArr[bound((i11 - (i3 - 1)) + i4, i4, i5)];
                i7 -= (i13 >> 16) & 255;
                i8 -= (i13 >> 8) & 255;
                i9 -= i13 & 255;
                i10 -= i13 >>> 24;
            }
        }
    }

    private final void internalVerticalBlur(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int[] iArr3) {
        int i5 = ((i2 - 1) * i) + i3;
        int i6 = (i4 >> 1) * i;
        int i7 = i3 - i6;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i7 <= i5 + i6) {
            int i13 = iArr[bound(i7, i3, i5)];
            i8 += (i13 >> 16) & 255;
            i9 += (i13 >> 8) & 255;
            i10 += i13 & 255;
            i11 += i13 >>> 24;
            if (i7 - i6 >= i3) {
                iArr2[i12] = (iArr3[i11] << 24) | (iArr3[i8] << 16) | (iArr3[i9] << 8) | iArr3[i10];
                i12++;
                int i14 = iArr[bound(i7 - ((i4 - 1) * i), i3, i5)];
                i8 -= (i14 >> 16) & 255;
                i9 -= (i14 >> 8) & 255;
                i10 -= i14 & 255;
                i11 -= i14 >>> 24;
            }
            i7 += i;
        }
    }
}
