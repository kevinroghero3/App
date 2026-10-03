package com.swmansion.rnscreens.gamma.tabs;

import android.util.Log;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerDelegate;
import com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface;
import com.swmansion.rnscreens.gamma.helpers.EventHelpersKt;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenDidAppearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenDidDisappearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenWillAppearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenWillDisappearEvent;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = TabScreenViewManager.REACT_CLASS)
public final class TabScreenViewManager extends ViewGroupManager<TabScreen> implements RNSBottomTabsScreenManagerInterface<TabScreen> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSBottomTabsScreen";
    private final ViewManagerDelegate<TabScreen> delegate = new RNSBottomTabsScreenManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setBadgeValue(@Nullable TabScreen tabScreen, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setIconImageSource(@Nullable TabScreen tabScreen, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setIconSfSymbolName(@Nullable TabScreen tabScreen, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setIconType(@Nullable TabScreen tabScreen, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setOverrideScrollViewContentInsetAdjustmentBehavior(@NotNull TabScreen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setSelectedIconImageSource(@Nullable TabScreen tabScreen, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setSelectedIconSfSymbolName(@Nullable TabScreen tabScreen, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setSpecialEffects(@NotNull TabScreen view, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setTabBarBackgroundColor(@NotNull TabScreen view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setTabBarBlurEffect(@NotNull TabScreen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setTabBarItemBadgeBackgroundColor(@NotNull TabScreen view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setTabBarItemIconColor(@Nullable TabScreen tabScreen, @Nullable Integer num) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setTabBarItemTitleFontColor(@NotNull TabScreen view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setTabBarItemTitleFontFamily(@NotNull TabScreen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setTabBarItemTitleFontSize(@NotNull TabScreen view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setTabBarItemTitleFontStyle(@NotNull TabScreen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setTabBarItemTitleFontWeight(@NotNull TabScreen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setTabBarItemTitlePositionAdjustment(@Nullable TabScreen tabScreen, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public TabScreen createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Log.d(REACT_CLASS, "createViewInstance");
        return new TabScreen(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<TabScreen> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt__MapsKt.mutableMapOf(EventHelpersKt.makeEventRegistrationInfo(TabScreenWillAppearEvent.Companion), EventHelpersKt.makeEventRegistrationInfo(TabScreenDidAppearEvent.Companion), EventHelpersKt.makeEventRegistrationInfo(TabScreenWillDisappearEvent.Companion), EventHelpersKt.makeEventRegistrationInfo(TabScreenDidDisappearEvent.Companion));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(@NotNull ThemedReactContext reactContext, @NotNull TabScreen view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        super.addEventEmitters(reactContext, view);
        view.onViewManagerAddEventEmitters$react_native_screens_release();
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    @ReactProp(name = "isFocused")
    public void setIsFocused(@NotNull TabScreen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        Log.d(REACT_CLASS, "TabScreen [" + view.getId() + "] setIsFocused " + z);
        view.setFocusedTab(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    @ReactProp(name = "tabKey")
    public void setTabKey(@NotNull TabScreen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabKey(str);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    @ReactProp(name = "title")
    public void setTitle(@NotNull TabScreen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabTitle(str);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    @ReactProp(name = "iconResourceName")
    public void setIconResourceName(@NotNull TabScreen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setIconResourceName(str);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
