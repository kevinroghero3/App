package com.swmansion.rnscreens.gamma.common;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseEventEmitter {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BaseEventEmitter";
    private final ReactContext reactContext;
    private final EventDispatcher reactEventDispatcher;
    private final int viewTag;

    public BaseEventEmitter(@NotNull ReactContext reactContext, int i) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.viewTag = i;
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, i);
        if (eventDispatcherForReactTag != null) {
            this.reactEventDispatcher = eventDispatcherForReactTag;
            return;
        }
        throw new IllegalStateException(("[RNScreens] Nullish event dispatcher for view with tag: " + i).toString());
    }

    public final ReactContext getReactContext() {
        return this.reactContext;
    }

    public final int getViewTag() {
        return this.viewTag;
    }

    public final EventDispatcher getReactEventDispatcher() {
        return this.reactEventDispatcher;
    }

    public final int getSurfaceId() {
        return UIManagerHelper.getSurfaceId(this.reactContext);
    }

    public static final class Companion {
        public static int a;
        public static int b;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static int c() {
            int i = a;
            int i2 = i % 5609021;
            a = i + 1;
            if (i2 != 0) {
                return b;
            }
            int i3 = (int) Runtime.getRuntime().totalMemory();
            b = i3;
            return i3;
        }
    }
}
