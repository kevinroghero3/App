package com.facebook.react.views.text.internal.span;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class CustomLetterSpacingSpan extends MetricAffectingSpan implements ReactSpan {
    private final float spacing;

    public CustomLetterSpacingSpan(float f) {
        this.spacing = f;
    }

    public final float getSpacing() {
        return this.spacing;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        apply(paint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        apply(paint);
    }

    private final void apply(TextPaint textPaint) {
        if (Float.isNaN(this.spacing)) {
            return;
        }
        textPaint.setLetterSpacing(this.spacing);
    }
}
