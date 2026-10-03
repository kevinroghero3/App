package com.swmansion.rnscreens.gamma.tabs;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.common.assets.ReactFontManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.material.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.swmansion.rnscreens.gamma.helpers.FragmentManagerHelper;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class TabsHost extends LinearLayout implements TabScreenDelegate {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsHost.class, "tabBarBackgroundColor", "getTabBarBackgroundColor()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsHost.class, "tabBarItemIconColor", "getTabBarItemIconColor()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsHost.class, "tabBarItemTitleFontFamily", "getTabBarItemTitleFontFamily()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsHost.class, "tabBarItemIconColorActive", "getTabBarItemIconColorActive()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsHost.class, "tabBarItemTitleFontColor", "getTabBarItemTitleFontColor()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsHost.class, "tabBarItemTitleFontColorActive", "getTabBarItemTitleFontColorActive()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsHost.class, "tabBarItemTitleFontSize", "getTabBarItemTitleFontSize()Ljava/lang/Float;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsHost.class, "tabBarItemTitleFontSizeActive", "getTabBarItemTitleFontSizeActive()Ljava/lang/Float;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsHost.class, "tabBarItemTitleFontWeight", "getTabBarItemTitleFontWeight()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsHost.class, "tabBarItemTitleFontStyle", "getTabBarItemTitleFontStyle()Ljava/lang/String;", 0))};
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "TabsHost";
    private final BottomNavigationView bottomNavigationView;
    private final ContainerUpdateCoordinator containerUpdateCoordinator;
    private final FrameLayout contentView;
    public TabsHostEventEmitter eventEmitter;
    private FragmentManager fragmentManager;
    private boolean isLayoutInvalidated;
    private final ThemedReactContext reactContext;
    private final ReadWriteProperty tabBarBackgroundColor$delegate;
    private final ReadWriteProperty tabBarItemIconColor$delegate;
    private final ReadWriteProperty tabBarItemIconColorActive$delegate;
    private final ReadWriteProperty tabBarItemTitleFontColor$delegate;
    private final ReadWriteProperty tabBarItemTitleFontColorActive$delegate;
    private final ReadWriteProperty tabBarItemTitleFontFamily$delegate;
    private final ReadWriteProperty tabBarItemTitleFontSize$delegate;
    private final ReadWriteProperty tabBarItemTitleFontSizeActive$delegate;
    private final ReadWriteProperty tabBarItemTitleFontStyle$delegate;
    private final ReadWriteProperty tabBarItemTitleFontWeight$delegate;
    private final List<TabScreenFragment> tabScreenFragments;

    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHost(@NotNull ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.containerUpdateCoordinator = new ContainerUpdateCoordinator();
        BottomNavigationView bottomNavigationView = new BottomNavigationView(reactContext);
        bottomNavigationView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.bottomNavigationView = bottomNavigationView;
        FrameLayout frameLayout = new FrameLayout(reactContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 1.0f;
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setId(View.generateViewId());
        this.contentView = frameLayout;
        this.tabScreenFragments = new ArrayList();
        Delegates delegates = Delegates.INSTANCE;
        final Object obj = null;
        this.tabBarBackgroundColor$delegate = new ObservableProperty<Integer>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsHost tabsHost = this;
                tabsHost.updateNavigationMenuIfNeeded(num, num2);
            }
        };
        this.tabBarItemIconColor$delegate = new ObservableProperty<Integer>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$special$$inlined$observable$2
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsHost tabsHost = this;
                tabsHost.updateNavigationMenuIfNeeded(num, num2);
            }
        };
        this.tabBarItemTitleFontFamily$delegate = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$special$$inlined$observable$3
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, String str, String str2) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsHost tabsHost = this;
                tabsHost.updateNavigationMenuIfNeeded(str, str2);
            }
        };
        this.tabBarItemIconColorActive$delegate = new ObservableProperty<Integer>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$special$$inlined$observable$4
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsHost tabsHost = this;
                tabsHost.updateNavigationMenuIfNeeded(num, num2);
            }
        };
        this.tabBarItemTitleFontColor$delegate = new ObservableProperty<Integer>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$special$$inlined$observable$5
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsHost tabsHost = this;
                tabsHost.updateNavigationMenuIfNeeded(num, num2);
            }
        };
        this.tabBarItemTitleFontColorActive$delegate = new ObservableProperty<Integer>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$special$$inlined$observable$6
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsHost tabsHost = this;
                tabsHost.updateNavigationMenuIfNeeded(num, num2);
            }
        };
        this.tabBarItemTitleFontSize$delegate = new ObservableProperty<Float>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$special$$inlined$observable$7
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, Float f, Float f2) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsHost tabsHost = this;
                tabsHost.updateNavigationMenuIfNeeded(f, f2);
            }
        };
        this.tabBarItemTitleFontSizeActive$delegate = new ObservableProperty<Float>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$special$$inlined$observable$8
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, Float f, Float f2) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsHost tabsHost = this;
                tabsHost.updateNavigationMenuIfNeeded(f, f2);
            }
        };
        this.tabBarItemTitleFontWeight$delegate = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$special$$inlined$observable$9
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, String str, String str2) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsHost tabsHost = this;
                tabsHost.updateNavigationMenuIfNeeded(str, str2);
            }
        };
        this.tabBarItemTitleFontStyle$delegate = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$special$$inlined$observable$10
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, String str, String str2) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsHost tabsHost = this;
                tabsHost.updateNavigationMenuIfNeeded(str, str2);
            }
        };
        setOrientation(1);
        bottomNavigationView.setLabelVisibilityMode(1);
        addView(frameLayout);
        addView(bottomNavigationView);
        bottomNavigationView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                TabsHost._init_$lambda$15(view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$$ExternalSyntheticLambda1
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                return TabsHost._init_$lambda$16(this.f$0, menuItem);
            }
        });
    }

    final class ContainerUpdateCoordinator {
        private boolean isBottomNavigationMenuInvalidated;
        private boolean isSelectedTabInvalidated;
        private boolean isUpdatePending;

        public ContainerUpdateCoordinator() {
        }

        public final void invalidateSelectedTab() {
            this.isSelectedTabInvalidated = true;
        }

        public final void invalidateNavigationMenu() {
            this.isBottomNavigationMenuInvalidated = true;
        }

        public final void invalidateAll() {
            invalidateSelectedTab();
            invalidateNavigationMenu();
        }

        public final void postContainerUpdateIfNeeded() {
            if (this.isUpdatePending) {
                return;
            }
            postContainerUpdate();
        }

        public final void postContainerUpdate() {
            this.isUpdatePending = true;
            TabsHost.this.post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$ContainerUpdateCoordinator$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.runContainerUpdateIfNeeded();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void runContainerUpdateIfNeeded() {
            if (this.isUpdatePending) {
                runContainerUpdate();
            }
        }

        public final void runContainerUpdate() {
            this.isUpdatePending = false;
            if (this.isSelectedTabInvalidated) {
                this.isSelectedTabInvalidated = false;
                TabsHost.this.updateSelectedTab();
            }
            if (this.isBottomNavigationMenuInvalidated) {
                this.isBottomNavigationMenuInvalidated = false;
                TabsHost.this.updateBottomNavigationViewAppearance();
            }
        }
    }

    public final TabsHostEventEmitter getEventEmitter$react_native_screens_release() {
        TabsHostEventEmitter tabsHostEventEmitter = this.eventEmitter;
        if (tabsHostEventEmitter != null) {
            return tabsHostEventEmitter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
        return null;
    }

    public final void setEventEmitter$react_native_screens_release(@NotNull TabsHostEventEmitter tabsHostEventEmitter) {
        Intrinsics.checkNotNullParameter(tabsHostEventEmitter, "<set-?>");
        this.eventEmitter = tabsHostEventEmitter;
    }

    private final FragmentManager getRequireFragmentManager() {
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("[RNScreens] Nullish fragment manager");
    }

    public final Integer getTabBarBackgroundColor() {
        return (Integer) this.tabBarBackgroundColor$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setTabBarBackgroundColor(@Nullable Integer num) {
        this.tabBarBackgroundColor$delegate.setValue(this, $$delegatedProperties[0], num);
    }

    public final Integer getTabBarItemIconColor() {
        return (Integer) this.tabBarItemIconColor$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setTabBarItemIconColor(@Nullable Integer num) {
        this.tabBarItemIconColor$delegate.setValue(this, $$delegatedProperties[1], num);
    }

    public final String getTabBarItemTitleFontFamily() {
        return (String) this.tabBarItemTitleFontFamily$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setTabBarItemTitleFontFamily(@Nullable String str) {
        this.tabBarItemTitleFontFamily$delegate.setValue(this, $$delegatedProperties[2], str);
    }

    public final Integer getTabBarItemIconColorActive() {
        return (Integer) this.tabBarItemIconColorActive$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final void setTabBarItemIconColorActive(@Nullable Integer num) {
        this.tabBarItemIconColorActive$delegate.setValue(this, $$delegatedProperties[3], num);
    }

    public final Integer getTabBarItemTitleFontColor() {
        return (Integer) this.tabBarItemTitleFontColor$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final void setTabBarItemTitleFontColor(@Nullable Integer num) {
        this.tabBarItemTitleFontColor$delegate.setValue(this, $$delegatedProperties[4], num);
    }

    public final Integer getTabBarItemTitleFontColorActive() {
        return (Integer) this.tabBarItemTitleFontColorActive$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final void setTabBarItemTitleFontColorActive(@Nullable Integer num) {
        this.tabBarItemTitleFontColorActive$delegate.setValue(this, $$delegatedProperties[5], num);
    }

    public final Float getTabBarItemTitleFontSize() {
        return (Float) this.tabBarItemTitleFontSize$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final void setTabBarItemTitleFontSize(@Nullable Float f) {
        this.tabBarItemTitleFontSize$delegate.setValue(this, $$delegatedProperties[6], f);
    }

    public final Float getTabBarItemTitleFontSizeActive() {
        return (Float) this.tabBarItemTitleFontSizeActive$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final void setTabBarItemTitleFontSizeActive(@Nullable Float f) {
        this.tabBarItemTitleFontSizeActive$delegate.setValue(this, $$delegatedProperties[7], f);
    }

    public final String getTabBarItemTitleFontWeight() {
        return (String) this.tabBarItemTitleFontWeight$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final void setTabBarItemTitleFontWeight(@Nullable String str) {
        this.tabBarItemTitleFontWeight$delegate.setValue(this, $$delegatedProperties[8], str);
    }

    public final String getTabBarItemTitleFontStyle() {
        return (String) this.tabBarItemTitleFontStyle$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public final void setTabBarItemTitleFontStyle(@Nullable String str) {
        this.tabBarItemTitleFontStyle$delegate.setValue(this, $$delegatedProperties[9], str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void updateNavigationMenuIfNeeded(T t, T t2) {
        if (Intrinsics.areEqual(t2, t)) {
            return;
        }
        ContainerUpdateCoordinator containerUpdateCoordinator = this.containerUpdateCoordinator;
        containerUpdateCoordinator.invalidateNavigationMenu();
        containerUpdateCoordinator.postContainerUpdateIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$15(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Log.d(TAG, "BottomNavigationView layout changed {" + i + ", " + i2 + "} {" + (i3 - i) + ", " + (i4 - i2) + "}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$16(TabsHost tabsHost, MenuItem item) {
        String tabKey;
        TabScreen tabScreen$react_native_screens_release;
        Intrinsics.checkNotNullParameter(item, "item");
        Log.d(TAG, "Item selected " + item);
        TabScreenFragment fragmentForMenuItemId = tabsHost.getFragmentForMenuItemId(item.getItemId());
        if (fragmentForMenuItemId == null || (tabScreen$react_native_screens_release = fragmentForMenuItemId.getTabScreen$react_native_screens_release()) == null || (tabKey = tabScreen$react_native_screens_release.getTabKey()) == null) {
            tabKey = "undefined";
        }
        tabsHost.getEventEmitter$react_native_screens_release().emitOnNativeFocusChange(tabKey);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Log.d(TAG, "TabsHost [" + getId() + "] attached to window");
        super.onAttachedToWindow();
        FragmentManager fragmentManagerFindFragmentManagerForView = FragmentManagerHelper.INSTANCE.findFragmentManagerForView(this);
        if (fragmentManagerFindFragmentManagerForView != null) {
            this.fragmentManager = fragmentManagerFindFragmentManagerForView;
            return;
        }
        throw new IllegalStateException("[RNScreens] Nullish fragment manager - can't run container operations");
    }

    public final void mountReactSubviewAt$react_native_screens_release(@NotNull TabScreen tabScreen, int i) {
        Intrinsics.checkNotNullParameter(tabScreen, "tabScreen");
        if (i >= this.bottomNavigationView.getMaxItemCount()) {
            throw new IllegalArgumentException(("[RNScreens] Attempt to insert TabScreen at index " + i + "; BottomNavigationView supports at most " + this.bottomNavigationView.getMaxItemCount() + " items").toString());
        }
        this.tabScreenFragments.add(i, new TabScreenFragment(tabScreen));
        tabScreen.setTabScreenDelegate$react_native_screens_release(this);
        ContainerUpdateCoordinator containerUpdateCoordinator = this.containerUpdateCoordinator;
        containerUpdateCoordinator.invalidateAll();
        containerUpdateCoordinator.postContainerUpdateIfNeeded();
    }

    public final void unmountReactSubviewAt$react_native_screens_release(int i) {
        this.tabScreenFragments.remove(i).getTabScreen$react_native_screens_release().setTabScreenDelegate$react_native_screens_release(null);
        ContainerUpdateCoordinator containerUpdateCoordinator = this.containerUpdateCoordinator;
        containerUpdateCoordinator.invalidateAll();
        containerUpdateCoordinator.postContainerUpdateIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean unmountReactSubview$lambda$23(TabScreen tabScreen, TabScreenFragment it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2.getTabScreen$react_native_screens_release() == tabScreen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean unmountReactSubview$lambda$24(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    public final void unmountReactSubview$react_native_screens_release(@NotNull final TabScreen reactSubview) {
        Intrinsics.checkNotNullParameter(reactSubview, "reactSubview");
        List<TabScreenFragment> list = this.tabScreenFragments;
        final Function1 function1 = new Function1() { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TabsHost.unmountReactSubview$lambda$23(reactSubview, (TabScreenFragment) obj));
            }
        };
        boolean zRemoveIf = list.removeIf(new Predicate() { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return TabsHost.unmountReactSubview$lambda$24(function1, obj);
            }
        });
        Boolean boolValueOf = Boolean.valueOf(zRemoveIf);
        if (!zRemoveIf) {
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            reactSubview.setTabScreenDelegate$react_native_screens_release(null);
            ContainerUpdateCoordinator containerUpdateCoordinator = this.containerUpdateCoordinator;
            containerUpdateCoordinator.invalidateAll();
            containerUpdateCoordinator.postContainerUpdateIfNeeded();
        }
    }

    public final void unmountAllReactSubviews$react_native_screens_release() {
        Iterator<T> it2 = this.tabScreenFragments.iterator();
        while (it2.hasNext()) {
            ((TabScreenFragment) it2.next()).getTabScreen$react_native_screens_release().setTabScreenDelegate$react_native_screens_release(null);
        }
        this.tabScreenFragments.clear();
        ContainerUpdateCoordinator containerUpdateCoordinator = this.containerUpdateCoordinator;
        containerUpdateCoordinator.invalidateAll();
        containerUpdateCoordinator.postContainerUpdateIfNeeded();
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.TabScreenDelegate
    public void onTabFocusChangedFromJS(@NotNull TabScreen tabScreen, boolean z) {
        Intrinsics.checkNotNullParameter(tabScreen, "tabScreen");
        ContainerUpdateCoordinator containerUpdateCoordinator = this.containerUpdateCoordinator;
        containerUpdateCoordinator.invalidateSelectedTab();
        containerUpdateCoordinator.postContainerUpdateIfNeeded();
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.TabScreenDelegate
    public void onMenuItemAttributesChange(@NotNull TabScreen tabScreen) {
        Intrinsics.checkNotNullParameter(tabScreen, "tabScreen");
        MenuItem menuItemForTabScreen = getMenuItemForTabScreen(tabScreen);
        if (menuItemForTabScreen != null) {
            updateMenuItemOfTabScreen(menuItemForTabScreen, tabScreen);
        }
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.TabScreenDelegate
    public TabScreenFragment getFragmentForTabScreen(@NotNull TabScreen tabScreen) {
        Object next;
        Intrinsics.checkNotNullParameter(tabScreen, "tabScreen");
        Iterator<T> it2 = this.tabScreenFragments.iterator();
        while (it2.hasNext()) {
            next = it2.next();
            if (((TabScreenFragment) next).getTabScreen$react_native_screens_release() == tabScreen) {
                return (TabScreenFragment) next;
            }
        }
        next = null;
        return (TabScreenFragment) next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBottomNavigationViewAppearance() {
        SentryLogcatAdapter.w(TAG, "updateBottomNavigationViewAppearance");
        this.bottomNavigationView.setVisibility(0);
        BottomNavigationView bottomNavigationView = this.bottomNavigationView;
        Integer tabBarBackgroundColor = getTabBarBackgroundColor();
        bottomNavigationView.setBackgroundColor(tabBarBackgroundColor != null ? tabBarBackgroundColor.intValue() : R.color.m3_sys_color_light_surface_container);
        int[][] iArr = {new int[]{-16842912}, new int[]{android.R.attr.state_checked}};
        Integer tabBarItemTitleFontColor = getTabBarItemTitleFontColor();
        int iIntValue = tabBarItemTitleFontColor != null ? tabBarItemTitleFontColor.intValue() : R.color.m3_tabs_text_color_secondary;
        Integer tabBarItemTitleFontColorActive = getTabBarItemTitleFontColorActive();
        this.bottomNavigationView.setItemTextColor(new ColorStateList(iArr, new int[]{iIntValue, (tabBarItemTitleFontColorActive == null && (tabBarItemTitleFontColorActive = getTabBarItemTitleFontColor()) == null) ? R.color.m3_tabs_text_color : tabBarItemTitleFontColorActive.intValue()}));
        Integer tabBarItemIconColor = getTabBarItemIconColor();
        int iIntValue2 = tabBarItemIconColor != null ? tabBarItemIconColor.intValue() : R.color.m3_tabs_icon_color_secondary;
        Integer tabBarItemIconColorActive = getTabBarItemIconColorActive();
        this.bottomNavigationView.setItemIconTintList(new ColorStateList(iArr, new int[]{iIntValue2, (tabBarItemIconColorActive == null && (tabBarItemIconColorActive = getTabBarItemIconColor()) == null) ? R.color.m3_tabs_icon_color : tabBarItemIconColorActive.intValue()}));
        this.bottomNavigationView.getMenu().clear();
        int i = 0;
        for (Object obj : this.tabScreenFragments) {
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TabScreenFragment tabScreenFragment = (TabScreenFragment) obj;
            Log.d(TAG, "Add menu item: " + i);
            this.bottomNavigationView.getMenu().add(0, i, 0, tabScreenFragment.getTabScreen$react_native_screens_release().getTabTitle()).setIcon(tabScreenFragment.getTabScreen$react_native_screens_release().getIcon());
            i++;
        }
        updateFontStyles();
        BottomNavigationView bottomNavigationView2 = this.bottomNavigationView;
        Integer selectedTabScreenFragmentId = getSelectedTabScreenFragmentId();
        if (selectedTabScreenFragmentId != null) {
            bottomNavigationView2.setSelectedItemId(selectedTabScreenFragmentId.intValue());
            post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.tabs.TabsHost$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    TabsHost.updateBottomNavigationViewAppearance$lambda$35(this.f$0);
                }
            });
            return;
        }
        throw new IllegalStateException("[RNScreens] A single selected tab must be present");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateBottomNavigationViewAppearance$lambda$35(TabsHost tabsHost) {
        tabsHost.forceSubtreeMeasureAndLayoutPass();
        Log.d(TAG, "BottomNavigationView request layout");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x008f  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a7  */
    private final void updateFontStyles() {
        int iIntValue;
        Integer intOrNull;
        float fFloatValue;
        float fFloatValue2;
        View childAt = this.bottomNavigationView.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        for (View view : ViewGroupKt.getChildren((ViewGroup) childAt)) {
            TextView textView = (TextView) view.findViewById(R.id.navigation_bar_item_large_label_view);
            TextView textView2 = (TextView) view.findViewById(R.id.navigation_bar_item_small_label_view);
            boolean zAreEqual = Intrinsics.areEqual(getTabBarItemTitleFontStyle(), "italic");
            if (Intrinsics.areEqual(getTabBarItemTitleFontWeight(), "bold")) {
                iIntValue = 700;
            } else {
                String tabBarItemTitleFontWeight = getTabBarItemTitleFontWeight();
                iIntValue = (tabBarItemTitleFontWeight == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(tabBarItemTitleFontWeight)) == null) ? 400 : intOrNull.intValue();
            }
            ReactFontManager companion = ReactFontManager.Companion.getInstance();
            String tabBarItemTitleFontFamily = getTabBarItemTitleFontFamily();
            if (tabBarItemTitleFontFamily == null) {
                tabBarItemTitleFontFamily = "";
            }
            Typeface typeface = companion.getTypeface(tabBarItemTitleFontFamily, iIntValue, zAreEqual, this.reactContext.getAssets());
            Float tabBarItemTitleFontSize = getTabBarItemTitleFontSize();
            if (tabBarItemTitleFontSize == null) {
                fFloatValue = 12.0f;
            } else {
                if (tabBarItemTitleFontSize.floatValue() <= 0.0f) {
                    tabBarItemTitleFontSize = null;
                }
                if (tabBarItemTitleFontSize != null) {
                    fFloatValue = tabBarItemTitleFontSize.floatValue();
                } else {
                    fFloatValue = 12.0f;
                }
            }
            Float tabBarItemTitleFontSizeActive = getTabBarItemTitleFontSizeActive();
            if (tabBarItemTitleFontSizeActive == null) {
                fFloatValue2 = 14.0f;
            } else {
                Float f = tabBarItemTitleFontSizeActive.floatValue() > 0.0f ? tabBarItemTitleFontSizeActive : null;
                if (f != null) {
                    fFloatValue2 = f.floatValue();
                } else {
                    fFloatValue2 = 14.0f;
                }
            }
            textView2.setTextSize(fFloatValue);
            textView2.setTypeface(typeface);
            textView.setTextSize(fFloatValue2);
            textView.setTypeface(typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectedTab() {
        Object next;
        Iterator<T> it2 = this.tabScreenFragments.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!((TabScreenFragment) next).getTabScreen$react_native_screens_release().isFocusedTab());
        if (next == null) {
            throw new IllegalStateException("[RNScreens] No focused tab present");
        }
        TabScreenFragment tabScreenFragment = (TabScreenFragment) next;
        if (getRequireFragmentManager().getFragments().size() > 1) {
            throw new IllegalStateException("[RNScreens] There can be only a single focused tab");
        }
        List<Fragment> fragments = getRequireFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        Fragment fragment = (Fragment) CollectionsKt___CollectionsKt.firstOrNull((List) fragments);
        if (tabScreenFragment == fragment) {
            return;
        }
        if (fragment == null) {
            FragmentTransaction reorderingAllowed = getRequireFragmentManager().beginTransaction().setReorderingAllowed(true);
            reorderingAllowed.add(this.contentView.getId(), tabScreenFragment);
            reorderingAllowed.commitNowAllowingStateLoss();
        } else {
            FragmentTransaction reorderingAllowed2 = getRequireFragmentManager().beginTransaction().setReorderingAllowed(true);
            reorderingAllowed2.remove(fragment);
            reorderingAllowed2.add(this.contentView.getId(), tabScreenFragment);
            reorderingAllowed2.commitNowAllowingStateLoss();
        }
    }

    private final void forceSubtreeMeasureAndLayoutPass() {
        this.isLayoutInvalidated = false;
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    private final TabScreenFragment getFragmentForMenuItemId(int i) {
        return (TabScreenFragment) CollectionsKt___CollectionsKt.getOrNull(this.tabScreenFragments, i);
    }

    private final Integer getSelectedTabScreenFragmentId() {
        if (this.tabScreenFragments.isEmpty()) {
            return null;
        }
        Iterator<TabScreenFragment> it2 = this.tabScreenFragments.iterator();
        int i = 0;
        while (it2.hasNext()) {
            if (it2.next().getTabScreen$react_native_screens_release().isFocusedTab()) {
                return Integer.valueOf(i);
            }
            i++;
        }
        i = -1;
        return Integer.valueOf(i);
    }

    private final MenuItem getMenuItemForTabScreen(TabScreen tabScreen) {
        Iterator<TabScreenFragment> it2 = this.tabScreenFragments.iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            if (it2.next().getTabScreen$react_native_screens_release() == tabScreen) {
                break;
            }
            i++;
        }
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return null;
        }
        return this.bottomNavigationView.getMenu().findItem(numValueOf.intValue());
    }

    private final void updateMenuItemOfTabScreen(MenuItem menuItem, TabScreen tabScreen) {
        menuItem.setTitle(tabScreen.getTabTitle());
        menuItem.setIcon(tabScreen.getIcon());
    }

    public final void onViewManagerAddEventEmitters$react_native_screens_release() {
        if (getId() == -1) {
            throw new IllegalStateException("[RNScreens] TabsHost must have its tag set when registering event emitters");
        }
        setEventEmitter$react_native_screens_release(new TabsHostEventEmitter(this.reactContext, getId()));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
