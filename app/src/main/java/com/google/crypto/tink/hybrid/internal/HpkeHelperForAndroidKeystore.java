package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.hybrid.HpkePublicKey;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public final class HpkeHelperForAndroidKeystore {
    private static final byte[] EMPTY_ASSOCIATED_DATA = new byte[0];
    private final HpkeAead aead;
    private final HpkeKdf kdf;
    private final HpkeKem kem;
    private final byte[] publicKeyByteArray;

    private HpkeHelperForAndroidKeystore(HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr) {
        this.kem = hpkeKem;
        this.kdf = hpkeKdf;
        this.aead = hpkeAead;
        this.publicKeyByteArray = bArr;
    }

    public static HpkeHelperForAndroidKeystore create(HpkePublicKey hpkePublicKey) throws GeneralSecurityException {
        HpkeParameters parameters = hpkePublicKey.getParameters();
        validateParameters(parameters);
        return new HpkeHelperForAndroidKeystore(HpkePrimitiveFactory.createKem(parameters.getKemId()), HpkePrimitiveFactory.createKdf(parameters.getKdfId()), HpkePrimitiveFactory.createAead(parameters.getAeadId()), hpkePublicKey.getPublicKeyBytes().toByteArray());
    }

    private static void validateParameters(HpkeParameters hpkeParameters) throws GeneralSecurityException {
        if (!hpkeParameters.getKemId().equals(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256)) {
            throw new GeneralSecurityException("HpkeHelperForAndroidKeystore currently only supports DHKEM_P256_HKDF_SHA256.");
        }
        if (!hpkeParameters.getKdfId().equals(HpkeParameters.KdfId.HKDF_SHA256)) {
            throw new GeneralSecurityException("HpkeHelperForAndroidKeystore currently only supports HKDF_SHA256.");
        }
        if (!hpkeParameters.getAeadId().equals(HpkeParameters.AeadId.AES_128_GCM) && !hpkeParameters.getAeadId().equals(HpkeParameters.AeadId.AES_256_GCM)) {
            throw new GeneralSecurityException("HpkeHelperForAndroidKeystore currently only supports AES_128_GCM and AES_256_GCM.");
        }
        if (!hpkeParameters.getVariant().equals(HpkeParameters.Variant.NO_PREFIX)) {
            throw new GeneralSecurityException("HpkeHelperForAndroidKeystore currently only supports Variant.NO_PREFIX");
        }
    }

    public byte[] decryptUnauthenticatedWithEncapsulatedKeyAndP256SharedSecret(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        if (bArr4 == null) {
            bArr4 = new byte[0];
        }
        byte[] bArr5 = bArr4;
        return HpkeContext.createContext(HpkeUtil.BASE_MODE, bArr, NistCurvesHpkeKem.fromCurve(EllipticCurves.CurveType.NIST_P256).deriveKemSharedSecret(bArr2, bArr, this.publicKeyByteArray), this.kem, this.kdf, this.aead, bArr5).open(bArr3, i, EMPTY_ASSOCIATED_DATA);
    }
}
