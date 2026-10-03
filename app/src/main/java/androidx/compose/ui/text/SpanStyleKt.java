package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class SpanStyleKt {
    private static final long DefaultBackgroundColor;
    private static final long DefaultColor;
    private static final TextForegroundStyle DefaultColorForegroundStyle;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);

    public static final <T> T lerpDiscrete(T t, T t2, float f) {
        return ((double) f) < 0.5d ? t : t2;
    }

    static {
        Color.Companion companion = Color.Companion;
        DefaultBackgroundColor = companion.m1204getTransparent0d7_KjU();
        long jM1195getBlack0d7_KjU = companion.m1195getBlack0d7_KjU();
        DefaultColor = jM1195getBlack0d7_KjU;
        DefaultColorForegroundStyle = TextForegroundStyle.Companion.m3560from8_81llA(jM1195getBlack0d7_KjU);
    }

    /* JADX INFO: renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m3091lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        if (TextUnitKt.m3861isUnspecifiedR2X_6o(j) || TextUnitKt.m3861isUnspecifiedR2X_6o(j2)) {
            return ((TextUnit) lerpDiscrete(TextUnit.m3833boximpl(j), TextUnit.m3833boximpl(j2), f)).m3852unboximpl();
        }
        return TextUnitKt.m3863lerpC3pnCVY(j, j2, f);
    }

    public static final SpanStyle lerp(@NotNull SpanStyle spanStyle, @NotNull SpanStyle spanStyle2, float f) {
        TextForegroundStyle textForegroundStyleLerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle$ui_text_release(), spanStyle2.getTextForegroundStyle$ui_text_release(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f);
        long jM3091lerpTextUnitInheritableC3pnCVY = m3091lerpTextUnitInheritableC3pnCVY(spanStyle.m3086getFontSizeXSAIIZE(), spanStyle2.m3086getFontSizeXSAIIZE(), f);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeightLerp = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.m3087getFontStyle4Lr2A7w(), spanStyle2.m3087getFontStyle4Lr2A7w(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.m3088getFontSynthesisZQGJjVo(), spanStyle2.m3088getFontSynthesisZQGJjVo(), f);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f);
        long jM3091lerpTextUnitInheritableC3pnCVY2 = m3091lerpTextUnitInheritableC3pnCVY(spanStyle.m3089getLetterSpacingXSAIIZE(), spanStyle2.m3089getLetterSpacingXSAIIZE(), f);
        BaselineShift baselineShiftM3084getBaselineShift5SSeXJ0 = spanStyle.m3084getBaselineShift5SSeXJ0();
        float fM3429unboximpl = baselineShiftM3084getBaselineShift5SSeXJ0 != null ? baselineShiftM3084getBaselineShift5SSeXJ0.m3429unboximpl() : BaselineShift.m3424constructorimpl(0.0f);
        BaselineShift baselineShiftM3084getBaselineShift5SSeXJ1 = spanStyle2.m3084getBaselineShift5SSeXJ0();
        float fM3436lerpjWV1Mfo = BaselineShiftKt.m3436lerpjWV1Mfo(fM3429unboximpl, baselineShiftM3084getBaselineShift5SSeXJ1 != null ? baselineShiftM3084getBaselineShift5SSeXJ1.m3429unboximpl() : BaselineShift.m3424constructorimpl(0.0f), f);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransformLerp = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f);
        LocaleList localeList = (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f);
        long jM1220lerpjxsXWHM = ColorKt.m1220lerpjxsXWHM(spanStyle.m3083getBackground0d7_KjU(), spanStyle2.m3083getBackground0d7_KjU(), f);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        return new SpanStyle(textForegroundStyleLerp, jM3091lerpTextUnitInheritableC3pnCVY, fontWeightLerp, fontStyle, fontSynthesis, fontFamily, str, jM3091lerpTextUnitInheritableC3pnCVY2, BaselineShift.m3423boximpl(fM3436lerpjWV1Mfo), textGeometricTransformLerp, localeList, jM1220lerpjxsXWHM, textDecoration, ShadowKt.lerp(shadow, shadow2, f), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.Companion.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    public static final SpanStyle resolveSpanStyleDefaults(@NotNull SpanStyle spanStyle) {
        long jM3089getLetterSpacingXSAIIZE;
        TextForegroundStyle textForegroundStyleTakeOrElse = spanStyle.getTextForegroundStyle$ui_text_release().takeOrElse(new Function0<TextForegroundStyle>() { // from class: androidx.compose.ui.text.SpanStyleKt.resolveSpanStyleDefaults.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextForegroundStyle invoke() {
                return SpanStyleKt.DefaultColorForegroundStyle;
            }
        });
        long jM3086getFontSizeXSAIIZE = TextUnitKt.m3861isUnspecifiedR2X_6o(spanStyle.m3086getFontSizeXSAIIZE()) ? DefaultFontSize : spanStyle.m3086getFontSizeXSAIIZE();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyleM3087getFontStyle4Lr2A7w = spanStyle.m3087getFontStyle4Lr2A7w();
        FontStyle fontStyleM3242boximpl = FontStyle.m3242boximpl(fontStyleM3087getFontStyle4Lr2A7w != null ? fontStyleM3087getFontStyle4Lr2A7w.m3248unboximpl() : FontStyle.Companion.m3252getNormal_LCdwA());
        FontSynthesis fontSynthesisM3088getFontSynthesisZQGJjVo = spanStyle.m3088getFontSynthesisZQGJjVo();
        FontSynthesis fontSynthesisM3253boximpl = FontSynthesis.m3253boximpl(fontSynthesisM3088getFontSynthesisZQGJjVo != null ? fontSynthesisM3088getFontSynthesisZQGJjVo.m3261unboximpl() : FontSynthesis.Companion.m3262getAllGVVA2EU());
        FontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        if (TextUnitKt.m3861isUnspecifiedR2X_6o(spanStyle.m3089getLetterSpacingXSAIIZE())) {
            jM3089getLetterSpacingXSAIIZE = DefaultLetterSpacing;
        } else {
            jM3089getLetterSpacingXSAIIZE = spanStyle.m3089getLetterSpacingXSAIIZE();
        }
        long j = jM3089getLetterSpacingXSAIIZE;
        BaselineShift baselineShiftM3084getBaselineShift5SSeXJ0 = spanStyle.m3084getBaselineShift5SSeXJ0();
        BaselineShift baselineShiftM3423boximpl = BaselineShift.m3423boximpl(baselineShiftM3084getBaselineShift5SSeXJ0 != null ? baselineShiftM3084getBaselineShift5SSeXJ0.m3429unboximpl() : BaselineShift.Companion.m3433getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long jM3083getBackground0d7_KjU = spanStyle.m3083getBackground0d7_KjU();
        if (jM3083getBackground0d7_KjU == 16) {
            jM3083getBackground0d7_KjU = DefaultBackgroundColor;
        }
        long j2 = jM3083getBackground0d7_KjU;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = spanStyle.getPlatformStyle();
        DrawStyle drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(textForegroundStyleTakeOrElse, jM3086getFontSizeXSAIIZE, fontWeight2, fontStyleM3242boximpl, fontSynthesisM3253boximpl, fontFamily2, str, j, baselineShiftM3423boximpl, textGeometricTransform2, localeList2, j2, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        if (spanStyle.getPlatformStyle() == null) {
            return platformSpanStyle;
        }
        if (platformSpanStyle == null) {
            return spanStyle.getPlatformStyle();
        }
        return spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0033  */
    /* JADX INFO: renamed from: fastMerge-dSHsh3o, reason: not valid java name */
    public static final SpanStyle m3090fastMergedSHsh3o(@NotNull SpanStyle spanStyle, long j, @Nullable Brush brush, float f, long j2, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j3, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j4, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable PlatformSpanStyle platformSpanStyle, @Nullable DrawStyle drawStyle) {
        TextGeometricTransform textGeometricTransform2;
        long jM3083getBackground0d7_KjU;
        PlatformSpanStyle platformSpanStyle2;
        DrawStyle drawStyle2;
        TextForegroundStyle textForegroundStyleM3560from8_81llA;
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyleM3087getFontStyle4Lr2A7w = fontStyle;
        FontSynthesis fontSynthesisM3088getFontSynthesisZQGJjVo = fontSynthesis;
        String fontFeatureSettings = str;
        BaselineShift baselineShiftM3084getBaselineShift5SSeXJ0 = baselineShift;
        if (!TextUnitKt.m3861isUnspecifiedR2X_6o(j2) && !TextUnit.m3840equalsimpl0(j2, spanStyle.m3086getFontSizeXSAIIZE())) {
            textGeometricTransform2 = textGeometricTransform;
            jM3083getBackground0d7_KjU = j4;
            platformSpanStyle2 = platformSpanStyle;
            drawStyle2 = drawStyle;
        } else if ((brush != null || j == 16 || Color.m1170equalsimpl0(j, spanStyle.getTextForegroundStyle$ui_text_release().mo3437getColor0d7_KjU())) && ((fontStyleM3087getFontStyle4Lr2A7w == null || Intrinsics.areEqual(fontStyleM3087getFontStyle4Lr2A7w, spanStyle.m3087getFontStyle4Lr2A7w())) && ((fontWeight2 == null || Intrinsics.areEqual(fontWeight2, spanStyle.getFontWeight())) && ((fontFamily == null || fontFamily == spanStyle.getFontFamily()) && (TextUnitKt.m3861isUnspecifiedR2X_6o(j3) || TextUnit.m3840equalsimpl0(j3, spanStyle.m3089getLetterSpacingXSAIIZE())))))) {
            if ((textDecoration == null || Intrinsics.areEqual(textDecoration, spanStyle.getTextDecoration())) && Intrinsics.areEqual(brush, spanStyle.getTextForegroundStyle$ui_text_release().getBrush()) && ((brush == null || f == spanStyle.getTextForegroundStyle$ui_text_release().getAlpha()) && ((fontSynthesisM3088getFontSynthesisZQGJjVo == null || Intrinsics.areEqual(fontSynthesisM3088getFontSynthesisZQGJjVo, spanStyle.m3088getFontSynthesisZQGJjVo())) && ((fontFeatureSettings == null || Intrinsics.areEqual(fontFeatureSettings, spanStyle.getFontFeatureSettings())) && (baselineShiftM3084getBaselineShift5SSeXJ0 == null || Intrinsics.areEqual(baselineShiftM3084getBaselineShift5SSeXJ0, spanStyle.m3084getBaselineShift5SSeXJ0())))))) {
                textGeometricTransform2 = textGeometricTransform;
                if ((textGeometricTransform2 == null || Intrinsics.areEqual(textGeometricTransform2, spanStyle.getTextGeometricTransform())) && (localeList == null || Intrinsics.areEqual(localeList, spanStyle.getLocaleList()))) {
                    jM3083getBackground0d7_KjU = j4;
                    if ((jM3083getBackground0d7_KjU == 16 || Color.m1170equalsimpl0(jM3083getBackground0d7_KjU, spanStyle.m3083getBackground0d7_KjU())) && (shadow == null || Intrinsics.areEqual(shadow, spanStyle.getShadow()))) {
                        platformSpanStyle2 = platformSpanStyle;
                        if (platformSpanStyle2 == null || Intrinsics.areEqual(platformSpanStyle2, spanStyle.getPlatformStyle())) {
                            drawStyle2 = drawStyle;
                            if (drawStyle2 == null || Intrinsics.areEqual(drawStyle2, spanStyle.getDrawStyle())) {
                                return spanStyle;
                            }
                            spanStyle = spanStyle;
                        } else {
                            spanStyle = spanStyle;
                            drawStyle2 = drawStyle;
                        }
                    } else {
                        spanStyle = spanStyle;
                        platformSpanStyle2 = platformSpanStyle;
                        drawStyle2 = drawStyle;
                    }
                }
            } else {
                textGeometricTransform2 = textGeometricTransform;
            }
            jM3083getBackground0d7_KjU = j4;
            platformSpanStyle2 = platformSpanStyle;
            drawStyle2 = drawStyle;
        } else {
            textGeometricTransform2 = textGeometricTransform;
            jM3083getBackground0d7_KjU = j4;
            platformSpanStyle2 = platformSpanStyle;
            drawStyle2 = drawStyle;
        }
        if (brush != null) {
            textForegroundStyleM3560from8_81llA = TextForegroundStyle.Companion.from(brush, f);
        } else {
            textForegroundStyleM3560from8_81llA = TextForegroundStyle.Companion.m3560from8_81llA(j);
        }
        TextForegroundStyle textForegroundStyleMerge = spanStyle.getTextForegroundStyle$ui_text_release().merge(textForegroundStyleM3560from8_81llA);
        FontFamily fontFamily2 = fontFamily == null ? spanStyle.getFontFamily() : fontFamily;
        long jM3086getFontSizeXSAIIZE = !TextUnitKt.m3861isUnspecifiedR2X_6o(j2) ? j2 : spanStyle.m3086getFontSizeXSAIIZE();
        if (fontWeight2 == null) {
            fontWeight2 = spanStyle.getFontWeight();
        }
        if (fontStyleM3087getFontStyle4Lr2A7w == null) {
            fontStyleM3087getFontStyle4Lr2A7w = spanStyle.m3087getFontStyle4Lr2A7w();
        }
        if (fontSynthesisM3088getFontSynthesisZQGJjVo == null) {
            fontSynthesisM3088getFontSynthesisZQGJjVo = spanStyle.m3088getFontSynthesisZQGJjVo();
        }
        if (fontFeatureSettings == null) {
            fontFeatureSettings = spanStyle.getFontFeatureSettings();
        }
        long jM3089getLetterSpacingXSAIIZE = !TextUnitKt.m3861isUnspecifiedR2X_6o(j3) ? j3 : spanStyle.m3089getLetterSpacingXSAIIZE();
        if (baselineShiftM3084getBaselineShift5SSeXJ0 == null) {
            baselineShiftM3084getBaselineShift5SSeXJ0 = spanStyle.m3084getBaselineShift5SSeXJ0();
        }
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = spanStyle.getTextGeometricTransform();
        }
        LocaleList localeList2 = localeList == null ? spanStyle.getLocaleList() : localeList;
        if (jM3083getBackground0d7_KjU == 16) {
            jM3083getBackground0d7_KjU = spanStyle.m3083getBackground0d7_KjU();
        }
        TextDecoration textDecoration2 = textDecoration == null ? spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = shadow == null ? spanStyle.getShadow() : shadow;
        PlatformSpanStyle platformSpanStyleMergePlatformStyle = mergePlatformStyle(spanStyle, platformSpanStyle2);
        if (drawStyle2 == null) {
            drawStyle2 = spanStyle.getDrawStyle();
        }
        return new SpanStyle(textForegroundStyleMerge, jM3086getFontSizeXSAIIZE, fontWeight2, fontStyleM3087getFontStyle4Lr2A7w, fontSynthesisM3088getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, jM3089getLetterSpacingXSAIIZE, baselineShiftM3084getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, jM3083getBackground0d7_KjU, textDecoration2, shadow2, platformSpanStyleMergePlatformStyle, drawStyle2, (DefaultConstructorMarker) null);
    }
}
