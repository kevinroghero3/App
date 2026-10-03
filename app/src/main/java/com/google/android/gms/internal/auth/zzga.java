package com.google.android.gms.internal.auth;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.soloader.Elf64;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes4.dex */
final class zzga<T> implements zzgi<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhj.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfx zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzfl zzk;
    private final zzgz zzl;
    private final zzem zzm;
    private final zzgc zzn;
    private final zzfs zzo;

    private zzga(int[] iArr, Object[] objArr, int i, int i2, zzfx zzfxVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzgc zzgcVar, zzfl zzflVar, zzgz zzgzVar, zzem zzemVar, zzfs zzfsVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzh = iArr2;
        this.zzi = i4;
        this.zzj = i5;
        this.zzn = zzgcVar;
        this.zzk = zzflVar;
        this.zzl = zzgzVar;
        this.zzm = zzemVar;
        this.zzg = zzfxVar;
        this.zzo = zzfsVar;
    }

    private final void zzA(Object obj, int i, int i2) {
        zzhj.zzn(obj, zzl(i2) & 1048575, i);
    }

    private final void zzB(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzo(i) & 1048575, obj2);
        zzz(obj, i);
    }

    private final void zzC(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzo(i2) & 1048575, obj2);
        zzA(obj, i, i2);
    }

    private final boolean zzD(Object obj, Object obj2, int i) {
        return zzE(obj, i) == zzE(obj2, i);
    }

    private final boolean zzE(Object obj, int i) {
        int iZzl = zzl(i);
        long j = iZzl & 1048575;
        if (j != 1048575) {
            return (zzhj.zzc(obj, j) & (1 << (iZzl >>> 20))) != 0;
        }
        int iZzo = zzo(i);
        long j2 = iZzo & 1048575;
        switch (zzn(iZzo)) {
            case 0:
                return Double.doubleToRawLongBits(zzhj.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhj.zzb(obj, j2)) != 0;
            case 2:
                return zzhj.zzd(obj, j2) != 0;
            case 3:
                return zzhj.zzd(obj, j2) != 0;
            case 4:
                return zzhj.zzc(obj, j2) != 0;
            case 5:
                return zzhj.zzd(obj, j2) != 0;
            case 6:
                return zzhj.zzc(obj, j2) != 0;
            case 7:
                return zzhj.zzt(obj, j2);
            case 8:
                Object objZzf = zzhj.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzef) {
                    return !zzef.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhj.zzf(obj, j2) != null;
            case 10:
                return !zzef.zzb.equals(zzhj.zzf(obj, j2));
            case 11:
                return zzhj.zzc(obj, j2) != 0;
            case 12:
                return zzhj.zzc(obj, j2) != 0;
            case 13:
                return zzhj.zzc(obj, j2) != 0;
            case 14:
                return zzhj.zzd(obj, j2) != 0;
            case 15:
                return zzhj.zzc(obj, j2) != 0;
            case 16:
                return zzhj.zzd(obj, j2) != 0;
            case 17:
                return zzhj.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzF(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzE(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzG(Object obj, int i, zzgi zzgiVar) {
        return zzgiVar.zzi(zzhj.zzf(obj, i & 1048575));
    }

    private static boolean zzH(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzev) {
            return ((zzev) obj).zzm();
        }
        return true;
    }

    private final boolean zzI(Object obj, int i, int i2) {
        return zzhj.zzc(obj, (long) (zzl(i2) & 1048575)) == i;
    }

    static zzha zzc(Object obj) {
        zzev zzevVar = (zzev) obj;
        zzha zzhaVar = zzevVar.zzc;
        if (zzhaVar != zzha.zza()) {
            return zzhaVar;
        }
        zzha zzhaVarZzd = zzha.zzd();
        zzevVar.zzc = zzhaVarZzd;
        return zzhaVarZzd;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x0250  */
    /* JADX WARN: Code duplicated, block: B:124:0x0253  */
    /* JADX WARN: Code duplicated, block: B:127:0x026b  */
    /* JADX WARN: Code duplicated, block: B:128:0x026e  */
    static zzga zzj(Class cls, zzfu zzfuVar, zzgc zzgcVar, zzfl zzflVar, zzgz zzgzVar, zzem zzemVar, zzfs zzfsVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        Class<?> cls2;
        int iObjectFieldOffset;
        int i18;
        int i19;
        int i20;
        int iObjectFieldOffset2;
        Field fieldZzv;
        char cCharAt9;
        int i21;
        int i22;
        int i23;
        Object obj;
        Field fieldZzv2;
        int i24;
        Object obj2;
        Field fieldZzv3;
        int i25;
        char cCharAt10;
        int i26;
        char cCharAt11;
        int i27;
        char cCharAt12;
        int i28;
        char cCharAt13;
        if (!(zzfuVar instanceof zzgh)) {
            throw null;
        }
        zzgh zzghVar = (zzgh) zzfuVar;
        String strZzd = zzghVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i29 = 1;
            while (true) {
                i = i29 + 1;
                if (strZzd.charAt(i29) < 55296) {
                    break;
                }
                i29 = i;
            }
        } else {
            i = 1;
        }
        int i30 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i31 = iCharAt3 & 8191;
            int i32 = 13;
            while (true) {
                i28 = i30 + 1;
                cCharAt13 = strZzd.charAt(i30);
                if (cCharAt13 < 55296) {
                    break;
                }
                i31 |= (cCharAt13 & 8191) << i32;
                i32 += 13;
                i30 = i28;
            }
            iCharAt3 = i31 | (cCharAt13 << i32);
            i30 = i28;
        }
        if (iCharAt3 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            i3 = 0;
            i6 = 0;
            i2 = 0;
            i4 = 0;
            iArr = zza;
            i5 = 0;
        } else {
            int i33 = i30 + 1;
            int iCharAt4 = strZzd.charAt(i30);
            if (iCharAt4 >= 55296) {
                int i34 = iCharAt4 & 8191;
                int i35 = 13;
                while (true) {
                    i14 = i33 + 1;
                    cCharAt8 = strZzd.charAt(i33);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i34 |= (cCharAt8 & 8191) << i35;
                    i35 += 13;
                    i33 = i14;
                }
                iCharAt4 = i34 | (cCharAt8 << i35);
                i33 = i14;
            }
            int i36 = i33 + 1;
            int iCharAt5 = strZzd.charAt(i33);
            if (iCharAt5 >= 55296) {
                int i37 = iCharAt5 & 8191;
                int i38 = 13;
                while (true) {
                    i13 = i36 + 1;
                    cCharAt7 = strZzd.charAt(i36);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt7 & 8191) << i38;
                    i38 += 13;
                    i36 = i13;
                }
                iCharAt5 = i37 | (cCharAt7 << i38);
                i36 = i13;
            }
            int i39 = i36 + 1;
            int iCharAt6 = strZzd.charAt(i36);
            if (iCharAt6 >= 55296) {
                int i40 = iCharAt6 & 8191;
                int i41 = 13;
                while (true) {
                    i12 = i39 + 1;
                    cCharAt6 = strZzd.charAt(i39);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt6 & 8191) << i41;
                    i41 += 13;
                    i39 = i12;
                }
                iCharAt6 = i40 | (cCharAt6 << i41);
                i39 = i12;
            }
            int i42 = i39 + 1;
            int iCharAt7 = strZzd.charAt(i39);
            if (iCharAt7 >= 55296) {
                int i43 = iCharAt7 & 8191;
                int i44 = 13;
                while (true) {
                    i11 = i42 + 1;
                    cCharAt5 = strZzd.charAt(i42);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt5 & 8191) << i44;
                    i44 += 13;
                    i42 = i11;
                }
                iCharAt7 = i43 | (cCharAt5 << i44);
                i42 = i11;
            }
            int i45 = i42 + 1;
            iCharAt = strZzd.charAt(i42);
            if (iCharAt >= 55296) {
                int i46 = iCharAt & 8191;
                int i47 = 13;
                while (true) {
                    i10 = i45 + 1;
                    cCharAt4 = strZzd.charAt(i45);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt4 & 8191) << i47;
                    i47 += 13;
                    i45 = i10;
                }
                iCharAt = i46 | (cCharAt4 << i47);
                i45 = i10;
            }
            int i48 = i45 + 1;
            iCharAt2 = strZzd.charAt(i45);
            if (iCharAt2 >= 55296) {
                int i49 = iCharAt2 & 8191;
                int i50 = 13;
                while (true) {
                    i9 = i48 + 1;
                    cCharAt3 = strZzd.charAt(i48);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt3 & 8191) << i50;
                    i50 += 13;
                    i48 = i9;
                }
                iCharAt2 = i49 | (cCharAt3 << i50);
                i48 = i9;
            }
            int i51 = i48 + 1;
            int iCharAt8 = strZzd.charAt(i48);
            if (iCharAt8 >= 55296) {
                int i52 = iCharAt8 & 8191;
                int i53 = 13;
                while (true) {
                    i8 = i51 + 1;
                    cCharAt2 = strZzd.charAt(i51);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt2 & 8191) << i53;
                    i53 += 13;
                    i51 = i8;
                }
                iCharAt8 = i52 | (cCharAt2 << i53);
                i51 = i8;
            }
            int i54 = i51 + 1;
            int iCharAt9 = strZzd.charAt(i51);
            if (iCharAt9 >= 55296) {
                int i55 = iCharAt9 & 8191;
                int i56 = 13;
                while (true) {
                    i7 = i54 + 1;
                    cCharAt = strZzd.charAt(i54);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i55 |= (cCharAt & 8191) << i56;
                    i56 += 13;
                    i54 = i7;
                }
                iCharAt9 = i55 | (cCharAt << i56);
                i54 = i7;
            }
            i2 = iCharAt4 + iCharAt4 + iCharAt5;
            iArr = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i3 = iCharAt6;
            i4 = iCharAt9;
            i5 = iCharAt4;
            i6 = iCharAt7;
            i30 = i54;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzghVar.zze();
        Class<?> cls3 = zzghVar.zza().getClass();
        int i57 = i4 + iCharAt2;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[iCharAt + iCharAt];
        int i58 = 0;
        int i59 = 0;
        int i60 = i4;
        int i61 = i57;
        while (i30 < length) {
            int i62 = i30 + 1;
            int iCharAt10 = strZzd.charAt(i30);
            if (iCharAt10 >= c) {
                int i63 = iCharAt10 & 8191;
                int i64 = i62;
                int i65 = 13;
                while (true) {
                    i27 = i64 + 1;
                    cCharAt12 = strZzd.charAt(i64);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i63 |= (cCharAt12 & 8191) << i65;
                    i65 += 13;
                    i64 = i27;
                }
                iCharAt10 = i63 | (cCharAt12 << i65);
                i15 = i27;
            } else {
                i15 = i62;
            }
            int i66 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i67 = iCharAt11 & 8191;
                int i68 = i66;
                int i69 = 13;
                while (true) {
                    i26 = i68 + 1;
                    cCharAt11 = strZzd.charAt(i68);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i67 |= (cCharAt11 & 8191) << i69;
                    i69 += 13;
                    i68 = i26;
                }
                iCharAt11 = i67 | (cCharAt11 << i69);
                i16 = i26;
            } else {
                i16 = i66;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i59] = i58;
                i59++;
            }
            int i70 = iCharAt11 & 255;
            int i71 = length;
            if (i70 >= 51) {
                int i72 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i73 = iCharAt12 & 8191;
                    int i74 = 13;
                    while (true) {
                        i25 = i72 + 1;
                        cCharAt10 = strZzd.charAt(i72);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i73 |= (cCharAt10 & 8191) << i74;
                        i74 += 13;
                        i72 = i25;
                        c2 = 55296;
                    }
                    iCharAt12 = i73 | (cCharAt10 << i74);
                    i72 = i25;
                }
                int i75 = i70 - 51;
                int i76 = i72;
                if (i75 == 9 || i75 == 17) {
                    int i77 = i58 / 3;
                    i22 = i2 + 1;
                    objArr[i77 + i77 + 1] = objArrZze[i2];
                } else {
                    if (i75 == 12 && (zzghVar.zzc() == 1 || (iCharAt11 & 2048) != 0)) {
                        int i78 = i58 / 3;
                        i22 = i2 + 1;
                        objArr[i78 + i78 + 1] = objArrZze[i2];
                    }
                    i23 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i23];
                    if (obj instanceof Field) {
                        fieldZzv2 = (Field) obj;
                    } else {
                        fieldZzv2 = zzv(cls3, (String) obj);
                        objArrZze[i23] = fieldZzv2;
                    }
                    int i79 = i3;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzv2);
                    i24 = i23 + 1;
                    obj2 = objArrZze[i24];
                    if (obj2 instanceof Field) {
                        fieldZzv3 = (Field) obj2;
                    } else {
                        fieldZzv3 = zzv(cls3, (String) obj2);
                        objArrZze[i24] = fieldZzv3;
                    }
                    strZzd = strZzd;
                    i17 = i79;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzv3);
                    cls2 = cls3;
                    i20 = i2;
                    i18 = i76;
                    i19 = 0;
                }
                i2 = i22;
                i23 = iCharAt12 + iCharAt12;
                obj = objArrZze[i23];
                if (obj instanceof Field) {
                    fieldZzv2 = (Field) obj;
                } else {
                    fieldZzv2 = zzv(cls3, (String) obj);
                    objArrZze[i23] = fieldZzv2;
                }
                int i710 = i3;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzv2);
                i24 = i23 + 1;
                obj2 = objArrZze[i24];
                if (obj2 instanceof Field) {
                    fieldZzv3 = (Field) obj2;
                } else {
                    fieldZzv3 = zzv(cls3, (String) obj2);
                    objArrZze[i24] = fieldZzv3;
                }
                strZzd = strZzd;
                i17 = i710;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzv3);
                cls2 = cls3;
                i20 = i2;
                i18 = i76;
                i19 = 0;
            } else {
                int i80 = i3;
                int i81 = i2 + 1;
                Field fieldZzv4 = zzv(cls3, (String) objArrZze[i2]);
                if (i70 == 9 || i70 == 17) {
                    i17 = i80;
                    int i82 = i58 / 3;
                    objArr[i82 + i82 + 1] = fieldZzv4.getType();
                } else {
                    if (i70 == 27 || i70 == 49) {
                        i17 = i80;
                        int i83 = i58 / 3;
                        i21 = i2 + 2;
                        objArr[i83 + i83 + 1] = objArrZze[i81];
                    } else if (i70 == 12 || i70 == 30 || i70 == 44) {
                        i17 = i80;
                        if (zzghVar.zzc() == 1 || (iCharAt11 & 2048) != 0) {
                            int i84 = i58 / 3;
                            i21 = i2 + 2;
                            objArr[i84 + i84 + 1] = objArrZze[i81];
                        }
                    } else {
                        if (i70 == 50) {
                            int i85 = i60 + 1;
                            iArr[i60] = i58;
                            int i86 = i58 / 3;
                            int i87 = i2 + 2;
                            int i88 = i86 + i86;
                            objArr[i88] = objArrZze[i81];
                            if ((iCharAt11 & 2048) != 0) {
                                objArr[i88 + 1] = objArrZze[i87];
                                i60 = i85;
                                i81 = i2 + 3;
                            } else {
                                i60 = i85;
                                i81 = i87;
                            }
                        }
                        i17 = i80;
                    }
                    i81 = i21;
                }
                cls2 = cls3;
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzv4);
                if ((iCharAt11 & 4096) == 0 || i70 > 17) {
                    iObjectFieldOffset = 1048575;
                    i18 = i16;
                    i19 = 0;
                } else {
                    int i89 = i16 + 1;
                    int iCharAt13 = strZzd.charAt(i16);
                    if (iCharAt13 >= 55296) {
                        int i90 = iCharAt13 & 8191;
                        int i91 = 13;
                        while (true) {
                            i18 = i89 + 1;
                            cCharAt9 = strZzd.charAt(i89);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i90 |= (cCharAt9 & 8191) << i91;
                            i91 += 13;
                            i89 = i18;
                        }
                        iCharAt13 = i90 | (cCharAt9 << i91);
                    } else {
                        i18 = i89;
                    }
                    int i92 = i5 + i5 + (iCharAt13 / 32);
                    Object obj3 = objArrZze[i92];
                    if (obj3 instanceof Field) {
                        fieldZzv = (Field) obj3;
                    } else {
                        fieldZzv = zzv(cls2, (String) obj3);
                        objArrZze[i92] = fieldZzv;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzv);
                    i19 = iCharAt13 % 32;
                }
                if (i70 >= 18 && i70 <= 49) {
                    iArr[i61] = iObjectFieldOffset3;
                    i61++;
                }
                i20 = i81;
                iObjectFieldOffset2 = iObjectFieldOffset3;
            }
            iArr2[i58] = iCharAt10;
            iArr2[i58 + 1] = iObjectFieldOffset2 | ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i70 << 20);
            iArr2[i58 + 2] = iObjectFieldOffset | (i19 << 20);
            i58 += 3;
            cls3 = cls2;
            i2 = i20;
            i30 = i18;
            i3 = i17;
            strZzd = strZzd;
            length = i71;
            i6 = i6;
            c = 55296;
        }
        return new zzga(iArr2, objArr, i3, i6, zzghVar.zza(), zzghVar.zzc(), false, iArr, i4, i57, zzgcVar, zzflVar, zzgzVar, zzemVar, zzfsVar);
    }

    private static int zzk(Object obj, long j) {
        return ((Integer) zzhj.zzf(obj, j)).intValue();
    }

    private final int zzl(int i) {
        return this.zzc[i + 2];
    }

    private final int zzm(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzn(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzo(int i) {
        return this.zzc[i + 1];
    }

    private static long zzp(Object obj, long j) {
        return ((Long) zzhj.zzf(obj, j)).longValue();
    }

    private final zzey zzq(int i) {
        int i2 = i / 3;
        return (zzey) this.zzd[i2 + i2 + 1];
    }

    private final zzgi zzr(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgi zzgiVar = (zzgi) this.zzd[i3];
        if (zzgiVar != null) {
            return zzgiVar;
        }
        zzgi zzgiVarZzb = zzgf.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzgiVarZzb;
        return zzgiVarZzb;
    }

    private final Object zzs(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzt(Object obj, int i) {
        zzgi zzgiVarZzr = zzr(i);
        int iZzo = zzo(i);
        if (!zzE(obj, i)) {
            return zzgiVarZzr.zzd();
        }
        Object object = zzb.getObject(obj, 1048575 & iZzo);
        if (zzH(object)) {
            return object;
        }
        Object objZzd = zzgiVarZzr.zzd();
        if (object != null) {
            zzgiVarZzr.zzf(objZzd, object);
        }
        return objZzd;
    }

    private final Object zzu(Object obj, int i, int i2) {
        zzgi zzgiVarZzr = zzr(i2);
        if (!zzI(obj, i, i2)) {
            return zzgiVarZzr.zzd();
        }
        Object object = zzb.getObject(obj, zzo(i2) & 1048575);
        if (zzH(object)) {
            return object;
        }
        Object objZzd = zzgiVarZzr.zzd();
        if (object != null) {
            zzgiVarZzr.zzf(objZzd, object);
        }
        return objZzd;
    }

    private static Field zzv(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzw(Object obj) {
        if (!zzH(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzx(Object obj, Object obj2, int i) {
        if (zzE(obj2, i)) {
            int iZzo = zzo(i);
            Unsafe unsafe = zzb;
            long j = iZzo & 1048575;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgi zzgiVarZzr = zzr(i);
            if (!zzE(obj, i)) {
                if (zzH(object)) {
                    Object objZzd = zzgiVarZzr.zzd();
                    zzgiVarZzr.zzf(objZzd, object);
                    unsafe.putObject(obj, j, objZzd);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzz(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzH(object2)) {
                Object objZzd2 = zzgiVarZzr.zzd();
                zzgiVarZzr.zzf(objZzd2, object2);
                unsafe.putObject(obj, j, objZzd2);
                object2 = objZzd2;
            }
            zzgiVarZzr.zzf(object2, object);
        }
    }

    private final void zzy(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzI(obj2, i2, i)) {
            int iZzo = zzo(i);
            Unsafe unsafe = zzb;
            long j = iZzo & 1048575;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgi zzgiVarZzr = zzr(i);
            if (!zzI(obj, i2, i)) {
                if (zzH(object)) {
                    Object objZzd = zzgiVarZzr.zzd();
                    zzgiVarZzr.zzf(objZzd, object);
                    unsafe.putObject(obj, j, objZzd);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzA(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzH(object2)) {
                Object objZzd2 = zzgiVarZzr.zzd();
                zzgiVarZzr.zzf(objZzd2, object2);
                unsafe.putObject(obj, j, objZzd2);
                object2 = objZzd2;
            }
            zzgiVarZzr.zzf(object2, object);
        }
    }

    private final void zzz(Object obj, int i) {
        int iZzl = zzl(i);
        long j = 1048575 & iZzl;
        if (j == 1048575) {
            return;
        }
        zzhj.zzn(obj, j, (1 << (iZzl >>> 20)) | zzhj.zzc(obj, j));
    }

    /* JADX WARN: Code duplicated, block: B:76:0x01c3  */
    @Override // com.google.android.gms.internal.auth.zzgi
    public final int zza(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzo = zzo(i3);
            int i4 = this.zzc[i3];
            long j = iZzo & 1048575;
            switch (zzn(iZzo)) {
                case 0:
                    i = i2 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhj.zza(obj, j));
                    byte[] bArr = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i2 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhj.zzb(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr2 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr3 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr4 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i2 * 53;
                    iFloatToIntBits = zzfa.zza(zzhj.zzt(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i2 * 53;
                    iFloatToIntBits = ((String) zzhj.zzf(obj, j)).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 9:
                    Object objZzf = zzhj.zzf(obj, j);
                    if (objZzf != null) {
                        iFloatToIntBits = objZzf.hashCode();
                    } else {
                        iFloatToIntBits = 37;
                    }
                    i = i2 * 53;
                    i2 = i + iFloatToIntBits;
                    break;
                case 10:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr5 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr6 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 17:
                    Object objZzf2 = zzhj.zzf(obj, j);
                    if (objZzf2 != null) {
                        iFloatToIntBits = objZzf2.hashCode();
                    } else {
                        iFloatToIntBits = 37;
                    }
                    i = i2 * 53;
                    i2 = i + iFloatToIntBits;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(((Double) zzhj.zzf(obj, j)).doubleValue());
                        byte[] bArr7 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = Float.floatToIntBits(((Float) zzhj.zzf(obj, j)).floatValue());
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr8 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr9 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr10 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzfa.zza(((Boolean) zzhj.zzf(obj, j)).booleanValue());
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = ((String) zzhj.zzf(obj, j)).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr11 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr12 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        return (i2 * 53) + this.zzl.zzb(obj).hashCode();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0240  */
    /* JADX WARN: Code duplicated, block: B:102:0x0244  */
    /* JADX WARN: Code duplicated, block: B:104:0x0248  */
    /* JADX WARN: Code duplicated, block: B:107:0x025c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0260  */
    /* JADX WARN: Code duplicated, block: B:117:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:119:0x02b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:121:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:130:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:131:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:166:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:169:0x03da  */
    /* JADX WARN: Code duplicated, block: B:177:0x0436  */
    /* JADX WARN: Code duplicated, block: B:180:0x0441  */
    /* JADX WARN: Code duplicated, block: B:182:0x044c  */
    /* JADX WARN: Code duplicated, block: B:185:0x0452  */
    /* JADX WARN: Code duplicated, block: B:187:0x045d  */
    /* JADX WARN: Code duplicated, block: B:188:0x047b  */
    /* JADX WARN: Code duplicated, block: B:190:0x047e  */
    /* JADX WARN: Code duplicated, block: B:192:0x0489 A[LOOP:3: B:191:0x0487->B:192:0x0489, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:197:0x04a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:198:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:200:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:202:0x04bb A[LOOP:4: B:199:0x04b1->B:202:0x04bb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:203:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:205:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:207:0x04d7 A[LOOP:5: B:206:0x04d5->B:207:0x04d7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:212:0x04ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:213:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:215:0x0500  */
    /* JADX WARN: Code duplicated, block: B:217:0x0508 A[LOOP:6: B:214:0x04fe->B:217:0x0508, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:220:0x0527  */
    /* JADX WARN: Code duplicated, block: B:222:0x052a  */
    /* JADX WARN: Code duplicated, block: B:223:0x0533 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:224:0x0535  */
    /* JADX WARN: Code duplicated, block: B:227:0x0552 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:228:0x0554  */
    /* JADX WARN: Code duplicated, block: B:230:0x0561  */
    /* JADX WARN: Code duplicated, block: B:232:0x0575 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:233:0x0577  */
    /* JADX WARN: Code duplicated, block: B:235:0x057d  */
    /* JADX WARN: Code duplicated, block: B:239:0x058c  */
    /* JADX WARN: Code duplicated, block: B:240:0x0594  */
    /* JADX WARN: Code duplicated, block: B:243:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:246:0x05bc  */
    /* JADX WARN: Code duplicated, block: B:249:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:251:0x05dd  */
    /* JADX WARN: Code duplicated, block: B:253:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:255:0x05e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:256:0x05eb  */
    /* JADX WARN: Code duplicated, block: B:257:0x05f8  */
    /* JADX WARN: Code duplicated, block: B:260:0x0609  */
    /* JADX WARN: Code duplicated, block: B:262:0x0611  */
    /* JADX WARN: Code duplicated, block: B:264:0x0619  */
    /* JADX WARN: Code duplicated, block: B:266:0x061d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x006b  */
    /* JADX WARN: Code duplicated, block: B:278:0x0647  */
    /* JADX WARN: Code duplicated, block: B:279:0x0655  */
    /* JADX WARN: Code duplicated, block: B:281:0x065e  */
    /* JADX WARN: Code duplicated, block: B:284:0x0693  */
    /* JADX WARN: Code duplicated, block: B:286:0x069f  */
    /* JADX WARN: Code duplicated, block: B:288:0x06a8  */
    /* JADX WARN: Code duplicated, block: B:290:0x06b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:291:0x06b2  */
    /* JADX WARN: Code duplicated, block: B:292:0x06b9  */
    /* JADX WARN: Code duplicated, block: B:295:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:297:0x06d1  */
    /* JADX WARN: Code duplicated, block: B:299:0x06d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:306:0x06f4  */
    /* JADX WARN: Code duplicated, block: B:308:0x06fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:309:0x0700  */
    /* JADX WARN: Code duplicated, block: B:30:0x009d  */
    /* JADX WARN: Code duplicated, block: B:310:0x0704  */
    /* JADX WARN: Code duplicated, block: B:312:0x070c  */
    /* JADX WARN: Code duplicated, block: B:315:0x0719  */
    /* JADX WARN: Code duplicated, block: B:317:0x0721  */
    /* JADX WARN: Code duplicated, block: B:319:0x0729 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:323:0x0737  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:333:0x0759  */
    /* JADX WARN: Code duplicated, block: B:335:0x0765  */
    /* JADX WARN: Code duplicated, block: B:337:0x0771  */
    /* JADX WARN: Code duplicated, block: B:339:0x077b  */
    /* JADX WARN: Code duplicated, block: B:340:0x077d  */
    /* JADX WARN: Code duplicated, block: B:346:0x078c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:347:0x078e  */
    /* JADX WARN: Code duplicated, block: B:349:0x079b  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:350:0x079d  */
    /* JADX WARN: Code duplicated, block: B:353:0x07a5  */
    /* JADX WARN: Code duplicated, block: B:355:0x07ad  */
    /* JADX WARN: Code duplicated, block: B:357:0x07b7  */
    /* JADX WARN: Code duplicated, block: B:358:0x07b9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:360:0x07bf  */
    /* JADX WARN: Code duplicated, block: B:362:0x07cb  */
    /* JADX WARN: Code duplicated, block: B:364:0x07d7 A[LOOP:14: B:363:0x07d5->B:364:0x07d7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:369:0x07e9  */
    /* JADX WARN: Code duplicated, block: B:371:0x07ec  */
    /* JADX WARN: Code duplicated, block: B:373:0x07fa  */
    /* JADX WARN: Code duplicated, block: B:375:0x0802 A[LOOP:15: B:372:0x07f8->B:375:0x0802, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:376:0x080c  */
    /* JADX WARN: Code duplicated, block: B:378:0x0818  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:380:0x0824 A[LOOP:16: B:379:0x0822->B:380:0x0824, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:385:0x0837  */
    /* JADX WARN: Code duplicated, block: B:387:0x083a  */
    /* JADX WARN: Code duplicated, block: B:389:0x0848  */
    /* JADX WARN: Code duplicated, block: B:391:0x0850 A[LOOP:17: B:388:0x0846->B:391:0x0850, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:393:0x0863  */
    /* JADX WARN: Code duplicated, block: B:395:0x086f  */
    /* JADX WARN: Code duplicated, block: B:397:0x0883 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:398:0x0885  */
    /* JADX WARN: Code duplicated, block: B:400:0x089b  */
    /* JADX WARN: Code duplicated, block: B:402:0x08a6  */
    /* JADX WARN: Code duplicated, block: B:404:0x08b2 A[LOOP:18: B:403:0x08b0->B:404:0x08b2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:409:0x08c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:410:0x08c7  */
    /* JADX WARN: Code duplicated, block: B:412:0x08d5  */
    /* JADX WARN: Code duplicated, block: B:414:0x08dd A[LOOP:19: B:411:0x08d3->B:414:0x08dd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:415:0x08e7  */
    /* JADX WARN: Code duplicated, block: B:417:0x08f2  */
    /* JADX WARN: Code duplicated, block: B:419:0x08fe A[LOOP:20: B:418:0x08fc->B:419:0x08fe, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:424:0x0915  */
    /* JADX WARN: Code duplicated, block: B:426:0x0918  */
    /* JADX WARN: Code duplicated, block: B:428:0x092a  */
    /* JADX WARN: Code duplicated, block: B:430:0x0932 A[LOOP:21: B:427:0x0928->B:430:0x0932, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:431:0x0940  */
    /* JADX WARN: Code duplicated, block: B:433:0x094b  */
    /* JADX WARN: Code duplicated, block: B:435:0x0957 A[LOOP:22: B:434:0x0955->B:435:0x0957, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:440:0x096d  */
    /* JADX WARN: Code duplicated, block: B:442:0x0970  */
    /* JADX WARN: Code duplicated, block: B:444:0x0982  */
    /* JADX WARN: Code duplicated, block: B:446:0x098a A[LOOP:23: B:443:0x0980->B:446:0x098a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:449:0x099d  */
    /* JADX WARN: Code duplicated, block: B:451:0x09a5 A[LOOP:2: B:448:0x099b->B:451:0x09a5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:452:0x09b9 A[PHI: r0 r7 r8 r9 r10 r11 r12 r13
  0x09b9: PHI (r0v30 'this' com.google.android.gms.internal.auth.zzga<T>) = 
  (r0v1 'this' com.google.android.gms.internal.auth.zzga<T>)
  (r0v1 'this' com.google.android.gms.internal.auth.zzga<T>)
  (r0v1 'this' com.google.android.gms.internal.auth.zzga<T>)
  (r0v9 'this' com.google.android.gms.internal.auth.zzga<T>)
  (r0v28 'this' com.google.android.gms.internal.auth.zzga<T>)
  (r0v1 'this' com.google.android.gms.internal.auth.zzga<T>)
 binds: [B:441:0x096e, B:425:0x0916, B:409:0x08c5, B:278:0x0647, B:283:0x068d, B:186:0x045b] A[DONT_GENERATE, DONT_INLINE]
  0x09b9: PHI (r7v50 int) = (r7v32 int), (r7v33 int), (r7v35 int), (r7v46 int), (r7v47 int), (r7v53 int) binds: [B:441:0x096e, B:425:0x0916, B:409:0x08c5, B:278:0x0647, B:283:0x068d, B:186:0x045b] A[DONT_GENERATE, DONT_INLINE]
  0x09b9: PHI (r8v138 sun.misc.Unsafe) = 
  (r8v82 sun.misc.Unsafe)
  (r8v83 sun.misc.Unsafe)
  (r8v85 sun.misc.Unsafe)
  (r8v126 sun.misc.Unsafe)
  (r8v133 sun.misc.Unsafe)
  (r8v143 sun.misc.Unsafe)
 binds: [B:441:0x096e, B:425:0x0916, B:409:0x08c5, B:278:0x0647, B:283:0x068d, B:186:0x045b] A[DONT_GENERATE, DONT_INLINE]
  0x09b9: PHI (r9v112 com.google.android.gms.internal.auth.zzdt) = 
  (r9v68 com.google.android.gms.internal.auth.zzdt)
  (r9v69 com.google.android.gms.internal.auth.zzdt)
  (r9v71 com.google.android.gms.internal.auth.zzdt)
  (r9v102 com.google.android.gms.internal.auth.zzdt)
  (r9v108 com.google.android.gms.internal.auth.zzdt)
  (r9v118 com.google.android.gms.internal.auth.zzdt)
 binds: [B:441:0x096e, B:425:0x0916, B:409:0x08c5, B:278:0x0647, B:283:0x068d, B:186:0x045b] A[DONT_GENERATE, DONT_INLINE]
  0x09b9: PHI (r10v32 int) = (r10v14 int), (r10v14 int), (r10v14 int), (r10v14 int), (r10v31 int), (r10v14 int) binds: [B:441:0x096e, B:425:0x0916, B:409:0x08c5, B:278:0x0647, B:283:0x068d, B:186:0x045b] A[DONT_GENERATE, DONT_INLINE]
  0x09b9: PHI (r11v42 int) = (r11v15 int), (r11v16 int), (r11v18 int), (r11v31 int), (r11v38 int), (r11v48 int) binds: [B:441:0x096e, B:425:0x0916, B:409:0x08c5, B:278:0x0647, B:283:0x068d, B:186:0x045b] A[DONT_GENERATE, DONT_INLINE]
  0x09b9: PHI (r12v41 int) = (r12v11 int), (r12v12 int), (r12v14 int), (r12v34 int), (r12v37 int), (r12v44 int) binds: [B:441:0x096e, B:425:0x0916, B:409:0x08c5, B:278:0x0647, B:283:0x068d, B:186:0x045b] A[DONT_GENERATE, DONT_INLINE]
  0x09b9: PHI (r13v63 int) = (r13v42 int), (r13v42 int), (r13v42 int), (r13v42 int), (r13v61 int), (r13v42 int) binds: [B:441:0x096e, B:425:0x0916, B:409:0x08c5, B:278:0x0647, B:283:0x068d, B:186:0x045b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:464:0x0a05  */
    /* JADX WARN: Code duplicated, block: B:467:0x0a16  */
    /* JADX WARN: Code duplicated, block: B:468:0x0a24  */
    /* JADX WARN: Code duplicated, block: B:471:0x0a3b  */
    /* JADX WARN: Code duplicated, block: B:473:0x0a3e  */
    /* JADX WARN: Code duplicated, block: B:474:0x0a6b A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:475:0x0a7a  */
    /* JADX WARN: Code duplicated, block: B:477:0x0a84  */
    /* JADX WARN: Code duplicated, block: B:478:0x0a9b  */
    /* JADX WARN: Code duplicated, block: B:480:0x0aa7  */
    /* JADX WARN: Code duplicated, block: B:483:0x0ac9  */
    /* JADX WARN: Code duplicated, block: B:485:0x0ad5  */
    /* JADX WARN: Code duplicated, block: B:491:0x0af5  */
    /* JADX WARN: Code duplicated, block: B:493:0x0b0d  */
    /* JADX WARN: Code duplicated, block: B:495:0x0b1a  */
    /* JADX WARN: Code duplicated, block: B:496:0x0b27  */
    /* JADX WARN: Code duplicated, block: B:498:0x0b2e  */
    /* JADX WARN: Code duplicated, block: B:499:0x0b59 A[PHI: r4 r6 r7
  0x0b59: PHI (r4v41 int) = (r4v38 int), (r4v43 int) binds: [B:497:0x0b2c, B:494:0x0b18] A[DONT_GENERATE, DONT_INLINE]
  0x0b59: PHI (r6v62 int) = (r6v59 int), (r6v64 int) binds: [B:497:0x0b2c, B:494:0x0b18] A[DONT_GENERATE, DONT_INLINE]
  0x0b59: PHI (r7v21 java.lang.Object) = (r7v20 java.lang.Object), (r7v22 java.lang.Object) binds: [B:497:0x0b2c, B:494:0x0b18] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:500:0x0b6d  */
    /* JADX WARN: Code duplicated, block: B:502:0x0b80  */
    /* JADX WARN: Code duplicated, block: B:504:0x0b88  */
    /* JADX WARN: Code duplicated, block: B:505:0x0b8c  */
    /* JADX WARN: Code duplicated, block: B:514:0x0bae  */
    /* JADX WARN: Code duplicated, block: B:516:0x0bc0  */
    /* JADX WARN: Code duplicated, block: B:518:0x0bca  */
    /* JADX WARN: Code duplicated, block: B:519:0x0bcc  */
    /* JADX WARN: Code duplicated, block: B:521:0x0bda  */
    /* JADX WARN: Code duplicated, block: B:523:0x0bed  */
    /* JADX WARN: Code duplicated, block: B:524:0x0bff  */
    /* JADX WARN: Code duplicated, block: B:526:0x0c12  */
    /* JADX WARN: Code duplicated, block: B:527:0x0c24  */
    /* JADX WARN: Code duplicated, block: B:529:0x0c36  */
    /* JADX WARN: Code duplicated, block: B:530:0x0c48  */
    /* JADX WARN: Code duplicated, block: B:532:0x0c5a  */
    /* JADX WARN: Code duplicated, block: B:533:0x0c6b  */
    /* JADX WARN: Code duplicated, block: B:535:0x0c7e  */
    /* JADX WARN: Code duplicated, block: B:536:0x0c93  */
    /* JADX WARN: Code duplicated, block: B:538:0x0ca6  */
    /* JADX WARN: Code duplicated, block: B:540:0x0cbc A[PHI: r3 r4 r6 r7 r8 r20 r21 r27
  0x0cbc: PHI (r3v54 int) = 
  (r3v41 int)
  (r3v42 int)
  (r3v43 int)
  (r3v44 int)
  (r3v45 int)
  (r3v46 int)
  (r3v47 int)
  (r3v48 int)
  (r3v50 int)
  (r3v53 int)
  (r3v55 int)
 binds: [B:474:0x0a6b, B:537:0x0ca4, B:534:0x0c7c, B:531:0x0c58, B:528:0x0c34, B:525:0x0c10, B:522:0x0beb, B:515:0x0bbe, B:501:0x0b7e, B:499:0x0b59, B:492:0x0b00] A[DONT_GENERATE, DONT_INLINE]
  0x0cbc: PHI (r4v46 int) = 
  (r4v28 int)
  (r4v29 int)
  (r4v30 int)
  (r4v31 int)
  (r4v32 int)
  (r4v33 int)
  (r4v34 int)
  (r4v35 int)
  (r4v37 int)
  (r4v42 int)
  (r4v48 int)
 binds: [B:474:0x0a6b, B:537:0x0ca4, B:534:0x0c7c, B:531:0x0c58, B:528:0x0c34, B:525:0x0c10, B:522:0x0beb, B:515:0x0bbe, B:501:0x0b7e, B:499:0x0b59, B:492:0x0b00] A[DONT_GENERATE, DONT_INLINE]
  0x0cbc: PHI (r6v67 com.google.android.gms.internal.auth.zzdt) = 
  (r6v49 com.google.android.gms.internal.auth.zzdt)
  (r6v50 com.google.android.gms.internal.auth.zzdt)
  (r6v51 com.google.android.gms.internal.auth.zzdt)
  (r6v52 com.google.android.gms.internal.auth.zzdt)
  (r6v53 com.google.android.gms.internal.auth.zzdt)
  (r6v54 com.google.android.gms.internal.auth.zzdt)
  (r6v55 com.google.android.gms.internal.auth.zzdt)
  (r6v56 com.google.android.gms.internal.auth.zzdt)
  (r6v58 com.google.android.gms.internal.auth.zzdt)
  (r6v63 com.google.android.gms.internal.auth.zzdt)
  (r6v69 com.google.android.gms.internal.auth.zzdt)
 binds: [B:474:0x0a6b, B:537:0x0ca4, B:534:0x0c7c, B:531:0x0c58, B:528:0x0c34, B:525:0x0c10, B:522:0x0beb, B:515:0x0bbe, B:501:0x0b7e, B:499:0x0b59, B:492:0x0b00] A[DONT_GENERATE, DONT_INLINE]
  0x0cbc: PHI (r7v25 java.lang.Object) = 
  (r7v10 java.lang.Object)
  (r7v11 java.lang.Object)
  (r7v12 java.lang.Object)
  (r7v13 java.lang.Object)
  (r7v14 java.lang.Object)
  (r7v15 java.lang.Object)
  (r7v16 java.lang.Object)
  (r7v17 java.lang.Object)
  (r7v19 java.lang.Object)
  (r7v21 java.lang.Object)
  (r7v26 java.lang.Object)
 binds: [B:474:0x0a6b, B:537:0x0ca4, B:534:0x0c7c, B:531:0x0c58, B:528:0x0c34, B:525:0x0c10, B:522:0x0beb, B:515:0x0bbe, B:501:0x0b7e, B:499:0x0b59, B:492:0x0b00] A[DONT_GENERATE, DONT_INLINE]
  0x0cbc: PHI (r8v70 int) = 
  (r8v48 int)
  (r8v49 int)
  (r8v50 int)
  (r8v51 int)
  (r8v52 int)
  (r8v53 int)
  (r8v54 int)
  (r8v55 int)
  (r8v57 int)
  (r8v61 int)
  (r8v71 int)
 binds: [B:474:0x0a6b, B:537:0x0ca4, B:534:0x0c7c, B:531:0x0c58, B:528:0x0c34, B:525:0x0c10, B:522:0x0beb, B:515:0x0bbe, B:501:0x0b7e, B:499:0x0b59, B:492:0x0b00] A[DONT_GENERATE, DONT_INLINE]
  0x0cbc: PHI (r20v18 int) = 
  (r20v6 int)
  (r20v7 int)
  (r20v8 int)
  (r20v9 int)
  (r20v10 int)
  (r20v11 int)
  (r20v12 int)
  (r20v13 int)
  (r20v15 int)
  (r20v17 int)
  (r20v19 int)
 binds: [B:474:0x0a6b, B:537:0x0ca4, B:534:0x0c7c, B:531:0x0c58, B:528:0x0c34, B:525:0x0c10, B:522:0x0beb, B:515:0x0bbe, B:501:0x0b7e, B:499:0x0b59, B:492:0x0b00] A[DONT_GENERATE, DONT_INLINE]
  0x0cbc: PHI (r21v22 sun.misc.Unsafe) = 
  (r21v10 sun.misc.Unsafe)
  (r21v11 sun.misc.Unsafe)
  (r21v12 sun.misc.Unsafe)
  (r21v13 sun.misc.Unsafe)
  (r21v14 sun.misc.Unsafe)
  (r21v15 sun.misc.Unsafe)
  (r21v16 sun.misc.Unsafe)
  (r21v17 sun.misc.Unsafe)
  (r21v19 sun.misc.Unsafe)
  (r21v21 sun.misc.Unsafe)
  (r21v23 sun.misc.Unsafe)
 binds: [B:474:0x0a6b, B:537:0x0ca4, B:534:0x0c7c, B:531:0x0c58, B:528:0x0c34, B:525:0x0c10, B:522:0x0beb, B:515:0x0bbe, B:501:0x0b7e, B:499:0x0b59, B:492:0x0b00] A[DONT_GENERATE, DONT_INLINE]
  0x0cbc: PHI (r27v16 int) = 
  (r27v4 int)
  (r27v5 int)
  (r27v6 int)
  (r27v7 int)
  (r27v8 int)
  (r27v9 int)
  (r27v10 int)
  (r27v11 int)
  (r27v13 int)
  (r27v15 int)
  (r27v17 int)
 binds: [B:474:0x0a6b, B:537:0x0ca4, B:534:0x0c7c, B:531:0x0c58, B:528:0x0c34, B:525:0x0c10, B:522:0x0beb, B:515:0x0bbe, B:501:0x0b7e, B:499:0x0b59, B:492:0x0b00] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:579:0x00c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:580:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:581:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:582:0x0145 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:583:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:584:0x019f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:585:0x01c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:586:0x02da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:587:0x02f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:588:0x030f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:589:0x032a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:590:0x033d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:591:0x0363 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:0x037b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:0x03c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:0x049b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:0x04e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:596:0x0642 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x063d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x0632 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x062d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:600:0x06ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:0x06ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:0x0751 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:0x074c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x0747 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x0742 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:0x0787 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x07e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x0832 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x08c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x0910 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x0968 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x09c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x09f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x0cbf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x0cd2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x00fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:0x013d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x017a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:0x01be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x02d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x02ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x0305 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x0321 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x0334 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x0359 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:0x0371 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x038c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:0x03c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x0420 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x09ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x03a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x011c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:0x01bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:641:0x01bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:642:0x01bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:0x02cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:0x02a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:0x0288 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:0x023b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:0x0257 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:0x0279 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x02ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:0x0300 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x0300 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x031e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x038c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x038c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:0x038c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x038c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x008d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x09e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:0x09ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:0x0418 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x040c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:0x0897 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:676:0x0516 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:679:0x0516 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:684:0x05b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:686:0x059e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:689:0x0637 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:690:0x0625 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:691:0x061f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:697:0x085a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:698:0x06df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:699:0x06db A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:705:0x085a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:706:0x072f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:707:0x072b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:716:0x0873 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:721:0x085a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:724:0x085a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:727:0x0998 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:730:0x0998 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:733:0x0998 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:735:0x01ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:737:0x0227 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:738:0x020b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:744:0x0223 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x01d4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:77:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:83:0x01f7 A[LOOP:24: B:80:0x01ed->B:83:0x01f7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:85:0x0201  */
    /* JADX WARN: Code duplicated, block: B:89:0x0213  */
    /* JADX WARN: Code duplicated, block: B:91:0x021b A[LOOP:26: B:88:0x0211->B:91:0x021b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:95:0x022b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x022d  */
    final int zzb(Object obj, byte[] bArr, int i, int i2, int i3, zzdt zzdtVar) throws IOException {
        Unsafe unsafe;
        int i4;
        int i5;
        int iZzi;
        int i6;
        int i7;
        int iZzm;
        int i8;
        int i9;
        int i10;
        int i11;
        Unsafe unsafe2;
        int i12;
        int[] iArr;
        int i13;
        int i14;
        int iZzn;
        long j;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        zzdt zzdtVar2;
        int i20;
        int i21;
        int i22;
        int i23;
        boolean z;
        int i24;
        int i25;
        int length;
        int i26;
        char[] cArr;
        int i27;
        int i28;
        byte b;
        byte b2;
        byte b3;
        int i29;
        int i30;
        int i31;
        int i32;
        zzdt zzdtVar3;
        int i33;
        int i34;
        int i35;
        Unsafe unsafe3;
        int i36;
        int i37;
        Unsafe unsafe4;
        Unsafe unsafe5;
        Object object;
        Unsafe unsafe6;
        long j2;
        int i38;
        int iZzk;
        boolean z2;
        int i39;
        int i40;
        int i41;
        int iZza;
        int i42;
        zzey zzeyVarZzq;
        long j3;
        Unsafe unsafe7;
        zzez zzezVarZzd;
        zzez zzezVar;
        int i43;
        zzdt zzdtVar4;
        int i44;
        int i45;
        zzek zzekVar;
        int iZzh;
        int iZzh2;
        zzek zzekVar2;
        int i46;
        zzer zzerVar;
        int iZzh3;
        zzer zzerVar2;
        int i47;
        zzfm zzfmVar;
        int iZzh4;
        zzfm zzfmVar2;
        int i48;
        int i49;
        zzdt zzdtVar5;
        int i50;
        Unsafe unsafe8;
        int i51;
        int iZzf;
        zzfm zzfmVar3;
        int iZzh5;
        int iZzh6;
        zzfm zzfmVar4;
        int iZzh7;
        int i52;
        zzew zzewVar;
        int iZzh8;
        zzew zzewVar2;
        int i53;
        zzdv zzdvVar;
        boolean z3;
        int iZzh9;
        boolean z4;
        zzdv zzdvVar2;
        int i54;
        boolean z5;
        int i55;
        int i56;
        int iZzh10;
        int i57;
        int i58;
        int i59;
        Object obj2;
        int iZzh11;
        int i60;
        int i61;
        zzdt zzdtVar6;
        int i62;
        int i63;
        int iZzh12;
        int i64;
        int iZzh13;
        int i65;
        int iZzj;
        zzey zzeyVarZzq2;
        zzgz zzgzVar;
        int i66;
        int i67;
        Iterator it2;
        Object objZzc;
        int iIntValue;
        int size;
        Object objZzc2;
        int i68;
        int i69;
        Integer num;
        int iIntValue2;
        zzew zzewVar3;
        int iZzh14;
        zzew zzewVar4;
        int i70;
        zzfm zzfmVar5;
        int iZzh15;
        zzfm zzfmVar6;
        int i71;
        zzgi zzgiVarZzr;
        int i72;
        int iZzh16;
        zzez zzezVarZzd2;
        this = this;
        Object obj3 = obj;
        int i73 = i2;
        i3 = i3;
        zzdt zzdtVar7 = zzdtVar;
        zzw(obj);
        Unsafe unsafe9 = zzb;
        int i74 = 0;
        int iZzg = i;
        int i75 = 0;
        int i76 = 0;
        int i77 = 0;
        int i78 = -1;
        int i79 = 1048575;
        while (true) {
            if (iZzg < i73) {
                int i80 = iZzg + 1;
                int i81 = bArr[iZzg];
                if (i81 < 0) {
                    iZzi = zzdu.zzi(i81, bArr, i80, zzdtVar7);
                    i5 = zzdtVar7.zza;
                } else {
                    i5 = i81;
                    iZzi = i80;
                }
                int i82 = i5 >>> 3;
                if (i82 > i78) {
                    iZzm = (i82 < this.zze || i82 > this.zzf) ? -1 : this.zzm(i82, i75 / 3);
                } else {
                    if (i82 < this.zze || i82 > this.zzf) {
                        i6 = -1;
                        i7 = -1;
                    } else {
                        iZzm = this.zzm(i82, i74);
                    }
                    if (i7 == i6) {
                        i8 = iZzi;
                        i9 = i5;
                        i77 = i77;
                        i79 = i79;
                        i10 = i82;
                        i11 = i74;
                        unsafe2 = unsafe9;
                        i4 = i3;
                        i2 = i73;
                    } else {
                        i12 = i5 & 7;
                        iArr = this.zzc;
                        i13 = iArr[i7 + 1];
                        i14 = i5;
                        iZzn = zzn(i13);
                        j = i13 & 1048575;
                        i78 = i82;
                        if (iZzn <= 17) {
                            int i83 = iArr[i7 + 2];
                            i15 = 1 << (i83 >>> 20);
                            i16 = i83 & 1048575;
                            if (i16 != i79) {
                                if (i79 != 1048575) {
                                    unsafe9.putInt(obj3, i79, i77);
                                }
                                if (i16 == 1048575) {
                                    i32 = 0;
                                } else {
                                    i32 = unsafe9.getInt(obj3, i16);
                                }
                                i77 = i32;
                                i79 = i16;
                            } else {
                                i77 = i77;
                                i79 = i79;
                            }
                            switch (iZzn) {
                                case 0:
                                    i17 = iZzi;
                                    i18 = i7;
                                    i19 = i14;
                                    i74 = 0;
                                    if (i12 == 1) {
                                        zzhj.zzl(obj3, j, Double.longBitsToDouble(zzdu.zzn(bArr, i17)));
                                        iZzg = i17 + 8;
                                        i77 |= i15;
                                        i76 = i19;
                                        i75 = i18;
                                        i73 = i2;
                                    } else {
                                        int i84 = i19;
                                        i11 = i74;
                                        Unsafe unsafe10 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe10;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i84;
                                    }
                                    break;
                                case 1:
                                    i17 = iZzi;
                                    i18 = i7;
                                    i19 = i14;
                                    i74 = 0;
                                    if (i12 == 5) {
                                        zzhj.zzm(obj3, j, Float.intBitsToFloat(zzdu.zzb(bArr, i17)));
                                        iZzg = i17 + 4;
                                        i77 |= i15;
                                        i76 = i19;
                                        i75 = i18;
                                        i73 = i2;
                                    } else {
                                        int i85 = i19;
                                        i11 = i74;
                                        Unsafe unsafe11 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe11;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i85;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    i17 = iZzi;
                                    i18 = i7;
                                    i19 = i14;
                                    i74 = 0;
                                    if (i12 == 0) {
                                        int iZzk2 = zzdu.zzk(bArr, i17, zzdtVar7);
                                        unsafe9.putLong(obj, j, zzdtVar7.zzb);
                                        i77 |= i15;
                                        iZzg = iZzk2;
                                        i76 = i19;
                                        i75 = i18;
                                        i73 = i2;
                                    } else {
                                        int i86 = i19;
                                        i11 = i74;
                                        Unsafe unsafe12 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe12;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i86;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    i17 = iZzi;
                                    i18 = i7;
                                    i19 = i14;
                                    i74 = 0;
                                    if (i12 == 0) {
                                        iZzg = zzdu.zzh(bArr, i17, zzdtVar7);
                                        unsafe9.putInt(obj3, j, zzdtVar7.zza);
                                        i77 |= i15;
                                        i76 = i19;
                                        i75 = i18;
                                        i73 = i2;
                                    } else {
                                        int i87 = i19;
                                        i11 = i74;
                                        Unsafe unsafe13 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe13;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i87;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    i22 = iZzi;
                                    i18 = i7;
                                    i19 = i14;
                                    i74 = 0;
                                    if (i12 == 1) {
                                        i17 = i22;
                                        unsafe9.putLong(obj, j, zzdu.zzn(bArr, i22));
                                        iZzg = i17 + 8;
                                        i77 |= i15;
                                        i76 = i19;
                                        i75 = i18;
                                        i73 = i2;
                                    } else {
                                        i17 = i22;
                                        int i88 = i19;
                                        i11 = i74;
                                        Unsafe unsafe14 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe14;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i88;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    i23 = iZzi;
                                    i18 = i7;
                                    i19 = i14;
                                    i74 = 0;
                                    if (i12 == 5) {
                                        unsafe9.putInt(obj3, j, zzdu.zzb(bArr, i23));
                                        i17 = i23;
                                        iZzg = i17 + 4;
                                        i77 |= i15;
                                        i76 = i19;
                                        i75 = i18;
                                        i73 = i2;
                                    } else {
                                        i17 = i23;
                                        int i89 = i19;
                                        i11 = i74;
                                        Unsafe unsafe15 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe15;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i89;
                                    }
                                    break;
                                case 7:
                                    i23 = iZzi;
                                    i18 = i7;
                                    i19 = i14;
                                    i74 = 0;
                                    if (i12 == 0) {
                                        iZzg = zzdu.zzk(bArr, i23, zzdtVar7);
                                        if (zzdtVar7.zzb != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        zzhj.zzk(obj3, j, z);
                                        i77 |= i15;
                                        i76 = i19;
                                        i75 = i18;
                                        i73 = i2;
                                    } else {
                                        i17 = i23;
                                        int i810 = i19;
                                        i11 = i74;
                                        Unsafe unsafe16 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe16;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i810;
                                    }
                                    break;
                                case 8:
                                    i23 = iZzi;
                                    i18 = i7;
                                    i19 = i14;
                                    if (i12 == 2) {
                                        if ((i13 & 536870912) != 0) {
                                            iZzg = zzdu.zzh(bArr, i23, zzdtVar7);
                                            i25 = zzdtVar7.zza;
                                            if (i25 >= 0) {
                                                throw zzfb.zzc();
                                            }
                                            if (i25 == 0) {
                                                zzdtVar7.zzc = "";
                                                i74 = 0;
                                            } else {
                                                int i90 = zzhn.zza;
                                                length = bArr.length;
                                                if ((((length - iZzg) - i25) | iZzg | i25) >= 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzg), Integer.valueOf(i25)));
                                                }
                                                i26 = iZzg + i25;
                                                cArr = new char[i25];
                                                i27 = 0;
                                                while (iZzg < i26) {
                                                    b3 = bArr[iZzg];
                                                    if (zzhk.zzd(b3)) {
                                                        iZzg++;
                                                        cArr[i27] = (char) b3;
                                                        i27++;
                                                    } else {
                                                        while (iZzg < i26) {
                                                            i28 = iZzg + 1;
                                                            b = bArr[iZzg];
                                                            if (zzhk.zzd(b)) {
                                                                cArr[i27] = (char) b;
                                                                i27++;
                                                                iZzg = i28;
                                                                while (iZzg < i26) {
                                                                    b2 = bArr[iZzg];
                                                                    if (zzhk.zzd(b2)) {
                                                                        iZzg++;
                                                                        cArr[i27] = (char) b2;
                                                                        i27++;
                                                                    }
                                                                }
                                                            } else if (b < -32) {
                                                                if (i28 < i26) {
                                                                    throw zzfb.zzb();
                                                                }
                                                                iZzg += 2;
                                                                zzhk.zzc(b, bArr[i28], cArr, i27);
                                                                i27++;
                                                            } else if (b < -16) {
                                                                if (i28 < i26 - 1) {
                                                                    throw zzfb.zzb();
                                                                }
                                                                zzhk.zzb(b, bArr[i28], bArr[iZzg + 2], cArr, i27);
                                                                i27++;
                                                                iZzg += 3;
                                                            } else {
                                                                if (i28 < i26 - 2) {
                                                                    throw zzfb.zzb();
                                                                }
                                                                zzhk.zza(b, bArr[i28], bArr[iZzg + 2], bArr[iZzg + 3], cArr, i27);
                                                                i27 += 2;
                                                                iZzg += 4;
                                                            }
                                                        }
                                                        i74 = 0;
                                                        zzdtVar7.zzc = new String(cArr, 0, i27);
                                                        iZzg = i26;
                                                    }
                                                }
                                                while (iZzg < i26) {
                                                    i28 = iZzg + 1;
                                                    b = bArr[iZzg];
                                                    if (zzhk.zzd(b)) {
                                                        cArr[i27] = (char) b;
                                                        i27++;
                                                        iZzg = i28;
                                                        while (iZzg < i26) {
                                                            b2 = bArr[iZzg];
                                                            if (zzhk.zzd(b2)) {
                                                                iZzg++;
                                                                cArr[i27] = (char) b2;
                                                                i27++;
                                                            }
                                                        }
                                                    } else if (b < -32) {
                                                        if (i28 < i26) {
                                                            throw zzfb.zzb();
                                                        }
                                                        iZzg += 2;
                                                        zzhk.zzc(b, bArr[i28], cArr, i27);
                                                        i27++;
                                                    } else if (b < -16) {
                                                        if (i28 < i26 - 1) {
                                                            throw zzfb.zzb();
                                                        }
                                                        zzhk.zzb(b, bArr[i28], bArr[iZzg + 2], cArr, i27);
                                                        i27++;
                                                        iZzg += 3;
                                                    } else {
                                                        if (i28 < i26 - 2) {
                                                            throw zzfb.zzb();
                                                        }
                                                        zzhk.zza(b, bArr[i28], bArr[iZzg + 2], bArr[iZzg + 3], cArr, i27);
                                                        i27 += 2;
                                                        iZzg += 4;
                                                    }
                                                }
                                                i74 = 0;
                                                zzdtVar7.zzc = new String(cArr, 0, i27);
                                                iZzg = i26;
                                            }
                                        } else {
                                            i74 = 0;
                                            iZzg = zzdu.zzh(bArr, i23, zzdtVar7);
                                            i24 = zzdtVar7.zza;
                                            if (i24 >= 0) {
                                                throw zzfb.zzc();
                                            }
                                            if (i24 == 0) {
                                                zzdtVar7.zzc = "";
                                            } else {
                                                zzdtVar7.zzc = new String(bArr, iZzg, i24, zzfa.zzb);
                                                iZzg += i24;
                                            }
                                        }
                                        unsafe9.putObject(obj3, j, zzdtVar7.zzc);
                                        i77 |= i15;
                                        i76 = i19;
                                        i75 = i18;
                                        i73 = i2;
                                    } else {
                                        i74 = 0;
                                        i17 = i23;
                                        int i811 = i19;
                                        i11 = i74;
                                        Unsafe unsafe17 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe17;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i811;
                                    }
                                    break;
                                case 9:
                                    i18 = i7;
                                    i19 = i14;
                                    if (i12 == 2) {
                                        Object objZzt = this.zzt(obj3, i18);
                                        iZzg = zzdu.zzm(objZzt, this.zzr(i18), bArr, iZzi, i2, zzdtVar);
                                        this.zzB(obj3, i18, objZzt);
                                        i77 |= i15;
                                        i74 = 0;
                                        i76 = i19;
                                        i75 = i18;
                                        i73 = i2;
                                    } else {
                                        i23 = iZzi;
                                        i74 = 0;
                                        i17 = i23;
                                        int i812 = i19;
                                        i11 = i74;
                                        Unsafe unsafe18 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe18;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i812;
                                    }
                                    break;
                                case 10:
                                    i18 = i7;
                                    i19 = i14;
                                    if (i12 == 2) {
                                        iZzg = zzdu.zza(bArr, iZzi, zzdtVar7);
                                        unsafe9.putObject(obj3, j, zzdtVar7.zzc);
                                        i30 = iZzg;
                                        i31 = i77 | i15;
                                        i77 = i31;
                                        iZzg = i30;
                                        i74 = 0;
                                        i76 = i19;
                                        i75 = i18;
                                        i73 = i2;
                                    } else {
                                        i23 = iZzi;
                                        i74 = 0;
                                        i17 = i23;
                                        int i813 = i19;
                                        i11 = i74;
                                        Unsafe unsafe19 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe19;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i813;
                                    }
                                    break;
                                case 12:
                                    i18 = i7;
                                    i19 = i14;
                                    if (i12 == 0) {
                                        iZzg = zzdu.zzh(bArr, iZzi, zzdtVar7);
                                        i29 = zzdtVar7.zza;
                                        zzey zzeyVarZzq3 = this.zzq(i18);
                                        if ((Integer.MIN_VALUE & i13) != 0 || zzeyVarZzq3 == null || zzeyVarZzq3.zza()) {
                                            unsafe9.putInt(obj3, j, i29);
                                            i30 = iZzg;
                                            i31 = i77 | i15;
                                            i77 = i31;
                                            iZzg = i30;
                                            i74 = 0;
                                            i76 = i19;
                                            i75 = i18;
                                        } else {
                                            zzc(obj).zzh(i19, Long.valueOf(i29));
                                            i76 = i19;
                                            i75 = i18;
                                            i77 = i77;
                                            i74 = 0;
                                        }
                                        i73 = i2;
                                    } else {
                                        i23 = iZzi;
                                        i74 = 0;
                                        i17 = i23;
                                        int i814 = i19;
                                        i11 = i74;
                                        Unsafe unsafe110 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe110;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i814;
                                    }
                                    break;
                                case 15:
                                    i18 = i7;
                                    if (i12 == 0) {
                                        iZzg = zzdu.zzh(bArr, iZzi, zzdtVar7);
                                        unsafe9.putInt(obj3, j, zzej.zzb(zzdtVar7.zza));
                                        i19 = i14;
                                        i30 = iZzg;
                                        i31 = i77 | i15;
                                        i77 = i31;
                                        iZzg = i30;
                                        i74 = 0;
                                        i76 = i19;
                                        i75 = i18;
                                        i73 = i2;
                                    } else {
                                        i23 = iZzi;
                                        i19 = i14;
                                        i74 = 0;
                                        i17 = i23;
                                        int i815 = i19;
                                        i11 = i74;
                                        Unsafe unsafe111 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe111;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i815;
                                    }
                                    break;
                                case 16:
                                    if (i12 == 0) {
                                        int iZzk3 = zzdu.zzk(bArr, iZzi, zzdtVar7);
                                        i18 = i7;
                                        unsafe9.putLong(obj, j, zzej.zzc(zzdtVar7.zzb));
                                        i31 = i77 | i15;
                                        i30 = iZzk3;
                                        i19 = i14;
                                        i77 = i31;
                                        iZzg = i30;
                                        i74 = 0;
                                        i76 = i19;
                                        i75 = i18;
                                        i73 = i2;
                                    } else {
                                        i18 = i7;
                                        i23 = iZzi;
                                        i19 = i14;
                                        i74 = 0;
                                        i17 = i23;
                                        int i816 = i19;
                                        i11 = i74;
                                        Unsafe unsafe112 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe112;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i816;
                                    }
                                    break;
                                default:
                                    i17 = iZzi;
                                    i18 = i7;
                                    i19 = i14;
                                    i74 = 0;
                                    if (i12 == 3) {
                                        Object objZzt2 = this.zzt(obj3, i18);
                                        i10 = i78;
                                        i11 = 0;
                                        zzdtVar2 = zzdtVar7;
                                        i20 = i19;
                                        int iZzl = zzdu.zzl(objZzt2, this.zzr(i18), bArr, i17, i2, (i78 << 3) | 4, zzdtVar);
                                        this.zzB(obj3, i18, objZzt2);
                                        int i91 = i77 | i15;
                                        unsafe2 = unsafe9;
                                        i21 = i18;
                                        i77 = i91;
                                        iZzg = iZzl;
                                        i2 = i2;
                                        i3 = i3;
                                        i78 = i10;
                                        zzdtVar7 = zzdtVar2;
                                        i73 = i2;
                                        i74 = i11;
                                        i76 = i20;
                                        unsafe9 = unsafe2;
                                        i79 = i79;
                                        i75 = i21;
                                    } else {
                                        int i817 = i19;
                                        i11 = i74;
                                        Unsafe unsafe113 = unsafe9;
                                        i10 = i78;
                                        i4 = i3;
                                        unsafe2 = unsafe113;
                                        i2 = i2;
                                        i74 = i18;
                                        i8 = i17;
                                        i9 = i817;
                                    }
                                    break;
                            }
                        } else {
                            i77 = i77;
                            i79 = i79;
                            zzdtVar3 = zzdtVar7;
                            i33 = i7;
                            i34 = i2;
                            i35 = iZzi;
                            unsafe3 = unsafe9;
                            i36 = i14;
                            i11 = 0;
                            if (iZzn == 27) {
                                i37 = i78;
                                unsafe4 = unsafe3;
                                if (iZzn <= 49) {
                                    j3 = i13;
                                    unsafe7 = zzb;
                                    zzezVarZzd = (zzez) unsafe7.getObject(obj3, j);
                                    if (zzezVarZzd.zzc()) {
                                        int size2 = zzezVarZzd.size();
                                        zzezVarZzd = zzezVarZzd.zzd(size2 != 0 ? size2 + size2 : 10);
                                        unsafe7.putObject(obj3, j, zzezVarZzd);
                                    }
                                    zzezVar = zzezVarZzd;
                                    switch (iZzn) {
                                        case 18:
                                        case 35:
                                            i43 = i34;
                                            zzdtVar4 = zzdtVar3;
                                            i44 = i36;
                                            unsafe4 = unsafe4;
                                            i45 = i33;
                                            if (i12 == 2) {
                                                if (i12 == 1) {
                                                    zzekVar = (zzek) zzezVar;
                                                    zzekVar.zze(Double.longBitsToDouble(zzdu.zzn(bArr, i35)));
                                                    iZzh = i35 + 8;
                                                    while (iZzh < i43) {
                                                        iZzh2 = zzdu.zzh(bArr, iZzh, zzdtVar4);
                                                        if (i44 == zzdtVar4.zza) {
                                                            zzekVar.zze(Double.longBitsToDouble(zzdu.zzn(bArr, iZzh2)));
                                                            iZzh = iZzh2 + 8;
                                                        }
                                                    }
                                                } else {
                                                    i76 = i44;
                                                    i75 = i45;
                                                    iZzg = i35;
                                                }
                                                i77 = i77;
                                                i79 = i79;
                                                obj3 = obj;
                                                if (iZzg != i35) {
                                                    i3 = i3;
                                                    zzdtVar7 = zzdtVar4;
                                                    i78 = i37;
                                                    i73 = i43;
                                                    i74 = 0;
                                                    unsafe9 = unsafe4;
                                                } else {
                                                    i77 = i77;
                                                    i79 = i79;
                                                    unsafe2 = unsafe4;
                                                    i2 = i43;
                                                    i4 = i3;
                                                    i74 = i75;
                                                    i8 = iZzg;
                                                    int i92 = i37;
                                                    i9 = i76;
                                                    i10 = i92;
                                                }
                                            } else {
                                                zzekVar2 = (zzek) zzezVar;
                                                iZzh = zzdu.zzh(bArr, i35, zzdtVar4);
                                                i46 = zzdtVar4.zza + iZzh;
                                                while (iZzh < i46) {
                                                    zzekVar2.zze(Double.longBitsToDouble(zzdu.zzn(bArr, iZzh)));
                                                    iZzh += 8;
                                                }
                                                if (iZzh != i46) {
                                                    throw zzfb.zzf();
                                                }
                                            }
                                            iZzg = iZzh;
                                            i76 = i44;
                                            i75 = i45;
                                            i77 = i77;
                                            i79 = i79;
                                            obj3 = obj;
                                            if (iZzg != i35) {
                                                i3 = i3;
                                                zzdtVar7 = zzdtVar4;
                                                i78 = i37;
                                                i73 = i43;
                                                i74 = 0;
                                                unsafe9 = unsafe4;
                                            } else {
                                                i77 = i77;
                                                i79 = i79;
                                                unsafe2 = unsafe4;
                                                i2 = i43;
                                                i4 = i3;
                                                i74 = i75;
                                                i8 = iZzg;
                                                int i93 = i37;
                                                i9 = i76;
                                                i10 = i93;
                                            }
                                            break;
                                        case 19:
                                        case 36:
                                            i43 = i34;
                                            zzdtVar4 = zzdtVar3;
                                            i44 = i36;
                                            unsafe4 = unsafe4;
                                            i45 = i33;
                                            if (i12 == 2) {
                                                if (i12 == 5) {
                                                    zzerVar = (zzer) zzezVar;
                                                    zzerVar.zze(Float.intBitsToFloat(zzdu.zzb(bArr, i35)));
                                                    iZzh = i35 + 4;
                                                    while (iZzh < i43) {
                                                        iZzh3 = zzdu.zzh(bArr, iZzh, zzdtVar4);
                                                        if (i44 == zzdtVar4.zza) {
                                                            zzerVar.zze(Float.intBitsToFloat(zzdu.zzb(bArr, iZzh3)));
                                                            iZzh = iZzh3 + 4;
                                                        }
                                                    }
                                                } else {
                                                    i76 = i44;
                                                    i75 = i45;
                                                    iZzg = i35;
                                                }
                                                i77 = i77;
                                                i79 = i79;
                                                obj3 = obj;
                                                if (iZzg != i35) {
                                                    i3 = i3;
                                                    zzdtVar7 = zzdtVar4;
                                                    i78 = i37;
                                                    i73 = i43;
                                                    i74 = 0;
                                                    unsafe9 = unsafe4;
                                                } else {
                                                    i77 = i77;
                                                    i79 = i79;
                                                    unsafe2 = unsafe4;
                                                    i2 = i43;
                                                    i4 = i3;
                                                    i74 = i75;
                                                    i8 = iZzg;
                                                    int i94 = i37;
                                                    i9 = i76;
                                                    i10 = i94;
                                                }
                                            } else {
                                                zzerVar2 = (zzer) zzezVar;
                                                iZzh = zzdu.zzh(bArr, i35, zzdtVar4);
                                                i47 = zzdtVar4.zza + iZzh;
                                                while (iZzh < i47) {
                                                    zzerVar2.zze(Float.intBitsToFloat(zzdu.zzb(bArr, iZzh)));
                                                    iZzh += 4;
                                                }
                                                if (iZzh != i47) {
                                                    throw zzfb.zzf();
                                                }
                                            }
                                            iZzg = iZzh;
                                            i76 = i44;
                                            i75 = i45;
                                            i77 = i77;
                                            i79 = i79;
                                            obj3 = obj;
                                            if (iZzg != i35) {
                                                i3 = i3;
                                                zzdtVar7 = zzdtVar4;
                                                i78 = i37;
                                                i73 = i43;
                                                i74 = 0;
                                                unsafe9 = unsafe4;
                                            } else {
                                                i77 = i77;
                                                i79 = i79;
                                                unsafe2 = unsafe4;
                                                i2 = i43;
                                                i4 = i3;
                                                i74 = i75;
                                                i8 = iZzg;
                                                int i95 = i37;
                                                i9 = i76;
                                                i10 = i95;
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            i43 = i34;
                                            zzdtVar4 = zzdtVar3;
                                            i44 = i36;
                                            unsafe4 = unsafe4;
                                            i45 = i33;
                                            if (i12 == 2) {
                                                if (i12 == 0) {
                                                    zzfmVar = (zzfm) zzezVar;
                                                    iZzh = zzdu.zzk(bArr, i35, zzdtVar4);
                                                    zzfmVar.zze(zzdtVar4.zzb);
                                                    while (iZzh < i43) {
                                                        iZzh4 = zzdu.zzh(bArr, iZzh, zzdtVar4);
                                                        if (i44 == zzdtVar4.zza) {
                                                            iZzh = zzdu.zzk(bArr, iZzh4, zzdtVar4);
                                                            zzfmVar.zze(zzdtVar4.zzb);
                                                        }
                                                    }
                                                } else {
                                                    i76 = i44;
                                                    i75 = i45;
                                                    iZzg = i35;
                                                }
                                                i77 = i77;
                                                i79 = i79;
                                                obj3 = obj;
                                                if (iZzg != i35) {
                                                    i3 = i3;
                                                    zzdtVar7 = zzdtVar4;
                                                    i78 = i37;
                                                    i73 = i43;
                                                    i74 = 0;
                                                    unsafe9 = unsafe4;
                                                } else {
                                                    i77 = i77;
                                                    i79 = i79;
                                                    unsafe2 = unsafe4;
                                                    i2 = i43;
                                                    i4 = i3;
                                                    i74 = i75;
                                                    i8 = iZzg;
                                                    int i96 = i37;
                                                    i9 = i76;
                                                    i10 = i96;
                                                }
                                            } else {
                                                zzfmVar2 = (zzfm) zzezVar;
                                                iZzh = zzdu.zzh(bArr, i35, zzdtVar4);
                                                i48 = zzdtVar4.zza + iZzh;
                                                while (iZzh < i48) {
                                                    iZzh = zzdu.zzk(bArr, iZzh, zzdtVar4);
                                                    zzfmVar2.zze(zzdtVar4.zzb);
                                                }
                                                if (iZzh != i48) {
                                                    throw zzfb.zzf();
                                                }
                                            }
                                            iZzg = iZzh;
                                            i76 = i44;
                                            i75 = i45;
                                            i77 = i77;
                                            i79 = i79;
                                            obj3 = obj;
                                            if (iZzg != i35) {
                                                i3 = i3;
                                                zzdtVar7 = zzdtVar4;
                                                i78 = i37;
                                                i73 = i43;
                                                i74 = 0;
                                                unsafe9 = unsafe4;
                                            } else {
                                                i77 = i77;
                                                i79 = i79;
                                                unsafe2 = unsafe4;
                                                i2 = i43;
                                                i4 = i3;
                                                i74 = i75;
                                                i8 = iZzg;
                                                int i97 = i37;
                                                i9 = i76;
                                                i10 = i97;
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            i49 = i34;
                                            zzdtVar5 = zzdtVar3;
                                            i50 = i37;
                                            i44 = i36;
                                            unsafe8 = unsafe4;
                                            i51 = i33;
                                            if (i12 == 2) {
                                                if (i12 == 0) {
                                                    unsafe4 = unsafe8;
                                                    zzdtVar4 = zzdtVar5;
                                                    i37 = i50;
                                                    i43 = i49;
                                                    i45 = i51;
                                                    iZzg = zzdu.zzj(i44, bArr, i35, i2, zzezVar, zzdtVar);
                                                    i76 = i44;
                                                    i75 = i45;
                                                    i77 = i77;
                                                    i79 = i79;
                                                    obj3 = obj;
                                                    if (iZzg != i35) {
                                                        i3 = i3;
                                                        zzdtVar7 = zzdtVar4;
                                                        i78 = i37;
                                                        i73 = i43;
                                                        i74 = 0;
                                                        unsafe9 = unsafe4;
                                                    } else {
                                                        i77 = i77;
                                                        i79 = i79;
                                                        unsafe2 = unsafe4;
                                                        i2 = i43;
                                                        i4 = i3;
                                                        i74 = i75;
                                                        i8 = iZzg;
                                                        int i98 = i37;
                                                        i9 = i76;
                                                        i10 = i98;
                                                    }
                                                }
                                                unsafe4 = unsafe8;
                                                zzdtVar4 = zzdtVar5;
                                                i37 = i50;
                                                i43 = i49;
                                                i45 = i51;
                                                i76 = i44;
                                                i75 = i45;
                                                iZzg = i35;
                                                i77 = i77;
                                                i79 = i79;
                                                obj3 = obj;
                                                if (iZzg != i35) {
                                                    i3 = i3;
                                                    zzdtVar7 = zzdtVar4;
                                                    i78 = i37;
                                                    i73 = i43;
                                                    i74 = 0;
                                                    unsafe9 = unsafe4;
                                                } else {
                                                    i77 = i77;
                                                    i79 = i79;
                                                    unsafe2 = unsafe4;
                                                    i2 = i43;
                                                    i4 = i3;
                                                    i74 = i75;
                                                    i8 = iZzg;
                                                    int i99 = i37;
                                                    i9 = i76;
                                                    i10 = i99;
                                                }
                                                break;
                                            } else {
                                                iZzf = zzdu.zzf(bArr, i35, zzezVar, zzdtVar5);
                                                zzdtVar4 = zzdtVar5;
                                                i37 = i50;
                                                i43 = i49;
                                                i75 = i51;
                                                i76 = i44;
                                                i77 = i77;
                                                i79 = i79;
                                                int i100 = iZzf;
                                                unsafe4 = unsafe8;
                                                iZzg = i100;
                                                obj3 = obj;
                                                if (iZzg != i35) {
                                                    i3 = i3;
                                                    zzdtVar7 = zzdtVar4;
                                                    i78 = i37;
                                                    i73 = i43;
                                                    i74 = 0;
                                                    unsafe9 = unsafe4;
                                                } else {
                                                    i77 = i77;
                                                    i79 = i79;
                                                    unsafe2 = unsafe4;
                                                    i2 = i43;
                                                    i4 = i3;
                                                    i74 = i75;
                                                    i8 = iZzg;
                                                    int i910 = i37;
                                                    i9 = i76;
                                                    i10 = i910;
                                                }
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            i49 = i34;
                                            zzdtVar5 = zzdtVar3;
                                            i50 = i37;
                                            i44 = i36;
                                            unsafe8 = unsafe4;
                                            i51 = i33;
                                            if (i12 == 2) {
                                                if (i12 == 1) {
                                                    zzfmVar3 = (zzfm) zzezVar;
                                                    zzfmVar3.zze(zzdu.zzn(bArr, i35));
                                                    iZzh5 = i35 + 8;
                                                    while (iZzh5 < i49) {
                                                        iZzh6 = zzdu.zzh(bArr, iZzh5, zzdtVar5);
                                                        if (i44 == zzdtVar5.zza) {
                                                            unsafe4 = unsafe8;
                                                            iZzg = iZzh5;
                                                            zzdtVar4 = zzdtVar5;
                                                            i37 = i50;
                                                            i43 = i49;
                                                            i75 = i51;
                                                            i76 = i44;
                                                            i77 = i77;
                                                            i79 = i79;
                                                            obj3 = obj;
                                                            if (iZzg != i35) {
                                                                i3 = i3;
                                                                zzdtVar7 = zzdtVar4;
                                                                i78 = i37;
                                                                i73 = i43;
                                                                i74 = 0;
                                                                unsafe9 = unsafe4;
                                                            } else {
                                                                i77 = i77;
                                                                i79 = i79;
                                                                unsafe2 = unsafe4;
                                                                i2 = i43;
                                                                i4 = i3;
                                                                i74 = i75;
                                                                i8 = iZzg;
                                                                int i911 = i37;
                                                                i9 = i76;
                                                                i10 = i911;
                                                            }
                                                        } else {
                                                            zzfmVar3.zze(zzdu.zzn(bArr, iZzh6));
                                                            iZzh5 = iZzh6 + 8;
                                                        }
                                                        break;
                                                    }
                                                    unsafe4 = unsafe8;
                                                    iZzg = iZzh5;
                                                    zzdtVar4 = zzdtVar5;
                                                    i37 = i50;
                                                    i43 = i49;
                                                    i75 = i51;
                                                    i76 = i44;
                                                    i77 = i77;
                                                    i79 = i79;
                                                    obj3 = obj;
                                                    if (iZzg != i35) {
                                                        i3 = i3;
                                                        zzdtVar7 = zzdtVar4;
                                                        i78 = i37;
                                                        i73 = i43;
                                                        i74 = 0;
                                                        unsafe9 = unsafe4;
                                                    } else {
                                                        i77 = i77;
                                                        i79 = i79;
                                                        unsafe2 = unsafe4;
                                                        i2 = i43;
                                                        i4 = i3;
                                                        i74 = i75;
                                                        i8 = iZzg;
                                                        int i912 = i37;
                                                        i9 = i76;
                                                        i10 = i912;
                                                    }
                                                }
                                                unsafe4 = unsafe8;
                                                zzdtVar4 = zzdtVar5;
                                                i37 = i50;
                                                i43 = i49;
                                                i45 = i51;
                                                i76 = i44;
                                                i75 = i45;
                                                iZzg = i35;
                                                i77 = i77;
                                                i79 = i79;
                                                obj3 = obj;
                                                if (iZzg != i35) {
                                                    i3 = i3;
                                                    zzdtVar7 = zzdtVar4;
                                                    i78 = i37;
                                                    i73 = i43;
                                                    i74 = 0;
                                                    unsafe9 = unsafe4;
                                                } else {
                                                    i77 = i77;
                                                    i79 = i79;
                                                    unsafe2 = unsafe4;
                                                    i2 = i43;
                                                    i4 = i3;
                                                    i74 = i75;
                                                    i8 = iZzg;
                                                    int i913 = i37;
                                                    i9 = i76;
                                                    i10 = i913;
                                                }
                                                break;
                                            } else {
                                                zzfmVar4 = (zzfm) zzezVar;
                                                iZzh7 = zzdu.zzh(bArr, i35, zzdtVar5);
                                                i52 = zzdtVar5.zza + iZzh7;
                                                while (iZzh7 < i52) {
                                                    zzfmVar4.zze(zzdu.zzn(bArr, iZzh7));
                                                    iZzh7 += 8;
                                                }
                                                if (iZzh7 != i52) {
                                                    throw zzfb.zzf();
                                                }
                                                iZzf = iZzh7;
                                                zzdtVar4 = zzdtVar5;
                                                i37 = i50;
                                                i43 = i49;
                                                i75 = i51;
                                                i76 = i44;
                                                i77 = i77;
                                                i79 = i79;
                                                int i101 = iZzf;
                                                unsafe4 = unsafe8;
                                                iZzg = i101;
                                                obj3 = obj;
                                                if (iZzg != i35) {
                                                    i3 = i3;
                                                    zzdtVar7 = zzdtVar4;
                                                    i78 = i37;
                                                    i73 = i43;
                                                    i74 = 0;
                                                    unsafe9 = unsafe4;
                                                } else {
                                                    i77 = i77;
                                                    i79 = i79;
                                                    unsafe2 = unsafe4;
                                                    i2 = i43;
                                                    i4 = i3;
                                                    i74 = i75;
                                                    i8 = iZzg;
                                                    int i914 = i37;
                                                    i9 = i76;
                                                    i10 = i914;
                                                }
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            i49 = i34;
                                            zzdtVar5 = zzdtVar3;
                                            i50 = i37;
                                            i44 = i36;
                                            unsafe8 = unsafe4;
                                            i51 = i33;
                                            if (i12 == 2) {
                                                if (i12 == 5) {
                                                    zzewVar = (zzew) zzezVar;
                                                    zzewVar.zze(zzdu.zzb(bArr, i35));
                                                    iZzh5 = i35 + 4;
                                                    while (iZzh5 < i49) {
                                                        iZzh8 = zzdu.zzh(bArr, iZzh5, zzdtVar5);
                                                        if (i44 == zzdtVar5.zza) {
                                                            unsafe4 = unsafe8;
                                                            iZzg = iZzh5;
                                                            zzdtVar4 = zzdtVar5;
                                                            i37 = i50;
                                                            i43 = i49;
                                                            i75 = i51;
                                                            i76 = i44;
                                                            i77 = i77;
                                                            i79 = i79;
                                                            obj3 = obj;
                                                            if (iZzg != i35) {
                                                                i3 = i3;
                                                                zzdtVar7 = zzdtVar4;
                                                                i78 = i37;
                                                                i73 = i43;
                                                                i74 = 0;
                                                                unsafe9 = unsafe4;
                                                            } else {
                                                                i77 = i77;
                                                                i79 = i79;
                                                                unsafe2 = unsafe4;
                                                                i2 = i43;
                                                                i4 = i3;
                                                                i74 = i75;
                                                                i8 = iZzg;
                                                                int i915 = i37;
                                                                i9 = i76;
                                                                i10 = i915;
                                                            }
                                                        } else {
                                                            zzewVar.zze(zzdu.zzb(bArr, iZzh8));
                                                            iZzh5 = iZzh8 + 4;
                                                        }
                                                        break;
                                                    }
                                                    unsafe4 = unsafe8;
                                                    iZzg = iZzh5;
                                                    zzdtVar4 = zzdtVar5;
                                                    i37 = i50;
                                                    i43 = i49;
                                                    i75 = i51;
                                                    i76 = i44;
                                                    i77 = i77;
                                                    i79 = i79;
                                                    obj3 = obj;
                                                    if (iZzg != i35) {
                                                        i3 = i3;
                                                        zzdtVar7 = zzdtVar4;
                                                        i78 = i37;
                                                        i73 = i43;
                                                        i74 = 0;
                                                        unsafe9 = unsafe4;
                                                    } else {
                                                        i77 = i77;
                                                        i79 = i79;
                                                        unsafe2 = unsafe4;
                                                        i2 = i43;
                                                        i4 = i3;
                                                        i74 = i75;
                                                        i8 = iZzg;
                                                        int i916 = i37;
                                                        i9 = i76;
                                                        i10 = i916;
                                                    }
                                                }
                                                unsafe4 = unsafe8;
                                                zzdtVar4 = zzdtVar5;
                                                i37 = i50;
                                                i43 = i49;
                                                i45 = i51;
                                                i76 = i44;
                                                i75 = i45;
                                                iZzg = i35;
                                                i77 = i77;
                                                i79 = i79;
                                                obj3 = obj;
                                                if (iZzg != i35) {
                                                    i3 = i3;
                                                    zzdtVar7 = zzdtVar4;
                                                    i78 = i37;
                                                    i73 = i43;
                                                    i74 = 0;
                                                    unsafe9 = unsafe4;
                                                } else {
                                                    i77 = i77;
                                                    i79 = i79;
                                                    unsafe2 = unsafe4;
                                                    i2 = i43;
                                                    i4 = i3;
                                                    i74 = i75;
                                                    i8 = iZzg;
                                                    int i917 = i37;
                                                    i9 = i76;
                                                    i10 = i917;
                                                }
                                                break;
                                            } else {
                                                zzewVar2 = (zzew) zzezVar;
                                                iZzh7 = zzdu.zzh(bArr, i35, zzdtVar5);
                                                i53 = zzdtVar5.zza + iZzh7;
                                                while (iZzh7 < i53) {
                                                    zzewVar2.zze(zzdu.zzb(bArr, iZzh7));
                                                    iZzh7 += 4;
                                                }
                                                if (iZzh7 != i53) {
                                                    throw zzfb.zzf();
                                                }
                                                iZzf = iZzh7;
                                                zzdtVar4 = zzdtVar5;
                                                i37 = i50;
                                                i43 = i49;
                                                i75 = i51;
                                                i76 = i44;
                                                i77 = i77;
                                                i79 = i79;
                                                int i102 = iZzf;
                                                unsafe4 = unsafe8;
                                                iZzg = i102;
                                                obj3 = obj;
                                                if (iZzg != i35) {
                                                    i3 = i3;
                                                    zzdtVar7 = zzdtVar4;
                                                    i78 = i37;
                                                    i73 = i43;
                                                    i74 = 0;
                                                    unsafe9 = unsafe4;
                                                } else {
                                                    i77 = i77;
                                                    i79 = i79;
                                                    unsafe2 = unsafe4;
                                                    i2 = i43;
                                                    i4 = i3;
                                                    i74 = i75;
                                                    i8 = iZzg;
                                                    int i918 = i37;
                                                    i9 = i76;
                                                    i10 = i918;
                                                }
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            i49 = i34;
                                            zzdtVar5 = zzdtVar3;
                                            i50 = i37;
                                            i44 = i36;
                                            unsafe8 = unsafe4;
                                            i51 = i33;
                                            if (i12 == 2) {
                                                if (i12 == 0) {
                                                    zzdvVar = (zzdv) zzezVar;
                                                    int iZzk4 = zzdu.zzk(bArr, i35, zzdtVar5);
                                                    if (zzdtVar5.zzb != 0) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    zzdvVar.zze(z3);
                                                    iZzf = iZzk4;
                                                    while (iZzf < i49) {
                                                        iZzh9 = zzdu.zzh(bArr, iZzf, zzdtVar5);
                                                        if (i44 == zzdtVar5.zza) {
                                                            iZzf = zzdu.zzk(bArr, iZzh9, zzdtVar5);
                                                            if (zzdtVar5.zzb != 0) {
                                                                z4 = true;
                                                            } else {
                                                                z4 = false;
                                                            }
                                                            zzdvVar.zze(z4);
                                                        }
                                                    }
                                                }
                                                unsafe4 = unsafe8;
                                                zzdtVar4 = zzdtVar5;
                                                i37 = i50;
                                                i43 = i49;
                                                i45 = i51;
                                                i76 = i44;
                                                i75 = i45;
                                                iZzg = i35;
                                                i77 = i77;
                                                i79 = i79;
                                                obj3 = obj;
                                                if (iZzg != i35) {
                                                    i3 = i3;
                                                    zzdtVar7 = zzdtVar4;
                                                    i78 = i37;
                                                    i73 = i43;
                                                    i74 = 0;
                                                    unsafe9 = unsafe4;
                                                } else {
                                                    i77 = i77;
                                                    i79 = i79;
                                                    unsafe2 = unsafe4;
                                                    i2 = i43;
                                                    i4 = i3;
                                                    i74 = i75;
                                                    i8 = iZzg;
                                                    int i919 = i37;
                                                    i9 = i76;
                                                    i10 = i919;
                                                }
                                            } else {
                                                zzdvVar2 = (zzdv) zzezVar;
                                                iZzh7 = zzdu.zzh(bArr, i35, zzdtVar5);
                                                i54 = zzdtVar5.zza + iZzh7;
                                                while (iZzh7 < i54) {
                                                    iZzh7 = zzdu.zzk(bArr, iZzh7, zzdtVar5);
                                                    if (zzdtVar5.zzb != 0) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    zzdvVar2.zze(z5);
                                                }
                                                if (iZzh7 != i54) {
                                                    throw zzfb.zzf();
                                                }
                                                iZzf = iZzh7;
                                            }
                                            zzdtVar4 = zzdtVar5;
                                            i37 = i50;
                                            i43 = i49;
                                            i75 = i51;
                                            i76 = i44;
                                            i77 = i77;
                                            i79 = i79;
                                            int i103 = iZzf;
                                            unsafe4 = unsafe8;
                                            iZzg = i103;
                                            obj3 = obj;
                                            if (iZzg != i35) {
                                                i3 = i3;
                                                zzdtVar7 = zzdtVar4;
                                                i78 = i37;
                                                i73 = i43;
                                                i74 = 0;
                                                unsafe9 = unsafe4;
                                            } else {
                                                i77 = i77;
                                                i79 = i79;
                                                unsafe2 = unsafe4;
                                                i2 = i43;
                                                i4 = i3;
                                                i74 = i75;
                                                i8 = iZzg;
                                                int i9110 = i37;
                                                i9 = i76;
                                                i10 = i9110;
                                            }
                                            break;
                                        case 26:
                                            i49 = i34;
                                            zzdtVar5 = zzdtVar3;
                                            i50 = i37;
                                            i44 = i36;
                                            unsafe8 = unsafe4;
                                            i51 = i33;
                                            if (i12 == 2) {
                                                if ((j3 & 536870912) == 0) {
                                                    iZzh5 = zzdu.zzh(bArr, i35, zzdtVar5);
                                                    i59 = zzdtVar5.zza;
                                                    if (i59 >= 0) {
                                                        throw zzfb.zzc();
                                                    }
                                                    if (i59 == 0) {
                                                        obj2 = "";
                                                        zzezVar.add(obj2);
                                                    } else {
                                                        obj2 = "";
                                                        zzezVar.add(new String(bArr, iZzh5, i59, zzfa.zzb));
                                                        iZzh5 += i59;
                                                    }
                                                    while (iZzh5 < i49) {
                                                        iZzh11 = zzdu.zzh(bArr, iZzh5, zzdtVar5);
                                                        if (i44 == zzdtVar5.zza) {
                                                            iZzh5 = zzdu.zzh(bArr, iZzh11, zzdtVar5);
                                                            i60 = zzdtVar5.zza;
                                                            if (i60 >= 0) {
                                                                throw zzfb.zzc();
                                                            }
                                                            if (i60 == 0) {
                                                                
                                                                /*  JADX ERROR: Method code generation error
                                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x06db: INVOKE (r14v48 ?? I:??[OBJECT, ARRAY]), (r10v27 'obj2' java.lang.Object) INTERFACE call: java.util.List.add(java.lang.Object):boolean A[MD:(E):boolean (c)] (LINE:140) in method: com.google.android.gms.internal.auth.zzga.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzdt):int, file: classes4.dex
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:226)
                                                                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                                                                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
                                                                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                                                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                                                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                                                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                                                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                                                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                                                                    	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                                                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                                                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                                                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                                                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                                                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                                                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                                                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                                                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                                                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r14v48 ??
                                                                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                                                                    */
                                                                /*
                                                                    Method dump skipped, instruction units count: 3568
                                                                    To view this dump change 'Code comments level' option to 'DEBUG'
                                                                */
                                                                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzdt):int");
                                                            }

                                                            @Override // com.google.android.gms.internal.auth.zzgi
                                                            public final Object zzd() {
                                                                return ((zzev) this.zzg).zzc();
                                                            }

                                                            /* JADX WARN: Code duplicated, block: B:25:0x006c  */
                                                            /* JADX WARN: Code duplicated, block: B:27:0x0072  */
                                                            /* JADX WARN: Code duplicated, block: B:38:0x007f A[SYNTHETIC] */
                                                            @Override // com.google.android.gms.internal.auth.zzgi
                                                            public final void zze(Object obj) {
                                                                if (zzH(obj)) {
                                                                    if (obj instanceof zzev) {
                                                                        zzev zzevVar = (zzev) obj;
                                                                        zzevVar.zzl(Integer.MAX_VALUE);
                                                                        zzevVar.zza = 0;
                                                                        zzevVar.zzj();
                                                                    }
                                                                    int length = this.zzc.length;
                                                                    for (int i = 0; i < length; i += 3) {
                                                                        int iZzo = zzo(i);
                                                                        int iZzn = zzn(iZzo);
                                                                        long j = iZzo & 1048575;
                                                                        if (iZzn != 9) {
                                                                            if (iZzn != 60 && iZzn != 68) {
                                                                                switch (iZzn) {
                                                                                    case 17:
                                                                                        if (zzE(obj, i)) {
                                                                                            zzr(i).zze(zzb.getObject(obj, j));
                                                                                        }
                                                                                        break;
                                                                                    case 18:
                                                                                    case 19:
                                                                                    case 20:
                                                                                    case 21:
                                                                                    case 22:
                                                                                    case 23:
                                                                                    case 24:
                                                                                    case 25:
                                                                                    case 26:
                                                                                    case 27:
                                                                                    case 28:
                                                                                    case 29:
                                                                                    case 30:
                                                                                    case 31:
                                                                                    case 32:
                                                                                    case 33:
                                                                                    case 34:
                                                                                    case 35:
                                                                                    case 36:
                                                                                    case 37:
                                                                                    case 38:
                                                                                    case 39:
                                                                                    case 40:
                                                                                    case 41:
                                                                                    case 42:
                                                                                    case 43:
                                                                                    case 44:
                                                                                    case 45:
                                                                                    case 46:
                                                                                    case 47:
                                                                                    case 48:
                                                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                                                                        this.zzk.zza(obj, j);
                                                                                        break;
                                                                                    case 50:
                                                                                        Unsafe unsafe = zzb;
                                                                                        Object object = unsafe.getObject(obj, j);
                                                                                        if (object != null) {
                                                                                            ((zzfr) object).zzc();
                                                                                            unsafe.putObject(obj, j, object);
                                                                                        }
                                                                                        break;
                                                                                }
                                                                            } else if (zzI(obj, this.zzc[i], i)) {
                                                                                zzr(i).zze(zzb.getObject(obj, j));
                                                                            }
                                                                        } else if (zzE(obj, i)) {
                                                                            zzr(i).zze(zzb.getObject(obj, j));
                                                                        }
                                                                    }
                                                                    this.zzl.zze(obj);
                                                                }
                                                            }

                                                            @Override // com.google.android.gms.internal.auth.zzgi
                                                            public final void zzf(Object obj, Object obj2) {
                                                                zzw(obj);
                                                                obj2.getClass();
                                                                for (int i = 0; i < this.zzc.length; i += 3) {
                                                                    int iZzo = zzo(i);
                                                                    int i2 = this.zzc[i];
                                                                    long j = iZzo & 1048575;
                                                                    switch (zzn(iZzo)) {
                                                                        case 0:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzl(obj, j, zzhj.zza(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 1:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzm(obj, j, zzhj.zzb(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 2:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 3:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 4:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 5:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 6:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 7:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzk(obj, j, zzhj.zzt(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 8:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 9:
                                                                            zzx(obj, obj2, i);
                                                                            break;
                                                                        case 10:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 11:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 12:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 13:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 14:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 15:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 16:
                                                                            if (zzE(obj2, i)) {
                                                                                zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                                                                                zzz(obj, i);
                                                                            }
                                                                            break;
                                                                        case 17:
                                                                            zzx(obj, obj2, i);
                                                                            break;
                                                                        case 18:
                                                                        case 19:
                                                                        case 20:
                                                                        case 21:
                                                                        case 22:
                                                                        case 23:
                                                                        case 24:
                                                                        case 25:
                                                                        case 26:
                                                                        case 27:
                                                                        case 28:
                                                                        case 29:
                                                                        case 30:
                                                                        case 31:
                                                                        case 32:
                                                                        case 33:
                                                                        case 34:
                                                                        case 35:
                                                                        case 36:
                                                                        case 37:
                                                                        case 38:
                                                                        case 39:
                                                                        case 40:
                                                                        case 41:
                                                                        case 42:
                                                                        case 43:
                                                                        case 44:
                                                                        case 45:
                                                                        case 46:
                                                                        case 47:
                                                                        case 48:
                                                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                                                            this.zzk.zzb(obj, obj2, j);
                                                                            break;
                                                                        case 50:
                                                                            int i3 = zzgk.zza;
                                                                            zzhj.zzp(obj, j, zzfs.zza(zzhj.zzf(obj, j), zzhj.zzf(obj2, j)));
                                                                            break;
                                                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                                        case 52:
                                                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                                                        case 54:
                                                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                                                        case 56:
                                                                        case 57:
                                                                        case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                                                                        case 59:
                                                                            if (zzI(obj2, i2, i)) {
                                                                                zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                                                                                zzA(obj, i2, i);
                                                                            }
                                                                            break;
                                                                        case 60:
                                                                            zzy(obj, obj2, i);
                                                                            break;
                                                                        case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                                        case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                                                                        case 63:
                                                                        case 64:
                                                                        case 65:
                                                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                                        case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                                                                            if (zzI(obj2, i2, i)) {
                                                                                zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                                                                                zzA(obj, i2, i);
                                                                            }
                                                                            break;
                                                                        case 68:
                                                                            zzy(obj, obj2, i);
                                                                            break;
                                                                    }
                                                                }
                                                                zzgk.zzd(this.zzl, obj, obj2);
                                                            }

                                                            @Override // com.google.android.gms.internal.auth.zzgi
                                                            public final void zzg(Object obj, byte[] bArr, int i, int i2, zzdt zzdtVar) throws IOException {
                                                                zzb(obj, bArr, i, i2, 0, zzdtVar);
                                                            }

                                                            @Override // com.google.android.gms.internal.auth.zzgi
                                                            public final boolean zzh(Object obj, Object obj2) {
                                                                boolean zZzf;
                                                                int length = this.zzc.length;
                                                                for (int i = 0; i < length; i += 3) {
                                                                    int iZzo = zzo(i);
                                                                    long j = iZzo & 1048575;
                                                                    switch (zzn(iZzo)) {
                                                                        case 0:
                                                                            if (!zzD(obj, obj2, i) || Double.doubleToLongBits(zzhj.zza(obj, j)) != Double.doubleToLongBits(zzhj.zza(obj2, j))) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 1:
                                                                            if (!zzD(obj, obj2, i) || Float.floatToIntBits(zzhj.zzb(obj, j)) != Float.floatToIntBits(zzhj.zzb(obj2, j))) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 2:
                                                                            if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 3:
                                                                            if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 4:
                                                                            if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 5:
                                                                            if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 6:
                                                                            if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 7:
                                                                            if (!zzD(obj, obj2, i) || zzhj.zzt(obj, j) != zzhj.zzt(obj2, j)) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 8:
                                                                            if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 9:
                                                                            if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 10:
                                                                            if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 11:
                                                                            if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 12:
                                                                            if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 13:
                                                                            if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 14:
                                                                            if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 15:
                                                                            if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 16:
                                                                            if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 17:
                                                                            if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        case 18:
                                                                        case 19:
                                                                        case 20:
                                                                        case 21:
                                                                        case 22:
                                                                        case 23:
                                                                        case 24:
                                                                        case 25:
                                                                        case 26:
                                                                        case 27:
                                                                        case 28:
                                                                        case 29:
                                                                        case 30:
                                                                        case 31:
                                                                        case 32:
                                                                        case 33:
                                                                        case 34:
                                                                        case 35:
                                                                        case 36:
                                                                        case 37:
                                                                        case 38:
                                                                        case 39:
                                                                        case 40:
                                                                        case 41:
                                                                        case 42:
                                                                        case 43:
                                                                        case 44:
                                                                        case 45:
                                                                        case 46:
                                                                        case 47:
                                                                        case 48:
                                                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                                                            zZzf = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
                                                                            break;
                                                                        case 50:
                                                                            zZzf = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
                                                                            break;
                                                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                                        case 52:
                                                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                                                        case 54:
                                                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                                                        case 56:
                                                                        case 57:
                                                                        case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                                                                        case 59:
                                                                        case 60:
                                                                        case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                                        case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                                                                        case 63:
                                                                        case 64:
                                                                        case 65:
                                                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                                        case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                                                                        case 68:
                                                                            long jZzl = zzl(i) & 1048575;
                                                                            if (zzhj.zzc(obj, jZzl) != zzhj.zzc(obj2, jZzl) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                                                                                return false;
                                                                            }
                                                                            continue;
                                                                            break;
                                                                            break;
                                                                        default:
                                                                            continue;
                                                                            break;
                                                                    }
                                                                    if (!zZzf) {
                                                                        return false;
                                                                    }
                                                                }
                                                                return this.zzl.zzb(obj).equals(this.zzl.zzb(obj2));
                                                            }

                                                            /* JADX WARN: Code duplicated, block: B:42:0x009c  */
                                                            /* JADX WARN: Code duplicated, block: B:44:0x00ab  */
                                                            /* JADX WARN: Code duplicated, block: B:47:0x00b6  */
                                                            /* JADX WARN: Code duplicated, block: B:50:0x00c1 A[LOOP:1: B:45:0x00b0->B:50:0x00c1, LOOP_END] */
                                                            /* JADX WARN: Code duplicated, block: B:62:0x00c0 A[SYNTHETIC] */
                                                            /* JADX WARN: Code duplicated, block: B:66:0x00de A[SYNTHETIC] */
                                                            @Override // com.google.android.gms.internal.auth.zzgi
                                                            public final boolean zzi(Object obj) {
                                                                int i;
                                                                int i2;
                                                                List list;
                                                                zzgi zzgiVarZzr;
                                                                int i3;
                                                                int i4 = 0;
                                                                int i5 = 0;
                                                                int i6 = 1048575;
                                                                while (i5 < this.zzi) {
                                                                    int i7 = this.zzh[i5];
                                                                    int i8 = this.zzc[i7];
                                                                    int iZzo = zzo(i7);
                                                                    int i9 = this.zzc[i7 + 2];
                                                                    int i10 = i9 & 1048575;
                                                                    int i11 = 1 << (i9 >>> 20);
                                                                    if (i10 != i6) {
                                                                        if (i10 != 1048575) {
                                                                            i4 = zzb.getInt(obj, i10);
                                                                        }
                                                                        i2 = i4;
                                                                        i = i10;
                                                                    } else {
                                                                        i = i6;
                                                                        i2 = i4;
                                                                    }
                                                                    if ((268435456 & iZzo) != 0 && !zzF(obj, i7, i, i2, i11)) {
                                                                        return false;
                                                                    }
                                                                    int iZzn = zzn(iZzo);
                                                                    if (iZzn == 9 || iZzn == 17) {
                                                                        if (zzF(obj, i7, i, i2, i11) && !zzG(obj, iZzo, zzr(i7))) {
                                                                            return false;
                                                                        }
                                                                    } else if (iZzn == 27) {
                                                                        list = (List) zzhj.zzf(obj, iZzo & 1048575);
                                                                        if (list.isEmpty()) {
                                                                            continue;
                                                                        } else {
                                                                            zzgiVarZzr = zzr(i7);
                                                                            for (i3 = 0; i3 < list.size(); i3++) {
                                                                                if (!zzgiVarZzr.zzi(list.get(i3))) {
                                                                                    return false;
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (iZzn == 60 || iZzn == 68) {
                                                                        if (zzI(obj, i8, i7) && !zzG(obj, iZzo, zzr(i7))) {
                                                                            return false;
                                                                        }
                                                                    } else if (iZzn == 49) {
                                                                        list = (List) zzhj.zzf(obj, iZzo & 1048575);
                                                                        if (list.isEmpty()) {
                                                                            zzgiVarZzr = zzr(i7);
                                                                            while (i3 < list.size()) {
                                                                                if (!zzgiVarZzr.zzi(list.get(i3))) {
                                                                                    return false;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            continue;
                                                                        }
                                                                    } else if (iZzn == 50 && !((zzfr) zzhj.zzf(obj, iZzo & 1048575)).isEmpty()) {
                                                                        throw null;
                                                                    }
                                                                    i5++;
                                                                    i6 = i;
                                                                    i4 = i2;
                                                                }
                                                                return true;
                                                            }
                                                        }
