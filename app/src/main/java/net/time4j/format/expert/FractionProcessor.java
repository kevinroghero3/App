package net.time4j.format.expert;

import com.google.android.gms.internal.measurement.zzai$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;

/* JADX INFO: loaded from: classes3.dex */
final class FractionProcessor implements FormatProcessor<Integer> {
    private static final int MRD_MINUS_1 = 999999999;
    private final FormatProcessor<Void> decimalSeparator;
    private final ChronoElement<Integer> element;
    private final boolean fixedWidth;
    private final Leniency lenientMode;
    private final int maxDigits;
    private final int minDigits;
    private final char zeroDigit;

    @Override // net.time4j.format.expert.FormatProcessor
    public boolean isNumerical() {
        return true;
    }

    FractionProcessor(ChronoElement<Integer> chronoElement, int i, int i2, boolean z) {
        this.element = chronoElement;
        this.minDigits = i;
        this.maxDigits = i2;
        this.fixedWidth = !z && i == i2;
        this.decimalSeparator = z ? new LiteralProcessor(Attributes.DECIMAL_SEPARATOR) : null;
        if (chronoElement == null) {
            throw new NullPointerException("Missing element.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Negative min digits: " + i);
        }
        if (i > i2) {
            throw new IllegalArgumentException("Max smaller than min: " + i2 + " < " + i);
        }
        if (i > 9) {
            throw new IllegalArgumentException("Min digits out of range: " + i);
        }
        if (i2 > 9) {
            throw new IllegalArgumentException("Max digits out of range: " + i2);
        }
        this.zeroDigit = '0';
        this.lenientMode = Leniency.SMART;
    }

    private FractionProcessor(FormatProcessor<Void> formatProcessor, ChronoElement<Integer> chronoElement, int i, int i2, boolean z, char c, Leniency leniency) {
        this.decimalSeparator = formatProcessor;
        this.element = chronoElement;
        this.minDigits = i;
        this.maxDigits = i2;
        this.fixedWidth = z;
        this.zeroDigit = c;
        this.lenientMode = leniency;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        char cCharValue;
        int i;
        int i2;
        int i3;
        int i4;
        BigDecimal decimal = toDecimal((Number) chronoDisplay.get(this.element));
        BigDecimal decimal2 = toDecimal((Number) chronoDisplay.getMinimum(this.element));
        BigDecimal decimal3 = toDecimal((Number) chronoDisplay.getMaximum(this.element));
        if (decimal.compareTo(decimal3) > 0) {
            decimal = decimal3;
        }
        BigDecimal bigDecimalSubtract = decimal.subtract(decimal2);
        BigDecimal bigDecimalAdd = decimal3.subtract(decimal2).add(BigDecimal.ONE);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal bigDecimalDivide = bigDecimalSubtract.divide(bigDecimalAdd, 9, roundingMode);
        BigDecimal bigDecimalM = BigDecimal.ZERO;
        if (bigDecimalDivide.compareTo(bigDecimalM) != 0) {
            bigDecimalM = zzai$$ExternalSyntheticBackportWithForwarding0.m(bigDecimalDivide);
        }
        BigDecimal bigDecimal = bigDecimalM;
        if (z) {
            cCharValue = this.zeroDigit;
        } else {
            cCharValue = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue();
        }
        char c = cCharValue;
        int length = appendable instanceof CharSequence ? ((CharSequence) appendable).length() : -1;
        int i5 = 0;
        if (bigDecimal.scale() == 0) {
            if (this.minDigits > 0) {
                if (hasDecimalSeparator()) {
                    i2 = 1;
                    this.decimalSeparator.print(chronoDisplay, appendable, attributeQuery, set, z);
                    i3 = 1;
                } else {
                    i2 = 1;
                    i3 = 0;
                }
                while (true) {
                    i4 = this.minDigits;
                    if (i5 >= i4) {
                        break;
                    }
                    appendable.append(c);
                    i5++;
                }
                i5 = i3 + i4;
                i = i2;
            } else {
                i = 1;
            }
        } else {
            if (hasDecimalSeparator()) {
                i5 = 1;
                this.decimalSeparator.print(chronoDisplay, appendable, attributeQuery, set, z);
                i = 1;
            } else {
                i = 1;
            }
            String plainString = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), this.minDigits), this.maxDigits), roundingMode).toPlainString();
            int length2 = plainString.length();
            for (int i6 = 2; i6 < length2; i6++) {
                appendable.append((char) (plainString.charAt(i6) + (c - '0')));
                i5++;
            }
        }
        if (length != -1 && i5 > i && set != null) {
            set.add(new ElementPosition(this.element, length + 1, length + i5));
        }
        return i5;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        int i;
        int i2;
        char cCharValue;
        Leniency leniency = z ? this.lenientMode : (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
        int i3 = 9;
        if (!leniency.isLax() || this.fixedWidth) {
            i = this.minDigits;
            i2 = this.maxDigits;
        } else {
            i2 = 9;
            i = 0;
        }
        int length = charSequence.length();
        if (parseLog.getPosition() >= length) {
            if (i > 0) {
                parseLog.setError(parseLog.getPosition(), "Expected fraction digits not found for: " + this.element.name());
                return;
            }
            return;
        }
        if (hasDecimalSeparator()) {
            this.decimalSeparator.parse(charSequence, parseLog, attributeQuery, null, z);
            if (parseLog.isError()) {
                if (i == 0) {
                    parseLog.clearError();
                    return;
                }
                return;
            }
        }
        int position = parseLog.getPosition();
        int i4 = position + i;
        int iMin = Math.min(i2 + position, length);
        if (i4 > length && leniency.isStrict()) {
            parseLog.setError(parseLog.getPosition(), "Expected at least " + i + " digits.");
            return;
        }
        if (z) {
            cCharValue = this.zeroDigit;
        } else {
            cCharValue = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue();
        }
        long j = 0;
        while (position < iMin) {
            int iCharAt = charSequence.charAt(position) - cCharValue;
            if (iCharAt < 0 || iCharAt > i3) {
                int i5 = i;
                if (position >= i4 || !leniency.isStrict()) {
                    break;
                    break;
                }
                parseLog.setError(parseLog.getPosition(), "Expected at least " + i5 + " digits.");
                return;
            }
            j = (j * 10) + ((long) iCharAt);
            position++;
            i = i;
            i3 = 9;
        }
        BigDecimal bigDecimalMovePointLeft = new BigDecimal(j).movePointLeft(position - parseLog.getPosition());
        if (this.element.name().equals("NANO_OF_SECOND")) {
            parsedEntity.put(this.element, getRealValue(bigDecimalMovePointLeft, 0, 999999999));
        } else {
            parsedEntity.put(FractionalElement.FRACTION, bigDecimalMovePointLeft);
            ChronoElement<Integer> chronoElement = this.element;
            parsedEntity.put(chronoElement, chronoElement.getDefaultMinimum());
        }
        parseLog.setPosition(position);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FractionProcessor)) {
            return false;
        }
        FractionProcessor fractionProcessor = (FractionProcessor) obj;
        return this.element.equals(fractionProcessor.element) && this.minDigits == fractionProcessor.minDigits && this.maxDigits == fractionProcessor.maxDigits && hasDecimalSeparator() == fractionProcessor.hasDecimalSeparator();
    }

    public int hashCode() {
        return (this.element.hashCode() * 7) + ((this.minDigits + (this.maxDigits * 10)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(FractionProcessor.class.getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(", min-digits=");
        sb.append(this.minDigits);
        sb.append(", max-digits=");
        sb.append(this.maxDigits);
        sb.append(']');
        return sb.toString();
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public ChronoElement<Integer> getElement() {
        return this.element;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<Integer> withElement(ChronoElement<Integer> chronoElement) {
        return this.element == chronoElement ? this : new FractionProcessor(chronoElement, this.minDigits, this.maxDigits, hasDecimalSeparator());
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<Integer> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new FractionProcessor(this.decimalSeparator, this.element, this.minDigits, this.maxDigits, this.fixedWidth, ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue(), (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART));
    }

    ChronoEntity<?> update(ChronoEntity<?> chronoEntity, ChronoEntity<?> chronoEntity2) {
        FractionalElement fractionalElement = FractionalElement.FRACTION;
        if (!chronoEntity2.contains(fractionalElement)) {
            return chronoEntity;
        }
        int realValue = getRealValue((BigDecimal) chronoEntity2.get(fractionalElement), ((Integer) chronoEntity.getMinimum(this.element)).intValue(), ((Integer) chronoEntity.getMaximum(this.element)).intValue());
        chronoEntity2.with(fractionalElement, (Object) null);
        chronoEntity2.with(this.element, realValue);
        return chronoEntity.with(this.element, realValue);
    }

    private int getRealValue(BigDecimal bigDecimal, int i, int i2) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(i);
        return bigDecimal.multiply(BigDecimal.valueOf(i2).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).intValueExact();
    }

    private static BigDecimal toDecimal(Number number) {
        return BigDecimal.valueOf(number.longValue());
    }

    private boolean hasDecimalSeparator() {
        return this.decimalSeparator != null;
    }
}
