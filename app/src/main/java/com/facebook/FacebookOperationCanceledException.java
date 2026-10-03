package com.facebook;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class FacebookOperationCanceledException extends FacebookException {
    public static final Companion Companion = new Companion(null);
    public static final long serialVersionUID = 1;

    public FacebookOperationCanceledException() {
    }

    public FacebookOperationCanceledException(@Nullable String str) {
        super(str);
    }

    public FacebookOperationCanceledException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public FacebookOperationCanceledException(@Nullable Throwable th) {
        super(th);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
