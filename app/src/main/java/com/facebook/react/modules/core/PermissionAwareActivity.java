package com.facebook.react.modules.core;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface PermissionAwareActivity {
    int checkPermission(@NotNull String str, int i, int i2);

    int checkSelfPermission(@NotNull String str);

    void requestPermissions(@NotNull String[] strArr, int i, @Nullable PermissionListener permissionListener);

    boolean shouldShowRequestPermissionRationale(@NotNull String str);
}
