package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ActivityLifecycleObserver {
    public static final ActivityLifecycleObserver of(@NonNull Activity activity) {
        return new zab(zaa.zaa(activity));
    }

    public abstract ActivityLifecycleObserver onStopCallOnce(@NonNull Runnable runnable);
}
