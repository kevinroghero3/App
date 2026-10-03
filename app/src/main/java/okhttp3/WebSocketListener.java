package okhttp3;

import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class WebSocketListener {
    public void onClosed(@NotNull WebSocket webSocket, int i, @NotNull String reason) {
        Intrinsics.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics.checkParameterIsNotNull(reason, "reason");
    }

    public void onClosing(@NotNull WebSocket webSocket, int i, @NotNull String reason) {
        Intrinsics.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics.checkParameterIsNotNull(reason, "reason");
    }

    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
        Intrinsics.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics.checkParameterIsNotNull(t, "t");
    }

    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        Intrinsics.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics.checkParameterIsNotNull(text, "text");
    }

    public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString bytes) {
        Intrinsics.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
    }

    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        Intrinsics.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics.checkParameterIsNotNull(response, "response");
    }
}
