package io.sentry;

import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public enum SentryAttributeType {
    STRING,
    BOOLEAN,
    INTEGER,
    DOUBLE;

    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
