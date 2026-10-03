package com.facebook.react.runtime;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;

/* JADX INFO: loaded from: classes2.dex */
class ReactLifecycleStateManager {
    private final BridgelessReactStateTracker mBridgelessReactStateTracker;
    LifecycleState mState = LifecycleState.BEFORE_CREATE;

    ReactLifecycleStateManager(BridgelessReactStateTracker bridgelessReactStateTracker) {
        this.mBridgelessReactStateTracker = bridgelessReactStateTracker;
    }

    public LifecycleState getLifecycleState() {
        return this.mState;
    }

    public void resumeReactContextIfHostResumed(ReactContext reactContext, @Nullable Activity activity) {
        if (this.mState == LifecycleState.RESUMED) {
            this.mBridgelessReactStateTracker.enterState("ReactContext.onHostResume()");
            reactContext.onHostResume(activity);
        }
    }

    public void moveToOnHostResume(@Nullable ReactContext reactContext, @Nullable Activity activity) {
        LifecycleState lifecycleState = this.mState;
        LifecycleState lifecycleState2 = LifecycleState.RESUMED;
        if (lifecycleState == lifecycleState2) {
            return;
        }
        if (reactContext != null) {
            this.mBridgelessReactStateTracker.enterState("ReactContext.onHostResume()");
            reactContext.onHostResume(activity);
        }
        this.mState = lifecycleState2;
    }

    public void moveToOnHostPause(@Nullable ReactContext reactContext, @Nullable Activity activity) {
        if (reactContext != null) {
            LifecycleState lifecycleState = this.mState;
            if (lifecycleState == LifecycleState.BEFORE_CREATE) {
                this.mBridgelessReactStateTracker.enterState("ReactContext.onHostResume()");
                reactContext.onHostResume(activity);
                this.mBridgelessReactStateTracker.enterState("ReactContext.onHostPause()");
                reactContext.onHostPause();
            } else if (lifecycleState == LifecycleState.RESUMED) {
                this.mBridgelessReactStateTracker.enterState("ReactContext.onHostPause()");
                reactContext.onHostPause();
            }
        }
        this.mState = LifecycleState.BEFORE_RESUME;
    }

    public void moveToOnHostDestroy(@Nullable ReactContext reactContext) {
        if (reactContext != null) {
            LifecycleState lifecycleState = this.mState;
            if (lifecycleState == LifecycleState.BEFORE_RESUME) {
                this.mBridgelessReactStateTracker.enterState("ReactContext.onHostDestroy()");
                reactContext.onHostDestroy();
            } else if (lifecycleState == LifecycleState.RESUMED) {
                this.mBridgelessReactStateTracker.enterState("ReactContext.onHostPause()");
                reactContext.onHostPause();
                this.mBridgelessReactStateTracker.enterState("ReactContext.onHostDestroy()");
                reactContext.onHostDestroy();
            }
        }
        this.mState = LifecycleState.BEFORE_CREATE;
    }
}
