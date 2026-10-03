package com.salesforce.marketingcloud.storage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface f {

    /* JADX INFO: loaded from: classes6.dex */
    public enum a {
        UNREAD,
        READ,
        DELETED,
        NOT_DELETED
    }

    public static class b {
        public final String a;
        public final String b;
        public final Date c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public b(@NonNull String str, @Nullable String str2, @Nullable Date date, boolean z, boolean z2, boolean z3) {
            this.a = str;
            this.b = str2;
            this.c = date;
            this.d = z;
            this.e = z2;
            this.f = z3;
        }
    }

    int a(@NonNull a aVar);

    int a(@NonNull List<String> list);

    InboxMessage a(@NonNull String str, @NonNull Crypto crypto);

    List<InboxMessage> a(@NonNull Crypto crypto, a aVar);

    void a(@NonNull InboxMessage inboxMessage, @NonNull Crypto crypto);

    void b();

    void b(@NonNull String[] strArr);

    void c(@NonNull String str);

    void d(@NonNull String str);

    boolean e(@NonNull String str);

    b f(@NonNull String str);

    int h();

    List<b> i();

    void j();

    List<InboxMessage> m(@NonNull Crypto crypto);
}
