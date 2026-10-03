package com.salesforce.marketingcloud.extensions;

import android.util.Base64;
import com.salesforce.marketingcloud.config.b;
import com.salesforce.marketingcloud.g;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class PushExtensionsKt {

    static final class a extends Lambda implements Function0<String> {
        public static final a b = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Could not add event to active events map.";
        }
    }

    public static final String base64Decode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArrDecode = Base64.decode(str, 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return new String(bArrDecode, Charsets.UTF_8);
    }

    public static final Integer getIntOrNull(@NotNull JSONObject jSONObject, @Nullable String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (str != null) {
            try {
                return Integer.valueOf(jSONObject.getInt(str));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static final String getStringOrNull(@NotNull JSONObject jSONObject, @Nullable String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (str != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static final JSONArray toJSONArray(@NotNull Map<String, b> map) throws JSONException {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, b> entry : map.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.salesforce.marketingcloud.config.a.i, entry.getKey());
            String strF = entry.getValue().f();
            if (strF != null) {
                jSONObject.put("path", strF);
            }
            jSONObject.put(com.salesforce.marketingcloud.config.a.k, entry.getValue().e());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static final Map<String, String> toMap(@NotNull JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    Object obj = jSONArray.get(i);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject = (JSONObject) obj;
                    String stringOrNull = getStringOrNull(jSONObject, com.salesforce.marketingcloud.config.a.h);
                    if (stringOrNull != null) {
                        String lowerCase = stringOrNull.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        linkedHashMap.put(lowerCase, getStringOrNull(jSONObject, com.salesforce.marketingcloud.config.a.e));
                    }
                } catch (Exception e) {
                    g.a.e("~!toMap", e, a.b);
                }
            }
        }
        return linkedHashMap;
    }
}
