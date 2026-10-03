package com.facebook.react.turbomodule.core.interfaces;

import com.facebook.jni.HybridData;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class BindingsInstallerHolder {
    private final HybridData mHybridData;

    public BindingsInstallerHolder(@NotNull HybridData mHybridData) {
        Intrinsics.checkNotNullParameter(mHybridData, "mHybridData");
        this.mHybridData = mHybridData;
    }
}
