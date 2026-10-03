package com.google.crypto.tink;

import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.proto.KeyTypeEntry;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class Config {
    public static KeyTypeEntry getTinkKeyTypeEntry(String str, String str2, String str3, int i, boolean z) {
        return KeyTypeEntry.newBuilder().setPrimitiveName(str2).setTypeUrl("type.googleapis.com/google.crypto.tink." + str3).setKeyManagerVersion(i).setNewKeyAllowed(z).setCatalogueName(str).build();
    }

    public static void register(RegistryConfig registryConfig) throws GeneralSecurityException {
        Iterator<KeyTypeEntry> it2 = registryConfig.getEntryList().iterator();
        while (it2.hasNext()) {
            registerKeyType(it2.next());
        }
    }

    public static void registerKeyType(KeyTypeEntry keyTypeEntry) throws GeneralSecurityException {
        validate(keyTypeEntry);
        if (keyTypeEntry.getCatalogueName().equals("TinkAead") || keyTypeEntry.getCatalogueName().equals("TinkMac") || keyTypeEntry.getCatalogueName().equals("TinkHybridDecrypt") || keyTypeEntry.getCatalogueName().equals("TinkHybridEncrypt") || keyTypeEntry.getCatalogueName().equals("TinkPublicKeySign") || keyTypeEntry.getCatalogueName().equals("TinkPublicKeyVerify") || keyTypeEntry.getCatalogueName().equals("TinkStreamingAead") || keyTypeEntry.getCatalogueName().equals("TinkDeterministicAead")) {
            return;
        }
        Catalogue<?> catalogue = Registry.getCatalogue(keyTypeEntry.getCatalogueName());
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(catalogue.getPrimitiveWrapper());
        Registry.registerKeyManager(catalogue.getKeyManager(keyTypeEntry.getTypeUrl(), keyTypeEntry.getPrimitiveName(), keyTypeEntry.getKeyManagerVersion()), keyTypeEntry.getNewKeyAllowed());
    }

    private static void validate(KeyTypeEntry keyTypeEntry) throws GeneralSecurityException {
        if (keyTypeEntry.getTypeUrl().isEmpty()) {
            throw new GeneralSecurityException("Missing type_url.");
        }
        if (keyTypeEntry.getPrimitiveName().isEmpty()) {
            throw new GeneralSecurityException("Missing primitive_name.");
        }
        if (keyTypeEntry.getCatalogueName().isEmpty()) {
            throw new GeneralSecurityException("Missing catalogue_name.");
        }
    }

    private Config() {
    }
}
