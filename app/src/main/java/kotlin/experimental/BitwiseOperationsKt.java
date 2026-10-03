package kotlin.experimental;

/* JADX INFO: loaded from: classes6.dex */
public final class BitwiseOperationsKt {
    private static final byte and(byte b, byte b2) {
        return (byte) (b & b2);
    }

    private static final short and(short s, short s2) {
        return (short) (s & s2);
    }

    private static final byte inv(byte b) {
        return (byte) (~b);
    }

    private static final short inv(short s) {
        return (short) (~s);
    }

    private static final byte or(byte b, byte b2) {
        return (byte) (b | b2);
    }

    private static final short or(short s, short s2) {
        return (short) (s | s2);
    }

    private static final byte xor(byte b, byte b2) {
        return (byte) (b ^ b2);
    }

    private static final short xor(short s, short s2) {
        return (short) (s ^ s2);
    }
}
