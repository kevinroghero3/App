package com.salesforce.marketingcloud.http;

import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.util.j;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'l' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String A;
    private static final long B = 86400000;
    private static final /* synthetic */ b[] C;
    public static final b i = new b("ET_ANALYTICS", 0, "POST", 1, "/device/v1/event/analytic", "application/json", "application/json", "analytics_next_retry_time", 10000);
    public static final b j = new b("PI_ANALYTICS", 1, "POST", 2, "{0}", "application/json", "application/json", "piwama_next_retry_time");
    public static final b k;
    public static final b l;
    public static final b m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f53n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b f54o;
    public static final b p;
    public static final b q;
    public static final b r;
    public static final b s;
    public static final String t = "x-subscriber-token";
    public static final String u = "user-agent";
    public static final String v = "authorization";
    public static final String w = "accept";
    public static final String x = "x-sdk-version";
    public static final String y = "retry-after";
    private static final String z = "Bearer %s";
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final long h;

    /* JADX INFO: loaded from: classes6.dex */
    static class a {
        static final int a = 1;
        static final int b = 2;

        private a() {
        }
    }

    static {
        b bVar = new b("INBOX_MESSAGE", 2, "GET", 1, "/device/v1/{0}/message/?deviceid={1}&wm={2}", "application/json", "application/json", "inbox_next_retry_time");
        k = bVar;
        l = new b("USER_INITIATED_INBOX_MESSAGE", 3, bVar.g, bVar.b, bVar.c, bVar.e, bVar.f, bVar.d, 60000L);
        m = new b("INBOX_STATUS", 4, "PATCH", 1, "/device/v1/{0}/message", "application/json", "application/json", "inbox_status_next_retry_time");
        f53n = new b("GEOFENCE_MESSAGE", 5, "GET", 1, "/device/v1/location/{0}/fence/?latitude={1,number,#.########}&longitude={2,number,#.########}&deviceid={3}", "application/json", "application/json", "geofence_next_retry_time");
        f54o = new b("PROXIMITY_MESSAGES", 6, "GET", 1, "/device/v1/location/{0}/proximity/?latitude={1,number,#.########}&longitude={2,number,#.########}&deviceid={3}", "application/json", "application/json", "proximity_next_retry_time");
        p = new b("REGISTRATION", 7, "POST", 1, "/device/v1/registration", "application/json", "application/json", "registration_next_retry_time", 60000L);
        q = new b("SYNC", 8, "POST", 1, "/device/v1/{0}/sync/{1}", "application/json", "application/json", "sync_next_retry_time");
        r = new b("DEVICE_STATS", 9, "POST", 1, "/devicestatistics/v1/analytic", "application/json", "application/json", "et_device_stats_retry_after");
        s = new b("EVENTS", 10, "POST", 1, "/devicestatistics/v1/event", "application/json", "application/json", "et_events_retry_after");
        C = a();
        A = String.format(j.a, "MarketingCloudSdk/%s (Android %s; %%s; %s/%s) %%s/%%s", MarketingCloudSdk.getSdkVersionName(), Build.VERSION.RELEASE, Build.MANUFACTURER, Build.MODEL);
    }

    private b(String str, int i2, String str2, int i3, String str3, String str4, String str5, String str6) {
        this(str, i2, str2, i3, str3, str4, str5, str6, 0L);
    }

    private static /* synthetic */ b[] a() {
        return new b[]{i, j, k, l, m, f53n, f54o, p, q, r, s};
    }

    public static Object[] b(String str, String str2) {
        return new Object[]{str, str2};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) C.clone();
    }

    long c(SharedPreferences sharedPreferences) {
        return sharedPreferences.getLong(this.d, 0L);
    }

    private b(String str, int i2, String str2, int i3, String str3, String str4, String str5, String str6, long j2) {
        super(str, i2);
        this.g = str2;
        this.b = i3;
        this.c = str3;
        this.e = str4;
        this.f = str5;
        this.d = str6;
        this.h = j2 < 0 ? 0L : j2;
    }

    public static Object[] a(String str, String str2, LatLon latLon) {
        return new Object[]{str, Double.valueOf(latLon.latitude()), Double.valueOf(latLon.longitude()), str2};
    }

    void b(@NonNull SharedPreferences sharedPreferences) {
        if (this.h > 0) {
            sharedPreferences.edit().putLong(this.d + "_device", this.h + System.currentTimeMillis()).apply();
        }
    }

    public static Object[] a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return new Object[]{str, str2, str3};
    }

    public static Object[] a(String str) {
        return new Object[]{str};
    }

    private String b(MarketingCloudConfig marketingCloudConfig) {
        return String.format(j.a, A, Locale.getDefault(), marketingCloudConfig.appPackageName(), marketingCloudConfig.appVersionName());
    }

    public static void a(@Nullable Map<String, List<String>> map, @NonNull com.salesforce.marketingcloud.storage.b bVar) {
        List<String> listA;
        String str;
        if (map == null || map.isEmpty() || (listA = a(map, t)) == null || listA.isEmpty() || (str = listA.get(0)) == null || str.isEmpty()) {
            return;
        }
        bVar.a(com.salesforce.marketingcloud.storage.b.j, str);
    }

    public static boolean a(@NonNull com.salesforce.marketingcloud.storage.h hVar) {
        return hVar.c().b(com.salesforce.marketingcloud.storage.b.j, null) != null;
    }

    private static List<String> a(@NonNull Map<String, List<String>> map, String str) {
        for (String str2 : map.keySet()) {
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return map.get(str2);
            }
        }
        return null;
    }

    void a(@NonNull SharedPreferences sharedPreferences, @NonNull f fVar) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (fVar.p() && this.h > 0) {
            editorEdit.putLong(this.d + "_device", fVar.l() + this.h);
        }
        List<String> listA = a(fVar.m(), y);
        if (listA != null && !listA.isEmpty()) {
            try {
                long j2 = Long.parseLong(listA.get(0)) * 1000;
                String str = this.d;
                long jL = fVar.l();
                if (j2 > 86400000) {
                    j2 = 86400000;
                }
                editorEdit.putLong(str, jL + j2);
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.a("MCRequest", e, "Unable to parse Retry-After value.", new Object[0]);
            }
        }
        editorEdit.apply();
    }

    long a(SharedPreferences sharedPreferences) {
        if (this.h <= 0) {
            return 0L;
        }
        return sharedPreferences.getLong(this.d + "_device", 0L);
    }

    private String a(String str, String str2) throws MalformedURLException {
        if (str.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str = str.substring(0, str.length() - 1);
        }
        return new URL(String.format(j.a, "%s%s", str, str2)).toString();
    }

    public c a(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull com.salesforce.marketingcloud.storage.b bVar, @NonNull Object[] objArr) {
        return a(marketingCloudConfig, bVar, a(marketingCloudConfig), new MessageFormat(this.c, j.a).format(objArr), null, null);
    }

    public c a(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull com.salesforce.marketingcloud.storage.b bVar, String str) {
        return a(marketingCloudConfig, bVar, a(marketingCloudConfig), this.c, str, null);
    }

    public c a(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull com.salesforce.marketingcloud.storage.b bVar, String str, @Nullable String str2) {
        String strA = a(marketingCloudConfig);
        if (str2 == null) {
            str2 = this.c;
        }
        return a(marketingCloudConfig, bVar, strA, str2, str, null);
    }

    public c a(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull com.salesforce.marketingcloud.storage.b bVar, Object[] objArr, String str) {
        return a(marketingCloudConfig, bVar, a(marketingCloudConfig), new MessageFormat(this.c, j.a).format(objArr), str, null);
    }

    public c a(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull com.salesforce.marketingcloud.storage.b bVar, Object[] objArr, String str, Map<String, String> map) {
        return a(marketingCloudConfig, bVar, a(marketingCloudConfig), new MessageFormat(this.c, j.a).format(objArr), str, map);
    }

    private String a(@NonNull MarketingCloudConfig marketingCloudConfig) {
        return this.b == 1 ? marketingCloudConfig.marketingCloudServerUrl() : marketingCloudConfig.predictiveIntelligenceServerUrl();
    }

    private c a(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull com.salesforce.marketingcloud.storage.b bVar, @NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable Map<String, String> map) {
        try {
            String strA = a(str, str2);
            com.salesforce.marketingcloud.g.d("MCRequest", "Executing %s request ...", strA);
            c.a aVarD = c.b().b(this.g).a(this).a(this.e).d(strA);
            if (str3 != null) {
                aVarD.c(str3);
            }
            aVarD.a(u, b(marketingCloudConfig));
            aVarD.a("authorization", String.format(j.a, z, marketingCloudConfig.accessToken()));
            aVarD.a(w, this.f);
            aVarD.a(x, MarketingCloudSdk.getSdkVersionName());
            String strB = bVar.b(com.salesforce.marketingcloud.storage.b.j, null);
            if (strB != null) {
                aVarD.a(t, strB);
            }
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    aVarD.a(entry.getKey(), entry.getValue());
                }
            }
            return aVarD.a();
        } catch (Exception e) {
            com.salesforce.marketingcloud.g.b("MCRequest", e, "Failed to execute request.", new Object[0]);
            return null;
        }
    }
}
