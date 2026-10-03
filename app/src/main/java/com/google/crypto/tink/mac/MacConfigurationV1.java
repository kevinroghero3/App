package com.google.crypto.tink.mac;

import com.google.crypto.tink.Configuration;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.mac.internal.ChunkedAesCmacImpl;
import com.google.crypto.tink.mac.internal.ChunkedHmacImpl;
import com.google.crypto.tink.subtle.PrfMac;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class MacConfigurationV1 {
    private static final int AES_CMAC_KEY_SIZE_BYTES = 32;
    private static final MacWrapper MAC_WRAPPER = new MacWrapper();
    private static final ChunkedMacWrapper CHUNKED_MAC_WRAPPER = new ChunkedMacWrapper();
    private static final Configuration CONFIGURATION = create();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ChunkedMac access$200(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createChunkedMac(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Mac access$300(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createMac(entry);
    }

    private MacConfigurationV1() {
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.mac.MacConfigurationV1$1, reason: invalid class name */
    class AnonymousClass1 implements Configuration {
        AnonymousClass1() {
        }

        @Override // com.google.crypto.tink.Configuration
        public <P> P createPrimitive(KeysetHandleInterface keysetHandleInterface, Class<P> cls) throws GeneralSecurityException {
            if (cls == Mac.class) {
                return cls.cast(MacConfigurationV1.MAC_WRAPPER.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.mac.MacConfigurationV1$1$$ExternalSyntheticLambda0
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return MacConfigurationV1.access$300(entry);
                    }
                }));
            }
            if (cls == ChunkedMac.class) {
                return cls.cast(MacConfigurationV1.CHUNKED_MAC_WRAPPER.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.mac.MacConfigurationV1$1$$ExternalSyntheticLambda1
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return MacConfigurationV1.access$200(entry);
                    }
                }));
            }
            throw new GeneralSecurityException("MacConfigurationV1 can only create MAC and ChunkedMAC");
        }
    }

    private static Configuration create() {
        return new AnonymousClass1();
    }

    public static Configuration get() throws GeneralSecurityException {
        if (TinkFipsUtil.useOnlyFips()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant MacConfigurationV1 in FIPS mode");
        }
        return CONFIGURATION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Mac createMac(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof AesCmacKey) {
            return createAesCmac((AesCmacKey) key);
        }
        if (key instanceof HmacKey) {
            return PrfMac.create((HmacKey) key);
        }
        throw new GeneralSecurityException("Unknown key class: " + key.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ChunkedMac createChunkedMac(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof AesCmacKey) {
            return createChunkedAesCmac((AesCmacKey) key);
        }
        if (key instanceof HmacKey) {
            return new ChunkedHmacImpl((HmacKey) key);
        }
        throw new GeneralSecurityException("Unknown key class: " + key.getClass());
    }

    private static ChunkedMac createChunkedAesCmac(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        if (aesCmacKey.getParameters().getKeySizeBytes() != 32) {
            throw new GeneralSecurityException("AesCmac key size is not 32 bytes");
        }
        return ChunkedAesCmacImpl.create(aesCmacKey);
    }

    private static Mac createAesCmac(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        if (aesCmacKey.getParameters().getKeySizeBytes() != 32) {
            throw new GeneralSecurityException("AesCmac key size is not 32 bytes");
        }
        return PrfMac.create(aesCmacKey);
    }
}
