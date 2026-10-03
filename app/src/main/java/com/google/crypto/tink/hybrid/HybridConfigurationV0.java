package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Configuration;
import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.hybrid.internal.HpkeDecrypt;
import com.google.crypto.tink.hybrid.internal.HpkeEncrypt;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridDecrypt;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridEncrypt;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class HybridConfigurationV0 {
    private static final HybridEncryptWrapper HYBRID_ENCRYPT_WRAPPER = new HybridEncryptWrapper();
    private static final HybridDecryptWrapper HYBRID_DECRYPT_WRAPPER = new HybridDecryptWrapper();
    private static final Configuration CONFIGURATION = create();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HybridDecrypt access$200(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createHybridDecrypt(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HybridEncrypt access$300(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createHybridEncrypt(entry);
    }

    private HybridConfigurationV0() {
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.HybridConfigurationV0$1, reason: invalid class name */
    class AnonymousClass1 implements Configuration {
        AnonymousClass1() {
        }

        @Override // com.google.crypto.tink.Configuration
        public <P> P createPrimitive(KeysetHandleInterface keysetHandleInterface, Class<P> cls) throws GeneralSecurityException {
            if (cls.equals(HybridEncrypt.class)) {
                return cls.cast(HybridConfigurationV0.HYBRID_ENCRYPT_WRAPPER.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.hybrid.HybridConfigurationV0$1$$ExternalSyntheticLambda0
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return HybridConfigurationV0.access$300(entry);
                    }
                }));
            }
            if (cls.equals(HybridDecrypt.class)) {
                return cls.cast(HybridConfigurationV0.HYBRID_DECRYPT_WRAPPER.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.hybrid.HybridConfigurationV0$1$$ExternalSyntheticLambda1
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return HybridConfigurationV0.access$200(entry);
                    }
                }));
            }
            throw new GeneralSecurityException("HybridConfigurationV0 can only create HybridEncrypt and HybridDecrypt primitives");
        }
    }

    private static Configuration create() {
        return new AnonymousClass1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HybridEncrypt createHybridEncrypt(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof LegacyProtoKey) {
            key = MutableSerializationRegistry.globalInstance().parseKey(((LegacyProtoKey) key).getSerialization(InsecureSecretKeyAccess.get()), InsecureSecretKeyAccess.get());
        }
        if (key instanceof EciesPublicKey) {
            return EciesAeadHkdfHybridEncrypt.create((EciesPublicKey) key);
        }
        if (key instanceof HpkePublicKey) {
            return HpkeEncrypt.create((HpkePublicKey) key);
        }
        throw new GeneralSecurityException("Unknown key class: " + key.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HybridDecrypt createHybridDecrypt(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof LegacyProtoKey) {
            key = MutableSerializationRegistry.globalInstance().parseKey(((LegacyProtoKey) key).getSerialization(InsecureSecretKeyAccess.get()), InsecureSecretKeyAccess.get());
        }
        if (key instanceof EciesPrivateKey) {
            return EciesAeadHkdfHybridDecrypt.create((EciesPrivateKey) key);
        }
        if (key instanceof HpkePrivateKey) {
            return HpkeDecrypt.create((HpkePrivateKey) key);
        }
        throw new GeneralSecurityException("Unknown key class: " + key.getClass());
    }

    public static Configuration get() throws GeneralSecurityException {
        if (TinkFipsUtil.useOnlyFips()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant HybridConfigurationV0 in FIPS mode");
        }
        return CONFIGURATION;
    }
}
