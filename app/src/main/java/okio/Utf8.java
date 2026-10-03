package okio;

import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i) {
        return (i >= 0 && 31 >= i) || (127 <= i && 159 >= i);
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 192) == 128;
    }

    public static final long size(@NotNull String str) {
        return size$default(str, 0, 0, 3, null);
    }

    public static final long size(@NotNull String str, int i) {
        return size$default(str, i, 0, 2, null);
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }

    public static final long size(@NotNull String utf8Size, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(utf8Size, "$this$utf8Size");
        if (i < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (i2 > utf8Size.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + utf8Size.length()).toString());
        }
        long j = 0;
        while (i < i2) {
            char cCharAt = utf8Size.charAt(i);
            if (cCharAt < 128) {
                j++;
            } else {
                if (cCharAt < 2048) {
                    i3 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i3 = 3;
                } else {
                    int i4 = i + 1;
                    char cCharAt2 = i4 < i2 ? utf8Size.charAt(i4) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j++;
                        i = i4;
                    } else {
                        j += (long) 4;
                        i += 2;
                    }
                }
                j += (long) i3;
            }
            i++;
        }
        return j;
    }

    public static final void processUtf8Bytes(@NotNull String processUtf8Bytes, int i, int i2, @NotNull Function1<? super Byte, Unit> yield) {
        int i3;
        char cCharAt;
        Intrinsics.checkNotNullParameter(processUtf8Bytes, "$this$processUtf8Bytes");
        Intrinsics.checkNotNullParameter(yield, "yield");
        while (i < i2) {
            char cCharAt2 = processUtf8Bytes.charAt(i);
            if (Intrinsics.compare((int) cCharAt2, 128) < 0) {
                yield.invoke(Byte.valueOf((byte) cCharAt2));
                while (true) {
                    i++;
                    if (i >= i2 || Intrinsics.compare((int) processUtf8Bytes.charAt(i), 128) >= 0) {
                        break;
                    } else {
                        yield.invoke(Byte.valueOf((byte) processUtf8Bytes.charAt(i)));
                    }
                }
            } else {
                if (Intrinsics.compare((int) cCharAt2, 2048) < 0) {
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 >> 6) | JfifUtil.MARKER_SOFn)));
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (55296 > cCharAt2 || 57343 < cCharAt2) {
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 >> '\f') | 224)));
                    yield.invoke(Byte.valueOf((byte) (((cCharAt2 >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (Intrinsics.compare((int) cCharAt2, 56319) > 0 || i2 <= (i3 = i + 1) || 56320 > (cCharAt = processUtf8Bytes.charAt(i3)) || 57343 < cCharAt) {
                    yield.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                } else {
                    int iCharAt = ((cCharAt2 << '\n') + processUtf8Bytes.charAt(i3)) - 56613888;
                    yield.invoke(Byte.valueOf((byte) ((iCharAt >> 18) | 240)));
                    yield.invoke(Byte.valueOf((byte) (((iCharAt >> 12) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) (((iCharAt >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((iCharAt & 63) | 128)));
                    i += 2;
                }
                i++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:82:0x0148  */
    /* JADX WARN: Code duplicated, block: B:84:0x0153  */
    public static final void processUtf8CodePoints(@NotNull byte[] processUtf8CodePoints, int i, int i2, @NotNull Function1<? super Integer, Unit> yield) {
        int i3;
        Intrinsics.checkNotNullParameter(processUtf8CodePoints, "$this$processUtf8CodePoints");
        Intrinsics.checkNotNullParameter(yield, "yield");
        while (i < i2) {
            byte b = processUtf8CodePoints[i];
            if (b >= 0) {
                yield.invoke(Integer.valueOf(b));
                i++;
                while (i < i2) {
                    byte b2 = processUtf8CodePoints[i];
                    if (b2 < 0) {
                        break;
                    }
                    i++;
                    yield.invoke(Integer.valueOf(b2));
                }
            } else if ((b >> 5) == -2) {
                int i4 = i + 1;
                if (i2 > i4) {
                    byte b3 = processUtf8CodePoints[i4];
                    if ((b3 & 192) == 128) {
                        int i5 = (b << 6) ^ (b3 ^ 3968);
                        yield.invoke(i5 < 128 ? Integer.valueOf(REPLACEMENT_CODE_POINT) : Integer.valueOf(i5));
                        Unit unit = Unit.INSTANCE;
                        i3 = 2;
                        i += i3;
                    }
                }
                yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                Unit unit2 = Unit.INSTANCE;
                i3 = 1;
                i += i3;
            } else if ((b >> 4) == -2) {
                int i6 = i + 2;
                if (i2 <= i6) {
                    yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    Unit unit3 = Unit.INSTANCE;
                    int i7 = i + 1;
                    if (i2 <= i7 || (processUtf8CodePoints[i7] & 192) != 128) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                } else {
                    byte b4 = processUtf8CodePoints[i + 1];
                    if ((b4 & 192) == 128) {
                        byte b5 = processUtf8CodePoints[i6];
                        if ((b5 & 192) == 128) {
                            int i8 = (b << Ascii.FF) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                            yield.invoke((i8 >= 2048 && (55296 > i8 || 57343 < i8)) ? Integer.valueOf(i8) : Integer.valueOf(REPLACEMENT_CODE_POINT));
                            Unit unit4 = Unit.INSTANCE;
                            i3 = 3;
                        } else {
                            yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            Unit unit5 = Unit.INSTANCE;
                            i3 = 2;
                        }
                    } else {
                        yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        Unit unit6 = Unit.INSTANCE;
                        i3 = 1;
                    }
                }
                i += i3;
            } else if ((b >> 3) == -2) {
                int i9 = i + 3;
                if (i2 <= i9) {
                    yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    Unit unit7 = Unit.INSTANCE;
                    int i10 = i + 1;
                    if (i2 <= i10 || (processUtf8CodePoints[i10] & 192) != 128) {
                        i3 = 1;
                    } else {
                        int i11 = i + 2;
                        if (i2 <= i11 || (processUtf8CodePoints[i11] & 192) != 128) {
                            i3 = 2;
                        } else {
                            i3 = 3;
                        }
                    }
                } else {
                    byte b6 = processUtf8CodePoints[i + 1];
                    if ((b6 & 192) == 128) {
                        byte b7 = processUtf8CodePoints[i + 2];
                        if ((b7 & 192) == 128) {
                            byte b8 = processUtf8CodePoints[i9];
                            if ((b8 & 192) == 128) {
                                int i12 = (b << Ascii.DC2) ^ (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << Ascii.FF));
                                yield.invoke((i12 <= 1114111 && (55296 > i12 || 57343 < i12) && i12 >= 65536) ? Integer.valueOf(i12) : Integer.valueOf(REPLACEMENT_CODE_POINT));
                                Unit unit8 = Unit.INSTANCE;
                                i3 = 4;
                            } else {
                                yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                Unit unit9 = Unit.INSTANCE;
                                i3 = 3;
                            }
                        } else {
                            yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            Unit unit10 = Unit.INSTANCE;
                            i3 = 2;
                        }
                    } else {
                        yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        Unit unit11 = Unit.INSTANCE;
                        i3 = 1;
                    }
                }
                i += i3;
            } else {
                yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                i++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:84:0x0165  */
    /* JADX WARN: Code duplicated, block: B:86:0x0170  */
    public static final void processUtf16Chars(@NotNull byte[] processUtf16Chars, int i, int i2, @NotNull Function1<? super Character, Unit> yield) {
        int i3;
        Intrinsics.checkNotNullParameter(processUtf16Chars, "$this$processUtf16Chars");
        Intrinsics.checkNotNullParameter(yield, "yield");
        while (i < i2) {
            byte b = processUtf16Chars[i];
            if (b >= 0) {
                yield.invoke(Character.valueOf((char) b));
                i++;
                while (i < i2) {
                    byte b2 = processUtf16Chars[i];
                    if (b2 < 0) {
                        break;
                    }
                    i++;
                    yield.invoke(Character.valueOf((char) b2));
                }
            } else if ((b >> 5) == -2) {
                int i4 = i + 1;
                if (i2 > i4) {
                    byte b3 = processUtf16Chars[i4];
                    if ((b3 & 192) == 128) {
                        int i5 = (b << 6) ^ (b3 ^ 3968);
                        yield.invoke(Character.valueOf(i5 < 128 ? (char) REPLACEMENT_CODE_POINT : (char) i5));
                        Unit unit = Unit.INSTANCE;
                        i3 = 2;
                        i += i3;
                    }
                }
                yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                Unit unit2 = Unit.INSTANCE;
                i3 = 1;
                i += i3;
            } else if ((b >> 4) == -2) {
                int i6 = i + 2;
                if (i2 <= i6) {
                    yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                    Unit unit3 = Unit.INSTANCE;
                    int i7 = i + 1;
                    if (i2 <= i7 || (processUtf16Chars[i7] & 192) != 128) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                } else {
                    byte b4 = processUtf16Chars[i + 1];
                    if ((b4 & 192) == 128) {
                        byte b5 = processUtf16Chars[i6];
                        if ((b5 & 192) == 128) {
                            int i8 = (b << Ascii.FF) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                            yield.invoke(Character.valueOf((i8 >= 2048 && (55296 > i8 || 57343 < i8)) ? (char) i8 : (char) REPLACEMENT_CODE_POINT));
                            Unit unit4 = Unit.INSTANCE;
                            i3 = 3;
                        } else {
                            yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            Unit unit5 = Unit.INSTANCE;
                            i3 = 2;
                        }
                    } else {
                        yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                        Unit unit6 = Unit.INSTANCE;
                        i3 = 1;
                    }
                }
                i += i3;
            } else if ((b >> 3) == -2) {
                int i9 = i + 3;
                if (i2 <= i9) {
                    yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                    Unit unit7 = Unit.INSTANCE;
                    int i10 = i + 1;
                    if (i2 <= i10 || (processUtf16Chars[i10] & 192) != 128) {
                        i3 = 1;
                    } else {
                        int i11 = i + 2;
                        if (i2 <= i11 || (processUtf16Chars[i11] & 192) != 128) {
                            i3 = 2;
                        } else {
                            i3 = 3;
                        }
                    }
                } else {
                    byte b6 = processUtf16Chars[i + 1];
                    if ((b6 & 192) == 128) {
                        byte b7 = processUtf16Chars[i + 2];
                        if ((b7 & 192) == 128) {
                            byte b8 = processUtf16Chars[i9];
                            if ((b8 & 192) == 128) {
                                int i12 = (b << Ascii.DC2) ^ (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << Ascii.FF));
                                if (i12 <= 1114111 && ((55296 > i12 || 57343 < i12) && i12 >= 65536 && i12 != 65533)) {
                                    yield.invoke(Character.valueOf((char) ((i12 >>> 10) + HIGH_SURROGATE_HEADER)));
                                    yield.invoke(Character.valueOf((char) ((i12 & 1023) + LOG_SURROGATE_HEADER)));
                                } else {
                                    yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                }
                                Unit unit8 = Unit.INSTANCE;
                                i3 = 4;
                            } else {
                                yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                Unit unit9 = Unit.INSTANCE;
                                i3 = 3;
                            }
                        } else {
                            yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            Unit unit10 = Unit.INSTANCE;
                            i3 = 2;
                        }
                    } else {
                        yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                        Unit unit11 = Unit.INSTANCE;
                        i3 = 1;
                    }
                }
                i += i3;
            } else {
                yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                i++;
            }
        }
    }

    public static final int process2Utf8Bytes(@NotNull byte[] process2Utf8Bytes, int i, int i2, @NotNull Function1<? super Integer, Unit> yield) {
        Intrinsics.checkNotNullParameter(process2Utf8Bytes, "$this$process2Utf8Bytes");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i3 = i + 1;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            yield.invoke(numValueOf);
            return 1;
        }
        byte b = process2Utf8Bytes[i];
        byte b2 = process2Utf8Bytes[i3];
        if ((b2 & 192) != 128) {
            yield.invoke(numValueOf);
            return 1;
        }
        int i4 = (b2 ^ 3968) ^ (b << 6);
        if (i4 < 128) {
            yield.invoke(numValueOf);
            return 2;
        }
        yield.invoke(Integer.valueOf(i4));
        return 2;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] process3Utf8Bytes, int i, int i2, @NotNull Function1<? super Integer, Unit> yield) {
        Intrinsics.checkNotNullParameter(process3Utf8Bytes, "$this$process3Utf8Bytes");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i3 = i + 2;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            yield.invoke(numValueOf);
            int i4 = i + 1;
            return (i2 <= i4 || (process3Utf8Bytes[i4] & 192) != 128) ? 1 : 2;
        }
        byte b = process3Utf8Bytes[i];
        byte b2 = process3Utf8Bytes[i + 1];
        if ((b2 & 192) != 128) {
            yield.invoke(numValueOf);
            return 1;
        }
        byte b3 = process3Utf8Bytes[i3];
        if ((b3 & 192) != 128) {
            yield.invoke(numValueOf);
            return 2;
        }
        int i5 = ((b3 ^ (-123008)) ^ (b2 << 6)) ^ (b << Ascii.FF);
        if (i5 < 2048) {
            yield.invoke(numValueOf);
            return 3;
        }
        if (55296 <= i5 && 57343 >= i5) {
            yield.invoke(numValueOf);
            return 3;
        }
        yield.invoke(Integer.valueOf(i5));
        return 3;
    }

    public static final int process4Utf8Bytes(@NotNull byte[] process4Utf8Bytes, int i, int i2, @NotNull Function1<? super Integer, Unit> yield) {
        Intrinsics.checkNotNullParameter(process4Utf8Bytes, "$this$process4Utf8Bytes");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i3 = i + 3;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            yield.invoke(numValueOf);
            int i4 = i + 1;
            if (i2 <= i4 || (process4Utf8Bytes[i4] & 192) != 128) {
                return 1;
            }
            int i5 = i + 2;
            return (i2 <= i5 || (process4Utf8Bytes[i5] & 192) != 128) ? 2 : 3;
        }
        byte b = process4Utf8Bytes[i];
        byte b2 = process4Utf8Bytes[i + 1];
        if ((b2 & 192) != 128) {
            yield.invoke(numValueOf);
            return 1;
        }
        byte b3 = process4Utf8Bytes[i + 2];
        if ((b3 & 192) != 128) {
            yield.invoke(numValueOf);
            return 2;
        }
        byte b4 = process4Utf8Bytes[i3];
        if ((b4 & 192) != 128) {
            yield.invoke(numValueOf);
            return 3;
        }
        int i6 = (((b4 ^ 3678080) ^ (b3 << 6)) ^ (b2 << Ascii.FF)) ^ (b << Ascii.DC2);
        if (i6 > 1114111) {
            yield.invoke(numValueOf);
            return 4;
        }
        if (55296 <= i6 && 57343 >= i6) {
            yield.invoke(numValueOf);
            return 4;
        }
        if (i6 < 65536) {
            yield.invoke(numValueOf);
            return 4;
        }
        yield.invoke(Integer.valueOf(i6));
        return 4;
    }
}
