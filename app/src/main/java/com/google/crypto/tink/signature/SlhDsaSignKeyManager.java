package com.google.crypto.tink.signature;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.ConscryptUtil;
import com.google.crypto.tink.internal.KeyCreator;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.signature.internal.SlhDsaProtoSerialization;
import com.google.crypto.tink.signature.internal.SlhDsaVerifyConscrypt;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.util.AbstractMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SlhDsaSignKeyManager {
    static final String SLH_DSA_SHA2_128S_ALGORITHM = "SLH-DSA-SHA2-128S";
    private static final KeyCreator<SlhDsaParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.signature.SlhDsaSignKeyManager$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return SlhDsaSignKeyManager.createKey((SlhDsaParameters) parameters, num);
        }
    };
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;

    /* JADX INFO: Access modifiers changed from: private */
    public static SlhDsaPrivateKey createKey(SlhDsaParameters slhDsaParameters, @Nullable Integer num) throws GeneralSecurityException {
        if (slhDsaParameters.getPrivateKeySize() != 64 || slhDsaParameters.getHashType() != SlhDsaParameters.HashType.SHA2 || slhDsaParameters.getSignatureType() != SlhDsaParameters.SignatureType.SMALL_SIGNATURE) {
            throw new GeneralSecurityException("Unsupported SLH-DSA parameters");
        }
        Provider providerProviderOrNull = ConscryptUtil.providerOrNull();
        if (providerProviderOrNull == null) {
            throw new GeneralSecurityException("Obtaining Conscrypt provider failed");
        }
        KeyPair keyPairGenerateKeyPair = KeyPairGenerator.getInstance(SLH_DSA_SHA2_128S_ALGORITHM, providerProviderOrNull).generateKeyPair();
        KeyFactory keyFactory = KeyFactory.getInstance(SLH_DSA_SHA2_128S_ALGORITHM, providerProviderOrNull);
        return SlhDsaPrivateKey.createWithoutVerification(SlhDsaPublicKey.builder().setSerializedPublicKey(Bytes.copyFrom(((SlhDsaVerifyConscrypt.RawKeySpec) keyFactory.getKeySpec(keyPairGenerateKeyPair.getPublic(), SlhDsaVerifyConscrypt.RawKeySpec.class)).getEncoded())).setParameters(slhDsaParameters).setIdRequirement(num).build(), SecretBytes.copyFrom(((SlhDsaVerifyConscrypt.RawKeySpec) keyFactory.getKeySpec(keyPairGenerateKeyPair.getPrivate(), SlhDsaVerifyConscrypt.RawKeySpec.class)).getEncoded(), InsecureSecretKeyAccess.get()));
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        return MlDsaSignKeyManager$$ExternalSyntheticBackport1.m(new Map.Entry[]{new AbstractMap.SimpleEntry("SLH_DSA_SHA2_128S_TINK", SlhDsaParameters.createSlhDsaWithSha2And128S(SlhDsaParameters.Variant.TINK)), new AbstractMap.SimpleEntry("SLH_DSA_SHA2_128S_RAW", SlhDsaParameters.createSlhDsaWithSha2And128S(SlhDsaParameters.Variant.NO_PREFIX))});
    }

    public static void registerPair() throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use SLH-DSA in FIPS-mode, as it is not yet certified in Conscrypt.");
        }
        if (ConscryptUtil.providerOrNull() == null) {
            throw new GeneralSecurityException("Cannot use SLH-DSA without Conscrypt provider");
        }
        SlhDsaProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, SlhDsaParameters.class);
    }

    private SlhDsaSignKeyManager() {
    }
}
