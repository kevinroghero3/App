package com.facebook.react.views.text.internal.span;

import android.text.TextPaint;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactTextPaintHolderSpan implements ReactSpan {
    private final TextPaint textPaint;

    public static /* synthetic */ ReactTextPaintHolderSpan copy$default(ReactTextPaintHolderSpan reactTextPaintHolderSpan, TextPaint textPaint, int i, Object obj) {
        if ((i & 1) != 0) {
            textPaint = reactTextPaintHolderSpan.textPaint;
        }
        return reactTextPaintHolderSpan.copy(textPaint);
    }

    public final TextPaint component1() {
        return this.textPaint;
    }

    public final ReactTextPaintHolderSpan copy(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        return new ReactTextPaintHolderSpan(textPaint);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReactTextPaintHolderSpan) && Intrinsics.areEqual(this.textPaint, ((ReactTextPaintHolderSpan) obj).textPaint);
    }

    public int hashCode() {
        return this.textPaint.hashCode();
    }

    public String toString() {
        return "ReactTextPaintHolderSpan(textPaint=" + this.textPaint + ")";
    }

    public ReactTextPaintHolderSpan(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        this.textPaint = textPaint;
    }

    public final TextPaint getTextPaint() {
        return this.textPaint;
    }
}
