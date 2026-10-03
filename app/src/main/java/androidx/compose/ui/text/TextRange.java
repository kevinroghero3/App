package androidx.compose.ui.text;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@JvmInline
public final class TextRange {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = TextRangeKt.TextRange(0);
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextRange m3123boximpl(long j) {
        return new TextRange(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3124constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3127equalsimpl(long j, Object obj) {
        return (obj instanceof TextRange) && j == ((TextRange) obj).m3139unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3128equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getEnd-impl, reason: not valid java name */
    public static final int m3130getEndimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* JADX INFO: renamed from: getStart-impl, reason: not valid java name */
    public static final int m3135getStartimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3136hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m3127equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3136hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3139unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ TextRange(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: getMin-impl, reason: not valid java name */
    public static final int m3133getMinimpl(long j) {
        return m3135getStartimpl(j) > m3130getEndimpl(j) ? m3130getEndimpl(j) : m3135getStartimpl(j);
    }

    /* JADX INFO: renamed from: getMax-impl, reason: not valid java name */
    public static final int m3132getMaximpl(long j) {
        return m3135getStartimpl(j) > m3130getEndimpl(j) ? m3135getStartimpl(j) : m3130getEndimpl(j);
    }

    /* JADX INFO: renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m3129getCollapsedimpl(long j) {
        return m3135getStartimpl(j) == m3130getEndimpl(j);
    }

    /* JADX INFO: renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m3134getReversedimpl(long j) {
        return m3135getStartimpl(j) > m3130getEndimpl(j);
    }

    /* JADX INFO: renamed from: getLength-impl, reason: not valid java name */
    public static final int m3131getLengthimpl(long j) {
        return m3132getMaximpl(j) - m3133getMinimpl(j);
    }

    /* JADX INFO: renamed from: intersects-5zc-tL8, reason: not valid java name */
    public static final boolean m3137intersects5zctL8(long j, long j2) {
        return m3133getMinimpl(j) < m3132getMaximpl(j2) && m3133getMinimpl(j2) < m3132getMaximpl(j);
    }

    /* JADX INFO: renamed from: contains-5zc-tL8, reason: not valid java name */
    public static final boolean m3125contains5zctL8(long j, long j2) {
        return m3133getMinimpl(j) <= m3133getMinimpl(j2) && m3132getMaximpl(j2) <= m3132getMaximpl(j);
    }

    /* JADX INFO: renamed from: contains-impl, reason: not valid java name */
    public static final boolean m3126containsimpl(long j, int i) {
        return i < m3132getMaximpl(j) && m3133getMinimpl(j) <= i;
    }

    public String toString() {
        return m3138toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3138toStringimpl(long j) {
        return "TextRange(" + m3135getStartimpl(j) + ", " + m3130getEndimpl(j) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-d9O1mEE, reason: not valid java name */
        public final long m3140getZerod9O1mEE() {
            return TextRange.Zero;
        }
    }
}
