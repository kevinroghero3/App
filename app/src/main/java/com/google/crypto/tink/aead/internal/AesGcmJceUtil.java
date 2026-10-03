package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class AesGcmJceUtil {
    public static final int IV_SIZE_IN_BYTES = 12;
    public static final int TAG_SIZE_IN_BYTES = 16;
    private static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.aead.internal.AesGcmJceUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/GCM/NoPadding");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    };

    public static Cipher getThreadLocalCipher() {
        return localCipher.get();
    }

    public static SecretKey getSecretKey(byte[] bArr) throws GeneralSecurityException {
        Validators.validateAesKeySize(bArr.length);
        return new SecretKeySpec(bArr, "AES");
    }

    public static AlgorithmParameterSpec getParams(byte[] bArr) {
        return getParams(bArr, 0, bArr.length);
    }

    public static AlgorithmParameterSpec getParams(byte[] bArr, int i, int i2) {
        Integer androidApiLevel = Util.getAndroidApiLevel();
        if (androidApiLevel != null && androidApiLevel.intValue() <= 19) {
            return new IvParameterSpec(bArr, i, i2);
        }
        return new GCMParameterSpec(128, bArr, i, i2);
    }

    private AesGcmJceUtil() {
    }
}
