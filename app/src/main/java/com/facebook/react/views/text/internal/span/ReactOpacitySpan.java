package com.facebook.react.views.text.internal.span;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactOpacitySpan extends CharacterStyle implements UpdateAppearance, ReactSpan {
    private final float opacity;

    public final float getOpacity() {
        return this.opacity;
    }

    public ReactOpacitySpan(float f) {
        this.opacity = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setAlpha(MathKt__MathJVMKt.roundToInt(Color.alpha(paint.getColor()) * this.opacity));
        int i = paint.bgColor;
        if (i != 0) {
            paint.bgColor = Color.argb(MathKt__MathJVMKt.roundToInt(Color.alpha(i) * this.opacity), Color.red(paint.bgColor), Color.green(paint.bgColor), Color.blue(paint.bgColor));
        }
    }
}
