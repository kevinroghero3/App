package net.time4j.format.expert;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.transistorsoft.locationmanager.geofence.TSGeofenceManager;
import com.yalantis.ucrop.UCrop;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.io.encoding.Base64;
import net.time4j.AdjustableElement;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.Weekmodel;
import net.time4j.engine.BridgeChronology;
import net.time4j.engine.CalendarVariant;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.Chronology;
import net.time4j.engine.EpochDays;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.DisplayMode;
import net.time4j.format.NumberSystem;
import net.time4j.format.OutputContext;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.DualFormatElement;
import net.time4j.history.ChronoHistory;

/* JADX INFO: loaded from: classes3.dex */
public enum PatternType {
    CLDR,
    SIMPLE_DATE_FORMAT,
    CLDR_24,
    CLDR_DATE,
    DYNAMIC;

    private static int capitalized(int i) {
        return (i < 65 || i > 90) ? i - 32 : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T cast(Object obj) {
        return obj;
    }

    private static boolean isGeneralSymbol(char c) {
        if (c == 'L' || c == 'M' || c == 'U' || c == 'W' || c == 'g' || c == 'r' || c == 'w' || c == 'y') {
            return true;
        }
        switch (c) {
            case 'D':
            case UCrop.REQUEST_CROP /* 69 */:
            case CoreConstants.OOS_RESET_FREQUENCY /* 70 */:
            case 'G':
                return true;
            default:
                switch (c) {
                    case 'c':
                    case 'd':
                    case 'e':
                        return true;
                    default:
                        return false;
                }
        }
    }

    Map<ChronoElement<?>, ChronoElement<?>> registerSymbol(ChronoFormatter.Builder<?> builder, Locale locale, char c, int i) {
        Chronology<?> effectiveChronology = getEffectiveChronology(builder);
        int i2 = AnonymousClass1.$SwitchMap$net$time4j$format$expert$PatternType[ordinal()];
        if (i2 == 1) {
            return cldr(builder, locale, c, i);
        }
        if (i2 == 2) {
            return sdf(builder, effectiveChronology, locale, c, i);
        }
        if (i2 == 3) {
            return cldr24(builder, locale, c, i);
        }
        if (i2 != 4) {
            if (i2 == 5) {
                return dynamic(builder, c, i, locale);
            }
            throw new UnsupportedOperationException(name());
        }
        Class<?> chronoType = effectiveChronology.getChronoType();
        if (Calendrical.class.isAssignableFrom(chronoType) || CalendarVariant.class.isAssignableFrom(chronoType)) {
            return general(builder, effectiveChronology, c, i, locale);
        }
        throw new IllegalArgumentException("No calendar chronology.");
    }

    /* JADX INFO: renamed from: net.time4j.format.expert.PatternType$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$expert$PatternType;

        static {
            int[] iArr = new int[PatternType.values().length];
            $SwitchMap$net$time4j$format$expert$PatternType = iArr;
            try {
                iArr[PatternType.CLDR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$format$expert$PatternType[PatternType.SIMPLE_DATE_FORMAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$format$expert$PatternType[PatternType.CLDR_24.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$time4j$format$expert$PatternType[PatternType.CLDR_DATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$time4j$format$expert$PatternType[PatternType.DYNAMIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static boolean isISO(Chronology<?> chronology) {
        return getCalendarType(chronology).equals(CalendarText.ISO_CALENDAR_TYPE);
    }

    private static String getCalendarType(Chronology<?> chronology) {
        CalendarType calendarType = (CalendarType) chronology.getChronoType().getAnnotation(CalendarType.class);
        return calendarType == null ? CalendarText.ISO_CALENDAR_TYPE : calendarType.value();
    }

    private static ChronoElement<Integer> findEthiopianHour(Chronology<?> chronology) {
        Iterator<ChronoExtension> it2 = chronology.getExtensions().iterator();
        while (it2.hasNext()) {
            for (ChronoElement<?> chronoElement : it2.next().getElements(Locale.ROOT, Attributes.empty())) {
                if (chronoElement.name().equals("ETHIOPIAN_HOUR")) {
                    return (ChronoElement) cast(chronoElement);
                }
            }
        }
        return null;
    }

    private static Chronology<?> getEffectiveChronology(ChronoFormatter.Builder<?> builder) {
        Chronology<?> chronology = builder.getChronology();
        while (chronology instanceof BridgeChronology) {
            chronology = chronology.preparser();
        }
        return chronology;
    }

    private Map<ChronoElement<?>, ChronoElement<?>> cldr(ChronoFormatter.Builder<?> builder, Locale locale, char c, int i) {
        Chronology<?> effectiveChronology = getEffectiveChronology(builder);
        if (isGeneralSymbol(c) && !isISO(effectiveChronology)) {
            return general(builder, effectiveChronology, c, i, locale);
        }
        if (c == 'h' && getCalendarType(effectiveChronology).equals("ethiopic")) {
            ChronoElement<Integer> chronoElementFindEthiopianHour = findEthiopianHour(effectiveChronology);
            if (chronoElementFindEthiopianHour == null) {
                throw new IllegalArgumentException("Ethiopian time not available.");
            }
            addNumber(chronoElementFindEthiopianHour, c, builder, i, false);
            return Collections.emptyMap();
        }
        return cldrISO(builder, effectiveChronology, locale, c, i, false);
    }

    private Map<ChronoElement<?>, ChronoElement<?>> cldrISO(ChronoFormatter.Builder<?> builder, Chronology<?> chronology, Locale locale, char c, int i, boolean z) {
        TextWidth textWidth;
        TextWidth textWidth2;
        switch (c) {
            case 'A':
                builder.addInteger(PlainTime.MILLI_OF_DAY, i, 8);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                builder.startSection(Attributes.TEXT_WIDTH, getPeriodWidth(i));
                builder.addDayPeriodApproximate();
                builder.endSection();
                break;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 'I':
            case 'J':
            case 'N':
            case 'P':
            case 'R':
            case 'T':
            case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
            case '[':
            case '\\':
            case ']':
            case '^':
            case '_':
            case '`':
            case 'f':
            case 'i':
            case b.l /* 106 */:
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
            case b.f39n /* 110 */:
            case b.f40o /* 111 */:
            case 'p':
            case 't':
            case 'v':
            default:
                throw new IllegalArgumentException("Unsupported pattern symbol: " + c);
            case 'D':
                if (i < 3) {
                    builder.addInteger(PlainDate.DAY_OF_YEAR, i, 3);
                } else {
                    if (i != 3 && !z) {
                        throw new IllegalArgumentException("Too many pattern letters (D): " + i);
                    }
                    builder.addFixedInteger(PlainDate.DAY_OF_YEAR, i);
                }
                break;
            case UCrop.REQUEST_CROP /* 69 */:
                if (i <= 3) {
                    textWidth = TextWidth.ABBREVIATED;
                } else if (i == 4 || z) {
                    textWidth = TextWidth.WIDE;
                } else if (i == 5) {
                    textWidth = TextWidth.NARROW;
                } else {
                    if (i != 6) {
                        throw new IllegalArgumentException("Too many pattern letters (E): " + i);
                    }
                    textWidth = TextWidth.SHORT;
                }
                builder.startSection(Attributes.TEXT_WIDTH, textWidth);
                builder.addText(PlainDate.DAY_OF_WEEK);
                builder.endSection();
                break;
            case CoreConstants.OOS_RESET_FREQUENCY /* 70 */:
                if (i != 1 && !z) {
                    throw new IllegalArgumentException("Too many pattern letters (F): " + i);
                }
                builder.addFixedInteger(PlainDate.WEEKDAY_IN_MONTH, i);
                break;
                break;
            case 'G':
                if (i <= 3) {
                    textWidth2 = TextWidth.ABBREVIATED;
                } else if (i == 4 || z) {
                    textWidth2 = TextWidth.WIDE;
                } else {
                    if (i != 5) {
                        throw new IllegalArgumentException("Too many pattern letters (G): " + i);
                    }
                    textWidth2 = TextWidth.NARROW;
                }
                builder.startSection(Attributes.TEXT_WIDTH, textWidth2);
                ChronoHistory chronoHistoryOf = ChronoHistory.of(locale);
                builder.addText((TextElement<?>) TextElement.class.cast(chronoHistoryOf.era()));
                builder.endSection();
                HashMap map = new HashMap();
                map.put(PlainDate.YEAR, chronoHistoryOf.yearOfEra());
                map.put(PlainDate.MONTH_OF_YEAR, chronoHistoryOf.month());
                map.put(PlainDate.MONTH_AS_NUMBER, chronoHistoryOf.month());
                map.put(PlainDate.DAY_OF_MONTH, chronoHistoryOf.dayOfMonth());
                map.put(PlainDate.DAY_OF_YEAR, chronoHistoryOf.dayOfYear());
                return map;
            case SyslogConstants.LOG_CRON /* 72 */:
                addNumber(PlainTime.DIGITAL_HOUR_OF_DAY, c, builder, i, z);
                break;
            case 'K':
                addNumber(PlainTime.DIGITAL_HOUR_OF_AMPM, c, builder, i, z);
                break;
            case Base64.mimeLineLength /* 76 */:
                builder.startSection(Attributes.OUTPUT_CONTEXT, OutputContext.STANDALONE);
                addMonth(builder, Math.min(i, z ? 4 : i));
                builder.endSection();
                break;
            case 'M':
                addMonth(builder, Math.min(i, z ? 4 : i));
                break;
            case 'O':
                if (i == 1) {
                    builder.addShortLocalizedOffset();
                } else {
                    if (i != 4) {
                        throw new IllegalArgumentException("Count of pattern letters is not 1 or 4: " + i);
                    }
                    builder.addLongLocalizedOffset();
                }
                break;
            case 'Q':
                addQuarterOfYear(builder, i);
                break;
            case 'S':
                builder.addFraction(PlainTime.NANO_OF_SECOND, i, i, false);
                break;
            case 'V':
                if (i != 2) {
                    throw new IllegalArgumentException("Count of pattern letters is not 2: " + i);
                }
                try {
                    builder.addTimezoneID();
                } catch (IllegalStateException e) {
                    throw new IllegalArgumentException(e.getMessage());
                }
                break;
                break;
            case 'W':
                if (i != 1) {
                    throw new IllegalArgumentException("Too many pattern letters (W): " + i);
                }
                builder.addFixedInteger(Weekmodel.of(locale).weekOfMonth(), 1);
                break;
                break;
            case SyslogConstants.LOG_FTP /* 88 */:
                addOffset(builder, c, i, true);
                break;
            case 'Y':
                if (i == 2) {
                    builder.addTwoDigitYear(PlainDate.YEAR_OF_WEEKDATE);
                } else {
                    builder.addYear(PlainDate.YEAR_OF_WEEKDATE, i, false);
                }
                break;
            case 'Z':
                if (i < 4) {
                    builder.addTimezoneOffset(DisplayMode.LONG, false, Collections.singletonList("+0000"));
                } else if (i == 4) {
                    builder.addLongLocalizedOffset();
                } else {
                    if (i != 5) {
                        throw new IllegalArgumentException("Too many pattern letters (Z): " + i);
                    }
                    builder.addTimezoneOffset(DisplayMode.LONG, true, Collections.singletonList("Z"));
                }
                break;
            case TSGeofenceManager.MAX_GEOFENCES /* 97 */:
                builder.startSection(Attributes.TEXT_WIDTH, z ? TextWidth.ABBREVIATED : getPeriodWidth(i));
                builder.addText(PlainTime.AM_PM_OF_DAY);
                builder.endSection();
                if (getCalendarType(chronology).equals("ethiopic")) {
                    ChronoElement<Integer> chronoElementFindEthiopianHour = findEthiopianHour(chronology);
                    if (chronoElementFindEthiopianHour == null) {
                        throw new IllegalArgumentException("Ethiopian time not available.");
                    }
                    HashMap map2 = new HashMap();
                    map2.put(chronoElementFindEthiopianHour, PlainTime.CLOCK_HOUR_OF_AMPM);
                    return map2;
                }
                break;
            case 'b':
                builder.startSection(Attributes.TEXT_WIDTH, getPeriodWidth(i));
                builder.addDayPeriodFixed();
                builder.endSection();
                break;
            case 'c':
                if (i == 2) {
                    throw new IllegalArgumentException("Invalid pattern count of 2 for symbol 'c'.");
                }
                builder.startSection(Attributes.OUTPUT_CONTEXT, OutputContext.STANDALONE);
                if (i == 1) {
                    builder.addFixedNumerical(Weekmodel.of(locale).localDayOfWeek(), 1);
                } else {
                    cldrISO(builder, chronology, locale, 'E', i, z);
                }
                builder.endSection();
                break;
                break;
            case 'd':
                addNumber(PlainDate.DAY_OF_MONTH, c, builder, i, z);
                break;
            case 'e':
                if (i <= 2) {
                    builder.addFixedNumerical(Weekmodel.of(locale).localDayOfWeek(), i);
                } else {
                    cldrISO(builder, chronology, locale, 'E', i, z);
                }
                break;
            case b.i /* 103 */:
                builder.addLongNumber(EpochDays.MODIFIED_JULIAN_DATE, i, 18, SignPolicy.SHOW_WHEN_NEGATIVE);
                break;
            case 'h':
                addNumber(PlainTime.CLOCK_HOUR_OF_AMPM, c, builder, i, z);
                break;
            case 'k':
                addNumber(PlainTime.CLOCK_HOUR_OF_DAY, c, builder, i, z);
                break;
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                addNumber(PlainTime.MINUTE_OF_HOUR, c, builder, i, z);
                break;
            case 'q':
                builder.startSection(Attributes.OUTPUT_CONTEXT, OutputContext.STANDALONE);
                addQuarterOfYear(builder, i);
                builder.endSection();
                break;
            case 'r':
                builder.startSection(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
                builder.startSection(Attributes.ZERO_DIGIT, '0');
                builder.addYear(PlainDate.YEAR, i, true);
                builder.endSection();
                builder.endSection();
                break;
            case 's':
                addNumber(PlainTime.SECOND_OF_MINUTE, c, builder, i, z);
                break;
            case 'u':
                builder.addYear(PlainDate.YEAR, i, true);
                break;
            case 'w':
                if (i > 2) {
                    throw new IllegalArgumentException("Too many pattern letters (w): " + i);
                }
                AdjustableElement<Integer, PlainDate> adjustableElementWeekOfYear = Weekmodel.of(locale).weekOfYear();
                for (ChronoElement<?> chronoElement : chronology.getRegisteredElements()) {
                    if (chronoElement.getSymbol() == c) {
                        Weekmodel weekmodel = Weekmodel.ISO;
                        if (chronoElement.equals(weekmodel.weekOfYear())) {
                            adjustableElementWeekOfYear = weekmodel.weekOfYear();
                            addNumber(adjustableElementWeekOfYear, c, builder, i, z);
                            break;
                        }
                    }
                }
                addNumber(adjustableElementWeekOfYear, c, builder, i, z);
                break;
                break;
            case SyslogConstants.LOG_CLOCK /* 120 */:
                addOffset(builder, c, i, false);
                break;
            case 'y':
                if (i == 2) {
                    builder.addTwoDigitYear(PlainDate.YEAR);
                } else {
                    builder.addYear(PlainDate.YEAR, i, false);
                }
                break;
            case 'z':
                try {
                    if (i < 4) {
                        builder.addShortTimezoneName();
                    } else {
                        if (i != 4 && !z) {
                            throw new IllegalArgumentException("Too many pattern letters (z): " + i);
                        }
                        builder.addLongTimezoneName();
                    }
                } catch (IllegalStateException e2) {
                    throw new IllegalArgumentException(e2.getMessage());
                }
                break;
        }
        return Collections.emptyMap();
    }

    private static TextWidth getPeriodWidth(int i) {
        if (i <= 3) {
            return TextWidth.ABBREVIATED;
        }
        if (i == 4) {
            return TextWidth.WIDE;
        }
        if (i == 5) {
            return TextWidth.NARROW;
        }
        throw new IllegalArgumentException("Too many pattern letters: " + i);
    }

    private Map<ChronoElement<?>, ChronoElement<?>> sdf(ChronoFormatter.Builder<?> builder, Chronology<?> chronology, Locale locale, char c, int i) {
        if (c != 'B' && c != 'O' && c != 'Q') {
            if (c == 'S') {
                builder.addFixedInteger(PlainTime.MILLI_OF_SECOND, i);
            } else if (c == 'Z') {
                addOffset(builder, c, 2, false);
            } else if (c != 'e' && c != 'g') {
                if (c == 'u') {
                    builder.addFixedNumerical(PlainDate.DAY_OF_WEEK, i);
                } else if (c != 'x' && c != 'b' && c != 'c' && c != 'q' && c != 'r') {
                    switch (c) {
                        case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
                        case 'V':
                            break;
                        case 'W':
                            builder.addFixedInteger(Weekmodel.of(locale).boundedWeekOfMonth(), i);
                            break;
                        case SyslogConstants.LOG_FTP /* 88 */:
                            if (i >= 4) {
                                throw new IllegalArgumentException("Too many pattern letters (X): " + i);
                            }
                            return cldrISO(builder, chronology, locale, 'X', i, true);
                        default:
                            return cldrISO(builder, chronology, locale, c, i, true);
                    }
                }
            }
            return Collections.emptyMap();
        }
        throw new IllegalArgumentException("CLDR pattern symbol not supported in SimpleDateFormat-style: " + c);
    }

    private Map<ChronoElement<?>, ChronoElement<?>> cldr24(ChronoFormatter.Builder<?> builder, Locale locale, char c, int i) {
        if (c == 'H') {
            addNumber(PlainTime.HOUR_FROM_0_TO_24, c, builder, i, false);
            return Collections.emptyMap();
        }
        return cldr(builder, locale, c, i);
    }

    private static void addOffset(ChronoFormatter.Builder<?> builder, char c, int i, boolean z) {
        if (i == 1) {
            builder.addTimezoneOffset(DisplayMode.SHORT, false, Collections.singletonList(z ? "Z" : "+00"));
            return;
        }
        if (i == 2) {
            builder.addTimezoneOffset(DisplayMode.MEDIUM, false, Collections.singletonList(z ? "Z" : "+0000"));
            return;
        }
        if (i == 3) {
            builder.addTimezoneOffset(DisplayMode.MEDIUM, true, Collections.singletonList(z ? "Z" : "+00:00"));
            return;
        }
        if (i == 4) {
            builder.addTimezoneOffset(DisplayMode.LONG, false, Collections.singletonList(z ? "Z" : "+0000"));
            return;
        }
        if (i == 5) {
            builder.addTimezoneOffset(DisplayMode.LONG, true, Collections.singletonList(z ? "Z" : "+00:00"));
            return;
        }
        throw new IllegalArgumentException("Too many pattern letters (" + c + "): " + i);
    }

    private static void addNumber(ChronoElement<Integer> chronoElement, char c, ChronoFormatter.Builder<?> builder, int i, boolean z) {
        if (i == 1) {
            builder.addInteger(chronoElement, 1, 2);
            return;
        }
        if (i == 2 || z) {
            builder.addFixedInteger(chronoElement, i);
            return;
        }
        throw new IllegalArgumentException("Too many pattern letters (" + c + "): " + i);
    }

    private static void addMonth(ChronoFormatter.Builder<?> builder, int i) {
        if (i == 1) {
            builder.addInteger(PlainDate.MONTH_AS_NUMBER, 1, 2);
            return;
        }
        if (i == 2) {
            builder.addFixedInteger(PlainDate.MONTH_AS_NUMBER, 2);
            return;
        }
        if (i == 3) {
            builder.startSection(Attributes.TEXT_WIDTH, TextWidth.ABBREVIATED);
            builder.addText(PlainDate.MONTH_OF_YEAR);
            builder.endSection();
        } else if (i == 4) {
            builder.startSection(Attributes.TEXT_WIDTH, TextWidth.WIDE);
            builder.addText(PlainDate.MONTH_OF_YEAR);
            builder.endSection();
        } else if (i == 5) {
            builder.startSection(Attributes.TEXT_WIDTH, TextWidth.NARROW);
            builder.addText(PlainDate.MONTH_OF_YEAR);
            builder.endSection();
        } else {
            throw new IllegalArgumentException("Too many pattern letters for month: " + i);
        }
    }

    private static void addQuarterOfYear(ChronoFormatter.Builder<?> builder, int i) {
        if (i == 1 || i == 2) {
            builder.addFixedNumerical(PlainDate.QUARTER_OF_YEAR, i);
            return;
        }
        if (i == 3) {
            builder.startSection(Attributes.TEXT_WIDTH, TextWidth.ABBREVIATED);
            builder.addText(PlainDate.QUARTER_OF_YEAR);
            builder.endSection();
        } else if (i == 4) {
            builder.startSection(Attributes.TEXT_WIDTH, TextWidth.WIDE);
            builder.addText(PlainDate.QUARTER_OF_YEAR);
            builder.endSection();
        } else if (i == 5) {
            builder.startSection(Attributes.TEXT_WIDTH, TextWidth.NARROW);
            builder.addText(PlainDate.QUARTER_OF_YEAR);
            builder.endSection();
        } else {
            throw new IllegalArgumentException("Too many pattern letters for quarter-of-year: " + i);
        }
    }

    private Map<ChronoElement<?>, ChronoElement<?>> general(ChronoFormatter.Builder<?> builder, Chronology<?> chronology, char c, int i, Locale locale) {
        TextElement<?> textElement;
        ChronoElement<Integer> chronoElement;
        TextWidth textWidth;
        TextWidth textWidth2;
        TextWidth textWidth3;
        if (c == 'g') {
            builder.addLongNumber(EpochDays.MODIFIED_JULIAN_DATE, i, 18, SignPolicy.SHOW_WHEN_NEGATIVE);
            return Collections.emptyMap();
        }
        if (c == 'G' && chronology == PlainDate.axis()) {
            return cldrISO(builder, chronology, locale, c, i, false);
        }
        Set<ChronoElement<?>> elements = getElements(chronology, c, locale);
        String name = builder.getChronology().getChronoType().getName();
        ChronoElement<?> chronoElementFind = find(elements, c, name);
        if (Integer.class.isAssignableFrom(chronoElementFind.getType())) {
            textElement = chronoElementFind instanceof DualFormatElement ? (TextElement) cast(chronoElementFind) : null;
            chronoElement = (ChronoElement) cast(chronoElementFind);
        } else {
            if (!(chronoElementFind instanceof TextElement)) {
                throw new IllegalStateException("Implementation error: " + chronoElementFind + " in \"" + name + "\"");
            }
            textElement = (TextElement) cast(chronoElementFind);
            chronoElement = null;
        }
        if (c == 'L') {
            builder.startSection(Attributes.OUTPUT_CONTEXT, OutputContext.STANDALONE);
            addMonth(builder, i, textElement);
            builder.endSection();
        } else if (c == 'M') {
            addMonth(builder, i, textElement);
        } else if (c != 'U') {
            boolean z = true;
            if (c != 'W') {
                if (c != 'r') {
                    if (c != 'w') {
                        if (c == 'y') {
                            if (locale.getLanguage().equals("am") && getCalendarType(chronology).equals("ethiopic")) {
                                builder.startSection(Attributes.NUMBER_SYSTEM, NumberSystem.ETHIOPIC);
                            } else {
                                z = false;
                            }
                            if (i == 2) {
                                builder.addTwoDigitYear(chronoElement);
                            } else {
                                builder.addYear(chronoElement, i, false);
                            }
                            if (z) {
                                builder.endSection();
                            }
                        } else {
                            switch (c) {
                                case 'D':
                                    if (i < 3) {
                                        builder.addInteger(chronoElement, i, 3);
                                    } else {
                                        if (i != 3) {
                                            throw new IllegalArgumentException("Too many pattern letters (D): " + i);
                                        }
                                        builder.addFixedInteger(chronoElement, i);
                                    }
                                    break;
                                case UCrop.REQUEST_CROP /* 69 */:
                                    if (i <= 3) {
                                        textWidth2 = TextWidth.ABBREVIATED;
                                    } else if (i == 4) {
                                        textWidth2 = TextWidth.WIDE;
                                    } else if (i == 5) {
                                        textWidth2 = TextWidth.NARROW;
                                    } else {
                                        if (i != 6) {
                                            throw new IllegalArgumentException("Too many pattern letters (E): " + i);
                                        }
                                        textWidth2 = TextWidth.SHORT;
                                    }
                                    builder.startSection(Attributes.TEXT_WIDTH, textWidth2);
                                    builder.addText(textElement);
                                    builder.endSection();
                                    break;
                                case CoreConstants.OOS_RESET_FREQUENCY /* 70 */:
                                    if (i != 1) {
                                        throw new IllegalArgumentException("Too many pattern letters (F): " + i);
                                    }
                                    builder.addFixedInteger(chronoElement, i);
                                    break;
                                case 'G':
                                    if (i <= 3) {
                                        textWidth3 = TextWidth.ABBREVIATED;
                                    } else if (i == 4) {
                                        textWidth3 = TextWidth.WIDE;
                                    } else {
                                        if (i != 5) {
                                            throw new IllegalArgumentException("Too many pattern letters (G): " + i);
                                        }
                                        textWidth3 = TextWidth.NARROW;
                                    }
                                    builder.startSection(Attributes.TEXT_WIDTH, textWidth3);
                                    builder.addText(textElement);
                                    builder.endSection();
                                    break;
                                default:
                                    switch (c) {
                                        case 'c':
                                            if (i == 2) {
                                                throw new IllegalArgumentException("Invalid pattern count of 2 for symbol 'c'.");
                                            }
                                            builder.startSection(Attributes.OUTPUT_CONTEXT, OutputContext.STANDALONE);
                                            if (i == 1) {
                                                builder.addFixedNumerical((ChronoElement) cast(chronoElementFind), 1);
                                            } else {
                                                general(builder, chronology, 'E', i, locale);
                                            }
                                            builder.endSection();
                                            break;
                                            break;
                                        case 'd':
                                            if (chronoElement != null) {
                                                addNumber(chronoElement, c, builder, i, false);
                                            } else {
                                                if (i > 2) {
                                                    throw new IllegalArgumentException("Too many pattern letters for day-of-month: " + i);
                                                }
                                                builder.startSection(DualFormatElement.COUNT_OF_PATTERN_SYMBOLS, i);
                                                builder.addText(textElement);
                                                builder.endSection();
                                            }
                                            break;
                                        case 'e':
                                            if (i <= 2) {
                                                builder.addFixedNumerical((ChronoElement) cast(chronoElementFind), i);
                                            } else {
                                                general(builder, chronology, 'E', i, locale);
                                            }
                                            break;
                                        default:
                                            throw new IllegalArgumentException("Unsupported pattern symbol: " + c);
                                    }
                                    break;
                            }
                        }
                    } else {
                        addNumber(chronoElement, c, builder, i, false);
                    }
                } else {
                    builder.startSection(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
                    builder.startSection(Attributes.ZERO_DIGIT, '0');
                    builder.addYear(chronoElement, i, true);
                    builder.endSection();
                    builder.endSection();
                }
            } else {
                if (i != 1) {
                    throw new IllegalArgumentException("Too many pattern letters (W): " + i);
                }
                builder.addFixedInteger(chronoElement, 1);
            }
        } else {
            if (textElement == null) {
                throw new IllegalStateException("Implementation error: " + chronoElementFind + " in \"" + name + "\"");
            }
            if (i <= 3) {
                textWidth = TextWidth.ABBREVIATED;
            } else if (i == 4) {
                textWidth = TextWidth.WIDE;
            } else {
                if (i != 5) {
                    throw new IllegalArgumentException("Too many pattern letters (U): " + i);
                }
                textWidth = TextWidth.NARROW;
            }
            builder.startSection(Attributes.TEXT_WIDTH, textWidth);
            builder.addText(textElement);
            builder.endSection();
        }
        return Collections.emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void addEnumElementAsText(ChronoFormatter.Builder<?> builder, ChronoElement<? extends Enum> chronoElement) {
        builder.addText(chronoElement);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void addEnumElementAsInteger(ChronoFormatter.Builder<?> builder, ChronoElement<? extends Enum> chronoElement, int i) {
        builder.addNumerical(chronoElement, i, 9);
    }

    private static ChronoElement<?> findDynamicElement(Chronology<?> chronology, Locale locale, int i) {
        ChronoElement<?> chronoElementFindDynamicElement = findDynamicElement(chronology, locale, i, false);
        return chronoElementFindDynamicElement == null ? findDynamicElement(chronology, locale, i, true) : chronoElementFindDynamicElement;
    }

    private static ChronoElement<?> findDynamicElement(Chronology<?> chronology, Locale locale, int i, boolean z) {
        if (z) {
            i = capitalized(i);
        }
        for (ChronoElement<?> chronoElement : chronology.getRegisteredElements()) {
            int symbol = chronoElement.getSymbol();
            if (z) {
                symbol = capitalized(symbol);
            }
            if (symbol == i) {
                return chronoElement;
            }
        }
        Iterator<ChronoExtension> it2 = chronology.getExtensions().iterator();
        while (it2.hasNext()) {
            for (ChronoElement<?> chronoElement2 : it2.next().getElements(locale, Attributes.empty())) {
                int symbol2 = chronoElement2.getSymbol();
                if (z) {
                    symbol2 = capitalized(symbol2);
                }
                if (symbol2 == i) {
                    return chronoElement2;
                }
            }
        }
        return null;
    }

    private Map<ChronoElement<?>, ChronoElement<?>> dynamic(ChronoFormatter.Builder<?> builder, char c, int i, Locale locale) {
        boolean z;
        boolean z2 = c >= 'A' && c <= 'Z';
        ChronoElement<?> chronoElementFindDynamicElement = findDynamicElement(getEffectiveChronology(builder), locale, c);
        if (chronoElementFindDynamicElement == null) {
            throw new IllegalArgumentException("Cannot resolve symbol: " + c);
        }
        if (z2 && (((z = chronoElementFindDynamicElement instanceof TextElement)) || Enum.class.isAssignableFrom(chronoElementFindDynamicElement.getType()))) {
            if (i == 1) {
                builder.startSection(Attributes.TEXT_WIDTH, TextWidth.NARROW);
            } else if (i == 2) {
                builder.startSection(Attributes.TEXT_WIDTH, TextWidth.SHORT);
            } else if (i == 3) {
                builder.startSection(Attributes.TEXT_WIDTH, TextWidth.ABBREVIATED);
            } else if (i == 4) {
                builder.startSection(Attributes.TEXT_WIDTH, TextWidth.WIDE);
            } else {
                throw new IllegalArgumentException("Illegal count of symbols: " + c);
            }
            if (z) {
                builder.addText((TextElement<?>) cast(chronoElementFindDynamicElement));
            } else {
                addEnumElementAsText(builder, (ChronoElement) cast(chronoElementFindDynamicElement));
            }
            builder.endSection();
        } else if (chronoElementFindDynamicElement.getType() == Integer.class) {
            builder.addInteger((ChronoElement) cast(chronoElementFindDynamicElement), i, 9);
        } else if (Enum.class.isAssignableFrom(chronoElementFindDynamicElement.getType())) {
            addEnumElementAsInteger(builder, (ChronoElement) cast(chronoElementFindDynamicElement), i);
        } else {
            throw new IllegalArgumentException("Can only handle enum or integer elements in a numerical way: " + chronoElementFindDynamicElement);
        }
        return Collections.emptyMap();
    }

    private static Set<ChronoElement<?>> getElements(Chronology<?> chronology, char c, Locale locale) {
        if (c == 'w' || c == 'W' || c == 'e' || c == 'c') {
            Iterator<ChronoExtension> it2 = chronology.getExtensions().iterator();
            while (it2.hasNext()) {
                for (ChronoElement<?> chronoElement : it2.next().getElements(locale, Attributes.empty())) {
                    if (((c == 'e' || c == 'c') && chronoElement.name().equals("LOCAL_DAY_OF_WEEK")) || ((c == 'w' && chronoElement.name().equals("WEEK_OF_YEAR")) || (c == 'W' && chronoElement.name().equals("WEEK_OF_MONTH")))) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(chronoElement);
                        return hashSet;
                    }
                }
            }
            return Collections.emptySet();
        }
        return chronology.getRegisteredElements();
    }

    private static ChronoElement<?> find(Set<ChronoElement<?>> set, char c, String str) {
        char c2 = c == 'L' ? 'M' : c == 'c' ? 'e' : c;
        for (ChronoElement<?> chronoElement : set) {
            if (chronoElement.isDateElement() && chronoElement.getSymbol() == c2 && (c2 != 'M' || !chronoElement.name().equals("MONTH_AS_NUMBER"))) {
                return chronoElement;
            }
        }
        if (c == 'y' && str.equals("net.time4j.PlainDate")) {
            return PlainDate.YEAR;
        }
        throw new IllegalArgumentException("Cannot find any chronological date element for symbol " + c + " in \"" + str + "\".");
    }

    private static <V extends Enum<V>> void addMonth(ChronoFormatter.Builder<?> builder, int i, TextElement<?> textElement) {
        if (i == 1 || i == 2) {
            if (Enum.class.isAssignableFrom(textElement.getType())) {
                ChronoElement<V> chronoElement = (ChronoElement) cast(textElement);
                if (i == 1) {
                    builder.addNumerical(chronoElement, 1, 2);
                    return;
                } else {
                    if (i == 2) {
                        builder.addFixedNumerical(chronoElement, 2);
                        return;
                    }
                    return;
                }
            }
            builder.startSection(DualFormatElement.COUNT_OF_PATTERN_SYMBOLS, i);
            builder.addText(textElement);
            builder.endSection();
            return;
        }
        if (i == 3) {
            builder.startSection(Attributes.TEXT_WIDTH, TextWidth.ABBREVIATED);
            builder.addText(textElement);
            builder.endSection();
        } else if (i == 4) {
            builder.startSection(Attributes.TEXT_WIDTH, TextWidth.WIDE);
            builder.addText(textElement);
            builder.endSection();
        } else if (i == 5) {
            builder.startSection(Attributes.TEXT_WIDTH, TextWidth.NARROW);
            builder.addText(textElement);
            builder.endSection();
        } else {
            throw new IllegalArgumentException("Too many pattern letters for month: " + i);
        }
    }
}
