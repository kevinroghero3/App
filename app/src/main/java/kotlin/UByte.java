package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt___URangesKt;

/* JADX INFO: loaded from: classes.dex */
@JvmInline
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UByte m5484boximpl(byte b) {
        return new UByte(b);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte m5490constructorimpl(byte b) {
        return b;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5496equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m5540unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5497equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5502hashCodeimpl(byte b) {
        return Byte.hashCode(b);
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m5528toByteimpl(byte b) {
        return b;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m5531toIntimpl(byte b) {
        return b & 255;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m5532toLongimpl(byte b) {
        return ((long) b) & 255;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m5533toShortimpl(byte b) {
        return (short) (b & 255);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m5535toUBytew2LRezQ(byte b) {
        return b;
    }

    public boolean equals(Object obj) {
        return m5496equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5502hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ byte m5540unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.compare(m5540unboximpl() & 255, uByte.m5540unboximpl() & 255);
    }

    private /* synthetic */ UByte(byte b) {
        this.data = b;
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
    private int m5485compareTo7apg3OU(byte b) {
        return Intrinsics.compare(m5540unboximpl() & 255, b & 255);
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static int m5486compareTo7apg3OU(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m5489compareToxj2QHRw(byte b, short s) {
        return Intrinsics.compare(b & 255, s & UShort.MAX_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m5488compareToWZ4Q5Ns(byte b, int i) {
        return Integer.compare(UInt.m5567constructorimpl(b & 255) ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m5487compareToVKZWuLQ(byte b, long j) {
        return Long.compare(ULong.m5646constructorimpl(((long) b) & 255) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m5514plus7apg3OU(byte b, byte b2) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(b & 255) + UInt.m5567constructorimpl(b2 & 255));
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m5517plusxj2QHRw(byte b, short s) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(b & 255) + UInt.m5567constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m5516plusWZ4Q5Ns(byte b, int i) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(b & 255) + i);
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m5515plusVKZWuLQ(byte b, long j) {
        return ULong.m5646constructorimpl(ULong.m5646constructorimpl(((long) b) & 255) + j);
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m5505minus7apg3OU(byte b, byte b2) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(b & 255) - UInt.m5567constructorimpl(b2 & 255));
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m5508minusxj2QHRw(byte b, short s) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(b & 255) - UInt.m5567constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m5507minusWZ4Q5Ns(byte b, int i) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(b & 255) - i);
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m5506minusVKZWuLQ(byte b, long j) {
        return ULong.m5646constructorimpl(ULong.m5646constructorimpl(((long) b) & 255) - j);
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m5524times7apg3OU(byte b, byte b2) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(b & 255) * UInt.m5567constructorimpl(b2 & 255));
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m5527timesxj2QHRw(byte b, short s) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(b & 255) * UInt.m5567constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m5526timesWZ4Q5Ns(byte b, int i) {
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl(b & 255) * i);
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m5525timesVKZWuLQ(byte b, long j) {
        return ULong.m5646constructorimpl(ULong.m5646constructorimpl(((long) b) & 255) * j);
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m5492div7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5567constructorimpl(b & 255), UInt.m5567constructorimpl(b2 & 255));
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m5495divxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5567constructorimpl(b & 255), UInt.m5567constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m5494divWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5567constructorimpl(b & 255), i);
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m5493divVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport3.m(ULong.m5646constructorimpl(((long) b) & 255), j);
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m5520rem7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m5567constructorimpl(b & 255), UInt.m5567constructorimpl(b2 & 255));
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m5523remxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m5567constructorimpl(b & 255), UInt.m5567constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m5522remWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m5567constructorimpl(b & 255), i);
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m5521remVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport2.m(ULong.m5646constructorimpl(((long) b) & 255), j);
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m5498floorDiv7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5567constructorimpl(b & 255), UInt.m5567constructorimpl(b2 & 255));
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m5501floorDivxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5567constructorimpl(b & 255), UInt.m5567constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m5500floorDivWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5567constructorimpl(b & 255), i);
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m5499floorDivVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport3.m(ULong.m5646constructorimpl(((long) b) & 255), j);
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m5509mod7apg3OU(byte b, byte b2) {
        return m5490constructorimpl((byte) UByte$$ExternalSyntheticBackport1.m(UInt.m5567constructorimpl(b & 255), UInt.m5567constructorimpl(b2 & 255)));
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m5512modxj2QHRw(byte b, short s) {
        return UShort.m5753constructorimpl((short) UByte$$ExternalSyntheticBackport1.m(UInt.m5567constructorimpl(b & 255), UInt.m5567constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m5511modWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m5567constructorimpl(b & 255), i);
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m5510modVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport2.m(ULong.m5646constructorimpl(((long) b) & 255), j);
    }

    /* JADX INFO: renamed from: inc-w2LRezQ, reason: not valid java name */
    private static final byte m5503incw2LRezQ(byte b) {
        return m5490constructorimpl((byte) (b + 1));
    }

    /* JADX INFO: renamed from: dec-w2LRezQ, reason: not valid java name */
    private static final byte m5491decw2LRezQ(byte b) {
        return m5490constructorimpl((byte) (b - 1));
    }

    /* JADX INFO: renamed from: rangeTo-7apg3OU, reason: not valid java name */
    private static final UIntRange m5518rangeTo7apg3OU(byte b, byte b2) {
        return new UIntRange(UInt.m5567constructorimpl(b & 255), UInt.m5567constructorimpl(b2 & 255), null);
    }

    /* JADX INFO: renamed from: rangeUntil-7apg3OU, reason: not valid java name */
    private static final UIntRange m5519rangeUntil7apg3OU(byte b, byte b2) {
        return URangesKt___URangesKt.m6762untilJ1ME1BU(UInt.m5567constructorimpl(b & 255), UInt.m5567constructorimpl(b2 & 255));
    }

    /* JADX INFO: renamed from: and-7apg3OU, reason: not valid java name */
    private static final byte m5483and7apg3OU(byte b, byte b2) {
        return m5490constructorimpl((byte) (b & b2));
    }

    /* JADX INFO: renamed from: or-7apg3OU, reason: not valid java name */
    private static final byte m5513or7apg3OU(byte b, byte b2) {
        return m5490constructorimpl((byte) (b | b2));
    }

    /* JADX INFO: renamed from: xor-7apg3OU, reason: not valid java name */
    private static final byte m5539xor7apg3OU(byte b, byte b2) {
        return m5490constructorimpl((byte) (b ^ b2));
    }

    /* JADX INFO: renamed from: inv-w2LRezQ, reason: not valid java name */
    private static final byte m5504invw2LRezQ(byte b) {
        return m5490constructorimpl((byte) (~b));
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m5538toUShortMh2AYeg(byte b) {
        return UShort.m5753constructorimpl((short) (b & 255));
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m5536toUIntpVg5ArA(byte b) {
        return UInt.m5567constructorimpl(b & 255);
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m5537toULongsVKNKU(byte b) {
        return ULong.m5646constructorimpl(((long) b) & 255);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m5530toFloatimpl(byte b) {
        return (float) UnsignedKt.uintToDouble(b & 255);
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m5529toDoubleimpl(byte b) {
        return UnsignedKt.uintToDouble(b & 255);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5534toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }

    public String toString() {
        return m5534toStringimpl(this.data);
    }
}
