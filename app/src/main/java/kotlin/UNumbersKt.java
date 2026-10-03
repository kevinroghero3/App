package kotlin;

/* JADX INFO: loaded from: classes6.dex */
public final class UNumbersKt {
    /* JADX INFO: renamed from: countOneBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m5724countOneBitsWZ4Q5Ns(int i) {
        return Integer.bitCount(i);
    }

    /* JADX INFO: renamed from: countLeadingZeroBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m5720countLeadingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    /* JADX INFO: renamed from: countTrailingZeroBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m5728countTrailingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    /* JADX INFO: renamed from: takeHighestOneBit-WZ4Q5Ns, reason: not valid java name */
    private static final int m5740takeHighestOneBitWZ4Q5Ns(int i) {
        return UInt.m5567constructorimpl(Integer.highestOneBit(i));
    }

    /* JADX INFO: renamed from: takeLowestOneBit-WZ4Q5Ns, reason: not valid java name */
    private static final int m5744takeLowestOneBitWZ4Q5Ns(int i) {
        return UInt.m5567constructorimpl(Integer.lowestOneBit(i));
    }

    /* JADX INFO: renamed from: rotateLeft-V7xB4Y4, reason: not valid java name */
    private static final int m5732rotateLeftV7xB4Y4(int i, int i2) {
        return UInt.m5567constructorimpl(Integer.rotateLeft(i, i2));
    }

    /* JADX INFO: renamed from: rotateRight-V7xB4Y4, reason: not valid java name */
    private static final int m5736rotateRightV7xB4Y4(int i, int i2) {
        return UInt.m5567constructorimpl(Integer.rotateRight(i, i2));
    }

    /* JADX INFO: renamed from: countOneBits-VKZWuLQ, reason: not valid java name */
    private static final int m5723countOneBitsVKZWuLQ(long j) {
        return Long.bitCount(j);
    }

    /* JADX INFO: renamed from: countLeadingZeroBits-VKZWuLQ, reason: not valid java name */
    private static final int m5719countLeadingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    /* JADX INFO: renamed from: countTrailingZeroBits-VKZWuLQ, reason: not valid java name */
    private static final int m5727countTrailingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    /* JADX INFO: renamed from: takeHighestOneBit-VKZWuLQ, reason: not valid java name */
    private static final long m5739takeHighestOneBitVKZWuLQ(long j) {
        return ULong.m5646constructorimpl(Long.highestOneBit(j));
    }

    /* JADX INFO: renamed from: takeLowestOneBit-VKZWuLQ, reason: not valid java name */
    private static final long m5743takeLowestOneBitVKZWuLQ(long j) {
        return ULong.m5646constructorimpl(Long.lowestOneBit(j));
    }

    /* JADX INFO: renamed from: rotateLeft-JSWoG40, reason: not valid java name */
    private static final long m5730rotateLeftJSWoG40(long j, int i) {
        return ULong.m5646constructorimpl(Long.rotateLeft(j, i));
    }

    /* JADX INFO: renamed from: rotateRight-JSWoG40, reason: not valid java name */
    private static final long m5734rotateRightJSWoG40(long j, int i) {
        return ULong.m5646constructorimpl(Long.rotateRight(j, i));
    }

    /* JADX INFO: renamed from: countOneBits-7apg3OU, reason: not valid java name */
    private static final int m5722countOneBits7apg3OU(byte b) {
        return Integer.bitCount(UInt.m5567constructorimpl(b & 255));
    }

    /* JADX INFO: renamed from: countLeadingZeroBits-7apg3OU, reason: not valid java name */
    private static final int m5718countLeadingZeroBits7apg3OU(byte b) {
        return Integer.numberOfLeadingZeros(b & 255) - 24;
    }

    /* JADX INFO: renamed from: countTrailingZeroBits-7apg3OU, reason: not valid java name */
    private static final int m5726countTrailingZeroBits7apg3OU(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    /* JADX INFO: renamed from: takeHighestOneBit-7apg3OU, reason: not valid java name */
    private static final byte m5738takeHighestOneBit7apg3OU(byte b) {
        return UByte.m5490constructorimpl((byte) Integer.highestOneBit(b & 255));
    }

    /* JADX INFO: renamed from: takeLowestOneBit-7apg3OU, reason: not valid java name */
    private static final byte m5742takeLowestOneBit7apg3OU(byte b) {
        return UByte.m5490constructorimpl((byte) Integer.lowestOneBit(b & 255));
    }

    /* JADX INFO: renamed from: rotateLeft-LxnNnR4, reason: not valid java name */
    private static final byte m5731rotateLeftLxnNnR4(byte b, int i) {
        return UByte.m5490constructorimpl(NumbersKt__NumbersKt.rotateLeft(b, i));
    }

    /* JADX INFO: renamed from: rotateRight-LxnNnR4, reason: not valid java name */
    private static final byte m5735rotateRightLxnNnR4(byte b, int i) {
        return UByte.m5490constructorimpl(NumbersKt__NumbersKt.rotateRight(b, i));
    }

    /* JADX INFO: renamed from: countOneBits-xj2QHRw, reason: not valid java name */
    private static final int m5725countOneBitsxj2QHRw(short s) {
        return Integer.bitCount(UInt.m5567constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: countLeadingZeroBits-xj2QHRw, reason: not valid java name */
    private static final int m5721countLeadingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    /* JADX INFO: renamed from: countTrailingZeroBits-xj2QHRw, reason: not valid java name */
    private static final int m5729countTrailingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    /* JADX INFO: renamed from: takeHighestOneBit-xj2QHRw, reason: not valid java name */
    private static final short m5741takeHighestOneBitxj2QHRw(short s) {
        return UShort.m5753constructorimpl((short) Integer.highestOneBit(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: takeLowestOneBit-xj2QHRw, reason: not valid java name */
    private static final short m5745takeLowestOneBitxj2QHRw(short s) {
        return UShort.m5753constructorimpl((short) Integer.lowestOneBit(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: rotateLeft-olVBNx4, reason: not valid java name */
    private static final short m5733rotateLeftolVBNx4(short s, int i) {
        return UShort.m5753constructorimpl(NumbersKt__NumbersKt.rotateLeft(s, i));
    }

    /* JADX INFO: renamed from: rotateRight-olVBNx4, reason: not valid java name */
    private static final short m5737rotateRightolVBNx4(short s, int i) {
        return UShort.m5753constructorimpl(NumbersKt__NumbersKt.rotateRight(s, i));
    }
}
