package com.guhungry.photomanipulator;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.internal.ViewUtils;
import com.guhungry.photomanipulator.factory.AndroidConcreteFactory;
import com.guhungry.photomanipulator.factory.AndroidFactory;
import com.guhungry.photomanipulator.model.CGRect;
import com.guhungry.photomanipulator.model.CGSize;
import com.guhungry.photomanipulator.model.FlipMode;
import com.guhungry.photomanipulator.model.RotationMode;
import com.guhungry.photomanipulator.model.TextStyle;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapUtils {
    public static final BitmapUtils INSTANCE = new BitmapUtils();

    @JvmStatic
    public static final Bitmap cropAndResize(@NotNull InputStream input, @NotNull CGRect cropSize, @NotNull CGSize targetSize, @NotNull BitmapFactory.Options outOptions) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(cropSize, "cropSize");
        Intrinsics.checkNotNullParameter(targetSize, "targetSize");
        Intrinsics.checkNotNullParameter(outOptions, "outOptions");
        return cropAndResize$default(input, cropSize, targetSize, outOptions, null, 16, null);
    }

    @JvmStatic
    public static final void overlay(@NotNull Bitmap background, @NotNull Bitmap overlay, @NotNull PointF position) {
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(overlay, "overlay");
        Intrinsics.checkNotNullParameter(position, "position");
        overlay$default(background, overlay, position, null, 8, null);
    }

    @Deprecated(message = "Use printText(Bitmap, String, PointF, TextStyle, AndroidFactory) instead")
    @JvmStatic
    public static final void printText(@NotNull Bitmap image, @NotNull String text, @NotNull PointF position, int i, float f) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(position, "position");
        printText$default(image, text, position, i, f, null, null, 0.0f, null, null, 992, null);
    }

    @Deprecated(message = "Use printText(Bitmap, String, PointF, TextStyle, AndroidFactory) instead")
    @JvmStatic
    public static final void printText(@NotNull Bitmap image, @NotNull String text, @NotNull PointF position, int i, float f, @Nullable Typeface typeface) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(position, "position");
        printText$default(image, text, position, i, f, typeface, null, 0.0f, null, null, 960, null);
    }

    @Deprecated(message = "Use printText(Bitmap, String, PointF, TextStyle, AndroidFactory) instead")
    @JvmStatic
    public static final void printText(@NotNull Bitmap image, @NotNull String text, @NotNull PointF position, int i, float f, @Nullable Typeface typeface, @NotNull Paint.Align alignment) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        printText$default(image, text, position, i, f, typeface, alignment, 0.0f, null, null, 896, null);
    }

    @Deprecated(message = "Use printText(Bitmap, String, PointF, TextStyle, AndroidFactory) instead")
    @JvmStatic
    public static final void printText(@NotNull Bitmap image, @NotNull String text, @NotNull PointF position, int i, float f, @Nullable Typeface typeface, @NotNull Paint.Align alignment, float f2) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        printText$default(image, text, position, i, f, typeface, alignment, f2, null, null, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
    }

    @Deprecated(message = "Use printText(Bitmap, String, PointF, TextStyle, AndroidFactory) instead")
    @JvmStatic
    public static final void printText(@NotNull Bitmap image, @NotNull String text, @NotNull PointF position, int i, float f, @Nullable Typeface typeface, @NotNull Paint.Align alignment, float f2, @Nullable Float f3) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        printText$default(image, text, position, i, f, typeface, alignment, f2, f3, null, 512, null);
    }

    @JvmStatic
    public static final void printText(@NotNull Bitmap image, @NotNull String text, @NotNull PointF position, @NotNull TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        printText$default(image, text, position, textStyle, null, 16, null);
    }

    private BitmapUtils() {
    }

    @JvmStatic
    public static final CGSize readImageDimensions(@NotNull InputStream input) {
        Intrinsics.checkNotNullParameter(input, "input");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(input, null, options);
        return new CGSize(options.outWidth, options.outHeight);
    }

    private final int decodeSampleSize(CGSize cGSize, CGSize cGSize2) {
        int i = 1;
        if (cGSize.getHeight() > cGSize2.getHeight() || cGSize.getWidth() > cGSize2.getWidth()) {
            int height = cGSize.getHeight() / 2;
            int width = cGSize.getWidth() / 2;
            while (width / i >= cGSize2.getWidth() && height / i >= cGSize2.getHeight()) {
                i *= 2;
            }
        }
        return i;
    }

    @JvmStatic
    public static final Bitmap crop(@NotNull InputStream input, @NotNull CGRect region, @NotNull BitmapFactory.Options outOptions) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(outOptions, "outOptions");
        try {
            BitmapRegionDecoder bitmapRegionDecoder = INSTANCE.getBitmapRegionDecoder(input);
            try {
                Bitmap bitmapDecodeRegion = bitmapRegionDecoder.decodeRegion(region.toRect(), outOptions);
                Intrinsics.checkNotNullExpressionValue(bitmapDecodeRegion, "decoder.decodeRegion(region.toRect(), outOptions)");
                bitmapRegionDecoder.recycle();
                CloseableKt.closeFinally(input, null);
                return bitmapDecodeRegion;
            } catch (Throwable th) {
                bitmapRegionDecoder.recycle();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.closeFinally(input, th2);
                throw th3;
            }
        }
    }

    private final BitmapRegionDecoder getBitmapRegionDecoder(InputStream inputStream) throws IOException {
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        if (Build.VERSION.SDK_INT >= 31) {
            bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStream);
            Intrinsics.checkNotNull(bitmapRegionDecoderNewInstance);
        } else {
            bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStream, false);
            Intrinsics.checkNotNull(bitmapRegionDecoderNewInstance);
        }
        Intrinsics.checkNotNullExpressionValue(bitmapRegionDecoderNewInstance, "if (Build.VERSION.SDK_IN…input, false)!!\n        }");
        return bitmapRegionDecoderNewInstance;
    }

    public static /* synthetic */ Bitmap cropAndResize$default(InputStream inputStream, CGRect cGRect, CGSize cGSize, BitmapFactory.Options options, Matrix matrix, int i, Object obj) {
        if ((i & 16) != 0) {
            matrix = null;
        }
        return cropAndResize(inputStream, cGRect, cGSize, options, matrix);
    }

    @JvmStatic
    public static final Bitmap cropAndResize(@NotNull InputStream input, @NotNull CGRect cropSize, @NotNull CGSize targetSize, @NotNull BitmapFactory.Options outOptions, @Nullable Matrix matrix) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(cropSize, "cropSize");
        Intrinsics.checkNotNullParameter(targetSize, "targetSize");
        Intrinsics.checkNotNullParameter(outOptions, "outOptions");
        BitmapUtils bitmapUtils = INSTANCE;
        outOptions.inSampleSize = bitmapUtils.decodeSampleSize(cropSize.getSize(), targetSize);
        outOptions.inJustDecodeBounds = false;
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(input, null, outOptions);
        if (bitmapDecodeStream == null) {
            throw new IOException("Cannot decode bitmap: uri");
        }
        if (matrix != null) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), matrix, true);
            bitmapDecodeStream.recycle();
            bitmapDecodeStream = bitmapCreateBitmap;
        }
        Intrinsics.checkNotNullExpressionValue(bitmapDecodeStream, "if (matrix != null) Bitm….recycle()  } else bitmap");
        CGRect cGRectFindCropPosition$photomanipulator_release$default = findCropPosition$photomanipulator_release$default(bitmapUtils, cropSize, targetSize, outOptions.inSampleSize, null, 8, null);
        Bitmap bitmap = bitmapDecodeStream;
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap, cGRectFindCropPosition$photomanipulator_release$default.getOrigin().x, cGRectFindCropPosition$photomanipulator_release$default.getOrigin().y, cGRectFindCropPosition$photomanipulator_release$default.getSize().getWidth(), cGRectFindCropPosition$photomanipulator_release$default.getSize().getHeight(), bitmapUtils.findCropScale(cGRectFindCropPosition$photomanipulator_release$default, targetSize), true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(rotated, cr…eight, scaleMatrix, true)");
        return bitmapCreateBitmap2;
    }

    public static /* synthetic */ CGRect findCropPosition$photomanipulator_release$default(BitmapUtils bitmapUtils, CGRect cGRect, CGSize cGSize, int i, AndroidFactory androidFactory, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            androidFactory = new AndroidConcreteFactory();
        }
        return bitmapUtils.findCropPosition$photomanipulator_release(cGRect, cGSize, i, androidFactory);
    }

    public final CGRect findCropPosition$photomanipulator_release(@NotNull CGRect rect, @NotNull CGSize targetSize, int i, @NotNull AndroidFactory factory) {
        float width;
        float height;
        float height2;
        float fFloor;
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(targetSize, "targetSize");
        Intrinsics.checkNotNullParameter(factory, "factory");
        float fRatio = rect.getSize().ratio();
        float fRatio2 = targetSize.ratio();
        if (fRatio > fRatio2) {
            fFloor = (float) Math.floor(rect.getSize().getHeight() * fRatio2);
            height2 = rect.getSize().getHeight();
            width = rect.getOrigin().x + ((rect.getSize().getWidth() - fFloor) / 2);
            height = rect.getOrigin().y;
        } else {
            float width2 = rect.getSize().getWidth();
            float fFloor2 = (float) Math.floor(rect.getSize().getWidth() / fRatio2);
            width = rect.getOrigin().x;
            height = ((rect.getSize().getHeight() - fFloor2) / 2) + rect.getOrigin().y;
            height2 = fFloor2;
            fFloor = width2;
        }
        return new CGRect(applyScale(width, i), applyScale(height, i), applyScale(fFloor, i), applyScale(height2, i), factory);
    }

    private final int applyScale(float f, int i) {
        return (int) Math.floor(f / i);
    }

    private final Matrix findCropScale(CGRect cGRect, CGSize cGSize) {
        float width;
        int width2;
        if (cGRect.getSize().ratio() > cGSize.ratio()) {
            width = cGSize.getHeight();
            width2 = cGRect.getSize().getHeight();
        } else {
            width = cGSize.getWidth();
            width2 = cGRect.getSize().getWidth();
        }
        float f = width / width2;
        Matrix matrix = new Matrix();
        matrix.setScale(f, f);
        return matrix;
    }

    public static /* synthetic */ void printText$default(Bitmap bitmap, String str, PointF pointF, int i, float f, Typeface typeface, Paint.Align align, float f2, Float f3, AndroidFactory androidFactory, int i2, Object obj) {
        printText(bitmap, str, pointF, i, f, (i2 & 32) != 0 ? null : typeface, (i2 & 64) != 0 ? Paint.Align.LEFT : align, (i2 & 128) != 0 ? 0.0f : f2, (i2 & 256) != 0 ? null : f3, (i2 & 512) != 0 ? new AndroidConcreteFactory() : androidFactory);
    }

    @Deprecated(message = "Use printText(Bitmap, String, PointF, TextStyle, AndroidFactory) instead")
    @JvmStatic
    public static final void printText(@NotNull Bitmap image, @NotNull String text, @NotNull PointF position, int i, float f, @Nullable Typeface typeface, @NotNull Paint.Align alignment, float f2, @Nullable Float f3, @NotNull AndroidFactory factory) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(factory, "factory");
        printText(image, text, position, new TextStyle(i, f, typeface, alignment, f2, f3, 0.0f, 0.0f, 0.0f, null, 960, null), factory);
    }

    public static /* synthetic */ void printText$default(Bitmap bitmap, String str, PointF pointF, TextStyle textStyle, AndroidFactory androidFactory, int i, Object obj) {
        if ((i & 16) != 0) {
            androidFactory = new AndroidConcreteFactory();
        }
        printText(bitmap, str, pointF, textStyle, androidFactory);
    }

    @JvmStatic
    public static final void printText(@NotNull Bitmap image, @NotNull String text, @NotNull PointF position, @NotNull TextStyle textStyle, @NotNull AndroidFactory factory) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Intrinsics.checkNotNullParameter(factory, "factory");
        if (StringsKt__StringsKt.isBlank(text)) {
            return;
        }
        Canvas canvasMakeCanvas = factory.makeCanvas(image);
        Paint paintMakePaint = factory.makePaint();
        paintMakePaint.setColor(textStyle.getColor());
        paintMakePaint.setTextSize(textStyle.getSize());
        paintMakePaint.setTextAlign(textStyle.getAlignment());
        paintMakePaint.setAntiAlias(true);
        Typeface font = textStyle.getFont();
        if (font != null) {
            paintMakePaint.setTypeface(font);
        }
        BitmapUtils bitmapUtils = INSTANCE;
        bitmapUtils.setTextBorder(paintMakePaint, textStyle);
        bitmapUtils.setTextShadow(paintMakePaint, textStyle);
        float size = position.y + (textStyle.getSize() / 2);
        canvasMakeCanvas.save();
        Float rotation = textStyle.getRotation();
        canvasMakeCanvas.rotate(-(rotation != null ? rotation.floatValue() : 0.0f), position.x, size);
        Iterator it2 = StringsKt__StringsKt.split$default((CharSequence) text, new String[]{"\n"}, false, 0, 6, (Object) null).iterator();
        while (it2.hasNext()) {
            canvasMakeCanvas.drawText((String) it2.next(), position.x, size, paintMakePaint);
            size += paintMakePaint.descent() - paintMakePaint.ascent();
        }
        canvasMakeCanvas.restore();
    }

    private final void setTextBorder(Paint paint, TextStyle textStyle) {
        if (textStyle.getThickness() <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(textStyle.getThickness());
    }

    private final void setTextShadow(Paint paint, TextStyle textStyle) {
        if (textStyle.getShadowColor() == null || textStyle.getShadowRadius() <= 0.0f) {
            return;
        }
        paint.setShadowLayer(textStyle.getShadowRadius(), textStyle.getShadowOffsetX(), textStyle.getShadowOffsetY(), textStyle.getShadowColor().intValue());
    }

    public static /* synthetic */ void overlay$default(Bitmap bitmap, Bitmap bitmap2, PointF pointF, AndroidFactory androidFactory, int i, Object obj) {
        if ((i & 8) != 0) {
            androidFactory = new AndroidConcreteFactory();
        }
        overlay(bitmap, bitmap2, pointF, androidFactory);
    }

    @JvmStatic
    public static final void overlay(@NotNull Bitmap background, @NotNull Bitmap overlay, @NotNull PointF position, @NotNull AndroidFactory factory) {
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(overlay, "overlay");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Canvas canvasMakeCanvas = factory.makeCanvas(background);
        Paint paintMakePaint = factory.makePaint();
        paintMakePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        canvasMakeCanvas.drawBitmap(overlay, position.x, position.y, paintMakePaint);
    }

    @JvmStatic
    public static final Bitmap flip(@NotNull Bitmap image, @NotNull FlipMode mode) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (mode == FlipMode.None) {
            return image;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(mode.getScaleX(), mode.getScaleY());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(image, 0, 0…etHeight(), matrix, true)");
        return bitmapCreateBitmap;
    }

    @JvmStatic
    public static final Bitmap rotate(@NotNull Bitmap image, @NotNull RotationMode mode) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (mode == RotationMode.None) {
            return image;
        }
        Matrix matrix = new Matrix();
        matrix.preRotate(mode.getDegrees());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(image, 0, 0…etHeight(), matrix, true)");
        return bitmapCreateBitmap;
    }

    public final Matrix getCorrectOrientationMatrix(@NotNull InputStream input) {
        Intrinsics.checkNotNullParameter(input, "input");
        ExifInterface exifInterface = new ExifInterface(input);
        boolean zIsFlipped = exifInterface.isFlipped();
        int rotationDegrees = exifInterface.getRotationDegrees();
        if (!zIsFlipped && rotationDegrees == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(rotationDegrees);
        if (zIsFlipped) {
            matrix.preScale(-1.0f, 1.0f);
        }
        return matrix;
    }
}
