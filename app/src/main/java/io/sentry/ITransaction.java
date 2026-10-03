package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface ITransaction extends ISpan {
    void finish(@Nullable SpanStatus spanStatus, @Nullable SentryDate sentryDate, boolean z, @Nullable Hint hint);

    void forceFinish(@NotNull SpanStatus spanStatus, boolean z, @Nullable Hint hint);

    SentryId getEventId();

    ISpan getLatestActiveSpan();

    String getName();

    List<Span> getSpans();

    TransactionNameSource getTransactionNameSource();

    Boolean isProfileSampled();

    void scheduleFinish();

    void setName(@NotNull String str);

    void setName(@NotNull String str, @NotNull TransactionNameSource transactionNameSource);

    ISpan startChild(@NotNull String str, @Nullable String str2, @Nullable SentryDate sentryDate);
}
