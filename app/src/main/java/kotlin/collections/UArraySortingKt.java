package kotlin.collections;

import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class UArraySortingKt {
    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m5932partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte bM5548getw2LRezQ = UByteArray.m5548getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = bM5548getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m5548getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m5548getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM5548getw2LRezQ2 = UByteArray.m5548getw2LRezQ(bArr, i);
                UByteArray.m5553setVurrAj0(bArr, i, UByteArray.m5548getw2LRezQ(bArr, i2));
                UByteArray.m5553setVurrAj0(bArr, i2, bM5548getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m5936quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM5932partition4UcCI2c = m5932partition4UcCI2c(bArr, i, i2);
        int i3 = iM5932partition4UcCI2c - 1;
        if (i < i3) {
            m5936quickSort4UcCI2c(bArr, i, i3);
        }
        if (iM5932partition4UcCI2c < i2) {
            m5936quickSort4UcCI2c(bArr, iM5932partition4UcCI2c, i2);
        }
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m5933partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short sM5811getMh2AYeg = UShortArray.m5811getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                short sM5811getMh2AYeg2 = UShortArray.m5811getMh2AYeg(sArr, i);
                i3 = sM5811getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(sM5811getMh2AYeg2 & UShort.MAX_VALUE, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m5811getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM5811getMh2AYeg3 = UShortArray.m5811getMh2AYeg(sArr, i);
                UShortArray.m5816set01HTLdE(sArr, i, UShortArray.m5811getMh2AYeg(sArr, i2));
                UShortArray.m5816set01HTLdE(sArr, i2, sM5811getMh2AYeg3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m5937quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM5933partitionAa5vz7o = m5933partitionAa5vz7o(sArr, i, i2);
        int i3 = iM5933partitionAa5vz7o - 1;
        if (i < i3) {
            m5937quickSortAa5vz7o(sArr, i, i3);
        }
        if (iM5933partitionAa5vz7o < i2) {
            m5937quickSortAa5vz7o(sArr, iM5933partitionAa5vz7o, i2);
        }
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m5934partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM5627getpVg5ArA = UIntArray.m5627getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compare(UIntArray.m5627getpVg5ArA(iArr, i) ^ Integer.MIN_VALUE, iM5627getpVg5ArA ^ Integer.MIN_VALUE) < 0) {
                i++;
            }
            while (Integer.compare(UIntArray.m5627getpVg5ArA(iArr, i2) ^ Integer.MIN_VALUE, iM5627getpVg5ArA ^ Integer.MIN_VALUE) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM5627getpVg5ArA2 = UIntArray.m5627getpVg5ArA(iArr, i);
                UIntArray.m5632setVXSXFK8(iArr, i, UIntArray.m5627getpVg5ArA(iArr, i2));
                UIntArray.m5632setVXSXFK8(iArr, i2, iM5627getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m5938quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM5934partitionoBK06Vg = m5934partitionoBK06Vg(iArr, i, i2);
        int i3 = iM5934partitionoBK06Vg - 1;
        if (i < i3) {
            m5938quickSortoBK06Vg(iArr, i, i3);
        }
        if (iM5934partitionoBK06Vg < i2) {
            m5938quickSortoBK06Vg(iArr, iM5934partitionoBK06Vg, i2);
        }
    }

    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m5931partitionnroSd4(long[] jArr, int i, int i2) {
        long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compare(ULongArray.m5706getsVKNKU(jArr, i) ^ Long.MIN_VALUE, jM5706getsVKNKU ^ Long.MIN_VALUE) < 0) {
                i++;
            }
            while (Long.compare(ULongArray.m5706getsVKNKU(jArr, i2) ^ Long.MIN_VALUE, jM5706getsVKNKU ^ Long.MIN_VALUE) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM5706getsVKNKU2 = ULongArray.m5706getsVKNKU(jArr, i);
                ULongArray.m5711setk8EXiF4(jArr, i, ULongArray.m5706getsVKNKU(jArr, i2));
                ULongArray.m5711setk8EXiF4(jArr, i2, jM5706getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m5935quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM5931partitionnroSd4 = m5931partitionnroSd4(jArr, i, i2);
        int i3 = iM5931partitionnroSd4 - 1;
        if (i < i3) {
            m5935quickSortnroSd4(jArr, i, i3);
        }
        if (iM5931partitionnroSd4 < i2) {
            m5935quickSortnroSd4(jArr, iM5931partitionnroSd4, i2);
        }
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m5940sortArray4UcCI2c(@NotNull byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m5936quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m5941sortArrayAa5vz7o(@NotNull short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m5937quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m5942sortArrayoBK06Vg(@NotNull int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m5938quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m5939sortArraynroSd4(@NotNull long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m5935quickSortnroSd4(array, i, i2 - 1);
    }
}
