package okhttp3;

import java.io.IOException;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface Call extends Cloneable {

    public interface Factory {
        Call newCall(@NotNull Request request);
    }

    void cancel();

    Call clone();

    void enqueue(@NotNull Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    Timeout timeout();
}
