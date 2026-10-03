package com.facebook.react.devsupport.interfaces;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface DevBundleDownloadListener {
    void onFailure(@Nullable Exception exc);

    void onProgress(@Nullable String str, @Nullable Integer num, @Nullable Integer num2);

    void onSuccess();
}
