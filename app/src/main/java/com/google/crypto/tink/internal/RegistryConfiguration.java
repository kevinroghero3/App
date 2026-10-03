package com.google.crypto.tink.internal;

import com.google.crypto.tink.Configuration;
import com.google.crypto.tink.KeysetHandleInterface;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class RegistryConfiguration {
    private static final Configuration CONFIG = new Configuration() { // from class: com.google.crypto.tink.internal.RegistryConfiguration.1
        @Override // com.google.crypto.tink.Configuration
        public <P> P createPrimitive(KeysetHandleInterface keysetHandleInterface, Class<P> cls) throws GeneralSecurityException {
            return (P) MutablePrimitiveRegistry.globalInstance().wrap(keysetHandleInterface, cls);
        }
    };

    public static Configuration get() {
        return CONFIG;
    }

    private RegistryConfiguration() {
    }
}
