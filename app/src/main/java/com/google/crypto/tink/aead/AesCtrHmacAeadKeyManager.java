package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.aead.internal.AesCtrHmacAeadProtoSerialization;
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
import com.google.crypto.tink.subtle.EncryptThenAuthenticate;
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AesCtrHmacAeadKeyManager {
    private static final PrimitiveConstructor<AesCtrHmacAeadKey, Aead> AES_CTR_HMAC_AEAD_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return EncryptThenAuthenticate.create((AesCtrHmacAeadKey) key);
        }
    }, AesCtrHmacAeadKey.class, Aead.class);
    private static final KeyManager<Aead> legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), Aead.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesCtrHmacAeadKey.parser());
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<AesCtrHmacAeadParameters> KEY_DERIVER = new MutableKeyDerivationRegistry.InsecureKeyCreator() { // from class: com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.MutableKeyDerivationRegistry.InsecureKeyCreator
        public final Key createKeyFromRandomness(Parameters parameters, InputStream inputStream, Integer num, SecretKeyAccess secretKeyAccess) {
            return AesCtrHmacAeadKeyManager.createAesCtrHmacAeadKeyFromRandomness((AesCtrHmacAeadParameters) parameters, inputStream, num, secretKeyAccess);
        }
    };
    private static final KeyCreator<AesCtrHmacAeadParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager$$ExternalSyntheticLambda3
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return AesCtrHmacAeadKeyManager.createAesCtrHmacAeadKey((AesCtrHmacAeadParameters) parameters, num);
        }
    };
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;

    private static void validate(AesCtrHmacAeadParameters aesCtrHmacAeadParameters) throws GeneralSecurityException {
        if (aesCtrHmacAeadParameters.getAesKeySizeBytes() != 16 && aesCtrHmacAeadParameters.getAesKeySizeBytes() != 32) {
            throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
        }
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    static AesCtrHmacAeadKey createAesCtrHmacAeadKeyFromRandomness(AesCtrHmacAeadParameters aesCtrHmacAeadParameters, InputStream inputStream, @Nullable Integer num, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return AesCtrHmacAeadKey.builder().setParameters(aesCtrHmacAeadParameters).setIdRequirement(num).setAesKeyBytes(Util.readIntoSecretBytes(inputStream, aesCtrHmacAeadParameters.getAesKeySizeBytes(), secretKeyAccess)).setHmacKeyBytes(Util.readIntoSecretBytes(inputStream, aesCtrHmacAeadParameters.getHmacKeySizeBytes(), secretKeyAccess)).build();
    }

    static AesCtrHmacAeadKey createAesCtrHmacAeadKey(AesCtrHmacAeadParameters aesCtrHmacAeadParameters, @Nullable Integer num) throws GeneralSecurityException {
        validate(aesCtrHmacAeadParameters);
        return AesCtrHmacAeadKey.builder().setParameters(aesCtrHmacAeadParameters).setIdRequirement(num).setAesKeyBytes(SecretBytes.randomBytes(aesCtrHmacAeadParameters.getAesKeySizeBytes())).setHmacKeyBytes(SecretBytes.randomBytes(aesCtrHmacAeadParameters.getHmacKeySizeBytes())).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES128_CTR_HMAC_SHA256", PredefinedAeadParameters.AES128_CTR_HMAC_SHA256);
        AesCtrHmacAeadParameters.Builder ivSizeBytes = AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(16).setHmacKeySizeBytes(32).setTagSizeBytes(16).setIvSizeBytes(16);
        AesCtrHmacAeadParameters.HashType hashType = AesCtrHmacAeadParameters.HashType.SHA256;
        AesCtrHmacAeadParameters.Builder hashType2 = ivSizeBytes.setHashType(hashType);
        AesCtrHmacAeadParameters.Variant variant = AesCtrHmacAeadParameters.Variant.NO_PREFIX;
        map.put("AES128_CTR_HMAC_SHA256_RAW", hashType2.setVariant(variant).build());
        map.put("AES256_CTR_HMAC_SHA256", PredefinedAeadParameters.AES256_CTR_HMAC_SHA256);
        map.put("AES256_CTR_HMAC_SHA256_RAW", AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(32).setHmacKeySizeBytes(32).setTagSizeBytes(32).setIvSizeBytes(16).setHashType(hashType).setVariant(variant).build());
        return Collections.unmodifiableMap(map);
    }

    public static void register(boolean z) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility algorithmFipsCompatibility = FIPS;
        if (!algorithmFipsCompatibility.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        AesCtrHmacAeadProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(AES_CTR_HMAC_AEAD_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, AesCtrHmacAeadParameters.class);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesCtrHmacAeadParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyKeyManager, algorithmFipsCompatibility, z);
    }

    public static final KeyTemplate aes128CtrHmacSha256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesCtrHmacAeadKeyManager.lambda$aes128CtrHmacSha256Template$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes128CtrHmacSha256Template$0() throws Exception {
        return KeyTemplate.createFrom(AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(16).setHmacKeySizeBytes(32).setIvSizeBytes(16).setTagSizeBytes(16).setHashType(AesCtrHmacAeadParameters.HashType.SHA256).setVariant(AesCtrHmacAeadParameters.Variant.TINK).build());
    }

    public static final KeyTemplate aes256CtrHmacSha256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesCtrHmacAeadKeyManager.lambda$aes256CtrHmacSha256Template$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes256CtrHmacSha256Template$1() throws Exception {
        return KeyTemplate.createFrom(AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(32).setHmacKeySizeBytes(32).setIvSizeBytes(16).setTagSizeBytes(32).setHashType(AesCtrHmacAeadParameters.HashType.SHA256).setVariant(AesCtrHmacAeadParameters.Variant.TINK).build());
    }

    private AesCtrHmacAeadKeyManager() {
    }
}
