package kotlin;

import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
class NumbersKt__NumbersJVMKt extends NumbersKt__FloorDivModKt {
    private static final boolean isNaN(double d) {
        return Double.isNaN(d);
    }

    private static final boolean isNaN(float f) {
        return Float.isNaN(f);
    }

    private static final boolean isInfinite(double d) {
        return Double.isInfinite(d);
    }

    private static final boolean isInfinite(float f) {
        return Float.isInfinite(f);
    }

    private static final boolean isFinite(double d) {
        return Math.abs(d) <= Double.MAX_VALUE;
    }

    private static final boolean isFinite(float f) {
        return Math.abs(f) <= Float.MAX_VALUE;
    }

    private static final long toBits(double d) {
        return Double.doubleToLongBits(d);
    }

    private static final long toRawBits(double d) {
        return Double.doubleToRawLongBits(d);
    }

    private static final double fromBits(DoubleCompanionObject doubleCompanionObject, long j) {
        Intrinsics.checkNotNullParameter(doubleCompanionObject, "<this>");
        return Double.longBitsToDouble(j);
    }

    private static final int toBits(float f) {
        return Float.floatToIntBits(f);
    }

    private static final int toRawBits(float f) {
        return Float.floatToRawIntBits(f);
    }

    private static final float fromBits(FloatCompanionObject floatCompanionObject, int i) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return Float.intBitsToFloat(i);
    }

    private static final int countOneBits(int i) {
        return Integer.bitCount(i);
    }

    private static final int countLeadingZeroBits(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    private static final int countTrailingZeroBits(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    private static final int takeHighestOneBit(int i) {
        return Integer.highestOneBit(i);
    }

    private static final int takeLowestOneBit(int i) {
        return Integer.lowestOneBit(i);
    }

    private static final int rotateLeft(int i, int i2) {
        return Integer.rotateLeft(i, i2);
    }

    private static final int rotateRight(int i, int i2) {
        return Integer.rotateRight(i, i2);
    }

    private static final int countOneBits(long j) {
        return Long.bitCount(j);
    }

    private static final int countLeadingZeroBits(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    private static final int countTrailingZeroBits(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    private static final long takeHighestOneBit(long j) {
        return Long.highestOneBit(j);
    }

    private static final long takeLowestOneBit(long j) {
        return Long.lowestOneBit(j);
    }

    private static final long rotateLeft(long j, int i) {
        return Long.rotateLeft(j, i);
    }

    private static final long rotateRight(long j, int i) {
        return Long.rotateRight(j, i);
    }
}
