package com.google.android.gms.common.moduleinstall;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.tasks.Task;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* JADX INFO: loaded from: classes2.dex */
public interface ModuleInstallClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    Task<ModuleAvailabilityResponse> areModulesAvailable(@NonNull OptionalModuleApi... optionalModuleApiArr);

    Task<Void> deferredInstall(@NonNull OptionalModuleApi... optionalModuleApiArr);

    Task<ModuleInstallIntentResponse> getInstallModulesIntent(@NonNull OptionalModuleApi... optionalModuleApiArr);

    @ResultIgnorabilityUnspecified
    Task<ModuleInstallResponse> installModules(@NonNull ModuleInstallRequest moduleInstallRequest);

    Task<Void> releaseModules(@NonNull OptionalModuleApi... optionalModuleApiArr);

    @ResultIgnorabilityUnspecified
    Task<Boolean> unregisterListener(@NonNull InstallStatusListener installStatusListener);
}
