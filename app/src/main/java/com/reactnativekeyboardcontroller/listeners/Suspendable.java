package com.reactnativekeyboardcontroller.listeners;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface Suspendable {
    boolean isSuspended();

    void setSuspended(boolean z);

    void suspend(boolean z);

    public static final class DefaultImpls {
        public static void suspend(@NotNull Suspendable suspendable, boolean z) {
            suspendable.setSuspended(z);
        }
    }
}
