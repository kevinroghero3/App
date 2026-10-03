package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.StreamingAead;
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
import com.google.crypto.tink.streamingaead.internal.AesGcmHkdfStreamingProtoSerialization;
import com.google.crypto.tink.subtle.AesGcmHkdfStreaming;
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class AesGcmHkdfStreamingKeyManager {
    private static final PrimitiveConstructor<AesGcmHkdfStreamingKey, StreamingAead> AES_GCM_HKDF_STREAMING_AEAD_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKeyManager$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return AesGcmHkdfStreaming.create((AesGcmHkdfStreamingKey) key);
        }
    }, AesGcmHkdfStreamingKey.class, StreamingAead.class);
    private static final KeyManager<StreamingAead> legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), StreamingAead.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.AesGcmHkdfStreamingKey.parser());
    private static final KeyCreator<AesGcmHkdfStreamingParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKeyManager$$ExternalSyntheticLambda3
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return AesGcmHkdfStreamingKeyManager.creatAesGcmHkdfStreamingKey((AesGcmHkdfStreamingParameters) parameters, num);
        }
    };
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<AesGcmHkdfStreamingParameters> KEY_DERIVER = new MutableKeyDerivationRegistry.InsecureKeyCreator() { // from class: com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKeyManager$$ExternalSyntheticLambda4
        @Override // com.google.crypto.tink.internal.MutableKeyDerivationRegistry.InsecureKeyCreator
        public final Key createKeyFromRandomness(Parameters parameters, InputStream inputStream, Integer num, SecretKeyAccess secretKeyAccess) {
            return AesGcmHkdfStreamingKeyManager.createAesGcmHkdfStreamingKeyFromRandomness((AesGcmHkdfStreamingParameters) parameters, inputStream, num, secretKeyAccess);
        }
    };

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesGcmHkdfStreamingKey creatAesGcmHkdfStreamingKey(AesGcmHkdfStreamingParameters aesGcmHkdfStreamingParameters, @Nullable Integer num) throws GeneralSecurityException {
        return AesGcmHkdfStreamingKey.create(aesGcmHkdfStreamingParameters, SecretBytes.randomBytes(aesGcmHkdfStreamingParameters.getKeySizeBytes()));
    }

    static AesGcmHkdfStreamingKey createAesGcmHkdfStreamingKeyFromRandomness(AesGcmHkdfStreamingParameters aesGcmHkdfStreamingParameters, InputStream inputStream, @Nullable Integer num, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return AesGcmHkdfStreamingKey.create(aesGcmHkdfStreamingParameters, Util.readIntoSecretBytes(inputStream, aesGcmHkdfStreamingParameters.getKeySizeBytes(), secretKeyAccess));
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES128_GCM_HKDF_4KB", PredefinedStreamingAeadParameters.AES128_GCM_HKDF_4KB);
        map.put("AES128_GCM_HKDF_1MB", PredefinedStreamingAeadParameters.AES128_GCM_HKDF_1MB);
        map.put("AES256_GCM_HKDF_4KB", PredefinedStreamingAeadParameters.AES256_GCM_HKDF_4KB);
        map.put("AES256_GCM_HKDF_1MB", PredefinedStreamingAeadParameters.AES256_GCM_HKDF_1MB);
        return Collections.unmodifiableMap(map);
    }

    public static void register(boolean z) throws GeneralSecurityException {
        if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
            throw new GeneralSecurityException("Registering AES-GCM HKDF Streaming AEAD is not supported in FIPS mode");
        }
        AesGcmHkdfStreamingProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, AesGcmHkdfStreamingParameters.class);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, AesGcmHkdfStreamingParameters.class);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(AES_GCM_HKDF_STREAMING_AEAD_PRIMITIVE_CONSTRUCTOR);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, z);
    }

    public static final KeyTemplate aes128GcmHkdf4KBTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKeyManager$$ExternalSyntheticLambda6
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesGcmHkdfStreamingKeyManager.lambda$aes128GcmHkdf4KBTemplate$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes128GcmHkdf4KBTemplate$0() throws Exception {
        return KeyTemplate.createFrom(AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(16).setDerivedAesGcmKeySizeBytes(16).setCiphertextSegmentSizeBytes(4096).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).build());
    }

    public static final KeyTemplate aes128GcmHkdf1MBTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKeyManager$$ExternalSyntheticLambda5
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesGcmHkdfStreamingKeyManager.lambda$aes128GcmHkdf1MBTemplate$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes128GcmHkdf1MBTemplate$1() throws Exception {
        return KeyTemplate.createFrom(AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(16).setDerivedAesGcmKeySizeBytes(16).setCiphertextSegmentSizeBytes(1048576).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).build());
    }

    public static final KeyTemplate aes256GcmHkdf4KBTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKeyManager$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesGcmHkdfStreamingKeyManager.lambda$aes256GcmHkdf4KBTemplate$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes256GcmHkdf4KBTemplate$2() throws Exception {
        return KeyTemplate.createFrom(AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(32).setDerivedAesGcmKeySizeBytes(32).setCiphertextSegmentSizeBytes(4096).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).build());
    }

    public static final KeyTemplate aes256GcmHkdf1MBTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKeyManager$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return AesGcmHkdfStreamingKeyManager.lambda$aes256GcmHkdf1MBTemplate$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$aes256GcmHkdf1MBTemplate$3() throws Exception {
        return KeyTemplate.createFrom(AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(32).setDerivedAesGcmKeySizeBytes(32).setCiphertextSegmentSizeBytes(1048576).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).build());
    }

    private AesGcmHkdfStreamingKeyManager() {
    }
}
