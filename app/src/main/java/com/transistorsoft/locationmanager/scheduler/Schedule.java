package com.transistorsoft.locationmanager.scheduler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes.dex */
public class Schedule {
    private static final SimpleDateFormat c = new SimpleDateFormat("HH:mm");
    private static final Pattern d = Pattern.compile("\\d{4}-\\d{2}-\\d{2}.*");
    private static final String e = "geofence";
    private static final String f = "location";
    private final List<Integer> a = new ArrayList();
    private boolean b = false;
    public Calendar offTime;
    public Calendar onTime;
    public int trackingMode;

    public Schedule(String str) {
        a(str);
    }

    private void a(String str) {
        String[] strArrSplit = str.split(StringUtils.SPACE);
        Locale locale = Locale.US;
        this.onTime = Calendar.getInstance(locale);
        this.offTime = Calendar.getInstance(locale);
        if (strArrSplit[0].contains("-")) {
            Pattern pattern = d;
            if (pattern.matcher(strArrSplit[0]).matches()) {
                this.b = true;
                String[] strArrSplit2 = strArrSplit[0].split("-");
                this.onTime.set(1, Integer.parseInt(strArrSplit2[0]));
                this.onTime.set(2, Integer.parseInt(strArrSplit2[1]) - 1);
                this.onTime.set(5, Integer.parseInt(strArrSplit2[2]));
                if (pattern.matcher(strArrSplit[1]).matches()) {
                    String[] strArrSplit3 = strArrSplit[1].split("-");
                    this.offTime.set(1, Integer.parseInt(strArrSplit3[0]));
                    this.offTime.set(2, Integer.parseInt(strArrSplit3[1]) - 1);
                    this.offTime.set(5, Integer.parseInt(strArrSplit3[2]));
                    strArrSplit[1] = strArrSplit2[3] + "-" + strArrSplit3[3];
                } else {
                    this.offTime.set(1, this.onTime.get(1));
                    this.offTime.set(2, this.onTime.get(2));
                    this.offTime.set(5, this.onTime.get(5));
                }
            } else {
                String[] strArrSplit4 = strArrSplit[0].split("-");
                int i = Integer.parseInt(strArrSplit4[1]);
                for (int i2 = Integer.parseInt(strArrSplit4[0]); i2 <= i; i2++) {
                    this.a.add(Integer.valueOf(i2));
                }
            }
        } else {
            for (String str2 : strArrSplit[0].split(",")) {
                this.a.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        String[] strArrSplit5 = strArrSplit[1].split("-");
        String[] strArrSplit6 = strArrSplit5[0].split(":");
        this.onTime.set(11, Integer.parseInt(strArrSplit6[0]));
        this.onTime.set(12, Integer.parseInt(strArrSplit6[1]));
        this.onTime.set(13, 0);
        this.onTime.set(14, 0);
        String[] strArrSplit7 = strArrSplit5[1].split(":");
        this.offTime.set(11, Integer.parseInt(strArrSplit7[0]));
        this.offTime.set(12, Integer.parseInt(strArrSplit7[1]));
        this.offTime.set(13, 0);
        this.offTime.set(14, 0);
        if (this.b && this.offTime.before(this.onTime)) {
            this.offTime.add(6, 1);
        }
        if (strArrSplit.length <= 2) {
            this.trackingMode = 1;
        } else if (strArrSplit[2].contains("geofence")) {
            this.trackingMode = 0;
        } else {
            this.trackingMode = 1;
        }
    }

    public Boolean hasDay(int i) {
        return Boolean.valueOf(this.a.contains(Integer.valueOf(i)));
    }

    public boolean isExpired() {
        return Calendar.getInstance(Locale.US).after(this.offTime);
    }

    public boolean isLiteralDate() {
        return this.b;
    }

    public boolean isNext(Calendar calendar) {
        if (!this.b) {
            make(calendar);
            if (!hasDay(calendar.get(7)).booleanValue()) {
                return false;
            }
        }
        return calendar.before(this.offTime);
    }

    public void make(Calendar calendar) {
        if (this.b) {
            return;
        }
        this.onTime.set(6, calendar.get(6));
        this.onTime.set(1, calendar.get(1));
        this.offTime.set(6, calendar.get(6));
        this.offTime.set(1, calendar.get(1));
        if (this.offTime.before(this.onTime)) {
            this.offTime.add(6, 1);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Schedule[");
        SimpleDateFormat simpleDateFormat = c;
        sb.append(simpleDateFormat.format(this.onTime.getTime()));
        sb.append("-");
        sb.append(simpleDateFormat.format(this.offTime.getTime()));
        sb.append(", Days: ");
        sb.append(this.a);
        sb.append(", trackingMode: ");
        sb.append(this.trackingMode);
        sb.append("]");
        return sb.toString();
    }
}
