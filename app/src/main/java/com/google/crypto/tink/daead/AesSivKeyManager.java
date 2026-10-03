package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.daead.internal.AesSivProtoSerialization;
import com.google.crypto.tink.internal.KeyCreator;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableKeyDerivationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.AesSiv;
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AesSivKeyManager {
    private static final int KEY_SIZE_IN_BYTES = 64;
    private static final PrimitiveConstructor<AesSivKey, DeterministicAead> AES_SIV_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.daead.AesSivKeyManager$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return AesSivKeyManager.createDeterministicAead((AesSivKey) key);
        }
    }, AesSivKey.class, DeterministicAead.class);
    private static final KeyManager<DeterministicAead> legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), DeterministicAead.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesSivKey.parser());
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<AesSivParameters> KEY_DERIVER = new MutableKeyDerivationRegistry.InsecureKeyCreator() { // from class: com.google.crypto.tink.daead.AesSivKeyManager$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.MutableKeyDerivationRegistry.InsecureKeyCreator
        public final Key createKeyFromRandomness(Parameters parameters, InputStream inputStream, Integer num, SecretKeyAccess secretKeyAccess) {
            return AesSivKeyManager.createAesSivKeyFromRandomness((AesSivParameters) parameters, inputStream, num, secretKeyAccess);
        }
    };
    private static final KeyCreator<AesSivParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.daead.AesSivKeyManager$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return AesSivKeyManager.newKey((AesSivParameters) parameters, num);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static DeterministicAead createDeterministicAead(AesSivKey aesSivKey) throws GeneralSecurityException {
        validateParameters(aesSivKey.getParameters());
        return AesSiv.create(aesSivKey);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    private static void validateParameters(AesSivParameters aesSivParameters) throws GeneralSecurityException {
        if (aesSivParameters.getKeySizeBytes() == 64) {
            return;
        }
        throw new InvalidAlgorithmParameterException("invalid key size: " + aesSivParameters.getKeySizeBytes() + ". Valid keys must have 64 bytes.");
    }

    static AesSivKey createAesSivKeyFromRandomness(AesSivParameters aesSivParameters, InputStream inputStream, @Nullable Integer num, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        validateParameters(aesSivParameters);
        return AesSivKey.builder().setParameters(aesSivParameters).setIdRequirement(num).setKeyBytes(Util.readIntoSecretBytes(inputStream, aesSivParameters.getKeySizeBytes(), secretKeyAccess)).build();
    }

    static AesSivKey newKey(AesSivParameters aesSivParameters, @Nullable Integer num) throws GeneralSecurityException {
        validateParameters(aesSivParameters);
        return AesSivKey.builder().setParameters(aesSivParameters).setIdRequirement(num).setKeyBytes(SecretBytes.randomBytes(aesSivParameters.getKeySizeBytes())).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES256_SIV", PredefinedDeterministicAeadParameters.AES256_SIV);
        map.put("AES256_SIV_RAW", AesSivParameters.builder().setKeySizeBytes(64).setVariant(AesSivParameters.Variant.NO_PREFIX).build());
        return Collections.unmodifiableMap(map);
    }

    public static void register(boolean z) throws GeneralSecurityException {
        if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
            throw new GeneralSecurityException("Registering AES SIV is not supported in FIPS mode");
        }
        AesSivProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(AES_SIV_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, AesSivParameters.class);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesSivParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, z);
    }

    public static final KeyTemplate aes256SivTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.daead.AesSivKeyManager$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesSivKeyManager.lambda$aes256SivTemplate$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes256SivTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesSivParameters.builder().setKeySizeBytes(64).setVariant(AesSivParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes256SivTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.daead.AesSivKeyManager$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesSivKeyManager.lambda$rawAes256SivTemplate$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$rawAes256SivTemplate$1() throws Exception {
        return KeyTemplate.createFrom(AesSivParameters.builder().setKeySizeBytes(64).setVariant(AesSivParameters.Variant.NO_PREFIX).build());
    }

    private AesSivKeyManager() {
    }
}
