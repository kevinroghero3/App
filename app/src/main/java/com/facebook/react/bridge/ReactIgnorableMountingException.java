package com.facebook.react.bridge;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactIgnorableMountingException extends RuntimeException {
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final boolean isIgnorable(@NotNull Throwable th) {
        return Companion.isIgnorable(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactIgnorableMountingException(@NotNull String m) {
        super(m);
        Intrinsics.checkNotNullParameter(m, "m");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactIgnorableMountingException(@NotNull Throwable e) {
        super(e);
        Intrinsics.checkNotNullParameter(e, "e");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactIgnorableMountingException(@NotNull String m, @NotNull Throwable e) {
        super(m, e);
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(e, "e");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean isIgnorable(@NotNull Throwable e) {
            Intrinsics.checkNotNullParameter(e, "e");
            while (e != null) {
                if (e instanceof ReactIgnorableMountingException) {
                    return true;
                }
                e = e.getCause();
            }
            return false;
        }
    }
}
