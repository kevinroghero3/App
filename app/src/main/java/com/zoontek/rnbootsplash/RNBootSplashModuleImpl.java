package com.zoontek.rnbootsplash;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.window.SplashScreen;
import android.window.SplashScreenView;
import androidx.annotation.StyleRes;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.PixelUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class RNBootSplashModuleImpl {
    public static final String NAME = "RNBootSplash";
    private static RNBootSplashDialog mFadeOutDialog;
    private static RNBootSplashDialog mInitialDialog;
    public static final RNBootSplashModuleImpl INSTANCE = new RNBootSplashModuleImpl();
    private static final RNBootSplashQueue<Promise> mPromiseQueue = new RNBootSplashQueue<>();
    private static Status mStatus = Status.HIDDEN;
    private static int mThemeResId = -1;

    /* JADX INFO: loaded from: classes3.dex */
    enum Status {
        HIDDEN,
        HIDING,
        INITIALIZING,
        VISIBLE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }
    }

    private RNBootSplashModuleImpl() {
    }

    public final void init$react_native_bootsplash_release(@Nullable final Activity activity, @StyleRes int i) {
        int i2;
        if (mThemeResId != -1) {
            FLog.w(ReactConstants.TAG, "RNBootSplash: Ignored initialization, module is already initialized.");
            return;
        }
        mThemeResId = i;
        if (activity == null) {
            FLog.w(ReactConstants.TAG, "RNBootSplash: Ignored initialization, current activity is null.");
            return;
        }
        TypedValue typedValue = new TypedValue();
        if (activity.getTheme().resolveAttribute(R.attr.postBootSplashTheme, typedValue, true) && (i2 = typedValue.resourceId) != 0) {
            activity.setTheme(i2);
        }
        final View viewFindViewById = activity.findViewById(android.R.id.content);
        mStatus = Status.INITIALIZING;
        viewFindViewById.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$init$1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (RNBootSplashModuleImpl.mStatus == RNBootSplashModuleImpl.Status.INITIALIZING) {
                    return false;
                }
                viewFindViewById.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
        if (Build.VERSION.SDK_INT >= 31) {
            activity.getSplashScreen().setOnExitAnimationListener(new SplashScreen.OnExitAnimationListener() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$$ExternalSyntheticLambda5
                @Override // android.window.SplashScreen.OnExitAnimationListener
                public final void onSplashScreenExit(SplashScreenView splashScreenView) {
                    RNBootSplashModuleImpl.init$lambda$0(activity, splashScreenView);
                }
            });
        }
        mInitialDialog = new RNBootSplashDialog(activity, mThemeResId, false);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                RNBootSplashModuleImpl.init$lambda$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(Activity activity, SplashScreenView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.remove();
        activity.getSplashScreen().clearOnExitAnimationListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2() {
        RNBootSplashDialog rNBootSplashDialog = mInitialDialog;
        if (rNBootSplashDialog != null) {
            rNBootSplashDialog.show(new Function0() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return RNBootSplashModuleImpl.init$lambda$2$lambda$1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$2$lambda$1() {
        mStatus = Status.VISIBLE;
        return Unit.INSTANCE;
    }

    private final void clearPromiseQueue() {
        while (true) {
            RNBootSplashQueue<Promise> rNBootSplashQueue = mPromiseQueue;
            if (rNBootSplashQueue.isEmpty()) {
                return;
            }
            Promise promiseShift = rNBootSplashQueue.shift();
            if (promiseShift != null) {
                promiseShift.resolve(Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideAndClearPromiseQueue(final ReactApplicationContext reactApplicationContext, final boolean z) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                RNBootSplashModuleImpl.hideAndClearPromiseQueue$lambda$6(reactApplicationContext, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideAndClearPromiseQueue$lambda$6(final ReactApplicationContext reactApplicationContext, final boolean z) {
        Activity currentActivity = reactApplicationContext.getCurrentActivity();
        if (mStatus == Status.INITIALIZING || currentActivity == null || currentActivity.isFinishing() || currentActivity.isDestroyed()) {
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$hideAndClearPromiseQueue$1$1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    timer.cancel();
                    RNBootSplashModuleImpl.INSTANCE.hideAndClearPromiseQueue(reactApplicationContext, z);
                }
            }, 100L);
            return;
        }
        Status status = mStatus;
        Status status2 = Status.HIDING;
        if (status == status2) {
            return;
        }
        if (mStatus == Status.HIDDEN) {
            INSTANCE.clearPromiseQueue();
            return;
        }
        mStatus = status2;
        Function0<Unit> function0 = new Function0() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RNBootSplashModuleImpl.hideAndClearPromiseQueue$lambda$6$lambda$5();
            }
        };
        if (z) {
            RNBootSplashDialog rNBootSplashDialog = new RNBootSplashDialog(currentActivity, mThemeResId, true);
            mFadeOutDialog = rNBootSplashDialog;
            rNBootSplashDialog.show(function0);
        } else {
            RNBootSplashDialog rNBootSplashDialog2 = mInitialDialog;
            if (rNBootSplashDialog2 != null) {
                rNBootSplashDialog2.dismiss(function0);
            } else {
                function0.invoke();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit hideAndClearPromiseQueue$lambda$6$lambda$5$lambda$3() {
        mFadeOutDialog = null;
        mStatus = Status.HIDDEN;
        INSTANCE.clearPromiseQueue();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit hideAndClearPromiseQueue$lambda$6$lambda$5() {
        final Function0 function0 = new Function0() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RNBootSplashModuleImpl.hideAndClearPromiseQueue$lambda$6$lambda$5$lambda$3();
            }
        };
        Function0<Unit> function1 = new Function0() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RNBootSplashModuleImpl.hideAndClearPromiseQueue$lambda$6$lambda$5$lambda$4(function0);
            }
        };
        RNBootSplashDialog rNBootSplashDialog = mInitialDialog;
        if (rNBootSplashDialog != null) {
            rNBootSplashDialog.dismiss(function1);
        } else {
            function1.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit hideAndClearPromiseQueue$lambda$6$lambda$5$lambda$4(Function0 function0) {
        mInitialDialog = null;
        RNBootSplashDialog rNBootSplashDialog = mFadeOutDialog;
        if (rNBootSplashDialog != null) {
            rNBootSplashDialog.dismiss(function0);
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public final boolean isSamsungOneUI4() {
        Object objM5472constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(Boolean.valueOf((Build.VERSION.class.getDeclaredField("SEM_PLATFORM_INT").getInt(null) - 90000) / 10000 == 4));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.m5478isFailureimpl(objM5472constructorimpl)) {
            objM5472constructorimpl = bool;
        }
        return ((Boolean) objM5472constructorimpl).booleanValue();
    }

    public final void onHostDestroy$react_native_bootsplash_release() {
        mStatus = Status.HIDDEN;
        mThemeResId = -1;
        clearPromiseQueue();
        RNBootSplashDialog rNBootSplashDialog = mInitialDialog;
        if (rNBootSplashDialog != null) {
            rNBootSplashDialog.dismiss();
            mInitialDialog = null;
        }
        RNBootSplashDialog rNBootSplashDialog2 = mFadeOutDialog;
        if (rNBootSplashDialog2 != null) {
            rNBootSplashDialog2.dismiss();
            mFadeOutDialog = null;
        }
    }

    public final Map<String, Object> getConstants(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Resources resources = reactContext.getResources();
        HashMap map = new HashMap();
        int i = reactContext.getResources().getConfiguration().uiMode;
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        int identifier2 = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        float dIPFromPixel = 0.0f;
        float dIPFromPixel2 = identifier > 0 ? PixelUtil.toDIPFromPixel(resources.getDimensionPixelSize(identifier)) : 0.0f;
        if (identifier2 > 0 && !ViewConfiguration.get(reactContext).hasPermanentMenuKey()) {
            dIPFromPixel = PixelUtil.toDIPFromPixel(resources.getDimensionPixelSize(identifier2));
        }
        map.put("darkModeEnabled", Boolean.valueOf((i & 48) == 32));
        map.put("logoSizeRatio", Double.valueOf(isSamsungOneUI4() ? 0.5d : 1.0d));
        map.put("navigationBarHeight", Float.valueOf(dIPFromPixel));
        map.put("statusBarHeight", Float.valueOf(dIPFromPixel2));
        return map;
    }

    public final void hide(@NotNull ReactApplicationContext reactContext, boolean z, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(promise, "promise");
        mPromiseQueue.push(promise);
        hideAndClearPromiseQueue(reactContext, z);
    }

    public final void isVisible(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Boolean.valueOf(mStatus != Status.HIDDEN));
    }
}
