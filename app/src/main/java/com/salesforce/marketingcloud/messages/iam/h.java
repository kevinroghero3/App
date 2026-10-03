package com.salesforce.marketingcloud.messages.iam;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.internal.o;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final InAppMessage.CloseButton a(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        InAppMessage.Alignment alignmentValueOf = InAppMessage.Alignment.end;
        String strOptString = jSONObject.optString("alignment");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strB = o.b(strOptString);
        if (strB != null) {
            alignmentValueOf = InAppMessage.Alignment.valueOf(strB);
        }
        return new InAppMessage.CloseButton(alignmentValueOf);
    }

    public static final InAppMessage.Media b(@NotNull JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String string = jSONObject.getString("url");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        InAppMessage.Media.ImageSize imageSizeValueOf = InAppMessage.Media.ImageSize.e2e;
        String strOptString = jSONObject.optString(RRWebVideoEvent.JsonKeys.SIZE);
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strB = o.b(strOptString);
        if (strB != null) {
            imageSizeValueOf = InAppMessage.Media.ImageSize.valueOf(strB);
        }
        String strOptString2 = jSONObject.optString("altText");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strB2 = o.b(strOptString2);
        InAppMessage.Size size = InAppMessage.Size.s;
        String strOptString3 = jSONObject.optString(ViewProps.BORDER_WIDTH);
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strB3 = o.b(strOptString3);
        InAppMessage.Size sizeValueOf = strB3 != null ? InAppMessage.Size.valueOf(strB3) : size;
        String strOptString4 = jSONObject.optString(ViewProps.BORDER_COLOR);
        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
        String strB4 = o.b(strOptString4);
        String strOptString5 = jSONObject.optString("cornerRadius");
        Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
        String strB5 = o.b(strOptString5);
        return new InAppMessage.Media(string, imageSizeValueOf, strB2, sizeValueOf, strB4, strB5 != null ? InAppMessage.Size.valueOf(strB5) : size);
    }

    public static final InAppMessage.TextField c(@NotNull JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String string = jSONObject.getString("text");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        InAppMessage.Size sizeValueOf = InAppMessage.Size.s;
        String strOptString = jSONObject.optString(ViewProps.FONT_SIZE);
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strB = o.b(strOptString);
        if (strB != null) {
            sizeValueOf = InAppMessage.Size.valueOf(strB);
        }
        String strOptString2 = jSONObject.optString("fontColor");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strB2 = o.b(strOptString2);
        InAppMessage.Alignment alignmentValueOf = InAppMessage.Alignment.center;
        String strOptString3 = jSONObject.optString("alignment");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strB3 = o.b(strOptString3);
        if (strB3 != null) {
            alignmentValueOf = InAppMessage.Alignment.valueOf(strB3);
        }
        return new InAppMessage.TextField(string, sizeValueOf, strB2, alignmentValueOf);
    }

    public static final List<InAppMessage.Button> a(@NotNull JSONArray jSONArray) throws JSONException {
        InAppMessage.Button button;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        int i = 0;
        IntRange intRangeUntil = RangesKt___RangesKt.until(0, jSONArray.length());
        ArrayList<JSONObject> arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it2 = intRangeUntil.iterator();
        while (it2.hasNext()) {
            int iNextInt = ((IntIterator) it2).nextInt();
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                jSONObject = jSONArray.getJSONObject(iNextInt);
                if (jSONObject == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                jSONObject = (JSONObject) Integer.valueOf(jSONArray.getInt(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jSONObject = (JSONObject) Double.valueOf(jSONArray.getDouble(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jSONObject = (JSONObject) Long.valueOf(jSONArray.getLong(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jSONObject = (JSONObject) Boolean.valueOf(jSONArray.getBoolean(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                Object string = jSONArray.getString(iNextInt);
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) string;
            } else {
                Object obj = jSONArray.get(iNextInt);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) obj;
            }
            arrayList.add(jSONObject);
        }
        ArrayList arrayList2 = new ArrayList();
        for (JSONObject jSONObject2 : arrayList) {
            try {
                String string2 = jSONObject2.getString("id");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                int iOptInt = jSONObject2.optInt(FirebaseAnalytics.Param.INDEX, i);
                String string3 = jSONObject2.getString("text");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                InAppMessage.Button.ActionType actionTypeValueOf = InAppMessage.Button.ActionType.close;
                String strOptString = jSONObject2.optString(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                String strB = o.b(strOptString);
                if (strB != null) {
                    actionTypeValueOf = InAppMessage.Button.ActionType.valueOf(strB);
                }
                InAppMessage.Button.ActionType actionType = actionTypeValueOf;
                String strOptString2 = jSONObject2.optString("actionAndroid");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                String strB2 = o.b(strOptString2);
                String strOptString3 = jSONObject2.optString("fontColor");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                String strB3 = o.b(strOptString3);
                InAppMessage.Size size = InAppMessage.Size.s;
                String strOptString4 = jSONObject2.optString(ViewProps.FONT_SIZE);
                Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                String strB4 = o.b(strOptString4);
                InAppMessage.Size sizeValueOf = strB4 != null ? InAppMessage.Size.valueOf(strB4) : size;
                String strOptString5 = jSONObject2.optString(ViewProps.BACKGROUND_COLOR);
                Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                String strB5 = o.b(strOptString5);
                String strOptString6 = jSONObject2.optString(ViewProps.BORDER_COLOR);
                Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                String strB6 = o.b(strOptString6);
                String strOptString7 = jSONObject2.optString(ViewProps.BORDER_WIDTH);
                Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                String strB7 = o.b(strOptString7);
                InAppMessage.Size sizeValueOf2 = strB7 != null ? InAppMessage.Size.valueOf(strB7) : size;
                String strOptString8 = jSONObject2.optString("cornerRadius");
                Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
                String strB8 = o.b(strOptString8);
                button = new InAppMessage.Button(string2, iOptInt, string3, actionType, strB2, strB3, sizeValueOf, strB5, strB6, sizeValueOf2, strB8 != null ? InAppMessage.Size.valueOf(strB8) : size);
            } catch (Exception unused) {
                button = null;
            }
            InAppMessage.Button button2 = button;
            if (button2 != null) {
                arrayList2.add(button2);
            }
            i = 0;
        }
        return arrayList2;
    }
}
