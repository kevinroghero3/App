package com.google.firebase.messaging.ktx;

import com.google.firebase.ktx.Firebase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class MessagingKt {
    public static final FirebaseMessaging getMessaging(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseMessaging, "getInstance()");
        return firebaseMessaging;
    }

    @Deprecated(message = "Migrate to use the KTX API from the main module: https://firebase.google.com/docs/android/kotlin-migration.", replaceWith = @ReplaceWith(expression = "", imports = {}))
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
