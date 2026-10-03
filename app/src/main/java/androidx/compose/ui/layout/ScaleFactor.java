package androidx.compose.ui.layout;

import androidx.compose.ui.internal.InlineClassHelperKt;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@JvmInline
public final class ScaleFactor {
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified = ScaleFactorKt.ScaleFactor(Float.NaN, Float.NaN);
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ScaleFactor m2606boximpl(long j) {
        return new ScaleFactor(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2609constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2613equalsimpl(long j, Object obj) {
        return (obj instanceof ScaleFactor) && j == ((ScaleFactor) obj).m2620unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2614equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    public static /* synthetic */ void getScaleX$annotations() {
    }

    public static /* synthetic */ void getScaleY$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2617hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2613equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2617hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2620unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ ScaleFactor(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: getScaleX-impl, reason: not valid java name */
    public static final float m2615getScaleXimpl(long j) {
        if (j == Unspecified) {
            InlineClassHelperKt.throwIllegalStateException("ScaleFactor is unspecified");
        }
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getScaleY-impl, reason: not valid java name */
    public static final float m2616getScaleYimpl(long j) {
        if (j == Unspecified) {
            InlineClassHelperKt.throwIllegalStateException("ScaleFactor is unspecified");
        }
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m2607component1impl(long j) {
        return m2615getScaleXimpl(j);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m2608component2impl(long j) {
        return m2616getScaleYimpl(j);
    }

    /* JADX INFO: renamed from: copy-8GGzs04, reason: not valid java name */
    public static final long m2610copy8GGzs04(long j, float f, float f2) {
        return ScaleFactorKt.ScaleFactor(f, f2);
    }

    /* JADX INFO: renamed from: copy-8GGzs04$default, reason: not valid java name */
    public static /* synthetic */ long m2611copy8GGzs04$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m2615getScaleXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m2616getScaleYimpl(j);
        }
        return m2610copy8GGzs04(j, f, f2);
    }

    /* JADX INFO: renamed from: times-44nBxM0, reason: not valid java name */
    public static final long m2618times44nBxM0(long j, float f) {
        return ScaleFactorKt.ScaleFactor(m2615getScaleXimpl(j) * f, m2616getScaleYimpl(j) * f);
    }

    /* JADX INFO: renamed from: div-44nBxM0, reason: not valid java name */
    public static final long m2612div44nBxM0(long j, float f) {
        return ScaleFactorKt.ScaleFactor(m2615getScaleXimpl(j) / f, m2616getScaleYimpl(j) / f);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2619toStringimpl(long j) {
        return "ScaleFactor(" + ScaleFactorKt.roundToTenths(m2615getScaleXimpl(j)) + ", " + ScaleFactorKt.roundToTenths(m2616getScaleYimpl(j)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public String toString() {
        return m2619toStringimpl(this.packedValue);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-_hLwfpc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2621getUnspecified_hLwfpc$annotations() {
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnspecified-_hLwfpc, reason: not valid java name */
        public final long m2622getUnspecified_hLwfpc() {
            return ScaleFactor.Unspecified;
        }
    }
}
