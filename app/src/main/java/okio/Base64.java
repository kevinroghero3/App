package okio;

import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-Base64, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class Base64 {
    private static final byte[] BASE64;
    private static final byte[] BASE64_URL_SAFE;

    public static final byte[] getBASE64() {
        return BASE64;
    }

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }

    public static final byte[] decodeBase64ToArray(@NotNull String decodeBase64ToArray) {
        int i;
        char cCharAt;
        Intrinsics.checkNotNullParameter(decodeBase64ToArray, "$this$decodeBase64ToArray");
        int length = decodeBase64ToArray.length();
        while (length > 0 && ((cCharAt = decodeBase64ToArray.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i2 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt2 = decodeBase64ToArray.charAt(i6);
            if ('A' <= cCharAt2 && 'Z' >= cCharAt2) {
                i = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && 'z' >= cCharAt2) {
                i = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && '9' >= cCharAt2) {
                i = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i = 62;
            } else {
                if (cCharAt2 == '/' || cCharAt2 == '_') {
                    i = 63;
                } else if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i4 = (i4 << 6) | i;
            i3++;
            if (i3 % 4 == 0) {
                bArr[i5] = (byte) (i4 >> 16);
                bArr[i5 + 1] = (byte) (i4 >> 8);
                bArr[i5 + 2] = (byte) i4;
                i5 += 3;
            }
        }
        int i7 = i3 % 4;
        if (i7 == 1) {
            return null;
        }
        if (i7 == 2) {
            bArr[i5] = (byte) ((i4 << 12) >> 16);
            i5++;
        } else if (i7 == 3) {
            int i8 = i4 << 6;
            bArr[i5] = (byte) (i8 >> 16);
            bArr[i5 + 1] = (byte) (i8 >> 8);
            i5 += 2;
        }
        if (i5 == i2) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i5);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf;
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    public static final String encodeBase64(@NotNull byte[] encodeBase64, @NotNull byte[] map) {
        Intrinsics.checkNotNullParameter(encodeBase64, "$this$encodeBase64");
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] bArr = new byte[((encodeBase64.length + 2) / 3) * 4];
        int length = encodeBase64.length - (encodeBase64.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = encodeBase64[i];
            byte b2 = encodeBase64[i + 1];
            int i3 = i + 3;
            byte b3 = encodeBase64[i + 2];
            bArr[i2] = map[(b & 255) >> 2];
            bArr[i2 + 1] = map[((b & 3) << 4) | ((b2 & 255) >> 4)];
            bArr[i2 + 2] = map[((b2 & Ascii.SI) << 2) | ((b3 & 255) >> 6)];
            bArr[i2 + 3] = map[b3 & Utf8.REPLACEMENT_BYTE];
            i2 += 4;
            i = i3;
        }
        int length2 = encodeBase64.length - length;
        if (length2 == 1) {
            byte b4 = encodeBase64[i];
            bArr[i2] = map[(b4 & 255) >> 2];
            bArr[i2 + 1] = map[(b4 & 3) << 4];
            byte b5 = (byte) 61;
            bArr[i2 + 2] = b5;
            bArr[i2 + 3] = b5;
        } else if (length2 == 2) {
            byte b6 = encodeBase64[i];
            byte b7 = encodeBase64[i + 1];
            bArr[i2] = map[(b6 & 255) >> 2];
            bArr[i2 + 1] = map[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            bArr[i2 + 2] = map[(b7 & Ascii.SI) << 2];
            bArr[i2 + 3] = (byte) 61;
        }
        return Platform.toUtf8String(bArr);
    }
}
