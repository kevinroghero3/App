package org.joda.time.tz;

import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.salesforce.marketingcloud.push.g;
import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import io.sentry.instrumentation.file.SentryFileReader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.TimeZones;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.MutableDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.LenientChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes6.dex */
public class ZoneInfoCompiler {
    static final Map<String, Integer> DOW_LOOKUP;
    static final Map<String, Integer> MONTH_LOOKUP;
    static Chronology cLenientISO;
    static DateTimeOfYear cStartOfYear;
    static final Set<String> RULE_LOOKUP = expand("rule", "r");
    static final Set<String> ZONE_LOOKUP = expand("zone", "z");
    static final Set<String> LINK_LOOKUP = expand("link", "l");
    static final Set<String> MIN_YEAR_LOOKUP = expand("minimum", "mi");
    static final Set<String> MAX_YEAR_LOOKUP = expand("maximum", "ma");
    static final Set<String> ONLY_YEAR_LOOKUP = expand("only", "o");
    private Map<String, RuleSet> iRuleSets = new HashMap();
    private List<Zone> iZones = new ArrayList();
    private List<String> iGoodLinks = new ArrayList();
    private List<String> iBackLinks = new ArrayList();

    static char parseZoneChar(char c) {
        if (c != 'G') {
            if (c != 'S') {
                if (c != 'U' && c != 'Z' && c != 'g') {
                    if (c != 's') {
                        if (c != 'u' && c != 'z') {
                            return 'w';
                        }
                    }
                }
            }
            return 's';
        }
        return 'u';
    }

    static {
        HashMap map = new HashMap();
        MONTH_LOOKUP = map;
        put(expand("january", "ja"), 1, map);
        put(expand("february", "f"), 2, map);
        put(expand("march", "mar"), 3, map);
        put(expand("april", "ap"), 4, map);
        put(expand("may", "may"), 5, map);
        put(expand("june", "jun"), 6, map);
        put(expand("july", "jul"), 7, map);
        put(expand("august", "au"), 8, map);
        put(expand("september", g.k), 9, map);
        put(expand("october", "o"), 10, map);
        put(expand("november", "n"), 11, map);
        put(expand("december", DateTokenConverter.CONVERTER_KEY), 12, map);
        HashMap map2 = new HashMap();
        DOW_LOOKUP = map2;
        put(expand("monday", "m"), 1, map2);
        put(expand("tuesday", "tu"), 2, map2);
        put(expand("wednesday", "w"), 3, map2);
        put(expand("thursday", "th"), 4, map2);
        put(expand("friday", "f"), 5, map2);
        put(expand("saturday", "sa"), 6, map2);
        put(expand("sunday", "su"), 7, map2);
    }

    private static void put(Set<String> set, int i, Map<String, Integer> map) {
        Iterator<String> it2 = set.iterator();
        while (it2.hasNext()) {
            map.put(it2.next(), Integer.valueOf(i));
        }
    }

    private static Set<String> expand(String str, String str2) {
        HashSet hashSet = new HashSet();
        while (!str.equals(str2)) {
            hashSet.add(str);
            str = str.substring(0, str.length() - 1);
        }
        hashSet.add(str);
        return hashSet;
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length == 0) {
            printUsage();
            return;
        }
        int i = 0;
        File file = null;
        int i2 = 0;
        boolean z = false;
        File file2 = null;
        while (i2 < strArr.length) {
            if ("-src".equals(strArr[i2])) {
                i2++;
                if (i2 >= strArr.length) {
                    printUsage();
                    return;
                }
                file2 = new File(strArr[i2]);
            } else if ("-dst".equals(strArr[i2])) {
                i2++;
                if (i2 >= strArr.length) {
                    printUsage();
                    return;
                }
                file = new File(strArr[i2]);
            } else {
                if (!"-verbose".equals(strArr[i2])) {
                    if (!"-?".equals(strArr[i2])) {
                        break;
                    }
                    printUsage();
                    return;
                }
                z = true;
            }
            i2++;
        }
        if (i2 >= strArr.length) {
            printUsage();
            return;
        }
        File[] fileArr = new File[strArr.length - i2];
        while (i2 < strArr.length) {
            fileArr[i] = file2 == null ? new File(strArr[i2]) : new File(file2, strArr[i2]);
            i2++;
            i++;
        }
        ZoneInfoLogger.set(z);
        new ZoneInfoCompiler().compile(file, fileArr);
    }

    private static void printUsage() {
        PrintStream printStream = System.out;
        printStream.println("Usage: java org.joda.time.tz.ZoneInfoCompiler <options> <source files>");
        printStream.println("where possible options include:");
        printStream.println("  -src <directory>    Specify where to read source files");
        printStream.println("  -dst <directory>    Specify where to write generated files");
        printStream.println("  -verbose            Output verbosely (default false)");
    }

    static DateTimeOfYear getStartOfYear() {
        if (cStartOfYear == null) {
            cStartOfYear = new DateTimeOfYear();
        }
        return cStartOfYear;
    }

    static Chronology getLenientISOChronology() {
        if (cLenientISO == null) {
            cLenientISO = LenientChronology.getInstance(ISOChronology.getInstanceUTC());
        }
        return cLenientISO;
    }

    static void writeZoneInfoMap(DataOutputStream dataOutputStream, Map<String, DateTimeZone> map) throws IOException {
        if (dataOutputStream == null) {
            throw new IllegalArgumentException("DataOutputStream must not be null.");
        }
        HashMap map2 = new HashMap(map.size());
        TreeMap treeMap = new TreeMap();
        short s = 0;
        for (Map.Entry<String, DateTimeZone> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!map2.containsKey(key)) {
                Short shValueOf = Short.valueOf(s);
                map2.put(key, shValueOf);
                treeMap.put(shValueOf, key);
                s = (short) (s + 1);
                if (s == Short.MAX_VALUE) {
                    throw new InternalError("Too many time zone ids");
                }
            }
            String id = entry.getValue().getID();
            if (!map2.containsKey(id)) {
                Short shValueOf2 = Short.valueOf(s);
                map2.put(id, shValueOf2);
                treeMap.put(shValueOf2, id);
                s = (short) (s + 1);
                if (s == Short.MAX_VALUE) {
                    throw new InternalError("Too many time zone ids");
                }
            }
        }
        dataOutputStream.writeShort(treeMap.size());
        Iterator it2 = treeMap.values().iterator();
        while (it2.hasNext()) {
            dataOutputStream.writeUTF((String) it2.next());
        }
        dataOutputStream.writeShort(map.size());
        for (Map.Entry<String, DateTimeZone> entry2 : map.entrySet()) {
            dataOutputStream.writeShort(((Short) map2.get(entry2.getKey())).shortValue());
            dataOutputStream.writeShort(((Short) map2.get(entry2.getValue().getID())).shortValue());
        }
    }

    static int parseYear(String str, int i) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if (MIN_YEAR_LOOKUP.contains(lowerCase)) {
            return Integer.MIN_VALUE;
        }
        if (MAX_YEAR_LOOKUP.contains(lowerCase)) {
            return Integer.MAX_VALUE;
        }
        return ONLY_YEAR_LOOKUP.contains(lowerCase) ? i : Integer.parseInt(str);
    }

    static int parseMonth(String str) {
        Integer num = MONTH_LOOKUP.get(str.toLowerCase(Locale.ENGLISH));
        if (num == null) {
            throw new IllegalArgumentException("Unknown month: " + str);
        }
        return num.intValue();
    }

    static int parseDayOfWeek(String str) {
        Integer num = DOW_LOOKUP.get(str.toLowerCase(Locale.ENGLISH));
        if (num == null) {
            throw new IllegalArgumentException("Unknown day-of-week: " + str);
        }
        return num.intValue();
    }

    static String parseOptional(String str) {
        if (str.equals("-")) {
            return null;
        }
        return str;
    }

    static int parseTime(String str) {
        if (str.equals("-")) {
            return 0;
        }
        DateTimeFormatter dateTimeFormatterHourMinuteSecondFraction = ISODateTimeFormat.hourMinuteSecondFraction();
        MutableDateTime mutableDateTime = new MutableDateTime(0L, getLenientISOChronology());
        boolean zStartsWith = str.startsWith("-");
        if (dateTimeFormatterHourMinuteSecondFraction.parseInto(mutableDateTime, str, zStartsWith ? 1 : 0) == (~(zStartsWith ? 1 : 0))) {
            throw new IllegalArgumentException(str);
        }
        int millis = (int) mutableDateTime.getMillis();
        return zStartsWith ? -millis : millis;
    }

    static boolean test(String str, DateTimeZone dateTimeZone) {
        if (!str.equals(dateTimeZone.getID())) {
            return true;
        }
        long j = ISOChronology.getInstanceUTC().year().set(0L, 1850);
        long j2 = ISOChronology.getInstanceUTC().year().set(0L, 2050);
        int offset = dateTimeZone.getOffset(j);
        int standardOffset = dateTimeZone.getStandardOffset(j);
        String nameKey = dateTimeZone.getNameKey(j);
        ArrayList arrayList = new ArrayList();
        while (true) {
            long jNextTransition = dateTimeZone.nextTransition(j);
            if (jNextTransition == j || jNextTransition > j2) {
                break;
            }
            int offset2 = dateTimeZone.getOffset(jNextTransition);
            int standardOffset2 = dateTimeZone.getStandardOffset(jNextTransition);
            String nameKey2 = dateTimeZone.getNameKey(jNextTransition);
            if (offset == offset2 && standardOffset == standardOffset2 && nameKey.equals(nameKey2)) {
                System.out.println("*d* Error in " + dateTimeZone.getID() + StringUtils.SPACE + new DateTime(jNextTransition, ISOChronology.getInstanceUTC()));
                return false;
            }
            if (nameKey2 == null || (nameKey2.length() < 3 && !"??".equals(nameKey2) && !"%z".equals(nameKey2))) {
                System.out.println("*s* Error in " + dateTimeZone.getID() + StringUtils.SPACE + new DateTime(jNextTransition, ISOChronology.getInstanceUTC()) + ", nameKey=" + nameKey2);
                return false;
            }
            arrayList.add(Long.valueOf(jNextTransition));
            nameKey = nameKey2;
            offset = offset2;
            j = jNextTransition;
        }
        long j3 = ISOChronology.getInstanceUTC().year().set(0L, 2050);
        long j4 = ISOChronology.getInstanceUTC().year().set(0L, 1850);
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return true;
            }
            long jPreviousTransition = dateTimeZone.previousTransition(j3);
            if (jPreviousTransition == j3 || jPreviousTransition < j4) {
                return true;
            }
            long jLongValue = ((Long) arrayList.get(size)).longValue() - 1;
            if (jLongValue != jPreviousTransition) {
                System.out.println("*r* Error in " + dateTimeZone.getID() + StringUtils.SPACE + new DateTime(jPreviousTransition, ISOChronology.getInstanceUTC()) + " != " + new DateTime(jLongValue, ISOChronology.getInstanceUTC()));
                return false;
            }
            j3 = jPreviousTransition;
        }
    }

    public Map<String, DateTimeZone> compile(File file, File[] fileArr) throws Throwable {
        BufferedReader bufferedReader;
        if (fileArr != null) {
            for (int i = 0; i < fileArr.length; i++) {
                try {
                    bufferedReader = new BufferedReader(new SentryFileReader(fileArr[i]));
                    try {
                        parseDataFile(bufferedReader, "backward".equals(fileArr[i].getName()));
                        bufferedReader.close();
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            }
        }
        if (file != null) {
            if (!file.exists() && !file.mkdirs()) {
                throw new IOException("Destination directory doesn't exist and cannot be created: " + file);
            }
            if (!file.isDirectory()) {
                throw new IOException("Destination is not a directory: " + file);
            }
        }
        TreeMap treeMap = new TreeMap();
        TreeMap treeMap2 = new TreeMap();
        System.out.println("Writing zoneinfo files");
        for (int i2 = 0; i2 < this.iZones.size(); i2++) {
            Zone zone = this.iZones.get(i2);
            DateTimeZoneBuilder dateTimeZoneBuilder = new DateTimeZoneBuilder();
            zone.addToBuilder(dateTimeZoneBuilder, this.iRuleSets);
            DateTimeZone dateTimeZone = dateTimeZoneBuilder.toDateTimeZone(zone.iName, true);
            if (test(dateTimeZone.getID(), dateTimeZone)) {
                treeMap.put(dateTimeZone.getID(), dateTimeZone);
                treeMap2.put(dateTimeZone.getID(), zone);
                if (file != null) {
                    writeZone(file, dateTimeZoneBuilder, dateTimeZone);
                }
            }
        }
        for (int i3 = 0; i3 < this.iGoodLinks.size(); i3 += 2) {
            String str = this.iGoodLinks.get(i3);
            String str2 = this.iGoodLinks.get(i3 + 1);
            Zone zone2 = (Zone) treeMap2.get(str);
            if (zone2 == null) {
                System.out.println("Cannot find source zone '" + str + "' to link alias '" + str2 + "' to");
            } else {
                DateTimeZoneBuilder dateTimeZoneBuilder2 = new DateTimeZoneBuilder();
                zone2.addToBuilder(dateTimeZoneBuilder2, this.iRuleSets);
                DateTimeZone dateTimeZone2 = dateTimeZoneBuilder2.toDateTimeZone(str2, true);
                if (test(dateTimeZone2.getID(), dateTimeZone2)) {
                    treeMap.put(dateTimeZone2.getID(), dateTimeZone2);
                    if (file != null) {
                        writeZone(file, dateTimeZoneBuilder2, dateTimeZone2);
                    }
                }
                treeMap.put(dateTimeZone2.getID(), dateTimeZone2);
                if (ZoneInfoLogger.verbose()) {
                    System.out.println("Good link: " + str2 + " -> " + str + " revived");
                }
            }
        }
        for (int i4 = 0; i4 < 2; i4++) {
            for (int i5 = 0; i5 < this.iBackLinks.size(); i5 += 2) {
                String str3 = this.iBackLinks.get(i5);
                String str4 = this.iBackLinks.get(i5 + 1);
                DateTimeZone dateTimeZone3 = (DateTimeZone) treeMap.get(str3);
                if (dateTimeZone3 != null) {
                    treeMap.put(str4, dateTimeZone3);
                    if (ZoneInfoLogger.verbose()) {
                        System.out.println("Back link: " + str4 + " -> " + dateTimeZone3.getID());
                    }
                } else if (i4 > 0) {
                    System.out.println("Cannot find time zone '" + str3 + "' to link alias '" + str4 + "' to");
                }
            }
        }
        if (file != null) {
            System.out.println("Writing ZoneInfoMap");
            File file2 = new File(file, "ZoneInfoMap");
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            DataOutputStream dataOutputStream = new DataOutputStream(SentryFileOutputStream.Factory.create(new FileOutputStream(file2), file2));
            try {
                TreeMap treeMap3 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                treeMap3.putAll(treeMap);
                writeZoneInfoMap(dataOutputStream, treeMap3);
            } finally {
                dataOutputStream.close();
            }
        }
        return treeMap;
    }

    private void writeZone(File file, DateTimeZoneBuilder dateTimeZoneBuilder, DateTimeZone dateTimeZone) throws IOException {
        if (ZoneInfoLogger.verbose()) {
            System.out.println("Writing " + dateTimeZone.getID());
        }
        File file2 = new File(file, dateTimeZone.getID());
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file2), file2);
        try {
            dateTimeZoneBuilder.writeTo(dateTimeZone.getID(), fileOutputStreamCreate);
            fileOutputStreamCreate.close();
            FileInputStream fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(file2), file2);
            DateTimeZone from = DateTimeZoneBuilder.readFrom(fileInputStreamCreate, dateTimeZone.getID());
            fileInputStreamCreate.close();
            if (dateTimeZone.equals(from)) {
                return;
            }
            System.out.println("*e* Error in " + dateTimeZone.getID() + ": Didn't read properly from file");
        } catch (Throwable th) {
            fileOutputStreamCreate.close();
            throw th;
        }
    }

    public void parseDataFile(BufferedReader bufferedReader, boolean z) throws IOException {
        while (true) {
            Zone zone = null;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    if (zone != null) {
                        this.iZones.add(zone);
                        return;
                    }
                    return;
                }
                String strTrim = line.trim();
                if (strTrim.length() != 0 && strTrim.charAt(0) != '#') {
                    int iIndexOf = line.indexOf(35);
                    if (iIndexOf >= 0) {
                        line = line.substring(0, iIndexOf);
                    }
                    StringTokenizer stringTokenizer = new StringTokenizer(line, " \f\r\t\u000b");
                    if (!Character.isWhitespace(line.charAt(0)) || !stringTokenizer.hasMoreTokens()) {
                        if (zone != null) {
                            this.iZones.add(zone);
                        }
                        if (!stringTokenizer.hasMoreTokens()) {
                            break;
                        }
                        String lowerCase = stringTokenizer.nextToken().toLowerCase(Locale.ENGLISH);
                        if (RULE_LOOKUP.contains(lowerCase)) {
                            Rule rule = new Rule(stringTokenizer);
                            RuleSet ruleSet = this.iRuleSets.get(rule.iName);
                            if (ruleSet == null) {
                                this.iRuleSets.put(rule.iName, new RuleSet(rule));
                                break;
                            } else {
                                ruleSet.addRule(rule);
                                break;
                            }
                        }
                        if (ZONE_LOOKUP.contains(lowerCase)) {
                            if (stringTokenizer.countTokens() < 4) {
                                throw new IllegalArgumentException("Attempting to create a Zone from an incomplete tokenizer");
                            }
                            zone = new Zone(stringTokenizer);
                        } else {
                            if (LINK_LOOKUP.contains(lowerCase)) {
                                String strNextToken = stringTokenizer.nextToken();
                                String strNextToken2 = stringTokenizer.nextToken();
                                if (strNextToken2.equals("WET") || strNextToken2.equals("CET") || strNextToken2.equals("EET")) {
                                    this.iGoodLinks.add(strNextToken);
                                    this.iGoodLinks.add(strNextToken2);
                                    break;
                                }
                                if (strNextToken2.equals("MET")) {
                                    this.iBackLinks.add("CET");
                                    this.iBackLinks.add(strNextToken2);
                                    break;
                                } else if (z || strNextToken2.equals("US/Pacific-New") || strNextToken2.startsWith("Etc/") || strNextToken2.equals(TimeZones.GMT_ID)) {
                                    this.iBackLinks.add(strNextToken);
                                    this.iBackLinks.add(strNextToken2);
                                    break;
                                } else {
                                    this.iGoodLinks.add(strNextToken);
                                    this.iGoodLinks.add(strNextToken2);
                                    break;
                                }
                            }
                            System.out.println("Unknown line: " + line);
                            break;
                        }
                    } else if (zone != null) {
                        zone.chain(stringTokenizer);
                    }
                }
            }
        }
    }

    static class DateTimeOfYear {
        public final boolean iAdvanceDayOfWeek;
        public final int iDayOfMonth;
        public final int iDayOfWeek;
        public final int iMillisOfDay;
        public final int iMonthOfYear;
        public final char iZoneChar;

        DateTimeOfYear() {
            this.iMonthOfYear = 1;
            this.iDayOfMonth = 1;
            this.iDayOfWeek = 0;
            this.iAdvanceDayOfWeek = false;
            this.iMillisOfDay = 0;
            this.iZoneChar = 'w';
        }

        DateTimeOfYear(StringTokenizer stringTokenizer) {
            int i;
            int dayOfWeek;
            int i2;
            boolean z;
            int i3;
            boolean z2;
            int time;
            LocalDate localDatePlusDays;
            int dayOfMonth = 1;
            int i4 = 0;
            boolean z3 = false;
            int i5 = 0;
            char zoneChar = 'w';
            if (stringTokenizer.hasMoreTokens()) {
                int month = ZoneInfoCompiler.parseMonth(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    String strNextToken = stringTokenizer.nextToken();
                    if (strNextToken.toLowerCase(Locale.ENGLISH).startsWith("last")) {
                        z = false;
                        dayOfWeek = ZoneInfoCompiler.parseDayOfWeek(strNextToken.substring(4));
                        i2 = -1;
                    } else {
                        try {
                            i2 = Integer.parseInt(strNextToken);
                            dayOfWeek = 0;
                            z = false;
                        } catch (NumberFormatException unused) {
                            int iIndexOf = strNextToken.indexOf(">=");
                            if (iIndexOf > 0) {
                                int i6 = Integer.parseInt(strNextToken.substring(iIndexOf + 2));
                                dayOfWeek = ZoneInfoCompiler.parseDayOfWeek(strNextToken.substring(0, iIndexOf));
                                i2 = i6;
                                z = true;
                            } else {
                                int iIndexOf2 = strNextToken.indexOf("<=");
                                if (iIndexOf2 > 0) {
                                    int i7 = Integer.parseInt(strNextToken.substring(iIndexOf2 + 2));
                                    dayOfWeek = ZoneInfoCompiler.parseDayOfWeek(strNextToken.substring(0, iIndexOf2));
                                    i2 = i7;
                                    z = false;
                                } else {
                                    throw new IllegalArgumentException(strNextToken);
                                }
                            }
                        }
                    }
                    if (stringTokenizer.hasMoreTokens()) {
                        String strNextToken2 = stringTokenizer.nextToken();
                        zoneChar = ZoneInfoCompiler.parseZoneChar(strNextToken2.charAt(strNextToken2.length() - 1));
                        if (!strNextToken2.equals("24:00")) {
                            time = ZoneInfoCompiler.parseTime(strNextToken2);
                        } else if (month == 12 && i2 == 31) {
                            time = ZoneInfoCompiler.parseTime("23:59:59.999");
                        } else {
                            if (i2 == -1) {
                                localDatePlusDays = new LocalDate(2001, month, 1).plusMonths(1);
                            } else {
                                localDatePlusDays = new LocalDate(2001, month, i2).plusDays(1);
                            }
                            boolean z4 = (i2 == -1 || dayOfWeek == 0) ? false : true;
                            int monthOfYear = localDatePlusDays.getMonthOfYear();
                            dayOfMonth = localDatePlusDays.getDayOfMonth();
                            dayOfWeek = dayOfWeek != 0 ? (dayOfWeek % 7) + 1 : dayOfWeek;
                            dayOfMonth = monthOfYear;
                            z2 = z4;
                            i3 = 0;
                        }
                        i5 = time;
                        dayOfMonth = month;
                        i3 = i5;
                        dayOfMonth = i2;
                        z2 = z;
                    } else {
                        dayOfMonth = month;
                        i3 = i5;
                        dayOfMonth = i2;
                        z2 = z;
                    }
                    zoneChar = zoneChar;
                    i = i3;
                    z3 = z2;
                    i4 = dayOfWeek;
                } else {
                    dayOfMonth = month;
                }
                this.iMonthOfYear = dayOfMonth;
                this.iDayOfMonth = dayOfMonth;
                this.iDayOfWeek = i4;
                this.iAdvanceDayOfWeek = z3;
                this.iMillisOfDay = i;
                this.iZoneChar = zoneChar;
            }
            i = i4;
            this.iMonthOfYear = dayOfMonth;
            this.iDayOfMonth = dayOfMonth;
            this.iDayOfWeek = i4;
            this.iAdvanceDayOfWeek = z3;
            this.iMillisOfDay = i;
            this.iZoneChar = zoneChar;
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, String str, int i, int i2, int i3) {
            dateTimeZoneBuilder.addRecurringSavings(str, i, i2, i3, this.iZoneChar, this.iMonthOfYear, this.iDayOfMonth, this.iDayOfWeek, this.iAdvanceDayOfWeek, this.iMillisOfDay);
        }

        public void addCutover(DateTimeZoneBuilder dateTimeZoneBuilder, int i) {
            dateTimeZoneBuilder.addCutover(i, this.iZoneChar, this.iMonthOfYear, this.iDayOfMonth, this.iDayOfWeek, this.iAdvanceDayOfWeek, this.iMillisOfDay);
        }

        public String toString() {
            return "MonthOfYear: " + this.iMonthOfYear + "\nDayOfMonth: " + this.iDayOfMonth + "\nDayOfWeek: " + this.iDayOfWeek + "\nAdvanceDayOfWeek: " + this.iAdvanceDayOfWeek + "\nMillisOfDay: " + this.iMillisOfDay + "\nZoneChar: " + this.iZoneChar + "\n";
        }
    }

    static class Rule {
        public final DateTimeOfYear iDateTimeOfYear;
        public final int iFromYear;
        public final String iLetterS;
        public final String iName;
        public final int iSaveMillis;
        public final int iToYear;
        public final String iType;

        Rule(StringTokenizer stringTokenizer) {
            if (stringTokenizer.countTokens() < 6) {
                throw new IllegalArgumentException("Attempting to create a Rule from an incomplete tokenizer");
            }
            this.iName = stringTokenizer.nextToken().intern();
            int year = ZoneInfoCompiler.parseYear(stringTokenizer.nextToken(), 0);
            this.iFromYear = year;
            int year2 = ZoneInfoCompiler.parseYear(stringTokenizer.nextToken(), year);
            this.iToYear = year2;
            if (year2 < year) {
                throw new IllegalArgumentException();
            }
            this.iType = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
            this.iDateTimeOfYear = new DateTimeOfYear(stringTokenizer);
            this.iSaveMillis = ZoneInfoCompiler.parseTime(stringTokenizer.nextToken());
            this.iLetterS = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
        }

        Rule(Rule rule) {
            this.iName = rule.iName;
            this.iFromYear = 1800;
            this.iToYear = rule.iFromYear;
            this.iType = null;
            this.iDateTimeOfYear = rule.iDateTimeOfYear;
            this.iSaveMillis = 0;
            this.iLetterS = rule.iLetterS;
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, int i, int i2, String str) {
            int i3 = this.iSaveMillis + (-i2);
            this.iDateTimeOfYear.addRecurring(dateTimeZoneBuilder, formatName(str, i, i3, this.iLetterS), i3, this.iFromYear, this.iToYear);
        }

        static String formatName(String str, int i, int i2, String str2) {
            int iIndexOf = str.indexOf(47);
            if (iIndexOf > 0) {
                if (i2 == 0) {
                    return str.substring(0, iIndexOf).intern();
                }
                return str.substring(iIndexOf + 1).intern();
            }
            int iIndexOf2 = str.indexOf("%s");
            if (iIndexOf2 >= 0) {
                String strSubstring = str.substring(0, iIndexOf2);
                String strSubstring2 = str.substring(iIndexOf2 + 2);
                StringBuilder sb = new StringBuilder();
                sb.append(strSubstring);
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(str2);
                sb.append(strSubstring2);
                return sb.toString().intern();
            }
            if (!str.equals("%z")) {
                return str;
            }
            if (i2 == 0) {
                return formatOffset(i).intern();
            }
            return formatOffset(i + i2).intern();
        }

        private static String formatOffset(int i) {
            String str = i < 0 ? "-" : Marker.ANY_NON_NULL_MARKER;
            int iAbs = Math.abs(i) / 1000;
            int i2 = iAbs / DateTimeConstants.SECONDS_PER_HOUR;
            int i3 = (iAbs / 60) % 60;
            int i4 = iAbs % 60;
            if (i4 != 0) {
                return str + twoDigitString(i2) + twoDigitString(i3) + twoDigitString(i4);
            }
            if (i3 == 0) {
                return str + twoDigitString(i2);
            }
            return str + twoDigitString(i2) + twoDigitString(i3);
        }

        private static String twoDigitString(int i) {
            return Integer.toString(i + 100).substring(1);
        }

        public String toString() {
            return "[Rule]\nName: " + this.iName + "\nFromYear: " + this.iFromYear + "\nToYear: " + this.iToYear + "\nType: " + this.iType + "\n" + this.iDateTimeOfYear + "SaveMillis: " + this.iSaveMillis + "\nLetterS: " + this.iLetterS + "\n";
        }
    }

    static class RuleSet {
        private List<Rule> iRules;

        RuleSet(Rule rule) {
            ArrayList arrayList = new ArrayList();
            this.iRules = arrayList;
            arrayList.add(rule);
        }

        void addRule(Rule rule) {
            if (!rule.iName.equals(this.iRules.get(0).iName)) {
                throw new IllegalArgumentException("Rule name mismatch");
            }
            this.iRules.add(rule);
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, int i, String str) {
            int iMin = 0;
            for (int i2 = 0; i2 < this.iRules.size(); i2++) {
                int i3 = this.iRules.get(i2).iSaveMillis;
                if (i3 < 0) {
                    iMin = Math.min(iMin, i3);
                }
            }
            if (iMin < 0) {
                if (ZoneInfoLogger.verbose()) {
                    System.out.println("Fixed negative save values for rule '" + this.iRules.get(0).iName + "'");
                }
                i += iMin;
                int iIndexOf = str.indexOf(RemoteSettings.FORWARD_SLASH_STRING);
                if (iIndexOf > 0) {
                    str = str.substring(iIndexOf + 1) + RemoteSettings.FORWARD_SLASH_STRING + str.substring(0, iIndexOf);
                }
            }
            dateTimeZoneBuilder.setStandardOffset(i);
            if (iMin < 0) {
                new Rule(this.iRules.get(0)).addRecurring(dateTimeZoneBuilder, i, iMin, str);
            }
            for (int i4 = 0; i4 < this.iRules.size(); i4++) {
                this.iRules.get(i4).addRecurring(dateTimeZoneBuilder, i, iMin, str);
            }
        }
    }

    static class Zone {
        public final String iFormat;
        public final String iName;
        private Zone iNext;
        public final int iOffsetMillis;
        public final String iRules;
        public final DateTimeOfYear iUntilDateTimeOfYear;
        public final int iUntilYear;

        Zone(StringTokenizer stringTokenizer) {
            this(stringTokenizer.nextToken(), stringTokenizer);
        }

        private Zone(String str, StringTokenizer stringTokenizer) {
            int i;
            this.iName = str.intern();
            this.iOffsetMillis = ZoneInfoCompiler.parseTime(stringTokenizer.nextToken());
            this.iRules = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
            this.iFormat = stringTokenizer.nextToken().intern();
            DateTimeOfYear startOfYear = ZoneInfoCompiler.getStartOfYear();
            if (stringTokenizer.hasMoreTokens()) {
                i = Integer.parseInt(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    startOfYear = new DateTimeOfYear(stringTokenizer);
                }
            } else {
                i = Integer.MAX_VALUE;
            }
            this.iUntilYear = i;
            this.iUntilDateTimeOfYear = startOfYear;
        }

        void chain(StringTokenizer stringTokenizer) {
            Zone zone = this.iNext;
            if (zone != null) {
                zone.chain(stringTokenizer);
            } else {
                this.iNext = new Zone(this.iName, stringTokenizer);
            }
        }

        public void addToBuilder(DateTimeZoneBuilder dateTimeZoneBuilder, Map<String, RuleSet> map) {
            addToBuilder(this, dateTimeZoneBuilder, map);
        }

        private static void addToBuilder(Zone zone, DateTimeZoneBuilder dateTimeZoneBuilder, Map<String, RuleSet> map) {
            while (zone != null) {
                String str = zone.iRules;
                if (str == null) {
                    String name = Rule.formatName(zone.iFormat, zone.iOffsetMillis, 0, null);
                    dateTimeZoneBuilder.setStandardOffset(zone.iOffsetMillis);
                    dateTimeZoneBuilder.setFixedSavings(name, 0);
                } else {
                    try {
                        int time = ZoneInfoCompiler.parseTime(str);
                        String name2 = Rule.formatName(zone.iFormat, zone.iOffsetMillis, time, null);
                        dateTimeZoneBuilder.setStandardOffset(zone.iOffsetMillis);
                        dateTimeZoneBuilder.setFixedSavings(name2, time);
                    } catch (Exception unused) {
                        RuleSet ruleSet = map.get(zone.iRules);
                        if (ruleSet == null) {
                            throw new IllegalArgumentException("Rules not found: " + zone.iRules);
                        }
                        ruleSet.addRecurring(dateTimeZoneBuilder, zone.iOffsetMillis, zone.iFormat);
                    }
                }
                int i = zone.iUntilYear;
                if (i == Integer.MAX_VALUE) {
                    return;
                }
                zone.iUntilDateTimeOfYear.addCutover(dateTimeZoneBuilder, i);
                zone = zone.iNext;
            }
        }

        public String toString() {
            String str = "[Zone]\nName: " + this.iName + "\nOffsetMillis: " + this.iOffsetMillis + "\nRules: " + this.iRules + "\nFormat: " + this.iFormat + "\nUntilYear: " + this.iUntilYear + "\n" + this.iUntilDateTimeOfYear;
            if (this.iNext == null) {
                return str;
            }
            return str + "...\n" + this.iNext.toString();
        }
    }
}
