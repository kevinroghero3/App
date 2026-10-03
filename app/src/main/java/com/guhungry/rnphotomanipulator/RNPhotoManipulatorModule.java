package com.guhungry.rnphotomanipulator;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.text.BidiFormatter;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.text.ReactFontManager;
import com.guhungry.photomanipulator.BitmapUtils;
import com.guhungry.photomanipulator.model.TextStyle;
import com.guhungry.rnphotomanipulator.utils.ImageUtils;
import com.guhungry.rnphotomanipulator.utils.ParamUtils;
import com.henninghall.date_picker.props.ModeProp;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class RNPhotoManipulatorModule extends RNPhotoManipulatorSpec {
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_QUALITY = 100;
    private static final String FILE_PREFIX = "RNPM_";
    public static final String NAME = "RNPhotoManipulator";
    private final ReactApplicationContext context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNPhotoManipulatorModule(@NotNull ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.guhungry.rnphotomanipulator.RNPhotoManipulatorSpec
    @ReactMethod
    public void batch(@NotNull String uri, @NotNull ReadableArray operations, @NotNull ReadableMap cropRegion, @Nullable ReadableMap readableMap, @Nullable Double d, @Nullable String str, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(operations, "operations");
        Intrinsics.checkNotNullParameter(cropRegion, "cropRegion");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Bitmap bitmapCropBitmapFromUri = ImageUtils.cropBitmapFromUri(this.context, uri, ParamUtils.toCGRect(cropRegion), ParamUtils.toCGSize(readableMap));
            int size = operations.size();
            for (int i = 0; i < size; i++) {
                bitmapCropBitmapFromUri = processBatchOperation(bitmapCropBitmapFromUri, operations.getMap(i));
            }
            ReactApplicationContext reactApplicationContext = this.context;
            Intrinsics.checkNotNull(str);
            Intrinsics.checkNotNull(d);
            String strSaveTempFile = ImageUtils.saveTempFile(reactApplicationContext, bitmapCropBitmapFromUri, str, FILE_PREFIX, (int) d.doubleValue());
            bitmapCropBitmapFromUri.recycle();
            promise.resolve(strSaveTempFile);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Bitmap processBatchOperation(Bitmap bitmap, ReadableMap readableMap) {
        String string;
        String string2;
        ReadableMap map;
        if (readableMap != null && (string = readableMap.getString("operation")) != null) {
            switch (string.hashCode()) {
                case -1091287984:
                    if (!string.equals("overlay") || (string2 = readableMap.getString("overlay")) == null) {
                        return bitmap;
                    }
                    Bitmap bitmapBitmapFromUri$default = ImageUtils.bitmapFromUri$default(this.context, string2, null, 4, null);
                    PointF pointF = ParamUtils.toPointF(readableMap.getMap(ViewProps.POSITION));
                    Intrinsics.checkNotNull(pointF);
                    BitmapUtils.overlay$default(bitmap, bitmapBitmapFromUri$default, pointF, null, 8, null);
                    break;
                    break;
                case -925180581:
                    if (string.equals("rotate")) {
                        String string3 = readableMap.getString(ModeProp.name);
                        Intrinsics.checkNotNull(string3);
                        return BitmapUtils.rotate(bitmap, ParamUtils.toRotationMode(string3));
                    }
                    break;
                case 3145837:
                    if (string.equals("flip")) {
                        String string4 = readableMap.getString(ModeProp.name);
                        Intrinsics.checkNotNull(string4);
                        return BitmapUtils.flip(bitmap, ParamUtils.toFlipMode(string4));
                    }
                    break;
                case 3556653:
                    if (!string.equals("text") || (map = readableMap.getMap("options")) == null) {
                        return bitmap;
                    }
                    String string5 = map.getString("text");
                    Intrinsics.checkNotNull(string5);
                    PointF pointF2 = ParamUtils.toPointF(map.getMap(ViewProps.POSITION));
                    Intrinsics.checkNotNull(pointF2);
                    printLine(bitmap, string5, pointF2, map);
                    return bitmap;
            }
        }
        return bitmap;
    }

    @Override // com.guhungry.rnphotomanipulator.RNPhotoManipulatorSpec
    @ReactMethod
    public void crop(@NotNull String uri, @NotNull ReadableMap cropRegion, @Nullable ReadableMap readableMap, @Nullable String str, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(cropRegion, "cropRegion");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Bitmap bitmapCropBitmapFromUri = ImageUtils.cropBitmapFromUri(this.context, uri, ParamUtils.toCGRect(cropRegion), ParamUtils.toCGSize(readableMap));
            ReactApplicationContext reactApplicationContext = this.context;
            Intrinsics.checkNotNull(str);
            String strSaveTempFile = ImageUtils.saveTempFile(reactApplicationContext, bitmapCropBitmapFromUri, str, FILE_PREFIX, 100);
            bitmapCropBitmapFromUri.recycle();
            promise.resolve(strSaveTempFile);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @Override // com.guhungry.rnphotomanipulator.RNPhotoManipulatorSpec
    @ReactMethod
    public void flipImage(@NotNull String uri, @NotNull String mode, @Nullable String str, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Bitmap bitmapBitmapFromUri = ImageUtils.bitmapFromUri(this.context, uri, ImageUtils.mutableOptions());
            Bitmap bitmapFlip = BitmapUtils.flip(bitmapBitmapFromUri, ParamUtils.toFlipMode(mode));
            bitmapBitmapFromUri.recycle();
            ReactApplicationContext reactApplicationContext = this.context;
            Intrinsics.checkNotNull(str);
            String strSaveTempFile = ImageUtils.saveTempFile(reactApplicationContext, bitmapFlip, str, FILE_PREFIX, 100);
            bitmapFlip.recycle();
            promise.resolve(strSaveTempFile);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @Override // com.guhungry.rnphotomanipulator.RNPhotoManipulatorSpec
    @ReactMethod
    public void rotateImage(@NotNull String uri, @NotNull String mode, @Nullable String str, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Bitmap bitmapBitmapFromUri = ImageUtils.bitmapFromUri(this.context, uri, ImageUtils.mutableOptions());
            Bitmap bitmapRotate = BitmapUtils.rotate(bitmapBitmapFromUri, ParamUtils.toRotationMode(mode));
            bitmapBitmapFromUri.recycle();
            ReactApplicationContext reactApplicationContext = this.context;
            Intrinsics.checkNotNull(str);
            String strSaveTempFile = ImageUtils.saveTempFile(reactApplicationContext, bitmapRotate, str, FILE_PREFIX, 100);
            bitmapRotate.recycle();
            promise.resolve(strSaveTempFile);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @Override // com.guhungry.rnphotomanipulator.RNPhotoManipulatorSpec
    @ReactMethod
    public void overlayImage(@NotNull String uri, @NotNull String icon, @NotNull ReadableMap position, @Nullable String str, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Bitmap bitmapBitmapFromUri = ImageUtils.bitmapFromUri(this.context, uri, ImageUtils.mutableOptions());
            Bitmap bitmapBitmapFromUri$default = ImageUtils.bitmapFromUri$default(this.context, icon, null, 4, null);
            PointF pointF = ParamUtils.toPointF(position);
            Intrinsics.checkNotNull(pointF);
            BitmapUtils.overlay$default(bitmapBitmapFromUri, bitmapBitmapFromUri$default, pointF, null, 8, null);
            bitmapBitmapFromUri$default.recycle();
            ReactApplicationContext reactApplicationContext = this.context;
            Intrinsics.checkNotNull(str);
            String strSaveTempFile = ImageUtils.saveTempFile(reactApplicationContext, bitmapBitmapFromUri, str, FILE_PREFIX, 100);
            bitmapBitmapFromUri.recycle();
            promise.resolve(strSaveTempFile);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @Override // com.guhungry.rnphotomanipulator.RNPhotoManipulatorSpec
    @ReactMethod
    public void printText(@NotNull String uri, @NotNull ReadableArray list, @Nullable String str, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Bitmap bitmapBitmapFromUri = ImageUtils.bitmapFromUri(this.context, uri, ImageUtils.mutableOptions());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ReadableMap map = list.getMap(i);
                if (map != null) {
                    String string = map.getString("text");
                    Intrinsics.checkNotNull(string);
                    PointF pointF = ParamUtils.toPointF(map.getMap(ViewProps.POSITION));
                    Intrinsics.checkNotNull(pointF);
                    printLine(bitmapBitmapFromUri, string, pointF, map);
                }
            }
            ReactApplicationContext reactApplicationContext = this.context;
            Intrinsics.checkNotNull(str);
            String strSaveTempFile = ImageUtils.saveTempFile(reactApplicationContext, bitmapBitmapFromUri, str, FILE_PREFIX, 100);
            bitmapBitmapFromUri.recycle();
            promise.resolve(strSaveTempFile);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    private final void printLine(Bitmap bitmap, String str, PointF pointF, ReadableMap readableMap) {
        PointF pointF2 = ParamUtils.toPointF(readableMap.getMap("shadowOffset"));
        BidiFormatter bidiFormatter = BidiFormatter.getInstance();
        boolean zAreEqual = Intrinsics.areEqual("rtl", readableMap.getString("direction"));
        Paint.Align textAlign = toTextAlign(zAreEqual, readableMap.getString("align"));
        PointF adjustedLocation = toAdjustedLocation(zAreEqual, pointF, bitmap.getWidth());
        Integer colorInt = ParamUtils.toColorInt(readableMap.getMap("color"));
        Intrinsics.checkNotNull(colorInt);
        TextStyle textStyle = new TextStyle(colorInt.intValue(), (float) readableMap.getDouble("textSize"), getFont(readableMap.getString("fontName")), textAlign, readableMap.getInt("thickness"), Float.valueOf((float) readableMap.getDouble("rotation")), (float) readableMap.getDouble("shadowRadius"), pointF2 != null ? pointF2.x : 0.0f, pointF2 != null ? pointF2.y : 0.0f, ParamUtils.toColorInt(readableMap.getMap(ViewProps.SHADOW_COLOR)));
        String strUnicodeWrap = bidiFormatter.unicodeWrap(str);
        Intrinsics.checkNotNullExpressionValue(strUnicodeWrap, "unicodeWrap(...)");
        BitmapUtils.printText$default(bitmap, strUnicodeWrap, adjustedLocation, textStyle, null, 16, null);
    }

    private final PointF toAdjustedLocation(boolean z, PointF pointF, int i) {
        return z ? new PointF(i - pointF.x, pointF.y) : pointF;
    }

    private final Paint.Align toTextAlign(boolean z, String str) {
        if (Intrinsics.areEqual("center", str)) {
            return Paint.Align.CENTER;
        }
        if (Intrinsics.areEqual(ViewProps.END, str)) {
            return z ? Paint.Align.LEFT : Paint.Align.RIGHT;
        }
        return z ? Paint.Align.RIGHT : Paint.Align.LEFT;
    }

    private final Typeface getFont(String str) {
        Object objM5472constructorimpl;
        if (str != null) {
            try {
                Result.Companion companion = Result.Companion;
                ReactFontManager companion2 = ReactFontManager.Companion.getInstance();
                AssetManager assets = this.context.getAssets();
                Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
                objM5472constructorimpl = Result.m5472constructorimpl(companion2.getTypeface(str, 0, assets));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m5475exceptionOrNullimpl(objM5472constructorimpl) != null) {
                objM5472constructorimpl = Typeface.DEFAULT;
            }
            Typeface typeface = (Typeface) objM5472constructorimpl;
            if (typeface != null) {
                return typeface;
            }
        }
        Typeface DEFAULT = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        return DEFAULT;
    }

    @Override // com.guhungry.rnphotomanipulator.RNPhotoManipulatorSpec
    @ReactMethod
    public void optimize(@NotNull String uri, double d, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Bitmap bitmapBitmapFromUri$default = ImageUtils.bitmapFromUri$default(this.context, uri, null, 4, null);
            String strSaveTempFile = ImageUtils.saveTempFile(this.context, bitmapBitmapFromUri$default, "image/jpeg", FILE_PREFIX, (int) d);
            bitmapBitmapFromUri$default.recycle();
            promise.resolve(strSaveTempFile);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
