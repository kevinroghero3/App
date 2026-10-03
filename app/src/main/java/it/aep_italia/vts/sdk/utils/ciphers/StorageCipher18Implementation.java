package it.aep_italia.vts.sdk.utils.ciphers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class StorageCipher18Implementation implements StorageCipher {
    private final Cipher a;
    private final SecureRandom b = new SecureRandom();
    private Key c;

    public StorageCipher18Implementation(Context context, KeyCipher keyCipher) throws Exception {
        String aESPreferencesKey = getAESPreferencesKey();
        SharedPreferences sharedPreferences = context.getSharedPreferences("VtsSecureStorageKeyStorage", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        String string = sharedPreferences.getString(aESPreferencesKey, null);
        this.a = getCipher();
        if (string != null) {
            try {
                this.c = keyCipher.unwrap(Base64.decode(string, 0), "AES");
                return;
            } catch (Exception e) {
                Log.e("StorageCipher18Impl", "unwrap key failed", e);
            }
        }
        byte[] bArr = new byte[16];
        this.b.nextBytes(bArr);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.c = secretKeySpec;
        editorEdit.putString(aESPreferencesKey, Base64.encodeToString(keyCipher.wrap(secretKeySpec), 0));
        editorEdit.apply();
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.StorageCipher
    public byte[] decrypt(byte[] bArr) throws Exception {
        int ivSize = getIvSize();
        byte[] bArr2 = new byte[ivSize];
        System.arraycopy(bArr, 0, bArr2, 0, ivSize);
        AlgorithmParameterSpec parameterSpec = getParameterSpec(bArr2);
        int length = bArr.length - getIvSize();
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, ivSize, bArr3, 0, length);
        this.a.init(2, this.c, parameterSpec);
        return this.a.doFinal(bArr3);
    }

    @Override // it.aep_italia.vts.sdk.utils.ciphers.StorageCipher
    public byte[] encrypt(byte[] bArr) throws Exception {
        int ivSize = getIvSize();
        byte[] bArr2 = new byte[ivSize];
        this.b.nextBytes(bArr2);
        this.a.init(1, this.c, getParameterSpec(bArr2));
        byte[] bArrDoFinal = this.a.doFinal(bArr);
        byte[] bArr3 = new byte[bArrDoFinal.length + ivSize];
        System.arraycopy(bArr2, 0, bArr3, 0, ivSize);
        System.arraycopy(bArrDoFinal, 0, bArr3, ivSize, bArrDoFinal.length);
        return bArr3;
    }

    protected String getAESPreferencesKey() {
        return "VGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK";
    }

    protected Cipher getCipher() throws Exception {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    protected int getIvSize() {
        return 16;
    }

    protected AlgorithmParameterSpec getParameterSpec(byte[] bArr) {
        return new IvParameterSpec(bArr);
    }
}
