package com.salesforce.marketingcloud.analytics;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final String A = "objectIds";
    public static final String B = "platform";
    public static final List<Integer> C = Collections.unmodifiableList(Arrays.asList(3, 14));
    public static final int D = 0;
    public static final int E = 1;
    private static final String F = "~!AnalyticItem";
    public static final int a = 2;
    public static final int b = 3;
    public static final int c = 4;
    public static final int d = 5;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 10;
    public static final int i = 11;
    public static final int j = 12;
    public static final int k = 13;
    public static final int l = 14;
    public static final int m = 15;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f31n = 16;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f32o = 17;
    public static final int p = 88888;
    public static final int q = 888;
    public static final int r = 8888;
    public static final String s = "uuid";
    public static final String t = "requestId";
    public static final String u = "propertyBag";
    public static final String v = "etAppId";
    public static final String w = "deviceId";
    public static final String x = "eventDate";
    public static final String y = "value";
    public static final String z = "analyticTypes";
    private final Date G;
    private final int H;
    private final int I;
    private final List<String> J;
    private final String K;
    private String L;
    private int M;
    private int N;
    private boolean O;
    private String P;
    private String Q;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0065b {
    }

    private b(Date date, int i2, int i3, List<String> list, String str, boolean z2, String str2) {
        ArrayList arrayList = new ArrayList();
        this.J = arrayList;
        this.G = (Date) com.salesforce.marketingcloud.util.g.a(date, "The Date is null.");
        com.salesforce.marketingcloud.util.g.a(i2 == 0 || i2 == 1, "The Product Type must be one of AnalyticProductType");
        this.H = i2;
        com.salesforce.marketingcloud.util.g.a(i3 > 0, "AnalyticType must be a valid int > 0.");
        this.I = i3;
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
        }
        this.K = str;
        this.Q = a(str2);
        this.O = z2;
    }

    public static b a(@NonNull Date date, int i2, int i3) {
        return a(date, i2, i3, Collections.emptyList(), null, false);
    }

    public Date b() {
        return this.G;
    }

    public void c(String str) {
        this.P = str;
    }

    public int d() {
        return this.M;
    }

    public String e() {
        return this.P;
    }

    public String f() {
        return this.L;
    }

    public int g() {
        return this.N;
    }

    public boolean h() {
        return this.O;
    }

    public List<String> i() {
        List<String> list;
        synchronized (this.J) {
            list = this.J;
        }
        return list;
    }

    public int j() {
        return this.H;
    }

    public String k() {
        return this.K;
    }

    public static b a(@NonNull Date date, int i2, int i3, List<String> list, boolean z2) {
        return a(date, i2, i3, list, null, z2);
    }

    public void b(int i2) {
        this.N = i2;
    }

    public String c() {
        return this.Q;
    }

    public void d(@Nullable @Size(min = 1) String str) {
        this.L = str;
    }

    public static b a(@NonNull Date date, int i2, int i3, List<String> list, String str, boolean z2) {
        return new b(date, i2, i3, list, str, z2, null);
    }

    public void b(String str) {
        this.Q = str;
    }

    public static b a(@NonNull Date date, int i2, int i3, @NonNull NotificationMessage notificationMessage, boolean z2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(notificationMessage.id());
        Region region = notificationMessage.region();
        if (region != null) {
            arrayList.add(region.id());
        }
        return new b(date, i2, i3, arrayList, notificationMessage.requestId(), z2, notificationMessage.propertyBag());
    }

    private String a(@Nullable String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", UUID.randomUUID());
            String str2 = this.K;
            if (str2 != null) {
                jSONObject.put("requestId", str2);
            }
            if (TextUtils.isEmpty(str)) {
                return jSONObject.toString();
            }
            jSONObject.put(u, new JSONObject(str));
            return jSONObject.toString();
        } catch (JSONException e2) {
            com.salesforce.marketingcloud.g.e(F, e2, "unable to build et json payload", new Object[0]);
        }
    }

    public void a(int i2) {
        this.M = i2;
    }

    public int a() {
        return this.I;
    }

    public void a(boolean z2) {
        this.O = z2;
    }
}
