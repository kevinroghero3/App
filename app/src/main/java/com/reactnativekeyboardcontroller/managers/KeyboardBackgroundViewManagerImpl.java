package com.reactnativekeyboardcontroller.managers;

import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.views.background.KeyboardBackgroundViewGroup;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class KeyboardBackgroundViewManagerImpl {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "KeyboardBackgroundView";

    public final KeyboardBackgroundViewGroup createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new KeyboardBackgroundViewGroup(reactContext);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
