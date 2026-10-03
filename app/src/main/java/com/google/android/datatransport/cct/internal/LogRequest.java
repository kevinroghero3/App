package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LogRequest {
    public abstract ClientInfo getClientInfo();

    @Encodable.Field(name = "logEvent")
    public abstract List<LogEvent> getLogEvents();

    public abstract Integer getLogSource();

    public abstract String getLogSourceName();

    public abstract QosTier getQosTier();

    public abstract long getRequestTimeMs();

    public abstract long getRequestUptimeMs();

    public static Builder builder() {
        return new AutoValue_LogRequest.Builder();
    }

    public static abstract class Builder {
        public abstract LogRequest build();

        public abstract Builder setClientInfo(@Nullable ClientInfo clientInfo);

        public abstract Builder setLogEvents(@Nullable List<LogEvent> list);

        abstract Builder setLogSource(@Nullable Integer num);

        abstract Builder setLogSourceName(@Nullable String str);

        public abstract Builder setQosTier(@Nullable QosTier qosTier);

        public abstract Builder setRequestTimeMs(long j);

        public abstract Builder setRequestUptimeMs(long j);

        public Builder setSource(int i) {
            return setLogSource(Integer.valueOf(i));
        }

        public Builder setSource(@NonNull String str) {
            return setLogSourceName(str);
        }
    }
}
