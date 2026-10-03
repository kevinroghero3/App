package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.signature.RsaSsaPkcs1Parameters;
import com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.util.SecretBigInteger;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPrivateCrtKey;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class RsaSsaPkcs1SignJce implements PublicKeySign {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final PublicKeySign signer;

    public static PublicKeySign create(RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey) throws GeneralSecurityException {
        return com.google.crypto.tink.signature.internal.RsaSsaPkcs1SignJce.create(rsaSsaPkcs1PrivateKey);
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.RsaSsaPkcs1SignJce$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        static {
            int[] iArr = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = iArr;
            try {
                iArr[Enums.HashType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static RsaSsaPkcs1Parameters.HashType convertHashType(Enums.HashType hashType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
        if (i == 1) {
            return RsaSsaPkcs1Parameters.HashType.SHA256;
        }
        if (i == 2) {
            return RsaSsaPkcs1Parameters.HashType.SHA384;
        }
        if (i == 3) {
            return RsaSsaPkcs1Parameters.HashType.SHA512;
        }
        throw new GeneralSecurityException("Unsupported hash: " + hashType.name());
    }

    private static PublicKeySign getSigner(RSAPrivateCrtKey rSAPrivateCrtKey, Enums.HashType hashType) throws GeneralSecurityException {
        return com.google.crypto.tink.signature.internal.RsaSsaPkcs1SignJce.create(RsaSsaPkcs1PrivateKey.builder().setPublicKey(RsaSsaPkcs1PublicKey.builder().setParameters(RsaSsaPkcs1Parameters.builder().setModulusSizeBits(rSAPrivateCrtKey.getModulus().bitLength()).setPublicExponent(rSAPrivateCrtKey.getPublicExponent()).setHashType(convertHashType(hashType)).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build()).setModulus(rSAPrivateCrtKey.getModulus()).build()).setPrimes(SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrimeP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrimeQ(), InsecureSecretKeyAccess.get())).setPrivateExponent(SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrivateExponent(), InsecureSecretKeyAccess.get())).setPrimeExponents(SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrimeExponentP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrimeExponentQ(), InsecureSecretKeyAccess.get())).setCrtCoefficient(SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getCrtCoefficient(), InsecureSecretKeyAccess.get())).build());
    }

    public RsaSsaPkcs1SignJce(RSAPrivateCrtKey rSAPrivateCrtKey, Enums.HashType hashType) throws GeneralSecurityException {
        this.signer = getSigner(rSAPrivateCrtKey, hashType);
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(byte[] bArr) throws GeneralSecurityException {
        return this.signer.sign(bArr);
    }
}
