package com.google.crypto.tink.internal;

import com.google.crypto.tink.KeysetHandleInterface;

/* JADX INFO: loaded from: classes2.dex */
public interface MonitoringClient {

    public interface Logger {
        default void log(int i, long j) {
        }

        default void logFailure() {
        }

        default void logKeyExport(int i) {
        }
    }

    Logger createLogger(KeysetHandleInterface keysetHandleInterface, MonitoringAnnotations monitoringAnnotations, String str, String str2);
}
