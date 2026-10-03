package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class DecoyKt {
    @ComposeCompilerApi
    public static final Void illegalDecoyCallException(@NotNull String str) {
        throw new IllegalStateException("Function " + str + " should have been replaced by compiler.");
    }
}
