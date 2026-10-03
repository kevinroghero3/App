package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class InsecureNonceChaCha20Poly1305Jce {
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final String KEY_NAME = "ChaCha20";
    private static final int KEY_SIZE_IN_BYTES = 32;
    private static final int NONCE_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final SecretKey keySpec;
    private final Provider provider;

    private InsecureNonceChaCha20Poly1305Jce(byte[] bArr, Provider provider) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.keySpec = new SecretKeySpec(bArr, KEY_NAME);
        this.provider = provider;
    }

    public static InsecureNonceChaCha20Poly1305Jce create(byte[] bArr) throws GeneralSecurityException {
        return new InsecureNonceChaCha20Poly1305Jce(bArr, ChaCha20Poly1305Jce.getValidCipherInstance().getProvider());
    }

    public static boolean isSupported() {
        return ChaCha20Poly1305Jce.isSupported();
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return encrypt(bArr, bArr2, 0, bArr3);
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) throws GeneralSecurityException {
        if (bArr2 == null) {
            throw new NullPointerException("plaintext is null");
        }
        if (bArr.length != 12) {
            throw new GeneralSecurityException("nonce length must be 12 bytes.");
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher cipherInstance = ChaCha20Poly1305Jce.getCipherInstance(this.provider);
        cipherInstance.init(1, this.keySpec, ivParameterSpec);
        if (bArr3 != null && bArr3.length != 0) {
            cipherInstance.updateAAD(bArr3);
        }
        int outputSize = cipherInstance.getOutputSize(bArr2.length);
        if (outputSize > Integer.MAX_VALUE - i) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr4 = new byte[i + outputSize];
        if (cipherInstance.doFinal(bArr2, 0, bArr2.length, bArr4, i) == outputSize) {
            return bArr4;
        }
        throw new GeneralSecurityException("not enough data written");
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return decrypt(bArr, bArr2, 0, bArr3);
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) throws GeneralSecurityException {
        if (bArr2 == null) {
            throw new NullPointerException("ciphertext is null");
        }
        if (bArr.length != 12) {
            throw new GeneralSecurityException("nonce length must be 12 bytes.");
        }
        if (bArr2.length < i + 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher cipherInstance = ChaCha20Poly1305Jce.getCipherInstance(this.provider);
        cipherInstance.init(2, this.keySpec, ivParameterSpec);
        if (bArr3 != null && bArr3.length != 0) {
            cipherInstance.updateAAD(bArr3);
        }
        return cipherInstance.doFinal(bArr2, i, bArr2.length - i);
    }
}
