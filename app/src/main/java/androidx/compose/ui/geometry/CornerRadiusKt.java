package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;

/* JADX INFO: loaded from: classes4.dex */
public final class CornerRadiusKt {
    public static /* synthetic */ long CornerRadius$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        return CornerRadius(f, f2);
    }

    /* JADX INFO: renamed from: lerp-3Ry4LBc, reason: not valid java name */
    public static final long m914lerp3Ry4LBc(long j, long j2, float f) {
        return CornerRadius(MathHelpersKt.lerp(CornerRadius.m903getXimpl(j), CornerRadius.m903getXimpl(j2), f), MathHelpersKt.lerp(CornerRadius.m904getYimpl(j), CornerRadius.m904getYimpl(j2), f));
    }

    public static final long CornerRadius(float f, float f2) {
        return CornerRadius.m897constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32));
    }
}
