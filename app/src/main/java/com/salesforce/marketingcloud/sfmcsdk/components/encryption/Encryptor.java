package com.salesforce.marketingcloud.sfmcsdk.components.encryption;

import android.text.TextUtils;
import android.util.Base64;
import io.sentry.android.core.SentryLogcatAdapter;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
class Encryptor {
    private static final String AES_CBC_CIPHER = "AES/CBC/PKCS5Padding";
    private static final String AES_GCM_CIPHER = "AES/GCM/NoPadding";
    private static final String BOUNCY_CASTLE = "BC";
    private static final String MAC_TRANSFORMATION = "HmacSHA256";
    private static final String RSA_PKCS1 = "RSA/ECB/PKCS1Padding";
    private static final String SHA1PRNG = "SHA1PRNG";
    private static final String TAG = "Encryptor";

    Encryptor() {
    }

    private static Cipher getEncryptingCipher(byte[] bArr, byte[] bArr2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher bestCipher = getBestCipher(AES_GCM_CIPHER);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, bestCipher.getAlgorithm());
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        bestCipher.init(1, secretKeySpec, ivParameterSpec);
        bestCipher.updateAAD(ivParameterSpec.getIV());
        return bestCipher;
    }

    private static Cipher getDecryptingCipher(byte[] bArr, byte[] bArr2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher bestCipher = getBestCipher(AES_GCM_CIPHER);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, bestCipher.getAlgorithm());
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        bestCipher.init(2, secretKeySpec, ivParameterSpec);
        bestCipher.updateAAD(ivParameterSpec.getIV());
        return bestCipher;
    }

    private static Cipher getLegacyDecryptingCipher(byte[] bArr, byte[] bArr2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher bestCipher = getBestCipher(AES_CBC_CIPHER);
        bestCipher.init(2, new SecretKeySpec(bArr, bestCipher.getAlgorithm()), new IvParameterSpec(bArr2));
        return bestCipher;
    }

    @Deprecated
    public static String legacyDecrypt(String str, String str2) {
        return decrypt(str, str2, new byte[16]);
    }

    public static String decrypt(String str, String str2) {
        return decrypt(str, str2, new byte[12]);
    }

    @Deprecated
    public static String legacyDecrypt(byte[] bArr, String str) {
        return decrypt(bArr, str, new byte[16]);
    }

    public static String decrypt(byte[] bArr, String str) {
        return decrypt(bArr, str, new byte[12]);
    }

    public static String decrypt(String str, String str2, byte[] bArr) {
        return (TextUtils.isEmpty(str2) || str == null) ? str : decrypt(str.getBytes(), str2, bArr);
    }

    public static String decrypt(byte[] bArr, String str, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            if (bArr != null) {
                return new String(bArr, StandardCharsets.UTF_8);
            }
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 2);
            byte[] bArrDecode2 = Base64.decode(bArr, 2);
            byte[] bArrDecrypt = decrypt(bArrDecode2, bArrDecode2.length, bArrDecode, bArr2);
            return new String(bArrDecrypt, 0, bArrDecrypt.length, StandardCharsets.UTF_8);
        } catch (Exception e) {
            SentryLogcatAdapter.w(TAG, "Error during decryption", e);
            return null;
        }
    }

    public static String encrypt(String str, String str2) {
        try {
            return encrypt(str, str2, generateInitVector());
        } catch (Exception e) {
            SentryLogcatAdapter.w(TAG, "Error during encryption", e);
            return null;
        }
    }

    public static String encrypt(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str2) || str == null) {
            return str;
        }
        byte[] bArrEncryptBytes = encryptBytes(str, str2, bArr);
        if (bArrEncryptBytes == null) {
            return null;
        }
        try {
            return new String(bArrEncryptBytes, StandardCharsets.US_ASCII);
        } catch (Exception e) {
            SentryLogcatAdapter.w(TAG, "Error during encryption", e);
            return null;
        }
    }

    public static byte[] encryptBytes(String str, String str2) {
        try {
            return encryptBytes(str, str2, generateInitVector());
        } catch (Exception e) {
            SentryLogcatAdapter.w(TAG, "Error during encryption", e);
            return null;
        }
    }

    public static byte[] encryptBytes(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str2)) {
            if (str == null) {
                return null;
            }
            return str.getBytes();
        }
        try {
            return Base64.encode(encrypt(str.getBytes(StandardCharsets.UTF_8), Base64.decode(str2, 2), bArr), 2);
        } catch (Exception e) {
            SentryLogcatAdapter.w(TAG, "Error during encryption", e);
            return null;
        }
    }

    public static String encryptWithRSA(PublicKey publicKey, String str) {
        byte[] bArrEncryptWithRSABytes = encryptWithRSABytes(publicKey, str);
        if (bArrEncryptWithRSABytes != null) {
            return Base64.encodeToString(bArrEncryptWithRSABytes, 3);
        }
        return null;
    }

    public static byte[] encryptWithRSABytes(PublicKey publicKey, String str) {
        return encryptWithPublicKey(publicKey, str, RSA_PKCS1);
    }

    public static String decryptWithRSA(PrivateKey privateKey, String str) {
        byte[] bArrDecryptWithRSABytes = decryptWithRSABytes(privateKey, str);
        if (bArrDecryptWithRSABytes != null) {
            try {
                return new String(bArrDecryptWithRSABytes, 0, bArrDecryptWithRSABytes.length, StandardCharsets.UTF_8);
            } catch (Exception e) {
                SentryLogcatAdapter.e(TAG, "Error during asymmetric decryption using RSA", e);
            }
        }
        return null;
    }

    public static byte[] decryptWithRSABytes(PrivateKey privateKey, String str) {
        return decryptWithPrivateKey(privateKey, str, RSA_PKCS1);
    }

    public static String decryptBytes(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            byte[] bArrDoFinal = getLegacyDecryptingCipher(bArr2, bArr3).doFinal(bArr, 0, bArr.length);
            return new String(bArrDoFinal, 0, bArrDoFinal.length, StandardCharsets.UTF_8);
        } catch (Exception e) {
            SentryLogcatAdapter.e(TAG, "Error during symmetric decryption using AES", e);
            return null;
        }
    }

    private static byte[] encryptWithPublicKey(PublicKey publicKey, String str, String str2) {
        if (publicKey == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(str2);
            cipher.init(1, publicKey);
            return cipher.doFinal(str.getBytes());
        } catch (Exception e) {
            SentryLogcatAdapter.e(TAG, "Error during asymmetric encryption", e);
            return null;
        }
    }

    private static byte[] decryptWithPrivateKey(PrivateKey privateKey, String str, String str2) {
        if (privateKey == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(str2);
            cipher.init(2, privateKey);
            return cipher.doFinal(Base64.decode(str.getBytes(), 3));
        } catch (Exception e) {
            SentryLogcatAdapter.e(TAG, "Error during asymmetric decryption", e);
            return null;
        }
    }

    public static byte[] generateInitVector() throws NoSuchAlgorithmException {
        byte[] bArr = new byte[12];
        SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
        return bArr;
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] bArrDoFinal = getEncryptingCipher(bArr2, bArr3).doFinal(bArr);
        byte[] bArr4 = new byte[bArr3.length + bArrDoFinal.length];
        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
        System.arraycopy(bArrDoFinal, 0, bArr4, bArr3.length, bArrDoFinal.length);
        return bArr4;
    }

    private static byte[] decrypt(byte[] bArr, int i, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        Cipher legacyDecryptingCipher;
        System.arraycopy(bArr, 0, bArr3, 0, bArr3.length);
        int length = i - bArr3.length;
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, bArr3.length, bArr4, 0, length);
        if (bArr3.length == 12) {
            legacyDecryptingCipher = getDecryptingCipher(bArr2, bArr3);
        } else {
            legacyDecryptingCipher = getLegacyDecryptingCipher(bArr2, bArr3);
        }
        return legacyDecryptingCipher.doFinal(bArr4, 0, length);
    }

    private static Cipher getBestCipher(String str) {
        Cipher cipher;
        try {
            if (AES_GCM_CIPHER.equals(str)) {
                cipher = Cipher.getInstance(str);
            } else {
                cipher = Cipher.getInstance(str, getLegacyEncryptionProvider());
            }
            return cipher;
        } catch (Exception e) {
            SentryLogcatAdapter.e(TAG, "No cipher transformation available", e);
            return null;
        }
    }

    private static String getLegacyEncryptionProvider() {
        return BOUNCY_CASTLE;
    }
}
