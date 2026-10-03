package com.salesforce.marketingcloud.analytics.piwama;

import android.text.TextUtils;
import com.salesforce.marketingcloud.internal.o;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class h implements c {
    private final Date a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public h(@NotNull String url, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull Date timestamp) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.a = timestamp;
        this.b = a(url, "url", true);
        this.c = str != null ? a(str, "title", false) : null;
        this.d = str2 != null ? a(str2, "item", false) : null;
        this.e = str3 != null ? a(str3, "search", false) : null;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public String a() {
        return "";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public int b() {
        return com.salesforce.marketingcloud.analytics.b.r;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_endpoint", d());
        jSONObject.put("timestamp", o.a(e()));
        jSONObject.put("url", this.b);
        if (!TextUtils.isEmpty(this.c)) {
            jSONObject.put("title", this.c);
        }
        if (!TextUtils.isEmpty(this.d)) {
            jSONObject.put("item", this.d);
        }
        if (!TextUtils.isEmpty(this.e)) {
            jSONObject.put("search", this.e);
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public String d() {
        return "track_view";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public Date e() {
        return this.a;
    }

    public final String f() {
        return this.d;
    }

    public final String g() {
        return this.e;
    }

    public final String h() {
        return this.c;
    }

    public final String i() {
        return this.b;
    }
}
