package com.facebook.react.reactperflogger;

import com.facebook.jni.HybridData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NativeModulePerfLogger {
    private final HybridData mHybridData;

    private static /* synthetic */ void getMHybridData$annotations() {
    }

    protected abstract HybridData initHybrid();

    public abstract void moduleCreateCacheHit(@NotNull String str, int i);

    public abstract void moduleCreateConstructEnd(@NotNull String str, int i);

    public abstract void moduleCreateConstructStart(@NotNull String str, int i);

    public abstract void moduleCreateEnd(@NotNull String str, int i);

    public abstract void moduleCreateFail(@NotNull String str, int i);

    public abstract void moduleCreateSetUpEnd(@NotNull String str, int i);

    public abstract void moduleCreateSetUpStart(@NotNull String str, int i);

    public abstract void moduleCreateStart(@NotNull String str, int i);

    public abstract void moduleDataCreateEnd(@NotNull String str, int i);

    public abstract void moduleDataCreateStart(@NotNull String str, int i);

    protected NativeModulePerfLogger() {
        maybeLoadOtherSoLibraries();
        this.mHybridData = initHybrid();
    }

    protected final void maybeLoadOtherSoLibraries() {
        synchronized (this) {
        }
    }
}
