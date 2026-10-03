package com.google.common.base;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
public final class Utf8 {
    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int iEncodedLengthGeneral = length;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt >= 2048) {
                iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i);
                break;
            }
            iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
            i++;
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(((long) iEncodedLengthGeneral) + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 2048) {
                i2 += (127 - cCharAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) == cCharAt) {
                        throw new IllegalArgumentException(unpairedSurrogateMsg(i));
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    public static boolean isWellFormed(byte[] bArr) {
        return isWellFormed(bArr, 0, bArr.length);
    }

    public static boolean isWellFormed(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        Preconditions.checkPositionIndexes(i, i3, bArr.length);
        while (i < i3) {
            if (bArr[i] < 0) {
                return isWellFormedSlowPath(bArr, i, i3);
            }
            i++;
        }
        return true;
    }

    private static boolean isWellFormedSlowPath(byte[] bArr, int i, int i2) {
        byte b;
        byte b2;
        while (i < i2) {
            int i3 = i + 1;
            byte b3 = bArr[i];
            if (b3 < 0) {
                if (b3 < -32) {
                    if (i3 != i2 && b3 >= -62) {
                        i += 2;
                        if (bArr[i3] > -65) {
                        }
                    }
                    return false;
                }
                if (b3 >= -16) {
                    int i4 = i + 3;
                    if (i4 < i2 && (b2 = bArr[i3]) <= -65 && (((b3 << Ascii.FS) + (b2 + 112)) >> 30) == 0 && bArr[i + 2] <= -65) {
                        i += 4;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return false;
                }
                int i5 = i + 2;
                if (i5 < i2 && (b = bArr[i3]) <= -65 && ((b3 != -32 || b >= -96) && (b3 != -19 || -96 > b))) {
                    i += 3;
                    if (bArr[i5] > -65) {
                    }
                }
                return false;
            }
            i = i3;
        }
        return true;
    }

    private static String unpairedSurrogateMsg(int i) {
        StringBuilder sb = new StringBuilder(39);
        sb.append("Unpaired surrogate at index ");
        sb.append(i);
        return sb.toString();
    }

    private Utf8() {
    }
}
