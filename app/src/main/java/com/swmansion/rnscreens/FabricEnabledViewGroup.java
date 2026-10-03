package com.swmansion.rnscreens;

import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.StateWrapper;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class FabricEnabledViewGroup extends ViewGroup {
    public final void setStateWrapper(@Nullable StateWrapper stateWrapper) {
    }

    protected final void updateScreenSizeFabric(int i, int i2, int i3) {
    }

    public FabricEnabledViewGroup(@Nullable ReactContext reactContext) {
        super(reactContext);
    }
}
