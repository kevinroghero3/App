package com.captureprotection;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CaptureProtectionModuleSpec extends ReactContextBaseJavaModule {
    public abstract void addListener(@NotNull String str);

    public abstract void allow(@NotNull Promise promise);

    public abstract void checkPermission(@NotNull Promise promise);

    public abstract void hasListener(@NotNull Promise promise);

    public abstract void isScreenRecording(@NotNull Promise promise);

    public abstract void prevent(@NotNull Promise promise);

    public abstract void protectionStatus(@NotNull Promise promise);

    public abstract void removeListeners(double d);

    public abstract void requestPermission(@NotNull Promise promise);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptureProtectionModuleSpec(@NotNull ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
