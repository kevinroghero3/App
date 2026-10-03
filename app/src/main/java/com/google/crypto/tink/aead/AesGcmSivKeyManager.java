package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.aead.internal.AesGcmSivProtoSerialization;
import com.google.crypto.tink.aead.subtle.AesGcmSiv;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
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
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AesGcmSivKeyManager {
    private static final PrimitiveConstructor<AesGcmSivKey, Aead> AES_GCM_SIV_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.aead.AesGcmSivKeyManager$$ExternalSyntheticLambda3
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return AesGcmSiv.create((AesGcmSivKey) key);
        }
    }, AesGcmSivKey.class, Aead.class);
    private static final KeyCreator<AesGcmSivParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.aead.AesGcmSivKeyManager$$ExternalSyntheticLambda4
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return AesGcmSivKeyManager.createAesGcmSivKey((AesGcmSivParameters) parameters, num);
        }
    };
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<AesGcmSivParameters> KEY_DERIVER = new MutableKeyDerivationRegistry.InsecureKeyCreator() { // from class: com.google.crypto.tink.aead.AesGcmSivKeyManager$$ExternalSyntheticLambda5
        @Override // com.google.crypto.tink.internal.MutableKeyDerivationRegistry.InsecureKeyCreator
        public final Key createKeyFromRandomness(Parameters parameters, InputStream inputStream, Integer num, SecretKeyAccess secretKeyAccess) {
            return AesGcmSivKeyManager.createAesGcmSivKeyFromRandomness((AesGcmSivParameters) parameters, inputStream, num, secretKeyAccess);
        }
    };
    private static final KeyManager<Aead> legacyKeyManager = LegacyKeyManagerImpl.create("type.googleapis.com/google.crypto.tink.AesGcmSivKey", Aead.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesGcmSivKey.parser());

    static AesGcmSivKey createAesGcmSivKeyFromRandomness(AesGcmSivParameters aesGcmSivParameters, InputStream inputStream, @Nullable Integer num, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return AesGcmSivKey.builder().setParameters(aesGcmSivParameters).setIdRequirement(num).setKeyBytes(Util.readIntoSecretBytes(inputStream, aesGcmSivParameters.getKeySizeBytes(), secretKeyAccess)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesGcmSivKey createAesGcmSivKey(AesGcmSivParameters aesGcmSivParameters, @Nullable Integer num) throws GeneralSecurityException {
        return AesGcmSivKey.builder().setParameters(aesGcmSivParameters).setIdRequirement(num).setKeyBytes(SecretBytes.randomBytes(aesGcmSivParameters.getKeySizeBytes())).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        AesGcmSivParameters.Builder keySizeBytes = AesGcmSivParameters.builder().setKeySizeBytes(16);
        AesGcmSivParameters.Variant variant = AesGcmSivParameters.Variant.TINK;
        map.put("AES128_GCM_SIV", keySizeBytes.setVariant(variant).build());
        AesGcmSivParameters.Builder keySizeBytes2 = AesGcmSivParameters.builder().setKeySizeBytes(16);
        AesGcmSivParameters.Variant variant2 = AesGcmSivParameters.Variant.NO_PREFIX;
        map.put("AES128_GCM_SIV_RAW", keySizeBytes2.setVariant(variant2).build());
        map.put("AES256_GCM_SIV", AesGcmSivParameters.builder().setKeySizeBytes(32).setVariant(variant).build());
        map.put("AES256_GCM_SIV_RAW", AesGcmSivParameters.builder().setKeySizeBytes(32).setVariant(variant2).build());
        return Collections.unmodifiableMap(map);
    }

    public static void register(boolean z) throws GeneralSecurityException {
        if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
            throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
        }
        AesGcmSivProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, AesGcmSivParameters.class);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesGcmSivParameters.class);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(AES_GCM_SIV_PRIMITIVE_CONSTRUCTOR);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, z);
    }

    public static final KeyTemplate aes128GcmSivTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesGcmSivKeyManager$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesGcmSivKeyManager.lambda$aes128GcmSivTemplate$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes128GcmSivTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesGcmSivParameters.builder().setKeySizeBytes(16).setVariant(AesGcmSivParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes128GcmSivTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesGcmSivKeyManager$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesGcmSivKeyManager.lambda$rawAes128GcmSivTemplate$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$rawAes128GcmSivTemplate$1() throws Exception {
        return KeyTemplate.createFrom(AesGcmSivParameters.builder().setKeySizeBytes(16).setVariant(AesGcmSivParameters.Variant.NO_PREFIX).build());
    }

    public static final KeyTemplate aes256GcmSivTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesGcmSivKeyManager$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesGcmSivKeyManager.lambda$aes256GcmSivTemplate$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes256GcmSivTemplate$2() throws Exception {
        return KeyTemplate.createFrom(AesGcmSivParameters.builder().setKeySizeBytes(32).setVariant(AesGcmSivParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes256GcmSivTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesGcmSivKeyManager$$ExternalSyntheticLambda6
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesGcmSivKeyManager.lambda$rawAes256GcmSivTemplate$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$rawAes256GcmSivTemplate$3() throws Exception {
        return KeyTemplate.createFrom(AesGcmSivParameters.builder().setKeySizeBytes(32).setVariant(AesGcmSivParameters.Variant.NO_PREFIX).build());
    }

    private AesGcmSivKeyManager() {
    }
}
