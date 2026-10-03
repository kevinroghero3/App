package ch.qos.logback.core.util;

import androidx.appcompat.app.AppCompatDelegate;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.transistorsoft.locationmanager.geofence.TSGeofenceManager;
import com.yalantis.ucrop.UCrop;
import io.sentry.SentryOptions;
import java.text.DateFormatSymbols;

/* JADX INFO: loaded from: classes4.dex */
class CharSequenceToRegexMapper {
    DateFormatSymbols symbols = DateFormatSymbols.getInstance();

    CharSequenceToRegexMapper() {
    }

    static int[] findMinMaxLengthsInSymbols(String[] strArr) {
        int iMin = Integer.MAX_VALUE;
        int iMax = 0;
        for (String str : strArr) {
            int length = str.length();
            if (length != 0) {
                iMin = Math.min(iMin, length);
                iMax = Math.max(iMax, length);
            }
        }
        return new int[]{iMin, iMax};
    }

    private String getRegexForAmPms() {
        return symbolArrayToRegex(this.symbols.getAmPmStrings());
    }

    private String getRegexForLongDaysOfTheWeek() {
        return symbolArrayToRegex(this.symbols.getWeekdays());
    }

    private String getRegexForLongMonths() {
        return symbolArrayToRegex(this.symbols.getMonths());
    }

    private String getRegexForShortDaysOfTheWeek() {
        return symbolArrayToRegex(this.symbols.getShortWeekdays());
    }

    private String number(int i) {
        return "\\d{" + i + "}";
    }

    private String symbolArrayToRegex(String[] strArr) {
        int[] iArrFindMinMaxLengthsInSymbols = findMinMaxLengthsInSymbols(strArr);
        return ".{" + iArrFindMinMaxLengthsInSymbols[0] + "," + iArrFindMinMaxLengthsInSymbols[1] + "}";
    }

    String getRegexForShortMonths() {
        return symbolArrayToRegex(this.symbols.getShortMonths());
    }

    String toRegex(CharSequenceState charSequenceState) {
        int i = charSequenceState.occurrences;
        char c = charSequenceState.c;
        if (c != 'y') {
            if (c == 'z') {
                return SentryOptions.DEFAULT_PROPAGATION_TARGETS;
            }
            switch (c) {
                case '\'':
                    if (i == 1) {
                        return "";
                    }
                    throw new IllegalStateException("Too many single quotes");
                case '.':
                    return "\\.";
                case 'K':
                case 'S':
                case 'W':
                case 'd':
                case 'h':
                case 'k':
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                case 's':
                case 'w':
                    break;
                case 'M':
                    if (i <= 2) {
                        return number(i);
                    }
                    return i == 3 ? getRegexForShortMonths() : getRegexForLongMonths();
                case 'Z':
                    return "(\\+|-)\\d{4}";
                case '\\':
                    throw new IllegalStateException("Forward slashes are not allowed");
                case TSGeofenceManager.MAX_GEOFENCES /* 97 */:
                    return getRegexForAmPms();
                default:
                    switch (c) {
                        case 'D':
                        case CoreConstants.OOS_RESET_FREQUENCY /* 70 */:
                        case SyslogConstants.LOG_CRON /* 72 */:
                            break;
                        case UCrop.REQUEST_CROP /* 69 */:
                            return i >= 4 ? getRegexForLongDaysOfTheWeek() : getRegexForShortDaysOfTheWeek();
                        case 'G':
                            return SentryOptions.DEFAULT_PROPAGATION_TARGETS;
                        default:
                            if (i == 1) {
                                return "" + c;
                            }
                            return c + "{" + i + "}";
                    }
                    break;
            }
        }
        return number(i);
    }
}
