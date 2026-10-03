package com.google.android.gms.dynamic;

import androidx.annotation.NonNull;
import com.google.android.gms.dynamic.LifecycleDelegate;

/* JADX INFO: loaded from: classes2.dex */
public interface OnDelegateCreatedListener<T extends LifecycleDelegate> {
    void onDelegateCreated(@NonNull T t);
}
