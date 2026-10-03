package com.swmansion.rnscreens.bottomsheet;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.inputmethod.InputMethodManager;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.swmansion.rnscreens.InsetsObserverProxy;
import com.swmansion.rnscreens.KeyboardDidHide;
import com.swmansion.rnscreens.KeyboardNotVisible;
import com.swmansion.rnscreens.KeyboardState;
import com.swmansion.rnscreens.KeyboardVisible;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenContainer;
import com.swmansion.rnscreens.ScreenContentWrapper;
import com.swmansion.rnscreens.ScreenFooter;
import com.swmansion.rnscreens.ScreenStackFragment;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SheetDelegate implements LifecycleEventObserver, OnApplyWindowInsetsListener {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "SheetDelegate";
    private boolean isKeyboardVisible;
    private final KeyboardHandler keyboardHandlerCallback;
    private KeyboardState keyboardState;
    private int lastStableDetentIndex;
    private int lastStableState;
    private final Screen screen;
    private final SheetStateObserver sheetStateObserver;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getLastStableState$annotations() {
    }

    private final boolean shouldDismissSheetInState(int i) {
        return i == 5;
    }

    public SheetDelegate(@NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.screen = screen;
        this.keyboardState = KeyboardNotVisible.INSTANCE;
        this.lastStableDetentIndex = screen.getSheetInitialDetentIndex();
        this.lastStableState = SheetUtils.INSTANCE.sheetStateFromDetentIndex(screen.getSheetInitialDetentIndex(), screen.getSheetDetents().size());
        SheetStateObserver sheetStateObserver = new SheetStateObserver();
        this.sheetStateObserver = sheetStateObserver;
        this.keyboardHandlerCallback = new KeyboardHandler();
        boolean z = screen.getFragment() instanceof ScreenStackFragment;
        Fragment fragment = screen.getFragment();
        Intrinsics.checkNotNull(fragment);
        fragment.getLifecycle().addObserver(this);
        BottomSheetBehavior<Screen> sheetBehavior = getSheetBehavior();
        if (sheetBehavior == null) {
            throw new IllegalStateException("[RNScreens] Sheet delegate accepts screen with initialized sheet behaviour only.");
        }
        sheetBehavior.addBottomSheetCallback(sheetStateObserver);
    }

    public final Screen getScreen() {
        return this.screen;
    }

    public final int getLastStableDetentIndex() {
        return this.lastStableDetentIndex;
    }

    public final int getLastStableState() {
        return this.lastStableState;
    }

    private final BottomSheetBehavior<Screen> getSheetBehavior() {
        return this.screen.getSheetBehavior();
    }

    private final ScreenStackFragment getStackFragment() {
        Fragment fragment = this.screen.getFragment();
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.swmansion.rnscreens.ScreenStackFragment");
        return (ScreenStackFragment) fragment;
    }

    private final View requireDecorView() {
        Activity currentActivity = this.screen.getReactContext().getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("[RNScreens] Attempt to access activity on detached context");
        }
        View decorView = currentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        return decorView;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            handleHostFragmentOnStart();
        } else if (i == 2) {
            handleHostFragmentOnResume();
        } else {
            if (i != 3) {
                return;
            }
            handleHostFragmentOnPause();
        }
    }

    private final void handleHostFragmentOnStart() {
        InsetsObserverProxy.INSTANCE.registerOnView(requireDecorView());
    }

    private final void handleHostFragmentOnResume() {
        InsetsObserverProxy.INSTANCE.addOnApplyWindowInsetsListener(this);
    }

    private final void handleHostFragmentOnPause() {
        InsetsObserverProxy.INSTANCE.removeOnApplyWindowInsetsListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSheetStateChanged(int i) {
        SheetUtils sheetUtils = SheetUtils.INSTANCE;
        boolean zIsStateStable = sheetUtils.isStateStable(i);
        if (zIsStateStable) {
            this.lastStableState = i;
            this.lastStableDetentIndex = sheetUtils.detentIndexFromSheetState(i, this.screen.getSheetDetents().size());
        }
        this.screen.onSheetDetentChanged$react_native_screens_release(this.lastStableDetentIndex, zIsStateStable);
        if (shouldDismissSheetInState(i)) {
            getStackFragment().dismissSelf$react_native_screens_release();
        }
    }

    public static /* synthetic */ BottomSheetBehavior configureBottomSheetBehaviour$react_native_screens_release$default(SheetDelegate sheetDelegate, BottomSheetBehavior bottomSheetBehavior, KeyboardState keyboardState, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            keyboardState = KeyboardNotVisible.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            i = sheetDelegate.lastStableDetentIndex;
        }
        return sheetDelegate.configureBottomSheetBehaviour$react_native_screens_release(bottomSheetBehavior, keyboardState, i);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0154  */
    public final BottomSheetBehavior<Screen> configureBottomSheetBehaviour$react_native_screens_release(@NotNull BottomSheetBehavior<Screen> behavior, @NotNull KeyboardState keyboardState, int i) {
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        Intrinsics.checkNotNullParameter(keyboardState, "keyboardState");
        Integer numTryResolveContainerHeight = tryResolveContainerHeight();
        if (numTryResolveContainerHeight == null) {
            throw new IllegalStateException("[RNScreens] Failed to find window height during bottom sheet behaviour configuration");
        }
        behavior.setHideable(true);
        behavior.setDraggable(true);
        behavior.addBottomSheetCallback(this.sheetStateObserver);
        ScreenFooter footer = this.screen.getFooter();
        if (footer != null) {
            footer.registerWithSheetBehavior(behavior);
        }
        if (keyboardState instanceof KeyboardNotVisible) {
            int size = this.screen.getSheetDetents().size();
            if (size != 1) {
                if (size == 2) {
                    return BottomSheetBehaviorExtKt.useTwoDetents(behavior, Integer.valueOf(SheetUtils.INSTANCE.sheetStateFromDetentIndex(i, this.screen.getSheetDetents().size())), Integer.valueOf((int) (this.screen.getSheetDetents().get(0).doubleValue() * ((double) numTryResolveContainerHeight.intValue()))), Integer.valueOf((int) (this.screen.getSheetDetents().get(1).doubleValue() * ((double) numTryResolveContainerHeight.intValue()))));
                }
                if (size == 3) {
                    return BottomSheetBehaviorExtKt.useThreeDetents(behavior, Integer.valueOf(SheetUtils.INSTANCE.sheetStateFromDetentIndex(i, this.screen.getSheetDetents().size())), Integer.valueOf((int) (this.screen.getSheetDetents().get(0).doubleValue() * ((double) numTryResolveContainerHeight.intValue()))), Float.valueOf((float) (this.screen.getSheetDetents().get(1).doubleValue() / this.screen.getSheetDetents().get(2).doubleValue())), Integer.valueOf((int) ((((double) 1) - this.screen.getSheetDetents().get(2).doubleValue()) * ((double) numTryResolveContainerHeight.intValue()))));
                }
                throw new IllegalStateException("[RNScreens] Invalid detent count " + this.screen.getSheetDetents().size() + ". Expected at most 3.");
            }
            if (SheetUtilsKt.isSheetFitToContents(this.screen)) {
                ScreenContentWrapper contentWrapper = this.screen.getContentWrapper();
                if (contentWrapper != null) {
                    numValueOf = Integer.valueOf(contentWrapper.getHeight());
                    if (!SheetUtilsKt.isLaidOutOrHasCachedLayout(contentWrapper)) {
                        numValueOf = null;
                    }
                } else {
                    numValueOf = null;
                }
            } else {
                numValueOf = Integer.valueOf((int) (((Number) CollectionsKt___CollectionsKt.first((List) this.screen.getSheetDetents())).doubleValue() * ((double) numTryResolveContainerHeight.intValue())));
            }
            BottomSheetBehaviorExtKt.useSingleDetent$default(behavior, numValueOf, false, 2, null);
        } else if (keyboardState instanceof KeyboardVisible) {
            int size2 = this.screen.getSheetDetents().size();
            if (size2 == 1) {
                behavior.addBottomSheetCallback(this.keyboardHandlerCallback);
            } else if (size2 == 2) {
                BottomSheetBehaviorExtKt.useTwoDetents$default(behavior, 3, null, null, 6, null);
                behavior.addBottomSheetCallback(this.keyboardHandlerCallback);
            } else if (size2 == 3) {
                BottomSheetBehaviorExtKt.useThreeDetents$default(behavior, 3, null, null, null, 14, null);
                behavior.addBottomSheetCallback(this.keyboardHandlerCallback);
            } else {
                throw new IllegalStateException("[RNScreens] Invalid detent count " + this.screen.getSheetDetents().size() + ". Expected at most 3.");
            }
        } else {
            if (!(keyboardState instanceof KeyboardDidHide)) {
                throw new NoWhenBranchMatchedException();
            }
            behavior.removeBottomSheetCallback(this.keyboardHandlerCallback);
            int size3 = this.screen.getSheetDetents().size();
            if (size3 == 1) {
                return BottomSheetBehaviorExtKt.useSingleDetent(behavior, Integer.valueOf((int) (((Number) CollectionsKt___CollectionsKt.first((List) this.screen.getSheetDetents())).doubleValue() * ((double) numTryResolveContainerHeight.intValue()))), false);
            }
            if (size3 == 2) {
                return BottomSheetBehaviorExtKt.useTwoDetents$default(behavior, null, Integer.valueOf((int) (this.screen.getSheetDetents().get(0).doubleValue() * ((double) numTryResolveContainerHeight.intValue()))), Integer.valueOf((int) (this.screen.getSheetDetents().get(1).doubleValue() * ((double) numTryResolveContainerHeight.intValue()))), 1, null);
            }
            if (size3 == 3) {
                return BottomSheetBehaviorExtKt.useThreeDetents$default(behavior, null, Integer.valueOf((int) (this.screen.getSheetDetents().get(0).doubleValue() * ((double) numTryResolveContainerHeight.intValue()))), Float.valueOf((float) (this.screen.getSheetDetents().get(1).doubleValue() / this.screen.getSheetDetents().get(2).doubleValue())), Integer.valueOf((int) ((((double) 1) - this.screen.getSheetDetents().get(2).doubleValue()) * ((double) numTryResolveContainerHeight.intValue()))), 1, null);
            }
            throw new IllegalStateException("[RNScreens] Invalid detent count " + this.screen.getSheetDetents().size() + ". Expected at most 3.");
        }
        return behavior;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(@NotNull View v, @NotNull WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        boolean zIsVisible = insets.isVisible(WindowInsetsCompat.Type.ime());
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.ime());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        if (zIsVisible) {
            this.isKeyboardVisible = true;
            this.keyboardState = new KeyboardVisible(insets2.bottom);
            BottomSheetBehavior<Screen> sheetBehavior = getSheetBehavior();
            if (sheetBehavior != null) {
                configureBottomSheetBehaviour$react_native_screens_release$default(this, sheetBehavior, this.keyboardState, 0, 4, null);
            }
            Insets insets3 = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            Intrinsics.checkNotNullExpressionValue(insets3, "getInsets(...)");
            WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder(insets).setInsets(WindowInsetsCompat.Type.navigationBars(), Insets.of(insets3.left, insets3.top, insets3.right, 0)).build();
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatBuild, "build(...)");
            return windowInsetsCompatBuild;
        }
        BottomSheetBehavior<Screen> sheetBehavior2 = getSheetBehavior();
        if (sheetBehavior2 != null) {
            if (this.isKeyboardVisible) {
                configureBottomSheetBehaviour$react_native_screens_release$default(this, sheetBehavior2, KeyboardDidHide.INSTANCE, 0, 4, null);
            } else {
                KeyboardState keyboardState = this.keyboardState;
                KeyboardNotVisible keyboardNotVisible = KeyboardNotVisible.INSTANCE;
                if (!Intrinsics.areEqual(keyboardState, keyboardNotVisible)) {
                    configureBottomSheetBehaviour$react_native_screens_release$default(this, sheetBehavior2, keyboardNotVisible, 0, 4, null);
                }
            }
        }
        this.keyboardState = KeyboardNotVisible.INSTANCE;
        this.isKeyboardVisible = false;
        Insets insets4 = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
        Intrinsics.checkNotNullExpressionValue(insets4, "getInsets(...)");
        WindowInsetsCompat windowInsetsCompatBuild2 = new WindowInsetsCompat.Builder(insets).setInsets(WindowInsetsCompat.Type.navigationBars(), Insets.of(insets4.left, insets4.top, insets4.right, 0)).build();
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatBuild2, "build(...)");
        return windowInsetsCompatBuild2;
    }

    private final Integer tryResolveContainerHeight() {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        DisplayMetrics displayMetrics;
        ScreenContainer container = this.screen.getContainer();
        if (container != null) {
            return Integer.valueOf(container.getHeight());
        }
        ThemedReactContext reactContext = this.screen.getReactContext();
        Resources resources = reactContext.getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            return Integer.valueOf(displayMetrics.heightPixels);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            Object systemService = reactContext.getSystemService("window");
            WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            if (windowManager != null && (currentWindowMetrics = windowManager.getCurrentWindowMetrics()) != null && (bounds = currentWindowMetrics.getBounds()) != null) {
                return Integer.valueOf(bounds.height());
            }
        }
        return null;
    }

    final class KeyboardHandler extends BottomSheetBehavior.BottomSheetCallback {
        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NotNull View bottomSheet, float f) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        public KeyboardHandler() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NotNull View bottomSheet, int i) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (i == 4 && WindowInsetsCompat.toWindowInsetsCompat(bottomSheet.getRootWindowInsets()).isVisible(WindowInsetsCompat.Type.ime())) {
                bottomSheet.requestFocus();
                ((InputMethodManager) SheetDelegate.this.getScreen().getReactContext().getSystemService(InputMethodManager.class)).hideSoftInputFromWindow(bottomSheet.getWindowToken(), 0);
            }
        }
    }

    final class SheetStateObserver extends BottomSheetBehavior.BottomSheetCallback {
        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NotNull View bottomSheet, float f) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        public SheetStateObserver() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NotNull View bottomSheet, int i) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            SheetDelegate.this.onSheetStateChanged(i);
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
