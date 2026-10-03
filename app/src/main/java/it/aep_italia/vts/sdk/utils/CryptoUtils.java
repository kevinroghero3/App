package it.aep_italia.vts.sdk.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class CryptoUtils {
    private static Cipher a() throws GeneralSecurityException {
        try {
            return Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new GeneralSecurityException("Could not create cipher", e);
        }
    }

    public static byte[] aesDecrypt(InputStream inputStream, byte[] bArr) throws IOException {
        if (inputStream != null) {
            return aesDecrypt(StreamUtils.extractAll(inputStream), bArr);
        }
        throw new IOException("Input stream cannot be null");
    }

    public static byte[] aesDecrypt(byte[] bArr, byte[] bArr2) throws IOException {
        if (bArr == null) {
            throw new IOException("Input payload cannot be null");
        }
        if (bArr2 == null) {
            throw new IOException("Decryption key cannot be null");
        }
        if (bArr2.length != 16 && bArr2.length != 24 && bArr2.length != 32) {
            throw new IOException("Invalid key size (supported: 16/24/32 bytes, got: " + bArr2.length + " bytes");
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipherA = a();
            cipherA.init(2, secretKeySpec, new IvParameterSpec(new byte[bArr2.length]));
            return cipherA.doFinal(bArr);
        } catch (Exception e) {
            throw new IOException("Decryption failed", e);
        }
    }

    public static byte[] aesEncrypt(byte[] bArr, byte[] bArr2) throws IOException {
        if (bArr == null) {
            throw new IOException("Input payload cannot be null");
        }
        if (bArr2 == null) {
            throw new IOException("Encryption key cannot be null");
        }
        if (bArr2.length != 16 && bArr2.length != 24 && bArr2.length != 32) {
            throw new IOException("Invalid key size (supported: 16/24/32 bytes, got: " + bArr2.length + " bytes");
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipherA = a();
            cipherA.init(1, secretKeySpec, new IvParameterSpec(new byte[bArr2.length]));
            return cipherA.doFinal(bArr);
        } catch (Exception e) {
            throw new IOException("Encryption failed", e);
        }
    }

    public static byte[][] readKeys(InputStream inputStream) throws Exception {
        ArrayList arrayList = new ArrayList();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            StreamUtils.pipeAndClose(inputStream, byteArrayOutputStream);
            int i = 0;
            for (String str : new String(byteArrayOutputStream.toByteArray()).split("\r?\n")) {
                String strTrim = str.trim();
                if (strTrim.length() > 0) {
                    arrayList.add(strTrim);
                }
            }
            if (arrayList.size() < 2 || !Pattern.matches("^(\\d+);(\\d+)$", (CharSequence) arrayList.get(0))) {
                throw new IllegalArgumentException("Unrecognized file format");
            }
            String[] strArrSplit = ((String) arrayList.get(0)).split(";");
            int i2 = Integer.parseInt(strArrSplit[0]);
            int i3 = Integer.parseInt(strArrSplit[1]);
            if (arrayList.size() != i2 + 1) {
                throw new IllegalArgumentException("Expected " + i2 + " keys, found " + (arrayList.size() - 1));
            }
            byte[][] bArr = new byte[i2][];
            while (i < i2) {
                int i4 = i + 1;
                try {
                    byte[] bArrStringToBytes = ByteUtils.stringToBytes((String) arrayList.get(i4));
                    if (bArrStringToBytes.length * 8 != i3) {
                        throw new IllegalArgumentException("Wrong key length (read " + (bArrStringToBytes.length * 8) + " bits)");
                    }
                    bArr[i] = bArrStringToBytes;
                    i = i4;
                } catch (Exception e) {
                    throw new IllegalArgumentException("Could not parse key", e);
                }
            }
            return bArr;
        } catch (Exception e2) {
            if (e2 instanceof IOException) {
                throw e2;
            }
            throw new IOException("Could not complete operation", e2);
        }
    }
}
