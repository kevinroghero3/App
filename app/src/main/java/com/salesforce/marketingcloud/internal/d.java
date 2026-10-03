package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final a a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String a(@NotNull InboxMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getMessageHash$sdk_release();
        }

        @JvmStatic
        public final String b(@NotNull InboxMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getRequestId$sdk_release();
        }

        @JvmStatic
        public final int c(@NotNull InboxMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getViewCount$sdk_release();
        }

        private a() {
        }

        @JvmStatic
        public final void a(@NotNull InboxMessage message, boolean z) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.setDeleted(z);
        }

        @JvmStatic
        public final void b(@NotNull InboxMessage message, boolean z) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.setDirty$sdk_release(z);
        }

        @JvmStatic
        public final void c(@NotNull InboxMessage message, boolean z) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.setRead(z);
        }
    }

    @JvmStatic
    public static final String a(@NotNull InboxMessage inboxMessage) {
        return a.a(inboxMessage);
    }

    @JvmStatic
    public static final String b(@NotNull InboxMessage inboxMessage) {
        return a.b(inboxMessage);
    }

    @JvmStatic
    public static final void c(@NotNull InboxMessage inboxMessage, boolean z) {
        a.c(inboxMessage, z);
    }

    @JvmStatic
    public static final void a(@NotNull InboxMessage inboxMessage, boolean z) {
        a.a(inboxMessage, z);
    }

    @JvmStatic
    public static final void b(@NotNull InboxMessage inboxMessage, boolean z) {
        a.b(inboxMessage, z);
    }

    @JvmStatic
    public static final int c(@NotNull InboxMessage inboxMessage) {
        return a.c(inboxMessage);
    }
}
