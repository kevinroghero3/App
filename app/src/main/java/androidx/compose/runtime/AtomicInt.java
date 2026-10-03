package androidx.compose.runtime;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class AtomicInt extends AtomicInteger {
    public static final int $stable = 0;

    public AtomicInt(int i) {
        super(i);
    }

    @Override // java.lang.Number
    public final byte byteValue() {
        return toByte();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger, java.lang.Number
    public final double doubleValue() {
        return toDouble();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger, java.lang.Number
    public final float floatValue() {
        return toFloat();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger, java.lang.Number
    public final int intValue() {
        return toInt();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger, java.lang.Number
    public final long longValue() {
        return toLong();
    }

    @Override // java.lang.Number
    public final short shortValue() {
        return toShort();
    }

    public double toDouble() {
        return super.doubleValue();
    }

    public float toFloat() {
        return super.floatValue();
    }

    public int toInt() {
        return super.intValue();
    }

    public long toLong() {
        return super.longValue();
    }

    public final int add(int i) {
        return addAndGet(i);
    }

    public byte toByte() {
        return (byte) intValue();
    }

    public short toShort() {
        return (short) intValue();
    }

    public char toChar() {
        return (char) intValue();
    }
}
