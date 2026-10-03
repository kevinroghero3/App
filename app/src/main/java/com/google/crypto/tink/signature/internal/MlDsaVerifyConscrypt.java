package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.ConscryptUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.MlDsaParameters;
import com.google.crypto.tink.signature.MlDsaPublicKey;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.EncodedKeySpec;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class MlDsaVerifyConscrypt implements PublicKeyVerify {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    static final String ML_DSA_65_ALGORITHM = "ML-DSA-65";
    static final int ML_DSA_65_SIG_LENGTH = 3309;
    static final String ML_DSA_87_ALGORITHM = "ML-DSA-87";
    static final int ML_DSA_87_SIG_LENGTH = 4627;
    private final String algorithm;
    private final byte[] outputPrefix;
    private final Provider provider;
    private final PublicKey publicKey;
    private final int signatureLength;

    private MlDsaVerifyConscrypt(byte[] bArr, PublicKey publicKey, String str, int i, Provider provider) {
        this.outputPrefix = bArr;
        this.publicKey = publicKey;
        this.algorithm = str;
        this.signatureLength = i;
        this.provider = provider;
    }

    public static PublicKeyVerify createWithProvider(MlDsaPublicKey mlDsaPublicKey, Provider provider) throws GeneralSecurityException {
        String str;
        PublicKey publicKeyGeneratePublic;
        int i;
        if (provider == null) {
            throw new NullPointerException("provider must not be null");
        }
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use ML-DSA in FIPS-mode, as it is not yet certified in Conscrypt.");
        }
        MlDsaParameters.MlDsaInstance mlDsaInstance = mlDsaPublicKey.getParameters().getMlDsaInstance();
        if (mlDsaInstance == MlDsaParameters.MlDsaInstance.ML_DSA_65) {
            str = ML_DSA_65_ALGORITHM;
            publicKeyGeneratePublic = KeyFactory.getInstance(ML_DSA_65_ALGORITHM, provider).generatePublic(new RawKeySpec(mlDsaPublicKey.getSerializedPublicKey().toByteArray()));
            i = ML_DSA_65_SIG_LENGTH;
        } else if (mlDsaInstance == MlDsaParameters.MlDsaInstance.ML_DSA_87) {
            str = ML_DSA_87_ALGORITHM;
            publicKeyGeneratePublic = KeyFactory.getInstance(ML_DSA_87_ALGORITHM, provider).generatePublic(new RawKeySpec(mlDsaPublicKey.getSerializedPublicKey().toByteArray()));
            i = ML_DSA_87_SIG_LENGTH;
        } else {
            throw new GeneralSecurityException("Unsupported ML-DSA instance: " + mlDsaInstance);
        }
        return new MlDsaVerifyConscrypt(mlDsaPublicKey.getOutputPrefix().toByteArray(), publicKeyGeneratePublic, str, i, provider);
    }

    public static PublicKeyVerify create(MlDsaPublicKey mlDsaPublicKey) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use ML-DSA in FIPS-mode, as it is not yet certified in Conscrypt.");
        }
        Provider providerProviderOrNull = ConscryptUtil.providerOrNull();
        if (providerProviderOrNull == null) {
            throw new GeneralSecurityException("Obtaining Conscrypt provider failed");
        }
        return createWithProvider(mlDsaPublicKey, providerProviderOrNull);
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
            KeyFactory.getInstance(ML_DSA_65_ALGORITHM, providerProviderOrNull);
            Signature.getInstance(ML_DSA_65_ALGORITHM, providerProviderOrNull);
            KeyFactory.getInstance(ML_DSA_87_ALGORITHM, providerProviderOrNull);
            Signature.getInstance(ML_DSA_87_ALGORITHM, providerProviderOrNull);
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
