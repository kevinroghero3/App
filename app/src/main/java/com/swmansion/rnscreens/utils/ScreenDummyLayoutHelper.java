package com.swmansion.rnscreens.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.PixelUtil;
import com.google.android.material.appbar.AppBarLayout;
import com.swmansion.rnscreens.ScreenStackHeaderConfig;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ScreenDummyLayoutHelper implements LifecycleEventListener {
    private static final String DEFAULT_HEADER_TITLE = "FontSize123!#$";
    public static final int FONT_SIZE_UNSET = -1;
    public static final String LIBRARY_NAME = "react_codegen_rnscreens";
    public static final String TAG = "ScreenDummyLayoutHelper";
    private AppBarLayout appBarLayout;
    private CacheEntry cache;
    private CoordinatorLayout coordinatorLayout;
    private int defaultContentInsetStartWithNavigation;
    private float defaultFontSize;
    private View dummyContentView;
    private volatile boolean isLayoutInitialized;
    private WeakReference<ReactApplicationContext> reactContextRef;
    private Toolbar toolbar;
    public static final Companion Companion = new Companion(null);
    private static WeakReference<ScreenDummyLayoutHelper> weakInstance = new WeakReference<>(null);

    @JvmStatic
    public static final ScreenDummyLayoutHelper getInstance() {
        return Companion.getInstance();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    public ScreenDummyLayoutHelper(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.cache = CacheEntry.Companion.getEMPTY();
        this.reactContextRef = new WeakReference<>(reactContext);
        try {
            System.loadLibrary(LIBRARY_NAME);
        } catch (UnsatisfiedLinkError unused) {
            SentryLogcatAdapter.w(TAG, "[RNScreens] Failed to load react_codegen_rnscreens library.");
        }
        weakInstance = new WeakReference<>(this);
        if (reactContext.hasCurrentActivity() && maybeInitDummyLayoutWithHeader(reactContext)) {
            return;
        }
        reactContext.addLifecycleEventListener(this);
    }

    private final boolean maybeInitDummyLayoutWithHeader(ReactApplicationContext reactApplicationContext) {
        if (this.isLayoutInitialized) {
            return true;
        }
        if (!reactApplicationContext.hasCurrentActivity()) {
            return false;
        }
        Activity currentActivity = reactApplicationContext.getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalArgumentException("[RNScreens] Attempt to use context detached from activity. This could happen only due to race-condition.");
        }
        synchronized (this) {
            if (this.isLayoutInitialized) {
                return true;
            }
            initDummyLayoutWithHeader(currentActivity);
            Unit unit = Unit.INSTANCE;
            return true;
        }
    }

    private final void initDummyLayoutWithHeader(Context context) {
        this.coordinatorLayout = new CoordinatorLayout(context);
        AppBarLayout appBarLayout = new AppBarLayout(context);
        appBarLayout.setLayoutParams(new CoordinatorLayout.LayoutParams(-1, -2));
        this.appBarLayout = appBarLayout;
        Toolbar toolbar = new Toolbar(context);
        toolbar.setTitle(DEFAULT_HEADER_TITLE);
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -2);
        layoutParams.setScrollFlags(0);
        toolbar.setLayoutParams(layoutParams);
        this.toolbar = toolbar;
        TextView textViewFindTitleTextViewInToolbar = ScreenStackHeaderConfig.Companion.findTitleTextViewInToolbar(toolbar);
        Intrinsics.checkNotNull(textViewFindTitleTextViewInToolbar);
        this.defaultFontSize = textViewFindTitleTextViewInToolbar.getTextSize();
        Toolbar toolbar2 = this.toolbar;
        View view = null;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            toolbar2 = null;
        }
        this.defaultContentInsetStartWithNavigation = toolbar2.getContentInsetStartWithNavigation();
        AppBarLayout appBarLayout2 = this.appBarLayout;
        if (appBarLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
            appBarLayout2 = null;
        }
        Toolbar toolbar3 = this.toolbar;
        if (toolbar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            toolbar3 = null;
        }
        appBarLayout2.addView(toolbar3);
        View view2 = new View(context);
        view2.setLayoutParams(new CoordinatorLayout.LayoutParams(-1, -1));
        this.dummyContentView = view2;
        CoordinatorLayout coordinatorLayout = this.coordinatorLayout;
        if (coordinatorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
            coordinatorLayout = null;
        }
        AppBarLayout appBarLayout3 = this.appBarLayout;
        if (appBarLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
            appBarLayout3 = null;
        }
        coordinatorLayout.addView(appBarLayout3);
        View view3 = this.dummyContentView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dummyContentView");
        } else {
            view = view3;
        }
        coordinatorLayout.addView(view);
        this.isLayoutInitialized = true;
    }

    private final float computeDummyLayout(int i, boolean z) {
        if (!this.isLayoutInitialized && !maybeInitDummyLayoutWithHeader(requireReactContext(new Function0() { // from class: com.swmansion.rnscreens.utils.ScreenDummyLayoutHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScreenDummyLayoutHelper.computeDummyLayout$lambda$7();
            }
        }))) {
            SentryLogcatAdapter.e(TAG, "[RNScreens] Failed to late-init layout while computing header height. This is most likely a race-condition-bug in react-native-screens, please file an issue at https://github.com/software-mansion/react-native-screens/issues");
            return 0.0f;
        }
        if (this.cache.hasKey(new CacheKey(i, z))) {
            return this.cache.getHeaderHeight();
        }
        View decorView = requireActivity().getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        int width = decorView.getWidth();
        int height = decorView.getHeight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
        AppBarLayout appBarLayout = null;
        if (z) {
            Toolbar toolbar = this.toolbar;
            if (toolbar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
                toolbar = null;
            }
            toolbar.setTitle("");
            Toolbar toolbar2 = this.toolbar;
            if (toolbar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
                toolbar2 = null;
            }
            toolbar2.setContentInsetStartWithNavigation(0);
        } else {
            Toolbar toolbar3 = this.toolbar;
            if (toolbar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
                toolbar3 = null;
            }
            toolbar3.setTitle(DEFAULT_HEADER_TITLE);
            Toolbar toolbar4 = this.toolbar;
            if (toolbar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
                toolbar4 = null;
            }
            toolbar4.setContentInsetStartWithNavigation(this.defaultContentInsetStartWithNavigation);
        }
        ScreenStackHeaderConfig.Companion companion = ScreenStackHeaderConfig.Companion;
        Toolbar toolbar5 = this.toolbar;
        if (toolbar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            toolbar5 = null;
        }
        TextView textViewFindTitleTextViewInToolbar = companion.findTitleTextViewInToolbar(toolbar5);
        if (textViewFindTitleTextViewInToolbar != null) {
            textViewFindTitleTextViewInToolbar.setTextSize(i != -1 ? i : this.defaultFontSize);
        }
        CoordinatorLayout coordinatorLayout = this.coordinatorLayout;
        if (coordinatorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
            coordinatorLayout = null;
        }
        coordinatorLayout.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        CoordinatorLayout coordinatorLayout2 = this.coordinatorLayout;
        if (coordinatorLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
            coordinatorLayout2 = null;
        }
        coordinatorLayout2.layout(0, 0, width, height);
        AppBarLayout appBarLayout2 = this.appBarLayout;
        if (appBarLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        } else {
            appBarLayout = appBarLayout2;
        }
        float dIPFromPixel = PixelUtil.toDIPFromPixel(appBarLayout.getHeight());
        this.cache = new CacheEntry(new CacheKey(i, z), dIPFromPixel);
        return dIPFromPixel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object computeDummyLayout$lambda$7() {
        return "[RNScreens] Context was null-ed before dummy layout was initialized";
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ ReactApplicationContext requireReactContext$default(ScreenDummyLayoutHelper screenDummyLayoutHelper, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return screenDummyLayoutHelper.requireReactContext(function0);
    }

    private final ReactApplicationContext requireReactContext(Function0<? extends Object> function0) {
        ReactApplicationContext reactApplicationContext = this.reactContextRef.get();
        if (function0 == null) {
            function0 = new Function0() { // from class: com.swmansion.rnscreens.utils.ScreenDummyLayoutHelper$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScreenDummyLayoutHelper.requireReactContext$lambda$8();
                }
            };
        }
        if (reactApplicationContext != null) {
            return reactApplicationContext;
        }
        throw new IllegalArgumentException(function0.invoke().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object requireReactContext$lambda$8() {
        return "[RNScreens] Attempt to require missing react context";
    }

    private final Activity requireActivity() {
        Activity currentActivity = requireReactContext$default(this, null, 1, null).getCurrentActivity();
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new IllegalArgumentException("[RNScreens] Attempt to use context detached from activity");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ScreenDummyLayoutHelper getInstance() {
            return (ScreenDummyLayoutHelper) ScreenDummyLayoutHelper.weakInstance.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onHostResume$lambda$10() {
        return "[RNScreens] ReactContext missing in onHostResume! This should not happen.";
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        ReactApplicationContext reactApplicationContextRequireReactContext = requireReactContext(new Function0() { // from class: com.swmansion.rnscreens.utils.ScreenDummyLayoutHelper$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScreenDummyLayoutHelper.onHostResume$lambda$10();
            }
        });
        if (maybeInitDummyLayoutWithHeader(reactApplicationContextRequireReactContext)) {
            reactApplicationContextRequireReactContext.removeLifecycleEventListener(this);
        } else {
            SentryLogcatAdapter.w(TAG, "[RNScreens] Failed to initialise dummy layout in onHostResume.");
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        ReactApplicationContext reactApplicationContext = this.reactContextRef.get();
        if (reactApplicationContext != null) {
            reactApplicationContext.removeLifecycleEventListener(this);
        }
    }
}
