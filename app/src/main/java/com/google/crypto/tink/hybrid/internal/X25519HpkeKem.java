package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.subtle.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
final class X25519HpkeKem implements HpkeKem {
    private final HkdfHpkeKdf hkdf;
    private final X25519 x25519;

    @Immutable
    static final class X25519Java implements X25519 {
        private X25519Java() {
        }

        @Override // com.google.crypto.tink.hybrid.internal.X25519
        public X25519.KeyPair generateKeyPair() throws GeneralSecurityException {
            byte[] bArrGeneratePrivateKey = com.google.crypto.tink.subtle.X25519.generatePrivateKey();
            return new X25519.KeyPair(bArrGeneratePrivateKey, com.google.crypto.tink.subtle.X25519.publicFromPrivate(bArrGeneratePrivateKey));
        }

        @Override // com.google.crypto.tink.hybrid.internal.X25519
        public byte[] computeSharedSecret(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return com.google.crypto.tink.subtle.X25519.computeSharedSecret(bArr, bArr2);
        }
    }

    X25519HpkeKem(HkdfHpkeKdf hkdfHpkeKdf) {
        X25519 x25519Java;
        this.hkdf = hkdfHpkeKdf;
        try {
            x25519Java = X25519Conscrypt.create();
        } catch (GeneralSecurityException unused) {
            x25519Java = new X25519Java();
        }
        this.x25519 = x25519Java;
    }

    private byte[] deriveKemSharedSecret(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return extractAndExpand(bArr, Bytes.concat(bArr2, bArr3));
    }

    private byte[] deriveKemSharedSecret(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        return extractAndExpand(bArr, Bytes.concat(bArr2, bArr3, bArr4));
    }

    private byte[] extractAndExpand(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrKemSuiteId = HpkeUtil.kemSuiteId(HpkeUtil.X25519_HKDF_SHA256_KEM_ID);
        HkdfHpkeKdf hkdfHpkeKdf = this.hkdf;
        return hkdfHpkeKdf.extractAndExpand(null, bArr, "eae_prk", bArr2, "shared_secret", bArrKemSuiteId, hkdfHpkeKdf.getMacLength());
    }

    HpkeKemEncapOutput encapsulateWithFixedEphemeralKey(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return new HpkeKemEncapOutput(deriveKemSharedSecret(this.x25519.computeSharedSecret(bArr2, bArr), bArr3, bArr), bArr3);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public HpkeKemEncapOutput encapsulate(byte[] bArr) throws GeneralSecurityException {
        X25519.KeyPair keyPairGenerateKeyPair = this.x25519.generateKeyPair();
        return encapsulateWithFixedEphemeralKey(bArr, keyPairGenerateKeyPair.privateKey, keyPairGenerateKeyPair.publicKey);
    }

    HpkeKemEncapOutput authEncapsulateWithFixedEphemeralKey(byte[] bArr, byte[] bArr2, byte[] bArr3, HpkeKemPrivateKey hpkeKemPrivateKey) throws GeneralSecurityException {
        return new HpkeKemEncapOutput(deriveKemSharedSecret(Bytes.concat(this.x25519.computeSharedSecret(bArr2, bArr), this.x25519.computeSharedSecret(hpkeKemPrivateKey.getSerializedPrivate().toByteArray(), bArr)), bArr3, bArr, hpkeKemPrivateKey.getSerializedPublic().toByteArray()), bArr3);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public HpkeKemEncapOutput authEncapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey) throws GeneralSecurityException {
        X25519.KeyPair keyPairGenerateKeyPair = this.x25519.generateKeyPair();
        return authEncapsulateWithFixedEphemeralKey(bArr, keyPairGenerateKeyPair.privateKey, keyPairGenerateKeyPair.publicKey, hpkeKemPrivateKey);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] decapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey) throws GeneralSecurityException {
        return deriveKemSharedSecret(this.x25519.computeSharedSecret(hpkeKemPrivateKey.getSerializedPrivate().toByteArray(), bArr), bArr, hpkeKemPrivateKey.getSerializedPublic().toByteArray());
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] authDecapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey, byte[] bArr2) throws GeneralSecurityException {
        byte[] byteArray = hpkeKemPrivateKey.getSerializedPrivate().toByteArray();
        return deriveKemSharedSecret(Bytes.concat(this.x25519.computeSharedSecret(byteArray, bArr), this.x25519.computeSharedSecret(byteArray, bArr2)), bArr, hpkeKemPrivateKey.getSerializedPublic().toByteArray(), bArr2);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] getKemId() throws GeneralSecurityException {
        if (Arrays.equals(this.hkdf.getKdfId(), HpkeUtil.HKDF_SHA256_KDF_ID)) {
            return HpkeUtil.X25519_HKDF_SHA256_KEM_ID;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
