package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface;
import com.swmansion.rnscreens.events.HeaderAttachedEvent;
import com.swmansion.rnscreens.events.HeaderDetachedEvent;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.Map;
import javax.annotation.Nonnull;
import kotlin.Deprecated;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@ReactModule(name = ScreenStackHeaderConfigViewManager.REACT_CLASS)
public final class ScreenStackHeaderConfigViewManager extends ViewGroupManager<ScreenStackHeaderConfig> implements RNSScreenStackHeaderConfigManagerInterface<ScreenStackHeaderConfig> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSScreenStackHeaderConfig";
    private final ViewManagerDelegate<ScreenStackHeaderConfig> delegate = new RNSScreenStackHeaderConfigManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ScreenStackHeaderConfig createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ScreenStackHeaderConfig(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance(@NotNull ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ScreenStackHeaderConfigShadowNode(context);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull ScreenStackHeaderConfig parent, @NotNull View child, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!(child instanceof ScreenStackHeaderSubview)) {
            throw new JSApplicationCausedNativeException("Config children should be of type RNSScreenStackHeaderSubview");
        }
        parent.addConfigSubview((ScreenStackHeaderSubview) child, i);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(@NotNull ScreenStackHeaderConfig view, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        return super.updateState(view, reactStylesDiffMap, stateWrapper);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@Nonnull @NotNull ScreenStackHeaderConfig view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.destroy();
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(@NotNull ScreenStackHeaderConfig parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.removeAllConfigSubviews();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(@NotNull ScreenStackHeaderConfig parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.removeConfigSubview(i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(@NotNull ScreenStackHeaderConfig parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getConfigSubviewsCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(@NotNull ScreenStackHeaderConfig parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getConfigSubview(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull ScreenStackHeaderConfig parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        super.onAfterUpdateTransaction(parent);
        parent.onUpdate();
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "title")
    public void setTitle(@NotNull ScreenStackHeaderConfig config, @Nullable String str) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTitle(str);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "titleFontFamily")
    public void setTitleFontFamily(@NotNull ScreenStackHeaderConfig config, @Nullable String str) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTitleFontFamily(str);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "titleFontSize")
    public void setTitleFontSize(@NotNull ScreenStackHeaderConfig config, int i) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTitleFontSize(i);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "titleFontWeight")
    public void setTitleFontWeight(@NotNull ScreenStackHeaderConfig config, @Nullable String str) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTitleFontWeight(str);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(customType = "Color", name = "titleColor")
    public void setTitleColor(@NotNull ScreenStackHeaderConfig config, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (num != null) {
            config.setTitleColor(num.intValue());
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(customType = "Color", name = ViewProps.BACKGROUND_COLOR)
    public void setBackgroundColor(@NotNull ScreenStackHeaderConfig config, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setBackgroundColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "hideShadow")
    public void setHideShadow(@NotNull ScreenStackHeaderConfig config, boolean z) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setHideShadow(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "hideBackButton")
    public void setHideBackButton(@NotNull ScreenStackHeaderConfig config, boolean z) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setHideBackButton(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @Deprecated(message = "For apps targeting SDK 35 or above edge-to-edge is enabled by default.")
    @ReactProp(name = "topInsetEnabled")
    public void setTopInsetEnabled(@NotNull ScreenStackHeaderConfig config, boolean z) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTopInsetEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(customType = "Color", name = "color")
    public void setColor(@NotNull ScreenStackHeaderConfig config, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTintColor(num != null ? num.intValue() : 0);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = ViewProps.HIDDEN)
    public void setHidden(@NotNull ScreenStackHeaderConfig config, boolean z) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setHidden(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "translucent")
    public void setTranslucent(@NotNull ScreenStackHeaderConfig config, boolean z) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTranslucent(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "backButtonInCustomView")
    public void setBackButtonInCustomView(@NotNull ScreenStackHeaderConfig config, boolean z) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setBackButtonInCustomView(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "direction")
    public void setDirection(@NotNull ScreenStackHeaderConfig config, @Nullable String str) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setDirection(str);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt__MapsKt.hashMapOf(TuplesKt.to(HeaderAttachedEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onAttached"))), TuplesKt.to(HeaderDetachedEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onDetached"))));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ScreenStackHeaderConfig> getDelegate() {
        return this.delegate;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void logNotAvailable(String str) {
        SentryLogcatAdapter.w("[RNScreens]", str + " prop is not available on Android");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setBackTitle(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, @Nullable String str) {
        logNotAvailable("backTitle");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setBackTitleFontFamily(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, @Nullable String str) {
        logNotAvailable("backTitleFontFamily");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setBackTitleFontSize(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        logNotAvailable("backTitleFontSize");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setBackTitleVisible(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        logNotAvailable("backTitleVisible");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitle(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        logNotAvailable("largeTitle");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitleFontFamily(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, @Nullable String str) {
        logNotAvailable("largeTitleFontFamily");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitleFontSize(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        logNotAvailable("largeTitleFontSize");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitleFontWeight(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, @Nullable String str) {
        logNotAvailable("largeTitleFontWeight");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitleBackgroundColor(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, @Nullable Integer num) {
        logNotAvailable("largeTitleBackgroundColor");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitleHideShadow(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        logNotAvailable("largeTitleHideShadow");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitleColor(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, @Nullable Integer num) {
        logNotAvailable("largeTitleColor");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setDisableBackButtonMenu(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        logNotAvailable("disableBackButtonMenu");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setBackButtonDisplayMode(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, @Nullable String str) {
        logNotAvailable("backButtonDisplayMode");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setBlurEffect(@Nullable ScreenStackHeaderConfig screenStackHeaderConfig, @Nullable String str) {
        logNotAvailable("blurEffect");
    }
}
