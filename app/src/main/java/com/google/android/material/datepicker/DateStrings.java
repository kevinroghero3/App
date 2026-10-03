package com.google.android.material.datepicker;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
class DateStrings {
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

    private static void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    private DateStrings() {
    }

    static String getYearMonth(long j) {
        return UtcDates.getYearMonthFormat(Locale.getDefault()).format(new Date(j));
    }

    static String getYearMonthDay(long j) {
        return getYearMonthDay(j, Locale.getDefault());
    }

    static String getYearMonthDay(long j, Locale locale) {
        return UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j));
    }

    static String getMonthDay(long j) {
        return getMonthDay(j, Locale.getDefault());
    }

    static String getMonthDay(long j, Locale locale) {
        return UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j));
    }

    static String getMonthDayOfWeekDay(long j) {
        return getMonthDayOfWeekDay(j, Locale.getDefault());
    }

    static String getMonthDayOfWeekDay(long j, Locale locale) {
        return UtcDates.getMonthWeekdayDayFormat(locale).format(new Date(j));
    }

    static String getYearMonthDayOfWeekDay(long j) {
        return getYearMonthDayOfWeekDay(j, Locale.getDefault());
    }

    static String getYearMonthDayOfWeekDay(long j, Locale locale) {
        return UtcDates.getYearMonthWeekdayDayFormat(locale).format(new Date(j));
    }

    static String getOptionalYearMonthDayOfWeekDay(long j) {
        if (isDateWithinCurrentYear(j)) {
            return getMonthDayOfWeekDay(j);
        }
        return getYearMonthDayOfWeekDay(j);
    }

    static String getDateString(long j) {
        return getDateString(j, null);
    }

    static String getDateString(long j, @Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j));
        }
        if (isDateWithinCurrentYear(j)) {
            return getMonthDay(j);
        }
        return getYearMonthDay(j);
    }

    private static boolean isDateWithinCurrentYear(long j) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return todayCalendar.get(1) == utcCalendar.get(1);
    }

    static Pair<String, String> getDateRangeString(@Nullable Long l, @Nullable Long l2) {
        return getDateRangeString(l, l2, null);
    }

    static Pair<String, String> getDateRangeString(@Nullable Long l, @Nullable Long l2, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l == null && l2 == null) {
            return Pair.create(null, null);
        }
        if (l == null) {
            return Pair.create(null, getDateString(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return Pair.create(getDateString(l.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l.longValue())), simpleDateFormat.format(new Date(l2.longValue())));
        }
        if (utcCalendar.get(1) == utcCalendar2.get(1)) {
            if (utcCalendar.get(1) == todayCalendar.get(1)) {
                return Pair.create(getMonthDay(l.longValue(), Locale.getDefault()), getMonthDay(l2.longValue(), Locale.getDefault()));
            }
            return Pair.create(getMonthDay(l.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
        }
        return Pair.create(getYearMonthDay(l.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
    }

    static String getDayContentDescription(Context context, long j, boolean z, boolean z2, boolean z3) {
        int i = 2 % 2;
        String optionalYearMonthDayOfWeekDay = getOptionalYearMonthDayOfWeekDay(j);
        if (z) {
            String string = context.getString(R.string.mtrl_picker_today_description);
            if (string.startsWith(".,.%")) {
                Object[] objArr = new Object[1];
                a(string.substring(4), objArr);
                string = ((String) objArr[0]).intern();
                int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                artificialFrame = i2 % 128;
                int i3 = i2 % 2;
            }
            optionalYearMonthDayOfWeekDay = String.format(string, optionalYearMonthDayOfWeekDay);
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
            artificialFrame = i4 % 128;
            int i5 = i4 % 2;
        }
        if (z2) {
            String string2 = context.getString(R.string.mtrl_picker_start_date_description);
            if (string2.startsWith(".,.%")) {
                Object[] objArr2 = new Object[1];
                a(string2.substring(4), objArr2);
                string2 = ((String) objArr2[0]).intern();
            }
            return String.format(string2, optionalYearMonthDayOfWeekDay);
        }
        if (!z3) {
            return optionalYearMonthDayOfWeekDay;
        }
        String string3 = context.getString(R.string.mtrl_picker_end_date_description);
        if (!(!string3.startsWith(".,.%"))) {
            Object[] objArr3 = new Object[1];
            a(string3.substring(4), objArr3);
            string3 = ((String) objArr3[0]).intern();
        }
        String str = String.format(string3, optionalYearMonthDayOfWeekDay);
        int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
        artificialFrame = i6 % 128;
        if (i6 % 2 != 0) {
            return str;
        }
        throw null;
    }

    static String getYearContentDescription(Context context, int i) {
        int i2 = 2 % 2;
        if (UtcDates.getTodayCalendar().get(1) == i) {
            String string = context.getString(R.string.mtrl_picker_navigate_to_current_year_description);
            if (!(!string.startsWith(".,.%"))) {
                Object[] objArr = new Object[1];
                a(string.substring(4), objArr);
                string = ((String) objArr[0]).intern();
            }
            return String.format(string, Integer.valueOf(i));
        }
        String string2 = context.getString(R.string.mtrl_picker_navigate_to_year_description);
        if (string2.startsWith(".,.%")) {
            int i3 = artificialFrame + 93;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
            int i4 = i3 % 2;
            Object[] objArr2 = new Object[1];
            a(string2.substring(4), objArr2);
            string2 = ((String) objArr2[0]).intern();
            int i5 = artificialFrame + b.f40o;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
            int i6 = i5 % 2;
        }
        String str = String.format(string2, Integer.valueOf(i));
        int i7 = getARTIFICIAL_FRAME_PACKAGE_NAME + 53;
        artificialFrame = i7 % 128;
        if (i7 % 2 == 0) {
            int i8 = 27 / 0;
        }
        return str;
    }
}
