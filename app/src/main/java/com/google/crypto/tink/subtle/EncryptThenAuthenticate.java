package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.aead.AesCtrHmacAeadKey;
import com.google.crypto.tink.internal.Util;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class EncryptThenAuthenticate implements Aead {
    private final IndCpaCipher cipher;
    private final Mac mac;
    private final int macLength;
    private final byte[] outputPrefix;

    public EncryptThenAuthenticate(IndCpaCipher indCpaCipher, Mac mac, int i) {
        this(indCpaCipher, mac, i, new byte[0]);
    }

    private EncryptThenAuthenticate(IndCpaCipher indCpaCipher, Mac mac, int i, byte[] bArr) {
        this.cipher = indCpaCipher;
        this.mac = mac;
        this.macLength = i;
        this.outputPrefix = bArr;
    }

    public static Aead create(AesCtrHmacAeadKey aesCtrHmacAeadKey) throws GeneralSecurityException {
        return new EncryptThenAuthenticate(new AesCtrJceCipher(aesCtrHmacAeadKey.getAesKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), aesCtrHmacAeadKey.getParameters().getIvSizeBytes()), new PrfMac(new PrfHmacJce("HMAC" + aesCtrHmacAeadKey.getParameters().getHashType(), new SecretKeySpec(aesCtrHmacAeadKey.getHmacKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), "HMAC")), aesCtrHmacAeadKey.getParameters().getTagSizeBytes()), aesCtrHmacAeadKey.getParameters().getTagSizeBytes(), aesCtrHmacAeadKey.getOutputPrefix().toByteArray());
    }

    public static Aead newAesCtrHmac(byte[] bArr, int i, String str, byte[] bArr2, int i2) throws GeneralSecurityException {
        return new EncryptThenAuthenticate(new AesCtrJceCipher(bArr, i), new PrfMac(new PrfHmacJce(str, new SecretKeySpec(bArr2, "HMAC")), i2), i2);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrEncrypt = this.cipher.encrypt(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return Bytes.concat(this.outputPrefix, bArrEncrypt, this.mac.computeMac(Bytes.concat(bArr2, bArrEncrypt, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))));
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.macLength;
        byte[] bArr3 = this.outputPrefix;
        if (length < i + bArr3.length) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        }
        if (!Util.isPrefix(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, this.outputPrefix.length, bArr.length - this.macLength);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.macLength, bArr.length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        this.mac.verifyMac(bArrCopyOfRange2, Bytes.concat(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8)));
        return this.cipher.decrypt(bArrCopyOfRange);
    }
}
