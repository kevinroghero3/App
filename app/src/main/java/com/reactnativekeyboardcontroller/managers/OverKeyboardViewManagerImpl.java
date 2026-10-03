package com.reactnativekeyboardcontroller.managers;

import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.views.overlay.OverKeyboardHostView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class OverKeyboardViewManagerImpl {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "OverKeyboardView";

    public final OverKeyboardHostView createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new OverKeyboardHostView(reactContext);
    }

    public final void setVisible(@NotNull OverKeyboardHostView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (z) {
            view.show();
        } else {
            view.hide();
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
