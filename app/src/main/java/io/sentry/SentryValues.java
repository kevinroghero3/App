package io.sentry;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
final class SentryValues<T> {
    private final List<T> values;

    public static final class JsonKeys {
        public static final String VALUES = "values";
    }

    SentryValues(@Nullable List<T> list) {
        this.values = new ArrayList(list == null ? new ArrayList<>(0) : list);
    }

    public List<T> getValues() {
        return this.values;
    }
}
