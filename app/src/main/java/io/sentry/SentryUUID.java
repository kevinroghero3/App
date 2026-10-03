package io.sentry;

import io.sentry.util.UUIDGenerator;
import io.sentry.util.UUIDStringUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class SentryUUID {
    private SentryUUID() {
    }

    public static String generateSentryId() {
        return UUIDStringUtils.toSentryIdString(UUIDGenerator.randomUUID());
    }

    public static String generateSpanId() {
        return UUIDStringUtils.toSentrySpanIdString(UUIDGenerator.randomHalfLengthUUID());
    }
}
