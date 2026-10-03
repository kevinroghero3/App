package okio.internal;

import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class _Utf8Kt {
    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }

    public static final String commonToUtf8String(@NotNull byte[] commonToUtf8String, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i;
        Intrinsics.checkNotNullParameter(commonToUtf8String, "$this$commonToUtf8String");
        if (i7 < 0 || i2 > commonToUtf8String.length || i7 > i2) {
            throw new ArrayIndexOutOfBoundsException("size=" + commonToUtf8String.length + " beginIndex=" + i7 + " endIndex=" + i2);
        }
        char[] cArr = new char[i2 - i7];
        int i8 = 0;
        while (i7 < i2) {
            byte b = commonToUtf8String[i7];
            if (b >= 0) {
                i3 = i8 + 1;
                cArr[i8] = (char) b;
                i7++;
                while (i7 < i2) {
                    byte b2 = commonToUtf8String[i7];
                    if (b2 < 0) {
                        break;
                    }
                    i7++;
                    cArr[i3] = (char) b2;
                    i3++;
                }
            } else if ((b >> 5) == -2) {
                int i9 = i7 + 1;
                if (i2 <= i9) {
                    i3 = i8 + 1;
                    cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                } else {
                    byte b3 = commonToUtf8String[i9];
                    if ((b3 & 192) == 128) {
                        int i10 = (b << 6) ^ (b3 ^ 3968);
                        if (i10 < 128) {
                            i3 = i8 + 1;
                            cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        } else {
                            i3 = i8 + 1;
                            cArr[i8] = (char) i10;
                        }
                        Unit unit = Unit.INSTANCE;
                        i7 += i4;
                    } else {
                        i3 = i8 + 1;
                        cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                i7 += i4;
            } else if ((b >> 4) == -2) {
                int i11 = i7 + 2;
                if (i2 <= i11) {
                    i3 = i8 + 1;
                    cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    Unit unit3 = Unit.INSTANCE;
                    int i12 = i7 + 1;
                    i4 = (i2 <= i12 || (commonToUtf8String[i12] & 192) != 128) ? 1 : 2;
                } else {
                    byte b4 = commonToUtf8String[i7 + 1];
                    if ((b4 & 192) == 128) {
                        byte b5 = commonToUtf8String[i11];
                        if ((b5 & 192) == 128) {
                            int i13 = (b << Ascii.FF) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                            if (i13 < 2048) {
                                i3 = i8 + 1;
                                cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            } else if (55296 <= i13 && 57343 >= i13) {
                                i3 = i8 + 1;
                                cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            } else {
                                i3 = i8 + 1;
                                cArr[i8] = (char) i13;
                            }
                            Unit unit4 = Unit.INSTANCE;
                            i4 = 3;
                        } else {
                            i3 = i8 + 1;
                            cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            Unit unit5 = Unit.INSTANCE;
                        }
                    } else {
                        i3 = i8 + 1;
                        cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        Unit unit6 = Unit.INSTANCE;
                    }
                }
                i7 += i4;
            } else {
                if ((b >> 3) == -2) {
                    int i14 = i7 + 3;
                    if (i2 <= i14) {
                        i5 = i8 + 1;
                        cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                        Unit unit7 = Unit.INSTANCE;
                        int i15 = i7 + 1;
                        if (i2 <= i15 || (commonToUtf8String[i15] & 192) != 128) {
                            i6 = 1;
                        } else {
                            int i16 = i7 + 2;
                            i6 = (i2 <= i16 || (commonToUtf8String[i16] & 192) != 128) ? 2 : 3;
                        }
                    } else {
                        byte b6 = commonToUtf8String[i7 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = commonToUtf8String[i7 + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = commonToUtf8String[i14];
                                if ((b8 & 192) == 128) {
                                    int i17 = (b << Ascii.DC2) ^ (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << Ascii.FF));
                                    if (i17 > 1114111) {
                                        i5 = i8 + 1;
                                        cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                                    } else if ((55296 <= i17 && 57343 >= i17) || i17 < 65536) {
                                        i5 = i8 + 1;
                                        cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                                    } else if (i17 != 65533) {
                                        cArr[i8] = (char) ((i17 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                        cArr[i8 + 1] = (char) ((i17 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                        i5 = i8 + 2;
                                    } else {
                                        cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                                        i5 = i8 + 1;
                                    }
                                    Unit unit8 = Unit.INSTANCE;
                                    i6 = 4;
                                } else {
                                    i5 = i8 + 1;
                                    cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                                    Unit unit9 = Unit.INSTANCE;
                                }
                            } else {
                                i5 = i8 + 1;
                                cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                                Unit unit10 = Unit.INSTANCE;
                            }
                        } else {
                            i5 = i8 + 1;
                            cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                            Unit unit11 = Unit.INSTANCE;
                            i6 = 1;
                        }
                    }
                    i7 += i6;
                } else {
                    i5 = i8 + 1;
                    cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                    i7++;
                }
                i8 = i5;
            }
            i8 = i3;
        }
        return new String(cArr, 0, i8);
    }

    public static final byte[] commonAsUtf8ToByteArray(@NotNull String commonAsUtf8ToByteArray) {
        int i;
        int i2;
        char cCharAt;
        Intrinsics.checkNotNullParameter(commonAsUtf8ToByteArray, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[commonAsUtf8ToByteArray.length() * 4];
        int length = commonAsUtf8ToByteArray.length();
        int i3 = 0;
        while (i3 < length) {
            char cCharAt2 = commonAsUtf8ToByteArray.charAt(i3);
            if (Intrinsics.compare((int) cCharAt2, 128) >= 0) {
                int length2 = commonAsUtf8ToByteArray.length();
                int i4 = i3;
                while (i3 < length2) {
                    char cCharAt3 = commonAsUtf8ToByteArray.charAt(i3);
                    if (Intrinsics.compare((int) cCharAt3, 128) < 0) {
                        bArr[i4] = (byte) cCharAt3;
                        i3++;
                        i4++;
                        while (i3 < length2 && Intrinsics.compare((int) commonAsUtf8ToByteArray.charAt(i3), 128) < 0) {
                            bArr[i4] = (byte) commonAsUtf8ToByteArray.charAt(i3);
                            i3++;
                            i4++;
                        }
                    } else {
                        if (Intrinsics.compare((int) cCharAt3, 2048) < 0) {
                            bArr[i4] = (byte) ((cCharAt3 >> 6) | JfifUtil.MARKER_SOFn);
                            i = i4 + 2;
                            bArr[i4 + 1] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (55296 > cCharAt3 || 57343 < cCharAt3) {
                            bArr[i4] = (byte) ((cCharAt3 >> '\f') | 224);
                            bArr[i4 + 1] = (byte) ((63 & (cCharAt3 >> 6)) | 128);
                            i = i4 + 3;
                            bArr[i4 + 2] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (Intrinsics.compare((int) cCharAt3, 56319) > 0 || length2 <= (i2 = i3 + 1) || 56320 > (cCharAt = commonAsUtf8ToByteArray.charAt(i2)) || 57343 < cCharAt) {
                            bArr[i4] = Utf8.REPLACEMENT_BYTE;
                            i3++;
                            i4++;
                        } else {
                            int iCharAt = ((cCharAt3 << '\n') + commonAsUtf8ToByteArray.charAt(i2)) - 56613888;
                            bArr[i4] = (byte) ((iCharAt >> 18) | 240);
                            bArr[i4 + 1] = (byte) (((iCharAt >> 12) & 63) | 128);
                            bArr[i4 + 2] = (byte) (((iCharAt >> 6) & 63) | 128);
                            bArr[i4 + 3] = (byte) ((iCharAt & 63) | 128);
                            i3 += 2;
                            i4 += 4;
                        }
                        i4 = i;
                        i3++;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i4);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i3] = (byte) cCharAt2;
            i3++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, commonAsUtf8ToByteArray.length());
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf2;
    }
}
