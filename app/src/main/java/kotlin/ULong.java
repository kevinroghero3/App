package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt___URangesKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
@JvmInline
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = new Companion(null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ULong m5640boximpl(long j) {
        return new ULong(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m5646constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5652equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m5698unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5653equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5658hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m5686toByteimpl(long j) {
        return (byte) j;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m5689toIntimpl(long j) {
        return (int) j;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m5690toLongimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m5691toShortimpl(long j) {
        return (short) j;
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m5695toULongsVKNKU(long j) {
        return j;
    }

    public boolean equals(Object obj) {
        return m5652equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5658hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5698unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedKt.ulongCompare(m5698unboximpl(), uLong.m5698unboximpl());
    }

    private /* synthetic */ ULong(long j) {
        this.data = j;
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
    private static final int m5641compareTo7apg3OU(long j, byte b) {
        return Long.compare(j ^ Long.MIN_VALUE, m5646constructorimpl(((long) b) & 255) ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m5645compareToxj2QHRw(long j, short s) {
        return Long.compare(j ^ Long.MIN_VALUE, m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m5644compareToWZ4Q5Ns(long j, int i) {
        return Long.compare(j ^ Long.MIN_VALUE, m5646constructorimpl(((long) i) & 4294967295L) ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private int m5642compareToVKZWuLQ(long j) {
        return UnsignedKt.ulongCompare(m5698unboximpl(), j);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static int m5643compareToVKZWuLQ(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final long m5670plus7apg3OU(long j, byte b) {
        return m5646constructorimpl(j + m5646constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final long m5673plusxj2QHRw(long j, short s) {
        return m5646constructorimpl(j + m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final long m5672plusWZ4Q5Ns(long j, int i) {
        return m5646constructorimpl(j + m5646constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m5671plusVKZWuLQ(long j, long j2) {
        return m5646constructorimpl(j + j2);
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final long m5661minus7apg3OU(long j, byte b) {
        return m5646constructorimpl(j - m5646constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final long m5664minusxj2QHRw(long j, short s) {
        return m5646constructorimpl(j - m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final long m5663minusWZ4Q5Ns(long j, int i) {
        return m5646constructorimpl(j - m5646constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m5662minusVKZWuLQ(long j, long j2) {
        return m5646constructorimpl(j - j2);
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final long m5682times7apg3OU(long j, byte b) {
        return m5646constructorimpl(j * m5646constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final long m5685timesxj2QHRw(long j, short s) {
        return m5646constructorimpl(j * m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final long m5684timesWZ4Q5Ns(long j, int i) {
        return m5646constructorimpl(j * m5646constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m5683timesVKZWuLQ(long j, long j2) {
        return m5646constructorimpl(j * j2);
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final long m5648div7apg3OU(long j, byte b) {
        return UByte$$ExternalSyntheticBackport3.m(j, m5646constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final long m5651divxj2QHRw(long j, short s) {
        return UByte$$ExternalSyntheticBackport3.m(j, m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final long m5650divWZ4Q5Ns(long j, int i) {
        return UByte$$ExternalSyntheticBackport3.m(j, m5646constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m5649divVKZWuLQ(long j, long j2) {
        return UnsignedKt.m5825ulongDivideeb3DHEI(j, j2);
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final long m5676rem7apg3OU(long j, byte b) {
        return UByte$$ExternalSyntheticBackport2.m(j, m5646constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final long m5679remxj2QHRw(long j, short s) {
        return UByte$$ExternalSyntheticBackport2.m(j, m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final long m5678remWZ4Q5Ns(long j, int i) {
        return UByte$$ExternalSyntheticBackport2.m(j, m5646constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m5677remVKZWuLQ(long j, long j2) {
        return UnsignedKt.m5826ulongRemaindereb3DHEI(j, j2);
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final long m5654floorDiv7apg3OU(long j, byte b) {
        return UByte$$ExternalSyntheticBackport3.m(j, m5646constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final long m5657floorDivxj2QHRw(long j, short s) {
        return UByte$$ExternalSyntheticBackport3.m(j, m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final long m5656floorDivWZ4Q5Ns(long j, int i) {
        return UByte$$ExternalSyntheticBackport3.m(j, m5646constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m5655floorDivVKZWuLQ(long j, long j2) {
        return UByte$$ExternalSyntheticBackport3.m(j, j2);
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m5665mod7apg3OU(long j, byte b) {
        return UByte.m5490constructorimpl((byte) UByte$$ExternalSyntheticBackport2.m(j, m5646constructorimpl(((long) b) & 255)));
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m5668modxj2QHRw(long j, short s) {
        return UShort.m5753constructorimpl((short) UByte$$ExternalSyntheticBackport2.m(j, m5646constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX)));
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m5667modWZ4Q5Ns(long j, int i) {
        return UInt.m5567constructorimpl((int) UByte$$ExternalSyntheticBackport2.m(j, m5646constructorimpl(((long) i) & 4294967295L)));
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m5666modVKZWuLQ(long j, long j2) {
        return UByte$$ExternalSyntheticBackport2.m(j, j2);
    }

    /* JADX INFO: renamed from: inc-s-VKNKU, reason: not valid java name */
    private static final long m5659incsVKNKU(long j) {
        return m5646constructorimpl(j + 1);
    }

    /* JADX INFO: renamed from: dec-s-VKNKU, reason: not valid java name */
    private static final long m5647decsVKNKU(long j) {
        return m5646constructorimpl(j - 1);
    }

    /* JADX INFO: renamed from: rangeTo-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m5674rangeToVKZWuLQ(long j, long j2) {
        return new ULongRange(j, j2, null);
    }

    /* JADX INFO: renamed from: rangeUntil-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m5675rangeUntilVKZWuLQ(long j, long j2) {
        return URangesKt___URangesKt.m6764untileb3DHEI(j, j2);
    }

    /* JADX INFO: renamed from: shl-s-VKNKU, reason: not valid java name */
    private static final long m5680shlsVKNKU(long j, int i) {
        return m5646constructorimpl(j << i);
    }

    /* JADX INFO: renamed from: shr-s-VKNKU, reason: not valid java name */
    private static final long m5681shrsVKNKU(long j, int i) {
        return m5646constructorimpl(j >>> i);
    }

    /* JADX INFO: renamed from: and-VKZWuLQ, reason: not valid java name */
    private static final long m5639andVKZWuLQ(long j, long j2) {
        return m5646constructorimpl(j & j2);
    }

    /* JADX INFO: renamed from: or-VKZWuLQ, reason: not valid java name */
    private static final long m5669orVKZWuLQ(long j, long j2) {
        return m5646constructorimpl(j | j2);
    }

    /* JADX INFO: renamed from: xor-VKZWuLQ, reason: not valid java name */
    private static final long m5697xorVKZWuLQ(long j, long j2) {
        return m5646constructorimpl(j ^ j2);
    }

    /* JADX INFO: renamed from: inv-s-VKNKU, reason: not valid java name */
    private static final long m5660invsVKNKU(long j) {
        return m5646constructorimpl(~j);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m5693toUBytew2LRezQ(long j) {
        return UByte.m5490constructorimpl((byte) j);
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m5696toUShortMh2AYeg(long j) {
        return UShort.m5753constructorimpl((short) j);
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m5694toUIntpVg5ArA(long j) {
        return UInt.m5567constructorimpl((int) j);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m5688toFloatimpl(long j) {
        return (float) UnsignedKt.ulongToDouble(j);
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m5687toDoubleimpl(long j) {
        return UnsignedKt.ulongToDouble(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5692toStringimpl(long j) {
        return UnsignedKt.ulongToString(j, 10);
    }

    public String toString() {
        return m5692toStringimpl(this.data);
    }
}
