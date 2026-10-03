package com.google.android.gms.common.internal;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class TelemetryLogging {
    private TelemetryLogging() {
    }

    public static TelemetryLoggingClient getClient(@NonNull Context context) {
        return getClient(context, TelemetryLoggingOptions.zaa);
    }

    public static TelemetryLoggingClient getClient(@NonNull Context context, @NonNull TelemetryLoggingOptions telemetryLoggingOptions) {
        return new com.google.android.gms.common.internal.service.zao(context, telemetryLoggingOptions);
    }
}
