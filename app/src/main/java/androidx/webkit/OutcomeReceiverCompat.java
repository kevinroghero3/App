package androidx.webkit;

import androidx.annotation.NonNull;
import java.lang.Throwable;

/* JADX INFO: loaded from: classes4.dex */
public interface OutcomeReceiverCompat<T, E extends Throwable> {
    default void onError(@NonNull E e) {
    }

    void onResult(T t);
}
