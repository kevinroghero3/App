package com.google.firebase.sessions;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SessionsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public static final SessionsActivityLifecycleCallbacks INSTANCE = new SessionsActivityLifecycleCallbacks();
    private static boolean hasPendingForeground;
    private static SessionLifecycleClient lifecycleClient;

    public static /* synthetic */ void getHasPendingForeground$com_google_firebase_firebase_sessions$annotations() {
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
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    private SessionsActivityLifecycleCallbacks() {
    }

    public final boolean getHasPendingForeground$com_google_firebase_firebase_sessions() {
        return hasPendingForeground;
    }

    public final void setHasPendingForeground$com_google_firebase_firebase_sessions(boolean z) {
        hasPendingForeground = z;
    }

    public final SessionLifecycleClient getLifecycleClient() {
        return lifecycleClient;
    }

    public final void setLifecycleClient(@Nullable SessionLifecycleClient sessionLifecycleClient) {
        lifecycleClient = sessionLifecycleClient;
        if (sessionLifecycleClient == null || !hasPendingForeground) {
            return;
        }
        hasPendingForeground = false;
        sessionLifecycleClient.foregrounded();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Unit unit;
        Intrinsics.checkNotNullParameter(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = lifecycleClient;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.foregrounded();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            hasPendingForeground = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = lifecycleClient;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.backgrounded();
        }
    }
}
