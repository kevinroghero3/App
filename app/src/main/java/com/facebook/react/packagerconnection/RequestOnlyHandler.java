package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RequestOnlyHandler implements RequestHandler {
    @Override // com.facebook.react.packagerconnection.RequestHandler
    public abstract void onRequest(@Nullable Object obj, @NotNull Responder responder);

    @Override // com.facebook.react.packagerconnection.RequestHandler
    public final void onNotification(@Nullable Object obj) {
        FLog.e(JSPackagerClient.class.getSimpleName(), "Notification is not supported");
    }
}
