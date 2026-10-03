package com.google.firebase.sessions;

import android.util.Base64;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes5.dex */
public final class SessionDataStoreConfigs {
    public static final SessionDataStoreConfigs INSTANCE = new SessionDataStoreConfigs();
    private static final String PROCESS_NAME;
    private static final String SESSIONS_CONFIG_NAME;
    private static final String SETTINGS_CONFIG_NAME;

    private SessionDataStoreConfigs() {
    }

    static {
        String strEncodeToString = Base64.encodeToString(StringsKt__StringsJVMKt.encodeToByteArray(ProcessDetailsProvider.INSTANCE.getProcessName$com_google_firebase_firebase_sessions()), 10);
        PROCESS_NAME = strEncodeToString;
        SESSIONS_CONFIG_NAME = "firebase_session_" + strEncodeToString + "_data";
        SETTINGS_CONFIG_NAME = "firebase_session_" + strEncodeToString + "_settings";
    }

    public final String getSESSIONS_CONFIG_NAME() {
        return SESSIONS_CONFIG_NAME;
    }

    public final String getSETTINGS_CONFIG_NAME() {
        return SETTINGS_CONFIG_NAME;
    }
}
