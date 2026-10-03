package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultsXmlParser {
    private static final String XML_TAG_ENTRY = "entry";
    private static final String XML_TAG_KEY = "key";
    private static final String XML_TAG_VALUE = "value";

    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    public static Map<String, String> getDefaultsFromXml(Context context, int i) {
        byte b;
        HashMap map = new HashMap();
        try {
            Resources resources = context.getResources();
            if (resources == null) {
                SentryLogcatAdapter.e(FirebaseRemoteConfig.TAG, "Could not find the resources of the current context while trying to set defaults from an XML.");
                return map;
            }
            XmlResourceParser xml = resources.getXml(i);
            String name = null;
            String text = null;
            String text2 = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    name = xml.getName();
                } else if (eventType == 3) {
                    if (xml.getName().equals(XML_TAG_ENTRY)) {
                        if (text == null || text2 == null) {
                            SentryLogcatAdapter.w(FirebaseRemoteConfig.TAG, "An entry in the defaults XML has an invalid key and/or value tag.");
                        } else {
                            map.put(text, text2);
                        }
                        text = null;
                        text2 = null;
                    }
                    name = null;
                } else if (eventType == 4 && name != null) {
                    int iHashCode = name.hashCode();
                    if (iHashCode != 106079) {
                        if (iHashCode == 111972721 && name.equals("value")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (name.equals("key")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        text = xml.getText();
                    } else if (b != 1) {
                        SentryLogcatAdapter.w(FirebaseRemoteConfig.TAG, "Encountered an unexpected tag while parsing the defaults XML.");
                    } else {
                        text2 = xml.getText();
                    }
                }
            }
            return map;
        } catch (IOException | XmlPullParserException e) {
            SentryLogcatAdapter.e(FirebaseRemoteConfig.TAG, "Encountered an error while parsing the defaults XML file.", e);
        }
    }
}
