package androidx.work.impl.foreground;

import androidx.annotation.NonNull;
import androidx.work.ForegroundInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface ForegroundProcessor {
    boolean isEnqueuedInForeground(@NonNull String str);

    void startForeground(@NonNull String str, @NonNull ForegroundInfo foregroundInfo);

    void stopForeground(@NonNull String str);
}
