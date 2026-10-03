package com.google.firebase.messaging;

import com.google.firebase.Firebase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public final class MessagingKt {
    public static final FirebaseMessaging getMessaging(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseMessaging, "getInstance()");
        return firebaseMessaging;
    }

    public static final RemoteMessage remoteMessage(@NotNull String to, @NotNull Function1<? super RemoteMessage.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(init, "init");
        RemoteMessage.Builder builder = new RemoteMessage.Builder(to);
        init.invoke(builder);
        RemoteMessage remoteMessageBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(remoteMessageBuild, "builder.build()");
        return remoteMessageBuild;
    }
}
