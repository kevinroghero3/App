package com.hitachiapp.services.push.mapp;

import android.app.Application;
import com.hitachiapp.services.push.bootstrap.PushSdkBootstrap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

/* JADX INFO: loaded from: classes.dex */
public final class MappPushSdkBootstrap implements PushSdkBootstrap {
    public static final MappPushSdkBootstrap INSTANCE = new MappPushSdkBootstrap();
    private static final String name = "MappBootstrap";

    private MappPushSdkBootstrap() {
    }

    @Override // com.hitachiapp.services.push.bootstrap.PushSdkBootstrap
    public String getName() {
        return name;
    }

    @Override // com.hitachiapp.services.push.bootstrap.PushSdkBootstrap
    public void init(@NotNull Application app2) {
        Object objM5472constructorimpl;
        Intrinsics.checkNotNullParameter(app2, "app");
        Timber.tag(getName()).d("MappPushSdkBootstrap.init invoked...", new Object[0]);
        try {
            Result.Companion companion = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(Class.forName("com.appoxee.Appoxee").getMethod("engage", Application.class).invoke(null, app2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m5479isSuccessimpl(objM5472constructorimpl)) {
            Timber.tag(INSTANCE.getName()).d("Mapp SDK initialized", new Object[0]);
        }
        Throwable thM5475exceptionOrNullimpl = Result.m5475exceptionOrNullimpl(objM5472constructorimpl);
        if (thM5475exceptionOrNullimpl != null) {
            Timber.tag(INSTANCE.getName()).d("Mapp init skipped: " + thM5475exceptionOrNullimpl.getMessage(), new Object[0]);
        }
    }
}
