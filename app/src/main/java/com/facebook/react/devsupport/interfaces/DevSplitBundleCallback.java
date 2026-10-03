package com.facebook.react.devsupport.interfaces;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface DevSplitBundleCallback {
    void onError(@Nullable String str, @Nullable Throwable th);

    void onSuccess();
}
