package com.facebook.react.views.scroll;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@ReactModule(name = ReactHorizontalScrollContainerViewManager.REACT_CLASS)
public final class ReactHorizontalScrollContainerViewManager extends ReactViewManager {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "AndroidHorizontalScrollContentView";
    private static Integer uiManagerType;

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactViewGroup createViewInstance(int i, @NotNull ThemedReactContext context, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uiManagerType != null) {
            throw new IllegalStateException("Check failed.");
        }
        uiManagerType = Integer.valueOf(ViewUtil.getUIManagerType(i));
        View viewCreateViewInstance = super.createViewInstance(i, context, reactStylesDiffMap, stateWrapper);
        Intrinsics.checkNotNullExpressionValue(viewCreateViewInstance, "createViewInstance(...)");
        ReactViewGroup reactViewGroup = (ReactViewGroup) viewCreateViewInstance;
        uiManagerType = null;
        return reactViewGroup;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public ReactViewGroup createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = uiManagerType;
        if (num == null) {
            throw new IllegalStateException("Required value was null.");
        }
        if (num.intValue() == 2) {
            return new ReactViewGroup(context);
        }
        return new ReactHorizontalScrollContainerLegacyView(context);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static /* synthetic */ void getUiManagerType$annotations() {
        }

        private Companion() {
        }
    }
}
