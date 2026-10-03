package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class LineHeightStyleSpan_androidKt {
    public static final int lineHeight(@NotNull Paint.FontMetricsInt fontMetricsInt) {
        return fontMetricsInt.descent - fontMetricsInt.ascent;
    }
}
