package it.aep_italia.vts.sdk.utils.ciphers;

import android.content.Context;
import android.content.res.Configuration;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes6.dex */
class c implements KeyCipher {
    protected final Context context;
    protected final String keyAlias = createKeyAlias();

    public c(Context context) throws Exception {
        this.context = context;
        b(context);
    }

    private PrivateKey a() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Key key = keyStore.getKey(this.keyAlias, null);
        if (key != null) {
            if (key instanceof PrivateKey) {
                return (PrivateKey) key;
            }
            throw new Exception("Not an instance of a PrivateKey");
        }
        throw new Exception("No key found under alias: " + this.keyAlias);
    }

    private AlgorithmParameterSpec a(Context context, Calendar calendar, Calendar calendar2) {
        return new KeyPairGeneratorSpec.Builder(context).setAlias(this.keyAlias).setSubject(new X500Principal("CN=" + this.keyAlias)).setSerialNumber(BigInteger.valueOf(1L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
    }

    private void a(Context context) throws Exception {
        Locale locale = Locale.getDefault();
        try {
            a(Locale.ENGLISH);
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 25);
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(makeAlgorithmParameterSpec(context, calendar, calendar2));
            keyPairGenerator.generateKeyPair();
        } finally {
            a(locale);
        }
    }

    private void a(Locale locale) {
        Locale.setDefault(locale);
        Configuration configuration = this.context.getResources().getConfiguration();
        configuration.setLocale(locale);
        this.context.createConfigurationContext(configuration);
    }

    private PublicKey b() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Certificate certificate = keyStore.getCertificate(this.keyAlias);
        if (certificate == null) {
            throw new Exception("No certificate found under alias: " + this.keyAlias);
        }
        PublicKey publicKey = certificate.getPublicKey();
        if (publicKey != null) {
            return publicKey;
        }
        throw new Exception("No key found under alias: " + this.keyAlias);
    }

    private void b(Context context) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        if (keyStore.getKey(this.keyAlias, null) == null) {
            a(context);
        }
    }

    protected String createKeyAlias() {
        return this.context.getPackageName() + ".VtsSecureStorageKey";
    }

    protected AlgorithmParameterSpec getAlgorithmParameterSpec() {
        return null;
    }

    protected Cipher getRSACipher() throws Exception {
        return Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidKeyStoreBCWorkaround");
    }

    protected AlgorithmParameterSpec makeAlgorithmParameterSpec(Context context, Calendar calendar, Calendar calendar2) {
        return new KeyGenParameterSpec.Builder(this.keyAlias, 3).setCertificateSubject(new X500Principal("CN=" + this.keyAlias)).setDigests("SHA-256").setBlockModes("ECB").setEncryptionPaddings("PKCS1Padding").setCertificateSerialNumber(BigInteger.valueOf(1L)).setCertificateNotBefore(calendar.getTime()).setCertificateNotAfter(calendar2.getTime()).build();
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.KeyCipher
    public Key unwrap(byte[] bArr, String str) throws Exception {
        PrivateKey privateKeyA = a();
        Cipher rSACipher = getRSACipher();
        rSACipher.init(4, privateKeyA, getAlgorithmParameterSpec());
        return rSACipher.unwrap(bArr, str, 3);
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.KeyCipher
    public byte[] wrap(Key key) throws Exception {
        PublicKey publicKeyB = b();
        Cipher rSACipher = getRSACipher();
        rSACipher.init(3, publicKeyB, getAlgorithmParameterSpec());
        return rSACipher.wrap(key);
    }
}
