package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.messages.Message;
import java.util.Date;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final a a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Message message, int i) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.setNotificationId$sdk_release(i);
        }

        @JvmStatic
        public final Date b(@NotNull Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getNextAllowedShow$sdk_release();
        }

        @JvmStatic
        public final int c(@NotNull Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getNotificationId$sdk_release();
        }

        @JvmStatic
        public final int d(@NotNull Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getPeriodShowCount$sdk_release();
        }

        @JvmStatic
        public final int e(@NotNull Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getShowCount$sdk_release();
        }

        private a() {
        }

        @JvmStatic
        public final Date a(@NotNull Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getLastShownDate$sdk_release();
        }

        @JvmStatic
        public final void b(@NotNull Message message, @Nullable Date date) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.setNextAllowedShow$sdk_release(date);
        }

        @JvmStatic
        public final void c(@NotNull Message message, int i) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.setShowCount$sdk_release(i);
        }

        @JvmStatic
        public final void a(@NotNull Message message, @Nullable Date date) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.setLastShownDate$sdk_release(date);
        }

        @JvmStatic
        public final void b(@NotNull Message message, int i) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.setPeriodShowCount$sdk_release(i);
        }
    }

    @JvmStatic
    public static final Date a(@NotNull Message message) {
        return a.a(message);
    }

    @JvmStatic
    public static final Date b(@NotNull Message message) {
        return a.b(message);
    }

    @JvmStatic
    public static final int c(@NotNull Message message) {
        return a.c(message);
    }

    @JvmStatic
    public static final int d(@NotNull Message message) {
        return a.d(message);
    }

    @JvmStatic
    public static final int e(@NotNull Message message) {
        return a.e(message);
    }

    @JvmStatic
    public static final void a(@NotNull Message message, @Nullable Date date) {
        a.a(message, date);
    }

    @JvmStatic
    public static final void b(@NotNull Message message, @Nullable Date date) {
        a.b(message, date);
    }

    @JvmStatic
    public static final void c(@NotNull Message message, int i) {
        a.c(message, i);
    }

    @JvmStatic
    public static final void a(@NotNull Message message, int i) {
        a.a(message, i);
    }

    @JvmStatic
    public static final void b(@NotNull Message message, int i) {
        a.b(message, i);
    }
}
