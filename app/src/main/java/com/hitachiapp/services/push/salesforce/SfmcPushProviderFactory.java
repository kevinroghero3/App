package com.hitachiapp.services.push.salesforce;

import android.content.Context;
import com.hitachiapp.R;
import com.hitachiapp.services.push.core.ExternalPushProvider;
import com.hitachiapp.services.push.core.NoOpPushProvider;
import com.hitachiapp.services.push.core.PushProviderFactory;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class SfmcPushProviderFactory implements PushProviderFactory {
    public static final SfmcPushProviderFactory INSTANCE = new SfmcPushProviderFactory();

    private SfmcPushProviderFactory() {
    }

    @Override // com.hitachiapp.services.push.core.PushProviderFactory
    public ExternalPushProvider create(@NotNull Context context) {
        Object objM5472constructorimpl;
        Object objM5472constructorimpl2;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(Boolean.valueOf(context.getResources().getBoolean(R.bool.salesforce_enabled)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.m5478isFailureimpl(objM5472constructorimpl)) {
            objM5472constructorimpl = bool;
        }
        boolean zBooleanValue = ((Boolean) objM5472constructorimpl).booleanValue();
        try {
            Result.Companion companion3 = Result.Companion;
            Class.forName("com.salesforce.marketingcloud.sfmcsdk.SFMCSdk");
            objM5472constructorimpl2 = Result.m5472constructorimpl(Class.forName("com.salesforce.marketingcloud.messages.push.PushMessageManager"));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            objM5472constructorimpl2 = Result.m5472constructorimpl(ResultKt.createFailure(th2));
        }
        return (zBooleanValue && Result.m5479isSuccessimpl(objM5472constructorimpl2)) ? SfmcProviderManagerImpl.INSTANCE : NoOpPushProvider.INSTANCE;
    }
}
