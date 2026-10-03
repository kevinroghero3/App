package com.hitachiapp.services.push.core;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface PushProviderFactory {
    ExternalPushProvider create(@NotNull Context context);
}
