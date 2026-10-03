package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zacp;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ResultTransform<R extends Result, S extends Result> {
    public final PendingResult<S> createFailedResult(@NonNull Status status) {
        return new zacp(status);
    }

    public Status onFailure(@NonNull Status status) {
        return status;
    }

    public abstract PendingResult<S> onSuccess(@NonNull R r);
}
