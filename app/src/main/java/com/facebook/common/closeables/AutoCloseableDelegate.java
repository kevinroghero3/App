package com.facebook.common.closeables;

import java.io.Closeable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoCloseableDelegate<T extends Closeable> extends AutoCleanupDelegate<T> {
    public AutoCloseableDelegate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ AutoCloseableDelegate(Closeable closeable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : closeable);
    }

    public AutoCloseableDelegate(@Nullable T t) {
        super(t, AutoCleanupDelegateKt.closeableCleanupFunction);
    }
}
