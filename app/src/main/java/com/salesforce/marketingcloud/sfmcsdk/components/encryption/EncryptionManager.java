package com.salesforce.marketingcloud.sfmcsdk.components.encryption;

import android.content.Context;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class EncryptionManager {
    private final String encryptionKey;

    public EncryptionManager(@NotNull Context context, @NotNull String moduleApplicationId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moduleApplicationId, "moduleApplicationId");
        String encryptionKey = new SalesforceKeyGenerator(context, new KeyStoreWrapper(context)).getEncryptionKey(moduleApplicationId);
        Intrinsics.checkNotNullExpressionValue(encryptionKey, "getEncryptionKey(...)");
        this.encryptionKey = encryptionKey;
    }

    public final String getEncryptionKey$sfmcsdk_release() {
        return this.encryptionKey;
    }

    public final byte[] generateIV() throws NoSuchAlgorithmException {
        byte[] bArrGenerateInitVector = Encryptor.generateInitVector();
        Intrinsics.checkNotNullExpressionValue(bArrGenerateInitVector, "generateInitVector(...)");
        return bArrGenerateInitVector;
    }

    public final String encrypt(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Encryptor.encrypt(data, this.encryptionKey);
    }

    public final String encrypt(@NotNull String data, @NotNull byte[] iv) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(iv, "iv");
        return Encryptor.encrypt(data, this.encryptionKey, iv);
    }

    public final String decrypt(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Encryptor.decrypt(data, this.encryptionKey);
    }
}
