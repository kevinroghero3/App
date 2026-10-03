package com.salesforce.marketingcloud.util;

import com.salesforce.marketingcloud.sfmcsdk.components.encryption.EncryptionManager;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Crypto {
    private final EncryptionManager a;

    public h(@Nullable EncryptionManager encryptionManager) {
        this.a = encryptionManager;
    }

    @Override // com.salesforce.marketingcloud.util.Crypto
    public String decString(@Nullable String str) {
        EncryptionManager encryptionManager;
        if (str == null || (encryptionManager = this.a) == null) {
            return null;
        }
        return encryptionManager.decrypt(str);
    }

    @Override // com.salesforce.marketingcloud.util.Crypto
    public String encString(@Nullable String str) {
        EncryptionManager encryptionManager;
        if (str == null || (encryptionManager = this.a) == null) {
            return null;
        }
        return encryptionManager.encrypt(str);
    }
}
