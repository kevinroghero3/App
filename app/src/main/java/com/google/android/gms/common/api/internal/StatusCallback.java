package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public class StatusCallback extends IStatusCallback.Stub {
    private final BaseImplementation.ResultHolder<Status> resultHolder;

    public StatusCallback(@NonNull BaseImplementation.ResultHolder<Status> resultHolder) {
        this.resultHolder = resultHolder;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public void onResult(@NonNull Status status) {
        this.resultHolder.setResult(status);
    }
}
