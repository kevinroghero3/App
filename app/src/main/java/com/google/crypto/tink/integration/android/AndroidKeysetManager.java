package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.BinaryKeysetReader;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.KeysetManager;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.LegacyKeysetSerialization;
import com.google.crypto.tink.TinkProtoParametersFormat;
import com.google.crypto.tink.subtle.Hex;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidKeysetManager {
    private static final String TAG = "AndroidKeysetManager";
    private static final Object lock = new Object();
    private KeysetManager keysetManager;
    private final Aead masterAead;
    private final KeysetWriter writer;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAtLeastM() {
        return true;
    }

    private AndroidKeysetManager(Builder builder) {
        this.writer = new SharedPrefKeysetWriter(builder.context, builder.keysetName, builder.prefFileName);
        this.masterAead = builder.masterAead;
        this.keysetManager = builder.keysetManager;
    }

    public static final class Builder {
        private KeysetManager keysetManager;
        private Context context = null;
        private String keysetName = null;
        private String prefFileName = null;
        private String masterKeyUri = null;
        private Aead masterAead = null;
        private boolean useKeystore = true;
        private KeyTemplate keyTemplate = null;
        private com.google.crypto.tink.proto.KeyTemplate keyTemplateProto = null;

        public Builder withSharedPref(Context context, String str, String str2) throws IOException {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            }
            if (str == null) {
                throw new IllegalArgumentException("need a keyset name");
            }
            this.context = context;
            this.keysetName = str;
            this.prefFileName = str2;
            return this;
        }

        public Builder withMasterKeyUri(String str) {
            if (!str.startsWith(AndroidKeystoreKmsClient.PREFIX)) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            }
            if (!this.useKeystore) {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
            this.masterKeyUri = str;
            return this;
        }

        public Builder withKeyTemplate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
            this.keyTemplateProto = keyTemplate;
            return this;
        }

        public Builder withKeyTemplate(KeyTemplate keyTemplate) {
            this.keyTemplate = keyTemplate;
            return this;
        }

        @Deprecated
        public Builder doNotUseKeystore() {
            this.masterKeyUri = null;
            this.useKeystore = false;
            return this;
        }

        private static byte[] readKeysetFromPrefs(Context context, String str, String str2) throws IOException {
            SharedPreferences sharedPreferences;
            if (str == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
            } else {
                sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
            }
            try {
                String string = sharedPreferences.getString(str, null);
                if (string == null) {
                    return null;
                }
                return Hex.decode(string);
            } catch (ClassCastException | IllegalArgumentException unused) {
                throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", str));
            }
        }

        private KeysetManager readKeysetInCleartext(byte[] bArr) throws GeneralSecurityException, IOException {
            return KeysetManager.withKeysetHandle(LegacyKeysetSerialization.parseKeyset(BinaryKeysetReader.withBytes(bArr), InsecureSecretKeyAccess.get()));
        }

        public AndroidKeysetManager build() throws GeneralSecurityException, IOException {
            AndroidKeysetManager androidKeysetManager;
            synchronized (this) {
                if (this.keysetName == null) {
                    throw new IllegalArgumentException("keysetName cannot be null");
                }
                com.google.crypto.tink.proto.KeyTemplate keyTemplate = this.keyTemplateProto;
                if (keyTemplate != null && this.keyTemplate == null) {
                    this.keyTemplate = KeyTemplate.createFrom(TinkProtoParametersFormat.parse(keyTemplate.toByteArray()));
                }
                synchronized (AndroidKeysetManager.lock) {
                    byte[] keysetFromPrefs = readKeysetFromPrefs(this.context, this.keysetName, this.prefFileName);
                    if (keysetFromPrefs == null) {
                        if (this.masterKeyUri != null) {
                            this.masterAead = readOrGenerateNewMasterKey();
                        }
                        this.keysetManager = generateKeysetAndWriteToPrefs();
                    } else if (this.masterKeyUri == null || !AndroidKeysetManager.isAtLeastM()) {
                        this.keysetManager = readKeysetInCleartext(keysetFromPrefs);
                    } else {
                        this.keysetManager = readMasterkeyDecryptAndParseKeyset(keysetFromPrefs);
                    }
                    androidKeysetManager = new AndroidKeysetManager(this);
                }
            }
            return androidKeysetManager;
        }

        private Aead readOrGenerateNewMasterKey() throws GeneralSecurityException {
            if (!AndroidKeysetManager.isAtLeastM()) {
                SentryLogcatAdapter.w(AndroidKeysetManager.TAG, "Android Keystore requires at least Android M");
                return null;
            }
            AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
            try {
                boolean zGenerateKeyIfNotExist = AndroidKeystoreKmsClient.generateKeyIfNotExist(this.masterKeyUri);
                try {
                    return androidKeystoreKmsClient.getAead(this.masterKeyUri);
                } catch (GeneralSecurityException | ProviderException e) {
                    if (zGenerateKeyIfNotExist) {
                        SentryLogcatAdapter.w(AndroidKeysetManager.TAG, "cannot use Android Keystore, it'll be disabled", e);
                        return null;
                    }
                    throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.masterKeyUri), e);
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                SentryLogcatAdapter.w(AndroidKeysetManager.TAG, "cannot use Android Keystore, it'll be disabled", e2);
                return null;
            }
        }

        private KeysetManager generateKeysetAndWriteToPrefs() throws GeneralSecurityException, IOException {
            KeyTemplate keyTemplate = this.keyTemplate;
            if (keyTemplate == null) {
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
            KeysetHandle keysetHandleGenerateNew = KeysetHandle.generateNew(keyTemplate);
            AndroidKeysetManager.write(keysetHandleGenerateNew, new SharedPrefKeysetWriter(this.context, this.keysetName, this.prefFileName), this.masterAead);
            return KeysetManager.withKeysetHandle(keysetHandleGenerateNew);
        }

        private KeysetManager readMasterkeyDecryptAndParseKeyset(byte[] bArr) throws GeneralSecurityException, IOException {
            try {
                this.masterAead = new AndroidKeystoreKmsClient().getAead(this.masterKeyUri);
                try {
                    return KeysetManager.withKeysetHandle(LegacyKeysetSerialization.parseEncryptedKeyset(BinaryKeysetReader.withBytes(bArr), this.masterAead, new byte[0]));
                } catch (IOException | GeneralSecurityException e) {
                    try {
                        return readKeysetInCleartext(bArr);
                    } catch (IOException unused) {
                        throw e;
                    }
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                try {
                    KeysetManager keysetInCleartext = readKeysetInCleartext(bArr);
                    SentryLogcatAdapter.w(AndroidKeysetManager.TAG, "cannot use Android Keystore, it'll be disabled", e2);
                    return keysetInCleartext;
                } catch (IOException unused2) {
                    throw e2;
                }
            }
        }
    }

    public KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        KeysetHandle keysetHandle;
        synchronized (this) {
            keysetHandle = this.keysetManager.getKeysetHandle();
        }
        return keysetHandle;
    }

    @Deprecated
    public AndroidKeysetManager rotate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        synchronized (this) {
            KeysetManager keysetManagerRotate = this.keysetManager.rotate(keyTemplate);
            this.keysetManager = keysetManagerRotate;
            write(keysetManagerRotate.getKeysetHandle(), this.writer, this.masterAead);
        }
        return this;
    }

    public AndroidKeysetManager add(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        synchronized (this) {
            KeysetManager keysetManagerAdd = this.keysetManager.add(keyTemplate);
            this.keysetManager = keysetManagerAdd;
            write(keysetManagerAdd.getKeysetHandle(), this.writer, this.masterAead);
        }
        return this;
    }

    public AndroidKeysetManager add(KeyTemplate keyTemplate) throws GeneralSecurityException {
        synchronized (this) {
            KeysetManager keysetManagerAdd = this.keysetManager.add(keyTemplate);
            this.keysetManager = keysetManagerAdd;
            write(keysetManagerAdd.getKeysetHandle(), this.writer, this.masterAead);
        }
        return this;
    }

    public AndroidKeysetManager setPrimary(int i) throws GeneralSecurityException {
        synchronized (this) {
            KeysetManager primary = this.keysetManager.setPrimary(i);
            this.keysetManager = primary;
            write(primary.getKeysetHandle(), this.writer, this.masterAead);
        }
        return this;
    }

    @Deprecated
    public AndroidKeysetManager promote(int i) throws GeneralSecurityException {
        AndroidKeysetManager primary;
        synchronized (this) {
            primary = setPrimary(i);
        }
        return primary;
    }

    public AndroidKeysetManager enable(int i) throws GeneralSecurityException {
        synchronized (this) {
            KeysetManager keysetManagerEnable = this.keysetManager.enable(i);
            this.keysetManager = keysetManagerEnable;
            write(keysetManagerEnable.getKeysetHandle(), this.writer, this.masterAead);
        }
        return this;
    }

    public AndroidKeysetManager disable(int i) throws GeneralSecurityException {
        synchronized (this) {
            KeysetManager keysetManagerDisable = this.keysetManager.disable(i);
            this.keysetManager = keysetManagerDisable;
            write(keysetManagerDisable.getKeysetHandle(), this.writer, this.masterAead);
        }
        return this;
    }

    public AndroidKeysetManager delete(int i) throws GeneralSecurityException {
        synchronized (this) {
            KeysetManager keysetManagerDelete = this.keysetManager.delete(i);
            this.keysetManager = keysetManagerDelete;
            write(keysetManagerDelete.getKeysetHandle(), this.writer, this.masterAead);
        }
        return this;
    }

    public AndroidKeysetManager destroy(int i) throws GeneralSecurityException {
        synchronized (this) {
            KeysetManager keysetManagerDestroy = this.keysetManager.destroy(i);
            this.keysetManager = keysetManagerDestroy;
            write(keysetManagerDestroy.getKeysetHandle(), this.writer, this.masterAead);
        }
        return this;
    }

    public boolean isUsingKeystore() {
        boolean z;
        synchronized (this) {
            z = this.masterAead != null;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void write(KeysetHandle keysetHandle, KeysetWriter keysetWriter, Aead aead) throws GeneralSecurityException {
        try {
            if (aead != null) {
                LegacyKeysetSerialization.serializeEncryptedKeyset(keysetHandle, keysetWriter, aead, new byte[0]);
            } else {
                LegacyKeysetSerialization.serializeKeyset(keysetHandle, keysetWriter, InsecureSecretKeyAccess.get());
            }
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }
}
