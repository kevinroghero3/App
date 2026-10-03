package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = "RNSModule")
public final class ScreensModule extends NativeScreensModuleSpec {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "RNSModule";
    private final AtomicBoolean isActiveTransition;
    private NativeProxy proxy;
    private final ReactApplicationContext reactContext;
    private int topScreenId;

    public final native void nativeInstall(long j);

    public final native void nativeUninstall();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreensModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.topScreenId = -1;
        this.isActiveTransition = new AtomicBoolean(false);
        try {
            System.loadLibrary("rnscreens");
            JavaScriptContextHolder javaScriptContextHolder = getReactApplicationContext().getJavaScriptContextHolder();
            if (javaScriptContextHolder != null) {
                nativeInstall(javaScriptContextHolder.get());
            } else {
                SentryLogcatAdapter.e("[RNScreens]", "Could not install JSI bindings.");
            }
        } catch (UnsatisfiedLinkError unused) {
            SentryLogcatAdapter.w("[RNScreens]", "Could not load RNScreens module.");
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        NativeProxy nativeProxy = this.proxy;
        if (nativeProxy != null) {
            nativeProxy.invalidateNative();
        }
        nativeUninstall();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
    }

    @Override // com.swmansion.rnscreens.NativeScreensModuleSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNSModule";
    }

    private final int[] startTransition(Integer num) {
        ScreenStack screenStack;
        ArrayList<ScreenStackFragmentWrapper> fragments;
        int size;
        UiThreadUtil.assertOnUiThread();
        if (this.isActiveTransition.get() || num == null) {
            return new int[]{-1, -1};
        }
        this.topScreenId = -1;
        int[] iArr = {-1, -1};
        UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(this.reactContext, num.intValue());
        View viewResolveView = uIManagerForReactTag != null ? uIManagerForReactTag.resolveView(num.intValue()) : null;
        if ((viewResolveView instanceof ScreenStack) && (size = (fragments = (screenStack = (ScreenStack) viewResolveView).getFragments()).size()) > 1) {
            this.isActiveTransition.set(true);
            screenStack.attachBelowTop();
            int id = fragments.get(size - 1).getScreen().getId();
            this.topScreenId = id;
            iArr[0] = id;
            iArr[1] = fragments.get(size - 2).getScreen().getId();
        }
        return iArr;
    }

    private final void updateTransition(double d) {
        UiThreadUtil.assertOnUiThread();
        if (this.topScreenId == -1) {
            return;
        }
        float f = (float) d;
        short coalescingKey = ScreenFragment.Companion.getCoalescingKey(f);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(this.reactContext, this.topScreenId);
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new ScreenTransitionProgressEvent(UIManagerHelper.getSurfaceId(this.reactContext), this.topScreenId, f, true, true, coalescingKey));
        }
    }

    private final void finishTransition(Integer num, boolean z) {
        UiThreadUtil.assertOnUiThread();
        if (!this.isActiveTransition.get() || num == null) {
            SentryLogcatAdapter.e("[RNScreens]", "Unable to call `finishTransition` method before transition start.");
            return;
        }
        UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(this.reactContext, num.intValue());
        View viewResolveView = uIManagerForReactTag != null ? uIManagerForReactTag.resolveView(num.intValue()) : null;
        if (viewResolveView instanceof ScreenStack) {
            if (z) {
                ((ScreenStack) viewResolveView).detachBelowTop();
            } else {
                ((ScreenStack) viewResolveView).notifyTopDetached();
            }
            this.isActiveTransition.set(false);
        }
        this.topScreenId = -1;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
