package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.hybrid.internal.LegacyFullHybridEncrypt;
import com.google.crypto.tink.hybrid.internal.WrappedHybridEncrypt;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public class HybridEncryptWrapper implements PrimitiveWrapper<HybridEncrypt, HybridEncrypt> {
    private static final HybridEncryptWrapper WRAPPER = new HybridEncryptWrapper();
    private static final PrimitiveConstructor<LegacyProtoKey, HybridEncrypt> LEGACY_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.hybrid.HybridEncryptWrapper$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return LegacyFullHybridEncrypt.create((LegacyProtoKey) key);
        }
    }, LegacyProtoKey.class, HybridEncrypt.class);

    HybridEncryptWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.internal.PrimitiveWrapper
    public HybridEncrypt wrap(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<HybridEncrypt> primitiveFactory) throws GeneralSecurityException {
        return WrappedHybridEncrypt.create(keysetHandleInterface, primitiveFactory);
    }

    @Override // com.google.crypto.tink.internal.PrimitiveWrapper
    public Class<HybridEncrypt> getPrimitiveClass() {
        return HybridEncrypt.class;
    }

    @Override // com.google.crypto.tink.internal.PrimitiveWrapper
    public Class<HybridEncrypt> getInputPrimitiveClass() {
        return HybridEncrypt.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(LEGACY_PRIMITIVE_CONSTRUCTOR);
    }

    public static void registerToInternalPrimitiveRegistry(PrimitiveRegistry.Builder builder) throws GeneralSecurityException {
        builder.registerPrimitiveWrapper(WRAPPER);
    }
}
