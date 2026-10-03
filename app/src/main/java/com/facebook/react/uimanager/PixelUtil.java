package com.facebook.react.uimanager;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes.dex */
public final class PixelUtil {
    public static final PixelUtil INSTANCE = new PixelUtil();

    @JvmStatic
    public static final float toPixelFromSP(float f) {
        return toPixelFromSP$default(f, 0.0f, 2, null);
    }

    private PixelUtil() {
    }

    @JvmStatic
    public static final float toPixelFromDIP(float f) {
        if (Float.isNaN(f)) {
            return Float.NaN;
        }
        return TypedValue.applyDimension(1, f, DisplayMetricsHolder.getWindowDisplayMetrics());
    }

    @JvmStatic
    public static final float toPixelFromDIP(double d) {
        return toPixelFromDIP((float) d);
    }

    public static /* synthetic */ float toPixelFromSP$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = Float.NaN;
        }
        return toPixelFromSP(f, f2);
    }

    @JvmStatic
    public static final float toPixelFromSP(float f, float f2) {
        if (Float.isNaN(f)) {
            return Float.NaN;
        }
        DisplayMetrics windowDisplayMetrics = DisplayMetricsHolder.getWindowDisplayMetrics();
        float fApplyDimension = TypedValue.applyDimension(2, f, windowDisplayMetrics);
        return f2 >= 1.0f ? Math.min(fApplyDimension, f * windowDisplayMetrics.density * f2) : fApplyDimension;
    }

    @JvmStatic
    public static final float toPixelFromSP(double d) {
        return toPixelFromSP$default((float) d, 0.0f, 2, null);
    }

    @JvmStatic
    public static final float toDIPFromPixel(float f) {
        if (Float.isNaN(f)) {
            return Float.NaN;
        }
        return f / DisplayMetricsHolder.getWindowDisplayMetrics().density;
    }

    @JvmStatic
    public static final float getDisplayMetricDensity() {
        return DisplayMetricsHolder.getWindowDisplayMetrics().density;
    }

    public final float dpToPx(int i) {
        return toPixelFromDIP(i);
    }

    public final float dpToPx(long j) {
        return toPixelFromDIP(j);
    }

    public final float dpToPx(float f) {
        return toPixelFromDIP(f);
    }

    public final float dpToPx(double d) {
        return toPixelFromDIP((float) d);
    }

    public final float pxToDp(int i) {
        return toDIPFromPixel(i);
    }

    public final float pxToDp(long j) {
        return toDIPFromPixel(j);
    }

    public final float pxToDp(float f) {
        return toDIPFromPixel(f);
    }

    public final float pxToDp(double d) {
        return toDIPFromPixel((float) d);
    }
}
