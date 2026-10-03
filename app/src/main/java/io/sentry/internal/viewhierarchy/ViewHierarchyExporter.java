package io.sentry.internal.viewhierarchy;

import io.sentry.protocol.ViewHierarchyNode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface ViewHierarchyExporter {
    boolean export(@NotNull ViewHierarchyNode viewHierarchyNode, @NotNull Object obj);
}
