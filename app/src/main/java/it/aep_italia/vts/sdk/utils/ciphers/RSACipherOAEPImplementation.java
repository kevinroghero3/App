package it.aep_italia.vts.sdk.utils.ciphers;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import java.math.BigInteger;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes6.dex */
public class RSACipherOAEPImplementation extends c {
    public RSACipherOAEPImplementation(Context context) throws Exception {
        super(context);
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.c
    protected String createKeyAlias() {
        return this.context.getPackageName() + ".VtsSecureStorageKeyOAEP";
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.c
    protected AlgorithmParameterSpec getAlgorithmParameterSpec() {
        return new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.c
    protected Cipher getRSACipher() throws Exception {
        return Cipher.getInstance("RSA/ECB/OAEPPadding", "AndroidKeyStoreBCWorkaround");
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.c
    protected AlgorithmParameterSpec makeAlgorithmParameterSpec(Context context, Calendar calendar, Calendar calendar2) {
        return new KeyGenParameterSpec.Builder(this.keyAlias, 3).setCertificateSubject(new X500Principal("CN=" + this.keyAlias)).setDigests("SHA-256").setBlockModes("ECB").setEncryptionPaddings("OAEPPadding").setCertificateSerialNumber(BigInteger.valueOf(1L)).setCertificateNotBefore(calendar.getTime()).setCertificateNotAfter(calendar2.getTime()).build();
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.c, it.aep_italia.vts.sdk.utils.ciphers.KeyCipher
    public /* bridge */ /* synthetic */ Key unwrap(byte[] bArr, String str) throws Exception {
        return super.unwrap(bArr, str);
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.c, it.aep_italia.vts.sdk.utils.ciphers.KeyCipher
    public /* bridge */ /* synthetic */ byte[] wrap(Key key) throws Exception {
        return super.wrap(key);
    }
}
