package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.AesEaxKey;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.prf.AesCmacPrfKey;
import com.google.crypto.tink.prf.AesCmacPrfParameters;
import com.google.crypto.tink.prf.Prf;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class AesEaxJce implements Aead {
    static final int BLOCK_SIZE_IN_BYTES = 16;
    static final int TAG_SIZE_IN_BYTES = 16;
    private final Prf cmac;
    private final int ivSizeInBytes;
    private final SecretKeySpec keySpec;
    private final byte[] outputPrefix;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final ThreadLocal<Cipher> localCtrCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesEaxJce.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/CTR/NOPADDING");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    };

    public static Aead create(AesEaxKey aesEaxKey) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (aesEaxKey.getParameters().getTagSizeBytes() != 16) {
            throw new GeneralSecurityException("AesEaxJce only supports 16 byte tag size, not " + aesEaxKey.getParameters().getTagSizeBytes());
        }
        return new AesEaxJce(aesEaxKey.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), aesEaxKey.getParameters().getIvSizeBytes(), aesEaxKey.getOutputPrefix().toByteArray());
    }

    private static Prf createCmac(byte[] bArr) throws GeneralSecurityException {
        return PrfAesCmac.create(AesCmacPrfKey.create(AesCmacPrfParameters.create(bArr.length), SecretBytes.copyFrom(bArr, InsecureSecretKeyAccess.get())));
    }

    private AesEaxJce(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.ivSizeInBytes = i;
        Validators.validateAesKeySize(bArr.length);
        this.keySpec = new SecretKeySpec(bArr, "AES");
        this.cmac = createCmac(bArr);
        this.outputPrefix = bArr2;
    }

    public AesEaxJce(byte[] bArr, int i) throws GeneralSecurityException {
        this(bArr, i, new byte[0]);
    }

    private byte[] omac(int i, byte[] bArr, int i2, int i3) throws GeneralSecurityException {
        byte[] bArr2 = new byte[i3 + 16];
        bArr2[15] = (byte) i;
        System.arraycopy(bArr, i2, bArr2, 16, i3);
        return this.cmac.compute(bArr2, 16);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.outputPrefix;
        int length2 = bArr3.length;
        int i = this.ivSizeInBytes;
        if (length > ((Integer.MAX_VALUE - length2) - i) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + i + bArr.length + 16);
        byte[] bArrRandBytes = Random.randBytes(this.ivSizeInBytes);
        System.arraycopy(bArrRandBytes, 0, bArrCopyOf, this.outputPrefix.length, this.ivSizeInBytes);
        byte[] bArrOmac = omac(0, bArrRandBytes, 0, bArrRandBytes.length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrOmac2 = omac(1, bArr2, 0, bArr2.length);
        Cipher cipher = localCtrCipher.get();
        cipher.init(1, this.keySpec, new IvParameterSpec(bArrOmac));
        cipher.doFinal(bArr, 0, bArr.length, bArrCopyOf, this.outputPrefix.length + this.ivSizeInBytes);
        byte[] bArrOmac3 = omac(2, bArrCopyOf, this.outputPrefix.length + this.ivSizeInBytes, bArr.length);
        int length3 = this.outputPrefix.length;
        int length4 = bArr.length;
        int i2 = this.ivSizeInBytes;
        for (int i3 = 0; i3 < 16; i3++) {
            bArrCopyOf[length3 + length4 + i2 + i3] = (byte) ((bArrOmac2[i3] ^ bArrOmac[i3]) ^ bArrOmac3[i3]);
        }
        return bArrCopyOf;
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.outputPrefix;
        int length2 = ((length - bArr3.length) - this.ivSizeInBytes) - 16;
        if (length2 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!Util.isPrefix(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrOmac = omac(0, bArr, this.outputPrefix.length, this.ivSizeInBytes);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrOmac2 = omac(1, bArr2, 0, bArr2.length);
        byte[] bArrOmac3 = omac(2, bArr, this.outputPrefix.length + this.ivSizeInBytes, length2);
        int length3 = bArr.length;
        byte b = 0;
        for (int i = 0; i < 16; i++) {
            b = (byte) (b | (((bArr[(length3 - 16) + i] ^ bArrOmac2[i]) ^ bArrOmac[i]) ^ bArrOmac3[i]));
        }
        if (b != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher = localCtrCipher.get();
        cipher.init(1, this.keySpec, new IvParameterSpec(bArrOmac));
        return cipher.doFinal(bArr, this.outputPrefix.length + this.ivSizeInBytes, length2);
    }
}
