package com.salesforce.marketingcloud.analytics.stats;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.util.j;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static final String A = "title";
    private static final String B = "0";
    public static final String b = "applicationId";
    public static final String c = "deviceId";
    public static final String d = "attributes";
    public static final String e = "name";
    public static final String f = "receiptDateUtc";
    public static final String g = "messageDateUtc";
    private static final String h = "uuid";
    private static final String i = "eventDateUtc";
    private static final String j = "id";
    private static final String k = "messageId";
    private static final String l = "activityInstanceId";
    private static final String m = "timeInApp";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f43n = "duration";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f44o = "dismissReason";
    private static final String p = "buttonId";
    private static final String q = "outcomeType";
    private static final String r = "triggerId";
    private static final String s = "reasons";
    private static final String t = "information";
    private static final String u = "platform";
    private static final String v = "metaData";
    private static final String w = "correlationIds";
    private static final String x = "propertyBag";
    private static final String y = "requestId";
    private static final String z = "messageType";
    final JSONObject a;

    private d(String str) throws JSONException {
        this.a = new JSONObject(str);
    }

    public static d a(@NonNull String str) throws JSONException {
        return new d(str);
    }

    static d b(String str, String str2, Date date, String str3, String str4) throws JSONException {
        d dVar = new d(str, str2, date);
        dVar.f(str3);
        dVar.b(str4);
        return dVar;
    }

    private void c(String str) throws JSONException {
        this.a.put(p, str);
    }

    private void d(JSONObject jSONObject) throws JSONException {
        this.a.put("propertyBag", jSONObject);
    }

    private void e(String str) throws JSONException {
        this.a.put("id", str);
    }

    private void f(String str) throws JSONException {
        this.a.put(k, str);
    }

    private void g(String str) throws JSONException {
        this.a.put(z, str);
    }

    private void h(String str) throws JSONException {
        this.a.put("name", str);
    }

    private void i(String str) throws JSONException {
        this.a.put(q, str);
    }

    private void j(String str) throws JSONException {
        this.a.put("requestId", str);
    }

    private void k(String str) throws JSONException {
        this.a.put("title", str);
    }

    private void l(String str) throws JSONException {
        this.a.put(r, str);
    }

    static d a(String str, String str2, Date date, String str3, String str4, long j2, int i2, String str5) throws JSONException {
        d dVar = new d(str, str2, date);
        dVar.f(str3);
        dVar.b(str4);
        dVar.a(j2);
        dVar.a(i2);
        dVar.c(str5);
        return dVar;
    }

    private void c(JSONObject jSONObject) throws JSONException {
        this.a.put(v, jSONObject);
    }

    private void d(@Nullable String str) throws JSONException {
        if (str == null) {
            return;
        }
        this.a.put("correlationIds", str);
    }

    private d(String str, String str2, Date date) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        this.a = jSONObject;
        jSONObject.put(b, str);
        jSONObject.put("deviceId", str2);
        jSONObject.put(i, j.a(date));
        jSONObject.put("uuid", UUID.randomUUID());
    }

    static d b(String str, String str2, Date date, String str3, @Nullable String str4, String str5, String str6, @Nullable String str7) throws JSONException {
        d dVar = new d(str, str2, date);
        dVar.f(str3);
        dVar.j(str4);
        dVar.g(str6);
        JSONObject jSONObject = TextUtils.isEmpty(str7) ? new JSONObject() : new JSONObject(str7);
        jSONObject.put("platform", "Android");
        if (jSONObject.isNull("messageDateUtc")) {
            jSONObject.put("messageDateUtc", str5);
        }
        dVar.d(jSONObject);
        return dVar;
    }

    static d a(String str, String str2, Date date, String str3, String str4, String str5, String str6) throws JSONException {
        d dVar = new d(str, str2, date);
        dVar.f(str3);
        dVar.b(str4);
        dVar.l(str5);
        dVar.i(str6);
        return dVar;
    }

    static d a(String str, String str2, Date date, String str3, String str4, List<String> list) throws JSONException {
        d dVar = new d(str, str2, date);
        dVar.f(str3);
        dVar.b(str4);
        dVar.a(list);
        dVar.b();
        return dVar;
    }

    private void b(@Nullable String str) throws JSONException {
        if (str != null) {
            this.a.put(l, str);
        }
    }

    void b(int i2) throws JSONException {
        this.a.put(m, i2);
    }

    private void b(JSONObject jSONObject) throws JSONException {
        this.a.put(t, jSONObject);
    }

    private void b() throws JSONException {
        this.a.put("platform", "Android");
    }

    static d a(String str, String str2, Date date, String str3, String str4) throws JSONException {
        d dVar = new d(str, str2, date);
        dVar.f(str3);
        dVar.b(str4);
        return dVar;
    }

    static d a(String str, String str2, Date date, JSONObject jSONObject) throws JSONException {
        d dVar = new d(str, str2, date);
        dVar.b(jSONObject);
        dVar.b();
        return dVar;
    }

    static d a(String str, String str2, Date date, @Nullable String str3, @Nullable String str4, JSONObject jSONObject) throws JSONException {
        d dVar = new d(str, str2, date);
        dVar.b(jSONObject);
        dVar.b();
        if (str3 != null) {
            dVar.f(str3);
        }
        if (str4 != null) {
            dVar.b(str4);
        }
        return dVar;
    }

    static d a(String str, String str2, Date date, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, @Nullable String str5) throws JSONException {
        d dVar = new d(str, str2, date);
        dVar.e(str4);
        dVar.h(str3);
        dVar.a(jSONObject);
        dVar.c(jSONObject2);
        dVar.d(str5);
        return dVar;
    }

    static d a(String str, String str2, Date date, String str3, String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) throws JSONException {
        d dVar = new d(str, str2, date);
        dVar.f(str3);
        if (str5 != null) {
            dVar.j(str5);
        }
        JSONObject jSONObject = TextUtils.isEmpty(str6) ? new JSONObject() : new JSONObject(str6);
        jSONObject.put("platform", "Android");
        dVar.d(jSONObject);
        if (str7 != null) {
            dVar.k(str7);
        }
        dVar.e(str4);
        return dVar;
    }

    void a(long j2) throws JSONException {
        this.a.put("duration", j2);
    }

    private void a(int i2) throws JSONException {
        this.a.put(f44o, i2);
    }

    private void a(List<String> list) throws JSONException {
        this.a.put(s, new JSONArray((Collection) list));
    }

    private void a(JSONObject jSONObject) throws JSONException {
        this.a.put("attributes", jSONObject);
    }

    public String a() {
        return this.a.toString();
    }
}
