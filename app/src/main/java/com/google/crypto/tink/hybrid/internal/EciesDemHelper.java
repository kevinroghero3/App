package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.aead.AesCtrHmacAeadKey;
import com.google.crypto.tink.aead.AesCtrHmacAeadParameters;
import com.google.crypto.tink.aead.AesGcmParameters;
import com.google.crypto.tink.aead.internal.AesGcmJceUtil;
import com.google.crypto.tink.daead.AesSivKey;
import com.google.crypto.tink.daead.AesSivParameters;
import com.google.crypto.tink.hybrid.EciesParameters;
import com.google.crypto.tink.subtle.AesSiv;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EncryptThenAuthenticate;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public final class EciesDemHelper {
    private static final byte[] EMPTY_AAD = new byte[0];

    public interface Dem {
        byte[] decrypt(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException;

        byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException;

        int getSymmetricKeySizeInBytes();
    }

    static final class AesGcmDem implements Dem {
        private static final int AES_GCM_IV_SIZE_IN_BYTES = 12;
        private static final int AES_GCM_TAG_SIZE_IN_BYTES = 16;
        private final int keySizeInBytes;

        AesGcmDem(AesGcmParameters aesGcmParameters) throws GeneralSecurityException {
            if (aesGcmParameters.getIvSizeBytes() != 12) {
                throw new GeneralSecurityException("invalid IV size");
            }
            if (aesGcmParameters.getTagSizeBytes() != 16) {
                throw new GeneralSecurityException("invalid tag size");
            }
            if (aesGcmParameters.getVariant() != AesGcmParameters.Variant.NO_PREFIX) {
                throw new GeneralSecurityException("invalid variant");
            }
            this.keySizeInBytes = aesGcmParameters.getKeySizeBytes();
        }

        @Override // com.google.crypto.tink.hybrid.internal.EciesDemHelper.Dem
        public int getSymmetricKeySizeInBytes() {
            return this.keySizeInBytes;
        }

        @Override // com.google.crypto.tink.hybrid.internal.EciesDemHelper.Dem
        public byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
            if (bArr.length != this.keySizeInBytes) {
                throw new GeneralSecurityException("invalid key size");
            }
            SecretKey secretKey = AesGcmJceUtil.getSecretKey(bArr);
            byte[] bArrRandBytes = Random.randBytes(12);
            AlgorithmParameterSpec params = AesGcmJceUtil.getParams(bArrRandBytes);
            Cipher threadLocalCipher = AesGcmJceUtil.getThreadLocalCipher();
            threadLocalCipher.init(1, secretKey, params);
            int outputSize = threadLocalCipher.getOutputSize(bArr4.length);
            int length = bArr2.length + bArr3.length;
            if (outputSize > 2147483635 - length) {
                throw new GeneralSecurityException("plaintext too long");
            }
            int i = length + 12;
            byte[] bArrCopyOf = Arrays.copyOf(bArr2, i + outputSize);
            System.arraycopy(bArr3, 0, bArrCopyOf, bArr2.length, bArr3.length);
            System.arraycopy(bArrRandBytes, 0, bArrCopyOf, length, 12);
            if (threadLocalCipher.doFinal(bArr4, 0, bArr4.length, bArrCopyOf, i) == outputSize) {
                return bArrCopyOf;
            }
            throw new GeneralSecurityException("not enough data written");
        }

        @Override // com.google.crypto.tink.hybrid.internal.EciesDemHelper.Dem
        public byte[] decrypt(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
            if (bArr2.length < i) {
                throw new GeneralSecurityException("ciphertext too short");
            }
            if (bArr.length != this.keySizeInBytes) {
                throw new GeneralSecurityException("invalid key size");
            }
            SecretKey secretKey = AesGcmJceUtil.getSecretKey(bArr);
            if (bArr2.length < i + 28) {
                throw new GeneralSecurityException("ciphertext too short");
            }
            AlgorithmParameterSpec params = AesGcmJceUtil.getParams(bArr2, i, 12);
            Cipher threadLocalCipher = AesGcmJceUtil.getThreadLocalCipher();
            threadLocalCipher.init(2, secretKey, params);
            return threadLocalCipher.doFinal(bArr2, i + 12, (bArr2.length - i) - 12);
        }
    }

    static final class AesCtrHmacDem implements Dem {
        private final int keySizeInBytes;
        private final AesCtrHmacAeadParameters parameters;

        AesCtrHmacDem(AesCtrHmacAeadParameters aesCtrHmacAeadParameters) {
            this.parameters = aesCtrHmacAeadParameters;
            this.keySizeInBytes = aesCtrHmacAeadParameters.getAesKeySizeBytes() + aesCtrHmacAeadParameters.getHmacKeySizeBytes();
        }

        @Override // com.google.crypto.tink.hybrid.internal.EciesDemHelper.Dem
        public int getSymmetricKeySizeInBytes() {
            return this.keySizeInBytes;
        }

        private Aead getAead(byte[] bArr) throws GeneralSecurityException {
            return EncryptThenAuthenticate.create(AesCtrHmacAeadKey.builder().setParameters(this.parameters).setAesKeyBytes(SecretBytes.copyFrom(Arrays.copyOf(bArr, this.parameters.getAesKeySizeBytes()), InsecureSecretKeyAccess.get())).setHmacKeyBytes(SecretBytes.copyFrom(Arrays.copyOfRange(bArr, this.parameters.getAesKeySizeBytes(), this.parameters.getAesKeySizeBytes() + this.parameters.getHmacKeySizeBytes()), InsecureSecretKeyAccess.get())).build());
        }

        @Override // com.google.crypto.tink.hybrid.internal.EciesDemHelper.Dem
        public byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
            return Bytes.concat(bArr2, bArr3, getAead(bArr).encrypt(bArr4, EciesDemHelper.EMPTY_AAD));
        }

        @Override // com.google.crypto.tink.hybrid.internal.EciesDemHelper.Dem
        public byte[] decrypt(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
            if (bArr2.length < i) {
                throw new GeneralSecurityException("ciphertext too short");
            }
            return getAead(bArr).decrypt(Arrays.copyOfRange(bArr2, i, bArr2.length), EciesDemHelper.EMPTY_AAD);
        }
    }

    static final class AesSivDem implements Dem {
        private final int keySizeInBytes;
        private final AesSivParameters parameters;

        AesSivDem(AesSivParameters aesSivParameters) {
            this.parameters = aesSivParameters;
            this.keySizeInBytes = aesSivParameters.getKeySizeBytes();
        }

        @Override // com.google.crypto.tink.hybrid.internal.EciesDemHelper.Dem
        public int getSymmetricKeySizeInBytes() {
            return this.keySizeInBytes;
        }

        private DeterministicAead getDaead(byte[] bArr) throws GeneralSecurityException {
            return AesSiv.create(AesSivKey.builder().setParameters(this.parameters).setKeyBytes(SecretBytes.copyFrom(bArr, InsecureSecretKeyAccess.get())).build());
        }

        @Override // com.google.crypto.tink.hybrid.internal.EciesDemHelper.Dem
        public byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
            return Bytes.concat(bArr2, bArr3, getDaead(bArr).encryptDeterministically(bArr4, EciesDemHelper.EMPTY_AAD));
        }

        @Override // com.google.crypto.tink.hybrid.internal.EciesDemHelper.Dem
        public byte[] decrypt(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
            if (bArr2.length < i) {
                throw new GeneralSecurityException("ciphertext too short");
            }
            return getDaead(bArr).decryptDeterministically(Arrays.copyOfRange(bArr2, i, bArr2.length), EciesDemHelper.EMPTY_AAD);
        }
    }

    public static Dem getDem(EciesParameters eciesParameters) throws GeneralSecurityException {
        Parameters demParameters = eciesParameters.getDemParameters();
        if (demParameters instanceof AesGcmParameters) {
            return new AesGcmDem((AesGcmParameters) demParameters);
        }
        if (demParameters instanceof AesCtrHmacAeadParameters) {
            return new AesCtrHmacDem((AesCtrHmacAeadParameters) demParameters);
        }
        if (demParameters instanceof AesSivParameters) {
            return new AesSivDem((AesSivParameters) demParameters);
        }
        throw new GeneralSecurityException("Unsupported DEM parameters: " + demParameters);
    }

    private EciesDemHelper() {
    }
}
