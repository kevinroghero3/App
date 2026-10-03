package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.Collection;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface IScopeObserver {
    void addBreadcrumb(@NotNull Breadcrumb breadcrumb);

    void removeExtra(@NotNull String str);

    void removeTag(@NotNull String str);

    void setBreadcrumbs(@NotNull Collection<Breadcrumb> collection);

    void setContexts(@NotNull Contexts contexts);

    void setExtra(@NotNull String str, @NotNull String str2);

    void setExtras(@NotNull Map<String, Object> map);

    void setFingerprint(@NotNull Collection<String> collection);

    void setLevel(@Nullable SentryLevel sentryLevel);

    void setReplayId(@NotNull SentryId sentryId);

    void setRequest(@Nullable Request request);

    void setTag(@NotNull String str, @NotNull String str2);

    void setTags(@NotNull Map<String, String> map);

    void setTrace(@Nullable SpanContext spanContext, @NotNull IScope iScope);

    void setTransaction(@Nullable String str);

    void setUser(@Nullable User user);
}
