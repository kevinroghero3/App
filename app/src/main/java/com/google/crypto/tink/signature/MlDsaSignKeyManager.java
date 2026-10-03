package com.google.crypto.tink.signature;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.ConscryptUtil;
import com.google.crypto.tink.internal.KeyCreator;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.signature.internal.MlDsaProtoSerialization;
import com.google.crypto.tink.signature.internal.MlDsaVerifyConscrypt;
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
final class MlDsaSignKeyManager {
    static final String ML_DSA_65_ALGORITHM = "ML-DSA-65";
    static final String ML_DSA_87_ALGORITHM = "ML-DSA-87";
    private static final KeyCreator<MlDsaParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.signature.MlDsaSignKeyManager$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return MlDsaSignKeyManager.createKey((MlDsaParameters) parameters, num);
        }
    };
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;

    static String getPublicKeyType() {
        return "type.googleapis.com/google.crypto.tink.MlDsaPublicKey";
    }

    static String getPrivateKeyType() {
        return "type.googleapis.com/google.crypto.tink.MlDsaPrivateKey";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MlDsaPrivateKey createKey(MlDsaParameters mlDsaParameters, @Nullable Integer num) throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator;
        KeyFactory keyFactory;
        Provider providerProviderOrNull = ConscryptUtil.providerOrNull();
        if (providerProviderOrNull == null) {
            throw new GeneralSecurityException("Obtaining Conscrypt provider failed");
        }
        if (mlDsaParameters.getMlDsaInstance() == MlDsaParameters.MlDsaInstance.ML_DSA_65) {
            keyPairGenerator = KeyPairGenerator.getInstance(ML_DSA_65_ALGORITHM, providerProviderOrNull);
            keyFactory = KeyFactory.getInstance(ML_DSA_65_ALGORITHM, providerProviderOrNull);
        } else if (mlDsaParameters.getMlDsaInstance() == MlDsaParameters.MlDsaInstance.ML_DSA_87) {
            keyPairGenerator = KeyPairGenerator.getInstance(ML_DSA_87_ALGORITHM, providerProviderOrNull);
            keyFactory = KeyFactory.getInstance(ML_DSA_87_ALGORITHM, providerProviderOrNull);
        } else {
            throw new GeneralSecurityException("Unknown ML-DSA instance: " + mlDsaParameters.getMlDsaInstance());
        }
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        return MlDsaPrivateKey.createWithoutVerification(MlDsaPublicKey.builder().setSerializedPublicKey(Bytes.copyFrom(((MlDsaVerifyConscrypt.RawKeySpec) keyFactory.getKeySpec(keyPairGenerateKeyPair.getPublic(), MlDsaVerifyConscrypt.RawKeySpec.class)).getEncoded())).setParameters(mlDsaParameters).setIdRequirement(num).build(), SecretBytes.copyFrom(((MlDsaVerifyConscrypt.RawKeySpec) keyFactory.getKeySpec(keyPairGenerateKeyPair.getPrivate(), MlDsaVerifyConscrypt.RawKeySpec.class)).getEncoded(), InsecureSecretKeyAccess.get()));
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        MlDsaParameters.MlDsaInstance mlDsaInstance = MlDsaParameters.MlDsaInstance.ML_DSA_65;
        MlDsaParameters.Variant variant = MlDsaParameters.Variant.TINK;
        MlDsaParameters mlDsaParametersCreate = MlDsaParameters.create(mlDsaInstance, variant);
        MlDsaParameters.Variant variant2 = MlDsaParameters.Variant.NO_PREFIX;
        MlDsaParameters mlDsaParametersCreate2 = MlDsaParameters.create(mlDsaInstance, variant2);
        MlDsaParameters.MlDsaInstance mlDsaInstance2 = MlDsaParameters.MlDsaInstance.ML_DSA_87;
        return MlDsaSignKeyManager$$ExternalSyntheticBackport1.m(new Map.Entry[]{new AbstractMap.SimpleEntry("ML_DSA_65", mlDsaParametersCreate), new AbstractMap.SimpleEntry("ML_DSA_65_RAW", mlDsaParametersCreate2), new AbstractMap.SimpleEntry("ML_DSA_87", MlDsaParameters.create(mlDsaInstance2, variant)), new AbstractMap.SimpleEntry("ML_DSA_87_RAW", MlDsaParameters.create(mlDsaInstance2, variant2))});
    }

    public static void registerPair() throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Cannot use ML-DSA in FIPS-mode, as it is not yet certified in Conscrypt.");
        }
        if (ConscryptUtil.providerOrNull() == null) {
            throw new GeneralSecurityException("Cannot use ML-DSA without Conscrypt provider");
        }
        MlDsaProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, MlDsaParameters.class);
    }

    private MlDsaSignKeyManager() {
    }
}
