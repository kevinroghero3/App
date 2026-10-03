package com.reactnativepagerview;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.reactnativepagerview.event.PageScrollEvent;
import com.reactnativepagerview.event.PageScrollStateChangedEvent;
import com.reactnativepagerview.event.PageSelectedEvent;
import io.sentry.protocol.Device;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class PagerViewViewManager extends ViewGroupManager<NestedScrollableHost> {
    private static final String COMMAND_SET_PAGE = "setPage";
    private static final String COMMAND_SET_PAGE_WITHOUT_ANIMATION = "setPageWithoutAnimation";
    private static final String COMMAND_SET_SCROLL_ENABLED = "setScrollEnabledImperatively";
    public static final Companion Companion = new Companion(null);
    private EventDispatcher eventDispatcher;

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return PagerViewViewManagerImpl.NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public NestedScrollableHost createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        final NestedScrollableHost nestedScrollableHost = new NestedScrollableHost(reactContext);
        nestedScrollableHost.setId(View.generateViewId());
        nestedScrollableHost.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        nestedScrollableHost.setSaveEnabled(false);
        final ViewPager2 viewPager2 = new ViewPager2(reactContext);
        viewPager2.setAdapter(new ViewPagerAdapter());
        viewPager2.setSaveEnabled(false);
        NativeModule nativeModule = reactContext.getNativeModule((Class<NativeModule>) UIManagerModule.class);
        Intrinsics.checkNotNull(nativeModule);
        this.eventDispatcher = ((UIManagerModule) nativeModule).getEventDispatcher();
        viewPager2.post(new Runnable() { // from class: com.reactnativepagerview.PagerViewViewManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PagerViewViewManager.createViewInstance$lambda$0(viewPager2, this, nestedScrollableHost);
            }
        });
        nestedScrollableHost.addView(viewPager2);
        return nestedScrollableHost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createViewInstance$lambda$0(ViewPager2 viewPager2, final PagerViewViewManager pagerViewViewManager, final NestedScrollableHost nestedScrollableHost) {
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.reactnativepagerview.PagerViewViewManager$createViewInstance$1$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i, float f, int i2) {
                super.onPageScrolled(i, f, i2);
                EventDispatcher eventDispatcher = this.this$0.eventDispatcher;
                if (eventDispatcher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
                    eventDispatcher = null;
                }
                eventDispatcher.dispatchEvent(new PageScrollEvent(nestedScrollableHost.getId(), i, f));
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                EventDispatcher eventDispatcher = this.this$0.eventDispatcher;
                if (eventDispatcher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
                    eventDispatcher = null;
                }
                eventDispatcher.dispatchEvent(new PageSelectedEvent(nestedScrollableHost.getId(), i));
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                String str;
                super.onPageScrollStateChanged(i);
                if (i == 0) {
                    str = "idle";
                } else if (i == 1) {
                    str = "dragging";
                } else if (i == 2) {
                    str = "settling";
                } else {
                    throw new IllegalStateException("Unsupported pageScrollState");
                }
                EventDispatcher eventDispatcher = this.this$0.eventDispatcher;
                if (eventDispatcher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
                    eventDispatcher = null;
                }
                eventDispatcher.dispatchEvent(new PageScrollStateChangedEvent(nestedScrollableHost.getId(), str));
            }
        });
        EventDispatcher eventDispatcher = pagerViewViewManager.eventDispatcher;
        if (eventDispatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
            eventDispatcher = null;
        }
        eventDispatcher.dispatchEvent(new PageSelectedEvent(nestedScrollableHost.getId(), viewPager2.getCurrentItem()));
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull NestedScrollableHost host, @NotNull View child, int i) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(child, "child");
        PagerViewViewManagerImpl.INSTANCE.addView(host, child, i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(@NotNull NestedScrollableHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return PagerViewViewManagerImpl.INSTANCE.getChildCount(parent);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(@NotNull NestedScrollableHost parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return PagerViewViewManagerImpl.INSTANCE.getChildAt(parent, i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(@NotNull NestedScrollableHost parent, @NotNull View view) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        PagerViewViewManagerImpl.INSTANCE.removeView(parent, view);
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(@NotNull NestedScrollableHost parent) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(parent, "parent");
        PagerViewViewManagerImpl.INSTANCE.removeAllViews(parent);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(@NotNull NestedScrollableHost parent, int i) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(parent, "parent");
        PagerViewViewManagerImpl.INSTANCE.removeViewAt(parent, i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return PagerViewViewManagerImpl.INSTANCE.needsCustomLayoutForChildren();
    }

    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public final void setScrollEnabled(@NotNull NestedScrollableHost host, boolean z) {
        Intrinsics.checkNotNullParameter(host, "host");
        PagerViewViewManagerImpl.INSTANCE.setScrollEnabled(host, z);
    }

    @ReactProp(defaultInt = 0, name = "initialPage")
    public final void setInitialPage(@NotNull NestedScrollableHost host, int i) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(host, "host");
        PagerViewViewManagerImpl.INSTANCE.setInitialPage(host, i);
    }

    @ReactProp(name = Device.JsonKeys.ORIENTATION)
    public final void setOrientation(@NotNull NestedScrollableHost host, @NotNull String value) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        PagerViewViewManagerImpl.INSTANCE.setOrientation(host, value);
    }

    @ReactProp(defaultInt = -1, name = "offscreenPageLimit")
    public final void set(@NotNull NestedScrollableHost host, int i) {
        Intrinsics.checkNotNullParameter(host, "host");
        PagerViewViewManagerImpl.INSTANCE.setOffscreenPageLimit(host, i);
    }

    @ReactProp(name = "overScrollMode")
    public final void setOverScrollMode(@NotNull NestedScrollableHost host, @NotNull String value) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        PagerViewViewManagerImpl.INSTANCE.setOverScrollMode(host, value);
    }

    @ReactProp(name = ViewProps.LAYOUT_DIRECTION)
    public final void setLayoutDirection(@NotNull NestedScrollableHost host, @NotNull String value) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        PagerViewViewManagerImpl.INSTANCE.setLayoutDirection(host, value);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        Map<String, Map<String, String>> mapOf = MapBuilder.of(PageScrollEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageScroll"), PageScrollStateChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageScrollStateChanged"), PageSelectedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageSelected"));
        Intrinsics.checkNotNullExpressionValue(mapOf, "of(...)");
        return mapOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
    
        if (r8.equals(com.reactnativepagerview.PagerViewViewManager.COMMAND_SET_PAGE) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        if (r8.equals(com.reactnativepagerview.PagerViewViewManager.COMMAND_SET_PAGE_WITHOUT_ANIMATION) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r9);
        r9 = r9.getInt(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
    
        if (r1 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
    
        if (r1.intValue() <= 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0070, code lost:
    
        if (r9 < 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
    
        if (r9 >= r1.intValue()) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
    
        r0.setCurrentItem(r7, r9, kotlin.jvm.internal.Intrinsics.areEqual(r8, com.reactnativepagerview.PagerViewViewManager.COMMAND_SET_PAGE));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return;
     */
    @Override // com.facebook.react.uimanager.ViewManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void receiveCommand(@org.jetbrains.annotations.NotNull com.reactnativepagerview.NestedScrollableHost r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.Nullable com.facebook.react.bridge.ReadableArray r9) throws java.lang.ClassNotFoundException {
        /*
            r6 = this;
            java.lang.String r0 = "root"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "commandId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            super.receiveCommand(r7, r8, r9)
            com.reactnativepagerview.PagerViewViewManagerImpl r0 = com.reactnativepagerview.PagerViewViewManagerImpl.INSTANCE
            androidx.viewpager2.widget.ViewPager2 r7 = r0.getViewPager(r7)
            com.facebook.infer.annotation.Assertions.assertNotNull(r7)
            com.facebook.infer.annotation.Assertions.assertNotNull(r9)
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r7.getAdapter()
            if (r1 == 0) goto L28
            int r1 = r1.getItemCount()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L29
        L28:
            r1 = 0
        L29:
            int r2 = r8.hashCode()
            r3 = -445763635(0xffffffffe56e2fcd, float:-7.030031E22)
            java.lang.String r4 = "setPage"
            r5 = 0
            if (r2 == r3) goto L59
            r3 = 1747675147(0x682b680b, float:3.2377757E24)
            if (r2 == r3) goto L46
            r3 = 1984860689(0x764e9211, float:1.0474372E33)
            if (r2 != r3) goto L80
            boolean r2 = r8.equals(r4)
            if (r2 == 0) goto L80
            goto L61
        L46:
            java.lang.String r0 = "setScrollEnabledImperatively"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L80
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            boolean r8 = r9.getBoolean(r5)
            r7.setUserInputEnabled(r8)
            goto L7f
        L59:
            java.lang.String r2 = "setPageWithoutAnimation"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L80
        L61:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            int r9 = r9.getInt(r5)
            if (r1 == 0) goto L7f
            int r2 = r1.intValue()
            if (r2 <= 0) goto L7f
            if (r9 < 0) goto L7f
            int r1 = r1.intValue()
            if (r9 >= r1) goto L7f
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r4)
            r0.setCurrentItem(r7, r9, r8)
        L7f:
            return
        L80:
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Class<com.reactnativepagerview.PagerViewViewManager> r7 = com.reactnativepagerview.PagerViewViewManager.class
            java.lang.String r7 = r7.getSimpleName()
            java.lang.Object[] r7 = new java.lang.Object[]{r8, r7}
            r8 = 2
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r8)
            java.lang.String r8 = "Unsupported command %d received by %s."
            java.lang.String r7 = java.lang.String.format(r8, r7)
            java.lang.String r8 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativepagerview.PagerViewViewManager.receiveCommand(com.reactnativepagerview.NestedScrollableHost, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }

    @ReactProp(defaultInt = 0, name = "pageMargin")
    public final void setPageMargin(@NotNull NestedScrollableHost host, int i) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(host, "host");
        PagerViewViewManagerImpl.INSTANCE.setPageMargin(host, i);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
