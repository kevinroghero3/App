package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class DpKt {
    /* JADX INFO: renamed from: getCenter-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m3677getCenterEaSLcWc$annotations(long j) {
    }

    public static /* synthetic */ void getDp$annotations(double d) {
    }

    public static /* synthetic */ void getDp$annotations(float f) {
    }

    public static /* synthetic */ void getDp$annotations(int i) {
    }

    public static /* synthetic */ void getHeight$annotations(DpRect dpRect) {
    }

    public static /* synthetic */ void getSize$annotations(DpRect dpRect) {
    }

    public static /* synthetic */ void getWidth$annotations(DpRect dpRect) {
    }

    /* JADX INFO: renamed from: isFinite-0680j_4, reason: not valid java name */
    public static final boolean m3678isFinite0680j_4(float f) {
        return !(f == Float.POSITIVE_INFINITY);
    }

    /* JADX INFO: renamed from: isFinite-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m3679isFinite0680j_4$annotations(float f) {
    }

    /* JADX INFO: renamed from: isSpecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m3681isSpecified0680j_4$annotations(float f) {
    }

    /* JADX INFO: renamed from: isSpecified-EaSLcWc, reason: not valid java name */
    public static final boolean m3682isSpecifiedEaSLcWc(long j) {
        return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: renamed from: isSpecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m3683isSpecifiedEaSLcWc$annotations(long j) {
    }

    /* JADX INFO: renamed from: isSpecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m3684isSpecifiedjoFl9I(long j) {
        return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: renamed from: isSpecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m3685isSpecifiedjoFl9I$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m3687isUnspecified0680j_4$annotations(float f) {
    }

    /* JADX INFO: renamed from: isUnspecified-EaSLcWc, reason: not valid java name */
    public static final boolean m3688isUnspecifiedEaSLcWc(long j) {
        return j == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: renamed from: isUnspecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m3689isUnspecifiedEaSLcWc$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m3690isUnspecifiedjoFl9I(long j) {
        return j == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: renamed from: isUnspecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m3691isUnspecifiedjoFl9I$annotations(long j) {
    }

    /* JADX INFO: renamed from: isSpecified-0680j_4, reason: not valid java name */
    public static final boolean m3680isSpecified0680j_4(float f) {
        return !Float.isNaN(f);
    }

    /* JADX INFO: renamed from: isUnspecified-0680j_4, reason: not valid java name */
    public static final boolean m3686isUnspecified0680j_4(float f) {
        return Float.isNaN(f);
    }

    public static final float getDp(int i) {
        return Dp.m3650constructorimpl(i);
    }

    public static final float getDp(double d) {
        return Dp.m3650constructorimpl((float) d);
    }

    public static final float getDp(float f) {
        return Dp.m3650constructorimpl(f);
    }

    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m3701times3ABfNKs(float f, float f2) {
        return Dp.m3650constructorimpl(f * f2);
    }

    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m3700times3ABfNKs(double d, float f) {
        return Dp.m3650constructorimpl(((float) d) * f);
    }

    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m3702times3ABfNKs(int i, float f) {
        return Dp.m3650constructorimpl(i * f);
    }

    /* JADX INFO: renamed from: min-YgX7TsA, reason: not valid java name */
    public static final float m3696minYgX7TsA(float f, float f2) {
        return Dp.m3650constructorimpl(Math.min(f, f2));
    }

    /* JADX INFO: renamed from: max-YgX7TsA, reason: not valid java name */
    public static final float m3695maxYgX7TsA(float f, float f2) {
        return Dp.m3650constructorimpl(Math.max(f, f2));
    }

    /* JADX INFO: renamed from: coerceIn-2z7ARbQ, reason: not valid java name */
    public static final float m3675coerceIn2z7ARbQ(float f, float f2, float f3) {
        return Dp.m3650constructorimpl(RangesKt___RangesKt.coerceIn(f, f2, f3));
    }

    /* JADX INFO: renamed from: coerceAtLeast-YgX7TsA, reason: not valid java name */
    public static final float m3673coerceAtLeastYgX7TsA(float f, float f2) {
        return Dp.m3650constructorimpl(RangesKt___RangesKt.coerceAtLeast(f, f2));
    }

    /* JADX INFO: renamed from: coerceAtMost-YgX7TsA, reason: not valid java name */
    public static final float m3674coerceAtMostYgX7TsA(float f, float f2) {
        return Dp.m3650constructorimpl(RangesKt___RangesKt.coerceAtMost(f, f2));
    }

    /* JADX INFO: renamed from: lerp-Md-fbLM, reason: not valid java name */
    public static final float m3693lerpMdfbLM(float f, float f2, float f3) {
        return Dp.m3650constructorimpl(MathHelpersKt.lerp(f, f2, f3));
    }

    /* JADX INFO: renamed from: takeOrElse-gVKV90s, reason: not valid java name */
    public static final long m3698takeOrElsegVKV90s(long j, @NotNull Function0<DpOffset> function0) {
        return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? j : function0.invoke().m3719unboximpl();
    }

    /* JADX INFO: renamed from: lerp-xhh869w, reason: not valid java name */
    public static final long m3694lerpxhh869w(long j, long j2, float f) {
        float fLerp = MathHelpersKt.lerp(DpOffset.m3711getXD9Ej5fM(j), DpOffset.m3711getXD9Ej5fM(j2), f);
        float fLerp2 = MathHelpersKt.lerp(DpOffset.m3713getYD9Ej5fM(j), DpOffset.m3713getYD9Ej5fM(j2), f);
        return DpOffset.m3706constructorimpl((((long) Float.floatToRawIntBits(fLerp)) << 32) | (((long) Float.floatToRawIntBits(fLerp2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: takeOrElse-itqla9I, reason: not valid java name */
    public static final long m3699takeOrElseitqla9I(long j, @NotNull Function0<DpSize> function0) {
        return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? j : function0.invoke().m3756unboximpl();
    }

    /* JADX INFO: renamed from: getCenter-EaSLcWc, reason: not valid java name */
    public static final long m3676getCenterEaSLcWc(long j) {
        float fM3650constructorimpl = Dp.m3650constructorimpl(DpSize.m3748getWidthD9Ej5fM(j) / 2.0f);
        return DpOffset.m3706constructorimpl((((long) Float.floatToRawIntBits(Dp.m3650constructorimpl(DpSize.m3746getHeightD9Ej5fM(j) / 2.0f))) & 4294967295L) | (((long) Float.floatToRawIntBits(fM3650constructorimpl)) << 32));
    }

    /* JADX INFO: renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m3704times6HolHcs(int i, long j) {
        return DpSize.m3754timesGh9hcWk(j, i);
    }

    /* JADX INFO: renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m3703times6HolHcs(float f, long j) {
        return DpSize.m3753timesGh9hcWk(j, f);
    }

    /* JADX INFO: renamed from: lerp-IDex15A, reason: not valid java name */
    public static final long m3692lerpIDex15A(long j, long j2, float f) {
        float fM3693lerpMdfbLM = m3693lerpMdfbLM(DpSize.m3748getWidthD9Ej5fM(j), DpSize.m3748getWidthD9Ej5fM(j2), f);
        float fM3693lerpMdfbLM2 = m3693lerpMdfbLM(DpSize.m3746getHeightD9Ej5fM(j), DpSize.m3746getHeightD9Ej5fM(j2), f);
        return DpSize.m3739constructorimpl((((long) Float.floatToRawIntBits(fM3693lerpMdfbLM)) << 32) | (((long) Float.floatToRawIntBits(fM3693lerpMdfbLM2)) & 4294967295L));
    }

    public static final float getWidth(@NotNull DpRect dpRect) {
        return Dp.m3650constructorimpl(dpRect.m3734getRightD9Ej5fM() - dpRect.m3733getLeftD9Ej5fM());
    }

    public static final float getHeight(@NotNull DpRect dpRect) {
        return Dp.m3650constructorimpl(dpRect.m3732getBottomD9Ej5fM() - dpRect.m3735getTopD9Ej5fM());
    }

    /* JADX INFO: renamed from: takeOrElse-D5KLDUw, reason: not valid java name */
    public static final float m3697takeOrElseD5KLDUw(float f, @NotNull Function0<Dp> function0) {
        return !Float.isNaN(f) ? f : function0.invoke().m3664unboximpl();
    }

    /* JADX INFO: renamed from: DpOffset-YgX7TsA, reason: not valid java name */
    public static final long m3671DpOffsetYgX7TsA(float f, float f2) {
        return DpOffset.m3706constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32));
    }

    /* JADX INFO: renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m3672DpSizeYgX7TsA(float f, float f2) {
        return DpSize.m3739constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32));
    }

    public static final long getSize(@NotNull DpRect dpRect) {
        return m3672DpSizeYgX7TsA(Dp.m3650constructorimpl(dpRect.m3734getRightD9Ej5fM() - dpRect.m3733getLeftD9Ej5fM()), Dp.m3650constructorimpl(dpRect.m3732getBottomD9Ej5fM() - dpRect.m3735getTopD9Ej5fM()));
    }
}
