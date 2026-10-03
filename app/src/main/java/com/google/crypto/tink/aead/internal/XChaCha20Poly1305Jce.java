package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.XChaCha20Poly1305Key;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.Random;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class XChaCha20Poly1305Jce implements Aead {
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final String KEY_NAME = "ChaCha20";
    private static final int KEY_SIZE_IN_BYTES = 32;
    private static final int NONCE_SIZE_IN_BYTES = 24;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final byte[] key;
    private final byte[] outputPrefix;
    private final Provider provider;

    private XChaCha20Poly1305Jce(byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.key = bArr;
        this.outputPrefix = bArr2;
        this.provider = provider;
    }

    public static Aead create(XChaCha20Poly1305Key xChaCha20Poly1305Key) throws GeneralSecurityException {
        return new XChaCha20Poly1305Jce(xChaCha20Poly1305Key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), xChaCha20Poly1305Key.getOutputPrefix().toByteArray(), ChaCha20Poly1305Jce.getValidCipherInstance().getProvider());
    }

    public static boolean isSupported() {
        return ChaCha20Poly1305Jce.isSupported();
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("plaintext is null");
        }
        byte[] bArrRandBytes = Random.randBytes(24);
        SecretKeySpec secretKeySpec = new SecretKeySpec(ChaCha20Util.hChaCha20(this.key, bArrRandBytes), KEY_NAME);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(getChaCha20Nonce(bArrRandBytes));
        Cipher cipherInstance = ChaCha20Poly1305Jce.getCipherInstance(this.provider);
        cipherInstance.init(1, secretKeySpec, ivParameterSpec);
        if (bArr2 != null && bArr2.length != 0) {
            cipherInstance.updateAAD(bArr2);
        }
        int outputSize = cipherInstance.getOutputSize(bArr.length);
        byte[] bArr3 = this.outputPrefix;
        if (outputSize > 2147483623 - bArr3.length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + 24 + outputSize);
        System.arraycopy(bArrRandBytes, 0, bArrCopyOf, this.outputPrefix.length, 24);
        if (cipherInstance.doFinal(bArr, 0, bArr.length, bArrCopyOf, this.outputPrefix.length + 24) == outputSize) {
            return bArrCopyOf;
        }
        throw new GeneralSecurityException("not enough data written");
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        int length = bArr.length;
        byte[] bArr3 = this.outputPrefix;
        if (length < bArr3.length + 40) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!Util.isPrefix(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArr4 = new byte[24];
        System.arraycopy(bArr, this.outputPrefix.length, bArr4, 0, 24);
        SecretKeySpec secretKeySpec = new SecretKeySpec(ChaCha20Util.hChaCha20(this.key, bArr4), KEY_NAME);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(getChaCha20Nonce(bArr4));
        Cipher cipherInstance = ChaCha20Poly1305Jce.getCipherInstance(this.provider);
        cipherInstance.init(2, secretKeySpec, ivParameterSpec);
        if (bArr2 != null && bArr2.length != 0) {
            cipherInstance.updateAAD(bArr2);
        }
        byte[] bArr5 = this.outputPrefix;
        return cipherInstance.doFinal(bArr, bArr5.length + 24, (bArr.length - bArr5.length) - 24);
    }

    static byte[] getChaCha20Nonce(byte[] bArr) {
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 16, bArr2, 4, 8);
        return bArr2;
    }
}
