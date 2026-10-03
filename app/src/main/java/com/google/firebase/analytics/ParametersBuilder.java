package com.google.firebase.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ParametersBuilder {
    private final Bundle zza = new Bundle();

    public final Bundle getBundle() {
        return this.zza;
    }

    public final void param(@NonNull String key, double d) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.zza.putDouble(key, d);
    }

    public final void param(@NonNull String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.zza.putLong(key, j);
    }

    public final void param(@NonNull String key, @NonNull Bundle value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.zza.putBundle(key, value);
    }

    public final void param(@NonNull String key, @NonNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.zza.putString(key, value);
    }

    public final void param(@NonNull String key, @NonNull Bundle[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.zza.putParcelableArray(key, value);
    }
}
