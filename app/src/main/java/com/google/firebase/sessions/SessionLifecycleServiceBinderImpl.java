package com.google.firebase.sessions;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public final class SessionLifecycleServiceBinderImpl implements SessionLifecycleServiceBinder {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "LifecycleServiceBinder";
    private final FirebaseApp firebaseApp;

    public SessionLifecycleServiceBinderImpl(@NotNull FirebaseApp firebaseApp) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        this.firebaseApp = firebaseApp;
    }

    @Override // com.google.firebase.sessions.SessionLifecycleServiceBinder
    public void bindToService(@NotNull Messenger callback, @NotNull ServiceConnection serviceConnection) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(serviceConnection, "serviceConnection");
        Context applicationContext = this.firebaseApp.getApplicationContext().getApplicationContext();
        Intent intent = new Intent(applicationContext, (Class<?>) SessionLifecycleService.class);
        Log.d(TAG, "Binding service to application.");
        intent.setAction(String.valueOf(Process.myPid()));
        intent.putExtra(SessionLifecycleService.CLIENT_CALLBACK_MESSENGER, callback);
        applicationContext.bindService(intent, serviceConnection, 65);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
