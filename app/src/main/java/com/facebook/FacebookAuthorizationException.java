package com.facebook;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class FacebookAuthorizationException extends FacebookException {
    public static final Companion Companion = new Companion(null);
    public static final long serialVersionUID = 1;

    public FacebookAuthorizationException() {
    }

    public FacebookAuthorizationException(@Nullable String str) {
        super(str);
    }

    public FacebookAuthorizationException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public FacebookAuthorizationException(@Nullable Throwable th) {
        super(th);
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
