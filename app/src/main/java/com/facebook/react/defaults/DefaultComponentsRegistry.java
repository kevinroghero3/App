package com.facebook.react.defaults;

import com.facebook.react.fabric.ComponentFactory;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultComponentsRegistry {
    public static final DefaultComponentsRegistry INSTANCE = new DefaultComponentsRegistry();

    @JvmStatic
    public static final native void register(@NotNull ComponentFactory componentFactory);

    private DefaultComponentsRegistry() {
    }

    static {
        DefaultSoLoader.Companion.maybeLoadSoLibrary();
    }
}
