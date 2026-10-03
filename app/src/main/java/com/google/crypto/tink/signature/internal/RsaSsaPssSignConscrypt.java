package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.signature.RsaSsaPssParameters;
import com.google.crypto.tink.signature.RsaSsaPssPrivateKey;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.Validators;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.PSSParameterSpec;
import java.security.spec.RSAPrivateCrtKeySpec;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class RsaSsaPssSignConscrypt implements PublicKeySign {
    private final Provider conscrypt;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final PSSParameterSpec parameterSpec;
    private final RSAPrivateCrtKey privateKey;
    private final String signatureAlgorithm;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final byte[] EMPTY = new byte[0];
    private static final byte[] legacyMessageSuffix = {0};

    public static PublicKeySign create(RsaSsaPssPrivateKey rsaSsaPssPrivateKey) throws GeneralSecurityException {
        return createWithProvider(rsaSsaPssPrivateKey, RsaSsaPssVerifyConscrypt.conscryptProviderOrNull());
    }

    public static PublicKeySign createWithProvider(RsaSsaPssPrivateKey rsaSsaPssPrivateKey, Provider provider) throws GeneralSecurityException {
        byte[] bArr;
        if (provider == null) {
            throw new NoSuchProviderException("RSA SSA PSS using Conscrypt is not supported.");
        }
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", provider);
        RsaSsaPssParameters parameters = rsaSsaPssPrivateKey.getParameters();
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) keyFactory.generatePrivate(new RSAPrivateCrtKeySpec(rsaSsaPssPrivateKey.getPublicKey().getModulus(), parameters.getPublicExponent(), rsaSsaPssPrivateKey.getPrivateExponent().getBigInteger(InsecureSecretKeyAccess.get()), rsaSsaPssPrivateKey.getPrimeP().getBigInteger(InsecureSecretKeyAccess.get()), rsaSsaPssPrivateKey.getPrimeQ().getBigInteger(InsecureSecretKeyAccess.get()), rsaSsaPssPrivateKey.getPrimeExponentP().getBigInteger(InsecureSecretKeyAccess.get()), rsaSsaPssPrivateKey.getPrimeExponentQ().getBigInteger(InsecureSecretKeyAccess.get()), rsaSsaPssPrivateKey.getCrtCoefficient().getBigInteger(InsecureSecretKeyAccess.get())));
        RsaSsaPssParameters.HashType sigHashType = parameters.getSigHashType();
        RsaSsaPssParameters.HashType mgf1HashType = parameters.getMgf1HashType();
        int saltLengthBytes = parameters.getSaltLengthBytes();
        byte[] byteArray = rsaSsaPssPrivateKey.getOutputPrefix().toByteArray();
        if (parameters.getVariant().equals(RsaSsaPssParameters.Variant.LEGACY)) {
            bArr = legacyMessageSuffix;
        } else {
            bArr = EMPTY;
        }
        return new RsaSsaPssSignConscrypt(rSAPrivateCrtKey, sigHashType, mgf1HashType, saltLengthBytes, byteArray, bArr, provider);
    }

    private RsaSsaPssSignConscrypt(RSAPrivateCrtKey rSAPrivateCrtKey, RsaSsaPssParameters.HashType hashType, RsaSsaPssParameters.HashType hashType2, int i, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Cannot use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        Validators.validateRsaModulusSize(rSAPrivateCrtKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(rSAPrivateCrtKey.getPublicExponent());
        this.privateKey = rSAPrivateCrtKey;
        this.signatureAlgorithm = RsaSsaPssVerifyConscrypt.getConscryptRsaSsaPssAlgo(hashType);
        this.parameterSpec = RsaSsaPssVerifyConscrypt.getPssParameterSpec(hashType, hashType2, i);
        this.outputPrefix = bArr;
        this.messageSuffix = bArr2;
        this.conscrypt = provider;
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(byte[] bArr) throws GeneralSecurityException {
        Signature signature = Signature.getInstance(this.signatureAlgorithm, this.conscrypt);
        signature.initSign(this.privateKey);
        signature.setParameter(this.parameterSpec);
        signature.update(bArr);
        byte[] bArr2 = this.messageSuffix;
        if (bArr2.length > 0) {
            signature.update(bArr2);
        }
        byte[] bArrSign = signature.sign();
        byte[] bArr3 = this.outputPrefix;
        return bArr3.length == 0 ? bArrSign : Bytes.concat(bArr3, bArrSign);
    }
}
