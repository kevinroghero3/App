package net.time4j.calendar;

import androidx.core.text.util.LocalePreferences;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.Map;
import net.time4j.Month;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoException;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.NumberSystem;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.DualFormatElement;
import net.time4j.format.internal.DualFormatHelper;

/* JADX INFO: loaded from: classes3.dex */
class EastAsianME implements TextElement<EastAsianMonth>, Serializable {
    static final EastAsianME SINGLETON_EA = new EastAsianME();
    private static final long serialVersionUID = -5874268477318061153L;

    @Override // net.time4j.engine.ChronoElement
    public char getSymbol() {
        return 'M';
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isLenient() {
        return false;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isTimeElement() {
        return false;
    }

    EastAsianME() {
    }

    @Override // net.time4j.engine.ChronoElement
    public String name() {
        return "MONTH_OF_YEAR";
    }

    @Override // net.time4j.engine.ChronoElement
    public Class<EastAsianMonth> getType() {
        return EastAsianMonth.class;
    }

    @Override // java.util.Comparator
    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        return ((EastAsianMonth) chronoDisplay.get(this)).compareTo((EastAsianMonth) chronoDisplay2.get(this));
    }

    @Override // net.time4j.engine.ChronoElement
    public EastAsianMonth getDefaultMinimum() {
        return EastAsianMonth.valueOf(1);
    }

    @Override // net.time4j.engine.ChronoElement
    public EastAsianMonth getDefaultMaximum() {
        return EastAsianMonth.valueOf(12);
    }

    @Override // net.time4j.engine.ChronoElement
    public String getDisplayName(Locale locale) {
        String str = CalendarText.getIsoInstance(locale).getTextForms().get("L_month");
        return str == null ? name() : str;
    }

    protected Object readResolve() throws ObjectStreamException {
        return SINGLETON_EA;
    }

    @Override // net.time4j.format.TextElement
    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
        TextAccessor stdMonths;
        Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
        EastAsianMonth eastAsianMonth = (EastAsianMonth) chronoDisplay.get(this);
        if (attributeQuery.contains(DualFormatElement.COUNT_OF_PATTERN_SYMBOLS)) {
            appendable.append(eastAsianMonth.getDisplayName(locale, (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC), attributeQuery));
            return;
        }
        TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
        OutputContext outputContext = (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT);
        if (eastAsianMonth.isLeap()) {
            stdMonths = CalendarText.getInstance(LocalePreferences.CalendarType.CHINESE, locale).getLeapMonths(textWidth, outputContext);
        } else {
            stdMonths = CalendarText.getInstance(LocalePreferences.CalendarType.CHINESE, locale).getStdMonths(textWidth, outputContext);
        }
        appendable.append(stdMonths.print(Month.valueOf(eastAsianMonth.getNumber())));
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0142 A[PHI: r8
  0x0142: PHI (r8v5 net.time4j.Month) = (r8v4 net.time4j.Month), (r8v9 net.time4j.Month) binds: [B:45:0x0123, B:47:0x013d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // net.time4j.format.TextElement
    public EastAsianMonth parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        boolean z;
        EastAsianMonth eastAsianMonthValueOf;
        boolean z2;
        int i;
        boolean z3;
        NumberSystem numberSystem;
        Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
        int length = charSequence.length();
        int index = parsePosition.getIndex();
        if (index >= length) {
            parsePosition.setErrorIndex(length);
            return null;
        }
        if (attributeQuery.contains(DualFormatElement.COUNT_OF_PATTERN_SYMBOLS)) {
            Map<String, String> textForms = CalendarText.getInstance("generic", locale).getTextForms();
            NumberSystem numberSystem2 = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
            char cCharValue = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, Character.valueOf(numberSystem2.getDigits().charAt(0)))).charValue();
            boolean zBooleanValue = ((Boolean) attributeQuery.get(EastAsianMonth.LEAP_MONTH_IS_TRAILING, Boolean.valueOf("R".equals(textForms.get("leap-alignment"))))).booleanValue();
            char cCharValue2 = ((Character) attributeQuery.get(EastAsianMonth.LEAP_MONTH_INDICATOR, Character.valueOf(textForms.get("leap-indicator").charAt(0)))).charValue();
            if (zBooleanValue || charSequence.charAt(index) != cCharValue2) {
                i = index;
                z3 = false;
            } else {
                i = index + 1;
                z3 = true;
            }
            if (numberSystem2.isDecimal()) {
                while (i < length && charSequence.charAt(i) == cCharValue) {
                    i++;
                }
            }
            int i2 = 12;
            int i3 = 0;
            for (int i4 = 1; i2 >= i4 && i3 == 0; i4 = 1) {
                String numeral = DualFormatHelper.toNumeral(numberSystem2, cCharValue, i2);
                int length2 = numeral.length();
                int i5 = 0;
                while (true) {
                    int i6 = i + i5;
                    if (length > i6) {
                        numberSystem = numberSystem2;
                        if (charSequence.charAt(i6) == numeral.charAt(i5)) {
                            break;
                        }
                        break;
                    }
                    numberSystem = numberSystem2;
                    i5++;
                    if (i5 == length2) {
                        i += length2;
                        i3 = i2;
                        break;
                    }
                    numberSystem2 = numberSystem;
                }
                i2--;
                numberSystem2 = numberSystem;
            }
            if (i3 == 0) {
                parsePosition.setErrorIndex(index);
                return null;
            }
            if (zBooleanValue && length > i && charSequence.charAt(i) == cCharValue2) {
                i++;
                z2 = true;
            } else {
                z2 = z3;
            }
            eastAsianMonthValueOf = EastAsianMonth.valueOf(i3);
            parsePosition.setIndex(i);
        } else {
            TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
            OutputContext outputContext = (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT);
            Month month = (Month) CalendarText.getInstance(LocalePreferences.CalendarType.CHINESE, locale).getStdMonths(textWidth, outputContext).parse(charSequence, parsePosition, Month.class, attributeQuery);
            if (month == null) {
                parsePosition.setErrorIndex(-1);
                parsePosition.setIndex(index);
                month = (Month) CalendarText.getInstance(LocalePreferences.CalendarType.CHINESE, locale).getLeapMonths(textWidth, outputContext).parse(charSequence, parsePosition, Month.class, attributeQuery);
                if (month != null) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (month == null) {
                parsePosition.setErrorIndex(index);
                return null;
            }
            eastAsianMonthValueOf = EastAsianMonth.valueOf(month.getValue());
            z2 = z;
        }
        return z2 ? eastAsianMonthValueOf.withLeap() : eastAsianMonthValueOf;
    }
}
