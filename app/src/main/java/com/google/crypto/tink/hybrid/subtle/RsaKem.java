package com.google.crypto.tink.hybrid.subtle;

import com.google.crypto.tink.internal.BigIntegerEncoding;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes5.dex */
class RsaKem {
    static final byte[] EMPTY_AAD = new byte[0];
    static final int MIN_RSA_KEY_LENGTH_BITS = 2048;

    private RsaKem() {
    }

    static void validateRsaModulus(BigInteger bigInteger) throws GeneralSecurityException {
        if (bigInteger.bitLength() < 2048) {
            throw new GeneralSecurityException(String.format("RSA key must be of at least size %d bits, but got %d", 2048, Integer.valueOf(bigInteger.bitLength())));
        }
    }

    static int bigIntSizeInBytes(BigInteger bigInteger) {
        return (bigInteger.bitLength() + 7) / 8;
    }

    static byte[] rsaEncrypt(PublicKey publicKey, byte[] bArr) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(1, publicKey);
        try {
            return cipher.doFinal(bArr);
        } catch (RuntimeException e) {
            throw new GeneralSecurityException(e);
        }
    }

    static byte[] rsaDecrypt(PrivateKey privateKey, byte[] bArr) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(2, privateKey);
        try {
            return cipher.doFinal(bArr);
        } catch (RuntimeException e) {
            throw new GeneralSecurityException(e);
        }
    }

    static byte[] generateSecret(BigInteger bigInteger) {
        int iBigIntSizeInBytes = bigIntSizeInBytes(bigInteger);
        SecureRandom secureRandom = new SecureRandom();
        while (true) {
            BigInteger bigInteger2 = new BigInteger(bigInteger.bitLength(), secureRandom);
            if (bigInteger2.signum() > 0 && bigInteger2.compareTo(bigInteger) < 0) {
                try {
                    return BigIntegerEncoding.toBigEndianBytesOfFixedLength(bigInteger2, iBigIntSizeInBytes);
                } catch (GeneralSecurityException e) {
                    throw new IllegalStateException("Unable to convert BigInteger to byte array", e);
                }
            }
        }
    }

    static KeyPair generateRsaKeyPair(int i) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(i);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No support for RSA algorithm.", e);
        }
    }
}
