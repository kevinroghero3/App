package com.salesforce.marketingcloud;

import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface MCLogListener {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    /* JADX INFO: loaded from: classes6.dex */
    public static class AndroidLogListener implements MCLogListener {
        @Override // com.salesforce.marketingcloud.MCLogListener
        public void out(int i, @NotNull String tag, @NotNull String message, @Nullable Throwable th) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            if (i == 2) {
                if (th == null) {
                    Log.v(tag, message);
                    return;
                } else {
                    Log.v(tag, message, th);
                    return;
                }
            }
            if (i == 3) {
                if (th == null) {
                    Log.d(tag, message);
                    return;
                } else {
                    Log.d(tag, message, th);
                    return;
                }
            }
            if (i == 4) {
                if (th == null) {
                    Log.i(tag, message);
                    return;
                } else {
                    Log.i(tag, message, th);
                    return;
                }
            }
            if (i == 5) {
                if (th == null) {
                    Log.w(tag, message);
                    return;
                } else {
                    Log.w(tag, message, th);
                    return;
                }
            }
            if (i != 6) {
                return;
            }
            if (th == null) {
                Log.e(tag, message);
            } else {
                Log.e(tag, message, th);
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DEBUG = 3;
        public static final int ERROR = 6;
        public static final int INFO = 4;
        public static final int VERBOSE = 2;
        public static final int WARN = 5;

        private Companion() {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface LogLevel {
    }

    void out(@LogLevel int i, @NotNull String str, @NotNull String str2, @Nullable Throwable th);
}
