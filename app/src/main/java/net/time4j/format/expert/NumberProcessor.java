package net.time4j.format.expert;

import ch.qos.logback.core.CoreConstants;
import com.google.crypto.tink.shaded.protobuf.DescriptorProtos;
import com.google.firebase.perf.util.Constants;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.IOException;
import java.util.Set;
import net.time4j.PlainDate;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;
import net.time4j.format.NumberSystem;
import net.time4j.format.NumericalElement;
import net.time4j.format.internal.DualFormatElement;

/* JADX INFO: loaded from: classes3.dex */
class NumberProcessor<V> implements FormatProcessor<V> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int[] THRESHOLDS = {9, 99, 999, 9999, DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    private final ChronoElement<V> element;
    private final boolean fixedInt;
    private final boolean fixedWidth;
    private final Leniency lenientMode;
    private final int maxDigits;
    private final int minDigits;
    private final NumberSystem numberSystem;
    private final int protectedLength;
    private final boolean protectedMode;
    private final int reserved;
    private final int scaleOfNumsys;
    private final SignPolicy signPolicy;
    private final boolean yearOfEra;
    private final char zeroDigit;

    @Override // net.time4j.format.expert.FormatProcessor
    public boolean isNumerical() {
        return true;
    }

    NumberProcessor(ChronoElement<V> chronoElement, boolean z, int i, int i2, SignPolicy signPolicy, boolean z2) {
        this(chronoElement, z, i, i2, signPolicy, z2, 0, '0', NumberSystem.ARABIC, Leniency.SMART, 0, false);
    }

    private NumberProcessor(ChronoElement<V> chronoElement, boolean z, int i, int i2, SignPolicy signPolicy, boolean z2, int i3, char c, NumberSystem numberSystem, Leniency leniency, int i4, boolean z3) {
        this.element = chronoElement;
        this.fixedWidth = z;
        this.minDigits = i;
        this.maxDigits = i2;
        this.signPolicy = signPolicy;
        this.protectedMode = z2;
        this.fixedInt = z3;
        if (chronoElement == null) {
            throw new NullPointerException("Missing element.");
        }
        if (signPolicy == null) {
            throw new NullPointerException("Missing sign policy.");
        }
        if (i < 1) {
            throw new IllegalArgumentException("Not positive: " + i);
        }
        if (i > i2) {
            throw new IllegalArgumentException("Max smaller than min: " + i2 + " < " + i);
        }
        if (z && i != i2) {
            throw new IllegalArgumentException("Variable width in fixed-width-mode: " + i2 + " != " + i);
        }
        if (z && signPolicy != SignPolicy.SHOW_NEVER) {
            throw new IllegalArgumentException("Sign policy must be SHOW_NEVER in fixed-width-mode.");
        }
        int scale = getScale(numberSystem);
        if (numberSystem.isDecimal()) {
            if (i > scale) {
                throw new IllegalArgumentException("Min digits out of range: " + i);
            }
            if (i2 > scale) {
                throw new IllegalArgumentException("Max digits out of range: " + i2);
            }
        }
        this.yearOfEra = chronoElement.name().equals("YEAR_OF_ERA");
        this.reserved = i3;
        this.zeroDigit = c;
        this.numberSystem = numberSystem;
        this.lenientMode = leniency;
        this.protectedLength = i4;
        this.scaleOfNumsys = scale;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0207 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0209  */
    /* JADX WARN: Code duplicated, block: B:105:0x023b  */
    /* JADX WARN: Code duplicated, block: B:108:0x0241  */
    /* JADX WARN: Code duplicated, block: B:110:0x0247  */
    /* JADX WARN: Code duplicated, block: B:111:0x024d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0253  */
    /* JADX WARN: Code duplicated, block: B:115:0x0262  */
    /* JADX WARN: Code duplicated, block: B:123:0x0272  */
    /* JADX WARN: Code duplicated, block: B:126:0x0278  */
    /* JADX WARN: Code duplicated, block: B:129:0x0280 A[LOOP:2: B:127:0x027c->B:129:0x0280, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:132:0x028b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x028d  */
    /* JADX WARN: Code duplicated, block: B:135:0x0290  */
    /* JADX WARN: Code duplicated, block: B:136:0x0294  */
    /* JADX WARN: Code duplicated, block: B:138:0x0297  */
    /* JADX WARN: Code duplicated, block: B:139:0x029d  */
    /* JADX WARN: Code duplicated, block: B:141:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:144:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:146:0x02b7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:148:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:149:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:150:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:159:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:161:0x0312  */
    /* JADX WARN: Code duplicated, block: B:56:0x0136  */
    /* JADX WARN: Code duplicated, block: B:58:0x014f  */
    /* JADX WARN: Code duplicated, block: B:60:0x0159 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x015b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x015d  */
    /* JADX WARN: Code duplicated, block: B:64:0x015f  */
    /* JADX WARN: Code duplicated, block: B:66:0x016a  */
    /* JADX WARN: Code duplicated, block: B:68:0x016e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0186  */
    /* JADX WARN: Code duplicated, block: B:71:0x0188  */
    /* JADX WARN: Code duplicated, block: B:74:0x018f  */
    /* JADX WARN: Code duplicated, block: B:75:0x0192  */
    /* JADX WARN: Code duplicated, block: B:77:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:79:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:81:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:83:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:84:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:85:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:88:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:90:0x01db  */
    /* JADX WARN: Code duplicated, block: B:91:0x01dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x01df  */
    /* JADX WARN: Code duplicated, block: B:96:0x01ed A[LOOP:1: B:94:0x01ea->B:96:0x01ed, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x0201  */
    /* JADX WARN: Instruction removed from duplicated block: B:159:0x02f9, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:161:0x0312, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.time4j.format.expert.FormatProcessor
    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        NumberSystem numberSystem;
        char cCharAt;
        char cCharAt2;
        Class<V> type;
        boolean zIsDecimal;
        String numeral;
        ChronoElement<V> chronoElement;
        boolean z2;
        int iPrintToInt;
        int iAbs;
        boolean z3;
        int length;
        long jLongValue;
        String string;
        String str;
        int i;
        int i2;
        int length2;
        int i3;
        int i4;
        int i5;
        char[] charArray;
        int i6;
        int i7;
        int i8;
        int i9;
        int length3 = appendable instanceof CharSequence ? ((CharSequence) appendable).length() : -1;
        if (z) {
            numberSystem = this.numberSystem;
            cCharAt = this.zeroDigit;
        } else {
            numberSystem = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
            AttributeKey<Character> attributeKey = Attributes.ZERO_DIGIT;
            if (attributeQuery.contains(attributeKey)) {
                cCharAt = ((Character) attributeQuery.get(attributeKey)).charValue();
            } else {
                cCharAt = numberSystem.isDecimal() ? numberSystem.getDigits().charAt(0) : '0';
            }
        }
        if (z && this.fixedInt) {
            int i10 = chronoDisplay.getInt(this.element);
            if (i10 < 0) {
                if (i10 == Integer.MIN_VALUE) {
                    return -1;
                }
                throw new IllegalArgumentException("Negative value not allowed according to sign policy.");
            }
            int length4 = length(i10);
            if (length4 > this.maxDigits) {
                throw new IllegalArgumentException("Element " + this.element.name() + " cannot be printed as the formatted value " + i10 + " exceeds the maximum width of " + this.maxDigits + ".");
            }
            int i11 = this.minDigits;
            int i12 = 0;
            for (int i13 = 0; i13 < i11 - length4; i13++) {
                appendable.append('0');
                i12++;
            }
            if (length4 == 2) {
                appendTwoDigits(i10, appendable, '0');
            } else if (length4 == 1) {
                appendable.append((char) (i10 + 48));
            } else if (i10 >= 2000 && i10 < 2100) {
                appendable.append('2');
                appendable.append('0');
                appendTwoDigits(i10 - Constants.MAX_URL_LENGTH, appendable, '0');
            } else if (i10 >= 1900 && i10 < 2000) {
                appendable.append('1');
                appendable.append('9');
                appendTwoDigits(i10 - 1900, appendable, '0');
            } else {
                appendable.append(Integer.toString(i10));
            }
            length2 = i12 + length4;
            i9 = -1;
            i8 = length3;
        } else {
            if (this.yearOfEra) {
                ChronoElement<V> chronoElement2 = this.element;
                if (chronoElement2 instanceof DualFormatElement) {
                    DualFormatElement dualFormatElement = (DualFormatElement) DualFormatElement.class.cast(chronoElement2);
                    StringBuilder sb = new StringBuilder();
                    dualFormatElement.print(chronoDisplay, sb, attributeQuery, numberSystem, cCharAt, this.minDigits, this.maxDigits);
                    appendable.append(sb.toString());
                    length2 = sb.length();
                    length3 = length3;
                } else {
                    cCharAt2 = numberSystem.getDigits().charAt(0);
                    type = this.element.getType();
                    zIsDecimal = numberSystem.isDecimal();
                    numeral = null;
                    if (type == Integer.class) {
                        i7 = chronoDisplay.getInt(this.element);
                        if (i7 == Integer.MIN_VALUE) {
                            return -1;
                        }
                        if (i7 < 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        iAbs = Math.abs(i7);
                        length = length(iAbs);
                    } else if (type == Long.class) {
                        jLongValue = ((Long) Long.class.cast(chronoDisplay.get(this.element))).longValue();
                        if (jLongValue < 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (jLongValue == Long.MIN_VALUE) {
                            string = "9223372036854775808";
                        } else {
                            string = Long.toString(Math.abs(jLongValue));
                        }
                        numeral = string;
                        length = numeral.length();
                        cCharAt2 = '0';
                        iAbs = Integer.MIN_VALUE;
                    } else {
                        if (Enum.class.isAssignableFrom(type)) {
                            throw new IllegalArgumentException("Not formattable: " + this.element);
                        }
                        chronoElement = this.element;
                        if (chronoElement instanceof NumericalElement) {
                            iPrintToInt = ((NumericalElement) this.element).printToInt(chronoDisplay.get(chronoElement), chronoDisplay, attributeQuery);
                            if (iPrintToInt < 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } else {
                            z2 = false;
                            iPrintToInt = Integer.MIN_VALUE;
                        }
                        if (iPrintToInt != Integer.MIN_VALUE) {
                            throw new IllegalArgumentException("Cannot print: " + this.element);
                        }
                        iAbs = Math.abs(iPrintToInt);
                        z3 = z2;
                        length = length(iAbs);
                    }
                    if (zIsDecimal) {
                        if (cCharAt == cCharAt2) {
                            if (numeral == null) {
                                numeral = numberSystem.toNumeral(iAbs);
                            }
                            charArray = numeral.toCharArray();
                            for (i6 = 0; i6 < charArray.length; i6++) {
                                charArray[i6] = (char) (charArray[i6] + (cCharAt - cCharAt2));
                            }
                            numeral = new String(charArray);
                        }
                        if (length > this.maxDigits) {
                            if (numeral == null) {
                                numeral = numberSystem.toNumeral(iAbs);
                            }
                            throw new IllegalArgumentException("Element " + this.element.name() + " cannot be printed as the formatted value " + numeral + " exceeds the maximum width of " + this.maxDigits + ".");
                        }
                    } else {
                        length3 = length3;
                    }
                    str = numeral;
                    if (z3) {
                        if (this.signPolicy != SignPolicy.SHOW_NEVER) {
                            throw new IllegalArgumentException("Negative value not allowed according to sign policy.");
                        }
                        appendable.append(CoreConstants.DASH_CHAR);
                    } else {
                        i = AnonymousClass1.$SwitchMap$net$time4j$format$expert$SignPolicy[this.signPolicy.ordinal()];
                        if (i == 1) {
                            appendable.append('+');
                        } else {
                            if (i == 2 && zIsDecimal && length > this.minDigits) {
                                appendable.append('+');
                            } else {
                                i2 = 0;
                            }
                            if (zIsDecimal) {
                                i3 = this.minDigits;
                                i4 = i2;
                                for (i5 = 0; i5 < i3 - length; i5++) {
                                    appendable.append(cCharAt);
                                    i4++;
                                }
                                i2 = i4;
                            }
                            if (str == null) {
                                appendable.append(str);
                                length = str.length();
                            } else if (zIsDecimal) {
                                length = numberSystem.toNumeral(iAbs, appendable);
                            } else if (length == 2) {
                                appendTwoDigits(iAbs, appendable, cCharAt);
                            } else if (length == 1) {
                                appendable.append((char) (iAbs + cCharAt));
                            } else if (iAbs < 2000 && iAbs < 2100) {
                                appendable.append((char) (cCharAt + 2));
                                appendable.append(cCharAt);
                                appendTwoDigits(iAbs - Constants.MAX_URL_LENGTH, appendable, cCharAt);
                            } else if (iAbs < 1900 && iAbs < 2000) {
                                appendable.append((char) (cCharAt + 1));
                                appendable.append((char) (cCharAt + '\t'));
                                appendTwoDigits(iAbs - 1900, appendable, cCharAt);
                            } else {
                                appendable.append(numberSystem.toNumeral(iAbs));
                            }
                            length2 = i2 + length;
                        }
                    }
                    i2 = 1;
                    if (zIsDecimal) {
                        i3 = this.minDigits;
                        i4 = i2;
                        while (i5 < i3 - length) {
                            appendable.append(cCharAt);
                            i4++;
                        }
                        i2 = i4;
                    }
                    if (str == null) {
                        appendable.append(str);
                        length = str.length();
                    } else if (zIsDecimal) {
                        length = numberSystem.toNumeral(iAbs, appendable);
                    } else if (length == 2) {
                        appendTwoDigits(iAbs, appendable, cCharAt);
                    } else if (length == 1) {
                        appendable.append((char) (iAbs + cCharAt));
                    } else if (iAbs < 2000) {
                        if (iAbs < 1900) {
                            appendable.append(numberSystem.toNumeral(iAbs));
                        } else {
                            appendable.append(numberSystem.toNumeral(iAbs));
                        }
                    } else if (iAbs < 1900) {
                        appendable.append(numberSystem.toNumeral(iAbs));
                    } else {
                        appendable.append(numberSystem.toNumeral(iAbs));
                    }
                    length2 = i2 + length;
                }
            } else {
                cCharAt2 = numberSystem.getDigits().charAt(0);
                type = this.element.getType();
                zIsDecimal = numberSystem.isDecimal();
                numeral = null;
                if (type == Integer.class) {
                    i7 = chronoDisplay.getInt(this.element);
                    if (i7 == Integer.MIN_VALUE) {
                        return -1;
                    }
                    if (i7 < 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    iAbs = Math.abs(i7);
                    length = length(iAbs);
                } else if (type == Long.class) {
                    jLongValue = ((Long) Long.class.cast(chronoDisplay.get(this.element))).longValue();
                    if (jLongValue < 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (jLongValue == Long.MIN_VALUE) {
                        string = "9223372036854775808";
                    } else {
                        string = Long.toString(Math.abs(jLongValue));
                    }
                    numeral = string;
                    length = numeral.length();
                    cCharAt2 = '0';
                    iAbs = Integer.MIN_VALUE;
                } else {
                    if (Enum.class.isAssignableFrom(type)) {
                        throw new IllegalArgumentException("Not formattable: " + this.element);
                    }
                    chronoElement = this.element;
                    if (chronoElement instanceof NumericalElement) {
                        iPrintToInt = ((NumericalElement) this.element).printToInt(chronoDisplay.get(chronoElement), chronoDisplay, attributeQuery);
                        if (iPrintToInt < 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                        iPrintToInt = Integer.MIN_VALUE;
                    }
                    if (iPrintToInt != Integer.MIN_VALUE) {
                        throw new IllegalArgumentException("Cannot print: " + this.element);
                    }
                    iAbs = Math.abs(iPrintToInt);
                    z3 = z2;
                    length = length(iAbs);
                }
                if (zIsDecimal) {
                    if (cCharAt == cCharAt2) {
                        if (numeral == null) {
                            numeral = numberSystem.toNumeral(iAbs);
                        }
                        charArray = numeral.toCharArray();
                        while (i6 < charArray.length) {
                            charArray[i6] = (char) (charArray[i6] + (cCharAt - cCharAt2));
                        }
                        numeral = new String(charArray);
                    }
                    if (length > this.maxDigits) {
                        if (numeral == null) {
                            numeral = numberSystem.toNumeral(iAbs);
                        }
                        throw new IllegalArgumentException("Element " + this.element.name() + " cannot be printed as the formatted value " + numeral + " exceeds the maximum width of " + this.maxDigits + ".");
                    }
                } else {
                    length3 = length3;
                }
                str = numeral;
                if (z3) {
                    if (this.signPolicy != SignPolicy.SHOW_NEVER) {
                        throw new IllegalArgumentException("Negative value not allowed according to sign policy.");
                    }
                    appendable.append(CoreConstants.DASH_CHAR);
                } else {
                    i = AnonymousClass1.$SwitchMap$net$time4j$format$expert$SignPolicy[this.signPolicy.ordinal()];
                    if (i == 1) {
                        if (i == 2) {
                            appendable.append('+');
                        }
                        i2 = 0;
                        if (zIsDecimal) {
                            i3 = this.minDigits;
                            i4 = i2;
                            while (i5 < i3 - length) {
                                appendable.append(cCharAt);
                                i4++;
                            }
                            i2 = i4;
                        }
                        if (str == null) {
                            appendable.append(str);
                            length = str.length();
                        } else if (zIsDecimal) {
                            length = numberSystem.toNumeral(iAbs, appendable);
                        } else if (length == 2) {
                            appendTwoDigits(iAbs, appendable, cCharAt);
                        } else if (length == 1) {
                            appendable.append((char) (iAbs + cCharAt));
                        } else if (iAbs < 2000) {
                            if (iAbs < 1900) {
                                appendable.append(numberSystem.toNumeral(iAbs));
                            } else {
                                appendable.append(numberSystem.toNumeral(iAbs));
                            }
                        } else if (iAbs < 1900) {
                            appendable.append(numberSystem.toNumeral(iAbs));
                        } else {
                            appendable.append(numberSystem.toNumeral(iAbs));
                        }
                        length2 = i2 + length;
                    } else {
                        appendable.append('+');
                    }
                }
                i2 = 1;
                if (zIsDecimal) {
                    i3 = this.minDigits;
                    i4 = i2;
                    while (i5 < i3 - length) {
                        appendable.append(cCharAt);
                        i4++;
                    }
                    i2 = i4;
                }
                if (str == null) {
                    appendable.append(str);
                    length = str.length();
                } else if (zIsDecimal) {
                    length = numberSystem.toNumeral(iAbs, appendable);
                } else if (length == 2) {
                    appendTwoDigits(iAbs, appendable, cCharAt);
                } else if (length == 1) {
                    appendable.append((char) (iAbs + cCharAt));
                } else if (iAbs < 2000) {
                    if (iAbs < 1900) {
                        appendable.append(numberSystem.toNumeral(iAbs));
                    } else {
                        appendable.append(numberSystem.toNumeral(iAbs));
                    }
                } else if (iAbs < 1900) {
                    appendable.append(numberSystem.toNumeral(iAbs));
                } else {
                    appendable.append(numberSystem.toNumeral(iAbs));
                }
                length2 = i2 + length;
            }
            i8 = length3;
            i9 = -1;
        }
        if (i8 != i9 && length2 > 0 && set != null) {
            set.add(new ElementPosition(this.element, i8, i8 + length2));
        }
        return length2;
    }

    /* JADX INFO: renamed from: net.time4j.format.expert.NumberProcessor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$expert$SignPolicy;

        static {
            int[] iArr = new int[SignPolicy.values().length];
            $SwitchMap$net$time4j$format$expert$SignPolicy = iArr;
            try {
                iArr[SignPolicy.SHOW_ALWAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$format$expert$SignPolicy[SignPolicy.SHOW_WHEN_BIG_NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        int scale;
        char cCharAt;
        boolean z2;
        NumberSystem numberSystem;
        int iMin;
        int i;
        boolean z3;
        int i2;
        long integer;
        int i3;
        int length = charSequence.length();
        int position = parseLog.getPosition();
        if (z && this.fixedInt) {
            if (position >= length) {
                parseLog.setError(position, "Missing digits for: " + this.element.name());
                parseLog.setWarning();
                return;
            }
            char cCharAt2 = charSequence.charAt(position);
            if (cCharAt2 == '-' || cCharAt2 == '+') {
                parseLog.setError(position, "Sign not allowed due to sign policy.");
                return;
            }
            int i4 = this.minDigits + position;
            int iMin2 = Math.min(length, i4);
            int i5 = position;
            long j = 0;
            while (i5 < iMin2) {
                int iCharAt = charSequence.charAt(i5) - '0';
                if (iCharAt < 0 || iCharAt > 9) {
                    break;
                }
                j = (j * 10) + ((long) iCharAt);
                i5++;
            }
            if (j > 2147483647L) {
                parseLog.setError(position, "Parsed number does not fit into an integer: " + j);
                return;
            }
            if (i5 < i4) {
                if (i5 == position) {
                    parseLog.setError(position, "Digit expected.");
                    return;
                }
                parseLog.setError(position, "Not enough digits found for: " + this.element.name());
                return;
            }
            parsedEntity.put((ChronoElement<?>) this.element, (int) j);
            parseLog.setPosition(i5);
            return;
        }
        int iIntValue = z ? this.protectedLength : ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue();
        if (iIntValue > 0) {
            length -= iIntValue;
        }
        if (position >= length) {
            parseLog.setError(position, "Missing digits for: " + this.element.name());
            parseLog.setWarning();
            return;
        }
        if (this.yearOfEra) {
            ChronoElement<V> chronoElement = this.element;
            if (chronoElement instanceof DualFormatElement) {
                Integer num = ((DualFormatElement) DualFormatElement.class.cast(chronoElement)).parse(charSequence, parseLog.getPP(), attributeQuery, parsedEntity);
                if (!parseLog.isError()) {
                    if (num == null) {
                        parseLog.setError(position, "No interpretable value.");
                        return;
                    } else {
                        parsedEntity.put((ChronoElement<?>) this.element, (Object) num);
                        return;
                    }
                }
                parseLog.setError(parseLog.getErrorIndex(), "Unparseable element: " + this.element.name());
                return;
            }
        }
        if (z) {
            NumberSystem numberSystem2 = this.numberSystem;
            boolean zIsDecimal = numberSystem2.isDecimal();
            scale = this.scaleOfNumsys;
            cCharAt = this.zeroDigit;
            z2 = zIsDecimal;
            numberSystem = numberSystem2;
        } else {
            NumberSystem numberSystem3 = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
            boolean zIsDecimal2 = numberSystem3.isDecimal();
            scale = getScale(numberSystem3);
            AttributeKey<Character> attributeKey = Attributes.ZERO_DIGIT;
            if (attributeQuery.contains(attributeKey)) {
                cCharAt = ((Character) attributeQuery.get(attributeKey)).charValue();
            } else {
                cCharAt = zIsDecimal2 ? numberSystem3.getDigits().charAt(0) : '0';
            }
            z2 = zIsDecimal2;
            numberSystem = numberSystem3;
        }
        Leniency leniency = z ? this.lenientMode : (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
        if (!z2 || (!this.fixedWidth && leniency.isLax())) {
            iMin = scale;
            i = 1;
        } else {
            i = this.minDigits;
            iMin = this.maxDigits;
        }
        char cCharAt3 = charSequence.charAt(position);
        if (cCharAt3 == '-' || cCharAt3 == '+') {
            if (this.signPolicy == SignPolicy.SHOW_NEVER && (this.fixedWidth || leniency.isStrict())) {
                parseLog.setError(position, "Sign not allowed due to sign policy.");
                return;
            } else if (this.signPolicy == SignPolicy.SHOW_WHEN_NEGATIVE && cCharAt3 == '+' && leniency.isStrict()) {
                parseLog.setError(position, "Positive sign not allowed due to sign policy.");
                return;
            } else {
                z3 = cCharAt3 == '-';
                position++;
            }
        } else {
            if (this.signPolicy == SignPolicy.SHOW_ALWAYS && leniency.isStrict()) {
                parseLog.setError(position, "Missing sign of number.");
                return;
            }
            z3 = false;
        }
        if (position >= length) {
            parseLog.setError(position, "Missing digits for: " + this.element.name());
            return;
        }
        if (!this.fixedWidth && this.reserved > 0 && iIntValue <= 0) {
            if (z2) {
                i3 = 0;
                for (int i6 = position; i6 < length; i6++) {
                    int iCharAt2 = charSequence.charAt(i6) - cCharAt;
                    if (iCharAt2 < 0 || iCharAt2 > 9) {
                        break;
                    }
                    i3++;
                }
            } else {
                i3 = 0;
                for (int i7 = position; i7 < length && numberSystem.contains(charSequence.charAt(i7)); i7++) {
                    i3++;
                }
            }
            iMin = Math.min(iMin, i3 - this.reserved);
        }
        int i8 = i + position;
        int iMin3 = Math.min(length, iMin + position);
        if (z2) {
            i2 = position;
            integer = 0;
            while (i2 < iMin3) {
                int iCharAt3 = charSequence.charAt(i2) - cCharAt;
                if (iCharAt3 < 0 || iCharAt3 > 9) {
                    break;
                }
                integer = (integer * 10) + ((long) iCharAt3);
                i2++;
            }
        } else {
            i2 = position;
            int i9 = 0;
            while (i2 < iMin3 && numberSystem.contains(charSequence.charAt(i2))) {
                i9++;
                i2++;
            }
            if (i9 > 0) {
                try {
                    integer = numberSystem.toInteger(charSequence.subSequence(i2 - i9, i2).toString(), leniency);
                } catch (NumberFormatException e) {
                    parseLog.setError(position, e.getMessage());
                    return;
                }
            } else {
                integer = 0;
            }
        }
        Class<V> type = this.element.getType();
        if (integer > 2147483647L && type == Integer.class) {
            parseLog.setError(position, "Parsed number does not fit into an integer: " + integer);
            return;
        }
        if (i2 < i8) {
            if (i2 == position) {
                parseLog.setError(position, "Digit expected.");
                return;
            } else if (this.fixedWidth || !leniency.isLax()) {
                parseLog.setError(position, "Not enough digits found for: " + this.element.name());
                return;
            }
        }
        if (z3) {
            if (integer == 0 && leniency.isStrict()) {
                parseLog.setError(position - 1, "Negative zero is not allowed.");
                return;
            }
            integer = -integer;
        } else if (this.signPolicy == SignPolicy.SHOW_WHEN_BIG_NUMBER && leniency.isStrict() && z2) {
            if (cCharAt3 == '+' && i2 <= i8) {
                parseLog.setError(position - 1, "Positive sign only allowed for big number.");
            } else if (cCharAt3 != '+' && i2 > i8) {
                parseLog.setError(position, "Positive sign must be present for big number.");
            }
        }
        if (type == Integer.class) {
            parsedEntity.put((ChronoElement<?>) this.element, (int) integer);
        } else if (type == Long.class) {
            parsedEntity.put((ChronoElement<?>) this.element, (Object) Long.valueOf(integer));
        } else if (this.element == PlainDate.MONTH_OF_YEAR) {
            parsedEntity.put(PlainDate.MONTH_AS_NUMBER, (int) integer);
        } else {
            if (!Enum.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException("Not parseable: " + this.element);
            }
            ChronoElement<V> chronoElement2 = this.element;
            if (!(chronoElement2 instanceof NumericalElement) || !((NumericalElement) chronoElement2).parseFromInt(parsedEntity, (int) integer)) {
                if (cCharAt3 == '-' || cCharAt3 == '+') {
                    position--;
                }
                parseLog.setError(position, "[" + this.element.name() + "] No enum found for value: " + integer);
                return;
            }
        }
        parseLog.setPosition(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NumberProcessor)) {
            return false;
        }
        NumberProcessor numberProcessor = (NumberProcessor) obj;
        return this.element.equals(numberProcessor.element) && this.fixedWidth == numberProcessor.fixedWidth && this.minDigits == numberProcessor.minDigits && this.maxDigits == numberProcessor.maxDigits && this.signPolicy == numberProcessor.signPolicy && this.protectedMode == numberProcessor.protectedMode;
    }

    public int hashCode() {
        return (this.element.hashCode() * 7) + ((this.minDigits + (this.maxDigits * 10)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(", fixed-width-mode=");
        sb.append(this.fixedWidth);
        sb.append(", min-digits=");
        sb.append(this.minDigits);
        sb.append(", max-digits=");
        sb.append(this.maxDigits);
        sb.append(", sign-policy=");
        sb.append(this.signPolicy);
        sb.append(", protected-mode=");
        sb.append(this.protectedMode);
        sb.append(']');
        return sb.toString();
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public ChronoElement<V> getElement() {
        return this.element;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<V> withElement(ChronoElement<V> chronoElement) {
        return (this.protectedMode || this.element == chronoElement) ? this : new NumberProcessor(chronoElement, this.fixedWidth, this.minDigits, this.maxDigits, this.signPolicy, false);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0062  */
    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<V> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        char c;
        char cCharAt;
        boolean z;
        AttributeKey<NumberSystem> attributeKey = Attributes.NUMBER_SYSTEM;
        NumberSystem numberSystem = NumberSystem.ARABIC;
        NumberSystem numberSystem2 = (NumberSystem) attributeQuery.get(attributeKey, numberSystem);
        AttributeKey<Character> attributeKey2 = Attributes.ZERO_DIGIT;
        if (attributeQuery.contains(attributeKey2)) {
            cCharAt = ((Character) attributeQuery.get(attributeKey2)).charValue();
        } else {
            if (numberSystem2.isDecimal()) {
                cCharAt = numberSystem2.getDigits().charAt(0);
            } else {
                c = '0';
            }
            int iIntValue = ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue();
            if (numberSystem2 != numberSystem && c == '0' && this.fixedWidth && iIntValue == 0 && this.element.getType() == Integer.class && !this.yearOfEra) {
                z = true;
            } else {
                z = false;
            }
            return new NumberProcessor(this.element, this.fixedWidth, this.minDigits, this.maxDigits, this.signPolicy, this.protectedMode, i, c, numberSystem2, (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART), iIntValue, z);
        }
        c = cCharAt;
        int iIntValue2 = ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue();
        if (numberSystem2 != numberSystem) {
            z = false;
        } else {
            z = false;
        }
        return new NumberProcessor(this.element, this.fixedWidth, this.minDigits, this.maxDigits, this.signPolicy, this.protectedMode, i, c, numberSystem2, (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART), iIntValue2, z);
    }

    private int getScale(NumberSystem numberSystem) {
        if (!numberSystem.isDecimal()) {
            return 100;
        }
        Class<V> type = this.element.getType();
        if (type == Integer.class) {
            return 10;
        }
        return type == Long.class ? 18 : 9;
    }

    private static int length(int i) {
        int i2;
        int i3 = 0;
        do {
            i2 = THRESHOLDS[i3];
            i3++;
        } while (i > i2);
        return i3;
    }

    private static void appendTwoDigits(int i, Appendable appendable, char c) throws IOException {
        int i2 = (i * b.i) >>> 10;
        appendable.append((char) (i2 + c));
        appendable.append((char) ((i - ((i2 << 3) + (i2 << 1))) + c));
    }
}
