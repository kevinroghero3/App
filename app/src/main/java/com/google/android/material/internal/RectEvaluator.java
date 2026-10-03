package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public class RectEvaluator implements TypeEvaluator<Rect> {
    private final Rect rect;

    public RectEvaluator(@NonNull Rect rect) {
        this.rect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f, @NonNull Rect rect, @NonNull Rect rect2) {
        int i = rect.left;
        int i2 = (int) ((rect2.left - i) * f);
        int i3 = rect.top;
        int i4 = (int) ((rect2.top - i3) * f);
        int i5 = rect.right;
        int i6 = (int) ((rect2.right - i5) * f);
        int i7 = rect.bottom;
        this.rect.set(i + i2, i3 + i4, i5 + i6, i7 + ((int) ((rect2.bottom - i7) * f)));
        return this.rect;
    }
}
