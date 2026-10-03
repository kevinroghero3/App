package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.emoji2.text.EmojiSpan;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PlaceholderExtensions_androidKt {
    /* JADX INFO: renamed from: getSpanUnit--R2X_6o$annotations, reason: not valid java name */
    private static /* synthetic */ void m3407getSpanUnitR2X_6o$annotations(long j) {
    }

    /* JADX INFO: renamed from: getSpanVerticalAlign-do9X-Gg$annotations, reason: not valid java name */
    private static /* synthetic */ void m3409getSpanVerticalAligndo9XGg$annotations(int i) {
    }

    private static final void setPlaceholder(Spannable spannable, Placeholder placeholder, int i, int i2, Density density) {
        for (Object obj : spannable.getSpans(i, i2, EmojiSpan.class)) {
            spannable.removeSpan((EmojiSpan) obj);
        }
        SpannableExtensions_androidKt.setSpan(spannable, new PlaceholderSpan(TextUnit.m3843getValueimpl(placeholder.m3049getWidthXSAIIZE()), m3406getSpanUnitR2X_6o(placeholder.m3049getWidthXSAIIZE()), TextUnit.m3843getValueimpl(placeholder.m3047getHeightXSAIIZE()), m3406getSpanUnitR2X_6o(placeholder.m3047getHeightXSAIIZE()), density.getFontScale() * density.getDensity(), m3408getSpanVerticalAligndo9XGg(placeholder.m3048getPlaceholderVerticalAlignJ6kI3mc())), i, i2);
    }

    /* JADX INFO: renamed from: getSpanUnit--R2X_6o, reason: not valid java name */
    private static final int m3406getSpanUnitR2X_6o(long j) {
        long jM3842getTypeUIouoOA = TextUnit.m3842getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3876getSpUIouoOA())) {
            return 0;
        }
        return TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3875getEmUIouoOA()) ? 1 : 2;
    }

    /* JADX INFO: renamed from: getSpanVerticalAlign-do9X-Gg, reason: not valid java name */
    private static final int m3408getSpanVerticalAligndo9XGg(int i) {
        PlaceholderVerticalAlign.Companion companion = PlaceholderVerticalAlign.Companion;
        if (PlaceholderVerticalAlign.m3053equalsimpl0(i, companion.m3057getAboveBaselineJ6kI3mc())) {
            return 0;
        }
        if (PlaceholderVerticalAlign.m3053equalsimpl0(i, companion.m3063getTopJ6kI3mc())) {
            return 1;
        }
        if (PlaceholderVerticalAlign.m3053equalsimpl0(i, companion.m3058getBottomJ6kI3mc())) {
            return 2;
        }
        if (PlaceholderVerticalAlign.m3053equalsimpl0(i, companion.m3059getCenterJ6kI3mc())) {
            return 3;
        }
        if (PlaceholderVerticalAlign.m3053equalsimpl0(i, companion.m3062getTextTopJ6kI3mc())) {
            return 4;
        }
        if (PlaceholderVerticalAlign.m3053equalsimpl0(i, companion.m3060getTextBottomJ6kI3mc())) {
            return 5;
        }
        if (PlaceholderVerticalAlign.m3053equalsimpl0(i, companion.m3061getTextCenterJ6kI3mc())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign");
    }

    public static final void setPlaceholders(@NotNull Spannable spannable, @NotNull List<AnnotatedString.Range<Placeholder>> list, @NotNull Density density) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<Placeholder> range = list.get(i);
            setPlaceholder(spannable, range.component1(), range.component2(), range.component3(), density);
        }
    }
}
