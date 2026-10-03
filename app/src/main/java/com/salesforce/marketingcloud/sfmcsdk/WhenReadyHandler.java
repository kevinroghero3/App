package com.salesforce.marketingcloud.sfmcsdk;

import android.os.Handler;
import android.os.Looper;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class WhenReadyHandler extends Handler {
    private final SFMCSdkReadyListener listener;

    public final SFMCSdkReadyListener getListener() {
        return this.listener;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WhenReadyHandler(@NotNull SFMCSdkReadyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Looper looperMyLooper = Looper.myLooper();
        super(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper);
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deliverSdk$lambda$0(WhenReadyHandler this$0, SFMCSdk sdk) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sdk, "$sdk");
        this$0.execute(sdk, this$0.listener);
    }

    public final void deliverSdk(@NotNull final SFMCSdk sdk) {
        Intrinsics.checkNotNullParameter(sdk, "sdk");
        post(new Runnable() { // from class: com.salesforce.marketingcloud.sfmcsdk.WhenReadyHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WhenReadyHandler.deliverSdk$lambda$0(this.f$0, sdk);
            }
        });
    }

    private final void execute(SFMCSdk sFMCSdk, final SFMCSdkReadyListener sFMCSdkReadyListener) {
        try {
            sFMCSdkReadyListener.ready(sFMCSdk);
        } catch (Exception e) {
            SFMCSdkLogger.INSTANCE.e("~$WhenReadyHandler", e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.WhenReadyHandler.execute.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Error in " + sFMCSdkReadyListener.getClass().getName();
                }
            });
        }
    }
}
