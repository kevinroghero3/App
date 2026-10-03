package com.google.crypto.tink.hybrid.subtle;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.aead.subtle.AeadFactory;
import com.google.crypto.tink.subtle.Hkdf;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;

/* JADX INFO: loaded from: classes5.dex */
public final class RsaKemHybridEncrypt implements HybridEncrypt {
    private final AeadFactory aeadFactory;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final RSAPublicKey recipientPublicKey;

    public RsaKemHybridEncrypt(RSAPublicKey rSAPublicKey, String str, byte[] bArr, AeadFactory aeadFactory) throws GeneralSecurityException {
        RsaKem.validateRsaModulus(rSAPublicKey.getModulus());
        this.recipientPublicKey = rSAPublicKey;
        this.hkdfHmacAlgo = str;
        this.hkdfSalt = bArr;
        this.aeadFactory = aeadFactory;
    }

    @Override // com.google.crypto.tink.HybridEncrypt
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrGenerateSecret = RsaKem.generateSecret(this.recipientPublicKey.getModulus());
        byte[] bArrRsaEncrypt = RsaKem.rsaEncrypt(this.recipientPublicKey, bArrGenerateSecret);
        byte[] bArrEncrypt = this.aeadFactory.createAead(Hkdf.computeHkdf(this.hkdfHmacAlgo, bArrGenerateSecret, this.hkdfSalt, bArr2, this.aeadFactory.getKeySizeInBytes())).encrypt(bArr, RsaKem.EMPTY_AAD);
        return ByteBuffer.allocate(bArrRsaEncrypt.length + bArrEncrypt.length).put(bArrRsaEncrypt).put(bArrEncrypt).array();
    }
}
