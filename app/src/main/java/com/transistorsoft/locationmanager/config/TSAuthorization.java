package com.transistorsoft.locationmanager.config;

import android.content.Context;
import android.util.Log;
import com.google.common.net.HttpHeaders;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.event.AuthorizationEvent;
import com.transistorsoft.locationmanager.http.HttpService;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TSAuthorization extends com.transistorsoft.locationmanager.config.a implements IModule {
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    public static final String FIELD_ACCESS_TOKEN = "accessToken";
    public static final String FIELD_EXPIRES = "expires";
    public static final String FIELD_REFRESH_HEADERS = "refreshHeaders";
    public static final String FIELD_REFRESH_PAYLOAD = "refreshPayload";
    public static final String FIELD_REFRESH_TOKEN = "refreshToken";
    public static final String FIELD_REFRESH_URL = "refreshUrl";
    public static final String FIELD_STRATEGY = "strategy";
    public static final String NAME = "authorization";
    public static final String STRATEGY_JWT = "JWT";
    public static final String STRATEGY_SAS = "SAS";
    private static final String m = "{refreshToken}";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f101n = "{accessToken}";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Pattern f102o = Pattern.compile("^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.?[A-Za-z0-9-_.+/=]*$");
    private static final Pattern p = Pattern.compile("^[A-Za-z0-9-_=]+$");
    private static final Pattern q = Pattern.compile("^(access|auth|id_token)");
    private static final Pattern r = Pattern.compile("^(renew|refresh)");
    private static final Pattern s = Pattern.compile("^expir.*");
    private String c;
    private String d;
    private String e;
    private String f;
    private Map<String, Object> g;
    private Map<String, Object> h;
    private long i;
    private boolean j;
    private boolean k;
    private boolean l;

    /* JADX INFO: loaded from: classes6.dex */
    public static class Builder {
        private String a = null;
        private String b = null;
        private String c = null;
        private String d = null;
        private Map<String, Object> e = null;
        private Map<String, Object> f = null;
        private long g = -1;

        public TSAuthorization build() {
            TSAuthorization tSAuthorization = new TSAuthorization();
            tSAuthorization.c = this.a;
            tSAuthorization.d = this.b;
            tSAuthorization.e = this.c;
            tSAuthorization.f = this.d;
            tSAuthorization.g = this.e;
            tSAuthorization.h = this.f;
            tSAuthorization.i = this.g;
            return tSAuthorization;
        }

        public Builder setAccessToken(String str) {
            this.b = str;
            return this;
        }

        public Builder setExpires(long j) {
            this.g = j;
            return this;
        }

        public Builder setRefreshHeaders(Map<String, Object> map) {
            this.f = map;
            return this;
        }

        public Builder setRefreshPayload(Map<String, Object> map) {
            this.e = map;
            return this;
        }

        public Builder setRefreshToken(String str) {
            this.d = str;
            return this;
        }

        public Builder setRefreshUrl(String str) {
            this.c = str;
            return this;
        }

        public Builder setStrategy(String str) {
            this.a = str;
            return this;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface Callback {
        void invoke(AuthorizationEvent authorizationEvent);
    }

    class a implements okhttp3.Callback {
        final /* synthetic */ Callback a;
        final /* synthetic */ Context b;

        a(Callback callback, Context context) {
            this.a = callback;
            this.b = context;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException iOException) {
            TSLog.logger.warn(TSLog.warn(iOException.getMessage()));
            TSAuthorization.this.a(0, iOException.getMessage(), this.a);
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody == null) {
                TSAuthorization.this.a(response.code(), "NO_RESPONSE_DATA", this.a);
                return;
            }
            try {
                String strString = responseBodyBody.string();
                JSONObject jSONObject = new JSONObject(strString);
                if (response.isSuccessful()) {
                    TSAuthorization.this.a(this.b, response.code(), jSONObject, this.a);
                } else {
                    TSAuthorization.this.a(response.code(), strString, this.a);
                }
            } catch (JSONException e) {
                TSAuthorization.this.a(response.code(), e.getMessage(), this.a);
            }
        }
    }

    public TSAuthorization() {
        super("authorization");
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = -1L;
        this.j = false;
        this.k = false;
        this.l = false;
        applyDefaults();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public void apply(Request.Builder builder) {
        if (this.d != null) {
            if (!this.c.equalsIgnoreCase(STRATEGY_JWT)) {
                if (this.c.equalsIgnoreCase(STRATEGY_SAS)) {
                    builder.header(HttpHeaders.AUTHORIZATION, this.d);
                }
            } else {
                builder.header(HttpHeaders.AUTHORIZATION, "Bearer " + this.d);
            }
        }
    }

    @Override // com.transistorsoft.locationmanager.config.IModule
    public void applyDefaults() {
        if (this.c == null) {
            this.c = STRATEGY_JWT;
        }
        if (this.g == null) {
            this.g = new HashMap();
        }
        if (this.h == null) {
            this.h = new HashMap();
            if (this.c.equalsIgnoreCase(STRATEGY_JWT)) {
                this.h.put(HttpHeaders.AUTHORIZATION, "Bearer {accessToken}");
            } else if (this.c.equalsIgnoreCase(STRATEGY_SAS)) {
                this.h.put(HttpHeaders.AUTHORIZATION, f101n);
            }
        }
    }

    public boolean canRefreshAuthorizationToken() {
        String str;
        Map<String, Object> map;
        String str2 = this.e;
        return (str2 == null || str2.isEmpty() || (str = this.f) == null || str.isEmpty() || (map = this.g) == null || map.keySet().isEmpty()) ? false : true;
    }

    public boolean equals(TSAuthorization tSAuthorization) {
        String str;
        String str2;
        String str3;
        Map<String, Object> map;
        Map<String, Object> map2;
        String str4 = this.c;
        return str4 != null && str4.equalsIgnoreCase(tSAuthorization.getStrategy()) && (str = this.d) != null && str.equals(tSAuthorization.getAccessToken()) && (str2 = this.f) != null && str2.equals(tSAuthorization.getRefreshToken()) && (str3 = this.e) != null && str3.equals(tSAuthorization.getRefreshUrl()) && (map = this.g) != null && map.equals(tSAuthorization.getRefreshPayload()) && (map2 = this.h) != null && map2.equals(tSAuthorization.getRefreshHeaders()) && this.i == tSAuthorization.getExpires();
    }

    public String getAccessToken() {
        return this.d;
    }

    @Override // com.transistorsoft.locationmanager.config.a
    public /* bridge */ /* synthetic */ List getDirtyFields() {
        return super.getDirtyFields();
    }

    public long getExpires() {
        return this.i;
    }

    public Map<String, Object> getRefreshHeaders() {
        return this.h;
    }

    public Map<String, Object> getRefreshPayload() {
        return this.g;
    }

    public String getRefreshToken() {
        return this.f;
    }

    public String getRefreshUrl() {
        return this.e;
    }

    public String getStrategy() {
        return this.c;
    }

    public void refreshAuthorizationToken(Context context, Callback callback) {
        OkHttpClient client = HttpService.getInstance(context).getClient();
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, Object> entry : this.g.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value.getClass() == String.class) {
                String str = (String) value;
                if (str.contains(m)) {
                    value = str.replace(m, this.f);
                }
            }
            builder.add(key, value.toString());
        }
        Request.Builder builderPost = new Request.Builder().url(this.e).post(builder.build());
        JSONObject headers = TSConfig.getInstance(context).getHeaders();
        if (headers != null) {
            Iterator<String> itKeys = headers.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && !next.equalsIgnoreCase("content-type")) {
                    try {
                        builderPost.header(next, headers.getString(next));
                    } catch (JSONException unused) {
                        TSLog.logger.warn("Invalid header ignored: " + next);
                    }
                }
            }
        }
        builderPost.header(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
        for (Map.Entry<String, Object> entry2 : this.h.entrySet()) {
            String key2 = entry2.getKey();
            Object value2 = entry2.getValue();
            if (value2.getClass() == String.class) {
                String str2 = (String) value2;
                if (str2.contains(f101n)) {
                    value2 = str2.replace(f101n, this.d);
                }
            }
            builderPost.header(key2, value2.toString());
        }
        client.newCall(builderPost.build()).enqueue(new a(callback, context));
    }

    public void setAccessToken(String str) {
        this.d = str;
    }

    public void setExpires(long j) {
        this.i = j;
    }

    public void setRefreshHeaders(Map<String, Object> map) {
        this.h = map;
    }

    public void setRefreshPayload(Map<String, Object> map) {
        this.g = map;
    }

    public void setRefreshToken(String str) {
        this.f = str;
    }

    public void setRefreshUrl(String str) {
        this.e = str;
    }

    public void setStrategy(String str) {
        this.c = str;
    }

    @Override // com.transistorsoft.locationmanager.config.IModule
    public JSONObject toJson(boolean z) {
        JSONObject jSONObject = new JSONObject();
        String string = this.d;
        if (string == null) {
            return jSONObject;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            String str = this.d;
            sb.append(str.substring(0, Math.min(str.length(), 5)));
            sb.append("<redacted>");
            string = sb.toString();
        }
        String string2 = this.f;
        if (string2 != null && z) {
            StringBuilder sb2 = new StringBuilder();
            String str2 = this.f;
            sb2.append(str2.substring(0, Math.min(str2.length(), 5)));
            sb2.append("<redacted>");
            string2 = sb2.toString();
        }
        try {
            jSONObject.put(FIELD_STRATEGY, this.c);
            jSONObject.put("accessToken", string);
            jSONObject.put(FIELD_REFRESH_TOKEN, string2);
            jSONObject.put(FIELD_REFRESH_URL, this.e);
            jSONObject.put(FIELD_REFRESH_PAYLOAD, this.g != null ? new JSONObject(this.g) : null);
            jSONObject.put(FIELD_REFRESH_HEADERS, this.h != null ? new JSONObject(this.h) : null);
            jSONObject.put(FIELD_EXPIRES, this.i);
        } catch (JSONException e) {
            Log.i("TSLocationManager", TSLog.error(e.getMessage()));
            TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
        }
        return jSONObject;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put(FIELD_STRATEGY, this.c);
        map.put("accessToken", this.d);
        map.put(FIELD_REFRESH_TOKEN, this.f);
        map.put(FIELD_REFRESH_URL, this.e);
        map.put(FIELD_REFRESH_PAYLOAD, this.g);
        map.put(FIELD_REFRESH_HEADERS, this.h);
        map.put(FIELD_EXPIRES, Long.valueOf(this.i));
        return map;
    }

    public boolean update(TSAuthorization tSAuthorization) {
        a();
        if (tSAuthorization.getStrategy() != null && !tSAuthorization.getStrategy().equals(this.c)) {
            this.c = tSAuthorization.getStrategy();
            a(FIELD_STRATEGY);
        }
        if (tSAuthorization.getAccessToken() != null && !tSAuthorization.getAccessToken().equals(this.d)) {
            this.d = tSAuthorization.getAccessToken();
            a("accessToken");
        }
        if (tSAuthorization.getRefreshToken() != null && !tSAuthorization.getRefreshToken().equals(this.f)) {
            this.f = tSAuthorization.getRefreshToken();
            a(FIELD_REFRESH_TOKEN);
        }
        if (tSAuthorization.getRefreshUrl() != null && !tSAuthorization.getRefreshUrl().equals(this.e)) {
            this.e = tSAuthorization.getRefreshUrl();
            a(FIELD_REFRESH_URL);
        }
        if (tSAuthorization.getRefreshPayload() != null && !tSAuthorization.getRefreshPayload().equals(this.g)) {
            this.g = tSAuthorization.getRefreshPayload();
            a(FIELD_REFRESH_PAYLOAD);
        }
        if (tSAuthorization.getRefreshHeaders() != null && !tSAuthorization.getRefreshHeaders().equals(this.h)) {
            this.h = tSAuthorization.getRefreshHeaders();
            a(FIELD_REFRESH_HEADERS);
        }
        if (tSAuthorization.getExpires() != this.i) {
            this.i = tSAuthorization.getExpires();
            a(FIELD_EXPIRES);
        }
        return !getDirtyFields().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Callback callback) {
        TSLog.logger.warn(TSLog.warn("🔑 " + str));
        callback.invoke(new AuthorizationEvent(i, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i, JSONObject jSONObject, Callback callback) {
        this.j = false;
        this.k = false;
        this.l = false;
        try {
            TSAuthorization tSAuthorization = new TSAuthorization();
            tSAuthorization.setStrategy(this.c);
            tSAuthorization.setRefreshToken(this.f);
            tSAuthorization.setRefreshPayload(this.g);
            tSAuthorization.setRefreshHeaders(this.h);
            a(jSONObject, tSAuthorization);
            TSConfig.getInstance(context).updateWithBuilder().setAuthorization(tSAuthorization).commit();
            if (this.j) {
                TSLog.logger.debug("🔑 Refresh token success");
                callback.invoke(new AuthorizationEvent(i, jSONObject));
            } else {
                callback.invoke(new AuthorizationEvent(i, TSLog.error("🔑 Failed to find refreshToken or accessToken in response from " + this.e)));
            }
        } catch (JSONException e) {
            String str = "Error parsing response data from refreshUrl: " + e.getMessage();
            TSLog.logger.error(TSLog.error("🔑 " + str), (Throwable) e);
            callback.invoke(new AuthorizationEvent(i, str));
        }
    }

    public TSAuthorization(Map<String, Object> map) {
        Integer num;
        super("authorization");
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = -1L;
        this.j = false;
        this.k = false;
        this.l = false;
        if (map.containsKey(FIELD_STRATEGY)) {
            this.c = (String) map.get(FIELD_STRATEGY);
        }
        if (map.containsKey("accessToken")) {
            this.d = (String) map.get("accessToken");
        }
        if (map.containsKey(FIELD_REFRESH_TOKEN)) {
            this.f = (String) map.get(FIELD_REFRESH_TOKEN);
        }
        if (map.containsKey(FIELD_REFRESH_URL)) {
            this.e = (String) map.get(FIELD_REFRESH_URL);
        }
        if (map.containsKey(FIELD_REFRESH_PAYLOAD)) {
            this.g = (Map) map.get(FIELD_REFRESH_PAYLOAD);
        }
        if (map.containsKey(FIELD_REFRESH_HEADERS)) {
            this.h = (Map) map.get(FIELD_REFRESH_HEADERS);
        }
        if (!map.containsKey(FIELD_EXPIRES) || (num = (Integer) map.get(FIELD_EXPIRES)) == null) {
            return;
        }
        this.i = num.longValue();
    }

    private void a(JSONObject jSONObject, TSAuthorization tSAuthorization) throws JSONException {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                a((JSONObject) obj, tSAuthorization);
            } else if (!(obj instanceof JSONArray)) {
                String string = obj.toString();
                boolean zIsNumeric = isNumeric(string);
                if (!this.j && q.matcher(next).find() && !zIsNumeric) {
                    this.j = true;
                    TSLog.logger.debug("🔑 Received accessToken");
                    tSAuthorization.setAccessToken(string);
                } else if (!this.k && r.matcher(next).find() && !zIsNumeric) {
                    this.k = true;
                    TSLog.logger.debug("🔑 Received refreshToken");
                    tSAuthorization.setRefreshToken(string);
                } else if (!this.l && s.matcher(next).find()) {
                    this.l = true;
                    TSLog.logger.debug("🔑 Received expires");
                    tSAuthorization.setExpires(Long.valueOf(string).longValue());
                }
            }
        }
    }

    public TSAuthorization(JSONObject jSONObject, boolean z) throws JSONException {
        super("authorization");
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = -1L;
        this.j = false;
        this.k = false;
        this.l = false;
        if (jSONObject.has(FIELD_STRATEGY)) {
            this.c = jSONObject.getString(FIELD_STRATEGY);
        }
        if (jSONObject.has("accessToken")) {
            this.d = jSONObject.getString("accessToken");
        }
        if (jSONObject.has(FIELD_REFRESH_TOKEN)) {
            this.f = jSONObject.getString(FIELD_REFRESH_TOKEN);
        }
        if (jSONObject.has(FIELD_REFRESH_URL)) {
            this.e = jSONObject.getString(FIELD_REFRESH_URL);
        }
        if (jSONObject.has(FIELD_REFRESH_PAYLOAD)) {
            this.g = Util.toMap(jSONObject.getJSONObject(FIELD_REFRESH_PAYLOAD));
        }
        if (jSONObject.has(FIELD_REFRESH_HEADERS)) {
            this.h = Util.toMap(jSONObject.getJSONObject(FIELD_REFRESH_HEADERS));
        }
        if (jSONObject.has(FIELD_EXPIRES)) {
            this.i = jSONObject.getLong(FIELD_EXPIRES);
        }
        if (z) {
            applyDefaults();
        }
    }
}
