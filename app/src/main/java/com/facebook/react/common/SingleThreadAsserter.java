package com.facebook.react.common;

import com.facebook.infer.annotation.Assertions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleThreadAsserter {
    private Thread thread;

    public final void assertNow() {
        Thread threadCurrentThread = Thread.currentThread();
        if (this.thread == null) {
            this.thread = threadCurrentThread;
        }
        Assertions.assertCondition(Intrinsics.areEqual(this.thread, threadCurrentThread));
    }
}
