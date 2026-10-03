package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.hybrid.HpkePrivateKey;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class HpkeDecrypt implements HybridDecrypt {
    private static final byte[] EMPTY_ASSOCIATED_DATA = new byte[0];
    private final HpkeAead aead;
    private final int encapsulatedKeyLength;
    private final HpkeKdf kdf;
    private final HpkeKem kem;
    private final byte[] outputPrefix;
    private final HpkeKemPrivateKey recipientPrivateKey;

    private HpkeDecrypt(HpkeKemPrivateKey hpkeKemPrivateKey, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, int i, Bytes bytes) {
        this.recipientPrivateKey = hpkeKemPrivateKey;
        this.kem = hpkeKem;
        this.kdf = hpkeKdf;
        this.aead = hpkeAead;
        this.encapsulatedKeyLength = i;
        this.outputPrefix = bytes.toByteArray();
    }

    private static int encodingSizeInBytes(HpkeParameters.KemId kemId) throws GeneralSecurityException {
        if (kemId.equals(HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256)) {
            return 32;
        }
        if (kemId.equals(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256)) {
            return 65;
        }
        if (kemId.equals(HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384)) {
            return 97;
        }
        if (kemId.equals(HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512)) {
            return 133;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    private static HpkeKemPrivateKey createHpkeKemPrivateKey(HpkePrivateKey hpkePrivateKey) throws GeneralSecurityException {
        HpkeParameters.KemId kemId = hpkePrivateKey.getParameters().getKemId();
        if (kemId.equals(HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) || kemId.equals(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) || kemId.equals(HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) || kemId.equals(HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512)) {
            return new HpkeKemPrivateKey(Bytes.copyFrom(hpkePrivateKey.getPrivateKeyBytes().toByteArray(InsecureSecretKeyAccess.get())), hpkePrivateKey.getPublicKey().getPublicKeyBytes());
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public static HybridDecrypt create(HpkePrivateKey hpkePrivateKey) throws GeneralSecurityException {
        HpkeParameters parameters = hpkePrivateKey.getParameters();
        return new HpkeDecrypt(createHpkeKemPrivateKey(hpkePrivateKey), HpkePrimitiveFactory.createKem(parameters.getKemId()), HpkePrimitiveFactory.createKdf(parameters.getKdfId()), HpkePrimitiveFactory.createAead(parameters.getAeadId()), encodingSizeInBytes(parameters.getKemId()), hpkePrivateKey.getOutputPrefix());
    }

    @Override // com.google.crypto.tink.HybridDecrypt
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.outputPrefix;
        int length = bArr3.length + this.encapsulatedKeyLength;
        if (bArr.length < length) {
            throw new GeneralSecurityException("Ciphertext is too short.");
        }
        if (!Util.isPrefix(bArr3, bArr)) {
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return HpkeContext.createRecipientContext(Arrays.copyOfRange(bArr, this.outputPrefix.length, length), this.recipientPrivateKey, this.kem, this.kdf, this.aead, bArr2).open(bArr, length, EMPTY_ASSOCIATED_DATA);
    }
}
