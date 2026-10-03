package com.salesforce.marketingcloud.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.salesforce.marketingcloud.legacycrypto.OldSdkHash;
import com.salesforce.marketingcloud.legacycrypto.SdkHash;
import com.salesforce.marketingcloud.tozny.AesCbcWithIntegrity;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public class AesCrypto extends AesCbcWithIntegrity implements Crypto {
    private static final String AES_CRYPTO_PREFS = "com.salesforce.marketingcloud.storagePrefs";
    private static final String ENC_TEST_STRING = "F6389234-1024-481F-9173-37D9D7F5051F";
    private static final String INSTALL_DATE_ENC = "install_date_enc";
    private static final int PBE_ITERATIONS = 500;
    private final AesCbcWithIntegrity.SecretKeys aesKey;

    public AesCrypto(Context context, String str, String str2, String str3, int i, OldSdkHash oldSdkHash) throws GeneralSecurityException {
        this.aesKey = AesCbcWithIntegrity.generateKeyFromPassword(generateEncPp(str, str2, str3, oldSdkHash), getSalt(context), i);
        verifyEncryption();
    }

    private String generateEncPp(String str, String str2, String str3, SdkHash sdkHash) {
        if (sdkHash == null) {
            return Base64.encodeToString((str + "--" + str2 + "__" + str3).getBytes(StandardCharsets.UTF_8), 2);
        }
        return Base64.encodeToString(sdkHash.generateHash(str + "--" + sdkHash.generateHash(str2) + "__" + sdkHash.generateHash(str3)).getBytes(StandardCharsets.UTF_8), 2);
    }

    private void verifyEncryption() throws GeneralSecurityException {
        if (!ENC_TEST_STRING.equals(decString(encString(ENC_TEST_STRING)))) {
            throw new GeneralSecurityException("Encryption/decryption test failed");
        }
    }

    @Override // com.salesforce.marketingcloud.util.Crypto
    public String decString(String str) {
        if (str == null) {
            return null;
        }
        try {
            return AesCbcWithIntegrity.decryptString(new AesCbcWithIntegrity.CipherTextIvMac(str), this.aesKey);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (GeneralSecurityException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.salesforce.marketingcloud.util.Crypto
    public String encString(String str) {
        if (str == null) {
            return null;
        }
        try {
            return AesCbcWithIntegrity.encrypt(str, this.aesKey).toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (GeneralSecurityException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String getSalt(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AES_CRYPTO_PREFS, 0);
        String string = sharedPreferences.getString(INSTALL_DATE_ENC, null);
        if (string != null) {
            return string;
        }
        String strSaltString = AesCbcWithIntegrity.saltString(AesCbcWithIntegrity.generateSalt());
        sharedPreferences.edit().putString(INSTALL_DATE_ENC, strSaltString).apply();
        return strSaltString;
    }

    public AesCrypto(Context context, String str, String str2, String str3, OldSdkHash oldSdkHash) {
        this(context, str, str2, str3, 500, oldSdkHash);
    }
}
