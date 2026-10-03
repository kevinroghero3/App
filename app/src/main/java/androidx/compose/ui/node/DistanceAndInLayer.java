package androidx.compose.ui.node;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: classes4.dex */
@JvmInline
final class DistanceAndInLayer {
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DistanceAndInLayer m2659boximpl(long j) {
        return new DistanceAndInLayer(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2661constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2662equalsimpl(long j, Object obj) {
        return (obj instanceof DistanceAndInLayer) && j == ((DistanceAndInLayer) obj).m2668unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2663equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2665hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: isInLayer-impl, reason: not valid java name */
    public static final boolean m2666isInLayerimpl(long j) {
        return ((int) (j & 4294967295L)) != 0;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2667toStringimpl(long j) {
        return "DistanceAndInLayer(packedValue=" + j + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(Object obj) {
        return m2662equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2665hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m2667toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2668unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ DistanceAndInLayer(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: compareTo-S_HNhKs, reason: not valid java name */
    public static final int m2660compareToS_HNhKs(long j, long j2) {
        boolean zM2666isInLayerimpl = m2666isInLayerimpl(j);
        if (zM2666isInLayerimpl != m2666isInLayerimpl(j2)) {
            return zM2666isInLayerimpl ? -1 : 1;
        }
        return (int) Math.signum(m2664getDistanceimpl(j) - m2664getDistanceimpl(j2));
    }

    /* JADX INFO: renamed from: getDistance-impl, reason: not valid java name */
    public static final float m2664getDistanceimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }
}
