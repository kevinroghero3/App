package app.notifee.core.model;

import android.os.Bundle;
import ch.qos.logback.core.CoreConstants;
import java.util.concurrent.TimeUnit;
import n.o.t.i.f.e.e.l;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    public Bundle a;
    public int b;
    public TimeUnit c;
    public Boolean d;
    public EnumC0026a e;
    public String f;
    public Long g;

    /* JADX INFO: renamed from: app.notifee.core.model.a$a, reason: collision with other inner class name */
    public enum EnumC0026a {
        SET,
        SET_AND_ALLOW_WHILE_IDLE,
        SET_EXACT,
        SET_EXACT_AND_ALLOW_WHILE_IDLE,
        SET_ALARM_CLOCK
    }

    public a(Bundle bundle) {
        this.b = -1;
        this.c = null;
        this.d = Boolean.FALSE;
        EnumC0026a enumC0026a = EnumC0026a.SET_EXACT;
        this.e = enumC0026a;
        this.f = null;
        this.g = null;
        this.a = bundle;
        if (bundle.containsKey("repeatFrequency")) {
            int iA = l.a(this.a.get("repeatFrequency"));
            this.g = Long.valueOf(l.b(this.a.get("timestamp")));
            if (iA == 0) {
                this.b = 1;
                this.c = TimeUnit.HOURS;
                this.f = "HOURLY";
            } else if (iA == 1) {
                this.b = 1;
                this.c = TimeUnit.DAYS;
                this.f = "DAILY";
            } else if (iA == 2) {
                this.b = 7;
                this.c = TimeUnit.DAYS;
                this.f = "WEEKLY";
            }
        }
        if (!this.a.containsKey("alarmManager")) {
            if (this.a.containsKey("allowWhileIdle")) {
                this.d = Boolean.TRUE;
                this.e = EnumC0026a.SET_EXACT_AND_ALLOW_WHILE_IDLE;
                return;
            }
            return;
        }
        this.d = Boolean.TRUE;
        Bundle bundle2 = this.a.getBundle("alarmManager");
        Object obj = bundle2.get("type");
        int iA2 = obj != null ? l.a(obj) : 2;
        if (bundle2.containsKey("allowWhileIdle") && bundle2.getBoolean("allowWhileIdle")) {
            iA2 = 3;
        }
        if (iA2 == 0) {
            this.e = EnumC0026a.SET;
            return;
        }
        if (iA2 == 1) {
            this.e = EnumC0026a.SET_AND_ALLOW_WHILE_IDLE;
            return;
        }
        if (iA2 == 3) {
            this.e = EnumC0026a.SET_EXACT_AND_ALLOW_WHILE_IDLE;
        } else if (iA2 != 4) {
            this.e = enumC0026a;
        } else {
            this.e = EnumC0026a.SET_ALARM_CLOCK;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0044  */
    public void a() {
        byte b;
        long j;
        if (this.f == null) {
            return;
        }
        long jLongValue = this.g.longValue();
        String str = this.f;
        str.getClass();
        int iHashCode = str.hashCode();
        if (iHashCode != -1738378111) {
            if (iHashCode != 64808441) {
                if (iHashCode == 2136870513 && str.equals("HOURLY")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("DAILY")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("WEEKLY")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            j = CoreConstants.MILLIS_IN_ONE_WEEK;
        } else if (b != 1) {
            j = b != 2 ? 0L : 3600000L;
        } else {
            j = 86400000;
        }
        while (jLongValue < System.currentTimeMillis()) {
            jLongValue += j;
        }
        this.g = Long.valueOf(jLongValue);
    }
}
