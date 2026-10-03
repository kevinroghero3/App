package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public abstract class InstallationResponse {

    public static abstract class Builder {
        public abstract InstallationResponse build();

        public abstract Builder setAuthToken(@NonNull TokenResult tokenResult);

        public abstract Builder setFid(@NonNull String str);

        public abstract Builder setRefreshToken(@NonNull String str);

        public abstract Builder setResponseCode(@NonNull ResponseCode responseCode);

        public abstract Builder setUri(@NonNull String str);
    }

    public enum ResponseCode {
        OK,
        BAD_CONFIG
    }

    public abstract TokenResult getAuthToken();

    public abstract String getFid();

    public abstract String getRefreshToken();

    public abstract ResponseCode getResponseCode();

    public abstract String getUri();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_InstallationResponse.Builder();
    }
}
