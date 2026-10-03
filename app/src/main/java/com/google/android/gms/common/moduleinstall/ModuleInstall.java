package com.google.android.gms.common.moduleinstall;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.moduleinstall.internal.zay;

/* JADX INFO: loaded from: classes2.dex */
public final class ModuleInstall {
    private ModuleInstall() {
    }

    public static ModuleInstallClient getClient(@NonNull Activity activity) {
        return new zay(activity);
    }

    public static ModuleInstallClient getClient(@NonNull Context context) {
        return new zay(context);
    }
}
