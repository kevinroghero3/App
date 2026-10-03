package com.salesforce.marketingcloud.analytics.piwama;

import com.salesforce.marketingcloud.internal.o;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface c {
    String a();

    default void a(@NotNull JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        jSONObject.put("analyticType", b());
        jSONObject.put("api_endpoint", d());
        if (a().length() > 0) {
            jSONObject.put("event_name", a());
        }
        jSONObject.put("timestamp", o.a(e()));
    }

    int b();

    JSONObject c();

    String d();

    Date e();

    default String a(@NotNull String str, @NotNull String fieldName, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        String string = StringsKt__StringsKt.trim((CharSequence) str).toString();
        int length = string.length();
        if (length != 0) {
            if (length <= 1024) {
                return string;
            }
            String strSubstring = string.substring(0, 1024);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return StringsKt__StringsKt.trim((CharSequence) strSubstring).toString();
        }
        throw new IllegalArgumentException("PiEvent must contain a " + fieldName + ".");
    }
}
