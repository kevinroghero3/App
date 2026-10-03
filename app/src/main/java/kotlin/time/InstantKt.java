package kotlin.time;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import ch.qos.logback.core.CoreConstants;
import java.io.IOException;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class InstantKt {
    private static final int DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    private static final long DISTANT_FUTURE_SECONDS = 3093527980800L;
    private static final long DISTANT_PAST_SECONDS = -3217862419201L;
    private static final int HOURS_PER_DAY = 24;
    private static final long MAX_SECOND = 31556889864403199L;
    private static final int MILLIS_PER_SECOND = 1000;
    private static final long MIN_SECOND = -31557014167219200L;
    private static final int NANOS_PER_MILLI = 1000000;
    public static final int NANOS_PER_SECOND = 1000000000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int[] POWERS_OF_TEN = {1, 10, 100, 1000, 10000, AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength, 1000000, 10000000, 100000000, 1000000000};
    private static final int[] asciiDigitPositionsInIsoStringAfterYear = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14};
    private static final int[] colonsInIsoOffsetString = {3, 6};
    private static final int[] asciiDigitsInIsoOffsetString = {1, 2, 4, 5, 7, 8};

    public static /* synthetic */ void isDistantFuture$annotations(Instant instant) {
    }

    public static /* synthetic */ void isDistantPast$annotations(Instant instant) {
    }

    private static final int monthLength(int i, boolean z) {
        if (i != 2) {
            return (i == 4 || i == 6 || i == 9 || i == 11) ? 30 : 31;
        }
        return z ? 29 : 28;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$1(char c) {
        return c == '-';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$2(char c) {
        return c == '-';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$3(char c) {
        return c == 'T' || c == 't';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$4(char c) {
        return c == ':';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$5(char c) {
        return c == ':';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$6(char c) {
        return '0' <= c && c < ':';
    }

    private static final boolean isDistantPast(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return instant.compareTo(Instant.Companion.getDISTANT_PAST()) <= 0;
    }

    private static final boolean isDistantFuture(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return instant.compareTo(Instant.Companion.getDISTANT_FUTURE()) >= 0;
    }

    private static final Void parseIso$parseFailure(CharSequence charSequence, String str) {
        throw new InstantFormatException(str + " when parsing an Instant from \"" + truncateForErrorMessage(charSequence, 64) + '\"');
    }

    private static final void parseIso$expect(CharSequence charSequence, String str, int i, Function1<? super Character, Boolean> function1) {
        char cCharAt = charSequence.charAt(i);
        if (function1.invoke(Character.valueOf(cCharAt)).booleanValue()) {
            return;
        }
        parseIso$parseFailure(charSequence, "Expected " + str + ", but got '" + cCharAt + "' at position " + i);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Instant parseIso(CharSequence charSequence) {
        int i;
        int i2;
        int i3;
        int i4;
        char cCharAt;
        char cCharAt2;
        if (charSequence.length() <= 0) {
            throw new IllegalArgumentException("An empty string is not a valid Instant");
        }
        char cCharAt3 = charSequence.charAt(0);
        if (cCharAt3 == '+' || cCharAt3 == '-') {
            i = 1;
        } else {
            i = 0;
            cCharAt3 = ' ';
        }
        int iCharAt = 0;
        int i5 = i;
        while (i5 < charSequence.length() && '0' <= (cCharAt2 = charSequence.charAt(i5)) && cCharAt2 < ':') {
            iCharAt = (iCharAt * 10) + (charSequence.charAt(i5) - '0');
            i5++;
        }
        int i6 = i5 - i;
        if (i6 > 10) {
            parseIso$parseFailure(charSequence, "Expected at most 10 digits for the year number, got " + i6 + " digits");
            throw new KotlinNothingValueException();
        }
        if (i6 == 10 && Intrinsics.compare((int) charSequence.charAt(i), 50) >= 0) {
            parseIso$parseFailure(charSequence, "Expected at most 9 digits for the year number or year 1000000000, got " + i6 + " digits");
            throw new KotlinNothingValueException();
        }
        if (i6 < 4) {
            parseIso$parseFailure(charSequence, "The year number must be padded to 4 digits, got " + i6 + " digits");
            throw new KotlinNothingValueException();
        }
        if (cCharAt3 == '+' && i6 == 4) {
            parseIso$parseFailure(charSequence, "The '+' sign at the start is only valid for year numbers longer than 4 digits");
            throw new KotlinNothingValueException();
        }
        if (cCharAt3 == ' ' && i6 != 4) {
            parseIso$parseFailure(charSequence, "A '+' or '-' sign is required for year numbers longer than 4 digits");
            throw new KotlinNothingValueException();
        }
        if (cCharAt3 == '-') {
            iCharAt = -iCharAt;
        }
        int i7 = i5 + 16;
        if (charSequence.length() < i7) {
            parseIso$parseFailure(charSequence, "The input string is too short");
            throw new KotlinNothingValueException();
        }
        parseIso$expect(charSequence, "'-'", i5, new Function1() { // from class: kotlin.time.InstantKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$1(((Character) obj).charValue()));
            }
        });
        parseIso$expect(charSequence, "'-'", i5 + 3, new Function1() { // from class: kotlin.time.InstantKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$2(((Character) obj).charValue()));
            }
        });
        parseIso$expect(charSequence, "'T' or 't'", i5 + 6, new Function1() { // from class: kotlin.time.InstantKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$3(((Character) obj).charValue()));
            }
        });
        parseIso$expect(charSequence, "':'", i5 + 9, new Function1() { // from class: kotlin.time.InstantKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$4(((Character) obj).charValue()));
            }
        });
        parseIso$expect(charSequence, "':'", i5 + 12, new Function1() { // from class: kotlin.time.InstantKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$5(((Character) obj).charValue()));
            }
        });
        for (int i8 : asciiDigitPositionsInIsoStringAfterYear) {
            parseIso$expect(charSequence, "an ASCII digit", i8 + i5, new Function1() { // from class: kotlin.time.InstantKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(InstantKt.parseIso$lambda$6(((Character) obj).charValue()));
                }
            });
        }
        int iso$twoDigitNumber = parseIso$twoDigitNumber(charSequence, i5 + 1);
        int iso$twoDigitNumber2 = parseIso$twoDigitNumber(charSequence, i5 + 4);
        int iso$twoDigitNumber3 = parseIso$twoDigitNumber(charSequence, i5 + 7);
        int iso$twoDigitNumber4 = parseIso$twoDigitNumber(charSequence, i5 + 10);
        int iso$twoDigitNumber5 = parseIso$twoDigitNumber(charSequence, i5 + 13);
        int i9 = i5 + 15;
        if (charSequence.charAt(i9) == '.') {
            i9 = i7;
            int iCharAt2 = 0;
            while (i9 < charSequence.length() && '0' <= (cCharAt = charSequence.charAt(i9)) && cCharAt < ':') {
                iCharAt2 = (iCharAt2 * 10) + (charSequence.charAt(i9) - '0');
                i9++;
            }
            int i10 = i9 - i7;
            if (1 > i10 || i10 >= 10) {
                parseIso$parseFailure(charSequence, "1..9 digits are supported for the fraction of the second, got " + i10 + " digits");
                throw new KotlinNothingValueException();
            }
            i2 = iCharAt2 * POWERS_OF_TEN[9 - i10];
        } else {
            i2 = 0;
        }
        if (i9 >= charSequence.length()) {
            parseIso$parseFailure(charSequence, "The UTC offset at the end of the string is missing");
            throw new KotlinNothingValueException();
        }
        char cCharAt4 = charSequence.charAt(i9);
        if (cCharAt4 == '+' || cCharAt4 == '-') {
            int length = charSequence.length() - i9;
            if (length > 9) {
                parseIso$parseFailure(charSequence, "The UTC offset string \"" + truncateForErrorMessage(charSequence.subSequence(i9, charSequence.length()).toString(), 16) + "\" is too long");
                throw new KotlinNothingValueException();
            }
            if (length % 3 != 0) {
                parseIso$parseFailure(charSequence, "Invalid UTC offset string \"" + charSequence.subSequence(i9, charSequence.length()).toString() + '\"');
                throw new KotlinNothingValueException();
            }
            int[] iArr = colonsInIsoOffsetString;
            int length2 = iArr.length;
            int i11 = 0;
            while (i11 < length2) {
                int i12 = i9 + iArr[i11];
                if (i12 >= charSequence.length()) {
                    break;
                }
                int i13 = length2;
                if (charSequence.charAt(i12) != ':') {
                    parseIso$parseFailure(charSequence, "Expected ':' at index " + i12 + ", got '" + charSequence.charAt(i12) + CoreConstants.SINGLE_QUOTE_CHAR);
                    throw new KotlinNothingValueException();
                }
                i11++;
                length2 = i13;
            }
            int[] iArr2 = asciiDigitsInIsoOffsetString;
            int length3 = iArr2.length;
            int i14 = 0;
            while (i14 < length3) {
                int i15 = iArr2[i14] + i9;
                if (i15 >= charSequence.length()) {
                    break;
                }
                char cCharAt5 = charSequence.charAt(i15);
                int[] iArr3 = iArr2;
                if ('0' > cCharAt5 || cCharAt5 >= ':') {
                    parseIso$parseFailure(charSequence, "Expected an ASCII digit at index " + i15 + ", got '" + charSequence.charAt(i15) + CoreConstants.SINGLE_QUOTE_CHAR);
                    throw new KotlinNothingValueException();
                }
                i14++;
                iArr2 = iArr3;
            }
            int iso$twoDigitNumber6 = parseIso$twoDigitNumber(charSequence, i9 + 1);
            int iso$twoDigitNumber7 = length > 3 ? parseIso$twoDigitNumber(charSequence, i9 + 4) : 0;
            int iso$twoDigitNumber8 = length > 6 ? parseIso$twoDigitNumber(charSequence, i9 + 7) : 0;
            if (iso$twoDigitNumber7 > 59) {
                parseIso$parseFailure(charSequence, "Expected offset-minute-of-hour in 0..59, got " + iso$twoDigitNumber7);
                throw new KotlinNothingValueException();
            }
            if (iso$twoDigitNumber8 > 59) {
                parseIso$parseFailure(charSequence, "Expected offset-second-of-minute in 0..59, got " + iso$twoDigitNumber8);
                throw new KotlinNothingValueException();
            }
            if (iso$twoDigitNumber6 > 17 && (iso$twoDigitNumber6 != 18 || iso$twoDigitNumber7 != 0 || iso$twoDigitNumber8 != 0)) {
                parseIso$parseFailure(charSequence, "Expected an offset in -18:00..+18:00, got " + charSequence.subSequence(i9, charSequence.length()).toString());
                throw new KotlinNothingValueException();
            }
            i3 = (cCharAt4 == '-' ? -1 : 1) * ((iso$twoDigitNumber6 * 3600) + (iso$twoDigitNumber7 * 60) + iso$twoDigitNumber8);
            i4 = 1;
        } else {
            if (cCharAt4 != 'Z' && cCharAt4 != 'z') {
                parseIso$parseFailure(charSequence, "Expected the UTC offset at position " + i9 + ", got '" + cCharAt4 + CoreConstants.SINGLE_QUOTE_CHAR);
                throw new KotlinNothingValueException();
            }
            int i16 = i9 + 1;
            if (charSequence.length() != i16) {
                parseIso$parseFailure(charSequence, "Extra text after the instant at position " + i16);
                throw new KotlinNothingValueException();
            }
            i4 = 1;
            i3 = 0;
        }
        if (i4 > iso$twoDigitNumber || iso$twoDigitNumber >= 13) {
            parseIso$parseFailure(charSequence, "Expected a month number in 1..12, got " + iso$twoDigitNumber);
            throw new KotlinNothingValueException();
        }
        if (i4 > iso$twoDigitNumber2 || iso$twoDigitNumber2 > monthLength(iso$twoDigitNumber, isLeapYear(iCharAt))) {
            parseIso$parseFailure(charSequence, "Expected a valid day-of-month for month " + iso$twoDigitNumber + " of year " + iCharAt + ", got " + iso$twoDigitNumber2);
            throw new KotlinNothingValueException();
        }
        if (iso$twoDigitNumber3 > 23) {
            parseIso$parseFailure(charSequence, "Expected hour in 0..23, got " + iso$twoDigitNumber3);
            throw new KotlinNothingValueException();
        }
        if (iso$twoDigitNumber4 > 59) {
            parseIso$parseFailure(charSequence, "Expected minute-of-hour in 0..59, got " + iso$twoDigitNumber4);
            throw new KotlinNothingValueException();
        }
        if (iso$twoDigitNumber5 > 59) {
            parseIso$parseFailure(charSequence, "Expected second-of-minute in 0..59, got " + iso$twoDigitNumber5);
            throw new KotlinNothingValueException();
        }
        return new UnboundLocalDateTime(iCharAt, iso$twoDigitNumber, iso$twoDigitNumber2, iso$twoDigitNumber3, iso$twoDigitNumber4, iso$twoDigitNumber5, i2).toInstant(i3);
    }

    private static final int parseIso$twoDigitNumber(CharSequence charSequence, int i) {
        return ((charSequence.charAt(i) - '0') * 10) + (charSequence.charAt(i + 1) - '0');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatIso(Instant instant) throws IOException {
        int[] iArr;
        StringBuilder sb = new StringBuilder();
        UnboundLocalDateTime unboundLocalDateTimeFromInstant = UnboundLocalDateTime.Companion.fromInstant(instant);
        int year = unboundLocalDateTimeFromInstant.getYear();
        int i = 0;
        if (Math.abs(year) < 1000) {
            StringBuilder sb2 = new StringBuilder();
            if (year >= 0) {
                sb2.append(year + 10000);
                Intrinsics.checkNotNullExpressionValue(sb2.deleteCharAt(0), "deleteCharAt(...)");
            } else {
                sb2.append(year - 10000);
                Intrinsics.checkNotNullExpressionValue(sb2.deleteCharAt(1), "deleteCharAt(...)");
            }
            sb.append((CharSequence) sb2);
        } else {
            if (year >= 10000) {
                sb.append('+');
            }
            sb.append(year);
        }
        sb.append(CoreConstants.DASH_CHAR);
        formatIso$lambda$8$appendTwoDigits(sb, sb, unboundLocalDateTimeFromInstant.getMonth());
        sb.append(CoreConstants.DASH_CHAR);
        formatIso$lambda$8$appendTwoDigits(sb, sb, unboundLocalDateTimeFromInstant.getDay());
        sb.append('T');
        formatIso$lambda$8$appendTwoDigits(sb, sb, unboundLocalDateTimeFromInstant.getHour());
        sb.append(CoreConstants.COLON_CHAR);
        formatIso$lambda$8$appendTwoDigits(sb, sb, unboundLocalDateTimeFromInstant.getMinute());
        sb.append(CoreConstants.COLON_CHAR);
        formatIso$lambda$8$appendTwoDigits(sb, sb, unboundLocalDateTimeFromInstant.getSecond());
        if (unboundLocalDateTimeFromInstant.getNanosecond() != 0) {
            sb.append('.');
            while (true) {
                int nanosecond = unboundLocalDateTimeFromInstant.getNanosecond();
                iArr = POWERS_OF_TEN;
                int i2 = i + 1;
                if (nanosecond % iArr[i2] != 0) {
                    break;
                }
                i = i2;
            }
            int i3 = i - (i % 3);
            String strValueOf = String.valueOf((unboundLocalDateTimeFromInstant.getNanosecond() / iArr[i3]) + iArr[9 - i3]);
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strValueOf.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            sb.append(strSubstring);
        }
        sb.append('Z');
        return sb.toString();
    }

    private static final void formatIso$lambda$8$appendTwoDigits(Appendable appendable, StringBuilder sb, int i) throws IOException {
        if (i < 10) {
            appendable.append('0');
        }
        sb.append(i);
    }

    private static final long safeAddOrElse(long j, long j2, Function0 function0) {
        long j3 = j + j2;
        if ((j ^ j3) >= 0 || (j ^ j2) < 0) {
            return j3;
        }
        function0.invoke();
        throw new KotlinNothingValueException();
    }

    private static final long safeMultiplyOrElse(long j, long j2, Function0 function0) {
        if (j2 == 1) {
            return j;
        }
        if (j == 1) {
            return j2;
        }
        if (j == 0 || j2 == 0) {
            return 0L;
        }
        long j3 = j * j2;
        if (j3 / j2 == j && ((j != Long.MIN_VALUE || j2 != -1) && (j2 != Long.MIN_VALUE || j != -1))) {
            return j3;
        }
        function0.invoke();
        throw new KotlinNothingValueException();
    }

    public static final boolean isLeapYear(int i) {
        return (i & 3) == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    private static final String truncateForErrorMessage(CharSequence charSequence, int i) {
        if (charSequence.length() <= i) {
            return charSequence.toString();
        }
        return charSequence.subSequence(0, i).toString() + "...";
    }
}
