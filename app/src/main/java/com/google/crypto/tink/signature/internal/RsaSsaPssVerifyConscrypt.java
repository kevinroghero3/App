package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.ConscryptUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.RsaSsaPssParameters;
import com.google.crypto.tink.signature.RsaSsaPssPublicKey;
import com.google.crypto.tink.subtle.Validators;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.RSAPublicKeySpec;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class RsaSsaPssVerifyConscrypt implements PublicKeyVerify {
    private static final String MGF_1 = "MGF1";
    private static final int TRAILER_FIELD_BC = 1;
    private final Provider conscrypt;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final PSSParameterSpec parameterSpec;
    private final RSAPublicKey publicKey;
    private final String signatureAlgorithm;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final byte[] EMPTY = new byte[0];
    private static final byte[] legacyMessageSuffix = {0};

    @Nullable
    static Provider conscryptProviderOrNull() {
        if (!Util.isAndroid() || Util.getAndroidApiLevel().intValue() > 23) {
            return ConscryptUtil.providerOrNull();
        }
        return null;
    }

    static String getConscryptRsaSsaPssAlgo(RsaSsaPssParameters.HashType hashType) {
        if (hashType == RsaSsaPssParameters.HashType.SHA256) {
            return "SHA256withRSA/PSS";
        }
        if (hashType == RsaSsaPssParameters.HashType.SHA384) {
            return "SHA384withRSA/PSS";
        }
        if (hashType == RsaSsaPssParameters.HashType.SHA512) {
            return "SHA512withRSA/PSS";
        }
        throw new IllegalArgumentException("Unsupported hash: " + hashType);
    }

    private static String getMdName(RsaSsaPssParameters.HashType hashType) {
        if (hashType == RsaSsaPssParameters.HashType.SHA256) {
            return "SHA-256";
        }
        if (hashType == RsaSsaPssParameters.HashType.SHA384) {
            return "SHA-384";
        }
        if (hashType == RsaSsaPssParameters.HashType.SHA512) {
            return "SHA-512";
        }
        throw new IllegalArgumentException("Unsupported MD hash: " + hashType);
    }

    private static MGF1ParameterSpec getMgf1Hash(RsaSsaPssParameters.HashType hashType) {
        if (hashType == RsaSsaPssParameters.HashType.SHA256) {
            return MGF1ParameterSpec.SHA256;
        }
        if (hashType == RsaSsaPssParameters.HashType.SHA384) {
            return MGF1ParameterSpec.SHA384;
        }
        if (hashType == RsaSsaPssParameters.HashType.SHA512) {
            return MGF1ParameterSpec.SHA512;
        }
        throw new IllegalArgumentException("Unsupported MGF1 hash: " + hashType);
    }

    static PSSParameterSpec getPssParameterSpec(RsaSsaPssParameters.HashType hashType, RsaSsaPssParameters.HashType hashType2, int i) {
        return new PSSParameterSpec(getMdName(hashType), MGF_1, getMgf1Hash(hashType2), i, 1);
    }

    private RsaSsaPssVerifyConscrypt(RSAPublicKey rSAPublicKey, RsaSsaPssParameters.HashType hashType, RsaSsaPssParameters.HashType hashType2, int i, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Cannot use RSA SSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        if (!hashType.equals(hashType2)) {
            throw new GeneralSecurityException("sigHash and mgf1Hash must be the same");
        }
        Validators.validateRsaModulusSize(rSAPublicKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(rSAPublicKey.getPublicExponent());
        this.publicKey = rSAPublicKey;
        this.signatureAlgorithm = getConscryptRsaSsaPssAlgo(hashType);
        this.parameterSpec = getPssParameterSpec(hashType, hashType2, i);
        this.outputPrefix = bArr;
        this.messageSuffix = bArr2;
        this.conscrypt = provider;
    }

    public static PublicKeyVerify create(RsaSsaPssPublicKey rsaSsaPssPublicKey) throws GeneralSecurityException {
        return createWithProvider(rsaSsaPssPublicKey, conscryptProviderOrNull());
    }

    public static PublicKeyVerify createWithProvider(RsaSsaPssPublicKey rsaSsaPssPublicKey, Provider provider) throws GeneralSecurityException {
        byte[] bArr;
        if (provider == null) {
            throw new NoSuchProviderException("RSA SSA PSS using Conscrypt is not supported.");
        }
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA", provider).generatePublic(new RSAPublicKeySpec(rsaSsaPssPublicKey.getModulus(), rsaSsaPssPublicKey.getParameters().getPublicExponent()));
        RsaSsaPssParameters parameters = rsaSsaPssPublicKey.getParameters();
        RsaSsaPssParameters.HashType sigHashType = parameters.getSigHashType();
        RsaSsaPssParameters.HashType mgf1HashType = parameters.getMgf1HashType();
        int saltLengthBytes = parameters.getSaltLengthBytes();
        byte[] byteArray = rsaSsaPssPublicKey.getOutputPrefix().toByteArray();
        if (rsaSsaPssPublicKey.getParameters().getVariant().equals(RsaSsaPssParameters.Variant.LEGACY)) {
            bArr = legacyMessageSuffix;
        } else {
            bArr = EMPTY;
        }
        return new RsaSsaPssVerifyConscrypt(rSAPublicKey, sigHashType, mgf1HashType, saltLengthBytes, byteArray, bArr, provider);
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!Util.isPrefix(this.outputPrefix, bArr)) {
            throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
        }
        Signature signature = Signature.getInstance(this.signatureAlgorithm, this.conscrypt);
        signature.initVerify(this.publicKey);
        signature.setParameter(this.parameterSpec);
        signature.update(bArr2);
        byte[] bArr3 = this.messageSuffix;
        if (bArr3.length > 0) {
            signature.update(bArr3);
        }
        byte[] bArr4 = this.outputPrefix;
        if (!signature.verify(bArr, bArr4.length, bArr.length - bArr4.length)) {
            throw new GeneralSecurityException("signature verification failed");
        }
    }
}
