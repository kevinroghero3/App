package com.facebook;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface LoginStatusCallback {
    void onCompleted(@NotNull AccessToken accessToken);

    void onError(@NotNull Exception exc);

    void onFailure();
}
