package com.th3rdwave.safeareacontext;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.views.view.ReactViewGroup;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SafeAreaView extends ReactViewGroup implements ViewTreeObserver.OnPreDrawListener {
    private SafeAreaViewEdges mEdges;
    private EdgeInsets mInsets;
    private SafeAreaViewMode mMode;
    private View mProviderView;
    private StateWrapper mStateWrapper;

    public SafeAreaView(@Nullable Context context) {
        super(context);
        this.mMode = SafeAreaViewMode.PADDING;
    }

    public final StateWrapper getStateWrapper() {
        return this.mStateWrapper;
    }

    public final void setStateWrapper(@Nullable StateWrapper stateWrapper) {
        this.mStateWrapper = stateWrapper;
    }

    private final void updateInsets() {
        EdgeInsets edgeInsets = this.mInsets;
        if (edgeInsets != null) {
            SafeAreaViewEdges safeAreaViewEdges = this.mEdges;
            if (safeAreaViewEdges == null) {
                SafeAreaViewEdgeModes safeAreaViewEdgeModes = SafeAreaViewEdgeModes.ADDITIVE;
                safeAreaViewEdges = new SafeAreaViewEdges(safeAreaViewEdgeModes, safeAreaViewEdgeModes, safeAreaViewEdgeModes, safeAreaViewEdgeModes);
            }
            StateWrapper stateWrapper = getStateWrapper();
            if (stateWrapper != null) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putMap("insets", SerializationUtilsKt.edgeInsetsToJsMap(edgeInsets));
                stateWrapper.updateState(writableMapCreateMap);
                return;
            }
            SafeAreaViewLocalData safeAreaViewLocalData = new SafeAreaViewLocalData(edgeInsets, this.mMode, safeAreaViewEdges);
            ReactContext reactContext = UIManagerHelperCompatKt.getReactContext(this);
            final UIManagerModule uIManagerModule = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
            if (uIManagerModule != null) {
                uIManagerModule.setViewLocalData(getId(), safeAreaViewLocalData);
                reactContext.runOnNativeModulesQueueThread(new Runnable() { // from class: com.th3rdwave.safeareacontext.SafeAreaView$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SafeAreaView.updateInsets$lambda$0(uIManagerModule);
                    }
                });
                waitForReactLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateInsets$lambda$0(UIManagerModule uIManagerModule) {
        uIManagerModule.getUIImplementation().dispatchViewUpdates(-1);
    }

    private final void waitForReactLayout() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition conditionNewCondition = reentrantLock.newCondition();
        long jNanoTime = System.nanoTime();
        UIManagerHelperCompatKt.getReactContext(this).runOnNativeModulesQueueThread(new Runnable() { // from class: com.th3rdwave.safeareacontext.SafeAreaView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SafeAreaView.waitForReactLayout$lambda$2(reentrantLock, booleanRef, conditionNewCondition);
            }
        });
        reentrantLock.lock();
        long jNanoTime2 = 0;
        while (!booleanRef.element && jNanoTime2 < 500000000) {
            try {
                try {
                    conditionNewCondition.awaitNanos(500000000L);
                } catch (InterruptedException unused) {
                    booleanRef.element = true;
                }
                jNanoTime2 += System.nanoTime() - jNanoTime;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        Unit unit = Unit.INSTANCE;
        reentrantLock.unlock();
        if (jNanoTime2 >= 500000000) {
            SentryLogcatAdapter.w("SafeAreaView", "Timed out waiting for layout.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void waitForReactLayout$lambda$2(ReentrantLock reentrantLock, Ref.BooleanRef booleanRef, Condition condition) {
        reentrantLock.lock();
        try {
            if (!booleanRef.element) {
                booleanRef.element = true;
                condition.signal();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void setMode(@NotNull SafeAreaViewMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.mMode = mode;
        updateInsets();
    }

    public final void setEdges(@NotNull SafeAreaViewEdges edges) {
        Intrinsics.checkNotNullParameter(edges, "edges");
        this.mEdges = edges;
        updateInsets();
    }

    private final boolean maybeUpdateInsets() {
        EdgeInsets safeAreaInsets;
        View view = this.mProviderView;
        if (view == null || (safeAreaInsets = SafeAreaUtilsKt.getSafeAreaInsets(view)) == null || Intrinsics.areEqual(this.mInsets, safeAreaInsets)) {
            return false;
        }
        this.mInsets = safeAreaInsets;
        updateInsets();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View findProvider() {
        for (ViewParent parent = getParent(); parent != 0; parent = parent.getParent()) {
            if (parent instanceof SafeAreaProvider) {
                return (View) parent;
            }
        }
        return this;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        ViewTreeObserver viewTreeObserver;
        super.onAttachedToWindow();
        View viewFindProvider = findProvider();
        this.mProviderView = viewFindProvider;
        if (viewFindProvider != null && (viewTreeObserver = viewFindProvider.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnPreDrawListener(this);
        }
        maybeUpdateInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver;
        super.onDetachedFromWindow();
        View view = this.mProviderView;
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
        this.mProviderView = null;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean zMaybeUpdateInsets = maybeUpdateInsets();
        if (zMaybeUpdateInsets) {
            requestLayout();
        }
        return !zMaybeUpdateInsets;
    }
}
