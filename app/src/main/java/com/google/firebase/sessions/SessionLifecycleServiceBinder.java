package com.google.firebase.sessions;

import android.content.ServiceConnection;
import android.os.Messenger;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public interface SessionLifecycleServiceBinder {
    public static final Companion Companion = Companion.$$INSTANCE;

    void bindToService(@NotNull Messenger messenger, @NotNull ServiceConnection serviceConnection);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final SessionLifecycleServiceBinder getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(SessionLifecycleServiceBinder.class);
            Intrinsics.checkNotNullExpressionValue(obj, "Firebase.app[SessionLife…erviceBinder::class.java]");
            return (SessionLifecycleServiceBinder) obj;
        }
    }
}
