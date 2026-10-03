package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.streamingaead.internal.LegacyFullStreamingAead;
import com.google.crypto.tink.streamingaead.internal.WrappedStreamingAead;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public class StreamingAeadWrapper implements PrimitiveWrapper<StreamingAead, StreamingAead> {
    private static final StreamingAeadWrapper WRAPPER = new StreamingAeadWrapper();
    private static final PrimitiveConstructor<LegacyProtoKey, StreamingAead> LEGACY_FULL_STREAMING_AEAD_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.streamingaead.StreamingAeadWrapper$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return LegacyFullStreamingAead.create((LegacyProtoKey) key);
        }
    }, LegacyProtoKey.class, StreamingAead.class);

    StreamingAeadWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.internal.PrimitiveWrapper
    public StreamingAead wrap(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<StreamingAead> primitiveFactory) throws GeneralSecurityException {
        return WrappedStreamingAead.wrap(keysetHandleInterface, primitiveFactory);
    }

    @Override // com.google.crypto.tink.internal.PrimitiveWrapper
    public Class<StreamingAead> getPrimitiveClass() {
        return StreamingAead.class;
    }

    @Override // com.google.crypto.tink.internal.PrimitiveWrapper
    public Class<StreamingAead> getInputPrimitiveClass() {
        return StreamingAead.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(LEGACY_FULL_STREAMING_AEAD_PRIMITIVE_CONSTRUCTOR);
    }

    public static void registerToInternalPrimitiveRegistry(PrimitiveRegistry.Builder builder) throws GeneralSecurityException {
        builder.registerPrimitiveWrapper(WRAPPER);
    }
}
