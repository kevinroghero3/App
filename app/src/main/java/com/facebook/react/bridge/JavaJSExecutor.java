package com.facebook.react.bridge;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface JavaJSExecutor {

    public interface Factory {
        JavaJSExecutor create() throws Exception;
    }

    void close();

    String executeJSCall(@NotNull String str, @Nullable String str2) throws ProxyExecutorException;

    void loadBundle(@NotNull String str) throws ProxyExecutorException;

    void setGlobalVariable(@NotNull String str, @NotNull String str2);

    public static final class ProxyExecutorException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProxyExecutorException(@NotNull Throwable cause) {
            super(cause);
            Intrinsics.checkNotNullParameter(cause, "cause");
        }
    }
}
