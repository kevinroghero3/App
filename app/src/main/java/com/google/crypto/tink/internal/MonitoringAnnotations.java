package com.google.crypto.tink.internal;

import com.google.crypto.tink.Annotations;
import com.google.errorprone.annotations.Immutable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class MonitoringAnnotations implements Annotations {
    public static final MonitoringAnnotations EMPTY = newBuilder().build();
    private final Map<String, String> entries;

    public static final class Builder {
        private HashMap<String, String> builderEntries = new HashMap<>();

        public Builder addAll(Map<String, String> map) {
            HashMap<String, String> map2 = this.builderEntries;
            if (map2 == null) {
                throw new IllegalStateException("addAll cannot be called after build()");
            }
            map2.putAll(map);
            return this;
        }

        public Builder add(String str, String str2) {
            HashMap<String, String> map = this.builderEntries;
            if (map == null) {
                throw new IllegalStateException("add cannot be called after build()");
            }
            map.put(str, str2);
            return this;
        }

        public MonitoringAnnotations build() {
            HashMap<String, String> map = this.builderEntries;
            if (map == null) {
                throw new IllegalStateException("cannot call build() twice");
            }
            MonitoringAnnotations monitoringAnnotations = new MonitoringAnnotations(Collections.unmodifiableMap(map));
            this.builderEntries = null;
            return monitoringAnnotations;
        }
    }

    private MonitoringAnnotations(Map<String, String> map) {
        this.entries = map;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Map<String, String> toMap() {
        return this.entries;
    }

    public boolean isEmpty() {
        return this.entries.isEmpty();
    }

    public boolean equals(Object obj) {
        if (obj instanceof MonitoringAnnotations) {
            return this.entries.equals(((MonitoringAnnotations) obj).entries);
        }
        return false;
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return this.entries.toString();
    }
}
