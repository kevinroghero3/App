package net.time4j.format.expert;

import androidx.core.app.NotificationManagerCompat;
import ch.qos.logback.core.CoreConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.time4j.base.UnixTime;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.DisplayMode;
import net.time4j.format.Leniency;
import net.time4j.tz.OffsetSign;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;
import org.joda.time.DateTimeConstants;

/* JADX INFO: loaded from: classes3.dex */
final class TimezoneOffsetProcessor implements FormatProcessor<TZID> {
    static final TimezoneOffsetProcessor EXTENDED_LONG_PARSER = new TimezoneOffsetProcessor();
    private final boolean caseInsensitive;
    private final boolean extended;
    private final Leniency lenientMode;
    private final DisplayMode precision;
    private final List<String> zeroOffsets;

    @Override // net.time4j.format.expert.FormatProcessor
    public boolean isNumerical() {
        return false;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<TZID> withElement(ChronoElement<TZID> chronoElement) {
        return this;
    }

    TimezoneOffsetProcessor(DisplayMode displayMode, boolean z, List<String> list) {
        if (displayMode == null) {
            throw new NullPointerException("Missing display mode.");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Missing zero offsets.");
        }
        ArrayList arrayList = new ArrayList(list);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (((String) it2.next()).trim().isEmpty()) {
                throw new IllegalArgumentException("Zero offset must not be white-space-only.");
            }
        }
        this.precision = displayMode;
        this.extended = z;
        this.zeroOffsets = Collections.unmodifiableList(arrayList);
        this.caseInsensitive = true;
        this.lenientMode = Leniency.SMART;
    }

    private TimezoneOffsetProcessor() {
        this.precision = DisplayMode.LONG;
        this.extended = true;
        this.zeroOffsets = Collections.emptyList();
        this.caseInsensitive = true;
        this.lenientMode = Leniency.SMART;
    }

    private TimezoneOffsetProcessor(DisplayMode displayMode, boolean z, List<String> list, boolean z2, Leniency leniency) {
        this.precision = displayMode;
        this.extended = z;
        this.zeroOffsets = list;
        this.caseInsensitive = z2;
        this.lenientMode = leniency;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008f A[PHI: r1
  0x008f: PHI (r1v21 int) = (r1v12 int), (r1v12 int), (r1v12 int), (r1v9 int) binds: [B:41:0x00b2, B:43:0x00b6, B:47:0x00be, B:32:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // net.time4j.format.expert.FormatProcessor
    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        ZonalOffset offset;
        int i;
        int length;
        int length2 = appendable instanceof CharSequence ? ((CharSequence) appendable).length() : -1;
        TZID timezone = chronoDisplay.hasTimezone() ? chronoDisplay.getTimezone() : null;
        if (timezone == null) {
            offset = getOffset(chronoDisplay, attributeQuery);
        } else if (timezone instanceof ZonalOffset) {
            offset = (ZonalOffset) timezone;
        } else {
            if (!(chronoDisplay instanceof UnixTime)) {
                throw new IllegalArgumentException("Cannot extract timezone offset from: " + chronoDisplay);
            }
            offset = Timezone.of(timezone).getOffset((UnixTime) chronoDisplay);
        }
        int integralAmount = offset.getIntegralAmount();
        int fractionalAmount = offset.getFractionalAmount();
        if ((integralAmount | fractionalAmount) == 0) {
            String str = this.zeroOffsets.get(0);
            appendable.append(str);
            length = str.length();
        } else {
            appendable.append((integralAmount < 0 || fractionalAmount < 0) ? CoreConstants.DASH_CHAR : '+');
            int iAbs = Math.abs(integralAmount);
            int i2 = iAbs / DateTimeConstants.SECONDS_PER_HOUR;
            int i3 = (iAbs / 60) % 60;
            int i4 = iAbs % 60;
            if (i2 < 10) {
                appendable.append('0');
                i = 2;
            } else {
                i = 1;
            }
            String strValueOf = String.valueOf(i2);
            appendable.append(strValueOf);
            int length3 = strValueOf.length() + i;
            DisplayMode displayMode = this.precision;
            DisplayMode displayMode2 = DisplayMode.SHORT;
            if (displayMode == displayMode2 && i3 == 0) {
                length = length3;
            } else {
                if (this.extended) {
                    appendable.append(CoreConstants.COLON_CHAR);
                    length3++;
                }
                if (i3 < 10) {
                    appendable.append('0');
                    length3++;
                }
                String strValueOf2 = String.valueOf(i3);
                appendable.append(strValueOf2);
                length3 += strValueOf2.length();
                DisplayMode displayMode3 = this.precision;
                if (displayMode3 == displayMode2 || displayMode3 == DisplayMode.MEDIUM || (displayMode3 != DisplayMode.FULL && (i4 | fractionalAmount) == 0)) {
                    length = length3;
                } else {
                    if (this.extended) {
                        appendable.append(CoreConstants.COLON_CHAR);
                        length3++;
                    }
                    if (i4 < 10) {
                        appendable.append('0');
                        length3++;
                    }
                    String strValueOf3 = String.valueOf(i4);
                    appendable.append(strValueOf3);
                    int length4 = strValueOf3.length() + length3;
                    if (fractionalAmount != 0) {
                        appendable.append('.');
                        int i5 = length4 + 1;
                        String strValueOf4 = String.valueOf(Math.abs(fractionalAmount));
                        int length5 = strValueOf4.length();
                        for (int i6 = 0; i6 < 9 - length5; i6++) {
                            appendable.append('0');
                            i5++;
                        }
                        appendable.append(strValueOf4);
                        length = strValueOf4.length() + i5;
                    } else {
                        length = length4;
                    }
                }
            }
        }
        if (length2 != -1 && length > 0 && set != null) {
            set.add(new ElementPosition(TimezoneElement.TIMEZONE_ID, length2, length2 + length));
        }
        return length;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x018b  */
    /* JADX WARN: Code duplicated, block: B:109:0x018f  */
    /* JADX WARN: Code duplicated, block: B:113:0x019a  */
    /* JADX WARN: Code duplicated, block: B:115:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00db  */
    /* JADX WARN: Code duplicated, block: B:57:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x0104  */
    /* JADX WARN: Code duplicated, block: B:69:0x0111  */
    /* JADX WARN: Code duplicated, block: B:71:0x0117  */
    /* JADX WARN: Code duplicated, block: B:90:0x014a  */
    /* JADX WARN: Code duplicated, block: B:92:0x0150  */
    /* JADX WARN: Code duplicated, block: B:94:0x0156  */
    @Override // net.time4j.format.expert.FormatProcessor
    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        OffsetSign offsetSign;
        int num;
        int i;
        int i2;
        int i3;
        int num2;
        int i4;
        int i5;
        int i6;
        int i7;
        ZonalOffset zonalOffsetOfTotalSeconds;
        DisplayMode displayMode;
        int num3;
        int i8;
        int i9;
        int i10;
        boolean zBooleanValue;
        int length = charSequence.length();
        int position = parseLog.getPosition();
        if (position >= length) {
            parseLog.setError(position, "Missing timezone offset.");
            return;
        }
        for (String str : this.zeroOffsets) {
            int length2 = str.length();
            if (length - position >= length2) {
                int i11 = length2 + position;
                String string = charSequence.subSequence(position, i11).toString();
                if (z) {
                    zBooleanValue = this.caseInsensitive;
                } else {
                    zBooleanValue = ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue();
                }
                if ((zBooleanValue && string.equalsIgnoreCase(str)) || (!zBooleanValue && string.equals(str))) {
                    parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.UTC);
                    parseLog.setPosition(i11);
                    return;
                }
            }
        }
        Leniency leniency = z ? this.lenientMode : (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
        char cCharAt = charSequence.charAt(position);
        if (cCharAt == '+') {
            offsetSign = OffsetSign.AHEAD_OF_UTC;
        } else {
            if (cCharAt == '-') {
                offsetSign = OffsetSign.BEHIND_UTC;
            } else if (Character.isDigit(cCharAt) && leniency.isLax()) {
                offsetSign = OffsetSign.AHEAD_OF_UTC;
            } else {
                parseLog.setError(position, "Missing sign of timezone offset.");
                return;
            }
            num = parseNum(charSequence, position, leniency);
            if (num == -1000) {
                parseLog.setError(position, "Hour part in timezone offset does not match expected pattern HH.");
                return;
            }
            if (num < 0) {
                num = ~num;
                i = position + 1;
            } else {
                i = position + 2;
            }
            if (i >= length) {
                if (this.precision == DisplayMode.SHORT) {
                    parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.ofHours(offsetSign, num));
                    parseLog.setPosition(i);
                    return;
                } else {
                    parseLog.setError(i, "Missing minute part in timezone offset.");
                    return;
                }
            }
            if (this.extended) {
                i2 = 0;
            } else {
                if (charSequence.charAt(i) == ':') {
                    if (this.precision == DisplayMode.SHORT) {
                        parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.ofHours(offsetSign, num));
                        parseLog.setPosition(i);
                        return;
                    } else {
                        parseLog.setError(i, "Colon expected in timezone offset.");
                        return;
                    }
                }
                i2 = 1;
            }
            i3 = i2 + i;
            Leniency leniency2 = Leniency.STRICT;
            num2 = parseNum(charSequence, i3, leniency2);
            if (num2 == -1000) {
                if (this.precision == DisplayMode.SHORT) {
                    parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.ofHours(offsetSign, num));
                    parseLog.setPosition(i);
                    return;
                } else {
                    parseLog.setError(i3, "Minute part in timezone offset does not match expected pattern mm.");
                    return;
                }
            }
            i4 = i3 + 2;
            if (i4 < length || !((displayMode = this.precision) == DisplayMode.LONG || displayMode == DisplayMode.FULL)) {
                i5 = 0;
                i6 = 0;
            } else {
                if (this.extended) {
                    if (charSequence.charAt(i4) == ':') {
                        num3 = parseNum(charSequence, i3 + 3, leniency2);
                        i8 = 1;
                    } else {
                        if (this.precision == DisplayMode.FULL) {
                            parseLog.setError(i4, "Colon expected in timezone offset.");
                            return;
                        }
                        num3 = -1000;
                    }
                    if (num3 == -1000) {
                        if (this.precision == DisplayMode.FULL) {
                            parseLog.setError(i4, "Second part in timezone offset does not match expected pattern ss.");
                            return;
                        }
                        i5 = 0;
                        i6 = 0;
                    } else {
                        int i12 = i4 + i8;
                        i9 = i12 + 2;
                        i10 = i12 + 12;
                        if (i10 <= length || charSequence.charAt(i9) != '.') {
                            i4 = i9;
                            i6 = num3;
                            i5 = 0;
                        } else {
                            int i13 = i12 + 3;
                            int i14 = i13;
                            int i15 = 0;
                            while (i13 < i10) {
                                char cCharAt2 = charSequence.charAt(i13);
                                if (cCharAt2 < '0' || cCharAt2 > '9') {
                                    parseLog.setError(i14, "9 digits in fractional part of timezone offset expected.");
                                    return;
                                } else {
                                    i15 = (i15 * 10) + (cCharAt2 - '0');
                                    i14++;
                                    i13++;
                                }
                            }
                            i4 = i14;
                            i5 = i15;
                            i6 = num3;
                        }
                    }
                } else {
                    num3 = parseNum(charSequence, i4, leniency2);
                }
                i8 = 0;
                if (num3 == -1000) {
                    if (this.precision == DisplayMode.FULL) {
                        parseLog.setError(i4, "Second part in timezone offset does not match expected pattern ss.");
                        return;
                    }
                    i5 = 0;
                    i6 = 0;
                } else {
                    int i16 = i4 + i8;
                    i9 = i16 + 2;
                    i10 = i16 + 12;
                    if (i10 <= length) {
                        i4 = i9;
                        i6 = num3;
                        i5 = 0;
                    } else {
                        i4 = i9;
                        i6 = num3;
                        i5 = 0;
                    }
                }
            }
            if (i6 != 0 && i5 == 0) {
                zonalOffsetOfTotalSeconds = ZonalOffset.ofHoursMinutes(offsetSign, num, num2);
            } else {
                i7 = (num * DateTimeConstants.SECONDS_PER_HOUR) + (num2 * 60) + i6;
                if (offsetSign == OffsetSign.BEHIND_UTC) {
                    i7 = -i7;
                    i5 = -i5;
                }
                zonalOffsetOfTotalSeconds = ZonalOffset.ofTotalSeconds(i7, i5);
            }
            parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, zonalOffsetOfTotalSeconds);
            parseLog.setPosition(i4);
        }
        position++;
        num = parseNum(charSequence, position, leniency);
        if (num == -1000) {
            parseLog.setError(position, "Hour part in timezone offset does not match expected pattern HH.");
            return;
        }
        if (num < 0) {
            num = ~num;
            i = position + 1;
        } else {
            i = position + 2;
        }
        if (i >= length) {
            if (this.precision == DisplayMode.SHORT) {
                parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.ofHours(offsetSign, num));
                parseLog.setPosition(i);
                return;
            } else {
                parseLog.setError(i, "Missing minute part in timezone offset.");
                return;
            }
        }
        if (this.extended) {
            i2 = 0;
        } else {
            if (charSequence.charAt(i) == ':') {
                if (this.precision == DisplayMode.SHORT) {
                    parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.ofHours(offsetSign, num));
                    parseLog.setPosition(i);
                    return;
                } else {
                    parseLog.setError(i, "Colon expected in timezone offset.");
                    return;
                }
            }
            i2 = 1;
        }
        i3 = i2 + i;
        Leniency leniency3 = Leniency.STRICT;
        num2 = parseNum(charSequence, i3, leniency3);
        if (num2 == -1000) {
            if (this.precision == DisplayMode.SHORT) {
                parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.ofHours(offsetSign, num));
                parseLog.setPosition(i);
                return;
            } else {
                parseLog.setError(i3, "Minute part in timezone offset does not match expected pattern mm.");
                return;
            }
        }
        i4 = i3 + 2;
        if (i4 < length) {
            i5 = 0;
            i6 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        if (i6 != 0) {
            i7 = (num * DateTimeConstants.SECONDS_PER_HOUR) + (num2 * 60) + i6;
            if (offsetSign == OffsetSign.BEHIND_UTC) {
                i7 = -i7;
                i5 = -i5;
            }
            zonalOffsetOfTotalSeconds = ZonalOffset.ofTotalSeconds(i7, i5);
        } else {
            i7 = (num * DateTimeConstants.SECONDS_PER_HOUR) + (num2 * 60) + i6;
            if (offsetSign == OffsetSign.BEHIND_UTC) {
                i7 = -i7;
                i5 = -i5;
            }
            zonalOffsetOfTotalSeconds = ZonalOffset.ofTotalSeconds(i7, i5);
        }
        parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, zonalOffsetOfTotalSeconds);
        parseLog.setPosition(i4);
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public ChronoElement<TZID> getElement() {
        return TimezoneElement.TIMEZONE_OFFSET;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<TZID> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new TimezoneOffsetProcessor(this.precision, this.extended, this.zeroOffsets, ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue(), (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimezoneOffsetProcessor)) {
            return false;
        }
        TimezoneOffsetProcessor timezoneOffsetProcessor = (TimezoneOffsetProcessor) obj;
        return this.precision == timezoneOffsetProcessor.precision && this.extended == timezoneOffsetProcessor.extended && this.zeroOffsets.equals(timezoneOffsetProcessor.zeroOffsets);
    }

    public int hashCode() {
        return (this.precision.hashCode() * 7) + (this.zeroOffsets.hashCode() * 31) + (this.extended ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(TimezoneOffsetProcessor.class.getName());
        sb.append("[precision=");
        sb.append(this.precision);
        sb.append(", extended=");
        sb.append(this.extended);
        sb.append(", zero-offsets=");
        sb.append(this.zeroOffsets);
        sb.append(']');
        return sb.toString();
    }

    private static ZonalOffset getOffset(ChronoDisplay chronoDisplay, AttributeQuery attributeQuery) {
        AttributeKey<TZID> attributeKey = Attributes.TIMEZONE_ID;
        if (attributeQuery.contains(attributeKey)) {
            TZID tzid = (TZID) attributeQuery.get(attributeKey);
            if (tzid instanceof ZonalOffset) {
                return (ZonalOffset) tzid;
            }
            if (tzid != null) {
                throw new IllegalArgumentException("Use a timezone offset instead of [" + tzid.canonical() + "] when formatting [" + chronoDisplay + "].");
            }
        }
        throw new IllegalArgumentException("Cannot extract timezone offset from format attributes for: " + chronoDisplay);
    }

    private static int parseNum(CharSequence charSequence, int i, Leniency leniency) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 2) {
            int i4 = i + i2;
            char cCharAt = i4 >= charSequence.length() ? (char) 0 : charSequence.charAt(i4);
            if (cCharAt < '0' || cCharAt > '9') {
                return (i2 == 0 || leniency.isStrict()) ? NotificationManagerCompat.IMPORTANCE_UNSPECIFIED : ~i3;
            }
            i3 = (i3 * 10) + (cCharAt - '0');
            i2++;
        }
        return i3;
    }
}
