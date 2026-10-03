package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class TextPaintExtensions_androidKt {
    public static final float correctBlurRadius(float f) {
        if (f == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f;
    }

    public static /* synthetic */ SpanStyle applySpanStyle$default(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, Function4 function4, Density density, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return applySpanStyle(androidTextPaint, spanStyle, function4, density, z);
    }

    public static final SpanStyle applySpanStyle(@NotNull AndroidTextPaint androidTextPaint, @NotNull SpanStyle spanStyle, @NotNull Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4, @NotNull Density density, boolean z) {
        long jM3842getTypeUIouoOA = TextUnit.m3842getTypeUIouoOA(spanStyle.m3086getFontSizeXSAIIZE());
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3876getSpUIouoOA())) {
            androidTextPaint.setTextSize(density.mo2482toPxR2X_6o(spanStyle.m3086getFontSizeXSAIIZE()));
        } else if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3875getEmUIouoOA())) {
            androidTextPaint.setTextSize(androidTextPaint.getTextSize() * TextUnit.m3843getValueimpl(spanStyle.m3086getFontSizeXSAIIZE()));
        }
        if (hasFontAttributes(spanStyle)) {
            FontFamily fontFamily = spanStyle.getFontFamily();
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle fontStyleM3087getFontStyle4Lr2A7w = spanStyle.m3087getFontStyle4Lr2A7w();
            FontStyle fontStyleM3242boximpl = FontStyle.m3242boximpl(fontStyleM3087getFontStyle4Lr2A7w != null ? fontStyleM3087getFontStyle4Lr2A7w.m3248unboximpl() : FontStyle.Companion.m3252getNormal_LCdwA());
            FontSynthesis fontSynthesisM3088getFontSynthesisZQGJjVo = spanStyle.m3088getFontSynthesisZQGJjVo();
            androidTextPaint.setTypeface(function4.invoke(fontFamily, fontWeight, fontStyleM3242boximpl, FontSynthesis.m3253boximpl(fontSynthesisM3088getFontSynthesisZQGJjVo != null ? fontSynthesisM3088getFontSynthesisZQGJjVo.m3261unboximpl() : FontSynthesis.Companion.m3262getAllGVVA2EU())));
        }
        if (spanStyle.getLocaleList() != null && !Intrinsics.areEqual(spanStyle.getLocaleList(), LocaleList.Companion.getCurrent())) {
            LocaleListHelperMethods.INSTANCE.setTextLocales(androidTextPaint, spanStyle.getLocaleList());
        }
        if (spanStyle.getFontFeatureSettings() != null && !Intrinsics.areEqual(spanStyle.getFontFeatureSettings(), "")) {
            androidTextPaint.setFontFeatureSettings(spanStyle.getFontFeatureSettings());
        }
        if (spanStyle.getTextGeometricTransform() != null && !Intrinsics.areEqual(spanStyle.getTextGeometricTransform(), TextGeometricTransform.Companion.getNone$ui_text_release())) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * spanStyle.getTextGeometricTransform().getScaleX());
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + spanStyle.getTextGeometricTransform().getSkewX());
        }
        androidTextPaint.m3404setColor8_81llA(spanStyle.m3085getColor0d7_KjU());
        androidTextPaint.m3402setBrush12SF9DM(spanStyle.getBrush(), Size.Companion.m1005getUnspecifiedNHjbRc(), spanStyle.getAlpha());
        androidTextPaint.setShadow(spanStyle.getShadow());
        androidTextPaint.setTextDecoration(spanStyle.getTextDecoration());
        androidTextPaint.setDrawStyle(spanStyle.getDrawStyle());
        if (TextUnitType.m3871equalsimpl0(TextUnit.m3842getTypeUIouoOA(spanStyle.m3089getLetterSpacingXSAIIZE()), companion.m3876getSpUIouoOA()) && TextUnit.m3843getValueimpl(spanStyle.m3089getLetterSpacingXSAIIZE()) != 0.0f) {
            float textSize = androidTextPaint.getTextSize() * androidTextPaint.getTextScaleX();
            float fMo2482toPxR2X_6o = density.mo2482toPxR2X_6o(spanStyle.m3089getLetterSpacingXSAIIZE());
            if (textSize != 0.0f) {
                androidTextPaint.setLetterSpacing(fMo2482toPxR2X_6o / textSize);
            }
        } else if (TextUnitType.m3871equalsimpl0(TextUnit.m3842getTypeUIouoOA(spanStyle.m3089getLetterSpacingXSAIIZE()), companion.m3875getEmUIouoOA())) {
            androidTextPaint.setLetterSpacing(TextUnit.m3843getValueimpl(spanStyle.m3089getLetterSpacingXSAIIZE()));
        }
        return m3418generateFallbackSpanStyle62GTOB8(spanStyle.m3089getLetterSpacingXSAIIZE(), z, spanStyle.m3083getBackground0d7_KjU(), spanStyle.m3084getBaselineShift5SSeXJ0());
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004f  */
    /* JADX INFO: renamed from: generateFallbackSpanStyle-62GTOB8, reason: not valid java name */
    private static final SpanStyle m3418generateFallbackSpanStyle62GTOB8(long j, boolean z, long j2, BaselineShift baselineShift) {
        boolean z2;
        long jM1205getUnspecified0d7_KjU = j2;
        boolean z3 = z && TextUnitType.m3871equalsimpl0(TextUnit.m3842getTypeUIouoOA(j), TextUnitType.Companion.m3876getSpUIouoOA()) && TextUnit.m3843getValueimpl(j) != 0.0f;
        Color.Companion companion = Color.Companion;
        boolean z4 = (Color.m1170equalsimpl0(jM1205getUnspecified0d7_KjU, companion.m1205getUnspecified0d7_KjU()) || Color.m1170equalsimpl0(jM1205getUnspecified0d7_KjU, companion.m1204getTransparent0d7_KjU())) ? false : true;
        if (baselineShift != null) {
            z2 = BaselineShift.m3426equalsimpl0(baselineShift.m3429unboximpl(), BaselineShift.Companion.m3433getNoney9eOQZs()) ? false : true;
        }
        if (!z3 && !z4 && !z2) {
            return null;
        }
        long jM3854getUnspecifiedXSAIIZE = z3 ? j : TextUnit.Companion.m3854getUnspecifiedXSAIIZE();
        if (!z4) {
            jM1205getUnspecified0d7_KjU = companion.m1205getUnspecified0d7_KjU();
        }
        return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, jM3854getUnspecifiedXSAIIZE, z2 ? baselineShift : null, (TextGeometricTransform) null, (LocaleList) null, jM1205getUnspecified0d7_KjU, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 63103, (DefaultConstructorMarker) null);
    }

    public static final void setTextMotion(@NotNull AndroidTextPaint androidTextPaint, @Nullable TextMotion textMotion) {
        int flags;
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        if (textMotion.getSubpixelTextPositioning$ui_text_release()) {
            flags = androidTextPaint.getFlags() | 128;
        } else {
            flags = androidTextPaint.getFlags() & (-129);
        }
        androidTextPaint.setFlags(flags);
        int iM3567getLinearity4e0Vf04$ui_text_release = textMotion.m3567getLinearity4e0Vf04$ui_text_release();
        TextMotion.Linearity.Companion companion = TextMotion.Linearity.Companion;
        if (TextMotion.Linearity.m3571equalsimpl0(iM3567getLinearity4e0Vf04$ui_text_release, companion.m3576getLinear4e0Vf04())) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (TextMotion.Linearity.m3571equalsimpl0(iM3567getLinearity4e0Vf04$ui_text_release, companion.m3575getFontHinting4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (TextMotion.Linearity.m3571equalsimpl0(iM3567getLinearity4e0Vf04$ui_text_release, companion.m3577getNone4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        } else {
            androidTextPaint.getFlags();
        }
    }

    public static final boolean hasFontAttributes(@NotNull SpanStyle spanStyle) {
        return (spanStyle.getFontFamily() == null && spanStyle.m3087getFontStyle4Lr2A7w() == null && spanStyle.getFontWeight() == null) ? false : true;
    }
}
