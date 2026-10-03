package com.salesforce.marketingcloud.messages.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.google.firebase.messaging.RemoteMessage;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MCService;
import com.salesforce.marketingcloud.analytics.j;
import com.salesforce.marketingcloud.behaviors.c;
import com.salesforce.marketingcloud.e;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.internal.CompressionUtility;
import com.salesforce.marketingcloud.internal.n;
import com.salesforce.marketingcloud.k;
import com.salesforce.marketingcloud.media.o;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.push.f;
import com.salesforce.marketingcloud.push.i;
import com.salesforce.marketingcloud.storage.h;
import io.sentry.protocol.SentryThread;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends PushMessageManager implements e, com.salesforce.marketingcloud.alarms.b.InterfaceC0064b {
    private static final String A = "content-available";
    private static final String B = "_c";
    private static final String C = "_p";
    private static final long D = TimeUnit.HOURS.toMillis(48);
    static final String y = "et_push_enabled";
    private static final String z = "last_push_token_refresh";
    private final Context j;
    private final com.salesforce.marketingcloud.notifications.a k;
    private final com.salesforce.marketingcloud.alarms.b l;
    private final Set<PushMessageManager.SilentPushListener> m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final h f75n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f76o;
    private final Set<PushMessageManager.PushTokenRefreshListener> p;
    private final j q;
    private final n r;
    private final i s;
    com.salesforce.marketingcloud.push.h t;
    private o u;
    private int v;
    private BroadcastReceiver w;
    private boolean x;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.push.a$a, reason: collision with other inner class name */
    class RunnableC0090a implements Runnable {
        final /* synthetic */ Map b;

        RunnableC0090a(Map map) {
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(a.this.j, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_SDK_PUSH_RECEIVED, a.b((Map<String, String>) this.b));
            if (k.a((Map<String, String>) this.b)) {
                g.d(PushMessageManager.i, "Sync handler push received.", new Object[0]);
                return;
            }
            if (!a.this.isPushEnabled()) {
                g.a(PushMessageManager.i, "Push Messaging is disabled.  Ignoring message.", new Object[0]);
                return;
            }
            if (this.b.containsKey(a.A)) {
                a.this.c(this.b);
                return;
            }
            if (this.b.containsKey(a.B)) {
                a.this.d(this.b);
                return;
            }
            try {
                NotificationMessage notificationMessageA = com.salesforce.marketingcloud.internal.j.a(CompressionUtility.INSTANCE.decompress(this.b));
                if (TextUtils.isEmpty(notificationMessageA.alert().trim())) {
                    g.a(PushMessageManager.i, "Message (%s) was received but does not have an alert message.", notificationMessageA.id());
                    return;
                }
                a.this.t.b(notificationMessageA);
                a.this.k.a(notificationMessageA, (com.salesforce.marketingcloud.notifications.a.b) null);
                a.this.q.a(this.b);
            } catch (f e) {
                g.b(PushMessageManager.i, e, "Unable to decompress push message", new Object[0]);
                String str = (String) this.b.get(NotificationMessage.NOTIF_KEY_ID);
                if (str != null) {
                    a.this.q.a(e, str);
                }
            } catch (Exception e2) {
                g.b(PushMessageManager.i, e2, "Unable to show push notification", new Object[0]);
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                g.d(PushMessageManager.i, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                g.d(PushMessageManager.i, "Received null action", new Object[0]);
            } else if (action.equals(PushMessageManager.d)) {
                a.this.a(intent.getExtras());
            } else {
                g.a(PushMessageManager.i, "Received unknown action: %s", action);
            }
        }
    }

    public a(@NonNull Context context, @NonNull h hVar, @NonNull com.salesforce.marketingcloud.notifications.a aVar, @NonNull com.salesforce.marketingcloud.alarms.b bVar, @Nullable String str, @NonNull j jVar, @NonNull o oVar, @NonNull n nVar) {
        i iVar = i.a;
        this.s = iVar;
        this.j = (Context) com.salesforce.marketingcloud.util.g.a(context, "Content is null");
        this.f75n = (h) com.salesforce.marketingcloud.util.g.a(hVar, "Storage is null");
        this.k = (com.salesforce.marketingcloud.notifications.a) com.salesforce.marketingcloud.util.g.a(aVar, "NotificationManager is null");
        this.l = (com.salesforce.marketingcloud.alarms.b) com.salesforce.marketingcloud.util.g.a(bVar, "AlarmScheduler is null");
        this.f76o = str;
        this.q = jVar;
        this.u = oVar;
        this.r = nVar;
        this.m = new ArraySet();
        this.p = new ArraySet();
        iVar.a(oVar);
        this.t = new com.salesforce.marketingcloud.push.h(oVar);
    }

    public static void a(@NonNull Context context, boolean z2, String str, String str2) {
        context.sendBroadcast(new Intent(PushMessageManager.d).putExtra(PushMessageManager.e, z2).putExtra(PushMessageManager.f, str).putExtra(PushMessageManager.h, str2).setPackage(context.getPackageName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle b(@NonNull Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (!map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
        }
        return bundle;
    }

    private void c() {
        this.w = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushMessageManager.d);
        ContextCompat.registerReceiver(this.j, this.w, intentFilter, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Map<String, String> map) {
        map.remove(B);
        map.remove(C);
        e(map);
    }

    private void e(Map<String, String> map) {
        synchronized (this.m) {
            for (PushMessageManager.SilentPushListener silentPushListener : this.m) {
                if (silentPushListener != null) {
                    try {
                        silentPushListener.silentPushReceived(map);
                    } catch (Exception e) {
                        g.b(PushMessageManager.i, e, "%s threw an exception while processing the silent push message", silentPushListener.getClass().getName());
                    }
                }
            }
        }
    }

    private void f(Map<String, String> map) {
        if (map == null || g(map)) {
            return;
        }
        this.r.a().submit(new RunnableC0090a(map));
    }

    private boolean g(Map<String, String> map) {
        if (com.salesforce.marketingcloud.b.a(this.v, 4)) {
            g.a(PushMessageManager.i, "Blocking push message.  Received a push message when the push feature is blocked.", new Object[0]);
        } else {
            if (!com.salesforce.marketingcloud.b.a(this.v, 128) || !com.salesforce.marketingcloud.messages.inbox.a.a(map)) {
                return false;
            }
            g.a(PushMessageManager.i, "Blocking push message.  Received an inbox message when the inbox feature is blocked.", new Object[0]);
        }
        return true;
    }

    @Override // com.salesforce.marketingcloud.d
    public String componentName() {
        return "PushMessageManager";
    }

    @Override // com.salesforce.marketingcloud.d
    public JSONObject componentState() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pushEnabled", this.x);
            jSONObject.put("pushPermissionsAllowed", NotificationManagerCompat.from(this.j).areNotificationsEnabled());
            synchronized (this.p) {
                if (!this.p.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (PushMessageManager.PushTokenRefreshListener pushTokenRefreshListener : this.p) {
                        if (pushTokenRefreshListener != null) {
                            jSONArray.put(pushTokenRefreshListener.getClass().getName());
                        }
                    }
                    jSONObject.put("tokenRefreshListeners", jSONArray);
                }
            }
            jSONObject.put("debugInfo", getPushDebugInfo());
        } catch (JSONException e) {
            g.b(PushMessageManager.i, e, "Unable to create component state for $s", componentName());
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.e
    public void controlChannelInit(int i) {
        if (!com.salesforce.marketingcloud.b.a(i, 4)) {
            if (com.salesforce.marketingcloud.b.a(this.v, 4)) {
                this.v = i;
                c();
                this.l.a(this, com.salesforce.marketingcloud.alarms.a.EnumC0062a.f);
                enablePush();
                String str = this.f76o;
                if (str != null) {
                    MCService.b(this.j, str);
                    return;
                }
                return;
            }
            return;
        }
        disablePush();
        BroadcastReceiver broadcastReceiver = this.w;
        if (broadcastReceiver != null) {
            this.j.unregisterReceiver(broadcastReceiver);
        }
        com.salesforce.marketingcloud.alarms.b bVar = this.l;
        com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a = com.salesforce.marketingcloud.alarms.a.EnumC0062a.f;
        bVar.e(enumC0062a);
        this.l.d(enumC0062a);
        if (com.salesforce.marketingcloud.b.c(i, 4)) {
            com.salesforce.marketingcloud.storage.b bVarC = this.f75n.c();
            bVarC.a(com.salesforce.marketingcloud.storage.b.i);
            bVarC.a(com.salesforce.marketingcloud.storage.b.e);
        }
        this.v = i;
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public void disablePush() {
        synchronized (this) {
            if (this.x && !com.salesforce.marketingcloud.b.a(this.v, 4)) {
                this.x = false;
                a();
                d();
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public void enablePush() {
        synchronized (this) {
            if (com.salesforce.marketingcloud.b.a(this.v, 4)) {
                return;
            }
            this.x = true;
            a();
            d();
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public JSONObject getPushDebugInfo() {
        try {
            return com.salesforce.marketingcloud.messages.push.b.a(this.j, this.f76o, this.f75n.c().b(com.salesforce.marketingcloud.storage.b.e, null));
        } catch (Exception e) {
            g.b(PushMessageManager.i, e, "Unable to acquire push debug info.", new Object[0]);
            return new JSONObject();
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public String getPushToken() {
        return this.f75n.c().b(com.salesforce.marketingcloud.storage.b.e, null);
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public boolean handleMessage(@NonNull RemoteMessage remoteMessage) {
        if (!PushMessageManager.isMarketingCloudPush(remoteMessage)) {
            g.a(PushMessageManager.i, "Message was not sent from the Marketing Cloud.  Message ignored.", new Object[0]);
            return false;
        }
        Map<String, String> data = remoteMessage.getData();
        data.put("messageDateUtc", com.salesforce.marketingcloud.util.j.a(new Date(remoteMessage.getSentTime())));
        f(data);
        return true;
    }

    @Override // com.salesforce.marketingcloud.e
    public void init(@NonNull InitializationStatus.a aVar, int i) {
        this.v = i;
        if (com.salesforce.marketingcloud.b.b(i, 4)) {
            this.x = this.f75n.e().getBoolean(y, true);
            c();
            com.salesforce.marketingcloud.alarms.b bVar = this.l;
            com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a = com.salesforce.marketingcloud.alarms.a.EnumC0062a.f;
            bVar.a(this, enumC0062a);
            if (this.f76o == null) {
                g.e(PushMessageManager.i, "No sender id was provided during initialization.  You will not receive push messages until a token is manually set.", new Object[0]);
                this.l.d(enumC0062a);
                this.f75n.c().a(com.salesforce.marketingcloud.storage.b.i);
                return;
            }
            b();
            if (!this.f76o.equals(this.f75n.c().b(com.salesforce.marketingcloud.storage.b.i, null))) {
                g.d(PushMessageManager.i, "Sender Id has changed.  Refresh system token.", new Object[0]);
                MCService.b(this.j, this.f76o);
            } else if (this.f75n.e().getLong(z, 0L) + D < System.currentTimeMillis()) {
                g.d(PushMessageManager.i, "Push token refresh cool down expired.  Refresh system token.", new Object[0]);
                MCService.b(this.j, this.f76o);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public boolean isPushEnabled() {
        boolean z2;
        synchronized (this) {
            z2 = this.x;
        }
        return z2;
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public void registerSilentPushListener(@NonNull PushMessageManager.SilentPushListener silentPushListener) {
        if (silentPushListener == null) {
            return;
        }
        synchronized (this.m) {
            this.m.add(silentPushListener);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public void registerTokenRefreshListener(@NonNull PushMessageManager.PushTokenRefreshListener pushTokenRefreshListener) {
        if (pushTokenRefreshListener == null) {
            return;
        }
        synchronized (this.p) {
            this.p.add(pushTokenRefreshListener);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public void setPushToken(@NonNull String str) {
        if (com.salesforce.marketingcloud.b.b(this.v, 4)) {
            if (str == null) {
                g.b(PushMessageManager.i, "Provided pushToken was null", new Object[0]);
                return;
            }
            if (this.f76o != null) {
                g.a(PushMessageManager.i, "Setting the SenderId during SDK initialization and setting the push token will cause conflicts in the system and could prevent the device from receiving push messages.", new Object[0]);
            }
            com.salesforce.marketingcloud.storage.b bVarC = this.f75n.c();
            bVarC.a(com.salesforce.marketingcloud.storage.b.i);
            bVarC.a(com.salesforce.marketingcloud.storage.b.e, str);
            this.l.d(com.salesforce.marketingcloud.alarms.a.EnumC0062a.f);
            b(str);
        }
    }

    @Override // com.salesforce.marketingcloud.d
    public void tearDown(boolean z2) {
        BroadcastReceiver broadcastReceiver = this.w;
        if (broadcastReceiver != null) {
            this.j.unregisterReceiver(broadcastReceiver);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public void unregisterSilentPushListener(@NonNull PushMessageManager.SilentPushListener silentPushListener) {
        synchronized (this.m) {
            this.m.remove(silentPushListener);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public void unregisterTokenRefreshListener(@NonNull PushMessageManager.PushTokenRefreshListener pushTokenRefreshListener) {
        synchronized (this.p) {
            this.p.remove(pushTokenRefreshListener);
        }
    }

    private void b() {
        JSONArray jSONArrayOptJSONArray = getPushDebugInfo().optJSONArray("messagingService");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 2) {
            return;
        }
        g.e(PushMessageManager.i, "Possible Multiple Push Provider implementation issue detected in your application. This may lead to the malfunctioning of the Push SDK.", new Object[0]);
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            int iOptInt = jSONObjectOptJSONObject.optInt(SentryThread.JsonKeys.PRIORITY);
            String strOptString = jSONObjectOptJSONObject.optString("name");
            if (iOptInt > -1) {
                g.d(PushMessageManager.i, strOptString + " is having higher priority than the Push SDK", new Object[0]);
            }
        }
    }

    private void d() {
        h hVar = this.f75n;
        if (hVar != null) {
            hVar.e().edit().putBoolean(y, this.x).apply();
        }
    }

    public static boolean a(@NonNull Map<String, String> map) {
        if (map.containsKey(NotificationMessage.NOTIF_KEY_ID) && map.containsKey(NotificationMessage.NOTIF_KEY_MESSAGE_TYPE)) {
            if (map.containsKey("messageDateUtc")) {
                return true;
            }
            g.c(PushMessageManager.i, "Optional key is missing for Delivery Receipt", new Object[0]);
            return true;
        }
        g.e(PushMessageManager.i, "Mandatory keys are missing, Delivery Receipt Event cannot be processed", new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, String> map) {
        String str = map.get(A);
        if (str != null) {
            try {
                if (Integer.parseInt(str) == 1) {
                    e(map);
                }
            } catch (Exception e) {
                g.b(PushMessageManager.i, e, "Unable to parse content available flag: %s", str);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public boolean handleMessage(@NonNull Map<String, String> map) {
        if (!PushMessageManager.isMarketingCloudPush(map)) {
            g.a(PushMessageManager.i, "Message was not sent from the Marketing Cloud.  Message ignored.", new Object[0]);
            return false;
        }
        f(map);
        return true;
    }

    void a(Bundle bundle) {
        com.salesforce.marketingcloud.storage.b bVarC = this.f75n.c();
        if (bundle.getBoolean(PushMessageManager.e, false)) {
            String string = bundle.getString(PushMessageManager.h, "");
            bVarC.a(com.salesforce.marketingcloud.storage.b.e, string);
            bVarC.a(com.salesforce.marketingcloud.storage.b.i, bundle.getString(PushMessageManager.f, ""));
            b(string);
            this.l.d(com.salesforce.marketingcloud.alarms.a.EnumC0062a.f);
            this.f75n.e().edit().putLong(z, System.currentTimeMillis()).apply();
            a(string);
            return;
        }
        bVarC.a(com.salesforce.marketingcloud.storage.b.i);
        this.l.b(com.salesforce.marketingcloud.alarms.a.EnumC0062a.f);
    }

    private void b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(PushMessageManager.h, str);
        c.a(this.j, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_SDK_TOKEN_REFRESHED, bundle);
    }

    @Override // com.salesforce.marketingcloud.alarms.b.InterfaceC0064b
    public void a(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a) {
        String str;
        if (enumC0062a != com.salesforce.marketingcloud.alarms.a.EnumC0062a.f || (str = this.f76o) == null) {
            return;
        }
        MCService.b(this.j, str);
    }

    private void a(String str) {
        synchronized (this.p) {
            for (PushMessageManager.PushTokenRefreshListener pushTokenRefreshListener : this.p) {
                if (pushTokenRefreshListener != null) {
                    try {
                        pushTokenRefreshListener.onTokenRefreshed(str);
                    } catch (Exception e) {
                        g.b(PushMessageManager.i, e, "%s threw an exception while processing the token refresh", pushTokenRefreshListener.getClass().getName());
                    }
                }
            }
        }
    }

    private void a() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(PushMessageManager.g, this.x);
        c.a(this.j, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_CUSTOMER_PUSH_MESSAGING_TOGGLED, bundle);
    }
}
