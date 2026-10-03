package com.hitachiapp.services.push.bootstrap;

import android.app.Application;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface PushSdkBootstrap {
    String getName();

    void init(@NotNull Application application);
}
