package androidx.compose.ui.unit;

import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface FontScaling {
    float getFontScale();

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3762toSp0xMU5do(@NotNull FontScaling fontScaling, float f) {
            return FontScaling.super.mo2485toSp0xMU5do(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3761toDpGaN1DYA(@NotNull FontScaling fontScaling, long j) {
            return FontScaling.super.mo2478toDpGaN1DYA(j);
        }
    }

    /* JADX INFO: renamed from: toSp-0xMU5do */
    default long mo2485toSp0xMU5do(float f) {
        FontScaleConverterFactory fontScaleConverterFactory = FontScaleConverterFactory.INSTANCE;
        if (!fontScaleConverterFactory.isNonLinearFontScalingActive(getFontScale())) {
            return TextUnitKt.getSp(f / getFontScale());
        }
        FontScaleConverter fontScaleConverterForScale = fontScaleConverterFactory.forScale(getFontScale());
        return TextUnitKt.getSp(fontScaleConverterForScale != null ? fontScaleConverterForScale.convertDpToSp(f) : f / getFontScale());
    }

    /* JADX INFO: renamed from: toDp-GaN1DYA */
    default float mo2478toDpGaN1DYA(long j) {
        if (!TextUnitType.m3871equalsimpl0(TextUnit.m3842getTypeUIouoOA(j), TextUnitType.Companion.m3876getSpUIouoOA())) {
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        }
        FontScaleConverterFactory fontScaleConverterFactory = FontScaleConverterFactory.INSTANCE;
        if (!fontScaleConverterFactory.isNonLinearFontScalingActive(getFontScale())) {
            return Dp.m3650constructorimpl(TextUnit.m3843getValueimpl(j) * getFontScale());
        }
        FontScaleConverter fontScaleConverterForScale = fontScaleConverterFactory.forScale(getFontScale());
        float fM3843getValueimpl = TextUnit.m3843getValueimpl(j);
        return Dp.m3650constructorimpl(fontScaleConverterForScale == null ? fM3843getValueimpl * getFontScale() : fontScaleConverterForScale.convertSpToDp(fM3843getValueimpl));
    }
}
