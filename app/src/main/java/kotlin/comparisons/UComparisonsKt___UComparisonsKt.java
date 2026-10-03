package kotlin.comparisons;

import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes6.dex */
public class UComparisonsKt___UComparisonsKt {
    /* JADX INFO: renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static int m6671maxOfJ1ME1BU(int i, int i2) {
        return Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) >= 0 ? i : i2;
    }

    /* JADX INFO: renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static long m6679maxOfeb3DHEI(long j, long j2) {
        return Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) >= 0 ? j : j2;
    }

    /* JADX INFO: renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m6672maxOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) >= 0 ? b : b2;
    }

    /* JADX INFO: renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m6670maxOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) >= 0 ? s : s2;
    }

    /* JADX INFO: renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m6676maxOfWZ9TVnA(int i, int i2, int i3) {
        return m6671maxOfJ1ME1BU(i, m6671maxOfJ1ME1BU(i2, i3));
    }

    /* JADX INFO: renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m6680maxOfsambcqE(long j, long j2, long j3) {
        return m6679maxOfeb3DHEI(j, m6679maxOfeb3DHEI(j2, j3));
    }

    /* JADX INFO: renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m6678maxOfb33U2AM(byte b, byte b2, byte b3) {
        return m6672maxOfKr8caGY(b, m6672maxOfKr8caGY(b2, b3));
    }

    /* JADX INFO: renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m6675maxOfVKSA0NQ(short s, short s2, short s3) {
        return m6670maxOf5PvTz6A(s, m6670maxOf5PvTz6A(s2, s3));
    }

    /* JADX INFO: renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m6673maxOfMd2H83M(int i, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(other);
        for (int i2 = 0; i2 < iM5628getSizeimpl; i2++) {
            i = m6671maxOfJ1ME1BU(i, UIntArray.m5627getpVg5ArA(other, i2));
        }
        return i;
    }

    /* JADX INFO: renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m6674maxOfR03FKyM(long j, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(other);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            j = m6679maxOfeb3DHEI(j, ULongArray.m5706getsVKNKU(other, i));
        }
        return j;
    }

    /* JADX INFO: renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m6677maxOfWr6uiD8(byte b, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(other);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            b = m6672maxOfKr8caGY(b, UByteArray.m5548getw2LRezQ(other, i));
        }
        return b;
    }

    /* JADX INFO: renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m6681maxOft1qELG4(short s, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(other);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            s = m6670maxOf5PvTz6A(s, UShortArray.m5811getMh2AYeg(other, i));
        }
        return s;
    }

    /* JADX INFO: renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static int m6683minOfJ1ME1BU(int i, int i2) {
        return Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) <= 0 ? i : i2;
    }

    /* JADX INFO: renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static long m6691minOfeb3DHEI(long j, long j2) {
        return Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) <= 0 ? j : j2;
    }

    /* JADX INFO: renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m6684minOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) <= 0 ? b : b2;
    }

    /* JADX INFO: renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m6682minOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) <= 0 ? s : s2;
    }

    /* JADX INFO: renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m6688minOfWZ9TVnA(int i, int i2, int i3) {
        return m6683minOfJ1ME1BU(i, m6683minOfJ1ME1BU(i2, i3));
    }

    /* JADX INFO: renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m6692minOfsambcqE(long j, long j2, long j3) {
        return m6691minOfeb3DHEI(j, m6691minOfeb3DHEI(j2, j3));
    }

    /* JADX INFO: renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m6690minOfb33U2AM(byte b, byte b2, byte b3) {
        return m6684minOfKr8caGY(b, m6684minOfKr8caGY(b2, b3));
    }

    /* JADX INFO: renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m6687minOfVKSA0NQ(short s, short s2, short s3) {
        return m6682minOf5PvTz6A(s, m6682minOf5PvTz6A(s2, s3));
    }

    /* JADX INFO: renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m6685minOfMd2H83M(int i, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5628getSizeimpl = UIntArray.m5628getSizeimpl(other);
        for (int i2 = 0; i2 < iM5628getSizeimpl; i2++) {
            i = m6683minOfJ1ME1BU(i, UIntArray.m5627getpVg5ArA(other, i2));
        }
        return i;
    }

    /* JADX INFO: renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m6686minOfR03FKyM(long j, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5707getSizeimpl = ULongArray.m5707getSizeimpl(other);
        for (int i = 0; i < iM5707getSizeimpl; i++) {
            j = m6691minOfeb3DHEI(j, ULongArray.m5706getsVKNKU(other, i));
        }
        return j;
    }

    /* JADX INFO: renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m6689minOfWr6uiD8(byte b, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5549getSizeimpl = UByteArray.m5549getSizeimpl(other);
        for (int i = 0; i < iM5549getSizeimpl; i++) {
            b = m6684minOfKr8caGY(b, UByteArray.m5548getw2LRezQ(other, i));
        }
        return b;
    }

    /* JADX INFO: renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m6693minOft1qELG4(short s, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5812getSizeimpl = UShortArray.m5812getSizeimpl(other);
        for (int i = 0; i < iM5812getSizeimpl; i++) {
            s = m6682minOf5PvTz6A(s, UShortArray.m5811getMh2AYeg(other, i));
        }
        return s;
    }
}
