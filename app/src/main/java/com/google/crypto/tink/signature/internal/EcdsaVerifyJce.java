package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.ConscryptUtil;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.EcdsaParameters;
import com.google.crypto.tink.signature.EcdsaPublicKey;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Enums;
import com.google.crypto.tink.subtle.SubtleUtil;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPublicKeySpec;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class EcdsaVerifyJce implements PublicKeyVerify {
    private final EllipticCurves.EcdsaEncoding encoding;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;

    @Nullable
    private final Provider provider;
    private final ECPublicKey publicKey;
    private final String signatureAlgorithm;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final byte[] EMPTY = new byte[0];
    private static final byte[] legacyMessageSuffix = {0};
    static final EnumTypeProtoConverter<Enums.HashType, EcdsaParameters.HashType> HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(Enums.HashType.SHA256, EcdsaParameters.HashType.SHA256).add(Enums.HashType.SHA384, EcdsaParameters.HashType.SHA384).add(Enums.HashType.SHA512, EcdsaParameters.HashType.SHA512).build();
    static final EnumTypeProtoConverter<EllipticCurves.EcdsaEncoding, EcdsaParameters.SignatureEncoding> ENCODING_CONVERTER = EnumTypeProtoConverter.builder().add(EllipticCurves.EcdsaEncoding.IEEE_P1363, EcdsaParameters.SignatureEncoding.IEEE_P1363).add(EllipticCurves.EcdsaEncoding.DER, EcdsaParameters.SignatureEncoding.DER).build();
    static final EnumTypeProtoConverter<EllipticCurves.CurveType, EcdsaParameters.CurveType> CURVE_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(EllipticCurves.CurveType.NIST_P256, EcdsaParameters.CurveType.NIST_P256).add(EllipticCurves.CurveType.NIST_P384, EcdsaParameters.CurveType.NIST_P384).add(EllipticCurves.CurveType.NIST_P521, EcdsaParameters.CurveType.NIST_P521).build();

    public static PublicKeyVerify create(EcdsaPublicKey ecdsaPublicKey) throws GeneralSecurityException {
        return createWithProviderOrNull(ecdsaPublicKey, ConscryptUtil.providerOrNull());
    }

    public static PublicKeyVerify createWithProvider(EcdsaPublicKey ecdsaPublicKey, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            throw new NullPointerException("provider must not be null");
        }
        return createWithProviderOrNull(ecdsaPublicKey, provider);
    }

    public static PublicKeyVerify createWithProviderOrNull(EcdsaPublicKey ecdsaPublicKey, @Nullable Provider provider) throws GeneralSecurityException {
        KeyFactory engineFactory;
        byte[] bArr;
        ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(ecdsaPublicKey.getPublicPoint(), EllipticCurves.getCurveSpec((EllipticCurves.CurveType) CURVE_TYPE_CONVERTER.toProtoEnum(ecdsaPublicKey.getParameters().getCurveType())));
        if (provider == null) {
            engineFactory = EngineFactory.KEY_FACTORY.getInstance("EC");
        } else {
            engineFactory = KeyFactory.getInstance("EC", provider);
        }
        ECPublicKey eCPublicKey = (ECPublicKey) engineFactory.generatePublic(eCPublicKeySpec);
        Enums.HashType hashType = (Enums.HashType) HASH_TYPE_CONVERTER.toProtoEnum(ecdsaPublicKey.getParameters().getHashType());
        EllipticCurves.EcdsaEncoding ecdsaEncoding = (EllipticCurves.EcdsaEncoding) ENCODING_CONVERTER.toProtoEnum(ecdsaPublicKey.getParameters().getSignatureEncoding());
        byte[] byteArray = ecdsaPublicKey.getOutputPrefix().toByteArray();
        if (ecdsaPublicKey.getParameters().getVariant().equals(EcdsaParameters.Variant.LEGACY)) {
            bArr = legacyMessageSuffix;
        } else {
            bArr = EMPTY;
        }
        return new EcdsaVerifyJce(eCPublicKey, hashType, ecdsaEncoding, byteArray, bArr, provider);
    }

    private EcdsaVerifyJce(ECPublicKey eCPublicKey, Enums.HashType hashType, EllipticCurves.EcdsaEncoding ecdsaEncoding, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto is not available.");
        }
        this.signatureAlgorithm = SubtleUtil.toEcdsaAlgo(hashType);
        this.publicKey = eCPublicKey;
        this.encoding = ecdsaEncoding;
        this.outputPrefix = bArr;
        this.messageSuffix = bArr2;
        this.provider = provider;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public EcdsaVerifyJce(ECPublicKey eCPublicKey, Enums.HashType hashType, EllipticCurves.EcdsaEncoding ecdsaEncoding) throws GeneralSecurityException {
        byte[] bArr = EMPTY;
        this(eCPublicKey, hashType, ecdsaEncoding, bArr, bArr, ConscryptUtil.providerOrNull());
        EllipticCurvesUtil.checkPointOnCurve(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
    }

    private Signature getInstance(String str) throws GeneralSecurityException {
        Provider provider = this.provider;
        if (provider != null) {
            return Signature.getInstance(str, provider);
        }
        return EngineFactory.SIGNATURE.getInstance(str);
    }

    private void noPrefixVerify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (this.encoding == EllipticCurves.EcdsaEncoding.IEEE_P1363) {
            if (bArr.length != EllipticCurves.fieldSizeInBytes(this.publicKey.getParams().getCurve()) * 2) {
                throw new GeneralSecurityException("Invalid signature");
            }
            bArr = EllipticCurves.ecdsaIeee2Der(bArr);
        }
        if (!EllipticCurves.isValidDerEncoding(bArr)) {
            throw new GeneralSecurityException("Invalid signature");
        }
        Signature ecdsaVerifyJce = getInstance(this.signatureAlgorithm);
        ecdsaVerifyJce.initVerify(this.publicKey);
        ecdsaVerifyJce.update(bArr2);
        byte[] bArr3 = this.messageSuffix;
        if (bArr3.length > 0) {
            ecdsaVerifyJce.update(bArr3);
        }
        try {
            if (ecdsaVerifyJce.verify(bArr)) {
                return;
            }
        } catch (RuntimeException unused) {
        }
        throw new GeneralSecurityException("Invalid signature");
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.outputPrefix;
        if (bArr3.length == 0) {
            noPrefixVerify(bArr, bArr2);
        } else {
            if (!Util.isPrefix(bArr3, bArr)) {
                throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
            }
            noPrefixVerify(Arrays.copyOfRange(bArr, this.outputPrefix.length, bArr.length), bArr2);
        }
    }
}
