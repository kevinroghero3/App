package com.google.crypto.tink.internal;

import com.google.crypto.tink.KeysetHandleInterface;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class MutableMonitoringRegistry {
    private final AtomicReference<MonitoringClient> monitoringClient = new AtomicReference<>();
    private static final MutableMonitoringRegistry GLOBAL_INSTANCE = new MutableMonitoringRegistry();
    private static final DoNothingClient DO_NOTHING_CLIENT = new DoNothingClient();

    public static MutableMonitoringRegistry globalInstance() {
        return GLOBAL_INSTANCE;
    }

    static class DoNothingClient implements MonitoringClient {
        private DoNothingClient() {
        }

        @Override // com.google.crypto.tink.internal.MonitoringClient
        public MonitoringClient.Logger createLogger(KeysetHandleInterface keysetHandleInterface, MonitoringAnnotations monitoringAnnotations, String str, String str2) {
            return MonitoringUtil.DO_NOTHING_LOGGER;
        }
    }

    public void clear() {
        synchronized (this) {
            this.monitoringClient.set(null);
        }
    }

    public void registerMonitoringClient(MonitoringClient monitoringClient) {
        synchronized (this) {
            if (this.monitoringClient.get() != null) {
                throw new IllegalStateException("a monitoring client has already been registered");
            }
            this.monitoringClient.set(monitoringClient);
        }
    }

    public MonitoringClient getMonitoringClient() {
        MonitoringClient monitoringClient = this.monitoringClient.get();
        return monitoringClient == null ? DO_NOTHING_CLIENT : monitoringClient;
    }
}
