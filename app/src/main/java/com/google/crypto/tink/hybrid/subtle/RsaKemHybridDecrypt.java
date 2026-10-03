package com.google.crypto.tink.hybrid.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.aead.subtle.AeadFactory;
import com.google.crypto.tink.subtle.Hkdf;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;

/* JADX INFO: loaded from: classes5.dex */
public final class RsaKemHybridDecrypt implements HybridDecrypt {
    private final AeadFactory aeadFactory;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final int modSizeInBytes;
    private final PrivateKey recipientPrivateKey;

    private RsaKemHybridDecrypt(PrivateKey privateKey, String str, byte[] bArr, AeadFactory aeadFactory) throws GeneralSecurityException {
        BigInteger modulus = ((RSAKey) privateKey).getModulus();
        RsaKem.validateRsaModulus(modulus);
        this.recipientPrivateKey = privateKey;
        this.hkdfSalt = bArr;
        this.hkdfHmacAlgo = str;
        this.aeadFactory = aeadFactory;
        this.modSizeInBytes = RsaKem.bigIntSizeInBytes(modulus);
    }

    public RsaKemHybridDecrypt(RSAPrivateKey rSAPrivateKey, String str, byte[] bArr, AeadFactory aeadFactory) throws GeneralSecurityException {
        this((PrivateKey) rSAPrivateKey, str, bArr, aeadFactory);
    }

    public static RsaKemHybridDecrypt create(PrivateKey privateKey, String str, byte[] bArr, AeadFactory aeadFactory) throws GeneralSecurityException {
        if (!(privateKey instanceof RSAKey)) {
            throw new InvalidKeyException("Must be an RSA private key");
        }
        return new RsaKemHybridDecrypt(privateKey, str, bArr, aeadFactory);
    }

    @Override // com.google.crypto.tink.HybridDecrypt
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.modSizeInBytes;
        if (length < i) {
            throw new GeneralSecurityException(String.format("Ciphertext must be of at least size %d bytes, but got %d", Integer.valueOf(i), Integer.valueOf(bArr.length)));
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byte[] bArr3 = new byte[this.modSizeInBytes];
        byteBufferWrap.get(bArr3);
        Aead aeadCreateAead = this.aeadFactory.createAead(Hkdf.computeHkdf(this.hkdfHmacAlgo, RsaKem.rsaDecrypt(this.recipientPrivateKey, bArr3), this.hkdfSalt, bArr2, this.aeadFactory.getKeySizeInBytes()));
        byte[] bArr4 = new byte[byteBufferWrap.remaining()];
        byteBufferWrap.get(bArr4);
        return aeadCreateAead.decrypt(bArr4, RsaKem.EMPTY_AAD);
    }
}
