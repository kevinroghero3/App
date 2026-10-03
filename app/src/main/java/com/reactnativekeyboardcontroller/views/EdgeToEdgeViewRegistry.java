package com.reactnativekeyboardcontroller.views;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class EdgeToEdgeViewRegistry {
    public static final EdgeToEdgeViewRegistry INSTANCE = new EdgeToEdgeViewRegistry();
    private static WeakReference<EdgeToEdgeReactViewGroup> lastCreatedView;

    private EdgeToEdgeViewRegistry() {
    }

    public final void register(@NotNull EdgeToEdgeReactViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        lastCreatedView = new WeakReference<>(view);
    }

    public final EdgeToEdgeReactViewGroup get() {
        WeakReference<EdgeToEdgeReactViewGroup> weakReference = lastCreatedView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
