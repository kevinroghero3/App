package com.mrousavy.camera.core;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class DoNotDisturbBugError extends CameraError {
    public DoNotDisturbBugError(@Nullable Throwable th) {
        super("system", "do-not-disturb-bug", "The Camera Device could not be opened because of a bug in Android 9 (API 28) when do-not-disturb mode is enabled! Either update your Android version, or disable do-not-disturb.", th);
    }
}
