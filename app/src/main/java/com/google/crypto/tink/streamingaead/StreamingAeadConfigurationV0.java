package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.Configuration;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.subtle.AesCtrHmacStreaming;
import com.google.crypto.tink.subtle.AesGcmHkdfStreaming;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class StreamingAeadConfigurationV0 {
    private static final StreamingAeadWrapper STREAMING_AEAD_WRAPPER = new StreamingAeadWrapper();
    private static final Configuration CONFIGURATION = create();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ StreamingAead access$100(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createStreamingAead(entry);
    }

    private StreamingAeadConfigurationV0() {
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.streamingaead.StreamingAeadConfigurationV0$1, reason: invalid class name */
    class AnonymousClass1 implements Configuration {
        AnonymousClass1() {
        }

        @Override // com.google.crypto.tink.Configuration
        public <P> P createPrimitive(KeysetHandleInterface keysetHandleInterface, Class<P> cls) throws GeneralSecurityException {
            if (cls == StreamingAead.class) {
                return cls.cast(StreamingAeadConfigurationV0.STREAMING_AEAD_WRAPPER.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.streamingaead.StreamingAeadConfigurationV0$1$$ExternalSyntheticLambda0
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return StreamingAeadConfigurationV0.access$100(entry);
                    }
                }));
            }
            throw new GeneralSecurityException("StreamingAeadConfigurationV0 can only create StreamingAead");
        }
    }

    private static Configuration create() {
        return new AnonymousClass1();
    }

    public static Configuration get() throws GeneralSecurityException {
        if (TinkFipsUtil.useOnlyFips()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant StreamingAead in FIPS mode");
        }
        return CONFIGURATION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StreamingAead createStreamingAead(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof LegacyProtoKey) {
            key = MutableSerializationRegistry.globalInstance().parseKey(((LegacyProtoKey) key).getSerialization(InsecureSecretKeyAccess.get()), InsecureSecretKeyAccess.get());
        }
        if (key instanceof AesGcmHkdfStreamingKey) {
            return AesGcmHkdfStreaming.create((AesGcmHkdfStreamingKey) key);
        }
        if (key instanceof AesCtrHmacStreamingKey) {
            return AesCtrHmacStreaming.create((AesCtrHmacStreamingKey) key);
        }
        throw new GeneralSecurityException("Unknown key class: " + key.getClass());
    }
}
