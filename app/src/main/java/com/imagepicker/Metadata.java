package com.imagepicker;

import io.sentry.android.core.SentryLogcatAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
abstract class Metadata {
    protected String datetime;
    protected int height;
    protected int width;

    public abstract String getDateTime();

    public abstract int getHeight();

    public abstract int getWidth();

    Metadata() {
    }

    protected String getDateTimeInUTC(String str, String str2) {
        try {
            Locale locale = Locale.US;
            Date date = new SimpleDateFormat(str2, locale).parse(str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", locale);
            if (date != null) {
                return simpleDateFormat.format(date);
            }
            return null;
        } catch (Exception e) {
            SentryLogcatAdapter.e("RNIP", "Could not parse image datetime to UTC: " + e.getMessage());
            return null;
        }
    }
}
