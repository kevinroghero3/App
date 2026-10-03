package net.time4j.format.expert;

import com.facebook.appevents.UserDataStore;
import java.io.IOException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;
import net.time4j.format.NumberType;
import net.time4j.format.PluralCategory;
import net.time4j.format.PluralRules;

/* JADX INFO: loaded from: classes6.dex */
final class OrdinalProcessor implements FormatProcessor<Integer> {
    private static final Map<PluralCategory, String> ENGLISH_ORDINALS;
    private final ChronoElement<Integer> element;
    private final Map<PluralCategory, String> indicators;
    private final Leniency lenientMode;
    private final Locale locale;
    private final int protectedLength;
    private final int reserved;
    private final char zeroDigit;

    @Override // net.time4j.format.expert.FormatProcessor
    public boolean isNumerical() {
        return false;
    }

    static {
        EnumMap enumMap = new EnumMap(PluralCategory.class);
        enumMap.put(PluralCategory.ONE, UserDataStore.STATE);
        enumMap.put(PluralCategory.TWO, "nd");
        enumMap.put(PluralCategory.FEW, "rd");
        enumMap.put(PluralCategory.OTHER, "th");
        ENGLISH_ORDINALS = Collections.unmodifiableMap(enumMap);
    }

    OrdinalProcessor(ChronoElement<Integer> chronoElement, Map<PluralCategory, String> map) {
        if (chronoElement == null) {
            throw new NullPointerException("Missing element.");
        }
        this.element = chronoElement;
        if (map == null) {
            this.indicators = null;
        } else {
            Map<PluralCategory, String> mapUnmodifiableMap = Collections.unmodifiableMap(new EnumMap(map));
            this.indicators = mapUnmodifiableMap;
            if (!mapUnmodifiableMap.containsKey(PluralCategory.OTHER)) {
                throw new IllegalArgumentException("Missing plural category OTHER: " + map);
            }
        }
        this.reserved = 0;
        this.protectedLength = 0;
        this.zeroDigit = '0';
        this.lenientMode = Leniency.SMART;
        this.locale = Locale.ROOT;
    }

    private OrdinalProcessor(ChronoElement<Integer> chronoElement, Map<PluralCategory, String> map, int i, int i2, char c, Leniency leniency, Locale locale) {
        this.element = chronoElement;
        this.indicators = map;
        this.reserved = i;
        this.protectedLength = i2;
        this.zeroDigit = c;
        this.lenientMode = leniency;
        this.locale = locale;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        char cCharValue;
        int i = chronoDisplay.getInt(this.element);
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return -1;
            }
            throw new IllegalArgumentException("Cannot format negative ordinal numbers: " + chronoDisplay);
        }
        String string = Integer.toString(i);
        if (z) {
            cCharValue = this.zeroDigit;
        } else {
            cCharValue = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue();
        }
        if (cCharValue != '0') {
            char[] charArray = string.toCharArray();
            for (int i2 = 0; i2 < charArray.length; i2++) {
                charArray[i2] = (char) (charArray[i2] + (cCharValue - '0'));
            }
            string = new String(charArray);
        }
        int length = appendable instanceof CharSequence ? ((CharSequence) appendable).length() : -1;
        appendable.append(string);
        int length2 = string.length();
        String indicator = getIndicator(attributeQuery, z, i);
        appendable.append(indicator);
        int length3 = length2 + indicator.length();
        if (length != -1 && length3 > 0 && set != null) {
            set.add(new ElementPosition(this.element, length, length + length3));
        }
        return length3;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        char cCharValue;
        int iMin;
        int length = charSequence.length();
        int position = parseLog.getPosition();
        Leniency leniency = z ? this.lenientMode : (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
        int iIntValue = z ? this.protectedLength : ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue();
        if (iIntValue > 0) {
            length -= iIntValue;
        }
        if (position >= length) {
            parseLog.setError(position, "Missing digits for: " + this.element.name());
            parseLog.setWarning();
            return;
        }
        if (z) {
            cCharValue = this.zeroDigit;
        } else {
            cCharValue = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue();
        }
        if (this.reserved <= 0 || iIntValue > 0) {
            iMin = 9;
        } else {
            int i = 0;
            for (int i2 = position; i2 < length; i2++) {
                int iCharAt = charSequence.charAt(i2) - cCharValue;
                if (iCharAt < 0 || iCharAt > 9) {
                    break;
                }
                i++;
            }
            iMin = Math.min(9, i - this.reserved);
        }
        int iMin2 = Math.min(length, iMin + position);
        boolean z2 = true;
        long j = 0;
        int i3 = position;
        while (i3 < iMin2) {
            int iCharAt2 = charSequence.charAt(i3) - cCharValue;
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                if (!z2) {
                    break;
                }
                parseLog.setError(position, "Digit expected.");
                return;
            } else {
                j = (j * 10) + ((long) iCharAt2);
                i3++;
                iMin2 = iMin2;
                z2 = false;
            }
        }
        if (i3 < position + 1) {
            parseLog.setError(position, "Not enough digits found for: " + this.element.name());
            return;
        }
        int i4 = (int) j;
        String indicator = getIndicator(attributeQuery, z, i4);
        int length2 = indicator.length() + i3;
        if (length2 >= length) {
            parseLog.setError(i3, "Missing or wrong ordinal indicator for: " + this.element.name());
            return;
        }
        String string = charSequence.subSequence(i3, length2).toString();
        if (string.equals(indicator)) {
            i3 = length2;
        } else if (!leniency.isLax()) {
            parseLog.setError(i3, "Wrong ordinal indicator for: " + this.element.name() + " (expected=" + indicator + ", found=" + string + ")");
            return;
        }
        parsedEntity.put(this.element, i4);
        parseLog.setPosition(i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrdinalProcessor)) {
            return false;
        }
        OrdinalProcessor ordinalProcessor = (OrdinalProcessor) obj;
        return this.element.equals(ordinalProcessor.element) && getIndicators().equals(ordinalProcessor.getIndicators());
    }

    public int hashCode() {
        return (this.element.hashCode() * 7) + (getIndicators().hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(OrdinalProcessor.class.getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(", indicators=");
        sb.append(getIndicators());
        sb.append(']');
        return sb.toString();
    }

    private String getIndicator(AttributeQuery attributeQuery, boolean z, int i) {
        Locale locale;
        if (isEnglish()) {
            locale = Locale.ENGLISH;
        } else {
            locale = z ? this.locale : (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
        }
        PluralCategory category = PluralRules.of(locale, NumberType.ORDINALS).getCategory(i);
        if (!getIndicators().containsKey(category)) {
            category = PluralCategory.OTHER;
        }
        return getIndicators().get(category);
    }

    private boolean isEnglish() {
        return this.indicators == null;
    }

    private Map<PluralCategory, String> getIndicators() {
        if (isEnglish()) {
            return ENGLISH_ORDINALS;
        }
        return this.indicators;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public ChronoElement<Integer> getElement() {
        return this.element;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<Integer> withElement(ChronoElement<Integer> chronoElement) {
        return this.element == chronoElement ? this : new OrdinalProcessor(chronoElement, this.indicators);
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<Integer> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new OrdinalProcessor(this.element, this.indicators, i, ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue(), ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue(), (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART), (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT));
    }
}
