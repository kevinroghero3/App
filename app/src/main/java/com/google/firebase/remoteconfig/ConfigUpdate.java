package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConfigUpdate {
    public abstract Set<String> getUpdatedKeys();

    public static ConfigUpdate create(@NonNull Set<String> set) {
        return new AutoValue_ConfigUpdate(set);
    }
}
