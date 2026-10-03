package io.sentry;

import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public enum MonitorScheduleUnit {
    MINUTE,
    HOUR,
    DAY,
    WEEK,
    MONTH,
    YEAR;

    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
