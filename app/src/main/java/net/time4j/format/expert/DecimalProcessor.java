package net.time4j.format.expert;

import com.google.android.gms.internal.measurement.zzai$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Set;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;

/* JADX INFO: loaded from: classes3.dex */
final class DecimalProcessor implements FormatProcessor<BigDecimal> {
    private final FormatProcessor<Void> decimalSeparator;
    private final ChronoElement<BigDecimal> element;
    private final Leniency lenientMode;
    private final int precision;
    private final int protectedLength;
    private final int scale;
    private final char zeroDigit;

    @Override // net.time4j.format.expert.FormatProcessor
    public boolean isNumerical() {
        return true;
    }

    DecimalProcessor(ChronoElement<BigDecimal> chronoElement, int i, int i2) {
        this.decimalSeparator = new LiteralProcessor(Attributes.DECIMAL_SEPARATOR);
        this.element = chronoElement;
        this.precision = i;
        this.scale = i2;
        if (chronoElement == null) {
            throw new NullPointerException("Missing element.");
        }
        if (i < 2) {
            throw new IllegalArgumentException("Precision must be >= 2: " + i);
        }
        if (i2 < i) {
            if (i2 < 1) {
                throw new IllegalArgumentException("Scale must be bigger than zero.");
            }
            this.zeroDigit = '0';
            this.lenientMode = Leniency.SMART;
            this.protectedLength = 0;
            return;
        }
        throw new IllegalArgumentException("Precision must be bigger than scale: " + i + "," + i2);
    }

    private DecimalProcessor(FormatProcessor<Void> formatProcessor, ChronoElement<BigDecimal> chronoElement, int i, int i2, char c, Leniency leniency, int i3) {
        this.decimalSeparator = formatProcessor;
        this.element = chronoElement;
        this.precision = i;
        this.scale = i2;
        this.zeroDigit = c;
        this.lenientMode = leniency;
        this.protectedLength = i3;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        char cCharValue;
        String plainString = ((BigDecimal) chronoDisplay.get(this.element)).setScale(this.scale, RoundingMode.FLOOR).toPlainString();
        int length = plainString.length();
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            if (plainString.charAt(i4) == '.') {
                i3 = i4;
            } else if (i3 >= 0) {
                i2++;
            } else {
                i++;
            }
        }
        int i5 = this.precision;
        int i6 = (i5 - this.scale) - i;
        if (i6 < 0) {
            throw new IllegalArgumentException("Integer part of element value exceeds fixed format width: " + plainString);
        }
        StringBuilder sb = new StringBuilder(i5 + 1);
        for (int i7 = 0; i7 < i6; i7++) {
            sb.append('0');
        }
        for (int i8 = 0; i8 < i; i8++) {
            sb.append(plainString.charAt(i8));
        }
        this.decimalSeparator.print(chronoDisplay, sb, attributeQuery, set, z);
        for (int i9 = 0; i9 < i2; i9++) {
            sb.append(plainString.charAt(i + 1 + i9));
        }
        for (int i10 = 0; i10 < this.scale - i2; i10++) {
            sb.append('0');
        }
        String string = sb.toString();
        if (z) {
            cCharValue = this.zeroDigit;
        } else {
            cCharValue = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue();
        }
        if (cCharValue != '0') {
            char[] charArray = string.toCharArray();
            for (int i11 = 0; i11 < charArray.length; i11++) {
                char c = charArray[i11];
                if (c >= '0' && c <= '9') {
                    charArray[i11] = (char) (c + (cCharValue - '0'));
                }
            }
            string = new String(charArray);
        }
        int length2 = string.length();
        int length3 = appendable instanceof CharSequence ? ((CharSequence) appendable).length() : -1;
        appendable.append(string);
        if (length3 != -1 && length2 > 0 && set != null) {
            set.add(new ElementPosition(this.element, length3, length3 + length2));
        }
        return length2;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        char cCharValue;
        int i;
        int i2;
        int iCharAt;
        int length = charSequence.length();
        int position = parseLog.getPosition();
        int iIntValue = z ? this.protectedLength : ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue();
        if (iIntValue > 0) {
            length -= iIntValue;
        }
        int i3 = length;
        if (position >= i3) {
            parseLog.setError(position, "Missing digits for: " + this.element.name());
            parseLog.setWarning();
            return;
        }
        if (z) {
            cCharValue = this.zeroDigit;
        } else {
            cCharValue = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue();
        }
        char c = cCharValue;
        int iMin = Math.min(i3, position + 18);
        boolean z2 = true;
        int i4 = 0;
        long j = 0;
        while (true) {
            i = position + i4;
            if (i >= iMin) {
                break;
            }
            int iCharAt2 = charSequence.charAt(i) - c;
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                if (!z2) {
                    break;
                }
                parseLog.setError(position, "Digit expected.");
                return;
            } else {
                j = (j * 10) + ((long) iCharAt2);
                i4++;
                z2 = false;
            }
        }
        Leniency leniency = z ? this.lenientMode : (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
        if (!leniency.isLax() && i4 != this.precision - this.scale) {
            parseLog.setError(position, "Integer part of decimal element does not match expected width.");
            return;
        }
        parseLog.setPosition(i);
        this.decimalSeparator.parse(charSequence, parseLog, attributeQuery, null, z);
        if (parseLog.isError()) {
            return;
        }
        int i5 = i + 1;
        int iMin2 = Math.min(i3, i + 19);
        int i6 = 0;
        long j2 = 0;
        while (true) {
            i2 = i5 + i6;
            if (i2 >= iMin2 || (iCharAt = charSequence.charAt(i2) - c) < 0 || iCharAt > 9) {
                break;
            }
            j2 = (j2 * 10) + ((long) iCharAt);
            i6++;
        }
        if (i6 == 0) {
            parseLog.setError(i5, "Fraction part expected.");
        } else if (leniency.isStrict() && i6 != this.scale) {
            parseLog.setError(i5, "Fraction part of decimal element does not match expected width.");
        } else {
            parseLog.setPosition(i2);
            parsedEntity.put(this.element, zzai$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(j).add(new BigDecimal(BigInteger.valueOf(j2), i6))));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecimalProcessor)) {
            return false;
        }
        DecimalProcessor decimalProcessor = (DecimalProcessor) obj;
        return this.element.equals(decimalProcessor.element) && this.precision == decimalProcessor.precision && this.scale == decimalProcessor.scale;
    }

    public int hashCode() {
        return (this.element.hashCode() * 7) + ((this.scale + (this.precision * 10)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(DecimalProcessor.class.getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(", precision=");
        sb.append(this.precision);
        sb.append(", scale=");
        sb.append(this.scale);
        sb.append(']');
        return sb.toString();
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public ChronoElement<BigDecimal> getElement() {
        return this.element;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<BigDecimal> withElement(ChronoElement<BigDecimal> chronoElement) {
        return this.element == chronoElement ? this : new DecimalProcessor(chronoElement, this.precision, this.scale);
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<BigDecimal> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new DecimalProcessor(this.decimalSeparator, this.element, this.precision, this.scale, ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue(), (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART), ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue());
    }
}
