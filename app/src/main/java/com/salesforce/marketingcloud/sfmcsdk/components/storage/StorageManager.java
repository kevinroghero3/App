package com.salesforce.marketingcloud.sfmcsdk.components.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.salesforce.marketingcloud.sfmcsdk.components.encryption.EncryptedSharedPreferences;
import com.salesforce.marketingcloud.sfmcsdk.components.encryption.EncryptionManager;
import com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class StorageManager {
    private final Context context;
    private final EncryptionManager encryptionManager;
    private final String moduleAppId;
    private final String registrationId;

    public StorageManager(@NotNull Context context, @NotNull EncryptionManager encryptionManager, @NotNull String moduleAppId, @NotNull String registrationId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(encryptionManager, "encryptionManager");
        Intrinsics.checkNotNullParameter(moduleAppId, "moduleAppId");
        Intrinsics.checkNotNullParameter(registrationId, "registrationId");
        this.context = context;
        this.encryptionManager = encryptionManager;
        this.moduleAppId = moduleAppId;
        this.registrationId = registrationId;
    }

    public final SharedPreferences getSecurePrefs(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return EncryptedSharedPreferences.Companion.create(this.context, FileUtilsKt.getFilenameForModuleInstallation(name, this.moduleAppId, this.registrationId), this.encryptionManager.getEncryptionKey$sfmcsdk_release());
    }
}
