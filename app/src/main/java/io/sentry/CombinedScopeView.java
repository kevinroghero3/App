package io.sentry;

import io.sentry.internal.eventprocessor.EventProcessorAndOrder;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import io.sentry.util.EventProcessorUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class CombinedScopeView implements IScope {
    private final IScope globalScope;
    private final IScope isolationScope;
    private final IScope scope;

    public CombinedScopeView(@NotNull IScope iScope, @NotNull IScope iScope2, @NotNull IScope iScope3) {
        this.globalScope = iScope;
        this.isolationScope = iScope2;
        this.scope = iScope3;
    }

    @Override // io.sentry.IScope
    public SentryLevel getLevel() {
        SentryLevel level = this.scope.getLevel();
        if (level != null) {
            return level;
        }
        SentryLevel level2 = this.isolationScope.getLevel();
        return level2 != null ? level2 : this.globalScope.getLevel();
    }

    @Override // io.sentry.IScope
    public void setLevel(@Nullable SentryLevel sentryLevel) {
        getDefaultWriteScope().setLevel(sentryLevel);
    }

    @Override // io.sentry.IScope
    public String getTransactionName() {
        String transactionName = this.scope.getTransactionName();
        if (transactionName != null) {
            return transactionName;
        }
        String transactionName2 = this.isolationScope.getTransactionName();
        return transactionName2 != null ? transactionName2 : this.globalScope.getTransactionName();
    }

    @Override // io.sentry.IScope
    public void setTransaction(@NotNull String str) {
        getDefaultWriteScope().setTransaction(str);
    }

    @Override // io.sentry.IScope
    public ISpan getSpan() {
        ISpan span = this.scope.getSpan();
        if (span != null) {
            return span;
        }
        ISpan span2 = this.isolationScope.getSpan();
        return span2 != null ? span2 : this.globalScope.getSpan();
    }

    @Override // io.sentry.IScope
    public void setActiveSpan(@Nullable ISpan iSpan) {
        this.scope.setActiveSpan(iSpan);
    }

    @Override // io.sentry.IScope
    public void setTransaction(@Nullable ITransaction iTransaction) {
        getDefaultWriteScope().setTransaction(iTransaction);
    }

    @Override // io.sentry.IScope
    public User getUser() {
        User user = this.scope.getUser();
        if (user != null) {
            return user;
        }
        User user2 = this.isolationScope.getUser();
        return user2 != null ? user2 : this.globalScope.getUser();
    }

    @Override // io.sentry.IScope
    public void setUser(@Nullable User user) {
        getDefaultWriteScope().setUser(user);
    }

    @Override // io.sentry.IScope
    public String getScreen() {
        String screen = this.scope.getScreen();
        if (screen != null) {
            return screen;
        }
        String screen2 = this.isolationScope.getScreen();
        return screen2 != null ? screen2 : this.globalScope.getScreen();
    }

    @Override // io.sentry.IScope
    public void setScreen(@Nullable String str) {
        getDefaultWriteScope().setScreen(str);
    }

    @Override // io.sentry.IScope
    public Request getRequest() {
        Request request = this.scope.getRequest();
        if (request != null) {
            return request;
        }
        Request request2 = this.isolationScope.getRequest();
        return request2 != null ? request2 : this.globalScope.getRequest();
    }

    @Override // io.sentry.IScope
    public void setRequest(@Nullable Request request) {
        getDefaultWriteScope().setRequest(request);
    }

    @Override // io.sentry.IScope
    public List<String> getFingerprint() {
        List<String> fingerprint = this.scope.getFingerprint();
        if (!fingerprint.isEmpty()) {
            return fingerprint;
        }
        List<String> fingerprint2 = this.isolationScope.getFingerprint();
        return !fingerprint2.isEmpty() ? fingerprint2 : this.globalScope.getFingerprint();
    }

    @Override // io.sentry.IScope
    public void setFingerprint(@NotNull List<String> list) {
        getDefaultWriteScope().setFingerprint(list);
    }

    @Override // io.sentry.IScope
    public Queue<Breadcrumb> getBreadcrumbs() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.globalScope.getBreadcrumbs());
        arrayList.addAll(this.isolationScope.getBreadcrumbs());
        arrayList.addAll(this.scope.getBreadcrumbs());
        Collections.sort(arrayList);
        Queue<Breadcrumb> queueCreateBreadcrumbsList = Scope.createBreadcrumbsList(this.scope.getOptions().getMaxBreadcrumbs());
        queueCreateBreadcrumbsList.addAll(arrayList);
        return queueCreateBreadcrumbsList;
    }

    @Override // io.sentry.IScope
    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable Hint hint) {
        getDefaultWriteScope().addBreadcrumb(breadcrumb, hint);
    }

    @Override // io.sentry.IScope
    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb) {
        getDefaultWriteScope().addBreadcrumb(breadcrumb);
    }

    @Override // io.sentry.IScope
    public void clearBreadcrumbs() {
        getDefaultWriteScope().clearBreadcrumbs();
    }

    @Override // io.sentry.IScope
    public void clearTransaction() {
        getDefaultWriteScope().clearTransaction();
    }

    @Override // io.sentry.IScope
    public ITransaction getTransaction() {
        ITransaction transaction = this.scope.getTransaction();
        if (transaction != null) {
            return transaction;
        }
        ITransaction transaction2 = this.isolationScope.getTransaction();
        return transaction2 != null ? transaction2 : this.globalScope.getTransaction();
    }

    @Override // io.sentry.IScope
    public void clear() {
        getDefaultWriteScope().clear();
    }

    @Override // io.sentry.IScope
    public Map<String, String> getTags() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(this.globalScope.getTags());
        concurrentHashMap.putAll(this.isolationScope.getTags());
        concurrentHashMap.putAll(this.scope.getTags());
        return concurrentHashMap;
    }

    @Override // io.sentry.IScope
    public void setTag(@Nullable String str, @Nullable String str2) {
        getDefaultWriteScope().setTag(str, str2);
    }

    @Override // io.sentry.IScope
    public void removeTag(@Nullable String str) {
        getDefaultWriteScope().removeTag(str);
    }

    @Override // io.sentry.IScope
    public Map<String, Object> getExtras() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(this.globalScope.getExtras());
        concurrentHashMap.putAll(this.isolationScope.getExtras());
        concurrentHashMap.putAll(this.scope.getExtras());
        return concurrentHashMap;
    }

    @Override // io.sentry.IScope
    public void setExtra(@Nullable String str, @Nullable String str2) {
        getDefaultWriteScope().setExtra(str, str2);
    }

    @Override // io.sentry.IScope
    public void removeExtra(@Nullable String str) {
        getDefaultWriteScope().removeExtra(str);
    }

    @Override // io.sentry.IScope
    public Contexts getContexts() {
        return new CombinedContextsView(this.globalScope.getContexts(), this.isolationScope.getContexts(), this.scope.getContexts(), getOptions().getDefaultScopeType());
    }

    @Override // io.sentry.IScope
    public void setContexts(@Nullable String str, @Nullable Object obj) {
        getDefaultWriteScope().setContexts(str, obj);
    }

    @Override // io.sentry.IScope
    public void setContexts(@Nullable String str, @Nullable Boolean bool) {
        getDefaultWriteScope().setContexts(str, bool);
    }

    @Override // io.sentry.IScope
    public void setContexts(@Nullable String str, @Nullable String str2) {
        getDefaultWriteScope().setContexts(str, str2);
    }

    @Override // io.sentry.IScope
    public void setContexts(@Nullable String str, @Nullable Number number) {
        getDefaultWriteScope().setContexts(str, number);
    }

    @Override // io.sentry.IScope
    public void setContexts(@Nullable String str, @Nullable Collection<?> collection) {
        getDefaultWriteScope().setContexts(str, collection);
    }

    @Override // io.sentry.IScope
    public void setContexts(@Nullable String str, @Nullable Object[] objArr) {
        getDefaultWriteScope().setContexts(str, objArr);
    }

    @Override // io.sentry.IScope
    public void setContexts(@Nullable String str, @Nullable Character ch2) {
        getDefaultWriteScope().setContexts(str, ch2);
    }

    @Override // io.sentry.IScope
    public void removeContexts(@Nullable String str) {
        getDefaultWriteScope().removeContexts(str);
    }

    private IScope getDefaultWriteScope() {
        return getSpecificScope(null);
    }

    /* JADX INFO: renamed from: io.sentry.CombinedScopeView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$ScopeType;

        static {
            int[] iArr = new int[ScopeType.values().length];
            $SwitchMap$io$sentry$ScopeType = iArr;
            try {
                iArr[ScopeType.CURRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$sentry$ScopeType[ScopeType.ISOLATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$sentry$ScopeType[ScopeType.GLOBAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$sentry$ScopeType[ScopeType.COMBINED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    IScope getSpecificScope(@Nullable ScopeType scopeType) {
        if (scopeType != null) {
            int i = AnonymousClass1.$SwitchMap$io$sentry$ScopeType[scopeType.ordinal()];
            if (i == 1) {
                return this.scope;
            }
            if (i == 2) {
                return this.isolationScope;
            }
            if (i == 3) {
                return this.globalScope;
            }
            if (i == 4) {
                return this;
            }
        }
        int i2 = AnonymousClass1.$SwitchMap$io$sentry$ScopeType[getOptions().getDefaultScopeType().ordinal()];
        if (i2 == 1) {
            return this.scope;
        }
        if (i2 == 2) {
            return this.isolationScope;
        }
        if (i2 == 3) {
            return this.globalScope;
        }
        return this.scope;
    }

    @Override // io.sentry.IScope
    public List<Attachment> getAttachments() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.addAll(this.globalScope.getAttachments());
        copyOnWriteArrayList.addAll(this.isolationScope.getAttachments());
        copyOnWriteArrayList.addAll(this.scope.getAttachments());
        return copyOnWriteArrayList;
    }

    @Override // io.sentry.IScope
    public void addAttachment(@NotNull Attachment attachment) {
        getDefaultWriteScope().addAttachment(attachment);
    }

    @Override // io.sentry.IScope
    public void clearAttachments() {
        getDefaultWriteScope().clearAttachments();
    }

    @Override // io.sentry.IScope
    public List<EventProcessorAndOrder> getEventProcessorsWithOrder() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.addAll(this.globalScope.getEventProcessorsWithOrder());
        copyOnWriteArrayList.addAll(this.isolationScope.getEventProcessorsWithOrder());
        copyOnWriteArrayList.addAll(this.scope.getEventProcessorsWithOrder());
        Collections.sort(copyOnWriteArrayList);
        return copyOnWriteArrayList;
    }

    @Override // io.sentry.IScope
    public List<EventProcessor> getEventProcessors() {
        return EventProcessorUtils.unwrap(getEventProcessorsWithOrder());
    }

    @Override // io.sentry.IScope
    public void addEventProcessor(@NotNull EventProcessor eventProcessor) {
        getDefaultWriteScope().addEventProcessor(eventProcessor);
    }

    @Override // io.sentry.IScope
    public Session withSession(Scope.IWithSession iWithSession) {
        return getDefaultWriteScope().withSession(iWithSession);
    }

    @Override // io.sentry.IScope
    public Scope.SessionPair startSession() {
        return getDefaultWriteScope().startSession();
    }

    @Override // io.sentry.IScope
    public Session endSession() {
        return getDefaultWriteScope().endSession();
    }

    @Override // io.sentry.IScope
    public void withTransaction(Scope.IWithTransaction iWithTransaction) {
        getDefaultWriteScope().withTransaction(iWithTransaction);
    }

    @Override // io.sentry.IScope
    public SentryOptions getOptions() {
        return this.globalScope.getOptions();
    }

    @Override // io.sentry.IScope
    public Session getSession() {
        Session session = this.scope.getSession();
        if (session != null) {
            return session;
        }
        Session session2 = this.isolationScope.getSession();
        return session2 != null ? session2 : this.globalScope.getSession();
    }

    @Override // io.sentry.IScope
    public void clearSession() {
        getDefaultWriteScope().clearSession();
    }

    @Override // io.sentry.IScope
    public void setPropagationContext(@NotNull PropagationContext propagationContext) {
        getDefaultWriteScope().setPropagationContext(propagationContext);
    }

    @Override // io.sentry.IScope
    public PropagationContext getPropagationContext() {
        return getDefaultWriteScope().getPropagationContext();
    }

    @Override // io.sentry.IScope
    public PropagationContext withPropagationContext(Scope.IWithPropagationContext iWithPropagationContext) {
        return getDefaultWriteScope().withPropagationContext(iWithPropagationContext);
    }

    @Override // io.sentry.IScope
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IScope m5364clone() {
        return new CombinedScopeView(this.globalScope, this.isolationScope.m5375clone(), this.scope.m5375clone());
    }

    @Override // io.sentry.IScope
    public void setLastEventId(@NotNull SentryId sentryId) {
        this.globalScope.setLastEventId(sentryId);
        this.isolationScope.setLastEventId(sentryId);
        this.scope.setLastEventId(sentryId);
    }

    @Override // io.sentry.IScope
    public SentryId getLastEventId() {
        return this.globalScope.getLastEventId();
    }

    @Override // io.sentry.IScope
    public void bindClient(@NotNull ISentryClient iSentryClient) {
        getDefaultWriteScope().bindClient(iSentryClient);
    }

    @Override // io.sentry.IScope
    public ISentryClient getClient() {
        ISentryClient client = this.scope.getClient();
        if (!(client instanceof NoOpSentryClient)) {
            return client;
        }
        ISentryClient client2 = this.isolationScope.getClient();
        return !(client2 instanceof NoOpSentryClient) ? client2 : this.globalScope.getClient();
    }

    @Override // io.sentry.IScope
    public void assignTraceContext(@NotNull SentryEvent sentryEvent) {
        this.globalScope.assignTraceContext(sentryEvent);
    }

    @Override // io.sentry.IScope
    public void setSpanContext(@NotNull Throwable th, @NotNull ISpan iSpan, @NotNull String str) {
        this.globalScope.setSpanContext(th, iSpan, str);
    }

    @Override // io.sentry.IScope
    public void replaceOptions(@NotNull SentryOptions sentryOptions) {
        this.globalScope.replaceOptions(sentryOptions);
    }

    @Override // io.sentry.IScope
    public SentryId getReplayId() {
        SentryId replayId = this.scope.getReplayId();
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!sentryId.equals(replayId)) {
            return replayId;
        }
        SentryId replayId2 = this.isolationScope.getReplayId();
        return !sentryId.equals(replayId2) ? replayId2 : this.globalScope.getReplayId();
    }

    @Override // io.sentry.IScope
    public void setReplayId(@NotNull SentryId sentryId) {
        getDefaultWriteScope().setReplayId(sentryId);
    }
}
