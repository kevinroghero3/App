package io.sentry;

import io.sentry.rrweb.RRWebEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface ReplayBreadcrumbConverter {
    RRWebEvent convert(@NotNull Breadcrumb breadcrumb);
}
