package com.salesforce.marketingcloud.analytics.etanalytics;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.analytics.i;
import com.salesforce.marketingcloud.internal.n;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.storage.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class a extends i {
    private static final int f = 0;
    private final h d;
    private final n e;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.etanalytics.a$a, reason: collision with other inner class name */
    class C0066a extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ h c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0066a(String str, Object[] objArr, h hVar) {
            super(str, objArr);
            this.c = hVar;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            this.c.h().b(0);
        }
    }

    public a(@NonNull h hVar, @NonNull n nVar) {
        this.d = hVar;
        this.e = nVar;
    }

    public static void a(h hVar, n nVar, boolean z) {
        if (z) {
            a(nVar, hVar);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.j
    public void b(@NonNull NotificationMessage notificationMessage) {
        Region region = notificationMessage.region();
        if (TextUtils.isEmpty(notificationMessage.id()) || region == null) {
            return;
        }
        this.e.b().execute(new com.salesforce.marketingcloud.analytics.a(this.d.h(), this.d.b(), com.salesforce.marketingcloud.analytics.b.a(new Date(), 0, 3, Arrays.asList(notificationMessage.id(), region.id()), notificationMessage.requestId(), true)));
    }

    private static void a(n nVar, h hVar) {
        nVar.b().execute(new C0066a("delete_analytics", new Object[0], hVar));
    }

    @Override // com.salesforce.marketingcloud.analytics.i
    public void a(boolean z) {
        if (z) {
            a(this.e, this.d);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.j
    public void a(@NonNull NotificationMessage notificationMessage, boolean z) {
        if (notificationMessage.region() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(notificationMessage.id());
            arrayList.add(notificationMessage.region().id());
            com.salesforce.marketingcloud.analytics.b bVarA = com.salesforce.marketingcloud.analytics.b.a(new Date(), 0, 17, arrayList, notificationMessage.requestId(), true);
            bVarA.b(z ? 1 : 0);
            this.e.b().execute(new com.salesforce.marketingcloud.analytics.a(this.d.h(), this.d.b(), bVarA));
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.g
    public void a(@NonNull InboxMessage inboxMessage) {
        this.e.b().execute(new com.salesforce.marketingcloud.analytics.a(this.d.h(), this.d.b(), com.salesforce.marketingcloud.analytics.b.a(new Date(), 0, 14, Collections.singletonList(inboxMessage.id()), com.salesforce.marketingcloud.internal.d.b(inboxMessage), true)));
    }
}
