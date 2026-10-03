package com.mrousavy.camera.react.utils;

import com.facebook.react.bridge.Promise;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.UnknownCameraError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class WithPromiseKt {
    public static final void withPromise(@NotNull Promise promise, @NotNull Function0<? extends Object> closure) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(closure, "closure");
        try {
            promise.resolve(closure.invoke());
        } catch (Throwable th) {
            th.printStackTrace();
            CameraError unknownCameraError = th instanceof CameraError ? th : new UnknownCameraError(th);
            promise.reject(unknownCameraError.getDomain() + RemoteSettings.FORWARD_SLASH_STRING + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
        }
    }
}
