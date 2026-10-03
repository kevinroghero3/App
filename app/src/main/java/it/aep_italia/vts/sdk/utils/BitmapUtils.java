package it.aep_italia.vts.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class BitmapUtils {
    private static final QRCodeWriter a = new QRCodeWriter();

    public static Bitmap generateQrCode(String str, ErrorCorrectionLevel errorCorrectionLevel, int i, int i2, int i3) throws Exception {
        HashMap map = new HashMap();
        map.put(EncodeHintType.ERROR_CORRECTION, errorCorrectionLevel);
        BitMatrix bitMatrixEncode = a.encode(str, BarcodeFormat.QR_CODE, 1, 1, map);
        int width = i / bitMatrixEncode.getWidth();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitMatrixEncode.getWidth() * width, bitMatrixEncode.getHeight() * width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);
        Paint paint2 = new Paint();
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        for (int i4 = 0; i4 < bitMatrixEncode.getWidth(); i4++) {
            for (int i5 = 0; i5 < bitMatrixEncode.getHeight(); i5++) {
                if (bitMatrixEncode.get(i4, i5)) {
                    int i6 = i4 * width;
                    int i7 = i5 * width;
                    canvas.drawRect(i6, i7, i6 + width, i7 + width, paint2);
                }
            }
        }
        return getResizedBitmap(bitmapCreateBitmap, i2, i3);
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    public static Bitmap roundBitmap(Bitmap bitmap) {
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        float f = iMin;
        RectF rectF = new RectF(0.0f, 0.0f, f, f);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        int width = bitmap.getWidth();
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        float f2 = width;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        int width2 = (bitmap.getWidth() - iMin) / 2;
        int height = (bitmap.getHeight() - iMin) / 2;
        Rect rect = new Rect(width2, height, iMin + width2, iMin + height);
        Rect rect2 = new Rect();
        rectF.round(rect2);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return bitmapCreateBitmap;
    }
}
