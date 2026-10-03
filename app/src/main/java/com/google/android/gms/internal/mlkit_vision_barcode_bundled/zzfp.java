package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.soloader.Elf64;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes4.dex */
final class zzfp<T> implements zzge<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgz.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfm zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzgs zzl;
    private final zzdt zzm;

    private zzfp(int[] iArr, Object[] objArr, int i, int i2, zzfm zzfmVar, boolean z, int[] iArr2, int i3, int i4, zzfs zzfsVar, zzez zzezVar, zzgs zzgsVar, zzdt zzdtVar, zzfh zzfhVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzh = zzdtVar != null && (zzfmVar instanceof zzed);
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzgsVar;
        this.zzm = zzdtVar;
        this.zzg = zzfmVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i);
            Unsafe unsafe = zzb;
            long j = iZzs & 1048575;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzge zzgeVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zzgeVarZzv.zze();
                    zzgeVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgeVarZzv.zze();
                zzgeVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgeVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i);
            Unsafe unsafe = zzb;
            long j = iZzs & 1048575;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzge zzgeVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zzgeVarZzv.zze();
                    zzgeVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgeVarZzv.zze();
                zzgeVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgeVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzgz.zzq(obj, j, (1 << (iZzp >>> 20)) | zzgz.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzgz.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & 1048575;
        if (j != 1048575) {
            return (zzgz.zzc(obj, j) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzgz.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzgz.zzb(obj, j2)) != 0;
            case 2:
                return zzgz.zzd(obj, j2) != 0;
            case 3:
                return zzgz.zzd(obj, j2) != 0;
            case 4:
                return zzgz.zzc(obj, j2) != 0;
            case 5:
                return zzgz.zzd(obj, j2) != 0;
            case 6:
                return zzgz.zzc(obj, j2) != 0;
            case 7:
                return zzgz.zzw(obj, j2);
            case 8:
                Object objZzf = zzgz.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzdf) {
                    return !zzdf.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzgz.zzf(obj, j2) != null;
            case 10:
                return !zzdf.zzb.equals(zzgz.zzf(obj, j2));
            case 11:
                return zzgz.zzc(obj, j2) != 0;
            case 12:
                return zzgz.zzc(obj, j2) != 0;
            case 13:
                return zzgz.zzc(obj, j2) != 0;
            case 14:
                return zzgz.zzd(obj, j2) != 0;
            case 15:
                return zzgz.zzc(obj, j2) != 0;
            case 16:
                return zzgz.zzd(obj, j2) != 0;
            case 17:
                return zzgz.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzge zzgeVar) {
        return zzgeVar.zzk(zzgz.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzeh) {
            return ((zzeh) obj).zzY();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzgz.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzgz.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzhh zzhhVar) throws IOException {
        if (obj instanceof String) {
            zzhhVar.zzG(i, (String) obj);
        } else {
            zzhhVar.zzd(i, (zzdf) obj);
        }
    }

    static zzgt zzd(Object obj) {
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVar = zzehVar.zzc;
        if (zzgtVar != zzgt.zzc()) {
            return zzgtVar;
        }
        zzgt zzgtVarZzf = zzgt.zzf();
        zzehVar.zzc = zzgtVarZzf;
        return zzgtVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0259  */
    /* JADX WARN: Code duplicated, block: B:125:0x025c  */
    /* JADX WARN: Code duplicated, block: B:128:0x0273  */
    /* JADX WARN: Code duplicated, block: B:129:0x0276  */
    /* JADX WARN: Code duplicated, block: B:182:0x037b  */
    static zzfp zzl(Class cls, zzfj zzfjVar, zzfs zzfsVar, zzez zzezVar, zzgs zzgsVar, zzdt zzdtVar, zzfh zzfhVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
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
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i17;
        int i18;
        int iObjectFieldOffset3;
        int i19;
        Field fieldZzz;
        int i20;
        char cCharAt9;
        int i21;
        int i22;
        int i23;
        int i24;
        Object obj;
        Field fieldZzz2;
        int i25;
        Object obj2;
        Field fieldZzz3;
        int i26;
        char cCharAt10;
        int i27;
        char cCharAt11;
        int i28;
        char cCharAt12;
        int i29;
        char cCharAt13;
        if (!(zzfjVar instanceof zzfw)) {
            throw null;
        }
        zzfw zzfwVar = (zzfw) zzfjVar;
        String strZzd = zzfwVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i30 = 1;
            while (true) {
                i = i30 + 1;
                if (strZzd.charAt(i30) < 55296) {
                    break;
                }
                i30 = i;
            }
        } else {
            i = 1;
        }
        int i31 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i32 = iCharAt3 & 8191;
            int i33 = 13;
            while (true) {
                i29 = i31 + 1;
                cCharAt13 = strZzd.charAt(i31);
                if (cCharAt13 < 55296) {
                    break;
                }
                i32 |= (cCharAt13 & 8191) << i33;
                i33 += 13;
                i31 = i29;
            }
            iCharAt3 = i32 | (cCharAt13 << i33);
            i31 = i29;
        }
        if (iCharAt3 == 0) {
            i6 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            iArr = zza;
            i2 = 0;
        } else {
            int i34 = i31 + 1;
            int iCharAt4 = strZzd.charAt(i31);
            if (iCharAt4 >= 55296) {
                int i35 = iCharAt4 & 8191;
                int i36 = 13;
                while (true) {
                    i14 = i34 + 1;
                    cCharAt8 = strZzd.charAt(i34);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i35 |= (cCharAt8 & 8191) << i36;
                    i36 += 13;
                    i34 = i14;
                }
                iCharAt4 = i35 | (cCharAt8 << i36);
                i34 = i14;
            }
            int i37 = i34 + 1;
            int iCharAt5 = strZzd.charAt(i34);
            if (iCharAt5 >= 55296) {
                int i38 = iCharAt5 & 8191;
                int i39 = 13;
                while (true) {
                    i13 = i37 + 1;
                    cCharAt7 = strZzd.charAt(i37);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt7 & 8191) << i39;
                    i39 += 13;
                    i37 = i13;
                }
                iCharAt5 = i38 | (cCharAt7 << i39);
                i37 = i13;
            }
            int i40 = i37 + 1;
            int iCharAt6 = strZzd.charAt(i37);
            if (iCharAt6 >= 55296) {
                int i41 = iCharAt6 & 8191;
                int i42 = 13;
                while (true) {
                    i12 = i40 + 1;
                    cCharAt6 = strZzd.charAt(i40);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt6 & 8191) << i42;
                    i42 += 13;
                    i40 = i12;
                }
                iCharAt6 = i41 | (cCharAt6 << i42);
                i40 = i12;
            }
            int i43 = i40 + 1;
            int iCharAt7 = strZzd.charAt(i40);
            if (iCharAt7 >= 55296) {
                int i44 = iCharAt7 & 8191;
                int i45 = 13;
                while (true) {
                    i11 = i43 + 1;
                    cCharAt5 = strZzd.charAt(i43);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt5 & 8191) << i45;
                    i45 += 13;
                    i43 = i11;
                }
                iCharAt7 = i44 | (cCharAt5 << i45);
                i43 = i11;
            }
            int i46 = i43 + 1;
            iCharAt = strZzd.charAt(i43);
            if (iCharAt >= 55296) {
                int i47 = iCharAt & 8191;
                int i48 = 13;
                while (true) {
                    i10 = i46 + 1;
                    cCharAt4 = strZzd.charAt(i46);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt4 & 8191) << i48;
                    i48 += 13;
                    i46 = i10;
                }
                iCharAt = i47 | (cCharAt4 << i48);
                i46 = i10;
            }
            int i49 = i46 + 1;
            iCharAt2 = strZzd.charAt(i46);
            if (iCharAt2 >= 55296) {
                int i50 = iCharAt2 & 8191;
                int i51 = 13;
                while (true) {
                    i9 = i49 + 1;
                    cCharAt3 = strZzd.charAt(i49);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt3 & 8191) << i51;
                    i51 += 13;
                    i49 = i9;
                }
                iCharAt2 = i50 | (cCharAt3 << i51);
                i49 = i9;
            }
            int i52 = i49 + 1;
            int iCharAt8 = strZzd.charAt(i49);
            if (iCharAt8 >= 55296) {
                int i53 = iCharAt8 & 8191;
                int i54 = 13;
                while (true) {
                    i8 = i52 + 1;
                    cCharAt2 = strZzd.charAt(i52);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt2 & 8191) << i54;
                    i54 += 13;
                    i52 = i8;
                }
                iCharAt8 = i53 | (cCharAt2 << i54);
                i52 = i8;
            }
            int i55 = i52 + 1;
            int iCharAt9 = strZzd.charAt(i52);
            if (iCharAt9 >= 55296) {
                int i56 = iCharAt9 & 8191;
                int i57 = 13;
                while (true) {
                    i7 = i55 + 1;
                    cCharAt = strZzd.charAt(i55);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i56 |= (cCharAt & 8191) << i57;
                    i57 += 13;
                    i55 = i7;
                }
                iCharAt9 = i56 | (cCharAt << i57);
                i55 = i7;
            }
            int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            int i58 = iCharAt4 + iCharAt4 + iCharAt5;
            i2 = iCharAt4;
            i3 = iCharAt9;
            i31 = i55;
            i4 = iCharAt7;
            i5 = iCharAt6;
            i6 = i58;
            iArr = iArr2;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzfwVar.zze();
        Class<?> cls2 = zzfwVar.zza().getClass();
        int i59 = i3 + iCharAt2;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[iCharAt + iCharAt];
        int i60 = i3;
        int i61 = i59;
        int i62 = 0;
        int i63 = 0;
        while (i31 < length) {
            int i64 = i31 + 1;
            int iCharAt10 = strZzd.charAt(i31);
            if (iCharAt10 >= c) {
                int i65 = iCharAt10 & 8191;
                int i66 = i64;
                int i67 = 13;
                while (true) {
                    i28 = i66 + 1;
                    cCharAt12 = strZzd.charAt(i66);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i65 |= (cCharAt12 & 8191) << i67;
                    i67 += 13;
                    i66 = i28;
                }
                iCharAt10 = i65 | (cCharAt12 << i67);
                i15 = i28;
            } else {
                i15 = i64;
            }
            int i68 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i69 = iCharAt11 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i27 = i70 + 1;
                    cCharAt11 = strZzd.charAt(i70);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i69 |= (cCharAt11 & 8191) << i71;
                    i71 += 13;
                    i70 = i27;
                }
                iCharAt11 = i69 | (cCharAt11 << i71);
                i16 = i27;
            } else {
                i16 = i68;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i63] = i62;
                i63++;
            }
            int i72 = iCharAt11 & 255;
            int i73 = length;
            int i74 = iCharAt11 & 2048;
            int i75 = i4;
            int i76 = i5;
            if (i72 >= 51) {
                int i77 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i78 = iCharAt12 & 8191;
                    int i79 = 13;
                    while (true) {
                        i26 = i77 + 1;
                        cCharAt10 = strZzd.charAt(i77);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i78 |= (cCharAt10 & 8191) << i79;
                        i79 += 13;
                        i77 = i26;
                        c2 = 55296;
                    }
                    iCharAt12 = i78 | (cCharAt10 << i79);
                    i77 = i26;
                }
                int i80 = i72 - 51;
                int i81 = i77;
                if (i80 == 9 || i80 == 17) {
                    i23 = i6 + 1;
                    int i82 = i62 / 3;
                    objArr[i82 + i82 + 1] = objArrZze[i6];
                } else {
                    if (i80 == 12) {
                        if (zzfwVar.zzc() == 1 || i74 != 0) {
                            i23 = i6 + 1;
                            int i83 = i62 / 3;
                            objArr[i83 + i83 + 1] = objArrZze[i6];
                        } else {
                            i74 = 0;
                        }
                    }
                    i24 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i24];
                    if (obj instanceof Field) {
                        fieldZzz2 = (Field) obj;
                    } else {
                        fieldZzz2 = zzz(cls2, (String) obj);
                        objArrZze[i24] = fieldZzz2;
                    }
                    int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzz2);
                    i25 = i24 + 1;
                    obj2 = objArrZze[i25];
                    int i84 = i74;
                    if (obj2 instanceof Field) {
                        fieldZzz3 = (Field) obj2;
                    } else {
                        fieldZzz3 = zzz(cls2, (String) obj2);
                        objArrZze[i25] = fieldZzz3;
                    }
                    i18 = iObjectFieldOffset4;
                    i19 = i84;
                    zzfwVar = zzfwVar;
                    iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz3);
                    i16 = i81;
                    strZzd = strZzd;
                    i17 = 0;
                }
                i6 = i23;
                i24 = iCharAt12 + iCharAt12;
                obj = objArrZze[i24];
                if (obj instanceof Field) {
                    fieldZzz2 = (Field) obj;
                } else {
                    fieldZzz2 = zzz(cls2, (String) obj);
                    objArrZze[i24] = fieldZzz2;
                }
                int iObjectFieldOffset5 = (int) unsafe.objectFieldOffset(fieldZzz2);
                i25 = i24 + 1;
                obj2 = objArrZze[i25];
                int i85 = i74;
                if (obj2 instanceof Field) {
                    fieldZzz3 = (Field) obj2;
                } else {
                    fieldZzz3 = zzz(cls2, (String) obj2);
                    objArrZze[i25] = fieldZzz3;
                }
                i18 = iObjectFieldOffset5;
                i19 = i85;
                zzfwVar = zzfwVar;
                iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz3);
                i16 = i81;
                strZzd = strZzd;
                i17 = 0;
            } else {
                int i86 = i6 + 1;
                Field fieldZzz4 = zzz(cls2, (String) objArrZze[i6]);
                if (i72 == 9 || i72 == 17) {
                    zzfwVar = zzfwVar;
                    int i87 = i62 / 3;
                    objArr[i87 + i87 + 1] = fieldZzz4.getType();
                } else {
                    if (i72 != 27) {
                        if (i72 == 49) {
                            i22 = i6 + 2;
                            i21 = 1;
                        } else if (i72 == 12 || i72 == 30 || i72 == 44) {
                            zzfwVar = zzfwVar;
                            if (zzfwVar.zzc() == 1 || i74 != 0) {
                                i22 = i6 + 2;
                                int i88 = i62 / 3;
                                objArr[i88 + i88 + 1] = objArrZze[i86];
                                i86 = i22;
                            } else {
                                i74 = 0;
                            }
                        } else {
                            if (i72 == 50) {
                                int i89 = i6 + 2;
                                int i90 = i60 + 1;
                                iArr[i60] = i62;
                                int i91 = i62 / 3;
                                int i92 = i91 + i91;
                                objArr[i92] = objArrZze[i86];
                                if (i74 != 0) {
                                    i86 = i6 + 3;
                                    objArr[i92 + 1] = objArrZze[i89];
                                    i60 = i90;
                                    zzfwVar = zzfwVar;
                                } else {
                                    i86 = i89;
                                    i60 = i90;
                                    i74 = 0;
                                }
                            }
                            zzfwVar = zzfwVar;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                        if ((iCharAt11 & 4096) != 0 || i72 > 17) {
                            iObjectFieldOffset2 = 1048575;
                            i17 = 0;
                        } else {
                            int i93 = i16 + 1;
                            int iCharAt13 = strZzd.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i94 = iCharAt13 & 8191;
                                int i95 = 13;
                                while (true) {
                                    i20 = i93 + 1;
                                    cCharAt9 = strZzd.charAt(i93);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i94 |= (cCharAt9 & 8191) << i95;
                                    i95 += 13;
                                    i93 = i20;
                                }
                                iCharAt13 = i94 | (cCharAt9 << i95);
                                i93 = i20;
                            }
                            int i96 = i2 + i2 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i96];
                            int i97 = i93;
                            if (obj3 instanceof Field) {
                                fieldZzz = (Field) obj3;
                            } else {
                                fieldZzz = zzz(cls2, (String) obj3);
                                objArrZze[i96] = fieldZzz;
                            }
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz);
                            i17 = iCharAt13 % 32;
                            i16 = i97;
                        }
                        if (i72 >= 18 && i72 <= 49) {
                            iArr[i61] = iObjectFieldOffset;
                            i61++;
                        }
                        i6 = i86;
                        i18 = iObjectFieldOffset;
                        iObjectFieldOffset3 = iObjectFieldOffset2;
                        i19 = i74;
                    } else {
                        i21 = 1;
                        i22 = i6 + 2;
                    }
                    int i98 = i62 / 3;
                    objArr[i98 + i98 + i21] = objArrZze[i86];
                    i86 = i22;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                if ((iCharAt11 & 4096) != 0) {
                    iObjectFieldOffset2 = 1048575;
                    i17 = 0;
                } else {
                    iObjectFieldOffset2 = 1048575;
                    i17 = 0;
                }
                if (i72 >= 18) {
                    iArr[i61] = iObjectFieldOffset;
                    i61++;
                }
                i6 = i86;
                i18 = iObjectFieldOffset;
                iObjectFieldOffset3 = iObjectFieldOffset2;
                i19 = i74;
            }
            iArr3[i62] = iCharAt10;
            iArr3[i62 + 1] = (i19 != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i72 << 20) | i18;
            iArr3[i62 + 2] = iObjectFieldOffset3 | (i17 << 20);
            i62 += 3;
            strZzd = strZzd;
            i31 = i16;
            length = i73;
            i4 = i75;
            zzfwVar = zzfwVar;
            i5 = i76;
            c = 55296;
        }
        return new zzfp(iArr3, objArr, i5, i4, zzfwVar.zza(), false, iArr, i3, i59, zzfsVar, zzezVar, zzgsVar, zzdtVar, zzfhVar);
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzgz.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzgz.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzgz.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzgz.zzf(obj, j)).longValue();
    }

    private final zzel zzu(int i) {
        int i2 = i / 3;
        return (zzel) this.zzd[i2 + i2 + 1];
    }

    private final zzge zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzge zzgeVar = (zzge) objArr[i3];
        if (zzgeVar != null) {
            return zzgeVar;
        }
        zzge zzgeVarZzb = zzfu.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzgeVarZzb;
        return zzgeVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzge zzgeVarZzv = zzv(i);
        int iZzs = zzs(i);
        if (!zzI(obj, i)) {
            return zzgeVarZzv.zze();
        }
        Object object = zzb.getObject(obj, 1048575 & iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgeVarZzv.zze();
        if (object != null) {
            zzgeVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzge zzgeVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzgeVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgeVarZzv.zze();
        if (object != null) {
            zzgeVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
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

    /* JADX WARN: Code duplicated, block: B:201:0x052e  */
    /* JADX WARN: Code duplicated, block: B:206:0x054e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v124, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v127, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v129, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v145 */
    /* JADX WARN: Type inference failed for: r0v195, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275, types: [int] */
    /* JADX WARN: Type inference failed for: r0v281 */
    /* JADX WARN: Type inference failed for: r0v284 */
    /* JADX WARN: Type inference failed for: r0v285 */
    /* JADX WARN: Type inference failed for: r0v286 */
    /* JADX WARN: Type inference failed for: r0v287 */
    /* JADX WARN: Type inference failed for: r0v288 */
    /* JADX WARN: Type inference failed for: r0v289 */
    /* JADX WARN: Type inference failed for: r0v290 */
    /* JADX WARN: Type inference failed for: r0v291 */
    /* JADX WARN: Type inference failed for: r0v292 */
    /* JADX WARN: Type inference failed for: r0v293 */
    /* JADX WARN: Type inference failed for: r0v294 */
    /* JADX WARN: Type inference failed for: r0v295 */
    /* JADX WARN: Type inference failed for: r0v296 */
    /* JADX WARN: Type inference failed for: r0v297 */
    /* JADX WARN: Type inference failed for: r0v298 */
    /* JADX WARN: Type inference failed for: r0v299 */
    /* JADX WARN: Type inference failed for: r0v300 */
    /* JADX WARN: Type inference failed for: r0v301 */
    /* JADX WARN: Type inference failed for: r0v302 */
    /* JADX WARN: Type inference failed for: r0v303 */
    /* JADX WARN: Type inference failed for: r0v304 */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5, types: [int] */
    /* JADX WARN: Type inference failed for: r12v6, types: [int] */
    /* JADX WARN: Type inference failed for: r12v8, types: [int] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r1v124 */
    /* JADX WARN: Type inference failed for: r1v125 */
    /* JADX WARN: Type inference failed for: r1v56, types: [int] */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v96, types: [int] */
    /* JADX WARN: Type inference failed for: r1v99, types: [int] */
    /* JADX WARN: Type inference failed for: r2v117 */
    /* JADX WARN: Type inference failed for: r2v118 */
    /* JADX WARN: Type inference failed for: r2v119 */
    /* JADX WARN: Type inference failed for: r2v120 */
    /* JADX WARN: Type inference failed for: r2v121 */
    /* JADX WARN: Type inference failed for: r2v45, types: [int] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51, types: [int] */
    /* JADX WARN: Type inference failed for: r2v55, types: [int] */
    /* JADX WARN: Type inference failed for: r2v59, types: [int] */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68, types: [int] */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [int] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30, types: [int] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v44, types: [int] */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46, types: [int] */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zza(Object obj) {
        ?? r14;
        int i;
        ?? r5;
        int iZzA;
        int iZzA2;
        int iZzA3;
        int iZzB;
        int iZzA4;
        int iZzA5;
        int iZzd;
        int iZzA6;
        int iZzA7;
        int iZzd2;
        ?? Zzg;
        int size;
        int iZzl;
        int iZzA8;
        int iZzz;
        int iZzz2;
        ?? Zzw;
        int iZzy;
        ?? ZzA;
        ?? Zzh;
        int iZze;
        int iZzA9;
        int iZzA10;
        ?? r0;
        Unsafe unsafe = zzb;
        boolean z = false;
        int i2 = 1048575;
        ?? r1 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i3 < this.zzc.length) {
            int iZzs = zzs(i3);
            int iZzr = zzr(iZzs);
            int[] iArr = this.zzc;
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & i2;
            if (iZzr <= 17) {
                if (i8 != i5) {
                    i5 = i8;
                    r0 = i8 == i2 ? z : unsafe.getInt(obj, i8);
                }
                r14 = r0;
                i = i5;
                r5 = 1 << (i7 >>> 20);
            } else {
                r0 = r1;
                r14 = r1;
                i = i5;
                r5 = z;
            }
            if (iZzr >= zzdy.zzJ.zza()) {
                zzdy.zzW.zza();
            }
            long j = iZzs & i2;
            switch (iZzr) {
                case 0:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 1:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        iZzA2 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 2:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(j2);
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 3:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(j3);
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 4:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(j4);
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 5:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 6:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        iZzA2 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 7:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        iZzA4 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 8:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        int i9 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzdf) {
                            iZzA5 = zzdn.zzA(i9);
                            iZzd = ((zzdf) object).zzd();
                            iZzA6 = zzdn.zzA(iZzd);
                            int i10 = iZzd;
                            iZzA7 = iZzA5;
                            iZzd2 = i10;
                            Zzh = iZzA7 + iZzA6 + iZzd2;
                            i4 += Zzh;
                        } else {
                            iZzA3 = zzdn.zzA(i9);
                            iZzB = zzdn.zzz((String) object);
                            Zzh = iZzB + iZzA3;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 9:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        Zzh = zzgg.zzh(i6, unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 10:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        zzdf zzdfVar = (zzdf) unsafe.getObject(obj, j);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzd2 = zzdfVar.zzd();
                        iZzA6 = zzdn.zzA(iZzd2);
                        Zzh = iZzA7 + iZzA6 + iZzd2;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 11:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzA(i11);
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 12:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(j5);
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 13:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        iZzA2 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 14:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 15:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzA((i12 + i12) ^ (i12 >> 31));
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 16:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB((j6 + j6) ^ (j6 >> 63));
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 17:
                    if (zzJ(obj, i3, i, r14 == true ? 1 : 0, r5)) {
                        Zzh = zzdn.zzw(i6, (zzfm) unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 18:
                    Zzh = zzgg.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 19:
                    Zzh = zzgg.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zzgg.zza;
                    if (list.size() == 0) {
                        Zzg = z;
                    } else {
                        Zzg = zzgg.zzg(list) + (list.size() * zzdn.zzA(i6 << 3));
                    }
                    i4 += Zzg;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i14 = zzgg.zza;
                    size = list2.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzl = zzgg.zzl(list2);
                        iZzA8 = zzdn.zzA(i6 << 3);
                        int i15 = size * iZzA8;
                        iZzA3 = iZzl;
                        iZzB = i15;
                        Zzh = iZzB + iZzA3;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zzgg.zza;
                    size = list3.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzl = zzgg.zzf(list3);
                        iZzA8 = zzdn.zzA(i6 << 3);
                        int i17 = size * iZzA8;
                        iZzA3 = iZzl;
                        iZzB = i17;
                        Zzh = iZzB + iZzA3;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 23:
                    Zzh = zzgg.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 24:
                    Zzh = zzgg.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i18 = zzgg.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        Zzh = z;
                    } else {
                        Zzh = size2 * (zzdn.zzA(i6 << 3) + 1);
                    }
                    i4 += Zzh;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 26:
                    ?? r2 = (List) unsafe.getObject(obj, j);
                    int i19 = zzgg.zza;
                    int size3 = r2.size();
                    if (size3 == 0) {
                        Zzg = z;
                    } else {
                        int iZzA11 = zzdn.zzA(i6 << 3) * size3;
                        if (r2 instanceof zzey) {
                            zzey zzeyVar = (zzey) r2;
                            for (?? r3 = z; r3 < size3; r3++) {
                                Object objZza = zzeyVar.zza();
                                if (objZza instanceof zzdf) {
                                    Zzg = iZzA11;
                                    int iZzd3 = ((zzdf) objZza).zzd();
                                    iZzz2 = Zzg + zzdn.zzA(iZzd3) + iZzd3;
                                } else {
                                    Zzg = iZzA11;
                                    iZzz2 = Zzg + zzdn.zzz((String) objZza);
                                }
                                Zzg = iZzz2;
                            }
                            Zzg = iZzA11;
                        } else {
                            for (?? r4 = z; r4 < size3; r4++) {
                                Object obj2 = r2.get(r4);
                                if (obj2 instanceof zzdf) {
                                    Zzg = iZzA11;
                                    int iZzd4 = ((zzdf) obj2).zzd();
                                    iZzz = Zzg + zzdn.zzA(iZzd4) + iZzd4;
                                } else {
                                    Zzg = iZzA11;
                                    iZzz = Zzg + zzdn.zzz((String) obj2);
                                }
                                Zzg = iZzz;
                            }
                            Zzg = iZzA11;
                        }
                    }
                    i4 += Zzg;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 27:
                    ?? r6 = (List) unsafe.getObject(obj, j);
                    zzge zzgeVarZzv = zzv(i3);
                    int i20 = zzgg.zza;
                    int size4 = r6.size();
                    if (size4 == 0) {
                        Zzw = z;
                    } else {
                        int iZzA12 = zzdn.zzA(i6 << 3) * size4;
                        for (?? r7 = z; r7 < size4; r7++) {
                            Object obj3 = r6.get(r7);
                            if (obj3 instanceof zzex) {
                                Zzw = iZzA12;
                                int iZza = ((zzex) obj3).zza();
                                iZzy = (Zzw == true ? 1 : 0) + zzdn.zzA(iZza) + iZza;
                            } else {
                                Zzw = iZzA12;
                                iZzy = (Zzw == true ? 1 : 0) + zzdn.zzy((zzfm) obj3, zzgeVarZzv);
                            }
                            Zzw = iZzy;
                        }
                        Zzw = iZzA12;
                    }
                    i4 += Zzw;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 28:
                    ?? r8 = (List) unsafe.getObject(obj, j);
                    int i21 = zzgg.zza;
                    int size5 = r8.size();
                    if (size5 == 0) {
                        ZzA = z;
                    } else {
                        ZzA = size5 * zzdn.zzA(i6 << 3);
                        for (?? r9 = z; r9 < r8.size(); r9++) {
                            int iZzd5 = ((zzdf) r8.get(r9)).zzd();
                            ZzA += zzdn.zzA(iZzd5) + iZzd5;
                        }
                    }
                    i4 += ZzA;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i22 = zzgg.zza;
                    size = list5.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzl = zzgg.zzk(list5);
                        iZzA8 = zzdn.zzA(i6 << 3);
                        int i110 = size * iZzA8;
                        iZzA3 = iZzl;
                        iZzB = i110;
                        Zzh = iZzB + iZzA3;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i23 = zzgg.zza;
                    size = list6.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzl = zzgg.zza(list6);
                        iZzA8 = zzdn.zzA(i6 << 3);
                        int i111 = size * iZzA8;
                        iZzA3 = iZzl;
                        iZzB = i111;
                        Zzh = iZzB + iZzA3;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 31:
                    Zzh = zzgg.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 32:
                    Zzh = zzgg.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i24 = zzgg.zza;
                    size = list7.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzl = zzgg.zzi(list7);
                        iZzA8 = zzdn.zzA(i6 << 3);
                        int i112 = size * iZzA8;
                        iZzA3 = iZzl;
                        iZzB = i112;
                        Zzh = iZzB + iZzA3;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i25 = zzgg.zza;
                    size = list8.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzl = zzgg.zzj(list8);
                        iZzA8 = zzdn.zzA(i6 << 3);
                        int i113 = size * iZzA8;
                        iZzA3 = iZzl;
                        iZzB = i113;
                        Zzh = iZzB + iZzA3;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 35:
                    iZze = zzgg.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 36:
                    iZze = zzgg.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 37:
                    iZze = zzgg.zzg((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 38:
                    iZze = zzgg.zzl((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 39:
                    iZze = zzgg.zzf((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 40:
                    iZze = zzgg.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 41:
                    iZze = zzgg.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i26 = zzgg.zza;
                    iZze = list9.size();
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 43:
                    iZze = zzgg.zzk((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 44:
                    iZze = zzgg.zza((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 45:
                    iZze = zzgg.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 46:
                    iZze = zzgg.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 47:
                    iZze = zzgg.zzi((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 48:
                    iZze = zzgg.zzj((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA9 = zzdn.zzA(i6 << 3);
                        iZzA10 = zzdn.zzA(iZze);
                        ZzA = iZzA9 + iZzA10 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    ?? r10 = (List) unsafe.getObject(obj, j);
                    zzge zzgeVarZzv2 = zzv(i3);
                    int i27 = zzgg.zza;
                    int size6 = r10.size();
                    Zzw = z;
                    if (size6 != 0) {
                        for (?? r11 = Zzw; r11 < size6; r11++) {
                            Zzw = Zzw;
                            Zzw += zzdn.zzw(i6, (zzfm) r10.get(r11), zzgeVarZzv2);
                        }
                        Zzw = Zzw;
                    }
                    i4 += Zzw;
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 50:
                    zzfg zzfgVar = (zzfg) unsafe.getObject(obj, j);
                    if (zzfgVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it2 = zzfgVar.entrySet().iterator();
                        if (it2.hasNext()) {
                            Map.Entry entry = (Map.Entry) it2.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzM(obj, i6, i3)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 52:
                    if (zzM(obj, i6, i3)) {
                        iZzA2 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzM(obj, i6, i3)) {
                        long jZzt = zzt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(jZzt);
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 54:
                    if (zzM(obj, i6, i3)) {
                        long jZzt2 = zzt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(jZzt2);
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzM(obj, i6, i3)) {
                        long jZzo = zzo(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(jZzo);
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 56:
                    if (zzM(obj, i6, i3)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 57:
                    if (zzM(obj, i6, i3)) {
                        iZzA2 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                    if (zzM(obj, i6, i3)) {
                        iZzA4 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 59:
                    if (zzM(obj, i6, i3)) {
                        int i28 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzdf) {
                            iZzA5 = zzdn.zzA(i28);
                            iZzd = ((zzdf) object2).zzd();
                            iZzA6 = zzdn.zzA(iZzd);
                            int i114 = iZzd;
                            iZzA7 = iZzA5;
                            iZzd2 = i114;
                            Zzh = iZzA7 + iZzA6 + iZzd2;
                            i4 += Zzh;
                        } else {
                            iZzA3 = zzdn.zzA(i28);
                            iZzB = zzdn.zzz((String) object2);
                            Zzh = iZzB + iZzA3;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 60:
                    if (zzM(obj, i6, i3)) {
                        Zzh = zzgg.zzh(i6, unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzM(obj, i6, i3)) {
                        zzdf zzdfVar2 = (zzdf) unsafe.getObject(obj, j);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzd2 = zzdfVar2.zzd();
                        iZzA6 = zzdn.zzA(iZzd2);
                        Zzh = iZzA7 + iZzA6 + iZzd2;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (zzM(obj, i6, i3)) {
                        int iZzo = zzo(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzA(iZzo);
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 63:
                    if (zzM(obj, i6, i3)) {
                        long jZzo2 = zzo(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(jZzo2);
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 64:
                    if (zzM(obj, i6, i3)) {
                        iZzA2 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 65:
                    if (zzM(obj, i6, i3)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzM(obj, i6, i3)) {
                        int iZzo2 = zzo(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzA((iZzo2 + iZzo2) ^ (iZzo2 >> 31));
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (zzM(obj, i6, i3)) {
                        long jZzt3 = zzt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB((jZzt3 + jZzt3) ^ (jZzt3 >> 63));
                        Zzh = iZzB + iZzA3;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                case 68:
                    if (zzM(obj, i6, i3)) {
                        Zzh = zzdn.zzw(i6, (zzfm) unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
                default:
                    i3 += 3;
                    r1 = r14;
                    i5 = i;
                    z = false;
                    i2 = 1048575;
                    break;
            }
        }
        int iZza2 = i4 + ((zzeh) obj).zzc.zza();
        if (!this.zzh) {
            return iZza2;
        }
        zzdx zzdxVar = ((zzed) obj).zzb;
        int iZzc = zzdxVar.zza.zzc();
        int iZza3 = 0;
        for (int i29 = 0; i29 < iZzc; i29++) {
            Map.Entry entryZzg = zzdxVar.zza.zzg(i29);
            iZza3 += zzdx.zza((zzdw) ((zzgi) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry2 : zzdxVar.zza.zzd()) {
            iZza3 += zzdx.zza((zzdw) entry2.getKey(), entry2.getValue());
        }
        return iZza2 + iZza3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int iZzs = zzs(i3);
            int[] iArr = this.zzc;
            int iZzr = zzr(iZzs);
            int i4 = iArr[i3];
            long j = iZzs & 1048575;
            int iFloatToIntBits = 37;
            switch (iZzr) {
                case 0:
                    i = i2 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzgz.zza(obj, j));
                    byte[] bArr = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i2 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzgz.zzb(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i2 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr2 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i2 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr3 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i2 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i2 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr4 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i2 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i2 * 53;
                    iFloatToIntBits = zzep.zza(zzgz.zzw(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i2 * 53;
                    iFloatToIntBits = ((String) zzgz.zzf(obj, j)).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 9:
                    i = i2 * 53;
                    Object objZzf = zzgz.zzf(obj, j);
                    if (objZzf != null) {
                        iFloatToIntBits = objZzf.hashCode();
                    }
                    i2 = i + iFloatToIntBits;
                    break;
                case 10:
                    i = i2 * 53;
                    iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i2 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i2 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i2 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i2 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr5 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i2 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i2 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr6 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 17:
                    i = i2 * 53;
                    Object objZzf2 = zzgz.zzf(obj, j);
                    if (objZzf2 != null) {
                        iFloatToIntBits = objZzf2.hashCode();
                    }
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
                    iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i2 * 53;
                    iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzep.zza(zzN(obj, j));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = ((String) zzgz.zzf(obj, j)).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode = (i2 * 53) + ((zzeh) obj).zzc.hashCode();
        return this.zzh ? (iHashCode * 53) + ((zzed) obj).zzb.zza.hashCode() : iHashCode;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x024b  */
    /* JADX WARN: Code duplicated, block: B:102:0x0253  */
    /* JADX WARN: Code duplicated, block: B:104:0x0257  */
    /* JADX WARN: Code duplicated, block: B:107:0x026b  */
    /* JADX WARN: Code duplicated, block: B:109:0x026f  */
    /* JADX WARN: Code duplicated, block: B:119:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:126:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:127:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:160:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:163:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:172:0x045a  */
    /* JADX WARN: Code duplicated, block: B:175:0x0465  */
    /* JADX WARN: Code duplicated, block: B:177:0x0471  */
    /* JADX WARN: Code duplicated, block: B:180:0x0478  */
    /* JADX WARN: Code duplicated, block: B:182:0x0488  */
    /* JADX WARN: Code duplicated, block: B:183:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:185:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:187:0x04b6 A[LOOP:3: B:186:0x04b4->B:187:0x04b6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:189:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:192:0x04db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:195:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:197:0x04fe A[LOOP:4: B:194:0x04f2->B:197:0x04fe, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:199:0x0511  */
    /* JADX WARN: Code duplicated, block: B:200:0x0519  */
    /* JADX WARN: Code duplicated, block: B:202:0x0522  */
    /* JADX WARN: Code duplicated, block: B:204:0x052f A[LOOP:5: B:203:0x052d->B:204:0x052f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:209:0x0546 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:210:0x0548  */
    /* JADX WARN: Code duplicated, block: B:212:0x055b  */
    /* JADX WARN: Code duplicated, block: B:214:0x0563 A[LOOP:6: B:211:0x0559->B:214:0x0563, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:217:0x0583  */
    /* JADX WARN: Code duplicated, block: B:219:0x058c  */
    /* JADX WARN: Code duplicated, block: B:220:0x0596 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:221:0x0598  */
    /* JADX WARN: Code duplicated, block: B:224:0x05b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:225:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:227:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:229:0x05d6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:230:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:232:0x05de  */
    /* JADX WARN: Code duplicated, block: B:236:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:237:0x05f5  */
    /* JADX WARN: Code duplicated, block: B:240:0x0605  */
    /* JADX WARN: Code duplicated, block: B:243:0x061d  */
    /* JADX WARN: Code duplicated, block: B:245:0x0633  */
    /* JADX WARN: Code duplicated, block: B:246:0x063a  */
    /* JADX WARN: Code duplicated, block: B:248:0x0646  */
    /* JADX WARN: Code duplicated, block: B:250:0x064e  */
    /* JADX WARN: Code duplicated, block: B:252:0x0652 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:253:0x0654  */
    /* JADX WARN: Code duplicated, block: B:254:0x065f  */
    /* JADX WARN: Code duplicated, block: B:257:0x066e  */
    /* JADX WARN: Code duplicated, block: B:259:0x0678  */
    /* JADX WARN: Code duplicated, block: B:261:0x0680  */
    /* JADX WARN: Code duplicated, block: B:263:0x0686 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:277:0x06d0  */
    /* JADX WARN: Code duplicated, block: B:279:0x06dc  */
    /* JADX WARN: Code duplicated, block: B:281:0x06ff  */
    /* JADX WARN: Code duplicated, block: B:283:0x0709  */
    /* JADX WARN: Code duplicated, block: B:285:0x0717  */
    /* JADX WARN: Code duplicated, block: B:287:0x0720  */
    /* JADX WARN: Code duplicated, block: B:289:0x0728 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:290:0x072a  */
    /* JADX WARN: Code duplicated, block: B:291:0x0730  */
    /* JADX WARN: Code duplicated, block: B:294:0x073f  */
    /* JADX WARN: Code duplicated, block: B:296:0x0747  */
    /* JADX WARN: Code duplicated, block: B:298:0x074f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:305:0x076c  */
    /* JADX WARN: Code duplicated, block: B:307:0x0776 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:308:0x0778  */
    /* JADX WARN: Code duplicated, block: B:309:0x077c  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:311:0x0784  */
    /* JADX WARN: Code duplicated, block: B:314:0x0794  */
    /* JADX WARN: Code duplicated, block: B:316:0x079c  */
    /* JADX WARN: Code duplicated, block: B:318:0x07a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:322:0x07b2  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:332:0x07df  */
    /* JADX WARN: Code duplicated, block: B:334:0x07ed  */
    /* JADX WARN: Code duplicated, block: B:336:0x07fa  */
    /* JADX WARN: Code duplicated, block: B:338:0x0804  */
    /* JADX WARN: Code duplicated, block: B:339:0x0806  */
    /* JADX WARN: Code duplicated, block: B:345:0x0818 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:346:0x081a  */
    /* JADX WARN: Code duplicated, block: B:348:0x0828  */
    /* JADX WARN: Code duplicated, block: B:349:0x082a  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:352:0x0831  */
    /* JADX WARN: Code duplicated, block: B:354:0x0839  */
    /* JADX WARN: Code duplicated, block: B:356:0x0843  */
    /* JADX WARN: Code duplicated, block: B:357:0x0845  */
    /* JADX WARN: Code duplicated, block: B:359:0x084b  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:361:0x0859  */
    /* JADX WARN: Code duplicated, block: B:363:0x0866 A[LOOP:14: B:362:0x0864->B:363:0x0866, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:368:0x087a  */
    /* JADX WARN: Code duplicated, block: B:370:0x087d  */
    /* JADX WARN: Code duplicated, block: B:372:0x088c  */
    /* JADX WARN: Code duplicated, block: B:374:0x0894 A[LOOP:15: B:371:0x088a->B:374:0x0894, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:375:0x089e  */
    /* JADX WARN: Code duplicated, block: B:377:0x08ac  */
    /* JADX WARN: Code duplicated, block: B:379:0x08b9 A[LOOP:16: B:378:0x08b7->B:379:0x08b9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:37:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:384:0x08cc  */
    /* JADX WARN: Code duplicated, block: B:386:0x08cf  */
    /* JADX WARN: Code duplicated, block: B:388:0x08de  */
    /* JADX WARN: Code duplicated, block: B:390:0x08e6 A[LOOP:17: B:387:0x08dc->B:390:0x08e6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:391:0x08f0  */
    /* JADX WARN: Code duplicated, block: B:393:0x08fe  */
    /* JADX WARN: Code duplicated, block: B:395:0x0907 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:396:0x0909  */
    /* JADX WARN: Code duplicated, block: B:398:0x091b  */
    /* JADX WARN: Code duplicated, block: B:400:0x092b  */
    /* JADX WARN: Code duplicated, block: B:402:0x0938 A[LOOP:18: B:401:0x0936->B:402:0x0938, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:407:0x094b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:408:0x094d  */
    /* JADX WARN: Code duplicated, block: B:410:0x095c  */
    /* JADX WARN: Code duplicated, block: B:412:0x0964 A[LOOP:19: B:409:0x095a->B:412:0x0964, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:413:0x096e  */
    /* JADX WARN: Code duplicated, block: B:415:0x097e  */
    /* JADX WARN: Code duplicated, block: B:417:0x098b A[LOOP:20: B:416:0x0989->B:417:0x098b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:422:0x09a2  */
    /* JADX WARN: Code duplicated, block: B:424:0x09a5  */
    /* JADX WARN: Code duplicated, block: B:426:0x09b8  */
    /* JADX WARN: Code duplicated, block: B:428:0x09c0 A[LOOP:21: B:425:0x09b6->B:428:0x09c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:429:0x09ce  */
    /* JADX WARN: Code duplicated, block: B:431:0x09de  */
    /* JADX WARN: Code duplicated, block: B:433:0x09eb A[LOOP:22: B:432:0x09e9->B:433:0x09eb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:438:0x0a03  */
    /* JADX WARN: Code duplicated, block: B:440:0x0a06  */
    /* JADX WARN: Code duplicated, block: B:442:0x0a19  */
    /* JADX WARN: Code duplicated, block: B:444:0x0a21 A[LOOP:23: B:441:0x0a17->B:444:0x0a21, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:446:0x0a31  */
    /* JADX WARN: Code duplicated, block: B:448:0x0a39 A[LOOP:2: B:445:0x0a2f->B:448:0x0a39, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:451:0x0a56 A[PHI: r7 r9 r10 r11 r12 r13 r19 r34
  0x0a56: PHI (r7v53 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu) = 
  (r7v35 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v36 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v37 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v47 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v58 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
 binds: [B:439:0x0a04, B:423:0x09a3, B:407:0x094b, B:282:0x0706, B:181:0x0486] A[DONT_GENERATE, DONT_INLINE]
  0x0a56: PHI (r9v76 int) = (r9v46 int), (r9v47 int), (r9v48 int), (r9v68 int), (r9v81 int) binds: [B:439:0x0a04, B:423:0x09a3, B:407:0x094b, B:282:0x0706, B:181:0x0486] A[DONT_GENERATE, DONT_INLINE]
  0x0a56: PHI (r10v63 int) = (r10v46 int), (r10v47 int), (r10v48 int), (r10v59 int), (r10v65 int) binds: [B:439:0x0a04, B:423:0x09a3, B:407:0x094b, B:282:0x0706, B:181:0x0486] A[DONT_GENERATE, DONT_INLINE]
  0x0a56: PHI (r11v50 int) = (r11v31 int), (r11v32 int), (r11v33 int), (r3v62 int), (r11v55 int) binds: [B:439:0x0a04, B:423:0x09a3, B:407:0x094b, B:282:0x0706, B:181:0x0486] A[DONT_GENERATE, DONT_INLINE]
  0x0a56: PHI (r12v48 int) = (r12v20 int), (r12v21 int), (r12v22 int), (r12v37 int), (r12v52 int) binds: [B:439:0x0a04, B:423:0x09a3, B:407:0x094b, B:282:0x0706, B:181:0x0486] A[DONT_GENERATE, DONT_INLINE]
  0x0a56: PHI (r13v67 int) = (r13v37 int), (r13v38 int), (r13v39 int), (r13v57 int), (r13v73 int) binds: [B:439:0x0a04, B:423:0x09a3, B:407:0x094b, B:282:0x0706, B:181:0x0486] A[DONT_GENERATE, DONT_INLINE]
  0x0a56: PHI (r19v52 int) = (r19v26 int), (r19v27 int), (r19v28 int), (r19v43 int), (r19v55 int) binds: [B:439:0x0a04, B:423:0x09a3, B:407:0x094b, B:282:0x0706, B:181:0x0486] A[DONT_GENERATE, DONT_INLINE]
  0x0a56: PHI (r34v29 sun.misc.Unsafe) = 
  (r34v8 sun.misc.Unsafe)
  (r34v9 sun.misc.Unsafe)
  (r34v10 sun.misc.Unsafe)
  (r34v23 sun.misc.Unsafe)
  (r34v33 sun.misc.Unsafe)
 binds: [B:439:0x0a04, B:423:0x09a3, B:407:0x094b, B:282:0x0706, B:181:0x0486] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:462:0x0aa4  */
    /* JADX WARN: Code duplicated, block: B:465:0x0ab5  */
    /* JADX WARN: Code duplicated, block: B:467:0x0ac1  */
    /* JADX WARN: Code duplicated, block: B:469:0x0ad6 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:470:0x0ae2  */
    /* JADX WARN: Code duplicated, block: B:472:0x0ae5  */
    /* JADX WARN: Code duplicated, block: B:473:0x0b0c  */
    /* JADX WARN: Code duplicated, block: B:475:0x0b13  */
    /* JADX WARN: Code duplicated, block: B:476:0x0b32  */
    /* JADX WARN: Code duplicated, block: B:477:0x0b3d  */
    /* JADX WARN: Code duplicated, block: B:479:0x0b46  */
    /* JADX WARN: Code duplicated, block: B:480:0x0b5d  */
    /* JADX WARN: Code duplicated, block: B:481:0x0b69  */
    /* JADX WARN: Code duplicated, block: B:483:0x0b72  */
    /* JADX WARN: Code duplicated, block: B:489:0x0b93  */
    /* JADX WARN: Code duplicated, block: B:490:0x0b9e  */
    /* JADX WARN: Code duplicated, block: B:491:0x0ba1  */
    /* JADX WARN: Code duplicated, block: B:493:0x0bac  */
    /* JADX WARN: Code duplicated, block: B:495:0x0bc1  */
    /* JADX WARN: Code duplicated, block: B:497:0x0bcb  */
    /* JADX WARN: Code duplicated, block: B:498:0x0bf0 A[PHI: r4 r5 r7 r10 r11
  0x0bf0: PHI (r4v52 int) = (r4v49 int), (r4v51 int), (r4v53 int) binds: [B:496:0x0bc9, B:492:0x0baa, B:490:0x0b9e] A[DONT_GENERATE, DONT_INLINE]
  0x0bf0: PHI (r5v41 java.lang.Object) = (r5v38 java.lang.Object), (r5v40 java.lang.Object), (r5v42 java.lang.Object) binds: [B:496:0x0bc9, B:492:0x0baa, B:490:0x0b9e] A[DONT_GENERATE, DONT_INLINE]
  0x0bf0: PHI (r7v22 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu) = 
  (r7v20 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v21 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v23 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
 binds: [B:496:0x0bc9, B:492:0x0baa, B:490:0x0b9e] A[DONT_GENERATE, DONT_INLINE]
  0x0bf0: PHI (r10v31 int) = (r10v29 int), (r10v30 int), (r10v32 int) binds: [B:496:0x0bc9, B:492:0x0baa, B:490:0x0b9e] A[DONT_GENERATE, DONT_INLINE]
  0x0bf0: PHI (r11v19 int) = (r11v17 int), (r11v18 int), (r11v20 int) binds: [B:496:0x0bc9, B:492:0x0baa, B:490:0x0b9e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:501:0x0bfe  */
    /* JADX WARN: Code duplicated, block: B:503:0x0c0f  */
    /* JADX WARN: Code duplicated, block: B:505:0x0c17  */
    /* JADX WARN: Code duplicated, block: B:506:0x0c1f  */
    /* JADX WARN: Code duplicated, block: B:515:0x0c45  */
    /* JADX WARN: Code duplicated, block: B:516:0x0c49  */
    /* JADX WARN: Code duplicated, block: B:518:0x0c59  */
    /* JADX WARN: Code duplicated, block: B:520:0x0c63  */
    /* JADX WARN: Code duplicated, block: B:521:0x0c66  */
    /* JADX WARN: Code duplicated, block: B:523:0x0c74  */
    /* JADX WARN: Code duplicated, block: B:525:0x0c85  */
    /* JADX WARN: Code duplicated, block: B:526:0x0c97  */
    /* JADX WARN: Code duplicated, block: B:528:0x0ca8  */
    /* JADX WARN: Code duplicated, block: B:529:0x0cba  */
    /* JADX WARN: Code duplicated, block: B:531:0x0cca  */
    /* JADX WARN: Code duplicated, block: B:532:0x0cdc  */
    /* JADX WARN: Code duplicated, block: B:534:0x0cec  */
    /* JADX WARN: Code duplicated, block: B:535:0x0cfd  */
    /* JADX WARN: Code duplicated, block: B:537:0x0d0e  */
    /* JADX WARN: Code duplicated, block: B:538:0x0d23  */
    /* JADX WARN: Code duplicated, block: B:540:0x0d34  */
    /* JADX WARN: Code duplicated, block: B:541:0x0d49 A[PHI: r6 r7 r10 r14 r21 r23
  0x0d49: PHI (r6v67 java.lang.Object) = 
  (r6v43 java.lang.Object)
  (r6v44 java.lang.Object)
  (r6v45 java.lang.Object)
  (r6v46 java.lang.Object)
  (r6v47 java.lang.Object)
  (r6v48 java.lang.Object)
  (r6v49 java.lang.Object)
  (r6v50 java.lang.Object)
  (r6v62 java.lang.Object)
  (r6v68 java.lang.Object)
 binds: [B:539:0x0d32, B:536:0x0d0c, B:533:0x0cea, B:530:0x0cc8, B:527:0x0ca6, B:524:0x0c83, B:517:0x0c57, B:515:0x0c45, B:500:0x0bf9, B:469:0x0ad6] A[DONT_GENERATE, DONT_INLINE]
  0x0d49: PHI (r7v33 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu) = 
  (r7v12 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v13 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v14 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v15 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v16 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v17 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v18 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v19 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v25 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r7v34 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
 binds: [B:539:0x0d32, B:536:0x0d0c, B:533:0x0cea, B:530:0x0cc8, B:527:0x0ca6, B:524:0x0c83, B:517:0x0c57, B:515:0x0c45, B:500:0x0bf9, B:469:0x0ad6] A[DONT_GENERATE, DONT_INLINE]
  0x0d49: PHI (r10v44 int) = 
  (r10v21 int)
  (r10v22 int)
  (r10v23 int)
  (r10v24 int)
  (r10v25 int)
  (r10v26 int)
  (r10v27 int)
  (r10v28 int)
  (r10v34 int)
  (r10v45 int)
 binds: [B:539:0x0d32, B:536:0x0d0c, B:533:0x0cea, B:530:0x0cc8, B:527:0x0ca6, B:524:0x0c83, B:517:0x0c57, B:515:0x0c45, B:500:0x0bf9, B:469:0x0ad6] A[DONT_GENERATE, DONT_INLINE]
  0x0d49: PHI (r14v58 int) = 
  (r14v38 int)
  (r14v39 int)
  (r14v40 int)
  (r14v41 int)
  (r14v42 int)
  (r14v43 int)
  (r14v44 int)
  (r14v45 int)
  (r14v51 int)
  (r14v59 int)
 binds: [B:539:0x0d32, B:536:0x0d0c, B:533:0x0cea, B:530:0x0cc8, B:527:0x0ca6, B:524:0x0c83, B:517:0x0c57, B:515:0x0c45, B:500:0x0bf9, B:469:0x0ad6] A[DONT_GENERATE, DONT_INLINE]
  0x0d49: PHI (r21v26 int) = 
  (r21v10 int)
  (r21v11 int)
  (r21v12 int)
  (r21v13 int)
  (r21v14 int)
  (r21v15 int)
  (r21v16 int)
  (r21v17 int)
  (r21v21 int)
  (r21v27 int)
 binds: [B:539:0x0d32, B:536:0x0d0c, B:533:0x0cea, B:530:0x0cc8, B:527:0x0ca6, B:524:0x0c83, B:517:0x0c57, B:515:0x0c45, B:500:0x0bf9, B:469:0x0ad6] A[DONT_GENERATE, DONT_INLINE]
  0x0d49: PHI (r23v24 int) = 
  (r23v8 int)
  (r23v9 int)
  (r23v10 int)
  (r23v11 int)
  (r23v12 int)
  (r23v13 int)
  (r23v14 int)
  (r23v15 int)
  (r23v20 int)
  (r23v25 int)
 binds: [B:539:0x0d32, B:536:0x0d0c, B:533:0x0cea, B:530:0x0cc8, B:527:0x0ca6, B:524:0x0c83, B:517:0x0c57, B:515:0x0c45, B:500:0x0bf9, B:469:0x0ad6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:551:0x0d7a  */
    /* JADX WARN: Code duplicated, block: B:553:0x0d84  */
    /* JADX WARN: Code duplicated, block: B:555:0x0d90  */
    /* JADX WARN: Code duplicated, block: B:556:0x0daa  */
    /* JADX WARN: Code duplicated, block: B:557:0x0dca  */
    /* JADX WARN: Code duplicated, block: B:57:0x017d  */
    /* JADX WARN: Code duplicated, block: B:589:0x00c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:590:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:591:0x013c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:0x0158 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:0x018d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:0x01a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:0x01cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:596:0x02ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x030c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x0321 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x0339 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:600:0x0350 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:0x0377 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:0x038e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:0x03e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x04d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x0540 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:0x06c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x06bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x06a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x069f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x0766 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x0760 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x07d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x07cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x07c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x07bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x0812 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x0874 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x08c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x0945 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x099c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:0x09fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x0a5d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x0a8f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x0d4c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x0d61 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x0185 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:0x019c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x02e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x0305 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x031a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x0333 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:0x034a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:0x0370 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:641:0x0387 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:642:0x03ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:0x03e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:0x0445 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:0x0a8c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:0x03ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:0x03ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:0x043d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x042d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x03c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x02dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x02c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:0x02a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:0x0243 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x0265 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:0x0292 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:0x03ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:0x03ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:0x03ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:0x03ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:0x03ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:0x0a79 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:670:0x0a6a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:682:0x0a4c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:684:0x050e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:685:0x0571 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:688:0x0571 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:692:0x0615 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:695:0x05ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:698:0x06ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:699:0x0690 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:700:0x0688 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:706:0x0902 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:707:0x0755 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:708:0x0751 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:714:0x0902 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:715:0x07aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:716:0x07a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:724:0x0902 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:730:0x0902 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:733:0x0902 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:736:0x0918 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:739:0x0918 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:742:0x0918 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:743:0x0208 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:750:0x0229 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:751:0x0229 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x01db  */
    /* JADX WARN: Code duplicated, block: B:76:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:78:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:82:0x0200 A[LOOP:24: B:79:0x01f6->B:82:0x0200, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:84:0x020a  */
    /* JADX WARN: Code duplicated, block: B:86:0x0214  */
    /* JADX WARN: Code duplicated, block: B:89:0x021b  */
    /* JADX WARN: Code duplicated, block: B:91:0x0223 A[LOOP:26: B:87:0x0217->B:91:0x0223, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:94:0x0231  */
    /* JADX WARN: Code duplicated, block: B:96:0x0237 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x0239  */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzcu zzcuVar) throws IOException {
        Object obj2;
        Unsafe unsafe;
        int i4;
        int i5;
        int i6;
        int iZzk;
        int i7;
        int i8;
        int iZzq;
        int i9;
        int i10;
        Object obj3;
        int i11;
        int i12;
        int i13;
        zzcu zzcuVar2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Object obj4;
        zzds zzdsVar;
        zzgs zzgsVar;
        zzef zzefVarZzb;
        int i19;
        int[] iArr;
        int i20;
        int i21;
        int iZzr;
        long j;
        String str;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int iZzm;
        Unsafe unsafe2;
        int i28;
        int iZzm2;
        int i29;
        boolean z;
        int i30;
        int i31;
        int i32;
        int i33;
        int length;
        int i34;
        char[] cArr;
        int i35;
        int i36;
        int i37;
        byte b;
        int i38;
        int i39;
        String str2;
        byte b2;
        byte b3;
        int i40;
        int i41;
        int i42;
        int i43;
        Unsafe unsafe3;
        int i44;
        int i45;
        int i46;
        Unsafe unsafe4;
        Object object;
        Object obj5;
        Unsafe unsafe5;
        long j2;
        int i47;
        boolean z2;
        int iZzj;
        int i48;
        int i49;
        Object obj6;
        int i50;
        int i51;
        int iZza;
        Object obj7;
        int i52;
        zzel zzelVarZzu;
        long j3;
        Unsafe unsafe6;
        zzeo zzeoVar;
        int i53;
        int i54;
        int i55;
        int i56;
        zzdp zzdpVar;
        int iZzj2;
        zzdp zzdpVar2;
        int i57;
        zzdz zzdzVar;
        int iZzj3;
        zzdz zzdzVar2;
        int i58;
        zzfb zzfbVar;
        int iZzj4;
        zzfb zzfbVar2;
        int i59;
        int i60;
        int iZzg;
        zzfb zzfbVar3;
        int iZzj5;
        zzfb zzfbVar4;
        int i61;
        zzei zzeiVar;
        int iZzj6;
        zzei zzeiVar2;
        int i62;
        zzcw zzcwVar;
        boolean z3;
        int iZzj7;
        boolean z4;
        zzcw zzcwVar2;
        int i63;
        boolean z5;
        int i64;
        int i65;
        int iZzj8;
        int i66;
        int i67;
        int i68;
        Object obj8;
        int iZzj9;
        int i69;
        zzcu zzcuVar3;
        int i70;
        int i71;
        int iZzj10;
        int i72;
        int iZzj11;
        int i73;
        int iZzj12;
        int iZzj13;
        int i74;
        int iZzl;
        zzel zzelVarZzu2;
        zzgs zzgsVar2;
        int i75;
        int i76;
        Iterator it2;
        Object objZzn;
        int iIntValue;
        int size;
        Object objZzn2;
        int i77;
        int i78;
        Integer num;
        int iIntValue2;
        int i79;
        zzei zzeiVar3;
        int iZzj14;
        zzei zzeiVar4;
        int i80;
        zzfb zzfbVar5;
        int iZzj15;
        zzfb zzfbVar6;
        int i81;
        int i82;
        zzge zzgeVarZzv;
        int iZzj16;
        zzeo zzeoVarZzd;
        Object obj9 = obj;
        byte[] bArr2 = bArr;
        int i83 = i2;
        int i84 = i3;
        zzcu zzcuVar4 = zzcuVar;
        zzA(obj);
        Unsafe unsafe7 = zzb;
        int i85 = 0;
        int iZzi = i;
        int i86 = 0;
        int i87 = 0;
        int i88 = 0;
        int i89 = -1;
        int i90 = 1048575;
        while (true) {
            if (iZzi < i83) {
                int i91 = iZzi + 1;
                byte b4 = bArr2[iZzi];
                if (b4 < 0) {
                    iZzk = zzcv.zzk(b4, bArr2, i91, zzcuVar4);
                    i6 = zzcuVar4.zza;
                } else {
                    i6 = b4;
                    iZzk = i91;
                }
                int i92 = i6 >>> 3;
                if (i92 > i89) {
                    iZzq = (i92 < this.zze || i92 > this.zzf) ? -1 : zzq(i92, i86 / 3);
                } else {
                    if (i92 < this.zze || i92 > this.zzf) {
                        i7 = -1;
                        i8 = -1;
                    } else {
                        iZzq = zzq(i92, i85);
                    }
                    if (i8 == i7) {
                        i9 = iZzk;
                        i90 = i90;
                        i10 = i88;
                        obj3 = obj9;
                        i11 = i92;
                        i12 = i85;
                        i13 = i12;
                        unsafe = unsafe7;
                        zzcuVar2 = zzcuVar4;
                        i14 = i84;
                        i15 = i6;
                    } else {
                        i19 = i6 & 7;
                        iArr = this.zzc;
                        i20 = iArr[i8 + 1];
                        i21 = i6;
                        iZzr = zzr(i20);
                        j = i20 & 1048575;
                        i89 = i92;
                        str = "Protocol message had invalid UTF-8.";
                        if (iZzr <= 17) {
                            int i93 = iArr[i8 + 2];
                            i22 = 1 << (i93 >>> 20);
                            i23 = i93 & 1048575;
                            if (i23 != i90) {
                                if (i90 != 1048575) {
                                    unsafe7.putInt(obj9, i90, i88);
                                }
                                if (i23 == 1048575) {
                                    i88 = 0;
                                } else {
                                    i88 = unsafe7.getInt(obj9, i23);
                                }
                                i90 = i23;
                            } else {
                                i90 = i90;
                            }
                            switch (iZzr) {
                                case 0:
                                    i24 = i8;
                                    i9 = iZzk;
                                    if (i19 == 1) {
                                        iZzi = i9 + 8;
                                        i26 = i88 | i22;
                                        zzgz.zzo(obj9, j, Double.longBitsToDouble(zzcv.zzq(bArr2, i9)));
                                        i40 = i26;
                                        i88 = i40;
                                        i84 = i3;
                                        i86 = i24;
                                        i90 = i90;
                                        i87 = i21;
                                        i89 = i89;
                                        i85 = 0;
                                        i83 = i2;
                                    } else {
                                        i29 = i24;
                                        i12 = 0;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                                case 1:
                                    i24 = i8;
                                    i9 = iZzk;
                                    if (i19 == 5) {
                                        iZzi = i9 + 4;
                                        i26 = i88 | i22;
                                        zzgz.zzp(obj9, j, Float.intBitsToFloat(zzcv.zzc(bArr2, i9)));
                                        i40 = i26;
                                        i88 = i40;
                                        i84 = i3;
                                        i86 = i24;
                                        i90 = i90;
                                        i87 = i21;
                                        i89 = i89;
                                        i85 = 0;
                                        i83 = i2;
                                    } else {
                                        i29 = i24;
                                        i12 = 0;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    i24 = i8;
                                    i9 = iZzk;
                                    if (i19 == 0) {
                                        i27 = i88 | i22;
                                        iZzm = zzcv.zzm(bArr2, i9, zzcuVar4);
                                        unsafe7.putLong(obj, j, zzcuVar4.zzb);
                                        i88 = i27;
                                        unsafe2 = unsafe7;
                                        zzcuVar2 = zzcuVar4;
                                        i28 = i24;
                                        i12 = 0;
                                        iZzm2 = iZzm;
                                        i83 = i2;
                                        i84 = i3;
                                        zzcuVar4 = zzcuVar2;
                                        unsafe7 = unsafe2;
                                        i86 = i28;
                                        iZzi = iZzm2;
                                        i90 = i90;
                                        i87 = i21;
                                        i85 = i12;
                                    } else {
                                        i29 = i24;
                                        i12 = 0;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    i24 = i8;
                                    i9 = iZzk;
                                    if (i19 == 0) {
                                        int iZzj17 = zzcv.zzj(bArr2, i9, zzcuVar4);
                                        unsafe7.putInt(obj9, j, zzcuVar4.zza);
                                        i26 = i88 | i22;
                                        iZzi = iZzj17;
                                        i40 = i26;
                                        i88 = i40;
                                        i84 = i3;
                                        i86 = i24;
                                        i90 = i90;
                                        i87 = i21;
                                        i89 = i89;
                                        i85 = 0;
                                        i83 = i2;
                                    } else {
                                        i29 = i24;
                                        i12 = 0;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    i24 = i8;
                                    i9 = iZzk;
                                    if (i19 == 1) {
                                        iZzm = i9 + 8;
                                        i27 = i88 | i22;
                                        unsafe7.putLong(obj, j, zzcv.zzq(bArr2, i9));
                                        i88 = i27;
                                        unsafe2 = unsafe7;
                                        zzcuVar2 = zzcuVar4;
                                        i28 = i24;
                                        i12 = 0;
                                        iZzm2 = iZzm;
                                        i83 = i2;
                                        i84 = i3;
                                        zzcuVar4 = zzcuVar2;
                                        unsafe7 = unsafe2;
                                        i86 = i28;
                                        iZzi = iZzm2;
                                        i90 = i90;
                                        i87 = i21;
                                        i85 = i12;
                                    } else {
                                        i29 = i24;
                                        i12 = 0;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    i24 = i8;
                                    i9 = iZzk;
                                    if (i19 == 5) {
                                        iZzi = i9 + 4;
                                        unsafe7.putInt(obj9, j, zzcv.zzc(bArr2, i9));
                                        i88 |= i22;
                                        i84 = i3;
                                        i86 = i24;
                                        i90 = i90;
                                        i87 = i21;
                                        i89 = i89;
                                        i85 = 0;
                                        i83 = i2;
                                    } else {
                                        i29 = i24;
                                        i12 = 0;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                                case 7:
                                    i24 = i8;
                                    i9 = iZzk;
                                    if (i19 == 0) {
                                        int i94 = i88 | i22;
                                        int iZzm3 = zzcv.zzm(bArr2, i9, zzcuVar4);
                                        if (zzcuVar4.zzb != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        zzgz.zzm(obj9, j, z);
                                        i88 = i94;
                                        iZzi = iZzm3;
                                        i84 = i3;
                                        i86 = i24;
                                        i90 = i90;
                                        i87 = i21;
                                        i89 = i89;
                                        i85 = 0;
                                        i83 = i2;
                                    } else {
                                        i29 = i24;
                                        i12 = 0;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                                case 8:
                                    i24 = i8;
                                    i30 = i21;
                                    i9 = iZzk;
                                    if (i19 == 2) {
                                        if ((i20 & 536870912) != 0) {
                                            iZzi = zzcv.zzj(bArr2, i9, zzcuVar4);
                                            i32 = zzcuVar4.zza;
                                            if (i32 >= 0) {
                                                throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            i33 = i88 | i22;
                                            if (i32 == 0) {
                                                zzcuVar4.zzc = "";
                                                i36 = i33;
                                                i21 = i30;
                                            } else {
                                                length = bArr2.length;
                                                int i95 = zzhe.zza;
                                                if ((iZzi | i32 | ((length - iZzi) - i32)) >= 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzi), Integer.valueOf(i32)));
                                                }
                                                i34 = iZzi + i32;
                                                cArr = new char[i32];
                                                i35 = 0;
                                                while (iZzi < i34) {
                                                    b3 = bArr2[iZzi];
                                                    if (zzha.zzd(b3)) {
                                                        iZzi++;
                                                        cArr[i35] = (char) b3;
                                                        i35++;
                                                    } else {
                                                        while (iZzi < i34) {
                                                            i37 = iZzi + 1;
                                                            b = bArr2[iZzi];
                                                            if (zzha.zzd(b)) {
                                                                cArr[i35] = (char) b;
                                                                while (true) {
                                                                    i35++;
                                                                    if (i37 < i34) {
                                                                        b2 = bArr2[i37];
                                                                        if (zzha.zzd(b2)) {
                                                                            i37++;
                                                                            cArr[i35] = (char) b2;
                                                                        }
                                                                    }
                                                                }
                                                                i38 = i33;
                                                                iZzi = i37;
                                                            } else {
                                                                i38 = i33;
                                                                if (b < -32) {
                                                                    i39 = i30;
                                                                    str2 = str;
                                                                    if (b < -16) {
                                                                        if (i37 < i34 - 1) {
                                                                            throw new zzer(str2);
                                                                        }
                                                                        zzha.zzb(b, bArr2[i37], bArr2[iZzi + 2], cArr, i35);
                                                                        i35++;
                                                                        iZzi += 3;
                                                                    } else {
                                                                        if (i37 < i34 - 2) {
                                                                            throw new zzer(str2);
                                                                        }
                                                                        zzha.zza(b, bArr2[i37], bArr2[iZzi + 2], bArr2[iZzi + 3], cArr, i35);
                                                                        i35 += 2;
                                                                        iZzi += 4;
                                                                    }
                                                                } else {
                                                                    if (i37 < i34) {
                                                                        throw new zzer(str);
                                                                    }
                                                                    iZzi += 2;
                                                                    zzha.zzc(b, bArr2[i37], cArr, i35);
                                                                    i35++;
                                                                }
                                                                str = str2;
                                                                i33 = i38;
                                                                i30 = i39;
                                                            }
                                                            i39 = i30;
                                                            str2 = str;
                                                            str = str2;
                                                            i33 = i38;
                                                            i30 = i39;
                                                        }
                                                        i36 = i33;
                                                        i21 = i30;
                                                        zzcuVar4.zzc = new String(cArr, 0, i35);
                                                        iZzi = i34;
                                                    }
                                                }
                                                while (iZzi < i34) {
                                                    i37 = iZzi + 1;
                                                    b = bArr2[iZzi];
                                                    if (zzha.zzd(b)) {
                                                        cArr[i35] = (char) b;
                                                        while (true) {
                                                            i35++;
                                                            if (i37 < i34) {
                                                                b2 = bArr2[i37];
                                                                if (zzha.zzd(b2)) {
                                                                    i37++;
                                                                    cArr[i35] = (char) b2;
                                                                }
                                                            }
                                                        }
                                                        i38 = i33;
                                                        iZzi = i37;
                                                    } else {
                                                        i38 = i33;
                                                        if (b < -32) {
                                                            i39 = i30;
                                                            str2 = str;
                                                            if (b < -16) {
                                                                if (i37 < i34 - 1) {
                                                                    throw new zzer(str2);
                                                                }
                                                                zzha.zzb(b, bArr2[i37], bArr2[iZzi + 2], cArr, i35);
                                                                i35++;
                                                                iZzi += 3;
                                                            } else {
                                                                if (i37 < i34 - 2) {
                                                                    throw new zzer(str2);
                                                                }
                                                                zzha.zza(b, bArr2[i37], bArr2[iZzi + 2], bArr2[iZzi + 3], cArr, i35);
                                                                i35 += 2;
                                                                iZzi += 4;
                                                            }
                                                        } else {
                                                            if (i37 < i34) {
                                                                throw new zzer(str);
                                                            }
                                                            iZzi += 2;
                                                            zzha.zzc(b, bArr2[i37], cArr, i35);
                                                            i35++;
                                                        }
                                                        str = str2;
                                                        i33 = i38;
                                                        i30 = i39;
                                                    }
                                                    i39 = i30;
                                                    str2 = str;
                                                    str = str2;
                                                    i33 = i38;
                                                    i30 = i39;
                                                }
                                                i36 = i33;
                                                i21 = i30;
                                                zzcuVar4.zzc = new String(cArr, 0, i35);
                                                iZzi = i34;
                                            }
                                            i31 = i36;
                                        } else {
                                            i21 = i30;
                                            iZzi = zzcv.zzh(bArr2, i9, zzcuVar4);
                                            i31 = i88 | i22;
                                        }
                                        unsafe7.putObject(obj9, j, zzcuVar4.zzc);
                                        i88 = i31;
                                        i84 = i3;
                                        i86 = i24;
                                        i90 = i90;
                                        i87 = i21;
                                        i89 = i89;
                                        i85 = 0;
                                        i83 = i2;
                                    } else {
                                        i21 = i30;
                                        i29 = i24;
                                        i12 = 0;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                                case 9:
                                    i24 = i8;
                                    i30 = i21;
                                    if (i19 == 2) {
                                        i40 = i88 | i22;
                                        Object objZzx = zzx(obj9, i24);
                                        iZzi = zzcv.zzo(objZzx, zzv(i24), bArr, iZzk, i2, zzcuVar);
                                        zzF(obj9, i24, objZzx);
                                        i21 = i30;
                                        i88 = i40;
                                        i84 = i3;
                                        i86 = i24;
                                        i90 = i90;
                                        i87 = i21;
                                        i89 = i89;
                                        i85 = 0;
                                        i83 = i2;
                                    } else {
                                        i9 = iZzk;
                                        i21 = i30;
                                        i29 = i24;
                                        i12 = 0;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                                case 10:
                                    i24 = i8;
                                    i30 = i21;
                                    if (i19 == 2) {
                                        i88 |= i22;
                                        iZzi = zzcv.zza(bArr2, iZzk, zzcuVar4);
                                        unsafe7.putObject(obj9, j, zzcuVar4.zzc);
                                        i21 = i30;
                                        i84 = i3;
                                        i86 = i24;
                                        i90 = i90;
                                        i87 = i21;
                                        i89 = i89;
                                        i85 = 0;
                                        i83 = i2;
                                    } else {
                                        i9 = iZzk;
                                        i21 = i30;
                                        i29 = i24;
                                        i12 = 0;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                                case 12:
                                    i24 = i8;
                                    i30 = i21;
                                    if (i19 == 0) {
                                        iZzi = zzcv.zzj(bArr2, iZzk, zzcuVar4);
                                        i41 = zzcuVar4.zza;
                                        zzel zzelVarZzu3 = zzu(i24);
                                        if ((Integer.MIN_VALUE & i20) != 0 || zzelVarZzu3 == null || zzelVarZzu3.zza(i41)) {
                                            i88 |= i22;
                                            unsafe7.putInt(obj9, j, i41);
                                        } else {
                                            zzd(obj).zzj(i30, Long.valueOf(i41));
                                        }
                                        i21 = i30;
                                        i84 = i3;
                                        i86 = i24;
                                        i90 = i90;
                                        i87 = i21;
                                        i89 = i89;
                                        i85 = 0;
                                        i83 = i2;
                                    } else {
                                        i9 = iZzk;
                                        i21 = i30;
                                        i29 = i24;
                                        i12 = 0;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                                case 15:
                                    i24 = i8;
                                    i30 = i21;
                                    if (i19 == 0) {
                                        i26 = i88 | i22;
                                        iZzi = zzcv.zzj(bArr2, iZzk, zzcuVar4);
                                        unsafe7.putInt(obj9, j, zzdj.zzb(zzcuVar4.zza));
                                        i21 = i30;
                                        i40 = i26;
                                        i88 = i40;
                                        i84 = i3;
                                        i86 = i24;
                                        i90 = i90;
                                        i87 = i21;
                                        i89 = i89;
                                        i85 = 0;
                                        i83 = i2;
                                    } else {
                                        i9 = iZzk;
                                        i21 = i30;
                                        i29 = i24;
                                        i12 = 0;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                                case 16:
                                    if (i19 == 0) {
                                        iZzm2 = zzcv.zzm(bArr2, iZzk, zzcuVar4);
                                        unsafe7.putLong(obj, j, zzdj.zzc(zzcuVar4.zzb));
                                        i88 |= i22;
                                        unsafe2 = unsafe7;
                                        zzcuVar2 = zzcuVar4;
                                        i28 = i8;
                                        i12 = 0;
                                        i83 = i2;
                                        i84 = i3;
                                        zzcuVar4 = zzcuVar2;
                                        unsafe7 = unsafe2;
                                        i86 = i28;
                                        iZzi = iZzm2;
                                        i90 = i90;
                                        i87 = i21;
                                        i85 = i12;
                                    } else {
                                        i29 = i8;
                                        unsafe7 = unsafe7;
                                        i89 = i89;
                                        i12 = 0;
                                        i9 = iZzk;
                                        zzcuVar4 = zzcuVar4;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                                default:
                                    i24 = i8;
                                    i9 = iZzk;
                                    if (i19 == 3) {
                                        Object objZzx2 = zzx(obj9, i24);
                                        i12 = 0;
                                        int iZzn = zzcv.zzn(objZzx2, zzv(i24), bArr, i9, i2, (i89 << 3) | 4, zzcuVar);
                                        zzF(obj9, i24, objZzx2);
                                        int i96 = i88 | i22;
                                        unsafe = unsafe7;
                                        i11 = i89;
                                        i13 = i24;
                                        obj3 = obj9;
                                        i90 = i90;
                                        i25 = i21;
                                        i10 = i96;
                                        zzcuVar2 = zzcuVar4;
                                        iZzi = iZzn;
                                        i84 = i3;
                                        zzcuVar4 = zzcuVar2;
                                        i89 = i11;
                                        i85 = i12;
                                        i87 = i25;
                                        i86 = i13;
                                        unsafe7 = unsafe;
                                        i83 = i2;
                                        obj9 = obj3;
                                        i88 = i10;
                                    } else {
                                        i29 = i24;
                                        i12 = 0;
                                        unsafe = unsafe7;
                                        i14 = i3;
                                        i11 = i89;
                                        i13 = i29;
                                        i15 = i21;
                                        i10 = i88;
                                        obj3 = obj9;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                    break;
                            }
                        } else {
                            i90 = i90;
                            i42 = i88;
                            i12 = 0;
                            i28 = i8;
                            i43 = iZzk;
                            zzcuVar2 = zzcuVar4;
                            unsafe3 = unsafe7;
                            if (iZzr == 27) {
                                if (iZzr <= 49) {
                                    j3 = i20;
                                    unsafe6 = zzb;
                                    zzeoVar = (zzeo) unsafe6.getObject(obj9, j);
                                    if (zzeoVar.zzc()) {
                                        int size2 = zzeoVar.size();
                                        zzeo zzeoVarZzd2 = zzeoVar.zzd(size2 != 0 ? size2 + size2 : 10);
                                        unsafe6.putObject(obj9, j, zzeoVarZzd2);
                                        zzeoVar = zzeoVarZzd2;
                                    }
                                    switch (iZzr) {
                                        case 18:
                                        case 35:
                                            i53 = i2;
                                            zzcuVar2 = zzcuVar2;
                                            i43 = i43;
                                            i54 = i89;
                                            i55 = i21;
                                            i56 = i28;
                                            i88 = i42;
                                            unsafe = unsafe3;
                                            if (i19 == 2) {
                                                if (i19 == 1) {
                                                    iZzi = i43 + 8;
                                                    int i97 = zzcv.zza;
                                                    zzdpVar = (zzdp) zzeoVar;
                                                    zzdpVar.zzf(Double.longBitsToDouble(zzcv.zzq(bArr2, i43)));
                                                    while (iZzi < i53) {
                                                        iZzj2 = zzcv.zzj(bArr2, iZzi, zzcuVar2);
                                                        if (i55 == zzcuVar2.zza) {
                                                            zzdpVar.zzf(Double.longBitsToDouble(zzcv.zzq(bArr2, iZzj2)));
                                                            iZzi = iZzj2 + 8;
                                                        }
                                                    }
                                                } else {
                                                    i87 = i55;
                                                    iZzi = i43;
                                                }
                                                i86 = i56;
                                                i90 = i90;
                                                i88 = i88;
                                                if (iZzi != i43) {
                                                    zzcuVar4 = zzcuVar2;
                                                    i89 = i54;
                                                    i83 = i53;
                                                    i85 = 0;
                                                    unsafe7 = unsafe;
                                                    obj9 = obj;
                                                    i84 = i3;
                                                } else {
                                                    i14 = i3;
                                                    i13 = i86;
                                                    i15 = i87;
                                                    i90 = i90;
                                                    i10 = i88;
                                                    i11 = i54;
                                                    obj3 = obj;
                                                    i9 = iZzi;
                                                }
                                            } else {
                                                int i98 = zzcv.zza;
                                                zzdpVar2 = (zzdp) zzeoVar;
                                                iZzi = zzcv.zzj(bArr2, i43, zzcuVar2);
                                                i57 = zzcuVar2.zza + iZzi;
                                                while (iZzi < i57) {
                                                    zzdpVar2.zzf(Double.longBitsToDouble(zzcv.zzq(bArr2, iZzi)));
                                                    iZzi += 8;
                                                }
                                                if (iZzi != i57) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i87 = i55;
                                            i86 = i56;
                                            i90 = i90;
                                            i88 = i88;
                                            if (iZzi != i43) {
                                                zzcuVar4 = zzcuVar2;
                                                i89 = i54;
                                                i83 = i53;
                                                i85 = 0;
                                                unsafe7 = unsafe;
                                                obj9 = obj;
                                                i84 = i3;
                                            } else {
                                                i14 = i3;
                                                i13 = i86;
                                                i15 = i87;
                                                i90 = i90;
                                                i10 = i88;
                                                i11 = i54;
                                                obj3 = obj;
                                                i9 = iZzi;
                                            }
                                            break;
                                        case 19:
                                        case 36:
                                            i53 = i2;
                                            zzcuVar2 = zzcuVar2;
                                            i43 = i43;
                                            i54 = i89;
                                            i55 = i21;
                                            i56 = i28;
                                            i88 = i42;
                                            unsafe = unsafe3;
                                            if (i19 == 2) {
                                                if (i19 == 5) {
                                                    iZzi = i43 + 4;
                                                    int i99 = zzcv.zza;
                                                    zzdzVar = (zzdz) zzeoVar;
                                                    zzdzVar.zzh(Float.intBitsToFloat(zzcv.zzc(bArr2, i43)));
                                                    while (iZzi < i53) {
                                                        iZzj3 = zzcv.zzj(bArr2, iZzi, zzcuVar2);
                                                        if (i55 == zzcuVar2.zza) {
                                                            zzdzVar.zzh(Float.intBitsToFloat(zzcv.zzc(bArr2, iZzj3)));
                                                            iZzi = iZzj3 + 4;
                                                        }
                                                    }
                                                } else {
                                                    i87 = i55;
                                                    iZzi = i43;
                                                }
                                                i86 = i56;
                                                i90 = i90;
                                                i88 = i88;
                                                if (iZzi != i43) {
                                                    zzcuVar4 = zzcuVar2;
                                                    i89 = i54;
                                                    i83 = i53;
                                                    i85 = 0;
                                                    unsafe7 = unsafe;
                                                    obj9 = obj;
                                                    i84 = i3;
                                                } else {
                                                    i14 = i3;
                                                    i13 = i86;
                                                    i15 = i87;
                                                    i90 = i90;
                                                    i10 = i88;
                                                    i11 = i54;
                                                    obj3 = obj;
                                                    i9 = iZzi;
                                                }
                                            } else {
                                                int i100 = zzcv.zza;
                                                zzdzVar2 = (zzdz) zzeoVar;
                                                iZzi = zzcv.zzj(bArr2, i43, zzcuVar2);
                                                i58 = zzcuVar2.zza + iZzi;
                                                while (iZzi < i58) {
                                                    zzdzVar2.zzh(Float.intBitsToFloat(zzcv.zzc(bArr2, iZzi)));
                                                    iZzi += 4;
                                                }
                                                if (iZzi != i58) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i87 = i55;
                                            i86 = i56;
                                            i90 = i90;
                                            i88 = i88;
                                            if (iZzi != i43) {
                                                zzcuVar4 = zzcuVar2;
                                                i89 = i54;
                                                i83 = i53;
                                                i85 = 0;
                                                unsafe7 = unsafe;
                                                obj9 = obj;
                                                i84 = i3;
                                            } else {
                                                i14 = i3;
                                                i13 = i86;
                                                i15 = i87;
                                                i90 = i90;
                                                i10 = i88;
                                                i11 = i54;
                                                obj3 = obj;
                                                i9 = iZzi;
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            i53 = i2;
                                            zzcuVar2 = zzcuVar2;
                                            i43 = i43;
                                            i54 = i89;
                                            i55 = i21;
                                            i56 = i28;
                                            i88 = i42;
                                            unsafe = unsafe3;
                                            if (i19 == 2) {
                                                if (i19 == 0) {
                                                    int i101 = zzcv.zza;
                                                    zzfbVar = (zzfb) zzeoVar;
                                                    iZzi = zzcv.zzm(bArr2, i43, zzcuVar2);
                                                    zzfbVar.zzf(zzcuVar2.zzb);
                                                    while (iZzi < i53) {
                                                        iZzj4 = zzcv.zzj(bArr2, iZzi, zzcuVar2);
                                                        if (i55 == zzcuVar2.zza) {
                                                            iZzi = zzcv.zzm(bArr2, iZzj4, zzcuVar2);
                                                            zzfbVar.zzf(zzcuVar2.zzb);
                                                        }
                                                    }
                                                } else {
                                                    i87 = i55;
                                                    iZzi = i43;
                                                }
                                                i86 = i56;
                                                i90 = i90;
                                                i88 = i88;
                                                if (iZzi != i43) {
                                                    zzcuVar4 = zzcuVar2;
                                                    i89 = i54;
                                                    i83 = i53;
                                                    i85 = 0;
                                                    unsafe7 = unsafe;
                                                    obj9 = obj;
                                                    i84 = i3;
                                                } else {
                                                    i14 = i3;
                                                    i13 = i86;
                                                    i15 = i87;
                                                    i90 = i90;
                                                    i10 = i88;
                                                    i11 = i54;
                                                    obj3 = obj;
                                                    i9 = iZzi;
                                                }
                                            } else {
                                                int i102 = zzcv.zza;
                                                zzfbVar2 = (zzfb) zzeoVar;
                                                iZzi = zzcv.zzj(bArr2, i43, zzcuVar2);
                                                i59 = zzcuVar2.zza + iZzi;
                                                while (iZzi < i59) {
                                                    iZzi = zzcv.zzm(bArr2, iZzi, zzcuVar2);
                                                    zzfbVar2.zzf(zzcuVar2.zzb);
                                                }
                                                if (iZzi != i59) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i87 = i55;
                                            i86 = i56;
                                            i90 = i90;
                                            i88 = i88;
                                            if (iZzi != i43) {
                                                zzcuVar4 = zzcuVar2;
                                                i89 = i54;
                                                i83 = i53;
                                                i85 = 0;
                                                unsafe7 = unsafe;
                                                obj9 = obj;
                                                i84 = i3;
                                            } else {
                                                i14 = i3;
                                                i13 = i86;
                                                i15 = i87;
                                                i90 = i90;
                                                i10 = i88;
                                                i11 = i54;
                                                obj3 = obj;
                                                i9 = iZzi;
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            i60 = i2;
                                            i54 = i89;
                                            i55 = i21;
                                            i56 = i28;
                                            i88 = i42;
                                            unsafe = unsafe3;
                                            if (i19 == 2) {
                                                if (i19 == 0) {
                                                    zzcuVar2 = zzcuVar2;
                                                    i43 = i43;
                                                    i53 = i60;
                                                    iZzi = zzcv.zzl(i55, bArr, i43, i2, zzeoVar, zzcuVar);
                                                }
                                                zzcuVar2 = zzcuVar2;
                                                i53 = i60;
                                                i87 = i55;
                                                iZzi = i43;
                                                i86 = i56;
                                                i90 = i90;
                                                i88 = i88;
                                                if (iZzi != i43) {
                                                    zzcuVar4 = zzcuVar2;
                                                    i89 = i54;
                                                    i83 = i53;
                                                    i85 = 0;
                                                    unsafe7 = unsafe;
                                                    obj9 = obj;
                                                    i84 = i3;
                                                } else {
                                                    i14 = i3;
                                                    i13 = i86;
                                                    i15 = i87;
                                                    i90 = i90;
                                                    i10 = i88;
                                                    i11 = i54;
                                                    obj3 = obj;
                                                    i9 = iZzi;
                                                }
                                            } else {
                                                iZzg = zzcv.zzg(bArr2, i43, zzeoVar, zzcuVar2);
                                                zzcuVar2 = zzcuVar2;
                                                iZzi = iZzg;
                                                i43 = i43;
                                                i53 = i60;
                                            }
                                            i87 = i55;
                                            i86 = i56;
                                            i90 = i90;
                                            i88 = i88;
                                            if (iZzi != i43) {
                                                zzcuVar4 = zzcuVar2;
                                                i89 = i54;
                                                i83 = i53;
                                                i85 = 0;
                                                unsafe7 = unsafe;
                                                obj9 = obj;
                                                i84 = i3;
                                            } else {
                                                i14 = i3;
                                                i13 = i86;
                                                i15 = i87;
                                                i90 = i90;
                                                i10 = i88;
                                                i11 = i54;
                                                obj3 = obj;
                                                i9 = iZzi;
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            i60 = i2;
                                            i54 = i89;
                                            i55 = i21;
                                            i56 = i28;
                                            i88 = i42;
                                            unsafe = unsafe3;
                                            if (i19 == 2) {
                                                if (i19 == 1) {
                                                    iZzg = i43 + 8;
                                                    int i103 = zzcv.zza;
                                                    zzfbVar3 = (zzfb) zzeoVar;
                                                    zzfbVar3.zzf(zzcv.zzq(bArr2, i43));
                                                    while (iZzg < i60) {
                                                        iZzj5 = zzcv.zzj(bArr2, iZzg, zzcuVar2);
                                                        if (i55 == zzcuVar2.zza) {
                                                            zzfbVar3.zzf(zzcv.zzq(bArr2, iZzj5));
                                                            iZzg = iZzj5 + 8;
                                                        }
                                                    }
                                                }
                                                zzcuVar2 = zzcuVar2;
                                                i53 = i60;
                                                i87 = i55;
                                                iZzi = i43;
                                                i86 = i56;
                                                i90 = i90;
                                                i88 = i88;
                                                if (iZzi != i43) {
                                                    zzcuVar4 = zzcuVar2;
                                                    i89 = i54;
                                                    i83 = i53;
                                                    i85 = 0;
                                                    unsafe7 = unsafe;
                                                    obj9 = obj;
                                                    i84 = i3;
                                                } else {
                                                    i14 = i3;
                                                    i13 = i86;
                                                    i15 = i87;
                                                    i90 = i90;
                                                    i10 = i88;
                                                    i11 = i54;
                                                    obj3 = obj;
                                                    i9 = iZzi;
                                                }
                                            } else {
                                                int i104 = zzcv.zza;
                                                zzfbVar4 = (zzfb) zzeoVar;
                                                iZzg = zzcv.zzj(bArr2, i43, zzcuVar2);
                                                i61 = zzcuVar2.zza + iZzg;
                                                while (iZzg < i61) {
                                                    zzfbVar4.zzf(zzcv.zzq(bArr2, iZzg));
                                                    iZzg += 8;
                                                }
                                                if (iZzg != i61) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            zzcuVar2 = zzcuVar2;
                                            iZzi = iZzg;
                                            i43 = i43;
                                            i53 = i60;
                                            i87 = i55;
                                            i86 = i56;
                                            i90 = i90;
                                            i88 = i88;
                                            if (iZzi != i43) {
                                                zzcuVar4 = zzcuVar2;
                                                i89 = i54;
                                                i83 = i53;
                                                i85 = 0;
                                                unsafe7 = unsafe;
                                                obj9 = obj;
                                                i84 = i3;
                                            } else {
                                                i14 = i3;
                                                i13 = i86;
                                                i15 = i87;
                                                i90 = i90;
                                                i10 = i88;
                                                i11 = i54;
                                                obj3 = obj;
                                                i9 = iZzi;
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            i60 = i2;
                                            i54 = i89;
                                            i55 = i21;
                                            i56 = i28;
                                            i88 = i42;
                                            unsafe = unsafe3;
                                            if (i19 == 2) {
                                                if (i19 == 5) {
                                                    iZzg = i43 + 4;
                                                    int i105 = zzcv.zza;
                                                    zzeiVar = (zzei) zzeoVar;
                                                    zzeiVar.zzg(zzcv.zzc(bArr2, i43));
                                                    while (iZzg < i60) {
                                                        iZzj6 = zzcv.zzj(bArr2, iZzg, zzcuVar2);
                                                        if (i55 == zzcuVar2.zza) {
                                                            zzeiVar.zzg(zzcv.zzc(bArr2, iZzj6));
                                                            iZzg = iZzj6 + 4;
                                                        }
                                                    }
                                                }
                                                zzcuVar2 = zzcuVar2;
                                                i53 = i60;
                                                i87 = i55;
                                                iZzi = i43;
                                                i86 = i56;
                                                i90 = i90;
                                                i88 = i88;
                                                if (iZzi != i43) {
                                                    zzcuVar4 = zzcuVar2;
                                                    i89 = i54;
                                                    i83 = i53;
                                                    i85 = 0;
                                                    unsafe7 = unsafe;
                                                    obj9 = obj;
                                                    i84 = i3;
                                                } else {
                                                    i14 = i3;
                                                    i13 = i86;
                                                    i15 = i87;
                                                    i90 = i90;
                                                    i10 = i88;
                                                    i11 = i54;
                                                    obj3 = obj;
                                                    i9 = iZzi;
                                                }
                                            } else {
                                                int i106 = zzcv.zza;
                                                zzeiVar2 = (zzei) zzeoVar;
                                                iZzg = zzcv.zzj(bArr2, i43, zzcuVar2);
                                                i62 = zzcuVar2.zza + iZzg;
                                                while (iZzg < i62) {
                                                    zzeiVar2.zzg(zzcv.zzc(bArr2, iZzg));
                                                    iZzg += 4;
                                                }
                                                if (iZzg != i62) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            zzcuVar2 = zzcuVar2;
                                            iZzi = iZzg;
                                            i43 = i43;
                                            i53 = i60;
                                            i87 = i55;
                                            i86 = i56;
                                            i90 = i90;
                                            i88 = i88;
                                            if (iZzi != i43) {
                                                zzcuVar4 = zzcuVar2;
                                                i89 = i54;
                                                i83 = i53;
                                                i85 = 0;
                                                unsafe7 = unsafe;
                                                obj9 = obj;
                                                i84 = i3;
                                            } else {
                                                i14 = i3;
                                                i13 = i86;
                                                i15 = i87;
                                                i90 = i90;
                                                i10 = i88;
                                                i11 = i54;
                                                obj3 = obj;
                                                i9 = iZzi;
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            i60 = i2;
                                            i54 = i89;
                                            i55 = i21;
                                            i56 = i28;
                                            i88 = i42;
                                            unsafe = unsafe3;
                                            if (i19 == 2) {
                                                if (i19 == 0) {
                                                    int i107 = zzcv.zza;
                                                    zzcwVar = (zzcw) zzeoVar;
                                                    iZzg = zzcv.zzm(bArr2, i43, zzcuVar2);
                                                    if (zzcuVar2.zzb != 0) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    zzcwVar.zze(z3);
                                                    while (iZzg < i60) {
                                                        iZzj7 = zzcv.zzj(bArr2, iZzg, zzcuVar2);
                                                        if (i55 == zzcuVar2.zza) {
                                                            iZzg = zzcv.zzm(bArr2, iZzj7, zzcuVar2);
                                                            if (zzcuVar2.zzb != 0) {
                                                                z4 = true;
                                                            } else {
                                                                z4 = false;
                                                            }
                                                            zzcwVar.zze(z4);
                                                        }
                                                    }
                                                }
                                                zzcuVar2 = zzcuVar2;
                                                i53 = i60;
                                                i87 = i55;
                                                iZzi = i43;
                                                i86 = i56;
                                                i90 = i90;
                                                i88 = i88;
                                                if (iZzi != i43) {
                                                    zzcuVar4 = zzcuVar2;
                                                    i89 = i54;
                                                    i83 = i53;
                                                    i85 = 0;
                                                    unsafe7 = unsafe;
                                                    obj9 = obj;
                                                    i84 = i3;
                                                } else {
                                                    i14 = i3;
                                                    i13 = i86;
                                                    i15 = i87;
                                                    i90 = i90;
                                                    i10 = i88;
                                                    i11 = i54;
                                                    obj3 = obj;
                                                    i9 = iZzi;
                                                }
                                            } else {
                                                int i108 = zzcv.zza;
                                                zzcwVar2 = (zzcw) zzeoVar;
                                                iZzg = zzcv.zzj(bArr2, i43, zzcuVar2);
                                                i63 = zzcuVar2.zza + iZzg;
                                                while (iZzg < i63) {
                                                    iZzg = zzcv.zzm(bArr2, iZzg, zzcuVar2);
                                                    if (zzcuVar2.zzb != 0) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    zzcwVar2.zze(z5);
                                                }
                                                if (iZzg != i63) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            zzcuVar2 = zzcuVar2;
                                            iZzi = iZzg;
                                            i43 = i43;
                                            i53 = i60;
                                            i87 = i55;
                                            i86 = i56;
                                            i90 = i90;
                                            i88 = i88;
                                            if (iZzi != i43) {
                                                zzcuVar4 = zzcuVar2;
                                                i89 = i54;
                                                i83 = i53;
                                                i85 = 0;
                                                unsafe7 = unsafe;
                                                obj9 = obj;
                                                i84 = i3;
                                            } else {
                                                i14 = i3;
                                                i13 = i86;
                                                i15 = i87;
                                                i90 = i90;
                                                i10 = i88;
                                                i11 = i54;
                                                obj3 = obj;
                                                i9 = iZzi;
                                            }
                                            break;
                                        case 26:
                                            i60 = i2;
                                            i54 = i89;
                                            i55 = i21;
                                            i56 = i28;
                                            i88 = i42;
                                            unsafe = unsafe3;
                                            if (i19 == 2) {
                                                if ((j3 & 536870912) == 0) {
                                                    iZzg = zzcv.zzj(bArr2, i43, zzcuVar2);
                                                    i68 = zzcuVar2.zza;
                                                    if (i68 >= 0) {
                                                        throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i68 == 0) {
                                                        obj8 = "";
                                                        zzeoVar.add(obj8);
                                                    } else {
                                                        obj8 = 
                                                        /*  JADX ERROR: Method code generation error
                                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0730: MOVE (r6v82 'obj8' java.lang.Object) = (r8v47 java.lang.Object) in method: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu):int, file: classes4.dex
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
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
                                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v47 java.lang.Object
                                                            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                                                            */
                                                        /*
                                                            Method dump skipped, instruction units count: 3812
                                                            To view this dump change 'Code comments level' option to 'DEBUG'
                                                        */
                                                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu):int");
                                                    }

                                                    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
                                                    public final Object zze() {
                                                        return ((zzeh) this.zzg).zzK();
                                                    }

                                                    /* JADX WARN: Code duplicated, block: B:26:0x0071  */
                                                    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
                                                    /* JADX WARN: Code duplicated, block: B:41:0x0084 A[SYNTHETIC] */
                                                    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
                                                    public final void zzf(Object obj) {
                                                        if (zzL(obj)) {
                                                            if (obj instanceof zzeh) {
                                                                zzeh zzehVar = (zzeh) obj;
                                                                zzehVar.zzW(Integer.MAX_VALUE);
                                                                zzehVar.zza = 0;
                                                                zzehVar.zzU();
                                                            }
                                                            int[] iArr = this.zzc;
                                                            for (int i = 0; i < iArr.length; i += 3) {
                                                                int iZzs = zzs(i);
                                                                int iZzr = zzr(iZzs);
                                                                long j = iZzs & 1048575;
                                                                if (iZzr != 9) {
                                                                    if (iZzr != 60 && iZzr != 68) {
                                                                        switch (iZzr) {
                                                                            case 17:
                                                                                if (zzI(obj, i)) {
                                                                                    zzv(i).zzf(zzb.getObject(obj, j));
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
                                                                                ((zzeo) zzgz.zzf(obj, j)).zzb();
                                                                                break;
                                                                            case 50:
                                                                                Unsafe unsafe = zzb;
                                                                                Object object = unsafe.getObject(obj, j);
                                                                                if (object != null) {
                                                                                    ((zzfg) object).zzc();
                                                                                    unsafe.putObject(obj, j, object);
                                                                                }
                                                                                break;
                                                                        }
                                                                    } else if (zzM(obj, this.zzc[i], i)) {
                                                                        zzv(i).zzf(zzb.getObject(obj, j));
                                                                    }
                                                                } else if (zzI(obj, i)) {
                                                                    zzv(i).zzf(zzb.getObject(obj, j));
                                                                }
                                                            }
                                                            this.zzl.zza(obj);
                                                            if (this.zzh) {
                                                                this.zzm.zza(obj);
                                                            }
                                                        }
                                                    }

                                                    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
                                                    public final void zzg(Object obj, Object obj2) {
                                                        zzA(obj);
                                                        obj2.getClass();
                                                        for (int i = 0; i < this.zzc.length; i += 3) {
                                                            int iZzs = zzs(i);
                                                            int[] iArr = this.zzc;
                                                            int iZzr = zzr(iZzs);
                                                            int i2 = iArr[i];
                                                            long j = iZzs & 1048575;
                                                            switch (iZzr) {
                                                                case 0:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzo(obj, j, zzgz.zza(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 1:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzp(obj, j, zzgz.zzb(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 2:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 3:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 4:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 5:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 6:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 7:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzm(obj, j, zzgz.zzw(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 8:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 9:
                                                                    zzB(obj, obj2, i);
                                                                    break;
                                                                case 10:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 11:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 12:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 13:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 14:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 15:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 16:
                                                                    if (zzI(obj2, i)) {
                                                                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 17:
                                                                    zzB(obj, obj2, i);
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
                                                                    zzeo zzeoVarZzd = (zzeo) zzgz.zzf(obj, j);
                                                                    zzeo zzeoVar = (zzeo) zzgz.zzf(obj2, j);
                                                                    int size = zzeoVarZzd.size();
                                                                    int size2 = zzeoVar.size();
                                                                    if (size > 0 && size2 > 0) {
                                                                        if (!zzeoVarZzd.zzc()) {
                                                                            zzeoVarZzd = zzeoVarZzd.zzd(size2 + size);
                                                                        }
                                                                        zzeoVarZzd.addAll(zzeoVar);
                                                                    }
                                                                    if (size > 0) {
                                                                        zzeoVar = zzeoVarZzd;
                                                                    }
                                                                    zzgz.zzs(obj, j, zzeoVar);
                                                                    break;
                                                                case 50:
                                                                    int i3 = zzgg.zza;
                                                                    zzgz.zzs(obj, j, zzfh.zza(zzgz.zzf(obj, j), zzgz.zzf(obj2, j)));
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
                                                                    if (zzM(obj2, i2, i)) {
                                                                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                                                                        zzE(obj, i2, i);
                                                                    }
                                                                    break;
                                                                case 60:
                                                                    zzC(obj, obj2, i);
                                                                    break;
                                                                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                                                                case 63:
                                                                case 64:
                                                                case 65:
                                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                                                                    if (zzM(obj2, i2, i)) {
                                                                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                                                                        zzE(obj, i2, i);
                                                                    }
                                                                    break;
                                                                case 68:
                                                                    zzC(obj, obj2, i);
                                                                    break;
                                                            }
                                                        }
                                                        zzgg.zzp(this.zzl, obj, obj2);
                                                        if (this.zzh) {
                                                            zzgg.zzo(this.zzm, obj, obj2);
                                                        }
                                                    }

                                                    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
                                                    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzcu zzcuVar) throws IOException {
                                                        zzc(obj, bArr, i, i2, 0, zzcuVar);
                                                    }

                                                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                                                    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
                                                    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
                                                    public final void zzi(Object obj, zzhh zzhhVar) throws IOException {
                                                        Map.Entry entry;
                                                        Iterator it2;
                                                        int i;
                                                        int i2;
                                                        int i3;
                                                        boolean z;
                                                        boolean z2;
                                                        if (this.zzh) {
                                                            zzdx zzdxVar = ((zzed) obj).zzb;
                                                            if (zzdxVar.zza.isEmpty()) {
                                                                entry = null;
                                                                it2 = null;
                                                            } else {
                                                                Iterator itZzf = zzdxVar.zzf();
                                                                entry = (Map.Entry) itZzf.next();
                                                                it2 = itZzf;
                                                            }
                                                        } else {
                                                            entry = null;
                                                            it2 = null;
                                                        }
                                                        int[] iArr = this.zzc;
                                                        Unsafe unsafe = zzb;
                                                        int i4 = 0;
                                                        int i5 = 1048575;
                                                        int i6 = 0;
                                                        while (i6 < iArr.length) {
                                                            int iZzs = zzs(i6);
                                                            int[] iArr2 = this.zzc;
                                                            int iZzr = zzr(iZzs);
                                                            int i7 = iArr2[i6];
                                                            if (iZzr <= 17) {
                                                                int i8 = iArr2[i6 + 2];
                                                                int i9 = i8 & 1048575;
                                                                if (i9 != i5) {
                                                                    i4 = i9 == 1048575 ? 0 : unsafe.getInt(obj, i9);
                                                                    i5 = i9;
                                                                } else {
                                                                    entry = entry;
                                                                }
                                                                i = i4;
                                                                i3 = 1 << (i8 >>> 20);
                                                                i2 = i5;
                                                            } else {
                                                                entry = entry;
                                                                i = i4;
                                                                i2 = i5;
                                                                i3 = 0;
                                                            }
                                                            while (entry != null && ((zzee) entry.getKey()).zza <= i7) {
                                                                this.zzm.zzb(zzhhVar, entry);
                                                                entry = it2.hasNext() ? (Map.Entry) it2.next() : null;
                                                            }
                                                            long j = iZzs & 1048575;
                                                            switch (iZzr) {
                                                                case 0:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzf(i7, zzgz.zza(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 1:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzo(i7, zzgz.zzb(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 2:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzt(i7, unsafe.getLong(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 3:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzK(i7, unsafe.getLong(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 4:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzr(i7, unsafe.getInt(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 5:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzm(i7, unsafe.getLong(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 6:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzk(i7, unsafe.getInt(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 7:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzb(i7, zzgz.zzw(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 8:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzO(i7, unsafe.getObject(obj, j), zzhhVar);
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 9:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzv(i7, unsafe.getObject(obj, j), zzv(i6));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 10:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzd(i7, (zzdf) unsafe.getObject(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 11:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzI(i7, unsafe.getInt(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 12:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzi(i7, unsafe.getInt(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 13:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzx(i7, unsafe.getInt(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 14:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzz(i7, unsafe.getLong(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 15:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzB(i7, unsafe.getInt(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 16:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzD(i7, unsafe.getLong(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 17:
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    if (zzJ(obj, i6, i2, i, i3)) {
                                                                        zzhhVar.zzq(i7, unsafe.getObject(obj, j), zzv(i6));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 18:
                                                                    z = false;
                                                                    zzgg.zzr(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 19:
                                                                    z = false;
                                                                    zzgg.zzv(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 20:
                                                                    z = false;
                                                                    zzgg.zzx(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 21:
                                                                    z = false;
                                                                    zzgg.zzD(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 22:
                                                                    z = false;
                                                                    zzgg.zzw(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 23:
                                                                    z = false;
                                                                    zzgg.zzu(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 24:
                                                                    z = false;
                                                                    zzgg.zzt(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 25:
                                                                    z = false;
                                                                    zzgg.zzq(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 26:
                                                                    int i10 = this.zzc[i6];
                                                                    List list = (List) unsafe.getObject(obj, j);
                                                                    int i11 = zzgg.zza;
                                                                    if (list != null && !list.isEmpty()) {
                                                                        zzhhVar.zzH(i10, list);
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 27:
                                                                    int i12 = this.zzc[i6];
                                                                    List list2 = (List) unsafe.getObject(obj, j);
                                                                    zzge zzgeVarZzv = zzv(i6);
                                                                    int i13 = zzgg.zza;
                                                                    if (list2 != null && !list2.isEmpty()) {
                                                                        for (int i14 = 0; i14 < list2.size(); i14++) {
                                                                            ((zzdo) zzhhVar).zzv(i12, list2.get(i14), zzgeVarZzv);
                                                                        }
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 28:
                                                                    int i15 = this.zzc[i6];
                                                                    List list3 = (List) unsafe.getObject(obj, j);
                                                                    int i16 = zzgg.zza;
                                                                    if (list3 != null && !list3.isEmpty()) {
                                                                        zzhhVar.zze(i15, list3);
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 29:
                                                                    z2 = false;
                                                                    zzgg.zzC(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    z = z2;
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 30:
                                                                    z2 = false;
                                                                    zzgg.zzs(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    z = z2;
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 31:
                                                                    z2 = false;
                                                                    zzgg.zzy(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    z = z2;
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 32:
                                                                    z2 = false;
                                                                    zzgg.zzz(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    z = z2;
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 33:
                                                                    z2 = false;
                                                                    zzgg.zzA(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    z = z2;
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 34:
                                                                    z2 = false;
                                                                    zzgg.zzB(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, false);
                                                                    z = z2;
                                                                    entry = entry;
                                                                    it2 = it2;
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 35:
                                                                    zzgg.zzr(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 36:
                                                                    zzgg.zzv(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 37:
                                                                    zzgg.zzx(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 38:
                                                                    zzgg.zzD(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 39:
                                                                    zzgg.zzw(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 40:
                                                                    zzgg.zzu(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 41:
                                                                    zzgg.zzt(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 42:
                                                                    zzgg.zzq(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 43:
                                                                    zzgg.zzC(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 44:
                                                                    zzgg.zzs(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 45:
                                                                    zzgg.zzy(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 46:
                                                                    zzgg.zzz(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 47:
                                                                    zzgg.zzA(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 48:
                                                                    zzgg.zzB(this.zzc[i6], (List) unsafe.getObject(obj, j), zzhhVar, true);
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                                                    int i17 = this.zzc[i6];
                                                                    List list4 = (List) unsafe.getObject(obj, j);
                                                                    zzge zzgeVarZzv2 = zzv(i6);
                                                                    int i18 = zzgg.zza;
                                                                    if (list4 != null && !list4.isEmpty()) {
                                                                        for (int i19 = 0; i19 < list4.size(); i19++) {
                                                                            ((zzdo) zzhhVar).zzq(i17, list4.get(i19), zzgeVarZzv2);
                                                                        }
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 50:
                                                                    if (unsafe.getObject(obj, j) != null) {
                                                                        throw null;
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzf(i7, zzm(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 52:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzo(i7, zzn(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzt(i7, zzt(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 54:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzK(i7, zzt(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzr(i7, zzo(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 56:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzm(i7, zzt(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 57:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzk(i7, zzo(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzb(i7, zzN(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 59:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzO(i7, unsafe.getObject(obj, j), zzhhVar);
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 60:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzv(i7, unsafe.getObject(obj, j), zzv(i6));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzd(i7, (zzdf) unsafe.getObject(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzI(i7, zzo(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 63:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzi(i7, zzo(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 64:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzx(i7, zzo(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 65:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzz(i7, zzt(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzB(i7, zzo(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzD(i7, zzt(obj, j));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                case 68:
                                                                    if (zzM(obj, i7, i6)) {
                                                                        zzhhVar.zzq(i7, unsafe.getObject(obj, j), zzv(i6));
                                                                    }
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                                default:
                                                                    i6 += 3;
                                                                    i4 = i;
                                                                    it2 = it2;
                                                                    entry = entry;
                                                                    i5 = i2;
                                                                    break;
                                                            }
                                                        }
                                                        Iterator it3 = it2;
                                                        while (entry != null) {
                                                            this.zzm.zzb(zzhhVar, entry);
                                                            entry = it3.hasNext() ? (Map.Entry) it3.next() : null;
                                                        }
                                                        ((zzeh) obj).zzc.zzl(zzhhVar);
                                                    }

                                                    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
                                                    public final boolean zzj(Object obj, Object obj2) {
                                                        boolean zZzE;
                                                        for (int i = 0; i < this.zzc.length; i += 3) {
                                                            int iZzs = zzs(i);
                                                            long j = iZzs & 1048575;
                                                            switch (zzr(iZzs)) {
                                                                case 0:
                                                                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzgz.zza(obj, j)) != Double.doubleToLongBits(zzgz.zza(obj2, j))) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 1:
                                                                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzgz.zzb(obj, j)) != Float.floatToIntBits(zzgz.zzb(obj2, j))) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 2:
                                                                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 3:
                                                                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 4:
                                                                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 5:
                                                                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 6:
                                                                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 7:
                                                                    if (!zzH(obj, obj2, i) || zzgz.zzw(obj, j) != zzgz.zzw(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 8:
                                                                    if (!zzH(obj, obj2, i) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 9:
                                                                    if (!zzH(obj, obj2, i) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 10:
                                                                    if (!zzH(obj, obj2, i) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 11:
                                                                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 12:
                                                                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 13:
                                                                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 14:
                                                                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 15:
                                                                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 16:
                                                                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 17:
                                                                    if (!zzH(obj, obj2, i) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
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
                                                                    zZzE = zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j));
                                                                    break;
                                                                case 50:
                                                                    zZzE = zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j));
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
                                                                    long jZzp = zzp(i) & 1048575;
                                                                    if (zzgz.zzc(obj, jZzp) != zzgz.zzc(obj2, jZzp) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                default:
                                                                    continue;
                                                                    break;
                                                            }
                                                            if (!zZzE) {
                                                                return false;
                                                            }
                                                        }
                                                        if (!((zzeh) obj).zzc.equals(((zzeh) obj2).zzc)) {
                                                            return false;
                                                        }
                                                        if (this.zzh) {
                                                            return ((zzed) obj).zzb.equals(((zzed) obj2).zzb);
                                                        }
                                                        return true;
                                                    }

                                                    /* JADX WARN: Code duplicated, block: B:42:0x009c  */
                                                    /* JADX WARN: Code duplicated, block: B:44:0x00ab  */
                                                    /* JADX WARN: Code duplicated, block: B:47:0x00b6  */
                                                    /* JADX WARN: Code duplicated, block: B:50:0x00c1 A[LOOP:1: B:45:0x00b0->B:50:0x00c1, LOOP_END] */
                                                    /* JADX WARN: Code duplicated, block: B:67:0x00c0 A[SYNTHETIC] */
                                                    /* JADX WARN: Code duplicated, block: B:71:0x00de A[SYNTHETIC] */
                                                    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
                                                    public final boolean zzk(Object obj) {
                                                        int i;
                                                        int i2;
                                                        List list;
                                                        zzge zzgeVarZzv;
                                                        int i3;
                                                        int i4 = 0;
                                                        int i5 = 0;
                                                        int i6 = 1048575;
                                                        while (i5 < this.zzj) {
                                                            int[] iArr = this.zzi;
                                                            int[] iArr2 = this.zzc;
                                                            int i7 = iArr[i5];
                                                            int i8 = iArr2[i7];
                                                            int iZzs = zzs(i7);
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
                                                            if ((268435456 & iZzs) != 0 && !zzJ(obj, i7, i, i2, i11)) {
                                                                return false;
                                                            }
                                                            int iZzr = zzr(iZzs);
                                                            if (iZzr == 9 || iZzr == 17) {
                                                                if (zzJ(obj, i7, i, i2, i11) && !zzK(obj, iZzs, zzv(i7))) {
                                                                    return false;
                                                                }
                                                            } else if (iZzr == 27) {
                                                                list = (List) zzgz.zzf(obj, iZzs & 1048575);
                                                                if (list.isEmpty()) {
                                                                    continue;
                                                                } else {
                                                                    zzgeVarZzv = zzv(i7);
                                                                    for (i3 = 0; i3 < list.size(); i3++) {
                                                                        if (!zzgeVarZzv.zzk(list.get(i3))) {
                                                                            return false;
                                                                        }
                                                                    }
                                                                }
                                                            } else if (iZzr == 60 || iZzr == 68) {
                                                                if (zzM(obj, i8, i7) && !zzK(obj, iZzs, zzv(i7))) {
                                                                    return false;
                                                                }
                                                            } else if (iZzr == 49) {
                                                                list = (List) zzgz.zzf(obj, iZzs & 1048575);
                                                                if (list.isEmpty()) {
                                                                    zzgeVarZzv = zzv(i7);
                                                                    while (i3 < list.size()) {
                                                                        if (!zzgeVarZzv.zzk(list.get(i3))) {
                                                                            return false;
                                                                        }
                                                                    }
                                                                } else {
                                                                    continue;
                                                                }
                                                            } else if (iZzr == 50 && !((zzfg) zzgz.zzf(obj, iZzs & 1048575)).isEmpty()) {
                                                                throw null;
                                                            }
                                                            i5++;
                                                            i6 = i;
                                                            i4 = i2;
                                                        }
                                                        return !this.zzh || ((zzed) obj).zzb.zzk();
                                                    }
                                                }
