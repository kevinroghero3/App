package io.sentry.android.replay.util;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class AndroidTextLayout implements TextLayout {
    public static final int $stable = 8;
    private final Layout layout;

    public AndroidTextLayout(@NotNull Layout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.layout = layout;
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineCount() {
        return this.layout.getLineCount();
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public Integer getDominantTextColor() {
        int i;
        if (!(this.layout.getText() instanceof Spanned)) {
            return null;
        }
        CharSequence text = this.layout.getText();
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
        ForegroundColorSpan[] spans = (ForegroundColorSpan[]) ((Spanned) text).getSpans(0, this.layout.getText().length(), ForegroundColorSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "spans");
        int i2 = Integer.MIN_VALUE;
        Integer numValueOf = null;
        for (ForegroundColorSpan foregroundColorSpan : spans) {
            CharSequence text2 = this.layout.getText();
            Intrinsics.checkNotNull(text2, "null cannot be cast to non-null type android.text.Spanned");
            int spanStart = ((Spanned) text2).getSpanStart(foregroundColorSpan);
            CharSequence text3 = this.layout.getText();
            Intrinsics.checkNotNull(text3, "null cannot be cast to non-null type android.text.Spanned");
            int spanEnd = ((Spanned) text3).getSpanEnd(foregroundColorSpan);
            if (spanStart != -1 && spanEnd != -1 && (i = spanEnd - spanStart) > i2) {
                numValueOf = Integer.valueOf(foregroundColorSpan.getForegroundColor());
                i2 = i;
            }
        }
        if (numValueOf != null) {
            return Integer.valueOf(ViewsKt.toOpaque(numValueOf.intValue()));
        }
        return null;
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public float getPrimaryHorizontal(int i, int i2) {
        return this.layout.getPrimaryHorizontal(i2);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getEllipsisCount(int i) {
        return this.layout.getEllipsisCount(i);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineVisibleEnd(int i) {
        return this.layout.getLineVisibleEnd(i);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineTop(int i) {
        return this.layout.getLineTop(i);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineBottom(int i) {
        return this.layout.getLineBottom(i);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineStart(int i) {
        return this.layout.getLineStart(i);
    }
}
