package io.sentry;

import java.io.Closeable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface IConnectionStatusProvider extends Closeable {

    /* JADX INFO: loaded from: classes6.dex */
    public enum ConnectionStatus {
        UNKNOWN,
        CONNECTED,
        DISCONNECTED,
        NO_PERMISSION
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface IConnectionStatusObserver {
        void onConnectionStatusChanged(@NotNull ConnectionStatus connectionStatus);
    }

    boolean addConnectionStatusObserver(@NotNull IConnectionStatusObserver iConnectionStatusObserver);

    ConnectionStatus getConnectionStatus();

    String getConnectionType();

    void removeConnectionStatusObserver(@NotNull IConnectionStatusObserver iConnectionStatusObserver);
}
