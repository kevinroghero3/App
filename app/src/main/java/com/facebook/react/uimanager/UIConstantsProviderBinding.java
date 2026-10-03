package com.facebook.react.uimanager;

import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.soloader.SoLoader;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class UIConstantsProviderBinding {
    public static final UIConstantsProviderBinding INSTANCE = new UIConstantsProviderBinding();

    public interface ConstantsForViewManagerProvider {
        NativeMap getConstantsForViewManager(@NotNull String str);
    }

    public interface ConstantsProvider {
        NativeMap getConstants();
    }

    public interface DefaultEventTypesProvider {
        NativeMap getDefaultEventTypes();
    }

    @JvmStatic
    public static final native void install(@NotNull RuntimeExecutor runtimeExecutor, @NotNull DefaultEventTypesProvider defaultEventTypesProvider, @NotNull ConstantsForViewManagerProvider constantsForViewManagerProvider, @NotNull ConstantsProvider constantsProvider);

    private UIConstantsProviderBinding() {
    }

    static {
        SoLoader.loadLibrary("uimanagerjni");
    }
}
