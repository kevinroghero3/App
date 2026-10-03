package com.salesforce.marketingcloud.sfmcsdk.modules.cdp;

import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleInterface;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface CdpModuleReadyListener extends ModuleReadyListener {
    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener
    void ready(@NotNull ModuleInterface moduleInterface);

    void ready(@NotNull CdpModuleInterface cdpModuleInterface);

    public static final class DefaultImpls {
        public static void ready(@NotNull CdpModuleReadyListener cdpModuleReadyListener, @NotNull ModuleInterface module) {
            Intrinsics.checkNotNullParameter(module, "module");
            cdpModuleReadyListener.ready((CdpModuleInterface) module);
        }
    }
}
