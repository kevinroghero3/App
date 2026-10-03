package com.swmansion.rnscreens.gamma.tabs;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSBottomTabsManagerDelegate;
import com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface;
import com.swmansion.rnscreens.gamma.helpers.EventHelpersKt;
import com.swmansion.rnscreens.gamma.tabs.event.TabsHostNativeFocusChangeEvent;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = TabsHostViewManager.REACT_CLASS)
public final class TabsHostViewManager extends ViewGroupManager<TabsHost> implements RNSBottomTabsManagerInterface<TabsHost> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSBottomTabs";
    private final ViewManagerDelegate<TabsHost> delegate = new RNSBottomTabsManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    public void setControlNavigationStateInJS(@Nullable TabsHost tabsHost, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    public void setTabBarBlurEffect(@Nullable TabsHost tabsHost, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    public void setTabBarItemBadgeBackgroundColor(@NotNull TabsHost view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    public void setTabBarItemTitlePositionAdjustment(@Nullable TabsHost tabsHost, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    public void setTabBarTintColor(@NotNull TabsHost view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public TabsHost createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new TabsHost(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<TabsHost> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull TabsHost parent, @NotNull View child, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!(child instanceof TabScreen)) {
            throw new IllegalArgumentException("[RNScreens] Attempt to attach child that is not of type javaClass");
        }
        parent.mountReactSubviewAt$react_native_screens_release((TabScreen) child, i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(@NotNull TabsHost parent, @NotNull View child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!(child instanceof TabScreen)) {
            throw new IllegalArgumentException("[RNScreens] Attempt to detach child that is not of type javaClass");
        }
        parent.unmountReactSubview$react_native_screens_release((TabScreen) child);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(@NotNull TabsHost parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.unmountReactSubviewAt$react_native_screens_release(i);
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(@NotNull TabsHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.unmountAllReactSubviews$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt__MapsKt.mutableMapOf(EventHelpersKt.makeEventRegistrationInfo(TabsHostNativeFocusChangeEvent.Companion));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(@NotNull ThemedReactContext reactContext, @NotNull TabsHost view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        super.addEventEmitters(reactContext, view);
        view.onViewManagerAddEventEmitters$react_native_screens_release();
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    @ReactProp(customType = "Color", name = "tabBarBackgroundColor")
    public void setTabBarBackgroundColor(@NotNull TabsHost view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabBarBackgroundColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    @ReactProp(name = "tabBarItemTitleFontSize")
    public void setTabBarItemTitleFontSize(@Nullable TabsHost tabsHost, float f) {
        if (tabsHost != null) {
            tabsHost.setTabBarItemTitleFontSize(Float.valueOf(f));
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    public void setTabBarItemTitleFontFamily(@NotNull TabsHost view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabBarItemTitleFontFamily(str);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    public void setTabBarItemTitleFontWeight(@NotNull TabsHost view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabBarItemTitleFontWeight(str);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    public void setTabBarItemTitleFontStyle(@NotNull TabsHost view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabBarItemTitleFontStyle(str);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    @ReactProp(customType = "Color", name = "tabBarItemTitleFontColor")
    public void setTabBarItemTitleFontColor(@NotNull TabsHost view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabBarItemTitleFontColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    @ReactProp(customType = "Color", name = "tabBarItemIconColor")
    public void setTabBarItemIconColor(@NotNull TabsHost view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabBarItemIconColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    @ReactProp(customType = "Color", name = "tabBarItemTitleFontColorActive")
    public void setTabBarItemTitleFontColorActive(@NotNull TabsHost view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabBarItemTitleFontColorActive(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    @ReactProp(customType = "Color", name = "tabBarItemIconColorActive")
    public void setTabBarItemIconColorActive(@NotNull TabsHost view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabBarItemIconColorActive(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsManagerInterface
    @ReactProp(name = "tabBarItemTitleFontSizeActive")
    public void setTabBarItemTitleFontSizeActive(@Nullable TabsHost tabsHost, float f) {
        if (tabsHost != null) {
            tabsHost.setTabBarItemTitleFontSizeActive(Float.valueOf(f));
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
