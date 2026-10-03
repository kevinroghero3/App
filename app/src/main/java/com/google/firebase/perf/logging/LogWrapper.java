package com.google.firebase.perf.logging;

import android.util.Log;
import io.sentry.android.core.SentryLogcatAdapter;

/* JADX INFO: loaded from: classes3.dex */
class LogWrapper {
    private static final String LOG_TAG = "FirebasePerformance";
    private static LogWrapper instance;

    public static LogWrapper getInstance() {
        LogWrapper logWrapper;
        synchronized (LogWrapper.class) {
            if (instance == null) {
                instance = new LogWrapper();
            }
            logWrapper = instance;
        }
        return logWrapper;
    }

    void d(String str) {
        Log.d(LOG_TAG, str);
    }

    void v(String str) {
        Log.v(LOG_TAG, str);
    }

    void i(String str) {
        Log.i(LOG_TAG, str);
    }

    void w(String str) {
        SentryLogcatAdapter.w(LOG_TAG, str);
    }

    void e(String str) {
        SentryLogcatAdapter.e(LOG_TAG, str);
    }

    private LogWrapper() {
    }
}
