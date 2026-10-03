package com.swmansion.rnscreens;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ScreenContentWrapper extends ReactViewGroup {
    private OnLayoutCallback delegate;

    public interface OnLayoutCallback {
        void onContentWrapperLayout(boolean z, int i, int i2, int i3, int i4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenContentWrapper(@NotNull ReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    public final OnLayoutCallback getDelegate$react_native_screens_release() {
        return this.delegate;
    }

    public final void setDelegate$react_native_screens_release(@Nullable OnLayoutCallback onLayoutCallback) {
        this.delegate = onLayoutCallback;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        OnLayoutCallback onLayoutCallback = this.delegate;
        if (onLayoutCallback != null) {
            onLayoutCallback.onContentWrapperLayout(z, i, i2, i3, i4);
        }
    }
}
