package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.StateWrapper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class MountItemFactory {
    public static final MountItemFactory INSTANCE = new MountItemFactory();

    private MountItemFactory() {
    }

    @JvmStatic
    public static final DispatchCommandMountItem createDispatchCommandMountItem(int i, int i2, int i3, @Nullable ReadableArray readableArray) {
        return new DispatchIntCommandMountItem(i, i2, i3, readableArray);
    }

    @JvmStatic
    public static final DispatchCommandMountItem createDispatchCommandMountItem(int i, int i2, @NotNull String commandId, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        return new DispatchStringCommandMountItem(i, i2, commandId, readableArray);
    }

    @JvmStatic
    public static final MountItem createSendAccessibilityEventMountItem(int i, int i2, int i3) {
        return new SendAccessibilityEventMountItem(i, i2, i3);
    }

    @JvmStatic
    public static final MountItem createPreAllocateViewMountItem(int i, int i2, @NotNull String component, @Nullable ReadableMap readableMap, @Nullable StateWrapper stateWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(component, "component");
        return new PreAllocateViewMountItem(i, i2, component, readableMap, stateWrapper, z);
    }

    @JvmStatic
    public static final MountItem createDestroyViewMountItem(int i, int i2) {
        return new DestroyUnmountedViewMountItem(i, i2);
    }

    @JvmStatic
    public static final MountItem createIntBufferBatchMountItem(int i, @NotNull int[] intBuf, @NotNull Object[] objBuf, int i2) {
        Intrinsics.checkNotNullParameter(intBuf, "intBuf");
        Intrinsics.checkNotNullParameter(objBuf, "objBuf");
        return new IntBufferBatchMountItem(i, intBuf, objBuf, i2);
    }
}
