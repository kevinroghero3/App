package io.sentry;

import io.sentry.internal.eventprocessor.EventProcessorAndOrder;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface IScope {
    void addAttachment(@NotNull Attachment attachment);

    void addBreadcrumb(@NotNull Breadcrumb breadcrumb);

    void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable Hint hint);

    void addEventProcessor(@NotNull EventProcessor eventProcessor);

    void assignTraceContext(@NotNull SentryEvent sentryEvent);

    void bindClient(@NotNull ISentryClient iSentryClient);

    void clear();

    void clearAttachments();

    void clearBreadcrumbs();

    void clearSession();

    void clearTransaction();

    /* JADX INFO: renamed from: clone */
    IScope m5375clone();

    Session endSession();

    List<Attachment> getAttachments();

    Queue<Breadcrumb> getBreadcrumbs();

    ISentryClient getClient();

    Contexts getContexts();

    List<EventProcessor> getEventProcessors();

    List<EventProcessorAndOrder> getEventProcessorsWithOrder();

    Map<String, Object> getExtras();

    List<String> getFingerprint();

    SentryId getLastEventId();

    SentryLevel getLevel();

    SentryOptions getOptions();

    PropagationContext getPropagationContext();

    SentryId getReplayId();

    Request getRequest();

    String getScreen();

    Session getSession();

    ISpan getSpan();

    Map<String, String> getTags();

    ITransaction getTransaction();

    String getTransactionName();

    User getUser();

    void removeContexts(@Nullable String str);

    void removeExtra(@Nullable String str);

    void removeTag(@Nullable String str);

    void replaceOptions(@NotNull SentryOptions sentryOptions);

    void setActiveSpan(@Nullable ISpan iSpan);

    void setContexts(@Nullable String str, @Nullable Boolean bool);

    void setContexts(@Nullable String str, @Nullable Character ch2);

    void setContexts(@Nullable String str, @Nullable Number number);

    void setContexts(@Nullable String str, @Nullable Object obj);

    void setContexts(@Nullable String str, @Nullable String str2);

    void setContexts(@Nullable String str, @Nullable Collection<?> collection);

    void setContexts(@Nullable String str, @Nullable Object[] objArr);

    void setExtra(@Nullable String str, @Nullable String str2);

    void setFingerprint(@NotNull List<String> list);

    void setLastEventId(@NotNull SentryId sentryId);

    void setLevel(@Nullable SentryLevel sentryLevel);

    void setPropagationContext(@NotNull PropagationContext propagationContext);

    void setReplayId(@NotNull SentryId sentryId);

    void setRequest(@Nullable Request request);

    void setScreen(@Nullable String str);

    void setSpanContext(@NotNull Throwable th, @NotNull ISpan iSpan, @NotNull String str);

    void setTag(@Nullable String str, @Nullable String str2);

    void setTransaction(@Nullable ITransaction iTransaction);

    void setTransaction(@NotNull String str);

    void setUser(@Nullable User user);

    Scope.SessionPair startSession();

    PropagationContext withPropagationContext(@NotNull Scope.IWithPropagationContext iWithPropagationContext);

    Session withSession(@NotNull Scope.IWithSession iWithSession);

    void withTransaction(@NotNull Scope.IWithTransaction iWithTransaction);
}
