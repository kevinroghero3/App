package com.google.maps.android.data.kml;

import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: loaded from: classes5.dex */
public class KmlBoolean {
    public static boolean parseBoolean(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(str) || "true".equals(str);
    }
}
