package com.facebook.react.fabric.events;

import com.facebook.jni.HybridClassBase;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.FabricSoLoader;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class EventEmitterWrapper extends HybridClassBase {
    private static final Companion Companion = new Companion(null);

    private final native void dispatchEvent(String str, NativeMap nativeMap, int i);

    private final native void dispatchEventSynchronously(String str, NativeMap nativeMap);

    private final native void dispatchUniqueEvent(String str, NativeMap nativeMap);

    private EventEmitterWrapper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatch(@NotNull String eventName, @Nullable WritableMap writableMap, int i) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            if (isValid()) {
                dispatchEvent(eventName, (NativeMap) writableMap, i);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchEventSynchronously(@NotNull String eventName, @Nullable WritableMap writableMap) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            if (isValid()) {
                dispatchEventSynchronously(eventName, (NativeMap) writableMap);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchUnique(@NotNull String eventName, @Nullable WritableMap writableMap) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            if (isValid()) {
                dispatchUniqueEvent(eventName, (NativeMap) writableMap);
            }
        }
    }

    public final void destroy() {
        synchronized (this) {
            if (isValid()) {
                resetNative();
            }
        }
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        FabricSoLoader.staticInit();
    }
}
