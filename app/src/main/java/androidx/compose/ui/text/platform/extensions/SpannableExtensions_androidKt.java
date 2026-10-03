package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.DrawStyleSpan;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class SpannableExtensions_androidKt {
    public static final void setSpan(@NotNull Spannable spannable, @NotNull Object obj, int i, int i2) {
        spannable.setSpan(obj, i, i2, 33);
    }

    public static final void setTextIndent(@NotNull Spannable spannable, @Nullable TextIndent textIndent, float f, @NotNull Density density) {
        float fM3843getValueimpl;
        if (textIndent != null) {
            if ((TextUnit.m3840equalsimpl0(textIndent.m3563getFirstLineXSAIIZE(), TextUnitKt.getSp(0)) && TextUnit.m3840equalsimpl0(textIndent.m3564getRestLineXSAIIZE(), TextUnitKt.getSp(0))) || TextUnitKt.m3861isUnspecifiedR2X_6o(textIndent.m3563getFirstLineXSAIIZE()) || TextUnitKt.m3861isUnspecifiedR2X_6o(textIndent.m3564getRestLineXSAIIZE())) {
                return;
            }
            long jM3842getTypeUIouoOA = TextUnit.m3842getTypeUIouoOA(textIndent.m3563getFirstLineXSAIIZE());
            TextUnitType.Companion companion = TextUnitType.Companion;
            float fM3843getValueimpl2 = 0.0f;
            if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3876getSpUIouoOA())) {
                fM3843getValueimpl = density.mo2482toPxR2X_6o(textIndent.m3563getFirstLineXSAIIZE());
            } else {
                fM3843getValueimpl = TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3875getEmUIouoOA()) ? TextUnit.m3843getValueimpl(textIndent.m3563getFirstLineXSAIIZE()) * f : 0.0f;
            }
            long jM3842getTypeUIouoOA2 = TextUnit.m3842getTypeUIouoOA(textIndent.m3564getRestLineXSAIIZE());
            if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA2, companion.m3876getSpUIouoOA())) {
                fM3843getValueimpl2 = density.mo2482toPxR2X_6o(textIndent.m3564getRestLineXSAIIZE());
            } else if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA2, companion.m3875getEmUIouoOA())) {
                fM3843getValueimpl2 = TextUnit.m3843getValueimpl(textIndent.m3564getRestLineXSAIIZE()) * f;
            }
            setSpan(spannable, new LeadingMarginSpan.Standard((int) Math.ceil(fM3843getValueimpl), (int) Math.ceil(fM3843getValueimpl2)), 0, spannable.length());
        }
    }

    /* JADX INFO: renamed from: setLineHeight-KmRG4DE, reason: not valid java name */
    public static final void m3416setLineHeightKmRG4DE(@NotNull Spannable spannable, long j, float f, @NotNull Density density, @NotNull LineHeightStyle lineHeightStyle) {
        float fM3411resolveLineHeightInPxo2QH7mI = m3411resolveLineHeightInPxo2QH7mI(j, f, density);
        if (Float.isNaN(fM3411resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(spannable, new LineHeightStyleSpan(fM3411resolveLineHeightInPxo2QH7mI, 0, (spannable.length() == 0 || StringsKt___StringsKt.last(spannable) == '\n') ? spannable.length() + 1 : spannable.length(), LineHeightStyle.Trim.m3524isTrimFirstLineTopimpl$ui_text_release(lineHeightStyle.m3507getTrimEVpEnUU()), LineHeightStyle.Trim.m3525isTrimLastLineBottomimpl$ui_text_release(lineHeightStyle.m3507getTrimEVpEnUU()), lineHeightStyle.m3506getAlignmentPIaL0Z0()), 0, spannable.length());
    }

    /* JADX INFO: renamed from: setLineHeight-r9BaKPg, reason: not valid java name */
    public static final void m3417setLineHeightr9BaKPg(@NotNull Spannable spannable, long j, float f, @NotNull Density density) {
        float fM3411resolveLineHeightInPxo2QH7mI = m3411resolveLineHeightInPxo2QH7mI(j, f, density);
        if (Float.isNaN(fM3411resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(spannable, new LineHeightSpan(fM3411resolveLineHeightInPxo2QH7mI), 0, spannable.length());
    }

    /* JADX INFO: renamed from: resolveLineHeightInPx-o2QH7mI, reason: not valid java name */
    private static final float m3411resolveLineHeightInPxo2QH7mI(long j, float f, Density density) {
        float fM3843getValueimpl;
        long jM3842getTypeUIouoOA = TextUnit.m3842getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3876getSpUIouoOA())) {
            if (!isNonLinearFontScalingActive(density)) {
                return density.mo2482toPxR2X_6o(j);
            }
            fM3843getValueimpl = TextUnit.m3843getValueimpl(j) / TextUnit.m3843getValueimpl(density.mo2486toSpkPz2Gy4(f));
        } else {
            if (!TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3875getEmUIouoOA())) {
                return Float.NaN;
            }
            fM3843getValueimpl = TextUnit.m3843getValueimpl(j);
        }
        return fM3843getValueimpl * f;
    }

    private static final boolean isNonLinearFontScalingActive(Density density) {
        return ((double) density.getFontScale()) > 1.05d;
    }

    public static final void setSpanStyles(@NotNull Spannable spannable, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull Density density, @NotNull Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        MetricAffectingSpan metricAffectingSpanM3410createLetterSpacingSpaneAf_CNQ;
        setFontAttributes(spannable, textStyle, list, function4);
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i);
            int start = range.getStart();
            int end = range.getEnd();
            if (start >= 0 && start < spannable.length() && end > start && end <= spannable.length()) {
                setSpanStyle(spannable, range, density);
                if (getNeedsLetterSpacingSpan(range.getItem())) {
                    z = true;
                }
            }
        }
        if (z) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                AnnotatedString.Range<SpanStyle> range2 = list.get(i2);
                int start2 = range2.getStart();
                int end2 = range2.getEnd();
                SpanStyle item = range2.getItem();
                if (start2 >= 0 && start2 < spannable.length() && end2 > start2 && end2 <= spannable.length() && (metricAffectingSpanM3410createLetterSpacingSpaneAf_CNQ = m3410createLetterSpacingSpaneAf_CNQ(item.m3089getLetterSpacingXSAIIZE(), density)) != null) {
                    setSpan(spannable, metricAffectingSpanM3410createLetterSpacingSpaneAf_CNQ, start2, end2);
                }
            }
        }
    }

    private static final void setSpanStyle(Spannable spannable, AnnotatedString.Range<SpanStyle> range, Density density) {
        int start = range.getStart();
        int end = range.getEnd();
        SpanStyle item = range.getItem();
        m3413setBaselineShift0ocSgnM(spannable, item.m3084getBaselineShift5SSeXJ0(), start, end);
        m3414setColorRPmYEkk(spannable, item.m3085getColor0d7_KjU(), start, end);
        setBrush(spannable, item.getBrush(), item.getAlpha(), start, end);
        setTextDecoration(spannable, item.getTextDecoration(), start, end);
        m3415setFontSizeKmRG4DE(spannable, item.m3086getFontSizeXSAIIZE(), density, start, end);
        setFontFeatureSettings(spannable, item.getFontFeatureSettings(), start, end);
        setGeometricTransform(spannable, item.getTextGeometricTransform(), start, end);
        setLocaleList(spannable, item.getLocaleList(), start, end);
        m3412setBackgroundRPmYEkk(spannable, item.m3083getBackground0d7_KjU(), start, end);
        setShadow(spannable, item.getShadow(), start, end);
        setDrawStyle(spannable, item.getDrawStyle(), start, end);
    }

    public static final void flattenFontStylesAndApply(@Nullable SpanStyle spanStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull Function3<? super SpanStyle, ? super Integer, ? super Integer, Unit> function3) {
        if (list.size() <= 1) {
            if (list.isEmpty()) {
                return;
            }
            function3.invoke(merge(spanStyle, list.get(0).getItem()), Integer.valueOf(list.get(0).getStart()), Integer.valueOf(list.get(0).getEnd()));
            return;
        }
        int size = list.size();
        int i = size * 2;
        Integer[] numArr = new Integer[i];
        for (int i2 = 0; i2 < i; i2++) {
            numArr[i2] = 0;
        }
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i3);
            numArr[i3] = Integer.valueOf(range.getStart());
            numArr[i3 + size] = Integer.valueOf(range.getEnd());
        }
        ArraysKt___ArraysJvmKt.sort((Object[]) numArr);
        int iIntValue = ((Number) ArraysKt___ArraysKt.first(numArr)).intValue();
        for (int i4 = 0; i4 < i; i4++) {
            Integer num = numArr[i4];
            int iIntValue2 = num.intValue();
            if (iIntValue2 != iIntValue) {
                int size3 = list.size();
                SpanStyle spanStyleMerge = spanStyle;
                for (int i5 = 0; i5 < size3; i5++) {
                    AnnotatedString.Range<SpanStyle> range2 = list.get(i5);
                    if (range2.getStart() != range2.getEnd() && AnnotatedStringKt.intersect(iIntValue, iIntValue2, range2.getStart(), range2.getEnd())) {
                        spanStyleMerge = merge(spanStyleMerge, range2.getItem());
                    }
                }
                if (spanStyleMerge != null) {
                    function3.invoke(spanStyleMerge, Integer.valueOf(iIntValue), num);
                }
                iIntValue = iIntValue2;
            }
        }
    }

    /* JADX INFO: renamed from: createLetterSpacingSpan-eAf_CNQ, reason: not valid java name */
    private static final MetricAffectingSpan m3410createLetterSpacingSpaneAf_CNQ(long j, Density density) {
        long jM3842getTypeUIouoOA = TextUnit.m3842getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3876getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.mo2482toPxR2X_6o(j));
        }
        if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3875getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.m3843getValueimpl(j));
        }
        return null;
    }

    private static final boolean getNeedsLetterSpacingSpan(SpanStyle spanStyle) {
        long jM3842getTypeUIouoOA = TextUnit.m3842getTypeUIouoOA(spanStyle.m3089getLetterSpacingXSAIIZE());
        TextUnitType.Companion companion = TextUnitType.Companion;
        return TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3876getSpUIouoOA()) || TextUnitType.m3871equalsimpl0(TextUnit.m3842getTypeUIouoOA(spanStyle.m3089getLetterSpacingXSAIIZE()), companion.m3875getEmUIouoOA());
    }

    private static final void setShadow(Spannable spannable, Shadow shadow, int i, int i2) {
        if (shadow != null) {
            setSpan(spannable, new ShadowSpan(ColorKt.m1223toArgb8_81llA(shadow.m1496getColor0d7_KjU()), Offset.m928getXimpl(shadow.m1497getOffsetF1C5BW0()), Offset.m929getYimpl(shadow.m1497getOffsetF1C5BW0()), TextPaintExtensions_androidKt.correctBlurRadius(shadow.getBlurRadius())), i, i2);
        }
    }

    private static final void setDrawStyle(Spannable spannable, DrawStyle drawStyle, int i, int i2) {
        if (drawStyle != null) {
            setSpan(spannable, new DrawStyleSpan(drawStyle), i, i2);
        }
    }

    /* JADX INFO: renamed from: setBackground-RPmYEkk, reason: not valid java name */
    public static final void m3412setBackgroundRPmYEkk(@NotNull Spannable spannable, long j, int i, int i2) {
        if (j != 16) {
            setSpan(spannable, new BackgroundColorSpan(ColorKt.m1223toArgb8_81llA(j)), i, i2);
        }
    }

    public static final void setLocaleList(@NotNull Spannable spannable, @Nullable LocaleList localeList, int i, int i2) {
        if (localeList != null) {
            setSpan(spannable, LocaleListHelperMethods.INSTANCE.localeSpan(localeList), i, i2);
        }
    }

    private static final void setGeometricTransform(Spannable spannable, TextGeometricTransform textGeometricTransform, int i, int i2) {
        if (textGeometricTransform != null) {
            setSpan(spannable, new ScaleXSpan(textGeometricTransform.getScaleX()), i, i2);
            setSpan(spannable, new SkewXSpan(textGeometricTransform.getSkewX()), i, i2);
        }
    }

    private static final void setFontFeatureSettings(Spannable spannable, String str, int i, int i2) {
        if (str != null) {
            setSpan(spannable, new FontFeatureSpan(str), i, i2);
        }
    }

    /* JADX INFO: renamed from: setFontSize-KmRG4DE, reason: not valid java name */
    public static final void m3415setFontSizeKmRG4DE(@NotNull Spannable spannable, long j, @NotNull Density density, int i, int i2) {
        long jM3842getTypeUIouoOA = TextUnit.m3842getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3876getSpUIouoOA())) {
            setSpan(spannable, new AbsoluteSizeSpan(MathKt__MathJVMKt.roundToInt(density.mo2482toPxR2X_6o(j)), false), i, i2);
        } else if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3875getEmUIouoOA())) {
            setSpan(spannable, new RelativeSizeSpan(TextUnit.m3843getValueimpl(j)), i, i2);
        }
    }

    public static final void setTextDecoration(@NotNull Spannable spannable, @Nullable TextDecoration textDecoration, int i, int i2) {
        if (textDecoration != null) {
            TextDecoration.Companion companion = TextDecoration.Companion;
            setSpan(spannable, new TextDecorationSpan(textDecoration.contains(companion.getUnderline()), textDecoration.contains(companion.getLineThrough())), i, i2);
        }
    }

    /* JADX INFO: renamed from: setColor-RPmYEkk, reason: not valid java name */
    public static final void m3414setColorRPmYEkk(@NotNull Spannable spannable, long j, int i, int i2) {
        if (j != 16) {
            setSpan(spannable, new ForegroundColorSpan(ColorKt.m1223toArgb8_81llA(j)), i, i2);
        }
    }

    /* JADX INFO: renamed from: setBaselineShift-0ocSgnM, reason: not valid java name */
    private static final void m3413setBaselineShift0ocSgnM(Spannable spannable, BaselineShift baselineShift, int i, int i2) {
        if (baselineShift != null) {
            setSpan(spannable, new BaselineShiftSpan(baselineShift.m3429unboximpl()), i, i2);
        }
    }

    private static final void setBrush(Spannable spannable, Brush brush, float f, int i, int i2) {
        if (brush != null) {
            if (brush instanceof SolidColor) {
                m3414setColorRPmYEkk(spannable, ((SolidColor) brush).m1506getValue0d7_KjU(), i, i2);
            } else if (brush instanceof ShaderBrush) {
                setSpan(spannable, new ShaderBrushSpan((ShaderBrush) brush, f), i, i2);
            }
        }
    }

    private static final boolean hasFontAttributes(TextStyle textStyle) {
        return TextPaintExtensions_androidKt.hasFontAttributes(textStyle.toSpanStyle()) || textStyle.m3168getFontSynthesisZQGJjVo() != null;
    }

    private static final SpanStyle merge(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.merge(spanStyle2);
    }

    private static final void setFontAttributes(final Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, final Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i);
            AnnotatedString.Range<SpanStyle> range2 = range;
            if (TextPaintExtensions_androidKt.hasFontAttributes(range2.getItem()) || range2.getItem().m3088getFontSynthesisZQGJjVo() != null) {
                arrayList.add(range);
            }
        }
        flattenFontStylesAndApply(hasFontAttributes(textStyle) ? new SpanStyle(0L, 0L, textStyle.getFontWeight(), textStyle.m3167getFontStyle4Lr2A7w(), textStyle.m3168getFontSynthesisZQGJjVo(), textStyle.getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65475, (DefaultConstructorMarker) null) : null, arrayList, new Function3<SpanStyle, Integer, Integer, Unit>() { // from class: androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt.setFontAttributes.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* synthetic */ Unit invoke(SpanStyle spanStyle, Integer num, Integer num2) {
                invoke(spanStyle, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SpanStyle spanStyle, int i2, int i3) {
                Spannable spannable2 = spannable;
                Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> function5 = function4;
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontWeight fontWeight = spanStyle.getFontWeight();
                if (fontWeight == null) {
                    fontWeight = FontWeight.Companion.getNormal();
                }
                FontStyle fontStyleM3087getFontStyle4Lr2A7w = spanStyle.m3087getFontStyle4Lr2A7w();
                FontStyle fontStyleM3242boximpl = FontStyle.m3242boximpl(fontStyleM3087getFontStyle4Lr2A7w != null ? fontStyleM3087getFontStyle4Lr2A7w.m3248unboximpl() : FontStyle.Companion.m3252getNormal_LCdwA());
                FontSynthesis fontSynthesisM3088getFontSynthesisZQGJjVo = spanStyle.m3088getFontSynthesisZQGJjVo();
                spannable2.setSpan(new TypefaceSpan(function5.invoke(fontFamily, fontWeight, fontStyleM3242boximpl, FontSynthesis.m3253boximpl(fontSynthesisM3088getFontSynthesisZQGJjVo != null ? fontSynthesisM3088getFontSynthesisZQGJjVo.m3261unboximpl() : FontSynthesis.Companion.m3262getAllGVVA2EU()))), i2, i3, 33);
            }
        });
    }
}
