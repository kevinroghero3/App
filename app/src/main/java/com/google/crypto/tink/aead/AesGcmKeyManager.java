package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.aead.internal.AesGcmProtoSerialization;
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
import com.google.crypto.tink.subtle.AesGcmJce;
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AesGcmKeyManager {
    private static final PrimitiveConstructor<AesGcmKey, Aead> AES_GCM_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.aead.AesGcmKeyManager$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return AesGcmJce.create((AesGcmKey) key);
        }
    }, AesGcmKey.class, Aead.class);
    private static final KeyManager<Aead> legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), Aead.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesGcmKey.parser());
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<AesGcmParameters> KEY_DERIVER = new MutableKeyDerivationRegistry.InsecureKeyCreator() { // from class: com.google.crypto.tink.aead.AesGcmKeyManager$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.MutableKeyDerivationRegistry.InsecureKeyCreator
        public final Key createKeyFromRandomness(Parameters parameters, InputStream inputStream, Integer num, SecretKeyAccess secretKeyAccess) {
            return AesGcmKeyManager.createAesGcmKeyFromRandomness((AesGcmParameters) parameters, inputStream, num, secretKeyAccess);
        }
    };
    private static final KeyCreator<AesGcmParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.aead.AesGcmKeyManager$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return AesGcmKeyManager.createAesGcmKey((AesGcmParameters) parameters, num);
        }
    };
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;

    private static final void validate(AesGcmParameters aesGcmParameters) throws GeneralSecurityException {
        if (aesGcmParameters.getKeySizeBytes() == 24) {
            throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
        }
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES128_GCM", PredefinedAeadParameters.AES128_GCM);
        AesGcmParameters.Builder tagSizeBytes = AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16);
        AesGcmParameters.Variant variant = AesGcmParameters.Variant.NO_PREFIX;
        map.put("AES128_GCM_RAW", tagSizeBytes.setVariant(variant).build());
        map.put("AES256_GCM", PredefinedAeadParameters.AES256_GCM);
        map.put("AES256_GCM_RAW", AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(variant).build());
        return Collections.unmodifiableMap(map);
    }

    static AesGcmKey createAesGcmKeyFromRandomness(AesGcmParameters aesGcmParameters, InputStream inputStream, @Nullable Integer num, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        validate(aesGcmParameters);
        return AesGcmKey.builder().setParameters(aesGcmParameters).setIdRequirement(num).setKeyBytes(Util.readIntoSecretBytes(inputStream, aesGcmParameters.getKeySizeBytes(), secretKeyAccess)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesGcmKey createAesGcmKey(AesGcmParameters aesGcmParameters, @Nullable Integer num) throws GeneralSecurityException {
        validate(aesGcmParameters);
        return AesGcmKey.builder().setParameters(aesGcmParameters).setIdRequirement(num).setKeyBytes(SecretBytes.randomBytes(aesGcmParameters.getKeySizeBytes())).build();
    }

    public static void register(boolean z) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility algorithmFipsCompatibility = FIPS;
        if (!algorithmFipsCompatibility.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        AesGcmProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(AES_GCM_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, AesGcmParameters.class);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesGcmParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyKeyManager, algorithmFipsCompatibility, z);
    }

    public static final KeyTemplate aes128GcmTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesGcmKeyManager$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesGcmKeyManager.lambda$aes128GcmTemplate$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes128GcmTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes128GcmTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesGcmKeyManager$$ExternalSyntheticLambda5
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesGcmKeyManager.lambda$rawAes128GcmTemplate$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$rawAes128GcmTemplate$1() throws Exception {
        return KeyTemplate.createFrom(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.NO_PREFIX).build());
    }

    public static final KeyTemplate aes256GcmTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesGcmKeyManager$$ExternalSyntheticLambda6
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesGcmKeyManager.lambda$aes256GcmTemplate$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes256GcmTemplate$2() throws Exception {
        return KeyTemplate.createFrom(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes256GcmTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesGcmKeyManager$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesGcmKeyManager.lambda$rawAes256GcmTemplate$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$rawAes256GcmTemplate$3() throws Exception {
        return KeyTemplate.createFrom(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.NO_PREFIX).build());
    }

    private AesGcmKeyManager() {
    }
}
