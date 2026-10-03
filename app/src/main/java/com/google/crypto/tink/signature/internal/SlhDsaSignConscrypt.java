package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.ConscryptUtil;
import com.google.crypto.tink.signature.SlhDsaParameters;
import com.google.crypto.tink.signature.SlhDsaPrivateKey;
import com.google.errorprone.annotations.Immutable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public class SlhDsaSignConscrypt implements PublicKeySign {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final String TEST_WORKLOAD = "test workload";
    private final String algorithm;
    private final byte[] outputPrefix;
    private final PrivateKey privateKey;
    private final Provider provider;
    private final int signatureLength;

    public SlhDsaSignConscrypt(byte[] bArr, PrivateKey privateKey, String str, int i, Provider provider) {
        this.outputPrefix = bArr;
        this.privateKey = privateKey;
        this.algorithm = str;
        this.signatureLength = i;
        this.provider = provider;
    }

    public static PublicKeySign createWithProvider(SlhDsaPrivateKey slhDsaPrivateKey, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            throw new NullPointerException("provider must not be null");
        }
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use SLH-DSA in FIPS-mode, as it is not yet certified in Conscrypt.");
        }
        SlhDsaParameters parameters = slhDsaPrivateKey.getParameters();
        if (parameters.getPrivateKeySize() != 64 || parameters.getHashType() != SlhDsaParameters.HashType.SHA2 || parameters.getSignatureType() != SlhDsaParameters.SignatureType.SMALL_SIGNATURE) {
            throw new GeneralSecurityException("Unsupported SLH-DSA parameters");
        }
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance("SLH-DSA-SHA2-128S", provider).generatePrivate(new SlhDsaVerifyConscrypt.RawKeySpec(slhDsaPrivateKey.getPrivateKeyBytes().toByteArray(InsecureSecretKeyAccess.get())));
        Charset charset = StandardCharsets.UTF_8;
        ((SlhDsaVerifyConscrypt) SlhDsaVerifyConscrypt.createWithProvider(slhDsaPrivateKey.getPublicKey(), provider)).verify(signInternal(TEST_WORKLOAD.getBytes(charset), slhDsaPrivateKey.getOutputPrefix().toByteArray(), privateKeyGeneratePrivate, "SLH-DSA-SHA2-128S", 7856, provider), TEST_WORKLOAD.getBytes(charset));
        return new SlhDsaSignConscrypt(slhDsaPrivateKey.getOutputPrefix().toByteArray(), privateKeyGeneratePrivate, "SLH-DSA-SHA2-128S", 7856, provider);
    }

    public static PublicKeySign create(SlhDsaPrivateKey slhDsaPrivateKey) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use SLH-DSA in FIPS-mode, as it is not yet certified in Conscrypt.");
        }
        Provider providerProviderOrNull = ConscryptUtil.providerOrNull();
        if (providerProviderOrNull == null) {
            throw new GeneralSecurityException("Obtaining Conscrypt provider failed");
        }
        return createWithProvider(slhDsaPrivateKey, providerProviderOrNull);
    }

    public static boolean isSupported() {
        return SlhDsaVerifyConscrypt.isSupported();
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(byte[] bArr) throws GeneralSecurityException {
        return signInternal(bArr, this.outputPrefix, this.privateKey, this.algorithm, this.signatureLength, this.provider);
    }

    private static byte[] signInternal(byte[] bArr, byte[] bArr2, PrivateKey privateKey, String str, int i, Provider provider) throws GeneralSecurityException {
        Signature signature = Signature.getInstance(str, provider);
        signature.initSign(privateKey);
        signature.update(bArr);
        byte[] bArr3 = new byte[bArr2.length + i];
        if (bArr2.length > 0) {
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        }
        signature.sign(bArr3, bArr2.length, i);
        return bArr3;
    }
}
