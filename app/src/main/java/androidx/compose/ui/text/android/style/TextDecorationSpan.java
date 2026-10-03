package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class TextDecorationSpan extends CharacterStyle {
    public static final int $stable = 0;
    private final boolean isStrikethroughText;
    private final boolean isUnderlineText;

    public final boolean isUnderlineText() {
        return this.isUnderlineText;
    }

    public final boolean isStrikethroughText() {
        return this.isStrikethroughText;
    }

    public TextDecorationSpan(boolean z, boolean z2) {
        this.isUnderlineText = z;
        this.isStrikethroughText = z2;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        textPaint.setUnderlineText(this.isUnderlineText);
        textPaint.setStrikeThruText(this.isStrikethroughText);
    }
}
