package com.google.crypto.tink.aead.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.AesGcmSivKey;
import com.google.crypto.tink.aead.AesGcmSivParameters;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
public final class AesGcmSiv implements Aead {
    private static final ThreadLocal<Cipher> localAesGcmSivCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.aead.subtle.AesGcmSiv.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @Nullable
        public Cipher initialValue() {
            try {
                Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/GCM-SIV/NoPadding");
                if (com.google.crypto.tink.aead.internal.AesGcmSiv.isAesGcmSivCipher(engineFactory)) {
                    return engineFactory;
                }
                return null;
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    };
    private final Aead aead;

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher cipherSupplier() throws GeneralSecurityException {
        try {
            Cipher cipher = localAesGcmSivCipher.get();
            if (cipher != null) {
                return cipher;
            }
            throw new GeneralSecurityException("AES GCM SIV cipher is invalid.");
        } catch (IllegalStateException e) {
            throw new GeneralSecurityException("AES GCM SIV cipher is not available or is invalid.", e);
        }
    }

    public static Aead create(AesGcmSivKey aesGcmSivKey) throws GeneralSecurityException {
        return com.google.crypto.tink.aead.internal.AesGcmSiv.create(aesGcmSivKey, new AesGcmSiv$$ExternalSyntheticLambda0());
    }

    private static Aead createFromRawKey(byte[] bArr) throws GeneralSecurityException {
        return com.google.crypto.tink.aead.internal.AesGcmSiv.create(AesGcmSivKey.builder().setKeyBytes(SecretBytes.copyFrom(bArr, InsecureSecretKeyAccess.get())).setParameters(AesGcmSivParameters.builder().setKeySizeBytes(bArr.length).setVariant(AesGcmSivParameters.Variant.NO_PREFIX).build()).build(), new AesGcmSiv$$ExternalSyntheticLambda0());
    }

    private AesGcmSiv(Aead aead) {
        this.aead = aead;
    }

    public AesGcmSiv(byte[] bArr) throws GeneralSecurityException {
        this(createFromRawKey(bArr));
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.aead.encrypt(bArr, bArr2);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.aead.decrypt(bArr, bArr2);
    }
}
