package androidx.compose.ui.unit;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface FontScalingLinear {
    float getFontScale();

    public static final class DefaultImpls {
        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3768toSp0xMU5do(@NotNull FontScalingLinear fontScalingLinear, float f) {
            return FontScalingLinear.super.m3766toSp0xMU5do(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3767toDpGaN1DYA(@NotNull FontScalingLinear fontScalingLinear, long j) {
            return FontScalingLinear.super.m3765toDpGaN1DYA(j);
        }
    }

    /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
    default long m3766toSp0xMU5do(float f) {
        return TextUnitKt.getSp(f / getFontScale());
    }

    /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
    default float m3765toDpGaN1DYA(long j) {
        if (!TextUnitType.m3871equalsimpl0(TextUnit.m3842getTypeUIouoOA(j), TextUnitType.Companion.m3876getSpUIouoOA())) {
            throw new IllegalStateException("Only Sp can convert to Px");
        }
        return Dp.m3650constructorimpl(TextUnit.m3843getValueimpl(j) * getFontScale());
    }
}
