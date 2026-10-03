package net.time4j.calendar;

import net.time4j.PlainDate;

/* JADX INFO: loaded from: classes6.dex */
public interface HijriData {
    PlainDate firstGregorianDate();

    int lengthOfMonth(int i, int i2);

    int maximumYear();

    int minimumYear();

    String name();

    void prepare();

    String version();
}
