package io.sentry.android.replay.util;

import androidx.compose.ui.text.TextLayoutResult;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ComposeTextLayout implements TextLayout {
    public static final int $stable = TextLayoutResult.$stable;
    private final boolean hasFillModifier;
    private final TextLayoutResult layout;

    @Override // io.sentry.android.replay.util.TextLayout
    public Integer getDominantTextColor() {
        return null;
    }

    public ComposeTextLayout(@NotNull TextLayoutResult layout, boolean z) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.layout = layout;
        this.hasFillModifier = z;
    }

    public final TextLayoutResult getLayout$sentry_android_replay_release() {
        return this.layout;
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineCount() {
        return this.layout.getLineCount();
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public float getPrimaryHorizontal(int i, int i2) {
        float horizontalPosition = this.layout.getHorizontalPosition(i2, true);
        return (this.hasFillModifier || getLineCount() != 1) ? horizontalPosition : horizontalPosition - this.layout.getLineLeft(i);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getEllipsisCount(int i) {
        return this.layout.isLineEllipsized(i) ? 1 : 0;
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineVisibleEnd(int i) {
        return this.layout.getLineEnd(i, true);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineTop(int i) {
        return MathKt__MathJVMKt.roundToInt(this.layout.getLineTop(i));
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineBottom(int i) {
        return MathKt__MathJVMKt.roundToInt(this.layout.getLineBottom(i));
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineStart(int i) {
        return this.layout.getLineStart(i);
    }
}
