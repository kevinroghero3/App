package com.facebook.react.internal.turbomodule.core.interfaces;

import com.facebook.react.bridge.NativeModule;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface TurboModuleRegistry {
    List<String> getEagerInitModuleNames();

    NativeModule getModule(@NotNull String str);

    Collection<NativeModule> getModules();

    boolean hasModule(@NotNull String str);

    void invalidate();
}
