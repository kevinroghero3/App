package com.google.crypto.tink.mac;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
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
import com.google.crypto.tink.mac.internal.ChunkedHmacImpl;
import com.google.crypto.tink.mac.internal.HmacProtoSerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class HmacKeyManager {
    private static final PrimitiveConstructor<HmacKey, ChunkedMac> CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.mac.HmacKeyManager$$ExternalSyntheticLambda3
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return new ChunkedHmacImpl((HmacKey) key);
        }
    }, HmacKey.class, ChunkedMac.class);
    private static final PrimitiveConstructor<HmacKey, Mac> MAC_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.mac.HmacKeyManager$$ExternalSyntheticLambda4
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return PrfMac.create((HmacKey) key);
        }
    }, HmacKey.class, Mac.class);
    private static final KeyManager<Mac> legacyKeyManager = LegacyKeyManagerImpl.create("type.googleapis.com/google.crypto.tink.HmacKey", Mac.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.HmacKey.parser());
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<HmacParameters> KEY_DERIVER = new MutableKeyDerivationRegistry.InsecureKeyCreator() { // from class: com.google.crypto.tink.mac.HmacKeyManager$$ExternalSyntheticLambda5
        @Override // com.google.crypto.tink.internal.MutableKeyDerivationRegistry.InsecureKeyCreator
        public final Key createKeyFromRandomness(Parameters parameters, InputStream inputStream, Integer num, SecretKeyAccess secretKeyAccess) {
            return HmacKeyManager.createHmacKeyFromRandomness((HmacParameters) parameters, inputStream, num, secretKeyAccess);
        }
    };
    private static final KeyCreator<HmacParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.mac.HmacKeyManager$$ExternalSyntheticLambda6
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return HmacKeyManager.createNewHmacKey((HmacParameters) parameters, num);
        }
    };
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    static HmacKey createHmacKeyFromRandomness(HmacParameters hmacParameters, InputStream inputStream, @Nullable Integer num, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return HmacKey.builder().setParameters(hmacParameters).setKeyBytes(Util.readIntoSecretBytes(inputStream, hmacParameters.getKeySizeBytes(), secretKeyAccess)).setIdRequirement(num).build();
    }

    static HmacKey createNewHmacKey(HmacParameters hmacParameters, @Nullable Integer num) throws GeneralSecurityException {
        return HmacKey.builder().setParameters(hmacParameters).setKeyBytes(SecretBytes.randomBytes(hmacParameters.getKeySizeBytes())).setIdRequirement(num).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("HMAC_SHA256_128BITTAG", PredefinedMacParameters.HMAC_SHA256_128BITTAG);
        HmacParameters.Builder tagSizeBytes = HmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(16);
        HmacParameters.Variant variant = HmacParameters.Variant.NO_PREFIX;
        HmacParameters.Builder variant2 = tagSizeBytes.setVariant(variant);
        HmacParameters.HashType hashType = HmacParameters.HashType.SHA256;
        map.put("HMAC_SHA256_128BITTAG_RAW", variant2.setHashType(hashType).build());
        HmacParameters.Builder tagSizeBytes2 = HmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(32);
        HmacParameters.Variant variant3 = HmacParameters.Variant.TINK;
        map.put("HMAC_SHA256_256BITTAG", tagSizeBytes2.setVariant(variant3).setHashType(hashType).build());
        map.put("HMAC_SHA256_256BITTAG_RAW", HmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(32).setVariant(variant).setHashType(hashType).build());
        HmacParameters.Builder variant4 = HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(16).setVariant(variant3);
        HmacParameters.HashType hashType2 = HmacParameters.HashType.SHA512;
        map.put("HMAC_SHA512_128BITTAG", variant4.setHashType(hashType2).build());
        map.put("HMAC_SHA512_128BITTAG_RAW", HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(16).setVariant(variant).setHashType(hashType2).build());
        map.put("HMAC_SHA512_256BITTAG", HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(32).setVariant(variant3).setHashType(hashType2).build());
        map.put("HMAC_SHA512_256BITTAG_RAW", HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(32).setVariant(variant).setHashType(hashType2).build());
        map.put("HMAC_SHA512_512BITTAG", PredefinedMacParameters.HMAC_SHA512_512BITTAG);
        map.put("HMAC_SHA512_512BITTAG_RAW", HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(64).setVariant(variant).setHashType(hashType2).build());
        return Collections.unmodifiableMap(map);
    }

    public static void register(boolean z) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility algorithmFipsCompatibility = FIPS;
        if (!algorithmFipsCompatibility.isCompatible()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        HmacProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(MAC_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, HmacParameters.class);
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, HmacParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyKeyManager, algorithmFipsCompatibility, z);
    }

    public static final KeyTemplate hmacSha256HalfDigestTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.mac.HmacKeyManager$$ExternalSyntheticLambda7
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return HmacKeyManager.lambda$hmacSha256HalfDigestTemplate$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$hmacSha256HalfDigestTemplate$0() throws Exception {
        return KeyTemplate.createFrom(HmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(16).setHashType(HmacParameters.HashType.SHA256).setVariant(HmacParameters.Variant.TINK).build());
    }

    public static final KeyTemplate hmacSha256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.mac.HmacKeyManager$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return HmacKeyManager.lambda$hmacSha256Template$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$hmacSha256Template$1() throws Exception {
        return KeyTemplate.createFrom(HmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(32).setHashType(HmacParameters.HashType.SHA256).setVariant(HmacParameters.Variant.TINK).build());
    }

    public static final KeyTemplate hmacSha512HalfDigestTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.mac.HmacKeyManager$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return HmacKeyManager.lambda$hmacSha512HalfDigestTemplate$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$hmacSha512HalfDigestTemplate$2() throws Exception {
        return KeyTemplate.createFrom(HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(32).setHashType(HmacParameters.HashType.SHA512).setVariant(HmacParameters.Variant.TINK).build());
    }

    public static final KeyTemplate hmacSha512Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.mac.HmacKeyManager$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return HmacKeyManager.lambda$hmacSha512Template$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$hmacSha512Template$3() throws Exception {
        return KeyTemplate.createFrom(HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(64).setHashType(HmacParameters.HashType.SHA512).setVariant(HmacParameters.Variant.TINK).build());
    }

    private HmacKeyManager() {
    }
}
