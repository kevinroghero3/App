package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LogEvent {

    public static abstract class Builder {
        public abstract LogEvent build();

        public abstract Builder setComplianceData(@Nullable ComplianceData complianceData);

        public abstract Builder setEventCode(@Nullable Integer num);

        public abstract Builder setEventTimeMs(long j);

        public abstract Builder setEventUptimeMs(long j);

        public abstract Builder setNetworkConnectionInfo(@Nullable NetworkConnectionInfo networkConnectionInfo);

        abstract Builder setSourceExtension(@Nullable byte[] bArr);

        abstract Builder setSourceExtensionJsonProto3(@Nullable String str);

        public abstract Builder setTimezoneOffsetSeconds(long j);
    }

    public abstract ComplianceData getComplianceData();

    public abstract Integer getEventCode();

    public abstract long getEventTimeMs();

    public abstract long getEventUptimeMs();

    public abstract NetworkConnectionInfo getNetworkConnectionInfo();

    public abstract byte[] getSourceExtension();

    public abstract String getSourceExtensionJsonProto3();

    public abstract long getTimezoneOffsetSeconds();

    public static Builder protoBuilder(@NonNull byte[] bArr) {
        return builder().setSourceExtension(bArr);
    }

    public static Builder jsonBuilder(@NonNull String str) {
        return builder().setSourceExtensionJsonProto3(str);
    }

    private static Builder builder() {
        return new AutoValue_LogEvent.Builder();
    }
}
