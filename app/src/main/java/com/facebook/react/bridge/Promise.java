package com.facebook.react.bridge;

import kotlin.Deprecated;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface Promise {
    @Deprecated(message = "Prefer passing a module-specific error code to JS. Using this method will pass the\n        error code EUNSPECIFIED", replaceWith = @ReplaceWith(expression = "reject(code, message)", imports = {}))
    void reject(@NotNull String str);

    void reject(@NotNull String str, @NotNull WritableMap writableMap);

    void reject(@NotNull String str, @Nullable String str2);

    void reject(@NotNull String str, @Nullable String str2, @NotNull WritableMap writableMap);

    void reject(@NotNull String str, @Nullable String str2, @Nullable Throwable th);

    void reject(@Nullable String str, @Nullable String str2, @Nullable Throwable th, @Nullable WritableMap writableMap);

    void reject(@NotNull String str, @Nullable Throwable th);

    void reject(@NotNull String str, @Nullable Throwable th, @NotNull WritableMap writableMap);

    void reject(@NotNull Throwable th);

    void reject(@NotNull Throwable th, @NotNull WritableMap writableMap);

    void resolve(@Nullable Object obj);
}
