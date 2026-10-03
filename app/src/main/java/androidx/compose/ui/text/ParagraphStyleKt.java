package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.Companion.m3854getUnspecifiedXSAIIZE();

    public static final ParagraphStyle lerp(@NotNull ParagraphStyle paragraphStyle, @NotNull ParagraphStyle paragraphStyle2, float f) {
        int iM3538unboximpl = ((TextAlign) SpanStyleKt.lerpDiscrete(TextAlign.m3532boximpl(paragraphStyle.m3041getTextAligne0LSkKk()), TextAlign.m3532boximpl(paragraphStyle2.m3041getTextAligne0LSkKk()), f)).m3538unboximpl();
        int iM3552unboximpl = ((TextDirection) SpanStyleKt.lerpDiscrete(TextDirection.m3546boximpl(paragraphStyle.m3043getTextDirections_7Xco()), TextDirection.m3546boximpl(paragraphStyle2.m3043getTextDirections_7Xco()), f)).m3552unboximpl();
        long jM3091lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m3091lerpTextUnitInheritableC3pnCVY(paragraphStyle.m3039getLineHeightXSAIIZE(), paragraphStyle2.m3039getLineHeightXSAIIZE(), f);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.Companion.getNone();
        }
        return new ParagraphStyle(iM3538unboximpl, iM3552unboximpl, jM3091lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, f), lerpPlatformStyle(paragraphStyle.getPlatformStyle(), paragraphStyle2.getPlatformStyle(), f), (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineHeightStyle(), paragraphStyle2.getLineHeightStyle(), f), ((LineBreak) SpanStyleKt.lerpDiscrete(LineBreak.m3452boximpl(paragraphStyle.m3038getLineBreakrAG3T2k()), LineBreak.m3452boximpl(paragraphStyle2.m3038getLineBreakrAG3T2k()), f)).m3464unboximpl(), ((Hyphens) SpanStyleKt.lerpDiscrete(Hyphens.m3442boximpl(paragraphStyle.m3036getHyphensvmbZdU8()), Hyphens.m3442boximpl(paragraphStyle2.m3036getHyphensvmbZdU8()), f)).m3448unboximpl(), (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextMotion(), paragraphStyle2.getTextMotion(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.Companion.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f);
    }

    public static final ParagraphStyle resolveParagraphStyleDefaults(@NotNull ParagraphStyle paragraphStyle, @NotNull LayoutDirection layoutDirection) {
        int iM3041getTextAligne0LSkKk = paragraphStyle.m3041getTextAligne0LSkKk();
        TextAlign.Companion companion = TextAlign.Companion;
        int iM3544getStarte0LSkKk = TextAlign.m3535equalsimpl0(iM3041getTextAligne0LSkKk, companion.m3545getUnspecifiede0LSkKk()) ? companion.m3544getStarte0LSkKk() : paragraphStyle.m3041getTextAligne0LSkKk();
        int iM3181resolveTextDirectionIhaHGbI = TextStyleKt.m3181resolveTextDirectionIhaHGbI(layoutDirection, paragraphStyle.m3043getTextDirections_7Xco());
        long jM3039getLineHeightXSAIIZE = TextUnitKt.m3861isUnspecifiedR2X_6o(paragraphStyle.m3039getLineHeightXSAIIZE()) ? DefaultLineHeight : paragraphStyle.m3039getLineHeightXSAIIZE();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = paragraphStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = paragraphStyle.getLineHeightStyle();
        int iM3038getLineBreakrAG3T2k = paragraphStyle.m3038getLineBreakrAG3T2k();
        LineBreak.Companion companion2 = LineBreak.Companion;
        int iM3471getSimplerAG3T2k = LineBreak.m3458equalsimpl0(iM3038getLineBreakrAG3T2k, companion2.m3472getUnspecifiedrAG3T2k()) ? companion2.m3471getSimplerAG3T2k() : paragraphStyle.m3038getLineBreakrAG3T2k();
        int iM3036getHyphensvmbZdU8 = paragraphStyle.m3036getHyphensvmbZdU8();
        Hyphens.Companion companion3 = Hyphens.Companion;
        int iM3450getNonevmbZdU8 = Hyphens.m3445equalsimpl0(iM3036getHyphensvmbZdU8, companion3.m3451getUnspecifiedvmbZdU8()) ? companion3.m3450getNonevmbZdU8() : paragraphStyle.m3036getHyphensvmbZdU8();
        TextMotion textMotion = paragraphStyle.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        return new ParagraphStyle(iM3544getStarte0LSkKk, iM3181resolveTextDirectionIhaHGbI, jM3039getLineHeightXSAIIZE, textIndent2, platformStyle, lineHeightStyle, iM3471getSimplerAG3T2k, iM3450getNonevmbZdU8, textMotion, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: fastMerge-j5T8yCg, reason: not valid java name */
    public static final ParagraphStyle m3044fastMergej5T8yCg(@NotNull ParagraphStyle paragraphStyle, int i, int i2, long j, @Nullable TextIndent textIndent, @Nullable PlatformParagraphStyle platformParagraphStyle, @Nullable LineHeightStyle lineHeightStyle, int i3, int i4, @Nullable TextMotion textMotion) {
        long j2;
        int iM3041getTextAligne0LSkKk = i;
        TextIndent textIndent2 = textIndent;
        TextAlign.Companion companion = TextAlign.Companion;
        if (TextAlign.m3535equalsimpl0(iM3041getTextAligne0LSkKk, companion.m3545getUnspecifiede0LSkKk()) || TextAlign.m3535equalsimpl0(iM3041getTextAligne0LSkKk, paragraphStyle.m3041getTextAligne0LSkKk())) {
            if (TextUnitKt.m3861isUnspecifiedR2X_6o(j)) {
                j2 = j;
            } else {
                j2 = j;
                if (TextUnit.m3840equalsimpl0(j2, paragraphStyle.m3039getLineHeightXSAIIZE())) {
                }
            }
            if ((textIndent2 == null || Intrinsics.areEqual(textIndent2, paragraphStyle.getTextIndent())) && ((TextDirection.m3549equalsimpl0(i2, TextDirection.Companion.m3558getUnspecifieds_7Xco()) || TextDirection.m3549equalsimpl0(i2, paragraphStyle.m3043getTextDirections_7Xco())) && ((platformParagraphStyle == null || Intrinsics.areEqual(platformParagraphStyle, paragraphStyle.getPlatformStyle())) && ((lineHeightStyle == null || Intrinsics.areEqual(lineHeightStyle, paragraphStyle.getLineHeightStyle())) && ((LineBreak.m3458equalsimpl0(i3, LineBreak.Companion.m3472getUnspecifiedrAG3T2k()) || LineBreak.m3458equalsimpl0(i3, paragraphStyle.m3038getLineBreakrAG3T2k())) && ((Hyphens.m3445equalsimpl0(i4, Hyphens.Companion.m3451getUnspecifiedvmbZdU8()) || Hyphens.m3445equalsimpl0(i4, paragraphStyle.m3036getHyphensvmbZdU8())) && (textMotion == null || Intrinsics.areEqual(textMotion, paragraphStyle.getTextMotion())))))))) {
                return paragraphStyle;
            }
        } else {
            j2 = j;
        }
        long jM3039getLineHeightXSAIIZE = TextUnitKt.m3861isUnspecifiedR2X_6o(j) ? paragraphStyle.m3039getLineHeightXSAIIZE() : j2;
        if (textIndent2 == null) {
            textIndent2 = paragraphStyle.getTextIndent();
        }
        TextIndent textIndent3 = textIndent2;
        if (TextAlign.m3535equalsimpl0(iM3041getTextAligne0LSkKk, companion.m3545getUnspecifiede0LSkKk())) {
            iM3041getTextAligne0LSkKk = paragraphStyle.m3041getTextAligne0LSkKk();
        }
        return new ParagraphStyle(iM3041getTextAligne0LSkKk, !TextDirection.m3549equalsimpl0(i2, TextDirection.Companion.m3558getUnspecifieds_7Xco()) ? i2 : paragraphStyle.m3043getTextDirections_7Xco(), jM3039getLineHeightXSAIIZE, textIndent3, mergePlatformStyle(paragraphStyle, platformParagraphStyle), lineHeightStyle == null ? paragraphStyle.getLineHeightStyle() : lineHeightStyle, !LineBreak.m3458equalsimpl0(i3, LineBreak.Companion.m3472getUnspecifiedrAG3T2k()) ? i3 : paragraphStyle.m3038getLineBreakrAG3T2k(), !Hyphens.m3445equalsimpl0(i4, Hyphens.Companion.m3451getUnspecifiedvmbZdU8()) ? i4 : paragraphStyle.m3036getHyphensvmbZdU8(), textMotion == null ? paragraphStyle.getTextMotion() : textMotion, (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle paragraphStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (paragraphStyle.getPlatformStyle() == null) {
            return platformParagraphStyle;
        }
        if (platformParagraphStyle == null) {
            return paragraphStyle.getPlatformStyle();
        }
        return paragraphStyle.getPlatformStyle().merge(platformParagraphStyle);
    }
}
