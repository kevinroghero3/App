package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.hybrid.HpkePublicKey;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class AuthHpkeHelperForAndroidKeystore {
    private static final byte[] EMPTY_ASSOCIATED_DATA = new byte[0];
    private final HpkeAead aead;
    private final HpkeKdf kdf;
    private final HpkeKem kem;
    private final byte[] ourPublicKeyByteArray;
    private final byte[] theirPublicKeyByteArray;

    private AuthHpkeHelperForAndroidKeystore(HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr, byte[] bArr2) {
        this.kem = hpkeKem;
        this.kdf = hpkeKdf;
        this.aead = hpkeAead;
        this.ourPublicKeyByteArray = bArr;
        this.theirPublicKeyByteArray = bArr2;
    }

    public static AuthHpkeHelperForAndroidKeystore create(HpkePublicKey hpkePublicKey, HpkePublicKey hpkePublicKey2) throws GeneralSecurityException {
        if (!hpkePublicKey.getParameters().equals(hpkePublicKey2.getParameters())) {
            throw new GeneralSecurityException("ourPublicKey.getParameters() must be equal to theirPublicKey.getParameters()");
        }
        HpkeParameters parameters = hpkePublicKey.getParameters();
        validateParameters(parameters);
        return new AuthHpkeHelperForAndroidKeystore(HpkePrimitiveFactory.createKem(parameters.getKemId()), HpkePrimitiveFactory.createKdf(parameters.getKdfId()), HpkePrimitiveFactory.createAead(parameters.getAeadId()), hpkePublicKey.getPublicKeyBytes().toByteArray(), hpkePublicKey2.getPublicKeyBytes().toByteArray());
    }

    private static void validateParameters(HpkeParameters hpkeParameters) throws GeneralSecurityException {
        if (!hpkeParameters.getKemId().equals(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256)) {
            throw new GeneralSecurityException("AuthHpkeHelperForAndroidKeystore currently only supports KemId.DHKEM_P256_HKDF_SHA256.");
        }
        if (!hpkeParameters.getKdfId().equals(HpkeParameters.KdfId.HKDF_SHA256)) {
            throw new GeneralSecurityException("AuthHpkeHelperForAndroidKeystore currently only supports KdfId.HKDF_SHA256.");
        }
        if (!hpkeParameters.getAeadId().equals(HpkeParameters.AeadId.AES_128_GCM) && !hpkeParameters.getAeadId().equals(HpkeParameters.AeadId.AES_256_GCM)) {
            throw new GeneralSecurityException("AuthHpkeHelperForAndroidKeystore currently only supports AeadId.AES_128_GCM and AeadId.AES_256_GCM.");
        }
        if (!hpkeParameters.getVariant().equals(HpkeParameters.Variant.NO_PREFIX)) {
            throw new GeneralSecurityException("AuthHpkeHelperForAndroidKeystore currently only supports Variant.NO_PREFIX");
        }
    }

    public byte[] decryptAuthenticatedWithEncapsulatedKeyAndP256SharedSecret(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, byte[] bArr5) throws GeneralSecurityException {
        return HpkeContext.createContext(HpkeUtil.AUTH_MODE, bArr, NistCurvesHpkeKem.fromCurve(EllipticCurves.CurveType.NIST_P256).deriveKemSharedSecret(Bytes.concat(bArr2, bArr3), bArr, this.ourPublicKeyByteArray, this.theirPublicKeyByteArray), this.kem, this.kdf, this.aead, bArr5).open(bArr4, i, EMPTY_ASSOCIATED_DATA);
    }

    public byte[] encryptAuthenticatedWithEncapsulatedKeyAndP256SharedSecret(ECPoint eCPoint, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        EllipticCurves.CurveType curveType = EllipticCurves.CurveType.NIST_P256;
        byte[] bArrPointEncode = EllipticCurves.pointEncode(curveType, EllipticCurves.PointFormatType.UNCOMPRESSED, eCPoint);
        return Bytes.concat(bArrPointEncode, HpkeContext.createContext(HpkeUtil.AUTH_MODE, bArrPointEncode, NistCurvesHpkeKem.fromCurve(curveType).deriveKemSharedSecret(Bytes.concat(bArr, bArr2), bArrPointEncode, this.theirPublicKeyByteArray, this.ourPublicKeyByteArray), this.kem, this.kdf, this.aead, bArr4).seal(bArr3, EMPTY_ASSOCIATED_DATA));
    }
}
