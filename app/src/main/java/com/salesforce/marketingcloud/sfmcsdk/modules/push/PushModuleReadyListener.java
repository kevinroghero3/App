package com.salesforce.marketingcloud.sfmcsdk.modules.push;

import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleInterface;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface PushModuleReadyListener extends ModuleReadyListener {
    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener
    void ready(@NotNull ModuleInterface moduleInterface);

    void ready(@NotNull PushModuleInterface pushModuleInterface);

    public static final class DefaultImpls {
        public static void ready(@NotNull PushModuleReadyListener pushModuleReadyListener, @NotNull ModuleInterface module) {
            Intrinsics.checkNotNullParameter(module, "module");
            pushModuleReadyListener.ready((PushModuleInterface) module);
        }
    }
}
