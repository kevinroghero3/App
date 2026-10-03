package net.time4j.calendar.service;

import androidx.core.text.util.LocalePreferences;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.salesforce.marketingcloud.push.g;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import net.time4j.format.CalendarText;
import net.time4j.format.OutputContext;
import net.time4j.format.TextProvider;
import net.time4j.format.TextWidth;
import net.time4j.i18n.LanguageMatch;
import net.time4j.i18n.PropertyBundle;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class GenericTextProviderSPI implements TextProvider {
    private static final String[] EMPTY_STRINGS = new String[0];
    private static final Set<String> LANGUAGES;
    private static final Set<Locale> LOCALES;
    private static final Set<String> TYPES;

    @Override // net.time4j.format.TextProvider
    public boolean supportsLanguage(Locale locale) {
        return true;
    }

    static {
        String[] strArrSplit = PropertyBundle.load("calendar/names/generic/generic", Locale.ROOT).getString("languages").split(StringUtils.SPACE);
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, strArrSplit);
        hashSet.add("");
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        LANGUAGES = setUnmodifiableSet;
        HashSet hashSet2 = new HashSet();
        for (String str : setUnmodifiableSet) {
            if (str.isEmpty()) {
                hashSet2.add(Locale.ROOT);
            } else {
                hashSet2.add(new Locale(str));
            }
        }
        LOCALES = Collections.unmodifiableSet(hashSet2);
        HashSet hashSet3 = new HashSet();
        hashSet3.add("buddhist");
        hashSet3.add(LocalePreferences.CalendarType.CHINESE);
        hashSet3.add("coptic");
        hashSet3.add(LocalePreferences.CalendarType.DANGI);
        hashSet3.add("ethiopic");
        hashSet3.add("frenchrev");
        hashSet3.add("hindu");
        hashSet3.add("generic");
        hashSet3.add(LocalePreferences.CalendarType.HEBREW);
        hashSet3.add(LocalePreferences.CalendarType.INDIAN);
        hashSet3.add(LocalePreferences.CalendarType.ISLAMIC);
        hashSet3.add("japanese");
        hashSet3.add("juche");
        hashSet3.add(LocalePreferences.CalendarType.PERSIAN);
        hashSet3.add("roc");
        hashSet3.add("vietnam");
        TYPES = Collections.unmodifiableSet(hashSet3);
    }

    @Override // net.time4j.format.TextProvider
    public boolean supportsCalendarType(String str) {
        return TYPES.contains(str);
    }

    @Override // net.time4j.format.TextProvider
    public String[] getSupportedCalendarTypes() {
        Set<String> set = TYPES;
        return (String[]) set.toArray(new String[set.size()]);
    }

    @Override // net.time4j.format.TextProvider
    public Locale[] getAvailableLocales() {
        Set<Locale> set = LOCALES;
        return (Locale[]) set.toArray(new Locale[set.size()]);
    }

    @Override // net.time4j.format.TextProvider
    public String[] months(String str, Locale locale, TextWidth textWidth, OutputContext outputContext, boolean z) {
        String str2 = str;
        TextWidth textWidth2 = textWidth;
        if (str2.equals("roc") || str2.equals("buddhist")) {
            List<String> textForms = CalendarText.getIsoInstance(locale).getStdMonths(textWidth2, outputContext).getTextForms();
            return (String[]) textForms.toArray(new String[textForms.size()]);
        }
        if (str2.equals("japanese")) {
            return new String[]{AppEventsConstants.EVENT_PARAM_VALUE_YES, ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
        }
        if (str2.equals(LocalePreferences.CalendarType.DANGI) || str2.equals("vietnam")) {
            str2 = LocalePreferences.CalendarType.CHINESE;
        } else if (str2.equals("hindu")) {
            str2 = LocalePreferences.CalendarType.INDIAN;
        } else if (str2.equals("juche")) {
            return (String[]) CalendarText.getIsoInstance(locale).getStdMonths(textWidth2, outputContext).getTextForms().toArray(new String[12]);
        }
        String str3 = str2;
        PropertyBundle bundle = getBundle(str3, locale);
        if (textWidth2 == TextWidth.SHORT) {
            textWidth2 = TextWidth.ABBREVIATED;
        }
        TextWidth textWidth3 = textWidth2;
        String[] strArrLookupBundle = lookupBundle(bundle, str3, locale.getLanguage(), countOfMonths(str3), getKey(bundle, "MONTH_OF_YEAR"), textWidth3, outputContext, z, 1);
        if (strArrLookupBundle == null) {
            OutputContext outputContext2 = OutputContext.STANDALONE;
            if (outputContext == outputContext2) {
                if (textWidth3 != TextWidth.NARROW) {
                    strArrLookupBundle = months(str3, locale, textWidth3, OutputContext.FORMAT, z);
                }
            } else if (textWidth3 == TextWidth.ABBREVIATED) {
                strArrLookupBundle = months(str3, locale, TextWidth.WIDE, OutputContext.FORMAT, z);
            } else if (textWidth3 == TextWidth.NARROW) {
                strArrLookupBundle = months(str3, locale, textWidth3, outputContext2, z);
            }
        }
        if (strArrLookupBundle != null) {
            return strArrLookupBundle;
        }
        throw new MissingResourceException("Cannot find calendar month.", GenericTextProviderSPI.class.getName(), locale.toString());
    }

    @Override // net.time4j.format.TextProvider
    public String[] quarters(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
        return EMPTY_STRINGS;
    }

    @Override // net.time4j.format.TextProvider
    public String[] weekdays(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
        return EMPTY_STRINGS;
    }

    @Override // net.time4j.format.TextProvider
    public String[] eras(String str, Locale locale, TextWidth textWidth) {
        TextWidth textWidth2;
        if (str.equals(LocalePreferences.CalendarType.CHINESE) || str.equals("vietnam")) {
            return EMPTY_STRINGS;
        }
        if (str.equals("japanese")) {
            if (textWidth == TextWidth.NARROW) {
                return new String[]{"M", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "H"};
            }
            return new String[]{"Meiji", "Taishō", "Shōwa", "Heisei"};
        }
        if (str.equals(LocalePreferences.CalendarType.DANGI) || str.equals("juche")) {
            String[] strArrEras = eras("korean", locale, textWidth);
            return new String[]{str.equals(LocalePreferences.CalendarType.DANGI) ? strArrEras[0] : strArrEras[1]};
        }
        PropertyBundle bundle = getBundle(str, locale);
        if (textWidth == TextWidth.SHORT) {
            textWidth = TextWidth.ABBREVIATED;
        }
        String[] strArrLookupBundle = lookupBundle(bundle, str, locale.getLanguage(), countOfEras(str), getKey(bundle, "ERA"), textWidth, OutputContext.FORMAT, false, 0);
        if (strArrLookupBundle == null && textWidth != (textWidth2 = TextWidth.ABBREVIATED)) {
            strArrLookupBundle = eras(str, locale, textWidth2);
        }
        if (strArrLookupBundle != null) {
            return strArrLookupBundle;
        }
        throw new MissingResourceException("Cannot find calendar resource for era.", GenericTextProviderSPI.class.getName(), locale.toString());
    }

    @Override // net.time4j.format.TextProvider
    public String[] meridiems(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
        return EMPTY_STRINGS;
    }

    public String toString() {
        return "GenericTextProviderSPI";
    }

    static PropertyBundle getBundle(String str, Locale locale) {
        String str2 = "calendar/names/" + str + RemoteSettings.FORWARD_SLASH_STRING + str;
        if (!LANGUAGES.contains(LanguageMatch.getAlias(locale))) {
            locale = Locale.ROOT;
        }
        return PropertyBundle.load(str2, locale);
    }

    private static String[] lookupBundle(PropertyBundle propertyBundle, String str, String str2, int i, String str3, TextWidth textWidth, OutputContext outputContext, boolean z, int i2) {
        String[] strArr = new String[i];
        boolean z2 = str3.length() == 1;
        for (int i3 = 0; i3 < i; i3++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
            if (z2) {
                char cCharAt = textWidth.name().charAt(0);
                if (outputContext != OutputContext.STANDALONE) {
                    cCharAt = Character.toLowerCase(cCharAt);
                }
                sb.append(cCharAt);
            } else {
                sb.append(textWidth.name());
                if (outputContext == OutputContext.STANDALONE) {
                    sb.append('|');
                    sb.append(outputContext.name());
                }
                if (z) {
                    sb.append('|');
                    sb.append("LEAP");
                }
            }
            sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
            sb.append('_');
            sb.append(i3 + i2);
            if (z && i3 == 6 && str.equals(LocalePreferences.CalendarType.HEBREW)) {
                sb.append('L');
            }
            String string = sb.toString();
            if (!propertyBundle.containsKey(string)) {
                return null;
            }
            String string2 = propertyBundle.getString(string);
            if (z && str.equals(LocalePreferences.CalendarType.CHINESE)) {
                string2 = toLeapForm(string2, str2, textWidth, outputContext);
            }
            strArr[i3] = string2;
        }
        return strArr;
    }

    private static String toLeapForm(String str, String str2, TextWidth textWidth, OutputContext outputContext) {
        if (str2.equals("en")) {
            if (textWidth == TextWidth.NARROW) {
                return "i" + str;
            }
            return "(leap) " + str;
        }
        if (str2.equals("de") || str2.equals("es") || str2.equals("fr") || str2.equals(g.h) || str2.equals("pt") || str2.equals("ro")) {
            if (textWidth == TextWidth.NARROW) {
                return "i" + str;
            }
            return "(i) " + str;
        }
        if (str2.equals("ja")) {
            return "閏" + str;
        }
        if (str2.equals("ko")) {
            return "윤" + str;
        }
        if (str2.equals("zh")) {
            return "閏" + str;
        }
        if (str2.equals("vi")) {
            if (textWidth == TextWidth.NARROW) {
                return str + "n";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(outputContext == OutputContext.STANDALONE ? " Nhuận" : " nhuận");
            return sb.toString();
        }
        return "*" + str;
    }

    private static String getKey(PropertyBundle propertyBundle, String str) {
        return (propertyBundle.containsKey("useShortKeys") && "true".equals(propertyBundle.getString("useShortKeys"))) ? str.substring(0, 1) : str;
    }

    private static ClassLoader getDefaultLoader() {
        return GenericTextProviderSPI.class.getClassLoader();
    }

    private static int countOfMonths(String str) {
        return (str.equals("coptic") || str.equals("ethiopic") || str.equals("generic") || str.equals(LocalePreferences.CalendarType.HEBREW)) ? 13 : 12;
    }

    private static int countOfEras(String str) {
        if (str.equals("hindu")) {
            return 6;
        }
        return (str.equals("ethiopic") || str.equals("generic") || str.equals("roc") || str.equals("buddhist") || str.equals("korean")) ? 2 : 1;
    }
}
