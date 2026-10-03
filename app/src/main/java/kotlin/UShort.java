package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt___URangesKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
@JvmInline
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = new Companion(null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UShort m5747boximpl(short s) {
        return new UShort(s);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m5753constructorimpl(short s) {
        return s;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5759equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m5803unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5760equalsimpl0(short s, short s2) {
        return s == s2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5765hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m5791toByteimpl(short s) {
        return (byte) s;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m5794toIntimpl(short s) {
        return s & MAX_VALUE;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m5795toLongimpl(short s) {
        return ((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m5796toShortimpl(short s) {
        return s;
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m5801toUShortMh2AYeg(short s) {
        return s;
    }

    public boolean equals(Object obj) {
        return m5759equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5765hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m5803unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(m5803unboximpl() & MAX_VALUE, uShort.m5803unboximpl() & MAX_VALUE);
    }

    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m5748compareTo7apg3OU(short s, byte b) {
        return Intrinsics.compare(s & MAX_VALUE, b & 255);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private int m5751compareToxj2QHRw(short s) {
        return Intrinsics.compare(m5803unboximpl() & MAX_VALUE, s & MAX_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static int m5752compareToxj2QHRw(short s, short s2) {
        return Intrinsics.compare(s & MAX_VALUE, s2 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m5750compareToWZ4Q5Ns(short s, int i) {
        return Integer.compare(UInt.m5567constructorimpl(s & MAX_VALUE) ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m5749compareToVKZWuLQ(short s, long j) {
        return Long.compare(ULong.m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m5777plus7apg3OU(short s, byte b) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(s & MAX_VALUE) + UInt.m5567constructorimpl(b & 255));
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m5780plusxj2QHRw(short s, short s2) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(s & MAX_VALUE) + UInt.m5567constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m5779plusWZ4Q5Ns(short s, int i) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(s & MAX_VALUE) + i);
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m5778plusVKZWuLQ(short s, long j) {
        return ULong.m5646constructorimpl(ULong.m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) + j);
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m5768minus7apg3OU(short s, byte b) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(s & MAX_VALUE) - UInt.m5567constructorimpl(b & 255));
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m5771minusxj2QHRw(short s, short s2) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(s & MAX_VALUE) - UInt.m5567constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m5770minusWZ4Q5Ns(short s, int i) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(s & MAX_VALUE) - i);
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m5769minusVKZWuLQ(short s, long j) {
        return ULong.m5646constructorimpl(ULong.m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) - j);
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m5787times7apg3OU(short s, byte b) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(s & MAX_VALUE) * UInt.m5567constructorimpl(b & 255));
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m5790timesxj2QHRw(short s, short s2) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(s & MAX_VALUE) * UInt.m5567constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m5789timesWZ4Q5Ns(short s, int i) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(s & MAX_VALUE) * i);
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m5788timesVKZWuLQ(short s, long j) {
        return ULong.m5646constructorimpl(ULong.m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) * j);
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m5755div7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5567constructorimpl(s & MAX_VALUE), UInt.m5567constructorimpl(b & 255));
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m5758divxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5567constructorimpl(s & MAX_VALUE), UInt.m5567constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m5757divWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5567constructorimpl(s & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m5756divVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport3.m(ULong.m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m5783rem7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m5567constructorimpl(s & MAX_VALUE), UInt.m5567constructorimpl(b & 255));
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m5786remxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m5567constructorimpl(s & MAX_VALUE), UInt.m5567constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m5785remWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m5567constructorimpl(s & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m5784remVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport2.m(ULong.m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m5761floorDiv7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5567constructorimpl(s & MAX_VALUE), UInt.m5567constructorimpl(b & 255));
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m5764floorDivxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5567constructorimpl(s & MAX_VALUE), UInt.m5567constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m5763floorDivWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5567constructorimpl(s & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m5762floorDivVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport3.m(ULong.m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m5772mod7apg3OU(short s, byte b) {
        return UByte.m5490constructorimpl((byte) UByte$$ExternalSyntheticBackport1.m(UInt.m5567constructorimpl(s & MAX_VALUE), UInt.m5567constructorimpl(b & 255)));
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m5775modxj2QHRw(short s, short s2) {
        return m5753constructorimpl((short) UByte$$ExternalSyntheticBackport1.m(UInt.m5567constructorimpl(s & MAX_VALUE), UInt.m5567constructorimpl(s2 & MAX_VALUE)));
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m5774modWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m5567constructorimpl(s & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m5773modVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport2.m(ULong.m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* JADX INFO: renamed from: inc-Mh2AYeg, reason: not valid java name */
    private static final short m5766incMh2AYeg(short s) {
        return m5753constructorimpl((short) (s + 1));
    }

    /* JADX INFO: renamed from: dec-Mh2AYeg, reason: not valid java name */
    private static final short m5754decMh2AYeg(short s) {
        return m5753constructorimpl((short) (s - 1));
    }

    /* JADX INFO: renamed from: rangeTo-xj2QHRw, reason: not valid java name */
    private static final UIntRange m5781rangeToxj2QHRw(short s, short s2) {
        return new UIntRange(UInt.m5567constructorimpl(s & MAX_VALUE), UInt.m5567constructorimpl(s2 & MAX_VALUE), null);
    }

    /* JADX INFO: renamed from: rangeUntil-xj2QHRw, reason: not valid java name */
    private static final UIntRange m5782rangeUntilxj2QHRw(short s, short s2) {
        return URangesKt___URangesKt.m6762untilJ1ME1BU(UInt.m5567constructorimpl(s & MAX_VALUE), UInt.m5567constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: and-xj2QHRw, reason: not valid java name */
    private static final short m5746andxj2QHRw(short s, short s2) {
        return m5753constructorimpl((short) (s & s2));
    }

    /* JADX INFO: renamed from: or-xj2QHRw, reason: not valid java name */
    private static final short m5776orxj2QHRw(short s, short s2) {
        return m5753constructorimpl((short) (s | s2));
    }

    /* JADX INFO: renamed from: xor-xj2QHRw, reason: not valid java name */
    private static final short m5802xorxj2QHRw(short s, short s2) {
        return m5753constructorimpl((short) (s ^ s2));
    }

    /* JADX INFO: renamed from: inv-Mh2AYeg, reason: not valid java name */
    private static final short m5767invMh2AYeg(short s) {
        return m5753constructorimpl((short) (~s));
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m5798toUBytew2LRezQ(short s) {
        return UByte.m5490constructorimpl((byte) s);
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m5799toUIntpVg5ArA(short s) {
        return UInt.m5567constructorimpl(s & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m5800toULongsVKNKU(short s) {
        return ULong.m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m5793toFloatimpl(short s) {
        return (float) UnsignedKt.uintToDouble(s & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m5792toDoubleimpl(short s) {
        return UnsignedKt.uintToDouble(s & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5797toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }

    public String toString() {
        return m5797toStringimpl(this.data);
    }
}
