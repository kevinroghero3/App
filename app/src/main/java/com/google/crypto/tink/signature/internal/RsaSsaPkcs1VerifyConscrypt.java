package com.google.crypto.tink.signature.internal;

import com.facebook.internal.security.OidcSecurityUtil;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.ConscryptUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.RsaSsaPkcs1Parameters;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.subtle.Validators;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class RsaSsaPkcs1VerifyConscrypt implements PublicKeyVerify {
    private final Provider conscrypt;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final RSAPublicKey publicKey;
    private final String signatureAlgorithm;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final byte[] EMPTY = new byte[0];
    private static final byte[] legacyMessageSuffix = {0};

    @Nullable
    static Provider conscryptProviderOrNull() {
        if (!Util.isAndroid() || Util.getAndroidApiLevel().intValue() > 21) {
            return ConscryptUtil.providerOrNull();
        }
        return null;
    }

    public static String toRsaSsaPkcs1Algo(RsaSsaPkcs1Parameters.HashType hashType) throws GeneralSecurityException {
        if (hashType == RsaSsaPkcs1Parameters.HashType.SHA256) {
            return OidcSecurityUtil.SIGNATURE_ALGORITHM_SHA256;
        }
        if (hashType == RsaSsaPkcs1Parameters.HashType.SHA384) {
            return "SHA384withRSA";
        }
        if (hashType == RsaSsaPkcs1Parameters.HashType.SHA512) {
            return "SHA512withRSA";
        }
        throw new GeneralSecurityException("unknown hash type");
    }

    public static PublicKeyVerify create(RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) throws GeneralSecurityException {
        Provider providerConscryptProviderOrNull = conscryptProviderOrNull();
        if (providerConscryptProviderOrNull == null) {
            throw new NoSuchProviderException("RSA-PKCS1.5 using Conscrypt is not supported.");
        }
        return createWithProvider(rsaSsaPkcs1PublicKey, providerConscryptProviderOrNull);
    }

    public static PublicKeyVerify createWithProvider(RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey, Provider provider) throws GeneralSecurityException {
        byte[] bArr;
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA", provider).generatePublic(new RSAPublicKeySpec(rsaSsaPkcs1PublicKey.getModulus(), rsaSsaPkcs1PublicKey.getParameters().getPublicExponent()));
        RsaSsaPkcs1Parameters.HashType hashType = rsaSsaPkcs1PublicKey.getParameters().getHashType();
        byte[] byteArray = rsaSsaPkcs1PublicKey.getOutputPrefix().toByteArray();
        if (rsaSsaPkcs1PublicKey.getParameters().getVariant().equals(RsaSsaPkcs1Parameters.Variant.LEGACY)) {
            bArr = legacyMessageSuffix;
        } else {
            bArr = EMPTY;
        }
        return new RsaSsaPkcs1VerifyConscrypt(rSAPublicKey, hashType, byteArray, bArr, provider);
    }

    private RsaSsaPkcs1VerifyConscrypt(RSAPublicKey rSAPublicKey, RsaSsaPkcs1Parameters.HashType hashType, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use RSA-PKCS1.5 in FIPS-mode, as BoringCrypto module is not available.");
        }
        Validators.validateRsaModulusSize(rSAPublicKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(rSAPublicKey.getPublicExponent());
        this.publicKey = rSAPublicKey;
        this.signatureAlgorithm = toRsaSsaPkcs1Algo(hashType);
        this.outputPrefix = bArr;
        this.messageSuffix = bArr2;
        this.conscrypt = provider;
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!Util.isPrefix(this.outputPrefix, bArr)) {
            throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
        }
        Signature signature = Signature.getInstance(this.signatureAlgorithm, this.conscrypt);
        signature.initVerify(this.publicKey);
        signature.update(bArr2);
        byte[] bArr3 = this.messageSuffix;
        if (bArr3.length > 0) {
            signature.update(bArr3);
        }
        try {
            if (signature.verify(Arrays.copyOfRange(bArr, this.outputPrefix.length, bArr.length))) {
                return;
            }
        } catch (RuntimeException unused) {
        }
        throw new GeneralSecurityException("Invalid signature");
    }
}
