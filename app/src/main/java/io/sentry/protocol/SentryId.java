package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryUUID;
import io.sentry.util.LazyEvaluator;
import io.sentry.util.StringUtils;
import io.sentry.util.UUIDStringUtils;
import java.io.IOException;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SentryId implements JsonSerializable {
    public static final SentryId EMPTY_ID = new SentryId(StringUtils.PROPER_NIL_UUID.replace("-", ""));
    private final LazyEvaluator<String> lazyStringValue;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$2(String str) {
        return str;
    }

    public SentryId() {
        this((UUID) null);
    }

    public SentryId(@Nullable final UUID uuid) {
        if (uuid != null) {
            this.lazyStringValue = new LazyEvaluator<>(new LazyEvaluator.Evaluator() { // from class: io.sentry.protocol.SentryId$$ExternalSyntheticLambda0
                @Override // io.sentry.util.LazyEvaluator.Evaluator
                public final Object evaluate() {
                    return this.f$0.lambda$new$0(uuid);
                }
            });
        } else {
            this.lazyStringValue = new LazyEvaluator<>(new LazyEvaluator.Evaluator() { // from class: io.sentry.protocol.SentryId$$ExternalSyntheticLambda1
                @Override // io.sentry.util.LazyEvaluator.Evaluator
                public final Object evaluate() {
                    return SentryUUID.generateSentryId();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$new$0(UUID uuid) {
        return lambda$new$1(UUIDStringUtils.toSentryIdString(uuid));
    }

    public SentryId(@NotNull String str) {
        final String strNormalizeUUID = StringUtils.normalizeUUID(str);
        if (strNormalizeUUID.length() != 32 && strNormalizeUUID.length() != 36) {
            throw new IllegalArgumentException("String representation of SentryId has either 32 (UUID no dashes) or 36 characters long (completed UUID). Received: " + str);
        }
        if (strNormalizeUUID.length() == 36) {
            this.lazyStringValue = new LazyEvaluator<>(new LazyEvaluator.Evaluator() { // from class: io.sentry.protocol.SentryId$$ExternalSyntheticLambda2
                @Override // io.sentry.util.LazyEvaluator.Evaluator
                public final Object evaluate() {
                    return this.f$0.lambda$new$1(strNormalizeUUID);
                }
            });
        } else {
            this.lazyStringValue = new LazyEvaluator<>(new LazyEvaluator.Evaluator() { // from class: io.sentry.protocol.SentryId$$ExternalSyntheticLambda3
                @Override // io.sentry.util.LazyEvaluator.Evaluator
                public final Object evaluate() {
                    return SentryId.lambda$new$2(strNormalizeUUID);
                }
            });
        }
    }

    public String toString() {
        return this.lazyStringValue.getValue();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SentryId.class != obj.getClass()) {
            return false;
        }
        return this.lazyStringValue.getValue().equals(((SentryId) obj).lazyStringValue.getValue());
    }

    public int hashCode() {
        return this.lazyStringValue.getValue().hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: normalize, reason: merged with bridge method [inline-methods] */
    public String lambda$new$1(@NotNull String str) {
        return StringUtils.normalizeUUID(str).replace("-", "");
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.value(toString());
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Deserializer implements JsonDeserializer<SentryId> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.JsonDeserializer
        public SentryId deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            return new SentryId(objectReader.nextString());
        }
    }
}
