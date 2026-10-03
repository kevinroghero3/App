package io.sentry;

import io.sentry.rrweb.RRWebEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class NoOpReplayBreadcrumbConverter implements ReplayBreadcrumbConverter {
    private static final NoOpReplayBreadcrumbConverter instance = new NoOpReplayBreadcrumbConverter();

    @Override // io.sentry.ReplayBreadcrumbConverter
    public RRWebEvent convert(@NotNull Breadcrumb breadcrumb) {
        return null;
    }

    public static NoOpReplayBreadcrumbConverter getInstance() {
        return instance;
    }

    private NoOpReplayBreadcrumbConverter() {
    }
}
