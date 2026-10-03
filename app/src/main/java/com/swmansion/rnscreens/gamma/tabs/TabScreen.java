package com.swmansion.rnscreens.gamma.tabs;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.facebook.react.uimanager.ThemedReactContext;
import com.swmansion.rnscreens.gamma.common.FragmentProviding;
import com.swmansion.rnscreens.gamma.helpers.SystemDrawableKt;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class TabScreen extends ViewGroup implements FragmentProviding {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabScreen.class, "tabTitle", "getTabTitle()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabScreen.class, "iconResourceName", "getIconResourceName()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabScreen.class, "icon", "getIcon()Landroid/graphics/drawable/Drawable;", 0))};
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "TabScreen";
    public TabScreenEventEmitter eventEmitter;
    private final ReadWriteProperty icon$delegate;
    private final ReadWriteProperty iconResourceName$delegate;
    private boolean isFocusedTab;
    private final ThemedReactContext reactContext;
    private String tabKey;
    private WeakReference<TabScreenDelegate> tabScreenDelegate;
    private final ReadWriteProperty tabTitle$delegate;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabScreen(@NotNull ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        final Object obj = null;
        this.tabScreenDelegate = new WeakReference<>(null);
        Delegates delegates = Delegates.INSTANCE;
        this.tabTitle$delegate = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabScreen$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, String str, String str2) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabScreen tabScreen = this;
                tabScreen.updateMenuItemAttributesIfNeeded(str, str2);
            }
        };
        this.iconResourceName$delegate = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabScreen$special$$inlined$observable$2
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, String str, String str2) {
                Intrinsics.checkNotNullParameter(property, "property");
                String str3 = str2;
                if (Intrinsics.areEqual(str3, str)) {
                    return;
                }
                TabScreen tabScreen = this;
                tabScreen.setIcon(SystemDrawableKt.getSystemDrawableResource(tabScreen.getReactContext(), str3));
            }
        };
        this.icon$delegate = new ObservableProperty<Drawable>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabScreen$special$$inlined$observable$3
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, Drawable drawable, Drawable drawable2) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabScreen tabScreen = this;
                tabScreen.updateMenuItemAttributesIfNeeded(drawable, drawable2);
            }
        };
    }

    public final TabScreenEventEmitter getEventEmitter$react_native_screens_release() {
        TabScreenEventEmitter tabScreenEventEmitter = this.eventEmitter;
        if (tabScreenEventEmitter != null) {
            return tabScreenEventEmitter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
        return null;
    }

    public final void setEventEmitter$react_native_screens_release(@NotNull TabScreenEventEmitter tabScreenEventEmitter) {
        Intrinsics.checkNotNullParameter(tabScreenEventEmitter, "<set-?>");
        this.eventEmitter = tabScreenEventEmitter;
    }

    public final String getTabKey() {
        return this.tabKey;
    }

    public final void setTabKey(@Nullable String str) {
        if (str != null && StringsKt__StringsKt.isBlank(str)) {
            str = null;
        }
        this.tabKey = str;
    }

    public final String getTabTitle() {
        return (String) this.tabTitle$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setTabTitle(@Nullable String str) {
        this.tabTitle$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final String getIconResourceName() {
        return (String) this.iconResourceName$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setIconResourceName(@Nullable String str) {
        this.iconResourceName$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    public final Drawable getIcon() {
        return (Drawable) this.icon$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setIcon(@Nullable Drawable drawable) {
        this.icon$delegate.setValue(this, $$delegatedProperties[2], drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void updateMenuItemAttributesIfNeeded(T t, T t2) {
        if (Intrinsics.areEqual(t2, t)) {
            return;
        }
        onMenuItemAttributesChange();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Log.d(TAG, "TabScreen [" + getId() + "] attached to window");
        super.onAttachedToWindow();
    }

    public final boolean isFocusedTab() {
        return this.isFocusedTab;
    }

    public final void setFocusedTab(boolean z) {
        if (this.isFocusedTab != z) {
            this.isFocusedTab = z;
            onTabFocusChangedFromJS();
        }
    }

    public final void setTabScreenDelegate$react_native_screens_release(@Nullable TabScreenDelegate tabScreenDelegate) {
        this.tabScreenDelegate = new WeakReference<>(tabScreenDelegate);
    }

    @Override // com.swmansion.rnscreens.gamma.common.FragmentProviding
    public Fragment getFragment() {
        TabScreenDelegate tabScreenDelegate = this.tabScreenDelegate.get();
        if (tabScreenDelegate != null) {
            return tabScreenDelegate.getFragmentForTabScreen(this);
        }
        return null;
    }

    private final void onTabFocusChangedFromJS() {
        TabScreenDelegate tabScreenDelegate = this.tabScreenDelegate.get();
        if (tabScreenDelegate != null) {
            tabScreenDelegate.onTabFocusChangedFromJS(this, this.isFocusedTab);
        }
    }

    private final void onMenuItemAttributesChange() {
        TabScreenDelegate tabScreenDelegate = this.tabScreenDelegate.get();
        if (tabScreenDelegate != null) {
            tabScreenDelegate.onMenuItemAttributesChange(this);
        }
    }

    public final void onViewManagerAddEventEmitters$react_native_screens_release() {
        if (getId() == -1) {
            throw new IllegalStateException("[RNScreens] TabScreen must have its tag set when registering event emitters");
        }
        setEventEmitter$react_native_screens_release(new TabScreenEventEmitter(this.reactContext, getId()));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
