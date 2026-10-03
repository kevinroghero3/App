package it.aep_italia.vts.sdk.utils.ciphers;

import android.content.Context;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes6.dex */
public class StorageCipherGCMImplementation extends StorageCipher18Implementation {
    public StorageCipherGCMImplementation(Context context, KeyCipher keyCipher) throws Exception {
        super(context, keyCipher);
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.StorageCipher18Implementation
    protected String getAESPreferencesKey() {
        return "VGhpcyBpcyB0aGUga2V5IGZvcihBIHNlY3XyZZBzdG9yYWdlIEFFUyBLZXkK";
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.StorageCipher18Implementation
    protected Cipher getCipher() throws Exception {
        return Cipher.getInstance("AES/GCM/NoPadding");
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.StorageCipher18Implementation
    protected int getIvSize() {
        return 12;
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.StorageCipher18Implementation
    protected AlgorithmParameterSpec getParameterSpec(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }
}
