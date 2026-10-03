package com.facebook.react.devsupport.interfaces;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface BundleLoadCallback {
    default void onError(@NotNull Exception cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
    }

    void onSuccess();
}
