package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.common.ViewUtil;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ReactEventEmitter implements RCTModernEventEmitter {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ReactEventEmitter";
    private RCTEventEmitter defaultEventEmitter;
    private RCTModernEventEmitter fabricEventEmitter;
    private final ReactApplicationContext reactContext;

    public ReactEventEmitter(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    public final void register(int i, @Nullable RCTModernEventEmitter rCTModernEventEmitter) {
        if (i != 2) {
            throw new IllegalStateException("Check failed.");
        }
        this.fabricEventEmitter = rCTModernEventEmitter;
    }

    public final void register(int i, @Nullable RCTEventEmitter rCTEventEmitter) {
        if (i != 1) {
            throw new IllegalStateException("Check failed.");
        }
        this.defaultEventEmitter = rCTEventEmitter;
    }

    public final void unregister(int i) {
        if (i == 1) {
            this.defaultEventEmitter = null;
        } else {
            this.fabricEventEmitter = null;
        }
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    @Deprecated(message = "Please use RCTModernEventEmitter")
    public void receiveEvent(int i, @NotNull String eventName, @Nullable WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(-1, i, eventName, writableMap);
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int i, int i2, @NotNull String eventName, @Nullable WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(i, i2, eventName, false, 0, writableMap, 2);
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    @Deprecated(message = "Please use RCTModernEventEmitter")
    public void receiveTouches(@NotNull String eventName, @NotNull WritableArray touches, @NotNull WritableArray changedIndices) {
        RCTEventEmitter rCTEventEmitterEnsureDefaultEventEmitter;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(touches, "touches");
        Intrinsics.checkNotNullParameter(changedIndices, "changedIndices");
        if (touches.size() <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        ReadableMap map = touches.getMap(0);
        if (ViewUtil.getUIManagerType(map != null ? map.getInt(TouchesHelper.TARGET_KEY) : 0) != 1 || (rCTEventEmitterEnsureDefaultEventEmitter = ensureDefaultEventEmitter()) == null) {
            return;
        }
        rCTEventEmitterEnsureDefaultEventEmitter.receiveTouches(eventName, touches, changedIndices);
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    @Deprecated(message = "Please use RCTModernEventEmitter")
    public void receiveTouches(@NotNull TouchEvent event) {
        RCTModernEventEmitter rCTModernEventEmitter;
        Intrinsics.checkNotNullParameter(event, "event");
        int uIManagerType = ViewUtil.getUIManagerType(event.getViewTag(), event.getSurfaceId());
        if (uIManagerType != 1) {
            if (uIManagerType == 2 && (rCTModernEventEmitter = this.fabricEventEmitter) != null) {
                TouchesHelper.sendTouchEvent(rCTModernEventEmitter, event);
                return;
            }
            return;
        }
        RCTEventEmitter rCTEventEmitterEnsureDefaultEventEmitter = ensureDefaultEventEmitter();
        if (rCTEventEmitterEnsureDefaultEventEmitter != null) {
            TouchesHelper.sendTouchesLegacy(rCTEventEmitterEnsureDefaultEventEmitter, event);
        }
    }

    private final RCTEventEmitter ensureDefaultEventEmitter() {
        if (this.defaultEventEmitter == null) {
            if (this.reactContext.hasActiveReactInstance()) {
                this.defaultEventEmitter = (RCTEventEmitter) this.reactContext.getJSModule(RCTEventEmitter.class);
            } else {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot get RCTEventEmitter from Context, no active Catalyst instance!"));
            }
        }
        return this.defaultEventEmitter;
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int i, int i2, @NotNull String eventName, boolean z, int i3, @Nullable WritableMap writableMap, int i4) {
        RCTModernEventEmitter rCTModernEventEmitter;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        int uIManagerType = ViewUtil.getUIManagerType(i2, i);
        if (uIManagerType != 1) {
            if (uIManagerType == 2 && (rCTModernEventEmitter = this.fabricEventEmitter) != null) {
                rCTModernEventEmitter.receiveEvent(i, i2, eventName, z, i3, writableMap, i4);
                return;
            }
            return;
        }
        RCTEventEmitter rCTEventEmitterEnsureDefaultEventEmitter = ensureDefaultEventEmitter();
        if (rCTEventEmitterEnsureDefaultEventEmitter != null) {
            rCTEventEmitterEnsureDefaultEventEmitter.receiveEvent(i2, eventName, writableMap);
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
