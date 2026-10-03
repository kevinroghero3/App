package com.google.crypto.tink.aead.internal;

import com.google.common.base.Ascii;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class Poly1305 {
    public static final int MAC_KEY_SIZE_IN_BYTES = 32;
    public static final int MAC_TAG_SIZE_IN_BYTES = 16;

    private Poly1305() {
    }

    private static long load32(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16))) & 4294967295L;
    }

    private static long load26(byte[] bArr, int i, int i2) {
        return (load32(bArr, i) >> i2) & 67108863;
    }

    private static void toByteArray(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) (255 & j);
            i2++;
            j >>= 8;
        }
    }

    private static void copyBlockSize(byte[] bArr, byte[] bArr2, int i) {
        int iMin = Math.min(16, bArr2.length - i);
        System.arraycopy(bArr2, i, bArr, 0, iMin);
        bArr[iMin] = 1;
        if (iMin != 16) {
            Arrays.fill(bArr, iMin + 1, bArr.length, (byte) 0);
        }
    }

    public static byte[] computeMac(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        int i = 0;
        long jLoad26 = load26(bArr, 0, 0) & 67108863;
        int i2 = 3;
        long jLoad27 = load26(bArr, 3, 2) & 67108611;
        long jLoad28 = load26(bArr, 6, 4) & 67092735;
        long jLoad29 = load26(bArr, 9, 6) & 66076671;
        long jLoad210 = load26(bArr, 12, 8) & 1048575;
        long j = jLoad28 * 5;
        long j2 = jLoad29 * 5;
        long j3 = jLoad210 * 5;
        byte[] bArr3 = new byte[17];
        long j4 = 0;
        int i3 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        while (i3 < bArr2.length) {
            copyBlockSize(bArr3, bArr2, i3);
            long jLoad211 = j8 + load26(bArr3, i, i);
            long jLoad212 = j5 + load26(bArr3, i2, 2);
            long jLoad213 = j4 + load26(bArr3, 6, 4);
            long jLoad214 = j6 + load26(bArr3, 9, 6);
            long jLoad215 = j7 + (load26(bArr3, 12, 8) | ((long) (bArr3[16] << Ascii.CAN)));
            long j9 = (jLoad211 * jLoad26) + (jLoad212 * j3) + (jLoad213 * j2) + (jLoad214 * j) + (jLoad27 * 5 * jLoad215);
            long j10 = (jLoad211 * jLoad27) + (jLoad212 * jLoad26) + (jLoad213 * j3) + (jLoad214 * j2) + (jLoad215 * j) + (j9 >> 26);
            long j11 = (jLoad211 * jLoad28) + (jLoad212 * jLoad27) + (jLoad213 * jLoad26) + (jLoad214 * j3) + (jLoad215 * j2) + (j10 >> 26);
            long j12 = (jLoad211 * jLoad29) + (jLoad212 * jLoad28) + (jLoad213 * jLoad27) + (jLoad214 * jLoad26) + (jLoad215 * j3) + (j11 >> 26);
            long j13 = (jLoad211 * jLoad210) + (jLoad212 * jLoad29) + (jLoad213 * jLoad28) + (jLoad214 * jLoad27) + (jLoad215 * jLoad26) + (j12 >> 26);
            long j14 = (j9 & 67108863) + ((j13 >> 26) * 5);
            j5 = (j10 & 67108863) + (j14 >> 26);
            i3 += 16;
            j4 = j11 & 67108863;
            j6 = j12 & 67108863;
            j7 = j13 & 67108863;
            j8 = j14 & 67108863;
            i = 0;
            i2 = 3;
        }
        long j15 = j4 + (j5 >> 26);
        long j16 = j15 & 67108863;
        long j17 = j6 + (j15 >> 26);
        long j18 = j17 & 67108863;
        long j19 = j7 + (j17 >> 26);
        long j20 = j19 & 67108863;
        long j21 = j8 + ((j19 >> 26) * 5);
        long j22 = j21 & 67108863;
        long j23 = (j5 & 67108863) + (j21 >> 26);
        long j24 = j22 + 5;
        long j25 = (j24 >> 26) + j23;
        long j26 = j16 + (j25 >> 26);
        long j27 = j18 + (j26 >> 26);
        long j28 = (j20 + (j27 >> 26)) - 67108864;
        long j29 = j28 >> 63;
        long j30 = ~j29;
        long j31 = (j25 & 67108863 & j30) | (j23 & j29);
        long j32 = (j26 & 67108863 & j30) | (j16 & j29);
        long j33 = (j27 & 67108863 & j30) | (j18 & j29);
        long jLoad32 = (((j22 & j29) | (j24 & 67108863 & j30) | (j31 << 26)) & 4294967295L) + load32(bArr, 16);
        long jLoad33 = (((j31 >> 6) | (j32 << 20)) & 4294967295L) + load32(bArr, 20) + (jLoad32 >> 32);
        long jLoad34 = (((j32 >> 12) | (j33 << 14)) & 4294967295L) + load32(bArr, 24) + (jLoad33 >> 32);
        long jLoad35 = load32(bArr, 28);
        byte[] bArr4 = new byte[16];
        toByteArray(bArr4, jLoad32 & 4294967295L, 0);
        toByteArray(bArr4, jLoad33 & 4294967295L, 4);
        toByteArray(bArr4, jLoad34 & 4294967295L, 8);
        toByteArray(bArr4, ((((j33 >> 18) | (((j20 & j29) | (j28 & j30)) << 8)) & 4294967295L) + jLoad35 + (jLoad34 >> 32)) & 4294967295L, 12);
        return bArr4;
    }

    public static void verifyMac(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (!Bytes.equal(computeMac(bArr, bArr2), bArr3)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
