package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes.dex */
public interface ConfigUpdateListener {
    void onError(@Nonnull FirebaseRemoteConfigException firebaseRemoteConfigException);

    void onUpdate(@NonNull ConfigUpdate configUpdate);
}
