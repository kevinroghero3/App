package androidx.compose.ui.text.style;

import androidx.compose.ui.text.SpanStyleKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class TextIndentKt {
    public static final TextIndent lerp(@NotNull TextIndent textIndent, @NotNull TextIndent textIndent2, float f) {
        return new TextIndent(SpanStyleKt.m3091lerpTextUnitInheritableC3pnCVY(textIndent.m3563getFirstLineXSAIIZE(), textIndent2.m3563getFirstLineXSAIIZE(), f), SpanStyleKt.m3091lerpTextUnitInheritableC3pnCVY(textIndent.m3564getRestLineXSAIIZE(), textIndent2.m3564getRestLineXSAIIZE(), f), null);
    }
}
