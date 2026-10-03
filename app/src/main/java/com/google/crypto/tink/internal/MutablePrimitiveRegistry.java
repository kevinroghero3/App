package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeysetHandleInterface;
import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class MutablePrimitiveRegistry {
    private static MutablePrimitiveRegistry globalInstance = new MutablePrimitiveRegistry();
    private final AtomicReference<PrimitiveRegistry> registry = new AtomicReference<>(PrimitiveRegistry.builder().build());

    public static MutablePrimitiveRegistry globalInstance() {
        return globalInstance;
    }

    public static void resetGlobalInstanceTestOnly() {
        globalInstance = new MutablePrimitiveRegistry();
    }

    MutablePrimitiveRegistry() {
    }

    public <KeyT extends Key, PrimitiveT> void registerPrimitiveConstructor(PrimitiveConstructor<KeyT, PrimitiveT> primitiveConstructor) throws GeneralSecurityException {
        synchronized (this) {
            this.registry.set(PrimitiveRegistry.builder(this.registry.get()).registerPrimitiveConstructor(primitiveConstructor).build());
        }
    }

    public <InputPrimitiveT, WrapperPrimitiveT> void registerPrimitiveWrapper(PrimitiveWrapper<InputPrimitiveT, WrapperPrimitiveT> primitiveWrapper) throws GeneralSecurityException {
        synchronized (this) {
            this.registry.set(PrimitiveRegistry.builder(this.registry.get()).registerPrimitiveWrapper(primitiveWrapper).build());
        }
    }

    public <KeyT extends Key, PrimitiveT> PrimitiveT getPrimitive(KeyT keyt, Class<PrimitiveT> cls) throws GeneralSecurityException {
        return (PrimitiveT) this.registry.get().getPrimitive(keyt, cls);
    }

    public <WrapperPrimitiveT> WrapperPrimitiveT wrap(KeysetHandleInterface keysetHandleInterface, Class<WrapperPrimitiveT> cls) throws GeneralSecurityException {
        return (WrapperPrimitiveT) this.registry.get().wrap(keysetHandleInterface, cls);
    }
}
