package com.swmansion.rnscreens;

import com.facebook.react.fabric.FabricUIManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeProxy {
    public static final Companion Companion = new Companion(null);

    public final void invalidateNative() {
    }

    public final void nativeAddMutationsListener(@NotNull FabricUIManager fabricUIManager) {
        Intrinsics.checkNotNullParameter(fabricUIManager, "fabricUIManager");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void addScreenToMap(int i, @NotNull Screen view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public final void clearMapOnInvalidate() {
        }

        public final void removeScreenFromMap(int i) {
        }

        private Companion() {
        }
    }
}
