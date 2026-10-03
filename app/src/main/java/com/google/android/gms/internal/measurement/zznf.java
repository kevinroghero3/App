package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes4.dex */
final class zznf extends zzng {
    @Override // com.google.android.gms.internal.measurement.zzng
    final int zza(String str, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        char cCharAt;
        int length = str.length();
        int i6 = i2 + i;
        int i7 = 0;
        while (i7 < length && (i5 = i7 + i) < i6 && (cCharAt = str.charAt(i7)) < 128) {
            bArr[i5] = (byte) cCharAt;
            i7++;
        }
        if (i7 == length) {
            return i + length;
        }
        int i8 = i + i7;
        while (i7 < length) {
            char cCharAt2 = str.charAt(i7);
            if (cCharAt2 >= 128 || i8 >= i6) {
                if (cCharAt2 < 2048 && i8 <= i6 - 2) {
                    bArr[i8] = (byte) ((cCharAt2 >>> 6) | 960);
                    i3 = i8 + 2;
                    bArr[i8 + 1] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i8 > i6 - 3) {
                        if (i8 > i6 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i7 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i4)))) {
                                throw new zzni(i7, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i8);
                        }
                        int i9 = i7 + 1;
                        if (i9 != str.length()) {
                            char cCharAt3 = str.charAt(i9);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i8 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                bArr[i8 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                bArr[i8 + 3] = (byte) ((codePoint & 63) | 128);
                                i8 += 4;
                                i7 = i9;
                            } else {
                                i7 = i9;
                            }
                        }
                        throw new zzni(i7 - 1, length);
                    }
                    bArr[i8] = (byte) ((cCharAt2 >>> '\f') | 480);
                    bArr[i8 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i3 = i8 + 3;
                    bArr[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                }
                i8 = i3;
            } else {
                bArr[i8] = (byte) cCharAt2;
                i8++;
            }
            i7++;
        }
        return i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzng
    final int zza(int i, byte[] bArr, int i2, int i3) {
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            return 0;
        }
        while (i2 < i3) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b < 0) {
                if (b < -32) {
                    if (i4 >= i3) {
                        return b;
                    }
                    if (b >= -62) {
                        i2 += 2;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return -1;
                }
                if (b >= -16) {
                    if (i4 >= i3 - 2) {
                        return zzne.zza(bArr, i4, i3);
                    }
                    byte b2 = bArr[i4];
                    if (b2 <= -65 && (((b << Ascii.FS) + (b2 + 112)) >> 30) == 0 && bArr[i2 + 2] <= -65) {
                        i4 = i2 + 4;
                        if (bArr[i2 + 3] > -65) {
                        }
                    }
                    return -1;
                }
                if (i4 >= i3 - 1) {
                    return zzne.zza(bArr, i4, i3);
                }
                byte b3 = bArr[i4];
                if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                    i4 = i2 + 3;
                    if (bArr[i2 + 2] > -65) {
                    }
                }
                return -1;
            }
            i2 = i4;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzng
    final String zza(byte[] bArr, int i, int i2) throws zzkc {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = bArr[i];
            if (b < 0) {
                break;
            }
            i++;
            zznd.zza(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                zznd.zza(b2, cArr, i5);
                i5++;
                i = i6;
                while (i < i3) {
                    byte b3 = bArr[i];
                    if (b3 < 0) {
                        break;
                    }
                    i++;
                    zznd.zza(b3, cArr, i5);
                    i5++;
                }
            } else if (b2 < -32) {
                if (i6 >= i3) {
                    throw zzkc.zzd();
                }
                i += 2;
                zznd.zza(b2, bArr[i6], cArr, i5);
                i5++;
            } else if (b2 < -16) {
                if (i6 >= i3 - 1) {
                    throw zzkc.zzd();
                }
                zznd.zza(b2, bArr[i6], bArr[i + 2], cArr, i5);
                i5++;
                i += 3;
            } else {
                if (i6 >= i3 - 2) {
                    throw zzkc.zzd();
                }
                zznd.zza(b2, bArr[i6], bArr[i + 2], bArr[i + 3], cArr, i5);
                i5 += 2;
                i += 4;
            }
        }
        return new String(cArr, 0, i5);
    }

    zznf() {
    }
}
