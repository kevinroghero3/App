package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class FontMetricsUtil {
    private static final float AMPLIFICATION_FACTOR = 100.0f;
    private static final String CAP_HEIGHT_MEASUREMENT_TEXT = "T";
    public static final FontMetricsUtil INSTANCE = new FontMetricsUtil();
    private static final String X_HEIGHT_MEASUREMENT_TEXT = "x";

    private FontMetricsUtil() {
    }

    @JvmStatic
    public static final WritableArray getFontMetrics(@NotNull CharSequence text, @NotNull Layout layout, @NotNull TextPaint paint, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize(textPaint.getTextSize() * 100.0f);
        Rect rect = new Rect();
        int i = 0;
        int i2 = 1;
        textPaint.getTextBounds("T", 0, 1, rect);
        float fHeight = (rect.height() / 100.0f) / displayMetrics.density;
        Rect rect2 = new Rect();
        textPaint.getTextBounds("x", 0, 1, rect2);
        float fHeight2 = (rect2.height() / 100.0f) / displayMetrics.density;
        int lineCount = layout.getLineCount();
        while (i < lineCount) {
            float lineWidth = (text.length() <= 0 || text.charAt(layout.getLineEnd(i) - i2) != '\n') ? layout.getLineWidth(i) : layout.getLineMax(i);
            Rect rect3 = new Rect();
            layout.getLineBounds(i, rect3);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble("x", layout.getLineLeft(i) / displayMetrics.density);
            writableMapCreateMap.putDouble("y", rect3.top / displayMetrics.density);
            writableMapCreateMap.putDouble("width", lineWidth / displayMetrics.density);
            writableMapCreateMap.putDouble("height", rect3.height() / displayMetrics.density);
            writableMapCreateMap.putDouble("descender", layout.getLineDescent(i) / displayMetrics.density);
            writableMapCreateMap.putDouble("ascender", (-layout.getLineAscent(i)) / displayMetrics.density);
            writableMapCreateMap.putDouble("baseline", layout.getLineBaseline(i) / displayMetrics.density);
            writableMapCreateMap.putDouble("capHeight", fHeight);
            writableMapCreateMap.putDouble("xHeight", fHeight2);
            writableMapCreateMap.putString("text", text.subSequence(layout.getLineStart(i), layout.getLineEnd(i)).toString());
            writableArrayCreateArray.pushMap(writableMapCreateMap);
            i++;
            i2 = 1;
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }
}
