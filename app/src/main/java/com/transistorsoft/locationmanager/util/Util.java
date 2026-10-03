package com.transistorsoft.locationmanager.util;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Util {
    public static final String ACTIVITY_NAME_IN_VEHICLE = "in_vehicle";
    public static final String ACTIVITY_NAME_ON_BICYCLE = "on_bicycle";
    public static final String ACTIVITY_NAME_ON_FOOT = "on_foot";
    public static final String ACTIVITY_NAME_RUNNING = "running";
    public static final String ACTIVITY_NAME_STILL = "still";
    public static final String ACTIVITY_NAME_TILTING = "tilting";
    public static final String ACTIVITY_NAME_UNKNOWN = "unknown";
    public static final String ACTIVITY_NAME_WALKING = "walking";
    private static AtomicBoolean a;

    public static Integer getActivityId(String str) {
        if (str.equals(ACTIVITY_NAME_IN_VEHICLE)) {
            return 0;
        }
        if (str.equals(ACTIVITY_NAME_ON_BICYCLE)) {
            return 1;
        }
        if (str.equals(ACTIVITY_NAME_ON_FOOT)) {
            return 2;
        }
        if (str.equals(ACTIVITY_NAME_RUNNING)) {
            return 8;
        }
        if (str.equals(ACTIVITY_NAME_WALKING)) {
            return 7;
        }
        if (str.equals(ACTIVITY_NAME_STILL)) {
            return 3;
        }
        if (!str.equals("unknown") && str.equals(ACTIVITY_NAME_TILTING)) {
            return 5;
        }
        return 4;
    }

    public static String getActivityName(int i) {
        if (i == 0) {
            return ACTIVITY_NAME_IN_VEHICLE;
        }
        if (i == 1) {
            return ACTIVITY_NAME_ON_BICYCLE;
        }
        if (i == 2) {
            return ACTIVITY_NAME_ON_FOOT;
        }
        if (i == 8) {
            return ACTIVITY_NAME_RUNNING;
        }
        if (i == 7) {
            return ACTIVITY_NAME_WALKING;
        }
        if (i == 3) {
            return ACTIVITY_NAME_STILL;
        }
        return (i != 4 && i == 5) ? ACTIVITY_NAME_TILTING : "unknown";
    }

    public static int getPendingIntentFlags(int i) {
        return Build.VERSION.SDK_INT >= 31 ? i | 33554432 : i;
    }

    public static boolean isRunningTest() {
        boolean z;
        if (a == null) {
            try {
                Class.forName("androidx.test.espresso.Espresso");
                z = true;
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            a = new AtomicBoolean(z);
        }
        return a.get();
    }

    public static String joinString(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str2 : list) {
            if (z) {
                z = false;
            } else {
                sb.append(str);
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    public static JSONObject mergeJson(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        JSONObject[] jSONObjectArr = {jSONObject, jSONObject2};
        for (int i = 0; i < 2; i++) {
            JSONObject jSONObject4 = jSONObjectArr[i];
            Iterator<String> itKeys = jSONObject4.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject3.put(next, jSONObject4.get(next));
            }
        }
        return jSONObject3;
    }

    public static List<Object> toList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object map = jSONArray.get(i);
            if (map instanceof JSONArray) {
                map = toList((JSONArray) map);
            } else if (map instanceof JSONObject) {
                map = toMap((JSONObject) map);
            }
            arrayList.add(map);
        }
        return arrayList;
    }

    public static Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object map2 = jSONObject.get(next);
            if (map2 instanceof JSONArray) {
                map2 = toList((JSONArray) map2);
            } else if (map2 instanceof JSONObject) {
                map2 = toMap((JSONObject) map2);
            }
            map.put(next, map2);
        }
        return map;
    }

    public static void deleteSharedPreferencesFile(Context context, String str) {
        context.deleteSharedPreferences(str);
    }
}
