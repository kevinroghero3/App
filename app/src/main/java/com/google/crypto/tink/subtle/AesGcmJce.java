package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.AesGcmKey;
import com.google.crypto.tink.aead.internal.AesGcmJceUtil;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Util;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class AesGcmJce implements Aead {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final int IV_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final SecretKey keySpec;
    private final byte[] outputPrefix;

    private AesGcmJce(byte[] bArr, com.google.crypto.tink.util.Bytes bytes) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.keySpec = AesGcmJceUtil.getSecretKey(bArr);
        this.outputPrefix = bytes.toByteArray();
    }

    public AesGcmJce(byte[] bArr) throws GeneralSecurityException {
        this(bArr, com.google.crypto.tink.util.Bytes.copyFrom(new byte[0]));
    }

    public static Aead create(AesGcmKey aesGcmKey) throws GeneralSecurityException {
        if (aesGcmKey.getParameters().getIvSizeBytes() != 12) {
            throw new GeneralSecurityException("Expected IV Size 12, got " + aesGcmKey.getParameters().getIvSizeBytes());
        }
        if (aesGcmKey.getParameters().getTagSizeBytes() != 16) {
            throw new GeneralSecurityException("Expected tag Size 16, got " + aesGcmKey.getParameters().getTagSizeBytes());
        }
        return new AesGcmJce(aesGcmKey.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), aesGcmKey.getOutputPrefix());
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("plaintext is null");
        }
        byte[] bArrRandBytes = Random.randBytes(12);
        AlgorithmParameterSpec params = AesGcmJceUtil.getParams(bArrRandBytes);
        Cipher threadLocalCipher = AesGcmJceUtil.getThreadLocalCipher();
        threadLocalCipher.init(1, this.keySpec, params);
        if (bArr2 != null && bArr2.length != 0) {
            threadLocalCipher.updateAAD(bArr2);
        }
        int outputSize = threadLocalCipher.getOutputSize(bArr.length);
        byte[] bArr3 = this.outputPrefix;
        if (outputSize > 2147483635 - bArr3.length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + 12 + outputSize);
        System.arraycopy(bArrRandBytes, 0, bArrCopyOf, this.outputPrefix.length, 12);
        if (threadLocalCipher.doFinal(bArr, 0, bArr.length, bArrCopyOf, this.outputPrefix.length + 12) == outputSize) {
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
        AlgorithmParameterSpec params = AesGcmJceUtil.getParams(bArr, this.outputPrefix.length, 12);
        Cipher threadLocalCipher = AesGcmJceUtil.getThreadLocalCipher();
        threadLocalCipher.init(2, this.keySpec, params);
        if (bArr2 != null && bArr2.length != 0) {
            threadLocalCipher.updateAAD(bArr2);
        }
        byte[] bArr4 = this.outputPrefix;
        return threadLocalCipher.doFinal(bArr, bArr4.length + 12, (bArr.length - bArr4.length) - 12);
    }
}
