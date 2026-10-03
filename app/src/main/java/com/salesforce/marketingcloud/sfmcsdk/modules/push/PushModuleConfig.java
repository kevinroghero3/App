package com.salesforce.marketingcloud.sfmcsdk.modules.push;

import com.salesforce.marketingcloud.sfmcsdk.modules.Config;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleIdentifier;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class PushModuleConfig implements Config {
    private final String moduleApplicationId;
    private final ModuleIdentifier moduleIdentifier;
    private final int version;

    public PushModuleConfig(@NotNull String moduleApplicationId) {
        Intrinsics.checkNotNullParameter(moduleApplicationId, "moduleApplicationId");
        this.moduleApplicationId = moduleApplicationId;
        this.moduleIdentifier = ModuleIdentifier.PUSH;
        this.version = 1;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.Config
    public int getMAX_SUPPORTED_VERSION() {
        return Config.DefaultImpls.getMAX_SUPPORTED_VERSION(this);
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.Config
    public boolean isModuleCompatible() {
        return Config.DefaultImpls.isModuleCompatible(this);
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.Config
    public String getModuleApplicationId() {
        return this.moduleApplicationId;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.Config
    public ModuleIdentifier getModuleIdentifier() {
        return this.moduleIdentifier;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.Config
    public int getVersion() {
        return this.version;
    }
}
