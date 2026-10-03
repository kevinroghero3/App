package com.google.crypto.tink.aead.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class ChaCha20Util {
    static final int BLOCK_SIZE_IN_BYTES = 64;
    static final int BLOCK_SIZE_IN_INTS = 16;
    static final int KEY_SIZE_IN_BYTES = 32;
    static final int KEY_SIZE_IN_INTS = 8;
    private static final int[] sigma = toIntArray(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    private static int rotateLeft(int i, int i2) {
        return (i << i2) | (i >>> (-i2));
    }

    static void setSigmaAndKey(int[] iArr, int[] iArr2) {
        int[] iArr3 = sigma;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    static void shuffleState(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            quarterRound(iArr, 0, 4, 8, 12);
            quarterRound(iArr, 1, 5, 9, 13);
            quarterRound(iArr, 2, 6, 10, 14);
            quarterRound(iArr, 3, 7, 11, 15);
            quarterRound(iArr, 0, 5, 10, 15);
            quarterRound(iArr, 1, 6, 11, 12);
            quarterRound(iArr, 2, 7, 8, 13);
            quarterRound(iArr, 3, 4, 9, 14);
        }
    }

    static void quarterRound(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int iRotateLeft = rotateLeft(i5 ^ iArr[i4], 16);
        iArr[i4] = iRotateLeft;
        int i6 = iArr[i3] + iRotateLeft;
        iArr[i3] = i6;
        int iRotateLeft2 = rotateLeft(iArr[i2] ^ i6, 12);
        iArr[i2] = iRotateLeft2;
        int i7 = iArr[i] + iRotateLeft2;
        iArr[i] = i7;
        int iRotateLeft3 = rotateLeft(iArr[i4] ^ i7, 8);
        iArr[i4] = iRotateLeft3;
        int i8 = iArr[i3] + iRotateLeft3;
        iArr[i3] = i8;
        iArr[i2] = rotateLeft(iArr[i2] ^ i8, 7);
    }

    static int[] toIntArray(byte[] bArr) {
        if (bArr.length % 4 != 0) {
            throw new IllegalArgumentException("invalid input length");
        }
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }

    static byte[] toByteArray(int[] iArr) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(iArr.length * 4).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArr);
        return byteBufferOrder.array();
    }

    static int[] hChaCha20(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        setSigmaAndKey(iArr3, iArr);
        iArr3[12] = iArr2[0];
        iArr3[13] = iArr2[1];
        iArr3[14] = iArr2[2];
        iArr3[15] = iArr2[3];
        shuffleState(iArr3);
        iArr3[4] = iArr3[12];
        iArr3[5] = iArr3[13];
        iArr3[6] = iArr3[14];
        iArr3[7] = iArr3[15];
        return Arrays.copyOf(iArr3, 8);
    }

    static byte[] hChaCha20(byte[] bArr, byte[] bArr2) {
        return toByteArray(hChaCha20(toIntArray(bArr), toIntArray(bArr2)));
    }

    private ChaCha20Util() {
    }
}
