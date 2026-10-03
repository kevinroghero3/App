package com.google.firebase.installations;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class InstallationTokenResult {

    /* JADX INFO: loaded from: classes5.dex */
    public static abstract class Builder {
        public abstract InstallationTokenResult build();

        public abstract Builder setToken(@NonNull String str);

        public abstract Builder setTokenCreationTimestamp(long j);

        public abstract Builder setTokenExpirationTimestamp(long j);
    }

    public abstract String getToken();

    public abstract long getTokenCreationTimestamp();

    public abstract long getTokenExpirationTimestamp();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_InstallationTokenResult.Builder();
    }
}
