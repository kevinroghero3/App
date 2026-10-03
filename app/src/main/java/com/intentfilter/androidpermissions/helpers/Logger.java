package com.intentfilter.androidpermissions.helpers;

import io.sentry.android.core.SentryLogcatAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class Logger {
    private final String LOG_TAG;

    public void i(String str) {
    }

    private Logger(Class cls) {
        this.LOG_TAG = cls.getSimpleName();
    }

    public static Logger loggerFor(Class cls) {
        return new Logger(cls);
    }

    public void e(String str) {
        SentryLogcatAdapter.e(this.LOG_TAG, str);
    }
}
