package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.aead.internal.AesEaxProtoSerialization;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyCreator;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.AesEaxJce;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AesEaxKeyManager {
    private static final PrimitiveConstructor<AesEaxKey, Aead> AES_EAX_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.aead.AesEaxKeyManager$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return AesEaxJce.create((AesEaxKey) key);
        }
    }, AesEaxKey.class, Aead.class);
    private static final KeyManager<Aead> legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), Aead.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesEaxKey.parser());
    private static final KeyCreator<AesEaxParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.aead.AesEaxKeyManager$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return AesEaxKeyManager.createAesEaxKey((AesEaxParameters) parameters, num);
        }
    };

    private static final void validate(AesEaxParameters aesEaxParameters) throws GeneralSecurityException {
        if (aesEaxParameters.getKeySizeBytes() == 24) {
            throw new GeneralSecurityException("192 bit AES EAX Parameters are not valid");
        }
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES128_EAX", PredefinedAeadParameters.AES128_EAX);
        AesEaxParameters.Builder tagSizeBytes = AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(16).setTagSizeBytes(16);
        AesEaxParameters.Variant variant = AesEaxParameters.Variant.NO_PREFIX;
        map.put("AES128_EAX_RAW", tagSizeBytes.setVariant(variant).build());
        map.put("AES256_EAX", PredefinedAeadParameters.AES256_EAX);
        map.put("AES256_EAX_RAW", AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(variant).build());
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesEaxKey createAesEaxKey(AesEaxParameters aesEaxParameters, @Nullable Integer num) throws GeneralSecurityException {
        validate(aesEaxParameters);
        return AesEaxKey.builder().setParameters(aesEaxParameters).setIdRequirement(num).setKeyBytes(SecretBytes.randomBytes(aesEaxParameters.getKeySizeBytes())).build();
    }

    public static void register(boolean z) throws GeneralSecurityException {
        if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
            throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
        }
        AesEaxProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(AES_EAX_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesEaxParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, z);
    }

    public static final KeyTemplate aes128EaxTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesEaxKeyManager$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesEaxKeyManager.lambda$aes128EaxTemplate$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes128EaxTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes128EaxTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesEaxKeyManager$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesEaxKeyManager.lambda$rawAes128EaxTemplate$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$rawAes128EaxTemplate$1() throws Exception {
        return KeyTemplate.createFrom(AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.NO_PREFIX).build());
    }

    public static final KeyTemplate aes256EaxTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesEaxKeyManager$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesEaxKeyManager.lambda$aes256EaxTemplate$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes256EaxTemplate$2() throws Exception {
        return KeyTemplate.createFrom(AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes256EaxTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesEaxKeyManager$$ExternalSyntheticLambda5
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesEaxKeyManager.lambda$rawAes256EaxTemplate$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$rawAes256EaxTemplate$3() throws Exception {
        return KeyTemplate.createFrom(AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.NO_PREFIX).build());
    }

    private AesEaxKeyManager() {
    }
}
