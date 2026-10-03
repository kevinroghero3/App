package com.swmansion.rnscreens;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderSubviewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderSubviewManagerInterface;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = ScreenStackHeaderSubviewManager.REACT_CLASS)
public final class ScreenStackHeaderSubviewManager extends ViewGroupManager<ScreenStackHeaderSubview> implements RNSScreenStackHeaderSubviewManagerInterface<ScreenStackHeaderSubview> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSScreenStackHeaderSubview";
    private final ViewManagerDelegate<ScreenStackHeaderSubview> delegate = new RNSScreenStackHeaderSubviewManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ScreenStackHeaderSubview createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ScreenStackHeaderSubview(context);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderSubviewManagerInterface
    @ReactProp(name = "type")
    public void setType(@NotNull ScreenStackHeaderSubview view, @Nullable String str) {
        ScreenStackHeaderSubview.Type type;
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        type = ScreenStackHeaderSubview.Type.CENTER;
                        view.setType(type);
                        return;
                    }
                    break;
                case 3015911:
                    if (str.equals("back")) {
                        type = ScreenStackHeaderSubview.Type.BACK;
                        view.setType(type);
                        return;
                    }
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        type = ScreenStackHeaderSubview.Type.LEFT;
                        view.setType(type);
                        return;
                    }
                    break;
                case 108511772:
                    if (str.equals(ViewProps.RIGHT)) {
                        type = ScreenStackHeaderSubview.Type.RIGHT;
                        view.setType(type);
                        return;
                    }
                    break;
                case 1778179403:
                    if (str.equals("searchBar")) {
                        type = ScreenStackHeaderSubview.Type.SEARCH_BAR;
                        view.setType(type);
                        return;
                    }
                    break;
            }
        }
        throw new JSApplicationIllegalArgumentException("Unknown type " + str);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(@NotNull ScreenStackHeaderSubview view, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        return super.updateState(view, reactStylesDiffMap, stateWrapper);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ScreenStackHeaderSubview> getDelegate() {
        return this.delegate;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
