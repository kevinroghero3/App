package com.salesforce.marketingcloud.push;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class f extends Exception {
    private final a b;
    private final String c;

    public enum a {
        UNKNOWN_ERROR,
        INVALID_JSON,
        INVALID_COMPRESSION,
        MISSING_FIELD,
        UNSUPPORTED_TYPE,
        BAD_MEDIA;

        private static final /* synthetic */ EnumEntries i = EnumEntriesKt.enumEntries(a());

        public static EnumEntries<a> b() {
            return i;
        }
    }

    public /* synthetic */ f(a aVar, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i & 2) != 0 ? null : str);
    }

    public final a a() {
        return this.b;
    }

    public final JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorCode", this.b);
        String message = getMessage();
        if (message != null) {
            jSONObject.put("message", message);
        }
        return jSONObject;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.c;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull a errorCode, @Nullable String str) {
        super(str);
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.b = errorCode;
        this.c = str;
    }
}
