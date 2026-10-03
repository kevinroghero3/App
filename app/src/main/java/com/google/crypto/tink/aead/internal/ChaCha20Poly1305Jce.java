package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.ChaCha20Poly1305Key;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Hex;
import com.google.crypto.tink.subtle.Random;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class ChaCha20Poly1305Jce implements Aead {
    private static final String CIPHER_NAME = "ChaCha20-Poly1305";
    private static final String KEY_NAME = "ChaCha20";
    private static final int KEY_SIZE_IN_BYTES = 32;
    private static final int NONCE_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final SecretKey keySpec;
    private final byte[] outputPrefix;
    private final Provider provider;
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final byte[] testKey = Hex.decode("808182838485868788898a8b8c8d8e8f909192939495969798999a9b9c9d9e9f");
    private static final byte[] testNonce = Hex.decode("070000004041424344454647");
    private static final byte[] testCiphertextOfEmpty = Hex.decode("a0784d7a4716f3feb4f64e7f4b39bf04");

    private static boolean isValid(Cipher cipher) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(testNonce);
            byte[] bArr = testKey;
            cipher.init(2, new SecretKeySpec(bArr, KEY_NAME), ivParameterSpec);
            byte[] bArr2 = testCiphertextOfEmpty;
            if (cipher.doFinal(bArr2).length != 0) {
                return false;
            }
            cipher.init(2, new SecretKeySpec(bArr, KEY_NAME), ivParameterSpec);
            return cipher.doFinal(bArr2).length == 0;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    private ChaCha20Poly1305Jce(byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.keySpec = new SecretKeySpec(bArr, KEY_NAME);
        this.outputPrefix = bArr2;
        this.provider = provider;
    }

    public static Aead create(ChaCha20Poly1305Key chaCha20Poly1305Key) throws GeneralSecurityException {
        return new ChaCha20Poly1305Jce(chaCha20Poly1305Key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), chaCha20Poly1305Key.getOutputPrefix().toByteArray(), getValidCipherInstance().getProvider());
    }

    static Cipher getValidCipherInstance() throws GeneralSecurityException {
        Cipher engineFactory = EngineFactory.CIPHER.getInstance(CIPHER_NAME);
        if (isValid(engineFactory)) {
            return engineFactory;
        }
        throw new GeneralSecurityException("JCE does not support algorithm: ChaCha20-Poly1305");
    }

    static Cipher getCipherInstance(Provider provider) throws GeneralSecurityException {
        return Cipher.getInstance(CIPHER_NAME, provider);
    }

    public static boolean isSupported() {
        try {
            getValidCipherInstance();
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("plaintext is null");
        }
        byte[] bArrRandBytes = Random.randBytes(12);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArrRandBytes);
        Cipher cipherInstance = getCipherInstance(this.provider);
        cipherInstance.init(1, this.keySpec, ivParameterSpec);
        if (bArr2 != null && bArr2.length != 0) {
            cipherInstance.updateAAD(bArr2);
        }
        int outputSize = cipherInstance.getOutputSize(bArr.length);
        byte[] bArr3 = this.outputPrefix;
        if (outputSize > 2147483635 - bArr3.length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + 12 + outputSize);
        System.arraycopy(bArrRandBytes, 0, bArrCopyOf, this.outputPrefix.length, 12);
        if (cipherInstance.doFinal(bArr, 0, bArr.length, bArrCopyOf, this.outputPrefix.length + 12) == outputSize) {
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
        if (length < bArr3.length + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!Util.isPrefix(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArr4 = new byte[12];
        System.arraycopy(bArr, this.outputPrefix.length, bArr4, 0, 12);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        Cipher cipherInstance = getCipherInstance(this.provider);
        cipherInstance.init(2, this.keySpec, ivParameterSpec);
        if (bArr2 != null && bArr2.length != 0) {
            cipherInstance.updateAAD(bArr2);
        }
        byte[] bArr5 = this.outputPrefix;
        return cipherInstance.doFinal(bArr, bArr5.length + 12, (bArr.length - bArr5.length) - 12);
    }
}
