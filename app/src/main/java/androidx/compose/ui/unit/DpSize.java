package androidx.compose.ui.unit;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@JvmInline
public final class DpSize {
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m3739constructorimpl(0);
    private static final long Unspecified = m3739constructorimpl(androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpSize m3736boximpl(long j) {
        return new DpSize(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3739constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3744equalsimpl(long j, Object obj) {
        return (obj instanceof DpSize) && j == ((DpSize) obj).m3756unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3745equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3747getHeightD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3749getWidthD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3750hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m3744equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3750hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3756unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ DpSize(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: copy-DwJknco$default, reason: not valid java name */
    public static /* synthetic */ long m3741copyDwJknco$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m3748getWidthD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m3746getHeightD9Ej5fM(j);
        }
        return m3740copyDwJknco(j, f, f2);
    }

    /* JADX INFO: renamed from: minus-e_xh8Ic, reason: not valid java name */
    public static final long m3751minuse_xh8Ic(long j, long j2) {
        float fM3650constructorimpl = Dp.m3650constructorimpl(m3748getWidthD9Ej5fM(j) - m3748getWidthD9Ej5fM(j2));
        float fM3650constructorimpl2 = Dp.m3650constructorimpl(m3746getHeightD9Ej5fM(j) - m3746getHeightD9Ej5fM(j2));
        return m3739constructorimpl((((long) Float.floatToRawIntBits(fM3650constructorimpl)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fM3650constructorimpl2))));
    }

    /* JADX INFO: renamed from: plus-e_xh8Ic, reason: not valid java name */
    public static final long m3752pluse_xh8Ic(long j, long j2) {
        float fM3650constructorimpl = Dp.m3650constructorimpl(m3748getWidthD9Ej5fM(j) + m3748getWidthD9Ej5fM(j2));
        float fM3650constructorimpl2 = Dp.m3650constructorimpl(m3746getHeightD9Ej5fM(j) + m3746getHeightD9Ej5fM(j2));
        return m3739constructorimpl((((long) Float.floatToRawIntBits(fM3650constructorimpl)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fM3650constructorimpl2))));
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    public static final float m3737component1D9Ej5fM(long j) {
        return m3748getWidthD9Ej5fM(j);
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
    public static final float m3738component2D9Ej5fM(long j) {
        return m3746getHeightD9Ej5fM(j);
    }

    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m3754timesGh9hcWk(long j, int i) {
        float f = i;
        return m3739constructorimpl((((long) Float.floatToRawIntBits(Dp.m3650constructorimpl(m3748getWidthD9Ej5fM(j) * f))) << 32) | (((long) Float.floatToRawIntBits(Dp.m3650constructorimpl(m3746getHeightD9Ej5fM(j) * f))) & 4294967295L));
    }

    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m3753timesGh9hcWk(long j, float f) {
        float fM3650constructorimpl = Dp.m3650constructorimpl(m3748getWidthD9Ej5fM(j) * f);
        float fM3650constructorimpl2 = Dp.m3650constructorimpl(m3746getHeightD9Ej5fM(j) * f);
        return m3739constructorimpl((((long) Float.floatToRawIntBits(fM3650constructorimpl)) << 32) | (((long) Float.floatToRawIntBits(fM3650constructorimpl2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m3743divGh9hcWk(long j, int i) {
        float f = i;
        return m3739constructorimpl((((long) Float.floatToRawIntBits(Dp.m3650constructorimpl(m3748getWidthD9Ej5fM(j) / f))) << 32) | (((long) Float.floatToRawIntBits(Dp.m3650constructorimpl(m3746getHeightD9Ej5fM(j) / f))) & 4294967295L));
    }

    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m3742divGh9hcWk(long j, float f) {
        float fM3650constructorimpl = Dp.m3650constructorimpl(m3748getWidthD9Ej5fM(j) / f);
        float fM3650constructorimpl2 = Dp.m3650constructorimpl(m3746getHeightD9Ej5fM(j) / f);
        return m3739constructorimpl((((long) Float.floatToRawIntBits(fM3650constructorimpl)) << 32) | (((long) Float.floatToRawIntBits(fM3650constructorimpl2)) & 4294967295L));
    }

    public String toString() {
        return m3755toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3755toStringimpl(long j) {
        if (j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            return ((Object) Dp.m3661toStringimpl(m3748getWidthD9Ej5fM(j))) + " x " + ((Object) Dp.m3661toStringimpl(m3746getHeightD9Ej5fM(j)));
        }
        return "DpSize.Unspecified";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-MYxV2XQ, reason: not valid java name */
        public final long m3758getZeroMYxV2XQ() {
            return DpSize.Zero;
        }

        /* JADX INFO: renamed from: getUnspecified-MYxV2XQ, reason: not valid java name */
        public final long m3757getUnspecifiedMYxV2XQ() {
            return DpSize.Unspecified;
        }
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m3748getWidthD9Ej5fM(long j) {
        return Dp.m3650constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m3746getHeightD9Ej5fM(long j) {
        return Dp.m3650constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    /* JADX INFO: renamed from: copy-DwJknco, reason: not valid java name */
    public static final long m3740copyDwJknco(long j, float f, float f2) {
        return m3739constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
    }
}
