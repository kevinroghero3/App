package io.sentry.android.core.util;

import android.content.Context;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidLazyEvaluator<T> {
    private final AndroidEvaluator<T> evaluator;
    private volatile T value = null;

    public interface AndroidEvaluator<T> {
        T evaluate(@NotNull Context context);
    }

    public AndroidLazyEvaluator(@NotNull AndroidEvaluator<T> androidEvaluator) {
        this.evaluator = androidEvaluator;
    }

    public T getValue(@NotNull Context context) {
        if (this.value == null) {
            synchronized (this) {
                if (this.value == null) {
                    this.value = this.evaluator.evaluate(context);
                }
            }
        }
        return this.value;
    }

    public void setValue(@Nullable T t) {
        synchronized (this) {
            this.value = t;
        }
    }

    public void resetValue() {
        synchronized (this) {
            this.value = null;
        }
    }
}
