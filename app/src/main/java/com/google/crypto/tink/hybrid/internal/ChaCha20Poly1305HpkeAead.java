package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.aead.internal.InsecureNonceChaCha20Poly1305;
import com.google.crypto.tink.aead.internal.InsecureNonceChaCha20Poly1305Jce;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
final class ChaCha20Poly1305HpkeAead implements HpkeAead {
    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public int getKeyLength() {
        return 32;
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public int getNonceLength() {
        return 12;
    }

    ChaCha20Poly1305HpkeAead() {
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] seal(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != getKeyLength()) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: " + getKeyLength());
        }
        if (InsecureNonceChaCha20Poly1305Jce.isSupported()) {
            return InsecureNonceChaCha20Poly1305Jce.create(bArr).encrypt(bArr2, bArr3, i, bArr4);
        }
        byte[] bArrEncrypt = new InsecureNonceChaCha20Poly1305(bArr).encrypt(bArr2, bArr3, bArr4);
        if (bArrEncrypt.length > Integer.MAX_VALUE - i) {
            throw new InvalidAlgorithmParameterException("Plaintext too long");
        }
        byte[] bArr5 = new byte[bArrEncrypt.length + i];
        System.arraycopy(bArrEncrypt, 0, bArr5, i, bArrEncrypt.length);
        return bArr5;
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] open(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != getKeyLength()) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: " + getKeyLength());
        }
        if (InsecureNonceChaCha20Poly1305Jce.isSupported()) {
            return InsecureNonceChaCha20Poly1305Jce.create(bArr).decrypt(bArr2, bArr3, i, bArr4);
        }
        return new InsecureNonceChaCha20Poly1305(bArr).decrypt(bArr2, Arrays.copyOfRange(bArr3, i, bArr3.length), bArr4);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] getAeadId() {
        return HpkeUtil.CHACHA20_POLY1305_AEAD_ID;
    }
}
