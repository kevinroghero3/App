package net.time4j.tz.model;

import com.google.firebase.perf.util.Constants;
import java.util.Comparator;

/* JADX INFO: loaded from: classes6.dex */
enum RuleComparator implements Comparator<DaylightSavingRule> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(DaylightSavingRule daylightSavingRule, DaylightSavingRule daylightSavingRule2) {
        int iCompareTo = daylightSavingRule.getDate(Constants.MAX_URL_LENGTH).compareTo(daylightSavingRule2.getDate(Constants.MAX_URL_LENGTH));
        return iCompareTo == 0 ? daylightSavingRule.getTimeOfDay().compareTo(daylightSavingRule2.getTimeOfDay()) : iCompareTo;
    }
}
