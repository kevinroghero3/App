package com.facebook.react.fabric;

import com.facebook.jni.HybridClassBase;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.RuntimeScheduler;
import com.facebook.react.common.mapbuffer.MapBufferSoLoader;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.uimanager.PixelUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class FabricUIManagerBinding extends HybridClassBase {
    private static final Companion Companion = new Companion(null);

    private final native void initHybrid();

    private final native void installFabricUIManager(RuntimeExecutor runtimeExecutor, RuntimeScheduler runtimeScheduler, FabricUIManager fabricUIManager, EventBeatManager eventBeatManager, ComponentFactory componentFactory);

    private final native void uninstallFabricUIManager();

    public final native void drainPreallocateViewsQueue();

    public final native void driveCxxAnimations();

    public final native void reportMount(int i);

    public final native void setConstraints(int i, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2);

    public final native void setPixelDensity(float f);

    public final native void startSurface(int i, @NotNull String str, @NotNull NativeMap nativeMap);

    public final native void startSurfaceWithConstraints(int i, @NotNull String str, @NotNull NativeMap nativeMap, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2);

    public final native void startSurfaceWithSurfaceHandler(int i, @NotNull SurfaceHandlerBinding surfaceHandlerBinding, boolean z);

    public final native void stopSurface(int i);

    public final native void stopSurfaceWithSurfaceHandler(@NotNull SurfaceHandlerBinding surfaceHandlerBinding);

    public FabricUIManagerBinding() {
        initHybrid();
    }

    public final void register(@NotNull RuntimeExecutor runtimeExecutor, @NotNull RuntimeScheduler runtimeScheduler, @NotNull FabricUIManager fabricUIManager, @NotNull EventBeatManager eventBeatManager, @NotNull ComponentFactory componentFactory) {
        Intrinsics.checkNotNullParameter(runtimeExecutor, "runtimeExecutor");
        Intrinsics.checkNotNullParameter(runtimeScheduler, "runtimeScheduler");
        Intrinsics.checkNotNullParameter(fabricUIManager, "fabricUIManager");
        Intrinsics.checkNotNullParameter(eventBeatManager, "eventBeatManager");
        Intrinsics.checkNotNullParameter(componentFactory, "componentFactory");
        fabricUIManager.setBinding(this);
        installFabricUIManager(runtimeExecutor, runtimeScheduler, fabricUIManager, eventBeatManager, componentFactory);
        setPixelDensity(PixelUtil.getDisplayMetricDensity());
    }

    public final void unregister() {
        uninstallFabricUIManager();
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
        MapBufferSoLoader.staticInit();
    }
}
