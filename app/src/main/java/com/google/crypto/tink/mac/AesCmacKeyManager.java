package com.google.crypto.tink.mac;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyCreator;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.mac.internal.AesCmacProtoSerialization;
import com.google.crypto.tink.mac.internal.ChunkedAesCmacImpl;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AesCmacKeyManager {
    private static final int KEY_SIZE_IN_BYTES = 32;
    private static final KeyCreator<AesCmacParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.mac.AesCmacKeyManager$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return AesCmacKeyManager.createAesCmacKey((AesCmacParameters) parameters, num);
        }
    };
    private static final PrimitiveConstructor<AesCmacKey, ChunkedMac> CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.mac.AesCmacKeyManager$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return AesCmacKeyManager.createChunkedMac((AesCmacKey) key);
        }
    }, AesCmacKey.class, ChunkedMac.class);
    private static final PrimitiveConstructor<AesCmacKey, Mac> MAC_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.mac.AesCmacKeyManager$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return AesCmacKeyManager.createMac((AesCmacKey) key);
        }
    }, AesCmacKey.class, Mac.class);
    private static final KeyManager<Mac> legacyKeyManager = LegacyKeyManagerImpl.create("type.googleapis.com/google.crypto.tink.AesCmacKey", Mac.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesCmacKey.parser());

    private static void validateParameters(AesCmacParameters aesCmacParameters) throws GeneralSecurityException {
        if (aesCmacParameters.getKeySizeBytes() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesCmacKey createAesCmacKey(AesCmacParameters aesCmacParameters, @Nullable Integer num) throws GeneralSecurityException {
        validateParameters(aesCmacParameters);
        return AesCmacKey.builder().setParameters(aesCmacParameters).setAesKeyBytes(SecretBytes.randomBytes(aesCmacParameters.getKeySizeBytes())).setIdRequirement(num).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ChunkedMac createChunkedMac(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        validateParameters(aesCmacKey.getParameters());
        return ChunkedAesCmacImpl.create(aesCmacKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Mac createMac(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        validateParameters(aesCmacKey.getParameters());
        return PrfMac.create(aesCmacKey);
    }

    public static void register(boolean z) throws GeneralSecurityException {
        if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
            throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
        }
        AesCmacProtoSerialization.register();
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesCmacParameters.class);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(MAC_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, z);
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        AesCmacParameters aesCmacParameters = PredefinedMacParameters.AES_CMAC;
        map.put("AES_CMAC", aesCmacParameters);
        map.put("AES256_CMAC", aesCmacParameters);
        map.put("AES256_CMAC_RAW", AesCmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesCmacParameters.Variant.NO_PREFIX).build());
        return Collections.unmodifiableMap(map);
    }

    public static final KeyTemplate aes256CmacTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.mac.AesCmacKeyManager$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesCmacKeyManager.lambda$aes256CmacTemplate$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes256CmacTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesCmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesCmacParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawAes256CmacTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.mac.AesCmacKeyManager$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesCmacKeyManager.lambda$rawAes256CmacTemplate$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$rawAes256CmacTemplate$1() throws Exception {
        return KeyTemplate.createFrom(AesCmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesCmacParameters.Variant.NO_PREFIX).build());
    }

    private AesCmacKeyManager() {
    }
}
