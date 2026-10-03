package io.sentry;

import io.sentry.util.Objects;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomSamplingContext {
    private final Map<String, Object> data = new HashMap();

    public void set(@NotNull String str, @Nullable Object obj) {
        Objects.requireNonNull(str, "key is required");
        this.data.put(str, obj);
    }

    public Object get(@NotNull String str) {
        Objects.requireNonNull(str, "key is required");
        return this.data.get(str);
    }

    public Map<String, Object> getData() {
        return this.data;
    }
}
