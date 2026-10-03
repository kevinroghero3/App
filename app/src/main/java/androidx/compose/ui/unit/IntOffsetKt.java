package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;

/* JADX INFO: loaded from: classes.dex */
public final class IntOffsetKt {
    public static final long IntOffset(int i, int i2) {
        return IntOffset.m3772constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
    }

    /* JADX INFO: renamed from: lerp-81ZRxRo, reason: not valid java name */
    public static final long m3789lerp81ZRxRo(long j, long j2, float f) {
        return IntOffset.m3772constructorimpl((((long) MathHelpersKt.lerp(IntOffset.m3778getXimpl(j), IntOffset.m3778getXimpl(j2), f)) << 32) | (((long) MathHelpersKt.lerp(IntOffset.m3779getYimpl(j), IntOffset.m3779getYimpl(j2), f)) & 4294967295L));
    }

    /* JADX INFO: renamed from: toOffset--gyyYBs, reason: not valid java name */
    public static final long m3795toOffsetgyyYBs(long j) {
        return OffsetKt.Offset(IntOffset.m3778getXimpl(j), IntOffset.m3779getYimpl(j));
    }

    /* JADX INFO: renamed from: plus-Nv-tHpc, reason: not valid java name */
    public static final long m3792plusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.m928getXimpl(j) + IntOffset.m3778getXimpl(j2), Offset.m929getYimpl(j) + IntOffset.m3779getYimpl(j2));
    }

    /* JADX INFO: renamed from: minus-Nv-tHpc, reason: not valid java name */
    public static final long m3790minusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.m928getXimpl(j) - IntOffset.m3778getXimpl(j2), Offset.m929getYimpl(j) - IntOffset.m3779getYimpl(j2));
    }

    /* JADX INFO: renamed from: plus-oCl6YwE, reason: not valid java name */
    public static final long m3793plusoCl6YwE(long j, long j2) {
        return OffsetKt.Offset(IntOffset.m3778getXimpl(j) + Offset.m928getXimpl(j2), IntOffset.m3779getYimpl(j) + Offset.m929getYimpl(j2));
    }

    /* JADX INFO: renamed from: minus-oCl6YwE, reason: not valid java name */
    public static final long m3791minusoCl6YwE(long j, long j2) {
        return OffsetKt.Offset(IntOffset.m3778getXimpl(j) - Offset.m928getXimpl(j2), IntOffset.m3779getYimpl(j) - Offset.m929getYimpl(j2));
    }

    /* JADX INFO: renamed from: round-k-4lQ0M, reason: not valid java name */
    public static final long m3794roundk4lQ0M(long j) {
        return IntOffset.m3772constructorimpl((((long) Math.round(Offset.m929getYimpl(j))) & 4294967295L) | (((long) Math.round(Offset.m928getXimpl(j))) << 32));
    }
}
