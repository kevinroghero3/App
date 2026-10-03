package com.salesforce.marketingcloud.messages.inbox;

import com.salesforce.marketingcloud.internal.o;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final String A = "messageType";
    private static final String B = "contentType";
    private static final String C = "notificationMessage";
    private static final int D = 1;
    public static final String a = "requestId";
    public static final String b = "title";
    public static final String c = "alert";
    public static final String d = "sound";
    public static final String e = "media";
    public static final String f = "url";
    public static final String g = "custom";
    public static final String h = "keys";
    public static final String i = "subtitle";
    public static final String j = "type";
    public static final String k = "androidUrl";
    public static final String l = "alt";
    public static final String m = "richFeatures";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f71n = "trigger";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f72o = "id";
    private static final String p = "hash";
    private static final String q = "subject";
    private static final String r = "startDateUtc";
    private static final String s = "endDateUtc";
    private static final String t = "_endDt";
    private static final String u = "sendDateUtc";
    private static final String v = "viewCount";
    private static final String w = "isDeleted";
    private static final String x = "inboxMessage";
    private static final String y = "inboxSubtitle";
    private static final String z = "calculatedType";

    public static final JSONObject a(@NotNull InboxMessage.Media media) throws JSONException {
        Intrinsics.checkNotNullParameter(media, "<this>");
        JSONObject jSONObject = new JSONObject();
        if (media.getUrl() != null) {
            jSONObject.put(k, media.getUrl());
        }
        if (media.getAltText() != null) {
            jSONObject.put(l, media.getAltText());
        }
        return jSONObject;
    }

    public static final InboxMessage.Media a(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String strOptString = jSONObject.optString(k);
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strB = o.b(strOptString);
        String strOptString2 = jSONObject.optString(l);
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strB2 = o.b(strOptString2);
        if (strB == null && strB2 == null) {
            return null;
        }
        if (strB == null) {
            strB = "";
        }
        return new InboxMessage.Media(strB, strB2);
    }
}
