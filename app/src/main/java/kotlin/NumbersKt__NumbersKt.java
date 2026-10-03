package kotlin;

/* JADX INFO: loaded from: classes6.dex */
class NumbersKt__NumbersKt extends NumbersKt__NumbersJVMKt {
    public static final byte rotateLeft(byte b, int i) {
        int i2 = i & 7;
        return (byte) ((b << i2) | ((b & 255) >>> (8 - i2)));
    }

    public static final short rotateLeft(short s, int i) {
        int i2 = i & 15;
        return (short) ((s << i2) | ((65535 & s) >>> (16 - i2)));
    }

    public static final byte rotateRight(byte b, int i) {
        int i2 = i & 7;
        return (byte) ((b << (8 - i2)) | ((b & 255) >>> i2));
    }

    public static final short rotateRight(short s, int i) {
        int i2 = i & 15;
        return (short) ((s << (16 - i2)) | ((65535 & s) >>> i2));
    }

    private static final int countOneBits(byte b) {
        return Integer.bitCount(b & 255);
    }

    private static final int countLeadingZeroBits(byte b) {
        return Integer.numberOfLeadingZeros(b & 255) - 24;
    }

    private static final int countTrailingZeroBits(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    private static final byte takeHighestOneBit(byte b) {
        return (byte) Integer.highestOneBit(b & 255);
    }

    private static final byte takeLowestOneBit(byte b) {
        return (byte) Integer.lowestOneBit(b);
    }

    private static final int countOneBits(short s) {
        return Integer.bitCount(s & UShort.MAX_VALUE);
    }

    private static final int countLeadingZeroBits(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    private static final int countTrailingZeroBits(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    private static final short takeHighestOneBit(short s) {
        return (short) Integer.highestOneBit(s & UShort.MAX_VALUE);
    }

    private static final short takeLowestOneBit(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
