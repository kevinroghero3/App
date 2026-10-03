package com.google.crypto.tink.subtle;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.hybrid.EciesParameters;
import com.google.crypto.tink.hybrid.EciesPublicKey;
import com.google.crypto.tink.hybrid.internal.EciesDemHelper;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* JADX INFO: loaded from: classes3.dex */
public final class EciesAeadHkdfHybridEncrypt implements HybridEncrypt {
    static final EnumTypeProtoConverter<EllipticCurves.CurveType, EciesParameters.CurveType> CURVE_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(EllipticCurves.CurveType.NIST_P256, EciesParameters.CurveType.NIST_P256).add(EllipticCurves.CurveType.NIST_P384, EciesParameters.CurveType.NIST_P384).add(EllipticCurves.CurveType.NIST_P521, EciesParameters.CurveType.NIST_P521).build();
    static final EnumTypeProtoConverter<EllipticCurves.PointFormatType, EciesParameters.PointFormat> POINT_FORMAT_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(EllipticCurves.PointFormatType.UNCOMPRESSED, EciesParameters.PointFormat.UNCOMPRESSED).add(EllipticCurves.PointFormatType.COMPRESSED, EciesParameters.PointFormat.COMPRESSED).add(EllipticCurves.PointFormatType.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, EciesParameters.PointFormat.LEGACY_UNCOMPRESSED).build();
    private final EciesDemHelper.Dem dem;
    private final EllipticCurves.PointFormatType ecPointFormat;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final byte[] outputPrefix;
    private final EciesHkdfSenderKem senderKem;

    static final String toHmacAlgo(EciesParameters.HashType hashType) throws GeneralSecurityException {
        if (hashType.equals(EciesParameters.HashType.SHA1)) {
            return "HmacSha1";
        }
        if (hashType.equals(EciesParameters.HashType.SHA224)) {
            return "HmacSha224";
        }
        if (hashType.equals(EciesParameters.HashType.SHA256)) {
            return "HmacSha256";
        }
        if (hashType.equals(EciesParameters.HashType.SHA384)) {
            return "HmacSha384";
        }
        if (hashType.equals(EciesParameters.HashType.SHA512)) {
            return "HmacSha512";
        }
        throw new GeneralSecurityException("hash unsupported for EciesAeadHkdf: " + hashType);
    }

    private EciesAeadHkdfHybridEncrypt(ECPublicKey eCPublicKey, byte[] bArr, String str, EllipticCurves.PointFormatType pointFormatType, EciesDemHelper.Dem dem, byte[] bArr2) throws GeneralSecurityException {
        EllipticCurves.checkPublicKey(eCPublicKey);
        this.senderKem = new EciesHkdfSenderKem(eCPublicKey);
        this.hkdfSalt = bArr;
        this.hkdfHmacAlgo = str;
        this.ecPointFormat = pointFormatType;
        this.dem = dem;
        this.outputPrefix = bArr2;
    }

    public static HybridEncrypt create(EciesPublicKey eciesPublicKey) throws GeneralSecurityException {
        ECPublicKey ecPublicKey = EllipticCurves.getEcPublicKey((EllipticCurves.CurveType) CURVE_TYPE_CONVERTER.toProtoEnum(eciesPublicKey.getParameters().getCurveType()), eciesPublicKey.getNistCurvePoint().getAffineX().toByteArray(), eciesPublicKey.getNistCurvePoint().getAffineY().toByteArray());
        byte[] byteArray = new byte[0];
        if (eciesPublicKey.getParameters().getSalt() != null) {
            byteArray = eciesPublicKey.getParameters().getSalt().toByteArray();
        }
        return new EciesAeadHkdfHybridEncrypt(ecPublicKey, byteArray, toHmacAlgo(eciesPublicKey.getParameters().getHashType()), (EllipticCurves.PointFormatType) POINT_FORMAT_TYPE_CONVERTER.toProtoEnum(eciesPublicKey.getParameters().getNistCurvePointFormat()), EciesDemHelper.getDem(eciesPublicKey.getParameters()), eciesPublicKey.getOutputPrefix().toByteArray());
    }

    @Override // com.google.crypto.tink.HybridEncrypt
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        EciesHkdfSenderKem.KemKey kemKeyGenerateKey = this.senderKem.generateKey(this.hkdfHmacAlgo, this.hkdfSalt, bArr2, this.dem.getSymmetricKeySizeInBytes(), this.ecPointFormat);
        return this.dem.encrypt(kemKeyGenerateKey.getSymmetricKey(), this.outputPrefix, kemKeyGenerateKey.getKemBytes(), bArr);
    }
}
