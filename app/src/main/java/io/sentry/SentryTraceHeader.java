package io.sentry;

import com.facebook.appevents.AppEventsConstants;
import io.sentry.exception.InvalidSentryTraceHeaderException;
import io.sentry.protocol.SentryId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryTraceHeader {
    private static final Pattern SENTRY_TRACEPARENT_HEADER_REGEX = Pattern.compile("^[ \\t]*([0-9a-f]{32})-([0-9a-f]{16})(-[01])?[ \\t]*$", 2);
    public static final String SENTRY_TRACE_HEADER = "sentry-trace";
    private final Boolean sampled;
    private final SpanId spanId;
    private final SentryId traceId;

    public SentryTraceHeader(@NotNull SentryId sentryId, @NotNull SpanId spanId, @Nullable Boolean bool) {
        this.traceId = sentryId;
        this.spanId = spanId;
        this.sampled = bool;
    }

    public SentryTraceHeader(@NotNull String str) throws InvalidSentryTraceHeaderException {
        Matcher matcher = SENTRY_TRACEPARENT_HEADER_REGEX.matcher(str);
        if (!matcher.matches()) {
            throw new InvalidSentryTraceHeaderException(str);
        }
        this.traceId = new SentryId(matcher.group(1));
        this.spanId = new SpanId(matcher.group(2));
        String strGroup = matcher.group(3);
        this.sampled = strGroup == null ? null : Boolean.valueOf(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strGroup.substring(1)));
    }

    public String getName() {
        return SENTRY_TRACE_HEADER;
    }

    public String getValue() {
        Boolean bool = this.sampled;
        if (bool != null) {
            return String.format("%s-%s-%s", this.traceId, this.spanId, bool.booleanValue() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        return String.format("%s-%s", this.traceId, this.spanId);
    }

    public SentryId getTraceId() {
        return this.traceId;
    }

    public SpanId getSpanId() {
        return this.spanId;
    }

    public Boolean isSampled() {
        return this.sampled;
    }
}
