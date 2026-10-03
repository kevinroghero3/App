package com.google.crypto.tink.aead.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.subtle.AesGcmJce;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class AesGcmFactory implements AeadFactory {
    private final int keySizeInBytes;

    public AesGcmFactory(int i) throws GeneralSecurityException {
        this.keySizeInBytes = validateAesKeySize(i);
    }

    @Override // com.google.crypto.tink.aead.subtle.AeadFactory
    public int getKeySizeInBytes() {
        return this.keySizeInBytes;
    }

    @Override // com.google.crypto.tink.aead.subtle.AeadFactory
    public Aead createAead(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != getKeySizeInBytes()) {
            throw new GeneralSecurityException(String.format("Symmetric key has incorrect length; expected %s, but got %s", Integer.valueOf(getKeySizeInBytes()), Integer.valueOf(bArr.length)));
        }
        return new AesGcmJce(bArr);
    }

    private static int validateAesKeySize(int i) throws InvalidAlgorithmParameterException {
        if (i == 16 || i == 32) {
            return i;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid AES key size, expected 16 or 32, but got %d", Integer.valueOf(i)));
    }
}
