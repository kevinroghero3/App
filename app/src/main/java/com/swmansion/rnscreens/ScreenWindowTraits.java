package com.swmansion.rnscreens;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.rnscreens.utils.EdgeToEdgePackageDetector;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ScreenWindowTraits {
    private static Integer defaultStatusBarColor;
    private static boolean didSetNavigationBarAppearance;
    private static boolean didSetOrientation;
    private static boolean didSetStatusBarAppearance;
    public static final ScreenWindowTraits INSTANCE = new ScreenWindowTraits();
    private static ScreenWindowTraits$windowInsetsListener$1 windowInsetsListener = new OnApplyWindowInsetsListener() { // from class: com.swmansion.rnscreens.ScreenWindowTraits$windowInsetsListener$1
        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
            Intrinsics.checkNotNullParameter(v, "v");
            Intrinsics.checkNotNullParameter(insets, "insets");
            WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = ViewCompat.onApplyWindowInsets(v, insets);
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatOnApplyWindowInsets, "onApplyWindowInsets(...)");
            if (Build.VERSION.SDK_INT >= 30) {
                Insets insets2 = windowInsetsCompatOnApplyWindowInsets.getInsets(WindowInsetsCompat.Type.statusBars());
                Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
                WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setInsets(WindowInsetsCompat.Type.statusBars(), Insets.of(insets2.left, 0, insets2.right, insets2.bottom)).build();
                Intrinsics.checkNotNullExpressionValue(windowInsetsCompatBuild, "build(...)");
                return windowInsetsCompatBuild;
            }
            WindowInsetsCompat windowInsetsCompatReplaceSystemWindowInsets = windowInsetsCompatOnApplyWindowInsets.replaceSystemWindowInsets(windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetLeft(), 0, windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetRight(), windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetBottom());
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatReplaceSystemWindowInsets, "replaceSystemWindowInsets(...)");
            return windowInsetsCompatReplaceSystemWindowInsets;
        }
    };

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Screen.WindowTraits.values().length];
            try {
                iArr[Screen.WindowTraits.ORIENTATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Screen.WindowTraits.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Screen.WindowTraits.STYLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Screen.WindowTraits.TRANSLUCENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Screen.WindowTraits.HIDDEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Screen.WindowTraits.ANIMATED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Screen.WindowTraits.NAVIGATION_BAR_COLOR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Screen.WindowTraits.NAVIGATION_BAR_TRANSLUCENT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Screen.WindowTraits.NAVIGATION_BAR_HIDDEN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ScreenWindowTraits() {
    }

    public final void applyDidSetOrientation$react_native_screens_release() {
        didSetOrientation = true;
    }

    public final void applyDidSetStatusBarAppearance$react_native_screens_release() {
        didSetStatusBarAppearance = true;
    }

    public final void applyDidSetNavigationBarAppearance$react_native_screens_release() {
        didSetNavigationBarAppearance = true;
    }

    public final void setOrientation$react_native_screens_release(@NotNull Screen screen, @Nullable Activity activity) {
        Integer screenOrientation;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null) {
            return;
        }
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.ORIENTATION);
        activity.setRequestedOrientation((screenFindScreenForTrait == null || (screenOrientation = screenFindScreenForTrait.getScreenOrientation()) == null) ? -1 : screenOrientation.intValue());
    }

    @Deprecated(message = "For apps targeting SDK 35 or above this prop has no effect because edge-to-edge is enabled by default and the status bar is always translucent.")
    public final void setColor$react_native_screens_release(@NotNull Screen screen, @Nullable Activity activity, @Nullable ReactContext reactContext) {
        Integer statusBarColor;
        Boolean boolIsStatusBarAnimated;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null || reactContext == null) {
            return;
        }
        if (defaultStatusBarColor == null) {
            defaultStatusBarColor = Integer.valueOf(activity.getWindow().getStatusBarColor());
        }
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.COLOR);
        Screen screenFindScreenForTrait2 = findScreenForTrait(screen, Screen.WindowTraits.ANIMATED);
        if (screenFindScreenForTrait == null || (statusBarColor = screenFindScreenForTrait.getStatusBarColor()) == null) {
            statusBarColor = defaultStatusBarColor;
        }
        UiThreadUtil.runOnUiThread(new ScreenWindowTraits$setColor$1(activity, statusBarColor, (screenFindScreenForTrait2 == null || (boolIsStatusBarAnimated = screenFindScreenForTrait2.isStatusBarAnimated()) == null) ? false : boolIsStatusBarAnimated.booleanValue(), reactContext.getExceptionHandler()));
    }

    public final void setStyle$react_native_screens_release(@NotNull Screen screen, @Nullable final Activity activity, @Nullable ReactContext reactContext) {
        final String statusBarStyle;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null || reactContext == null) {
            return;
        }
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.STYLE);
        if (screenFindScreenForTrait == null || (statusBarStyle = screenFindScreenForTrait.getStatusBarStyle()) == null) {
            statusBarStyle = "light";
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.rnscreens.ScreenWindowTraits$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ScreenWindowTraits.setStyle$lambda$0(activity, statusBarStyle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStyle$lambda$0(Activity activity, String str) {
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        new WindowInsetsControllerCompat(activity.getWindow(), decorView).setAppearanceLightStatusBars(Intrinsics.areEqual(str, "dark"));
    }

    @Deprecated(message = "For apps targeting SDK 35 or above this prop has no effect because edge-to-edge is enabled by default and the status bar is always translucent.")
    public final void setTranslucent$react_native_screens_release(@NotNull Screen screen, @Nullable final Activity activity, @Nullable ReactContext reactContext) {
        Boolean boolIsStatusBarTranslucent;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null || reactContext == null || EdgeToEdgePackageDetector.INSTANCE.getENABLED()) {
            return;
        }
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.TRANSLUCENT);
        final boolean zBooleanValue = (screenFindScreenForTrait == null || (boolIsStatusBarTranslucent = screenFindScreenForTrait.isStatusBarTranslucent()) == null) ? false : boolIsStatusBarTranslucent.booleanValue();
        final JSExceptionHandler exceptionHandler = reactContext.getExceptionHandler();
        UiThreadUtil.runOnUiThread(new GuardedRunnable(exceptionHandler) { // from class: com.swmansion.rnscreens.ScreenWindowTraits$setTranslucent$1
            @Override // com.facebook.react.bridge.GuardedRunnable
            public void runGuarded() {
                View decorView = activity.getWindow().getDecorView();
                Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
                if (!zBooleanValue) {
                    InsetsObserverProxy.INSTANCE.removeOnApplyWindowInsetsListener(ScreenWindowTraits.windowInsetsListener);
                } else {
                    InsetsObserverProxy insetsObserverProxy = InsetsObserverProxy.INSTANCE;
                    insetsObserverProxy.registerOnView(decorView);
                    insetsObserverProxy.addOnApplyWindowInsetsListener(ScreenWindowTraits.windowInsetsListener);
                }
                ViewCompat.requestApplyInsets(decorView);
            }
        });
    }

    public final void setHidden$react_native_screens_release(@NotNull Screen screen, @Nullable Activity activity) {
        Boolean boolIsStatusBarHidden;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null) {
            return;
        }
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.HIDDEN);
        final boolean zBooleanValue = (screenFindScreenForTrait == null || (boolIsStatusBarHidden = screenFindScreenForTrait.isStatusBarHidden()) == null) ? false : boolIsStatusBarHidden.booleanValue();
        Window window = activity.getWindow();
        final WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.rnscreens.ScreenWindowTraits$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ScreenWindowTraits.setHidden$lambda$1(zBooleanValue, windowInsetsControllerCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHidden$lambda$1(boolean z, WindowInsetsControllerCompat windowInsetsControllerCompat) {
        if (z) {
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.statusBars());
        } else {
            windowInsetsControllerCompat.show(WindowInsetsCompat.Type.statusBars());
        }
    }

    @Deprecated(message = "For all apps targeting Android SDK 35 or above edge-to-edge is enabled by default. ")
    public final void setNavigationBarColor$react_native_screens_release(@NotNull Screen screen, @Nullable Activity activity) {
        Integer navigationBarColor;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null) {
            return;
        }
        final Window window = activity.getWindow();
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.NAVIGATION_BAR_COLOR);
        final int navigationBarColor2 = (screenFindScreenForTrait == null || (navigationBarColor = screenFindScreenForTrait.getNavigationBarColor()) == null) ? window.getNavigationBarColor() : navigationBarColor.intValue();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.rnscreens.ScreenWindowTraits$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ScreenWindowTraits.setNavigationBarColor$lambda$2(window, navigationBarColor2);
            }
        });
        window.setNavigationBarColor(navigationBarColor2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigationBarColor$lambda$2(Window window, int i) {
        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightNavigationBars(INSTANCE.isColorLight(i));
    }

    @Deprecated(message = "For all apps targeting Android SDK 35 or above edge-to-edge is enabled by default. ")
    public final void setNavigationBarTranslucent$react_native_screens_release(@NotNull Screen screen, @Nullable Activity activity) {
        Boolean boolIsNavigationBarTranslucent;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null || EdgeToEdgePackageDetector.INSTANCE.getENABLED()) {
            return;
        }
        Window window = activity.getWindow();
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.NAVIGATION_BAR_TRANSLUCENT);
        if (screenFindScreenForTrait == null || (boolIsNavigationBarTranslucent = screenFindScreenForTrait.isNavigationBarTranslucent()) == null) {
            return;
        }
        WindowCompat.setDecorFitsSystemWindows(window, !boolIsNavigationBarTranslucent.booleanValue());
    }

    public final void setNavigationBarHidden$react_native_screens_release(@NotNull Screen screen, @Nullable Activity activity) {
        Boolean boolIsNavigationBarHidden;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.NAVIGATION_BAR_HIDDEN);
        if (screenFindScreenForTrait != null && (boolIsNavigationBarHidden = screenFindScreenForTrait.isNavigationBarHidden()) != null && boolIsNavigationBarHidden.booleanValue()) {
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.navigationBars());
            windowInsetsControllerCompat.setSystemBarsBehavior(2);
            return;
        }
        new WindowInsetsControllerCompat(window, window.getDecorView()).show(WindowInsetsCompat.Type.navigationBars());
    }

    public final void trySetWindowTraits$react_native_screens_release(@NotNull Screen screen, @Nullable Activity activity, @Nullable ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (didSetOrientation) {
            setOrientation$react_native_screens_release(screen, activity);
        }
        if (didSetStatusBarAppearance) {
            setColor$react_native_screens_release(screen, activity, reactContext);
            setStyle$react_native_screens_release(screen, activity, reactContext);
            setTranslucent$react_native_screens_release(screen, activity, reactContext);
            setHidden$react_native_screens_release(screen, activity);
        }
        if (didSetNavigationBarAppearance) {
            setNavigationBarColor$react_native_screens_release(screen, activity);
            setNavigationBarTranslucent$react_native_screens_release(screen, activity);
            setNavigationBarHidden$react_native_screens_release(screen, activity);
        }
    }

    private final Screen findScreenForTrait(Screen screen, Screen.WindowTraits windowTraits) {
        Screen screenChildScreenWithTraitSet = childScreenWithTraitSet(screen, windowTraits);
        if (screenChildScreenWithTraitSet != null) {
            return screenChildScreenWithTraitSet;
        }
        return checkTraitForScreen(screen, windowTraits) ? screen : findParentWithTraitSet(screen, windowTraits);
    }

    private final Screen findParentWithTraitSet(Screen screen, Screen.WindowTraits windowTraits) {
        for (ViewParent container = screen.getContainer(); container != null; container = container.getParent()) {
            if (container instanceof Screen) {
                Screen screen2 = (Screen) container;
                if (checkTraitForScreen(screen2, windowTraits)) {
                    return screen2;
                }
            }
        }
        return null;
    }

    private final Screen childScreenWithTraitSet(Screen screen, Screen.WindowTraits windowTraits) {
        ScreenFragmentWrapper fragmentWrapper;
        if (screen == null || (fragmentWrapper = screen.getFragmentWrapper()) == null) {
            return null;
        }
        Iterator<ScreenContainer> it2 = fragmentWrapper.getChildScreenContainers().iterator();
        while (it2.hasNext()) {
            Screen topScreen = it2.next().getTopScreen();
            ScreenWindowTraits screenWindowTraits = INSTANCE;
            Screen screenChildScreenWithTraitSet = screenWindowTraits.childScreenWithTraitSet(topScreen, windowTraits);
            if (screenChildScreenWithTraitSet != null) {
                return screenChildScreenWithTraitSet;
            }
            if (topScreen != null && screenWindowTraits.checkTraitForScreen(topScreen, windowTraits)) {
                return topScreen;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x004f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0051 A[ORIG_RETURN, RETURN] */
    private final boolean checkTraitForScreen(Screen screen, Screen.WindowTraits windowTraits) {
        switch (WhenMappings.$EnumSwitchMapping$0[windowTraits.ordinal()]) {
            case 1:
                if (screen.getScreenOrientation() != null) {
                    return true;
                }
                return false;
            case 2:
                if (screen.getStatusBarColor() != null) {
                    return true;
                }
                return false;
            case 3:
                if (screen.getStatusBarStyle() != null) {
                    return true;
                }
                return false;
            case 4:
                if (screen.isStatusBarTranslucent() != null) {
                    return true;
                }
                return false;
            case 5:
                if (screen.isStatusBarHidden() != null) {
                    return true;
                }
                return false;
            case 6:
                if (screen.isStatusBarAnimated() != null) {
                    return true;
                }
                return false;
            case 7:
                if (screen.getNavigationBarColor() != null) {
                    return true;
                }
                return false;
            case 8:
                if (screen.isNavigationBarTranslucent() != null) {
                    return true;
                }
                return false;
            case 9:
                if (screen.isNavigationBarHidden() != null) {
                    return true;
                }
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean isColorLight(int i) {
        return ((double) 1) - ((((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d)) / ((double) 255)) < 0.5d;
    }
}
