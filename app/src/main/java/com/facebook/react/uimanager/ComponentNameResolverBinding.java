package com.facebook.react.uimanager;

import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.soloader.SoLoader;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ComponentNameResolverBinding {
    public static final ComponentNameResolverBinding INSTANCE = new ComponentNameResolverBinding();

    @JvmStatic
    public static final native void install(@NotNull RuntimeExecutor runtimeExecutor, @NotNull Object obj);

    private ComponentNameResolverBinding() {
    }

    static {
        SoLoader.loadLibrary("uimanagerjni");
    }
}
