package com.hitachiapp.services.push.bootstrap;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class NoOpPushSdkBootstrap implements PushSdkBootstrap {
    public static final NoOpPushSdkBootstrap INSTANCE = new NoOpPushSdkBootstrap();
    private static final String name = "NO_OP";

    @Override // com.hitachiapp.services.push.bootstrap.PushSdkBootstrap
    public void init(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
    }

    private NoOpPushSdkBootstrap() {
    }

    @Override // com.hitachiapp.services.push.bootstrap.PushSdkBootstrap
    public String getName() {
        return name;
    }
}
