package io.sentry;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface TransactionFinishedCallback {
    void execute(@NotNull ITransaction iTransaction);
}
