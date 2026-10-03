package com.facebook;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface FacebookCallback<RESULT> {
    void onCancel();

    void onError(@NotNull FacebookException facebookException);

    void onSuccess(RESULT result);
}
