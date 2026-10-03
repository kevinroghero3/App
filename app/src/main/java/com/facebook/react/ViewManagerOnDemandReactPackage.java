package com.facebook.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface ViewManagerOnDemandReactPackage {
    ViewManager createViewManager(@NotNull ReactApplicationContext reactApplicationContext, @NotNull String str);

    Collection<String> getViewManagerNames(@NotNull ReactApplicationContext reactApplicationContext);
}
