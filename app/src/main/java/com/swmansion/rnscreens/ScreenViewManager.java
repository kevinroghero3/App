package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSScreenManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenManagerInterface;
import com.swmansion.rnscreens.events.HeaderBackButtonClickedEvent;
import com.swmansion.rnscreens.events.HeaderHeightChangeEvent;
import com.swmansion.rnscreens.events.ScreenAppearEvent;
import com.swmansion.rnscreens.events.ScreenDisappearEvent;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import com.swmansion.rnscreens.events.SheetDetentChangedEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenWillAppearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenWillDisappearEvent;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@ReactModule(name = ScreenViewManager.REACT_CLASS)
public class ScreenViewManager extends ViewGroupManager<Screen> implements RNSScreenManagerInterface<Screen> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSScreen";
    private final ViewManagerDelegate<Screen> delegate = new RNSScreenManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setCustomAnimationOnSwipe(@Nullable Screen screen, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setFullScreenSwipeEnabled(@Nullable Screen screen, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setFullScreenSwipeShadowEnabled(@Nullable Screen screen, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setGestureResponseDistance(@Nullable Screen screen, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setHideKeyboardOnSwipe(@Nullable Screen screen, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setHomeIndicatorHidden(@Nullable Screen screen, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setPreventNativeDismiss(@Nullable Screen screen, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSwipeDirection(@Nullable Screen screen, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setTransitionDuration(@Nullable Screen screen, int i) {
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public Screen createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new Screen(reactContext);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setActivityState(@NotNull Screen view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        setActivityState(view, (int) f);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull Screen parent, @NotNull View child, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child instanceof ScreenContentWrapper) {
            parent.registerLayoutCallbackForWrapper((ScreenContentWrapper) child);
        } else if (child instanceof ScreenFooter) {
            parent.setFooter((ScreenFooter) child);
        }
        super.addView(parent, child, i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(@NotNull Screen parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent.getChildAt(i) instanceof ScreenFooter) {
            parent.setFooter(null);
        }
        super.removeViewAt(parent, i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(@NotNull Screen parent, @NotNull View view) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        super.removeView(parent, view);
        if (view instanceof ScreenFooter) {
            parent.setFooter(null);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(@NotNull Screen view, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        return super.updateState(view, reactStylesDiffMap, stateWrapper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull Screen view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        view.onFinalizePropsUpdate$react_native_screens_release();
    }

    @ReactProp(name = "activityState")
    public final void setActivityState(@NotNull Screen view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (i == -1) {
            return;
        }
        if (i == 0) {
            view.setActivityState(Screen.ActivityState.INACTIVE);
        } else if (i == 1) {
            view.setActivityState(Screen.ActivityState.TRANSITIONING_OR_BELOW_TOP);
        } else {
            if (i != 2) {
                return;
            }
            view.setActivityState(Screen.ActivityState.ON_TOP);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3.equals("fullScreenModal") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r3.equals("containedTransparentModal") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r3.equals("pageSheet") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if (r3.equals("containedModal") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        if (r3.equals("modal") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r3 = com.swmansion.rnscreens.Screen.StackPresentation.MODAL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
    
        if (r3.equals("transparentModal") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
    
        r3 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @com.facebook.react.uimanager.annotations.ReactProp(name = "stackPresentation")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setStackPresentation(@org.jetbrains.annotations.NotNull com.swmansion.rnscreens.Screen r2, @org.jetbrains.annotations.Nullable java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L62
            int r0 = r3.hashCode()
            switch(r0) {
                case -76271493: goto L54;
                case 3452698: goto L49;
                case 104069805: goto L3e;
                case 438078970: goto L35;
                case 872434704: goto L2c;
                case 955284238: goto L23;
                case 1171936146: goto L1a;
                case 1798290171: goto Lf;
                default: goto Le;
            }
        Le:
            goto L62
        Lf:
            java.lang.String r0 = "formSheet"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
            com.swmansion.rnscreens.Screen$StackPresentation r3 = com.swmansion.rnscreens.Screen.StackPresentation.FORM_SHEET
            goto L5e
        L1a:
            java.lang.String r0 = "fullScreenModal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
            goto L46
        L23:
            java.lang.String r0 = "containedTransparentModal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
            goto L5c
        L2c:
            java.lang.String r0 = "pageSheet"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
            goto L46
        L35:
            java.lang.String r0 = "containedModal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
            goto L46
        L3e:
            java.lang.String r0 = "modal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
        L46:
            com.swmansion.rnscreens.Screen$StackPresentation r3 = com.swmansion.rnscreens.Screen.StackPresentation.MODAL
            goto L5e
        L49:
            java.lang.String r0 = "push"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
            com.swmansion.rnscreens.Screen$StackPresentation r3 = com.swmansion.rnscreens.Screen.StackPresentation.PUSH
            goto L5e
        L54:
            java.lang.String r0 = "transparentModal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
        L5c:
            com.swmansion.rnscreens.Screen$StackPresentation r3 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL
        L5e:
            r2.setStackPresentation(r3)
            return
        L62:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = "Unknown presentation type "
            r2.append(r0)
            r2.append(r3)
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r2 = r2.toString()
            r3.<init>(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackPresentation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (r3.equals("default") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
    
        if (r3.equals("flip") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0083, code lost:
    
        if (r3.equals("simple_push") != false) goto L42;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @com.facebook.react.uimanager.annotations.ReactProp(name = "stackAnimation")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setStackAnimation(@org.jetbrains.annotations.NotNull com.swmansion.rnscreens.Screen r2, @org.jetbrains.annotations.Nullable java.lang.String r3) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackAnimation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(defaultBoolean = true, name = "gestureEnabled")
    public void setGestureEnabled(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setGestureEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "replaceAnimation")
    public void setReplaceAnimation(@NotNull Screen view, @Nullable String str) {
        Screen.ReplaceAnimation replaceAnimation;
        Intrinsics.checkNotNullParameter(view, "view");
        if (str == null || Intrinsics.areEqual(str, "pop")) {
            replaceAnimation = Screen.ReplaceAnimation.POP;
        } else {
            if (!Intrinsics.areEqual(str, "push")) {
                throw new JSApplicationIllegalArgumentException("Unknown replace animation type " + str);
            }
            replaceAnimation = Screen.ReplaceAnimation.PUSH;
        }
        view.setReplaceAnimation(replaceAnimation);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "screenOrientation")
    public void setScreenOrientation(@NotNull Screen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScreenOrientation(str);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "statusBarAnimation")
    public void setStatusBarAnimation(@NotNull Screen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarAnimated(Boolean.valueOf((str == null || Intrinsics.areEqual("none", str)) ? false : true));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @Deprecated(message = "For apps targeting SDK 35 or above this prop has no effect. Since the edge-to-edge is enabled by default the color is always translucent.")
    @ReactProp(customType = "Color", name = "statusBarColor")
    public void setStatusBarColor(@NotNull Screen view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "statusBarStyle")
    public void setStatusBarStyle(@NotNull Screen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarStyle(str);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @Deprecated(message = "For apps targeting SDK 35 or above edge-to-edge is enabled by default and will be enforced in the future.")
    @ReactProp(name = "statusBarTranslucent")
    public void setStatusBarTranslucent(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarTranslucent(Boolean.valueOf(z));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "statusBarHidden")
    public void setStatusBarHidden(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarHidden(Boolean.valueOf(z));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @Deprecated(message = "For apps targeting SDK 35 or above this prop has no effect")
    @ReactProp(customType = "Color", name = "navigationBarColor")
    public void setNavigationBarColor(@NotNull Screen view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @Deprecated(message = "For apps targeting SDK 35 or above edge-to-edge is enabled by default")
    @ReactProp(name = "navigationBarTranslucent")
    public void setNavigationBarTranslucent(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarTranslucent(Boolean.valueOf(z));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "navigationBarHidden")
    public void setNavigationBarHidden(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarHidden(Boolean.valueOf(z));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "nativeBackButtonDismissalEnabled")
    public void setNativeBackButtonDismissalEnabled(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNativeBackButtonDismissalEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetElevation")
    public void setSheetElevation(@Nullable Screen screen, int i) {
        if (screen != null) {
            screen.setSheetElevation(i);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetAllowedDetents")
    public void setSheetAllowedDetents(@NotNull Screen view, @Nullable final ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.getSheetDetents().clear();
        if (readableArray == null || readableArray.size() == 0) {
            view.getSheetDetents().add(Double.valueOf(1.0d));
        } else {
            SequencesKt___SequencesKt.toCollection(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(IntProgression.Companion.fromClosedRange(0, readableArray.size() - 1, 1)), new Function1() { // from class: com.swmansion.rnscreens.ScreenViewManager$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Double.valueOf(readableArray.getDouble(((Integer) obj).intValue()));
                }
            }), view.getSheetDetents());
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetLargestUndimmedDetent")
    public void setSheetLargestUndimmedDetent(@NotNull Screen view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (-1 > i || i >= 3) {
            throw new IllegalStateException("[RNScreens] sheetLargestUndimmedDetent on Android supports values between -1 and 2");
        }
        view.setSheetLargestUndimmedDetentIndex(i);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetGrabberVisible")
    public void setSheetGrabberVisible(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetGrabberVisible(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetCornerRadius")
    public void setSheetCornerRadius(@NotNull Screen view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetCornerRadius(f);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetExpandsWhenScrolledToEdge")
    public void setSheetExpandsWhenScrolledToEdge(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetExpandsWhenScrolledToEdge(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetInitialDetent")
    public void setSheetInitialDetent(@NotNull Screen view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetInitialDetentIndex(i);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setScreenId(@NotNull Screen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str == null || str.length() == 0) {
            str = null;
        }
        view.setScreenId(str);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ScreenDismissedEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onDismissed"))), TuplesKt.to("topWillAppear", MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", TabScreenWillAppearEvent.EVENT_REGISTRATION_NAME))), TuplesKt.to(ScreenAppearEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onAppear"))), TuplesKt.to("topWillDisappear", MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", TabScreenWillDisappearEvent.EVENT_REGISTRATION_NAME))), TuplesKt.to(ScreenDisappearEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onDisappear"))), TuplesKt.to(HeaderHeightChangeEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onHeaderHeightChange"))), TuplesKt.to(HeaderBackButtonClickedEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onHeaderBackButtonClicked"))), TuplesKt.to(ScreenTransitionProgressEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onTransitionProgress"))), TuplesKt.to(SheetDetentChangedEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onSheetDetentChanged"))));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<Screen> getDelegate() {
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
