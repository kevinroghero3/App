package com.google.crypto.tink.prf;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
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
import com.google.crypto.tink.prf.internal.HkdfPrfProtoSerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.prf.HkdfStreamingPrf;
import com.google.crypto.tink.subtle.prf.PrfImpl;
import com.google.crypto.tink.subtle.prf.StreamingPrf;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class HkdfPrfKeyManager {
    private static final int MIN_KEY_SIZE = 32;
    private static final PrimitiveConstructor<HkdfPrfKey, StreamingPrf> STREAMING_HKDF_PRF_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.prf.HkdfPrfKeyManager$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return HkdfPrfKeyManager.createStreamingPrf((HkdfPrfKey) key);
        }
    }, HkdfPrfKey.class, StreamingPrf.class);
    private static final PrimitiveConstructor<HkdfPrfKey, Prf> HKDF_PRF_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.prf.HkdfPrfKeyManager$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return HkdfPrfKeyManager.createPrf((HkdfPrfKey) key);
        }
    }, HkdfPrfKey.class, Prf.class);
    private static final KeyManager<Prf> legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), Prf.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.HkdfPrfKey.parser());
    static final KeyCreator<HkdfPrfParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.prf.HkdfPrfKeyManager$$ExternalSyntheticLambda3
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return HkdfPrfKeyManager.newKey((HkdfPrfParameters) parameters, num);
        }
    };

    private static void validate(HkdfPrfParameters hkdfPrfParameters) throws GeneralSecurityException {
        if (hkdfPrfParameters.getKeySizeBytes() < 32) {
            throw new GeneralSecurityException("Key size must be at least 32");
        }
        if (hkdfPrfParameters.getHashType() != HkdfPrfParameters.HashType.SHA256 && hkdfPrfParameters.getHashType() != HkdfPrfParameters.HashType.SHA512) {
            throw new GeneralSecurityException("Hash type must be SHA256 or SHA512");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StreamingPrf createStreamingPrf(HkdfPrfKey hkdfPrfKey) throws GeneralSecurityException {
        validate(hkdfPrfKey.getParameters());
        return HkdfStreamingPrf.create(hkdfPrfKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Prf createPrf(HkdfPrfKey hkdfPrfKey) throws GeneralSecurityException {
        return PrfImpl.wrap(createStreamingPrf(hkdfPrfKey));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HkdfPrfKey newKey(HkdfPrfParameters hkdfPrfParameters, @Nullable Integer num) throws GeneralSecurityException {
        if (num != null) {
            throw new GeneralSecurityException("Id Requirement is not supported for HKDF PRF keys");
        }
        validate(hkdfPrfParameters);
        return HkdfPrfKey.builder().setParameters(hkdfPrfParameters).setKeyBytes(SecretBytes.randomBytes(hkdfPrfParameters.getKeySizeBytes())).build();
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HkdfPrfKey";
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("HKDF_SHA256", PredefinedPrfParameters.HKDF_SHA256);
        return Collections.unmodifiableMap(map);
    }

    public static void register(boolean z) throws GeneralSecurityException {
        if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
            throw new GeneralSecurityException("Registering HKDF PRF is not supported in FIPS mode");
        }
        HkdfPrfProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(HKDF_PRF_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(STREAMING_HKDF_PRF_CONSTRUCTOR);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, HkdfPrfParameters.class);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyKeyManager, z);
    }

    public static String staticKeyType() {
        return getKeyType();
    }

    public static final KeyTemplate hkdfSha256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.prf.HkdfPrfKeyManager$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return HkdfPrfKeyManager.lambda$hkdfSha256Template$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$hkdfSha256Template$0() throws Exception {
        return KeyTemplate.createFrom(HkdfPrfParameters.builder().setKeySizeBytes(32).setHashType(HkdfPrfParameters.HashType.SHA256).build());
    }

    private HkdfPrfKeyManager() {
    }
}
