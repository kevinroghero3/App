package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import com.henninghall.date_picker.props.ModeProp;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = SafeAreaViewManager.REACT_CLASS)
public final class SafeAreaViewManager extends ReactViewManager {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNCSafeAreaView";

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public SafeAreaView createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SafeAreaView(context);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public SafeAreaViewShadowNode createShadowNodeInstance() {
        return new SafeAreaViewShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public Class<SafeAreaViewShadowNode> getShadowNodeClass() {
        return SafeAreaViewShadowNode.class;
    }

    @ReactProp(name = ModeProp.name)
    public final void setMode(@NotNull SafeAreaView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Intrinsics.areEqual(str, ViewProps.PADDING)) {
            view.setMode(SafeAreaViewMode.PADDING);
        } else if (Intrinsics.areEqual(str, ViewProps.MARGIN)) {
            view.setMode(SafeAreaViewMode.MARGIN);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039  */
    /* JADX WARN: Code duplicated, block: B:18:0x0052  */
    /* JADX WARN: Code duplicated, block: B:23:0x006b  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    @ReactProp(name = "edges")
    public final void setEdges(@NotNull SafeAreaView view, @Nullable ReadableMap readableMap) {
        SafeAreaViewEdgeModes safeAreaViewEdgeModesValueOf;
        SafeAreaViewEdgeModes safeAreaViewEdgeModesValueOf2;
        SafeAreaViewEdgeModes safeAreaViewEdgeModesValueOf3;
        SafeAreaViewEdgeModes safeAreaViewEdgeModesValueOf4;
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableMap != null) {
            String string = readableMap.getString("top");
            if (string != null) {
                String upperCase = string.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                safeAreaViewEdgeModesValueOf = SafeAreaViewEdgeModes.valueOf(upperCase);
                if (safeAreaViewEdgeModesValueOf == null) {
                    safeAreaViewEdgeModesValueOf = SafeAreaViewEdgeModes.OFF;
                }
            } else {
                safeAreaViewEdgeModesValueOf = SafeAreaViewEdgeModes.OFF;
            }
            String string2 = readableMap.getString(ViewProps.RIGHT);
            if (string2 != null) {
                String upperCase2 = string2.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                safeAreaViewEdgeModesValueOf2 = SafeAreaViewEdgeModes.valueOf(upperCase2);
                if (safeAreaViewEdgeModesValueOf2 == null) {
                    safeAreaViewEdgeModesValueOf2 = SafeAreaViewEdgeModes.OFF;
                }
            } else {
                safeAreaViewEdgeModesValueOf2 = SafeAreaViewEdgeModes.OFF;
            }
            String string3 = readableMap.getString(ViewProps.BOTTOM);
            if (string3 != null) {
                String upperCase3 = string3.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
                safeAreaViewEdgeModesValueOf3 = SafeAreaViewEdgeModes.valueOf(upperCase3);
                if (safeAreaViewEdgeModesValueOf3 == null) {
                    safeAreaViewEdgeModesValueOf3 = SafeAreaViewEdgeModes.OFF;
                }
            } else {
                safeAreaViewEdgeModesValueOf3 = SafeAreaViewEdgeModes.OFF;
            }
            String string4 = readableMap.getString("left");
            if (string4 != null) {
                String upperCase4 = string4.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase4, "toUpperCase(...)");
                safeAreaViewEdgeModesValueOf4 = SafeAreaViewEdgeModes.valueOf(upperCase4);
                if (safeAreaViewEdgeModesValueOf4 == null) {
                    safeAreaViewEdgeModesValueOf4 = SafeAreaViewEdgeModes.OFF;
                }
            } else {
                safeAreaViewEdgeModesValueOf4 = SafeAreaViewEdgeModes.OFF;
            }
            view.setEdges(new SafeAreaViewEdges(safeAreaViewEdgeModesValueOf, safeAreaViewEdgeModesValueOf2, safeAreaViewEdgeModesValueOf3, safeAreaViewEdgeModesValueOf4));
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(@NotNull ReactViewGroup view, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        ((SafeAreaView) view).setStateWrapper(stateWrapper);
        return null;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
