package com.google.crypto.tink.integration.android;

import com.google.crypto.tink.Aead;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.ProviderException;
import javax.crypto.BadPaddingException;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidKeystoreAesGcm implements Aead {
    private static final int MAX_WAIT_TIME_MILLISECONDS_BEFORE_RETRY = 100;
    private static final String TAG = "AndroidKeystoreAesGcm";
    private final Aead keystoreAead;

    public AndroidKeystoreAesGcm(String str) throws GeneralSecurityException, IOException {
        this.keystoreAead = AndroidKeystore.getAead(str);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            return this.keystoreAead.encrypt(bArr, bArr2);
        } catch (GeneralSecurityException | ProviderException e) {
            SentryLogcatAdapter.w(TAG, "encountered a potentially transient KeyStore error, will wait and retry", e);
            sleepRandomAmount();
            return this.keystoreAead.encrypt(bArr, bArr2);
        }
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            return this.keystoreAead.decrypt(bArr, bArr2);
        } catch (GeneralSecurityException e) {
            e = e;
            SentryLogcatAdapter.w(TAG, "encountered a potentially transient KeyStore error, will wait and retry", e);
            sleepRandomAmount();
            return this.keystoreAead.decrypt(bArr, bArr2);
        } catch (ProviderException e2) {
            e = e2;
            SentryLogcatAdapter.w(TAG, "encountered a potentially transient KeyStore error, will wait and retry", e);
            sleepRandomAmount();
            return this.keystoreAead.decrypt(bArr, bArr2);
        } catch (BadPaddingException e3) {
            throw e3;
        }
    }

    private static void sleepRandomAmount() {
        try {
            Thread.sleep((int) (Math.random() * 100.0d));
        } catch (InterruptedException unused) {
        }
    }
}
