package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface RemoteCall<T, U> {
    void accept(@NonNull T t, @NonNull U u) throws RemoteException;
}
