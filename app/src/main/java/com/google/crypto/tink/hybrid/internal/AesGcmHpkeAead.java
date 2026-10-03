package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.aead.internal.InsecureNonceAesGcmJce;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
final class AesGcmHpkeAead implements HpkeAead {
    private final int keyLength;

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public int getNonceLength() {
        return 12;
    }

    AesGcmHpkeAead(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException("Unsupported key length: " + i);
        }
        this.keyLength = i;
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] seal(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != this.keyLength) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: " + bArr.length);
        }
        return new InsecureNonceAesGcmJce(bArr).encrypt(bArr2, bArr3, i, bArr4);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] open(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != this.keyLength) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: " + bArr.length);
        }
        return new InsecureNonceAesGcmJce(bArr).decrypt(bArr2, bArr3, i, bArr4);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] getAeadId() throws GeneralSecurityException {
        int i = this.keyLength;
        if (i == 16) {
            return HpkeUtil.AES_128_GCM_AEAD_ID;
        }
        if (i == 32) {
            return HpkeUtil.AES_256_GCM_AEAD_ID;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public int getKeyLength() {
        return this.keyLength;
    }
}
