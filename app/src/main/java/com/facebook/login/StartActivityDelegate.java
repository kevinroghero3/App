package com.facebook.login;

import android.app.Activity;
import android.content.Intent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface StartActivityDelegate {
    Activity getActivityContext();

    void startActivityForResult(@NotNull Intent intent, int i);
}
