package com.salesforce.marketingcloud.http;

import android.os.Bundle;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.salesforce.marketingcloud.internal.o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class c implements g {
    public static final b j = new b(null);
    private static final String k = com.salesforce.marketingcloud.g.a("Request");
    public static final String l = "GET";
    public static final String m = "POST";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f55n = "PATCH";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f56o = -100;
    private static final int p = 30000;
    private final String b;
    private final String c;
    private final int d;
    private final String e;
    private final String f;
    private final List<String> g;
    private final com.salesforce.marketingcloud.http.b h;
    private String i;

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
        private String a;
        private String b;
        private String d;
        private String e;
        private com.salesforce.marketingcloud.http.b f;
        private List<String> h;
        private int c = 30000;
        private Map<String, String> g = new LinkedHashMap();

        public final a a(@NotNull String contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            this.e = contentType;
            return this;
        }

        public final a b(@NotNull String method) {
            Intrinsics.checkNotNullParameter(method, "method");
            this.a = method;
            return this;
        }

        public final a c(@NotNull String requestBody) {
            Intrinsics.checkNotNullParameter(requestBody, "requestBody");
            this.d = requestBody;
            return this;
        }

        public final a d(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.b = url;
            return this;
        }

        public final a a(@NotNull com.salesforce.marketingcloud.http.b requestId) {
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            this.f = requestId;
            return this;
        }

        public final a a(int i) {
            this.c = i;
            return this;
        }

        public final void a(@NotNull List<String> headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.h = headers;
        }

        public final a a(@NotNull String key, @NotNull String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.g.put(key, StringsKt__StringsKt.trim((CharSequence) value).toString());
            return this;
        }

        public final c a() {
            List<String> list;
            List<String> listEmptyList = this.h;
            if (listEmptyList != null) {
                list = listEmptyList;
            } else if (!this.g.isEmpty()) {
                Map<String, String> map = this.g;
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList, CollectionsKt___CollectionsKt.plus((Collection<? extends String>) CollectionsKt__CollectionsJVMKt.listOf(key), entry.getValue()));
                }
                list = arrayList;
            } else {
                listEmptyList = CollectionsKt__CollectionsKt.emptyList();
                list = listEmptyList;
            }
            String str = this.d;
            if (str == null) {
                this.e = "";
            }
            String str2 = this.a;
            if (str2 != null) {
                String str3 = this.b;
                if (str3 != null) {
                    int i = this.c;
                    String str4 = this.e;
                    if (str4 != null) {
                        com.salesforce.marketingcloud.http.b bVar = this.f;
                        if (bVar != null) {
                            return new c(str2, str, i, str4, str3, list, bVar);
                        }
                        throw new IllegalStateException("Required value was null.");
                    }
                    throw new IllegalStateException("Required value was null.");
                }
                throw new IllegalStateException("Required value was null.");
            }
            throw new IllegalStateException("Required value was null.");
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final a a() {
            return new a();
        }

        public final String b() {
            return c.k;
        }

        private b() {
        }

        @JvmStatic
        public final c a(@NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(data, "data");
            a aVarA = c.j.a();
            String string = data.getString("method");
            if (string != null) {
                Intrinsics.checkNotNull(string);
                aVarA.b(string);
            }
            String string2 = data.getString("requestBody");
            if (string2 != null) {
                Intrinsics.checkNotNull(string2);
                aVarA.c(string2);
            }
            aVarA.a(data.getInt("connectionTimeout"));
            String string3 = data.getString("contentType");
            if (string3 != null) {
                Intrinsics.checkNotNull(string3);
                aVarA.a(string3);
            }
            String string4 = data.getString("url");
            if (string4 != null) {
                Intrinsics.checkNotNull(string4);
                aVarA.d(string4);
            }
            ArrayList<String> stringArrayList = data.getStringArrayList("headers");
            if (stringArrayList != null) {
                Intrinsics.checkNotNull(stringArrayList);
                aVarA.a(stringArrayList);
            }
            aVarA.a(com.salesforce.marketingcloud.http.b.values()[data.getInt("mcRequestId", 0)]);
            c cVarA = aVarA.a();
            cVarA.a(data.getString("tag"));
            return cVarA;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.c$c, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface InterfaceC0077c {
    }

    static final class d extends Lambda implements Function0<String> {
        public static final d b = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to complete request";
        }
    }

    public c(@NotNull String method, @Nullable String str, int i, @NotNull String contentType, @NotNull String url, @NotNull List<String> headers, @NotNull com.salesforce.marketingcloud.http.b requestId) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        this.b = method;
        this.c = str;
        this.d = i;
        this.e = contentType;
        this.f = url;
        this.g = headers;
        this.h = requestId;
    }

    @JvmStatic
    public static final a b() {
        return j.a();
    }

    public final c a(@NotNull String method, @Nullable String str, int i, @NotNull String contentType, @NotNull String url, @NotNull List<String> headers, @NotNull com.salesforce.marketingcloud.http.b requestId) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        return new c(method, str, i, contentType, url, headers, requestId);
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c) && this.d == cVar.d && Intrinsics.areEqual(this.e, cVar.e) && Intrinsics.areEqual(this.f, cVar.f) && Intrinsics.areEqual(this.g, cVar.g) && this.h == cVar.h;
    }

    public final String f() {
        return this.e;
    }

    public final String g() {
        return this.f;
    }

    @Override // com.salesforce.marketingcloud.http.g
    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putString("method", this.b);
        bundle.putString("requestBody", this.c);
        bundle.putInt("connectionTimeout", this.d);
        bundle.putString("contentType", this.e);
        bundle.putString("url", this.f);
        List<String> list = this.g;
        bundle.putStringArrayList("headers", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(this.g));
        bundle.putInt("mcRequestId", this.h.ordinal());
        bundle.putString("tag", this.i);
        return bundle;
    }

    public int hashCode() {
        int iHashCode = this.b.hashCode();
        String str = this.c;
        return (((((((((((iHashCode * 31) + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public final List<String> i() {
        return this.g;
    }

    public final com.salesforce.marketingcloud.http.b j() {
        return this.h;
    }

    public final f k() throws Throwable {
        HttpsURLConnection httpsURLConnection;
        f fVarA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            try {
                URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.f).openConnection());
                Intrinsics.checkNotNull(uRLConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                httpsURLConnection = (HttpsURLConnection) uRLConnection;
                try {
                    httpsURLConnection.setRequestMethod(this.b);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    httpsURLConnection.setAllowUserInteraction(false);
                    httpsURLConnection.setConnectTimeout(this.d);
                    IntProgression intProgressionStep = RangesKt___RangesKt.step(RangesKt___RangesKt.until(0, this.g.size()), 2);
                    int first = intProgressionStep.getFirst();
                    int last = intProgressionStep.getLast();
                    int step = intProgressionStep.getStep();
                    if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                        while (true) {
                            httpsURLConnection.setRequestProperty(this.g.get(first), this.g.get(first + 1));
                            if (first == last) {
                                break;
                            }
                            first += step;
                        }
                    }
                    String str = this.c;
                    if (str != null) {
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setRequestProperty("content-type", this.e);
                        OutputStream outputStream = httpsURLConnection.getOutputStream();
                        try {
                            byte[] bytes = str.getBytes(o.b());
                            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            outputStream.write(bytes);
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(outputStream, null);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(outputStream, th);
                                throw th2;
                            }
                        }
                    }
                    f.a aVarA = f.h.a();
                    aVarA.a(httpsURLConnection.getResponseCode());
                    aVarA.b(httpsURLConnection.getResponseMessage());
                    aVarA.a(httpsURLConnection.getHeaderFields());
                    try {
                        String strA = a(httpsURLConnection.getInputStream());
                        if (strA != null) {
                            aVarA.a(strA);
                        }
                    } catch (IOException unused) {
                        String strA2 = a(httpsURLConnection.getErrorStream());
                        if (strA2 != null) {
                            aVarA.a(strA2);
                        }
                    }
                    aVarA.b(jCurrentTimeMillis);
                    aVarA.a(System.currentTimeMillis());
                    fVarA = aVarA.a();
                    httpsURLConnection.disconnect();
                } catch (Exception e) {
                    e = e;
                    httpsURLConnection2 = httpsURLConnection;
                    com.salesforce.marketingcloud.g.a.b(k, e, d.b);
                    fVarA = f.h.a("ERROR", -100);
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                httpsURLConnection = httpsURLConnection2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        return fVarA;
    }

    public final int l() {
        return this.d;
    }

    public final String m() {
        return this.e;
    }

    public final List<String> n() {
        return this.g;
    }

    public final String o() {
        return this.b;
    }

    public final String p() {
        return this.c;
    }

    public final com.salesforce.marketingcloud.http.b q() {
        return this.h;
    }

    public final String r() {
        return this.i;
    }

    public final String s() {
        return this.f;
    }

    public String toString() {
        return "Request(method=" + this.b + ", requestBody=" + this.c + ", connectionTimeout=" + this.d + ", contentType=" + this.e + ", url=" + this.f + ", headers=" + this.g + ", requestId=" + this.h + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ c a(c cVar, String str, String str2, int i, String str3, String str4, List list, com.salesforce.marketingcloud.http.b bVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cVar.b;
        }
        if ((i2 & 2) != 0) {
            str2 = cVar.c;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            i = cVar.d;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = cVar.e;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = cVar.f;
        }
        String str7 = str4;
        if ((i2 & 32) != 0) {
            list = cVar.g;
        }
        List list2 = list;
        if ((i2 & 64) != 0) {
            bVar = cVar.h;
        }
        return cVar.a(str, str5, i3, str6, str7, list2, bVar);
    }

    @JvmStatic
    public static final c a(@NotNull Bundle bundle) {
        return j.a(bundle);
    }

    public final void a(@Nullable String str) {
        this.i = str;
    }

    private final String a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, o.b()));
        try {
            StringBuilder sb = new StringBuilder();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                sb.append(line);
                sb.append('\n');
            }
            String string = sb.toString();
            CloseableKt.closeFinally(bufferedReader, null);
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }
}
