package com.swmansion.rnscreens;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerModule;
import com.swmansion.rnscreens.utils.PaddingBundle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FabricEnabledHeaderConfigViewGroup extends ViewGroup {
    public static final Companion Companion = new Companion(null);
    private static final double DELTA = 0.9d;
    private int lastHeight;
    private int lastPaddingEnd;
    private int lastPaddingStart;

    public final void setStateWrapper(@Nullable StateWrapper stateWrapper) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FabricEnabledHeaderConfigViewGroup(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void updateHeaderConfigState(int i, int i2, int i3, int i4) {
        updateState(i, i2, i3, i4);
    }

    private final void updateState(int i, int i2, int i3, int i4) {
        if (Math.abs(this.lastPaddingStart - i3) >= DELTA || Math.abs(this.lastPaddingEnd - i4) >= DELTA || Math.abs(this.lastHeight - i2) >= DELTA) {
            this.lastPaddingStart = i3;
            this.lastPaddingEnd = i4;
            this.lastHeight = i2;
            Context context = getContext();
            ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
            UIManagerModule uIManagerModule = reactContext != null ? (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class) : null;
            if (uIManagerModule != null) {
                uIManagerModule.setViewLocalData(getId(), new PaddingBundle(i2, i3, i4));
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
