package net.time4j;

import android.os.Process;
import ch.qos.logback.core.CoreConstants;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.Chronology;
import net.time4j.engine.ElementRule;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.OutputContext;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;

/* JADX INFO: loaded from: classes3.dex */
public final class DayPeriod {
    private static final AttributeKey<DayPeriod> CUSTOM;
    private static DayPeriod FALLBACK;
    private static final SortedMap<PlainTime, String> STD_RULES;
    private final transient String calendarType;
    private final transient SortedMap<PlainTime, String> codeMap;
    private final transient Locale locale;

    static {
        TreeMap treeMap = new TreeMap();
        treeMap.put(PlainTime.midnightAtStartOfDay(), "am");
        treeMap.put(PlainTime.of(12), "pm");
        SortedMap<PlainTime, String> sortedMapUnmodifiableSortedMap = Collections.unmodifiableSortedMap(treeMap);
        STD_RULES = sortedMapUnmodifiableSortedMap;
        FALLBACK = new DayPeriod(Locale.ROOT, CalendarText.ISO_CALENDAR_TYPE, sortedMapUnmodifiableSortedMap);
        CUSTOM = Attributes.createKey("CUSTOM_DAY_PERIOD", DayPeriod.class);
    }

    private DayPeriod(Locale locale, String str, SortedMap<PlainTime, String> sortedMap) {
        this.locale = locale;
        this.calendarType = str;
        this.codeMap = Collections.unmodifiableSortedMap(sortedMap);
    }

    public static DayPeriod of(Locale locale) {
        return of(locale, CalendarText.ISO_CALENDAR_TYPE);
    }

    public static DayPeriod of(Map<PlainTime, String> map) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Label map is empty.");
        }
        TreeMap treeMap = new TreeMap(map);
        for (PlainTime plainTime : map.keySet()) {
            if (plainTime.getHour() == 24) {
                treeMap.put(PlainTime.midnightAtStartOfDay(), map.get(plainTime));
                treeMap.remove(plainTime);
            } else if (map.get(plainTime).isEmpty()) {
                throw new IllegalArgumentException("Map has empty label: " + map);
            }
        }
        return new DayPeriod(null, "", treeMap);
    }

    public ChronoFunction<ChronoDisplay, String> fixed() {
        return fixed(TextWidth.WIDE, OutputContext.FORMAT);
    }

    public ChronoFunction<ChronoDisplay, String> fixed(TextWidth textWidth, OutputContext outputContext) {
        return new PeriodName(true, textWidth, outputContext);
    }

    public ChronoFunction<ChronoDisplay, String> approximate() {
        return approximate(TextWidth.WIDE, OutputContext.FORMAT);
    }

    public ChronoFunction<ChronoDisplay, String> approximate(TextWidth textWidth, OutputContext outputContext) {
        return new PeriodName(false, textWidth, outputContext);
    }

    public PlainTime getStart(PlainTime plainTime) {
        if (plainTime.getHour() == 24) {
            plainTime = PlainTime.midnightAtStartOfDay();
        }
        PlainTime plainTimeLastKey = this.codeMap.lastKey();
        for (PlainTime plainTime2 : this.codeMap.keySet()) {
            if (plainTime.isSimultaneous(plainTime2)) {
                return plainTime2;
            }
            if (plainTime.isBefore(plainTime2)) {
                break;
            }
            plainTimeLastKey = plainTime2;
        }
        return plainTimeLastKey;
    }

    public PlainTime getEnd(PlainTime plainTime) {
        if (plainTime.getHour() == 24) {
            plainTime = PlainTime.midnightAtStartOfDay();
        }
        for (PlainTime plainTime2 : this.codeMap.keySet()) {
            if (plainTime.isBefore(plainTime2)) {
                return plainTime2;
            }
        }
        return this.codeMap.firstKey();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DayPeriod)) {
            return false;
        }
        DayPeriod dayPeriod = (DayPeriod) obj;
        Locale locale = this.locale;
        if (locale == null) {
            if (dayPeriod.locale != null) {
                return false;
            }
        } else if (!locale.equals(dayPeriod.locale)) {
            return false;
        }
        return this.codeMap.equals(dayPeriod.codeMap) && this.calendarType.equals(dayPeriod.calendarType);
    }

    public int hashCode() {
        return this.codeMap.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("DayPeriod[");
        if (isPredefined()) {
            sb.append("locale=");
            sb.append(this.locale);
            sb.append(CoreConstants.COMMA_CHAR);
            if (!this.calendarType.equals(CalendarText.ISO_CALENDAR_TYPE)) {
                sb.append(",calendar-type=");
                sb.append(this.calendarType);
                sb.append(CoreConstants.COMMA_CHAR);
            }
        }
        sb.append(this.codeMap);
        sb.append(']');
        return sb.toString();
    }

    static DayPeriod of(Locale locale, String str) {
        String language = locale.getLanguage();
        if (language.equals("nn")) {
            locale = new Locale("nb");
        }
        Map<String, String> mapLoadTextForms = loadTextForms(locale, str);
        TreeMap treeMap = new TreeMap();
        for (String str2 : mapLoadTextForms.keySet()) {
            if (accept(str2)) {
                int i = Integer.parseInt(str2.substring(1, 3));
                int i2 = Integer.parseInt(str2.substring(3, 5));
                PlainTime plainTimeMidnightAtStartOfDay = PlainTime.midnightAtStartOfDay();
                if (i == 24) {
                    if (i2 != 0) {
                        throw new IllegalStateException("Invalid time key: " + str2);
                    }
                } else {
                    if (i < 0 || i >= 24 || i2 < 0 || i2 >= 60) {
                        throw new IllegalStateException("Invalid time key: " + str2);
                    }
                    plainTimeMidnightAtStartOfDay = plainTimeMidnightAtStartOfDay.plus((i * 60) + i2, ClockUnit.MINUTES);
                }
                treeMap.put(plainTimeMidnightAtStartOfDay, mapLoadTextForms.get(str2));
            }
        }
        if (treeMap.isEmpty() || language.isEmpty()) {
            return FALLBACK;
        }
        Iterator it2 = treeMap.keySet().iterator();
        String str3 = "";
        while (it2.hasNext()) {
            String str4 = (String) treeMap.get((PlainTime) it2.next());
            if (str4.equals(str3)) {
                it2.remove();
            } else {
                str3 = str4;
            }
        }
        return new DayPeriod(locale, str, treeMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPredefined() {
        return this.locale != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFixedCode(PlainTime plainTime) {
        int iIntValue = ((Integer) plainTime.get(PlainTime.MINUTE_OF_DAY)).intValue();
        if (iIntValue == 0 || iIntValue == 1440) {
            return "midnight";
        }
        if (iIntValue < 720) {
            return "am";
        }
        if (iIntValue == 720) {
            return "noon";
        }
        return "pm";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String createKey(Map<String, String> map, TextWidth textWidth, OutputContext outputContext, String str) {
        if (textWidth == TextWidth.SHORT) {
            textWidth = TextWidth.ABBREVIATED;
        }
        String str2 = toPrefix(textWidth, outputContext) + str;
        if (map.containsKey(str2)) {
            return str2;
        }
        if (outputContext == OutputContext.STANDALONE) {
            TextWidth textWidth2 = TextWidth.ABBREVIATED;
            if (textWidth == textWidth2) {
                return createKey(map, textWidth, OutputContext.FORMAT, str);
            }
            return createKey(map, textWidth2, outputContext, str);
        }
        TextWidth textWidth3 = TextWidth.ABBREVIATED;
        return textWidth != textWidth3 ? createKey(map, textWidth3, outputContext, str) : str2;
    }

    /* JADX INFO: renamed from: net.time4j.DayPeriod$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$TextWidth;

        static {
            int[] iArr = new int[TextWidth.values().length];
            $SwitchMap$net$time4j$format$TextWidth = iArr;
            try {
                iArr[TextWidth.WIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$format$TextWidth[TextWidth.NARROW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static String toPrefix(TextWidth textWidth, OutputContext outputContext) {
        char upperCase;
        int i = AnonymousClass1.$SwitchMap$net$time4j$format$TextWidth[textWidth.ordinal()];
        if (i != 1) {
            upperCase = i != 2 ? 'a' : 'n';
        } else {
            upperCase = 'w';
        }
        if (outputContext == OutputContext.STANDALONE) {
            upperCase = Character.toUpperCase(upperCase);
        }
        return "P(" + upperCase + ")_";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> loadTextForms(Locale locale, String str) {
        Map<String, String> textForms = CalendarText.getInstance(str, locale).getTextForms();
        return (str.equals(CalendarText.ISO_CALENDAR_TYPE) || "true".equals(textForms.get("hasDayPeriods"))) ? textForms : CalendarText.getIsoInstance(locale).getTextForms();
    }

    private static boolean accept(String str) {
        return str.charAt(0) == 'T' && str.length() == 5 && Character.isDigit(str.charAt(1));
    }

    public static class Extension implements ChronoExtension {
        public static int onCustomAction;
        public static int onPlayFromUri;

        Extension() {
        }

        @Override // net.time4j.engine.ChronoExtension
        public boolean accept(Class<?> cls) {
            return PlainTime.class.isAssignableFrom(cls);
        }

        @Override // net.time4j.engine.ChronoExtension
        public Set<ChronoElement<?>> getElements(Locale locale, AttributeQuery attributeQuery) {
            DayPeriod dayPeriodFrom = from(locale, attributeQuery);
            HashSet hashSet = new HashSet();
            hashSet.add(new Element(false, dayPeriodFrom));
            if (!attributeQuery.contains(DayPeriod.CUSTOM)) {
                hashSet.add(new Element(true, dayPeriodFrom));
            }
            return Collections.unmodifiableSet(hashSet);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0072  */
        /* JADX WARN: Code duplicated, block: B:31:0x0084  */
        /* JADX WARN: Code duplicated, block: B:33:0x009a  */
        /* JADX WARN: Code duplicated, block: B:35:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:45:0x00cb  */
        /* JADX WARN: Code duplicated, block: B:46:0x00ce  */
        /* JADX WARN: Code duplicated, block: B:48:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:49:0x00db A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:50:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:52:0x00e3  */
        /* JADX WARN: Code duplicated, block: B:53:0x00e6  */
        /* JADX WARN: Code duplicated, block: B:54:0x00e9  */
        /* JADX WARN: Code duplicated, block: B:56:0x00ec  */
        /* JADX WARN: Code duplicated, block: B:71:0x0116 A[PHI: r6
  0x0116: PHI (r6v12 net.time4j.Meridiem) = 
  (r6v11 net.time4j.Meridiem)
  (r6v11 net.time4j.Meridiem)
  (r6v17 net.time4j.Meridiem)
  (r6v18 net.time4j.Meridiem)
  (r6v19 net.time4j.Meridiem)
  (r6v20 net.time4j.Meridiem)
 binds: [B:56:0x00ec, B:57:0x00ee, B:69:0x0111, B:68:0x010e, B:64:0x0101, B:63:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:93:0x0117 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:94:0x0117 A[SYNTHETIC] */
        @Override // net.time4j.engine.ChronoExtension
        public ChronoEntity<?> resolve(ChronoEntity<?> chronoEntity, Locale locale, AttributeQuery attributeQuery) {
            ChronoEntity chronoEntityWith;
            String strSubstring;
            int hour12;
            PlainTime end;
            Meridiem meridiem;
            Meridiem meridiem2;
            if (chronoEntity.contains(PlainTime.COMPONENT) || chronoEntity.contains(PlainTime.HOUR_FROM_0_TO_24) || chronoEntity.contains(PlainTime.DIGITAL_HOUR_OF_DAY) || chronoEntity.contains(PlainTime.CLOCK_HOUR_OF_DAY)) {
                return chronoEntity;
            }
            DayPeriod dayPeriodFrom = from(locale, attributeQuery);
            int i = 0;
            Element element = new Element(false, dayPeriodFrom);
            int i2 = 1;
            if (chronoEntity.contains(element)) {
                String str = (String) chronoEntity.get(element);
                int i3 = 0;
                Meridiem meridiem3 = null;
                while (true) {
                    int iIndexOf = str.indexOf(124, i);
                    if (iIndexOf == -1) {
                        strSubstring = str.substring(i);
                    } else {
                        strSubstring = str.substring(i, iIndexOf);
                    }
                    int i4 = iIndexOf + 1;
                    i3 += i2;
                    if (!dayPeriodFrom.isPredefined() || meridiem3 != null) {
                        for (PlainTime plainTime : dayPeriodFrom.codeMap.keySet()) {
                            if (((String) dayPeriodFrom.codeMap.get(plainTime)).equals(strSubstring)) {
                                hour12 = getHour12(chronoEntity);
                                end = dayPeriodFrom.getEnd(plainTime);
                                if (plainTime.getHour() >= 12) {
                                    if (!end.isAfter(plainTime) || end.isSimultaneous(PlainTime.midnightAtStartOfDay())) {
                                        meridiem = Meridiem.PM;
                                    } else if (hour12 != -1) {
                                        meridiem = hour12 + 12 >= plainTime.getHour() ? Meridiem.PM : Meridiem.AM;
                                    } else {
                                        meridiem = null;
                                    }
                                } else if (!end.isAfter(PlainTime.of(12))) {
                                    meridiem = Meridiem.AM;
                                } else if (hour12 != -1) {
                                    meridiem = null;
                                } else if (hour12 >= plainTime.getHour()) {
                                    meridiem = Meridiem.AM;
                                } else {
                                    meridiem = Meridiem.PM;
                                }
                                if (meridiem == null) {
                                    if (meridiem3 != null || meridiem3 == meridiem) {
                                        meridiem3 = meridiem;
                                    } else {
                                        if (hour12 != -1) {
                                            if (strSubstring.startsWith("night")) {
                                                meridiem = hour12 < 6 ? Meridiem.AM : Meridiem.PM;
                                            } else if (strSubstring.startsWith("afternoon")) {
                                                meridiem = hour12 < 6 ? Meridiem.PM : Meridiem.AM;
                                            }
                                            meridiem3 = meridiem;
                                        }
                                        meridiem3 = null;
                                    }
                                }
                            }
                        }
                    } else {
                        if (strSubstring.equals("midnight")) {
                            meridiem2 = Meridiem.AM;
                        } else if (!strSubstring.equals("noon")) {
                            while (r12.hasNext()) {
                                if (((String) dayPeriodFrom.codeMap.get(plainTime)).equals(strSubstring)) {
                                    hour12 = getHour12(chronoEntity);
                                    end = dayPeriodFrom.getEnd(plainTime);
                                    if (plainTime.getHour() >= 12) {
                                        if (end.isAfter(plainTime)) {
                                            meridiem = Meridiem.PM;
                                        } else {
                                            meridiem = Meridiem.PM;
                                        }
                                    } else if (!end.isAfter(PlainTime.of(12))) {
                                        meridiem = Meridiem.AM;
                                    } else if (hour12 != -1) {
                                        meridiem = null;
                                    } else if (hour12 >= plainTime.getHour()) {
                                        meridiem = Meridiem.AM;
                                    } else {
                                        meridiem = Meridiem.PM;
                                    }
                                    if (meridiem == null) {
                                        if (meridiem3 != null) {
                                            meridiem3 = meridiem;
                                        } else {
                                            meridiem3 = meridiem;
                                        }
                                    }
                                }
                            }
                        } else {
                            meridiem2 = Meridiem.PM;
                        }
                        meridiem3 = meridiem2;
                    }
                    if (i4 <= 0) {
                        break;
                    }
                    i = i4;
                    i2 = 1;
                }
                if (meridiem3 == null) {
                    return chronoEntity;
                }
                ChronoEntity<?> chronoEntityWith2 = chronoEntity.with(PlainTime.AM_PM_OF_DAY, meridiem3);
                return i3 > 1 ? chronoEntityWith2.with(element, (Object) null) : chronoEntityWith2;
            }
            Element element2 = new Element(true, dayPeriodFrom);
            if (!chronoEntity.contains(element2)) {
                return chronoEntity;
            }
            String str2 = (String) chronoEntity.get(element2);
            if (str2.equals("am") || str2.equals("midnight")) {
                chronoEntityWith = chronoEntity.with(PlainTime.AM_PM_OF_DAY, Meridiem.AM);
            } else {
                chronoEntityWith = chronoEntity.with(PlainTime.AM_PM_OF_DAY, Meridiem.PM);
            }
            return chronoEntityWith.with(element2, (Object) null);
        }

        @Override // net.time4j.engine.ChronoExtension
        public boolean canResolve(ChronoElement<?> chronoElement) {
            return chronoElement instanceof Element;
        }

        private static int getHour12(ChronoEntity<?> chronoEntity) {
            AdjustableElement<Integer, PlainTime> adjustableElement = PlainTime.CLOCK_HOUR_OF_AMPM;
            if (chronoEntity.contains(adjustableElement)) {
                int iIntValue = ((Integer) chronoEntity.get(adjustableElement)).intValue();
                if (iIntValue == 12) {
                    return 0;
                }
                return iIntValue;
            }
            ProportionalElement<Integer, PlainTime> proportionalElement = PlainTime.DIGITAL_HOUR_OF_AMPM;
            if (chronoEntity.contains(proportionalElement)) {
                return ((Integer) chronoEntity.get(proportionalElement)).intValue();
            }
            return -1;
        }

        private static DayPeriod from(Locale locale, AttributeQuery attributeQuery) {
            if (attributeQuery.contains(DayPeriod.CUSTOM)) {
                return (DayPeriod) attributeQuery.get(DayPeriod.CUSTOM);
            }
            return DayPeriod.of(locale, (String) attributeQuery.get(Attributes.CALENDAR_TYPE, CalendarText.ISO_CALENDAR_TYPE));
        }

        public static int postOrRun() {
            int i = onCustomAction;
            int i2 = i % 7281125;
            onCustomAction = i + 1;
            if (i2 != 0) {
                return onPlayFromUri;
            }
            int iMyPid = Process.myPid();
            onPlayFromUri = iMyPid;
            return iMyPid;
        }
    }

    static class Element extends BasicElement<String> implements TextElement<String>, ElementRule<ChronoEntity<?>, String> {
        private static final long serialVersionUID = 5589976208326940032L;
        private final transient DayPeriod dayPeriod;
        private final transient boolean fixed;

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(ChronoEntity<?> chronoEntity) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(ChronoEntity<?> chronoEntity) {
            return null;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isDateElement() {
            return false;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isTimeElement() {
            return true;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: avoid collision after fix types in other method */
        public boolean isValid2(ChronoEntity<?> chronoEntity, String str) {
            return false;
        }

        Element(boolean z, Locale locale, String str) {
            this(z, DayPeriod.of(locale, str));
        }

        Element(boolean z, DayPeriod dayPeriod) {
            super(z ? "FIXED_DAY_PERIOD" : "APPROXIMATE_DAY_PERIOD");
            this.fixed = z;
            this.dayPeriod = dayPeriod;
        }

        @Override // net.time4j.engine.ChronoElement
        public Class<String> getType() {
            return String.class;
        }

        @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
        public char getSymbol() {
            return this.fixed ? 'b' : 'B';
        }

        @Override // net.time4j.engine.ChronoElement
        public String getDefaultMinimum() {
            if (!this.fixed) {
                return (String) this.dayPeriod.codeMap.get((PlainTime) this.dayPeriod.codeMap.firstKey());
            }
            return "am";
        }

        @Override // net.time4j.engine.ChronoElement
        public String getDefaultMaximum() {
            if (!this.fixed) {
                return (String) this.dayPeriod.codeMap.get((PlainTime) this.dayPeriod.codeMap.lastKey());
            }
            return "pm";
        }

        @Override // net.time4j.engine.BasicElement
        public String toString() {
            StringBuilder sb = new StringBuilder(32);
            sb.append(name());
            sb.append('@');
            sb.append(this.dayPeriod);
            return sb.toString();
        }

        @Override // net.time4j.engine.BasicElement
        public <T extends ChronoEntity<T>> ElementRule<T, String> derive(Chronology<T> chronology) {
            if (chronology.isRegistered(PlainTime.COMPONENT)) {
                return this;
            }
            return null;
        }

        @Override // net.time4j.engine.BasicElement
        public boolean doEquals(BasicElement<?> basicElement) {
            return this.dayPeriod.equals(((Element) basicElement).dayPeriod);
        }

        @Override // net.time4j.engine.ElementRule
        public String getValue(ChronoEntity<?> chronoEntity) {
            String str;
            PlainTime plainTime = (PlainTime) chronoEntity.get(PlainTime.COMPONENT);
            if (this.fixed) {
                return DayPeriod.getFixedCode(plainTime);
            }
            if (this.dayPeriod.isPredefined()) {
                Map mapLoadTextForms = DayPeriod.loadTextForms(getLocale(), getCalendarType());
                if (plainTime.isMidnight()) {
                    str = "midnight";
                } else {
                    str = plainTime.isSimultaneous(PlainTime.of(12)) ? "noon" : null;
                }
                if (str != null && mapLoadTextForms.containsKey(DayPeriod.createKey(mapLoadTextForms, TextWidth.ABBREVIATED, OutputContext.FORMAT, str))) {
                    return str;
                }
            }
            return (String) this.dayPeriod.codeMap.get(this.dayPeriod.getStart(plainTime));
        }

        @Override // net.time4j.engine.ElementRule
        public String getMinimum(ChronoEntity<?> chronoEntity) {
            return getDefaultMinimum();
        }

        @Override // net.time4j.engine.ElementRule
        public String getMaximum(ChronoEntity<?> chronoEntity) {
            return getDefaultMaximum();
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: avoid collision after fix types in other method */
        public ChronoEntity<?> withValue2(ChronoEntity<?> chronoEntity, String str, boolean z) {
            throw new IllegalArgumentException("Day period element cannot be set.");
        }

        boolean isFixed() {
            return this.fixed;
        }

        Locale getLocale() {
            return this.dayPeriod.locale;
        }

        String getCalendarType() {
            return this.dayPeriod.calendarType;
        }

        Object getCodeMap() {
            return this.dayPeriod.codeMap;
        }

        private Object writeReplace() {
            return new SPX(this, 7);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("Serialization proxy required.");
        }

        @Override // net.time4j.format.TextElement
        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            String strApply;
            TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
            OutputContext outputContext = (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT);
            if (this.fixed) {
                strApply = this.dayPeriod.fixed(textWidth, outputContext).apply(chronoDisplay);
            } else {
                strApply = this.dayPeriod.approximate(textWidth, outputContext).apply(chronoDisplay);
            }
            appendable.append(strApply);
        }

        @Override // net.time4j.format.TextElement
        public String parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            int index = parsePosition.getIndex();
            AttributeKey<OutputContext> attributeKey = Attributes.OUTPUT_CONTEXT;
            OutputContext outputContext = OutputContext.FORMAT;
            OutputContext outputContext2 = (OutputContext) attributeQuery.get(attributeKey, outputContext);
            String str = parse(charSequence, parsePosition, attributeQuery, outputContext2);
            if (str != null || !((Boolean) attributeQuery.get(Attributes.PARSE_MULTIPLE_CONTEXT, Boolean.TRUE)).booleanValue()) {
                return str;
            }
            parsePosition.setErrorIndex(-1);
            parsePosition.setIndex(index);
            if (outputContext2 == outputContext) {
                outputContext = OutputContext.STANDALONE;
            }
            return parse(charSequence, parsePosition, attributeQuery, outputContext);
        }

        /* JADX WARN: Code duplicated, block: B:64:0x0150 A[PHI: r3
  0x0150: PHI (r3v7 int) = (r3v4 int), (r3v3 int) binds: [B:63:0x014e, B:56:0x012f] A[DONT_GENERATE, DONT_INLINE]] */
        private String parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery, OutputContext outputContext) {
            String str;
            Map map;
            String str2;
            String str3;
            boolean zCompareIgnoreCase;
            String strCreateKey;
            ArrayList arrayList = new ArrayList();
            String str4 = "noon";
            String str5 = "midnight";
            if (this.fixed) {
                arrayList.add("am");
                arrayList.add("pm");
                arrayList.add("midnight");
                arrayList.add("noon");
            } else {
                arrayList.addAll(new LinkedHashSet(this.dayPeriod.codeMap.values()));
                if (this.dayPeriod.isPredefined()) {
                    arrayList.add("midnight");
                    arrayList.add("noon");
                }
            }
            Map mapLoadTextForms = this.dayPeriod.isPredefined() ? DayPeriod.loadTextForms(getLocale(), getCalendarType()) : null;
            TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
            boolean zBooleanValue = ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue();
            boolean zBooleanValue2 = ((Boolean) attributeQuery.get(Attributes.PARSE_PARTIAL_COMPARE, Boolean.FALSE)).booleanValue();
            int index = parsePosition.getIndex();
            int length = charSequence.length();
            Iterator it2 = arrayList.iterator();
            String str6 = null;
            int i = 0;
            while (it2.hasNext()) {
                Iterator it3 = it2;
                String str7 = (String) it2.next();
                if (this.dayPeriod.isPredefined()) {
                    if (this.fixed) {
                        strCreateKey = DayPeriod.createKey(mapLoadTextForms, textWidth, outputContext, str7);
                        if (!mapLoadTextForms.containsKey(strCreateKey)) {
                            if (str7.equals(str5)) {
                                strCreateKey = DayPeriod.createKey(mapLoadTextForms, textWidth, outputContext, "am");
                            } else if (str7.equals(str4)) {
                                strCreateKey = DayPeriod.createKey(mapLoadTextForms, textWidth, outputContext, "pm");
                            }
                        }
                    } else {
                        strCreateKey = DayPeriod.createKey(mapLoadTextForms, textWidth, outputContext, str7);
                    }
                    str = mapLoadTextForms.containsKey(strCreateKey) ? (String) mapLoadTextForms.get(strCreateKey) : null;
                } else {
                    str = str7;
                }
                if (str != null) {
                    int length2 = str.length();
                    map = mapLoadTextForms;
                    int i2 = index;
                    int i3 = 0;
                    boolean z = true;
                    while (z && i3 < length2) {
                        String str8 = str4;
                        int i4 = index + i3;
                        if (i4 >= length) {
                            z = false;
                        } else {
                            char cCharAt = charSequence.charAt(i4);
                            char cCharAt2 = str.charAt(i3);
                            if (zBooleanValue) {
                                zCompareIgnoreCase = compareIgnoreCase(cCharAt, cCharAt2);
                            } else {
                                zCompareIgnoreCase = cCharAt == cCharAt2;
                            }
                            if (zCompareIgnoreCase) {
                                i2++;
                            }
                            z = zCompareIgnoreCase;
                        }
                        i3++;
                        str4 = str8;
                        str5 = str5;
                    }
                    str2 = str4;
                    str3 = str5;
                    if (zBooleanValue2 || length2 == 1) {
                        length2 = i2 - index;
                        if (i < length2) {
                            i = length2;
                            str6 = str7;
                        } else if (str6 != null && i == length2) {
                            if (this.fixed) {
                                str6 = null;
                            } else {
                                str6 = str6 + "|" + str7;
                            }
                        }
                    } else if (z) {
                        if (str6 == null) {
                            i = length2;
                            str6 = str7;
                        } else if (this.fixed) {
                            i = length2;
                            str6 = null;
                        } else {
                            str6 = str6 + "|" + str7;
                            i = length2;
                        }
                    }
                } else {
                    map = mapLoadTextForms;
                    str2 = str4;
                    str3 = str5;
                }
                mapLoadTextForms = map;
                it2 = it3;
                str4 = str2;
                str5 = str3;
            }
            if (str6 == null) {
                parsePosition.setErrorIndex(index);
            } else {
                parsePosition.setIndex(index + i);
            }
            return str6;
        }

        private boolean compareIgnoreCase(char c, char c2) {
            if (c >= 'a' && c <= 'z') {
                c = (char) (c - ' ');
            }
            if (c2 >= 'a' && c2 <= 'z') {
                c2 = (char) (c2 - ' ');
            }
            if (c >= 'A' && c <= 'Z') {
                return c == c2;
            }
            Locale locale = getLocale();
            return String.valueOf(c).toUpperCase(locale).equals(String.valueOf(c2).toUpperCase(locale));
        }
    }

    class PeriodName implements ChronoFunction<ChronoDisplay, String> {
        private final boolean fixed;
        private final OutputContext outputContext;
        private final TextWidth width;

        PeriodName(boolean z, TextWidth textWidth, OutputContext outputContext) {
            if (textWidth == null) {
                throw new NullPointerException("Missing text width.");
            }
            if (outputContext == null) {
                throw new NullPointerException("Missing output context.");
            }
            this.fixed = z;
            this.width = textWidth;
            this.outputContext = outputContext;
        }

        @Override // net.time4j.engine.ChronoFunction
        public String apply(ChronoDisplay chronoDisplay) {
            PlainTime plainTime = (PlainTime) chronoDisplay.get(PlainTime.COMPONENT);
            DayPeriod dayPeriod = DayPeriod.this;
            Locale locale = dayPeriod.locale;
            if (this.fixed) {
                String fixedCode = DayPeriod.getFixedCode(plainTime);
                if (!dayPeriod.isPredefined()) {
                    return fixedCode;
                }
                Map mapLoadTextForms = DayPeriod.loadTextForms(locale, dayPeriod.calendarType);
                String strCreateKey = DayPeriod.createKey(mapLoadTextForms, this.width, this.outputContext, fixedCode);
                if (!mapLoadTextForms.containsKey(strCreateKey)) {
                    if (fixedCode.equals("midnight")) {
                        strCreateKey = DayPeriod.createKey(mapLoadTextForms, this.width, this.outputContext, "am");
                    } else if (fixedCode.equals("noon")) {
                        strCreateKey = DayPeriod.createKey(mapLoadTextForms, this.width, this.outputContext, "pm");
                    }
                }
                if (mapLoadTextForms.containsKey(strCreateKey)) {
                    return (String) mapLoadTextForms.get(strCreateKey);
                }
            } else if (dayPeriod.isPredefined()) {
                Map mapLoadTextForms2 = DayPeriod.loadTextForms(locale, dayPeriod.calendarType);
                if (plainTime.isMidnight()) {
                    String strCreateKey2 = DayPeriod.createKey(mapLoadTextForms2, this.width, this.outputContext, "midnight");
                    if (mapLoadTextForms2.containsKey(strCreateKey2)) {
                        return (String) mapLoadTextForms2.get(strCreateKey2);
                    }
                } else if (plainTime.isSimultaneous(PlainTime.of(12))) {
                    String strCreateKey3 = DayPeriod.createKey(mapLoadTextForms2, this.width, this.outputContext, "noon");
                    if (mapLoadTextForms2.containsKey(strCreateKey3)) {
                        return (String) mapLoadTextForms2.get(strCreateKey3);
                    }
                }
                String strCreateKey4 = DayPeriod.createKey(mapLoadTextForms2, this.width, this.outputContext, (String) dayPeriod.codeMap.get(dayPeriod.getStart(plainTime)));
                if (mapLoadTextForms2.containsKey(strCreateKey4)) {
                    return (String) mapLoadTextForms2.get(strCreateKey4);
                }
            } else {
                return (String) dayPeriod.codeMap.get(dayPeriod.getStart(plainTime));
            }
            Meridiem meridiem = (Meridiem) plainTime.get(PlainTime.AM_PM_OF_DAY);
            if (locale == null) {
                locale = Locale.ROOT;
            }
            return meridiem.getDisplayName(locale);
        }
    }
}
