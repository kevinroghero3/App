package com.salesforce.marketingcloud.sfmcsdk;

import android.content.Context;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.Identity;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import com.salesforce.marketingcloud.sfmcsdk.modules.Config;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleInterface;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModule;
import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
final class SFMCSdk$Companion$configure$1$3$2$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SFMCSdkComponents $components;
    final /* synthetic */ Config $config;
    final /* synthetic */ Context $context;
    final /* synthetic */ CountDownLatch $moduleInitLatch;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SFMCSdk$Companion$configure$1$3$2$3(Context context, Config config, SFMCSdkComponents sFMCSdkComponents, CountDownLatch countDownLatch) {
        super(0);
        this.$context = context;
        this.$config = config;
        this.$components = sFMCSdkComponents;
        this.$moduleInitLatch = countDownLatch;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        PushModule pushModule$sfmcsdk_release = SFMCSdk.Companion.getPushModule$sfmcsdk_release();
        Context context = this.$context;
        final Config config = this.$config;
        SFMCSdkComponents sFMCSdkComponents = this.$components;
        final CountDownLatch countDownLatch = this.$moduleInitLatch;
        pushModule$sfmcsdk_release.initModule(context, config, sFMCSdkComponents, new ModuleReadyListener() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$configure$1$3$2$3$$ExternalSyntheticLambda0
            @Override // com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener
            public final void ready(ModuleInterface moduleInterface) {
                SFMCSdk$Companion$configure$1$3$2$3.invoke$lambda$1(countDownLatch, config, moduleInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(CountDownLatch moduleInitLatch, final Config config, ModuleInterface module) {
        Intrinsics.checkNotNullParameter(moduleInitLatch, "$moduleInitLatch");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(module, "module");
        moduleInitLatch.countDown();
        Unit unit = Unit.INSTANCE;
        Identity.Companion.getInstance().setModuleIdentity$sfmcsdk_release(module.getModuleIdentity());
        SFMCSdkLogger.INSTANCE.d("~$SFMCSdk", new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$configure$1$3$2$3$1$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Module (" + config.getModuleIdentifier() + ") has completed initialization.";
            }
        });
    }
}
