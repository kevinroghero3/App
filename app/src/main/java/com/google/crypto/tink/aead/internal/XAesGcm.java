package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.XAesGcmKey;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.prf.AesCmacPrfKey;
import com.google.crypto.tink.prf.AesCmacPrfParameters;
import com.google.crypto.tink.prf.Prf;
import com.google.crypto.tink.subtle.PrfAesCmac;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class XAesGcm implements Aead {
    private static final int DERIVED_KEY_SIZE_IN_BYTES = 32;
    private static final int IV_SIZE_IN_BYTES = 12;
    private static final int MAX_SALT_SIZE_IN_BYTES = 12;
    private static final int MIN_SALT_SIZE_IN_BYTES = 8;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final Prf cmac;
    private final byte[] outputPrefix;
    private final int saltSize;

    private static Prf createCmac(byte[] bArr) throws GeneralSecurityException {
        return PrfAesCmac.create(AesCmacPrfKey.create(AesCmacPrfParameters.create(bArr.length), SecretBytes.copyFrom(bArr, InsecureSecretKeyAccess.get())));
    }

    private XAesGcm(byte[] bArr, Bytes bytes, int i) throws GeneralSecurityException {
        this.cmac = createCmac(bArr);
        this.outputPrefix = bytes.toByteArray();
        this.saltSize = i;
    }

    public static Aead create(XAesGcmKey xAesGcmKey) throws GeneralSecurityException {
        if (xAesGcmKey.getParameters().getSaltSizeBytes() < 8 || xAesGcmKey.getParameters().getSaltSizeBytes() > 12) {
            throw new GeneralSecurityException("invalid salt size");
        }
        return new XAesGcm(xAesGcmKey.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), xAesGcmKey.getOutputPrefix(), xAesGcmKey.getParameters().getSaltSizeBytes());
    }

    private byte[] derivePerMessageKey(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = {0, 1, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] bArr3 = {0, 2, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        if (bArr.length > 12 || bArr.length < 8) {
            throw new GeneralSecurityException("invalid salt size");
        }
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        byte[] bArr4 = new byte[32];
        System.arraycopy(this.cmac.compute(bArr2, 16), 0, bArr4, 0, 16);
        System.arraycopy(this.cmac.compute(bArr3, 16), 0, bArr4, 16, 16);
        return bArr4;
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("plaintext is null");
        }
        byte[] bArrRandBytes = Random.randBytes(this.saltSize + 12);
        byte[] bArrCopyOf = Arrays.copyOf(bArrRandBytes, this.saltSize);
        int i = this.saltSize;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrRandBytes, i, i + 12);
        byte[] bArrEncrypt = new InsecureNonceAesGcmJce(derivePerMessageKey(bArrCopyOf)).encrypt(bArrCopyOfRange, bArr, this.outputPrefix.length + this.saltSize + bArrCopyOfRange.length, bArr2);
        byte[] bArr3 = this.outputPrefix;
        System.arraycopy(bArr3, 0, bArrEncrypt, 0, bArr3.length);
        System.arraycopy(bArrRandBytes, 0, bArrEncrypt, this.outputPrefix.length, bArrRandBytes.length);
        return bArrEncrypt;
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        int length = bArr.length;
        byte[] bArr3 = this.outputPrefix;
        if (length < bArr3.length + this.saltSize + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!Util.isPrefix(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArr4 = this.outputPrefix;
        int length2 = bArr4.length + this.saltSize;
        InsecureNonceAesGcmJce insecureNonceAesGcmJce = new InsecureNonceAesGcmJce(derivePerMessageKey(Arrays.copyOfRange(bArr, bArr4.length, length2)));
        int i = length2 + 12;
        return insecureNonceAesGcmJce.decrypt(Arrays.copyOfRange(bArr, length2, i), bArr, i, bArr2);
    }
}
