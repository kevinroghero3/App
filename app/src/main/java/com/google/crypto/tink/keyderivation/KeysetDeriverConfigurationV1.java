package com.google.crypto.tink.keyderivation;

import com.google.crypto.tink.Configuration;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.keyderivation.internal.KeyDeriver;
import com.google.crypto.tink.keyderivation.internal.PrfBasedKeyDeriver;
import com.google.crypto.tink.prf.HkdfPrfKey;
import com.google.crypto.tink.subtle.prf.StreamingPrf;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class KeysetDeriverConfigurationV1 {
    private static final Configuration CONFIGURATION = create();
    private static final PrimitiveRegistry PRF_REGISTRY = createPrfRegistry();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ KeyDeriver access$000(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createKeyDeriver(entry);
    }

    private KeysetDeriverConfigurationV1() {
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.keyderivation.KeysetDeriverConfigurationV1$1, reason: invalid class name */
    class AnonymousClass1 implements Configuration {
        AnonymousClass1() {
        }

        @Override // com.google.crypto.tink.Configuration
        public <P> P createPrimitive(KeysetHandleInterface keysetHandleInterface, Class<P> cls) throws GeneralSecurityException {
            if (cls == KeysetDeriver.class) {
                return cls.cast(com.google.crypto.tink.keyderivation.internal.KeysetDeriverWrapper.WRAPPER.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.keyderivation.KeysetDeriverConfigurationV1$1$$ExternalSyntheticLambda0
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return KeysetDeriverConfigurationV1.access$000(entry);
                    }
                }));
            }
            throw new GeneralSecurityException("KeysetDeriverConfigurationV1 can only create KeysetDeriver primitives");
        }
    }

    private static Configuration create() {
        return new AnonymousClass1();
    }

    private static PrimitiveRegistry createPrfRegistry() {
        try {
            return PrimitiveRegistry.builder().registerPrimitiveConstructor(PrimitiveConstructor.create(new KeysetDeriverConfigurationV0$$ExternalSyntheticLambda0(), HkdfPrfKey.class, StreamingPrf.class)).build();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Configuration get() throws GeneralSecurityException {
        if (TinkFipsUtil.useOnlyFips()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant KeysetDeriverConfigurationV1 in FIPS mode");
        }
        return CONFIGURATION;
    }

    private static KeyDeriver createHkdfPrfBasedKeyDeriver(PrfBasedKeyDerivationKey prfBasedKeyDerivationKey) throws GeneralSecurityException {
        KeyDeriver keyDeriverCreateWithPrfPrimitiveRegistry = PrfBasedKeyDeriver.createWithPrfPrimitiveRegistry(PRF_REGISTRY, prfBasedKeyDerivationKey);
        keyDeriverCreateWithPrfPrimitiveRegistry.deriveKey(new byte[]{1});
        return keyDeriverCreateWithPrfPrimitiveRegistry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyDeriver createKeyDeriver(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof PrfBasedKeyDerivationKey) {
            return createHkdfPrfBasedKeyDeriver((PrfBasedKeyDerivationKey) key);
        }
        throw new GeneralSecurityException("Unknown key class: " + key.getClass());
    }
}
