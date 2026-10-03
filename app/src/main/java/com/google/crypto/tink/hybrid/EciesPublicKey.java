package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class EciesPublicKey extends HybridPublicKey {

    @Nullable
    private final Integer idRequirement;

    @Nullable
    private final ECPoint nistPublicPoint;
    private final Bytes outputPrefix;
    private final EciesParameters parameters;

    @Nullable
    private final Bytes x25519PublicPointBytes;

    private EciesPublicKey(EciesParameters eciesParameters, @Nullable ECPoint eCPoint, @Nullable Bytes bytes, Bytes bytes2, @Nullable Integer num) {
        this.parameters = eciesParameters;
        this.nistPublicPoint = eCPoint;
        this.x25519PublicPointBytes = bytes;
        this.outputPrefix = bytes2;
        this.idRequirement = num;
    }

    private static void validateIdRequirement(EciesParameters.Variant variant, @Nullable Integer num) throws GeneralSecurityException {
        EciesParameters.Variant variant2 = EciesParameters.Variant.NO_PREFIX;
        if (!variant.equals(variant2) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + variant + " variant.");
        }
        if (variant.equals(variant2) && num != null) {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
    }

    private static EllipticCurve getParameterSpecNistCurve(EciesParameters.CurveType curveType) {
        if (curveType == EciesParameters.CurveType.NIST_P256) {
            return EllipticCurves.getNistP256Params().getCurve();
        }
        if (curveType == EciesParameters.CurveType.NIST_P384) {
            return EllipticCurves.getNistP384Params().getCurve();
        }
        if (curveType == EciesParameters.CurveType.NIST_P521) {
            return EllipticCurves.getNistP521Params().getCurve();
        }
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + curveType);
    }

    private static Bytes createOutputPrefix(EciesParameters.Variant variant, @Nullable Integer num) {
        if (variant == EciesParameters.Variant.NO_PREFIX) {
            return OutputPrefixUtil.EMPTY_PREFIX;
        }
        if (num == null) {
            throw new IllegalStateException("idRequirement must be non-null for EciesParameters.Variant: " + variant);
        }
        if (variant == EciesParameters.Variant.CRUNCHY) {
            return OutputPrefixUtil.getLegacyOutputPrefix(num.intValue());
        }
        if (variant == EciesParameters.Variant.TINK) {
            return OutputPrefixUtil.getTinkOutputPrefix(num.intValue());
        }
        throw new IllegalStateException("Unknown EciesParameters.Variant: " + variant);
    }

    public static EciesPublicKey createForCurveX25519(EciesParameters eciesParameters, Bytes bytes, @Nullable Integer num) throws GeneralSecurityException {
        if (!eciesParameters.getCurveType().equals(EciesParameters.CurveType.X25519)) {
            throw new GeneralSecurityException("createForCurveX25519 may only be called with parameters for curve X25519");
        }
        validateIdRequirement(eciesParameters.getVariant(), num);
        if (bytes.size() != 32) {
            throw new GeneralSecurityException("Encoded public point byte length for X25519 curve must be 32");
        }
        return new EciesPublicKey(eciesParameters, null, bytes, createOutputPrefix(eciesParameters.getVariant(), num), num);
    }

    public static EciesPublicKey createForNistCurve(EciesParameters eciesParameters, ECPoint eCPoint, @Nullable Integer num) throws GeneralSecurityException {
        if (eciesParameters.getCurveType().equals(EciesParameters.CurveType.X25519)) {
            throw new GeneralSecurityException("createForNistCurve may only be called with parameters for NIST curve");
        }
        validateIdRequirement(eciesParameters.getVariant(), num);
        EllipticCurvesUtil.checkPointOnCurve(eCPoint, getParameterSpecNistCurve(eciesParameters.getCurveType()));
        return new EciesPublicKey(eciesParameters, eCPoint, null, createOutputPrefix(eciesParameters.getVariant(), num), num);
    }

    @Nullable
    public ECPoint getNistCurvePoint() {
        return this.nistPublicPoint;
    }

    @Nullable
    public Bytes getX25519CurvePointBytes() {
        return this.x25519PublicPointBytes;
    }

    @Override // com.google.crypto.tink.hybrid.HybridPublicKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.hybrid.HybridPublicKey, com.google.crypto.tink.Key
    public EciesParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof EciesPublicKey)) {
            return false;
        }
        EciesPublicKey eciesPublicKey = (EciesPublicKey) key;
        return this.parameters.equals(eciesPublicKey.parameters) && Objects.equals(this.x25519PublicPointBytes, eciesPublicKey.x25519PublicPointBytes) && Objects.equals(this.nistPublicPoint, eciesPublicKey.nistPublicPoint) && Objects.equals(this.idRequirement, eciesPublicKey.idRequirement);
    }
}
