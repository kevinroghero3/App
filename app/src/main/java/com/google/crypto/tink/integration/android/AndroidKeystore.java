package com.google.crypto.tink.integration.android;

import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.stats.CodePackage;
import com.google.crypto.tink.Aead;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidKeystore {
    private static boolean isAtLeastM() {
        return true;
    }

    public static void generateNewAes256GcmKey(String str) throws GeneralSecurityException {
        generateNewKeyWithSpec(new KeyGenParameterSpec.Builder(str, 3).setKeySize(256).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").build());
    }

    public static void generateNewKeyWithSpec(KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(keyGenParameterSpec);
        keyGenerator.generateKey();
    }

    public static Aead getAead(String str) throws GeneralSecurityException {
        return new AeadImpl(str, getAndroidKeyStore());
    }

    public static void deleteKey(String str) throws GeneralSecurityException {
        getAndroidKeyStore().deleteEntry(str);
    }

    public static boolean hasKey(String str) throws GeneralSecurityException {
        return getAndroidKeyStore().containsAlias(str);
    }

    private static KeyStore getAndroidKeyStore() throws GeneralSecurityException {
        if (!isAtLeastM()) {
            throw new IllegalStateException("Need Android Keystore on Android M or newer");
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore;
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    static final class AeadImpl implements Aead {
        private static final int IV_SIZE_IN_BYTES = 12;
        private static final int TAG_SIZE_IN_BYTES = 16;
        private final SecretKey key;

        public AeadImpl(String str, KeyStore keyStore) throws GeneralSecurityException {
            SecretKey secretKey = (SecretKey) keyStore.getKey(str, null);
            this.key = secretKey;
            if (secretKey != null) {
                return;
            }
            throw new InvalidKeyException("Keystore cannot load the key with ID: " + str);
        }

        @Override // com.google.crypto.tink.Aead
        public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 2147483619) {
                throw new GeneralSecurityException("plaintext too long");
            }
            byte[] bArr3 = new byte[bArr.length + 28];
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, this.key);
            cipher.updateAAD(bArr2);
            if (cipher.doFinal(bArr, 0, bArr.length, bArr3, 12) != bArr.length + 16) {
                throw new GeneralSecurityException("encryption failed: bytesWritten is wrong");
            }
            byte[] iv = cipher.getIV();
            if (iv.length != 12) {
                throw new GeneralSecurityException("IV has unexpected length");
            }
            System.arraycopy(iv, 0, bArr3, 0, 12);
            return bArr3;
        }

        @Override // com.google.crypto.tink.Aead
        public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length < 28) {
                throw new BadPaddingException("ciphertext too short");
            }
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, this.key, gCMParameterSpec);
            cipher.updateAAD(bArr2);
            return cipher.doFinal(bArr, 12, bArr.length - 12);
        }
    }

    private AndroidKeystore() {
    }
}
