package androidx.core.app;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface OnUserLeaveHintProvider {
    void addOnUserLeaveHintListener(@NotNull Runnable runnable);

    void removeOnUserLeaveHintListener(@NotNull Runnable runnable);
}
