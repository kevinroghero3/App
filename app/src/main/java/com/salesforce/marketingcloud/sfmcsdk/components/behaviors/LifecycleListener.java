package com.salesforce.marketingcloud.sfmcsdk.components.behaviors;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class LifecycleListener implements DefaultLifecycleObserver, Application.ActivityLifecycleCallbacks {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "~$LifecycleListener";
    private static LifecycleListener instance;
    private Context context;
    private AtomicBoolean inForeground;

    public /* synthetic */ LifecycleListener(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    private LifecycleListener(Context context) {
        this.context = context;
        this.inForeground = new AtomicBoolean(false);
    }

    public final AtomicBoolean getInForeground() {
        return this.inForeground;
    }

    public final void setInForeground(@NotNull AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.inForeground = atomicBoolean;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LifecycleListener getInstance$sfmcsdk_release() {
            return LifecycleListener.instance;
        }

        public final void setInstance$sfmcsdk_release(@Nullable LifecycleListener lifecycleListener) {
            LifecycleListener.instance = lifecycleListener;
        }

        public final LifecycleListener getInstance(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (getInstance$sfmcsdk_release() == null) {
                setInstance$sfmcsdk_release(new LifecycleListener(context, null));
            }
            LifecycleListener instance$sfmcsdk_release = getInstance$sfmcsdk_release();
            Intrinsics.checkNotNull(instance$sfmcsdk_release, "null cannot be cast to non-null type com.salesforce.marketingcloud.sfmcsdk.components.behaviors.LifecycleListener");
            return instance$sfmcsdk_release;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStart(owner);
        if (this.inForeground.getAndSet(true)) {
            return;
        }
        SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.behaviors.LifecycleListener.onStart.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Application came into the foreground.";
            }
        });
        BehaviorManagerImpl.Companion.notifyBehavior$sfmcsdk_release(this.context, BehaviorType.APPLICATION_FOREGROUNDED, new Bundle());
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (this.inForeground.getAndSet(false)) {
            SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.behaviors.LifecycleListener.onStop.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Application went into the background.";
                }
            });
            BehaviorManagerImpl.Companion.notifyBehavior$sfmcsdk_release(this.context, BehaviorType.APPLICATION_BACKGROUNDED, new Bundle());
        }
        super.onStop(owner);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BehaviorManagerImpl.Companion companion = BehaviorManagerImpl.Companion;
        Context context = this.context;
        BehaviorType behaviorType = BehaviorType.SCREEN_ENTRY;
        Bundle bundle = new Bundle();
        bundle.putString("screen_name", Reflection.getOrCreateKotlinClass(activity.getClass()).getSimpleName());
        Unit unit = Unit.INSTANCE;
        companion.notifyBehavior$sfmcsdk_release(context, behaviorType, bundle);
    }
}
