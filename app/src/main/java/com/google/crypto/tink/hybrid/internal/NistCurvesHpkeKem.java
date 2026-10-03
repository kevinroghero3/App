package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
final class NistCurvesHpkeKem implements HpkeKem {
    private final EllipticCurves.CurveType curve;
    private final HkdfHpkeKdf hkdf;

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.internal.NistCurvesHpkeKem$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType;

        static {
            int[] iArr = new int[EllipticCurves.CurveType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType = iArr;
            try {
                iArr[EllipticCurves.CurveType.NIST_P256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[EllipticCurves.CurveType.NIST_P384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[EllipticCurves.CurveType.NIST_P521.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static NistCurvesHpkeKem fromCurve(EllipticCurves.CurveType curveType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[curveType.ordinal()];
        if (i == 1) {
            return new NistCurvesHpkeKem(new HkdfHpkeKdf("HmacSha256"), EllipticCurves.CurveType.NIST_P256);
        }
        if (i == 2) {
            return new NistCurvesHpkeKem(new HkdfHpkeKdf("HmacSha384"), EllipticCurves.CurveType.NIST_P384);
        }
        if (i == 3) {
            return new NistCurvesHpkeKem(new HkdfHpkeKdf("HmacSha512"), EllipticCurves.CurveType.NIST_P521);
        }
        throw new GeneralSecurityException("invalid curve type: " + curveType);
    }

    private NistCurvesHpkeKem(HkdfHpkeKdf hkdfHpkeKdf, EllipticCurves.CurveType curveType) {
        this.hkdf = hkdfHpkeKdf;
        this.curve = curveType;
    }

    byte[] deriveKemSharedSecret(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return extractAndExpand(bArr, Bytes.concat(bArr2, bArr3));
    }

    byte[] deriveKemSharedSecret(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        return extractAndExpand(bArr, Bytes.concat(bArr2, bArr3, bArr4));
    }

    private byte[] extractAndExpand(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrKemSuiteId = HpkeUtil.kemSuiteId(getKemId());
        HkdfHpkeKdf hkdfHpkeKdf = this.hkdf;
        return hkdfHpkeKdf.extractAndExpand(null, bArr, "eae_prk", bArr2, "shared_secret", bArrKemSuiteId, hkdfHpkeKdf.getMacLength());
    }

    HpkeKemEncapOutput encapsulate(byte[] bArr, KeyPair keyPair) throws GeneralSecurityException {
        EllipticCurves.CurveType curveType = this.curve;
        EllipticCurves.PointFormatType pointFormatType = EllipticCurves.PointFormatType.UNCOMPRESSED;
        byte[] bArrComputeSharedSecret = EllipticCurves.computeSharedSecret((ECPrivateKey) keyPair.getPrivate(), EllipticCurves.getEcPublicKey(curveType, pointFormatType, bArr));
        byte[] bArrPointEncode = EllipticCurves.pointEncode(this.curve, pointFormatType, ((ECPublicKey) keyPair.getPublic()).getW());
        return new HpkeKemEncapOutput(deriveKemSharedSecret(bArrComputeSharedSecret, bArrPointEncode, bArr), bArrPointEncode);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public HpkeKemEncapOutput encapsulate(byte[] bArr) throws GeneralSecurityException {
        return encapsulate(bArr, EllipticCurves.generateKeyPair(this.curve));
    }

    HpkeKemEncapOutput authEncapsulate(byte[] bArr, KeyPair keyPair, HpkeKemPrivateKey hpkeKemPrivateKey) throws GeneralSecurityException {
        EllipticCurves.CurveType curveType = this.curve;
        EllipticCurves.PointFormatType pointFormatType = EllipticCurves.PointFormatType.UNCOMPRESSED;
        ECPublicKey ecPublicKey = EllipticCurves.getEcPublicKey(curveType, pointFormatType, bArr);
        byte[] bArrConcat = Bytes.concat(EllipticCurves.computeSharedSecret((ECPrivateKey) keyPair.getPrivate(), ecPublicKey), EllipticCurves.computeSharedSecret(EllipticCurves.getEcPrivateKey(this.curve, hpkeKemPrivateKey.getSerializedPrivate().toByteArray()), ecPublicKey));
        byte[] bArrPointEncode = EllipticCurves.pointEncode(this.curve, pointFormatType, ((ECPublicKey) keyPair.getPublic()).getW());
        return new HpkeKemEncapOutput(deriveKemSharedSecret(bArrConcat, bArrPointEncode, bArr, hpkeKemPrivateKey.getSerializedPublic().toByteArray()), bArrPointEncode);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public HpkeKemEncapOutput authEncapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey) throws GeneralSecurityException {
        return authEncapsulate(bArr, EllipticCurves.generateKeyPair(this.curve), hpkeKemPrivateKey);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] decapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey) throws GeneralSecurityException {
        return deriveKemSharedSecret(EllipticCurves.computeSharedSecret(EllipticCurves.getEcPrivateKey(this.curve, hpkeKemPrivateKey.getSerializedPrivate().toByteArray()), EllipticCurves.getEcPublicKey(this.curve, EllipticCurves.PointFormatType.UNCOMPRESSED, bArr)), bArr, hpkeKemPrivateKey.getSerializedPublic().toByteArray());
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] authDecapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey, byte[] bArr2) throws GeneralSecurityException {
        ECPrivateKey ecPrivateKey = EllipticCurves.getEcPrivateKey(this.curve, hpkeKemPrivateKey.getSerializedPrivate().toByteArray());
        EllipticCurves.CurveType curveType = this.curve;
        EllipticCurves.PointFormatType pointFormatType = EllipticCurves.PointFormatType.UNCOMPRESSED;
        return deriveKemSharedSecret(Bytes.concat(EllipticCurves.computeSharedSecret(ecPrivateKey, EllipticCurves.getEcPublicKey(curveType, pointFormatType, bArr)), EllipticCurves.computeSharedSecret(ecPrivateKey, EllipticCurves.getEcPublicKey(this.curve, pointFormatType, bArr2))), bArr, hpkeKemPrivateKey.getSerializedPublic().toByteArray(), bArr2);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] getKemId() throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[this.curve.ordinal()];
        if (i == 1) {
            return HpkeUtil.P256_HKDF_SHA256_KEM_ID;
        }
        if (i == 2) {
            return HpkeUtil.P384_HKDF_SHA384_KEM_ID;
        }
        if (i == 3) {
            return HpkeUtil.P521_HKDF_SHA512_KEM_ID;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
