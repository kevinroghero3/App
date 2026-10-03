package kotlin.io.encoding;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.collections.AbstractList;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.Charsets;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public class Base64 {
    private static final Base64 Mime;
    private static final Base64 UrlSafe;
    private static final int bitsPerByte = 8;
    private static final int bitsPerSymbol = 6;
    public static final int bytesPerGroup = 3;
    private static final int mimeGroupsPerLine = 19;
    public static final int mimeLineLength = 76;
    public static final byte padSymbol = 61;
    public static final int symbolsPerGroup = 4;
    private final boolean isMimeScheme;
    private final boolean isUrlSafe;
    private final PaddingOption paddingOption;
    public static final Default Default = new Default(null);
    private static final byte[] mimeLineSeparatorSymbols = {Ascii.CR, 10};

    public enum PaddingOption {
        PRESENT,
        ABSENT,
        PRESENT_OPTIONAL,
        ABSENT_OPTIONAL;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<PaddingOption> getEntries() {
            return $ENTRIES;
        }
    }

    public /* synthetic */ Base64(boolean z, boolean z2, PaddingOption paddingOption, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, paddingOption);
    }

    private Base64(boolean z, boolean z2, PaddingOption paddingOption) {
        this.isUrlSafe = z;
        this.isMimeScheme = z2;
        this.paddingOption = paddingOption;
        if (z && z2) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public final boolean isUrlSafe$kotlin_stdlib() {
        return this.isUrlSafe;
    }

    public final boolean isMimeScheme$kotlin_stdlib() {
        return this.isMimeScheme;
    }

    public final PaddingOption getPaddingOption$kotlin_stdlib() {
        return this.paddingOption;
    }

    public final Base64 withPadding(@NotNull PaddingOption option) {
        Intrinsics.checkNotNullParameter(option, "option");
        return this.paddingOption == option ? this : new Base64(this.isUrlSafe, this.isMimeScheme, option);
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return base64.encodeToByteArray(bArr, i, i2);
    }

    public final byte[] encodeToByteArray(@NotNull byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(source, "source");
        return encodeToByteArrayImpl$kotlin_stdlib(source, i, i2);
    }

    public static /* synthetic */ int encodeIntoByteArray$default(Base64 base64, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
        }
        int i5 = (i4 & 4) != 0 ? 0 : i;
        int i6 = (i4 & 8) != 0 ? 0 : i2;
        if ((i4 & 16) != 0) {
            i3 = bArr.length;
        }
        return base64.encodeIntoByteArray(bArr, bArr2, i5, i6, i3);
    }

    public final int encodeIntoByteArray(@NotNull byte[] source, @NotNull byte[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return encodeIntoByteArrayImpl$kotlin_stdlib(source, destination, i, i2, i3);
    }

    public static /* synthetic */ String encode$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return base64.encode(bArr, i, i2);
    }

    public final String encode(@NotNull byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new String(encodeToByteArrayImpl$kotlin_stdlib(source, i, i2), Charsets.ISO_8859_1);
    }

    public static /* synthetic */ Appendable encodeToAppendable$default(Base64 base64, byte[] bArr, Appendable appendable, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = bArr.length;
        }
        return base64.encodeToAppendable(bArr, appendable, i, i2);
    }

    public final <A extends Appendable> A encodeToAppendable(@NotNull byte[] source, @NotNull A destination, int i, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        destination.append(new String(encodeToByteArrayImpl$kotlin_stdlib(source, i, i2), Charsets.ISO_8859_1));
        return destination;
    }

    public static /* synthetic */ byte[] decode$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return base64.decode(bArr, i, i2);
    }

    public final byte[] decode(@NotNull byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length, i, i2);
        int iDecodeSize$kotlin_stdlib = decodeSize$kotlin_stdlib(source, i, i2);
        byte[] bArr = new byte[iDecodeSize$kotlin_stdlib];
        if (decodeImpl(source, bArr, 0, i, i2) == iDecodeSize$kotlin_stdlib) {
            return bArr;
        }
        throw new IllegalStateException("Check failed.");
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 base64, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        int i5 = (i4 & 4) != 0 ? 0 : i;
        int i6 = (i4 & 8) != 0 ? 0 : i2;
        if ((i4 & 16) != 0) {
            i3 = bArr.length;
        }
        return base64.decodeIntoByteArray(bArr, bArr2, i5, i6, i3);
    }

    public final int decodeIntoByteArray(@NotNull byte[] source, @NotNull byte[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        checkSourceBounds$kotlin_stdlib(source.length, i2, i3);
        checkDestinationBounds(destination.length, i, decodeSize$kotlin_stdlib(source, i2, i3));
        return decodeImpl(source, destination, i, i2, i3);
    }

    public static /* synthetic */ byte[] decode$default(Base64 base64, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return base64.decode(charSequence, i, i2);
    }

    public final byte[] decode(@NotNull CharSequence source, int i, int i2) {
        byte[] bArrCharsToBytesImpl$kotlin_stdlib;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof String) {
            String str = (String) source;
            checkSourceBounds$kotlin_stdlib(str.length(), i, i2);
            String strSubstring = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Charset charset = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            bArrCharsToBytesImpl$kotlin_stdlib = strSubstring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bArrCharsToBytesImpl$kotlin_stdlib, "getBytes(...)");
        } else {
            bArrCharsToBytesImpl$kotlin_stdlib = charsToBytesImpl$kotlin_stdlib(source, i, i2);
        }
        return decode$default(this, bArrCharsToBytesImpl$kotlin_stdlib, 0, 0, 6, (Object) null);
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 base64, CharSequence charSequence, byte[] bArr, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        int i5 = (i4 & 4) != 0 ? 0 : i;
        int i6 = (i4 & 8) != 0 ? 0 : i2;
        if ((i4 & 16) != 0) {
            i3 = charSequence.length();
        }
        return base64.decodeIntoByteArray(charSequence, bArr, i5, i6, i3);
    }

    public final int decodeIntoByteArray(@NotNull CharSequence source, @NotNull byte[] destination, int i, int i2, int i3) {
        byte[] bArrCharsToBytesImpl$kotlin_stdlib;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (source instanceof String) {
            String str = (String) source;
            checkSourceBounds$kotlin_stdlib(str.length(), i2, i3);
            String strSubstring = str.substring(i2, i3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Charset charset = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            bArrCharsToBytesImpl$kotlin_stdlib = strSubstring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bArrCharsToBytesImpl$kotlin_stdlib, "getBytes(...)");
        } else {
            bArrCharsToBytesImpl$kotlin_stdlib = charsToBytesImpl$kotlin_stdlib(source, i2, i3);
        }
        return decodeIntoByteArray$default(this, bArrCharsToBytesImpl$kotlin_stdlib, destination, i, 0, 0, 24, (Object) null);
    }

    public final byte[] encodeToByteArrayImpl$kotlin_stdlib(@NotNull byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length, i, i2);
        byte[] bArr = new byte[encodeSize$kotlin_stdlib(i2 - i)];
        encodeIntoByteArrayImpl$kotlin_stdlib(source, bArr, 0, i, i2);
        return bArr;
    }

    public final int encodeIntoByteArrayImpl$kotlin_stdlib(@NotNull byte[] source, @NotNull byte[] destination, int i, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        checkSourceBounds$kotlin_stdlib(source.length, i2, i3);
        checkDestinationBounds(destination.length, i, encodeSize$kotlin_stdlib(i3 - i2));
        byte[] bArr = this.isUrlSafe ? Base64Kt.base64UrlEncodeMap : Base64Kt.base64EncodeMap;
        int i5 = this.isMimeScheme ? 19 : Integer.MAX_VALUE;
        int i6 = i;
        while (true) {
            i4 = i2 + 2;
            if (i4 >= i3) {
                break;
            }
            int iMin = Math.min((i3 - i2) / 3, i5);
            int i7 = 0;
            while (i7 < iMin) {
                int i8 = i2 + 3;
                int i9 = (source[i2 + 2] & 255) | ((source[i2] & 255) << 16) | ((source[i2 + 1] & 255) << 8);
                destination[i6] = bArr[i9 >>> 18];
                destination[i6 + 1] = bArr[(i9 >>> 12) & 63];
                destination[i6 + 2] = bArr[(i9 >>> 6) & 63];
                destination[i6 + 3] = bArr[i9 & 63];
                i7++;
                i6 += 4;
                i2 = i8;
            }
            if (iMin == i5 && i2 != i3) {
                byte[] bArr2 = mimeLineSeparatorSymbols;
                destination[i6] = bArr2[0];
                destination[i6 + 1] = bArr2[1];
                i6 += 2;
            }
        }
        int i10 = i3 - i2;
        if (i10 == 1) {
            int i11 = i2 + 1;
            int i12 = (source[i2] & 255) << 4;
            destination[i6] = bArr[i12 >>> 6];
            int i13 = i6 + 2;
            destination[i6 + 1] = bArr[i12 & 63];
            if (shouldPadOnEncode()) {
                destination[i13] = padSymbol;
                destination[i6 + 3] = padSymbol;
                i6 += 4;
            } else {
                i6 = i13;
            }
            i2 = i11;
        } else if (i10 == 2) {
            int i14 = ((source[i2 + 1] & 255) << 2) | ((source[i2] & 255) << 10);
            destination[i6] = bArr[i14 >>> 12];
            destination[i6 + 1] = bArr[(i14 >>> 6) & 63];
            int i15 = i6 + 3;
            destination[i6 + 2] = bArr[i14 & 63];
            if (shouldPadOnEncode()) {
                i6 += 4;
                destination[i15] = padSymbol;
            } else {
                i6 = i15;
            }
            i2 = i4;
        }
        if (i2 == i3) {
            return i6 - i;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int encodeSize$kotlin_stdlib(int i) {
        int i2 = i / 3;
        int i3 = i % 3;
        int i4 = i2 * 4;
        if (i3 != 0) {
            i4 += shouldPadOnEncode() ? 4 : i3 + 1;
        }
        if (this.isMimeScheme) {
            i4 += ((i4 - 1) / 76) * 2;
        }
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException("Input is too big");
    }

    private final boolean shouldPadOnEncode() {
        PaddingOption paddingOption = this.paddingOption;
        return paddingOption == PaddingOption.PRESENT || paddingOption == PaddingOption.PRESENT_OPTIONAL;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0067  */
    /* JADX WARN: Code duplicated, block: B:17:0x006f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0077  */
    /* JADX WARN: Code duplicated, block: B:21:0x007b  */
    /* JADX WARN: Code duplicated, block: B:24:0x00af  */
    /* JADX WARN: Code duplicated, block: B:26:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:27:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:51:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x007e A[SYNTHETIC] */
    private final int decodeImpl(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        int[] iArr = this.isUrlSafe ? Base64Kt.base64UrlDecodeMap : Base64Kt.base64DecodeMap;
        int i8 = -8;
        int i9 = i;
        int iHandlePaddingSymbol = i2;
        int i10 = -8;
        int i11 = 0;
        while (true) {
            if (iHandlePaddingSymbol >= i3) {
                z = false;
                break;
            }
            if (i10 == i8 && (i7 = iHandlePaddingSymbol + 3) < i3) {
                int i12 = iArr[bArr[i7] & 255] | (iArr[bArr[iHandlePaddingSymbol] & 255] << 18) | (iArr[bArr[iHandlePaddingSymbol + 1] & 255] << 12) | (iArr[bArr[iHandlePaddingSymbol + 2] & 255] << 6);
                if (i12 >= 0) {
                    bArr2[i9] = (byte) (i12 >> 16);
                    bArr2[i9 + 1] = (byte) (i12 >> 8);
                    bArr2[i9 + 2] = (byte) i12;
                    iHandlePaddingSymbol += 4;
                    i9 += 3;
                } else {
                    i4 = bArr[iHandlePaddingSymbol] & 255;
                    i5 = iArr[i4];
                    if (i5 < 0) {
                        iHandlePaddingSymbol++;
                        i11 = (i11 << 6) | i5;
                        i6 = i10 + 6;
                        if (i6 >= 0) {
                            bArr2[i9] = (byte) (i11 >>> i6);
                            i11 &= (1 << i6) - 1;
                            i10 -= 2;
                            i9++;
                        } else {
                            i10 = i6;
                        }
                    } else {
                        if (i5 == -2) {
                            iHandlePaddingSymbol = handlePaddingSymbol(bArr, iHandlePaddingSymbol, i3, i10);
                            z = true;
                            break;
                        }
                        if (this.isMimeScheme) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid symbol '");
                            sb.append((char) i4);
                            sb.append("'(");
                            String string = Integer.toString(i4, CharsKt__CharJVMKt.checkRadix(8));
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            sb.append(string);
                            sb.append(") at index ");
                            sb.append(iHandlePaddingSymbol);
                            throw new IllegalArgumentException(sb.toString());
                        }
                        iHandlePaddingSymbol++;
                    }
                }
            } else {
                i4 = bArr[iHandlePaddingSymbol] & 255;
                i5 = iArr[i4];
                if (i5 < 0) {
                    iHandlePaddingSymbol++;
                    i11 = (i11 << 6) | i5;
                    i6 = i10 + 6;
                    if (i6 >= 0) {
                        bArr2[i9] = (byte) (i11 >>> i6);
                        i11 &= (1 << i6) - 1;
                        i10 -= 2;
                        i9++;
                    } else {
                        i10 = i6;
                    }
                } else {
                    if (i5 == -2) {
                        iHandlePaddingSymbol = handlePaddingSymbol(bArr, iHandlePaddingSymbol, i3, i10);
                        z = true;
                        break;
                    }
                    if (this.isMimeScheme) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Invalid symbol '");
                        sb2.append((char) i4);
                        sb2.append("'(");
                        String string2 = Integer.toString(i4, CharsKt__CharJVMKt.checkRadix(8));
                        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                        sb2.append(string2);
                        sb2.append(") at index ");
                        sb2.append(iHandlePaddingSymbol);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                    iHandlePaddingSymbol++;
                }
            }
            i8 = -8;
        }
        if (i10 == -2) {
            throw new IllegalArgumentException("The last unit of input does not have enough bits");
        }
        if (i10 != -8 && !z && this.paddingOption == PaddingOption.PRESENT) {
            throw new IllegalArgumentException("The padding option is set to PRESENT, but the input is not properly padded");
        }
        if (i11 != 0) {
            throw new IllegalArgumentException("The pad bits must be zeros");
        }
        int iSkipIllegalSymbolsIfMime = skipIllegalSymbolsIfMime(bArr, iHandlePaddingSymbol, i3);
        if (iSkipIllegalSymbolsIfMime >= i3) {
            return i9 - i;
        }
        int i13 = bArr[iSkipIllegalSymbolsIfMime] & 255;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Symbol '");
        sb3.append((char) i13);
        sb3.append("'(");
        String string3 = Integer.toString(i13, CharsKt__CharJVMKt.checkRadix(8));
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        sb3.append(string3);
        sb3.append(") at index ");
        sb3.append(iSkipIllegalSymbolsIfMime - 1);
        sb3.append(" is prohibited after the pad character");
        throw new IllegalArgumentException(sb3.toString());
    }

    public final int decodeSize$kotlin_stdlib(@NotNull byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 - i;
        if (i3 == 0) {
            return 0;
        }
        if (i3 == 1) {
            throw new IllegalArgumentException("Input should have at least 2 symbols for Base64 decoding, startIndex: " + i + ", endIndex: " + i2);
        }
        if (this.isMimeScheme) {
            while (i < i2) {
                int i4 = Base64Kt.base64DecodeMap[source[i] & 255];
                if (i4 < 0) {
                    if (i4 == -2) {
                        i3 -= i2 - i;
                        break;
                    }
                    i3--;
                }
                i++;
            }
        } else if (source[i2 - 1] == 61) {
            i3 = source[i2 + (-2)] == 61 ? i3 - 2 : i3 - 1;
        }
        return (int) ((((long) i3) * ((long) 6)) / ((long) 8));
    }

    public final byte[] charsToBytesImpl$kotlin_stdlib(@NotNull CharSequence source, int i, int i2) {
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length(), i, i2);
        byte[] bArr = new byte[i2 - i];
        int i3 = 0;
        while (i < i2) {
            char cCharAt = source.charAt(i);
            if (cCharAt <= 255) {
                bArr[i3] = (byte) cCharAt;
            } else {
                bArr[i3] = Utf8.REPLACEMENT_BYTE;
            }
            i3++;
            i++;
        }
        return bArr;
    }

    public final String bytesToStringImpl$kotlin_stdlib(@NotNull byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        StringBuilder sb = new StringBuilder(source.length);
        for (byte b : source) {
            sb.append((char) b);
        }
        return sb.toString();
    }

    private final int handlePaddingSymbol(byte[] bArr, int i, int i2, int i3) {
        if (i3 == -8) {
            throw new IllegalArgumentException("Redundant pad character at index " + i);
        }
        if (i3 == -6) {
            checkPaddingIsAllowed(i);
        } else if (i3 == -4) {
            checkPaddingIsAllowed(i);
            i = skipIllegalSymbolsIfMime(bArr, i + 1, i2);
            if (i == i2 || bArr[i] != 61) {
                throw new IllegalArgumentException("Missing one pad character at index " + i);
            }
        } else if (i3 != -2) {
            throw new IllegalStateException("Unreachable");
        }
        return i + 1;
    }

    private final void checkPaddingIsAllowed(int i) {
        if (this.paddingOption != PaddingOption.ABSENT) {
            return;
        }
        throw new IllegalArgumentException("The padding option is set to ABSENT, but the input has a pad character at index " + i);
    }

    private final int skipIllegalSymbolsIfMime(byte[] bArr, int i, int i2) {
        if (!this.isMimeScheme) {
            return i;
        }
        while (i < i2) {
            if (Base64Kt.base64DecodeMap[bArr[i] & 255] != -1) {
                return i;
            }
            i++;
        }
        return i;
    }

    public final void checkSourceBounds$kotlin_stdlib(int i, int i2, int i3) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i2, i3, i);
    }

    private final void checkDestinationBounds(int i, int i2, int i3) {
        if (i2 < 0 || i2 > i) {
            throw new IndexOutOfBoundsException("destination offset: " + i2 + ", destination size: " + i);
        }
        int i4 = i2 + i3;
        if (i4 < 0 || i4 > i) {
            throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + i2 + ", destination size: " + i + ", capacity needed: " + i3);
        }
    }

    public static final class Default extends Base64 {
        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private Default() {
            boolean z = false;
            super(z, z, PaddingOption.PRESENT, null);
        }

        public final byte[] getMimeLineSeparatorSymbols$kotlin_stdlib() {
            return Base64.mimeLineSeparatorSymbols;
        }

        public final Base64 getUrlSafe() {
            return Base64.UrlSafe;
        }

        public final Base64 getMime() {
            return Base64.Mime;
        }
    }

    static {
        PaddingOption paddingOption = PaddingOption.PRESENT;
        UrlSafe = new Base64(true, false, paddingOption);
        Mime = new Base64(false, true, paddingOption);
    }
}
