package io.sentry.logger;

import io.sentry.SentryAttributes;
import io.sentry.SentryDate;
import io.sentry.SpanContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SentryLogParameters {
    private SentryAttributes attributes;
    private String origin = SpanContext.DEFAULT_ORIGIN;
    private SentryDate timestamp;

    public SentryDate getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(@Nullable SentryDate sentryDate) {
        this.timestamp = sentryDate;
    }

    public SentryAttributes getAttributes() {
        return this.attributes;
    }

    public void setAttributes(@Nullable SentryAttributes sentryAttributes) {
        this.attributes = sentryAttributes;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(@NotNull String str) {
        this.origin = str;
    }

    public static SentryLogParameters create(@Nullable SentryDate sentryDate, @Nullable SentryAttributes sentryAttributes) {
        SentryLogParameters sentryLogParameters = new SentryLogParameters();
        sentryLogParameters.setTimestamp(sentryDate);
        sentryLogParameters.setAttributes(sentryAttributes);
        return sentryLogParameters;
    }

    public static SentryLogParameters create(@Nullable SentryAttributes sentryAttributes) {
        return create(null, sentryAttributes);
    }
}
