package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.ConscryptUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.SlhDsaParameters;
import com.google.crypto.tink.signature.SlhDsaPublicKey;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.EncodedKeySpec;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public class SlhDsaVerifyConscrypt implements PublicKeyVerify {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    static final String SLH_DSA_SHA2_128S_ALGORITHM = "SLH-DSA-SHA2-128S";
    static final int SLH_DSA_SHA2_128S_SIG_LENGTH = 7856;
    private final String algorithm;
    private final byte[] outputPrefix;
    private final Provider provider;
    private final PublicKey publicKey;
    private final int signatureLength;

    public SlhDsaVerifyConscrypt(byte[] bArr, PublicKey publicKey, String str, int i, Provider provider) {
        this.outputPrefix = bArr;
        this.publicKey = publicKey;
        this.algorithm = str;
        this.signatureLength = i;
        this.provider = provider;
    }

    public static PublicKeyVerify createWithProvider(SlhDsaPublicKey slhDsaPublicKey, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            throw new NullPointerException("provider must not be null");
        }
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use SLH-DSA in FIPS-mode, as it is not yet certified in Conscrypt.");
        }
        SlhDsaParameters parameters = slhDsaPublicKey.getParameters();
        if (parameters.getPrivateKeySize() != 64 || parameters.getHashType() != SlhDsaParameters.HashType.SHA2 || parameters.getSignatureType() != SlhDsaParameters.SignatureType.SMALL_SIGNATURE) {
            throw new GeneralSecurityException("Unsupported SLH-DSA parameters");
        }
        return new SlhDsaVerifyConscrypt(slhDsaPublicKey.getOutputPrefix().toByteArray(), KeyFactory.getInstance(SLH_DSA_SHA2_128S_ALGORITHM, provider).generatePublic(new RawKeySpec(slhDsaPublicKey.getSerializedPublicKey().toByteArray())), SLH_DSA_SHA2_128S_ALGORITHM, SLH_DSA_SHA2_128S_SIG_LENGTH, provider);
    }

    public static PublicKeyVerify create(SlhDsaPublicKey slhDsaPublicKey) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use SLH-DSA in FIPS-mode, as it is not yet certified in Conscrypt.");
        }
        Provider providerProviderOrNull = ConscryptUtil.providerOrNull();
        if (providerProviderOrNull == null) {
            throw new GeneralSecurityException("Obtaining Conscrypt provider failed");
        }
        return createWithProvider(slhDsaPublicKey, providerProviderOrNull);
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!Util.isPrefix(this.outputPrefix, bArr)) {
            throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
        }
        if (bArr.length != this.outputPrefix.length + this.signatureLength) {
            throw new GeneralSecurityException("Invalid signature length");
        }
        Signature signature = Signature.getInstance(this.algorithm, this.provider);
        signature.initVerify(this.publicKey);
        signature.update(bArr2);
        if (!signature.verify(bArr, this.outputPrefix.length, this.signatureLength)) {
            throw new GeneralSecurityException("Invalid signature");
        }
    }

    public static boolean isSupported() {
        Provider providerProviderOrNull;
        if (!FIPS.isCompatible() || (providerProviderOrNull = ConscryptUtil.providerOrNull()) == null) {
            return false;
        }
        try {
            KeyFactory.getInstance(SLH_DSA_SHA2_128S_ALGORITHM, providerProviderOrNull);
            Signature.getInstance(SLH_DSA_SHA2_128S_ALGORITHM, providerProviderOrNull);
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public static final class RawKeySpec extends EncodedKeySpec {
        public RawKeySpec(byte[] bArr) {
            super(bArr);
        }

        @Override // java.security.spec.EncodedKeySpec
        public String getFormat() {
            return "raw";
        }
    }
}
