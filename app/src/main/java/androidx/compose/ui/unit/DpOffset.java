package androidx.compose.ui.unit;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@JvmInline
public final class DpOffset {
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m3706constructorimpl(0);
    private static final long Unspecified = m3706constructorimpl(androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m3705boximpl(long j) {
        return new DpOffset(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3706constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3709equalsimpl(long j, Object obj) {
        return (obj instanceof DpOffset) && j == ((DpOffset) obj).m3719unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3710equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3712getXD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3714getYD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3715hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m3709equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3715hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3719unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ DpOffset(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: copy-tPigGR8$default, reason: not valid java name */
    public static /* synthetic */ long m3708copytPigGR8$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m3711getXD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m3713getYD9Ej5fM(j);
        }
        return m3707copytPigGR8(j, f, f2);
    }

    /* JADX INFO: renamed from: minus-CB-Mgk4, reason: not valid java name */
    public static final long m3716minusCBMgk4(long j, long j2) {
        float fM3650constructorimpl = Dp.m3650constructorimpl(m3711getXD9Ej5fM(j) - m3711getXD9Ej5fM(j2));
        float fM3650constructorimpl2 = Dp.m3650constructorimpl(m3713getYD9Ej5fM(j) - m3713getYD9Ej5fM(j2));
        return m3706constructorimpl((((long) Float.floatToRawIntBits(fM3650constructorimpl)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fM3650constructorimpl2))));
    }

    /* JADX INFO: renamed from: plus-CB-Mgk4, reason: not valid java name */
    public static final long m3717plusCBMgk4(long j, long j2) {
        float fM3650constructorimpl = Dp.m3650constructorimpl(m3711getXD9Ej5fM(j) + m3711getXD9Ej5fM(j2));
        float fM3650constructorimpl2 = Dp.m3650constructorimpl(m3713getYD9Ej5fM(j) + m3713getYD9Ej5fM(j2));
        return m3706constructorimpl((((long) Float.floatToRawIntBits(fM3650constructorimpl)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fM3650constructorimpl2))));
    }

    public String toString() {
        return m3718toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3718toStringimpl(long j) {
        if (j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            return CoreConstants.LEFT_PARENTHESIS_CHAR + ((Object) Dp.m3661toStringimpl(m3711getXD9Ej5fM(j))) + ", " + ((Object) Dp.m3661toStringimpl(m3713getYD9Ej5fM(j))) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
        return "DpOffset.Unspecified";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-RKDOV3M, reason: not valid java name */
        public final long m3721getZeroRKDOV3M() {
            return DpOffset.Zero;
        }

        /* JADX INFO: renamed from: getUnspecified-RKDOV3M, reason: not valid java name */
        public final long m3720getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m3711getXD9Ej5fM(long j) {
        return Dp.m3650constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m3713getYD9Ej5fM(long j) {
        return Dp.m3650constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    /* JADX INFO: renamed from: copy-tPigGR8, reason: not valid java name */
    public static final long m3707copytPigGR8(long j, float f, float f2) {
        return m3706constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
    }
}
