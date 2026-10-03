package com.google.crypto.tink.prf;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
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
import com.google.crypto.tink.prf.internal.HmacPrfProtoSerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.PrfHmacJce;
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class HmacPrfKeyManager {
    private static final PrimitiveConstructor<HmacPrfKey, Prf> PRF_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.prf.HmacPrfKeyManager$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return PrfHmacJce.create((HmacPrfKey) key);
        }
    }, HmacPrfKey.class, Prf.class);
    private static final KeyManager<Prf> legacyKeyManager = LegacyKeyManagerImpl.create(getKeyType(), Prf.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.HmacPrfKey.parser());
    private static final KeyCreator<HmacPrfParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.prf.HmacPrfKeyManager$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return HmacPrfKeyManager.newKey((HmacPrfParameters) parameters, num);
        }
    };
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<HmacPrfParameters> KEY_DERIVER = new MutableKeyDerivationRegistry.InsecureKeyCreator() { // from class: com.google.crypto.tink.prf.HmacPrfKeyManager$$ExternalSyntheticLambda3
        @Override // com.google.crypto.tink.internal.MutableKeyDerivationRegistry.InsecureKeyCreator
        public final Key createKeyFromRandomness(Parameters parameters, InputStream inputStream, Integer num, SecretKeyAccess secretKeyAccess) {
            return HmacPrfKeyManager.createHmacKeyFromRandomness((HmacPrfParameters) parameters, inputStream, num, secretKeyAccess);
        }
    };
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;

    /* JADX INFO: Access modifiers changed from: private */
    public static HmacPrfKey newKey(HmacPrfParameters hmacPrfParameters, @Nullable Integer num) throws GeneralSecurityException {
        if (num != null) {
            throw new GeneralSecurityException("Id Requirement is not supported for HMAC PRF keys");
        }
        return HmacPrfKey.builder().setParameters(hmacPrfParameters).setKeyBytes(SecretBytes.randomBytes(hmacPrfParameters.getKeySizeBytes())).build();
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacPrfKey";
    }

    static HmacPrfKey createHmacKeyFromRandomness(HmacPrfParameters hmacPrfParameters, InputStream inputStream, @Nullable Integer num, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return HmacPrfKey.builder().setParameters(hmacPrfParameters).setKeyBytes(Util.readIntoSecretBytes(inputStream, hmacPrfParameters.getKeySizeBytes(), secretKeyAccess)).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("HMAC_SHA256_PRF", PredefinedPrfParameters.HMAC_SHA256_PRF);
        map.put("HMAC_SHA512_PRF", PredefinedPrfParameters.HMAC_SHA512_PRF);
        return Collections.unmodifiableMap(map);
    }

    public static void register(boolean z) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility algorithmFipsCompatibility = FIPS;
        if (!algorithmFipsCompatibility.isCompatible()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        HmacPrfProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PRF_PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, HmacPrfParameters.class);
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, HmacPrfParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyKeyManager, algorithmFipsCompatibility, z);
    }

    public static final KeyTemplate hmacSha256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.prf.HmacPrfKeyManager$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return HmacPrfKeyManager.lambda$hmacSha256Template$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$hmacSha256Template$0() throws Exception {
        return KeyTemplate.createFrom(HmacPrfParameters.builder().setKeySizeBytes(32).setHashType(HmacPrfParameters.HashType.SHA256).build());
    }

    public static final KeyTemplate hmacSha512Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.prf.HmacPrfKeyManager$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return HmacPrfKeyManager.lambda$hmacSha512Template$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$hmacSha512Template$1() throws Exception {
        return KeyTemplate.createFrom(HmacPrfParameters.builder().setKeySizeBytes(64).setHashType(HmacPrfParameters.HashType.SHA512).build());
    }

    private HmacPrfKeyManager() {
    }
}
