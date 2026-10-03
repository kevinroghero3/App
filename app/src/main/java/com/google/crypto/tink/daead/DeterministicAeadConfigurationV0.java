package com.google.crypto.tink.daead;

import com.google.crypto.tink.Configuration;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.subtle.AesSiv;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes5.dex */
class DeterministicAeadConfigurationV0 {
    private static final int KEY_SIZE_IN_BYTES = 64;
    private static final DeterministicAeadWrapper DETERMINISTIC_AEAD_WRAPPER = new DeterministicAeadWrapper();
    private static final Configuration CONFIGURATION = create();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ DeterministicAead access$100(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createDeterministicAead(entry);
    }

    private DeterministicAeadConfigurationV0() {
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.daead.DeterministicAeadConfigurationV0$1, reason: invalid class name */
    class AnonymousClass1 implements Configuration {
        AnonymousClass1() {
        }

        @Override // com.google.crypto.tink.Configuration
        public <P> P createPrimitive(KeysetHandleInterface keysetHandleInterface, Class<P> cls) throws GeneralSecurityException {
            if (cls.equals(DeterministicAead.class)) {
                return cls.cast(DeterministicAeadConfigurationV0.DETERMINISTIC_AEAD_WRAPPER.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.daead.DeterministicAeadConfigurationV0$1$$ExternalSyntheticLambda0
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return DeterministicAeadConfigurationV0.access$100(entry);
                    }
                }));
            }
            throw new GeneralSecurityException("DeterministicAeadConfigurationV0 can only create DeterministicAead primitive");
        }
    }

    private static Configuration create() {
        return new AnonymousClass1();
    }

    public static Configuration get() throws GeneralSecurityException {
        if (TinkFipsUtil.useOnlyFips()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant DeterministicAeadConfigurationV0 in FIPS mode");
        }
        return CONFIGURATION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DeterministicAead createDeterministicAead(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof LegacyProtoKey) {
            key = MutableSerializationRegistry.globalInstance().parseKey(((LegacyProtoKey) key).getSerialization(InsecureSecretKeyAccess.get()), InsecureSecretKeyAccess.get());
        }
        if (key instanceof AesSivKey) {
            return createAesSiv((AesSivKey) key);
        }
        throw new GeneralSecurityException("Unknown key class: " + key.getClass());
    }

    private static DeterministicAead createAesSiv(AesSivKey aesSivKey) throws GeneralSecurityException {
        if (aesSivKey.getParameters().getKeySizeBytes() != 64) {
            throw new InvalidAlgorithmParameterException("invalid key size: " + aesSivKey.getParameters().getKeySizeBytes() + ". Valid keys must have 64 bytes.");
        }
        return AesSiv.create(aesSivKey);
    }
}
