package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;

/* JADX INFO: loaded from: classes.dex */
public final class UnsignedKt {
    public static final double uintToDouble(int i) {
        return ((double) (Integer.MAX_VALUE & i)) + (((double) ((i >>> 31) << 30)) * ((double) 2));
    }

    private static final long uintToLong(int i) {
        return ((long) i) & 4294967295L;
    }

    public static final double ulongToDouble(long j) {
        return ((j >>> 11) * ((double) 2048)) + (j & 2047);
    }

    /* JADX INFO: renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m5824uintRemainderJ1ME1BU(int i, int i2) {
        return UInt.m5567constructorimpl((int) ((((long) i) & 4294967295L) % (((long) i2) & 4294967295L)));
    }

    /* JADX INFO: renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m5823uintDivideJ1ME1BU(int i, int i2) {
        return UInt.m5567constructorimpl((int) ((((long) i) & 4294967295L) / (((long) i2) & 4294967295L)));
    }

    /* JADX INFO: renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m5825ulongDivideeb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) < 0 ? ULong.m5646constructorimpl(0L) : ULong.m5646constructorimpl(1L);
        }
        if (j >= 0) {
            return ULong.m5646constructorimpl(j / j2);
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return ULong.m5646constructorimpl(j3 + ((long) (Long.compare(ULong.m5646constructorimpl(j - (j3 * j2)) ^ Long.MIN_VALUE, ULong.m5646constructorimpl(j2) ^ Long.MIN_VALUE) < 0 ? 0 : 1)));
    }

    /* JADX INFO: renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m5826ulongRemaindereb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) < 0 ? j : ULong.m5646constructorimpl(j - j2);
        }
        if (j >= 0) {
            return ULong.m5646constructorimpl(j % j2);
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (Long.compare(ULong.m5646constructorimpl(j3) ^ Long.MIN_VALUE, ULong.m5646constructorimpl(j2) ^ Long.MIN_VALUE) < 0) {
            j2 = 0;
        }
        return ULong.m5646constructorimpl(j3 - j2);
    }

    public static final int uintCompare(int i, int i2) {
        return Intrinsics.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    public static final int ulongCompare(long j, long j2) {
        return Intrinsics.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    private static final long uintToULong(int i) {
        return ULong.m5646constructorimpl(((long) i) & 4294967295L);
    }

    private static final float uintToFloat(int i) {
        return (float) uintToDouble(i);
    }

    private static final int floatToUInt(float f) {
        return doubleToUInt(f);
    }

    public static final int doubleToUInt(double d) {
        if (Double.isNaN(d) || d <= uintToDouble(0)) {
            return 0;
        }
        if (d >= uintToDouble(-1)) {
            return -1;
        }
        if (d <= 2.147483647E9d) {
            return UInt.m5567constructorimpl((int) d);
        }
        return UInt.m5567constructorimpl(UInt.m5567constructorimpl((int) (d - ((double) Integer.MAX_VALUE))) + UInt.m5567constructorimpl(Integer.MAX_VALUE));
    }

    private static final float ulongToFloat(long j) {
        return (float) ulongToDouble(j);
    }

    private static final long floatToULong(float f) {
        return doubleToULong(f);
    }

    public static final long doubleToULong(double d) {
        if (Double.isNaN(d) || d <= ulongToDouble(0L)) {
            return 0L;
        }
        if (d >= ulongToDouble(-1L)) {
            return -1L;
        }
        if (d < 9.223372036854776E18d) {
            return ULong.m5646constructorimpl((long) d);
        }
        return ULong.m5646constructorimpl(ULong.m5646constructorimpl((long) (d - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    private static final String uintToString(int i) {
        return String.valueOf(((long) i) & 4294967295L);
    }

    private static final String uintToString(int i, int i2) {
        return ulongToString(((long) i) & 4294967295L, i2);
    }

    private static final String ulongToString(long j) {
        return ulongToString(j, 10);
    }

    public static final String ulongToString(long j, int i) {
        if (j >= 0) {
            String string = Long.toString(j, CharsKt__CharJVMKt.checkRadix(i));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j3, CharsKt__CharJVMKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        sb.append(string2);
        String string3 = Long.toString(j4, CharsKt__CharJVMKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        sb.append(string3);
        return sb.toString();
    }
}
