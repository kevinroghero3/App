package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface Density extends FontScaling {
    float getDensity();

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3638toDpGaN1DYA(@NotNull Density density, long j) {
            return Density.super.mo2478toDpGaN1DYA(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3645toSp0xMU5do(@NotNull Density density, float f) {
            return Density.super.mo2485toSp0xMU5do(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m3643toPx0680j_4(@NotNull Density density, float f) {
            return Density.super.mo2483toPx0680j_4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m3637roundToPx0680j_4(@NotNull Density density, float f) {
            return Density.super.mo2477roundToPx0680j_4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m3642toPxR2X_6o(@NotNull Density density, long j) {
            return Density.super.mo2482toPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m3636roundToPxR2X_6o(@NotNull Density density, long j) {
            return Density.super.mo2476roundToPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3640toDpu2uoSUM(@NotNull Density density, int i) {
            return Density.super.mo2480toDpu2uoSUM(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3647toSpkPz2Gy4(@NotNull Density density, int i) {
            return Density.super.mo2487toSpkPz2Gy4(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3639toDpu2uoSUM(@NotNull Density density, float f) {
            return Density.super.mo2479toDpu2uoSUM(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3646toSpkPz2Gy4(@NotNull Density density, float f) {
            return Density.super.mo2486toSpkPz2Gy4(f);
        }

        @Deprecated
        public static Rect toRect(@NotNull Density density, @NotNull DpRect dpRect) {
            return Density.super.toRect(dpRect);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m3644toSizeXkaWNTQ(@NotNull Density density, long j) {
            return Density.super.mo2484toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3641toDpSizekrfVVM(@NotNull Density density, long j) {
            return Density.super.mo2481toDpSizekrfVVM(j);
        }
    }

    /* JADX INFO: renamed from: toPx-0680j_4 */
    default float mo2483toPx0680j_4(float f) {
        return f * getDensity();
    }

    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    default int mo2477roundToPx0680j_4(float f) {
        float fMo2483toPx0680j_4 = mo2483toPx0680j_4(f);
        if (Float.isInfinite(fMo2483toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(fMo2483toPx0680j_4);
    }

    /* JADX INFO: renamed from: toPx--R2X_6o */
    default float mo2482toPxR2X_6o(long j) {
        if (!TextUnitType.m3871equalsimpl0(TextUnit.m3842getTypeUIouoOA(j), TextUnitType.Companion.m3876getSpUIouoOA())) {
            throw new IllegalStateException("Only Sp can convert to Px");
        }
        return mo2483toPx0680j_4(mo2478toDpGaN1DYA(j));
    }

    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    default int mo2476roundToPxR2X_6o(long j) {
        return Math.round(mo2482toPxR2X_6o(j));
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo2480toDpu2uoSUM(int i) {
        return Dp.m3650constructorimpl(i / getDensity());
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo2487toSpkPz2Gy4(int i) {
        return mo2485toSp0xMU5do(mo2480toDpu2uoSUM(i));
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo2479toDpu2uoSUM(float f) {
        return Dp.m3650constructorimpl(f / getDensity());
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo2486toSpkPz2Gy4(float f) {
        return mo2485toSp0xMU5do(mo2479toDpu2uoSUM(f));
    }

    default Rect toRect(@NotNull DpRect dpRect) {
        return new Rect(mo2483toPx0680j_4(dpRect.m3733getLeftD9Ej5fM()), mo2483toPx0680j_4(dpRect.m3735getTopD9Ej5fM()), mo2483toPx0680j_4(dpRect.m3734getRightD9Ej5fM()), mo2483toPx0680j_4(dpRect.m3732getBottomD9Ej5fM()));
    }

    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    default long mo2484toSizeXkaWNTQ(long j) {
        if (j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            return SizeKt.Size(mo2483toPx0680j_4(DpSize.m3748getWidthD9Ej5fM(j)), mo2483toPx0680j_4(DpSize.m3746getHeightD9Ej5fM(j)));
        }
        return Size.Companion.m1005getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    default long mo2481toDpSizekrfVVM(long j) {
        if (j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            return DpKt.m3672DpSizeYgX7TsA(mo2479toDpu2uoSUM(Size.m997getWidthimpl(j)), mo2479toDpu2uoSUM(Size.m994getHeightimpl(j)));
        }
        return DpSize.Companion.m3757getUnspecifiedMYxV2XQ();
    }
}
