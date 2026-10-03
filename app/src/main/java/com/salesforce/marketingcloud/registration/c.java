package com.salesforce.marketingcloud.registration;

import androidx.annotation.Size;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface c {
    RegistrationManager.Editor a(@NotNull String str, @NotNull String str2, boolean z);

    RegistrationManager.Editor a(@Size(min = 1) @NotNull String str, @NotNull Map<String, String> map, boolean z);

    RegistrationManager.Editor a(@Size(min = 1) @NotNull String str, boolean z);

    RegistrationManager.Editor a(@NotNull Map<String, String> map, boolean z);
}
