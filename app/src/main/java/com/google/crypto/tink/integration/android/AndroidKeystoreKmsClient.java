package com.google.crypto.tink.integration.android;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KmsClient;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidKeystoreKmsClient implements KmsClient {
    private static final int MAX_WAIT_TIME_MILLISECONDS_BEFORE_RETRY = 40;
    public static final String PREFIX = "android-keystore://";
    private static final String TAG = "AndroidKeystoreKmsClient";
    private static final Object keystoreLock = new Object();
    private final String keyUri;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAtLeastM() {
        return true;
    }

    public AndroidKeystoreKmsClient() throws GeneralSecurityException {
        this(new Builder());
    }

    @Deprecated
    public AndroidKeystoreKmsClient(String str) {
        this(new Builder().setKeyUri(str));
    }

    private AndroidKeystoreKmsClient(Builder builder) {
        this.keyUri = builder.keyUri;
    }

    public static final class Builder {
        String keyUri = null;

        public Builder() {
            if (!AndroidKeystoreKmsClient.isAtLeastM()) {
                throw new IllegalStateException("need Android Keystore on Android M or newer");
            }
        }

        public Builder setKeyUri(String str) {
            if (str == null || !str.toLowerCase(Locale.US).startsWith(AndroidKeystoreKmsClient.PREFIX)) {
                throw new IllegalArgumentException("val must start with android-keystore://");
            }
            this.keyUri = str;
            return this;
        }

        public AndroidKeystoreKmsClient build() {
            return new AndroidKeystoreKmsClient(this);
        }
    }

    @Override // com.google.crypto.tink.KmsClient
    public boolean doesSupport(String str) {
        String str2 = this.keyUri;
        if (str2 == null || !str2.equals(str)) {
            return this.keyUri == null && str.toLowerCase(Locale.US).startsWith(PREFIX);
        }
        return true;
    }

    @Override // com.google.crypto.tink.KmsClient
    public KmsClient withCredentials(String str) throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }

    @Override // com.google.crypto.tink.KmsClient
    public KmsClient withDefaultCredentials() throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }

    @Override // com.google.crypto.tink.KmsClient
    public Aead getAead(String str) throws GeneralSecurityException {
        Aead aeadValidateAead;
        String str2 = this.keyUri;
        if (str2 != null && !str2.equals(str)) {
            throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", this.keyUri, str));
        }
        try {
            synchronized (keystoreLock) {
                aeadValidateAead = validateAead(new AndroidKeystoreAesGcm(Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str)));
            }
            return aeadValidateAead;
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    public void deleteKey(String str) throws GeneralSecurityException {
        String strValidateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str);
        synchronized (keystoreLock) {
            AndroidKeystore.deleteKey(strValidateKmsKeyUriAndRemovePrefix);
        }
    }

    boolean hasKey(String str) throws GeneralSecurityException {
        boolean zHasKey;
        String strValidateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str);
        try {
            synchronized (keystoreLock) {
                zHasKey = AndroidKeystore.hasKey(strValidateKmsKeyUriAndRemovePrefix);
            }
            return zHasKey;
        } catch (NullPointerException unused) {
            SentryLogcatAdapter.w(TAG, "Keystore is temporarily unavailable, wait, reinitialize Keystore and try again.");
            sleepRandomAmount();
            synchronized (keystoreLock) {
                return AndroidKeystore.hasKey(strValidateKmsKeyUriAndRemovePrefix);
            }
        }
    }

    private static void sleepRandomAmount() {
        try {
            Thread.sleep((int) (Math.random() * 40.0d));
        } catch (InterruptedException unused) {
        }
    }

    public static Aead getOrGenerateNewAeadKey(String str) throws GeneralSecurityException, IOException {
        Aead aeadValidateAead;
        String strValidateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str);
        synchronized (keystoreLock) {
            if (!AndroidKeystore.hasKey(strValidateKmsKeyUriAndRemovePrefix)) {
                AndroidKeystore.generateNewAes256GcmKey(strValidateKmsKeyUriAndRemovePrefix);
            }
            aeadValidateAead = validateAead(new AndroidKeystoreAesGcm(strValidateKmsKeyUriAndRemovePrefix));
        }
        return aeadValidateAead;
    }

    public static void generateNewAeadKey(String str) throws GeneralSecurityException {
        synchronized (keystoreLock) {
            String strValidateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str);
            if (AndroidKeystore.hasKey(strValidateKmsKeyUriAndRemovePrefix)) {
                throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", str));
            }
            AndroidKeystore.generateNewAes256GcmKey(strValidateKmsKeyUriAndRemovePrefix);
        }
    }

    static boolean generateKeyIfNotExist(String str) throws GeneralSecurityException {
        synchronized (keystoreLock) {
            String strValidateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str);
            if (AndroidKeystore.hasKey(strValidateKmsKeyUriAndRemovePrefix)) {
                return false;
            }
            AndroidKeystore.generateNewAes256GcmKey(strValidateKmsKeyUriAndRemovePrefix);
            return true;
        }
    }

    private static Aead validateAead(Aead aead) throws GeneralSecurityException {
        byte[] bArrRandBytes = Random.randBytes(10);
        byte[] bArr = new byte[0];
        if (Arrays.equals(bArrRandBytes, aead.decrypt(aead.encrypt(bArrRandBytes, bArr), bArr))) {
            return aead;
        }
        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
    }
}
