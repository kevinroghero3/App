package com.hitachiapp.services.push.core;

import com.google.firebase.messaging.RemoteMessage;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class NoOpPushProvider implements ExternalPushProvider {
    public static final NoOpPushProvider INSTANCE = new NoOpPushProvider();
    private static final String name = "NoOpPushProvider";

    @Override // com.hitachiapp.services.push.core.ExternalPushProvider
    public boolean canHandle(@NotNull RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        return false;
    }

    @Override // com.hitachiapp.services.push.core.ExternalPushProvider
    public boolean handleMessage(@NotNull RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        return false;
    }

    @Override // com.hitachiapp.services.push.core.ExternalPushProvider
    public void onNewToken(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
    }

    private NoOpPushProvider() {
    }

    @Override // com.hitachiapp.services.push.core.ExternalPushProvider
    public String getName() {
        return name;
    }
}
