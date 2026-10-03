package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class ExecutorSelector {
    private final Provider zza;

    public ExecutorSelector(@NonNull Provider provider) {
        this.zza = provider;
    }

    public Executor getExecutorToUse(@Nullable Executor executor) {
        return executor != null ? executor : (Executor) this.zza.get();
    }
}
