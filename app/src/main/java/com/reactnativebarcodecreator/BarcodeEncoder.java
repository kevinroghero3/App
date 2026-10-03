package com.reactnativebarcodecreator;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class BarcodeEncoder {
    private static final int BLACK = -16777216;
    private static final int WHITE = -1;

    public Bitmap createBitmap(BitMatrix bitMatrix, int i, int i2) {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int[] iArr = new int[width * height];
        for (int i3 = 0; i3 < height; i3++) {
            for (int i4 = 0; i4 < width; i4++) {
                iArr[(i3 * width) + i4] = bitMatrix.get(i4, i3) ? i2 : i;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmapCreateBitmap;
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        try {
            return new MultiFormatWriter().encode(str, barcodeFormat, i, i2);
        } catch (WriterException e) {
            throw e;
        } catch (Exception e2) {
            throw new WriterException(e2);
        }
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        try {
            return new MultiFormatWriter().encode(str, barcodeFormat, i, i2, map);
        } catch (WriterException e) {
            throw e;
        } catch (Exception e2) {
            throw new WriterException(e2);
        }
    }

    public Bitmap encodeBitmap(String str, BarcodeFormat barcodeFormat, int i, int i2, int i3, int i4) throws WriterException {
        return createBitmap(encode(str, barcodeFormat, i, i2), i3, i4);
    }

    public Bitmap encodeBitmap(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map, int i3, int i4) throws WriterException {
        return createBitmap(encode(str, barcodeFormat, i, i2, map), i3, i4);
    }
}
