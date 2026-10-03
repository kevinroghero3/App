package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.AesGcmSivKey;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.Hex;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class AesGcmSiv implements Aead {
    private static final int IV_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final ThrowingSupplier<Cipher> cipherSupplier;
    private final SecretKey keySpec;
    private final byte[] outputPrefix;
    private static final byte[] testPlaintext = Hex.decode("7a806c");
    private static final byte[] testAad = Hex.decode("46bb91c3c5");
    private static final byte[] testKey = Hex.decode("36864200e0eaf5284d884a0e77d31646");
    private static final byte[] testNounce = Hex.decode("bae8e37fc83441b16034566b");
    private static final byte[] testResult = Hex.decode("af60eb711bd85bc1e4d3e0a462e074eea428a8");

    public interface ThrowingSupplier<T> {
        T get() throws GeneralSecurityException;
    }

    public static boolean isAesGcmSivCipher(Cipher cipher) {
        try {
            cipher.init(2, new SecretKeySpec(testKey, "AES"), getParams(testNounce));
            cipher.updateAAD(testAad);
            byte[] bArr = testResult;
            return Bytes.equal(cipher.doFinal(bArr, 0, bArr.length), testPlaintext);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public static Aead create(AesGcmSivKey aesGcmSivKey, ThrowingSupplier<Cipher> throwingSupplier) throws GeneralSecurityException {
        if (!isAesGcmSivCipher(throwingSupplier.get())) {
            throw new IllegalStateException("Cipher does not implement AES GCM SIV.");
        }
        return new AesGcmSiv(aesGcmSivKey.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), aesGcmSivKey.getOutputPrefix().toByteArray(), throwingSupplier);
    }

    private AesGcmSiv(byte[] bArr, byte[] bArr2, ThrowingSupplier<Cipher> throwingSupplier) throws GeneralSecurityException {
        this.outputPrefix = bArr2;
        Validators.validateAesKeySize(bArr.length);
        this.keySpec = new SecretKeySpec(bArr, "AES");
        this.cipherSupplier = throwingSupplier;
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = this.cipherSupplier.get();
        int length = bArr.length;
        byte[] bArr3 = this.outputPrefix;
        if (length > 2147483619 - bArr3.length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + 12 + bArr.length + 16);
        byte[] bArrRandBytes = Random.randBytes(12);
        System.arraycopy(bArrRandBytes, 0, bArrCopyOf, this.outputPrefix.length, 12);
        cipher.init(1, this.keySpec, getParams(bArrRandBytes));
        if (bArr2 != null && bArr2.length != 0) {
            cipher.updateAAD(bArr2);
        }
        int iDoFinal = cipher.doFinal(bArr, 0, bArr.length, bArrCopyOf, this.outputPrefix.length + 12);
        if (iDoFinal == bArr.length + 16) {
            return bArrCopyOf;
        }
        throw new GeneralSecurityException(String.format("encryption failed; AES-GCM-SIV tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(iDoFinal - bArr.length)));
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.outputPrefix;
        if (length < bArr3.length + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!Util.isPrefix(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        Cipher cipher = this.cipherSupplier.get();
        cipher.init(2, this.keySpec, getParams(bArr, this.outputPrefix.length, 12));
        if (bArr2 != null && bArr2.length != 0) {
            cipher.updateAAD(bArr2);
        }
        byte[] bArr4 = this.outputPrefix;
        return cipher.doFinal(bArr, bArr4.length + 12, (bArr.length - bArr4.length) - 12);
    }

    private static AlgorithmParameterSpec getParams(byte[] bArr) {
        return getParams(bArr, 0, bArr.length);
    }

    private static AlgorithmParameterSpec getParams(byte[] bArr, int i, int i2) {
        return new GCMParameterSpec(128, bArr, i, i2);
    }
}
