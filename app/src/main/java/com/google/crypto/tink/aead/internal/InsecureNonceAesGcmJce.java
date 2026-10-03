package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public final class InsecureNonceAesGcmJce {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    public static final int IV_SIZE_IN_BYTES = 12;
    public static final int TAG_SIZE_IN_BYTES = 16;
    private final SecretKey keySpec;

    public InsecureNonceAesGcmJce(byte[] bArr) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.keySpec = AesGcmJceUtil.getSecretKey(bArr);
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return encrypt(bArr, bArr2, 0, bArr3);
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        AlgorithmParameterSpec params = AesGcmJceUtil.getParams(bArr);
        Cipher threadLocalCipher = AesGcmJceUtil.getThreadLocalCipher();
        threadLocalCipher.init(1, this.keySpec, params);
        if (bArr3 != null && bArr3.length != 0) {
            threadLocalCipher.updateAAD(bArr3);
        }
        int outputSize = threadLocalCipher.getOutputSize(bArr2.length);
        if (outputSize > Integer.MAX_VALUE - i) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr4 = new byte[i + outputSize];
        if (threadLocalCipher.doFinal(bArr2, 0, bArr2.length, bArr4, i) == outputSize) {
            return bArr4;
        }
        throw new GeneralSecurityException("not enough data written");
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return decrypt(bArr, bArr2, 0, bArr3);
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        if (bArr2.length < i + 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec params = AesGcmJceUtil.getParams(bArr);
        Cipher threadLocalCipher = AesGcmJceUtil.getThreadLocalCipher();
        threadLocalCipher.init(2, this.keySpec, params);
        if (bArr3 != null && bArr3.length != 0) {
            threadLocalCipher.updateAAD(bArr3);
        }
        return threadLocalCipher.doFinal(bArr2, i, bArr2.length - i);
    }
}
