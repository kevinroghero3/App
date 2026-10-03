package androidx.compose.ui.unit;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@JvmInline
public final class TextUnit {
    public static final Companion Companion = new Companion(null);
    private static final TextUnitType[] TextUnitTypes;
    private static final long Unspecified;
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnit m3833boximpl(long j) {
        return new TextUnit(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3835constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3839equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnit) && j == ((TextUnit) obj).m3852unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3840equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getRawType$annotations() {
    }

    /* JADX INFO: renamed from: getRawType-impl, reason: not valid java name */
    public static final long m3841getRawTypeimpl(long j) {
        return j & 1095216660480L;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3844hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m3839equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3844hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3852unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ TextUnit(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: unaryMinus-XSAIIZE, reason: not valid java name */
    public static final long m3851unaryMinusXSAIIZE(long j) {
        TextUnitKt.m3856checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m3841getRawTypeimpl(j), -m3843getValueimpl(j));
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m3837divkPz2Gy4(long j, float f) {
        TextUnitKt.m3856checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m3841getRawTypeimpl(j), m3843getValueimpl(j) / f);
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m3836divkPz2Gy4(long j, double d) {
        TextUnitKt.m3856checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m3841getRawTypeimpl(j), (float) (((double) m3843getValueimpl(j)) / d));
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m3838divkPz2Gy4(long j, int i) {
        TextUnitKt.m3856checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m3841getRawTypeimpl(j), m3843getValueimpl(j) / i);
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m3848timeskPz2Gy4(long j, float f) {
        TextUnitKt.m3856checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m3841getRawTypeimpl(j), m3843getValueimpl(j) * f);
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m3847timeskPz2Gy4(long j, double d) {
        TextUnitKt.m3856checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m3841getRawTypeimpl(j), (float) (((double) m3843getValueimpl(j)) * d));
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m3849timeskPz2Gy4(long j, int i) {
        TextUnitKt.m3856checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m3841getRawTypeimpl(j), m3843getValueimpl(j) * i);
    }

    /* JADX INFO: renamed from: compareTo--R2X_6o, reason: not valid java name */
    public static final int m3834compareToR2X_6o(long j, long j2) {
        TextUnitKt.m3857checkArithmeticNB67dxo(j, j2);
        return Float.compare(m3843getValueimpl(j), m3843getValueimpl(j2));
    }

    public String toString() {
        return m3850toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3850toStringimpl(long j) {
        long jM3842getTypeUIouoOA = m3842getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3877getUnspecifiedUIouoOA())) {
            return "Unspecified";
        }
        if (TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3876getSpUIouoOA())) {
            return m3843getValueimpl(j) + ".sp";
        }
        if (!TextUnitType.m3871equalsimpl0(jM3842getTypeUIouoOA, companion.m3875getEmUIouoOA())) {
            return "Invalid";
        }
        return m3843getValueimpl(j) + ".em";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-XSAIIZE$annotations, reason: not valid java name */
        public static /* synthetic */ void m3853getUnspecifiedXSAIIZE$annotations() {
        }

        private Companion() {
        }

        public final TextUnitType[] getTextUnitTypes$ui_unit_release() {
            return TextUnit.TextUnitTypes;
        }

        /* JADX INFO: renamed from: getUnspecified-XSAIIZE, reason: not valid java name */
        public final long m3854getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }
    }

    static {
        TextUnitType.Companion companion = TextUnitType.Companion;
        TextUnitTypes = new TextUnitType[]{TextUnitType.m3868boximpl(companion.m3877getUnspecifiedUIouoOA()), TextUnitType.m3868boximpl(companion.m3876getSpUIouoOA()), TextUnitType.m3868boximpl(companion.m3875getEmUIouoOA())};
        Unspecified = TextUnitKt.pack(0L, Float.NaN);
    }

    /* JADX INFO: renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m3842getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) (m3841getRawTypeimpl(j) >>> 32)].m3874unboximpl();
    }

    /* JADX INFO: renamed from: isSp-impl, reason: not valid java name */
    public static final boolean m3846isSpimpl(long j) {
        return m3841getRawTypeimpl(j) == 4294967296L;
    }

    /* JADX INFO: renamed from: isEm-impl, reason: not valid java name */
    public static final boolean m3845isEmimpl(long j) {
        return m3841getRawTypeimpl(j) == 8589934592L;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    public static final float m3843getValueimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }
}
