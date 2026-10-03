package com.google.android.gms.internal.mlkit_vision_barcode;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes2.dex */
final class zzcj {
    static int zza(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }

    static int zzb(@CheckForNull Object obj, @CheckForNull Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, @CheckForNull Object[] objArr2) {
        int iZza = zzck.zza(obj);
        int i2 = iZza & i;
        int iZzc = zzc(obj3, i2);
        if (iZzc != 0) {
            int i3 = ~i;
            int i4 = -1;
            while (true) {
                int i5 = iZzc - 1;
                int i6 = iArr[i5];
                int i7 = i6 & i;
                if ((i6 & i3) != (iZza & i3) || !zzax.zza(obj, objArr[i5]) || (objArr2 != null && !zzax.zza(obj2, objArr2[i5]))) {
                    if (i7 == 0) {
                        break;
                    }
                    i4 = i5;
                    iZzc = i7;
                } else {
                    if (i4 == -1) {
                        zze(obj3, i2, i7);
                    } else {
                        iArr[i4] = (iArr[i4] & i3) | (i7 & i);
                    }
                    return i5;
                }
            }
        }
        return -1;
    }

    static int zzc(Object obj, int i) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & 255;
        }
        return obj instanceof short[] ? (char) ((short[]) obj)[i] : ((int[]) obj)[i];
    }

    static Object zzd(int i) {
        if (i >= 2 && i <= 1073741824 && Integer.highestOneBit(i) == i) {
            if (i <= 256) {
                return new byte[i];
            }
            return i <= 65536 ? new short[i] : new int[i];
        }
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i);
    }

    static void zze(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }
}
