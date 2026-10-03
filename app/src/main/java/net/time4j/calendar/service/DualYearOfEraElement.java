package net.time4j.calendar.service;

import java.io.IOException;
import java.text.ParsePosition;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;
import net.time4j.format.NumberSystem;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.DualFormatElement;

/* JADX INFO: loaded from: classes6.dex */
public abstract class DualYearOfEraElement<T extends ChronoEntity<T>> extends StdIntegerDateElement<T> implements DualFormatElement {
    protected abstract NumberSystem getNumberSystem(AttributeQuery attributeQuery);

    public DualYearOfEraElement(Class<T> cls, int i, int i2, char c) {
        super("YEAR_OF_ERA", cls, i, i2, c, null, null);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0022 A[PHI: r1
  0x0022: PHI (r1v3 int) = (r1v2 int), (r1v7 int), (r1v8 int) binds: [B:3:0x0017, B:5:0x001a, B:7:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // net.time4j.format.TextElement
    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
        int i;
        char cCharAt;
        NumberSystem numberSystem = getNumberSystem(attributeQuery);
        int i2 = AnonymousClass1.$SwitchMap$net$time4j$format$TextWidth[((TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.NARROW)).ordinal()];
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                i3 = 3;
                if (i2 != 3) {
                    i = 4;
                } else {
                    i = i3;
                }
            } else {
                i = i3;
            }
        } else {
            i = i3;
        }
        AttributeKey<Character> attributeKey = Attributes.ZERO_DIGIT;
        if (attributeQuery.contains(attributeKey)) {
            cCharAt = ((Character) attributeQuery.get(attributeKey)).charValue();
        } else {
            cCharAt = numberSystem.isDecimal() ? numberSystem.getDigits().charAt(0) : '0';
        }
        print(chronoDisplay, appendable, attributeQuery, numberSystem, cCharAt, i, 10);
    }

    /* JADX INFO: renamed from: net.time4j.calendar.service.DualYearOfEraElement$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$TextWidth;

        static {
            int[] iArr = new int[TextWidth.values().length];
            $SwitchMap$net$time4j$format$TextWidth = iArr;
            try {
                iArr[TextWidth.NARROW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$format$TextWidth[TextWidth.SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$format$TextWidth[TextWidth.ABBREVIATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // net.time4j.format.internal.DualFormatElement
    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, NumberSystem numberSystem, char c, int i, int i2) throws IOException, ChronoException {
        String numeral = numberSystem.toNumeral(chronoDisplay.getInt(this));
        if (numberSystem.isDecimal()) {
            int length = numeral.length();
            for (int i3 = 0; i3 < i - length; i3++) {
                appendable.append(c);
            }
        }
        appendable.append(numeral);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // net.time4j.format.TextElement
    public Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        char cCharAt;
        int i;
        NumberSystem numberSystem = getNumberSystem(attributeQuery);
        int index = parsePosition.getIndex();
        AttributeKey<Character> attributeKey = Attributes.ZERO_DIGIT;
        int i2 = 0;
        if (attributeQuery.contains(attributeKey)) {
            cCharAt = ((Character) attributeQuery.get(attributeKey)).charValue();
        } else {
            cCharAt = numberSystem.isDecimal() ? numberSystem.getDigits().charAt(0) : '0';
        }
        Leniency leniency = numberSystem.isDecimal() ? Leniency.SMART : (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
        long integer = 0;
        if (numberSystem.isDecimal()) {
            int iMin = Math.min(index + 9, charSequence.length());
            i = index;
            for (int i3 = i; i3 < iMin; i3++) {
                int iCharAt = charSequence.charAt(i3) - cCharAt;
                if (iCharAt < 0 || iCharAt > 9) {
                    break;
                }
                integer = (integer * 10) + ((long) iCharAt);
                i++;
            }
        } else {
            int length = charSequence.length();
            for (int i4 = index; i4 < length && numberSystem.contains(charSequence.charAt(i4)); i4++) {
                i2++;
            }
            if (i2 > 0) {
                int i5 = index + i2;
                integer = numberSystem.toInteger(charSequence.subSequence(index, i5).toString(), leniency);
                i = i5;
            } else {
                i = index;
            }
        }
        if (i == index || integer > 2147483647L) {
            parsePosition.setErrorIndex(index);
            return null;
        }
        parsePosition.setIndex(i);
        return Integer.valueOf((int) integer);
    }

    @Override // net.time4j.format.internal.DualFormatElement
    public Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery, ChronoEntity<?> chronoEntity) {
        return parse(charSequence, parsePosition, attributeQuery);
    }
}
