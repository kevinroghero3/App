package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.subtle.Bytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: loaded from: classes2.dex */
abstract class InsecureNonceChaCha20Base {
    private final int initialCounter;
    int[] key;

    abstract int[] createInitialState(int[] iArr, int i);

    abstract int nonceSizeInBytes();

    public InsecureNonceChaCha20Base(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.key = ChaCha20Util.toIntArray(bArr);
        this.initialCounter = i;
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr2.length);
        encrypt(byteBufferAllocate, bArr, bArr2);
        return byteBufferAllocate.array();
    }

    public void encrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        process(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return decrypt(bArr, ByteBuffer.wrap(bArr2));
    }

    public byte[] decrypt(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        process(bArr, byteBufferAllocate, byteBuffer);
        return byteBufferAllocate.array();
    }

    private void process(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        if (bArr.length != nonceSizeInBytes()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + nonceSizeInBytes());
        }
        int iRemaining = byteBuffer2.remaining();
        int i = iRemaining / 64;
        for (int i2 = 0; i2 < i + 1; i2++) {
            ByteBuffer byteBufferChacha20Block = chacha20Block(bArr, this.initialCounter + i2);
            if (i2 == i) {
                Bytes.xor(byteBuffer, byteBuffer2, byteBufferChacha20Block, iRemaining % 64);
            } else {
                Bytes.xor(byteBuffer, byteBuffer2, byteBufferChacha20Block, 64);
            }
        }
    }

    ByteBuffer chacha20Block(byte[] bArr, int i) {
        int[] iArrCreateInitialState = createInitialState(ChaCha20Util.toIntArray(bArr), i);
        int[] iArr = (int[]) iArrCreateInitialState.clone();
        ChaCha20Util.shuffleState(iArr);
        for (int i2 = 0; i2 < iArrCreateInitialState.length; i2++) {
            iArrCreateInitialState[i2] = iArrCreateInitialState[i2] + iArr[i2];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrCreateInitialState, 0, 16);
        return byteBufferOrder;
    }
}
