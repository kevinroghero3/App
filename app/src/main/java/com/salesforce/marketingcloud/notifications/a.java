package com.salesforce.marketingcloud.notifications;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.google.maps.android.BuildConfig;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.analytics.j;
import com.salesforce.marketingcloud.e;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.push.f;
import com.salesforce.marketingcloud.storage.h;
import com.transistorsoft.locationmanager.config.TSNotification;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends NotificationManager implements e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f77n = "com.salesforce.marketingcloud.notifications.OPENED";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f78o = "com.salesforce.marketingcloud.notifications.open.RECEIVED";
    public static final String p = "com.salesforce.marketingcloud.notifications.MESSAGE";
    public static final int q = -1;
    static final String r = "com.salesforce.marketingcloud.notifications.EXTRA_OPEN_INTENT";
    static final String s = "com.salesforce.marketingcloud.notifications.EXTRA_AUTO_CANCEL";
    static final String t = "com.marketingcloud.salesforce.notifications.TAG";
    static final String u = "com.marketingcloud.salesforce.notifications.ENABLED";
    static final String v = "notification_id_key";
    final com.salesforce.marketingcloud.notifications.b f;
    final Context g;
    private final h h;
    private final j j;
    private NotificationManager.ShouldShowNotificationListener k;
    private BroadcastReceiver l;
    private boolean m = true;
    private final Set<NotificationManager.NotificationMessageDisplayedListener> i = new ArraySet();

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.notifications.a$a, reason: collision with other inner class name */
    class C0091a extends Thread {
        final /* synthetic */ NotificationMessage b;
        final /* synthetic */ b c;

        C0091a(NotificationMessage notificationMessage, b bVar) {
            this.b = notificationMessage;
            this.c = bVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int iNotificationId;
            try {
                a aVar = a.this;
                NotificationCompat.Builder builder = aVar.f.setupNotificationBuilder(aVar.g, this.b);
                android.app.NotificationManager notificationManager = (android.app.NotificationManager) a.this.g.getSystemService(TSNotification.NAME);
                if (notificationManager != null) {
                    notificationManager.notify(a.t, this.b.notificationId(), builder.build());
                    a.this.b(this.b);
                    iNotificationId = this.b.notificationId();
                } else {
                    iNotificationId = -1;
                }
            } catch (f e) {
                a.this.j.a(e, this.b.id);
            } catch (Exception e2) {
                g.b(NotificationManager.d, e2, "Unable to show notification due to an exception thrown by Android.", new Object[0]);
            }
            b bVar = this.c;
            if (bVar != null) {
                bVar.a(iNotificationId);
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface b {
        void a(int i);
    }

    a(Context context, h hVar, com.salesforce.marketingcloud.notifications.b bVar, j jVar) {
        this.g = context;
        this.h = hVar;
        this.f = bVar;
        this.j = (j) com.salesforce.marketingcloud.util.g.a(jVar, "MessageAnalyticEventListener is null.");
    }

    public static a a(@NonNull Context context, @NonNull h hVar, @NonNull NotificationCustomizationOptions notificationCustomizationOptions, @NonNull j jVar) {
        return new a(context, hVar, new com.salesforce.marketingcloud.notifications.b(notificationCustomizationOptions.smallIconResId, notificationCustomizationOptions.launchIntentProvider, notificationCustomizationOptions.notificationBuilder, notificationCustomizationOptions.channelIdProvider), jVar);
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager
    public final boolean areNotificationsEnabled() {
        boolean z;
        synchronized (this) {
            z = this.m;
        }
        return z;
    }

    void b(NotificationMessage notificationMessage) {
        synchronized (this.i) {
            if (!this.i.isEmpty()) {
                for (NotificationManager.NotificationMessageDisplayedListener notificationMessageDisplayedListener : this.i) {
                    if (notificationMessageDisplayedListener != null) {
                        try {
                            notificationMessageDisplayedListener.onNotificationMessageDisplayed(notificationMessage);
                        } catch (Exception e) {
                            g.b(NotificationManager.d, e, "%s threw an exception while processing notification message (%s)", notificationMessageDisplayedListener.getClass().getName(), notificationMessage.id());
                        }
                    }
                }
            }
        }
        try {
            this.j.b(notificationMessage);
        } catch (Exception e2) {
            g.b(NotificationManager.d, e2, "Failed to log analytics for message displayed.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.d
    public final String componentName() {
        return "NotificationManager";
    }

    @Override // com.salesforce.marketingcloud.d
    public final JSONObject componentState() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("notificationsEnabled", areNotificationsEnabled());
            jSONObject.put("displayMetrics", this.g.getResources().getDisplayMetrics().toString());
            jSONObject.put("Dpi Density", this.g.getResources().getDisplayMetrics().densityDpi);
            NotificationManager.ShouldShowNotificationListener shouldShowNotificationListener = this.k;
            if (shouldShowNotificationListener != null) {
                jSONObject.put("shouldShowNotificationListener", shouldShowNotificationListener.getClass().getName());
            }
        } catch (JSONException e) {
            g.b(NotificationManager.d, e, "Unable to create component state for %s", componentName());
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.e
    public void controlChannelInit(int i) {
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager
    public final void disableNotifications() {
        synchronized (this) {
            if (this.m) {
                this.m = false;
                a();
            }
        }
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager
    public final void enableNotifications() {
        synchronized (this) {
            if (this.m) {
                return;
            }
            this.m = true;
            a();
        }
    }

    @Override // com.salesforce.marketingcloud.e
    public final void init(@NonNull InitializationStatus.a aVar, int i) {
        this.m = this.h.e().getBoolean(u, true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(f77n);
        c cVar = new c();
        this.l = cVar;
        ContextCompat.registerReceiver(this.g, cVar, intentFilter, 4);
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager
    public final void registerNotificationMessageDisplayedListener(@NonNull NotificationManager.NotificationMessageDisplayedListener notificationMessageDisplayedListener) {
        if (notificationMessageDisplayedListener == null) {
            return;
        }
        synchronized (this.i) {
            this.i.add(notificationMessageDisplayedListener);
        }
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager
    public void setShouldShowNotificationListener(@Nullable NotificationManager.ShouldShowNotificationListener shouldShowNotificationListener) {
        this.k = shouldShowNotificationListener;
    }

    @Override // com.salesforce.marketingcloud.d
    public final void tearDown(boolean z) {
        if (z) {
            a(this.g);
        }
        Context context = this.g;
        if (context != null) {
            context.unregisterReceiver(this.l);
        }
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager
    public final void unregisterNotificationMessageDisplayedListener(@NonNull NotificationManager.NotificationMessageDisplayedListener notificationMessageDisplayedListener) {
        synchronized (this.i) {
            this.i.remove(notificationMessageDisplayedListener);
        }
    }

    private void a(@NonNull Context context) {
        if (this.h == null) {
            return;
        }
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        int i = this.h.e().getInt(v, -1);
        for (int i2 = 0; i >= 0 && i2 < 100; i2++) {
            notificationManagerCompatFrom.cancel(t, i);
            i--;
        }
    }

    private void a() {
        h hVar = this.h;
        if (hVar != null) {
            hVar.e().edit().putBoolean(u, this.m).apply();
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        private void a(Context context, Intent intent) {
            try {
                NotificationMessage notificationMessageExtractMessage = NotificationManager.extractMessage(intent);
                try {
                    a.this.a(context, notificationMessageExtractMessage, (PendingIntent) a(intent, a.r), a(intent), intent.getBooleanExtra(a.s, true));
                } catch (Exception e) {
                    g.b(NotificationManager.d, e, "Failed to handle notification opened for message: %s", notificationMessageExtractMessage.id());
                }
            } catch (Exception e2) {
                g.b(NotificationManager.d, e2, "Failed to extract notification message from intent", new Object[0]);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                g.a(NotificationManager.d, "Received null intent", new Object[0]);
                return;
            }
            context.sendBroadcast(new Intent(a.f78o).setPackage(context.getPackageName()));
            String action = intent.getAction();
            if (action == null) {
                g.a(NotificationManager.d, "Received null action", new Object[0]);
            } else if (a.f77n.equals(action)) {
                a(context, intent);
            } else {
                g.a(NotificationManager.d, "Received unknown action: %s", action);
            }
        }

        private <T> T a(Intent intent, String str) {
            try {
                return (T) intent.getParcelableExtra(str);
            } catch (Exception e) {
                g.b(NotificationManager.d, e, "Failed to extract parcelable extra '%s' from intent", str);
                return null;
            }
        }

        private Bundle a(Intent intent) {
            try {
                return intent.getExtras();
            } catch (Exception e) {
                g.b(NotificationManager.d, e, "Failed to extract extras from intent", new Object[0]);
                return null;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00bf A[Catch: all -> 0x00d8, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0008, B:7:0x0019, B:10:0x001e, B:12:0x0029, B:14:0x0034, B:17:0x0039, B:20:0x0041, B:23:0x0046, B:26:0x004b, B:31:0x006b, B:37:0x0084, B:39:0x009f, B:34:0x0072, B:40:0x00a3, B:42:0x00bf, B:43:0x00c5, B:29:0x0051), top: B:51:0x0001, inners: #0, #2 }] */
    public void a(@NonNull NotificationMessage notificationMessage, @Nullable b bVar) {
        boolean zShouldShowNotification;
        synchronized (this) {
            if (!areNotificationsEnabled()) {
                g.a(NotificationManager.d, "Notifications are not enabled.  Message %s will not be displayed", notificationMessage.id());
                if (bVar != null) {
                    bVar.a(-1);
                }
                return;
            }
            if (TextUtils.getTrimmedLength(notificationMessage.alert()) == 0) {
                g.a(NotificationManager.d, "Notifications with no alert message are not shown.", new Object[0]);
                if (bVar != null) {
                    bVar.a(-1);
                }
                return;
            }
            if (notificationMessage.notificationId() >= 0) {
                if (bVar != null) {
                    bVar.a(-1);
                }
                return;
            }
            NotificationManager.ShouldShowNotificationListener shouldShowNotificationListener = this.k;
            if (shouldShowNotificationListener != null) {
                try {
                    zShouldShowNotification = shouldShowNotificationListener.shouldShowNotification(notificationMessage);
                } catch (Exception e) {
                    g.b(NotificationManager.d, e, "%s threw an exception while processing shouldShowNotification() for messageId: %s", this.k.getClass().getName(), notificationMessage.id());
                    zShouldShowNotification = true;
                }
                try {
                    this.j.a(notificationMessage, zShouldShowNotification);
                } catch (Exception e2) {
                    g.b(NotificationManager.d, e2, "Failed to log Should Show Notification analytic for messageId: %s", notificationMessage.id());
                }
                if (zShouldShowNotification) {
                    SharedPreferences sharedPreferencesE = this.h.e();
                    com.salesforce.marketingcloud.internal.j.a(notificationMessage, sharedPreferencesE.getInt(v, 0));
                    sharedPreferencesE.edit().putInt(v, notificationMessage.notificationId() < Integer.MAX_VALUE ? notificationMessage.notificationId() + 1 : 0).apply();
                    new C0091a(notificationMessage, bVar).start();
                } else {
                    g.a(NotificationManager.d, "%s responded false to shouldShowNotification() for messageId: %s", this.k.getClass().getName(), notificationMessage.id());
                    if (bVar != null) {
                        bVar.a(-1);
                    }
                }
            } else {
                SharedPreferences sharedPreferencesE2 = this.h.e();
                com.salesforce.marketingcloud.internal.j.a(notificationMessage, sharedPreferencesE2.getInt(v, 0));
                sharedPreferencesE2.edit().putInt(v, notificationMessage.notificationId() < Integer.MAX_VALUE ? notificationMessage.notificationId() + 1 : 0).apply();
                new C0091a(notificationMessage, bVar).start();
            }
        }
    }

    NotificationCompat.Builder a(NotificationMessage notificationMessage) {
        try {
            return this.f.setupNotificationBuilder(this.g, notificationMessage);
        } catch (f e) {
            this.j.a(e, notificationMessage.id);
            return null;
        }
    }

    void a(Context context, NotificationMessage notificationMessage, PendingIntent pendingIntent, Bundle bundle, boolean z) {
        try {
            if (notificationMessage != null) {
                this.j.a(notificationMessage);
                String str = NotificationManager.d;
                g.a(str, "Notification open Event Logged for id : (%s)", notificationMessage.id);
                if (bundle != null) {
                    int i = bundle.getInt(com.salesforce.marketingcloud.push.b.f, -1);
                    String string = bundle.getString(com.salesforce.marketingcloud.push.b.g, null);
                    String string2 = bundle.getString(com.salesforce.marketingcloud.push.b.h, null);
                    if (i >= 0 && string != null) {
                        this.j.a(notificationMessage, i, string, string2);
                        g.a(str, "Notification click Event Logged for id : (%s)", notificationMessage.id);
                    }
                }
            } else {
                g.b(NotificationManager.d, "Cannot process notification opened: message is null", new Object[0]);
            }
            if (pendingIntent != null) {
                pendingIntent.send();
            }
            if (z && notificationMessage != null) {
                NotificationManager.cancelNotificationMessage(context, notificationMessage);
            }
            if (Build.VERSION.SDK_INT <= 30) {
                context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(p, notificationMessage);
            com.salesforce.marketingcloud.behaviors.c.a(context, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_SDK_NOTIFICATION_OPENED, bundle2);
        } catch (PendingIntent.CanceledException e) {
            g.b(NotificationManager.d, e, "Failed to send notification's open action PendingIntent.", new Object[0]);
        } catch (Exception e2) {
            g.b(NotificationManager.d, e2, "Failed to handle notification opened for message: %s", notificationMessage != null ? notificationMessage.id : BuildConfig.TRAVIS);
        }
    }
}
