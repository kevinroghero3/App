package com.hitachiapp.services.push.core;

import com.google.firebase.messaging.RemoteMessage;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface ExternalPushProvider {
    boolean canHandle(@NotNull RemoteMessage remoteMessage);

    String getName();

    boolean handleMessage(@NotNull RemoteMessage remoteMessage);

    void onNewToken(@NotNull String str);
}
