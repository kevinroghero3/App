package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
final class zzid {
    static double zza(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzd(bArr, i));
    }

    static float zzb(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzc(bArr, i));
    }

    static int zza(byte[] bArr, int i, zzig zzigVar) throws zzkc {
        int iZzc = zzc(bArr, i, zzigVar);
        int i2 = zzigVar.zza;
        if (i2 < 0) {
            throw zzkc.zzf();
        }
        if (i2 > bArr.length - iZzc) {
            throw zzkc.zzh();
        }
        if (i2 == 0) {
            zzigVar.zzc = zzih.zza;
            return iZzc;
        }
        zzigVar.zzc = zzih.zza(bArr, iZzc, i2);
        return iZzc + i2;
    }

    static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static int zza(zzlz zzlzVar, byte[] bArr, int i, int i2, int i3, zzig zzigVar) throws IOException {
        Object objZza = zzlzVar.zza();
        int iZza = zza(objZza, zzlzVar, bArr, i, i2, i3, zzigVar);
        zzlzVar.zzc(objZza);
        zzigVar.zzc = objZza;
        return iZza;
    }

    static int zza(zzlz zzlzVar, byte[] bArr, int i, int i2, zzig zzigVar) throws IOException {
        Object objZza = zzlzVar.zza();
        int iZza = zza(objZza, zzlzVar, bArr, i, i2, zzigVar);
        zzlzVar.zzc(objZza);
        zzigVar.zzc = objZza;
        return iZza;
    }

    static int zza(zzlz<?> zzlzVar, int i, byte[] bArr, int i2, int i3, zzkd<?> zzkdVar, zzig zzigVar) throws IOException {
        int iZza = zza(zzlzVar, bArr, i2, i3, zzigVar);
        zzkdVar.add(zzigVar.zzc);
        while (iZza < i3) {
            int iZzc = zzc(bArr, iZza, zzigVar);
            if (i != zzigVar.zza) {
                break;
            }
            iZza = zza(zzlzVar, bArr, iZzc, i3, zzigVar);
            zzkdVar.add(zzigVar.zzc);
        }
        return iZza;
    }

    static int zza(byte[] bArr, int i, zzkd<?> zzkdVar, zzig zzigVar) throws IOException {
        zzjv zzjvVar = (zzjv) zzkdVar;
        int iZzc = zzc(bArr, i, zzigVar);
        int i2 = zzigVar.zza + iZzc;
        while (iZzc < i2) {
            iZzc = zzc(bArr, iZzc, zzigVar);
            zzjvVar.zzd(zzigVar.zza);
        }
        if (iZzc == i2) {
            return iZzc;
        }
        throw zzkc.zzh();
    }

    static int zzb(byte[] bArr, int i, zzig zzigVar) throws zzkc {
        int iZzc = zzc(bArr, i, zzigVar);
        int i2 = zzigVar.zza;
        if (i2 < 0) {
            throw zzkc.zzf();
        }
        if (i2 == 0) {
            zzigVar.zzc = "";
            return iZzc;
        }
        zzigVar.zzc = zzne.zzb(bArr, iZzc, i2);
        return iZzc + i2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzmx zzmxVar, zzig zzigVar) throws zzkc {
        if ((i >>> 3) == 0) {
            throw zzkc.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzd = zzd(bArr, i2, zzigVar);
            zzmxVar.zza(i, Long.valueOf(zzigVar.zzb));
            return iZzd;
        }
        if (i4 == 1) {
            zzmxVar.zza(i, Long.valueOf(zzd(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzc = zzc(bArr, i2, zzigVar);
            int i5 = zzigVar.zza;
            if (i5 < 0) {
                throw zzkc.zzf();
            }
            if (i5 > bArr.length - iZzc) {
                throw zzkc.zzh();
            }
            if (i5 == 0) {
                zzmxVar.zza(i, zzih.zza);
            } else {
                zzmxVar.zza(i, zzih.zza(bArr, iZzc, i5));
            }
            return iZzc + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzmxVar.zza(i, Integer.valueOf(zzc(bArr, i2)));
                return i2 + 4;
            }
            throw zzkc.zzc();
        }
        zzmx zzmxVarZzd = zzmx.zzd();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (i2 < i3) {
            int iZzc2 = zzc(bArr, i2, zzigVar);
            int i8 = zzigVar.zza;
            if (i8 == i6) {
                i7 = i8;
                i2 = iZzc2;
                break;
            }
            i7 = i8;
            i2 = zza(i8, bArr, iZzc2, i3, zzmxVarZzd, zzigVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzkc.zzg();
        }
        zzmxVar.zza(i, zzmxVarZzd);
        return i2;
    }

    static int zzc(byte[] bArr, int i, zzig zzigVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzigVar.zza = b;
            return i2;
        }
        return zza(b, bArr, i2, zzigVar);
    }

    static int zza(int i, byte[] bArr, int i2, zzig zzigVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzigVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzigVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzigVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzigVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        while (true) {
            int i11 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzigVar.zza = i9 | ((b4 & 127) << 28);
                return i11;
            }
            i10 = i11;
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzkd<?> zzkdVar, zzig zzigVar) {
        zzjv zzjvVar = (zzjv) zzkdVar;
        int iZzc = zzc(bArr, i2, zzigVar);
        zzjvVar.zzd(zzigVar.zza);
        while (iZzc < i3) {
            int iZzc2 = zzc(bArr, iZzc, zzigVar);
            if (i != zzigVar.zza) {
                break;
            }
            iZzc = zzc(bArr, iZzc2, zzigVar);
            zzjvVar.zzd(zzigVar.zza);
        }
        return iZzc;
    }

    static int zzd(byte[] bArr, int i, zzig zzigVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzigVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            b = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b & 127)) << i4;
            i3++;
        }
        zzigVar.zzb = j2;
        return i3;
    }

    static int zza(Object obj, zzlz zzlzVar, byte[] bArr, int i, int i2, int i3, zzig zzigVar) throws IOException {
        int iZza = ((zzll) zzlzVar).zza(obj, bArr, i, i2, i3, zzigVar);
        zzigVar.zzc = obj;
        return iZza;
    }

    static int zza(Object obj, zzlz zzlzVar, byte[] bArr, int i, int i2, zzig zzigVar) throws IOException {
        int iZza = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZza = zza(i3, bArr, iZza, zzigVar);
            i3 = zzigVar.zza;
        }
        int i4 = iZza;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzkc.zzh();
        }
        int i5 = i3 + i4;
        zzlzVar.zza(obj, bArr, i4, i5, zzigVar);
        zzigVar.zzc = obj;
        return i5;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzig zzigVar) throws zzkc {
        if ((i >>> 3) == 0) {
            throw zzkc.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzd(bArr, i2, zzigVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzc(bArr, i2, zzigVar) + zzigVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzkc.zzc();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzc(bArr, i2, zzigVar);
            i6 = zzigVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zza(i6, bArr, i2, i3, zzigVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzkc.zzg();
        }
        return i2;
    }

    static long zzd(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
