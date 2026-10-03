package com.salesforce.marketingcloud.sfmcsdk.modules;

import android.content.Context;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface Config {
    int getMAX_SUPPORTED_VERSION();

    String getModuleApplicationId();

    ModuleIdentifier getModuleIdentifier();

    int getVersion();

    void init(@NotNull Context context, @NotNull SFMCSdkComponents sFMCSdkComponents, @NotNull ModuleReadyListener moduleReadyListener);

    boolean isModuleCompatible();

    public static final class DefaultImpls {
        public static int getMAX_SUPPORTED_VERSION(@NotNull Config config) {
            return 1;
        }

        public static /* synthetic */ void getMAX_SUPPORTED_VERSION$annotations() {
        }

        public static boolean isModuleCompatible(@NotNull Config config) {
            return config.getVersion() <= config.getMAX_SUPPORTED_VERSION();
        }
    }
}
