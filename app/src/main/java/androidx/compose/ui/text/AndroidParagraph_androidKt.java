package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;

/* JADX INFO: loaded from: classes4.dex */
public final class AndroidParagraph_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutAlign-aXe7zB0, reason: not valid java name */
    public static final int m2980toLayoutAlignaXe7zB0(int i) {
        TextAlign.Companion companion = TextAlign.Companion;
        if (TextAlign.m3535equalsimpl0(i, companion.m3542getLefte0LSkKk())) {
            return 3;
        }
        if (TextAlign.m3535equalsimpl0(i, companion.m3543getRighte0LSkKk())) {
            return 4;
        }
        if (TextAlign.m3535equalsimpl0(i, companion.m3539getCentere0LSkKk())) {
            return 2;
        }
        return (!TextAlign.m3535equalsimpl0(i, companion.m3544getStarte0LSkKk()) && TextAlign.m3535equalsimpl0(i, companion.m3540getEnde0LSkKk())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutHyphenationFrequency--3fSNIE, reason: not valid java name */
    public static final int m2982toLayoutHyphenationFrequency3fSNIE(int i) {
        Hyphens.Companion companion = Hyphens.Companion;
        if (Hyphens.m3445equalsimpl0(i, companion.m3449getAutovmbZdU8())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        Hyphens.m3445equalsimpl0(i, companion.m3450getNonevmbZdU8());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutBreakStrategy-xImikfE, reason: not valid java name */
    public static final int m2981toLayoutBreakStrategyxImikfE(int i) {
        LineBreak.Strategy.Companion companion = LineBreak.Strategy.Companion;
        if (!LineBreak.Strategy.m3476equalsimpl0(i, companion.m3482getSimplefcGXIks())) {
            if (LineBreak.Strategy.m3476equalsimpl0(i, companion.m3481getHighQualityfcGXIks())) {
                return 1;
            }
            if (LineBreak.Strategy.m3476equalsimpl0(i, companion.m3480getBalancedfcGXIks())) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutLineBreakStyle-hpcqdu8, reason: not valid java name */
    public static final int m2983toLayoutLineBreakStylehpcqdu8(int i) {
        LineBreak.Strictness.Companion companion = LineBreak.Strictness.Companion;
        if (!LineBreak.Strictness.m3487equalsimpl0(i, companion.m3491getDefaultusljTpc())) {
            if (LineBreak.Strictness.m3487equalsimpl0(i, companion.m3492getLooseusljTpc())) {
                return 1;
            }
            if (LineBreak.Strictness.m3487equalsimpl0(i, companion.m3493getNormalusljTpc())) {
                return 2;
            }
            if (LineBreak.Strictness.m3487equalsimpl0(i, companion.m3494getStrictusljTpc())) {
                return 3;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutLineBreakWordStyle-wPN0Rpw, reason: not valid java name */
    public static final int m2984toLayoutLineBreakWordStylewPN0Rpw(int i) {
        LineBreak.WordBreak.Companion companion = LineBreak.WordBreak.Companion;
        return (!LineBreak.WordBreak.m3499equalsimpl0(i, companion.m3503getDefaultjp8hJ3c()) && LineBreak.WordBreak.m3499equalsimpl0(i, companion.m3504getPhrasejp8hJ3c())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > i) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        if (!z || TextUnit.m3840equalsimpl0(textStyle.m3171getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m3840equalsimpl0(textStyle.m3171getLetterSpacingXSAIIZE(), TextUnit.Companion.m3854getUnspecifiedXSAIIZE())) {
            return false;
        }
        int iM3176getTextAligne0LSkKk = textStyle.m3176getTextAligne0LSkKk();
        TextAlign.Companion companion = TextAlign.Companion;
        return (TextAlign.m3535equalsimpl0(iM3176getTextAligne0LSkKk, companion.m3545getUnspecifiede0LSkKk()) || TextAlign.m3535equalsimpl0(textStyle.m3176getTextAligne0LSkKk(), companion.m3544getStarte0LSkKk()) || TextAlign.m3535equalsimpl0(textStyle.m3176getTextAligne0LSkKk(), companion.m3541getJustifye0LSkKk())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutTextGranularity-duNsdkg, reason: not valid java name */
    public static final int m2985toLayoutTextGranularityduNsdkg(int i) {
        TextGranularity.Companion companion = TextGranularity.Companion;
        return (!TextGranularity.m3095equalsimpl0(i, companion.m3099getCharacterDRrd7Zo()) && TextGranularity.m3095equalsimpl0(i, companion.m3100getWordDRrd7Zo())) ? 1 : 0;
    }
}
