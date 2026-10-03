package com.mrousavy.camera.core;

import com.google.firebase.sessions.settings.RemoteSettings;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CameraError extends Throwable {
    private final String domain;
    private final String id;
    private final String message;

    public /* synthetic */ CameraError(String str, String str2, String str3, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : th);
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getId() {
        return this.id;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraError(@NotNull String domain, @NotNull String id, @NotNull String message, @Nullable Throwable th) {
        super("[" + domain + RemoteSettings.FORWARD_SLASH_STRING + id + "] " + message, th);
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(message, "message");
        this.domain = domain;
        this.id = id;
        this.message = message;
    }

    public final String getCode() {
        return this.domain + RemoteSettings.FORWARD_SLASH_STRING + this.id;
    }
}
