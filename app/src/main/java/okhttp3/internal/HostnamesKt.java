package okhttp3.internal;

import ch.qos.logback.core.CoreConstants;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class HostnamesKt {
    public static final String toCanonicalHost(@NotNull String toCanonicalHost) {
        InetAddress inetAddressDecodeIpv6;
        Intrinsics.checkParameterIsNotNull(toCanonicalHost, "$this$toCanonicalHost");
        if (StringsKt__StringsKt.contains$default((CharSequence) toCanonicalHost, (CharSequence) ":", false, 2, (Object) null)) {
            if (StringsKt__StringsJVMKt.startsWith$default(toCanonicalHost, "[", false, 2, null) && StringsKt__StringsJVMKt.endsWith$default(toCanonicalHost, "]", false, 2, null)) {
                inetAddressDecodeIpv6 = decodeIpv6(toCanonicalHost, 1, toCanonicalHost.length() - 1);
            } else {
                inetAddressDecodeIpv6 = decodeIpv6(toCanonicalHost, 0, toCanonicalHost.length());
            }
            if (inetAddressDecodeIpv6 == null) {
                return null;
            }
            byte[] address = inetAddressDecodeIpv6.getAddress();
            if (address.length == 16) {
                Intrinsics.checkExpressionValueIsNotNull(address, "address");
                return inet6AddressToAscii(address);
            }
            if (address.length == 4) {
                return inetAddressDecodeIpv6.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + toCanonicalHost + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        try {
            String ascii = IDN.toASCII(toCanonicalHost);
            Intrinsics.checkExpressionValueIsNotNull(ascii, "IDN.toASCII(host)");
            Locale locale = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (ascii == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = ascii.toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (lowerCase.length() != 0 && !containsInvalidHostnameAsciiCodes(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static final boolean containsInvalidHostnameAsciiCodes(@NotNull String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127 || StringsKt__StringsKt.indexOf$default((CharSequence) " #%/:?@[\\]", cCharAt, 0, false, 6, (Object) null) != -1) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0076 A[LOOP:1: B:30:0x0069->B:34:0x0076, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x007c A[EDGE_INSN: B:55:0x007c->B:35:0x007c BREAK  A[LOOP:1: B:30:0x0069->B:34:0x0076], SYNTHETIC] */
    private static final InetAddress decodeIpv6(String str, int i, int i2) {
        int i3;
        int i4;
        int hexDigit;
        byte[] bArr = new byte[16];
        int i5 = i;
        int i6 = -1;
        int i7 = -1;
        int i8 = 0;
        while (i5 < i2) {
            if (i8 == 16) {
                return null;
            }
            int i9 = i5 + 2;
            if (i9 <= i2 && StringsKt__StringsJVMKt.startsWith$default(str, "::", i5, false, 4, null)) {
                if (i6 != -1) {
                    return null;
                }
                i8 += 2;
                if (i9 == i2) {
                    i6 = i8;
                    break;
                }
                i7 = i9;
                i6 = i8;
                i5 = i7;
                i3 = 0;
                while (i5 < i2) {
                    hexDigit = Util.parseHexDigit(str.charAt(i5));
                    if (hexDigit == -1) {
                        break;
                        break;
                    }
                    i3 = (i3 << 4) + hexDigit;
                    i5++;
                }
                i4 = i5 - i7;
                if (i4 != 0) {
                }
                return null;
            }
            if (i8 != 0) {
                if (!StringsKt__StringsJVMKt.startsWith$default(str, ":", i5, false, 4, null)) {
                    if (!StringsKt__StringsJVMKt.startsWith$default(str, ".", i5, false, 4, null) || !decodeIpv4Suffix(str, i7, i2, bArr, i8 - 2)) {
                        return null;
                    }
                    i8 += 2;
                    break;
                }
                i5++;
            }
            i7 = i5;
            i5 = i7;
            i3 = 0;
            while (i5 < i2) {
                hexDigit = Util.parseHexDigit(str.charAt(i5));
                if (hexDigit == -1) {
                    break;
                }
                i3 = (i3 << 4) + hexDigit;
                i5++;
            }
            i4 = i5 - i7;
            if (i4 != 0 || i4 > 4) {
                return null;
            }
            bArr[i8] = (byte) ((i3 >>> 8) & 255);
            bArr[i8 + 1] = (byte) (i3 & 255);
            i8 += 2;
        }
        if (i8 != 16) {
            if (i6 == -1) {
                return null;
            }
            int i10 = i8 - i6;
            System.arraycopy(bArr, i6, bArr, 16 - i10, i10);
            Arrays.fill(bArr, i6, (16 - i8) + i6, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    private static final boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        Buffer buffer = new Buffer();
        while (i2 < bArr.length) {
            if (i2 == i) {
                buffer.writeByte(58);
                i2 += i4;
                if (i2 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((Util.and(bArr[i2], 255) << 8) | Util.and(bArr[i2 + 1], 255));
                i2 += 2;
            }
        }
        return buffer.readUtf8();
    }
}
