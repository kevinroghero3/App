package io.sentry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryAttribute {
    private final String name;
    private final SentryAttributeType type;
    private final Object value;

    private SentryAttribute(@NotNull String str, @Nullable SentryAttributeType sentryAttributeType, @Nullable Object obj) {
        this.name = str;
        this.type = sentryAttributeType;
        this.value = obj;
    }

    public String getName() {
        return this.name;
    }

    public SentryAttributeType getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public static SentryAttribute named(@NotNull String str, @Nullable Object obj) {
        return new SentryAttribute(str, null, obj);
    }

    public static SentryAttribute booleanAttribute(@NotNull String str, @Nullable Boolean bool) {
        return new SentryAttribute(str, SentryAttributeType.BOOLEAN, bool);
    }

    public static SentryAttribute integerAttribute(@NotNull String str, @Nullable Integer num) {
        return new SentryAttribute(str, SentryAttributeType.INTEGER, num);
    }

    public static SentryAttribute doubleAttribute(@NotNull String str, @Nullable Double d) {
        return new SentryAttribute(str, SentryAttributeType.DOUBLE, d);
    }

    public static SentryAttribute stringAttribute(@NotNull String str, @Nullable String str2) {
        return new SentryAttribute(str, SentryAttributeType.STRING, str2);
    }
}
