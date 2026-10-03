package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface LifecycleFragment {
    void addCallback(@NonNull String str, @NonNull LifecycleCallback lifecycleCallback);

    <T extends LifecycleCallback> T getCallbackOrNull(@NonNull String str, @NonNull Class<T> cls);

    Activity getLifecycleActivity();

    boolean isCreated();

    boolean isStarted();

    void startActivityForResult(@NonNull Intent intent, int i);
}
