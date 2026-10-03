package com.salesforce.marketingcloud.legacycrypto;

import android.util.Log;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class OldSdkHash implements SdkHash {
    static final String TAG = "OldSdkHash";
    public static final Charset UTF_8 = StandardCharsets.UTF_8;

    private static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(UTF_8);
            messageDigest.update(bytes, 0, bytes.length);
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Throwable th) {
            Log.e(TAG, "md5 failed", th);
            return "";
        }
    }

    @Override // com.salesforce.marketingcloud.legacycrypto.SdkHash
    public String generateHash(String str) {
        return md5(str);
    }
}
