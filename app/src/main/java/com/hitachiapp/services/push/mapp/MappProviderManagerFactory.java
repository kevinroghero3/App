package com.hitachiapp.services.push.mapp;

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
public final class MappProviderManagerFactory implements PushProviderFactory {
    public static final MappProviderManagerFactory INSTANCE = new MappProviderManagerFactory();

    private MappProviderManagerFactory() {
    }

    @Override // com.hitachiapp.services.push.core.PushProviderFactory
    public ExternalPushProvider create(@NotNull Context context) {
        Object objM5472constructorimpl;
        Object objM5472constructorimpl2;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(Boolean.valueOf(context.getResources().getBoolean(R.bool.mapp_enabled)));
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
            objM5472constructorimpl2 = Result.m5472constructorimpl(Class.forName("com.appoxee.Appoxee"));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            objM5472constructorimpl2 = Result.m5472constructorimpl(ResultKt.createFailure(th2));
        }
        return (zBooleanValue && Result.m5479isSuccessimpl(objM5472constructorimpl2)) ? MappProviderManagerImpl.INSTANCE : NoOpPushProvider.INSTANCE;
    }
}
