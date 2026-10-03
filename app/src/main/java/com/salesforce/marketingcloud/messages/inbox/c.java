package com.salesforce.marketingcloud.messages.inbox;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.internal.n;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.util.Crypto;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import o.ArtificialStackFrames;
import o.build;
import o.onPostMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class c implements InboxMessageManager {
    private static final String p = "inbox_watermark_key";
    final com.salesforce.marketingcloud.storage.h d;
    final com.salesforce.marketingcloud.analytics.g e;
    final com.salesforce.marketingcloud.http.e f;
    final MarketingCloudConfig g;
    final String h;
    private final com.salesforce.marketingcloud.alarms.b j;
    private final n k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private InboxMessageManager.InboxRefreshListener f73n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f74o;
    private final Set<InboxMessageManager.InboxResponseListener> i = new ArraySet();
    private final Object l = new Object();
    private final Object m = new Object();

    class a extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, String str2) {
            super(str, objArr);
            this.c = str2;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            c.this.d.l().b(TextUtils.split(this.c, ","));
        }
    }

    class b extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ boolean c;

        class a implements MarketingCloudSdk.WhenReadyListener {
            final /* synthetic */ com.salesforce.marketingcloud.http.b a;

            a(com.salesforce.marketingcloud.http.b bVar) {
                this.a = bVar;
            }

            @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
            public void ready(@NonNull MarketingCloudSdk marketingCloudSdk) {
                c cVar = c.this;
                com.salesforce.marketingcloud.http.e eVar = cVar.f;
                com.salesforce.marketingcloud.http.b bVar = this.a;
                MarketingCloudConfig marketingCloudConfig = cVar.g;
                com.salesforce.marketingcloud.storage.b bVarC = cVar.d.c();
                String strApplicationId = c.this.g.applicationId();
                c cVar2 = c.this;
                eVar.a(bVar.a(marketingCloudConfig, bVarC, com.salesforce.marketingcloud.http.b.a(strApplicationId, cVar2.h, cVar2.d())));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, boolean z) {
            super(str, objArr);
            this.c = z;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            MarketingCloudSdk.requestSdk(new a(this.c ? com.salesforce.marketingcloud.http.b.l : com.salesforce.marketingcloud.http.b.k));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c$c, reason: collision with other inner class name */
    class C0088c extends com.salesforce.marketingcloud.internal.i {
        C0088c(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            List<com.salesforce.marketingcloud.storage.f.b> listI = c.this.d.l().i();
            int size = listI.size();
            if (size > 0) {
                ArrayList arrayList = new ArrayList(size);
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("deviceId", c.this.h);
                    String strA = com.salesforce.marketingcloud.util.j.a(new Date());
                    for (com.salesforce.marketingcloud.storage.f.b bVar : listI) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("actionParameters", jSONObject);
                        jSONObject2.put("messageId", bVar.a);
                        jSONObject2.put("actionDate", strA);
                        jSONObject2.put("action", bVar.e ? "Deleted" : "Viewed");
                        jSONArray.put(jSONObject2);
                        arrayList.add(bVar.a);
                    }
                    com.salesforce.marketingcloud.http.b bVar2 = com.salesforce.marketingcloud.http.b.m;
                    c cVar = c.this;
                    com.salesforce.marketingcloud.http.c cVarA = bVar2.a(cVar.g, cVar.d.c(), com.salesforce.marketingcloud.http.b.a(c.this.g.applicationId()), jSONArray.toString());
                    cVarA.a(TextUtils.join(",", arrayList));
                    c.this.f.a(cVarA);
                } catch (JSONException e) {
                    com.salesforce.marketingcloud.g.b(InboxMessageManager.TAG, e, "Failed to create Inbox status payload.  Status updates not sent to Marketing Cloud", new Object[0]);
                }
            }
        }
    }

    class d extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ com.salesforce.marketingcloud.storage.f c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, com.salesforce.marketingcloud.storage.f fVar) {
            super(str, objArr);
            this.c = fVar;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            this.c.h();
        }
    }

    class e extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ InboxMessage c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, InboxMessage inboxMessage) {
            super(str, objArr);
            this.c = inboxMessage;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            c.this.d.l().a(this.c, c.this.d.b());
        }
    }

    class f extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, String str2) {
            super(str, objArr);
            this.c = str2;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            c.this.setMessageRead(this.c);
        }
    }

    class g extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, Object[] objArr, String str2) {
            super(str, objArr);
            this.c = str2;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            c.this.d.l().c(this.c);
        }
    }

    class h extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, Object[] objArr, String str2) {
            super(str, objArr);
            this.c = str2;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            c.this.d.l().d(this.c);
        }
    }

    class i extends com.salesforce.marketingcloud.internal.i {
        i(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            c.this.d.l().j();
        }
    }

    class j extends com.salesforce.marketingcloud.internal.i {
        j(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            c.this.d.l().b();
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b(false);
        }
    }

    c(MarketingCloudConfig marketingCloudConfig, com.salesforce.marketingcloud.storage.h hVar, String str, com.salesforce.marketingcloud.alarms.b bVar, com.salesforce.marketingcloud.http.e eVar, com.salesforce.marketingcloud.analytics.g gVar, n nVar) {
        this.g = marketingCloudConfig;
        this.d = hVar;
        this.h = str;
        this.j = bVar;
        this.f = eVar;
        this.e = gVar;
        this.k = nVar;
    }

    static void a(com.salesforce.marketingcloud.storage.h hVar, com.salesforce.marketingcloud.alarms.b bVar, n nVar, boolean z) {
        bVar.d(com.salesforce.marketingcloud.alarms.a.EnumC0062a.g);
        if (z) {
            nVar.b().execute(new d("inbox_shutdown", new Object[0], hVar.l()));
        }
    }

    void b() {
        this.f74o = true;
        a(false);
    }

    JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.salesforce.marketingcloud.storage.db.g.e, this.d.l().m(this.d.b()));
            return jSONObject;
        } catch (JSONException e2) {
            com.salesforce.marketingcloud.g.b(InboxMessageManager.TAG, e2, "Failed to create our component state JSONObject.", new Object[0]);
            return null;
        }
    }

    String d() {
        String string;
        synchronized (this.l) {
            string = this.d.e().getString(p, com.salesforce.marketingcloud.util.j.a(new Date(0L)));
        }
        return string;
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void deleteMessage(@Nullable InboxMessage inboxMessage) {
        if (inboxMessage == null) {
            com.salesforce.marketingcloud.g.b(InboxMessageManager.TAG, "InboxMessage was null and could not be updated.  Call to deleteMessage() ignored.", new Object[0]);
        } else {
            com.salesforce.marketingcloud.internal.d.a(inboxMessage, true);
            deleteMessage(inboxMessage.id());
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void disableInbox() {
    }

    void e() {
        this.k.b().execute(new C0088c("send_inbox_message_status", new Object[0]));
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void enableInbox() {
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public int getDeletedMessageCount() {
        return this.d.l().a(com.salesforce.marketingcloud.storage.f.a.DELETED);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public List<InboxMessage> getDeletedMessages() {
        return this.d.l().a(this.d.b(), com.salesforce.marketingcloud.storage.f.a.DELETED);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public int getMessageCount() {
        return this.d.l().a(com.salesforce.marketingcloud.storage.f.a.NOT_DELETED);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public List<InboxMessage> getMessages() {
        return this.d.l().a(this.d.b(), com.salesforce.marketingcloud.storage.f.a.NOT_DELETED);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public int getReadMessageCount() {
        return this.d.l().a(com.salesforce.marketingcloud.storage.f.a.READ);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public List<InboxMessage> getReadMessages() {
        return this.d.l().a(this.d.b(), com.salesforce.marketingcloud.storage.f.a.READ);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public int getUnreadMessageCount() {
        return this.d.l().a(com.salesforce.marketingcloud.storage.f.a.UNREAD);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public List<InboxMessage> getUnreadMessages() {
        return this.d.l().a(this.d.b(), com.salesforce.marketingcloud.storage.f.a.UNREAD);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public boolean isInboxEnabled() {
        return true;
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void markAllMessagesDeleted() {
        this.k.b().execute(new j("delete_all", new Object[0]));
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void markAllMessagesRead() {
        this.k.b().execute(new i("mark_all_read", new Object[0]));
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void refreshInbox(InboxMessageManager.InboxRefreshListener inboxRefreshListener) {
        synchronized (this.m) {
            if (this.f73n == null) {
                this.f73n = inboxRefreshListener;
                com.salesforce.marketingcloud.g.d(InboxMessageManager.TAG, "Refreshing inbox messages", new Object[0]);
                a(true);
            } else {
                com.salesforce.marketingcloud.g.d(InboxMessageManager.TAG, "Refresh already in progress.", new Object[0]);
                try {
                    inboxRefreshListener.onRefreshComplete(false);
                } catch (Exception e2) {
                    com.salesforce.marketingcloud.g.b(InboxMessageManager.TAG, e2, "Error delivering Refresh Complete result to %s", inboxRefreshListener.getClass().getName());
                }
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void registerInboxResponseListener(@NonNull InboxMessageManager.InboxResponseListener inboxResponseListener) {
        if (inboxResponseListener != null) {
            synchronized (this.i) {
                this.i.add(inboxResponseListener);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void setMessageRead(@Nullable InboxMessage inboxMessage) {
        if (inboxMessage == null) {
            com.salesforce.marketingcloud.g.b(InboxMessageManager.TAG, "InboxMessage was null and could not be updated.  Call to setMessageRead() ignored.", new Object[0]);
        } else {
            com.salesforce.marketingcloud.internal.d.c(inboxMessage, true);
            setMessageRead(inboxMessage.id());
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void unregisterInboxResponseListener(@NonNull InboxMessageManager.InboxResponseListener inboxResponseListener) {
        synchronized (this.i) {
            this.i.remove(inboxResponseListener);
        }
    }

    void b(boolean z) {
        synchronized (this.m) {
            InboxMessageManager.InboxRefreshListener inboxRefreshListener = this.f73n;
            if (inboxRefreshListener != null) {
                try {
                    inboxRefreshListener.onRefreshComplete(z);
                } catch (Exception e2) {
                    com.salesforce.marketingcloud.g.b(InboxMessageManager.TAG, e2, "InboxRefreshListener threw an exception", new Object[0]);
                }
                this.f73n = null;
            }
        }
    }

    void a() {
        this.f74o = false;
        e();
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void deleteMessage(@NonNull String str) {
        this.k.b().execute(new g("inbox_delete", new Object[0], str));
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void setMessageRead(@NonNull String str) {
        this.k.b().execute(new h("mark_read", new Object[0], str));
    }

    void a(InboxMessage inboxMessage) {
        this.k.b().execute(new e("inbox_push_received", new Object[0], inboxMessage));
        if (this.f74o) {
            a(false);
        }
    }

    void b(@NonNull List<InboxMessage> list) {
        this.k.b().execute(new l("inbox_updated", new Object[0], list));
    }

    void b(int i2, String str) {
        com.salesforce.marketingcloud.g.c(InboxMessageManager.TAG, "Request failed: %d - %s", Integer.valueOf(i2), str);
        this.j.b(com.salesforce.marketingcloud.alarms.a.EnumC0062a.g);
    }

    void a(@NonNull NotificationMessage notificationMessage) {
        if (this.g.markMessageReadOnInboxNotificationOpen()) {
            this.k.b().execute(new f("inbox_notification_opened", new Object[0], notificationMessage.id()));
        }
    }

    void a(com.salesforce.marketingcloud.http.f fVar) {
        int length;
        try {
            JSONObject jSONObject = new JSONObject(fVar.j());
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.salesforce.marketingcloud.storage.db.i.e);
            List<InboxMessage> listEmptyList = Collections.emptyList();
            if (jSONArrayOptJSONArray != null && (length = jSONArrayOptJSONArray.length()) > 0) {
                listEmptyList = new ArrayList<>(length);
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                        listEmptyList.add(new InboxMessage(jSONObject2, jSONObject2.optBoolean("isDeleted")));
                    } catch (Exception e2) {
                        com.salesforce.marketingcloud.g.b(InboxMessageManager.TAG, e2, "Failed to parse inbox message", new Object[0]);
                    }
                }
            }
            b(listEmptyList);
            a(jSONObject.optString("waterMark"));
        } catch (Exception e3) {
            com.salesforce.marketingcloud.g.b(InboxMessageManager.TAG, e3, "Failed to parse inbox messages response", new Object[0]);
            a(-1, "Failed to parse response");
        }
    }

    void a(@Nullable String str) {
        if (!com.salesforce.marketingcloud.util.j.f(str)) {
            com.salesforce.marketingcloud.g.e(InboxMessageManager.TAG, "Could not convert watermark to a date", new Object[0]);
            return;
        }
        synchronized (this.l) {
            this.d.e().edit().putString(p, str).apply();
        }
    }

    void a(int i2, String str) {
        com.salesforce.marketingcloud.g.c(InboxMessageManager.TAG, "Request failed: %d - %s", Integer.valueOf(i2), str);
        new Handler(Looper.getMainLooper()).post(new k());
    }

    void a(List<InboxMessage> list) {
        synchronized (this.i) {
            if (!this.i.isEmpty()) {
                for (InboxMessageManager.InboxResponseListener inboxResponseListener : this.i) {
                    if (inboxResponseListener != null) {
                        try {
                            inboxResponseListener.onInboxMessagesChanged(list);
                        } catch (Exception e2) {
                            com.salesforce.marketingcloud.g.b(InboxMessageManager.TAG, e2, "%s threw an exception while processing the inbox messages response", inboxResponseListener.getClass().getName());
                        }
                    }
                }
            }
        }
    }

    void a(com.salesforce.marketingcloud.http.c cVar) {
        if (cVar.r() != null) {
            this.j.c(com.salesforce.marketingcloud.alarms.a.EnumC0062a.g);
            this.k.b().execute(new a("inbox_status_updated", new Object[0], cVar.r()));
        }
    }

    private void a(boolean z) {
        this.k.b().execute(new b("fetch_inbox_messages", new Object[0], z));
    }

    class l extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ List c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(String str, Object[] objArr, List list) {
            super(str, objArr);
            this.c = list;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0086  */
        /* JADX WARN: Code duplicated, block: B:34:0x0097  */
        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            boolean z;
            com.salesforce.marketingcloud.storage.f fVarL = c.this.d.l();
            Crypto cryptoB = c.this.d.b();
            if (!this.c.isEmpty()) {
                List<String> listEmptyList = Collections.emptyList();
                for (InboxMessage inboxMessage : this.c) {
                    if (inboxMessage.getDeleted()) {
                        if (listEmptyList.isEmpty()) {
                            listEmptyList = new ArrayList<>();
                        }
                        listEmptyList.add(inboxMessage.id);
                    } else {
                        com.salesforce.marketingcloud.storage.f.b bVarF = fVarL.f(inboxMessage.id());
                        boolean z2 = true;
                        if (bVarF != null) {
                            String str = bVarF.b;
                            if (str == null) {
                                com.salesforce.marketingcloud.internal.d.a(inboxMessage, bVarF.e);
                                com.salesforce.marketingcloud.internal.d.c(inboxMessage, bVarF.d);
                            } else {
                                if (str.equals(com.salesforce.marketingcloud.internal.d.a(inboxMessage))) {
                                    com.salesforce.marketingcloud.internal.d.a(inboxMessage, bVarF.e);
                                    com.salesforce.marketingcloud.internal.d.c(inboxMessage, bVarF.d);
                                    if (bVarF.c != null) {
                                        z = false;
                                    }
                                }
                                com.salesforce.marketingcloud.internal.d.b(inboxMessage, bVarF.f);
                                if (com.salesforce.marketingcloud.internal.d.c(inboxMessage) > 0) {
                                    com.salesforce.marketingcloud.internal.d.c(inboxMessage, true);
                                }
                                if (bVarF.e || (bVarF.d && com.salesforce.marketingcloud.internal.d.c(inboxMessage) == 0)) {
                                    com.salesforce.marketingcloud.internal.d.b(inboxMessage, true);
                                }
                                z2 = z;
                            }
                            z = true;
                            com.salesforce.marketingcloud.internal.d.b(inboxMessage, bVarF.f);
                            if (com.salesforce.marketingcloud.internal.d.c(inboxMessage) > 0) {
                                com.salesforce.marketingcloud.internal.d.c(inboxMessage, true);
                            }
                            if (bVarF.e) {
                                com.salesforce.marketingcloud.internal.d.b(inboxMessage, true);
                            } else {
                                com.salesforce.marketingcloud.internal.d.b(inboxMessage, true);
                            }
                            z2 = z;
                        }
                        fVarL.a(inboxMessage, cryptoB);
                        if (z2) {
                            c.this.e.a(inboxMessage);
                        }
                    }
                }
                fVarL.a(listEmptyList);
            }
            new Handler(Looper.getMainLooper()).post(new a());
        }

        public class a implements Runnable {
            private static final byte[] $$a = {67, 87, 59, -10};
            private static final int $$b = 17;
            private static int $10 = 0;
            private static int $11 = 1;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char TopicBuilder = 50542;
            private static char ICustomTabsCallback = 41278;
            private static char extraCallbackWithResult = 53435;
            private static char onMessageChannelReady = 14614;
            private static char[] IPostMessageService = {38363, 38265, 38149, 38152, 38150, 38148, 38271, 38147, 38153, 38182, 38183, 38150, 38145, 38270, 38147, 38150, 38270, 38174, 38199, 38166, 38145, 38270, 38147, 38284, 38357, 38356, 38361, 38355, 38365, 38375, 38365, 38360, 38361, 38363, 38361, 38376, 38372, 38307, 38283, 38285, 38286, 38396, 38284, 38361, 38355, 38369, 38372, 38351, 38348, 38357, 38360, 38359, 38363, 38285, 38356, 38348, 38347, 38357, 38360, 38357, 38359, 38369, 38399, 38386, 38353, 38384, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38275, 38345, 38350, 38375, 38370, 38345, 38355, 38380, 38374, 38349, 38358, 38285, 38355, 38357, 38365, 38361, 38360, 38360, 38353, 38348, 38356, 38379, 38379, 38355, 38357, 38358, 38356, 38358, 38358, 38361, 38282, 38362, 38356, 38356, 38392, 38383, 38355, 38363, 38355, 38348, 38354, 38353, 38345, 38380, 38391, 38363, 38356, 38348, 38382, 38396, 38393, 38285, 38283, 38273, 38379, 38356, 38348, 38353, 38360, 38360, 38361, 38365, 38357, 38355};

            /* JADX WARN: Code duplicated, block: B:10:0x0026  */
            /* JADX WARN: Code duplicated, block: B:8:0x0020  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$c(byte r7, short r8, short r9) {
                /*
                    int r8 = r8 * 4
                    int r8 = r8 + 1
                    int r9 = r9 * 3
                    int r9 = r9 + 4
                    int r7 = 122 - r7
                    byte[] r0 = com.salesforce.marketingcloud.messages.inbox.c.l.a.$$a
                    byte[] r1 = new byte[r8]
                    r2 = 0
                    if (r0 != 0) goto L15
                    r3 = r8
                    r7 = r9
                    r4 = r2
                    goto L28
                L15:
                    r3 = r2
                    r6 = r9
                    r9 = r7
                    r7 = r6
                L19:
                    int r4 = r3 + 1
                    byte r5 = (byte) r9
                    r1[r3] = r5
                    if (r4 != r8) goto L26
                    java.lang.String r7 = new java.lang.String
                    r7.<init>(r1, r2)
                    return r7
                L26:
                    r3 = r0[r7]
                L28:
                    int r9 = r9 + r3
                    int r7 = r7 + 1
                    r3 = r4
                    goto L19
                */
                throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.inbox.c.l.a.$$c(byte, short, short):java.lang.String");
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar = l.this;
                c.this.a(lVar.c);
                c.this.b(true);
            }

            private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
                int i2 = 2 % 2;
                build buildVar = new build();
                char[] cArr2 = new char[cArr.length];
                int i3 = 0;
                buildVar.c = 0;
                char[] cArr3 = new char[2];
                while (buildVar.c < cArr.length) {
                    int i4 = $10 + 123;
                    $11 = i4 % 128;
                    if (i4 % 2 == 0) {
                        cArr3[1] = cArr[buildVar.c];
                        cArr3[i3] = cArr[buildVar.c << 1];
                    } else {
                        cArr3[i3] = cArr[buildVar.c];
                        cArr3[1] = cArr[buildVar.c + 1];
                    }
                    int i5 = $11 + 101;
                    $10 = i5 % 128;
                    int i6 = i5 % 2;
                    int i7 = 58224;
                    int i8 = i3;
                    while (i8 < 16) {
                        char c = cArr3[1];
                        char c2 = cArr3[i3];
                        char[] cArr4 = cArr3;
                        try {
                            Object[] objArr2 = {Integer.valueOf(c), Integer.valueOf((c2 + i7) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))))), Integer.valueOf(c2 >>> 5), Integer.valueOf(onMessageChannelReady)};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                            if (objAccessartificialFrame == null) {
                                byte b = (byte) 0;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(28 - TextUtils.indexOf("", "", 0), (char) (17263 - View.MeasureSpec.getMode(0)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1066, 1042277788, false, $$c((byte) ($$b - 3), b, b), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                            }
                            char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            cArr4[1] = cCharValue;
                            Object[] objArr3 = {Integer.valueOf(cArr4[0]), Integer.valueOf((cCharValue + i7) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                            if (objAccessartificialFrame2 == null) {
                                byte b2 = (byte) 0;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((-16777188) - Color.rgb(0, 0, 0), (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 17263), 1067 - Color.red(0), 1042277788, false, $$c((byte) ($$b - 3), b2, b2), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                            }
                            cArr4[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                            i7 -= 40503;
                            i8++;
                            int i9 = $10 + 125;
                            $11 = i9 % 128;
                            int i10 = i9 % 2;
                            cArr3 = cArr4;
                            i3 = 0;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    char[] cArr5 = cArr3;
                    cArr2[buildVar.c] = cArr5[0];
                    cArr2[buildVar.c + 1] = cArr5[1];
                    Object[] objArr4 = {buildVar, buildVar};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
                    if (objAccessartificialFrame3 == null) {
                        byte b3 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (Color.argb(0, 0, 0, 0) + 63928), TextUtils.indexOf((CharSequence) "", '0') + 487, 1554985764, false, $$c((byte) ($$b - 5), b3, b3), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    int i11 = $10 + 125;
                    $11 = i11 % 128;
                    int i12 = i11 % 2;
                    cArr3 = cArr5;
                    i3 = 0;
                }
                objArr[0] = new String(cArr2, 0, i);
            }

            /* JADX WARN: Code duplicated, block: B:56:0x024d  */
            /* JADX WARN: Code duplicated, block: B:57:0x024e  */
            private static void c(boolean z, byte[] bArr, int[] iArr, Object[] objArr) throws Throwable {
                int i;
                Throwable cause;
                int i2 = 2 % 2;
                onPostMessage onpostmessage = new onPostMessage();
                int i3 = 0;
                int i4 = iArr[0];
                int i5 = iArr[1];
                int i6 = iArr[2];
                int i7 = iArr[3];
                char[] cArr = IPostMessageService;
                long j = 0;
                if (cArr != null) {
                    int i8 = $11 + 89;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                    int length = cArr.length;
                    char[] cArr2 = new char[length];
                    int i10 = 0;
                    while (i10 < length) {
                        try {
                            Object[] objArr2 = new Object[1];
                            objArr2[i3] = Integer.valueOf(cArr[i10]);
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                            if (objAccessartificialFrame == null) {
                                byte b = (byte) i3;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(10 - ExpandableListView.getPackedPositionChild(j), (char) View.getDefaultSize(i3, i3), (ViewConfiguration.getEdgeSlop() >> 16) + 1562, 178318710, false, $$c((byte) ($$b | 40), b, b), new Class[]{Integer.TYPE});
                            }
                            cArr2[i10] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            i10++;
                            i3 = 0;
                            j = 0;
                        } catch (Throwable th) {
                            Throwable cause2 = th.getCause();
                            if (cause2 == null) {
                                throw th;
                            }
                            throw cause2;
                        }
                    }
                    cArr = cArr2;
                }
                char[] cArr3 = new char[i5];
                System.arraycopy(cArr, i4, cArr3, 0, i5);
                if (bArr != null) {
                    char[] cArr4 = new char[i5];
                    onpostmessage.a = 0;
                    char c = 0;
                    while (onpostmessage.a < i5) {
                        int i11 = $11 + 93;
                        $10 = i11 % 128;
                        int i12 = i11 % 2;
                        if (bArr[onpostmessage.a] == 1) {
                            int i13 = $11 + 119;
                            $10 = i13 % 128;
                            if (i13 % 2 != 0) {
                                int i14 = onpostmessage.a;
                                Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                                if (objAccessartificialFrame2 == null) {
                                    byte b2 = (byte) 0;
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 23, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1), 2441 - KeyEvent.normalizeMetaState(0), -850656813, false, $$c((byte) 54, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                                }
                                cArr4[i14] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                                throw null;
                            }
                            int i15 = onpostmessage.a;
                            try {
                                Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                                if (objAccessartificialFrame3 == null) {
                                    byte b3 = (byte) 0;
                                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0') + 24, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), Gravity.getAbsoluteGravity(0, 0) + 2441, -850656813, false, $$c((byte) 54, b3, b3), new Class[]{Integer.TYPE, Integer.TYPE});
                                }
                                cArr4[i15] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                            } catch (Throwable th2) {
                                cause = th2.getCause();
                                if (cause != null) {
                                    throw th2;
                                }
                                throw cause;
                            }
                            cause = th2.getCause();
                            if (cause != null) {
                                throw th2;
                            }
                            throw cause;
                        }
                        int i16 = onpostmessage.a;
                        Object[] objArr5 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                        if (objAccessartificialFrame4 == null) {
                            byte b4 = (byte) 0;
                            byte b5 = b4;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(11 - View.getDefaultSize(0, 0), (char) Color.green(0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 1562, 1918398056, false, $$c(b4, b5, b5), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i16] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                        c = cArr4[onpostmessage.a];
                        Object[] objArr6 = {onpostmessage, onpostmessage};
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                        if (objAccessartificialFrame5 == null) {
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 22, (char) (29364 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), 216 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    }
                    cArr3 = cArr4;
                }
                if (i7 > 0) {
                    char[] cArr5 = new char[i5];
                    i = 0;
                    System.arraycopy(cArr3, 0, cArr5, 0, i5);
                    int i17 = i5 - i7;
                    System.arraycopy(cArr5, 0, cArr3, i17, i7);
                    System.arraycopy(cArr5, i7, cArr3, 0, i17);
                } else {
                    i = 0;
                }
                if (z) {
                    char[] cArr6 = new char[i5];
                    while (true) {
                        onpostmessage.a = i;
                        if (onpostmessage.a >= i5) {
                            break;
                        }
                        cArr6[onpostmessage.a] = cArr3[(i5 - onpostmessage.a) - 1];
                        i = onpostmessage.a + 1;
                    }
                    cArr3 = cArr6;
                }
                if (i6 > 0) {
                    int i18 = 0;
                    while (true) {
                        onpostmessage.a = i18;
                        if (onpostmessage.a >= i5) {
                            break;
                        }
                        int i19 = $10 + 119;
                        $11 = i19 % 128;
                        int i20 = i19 % 2;
                        cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                        i18 = onpostmessage.a + 1;
                    }
                }
                objArr[0] = new String(cArr3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r6v0 */
            /* JADX WARN: Type inference failed for: r6v25 */
            /* JADX WARN: Type inference failed for: r8v0 */
            /* JADX WARN: Type inference failed for: r8v37 */
            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] accessartificialFrame(android.content.Context r26, int r27, int r28) {
                /*
                    Method dump skipped, instruction units count: 2828
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.inbox.c.l.a.accessartificialFrame(android.content.Context, int, int):java.lang.Object[]");
            }
        }
    }
}
