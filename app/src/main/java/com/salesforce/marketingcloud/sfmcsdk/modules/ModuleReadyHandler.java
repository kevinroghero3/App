package com.salesforce.marketingcloud.sfmcsdk.modules;

import android.os.Handler;
import android.os.Looper;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ModuleReadyHandler extends Handler {
    private final ModuleReadyListener listener;

    public final ModuleReadyListener getListener() {
        return this.listener;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ModuleReadyHandler(@NotNull ModuleReadyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Looper looperMyLooper = Looper.myLooper();
        super(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper);
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deliverModule$lambda$0(ModuleReadyHandler this$0, ModuleInterface module) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(module, "$module");
        this$0.execute(module, this$0.listener);
    }

    public final void deliverModule(@NotNull final ModuleInterface module) {
        Intrinsics.checkNotNullParameter(module, "module");
        post(new Runnable() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ModuleReadyHandler.deliverModule$lambda$0(this.f$0, module);
            }
        });
    }

    private final void execute(final ModuleInterface moduleInterface, final ModuleReadyListener moduleReadyListener) {
        try {
            moduleReadyListener.ready(moduleInterface);
        } catch (Exception e) {
            SFMCSdkLogger.INSTANCE.e("~$ModuleReadyHandler", e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyHandler.execute.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Error delivering module " + moduleInterface + " to " + moduleReadyListener;
                }
            });
        }
    }
}
