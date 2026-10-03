package com.salesforce.marketingcloud.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MCReceiver;
import com.salesforce.marketingcloud.f;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.storage.h;
import com.salesforce.marketingcloud.util.j;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends f implements com.salesforce.marketingcloud.behaviors.b {
    public static final String j = "com.salesforce.marketingcloud.ACTION_ALARM_WAKE_EVENT";
    public static final String k = "com.salesforce.marketingcloud.WAKE_FOR_ALARM";
    static final String l = "pending_alarms";
    static final String m = g.a("AlarmScheduler");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f30n = 0;
    private final Map<com.salesforce.marketingcloud.alarms.a.EnumC0062a, InterfaceC0064b> d = new HashMap();
    private final com.salesforce.marketingcloud.behaviors.c e;
    BroadcastReceiver f;
    private Context g;
    private h h;
    private SharedPreferences i;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.salesforce.marketingcloud.behaviors.a.values().length];
            a = iArr;
            try {
                iArr[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_PACKAGE_REPLACED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_BOOT_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes3.dex */
    public interface InterfaceC0064b {
        void a(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a);
    }

    /* JADX INFO: loaded from: classes3.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                g.d(b.m, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                g.d(b.m, "Received null action", new Object[0]);
                return;
            }
            Bundle extras = intent.getExtras();
            if (extras == null) {
                g.d(b.m, "Intent had no extras", new Object[0]);
                return;
            }
            if (!action.equals(b.j)) {
                g.a(b.m, "Received unknown action: %s", action);
                return;
            }
            String string = extras.getString("com.salesforce.marketingcloud.WAKE_FOR_ALARM", null);
            if (string != null) {
                g.d(b.m, "ACTION_ALARM_WAKE_EVENT had extra: %s", string);
                try {
                    b.this.a(com.salesforce.marketingcloud.alarms.a.EnumC0062a.valueOf(string));
                } catch (IllegalArgumentException unused) {
                    g.e(b.m, "Woke for an unknown alarm: %s", string);
                }
            }
        }
    }

    public b(@NonNull Context context, @NonNull h hVar, @NonNull com.salesforce.marketingcloud.behaviors.c cVar) {
        this.g = context;
        this.h = hVar;
        this.e = (com.salesforce.marketingcloud.behaviors.c) com.salesforce.marketingcloud.util.g.a(cVar, "BehaviorManager is null");
        this.i = hVar.e();
    }

    private static PendingIntent a(@NonNull Context context, @Nullable String str, @NonNull Integer num) {
        return PendingIntent.getBroadcast(context, num.intValue(), MCReceiver.a(context, str), j.a(134217728));
    }

    public void b(@NonNull @Size(min = 1) com.salesforce.marketingcloud.alarms.a.EnumC0062a... enumC0062aArr) {
        for (com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a : enumC0062aArr) {
            a(enumC0062a, false);
        }
    }

    public boolean c(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a) {
        return enumC0062a.b().g() && a(enumC0062a, true);
    }

    @Override // com.salesforce.marketingcloud.d
    public final String componentName() {
        return "AlarmScheduler";
    }

    @Override // com.salesforce.marketingcloud.d
    public final JSONObject componentState() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            for (com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a : com.salesforce.marketingcloud.alarms.a.EnumC0062a.values()) {
                if (a(enumC0062a, jCurrentTimeMillis)) {
                    jSONObject2.put(enumC0062a.name(), j.a(new Date(this.i.getLong(enumC0062a.b().a(), 0L) + this.i.getLong(enumC0062a.b().c(), 0L))));
                }
            }
            jSONObject.put(l, jSONObject2);
        } catch (JSONException e) {
            g.b(m, e, "Failed to generate Component State JSONObject.", new Object[0]);
        }
        return jSONObject;
    }

    public void d(@NonNull @Size(min = 1) com.salesforce.marketingcloud.alarms.a.EnumC0062a... enumC0062aArr) {
        for (com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a : enumC0062aArr) {
            c(enumC0062a);
            a(enumC0062a);
            try {
                ((AlarmManager) this.g.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(a(this.g, enumC0062a.name(), Integer.valueOf(enumC0062a.b().b())));
                g.a(m, "Reset %s alarm.", enumC0062a.name());
            } catch (Exception e) {
                g.e(m, e, "Could not cancel %s alarm.", enumC0062a.name());
            }
        }
    }

    public void e(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a... enumC0062aArr) {
        synchronized (this.d) {
            for (com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a : enumC0062aArr) {
                this.d.remove(enumC0062a);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.behaviors.b
    public final void onBehavior(@NonNull com.salesforce.marketingcloud.behaviors.a aVar, @NonNull Bundle bundle) {
        int i = a.a[aVar.ordinal()];
        if (i == 1 || i == 2) {
            a(bundle.getLong("timestamp"));
        }
    }

    @Override // com.salesforce.marketingcloud.f, com.salesforce.marketingcloud.d
    public final void tearDown(boolean z) {
        if (z) {
            d(com.salesforce.marketingcloud.alarms.a.EnumC0062a.values());
        }
        Context context = this.g;
        if (context != null) {
            context.unregisterReceiver(this.f);
        }
        this.e.a(this);
    }

    public void c(@NonNull @Size(min = 1) com.salesforce.marketingcloud.alarms.a.EnumC0062a... enumC0062aArr) {
        for (com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a : enumC0062aArr) {
            g.a(m, "Resetting %s Alarm Interval.", enumC0062a.name());
            this.i.edit().putLong(enumC0062a.b().c(), 0L).apply();
        }
    }

    public void a(@NonNull InterfaceC0064b interfaceC0064b, @NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a... enumC0062aArr) {
        synchronized (this.d) {
            for (com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a : enumC0062aArr) {
                this.d.put(enumC0062a, interfaceC0064b);
            }
        }
    }

    final long b(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a) {
        long jE;
        long j2 = this.i.getLong(enumC0062a.b().c(), 0L);
        if (j2 == 0) {
            jE = enumC0062a.b().d();
        } else {
            jE = (long) (j2 * enumC0062a.b().e());
        }
        if (jE <= enumC0062a.b().f()) {
            return jE;
        }
        long jF = enumC0062a.b().f();
        g.a(m, "%s MAX INTERVAL exceeded. Setting interval to %s milliseconds.", enumC0062a.name(), Long.valueOf(jF));
        return jF;
    }

    @Override // com.salesforce.marketingcloud.f
    public final void a(@NonNull InitializationStatus.a aVar) {
        this.e.a(this, EnumSet.of(com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_BOOT_COMPLETE, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_PACKAGE_REPLACED));
        this.f = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(j);
        ContextCompat.registerReceiver(this.g, this.f, intentFilter, 4);
    }

    private boolean a(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a, boolean z) {
        if (!enumC0062a.a(this.h)) {
            g.a(m, "shouldCreateAlarm() for %s Alarm was FALSE.  Aborting alarm creation.", enumC0062a.name());
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jB = b(enumC0062a);
        if (a(enumC0062a, jCurrentTimeMillis)) {
            if (z) {
                return false;
            }
            g.a(m, "%s Send Pending ... will send at %s", enumC0062a.name(), j.a(new Date(this.h.e().getLong(enumC0062a.b().a(), 0L) + jB)));
            return false;
        }
        g.a(m, "No pending %s Alarm. Creating one ...", enumC0062a.name());
        a(enumC0062a, jCurrentTimeMillis, jB);
        a(this.g, enumC0062a, z ? 1000L : jB, jCurrentTimeMillis);
        return true;
    }

    public boolean a(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a, @IntRange(from = 0) long j2) {
        return this.i.getLong(enumC0062a.b().a(), 0L) > j2 - this.i.getLong(enumC0062a.b().c(), 0L);
    }

    private void a(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a, @IntRange(from = 0) long j2, @IntRange(from = 0, to = 86400000) long j3) {
        g.a(m, "Setting the %s Alarm Flag ...", enumC0062a.name());
        this.i.edit().putLong(enumC0062a.b().a(), j2).putLong(enumC0062a.b().c(), j3).apply();
    }

    void a(@NonNull @Size(min = 1) com.salesforce.marketingcloud.alarms.a.EnumC0062a... enumC0062aArr) {
        for (com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a : enumC0062aArr) {
            g.a(m, "Resetting %s Alarm Active Flag to FALSE", enumC0062a.name());
            this.i.edit().putLong(enumC0062a.b().a(), 0L).apply();
        }
    }

    void a(@NonNull Context context, @NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a, @IntRange(from = 0, to = 86400000) long j2, @IntRange(from = 0) long j3) {
        PendingIntent pendingIntentA = a(context, enumC0062a.name(), Integer.valueOf(enumC0062a.b().b()));
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        long j4 = j3 + j2;
        String strA = j.a(new Date(j4));
        try {
            if (Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms()) {
                alarmManager.setExact(0, j4, pendingIntentA);
            } else {
                alarmManager.set(0, j4, pendingIntentA);
            }
            g.d(m, "%s Alarm scheduled to wake at %s.", enumC0062a.name(), strA);
        } catch (Exception e) {
            g.e(m, e, "Failed to schedule alarm %s for %s", enumC0062a.name(), strA);
        }
    }

    private void a(long j2) {
        for (com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a : com.salesforce.marketingcloud.alarms.a.EnumC0062a.values()) {
            com.salesforce.marketingcloud.alarms.a aVarB = enumC0062a.b();
            long j3 = this.i.getLong(aVarB.a(), 0L);
            if (j3 > 0) {
                if (a(enumC0062a, j2)) {
                    a(this.g, enumC0062a, this.i.getLong(aVarB.c(), aVarB.d()), j3);
                } else {
                    a(enumC0062a);
                }
            }
        }
    }

    void a(com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a) {
        a(enumC0062a);
        InterfaceC0064b interfaceC0064b = this.d.get(enumC0062a);
        if (interfaceC0064b != null) {
            interfaceC0064b.a(enumC0062a);
        }
    }
}
