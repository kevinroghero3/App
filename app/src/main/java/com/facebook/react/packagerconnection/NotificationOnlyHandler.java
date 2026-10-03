package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NotificationOnlyHandler implements RequestHandler {
    @Override // com.facebook.react.packagerconnection.RequestHandler
    public abstract void onNotification(@Nullable Object obj);

    @Override // com.facebook.react.packagerconnection.RequestHandler
    public final void onRequest(@Nullable Object obj, @NotNull Responder responder) {
        Intrinsics.checkNotNullParameter(responder, "responder");
        responder.error("Request is not supported");
        FLog.e(JSPackagerClient.class.getSimpleName(), "Request is not supported");
    }
}
