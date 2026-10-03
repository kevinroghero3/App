package app.notifee.core.interfaces;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface MethodCallResult<T> {
    void onComplete(@Nullable Exception exc, T t);
}
