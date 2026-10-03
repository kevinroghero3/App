package com.google.android.gms.internal.measurement;

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
final class zzll<T> implements zzlz<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzna.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlh zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final zzls zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzlp zzo;
    private final zzkm zzp;
    private final zzmu<?, ?> zzq;
    private final zzjj<?> zzr;
    private final zzla zzs;

    private static <T> double zza(T t, long j) {
        return ((Double) zzna.zze(t, j)).doubleValue();
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> float zzb(T t, long j) {
        return ((Float) zzna.zze(t, j)).floatValue();
    }

    private static int zza(byte[] bArr, int i, int i2, zznh zznhVar, Class<?> cls, zzig zzigVar) throws IOException {
        switch (zzlk.zza[zznhVar.ordinal()]) {
            case 1:
                int iZzd = zzid.zzd(bArr, i, zzigVar);
                zzigVar.zzc = Boolean.valueOf(zzigVar.zzb != 0);
                return iZzd;
            case 2:
                return zzid.zza(bArr, i, zzigVar);
            case 3:
                zzigVar.zzc = Double.valueOf(zzid.zza(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzigVar.zzc = Integer.valueOf(zzid.zzc(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzigVar.zzc = Long.valueOf(zzid.zzd(bArr, i));
                return i + 8;
            case 8:
                zzigVar.zzc = Float.valueOf(zzid.zzb(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZzc = zzid.zzc(bArr, i, zzigVar);
                zzigVar.zzc = Integer.valueOf(zzigVar.zza);
                return iZzc;
            case 12:
            case 13:
                int iZzd2 = zzid.zzd(bArr, i, zzigVar);
                zzigVar.zzc = Long.valueOf(zzigVar.zzb);
                return iZzd2;
            case 14:
                return zzid.zza(zzlv.zza().zza((Class) cls), bArr, i, i2, zzigVar);
            case 15:
                int iZzc2 = zzid.zzc(bArr, i, zzigVar);
                zzigVar.zzc = Integer.valueOf(zziv.zza(zzigVar.zza));
                return iZzc2;
            case 16:
                int iZzd3 = zzid.zzd(bArr, i, zzigVar);
                zzigVar.zzc = Long.valueOf(zziv.zza(zzigVar.zzb));
                return iZzd3;
            case 17:
                return zzid.zzb(bArr, i, zzigVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:139:0x038c A[PHI: r12
  0x038c: PHI (r12v4 int) = 
  (r12v1 int)
  (r12v6 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
 binds: [B:18:0x0058, B:138:0x038b, B:119:0x02c1, B:116:0x02ac, B:113:0x0297, B:110:0x0282, B:107:0x026d, B:104:0x0258, B:101:0x0242, B:98:0x022c, B:95:0x0216, B:92:0x0200, B:89:0x01ea, B:86:0x01d4, B:83:0x01be, B:80:0x01a8, B:75:0x0174, B:72:0x0167, B:69:0x0157, B:66:0x0147, B:63:0x0137, B:60:0x012b, B:57:0x011f, B:54:0x0113, B:48:0x00f5, B:45:0x00e1, B:42:0x00cf, B:39:0x00bf, B:36:0x00af, B:33:0x00a3, B:30:0x0097, B:27:0x0087, B:24:0x0077, B:21:0x0061] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v234 */
    /* JADX WARN: Type inference failed for: r0v241 */
    /* JADX WARN: Type inference failed for: r0v244 */
    /* JADX WARN: Type inference failed for: r0v245 */
    /* JADX WARN: Type inference failed for: r0v246 */
    /* JADX WARN: Type inference failed for: r0v247 */
    /* JADX WARN: Type inference failed for: r0v248 */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r12v3, types: [int] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.google.android.gms.internal.measurement.zzma, com.google.android.gms.internal.measurement.zzma<T extends com.google.android.gms.internal.measurement.zzjm<T>, java.lang.Object>] */
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
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.measurement.zzlz
    public final int zza(T t) {
        ?? r14;
        int i;
        ?? r5;
        ?? r15;
        int iZza;
        int iZza2;
        int iZzc;
        int iZzd;
        int iZzf;
        int iZzg;
        ?? r0;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        ?? r10 = 0;
        int i3 = 1048575;
        ?? r1 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.zzc.length) {
            int iZzc2 = zzc(i4);
            int i6 = (267386880 & iZzc2) >>> 20;
            int[] iArr = this.zzc;
            int i7 = iArr[i4];
            int i8 = iArr[i4 + 2];
            int i9 = i8 & i2;
            if (i6 <= 17) {
                if (i9 != i3) {
                    i3 = i9;
                    r0 = i9 == i2 ? r10 : unsafe.getInt(t, i9);
                }
                r14 = r0;
                i = i3;
                r5 = 1 << (i8 >>> 20);
            } else {
                r0 = r1;
                r14 = r1;
                i = i3;
                r5 = r10;
            }
            long j = iZzc2 & i2;
            if (i6 >= zzjp.zza.zza()) {
                zzjp.zzb.zza();
            }
            ?? r17 = r5;
            switch (i6) {
                case 0:
                    r15 = r10;
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzjb.zza(i7, 0.0d);
                        r15 = r15;
                        i5 += iZza;
                    }
                    break;
                case 1:
                    r15 = r10;
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzjb.zza(i7, 0.0f);
                        r15 = r15;
                        i5 += iZza;
                    }
                    break;
                case 2:
                    r15 = r10;
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzjb.zzb(i7, unsafe.getLong(t, j));
                        r15 = r15;
                        i5 += iZza;
                    }
                    break;
                case 3:
                    r15 = r10;
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzjb.zze(i7, unsafe.getLong(t, j));
                        r15 = r15;
                        i5 += iZza;
                    }
                    break;
                case 4:
                    r15 = r10;
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzjb.zzc(i7, unsafe.getInt(t, j));
                        r15 = r15;
                        i5 += iZza;
                    }
                    break;
                case 5:
                    r15 = r10;
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzjb.zza(i7, 0L);
                        r15 = r15;
                        i5 += iZza;
                    }
                    break;
                case 6:
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        r15 = 0;
                        iZza = zzjb.zzb(i7, 0);
                        i5 += iZza;
                    } else {
                        r15 = 0;
                    }
                    break;
                case 7:
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzjb.zza(i7, true);
                        i5 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 8:
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        Object object = unsafe.getObject(t, j);
                        if (object instanceof zzih) {
                            iZza2 = zzjb.zza(i7, (zzih) object);
                        } else {
                            iZza2 = zzjb.zza(i7, (String) object);
                        }
                        i5 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 9:
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzmb.zza(i7, unsafe.getObject(t, j), zze(i4));
                        i5 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 10:
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzjb.zza(i7, (zzih) unsafe.getObject(t, j));
                        i5 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 11:
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzjb.zzf(i7, unsafe.getInt(t, j));
                        i5 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 12:
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzjb.zza(i7, unsafe.getInt(t, j));
                        i5 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 13:
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzjb.zzd(i7, 0);
                        i5 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 14:
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzjb.zzc(i7, 0L);
                        i5 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 15:
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzjb.zze(i7, unsafe.getInt(t, j));
                        i5 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 16:
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzjb.zzd(i7, unsafe.getLong(t, j));
                        i5 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 17:
                    if (zza(t, i4, i, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzjb.zza(i7, (zzlh) unsafe.getObject(t, j), zze(i4));
                        i5 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 18:
                    iZza2 = zzmb.zzd(i7, (List) unsafe.getObject(t, j), r10);
                    i5 += iZza2;
                    r15 = 0;
                    break;
                case 19:
                    iZzc = zzmb.zzc(i7, (List) unsafe.getObject(t, j), r10);
                    i5 += iZzc;
                    r15 = r10;
                    break;
                case 20:
                    iZzc = zzmb.zzf(i7, (List) unsafe.getObject(t, j), r10);
                    i5 += iZzc;
                    r15 = r10;
                    break;
                case 21:
                    iZzc = zzmb.zzj(i7, (List) unsafe.getObject(t, j), r10);
                    i5 += iZzc;
                    r15 = r10;
                    break;
                case 22:
                    iZzc = zzmb.zze(i7, (List) unsafe.getObject(t, j), r10);
                    i5 += iZzc;
                    r15 = r10;
                    break;
                case 23:
                    iZzc = zzmb.zzd(i7, (List) unsafe.getObject(t, j), r10);
                    i5 += iZzc;
                    r15 = r10;
                    break;
                case 24:
                    iZzc = zzmb.zzc(i7, (List) unsafe.getObject(t, j), r10);
                    i5 += iZzc;
                    r15 = r10;
                    break;
                case 25:
                    iZzc = zzmb.zza(i7, (List<?>) unsafe.getObject(t, j), (boolean) r10);
                    i5 += iZzc;
                    r15 = r10;
                    break;
                case 26:
                    iZza2 = zzmb.zzb(i7, (List) unsafe.getObject(t, j));
                    i5 += iZza2;
                    r15 = 0;
                    break;
                case 27:
                    iZza2 = zzmb.zzb(i7, (List<?>) unsafe.getObject(t, j), zze(i4));
                    i5 += iZza2;
                    r15 = 0;
                    break;
                case 28:
                    iZza2 = zzmb.zza(i7, (List<zzih>) unsafe.getObject(t, j));
                    i5 += iZza2;
                    r15 = 0;
                    break;
                case 29:
                    iZza2 = zzmb.zzi(i7, (List) unsafe.getObject(t, j), r10);
                    i5 += iZza2;
                    r15 = 0;
                    break;
                case 30:
                    iZzc = zzmb.zzb(i7, (List<Integer>) unsafe.getObject(t, j), (boolean) r10);
                    i5 += iZzc;
                    r15 = r10;
                    break;
                case 31:
                    iZzc = zzmb.zzc(i7, (List) unsafe.getObject(t, j), r10);
                    i5 += iZzc;
                    r15 = r10;
                    break;
                case 32:
                    iZzc = zzmb.zzd(i7, (List) unsafe.getObject(t, j), r10);
                    i5 += iZzc;
                    r15 = r10;
                    break;
                case 33:
                    iZzc = zzmb.zzg(i7, (List) unsafe.getObject(t, j), r10);
                    i5 += iZzc;
                    r15 = r10;
                    break;
                case 34:
                    iZzc = zzmb.zzh(i7, (List) unsafe.getObject(t, j), r10);
                    i5 += iZzc;
                    r15 = r10;
                    break;
                case 35:
                    iZzd = zzmb.zzd((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 36:
                    iZzd = zzmb.zzc((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 37:
                    iZzd = zzmb.zzf((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 38:
                    iZzd = zzmb.zzj((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 39:
                    iZzd = zzmb.zze((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 40:
                    iZzd = zzmb.zzd((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 41:
                    iZzd = zzmb.zzc((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 42:
                    iZzd = zzmb.zza((List<?>) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 43:
                    iZzd = zzmb.zzi((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 44:
                    iZzd = zzmb.zzb((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 45:
                    iZzd = zzmb.zzc((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 46:
                    iZzd = zzmb.zzd((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 47:
                    iZzd = zzmb.zzg((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 48:
                    iZzd = zzmb.zzh((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzf = zzjb.zzf(i7);
                        iZzg = zzjb.zzg(iZzd);
                        iZza2 = iZzd + iZzf + iZzg;
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    iZza2 = zzmb.zza(i7, (List<zzlh>) unsafe.getObject(t, j), zze(i4));
                    i5 += iZza2;
                    r15 = 0;
                    break;
                case 50:
                    iZza2 = this.zzs.zza(i7, unsafe.getObject(t, j), zzf(i4));
                    i5 += iZza2;
                    r15 = 0;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zza(i7, 0.0d);
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 52:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zza(i7, 0.0f);
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zzb(i7, zzd(t, j));
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 54:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zze(i7, zzd(t, j));
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zzc(i7, zzc(t, j));
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 56:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zza(i7, 0L);
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 57:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zzb(i7, (int) r10);
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zza(i7, true);
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 59:
                    if (zzc(t, i7, i4)) {
                        Object object2 = unsafe.getObject(t, j);
                        if (object2 instanceof zzih) {
                            iZza2 = zzjb.zza(i7, (zzih) object2);
                        } else {
                            iZza2 = zzjb.zza(i7, (String) object2);
                        }
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 60:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzmb.zza(i7, unsafe.getObject(t, j), zze(i4));
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zza(i7, (zzih) unsafe.getObject(t, j));
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zzf(i7, zzc(t, j));
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 63:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zza(i7, zzc(t, j));
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 64:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zzd(i7, (int) r10);
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 65:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zzc(i7, 0L);
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zze(i7, zzc(t, j));
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zzd(i7, zzd(t, j));
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                case 68:
                    if (zzc(t, i7, i4)) {
                        iZza2 = zzjb.zza(i7, (zzlh) unsafe.getObject(t, j), zze(i4));
                        i5 += iZza2;
                        r15 = 0;
                    } else {
                        r15 = r10;
                    }
                    break;
                default:
                    r15 = r10;
                    break;
            }
            i4 += 3;
            r1 = r14;
            r10 = r15;
            i3 = i;
            i2 = 1048575;
        }
        ?? r16 = r10;
        zzmu<?, ?> zzmuVar = this.zzq;
        int iZza3 = i5 + zzmuVar.zza(zzmuVar.zzd(t));
        if (!this.zzh) {
            return iZza3;
        }
        zzjk zzjkVarZza = this.zzr.zza(t);
        ?? r11 = r16;
        ?? Zza = r16;
        while (r11 < zzjkVarZza.zza.zza()) {
            Map.Entry entryZzb = zzjkVarZza.zza.zzb(r11);
            r11++;
            Zza += zzjk.zza((zzjm<?>) entryZzb.getKey(), entryZzb.getValue());
        }
        ?? Zza2 = Zza;
        for (Map.Entry entry : zzjkVarZza.zza.zzb()) {
            Zza2 += zzjk.zza((zzjm<?>) entry.getKey(), entry.getValue());
        }
        return iZza3 + Zza2;
    }

    /* JADX WARN: Code duplicated, block: B:76:0x01c2  */
    @Override // com.google.android.gms.internal.measurement.zzlz
    public final int zzb(T t) {
        int i;
        int iZza;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzc = zzc(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzc;
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZza = zzjx.zza(Double.doubleToLongBits(zzna.zza(t, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zzna.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzjx.zza(zzna.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzjx.zza(zzna.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zzna.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzjx.zza(zzna.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zzna.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzjx.zza(zzna.zzh(t, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zzna.zze(t, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZze = zzna.zze(t, j);
                    if (objZze != null) {
                        iZza = objZze.hashCode();
                    } else {
                        iZza = 37;
                    }
                    i = i2 * 53;
                    i2 = i + iZza;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zzna.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zzna.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zzna.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zzna.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzjx.zza(zzna.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zzna.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzjx.zza(zzna.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZze2 = zzna.zze(t, j);
                    if (objZze2 != null) {
                        iZza = objZze2.hashCode();
                    } else {
                        iZza = 37;
                    }
                    i = i2 * 53;
                    i2 = i + iZza;
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
                    iZza = zzna.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = zzna.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjx.zza(Double.doubleToLongBits(zza(t, j)));
                        i2 = i + iZza;
                    }
                    break;
                case 52:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzb(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjx.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 54:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjx.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 56:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjx.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 57:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjx.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 59:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zzna.zze(t, j)).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 60:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzna.zze(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzna.zze(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 63:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 64:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 65:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjx.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjx.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 68:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzna.zze(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
            }
        }
        int iHashCode = (i2 * 53) + this.zzq.zzd(t).hashCode();
        return this.zzh ? (iHashCode * 53) + this.zzr.zza(t).hashCode() : iHashCode;
    }

    private static <T> int zzc(T t, long j) {
        return ((Integer) zzna.zze(t, j)).intValue();
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0384  */
    /* JADX WARN: Code duplicated, block: B:119:0x038d  */
    /* JADX WARN: Code duplicated, block: B:128:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:131:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:133:0x040b  */
    /* JADX WARN: Code duplicated, block: B:135:0x0410  */
    /* JADX WARN: Code duplicated, block: B:136:0x041b  */
    /* JADX WARN: Code duplicated, block: B:138:0x041e  */
    /* JADX WARN: Code duplicated, block: B:140:0x0441  */
    /* JADX WARN: Code duplicated, block: B:142:0x0449 A[LOOP:2: B:139:0x043f->B:142:0x0449, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:143:0x045b  */
    /* JADX WARN: Code duplicated, block: B:145:0x0467  */
    /* JADX WARN: Code duplicated, block: B:147:0x046d  */
    /* JADX WARN: Code duplicated, block: B:149:0x0478 A[LOOP:3: B:148:0x0476->B:149:0x0478, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:154:0x048e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:155:0x0490  */
    /* JADX WARN: Code duplicated, block: B:157:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:159:0x04a9 A[LOOP:4: B:156:0x049f->B:159:0x04a9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:160:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:162:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:164:0x04c8 A[LOOP:5: B:163:0x04c6->B:164:0x04c8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:169:0x04de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:170:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:172:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:174:0x04f9 A[LOOP:6: B:171:0x04ef->B:174:0x04f9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:175:0x0507  */
    /* JADX WARN: Code duplicated, block: B:177:0x050d  */
    /* JADX WARN: Code duplicated, block: B:179:0x0513 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:180:0x0515  */
    /* JADX WARN: Code duplicated, block: B:183:0x0536  */
    /* JADX WARN: Code duplicated, block: B:185:0x053c  */
    /* JADX WARN: Code duplicated, block: B:187:0x0544  */
    /* JADX WARN: Code duplicated, block: B:189:0x0548 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:190:0x054a  */
    /* JADX WARN: Code duplicated, block: B:191:0x0553  */
    /* JADX WARN: Code duplicated, block: B:194:0x0560  */
    /* JADX WARN: Code duplicated, block: B:196:0x0568  */
    /* JADX WARN: Code duplicated, block: B:198:0x0570  */
    /* JADX WARN: Code duplicated, block: B:200:0x0574 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x005c  */
    /* JADX WARN: Code duplicated, block: B:212:0x05a0  */
    /* JADX WARN: Code duplicated, block: B:214:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:217:0x05c8  */
    /* JADX WARN: Code duplicated, block: B:219:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:221:0x05dc  */
    /* JADX WARN: Code duplicated, block: B:223:0x05e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:224:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:225:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:228:0x0605  */
    /* JADX WARN: Code duplicated, block: B:230:0x060d  */
    /* JADX WARN: Code duplicated, block: B:232:0x0615 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:240:0x0632  */
    /* JADX WARN: Code duplicated, block: B:242:0x063c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:243:0x063e  */
    /* JADX WARN: Code duplicated, block: B:244:0x0642  */
    /* JADX WARN: Code duplicated, block: B:246:0x064a  */
    /* JADX WARN: Code duplicated, block: B:249:0x0657  */
    /* JADX WARN: Code duplicated, block: B:24:0x0089  */
    /* JADX WARN: Code duplicated, block: B:251:0x065f  */
    /* JADX WARN: Code duplicated, block: B:253:0x0667 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:257:0x0675  */
    /* JADX WARN: Code duplicated, block: B:268:0x06a1 A[PHI: r1 r2 r3 r4 r5 r7 r14
  0x06a1: PHI (r1v126 sun.misc.Unsafe) = 
  (r1v90 sun.misc.Unsafe)
  (r1v92 sun.misc.Unsafe)
  (r1v94 sun.misc.Unsafe)
  (r1v96 sun.misc.Unsafe)
  (r1v97 sun.misc.Unsafe)
  (r1v127 sun.misc.Unsafe)
 binds: [B:333:0x07c4, B:322:0x0782, B:306:0x0736, B:282:0x06da, B:218:0x05d2, B:216:0x05c5] A[DONT_GENERATE, DONT_INLINE]
  0x06a1: PHI (r2v117 int) = (r2v89 int), (r2v91 int), (r2v93 int), (r2v95 int), (r2v96 int), (r2v118 int) binds: [B:333:0x07c4, B:322:0x0782, B:306:0x0736, B:282:0x06da, B:218:0x05d2, B:216:0x05c5] A[DONT_GENERATE, DONT_INLINE]
  0x06a1: PHI (r3v71 int) = (r3v53 int), (r3v55 int), (r3v57 int), (r3v59 int), (r3v60 int), (r3v72 int) binds: [B:333:0x07c4, B:322:0x0782, B:306:0x0736, B:282:0x06da, B:218:0x05d2, B:216:0x05c5] A[DONT_GENERATE, DONT_INLINE]
  0x06a1: PHI (r4v93 int) = (r4v80 int), (r4v82 int), (r4v84 int), (r4v86 int), (r4v87 int), (r36v0 int A[IMMUTABLE_TYPE, METHOD_ARGUMENT]) binds: [B:333:0x07c4, B:322:0x0782, B:306:0x0736, B:282:0x06da, B:218:0x05d2, B:216:0x05c5] A[DONT_GENERATE, DONT_INLINE]
  0x06a1: PHI (r5v72 int) = (r5v59 int), (r5v61 int), (r5v63 int), (r5v65 int), (r5v66 int), (r5v73 int) binds: [B:333:0x07c4, B:322:0x0782, B:306:0x0736, B:282:0x06da, B:218:0x05d2, B:216:0x05c5] A[DONT_GENERATE, DONT_INLINE]
  0x06a1: PHI (r7v33 int) = (r7v18 int), (r7v19 int), (r7v21 int), (r7v23 int), (r7v24 int), (r7v34 int) binds: [B:333:0x07c4, B:322:0x0782, B:306:0x0736, B:282:0x06da, B:218:0x05d2, B:216:0x05c5] A[DONT_GENERATE, DONT_INLINE]
  0x06a1: PHI (r14v51 com.google.android.gms.internal.measurement.zzig) = 
  (r14v43 com.google.android.gms.internal.measurement.zzig)
  (r14v43 com.google.android.gms.internal.measurement.zzig)
  (r14v43 com.google.android.gms.internal.measurement.zzig)
  (r14v43 com.google.android.gms.internal.measurement.zzig)
  (r14v43 com.google.android.gms.internal.measurement.zzig)
  (r14v52 com.google.android.gms.internal.measurement.zzig)
 binds: [B:333:0x07c4, B:322:0x0782, B:306:0x0736, B:282:0x06da, B:218:0x05d2, B:216:0x05c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:269:0x06a8  */
    /* JADX WARN: Code duplicated, block: B:26:0x008d  */
    /* JADX WARN: Code duplicated, block: B:271:0x06b4  */
    /* JADX WARN: Code duplicated, block: B:273:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:275:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:276:0x06cb  */
    /* JADX WARN: Code duplicated, block: B:282:0x06da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:283:0x06dc  */
    /* JADX WARN: Code duplicated, block: B:285:0x06e8  */
    /* JADX WARN: Code duplicated, block: B:286:0x06ea  */
    /* JADX WARN: Code duplicated, block: B:289:0x06f2  */
    /* JADX WARN: Code duplicated, block: B:28:0x0096  */
    /* JADX WARN: Code duplicated, block: B:291:0x06fa  */
    /* JADX WARN: Code duplicated, block: B:293:0x0704  */
    /* JADX WARN: Code duplicated, block: B:294:0x0706  */
    /* JADX WARN: Code duplicated, block: B:296:0x070c  */
    /* JADX WARN: Code duplicated, block: B:298:0x0718  */
    /* JADX WARN: Code duplicated, block: B:29:0x0099  */
    /* JADX WARN: Code duplicated, block: B:300:0x0723 A[LOOP:12: B:299:0x0721->B:300:0x0723, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:305:0x0735  */
    /* JADX WARN: Code duplicated, block: B:307:0x0738  */
    /* JADX WARN: Code duplicated, block: B:309:0x0745  */
    /* JADX WARN: Code duplicated, block: B:311:0x074d A[LOOP:13: B:308:0x0743->B:311:0x074d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:312:0x0757  */
    /* JADX WARN: Code duplicated, block: B:314:0x0763  */
    /* JADX WARN: Code duplicated, block: B:316:0x076e A[LOOP:14: B:315:0x076c->B:316:0x076e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:321:0x0781  */
    /* JADX WARN: Code duplicated, block: B:323:0x0784  */
    /* JADX WARN: Code duplicated, block: B:325:0x0791  */
    /* JADX WARN: Code duplicated, block: B:327:0x0799 A[LOOP:15: B:324:0x078f->B:327:0x0799, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:329:0x07ac  */
    /* JADX WARN: Code duplicated, block: B:331:0x07b8  */
    /* JADX WARN: Code duplicated, block: B:333:0x07c4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:334:0x07c6  */
    /* JADX WARN: Code duplicated, block: B:336:0x07df  */
    /* JADX WARN: Code duplicated, block: B:338:0x07eb  */
    /* JADX WARN: Code duplicated, block: B:340:0x07f6 A[LOOP:16: B:339:0x07f4->B:340:0x07f6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:345:0x0808 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:346:0x080a  */
    /* JADX WARN: Code duplicated, block: B:348:0x0817  */
    /* JADX WARN: Code duplicated, block: B:350:0x081f A[LOOP:17: B:347:0x0815->B:350:0x081f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:351:0x0829  */
    /* JADX WARN: Code duplicated, block: B:353:0x0835  */
    /* JADX WARN: Code duplicated, block: B:355:0x0840 A[LOOP:18: B:354:0x083e->B:355:0x0840, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:360:0x0852  */
    /* JADX WARN: Code duplicated, block: B:362:0x0855  */
    /* JADX WARN: Code duplicated, block: B:364:0x0862  */
    /* JADX WARN: Code duplicated, block: B:366:0x086a A[LOOP:19: B:363:0x0860->B:366:0x086a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:367:0x0874  */
    /* JADX WARN: Code duplicated, block: B:369:0x0880  */
    /* JADX WARN: Code duplicated, block: B:371:0x088b A[LOOP:20: B:370:0x0889->B:371:0x088b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:376:0x089e  */
    /* JADX WARN: Code duplicated, block: B:378:0x08a1  */
    /* JADX WARN: Code duplicated, block: B:380:0x08ae  */
    /* JADX WARN: Code duplicated, block: B:382:0x08b6 A[LOOP:21: B:379:0x08ac->B:382:0x08b6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:383:0x08c0 A[PHI: r7 r8 r9 r10 r11 r12 r14
  0x08c0: PHI (r7v42 int) = (r7v14 int), (r7v15 int), (r7v16 int), (r7v33 int), (r7v43 int) binds: [B:377:0x089f, B:361:0x0853, B:345:0x0808, B:268:0x06a1, B:135:0x0410] A[DONT_GENERATE, DONT_INLINE]
  0x08c0: PHI (r8v139 int) = (r8v89 int), (r8v90 int), (r8v91 int), (r8v135 int), (r8v140 int) binds: [B:377:0x089f, B:361:0x0853, B:345:0x0808, B:268:0x06a1, B:135:0x0410] A[DONT_GENERATE, DONT_INLINE]
  0x08c0: PHI (r9v99 int) = (r9v71 int), (r9v72 int), (r9v73 int), (r9v94 int), (r9v100 int) binds: [B:377:0x089f, B:361:0x0853, B:345:0x0808, B:268:0x06a1, B:135:0x0410] A[DONT_GENERATE, DONT_INLINE]
  0x08c0: PHI (r10v65 int) = (r10v33 int), (r10v34 int), (r10v35 int), (r10v57 int), (r10v66 int) binds: [B:377:0x089f, B:361:0x0853, B:345:0x0808, B:268:0x06a1, B:135:0x0410] A[DONT_GENERATE, DONT_INLINE]
  0x08c0: PHI (r11v70 int) = (r11v41 int), (r11v42 int), (r11v43 int), (r11v66 int), (r11v72 int) binds: [B:377:0x089f, B:361:0x0853, B:345:0x0808, B:268:0x06a1, B:135:0x0410] A[DONT_GENERATE, DONT_INLINE]
  0x08c0: PHI (r12v71 sun.misc.Unsafe) = 
  (r12v52 sun.misc.Unsafe)
  (r12v53 sun.misc.Unsafe)
  (r12v54 sun.misc.Unsafe)
  (r12v68 sun.misc.Unsafe)
  (r12v72 sun.misc.Unsafe)
 binds: [B:377:0x089f, B:361:0x0853, B:345:0x0808, B:268:0x06a1, B:135:0x0410] A[DONT_GENERATE, DONT_INLINE]
  0x08c0: PHI (r14v56 com.google.android.gms.internal.measurement.zzig) = 
  (r14v43 com.google.android.gms.internal.measurement.zzig)
  (r14v43 com.google.android.gms.internal.measurement.zzig)
  (r14v43 com.google.android.gms.internal.measurement.zzig)
  (r14v51 com.google.android.gms.internal.measurement.zzig)
  (r14v43 com.google.android.gms.internal.measurement.zzig)
 binds: [B:377:0x089f, B:361:0x0853, B:345:0x0808, B:268:0x06a1, B:135:0x0410] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:389:0x08ef  */
    /* JADX WARN: Code duplicated, block: B:391:0x08f2  */
    /* JADX WARN: Code duplicated, block: B:393:0x0907  */
    /* JADX WARN: Code duplicated, block: B:433:0x0a2a  */
    /* JADX WARN: Code duplicated, block: B:434:0x0a35  */
    /* JADX WARN: Code duplicated, block: B:436:0x0a38  */
    /* JADX WARN: Code duplicated, block: B:438:0x0a66  */
    /* JADX WARN: Code duplicated, block: B:439:0x0a71  */
    /* JADX WARN: Code duplicated, block: B:441:0x0a83  */
    /* JADX WARN: Code duplicated, block: B:443:0x0a9d  */
    /* JADX WARN: Code duplicated, block: B:445:0x0aaa  */
    /* JADX WARN: Code duplicated, block: B:446:0x0abf  */
    /* JADX WARN: Code duplicated, block: B:447:0x0ac7  */
    /* JADX WARN: Code duplicated, block: B:449:0x0ad4  */
    /* JADX WARN: Code duplicated, block: B:455:0x0af6  */
    /* JADX WARN: Code duplicated, block: B:456:0x0b03  */
    /* JADX WARN: Code duplicated, block: B:457:0x0b07  */
    /* JADX WARN: Code duplicated, block: B:459:0x0b17  */
    /* JADX WARN: Code duplicated, block: B:461:0x0b2a  */
    /* JADX WARN: Code duplicated, block: B:463:0x0b36  */
    /* JADX WARN: Code duplicated, block: B:464:0x0b5c A[PHI: r1 r2 r4 r9 r28
  0x0b5c: PHI (r1v58 com.google.android.gms.internal.measurement.zzig) = 
  (r1v53 com.google.android.gms.internal.measurement.zzig)
  (r1v55 com.google.android.gms.internal.measurement.zzig)
  (r1v56 com.google.android.gms.internal.measurement.zzig)
  (r1v61 com.google.android.gms.internal.measurement.zzig)
 binds: [B:462:0x0b34, B:458:0x0b15, B:456:0x0b03, B:440:0x0a81] A[DONT_GENERATE, DONT_INLINE]
  0x0b5c: PHI (r2v52 int) = (r2v45 int), (r2v48 int), (r2v49 int), (r2v55 int) binds: [B:462:0x0b34, B:458:0x0b15, B:456:0x0b03, B:440:0x0a81] A[DONT_GENERATE, DONT_INLINE]
  0x0b5c: PHI (r4v57 int) = (r4v50 int), (r4v53 int), (r4v54 int), (r4v60 int) binds: [B:462:0x0b34, B:458:0x0b15, B:456:0x0b03, B:440:0x0a81] A[DONT_GENERATE, DONT_INLINE]
  0x0b5c: PHI (r9v58 int) = (r9v49 int), (r9v50 int), (r9v51 int), (r9v61 int) binds: [B:462:0x0b34, B:458:0x0b15, B:456:0x0b03, B:440:0x0a81] A[DONT_GENERATE, DONT_INLINE]
  0x0b5c: PHI (r28v21 sun.misc.Unsafe) = (r28v16 sun.misc.Unsafe), (r28v17 sun.misc.Unsafe), (r28v18 sun.misc.Unsafe), (r28v24 sun.misc.Unsafe) binds: [B:462:0x0b34, B:458:0x0b15, B:456:0x0b03, B:440:0x0a81] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:466:0x0b69  */
    /* JADX WARN: Code duplicated, block: B:468:0x0b79  */
    /* JADX WARN: Code duplicated, block: B:470:0x0b81  */
    /* JADX WARN: Code duplicated, block: B:471:0x0b85  */
    /* JADX WARN: Code duplicated, block: B:480:0x0ba8  */
    /* JADX WARN: Code duplicated, block: B:482:0x0bb7  */
    /* JADX WARN: Code duplicated, block: B:484:0x0bc1  */
    /* JADX WARN: Code duplicated, block: B:485:0x0bc4  */
    /* JADX WARN: Code duplicated, block: B:487:0x0bd2  */
    /* JADX WARN: Code duplicated, block: B:489:0x0bdf  */
    /* JADX WARN: Code duplicated, block: B:490:0x0bf1  */
    /* JADX WARN: Code duplicated, block: B:492:0x0bfe  */
    /* JADX WARN: Code duplicated, block: B:493:0x0c10  */
    /* JADX WARN: Code duplicated, block: B:495:0x0c1c  */
    /* JADX WARN: Code duplicated, block: B:496:0x0c2d  */
    /* JADX WARN: Code duplicated, block: B:498:0x0c39  */
    /* JADX WARN: Code duplicated, block: B:499:0x0c4a  */
    /* JADX WARN: Code duplicated, block: B:501:0x0c57  */
    /* JADX WARN: Code duplicated, block: B:502:0x0c68  */
    /* JADX WARN: Code duplicated, block: B:504:0x0c75  */
    /* JADX WARN: Code duplicated, block: B:506:0x0c87 A[PHI: r2 r4 r5 r19 r27 r28
  0x0c87: PHI (r2v63 int) = 
  (r2v36 int)
  (r2v37 int)
  (r2v38 int)
  (r2v39 int)
  (r2v40 int)
  (r2v41 int)
  (r2v42 int)
  (r2v44 int)
  (r2v51 int)
  (r2v57 int)
  (r2v64 int)
 binds: [B:503:0x0c73, B:500:0x0c55, B:497:0x0c37, B:494:0x0c1a, B:491:0x0bfc, B:488:0x0bdd, B:481:0x0bb5, B:467:0x0b77, B:465:0x0b60, B:438:0x0a66, B:433:0x0a2a] A[DONT_GENERATE, DONT_INLINE]
  0x0c87: PHI (r4v67 int) = 
  (r4v41 int)
  (r4v42 int)
  (r4v43 int)
  (r4v44 int)
  (r4v45 int)
  (r4v46 int)
  (r4v47 int)
  (r4v49 int)
  (r4v56 int)
  (r4v63 int)
  (r4v68 int)
 binds: [B:503:0x0c73, B:500:0x0c55, B:497:0x0c37, B:494:0x0c1a, B:491:0x0bfc, B:488:0x0bdd, B:481:0x0bb5, B:467:0x0b77, B:465:0x0b60, B:438:0x0a66, B:433:0x0a2a] A[DONT_GENERATE, DONT_INLINE]
  0x0c87: PHI (r5v47 com.google.android.gms.internal.measurement.zzig) = 
  (r5v31 com.google.android.gms.internal.measurement.zzig)
  (r5v32 com.google.android.gms.internal.measurement.zzig)
  (r5v33 com.google.android.gms.internal.measurement.zzig)
  (r5v34 com.google.android.gms.internal.measurement.zzig)
  (r5v35 com.google.android.gms.internal.measurement.zzig)
  (r5v36 com.google.android.gms.internal.measurement.zzig)
  (r5v37 com.google.android.gms.internal.measurement.zzig)
  (r5v39 com.google.android.gms.internal.measurement.zzig)
  (r5v42 com.google.android.gms.internal.measurement.zzig)
  (r5v44 com.google.android.gms.internal.measurement.zzig)
  (r5v48 com.google.android.gms.internal.measurement.zzig)
 binds: [B:503:0x0c73, B:500:0x0c55, B:497:0x0c37, B:494:0x0c1a, B:491:0x0bfc, B:488:0x0bdd, B:481:0x0bb5, B:467:0x0b77, B:465:0x0b60, B:438:0x0a66, B:433:0x0a2a] A[DONT_GENERATE, DONT_INLINE]
  0x0c87: PHI (r19v15 int) = 
  (r19v7 int)
  (r19v7 int)
  (r19v7 int)
  (r19v7 int)
  (r19v7 int)
  (r19v7 int)
  (r19v7 int)
  (r19v7 int)
  (r19v9 int)
  (r19v7 int)
  (r19v7 int)
 binds: [B:503:0x0c73, B:500:0x0c55, B:497:0x0c37, B:494:0x0c1a, B:491:0x0bfc, B:488:0x0bdd, B:481:0x0bb5, B:467:0x0b77, B:465:0x0b60, B:438:0x0a66, B:433:0x0a2a] A[DONT_GENERATE, DONT_INLINE]
  0x0c87: PHI (r27v25 int) = 
  (r27v9 int)
  (r27v10 int)
  (r27v11 int)
  (r27v12 int)
  (r27v13 int)
  (r27v14 int)
  (r27v15 int)
  (r27v17 int)
  (r27v19 int)
  (r27v22 int)
  (r27v26 int)
 binds: [B:503:0x0c73, B:500:0x0c55, B:497:0x0c37, B:494:0x0c1a, B:491:0x0bfc, B:488:0x0bdd, B:481:0x0bb5, B:467:0x0b77, B:465:0x0b60, B:438:0x0a66, B:433:0x0a2a] A[DONT_GENERATE, DONT_INLINE]
  0x0c87: PHI (r28v29 sun.misc.Unsafe) = 
  (r28v7 sun.misc.Unsafe)
  (r28v8 sun.misc.Unsafe)
  (r28v9 sun.misc.Unsafe)
  (r28v10 sun.misc.Unsafe)
  (r28v11 sun.misc.Unsafe)
  (r28v12 sun.misc.Unsafe)
  (r28v13 sun.misc.Unsafe)
  (r28v15 sun.misc.Unsafe)
  (r28v20 sun.misc.Unsafe)
  (r28v26 sun.misc.Unsafe)
  (r28v30 sun.misc.Unsafe)
 binds: [B:503:0x0c73, B:500:0x0c55, B:497:0x0c37, B:494:0x0c1a, B:491:0x0bfc, B:488:0x0bdd, B:481:0x0bb5, B:467:0x0b77, B:465:0x0b60, B:438:0x0a66, B:433:0x0a2a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:508:0x0c8a  */
    /* JADX WARN: Code duplicated, block: B:522:0x0ccf  */
    /* JADX WARN: Code duplicated, block: B:525:0x0ce9  */
    /* JADX WARN: Code duplicated, block: B:552:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:553:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:554:0x0153 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:555:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:556:0x01c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:557:0x01e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:558:0x021e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:559:0x025f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:560:0x0286 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:561:0x02a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:562:0x02c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:563:0x02e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:564:0x0320 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:565:0x033e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:566:0x0378 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:567:0x0489 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:568:0x04d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:569:0x059b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:570:0x0596 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:571:0x0589 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:572:0x0584 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:573:0x062d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:574:0x0626 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:575:0x069c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:576:0x0697 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:577:0x0685 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:578:0x0680 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:579:0x06d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:580:0x0730 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:581:0x077c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:582:0x0803 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:583:0x084d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:584:0x0899 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:585:0x08d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:0x004f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:0x0363 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:596:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x0140 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x0164 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x01b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:600:0x01d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:0x020a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:0x024c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:0x0272 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x0290 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x02b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:0x02d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x030c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x032a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x0a12 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x09f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x0130 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x0375 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x03df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x01b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x01b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x030a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x0247 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:0x030a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x030a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x030a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x030a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x0358 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x0358 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:0x03d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x03c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x030a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x007b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x08e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x08c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x0533 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x0533 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:0x0533 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x058e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x057c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:0x0576 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:0x062b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:0x061b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:0x0617 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:0x068a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:674:0x066d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:0x0669 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:684:0x07bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:689:0x07a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:692:0x07a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:695:0x07d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:698:0x07d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0224  */
    /* JADX WARN: Code duplicated, block: B:701:0x07d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0229  */
    /* JADX WARN: Code duplicated, block: B:72:0x0231 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x0233  */
    /* JADX WARN: Code duplicated, block: B:74:0x0236  */
    /* JADX WARN: Code duplicated, block: B:82:0x0269  */
    /* JADX WARN: Code duplicated, block: B:83:0x026b  */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: TypeSearchVarInfo not found in map for var: r5v11 java.lang.Object
    	at jadx.core.dex.visitors.typeinference.TypeSearchState.getVarInfo(TypeSearchState.java:34)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.lambda$resolveIndependentVariables$1(TypeSearch.java:173)
    	at java.base/java.util.stream.MatchOps$1MatchSink.accept(Unknown Source)
    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.test(Unknown Source)
    	at java.base/java.util.stream.MatchOps$1MatchSink.accept(Unknown Source)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(Unknown Source)
    	at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
    	at java.base/java.util.stream.MatchOps$MatchOp.evaluateSequential(Unknown Source)
     */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r10v45 */
    /* JADX WARN: Type inference failed for: r10v46, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v48, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v75 */
    /* JADX WARN: Type inference failed for: r11v76 */
    final int zza(T t, byte[] bArr, int i, int i2, int i3, zzig zzigVar) throws IOException {
        Unsafe unsafe;
        int i4;
        int iZza;
        int i5;
        int i6;
        int i7;
        zzig zzigVar2;
        int i8;
        zzjh zzjhVar;
        int[] iArr;
        int i9;
        int i10;
        long j;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Unsafe unsafe2;
        int i16;
        int i17;
        zzig zzigVar3;
        int i18;
        int iZzc;
        boolean z;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Unsafe unsafe3;
        int i27;
        int i28;
        zzig zzigVar4;
        int i29;
        int i30;
        Unsafe unsafe4;
        int i31;
        Unsafe unsafe5;
        int i32;
        int i33;
        Unsafe unsafe6;
        int i34;
        Unsafe unsafe7;
        long j2;
        int i35;
        int iZzd;
        boolean z2;
        int i36;
        zzig zzigVar5;
        int i37;
        int iZza2;
        int i38;
        zzjy zzjyVarZzd;
        zzig zzigVar6;
        int i39;
        int i40;
        int i41;
        Unsafe unsafe8;
        Object objZzf;
        Object object;
        int i42;
        int i43;
        Unsafe unsafe9;
        int i44;
        int i45;
        int i46;
        long j3;
        Unsafe unsafe10;
        zzkd zzkdVar;
        int i47;
        int i48;
        int i49;
        Unsafe unsafe11;
        zzjg zzjgVar;
        int iZzc2;
        int iZzc3;
        zzjg zzjgVar2;
        int i50;
        zzjq zzjqVar;
        int iZzc4;
        zzjq zzjqVar2;
        int i51;
        zzks zzksVar;
        int iZzc5;
        zzks zzksVar2;
        int i52;
        int i53;
        int i54;
        Unsafe unsafe12;
        zzks zzksVar3;
        int i55;
        int iZzc6;
        zzks zzksVar4;
        int iZzc7;
        int i56;
        zzjv zzjvVar;
        int iZzc8;
        zzjv zzjvVar2;
        int i57;
        zzif zzifVar;
        boolean z3;
        int iZzc9;
        boolean z4;
        zzif zzifVar2;
        int i58;
        boolean z5;
        int iZzc10;
        int i59;
        int i60;
        int iZzc11;
        int i61;
        int i62;
        int i63;
        ?? r10;
        int iZzc12;
        int i64;
        int iZzc13;
        int i65;
        int iZzc14;
        int i66;
        int iZza3;
        zzjv zzjvVar3;
        int iZzc15;
        zzjv zzjvVar4;
        int i67;
        zzks zzksVar5;
        int iZzc16;
        zzks zzksVar6;
        int i68;
        zzlz zzlzVarZze;
        int i69;
        int iZzc17;
        zzkd zzkdVarZza;
        T t2 = t;
        i2 = i2;
        int i70 = i3;
        zzigVar = zzigVar;
        zzf(t);
        Unsafe unsafe13 = zzb;
        int iZza4 = i;
        int i71 = 0;
        int i72 = 0;
        int i73 = 0;
        int i74 = -1;
        int i75 = 1048575;
        while (true) {
            if (iZza4 < i2) {
                int i76 = iZza4 + 1;
                int i77 = bArr[iZza4];
                if (i77 < 0) {
                    int iZza5 = zzid.zza(i77, bArr, i76, zzigVar);
                    i4 = zzigVar.zza;
                    i76 = iZza5;
                } else {
                    i4 = i77;
                }
                int i78 = i4 >>> 3;
                int i79 = i4 & 7;
                if (i78 > i74) {
                    int i80 = i71 / 3;
                    if (i78 < this.zze || i78 > this.zzf) {
                        i6 = -1;
                        i5 = -1;
                    } else {
                        iZza = zza(i78, i80);
                    }
                    if (i5 == i6) {
                        unsafe = unsafe13;
                        i7 = i78;
                        i71 = 0;
                        i3 = i70;
                        zzigVar2 = zzigVar;
                        i8 = i76;
                        i72 = i4;
                    } else {
                        iArr = this.zzc;
                        i9 = iArr[i5 + 1];
                        i10 = (i9 & 267386880) >>> 20;
                        j = i9 & 1048575;
                        if (i10 <= 17) {
                            int i81 = iArr[i5 + 2];
                            i11 = 1 << (i81 >>> 20);
                            i12 = 1048575;
                            i13 = i81 & 1048575;
                            if (i13 != i75) {
                                if (i75 != 1048575) {
                                    unsafe13.putInt(t2, i75, i73);
                                    i12 = 1048575;
                                }
                                if (i13 == i12) {
                                    i73 = 0;
                                } else {
                                    i73 = unsafe13.getInt(t2, i13);
                                }
                                i75 = i13;
                            } else {
                                i75 = i75;
                            }
                            i14 = i73;
                            switch (i10) {
                                case 0:
                                    i15 = i4;
                                    unsafe2 = unsafe13;
                                    i16 = i78;
                                    i17 = i5;
                                    zzigVar3 = zzigVar;
                                    if (i79 == 1) {
                                        zzna.zza(t2, j, zzid.zza(bArr, i76));
                                        iZzc = i76 + 8;
                                        i22 = i14 | i11;
                                        i71 = i17;
                                        zzigVar = zzigVar3;
                                        unsafe13 = unsafe2;
                                        i2 = i2;
                                        i70 = i3;
                                        i72 = i15;
                                        i74 = i16;
                                        i75 = i75;
                                        iZza4 = iZzc;
                                        i73 = i22;
                                    } else {
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                case 1:
                                    i15 = i4;
                                    unsafe2 = unsafe13;
                                    i16 = i78;
                                    i17 = i5;
                                    zzigVar3 = zzigVar;
                                    if (i79 == 5) {
                                        zzna.zza((Object) t2, j, zzid.zzb(bArr, i76));
                                        iZzc = i76 + 4;
                                        i22 = i14 | i11;
                                        i71 = i17;
                                        zzigVar = zzigVar3;
                                        unsafe13 = unsafe2;
                                        i2 = i2;
                                        i70 = i3;
                                        i72 = i15;
                                        i74 = i16;
                                        i75 = i75;
                                        iZza4 = iZzc;
                                        i73 = i22;
                                    } else {
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    i15 = i4;
                                    i18 = i5;
                                    unsafe2 = unsafe13;
                                    i16 = i78;
                                    zzigVar3 = zzigVar;
                                    if (i79 == 0) {
                                        int iZzd2 = zzid.zzd(bArr, i76, zzigVar3);
                                        unsafe2.putLong(t, j, zzigVar3.zzb);
                                        zzigVar = zzigVar3;
                                        i71 = i18;
                                        iZza4 = iZzd2;
                                        unsafe13 = unsafe2;
                                        i2 = i2;
                                        i70 = i3;
                                        i72 = i15 == true ? 1 : 0;
                                        i74 = i16;
                                        i75 = i75;
                                        i73 = i14 | i11;
                                    } else {
                                        i17 = i18;
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    i15 = i4;
                                    i18 = i5;
                                    unsafe2 = unsafe13;
                                    i16 = i78;
                                    zzigVar3 = zzigVar;
                                    if (i79 == 0) {
                                        iZzc = zzid.zzc(bArr, i76, zzigVar3);
                                        unsafe2.putInt(t2, j, zzigVar3.zza);
                                        i17 = i18;
                                        i22 = i14 | i11;
                                        i71 = i17;
                                        zzigVar = zzigVar3;
                                        unsafe13 = unsafe2;
                                        i2 = i2;
                                        i70 = i3;
                                        i72 = i15;
                                        i74 = i16;
                                        i75 = i75;
                                        iZza4 = iZzc;
                                        i73 = i22;
                                    } else {
                                        i17 = i18;
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    i15 = i4;
                                    i18 = i5;
                                    unsafe2 = unsafe13;
                                    i16 = i78;
                                    zzigVar3 = zzigVar;
                                    if (i79 == 1) {
                                        unsafe2.putLong(t, j, zzid.zzd(bArr, i76));
                                        i17 = i18;
                                        iZzc = i76 + 8;
                                        i22 = i14 | i11;
                                        i71 = i17;
                                        zzigVar = zzigVar3;
                                        unsafe13 = unsafe2;
                                        i2 = i2;
                                        i70 = i3;
                                        i72 = i15;
                                        i74 = i16;
                                        i75 = i75;
                                        iZza4 = iZzc;
                                        i73 = i22;
                                    } else {
                                        i17 = i18;
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    i15 = i4;
                                    i18 = i5;
                                    unsafe2 = unsafe13;
                                    i16 = i78;
                                    zzigVar3 = zzigVar;
                                    if (i79 == 5) {
                                        unsafe2.putInt(t2, j, zzid.zzc(bArr, i76));
                                        i17 = i18;
                                        iZzc = i76 + 4;
                                        i22 = i14 | i11;
                                        i71 = i17;
                                        zzigVar = zzigVar3;
                                        unsafe13 = unsafe2;
                                        i2 = i2;
                                        i70 = i3;
                                        i72 = i15;
                                        i74 = i16;
                                        i75 = i75;
                                        iZza4 = iZzc;
                                        i73 = i22;
                                    } else {
                                        i17 = i18;
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                case 7:
                                    i15 = i4;
                                    i18 = i5;
                                    unsafe2 = unsafe13;
                                    i16 = i78;
                                    zzigVar3 = zzigVar;
                                    if (i79 == 0) {
                                        iZzc = zzid.zzd(bArr, i76, zzigVar3);
                                        if (zzigVar3.zzb != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        zzna.zzc(t2, j, z);
                                        i17 = i18;
                                        i22 = i14 | i11;
                                        i71 = i17;
                                        zzigVar = zzigVar3;
                                        unsafe13 = unsafe2;
                                        i2 = i2;
                                        i70 = i3;
                                        i72 = i15;
                                        i74 = i16;
                                        i75 = i75;
                                        iZza4 = iZzc;
                                        i73 = i22;
                                    } else {
                                        i17 = i18;
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                case 8:
                                    i15 = i4;
                                    i18 = i5;
                                    unsafe2 = unsafe13;
                                    i16 = i78;
                                    zzigVar3 = zzigVar;
                                    if (i79 == 2) {
                                        if (zzg(i9)) {
                                            iZzc = zzid.zzb(bArr, i76, zzigVar3);
                                        } else {
                                            iZzc = zzid.zzc(bArr, i76, zzigVar3);
                                            i19 = zzigVar3.zza;
                                            if (i19 >= 0) {
                                                throw zzkc.zzf();
                                            }
                                            if (i19 == 0) {
                                                zzigVar3.zzc = "";
                                            } else {
                                                zzigVar3.zzc = new String(bArr, iZzc, i19, zzjx.zza);
                                                iZzc += i19;
                                            }
                                        }
                                        unsafe2.putObject(t2, j, zzigVar3.zzc);
                                        i17 = i18;
                                        i22 = i14 | i11;
                                        i71 = i17;
                                        zzigVar = zzigVar3;
                                        unsafe13 = unsafe2;
                                        i2 = i2;
                                        i70 = i3;
                                        i72 = i15;
                                        i74 = i16;
                                        i75 = i75;
                                        iZza4 = iZzc;
                                        i73 = i22;
                                    } else {
                                        i17 = i18;
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                case 9:
                                    i2 = i2;
                                    i3 = i3;
                                    i16 = i78;
                                    i20 = i4;
                                    i21 = i5;
                                    zzigVar3 = zzigVar;
                                    unsafe2 = unsafe13;
                                    if (i79 == 2) {
                                        Object objZza = zza((Object) t2, i21);
                                        i15 = i20 == true ? 1 : 0;
                                        iZzc = zzid.zza(objZza, zze(i21), bArr, i76, i2, zzigVar);
                                        zza(t2, i21, objZza);
                                        i22 = i14 | i11;
                                        i17 = i21;
                                        i71 = i17;
                                        zzigVar = zzigVar3;
                                        unsafe13 = unsafe2;
                                        i2 = i2;
                                        i70 = i3;
                                        i72 = i15;
                                        i74 = i16;
                                        i75 = i75;
                                        iZza4 = iZzc;
                                        i73 = i22;
                                    } else {
                                        i15 = i20;
                                        i17 = i21;
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                case 10:
                                    i20 = i4;
                                    i21 = i5;
                                    unsafe2 = unsafe13;
                                    i16 = i78;
                                    zzigVar3 = zzigVar;
                                    if (i79 == 2) {
                                        iZzc = zzid.zza(bArr, i76, zzigVar3);
                                        unsafe2.putObject(t2, j, zzigVar3.zzc);
                                        i15 = i20;
                                        i17 = i21;
                                        i22 = i14 | i11;
                                        i71 = i17;
                                        zzigVar = zzigVar3;
                                        unsafe13 = unsafe2;
                                        i2 = i2;
                                        i70 = i3;
                                        i72 = i15;
                                        i74 = i16;
                                        i75 = i75;
                                        iZza4 = iZzc;
                                        i73 = i22;
                                    } else {
                                        i15 = i20;
                                        i17 = i21;
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                case 12:
                                    i15 = i4;
                                    i23 = i5;
                                    unsafe2 = unsafe13;
                                    i16 = i78;
                                    zzigVar3 = zzigVar;
                                    if (i79 == 0) {
                                        iZzc = zzid.zzc(bArr, i76, zzigVar3);
                                        i24 = zzigVar3.zza;
                                        i21 = i23;
                                        zzjy zzjyVarZzd2 = zzd(i21);
                                        if ((i9 & Integer.MIN_VALUE) != 0 || zzjyVarZzd2 == null || zzjyVarZzd2.zza(i24)) {
                                            i20 = i15 == true ? 1 : 0;
                                            unsafe2.putInt(t2, j, i24);
                                            i15 = i20;
                                            i17 = i21;
                                            i22 = i14 | i11;
                                            i71 = i17;
                                            zzigVar = zzigVar3;
                                            unsafe13 = unsafe2;
                                            i2 = i2;
                                            i70 = i3;
                                            i72 = i15;
                                            i74 = i16;
                                            i75 = i75;
                                            iZza4 = iZzc;
                                            i73 = i22;
                                        } else {
                                            zzmx zzmxVarZze = zze(t);
                                            Long lValueOf = Long.valueOf(i24);
                                            i25 = i15 == true ? 1 : 0;
                                            zzmxVarZze.zza(i25 == true ? 1 : 0, lValueOf);
                                            i26 = i21;
                                            zzigVar = zzigVar3;
                                            unsafe3 = unsafe2;
                                            i75 = i75;
                                            i73 = i14;
                                            iZza4 = iZzc;
                                            i70 = i3;
                                            i71 = i26;
                                            i72 = i25;
                                            i74 = i16;
                                            i2 = i2;
                                            unsafe13 = unsafe3;
                                        }
                                    } else {
                                        i17 = i23;
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                case 15:
                                    i2 = i2;
                                    i3 = i3;
                                    i15 = i4;
                                    i23 = i5;
                                    unsafe2 = unsafe13;
                                    i16 = i78;
                                    zzigVar3 = zzigVar;
                                    if (i79 == 0) {
                                        iZzc = zzid.zzc(bArr, i76, zzigVar3);
                                        unsafe2.putInt(t2, j, zziv.zza(zzigVar3.zza));
                                        i17 = i23;
                                        i22 = i14 | i11;
                                        i71 = i17;
                                        zzigVar = zzigVar3;
                                        unsafe13 = unsafe2;
                                        i2 = i2;
                                        i70 = i3;
                                        i72 = i15;
                                        i74 = i16;
                                        i75 = i75;
                                        iZza4 = iZzc;
                                        i73 = i22;
                                    } else {
                                        i17 = i23;
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                case 16:
                                    i27 = i5;
                                    if (i79 == 0) {
                                        int iZzd3 = zzid.zzd(bArr, i76, zzigVar);
                                        i28 = i27;
                                        unsafe13.putLong(t, j, zziv.zza(zzigVar.zzb));
                                        i73 = i14 | i11;
                                        zzigVar = zzigVar;
                                        i2 = i2;
                                        i70 = i3;
                                        iZza4 = iZzd3;
                                        unsafe13 = unsafe13;
                                        i72 = i4 == true ? 1 : 0;
                                        i74 = i78;
                                        i75 = i75;
                                        i71 = i28;
                                    } else {
                                        zzigVar3 = zzigVar;
                                        i16 = i78;
                                        i15 = i4;
                                        unsafe2 = unsafe13;
                                        i17 = i27;
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                case 17:
                                    if (i79 == 3) {
                                        int i82 = i5;
                                        Object objZza2 = zza((Object) t2, i82);
                                        iZza4 = zzid.zza(objZza2, zze(i82), bArr, i76, i2, (i78 << 3) | 4, zzigVar);
                                        zza(t2, i82, objZza2);
                                        i73 = i14 | i11;
                                        i70 = i3;
                                        i72 = i4 == true ? 1 : 0;
                                        i71 = i82;
                                        i74 = i78;
                                        i75 = i75;
                                        i2 = i2;
                                        zzigVar = zzigVar;
                                    } else {
                                        i16 = i78;
                                        i15 = i4;
                                        zzigVar3 = zzigVar;
                                        unsafe2 = unsafe13;
                                        i17 = i5;
                                        i28 = i17;
                                        zzigVar4 = zzigVar3;
                                        i29 = i15;
                                        i30 = i14;
                                        unsafe4 = unsafe2;
                                        i8 = i76;
                                        zzigVar2 = zzigVar4;
                                        i73 = i30;
                                        i72 = i29;
                                        i7 = i16;
                                        i75 = i75;
                                        unsafe = unsafe4;
                                        i71 = i28;
                                    }
                                    break;
                                default:
                                    i16 = i78;
                                    i15 = i4;
                                    zzigVar3 = zzigVar;
                                    unsafe2 = unsafe13;
                                    i17 = i5;
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                    break;
                            }
                        } else {
                            i31 = i4;
                            unsafe5 = unsafe13;
                            i16 = i78;
                            i26 = i5;
                            if (i10 == 27) {
                                i75 = i75;
                                i30 = i73;
                                zzigVar4 = zzigVar;
                                if (i10 <= 49) {
                                    j3 = i9;
                                    unsafe10 = zzb;
                                    zzkdVar = (zzkd) unsafe10.getObject(t2, j);
                                    if (zzkdVar.zzc()) {
                                        int size = zzkdVar.size();
                                        zzkd zzkdVarZza2 = zzkdVar.zza(size != 0 ? size << 1 : 10);
                                        unsafe10.putObject(t2, j, zzkdVarZza2);
                                        zzkdVar = zzkdVarZza2;
                                    }
                                    switch (i10) {
                                        case 18:
                                        case 35:
                                            i47 = i2;
                                            i3 = i3;
                                            i48 = i26;
                                            iZza4 = i76;
                                            i49 = i31 == true ? 1 : 0;
                                            unsafe11 = unsafe5;
                                            if (i79 == 2) {
                                                if (i79 == 1) {
                                                    zzjgVar = (zzjg) zzkdVar;
                                                    zzjgVar.zza(zzid.zza(bArr, iZza4));
                                                    iZzc2 = iZza4 + 8;
                                                    while (iZzc2 < i47) {
                                                        iZzc3 = zzid.zzc(bArr, iZzc2, zzigVar4);
                                                        if (i49 == zzigVar4.zza) {
                                                            zzjgVar.zza(zzid.zza(bArr, iZzc3));
                                                            iZzc2 = iZzc3 + 8;
                                                        }
                                                    }
                                                } else {
                                                    i53 = i49;
                                                    i75 = i75;
                                                    i76 = iZza4;
                                                }
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            } else {
                                                zzjgVar2 = (zzjg) zzkdVar;
                                                iZzc2 = zzid.zzc(bArr, iZza4, zzigVar4);
                                                i50 = zzigVar4.zza + iZzc2;
                                                while (iZzc2 < i50) {
                                                    zzjgVar2.zza(zzid.zza(bArr, iZzc2));
                                                    iZzc2 += 8;
                                                }
                                                if (iZzc2 != i50) {
                                                    throw zzkc.zzh();
                                                }
                                            }
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            iZza4 = iZzc2;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                        case 19:
                                        case 36:
                                            i47 = i2;
                                            i3 = i3;
                                            i48 = i26;
                                            iZza4 = i76;
                                            i49 = i31 == true ? 1 : 0;
                                            unsafe11 = unsafe5;
                                            if (i79 == 2) {
                                                if (i79 == 5) {
                                                    zzjqVar = (zzjq) zzkdVar;
                                                    zzjqVar.zza(zzid.zzb(bArr, iZza4));
                                                    iZzc2 = iZza4 + 4;
                                                    while (iZzc2 < i47) {
                                                        iZzc4 = zzid.zzc(bArr, iZzc2, zzigVar4);
                                                        if (i49 == zzigVar4.zza) {
                                                            zzjqVar.zza(zzid.zzb(bArr, iZzc4));
                                                            iZzc2 = iZzc4 + 4;
                                                        }
                                                    }
                                                } else {
                                                    i53 = i49;
                                                    i75 = i75;
                                                    i76 = iZza4;
                                                }
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            } else {
                                                zzjqVar2 = (zzjq) zzkdVar;
                                                iZzc2 = zzid.zzc(bArr, iZza4, zzigVar4);
                                                i51 = zzigVar4.zza + iZzc2;
                                                while (iZzc2 < i51) {
                                                    zzjqVar2.zza(zzid.zzb(bArr, iZzc2));
                                                    iZzc2 += 4;
                                                }
                                                if (iZzc2 != i51) {
                                                    throw zzkc.zzh();
                                                }
                                            }
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            iZza4 = iZzc2;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            i47 = i2;
                                            i3 = i3;
                                            i48 = i26;
                                            iZza4 = i76;
                                            i49 = i31 == true ? 1 : 0;
                                            unsafe11 = unsafe5;
                                            if (i79 == 2) {
                                                if (i79 == 0) {
                                                    zzksVar = (zzks) zzkdVar;
                                                    iZzc2 = zzid.zzd(bArr, iZza4, zzigVar4);
                                                    zzksVar.zza(zzigVar4.zzb);
                                                    while (iZzc2 < i47) {
                                                        iZzc5 = zzid.zzc(bArr, iZzc2, zzigVar4);
                                                        if (i49 == zzigVar4.zza) {
                                                            iZzc2 = zzid.zzd(bArr, iZzc5, zzigVar4);
                                                            zzksVar.zza(zzigVar4.zzb);
                                                        }
                                                    }
                                                } else {
                                                    i53 = i49;
                                                    i75 = i75;
                                                    i76 = iZza4;
                                                }
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            } else {
                                                zzksVar2 = (zzks) zzkdVar;
                                                iZzc2 = zzid.zzc(bArr, iZza4, zzigVar4);
                                                i52 = zzigVar4.zza + iZzc2;
                                                while (iZzc2 < i52) {
                                                    iZzc2 = zzid.zzd(bArr, iZzc2, zzigVar4);
                                                    zzksVar2.zza(zzigVar4.zzb);
                                                }
                                                if (iZzc2 != i52) {
                                                    throw zzkc.zzh();
                                                }
                                            }
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            iZza4 = iZzc2;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            i54 = i2;
                                            i3 = i3;
                                            i48 = i26;
                                            i76 = i76;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe12 = unsafe5;
                                            if (i79 == 2) {
                                                if (i79 == 0) {
                                                    unsafe11 = unsafe12;
                                                    i49 = i53 == true ? 1 : 0;
                                                    iZza4 = i76;
                                                    i3 = i3;
                                                    i47 = i54;
                                                    iZzc2 = zzid.zza(i53 == true ? 1 : 0, bArr, i76, i2, (zzkd<?>) zzkdVar, zzigVar);
                                                    i53 = i49;
                                                    i75 = i75;
                                                    i76 = iZza4;
                                                    iZza4 = iZzc2;
                                                    if (iZza4 == i76) {
                                                        i72 = i53;
                                                        i71 = i48;
                                                        i8 = iZza4;
                                                        unsafe = unsafe11;
                                                        zzigVar2 = zzigVar4;
                                                        i73 = i30;
                                                        i7 = i16;
                                                        t2 = t;
                                                    } else {
                                                        i72 = i53;
                                                        i70 = i3;
                                                        i2 = i47;
                                                        unsafe13 = unsafe11;
                                                        zzigVar = zzigVar4;
                                                        i73 = i30;
                                                        i74 = i16;
                                                        i71 = i48;
                                                        t2 = t;
                                                    }
                                                }
                                                unsafe11 = unsafe12;
                                                i49 = i53;
                                                iZza4 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                i53 = i49;
                                                i75 = i75;
                                                i76 = iZza4;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                                break;
                                            } else {
                                                iZza4 = zzid.zza(bArr, i76, (zzkd<?>) zzkdVar, zzigVar4);
                                                unsafe11 = unsafe12;
                                                i76 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                i75 = i75;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            i54 = i2;
                                            i3 = i3;
                                            i48 = i26;
                                            i76 = i76;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe12 = unsafe5;
                                            if (i79 == 2) {
                                                if (i79 == 1) {
                                                    zzksVar3 = (zzks) zzkdVar;
                                                    zzksVar3.zza(zzid.zzd(bArr, i76));
                                                    i55 = i76 + 8;
                                                    while (i55 < i54) {
                                                        iZzc6 = zzid.zzc(bArr, i55, zzigVar4);
                                                        if (i53 == zzigVar4.zza) {
                                                            unsafe11 = unsafe12;
                                                            i3 = i3;
                                                            i47 = i54;
                                                            iZza4 = i55;
                                                            i75 = i75;
                                                            i76 = i76;
                                                            if (iZza4 == i76) {
                                                                i72 = i53;
                                                                i71 = i48;
                                                                i8 = iZza4;
                                                                unsafe = unsafe11;
                                                                zzigVar2 = zzigVar4;
                                                                i73 = i30;
                                                                i7 = i16;
                                                                t2 = t;
                                                            } else {
                                                                i72 = i53;
                                                                i70 = i3;
                                                                i2 = i47;
                                                                unsafe13 = unsafe11;
                                                                zzigVar = zzigVar4;
                                                                i73 = i30;
                                                                i74 = i16;
                                                                i71 = i48;
                                                                t2 = t;
                                                            }
                                                        } else {
                                                            zzksVar3.zza(zzid.zzd(bArr, iZzc6));
                                                            i55 = iZzc6 + 8;
                                                        }
                                                        break;
                                                    }
                                                    unsafe11 = unsafe12;
                                                    i3 = i3;
                                                    i47 = i54;
                                                    iZza4 = i55;
                                                    i75 = i75;
                                                    i76 = i76;
                                                    if (iZza4 == i76) {
                                                        i72 = i53;
                                                        i71 = i48;
                                                        i8 = iZza4;
                                                        unsafe = unsafe11;
                                                        zzigVar2 = zzigVar4;
                                                        i73 = i30;
                                                        i7 = i16;
                                                        t2 = t;
                                                    } else {
                                                        i72 = i53;
                                                        i70 = i3;
                                                        i2 = i47;
                                                        unsafe13 = unsafe11;
                                                        zzigVar = zzigVar4;
                                                        i73 = i30;
                                                        i74 = i16;
                                                        i71 = i48;
                                                        t2 = t;
                                                    }
                                                }
                                                unsafe11 = unsafe12;
                                                i49 = i53;
                                                iZza4 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                i53 = i49;
                                                i75 = i75;
                                                i76 = iZza4;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                                break;
                                            } else {
                                                zzksVar4 = (zzks) zzkdVar;
                                                iZzc7 = zzid.zzc(bArr, i76, zzigVar4);
                                                i56 = zzigVar4.zza + iZzc7;
                                                while (iZzc7 < i56) {
                                                    zzksVar4.zza(zzid.zzd(bArr, iZzc7));
                                                    iZzc7 += 8;
                                                }
                                                if (iZzc7 != i56) {
                                                    throw zzkc.zzh();
                                                }
                                                iZza4 = iZzc7;
                                                unsafe11 = unsafe12;
                                                i76 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                i75 = i75;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            i54 = i2;
                                            i3 = i3;
                                            i48 = i26;
                                            i76 = i76;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe12 = unsafe5;
                                            if (i79 == 2) {
                                                if (i79 == 5) {
                                                    zzjvVar = (zzjv) zzkdVar;
                                                    zzjvVar.zzd(zzid.zzc(bArr, i76));
                                                    i55 = i76 + 4;
                                                    while (i55 < i54) {
                                                        iZzc8 = zzid.zzc(bArr, i55, zzigVar4);
                                                        if (i53 == zzigVar4.zza) {
                                                            unsafe11 = unsafe12;
                                                            i3 = i3;
                                                            i47 = i54;
                                                            iZza4 = i55;
                                                            i75 = i75;
                                                            i76 = i76;
                                                            if (iZza4 == i76) {
                                                                i72 = i53;
                                                                i71 = i48;
                                                                i8 = iZza4;
                                                                unsafe = unsafe11;
                                                                zzigVar2 = zzigVar4;
                                                                i73 = i30;
                                                                i7 = i16;
                                                                t2 = t;
                                                            } else {
                                                                i72 = i53;
                                                                i70 = i3;
                                                                i2 = i47;
                                                                unsafe13 = unsafe11;
                                                                zzigVar = zzigVar4;
                                                                i73 = i30;
                                                                i74 = i16;
                                                                i71 = i48;
                                                                t2 = t;
                                                            }
                                                        } else {
                                                            zzjvVar.zzd(zzid.zzc(bArr, iZzc8));
                                                            i55 = iZzc8 + 4;
                                                        }
                                                        break;
                                                    }
                                                    unsafe11 = unsafe12;
                                                    i3 = i3;
                                                    i47 = i54;
                                                    iZza4 = i55;
                                                    i75 = i75;
                                                    i76 = i76;
                                                    if (iZza4 == i76) {
                                                        i72 = i53;
                                                        i71 = i48;
                                                        i8 = iZza4;
                                                        unsafe = unsafe11;
                                                        zzigVar2 = zzigVar4;
                                                        i73 = i30;
                                                        i7 = i16;
                                                        t2 = t;
                                                    } else {
                                                        i72 = i53;
                                                        i70 = i3;
                                                        i2 = i47;
                                                        unsafe13 = unsafe11;
                                                        zzigVar = zzigVar4;
                                                        i73 = i30;
                                                        i74 = i16;
                                                        i71 = i48;
                                                        t2 = t;
                                                    }
                                                }
                                                unsafe11 = unsafe12;
                                                i49 = i53;
                                                iZza4 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                i53 = i49;
                                                i75 = i75;
                                                i76 = iZza4;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                                break;
                                            } else {
                                                zzjvVar2 = (zzjv) zzkdVar;
                                                iZzc7 = zzid.zzc(bArr, i76, zzigVar4);
                                                i57 = zzigVar4.zza + iZzc7;
                                                while (iZzc7 < i57) {
                                                    zzjvVar2.zzd(zzid.zzc(bArr, iZzc7));
                                                    iZzc7 += 4;
                                                }
                                                if (iZzc7 != i57) {
                                                    throw zzkc.zzh();
                                                }
                                                iZza4 = iZzc7;
                                                unsafe11 = unsafe12;
                                                i76 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                i75 = i75;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            i54 = i2;
                                            i3 = i3;
                                            i48 = i26;
                                            i76 = i76;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe12 = unsafe5;
                                            if (i79 == 2) {
                                                if (i79 == 0) {
                                                    zzifVar = (zzif) zzkdVar;
                                                    int iZzd4 = zzid.zzd(bArr, i76, zzigVar4);
                                                    if (zzigVar4.zzb != 0) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    zzifVar.zza(z3);
                                                    iZza4 = iZzd4;
                                                    while (iZza4 < i54) {
                                                        iZzc9 = zzid.zzc(bArr, iZza4, zzigVar4);
                                                        if (i53 == zzigVar4.zza) {
                                                            iZza4 = zzid.zzd(bArr, iZzc9, zzigVar4);
                                                            if (zzigVar4.zzb != 0) {
                                                                z4 = true;
                                                            } else {
                                                                z4 = false;
                                                            }
                                                            zzifVar.zza(z4);
                                                        }
                                                    }
                                                }
                                                unsafe11 = unsafe12;
                                                i49 = i53;
                                                iZza4 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                i53 = i49;
                                                i75 = i75;
                                                i76 = iZza4;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            } else {
                                                zzifVar2 = (zzif) zzkdVar;
                                                iZzc7 = zzid.zzc(bArr, i76, zzigVar4);
                                                i58 = zzigVar4.zza + iZzc7;
                                                while (iZzc7 < i58) {
                                                    iZzc7 = zzid.zzd(bArr, iZzc7, zzigVar4);
                                                    if (zzigVar4.zzb != 0) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    zzifVar2.zza(z5);
                                                }
                                                if (iZzc7 != i58) {
                                                    throw zzkc.zzh();
                                                }
                                                iZza4 = iZzc7;
                                            }
                                            unsafe11 = unsafe12;
                                            i76 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i75 = i75;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                        case 26:
                                            i54 = i2;
                                            i3 = i3;
                                            i48 = i26;
                                            i76 = i76;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe12 = unsafe5;
                                            if (i79 == 2) {
                                                if ((j3 & 536870912) == 0) {
                                                    iZzc10 = zzid.zzc(bArr, i76, zzigVar4);
                                                    i63 = zzigVar4.zza;
                                                    if (i63 >= 0) {
                                                        throw zzkc.zzf();
                                                    }
                                                    if (i63 == 0) {
                                                        r10 = r5;
                                                        zzkdVar.add(r10);
                                                    } else {
                                                        r10 = r5;
                                                        zzkdVar.add(new String(bArr, iZzc10, i63, zzjx.zza));
                                                        iZzc10 += i63;
                                                    }
                                                    while (iZzc10 < i54) {
                                                        iZzc12 = zzid.zzc(bArr, iZzc10, zzigVar4);
                                                        if (i53 == zzigVar4.zza) {
                                                            iZzc10 = zzid.zzc(bArr, iZzc12, zzigVar4);
                                                            i64 = zzigVar4.zza;
                                                            if (i64 >= 0) {
                                                                throw zzkc.zzf();
                                                            }
                                                            if (i64 == 0) {
                                                                zzkdVar.add(r10);
                                                            } else {
                                                                zzkdVar.add(new String(bArr, iZzc10, i64, zzjx.zza));
                                                                iZzc10 += i64;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    iZzc10 = zzid.zzc(bArr, i76, zzigVar4);
                                                    i59 = zzigVar4.zza;
                                                    if (i59 >= 0) {
                                                        throw zzkc.zzf();
                                                    }
                                                    if (i59 == 0) {
                                                        zzkdVar.add("");
                                                    } else {
                                                        i60 = iZzc10 + i59;
                                                        if (zzne.zzc(bArr, iZzc10, i60)) {
                                                            throw zzkc.zzd();
                                                        }
                                                        zzkdVar.add(new String(bArr, iZzc10, i59, zzjx.zza));
                                                        iZzc10 = i60;
                                                    }
                                                    while (iZzc10 < i54) {
                                                        iZzc11 = zzid.zzc(bArr, iZzc10, zzigVar4);
                                                        if (i53 == zzigVar4.zza) {
                                                            iZzc10 = zzid.zzc(bArr, iZzc11, zzigVar4);
                                                            i61 = zzigVar4.zza;
                                                            if (i61 >= 0) {
                                                                throw zzkc.zzf();
                                                            }
                                                            if (i61 == 0) {
                                                                zzkdVar.add("");
                                                            } else {
                                                                i62 = iZzc10 + i61;
                                                                if (zzne.zzc(bArr, iZzc10, i62)) {
                                                                    throw zzkc.zzd();
                                                                }
                                                                zzkdVar.add(new String(bArr, iZzc10, i61, zzjx.zza));
                                                                iZzc10 = i62;
                                                            }
                                                        } else {
                                                            i53 = i53 == true ? 1 : 0;
                                                            i76 = i76;
                                                            i75 = i75;
                                                        }
                                                    }
                                                    i53 = i53 == true ? 1 : 0;
                                                    i76 = i76;
                                                    i75 = i75;
                                                }
                                                iZza4 = iZzc10;
                                                i3 = i3;
                                                i48 = i48;
                                                i53 = i53;
                                                unsafe11 = unsafe12;
                                                i47 = i54;
                                            } else {
                                                unsafe11 = unsafe12;
                                                i49 = i53;
                                                iZza4 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                i53 = i49;
                                                i75 = i75;
                                                i76 = iZza4;
                                            }
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                        case 27:
                                            i47 = i2;
                                            i48 = i26;
                                            if (i79 == 2) {
                                                zzlz zzlzVarZze2 = zze(i48);
                                                i3 = i3;
                                                i54 = i47;
                                                i76 = i76;
                                                i53 = i31 == true ? 1 : 0;
                                                unsafe12 = unsafe5;
                                                iZza4 = zzid.zza((zzlz<?>) zzlzVarZze2, i31 == true ? 1 : 0, bArr, i76, i2, (zzkd<?>) zzkdVar, zzigVar);
                                                zzigVar4 = zzigVar4;
                                                unsafe11 = unsafe12;
                                                i76 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                i75 = i75;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            }
                                            i54 = i47;
                                            i76 = i76;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe12 = unsafe5;
                                            zzigVar4 = zzigVar4;
                                            unsafe11 = unsafe12;
                                            i49 = i53;
                                            iZza4 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                        case 28:
                                            i47 = i2;
                                            i48 = i26;
                                            if (i79 == 2) {
                                                iZzc13 = zzid.zzc(bArr, i76, zzigVar4);
                                                i65 = zzigVar4.zza;
                                                if (i65 >= 0) {
                                                    throw zzkc.zzf();
                                                }
                                                if (i65 <= bArr.length - iZzc13) {
                                                    throw zzkc.zzh();
                                                }
                                                if (i65 == 0) {
                                                    zzkdVar.add(zzih.zza);
                                                } else {
                                                    zzkdVar.add(zzih.zza(bArr, iZzc13, i65));
                                                    iZzc13 += i65;
                                                }
                                                while (iZzc13 < i47) {
                                                    iZzc14 = zzid.zzc(bArr, iZzc13, zzigVar4);
                                                    if (i31 == zzigVar4.zza) {
                                                        i3 = i3;
                                                        iZza4 = iZzc13;
                                                        i53 = i31 == true ? 1 : 0;
                                                        unsafe11 = unsafe5;
                                                        if (iZza4 == i76) {
                                                            i72 = i53;
                                                            i71 = i48;
                                                            i8 = iZza4;
                                                            unsafe = unsafe11;
                                                            zzigVar2 = zzigVar4;
                                                            i73 = i30;
                                                            i7 = i16;
                                                            t2 = t;
                                                        } else {
                                                            i72 = i53;
                                                            i70 = i3;
                                                            i2 = i47;
                                                            unsafe13 = unsafe11;
                                                            zzigVar = zzigVar4;
                                                            i73 = i30;
                                                            i74 = i16;
                                                            i71 = i48;
                                                            t2 = t;
                                                        }
                                                        break;
                                                    } else {
                                                        iZzc13 = zzid.zzc(bArr, iZzc14, zzigVar4);
                                                        i66 = zzigVar4.zza;
                                                        if (i66 >= 0) {
                                                            throw zzkc.zzf();
                                                        }
                                                        if (i66 <= bArr.length - iZzc13) {
                                                            throw zzkc.zzh();
                                                        }
                                                        if (i66 == 0) {
                                                            zzkdVar.add(zzih.zza);
                                                        } else {
                                                            zzkdVar.add(zzih.zza(bArr, iZzc13, i66));
                                                            iZzc13 += i66;
                                                        }
                                                    }
                                                }
                                                i3 = i3;
                                                iZza4 = iZzc13;
                                                i53 = i31 == true ? 1 : 0;
                                                unsafe11 = unsafe5;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            }
                                            i54 = i47;
                                            i76 = i76;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe12 = unsafe5;
                                            zzigVar4 = zzigVar4;
                                            unsafe11 = unsafe12;
                                            i49 = i53;
                                            iZza4 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            i47 = i2;
                                            i48 = i26;
                                            if (i79 == 2) {
                                                if (i79 == 0) {
                                                    iZza3 = zzid.zza(i31 == true ? 1 : 0, bArr, i76, i2, (zzkd<?>) zzkdVar, zzigVar);
                                                }
                                                i54 = i47;
                                                i76 = i76;
                                                i53 = i31 == true ? 1 : 0;
                                                unsafe12 = unsafe5;
                                                zzigVar4 = zzigVar4;
                                                unsafe11 = unsafe12;
                                                i49 = i53;
                                                iZza4 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                i53 = i49;
                                                i75 = i75;
                                                i76 = iZza4;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            } else {
                                                iZza3 = zzid.zza(bArr, i76, (zzkd<?>) zzkdVar, zzigVar4);
                                            }
                                            int i83 = iZza3;
                                            zzmb.zza(t, i16, zzkdVar, zzd(i48), null, this.zzq);
                                            iZzc13 = i83;
                                            i75 = i75;
                                            i3 = i3;
                                            iZza4 = iZzc13;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe11 = unsafe5;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            i47 = i2;
                                            i48 = i26;
                                            if (i79 == 2) {
                                                if (i79 == 0) {
                                                    zzjvVar3 = (zzjv) zzkdVar;
                                                    iZzc13 = zzid.zzc(bArr, i76, zzigVar4);
                                                    zzjvVar3.zzd(zziv.zza(zzigVar4.zza));
                                                    while (iZzc13 < i47) {
                                                        iZzc15 = zzid.zzc(bArr, iZzc13, zzigVar4);
                                                        if (i31 == zzigVar4.zza) {
                                                            iZzc13 = zzid.zzc(bArr, iZzc15, zzigVar4);
                                                            zzjvVar3.zzd(zziv.zza(zzigVar4.zza));
                                                        }
                                                    }
                                                }
                                                i54 = i47;
                                                i76 = i76;
                                                i53 = i31 == true ? 1 : 0;
                                                unsafe12 = unsafe5;
                                                zzigVar4 = zzigVar4;
                                                unsafe11 = unsafe12;
                                                i49 = i53;
                                                iZza4 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                i53 = i49;
                                                i75 = i75;
                                                i76 = iZza4;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            } else {
                                                zzjvVar4 = (zzjv) zzkdVar;
                                                iZzc13 = zzid.zzc(bArr, i76, zzigVar4);
                                                i67 = zzigVar4.zza + iZzc13;
                                                while (iZzc13 < i67) {
                                                    iZzc13 = zzid.zzc(bArr, iZzc13, zzigVar4);
                                                    zzjvVar4.zzd(zziv.zza(zzigVar4.zza));
                                                }
                                                if (iZzc13 != i67) {
                                                    throw zzkc.zzh();
                                                }
                                            }
                                            i75 = i75;
                                            i3 = i3;
                                            iZza4 = iZzc13;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe11 = unsafe5;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            i47 = i2;
                                            i48 = i26;
                                            if (i79 == 2) {
                                                if (i79 == 0) {
                                                    zzksVar5 = (zzks) zzkdVar;
                                                    iZzc13 = zzid.zzd(bArr, i76, zzigVar4);
                                                    zzksVar5.zza(zziv.zza(zzigVar4.zzb));
                                                    while (iZzc13 < i47) {
                                                        iZzc16 = zzid.zzc(bArr, iZzc13, zzigVar4);
                                                        if (i31 == zzigVar4.zza) {
                                                            iZzc13 = zzid.zzd(bArr, iZzc16, zzigVar4);
                                                            zzksVar5.zza(zziv.zza(zzigVar4.zzb));
                                                        }
                                                    }
                                                }
                                                i54 = i47;
                                                i76 = i76;
                                                i53 = i31 == true ? 1 : 0;
                                                unsafe12 = unsafe5;
                                                zzigVar4 = zzigVar4;
                                                unsafe11 = unsafe12;
                                                i49 = i53;
                                                iZza4 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                i53 = i49;
                                                i75 = i75;
                                                i76 = iZza4;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            } else {
                                                zzksVar6 = (zzks) zzkdVar;
                                                iZzc13 = zzid.zzc(bArr, i76, zzigVar4);
                                                i68 = zzigVar4.zza + iZzc13;
                                                while (iZzc13 < i68) {
                                                    iZzc13 = zzid.zzd(bArr, iZzc13, zzigVar4);
                                                    zzksVar6.zza(zziv.zza(zzigVar4.zzb));
                                                }
                                                if (iZzc13 != i68) {
                                                    throw zzkc.zzh();
                                                }
                                            }
                                            i75 = i75;
                                            i3 = i3;
                                            iZza4 = iZzc13;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe11 = unsafe5;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                            if (i79 == 3) {
                                                zzlzVarZze = zze(i26);
                                                i69 = ((i31 == true ? 1 : 0) & (-8)) | 4;
                                                i48 = i26;
                                                i47 = i2;
                                                iZzc13 = zzid.zza(zzlzVarZze, bArr, i76, i2, i69, zzigVar);
                                                zzkdVar.add(zzigVar4.zzc);
                                                while (iZzc13 < i47) {
                                                    iZzc17 = zzid.zzc(bArr, iZzc13, zzigVar4);
                                                    if (i31 == zzigVar4.zza) {
                                                        i75 = i75;
                                                        i3 = i3;
                                                        iZza4 = iZzc13;
                                                        i53 = i31 == true ? 1 : 0;
                                                        unsafe11 = unsafe5;
                                                        if (iZza4 == i76) {
                                                            i72 = i53;
                                                            i71 = i48;
                                                            i8 = iZza4;
                                                            unsafe = unsafe11;
                                                            zzigVar2 = zzigVar4;
                                                            i73 = i30;
                                                            i7 = i16;
                                                            t2 = t;
                                                        } else {
                                                            i72 = i53;
                                                            i70 = i3;
                                                            i2 = i47;
                                                            unsafe13 = unsafe11;
                                                            zzigVar = zzigVar4;
                                                            i73 = i30;
                                                            i74 = i16;
                                                            i71 = i48;
                                                            t2 = t;
                                                        }
                                                    } else {
                                                        iZzc13 = zzid.zza(zzlzVarZze, bArr, iZzc17, i2, i69, zzigVar);
                                                        zzkdVar.add(zzigVar4.zzc);
                                                    }
                                                    break;
                                                }
                                                i75 = i75;
                                                i3 = i3;
                                                iZza4 = iZzc13;
                                                i53 = i31 == true ? 1 : 0;
                                                unsafe11 = unsafe5;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            } else {
                                                i48 = i26;
                                                i54 = i2;
                                                i76 = i76;
                                                i53 = i31 == true ? 1 : 0;
                                                unsafe12 = unsafe5;
                                                zzigVar4 = zzigVar4;
                                                unsafe11 = unsafe12;
                                                i49 = i53;
                                                iZza4 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                i53 = i49;
                                                i75 = i75;
                                                i76 = iZza4;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            }
                                            break;
                                        default:
                                            i47 = i2;
                                            i3 = i3;
                                            i48 = i26;
                                            iZza4 = i76;
                                            i49 = i31 == true ? 1 : 0;
                                            unsafe11 = unsafe5;
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                    }
                                } else {
                                    i32 = i76;
                                    i33 = i31 == true ? 1 : 0;
                                    unsafe6 = unsafe5;
                                    if (i10 == 50) {
                                        i28 = i26;
                                        i34 = i33 == true ? 1 : 0;
                                        t2 = t;
                                        unsafe7 = zzb;
                                        j2 = iArr[i28 + 2] & 1048575;
                                        switch (i10) {
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                i28 = i28;
                                                zzigVar2 = zzigVar4;
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                i35 = i32;
                                                if (i79 == 1) {
                                                    unsafe7.putObject(t2, j, Double.valueOf(zzid.zza(bArr, i35)));
                                                    iZzd = i35 + 8;
                                                    unsafe7.putInt(t2, j2, i7);
                                                    iZza4 = iZzd;
                                                } else {
                                                    iZza4 = i35;
                                                }
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                                break;
                                            case 52:
                                                i28 = i28;
                                                zzigVar2 = zzigVar4;
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                i35 = i32;
                                                if (i79 == 5) {
                                                    unsafe7.putObject(t2, j, Float.valueOf(zzid.zzb(bArr, i35)));
                                                    iZzd = i35 + 4;
                                                    unsafe7.putInt(t2, j2, i7);
                                                    iZza4 = iZzd;
                                                } else {
                                                    iZza4 = i35;
                                                }
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                            case 54:
                                                i28 = i28;
                                                zzigVar2 = zzigVar4;
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                i35 = i32;
                                                if (i79 == 0) {
                                                    iZzd = zzid.zzd(bArr, i35, zzigVar2);
                                                    unsafe7.putObject(t2, j, Long.valueOf(zzigVar2.zzb));
                                                    unsafe7.putInt(t2, j2, i7);
                                                    iZza4 = iZzd;
                                                } else {
                                                    iZza4 = i35;
                                                }
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                            case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                                                i28 = i28;
                                                zzigVar2 = zzigVar4;
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                i35 = i32;
                                                if (i79 == 0) {
                                                    iZzd = zzid.zzc(bArr, i35, zzigVar2);
                                                    unsafe7.putObject(t2, j, Integer.valueOf(zzigVar2.zza));
                                                    unsafe7.putInt(t2, j2, i7);
                                                    iZza4 = iZzd;
                                                } else {
                                                    iZza4 = i35;
                                                }
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                i28 = i28;
                                                zzigVar2 = zzigVar4;
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                i35 = i32;
                                                if (i79 == 1) {
                                                    unsafe7.putObject(t2, j, Long.valueOf(zzid.zzd(bArr, i35)));
                                                    iZzd = i35 + 8;
                                                    unsafe7.putInt(t2, j2, i7);
                                                    iZza4 = iZzd;
                                                } else {
                                                    iZza4 = i35;
                                                }
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                i28 = i28;
                                                zzigVar2 = zzigVar4;
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                i35 = i32;
                                                if (i79 == 5) {
                                                    unsafe7.putObject(t2, j, Integer.valueOf(zzid.zzc(bArr, i35)));
                                                    iZzd = i35 + 4;
                                                    unsafe7.putInt(t2, j2, i7);
                                                    iZza4 = iZzd;
                                                } else {
                                                    iZza4 = i35;
                                                }
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                                break;
                                            case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                                                i28 = i28;
                                                zzigVar2 = zzigVar4;
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                i35 = i32;
                                                if (i79 == 0) {
                                                    iZzd = zzid.zzd(bArr, i35, zzigVar2);
                                                    if (zzigVar2.zzb != 0) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    unsafe7.putObject(t2, j, Boolean.valueOf(z2));
                                                    unsafe7.putInt(t2, j2, i7);
                                                    iZza4 = iZzd;
                                                } else {
                                                    iZza4 = i35;
                                                }
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                                break;
                                            case 59:
                                                i28 = i28;
                                                zzigVar2 = zzigVar4;
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                i35 = i32;
                                                if (i79 == 2) {
                                                    iZzd = zzid.zzc(bArr, i35, zzigVar2);
                                                    i36 = zzigVar2.zza;
                                                    if (i36 == 0) {
                                                        unsafe7.putObject(t2, j, "");
                                                    } else {
                                                        if ((i9 & 536870912) == 0 && !zzne.zzc(bArr, iZzd, iZzd + i36)) {
                                                            throw zzkc.zzd();
                                                        }
                                                        unsafe7.putObject(t2, j, new String(bArr, iZzd, i36, zzjx.zza));
                                                        iZzd += i36;
                                                    }
                                                    unsafe7.putInt(t2, j2, i7);
                                                    iZza4 = iZzd;
                                                } else {
                                                    iZza4 = i35;
                                                }
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                                break;
                                            case 60:
                                                zzigVar5 = zzigVar4;
                                                i37 = i34 == true ? 1 : 0;
                                                i35 = i32;
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                if (i79 == 2) {
                                                    Object objZza3 = zza(t2, i7, i28);
                                                    int iZza6 = zzid.zza(objZza3, zze(i28), bArr, i35, i2, zzigVar);
                                                    zza(t2, i7, i28, objZza3);
                                                    iZza4 = iZza6;
                                                    i34 = i37 == true ? 1 : 0;
                                                    zzigVar2 = zzigVar5;
                                                    i28 = i28;
                                                } else {
                                                    zzigVar6 = zzigVar5;
                                                    i39 = i35;
                                                    i40 = i7;
                                                    i34 = i37;
                                                    zzigVar2 = zzigVar6;
                                                    i35 = i39;
                                                    i7 = i40;
                                                    i28 = i28;
                                                    iZza4 = i35;
                                                }
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                                break;
                                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                i37 = i34 == true ? 1 : 0;
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                zzigVar5 = zzigVar4;
                                                i35 = i32;
                                                if (i79 == 2) {
                                                    iZza2 = zzid.zza(bArr, i35, zzigVar5);
                                                    unsafe7.putObject(t2, j, zzigVar5.zzc);
                                                    unsafe7.putInt(t2, j2, i7);
                                                    iZza4 = iZza2;
                                                    i34 = i37;
                                                    zzigVar2 = zzigVar5;
                                                    if (iZza4 == i35) {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i3 = i3;
                                                        i8 = iZza4;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    } else {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i70 = i3;
                                                        i74 = i7;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    }
                                                }
                                                zzigVar6 = zzigVar5;
                                                i39 = i35;
                                                i40 = i7;
                                                i34 = i37;
                                                zzigVar2 = zzigVar6;
                                                i35 = i39;
                                                i7 = i40;
                                                i28 = i28;
                                                iZza4 = i35;
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                                break;
                                            case 63:
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                zzigVar5 = zzigVar4;
                                                i35 = i32;
                                                if (i79 == 0) {
                                                    iZza2 = zzid.zzc(bArr, i35, zzigVar5);
                                                    i38 = zzigVar5.zza;
                                                    zzjyVarZzd = zzd(i28);
                                                    if (zzjyVarZzd != null || zzjyVarZzd.zza(i38)) {
                                                        i37 = i34 == true ? 1 : 0;
                                                        unsafe7.putObject(t2, j, Integer.valueOf(i38));
                                                        unsafe7.putInt(t2, j2, i7);
                                                    } else {
                                                        zzmx zzmxVarZze2 = zze(t);
                                                        Long lValueOf2 = Long.valueOf(i38);
                                                        i37 = i34 == true ? 1 : 0;
                                                        zzmxVarZze2.zza(i37 == true ? 1 : 0, lValueOf2);
                                                    }
                                                    iZza4 = iZza2;
                                                    i34 = i37;
                                                    zzigVar2 = zzigVar5;
                                                    if (iZza4 == i35) {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i3 = i3;
                                                        i8 = iZza4;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    } else {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i70 = i3;
                                                        i74 = i7;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    }
                                                } else {
                                                    i37 = i34 == true ? 1 : 0;
                                                    zzigVar6 = zzigVar5;
                                                    i39 = i35;
                                                    i40 = i7;
                                                    i34 = i37;
                                                    zzigVar2 = zzigVar6;
                                                    i35 = i39;
                                                    i7 = i40;
                                                    i28 = i28;
                                                    iZza4 = i35;
                                                    if (iZza4 == i35) {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i3 = i3;
                                                        i8 = iZza4;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    } else {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i70 = i3;
                                                        i74 = i7;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    }
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                zzigVar5 = zzigVar4;
                                                i35 = i32;
                                                if (i79 == 0) {
                                                    iZza2 = zzid.zzc(bArr, i35, zzigVar5);
                                                    unsafe7.putObject(t2, j, Integer.valueOf(zziv.zza(zzigVar5.zza)));
                                                    unsafe7.putInt(t2, j2, i7);
                                                    i37 = i34;
                                                    iZza4 = iZza2;
                                                    i34 = i37;
                                                    zzigVar2 = zzigVar5;
                                                    if (iZza4 == i35) {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i3 = i3;
                                                        i8 = iZza4;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    } else {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i70 = i3;
                                                        i74 = i7;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    }
                                                } else {
                                                    zzigVar6 = zzigVar5;
                                                    i39 = i35;
                                                    i40 = i7;
                                                    i37 = i34 == true ? 1 : 0;
                                                    i34 = i37;
                                                    zzigVar2 = zzigVar6;
                                                    i35 = i39;
                                                    i7 = i40;
                                                    i28 = i28;
                                                    iZza4 = i35;
                                                    if (iZza4 == i35) {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i3 = i3;
                                                        i8 = iZza4;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    } else {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i70 = i3;
                                                        i74 = i7;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    }
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                                                i37 = i34 == true ? 1 : 0;
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                zzigVar5 = zzigVar4;
                                                i35 = i32;
                                                if (i79 == 0) {
                                                    iZza2 = zzid.zzd(bArr, i35, zzigVar5);
                                                    i34 = i37 == true ? 1 : 0;
                                                    unsafe7.putObject(t2, j, Long.valueOf(zziv.zza(zzigVar5.zzb)));
                                                    unsafe7.putInt(t2, j2, i7);
                                                    i37 = i34;
                                                    iZza4 = iZza2;
                                                    i34 = i37;
                                                    zzigVar2 = zzigVar5;
                                                    if (iZza4 == i35) {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i3 = i3;
                                                        i8 = iZza4;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    } else {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i70 = i3;
                                                        i74 = i7;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    }
                                                }
                                                zzigVar6 = zzigVar5;
                                                i39 = i35;
                                                i40 = i7;
                                                i34 = i37;
                                                zzigVar2 = zzigVar6;
                                                i35 = i39;
                                                i7 = i40;
                                                i28 = i28;
                                                iZza4 = i35;
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                                break;
                                            case 68:
                                                if (i79 == 3) {
                                                    i7 = i16;
                                                    Object objZza4 = zza(t2, i7, i28);
                                                    i35 = i32;
                                                    unsafe = unsafe6;
                                                    zzigVar5 = zzigVar4;
                                                    iZza4 = zzid.zza(objZza4, zze(i28), bArr, i32, i2, ((i34 == true ? 1 : 0) & (-8)) | 4, zzigVar);
                                                    zza(t2, i7, i28, objZza4);
                                                    zzigVar2 = zzigVar5;
                                                    if (iZza4 == i35) {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i3 = i3;
                                                        i8 = iZza4;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    } else {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i70 = i3;
                                                        i74 = i7;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    }
                                                } else {
                                                    unsafe = unsafe6;
                                                    i28 = i28;
                                                    zzigVar2 = zzigVar4;
                                                    i35 = i32;
                                                    i7 = i16;
                                                    iZza4 = i35;
                                                    if (iZza4 == i35) {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i3 = i3;
                                                        i8 = iZza4;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    } else {
                                                        i35 = i35;
                                                        i7 = i7;
                                                        i70 = i3;
                                                        i74 = i7;
                                                        i73 = i30;
                                                        i72 = i34;
                                                        i75 = i75;
                                                        i71 = i28;
                                                    }
                                                }
                                                break;
                                            default:
                                                i28 = i28;
                                                zzigVar2 = zzigVar4;
                                                i35 = i32;
                                                i7 = i16;
                                                unsafe = unsafe6;
                                                iZza4 = i35;
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                                break;
                                        }
                                    } else if (i79 == 2) {
                                        unsafe8 = zzb;
                                        objZzf = zzf(i26);
                                        int i84 = i26;
                                        t2 = t;
                                        object = unsafe8.getObject(t2, j);
                                        if (this.zzs.zzf(object)) {
                                            Object objZzb = this.zzs.zzb(objZzf);
                                            this.zzs.zza(objZzb, object);
                                            unsafe8.putObject(t2, j, objZzb);
                                            object = objZzb;
                                        }
                                        zzky<?, ?> zzkyVarZza = this.zzs.zza(objZzf);
                                        Map<?, ?> mapZze = this.zzs.zze(object);
                                        int iZzc18 = zzid.zzc(bArr, i32, zzigVar4);
                                        i42 = zzigVar4.zza;
                                        if (i42 >= 0 || i42 > i2 - iZzc18) {
                                            throw zzkc.zzh();
                                        }
                                        int i85 = iZzc18 + i42;
                                        Object obj = zzkyVarZza.zzb;
                                        Object obj2 = zzkyVarZza.zzd;
                                        Object obj3 = obj;
                                        while (iZzc18 < i85) {
                                            int iZza7 = iZzc18 + 1;
                                            int i86 = bArr[iZzc18];
                                            if (i86 < 0) {
                                                iZza7 = zzid.zza(i86, bArr, iZza7, zzigVar4);
                                                i86 = zzigVar4.zza;
                                            }
                                            Object obj4 = obj2;
                                            int i87 = i86 >>> 3;
                                            int i88 = i32;
                                            int i89 = i86 & 7;
                                            Object obj5 = obj3;
                                            if (i87 == 1) {
                                                i43 = i84;
                                                unsafe9 = unsafe6;
                                                i44 = i88;
                                                i45 = i33;
                                                i46 = i85;
                                                if (i89 == zzkyVarZza.zza.zza()) {
                                                    iZzc18 = zza(bArr, iZza7, i2, zzkyVarZza.zza, (Class<?>) null, zzigVar);
                                                    obj3 = zzigVar4.zzc;
                                                    obj2 = obj4;
                                                }
                                                i85 = i46;
                                                i32 = i44;
                                                i33 = i45;
                                                unsafe6 = unsafe9;
                                                i84 = i43;
                                            } else {
                                                if (i87 == 2 && i89 == zzkyVarZza.zzc.zza()) {
                                                    unsafe9 = unsafe6;
                                                    i44 = i88;
                                                    i43 = i84;
                                                    obj5 = obj5;
                                                    i45 = i33;
                                                    i46 = i85;
                                                    iZzc18 = zza(bArr, iZza7, i2, zzkyVarZza.zzc, zzkyVarZza.zzd.getClass(), zzigVar);
                                                    obj2 = zzigVar4.zzc;
                                                } else {
                                                    i43 = i84;
                                                    unsafe9 = unsafe6;
                                                    i44 = i88;
                                                    i45 = i33;
                                                    i46 = i85;
                                                }
                                                obj3 = obj5;
                                                i85 = i46;
                                                i32 = i44;
                                                i33 = i45;
                                                unsafe6 = unsafe9;
                                                i84 = i43;
                                            }
                                            obj2 = obj4;
                                            iZzc18 = zzid.zza(i86, bArr, iZza7, i2, zzigVar4);
                                            obj3 = obj5;
                                            i85 = i46;
                                            i32 = i44;
                                            i33 = i45;
                                            unsafe6 = unsafe9;
                                            i84 = i43;
                                        }
                                        i28 = i84;
                                        i29 = i33;
                                        unsafe4 = unsafe6;
                                        int i90 = i32;
                                        Object obj6 = obj3;
                                        i76 = i85;
                                        if (iZzc18 != i76) {
                                            throw zzkc.zzg();
                                        }
                                        mapZze.put(obj6, obj2);
                                        if (i76 == i90) {
                                            i8 = i76;
                                            zzigVar2 = zzigVar4;
                                            i73 = i30;
                                            i72 = i29;
                                            i7 = i16;
                                            i75 = i75;
                                            unsafe = unsafe4;
                                            i71 = i28;
                                        } else {
                                            i70 = i3;
                                            iZza4 = i76;
                                            i2 = i2;
                                            zzigVar = zzigVar4;
                                            i73 = i30;
                                            i72 = i29 == true ? 1 : 0;
                                            i74 = i16;
                                            i75 = i75;
                                            unsafe13 = unsafe4;
                                            i71 = i28;
                                        }
                                    } else {
                                        i28 = i26;
                                        i29 = i33 == true ? 1 : 0;
                                        unsafe4 = unsafe6;
                                        t2 = t;
                                        i41 = i32;
                                    }
                                    unsafe13 = unsafe;
                                }
                            } else if (i79 == 2) {
                                zzkdVarZza = (zzkd) unsafe5.getObject(t2, j);
                                if (!zzkdVarZza.zzc()) {
                                    int size2 = zzkdVarZza.size();
                                    zzkdVarZza = zzkdVarZza.zza(size2 != 0 ? size2 << 1 : 10);
                                    unsafe5.putObject(t2, j, zzkdVarZza);
                                }
                                zzlz zzlzVarZze3 = zze(i26);
                                zzigVar = zzigVar;
                                unsafe3 = unsafe5;
                                i25 = i31 == true ? 1 : 0;
                                iZza4 = zzid.zza((zzlz<?>) zzlzVarZze3, i31 == true ? 1 : 0, bArr, i76, i2, (zzkd<?>) zzkdVarZza, zzigVar);
                                i73 = i73;
                                i75 = i75;
                                i70 = i3;
                                i71 = i26;
                                i72 = i25;
                                i74 = i16;
                                i2 = i2;
                                unsafe13 = unsafe3;
                            } else {
                                i75 = i75;
                                i30 = i73;
                                i28 = i26;
                                i29 = i31 == true ? 1 : 0;
                                zzigVar4 = zzigVar;
                                unsafe4 = unsafe5;
                                i41 = i76;
                            }
                            i8 = i41;
                            zzigVar2 = zzigVar4;
                            i73 = i30;
                            i72 = i29;
                            i7 = i16;
                            i75 = i75;
                            unsafe = unsafe4;
                            i71 = i28;
                        }
                    }
                    if (i72 == i3 || i3 == 0) {
                        if (!this.zzh && (zzjhVar = zzigVar2.zzd) != zzjh.zza) {
                            if (zzjhVar.zza(this.zzg, i7) == null) {
                                iZza4 = zzid.zza((i72 == true ? 1 : 0) == true ? 1 : 0, bArr, i8, i2, zze(t), zzigVar);
                            } else {
                                zzju.zzb zzbVar = (zzju.zzb) t2;
                                zzbVar.zza();
                                zzjk<zzju.zze> zzjkVar = zzbVar.zzc;
                                throw new NoSuchMethodError();
                            }
                        } else {
                            iZza4 = zzid.zza((i72 == true ? 1 : 0) == true ? 1 : 0, bArr, i8, i2, zze(t), zzigVar);
                        }
                        i70 = i3;
                        i74 = i7;
                        unsafe13 = unsafe;
                    } else {
                        iZza4 = i8;
                    }
                } else {
                    iZza = zza(i78);
                }
                i5 = iZza;
                i6 = -1;
                if (i5 == i6) {
                    unsafe = unsafe13;
                    i7 = i78;
                    i71 = 0;
                    i3 = i70;
                    zzigVar2 = zzigVar;
                    i8 = i76;
                    i72 = i4;
                } else {
                    iArr = this.zzc;
                    i9 = iArr[i5 + 1];
                    i10 = (i9 & 267386880) >>> 20;
                    j = i9 & 1048575;
                    if (i10 <= 17) {
                        int i810 = iArr[i5 + 2];
                        i11 = 1 << (i810 >>> 20);
                        i12 = 1048575;
                        i13 = i810 & 1048575;
                        if (i13 != i75) {
                            if (i75 != 1048575) {
                                unsafe13.putInt(t2, i75, i73);
                                i12 = 1048575;
                            }
                            if (i13 == i12) {
                                i73 = 0;
                            } else {
                                i73 = unsafe13.getInt(t2, i13);
                            }
                            i75 = i13;
                        } else {
                            i75 = i75;
                        }
                        i14 = i73;
                        switch (i10) {
                            case 0:
                                i15 = i4;
                                unsafe2 = unsafe13;
                                i16 = i78;
                                i17 = i5;
                                zzigVar3 = zzigVar;
                                if (i79 == 1) {
                                    zzna.zza(t2, j, zzid.zza(bArr, i76));
                                    iZzc = i76 + 8;
                                    i22 = i14 | i11;
                                    i71 = i17;
                                    zzigVar = zzigVar3;
                                    unsafe13 = unsafe2;
                                    i2 = i2;
                                    i70 = i3;
                                    i72 = i15;
                                    i74 = i16;
                                    i75 = i75;
                                    iZza4 = iZzc;
                                    i73 = i22;
                                } else {
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            case 1:
                                i15 = i4;
                                unsafe2 = unsafe13;
                                i16 = i78;
                                i17 = i5;
                                zzigVar3 = zzigVar;
                                if (i79 == 5) {
                                    zzna.zza((Object) t2, j, zzid.zzb(bArr, i76));
                                    iZzc = i76 + 4;
                                    i22 = i14 | i11;
                                    i71 = i17;
                                    zzigVar = zzigVar3;
                                    unsafe13 = unsafe2;
                                    i2 = i2;
                                    i70 = i3;
                                    i72 = i15;
                                    i74 = i16;
                                    i75 = i75;
                                    iZza4 = iZzc;
                                    i73 = i22;
                                } else {
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            case 2:
                            case 3:
                                i15 = i4;
                                i18 = i5;
                                unsafe2 = unsafe13;
                                i16 = i78;
                                zzigVar3 = zzigVar;
                                if (i79 == 0) {
                                    int iZzd5 = zzid.zzd(bArr, i76, zzigVar3);
                                    unsafe2.putLong(t, j, zzigVar3.zzb);
                                    zzigVar = zzigVar3;
                                    i71 = i18;
                                    iZza4 = iZzd5;
                                    unsafe13 = unsafe2;
                                    i2 = i2;
                                    i70 = i3;
                                    i72 = i15 == true ? 1 : 0;
                                    i74 = i16;
                                    i75 = i75;
                                    i73 = i14 | i11;
                                } else {
                                    i17 = i18;
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            case 4:
                            case 11:
                                i15 = i4;
                                i18 = i5;
                                unsafe2 = unsafe13;
                                i16 = i78;
                                zzigVar3 = zzigVar;
                                if (i79 == 0) {
                                    iZzc = zzid.zzc(bArr, i76, zzigVar3);
                                    unsafe2.putInt(t2, j, zzigVar3.zza);
                                    i17 = i18;
                                    i22 = i14 | i11;
                                    i71 = i17;
                                    zzigVar = zzigVar3;
                                    unsafe13 = unsafe2;
                                    i2 = i2;
                                    i70 = i3;
                                    i72 = i15;
                                    i74 = i16;
                                    i75 = i75;
                                    iZza4 = iZzc;
                                    i73 = i22;
                                } else {
                                    i17 = i18;
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            case 5:
                            case 14:
                                i15 = i4;
                                i18 = i5;
                                unsafe2 = unsafe13;
                                i16 = i78;
                                zzigVar3 = zzigVar;
                                if (i79 == 1) {
                                    unsafe2.putLong(t, j, zzid.zzd(bArr, i76));
                                    i17 = i18;
                                    iZzc = i76 + 8;
                                    i22 = i14 | i11;
                                    i71 = i17;
                                    zzigVar = zzigVar3;
                                    unsafe13 = unsafe2;
                                    i2 = i2;
                                    i70 = i3;
                                    i72 = i15;
                                    i74 = i16;
                                    i75 = i75;
                                    iZza4 = iZzc;
                                    i73 = i22;
                                } else {
                                    i17 = i18;
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            case 6:
                            case 13:
                                i15 = i4;
                                i18 = i5;
                                unsafe2 = unsafe13;
                                i16 = i78;
                                zzigVar3 = zzigVar;
                                if (i79 == 5) {
                                    unsafe2.putInt(t2, j, zzid.zzc(bArr, i76));
                                    i17 = i18;
                                    iZzc = i76 + 4;
                                    i22 = i14 | i11;
                                    i71 = i17;
                                    zzigVar = zzigVar3;
                                    unsafe13 = unsafe2;
                                    i2 = i2;
                                    i70 = i3;
                                    i72 = i15;
                                    i74 = i16;
                                    i75 = i75;
                                    iZza4 = iZzc;
                                    i73 = i22;
                                } else {
                                    i17 = i18;
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            case 7:
                                i15 = i4;
                                i18 = i5;
                                unsafe2 = unsafe13;
                                i16 = i78;
                                zzigVar3 = zzigVar;
                                if (i79 == 0) {
                                    iZzc = zzid.zzd(bArr, i76, zzigVar3);
                                    if (zzigVar3.zzb != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zzna.zzc(t2, j, z);
                                    i17 = i18;
                                    i22 = i14 | i11;
                                    i71 = i17;
                                    zzigVar = zzigVar3;
                                    unsafe13 = unsafe2;
                                    i2 = i2;
                                    i70 = i3;
                                    i72 = i15;
                                    i74 = i16;
                                    i75 = i75;
                                    iZza4 = iZzc;
                                    i73 = i22;
                                } else {
                                    i17 = i18;
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            case 8:
                                i15 = i4;
                                i18 = i5;
                                unsafe2 = unsafe13;
                                i16 = i78;
                                zzigVar3 = zzigVar;
                                if (i79 == 2) {
                                    if (zzg(i9)) {
                                        iZzc = zzid.zzb(bArr, i76, zzigVar3);
                                    } else {
                                        iZzc = zzid.zzc(bArr, i76, zzigVar3);
                                        i19 = zzigVar3.zza;
                                        if (i19 >= 0) {
                                            throw zzkc.zzf();
                                        }
                                        if (i19 == 0) {
                                            zzigVar3.zzc = "";
                                        } else {
                                            zzigVar3.zzc = new String(bArr, iZzc, i19, zzjx.zza);
                                            iZzc += i19;
                                        }
                                    }
                                    unsafe2.putObject(t2, j, zzigVar3.zzc);
                                    i17 = i18;
                                    i22 = i14 | i11;
                                    i71 = i17;
                                    zzigVar = zzigVar3;
                                    unsafe13 = unsafe2;
                                    i2 = i2;
                                    i70 = i3;
                                    i72 = i15;
                                    i74 = i16;
                                    i75 = i75;
                                    iZza4 = iZzc;
                                    i73 = i22;
                                } else {
                                    i17 = i18;
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            case 9:
                                i2 = i2;
                                i3 = i3;
                                i16 = i78;
                                i20 = i4;
                                i21 = i5;
                                zzigVar3 = zzigVar;
                                unsafe2 = unsafe13;
                                if (i79 == 2) {
                                    Object objZza5 = zza((Object) t2, i21);
                                    i15 = i20 == true ? 1 : 0;
                                    iZzc = zzid.zza(objZza5, zze(i21), bArr, i76, i2, zzigVar);
                                    zza(t2, i21, objZza5);
                                    i22 = i14 | i11;
                                    i17 = i21;
                                    i71 = i17;
                                    zzigVar = zzigVar3;
                                    unsafe13 = unsafe2;
                                    i2 = i2;
                                    i70 = i3;
                                    i72 = i15;
                                    i74 = i16;
                                    i75 = i75;
                                    iZza4 = iZzc;
                                    i73 = i22;
                                } else {
                                    i15 = i20;
                                    i17 = i21;
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            case 10:
                                i20 = i4;
                                i21 = i5;
                                unsafe2 = unsafe13;
                                i16 = i78;
                                zzigVar3 = zzigVar;
                                if (i79 == 2) {
                                    iZzc = zzid.zza(bArr, i76, zzigVar3);
                                    unsafe2.putObject(t2, j, zzigVar3.zzc);
                                    i15 = i20;
                                    i17 = i21;
                                    i22 = i14 | i11;
                                    i71 = i17;
                                    zzigVar = zzigVar3;
                                    unsafe13 = unsafe2;
                                    i2 = i2;
                                    i70 = i3;
                                    i72 = i15;
                                    i74 = i16;
                                    i75 = i75;
                                    iZza4 = iZzc;
                                    i73 = i22;
                                } else {
                                    i15 = i20;
                                    i17 = i21;
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            case 12:
                                i15 = i4;
                                i23 = i5;
                                unsafe2 = unsafe13;
                                i16 = i78;
                                zzigVar3 = zzigVar;
                                if (i79 == 0) {
                                    iZzc = zzid.zzc(bArr, i76, zzigVar3);
                                    i24 = zzigVar3.zza;
                                    i21 = i23;
                                    zzjy zzjyVarZzd3 = zzd(i21);
                                    if ((i9 & Integer.MIN_VALUE) != 0) {
                                    }
                                    i20 = i15 == true ? 1 : 0;
                                    unsafe2.putInt(t2, j, i24);
                                    i15 = i20;
                                    i17 = i21;
                                    i22 = i14 | i11;
                                    i71 = i17;
                                    zzigVar = zzigVar3;
                                    unsafe13 = unsafe2;
                                    i2 = i2;
                                    i70 = i3;
                                    i72 = i15;
                                    i74 = i16;
                                    i75 = i75;
                                    iZza4 = iZzc;
                                    i73 = i22;
                                } else {
                                    i17 = i23;
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            case 15:
                                i2 = i2;
                                i3 = i3;
                                i15 = i4;
                                i23 = i5;
                                unsafe2 = unsafe13;
                                i16 = i78;
                                zzigVar3 = zzigVar;
                                if (i79 == 0) {
                                    iZzc = zzid.zzc(bArr, i76, zzigVar3);
                                    unsafe2.putInt(t2, j, zziv.zza(zzigVar3.zza));
                                    i17 = i23;
                                    i22 = i14 | i11;
                                    i71 = i17;
                                    zzigVar = zzigVar3;
                                    unsafe13 = unsafe2;
                                    i2 = i2;
                                    i70 = i3;
                                    i72 = i15;
                                    i74 = i16;
                                    i75 = i75;
                                    iZza4 = iZzc;
                                    i73 = i22;
                                } else {
                                    i17 = i23;
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            case 16:
                                i27 = i5;
                                if (i79 == 0) {
                                    int iZzd6 = zzid.zzd(bArr, i76, zzigVar);
                                    i28 = i27;
                                    unsafe13.putLong(t, j, zziv.zza(zzigVar.zzb));
                                    i73 = i14 | i11;
                                    zzigVar = zzigVar;
                                    i2 = i2;
                                    i70 = i3;
                                    iZza4 = iZzd6;
                                    unsafe13 = unsafe13;
                                    i72 = i4 == true ? 1 : 0;
                                    i74 = i78;
                                    i75 = i75;
                                    i71 = i28;
                                } else {
                                    zzigVar3 = zzigVar;
                                    i16 = i78;
                                    i15 = i4;
                                    unsafe2 = unsafe13;
                                    i17 = i27;
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            case 17:
                                if (i79 == 3) {
                                    int i811 = i5;
                                    Object objZza6 = zza((Object) t2, i811);
                                    iZza4 = zzid.zza(objZza6, zze(i811), bArr, i76, i2, (i78 << 3) | 4, zzigVar);
                                    zza(t2, i811, objZza6);
                                    i73 = i14 | i11;
                                    i70 = i3;
                                    i72 = i4 == true ? 1 : 0;
                                    i71 = i811;
                                    i74 = i78;
                                    i75 = i75;
                                    i2 = i2;
                                    zzigVar = zzigVar;
                                } else {
                                    i16 = i78;
                                    i15 = i4;
                                    zzigVar3 = zzigVar;
                                    unsafe2 = unsafe13;
                                    i17 = i5;
                                    i28 = i17;
                                    zzigVar4 = zzigVar3;
                                    i29 = i15;
                                    i30 = i14;
                                    unsafe4 = unsafe2;
                                    i8 = i76;
                                    zzigVar2 = zzigVar4;
                                    i73 = i30;
                                    i72 = i29;
                                    i7 = i16;
                                    i75 = i75;
                                    unsafe = unsafe4;
                                    i71 = i28;
                                }
                                break;
                            default:
                                i16 = i78;
                                i15 = i4;
                                zzigVar3 = zzigVar;
                                unsafe2 = unsafe13;
                                i17 = i5;
                                i28 = i17;
                                zzigVar4 = zzigVar3;
                                i29 = i15;
                                i30 = i14;
                                unsafe4 = unsafe2;
                                i8 = i76;
                                zzigVar2 = zzigVar4;
                                i73 = i30;
                                i72 = i29;
                                i7 = i16;
                                i75 = i75;
                                unsafe = unsafe4;
                                i71 = i28;
                                break;
                        }
                    } else {
                        i31 = i4;
                        unsafe5 = unsafe13;
                        i16 = i78;
                        i26 = i5;
                        if (i10 == 27) {
                            i75 = i75;
                            i30 = i73;
                            zzigVar4 = zzigVar;
                            if (i10 <= 49) {
                                j3 = i9;
                                unsafe10 = zzb;
                                zzkdVar = (zzkd) unsafe10.getObject(t2, j);
                                if (zzkdVar.zzc()) {
                                    int size3 = zzkdVar.size();
                                    zzkd zzkdVarZza3 = zzkdVar.zza(size3 != 0 ? size3 << 1 : 10);
                                    unsafe10.putObject(t2, j, zzkdVarZza3);
                                    zzkdVar = zzkdVarZza3;
                                }
                                switch (i10) {
                                    case 18:
                                    case 35:
                                        i47 = i2;
                                        i3 = i3;
                                        i48 = i26;
                                        iZza4 = i76;
                                        i49 = i31 == true ? 1 : 0;
                                        unsafe11 = unsafe5;
                                        if (i79 == 2) {
                                            if (i79 == 1) {
                                                zzjgVar = (zzjg) zzkdVar;
                                                zzjgVar.zza(zzid.zza(bArr, iZza4));
                                                iZzc2 = iZza4 + 8;
                                                while (iZzc2 < i47) {
                                                    iZzc3 = zzid.zzc(bArr, iZzc2, zzigVar4);
                                                    if (i49 == zzigVar4.zza) {
                                                        zzjgVar.zza(zzid.zza(bArr, iZzc3));
                                                        iZzc2 = iZzc3 + 8;
                                                    }
                                                }
                                            } else {
                                                i53 = i49;
                                                i75 = i75;
                                                i76 = iZza4;
                                            }
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        } else {
                                            zzjgVar2 = (zzjg) zzkdVar;
                                            iZzc2 = zzid.zzc(bArr, iZza4, zzigVar4);
                                            i50 = zzigVar4.zza + iZzc2;
                                            while (iZzc2 < i50) {
                                                zzjgVar2.zza(zzid.zza(bArr, iZzc2));
                                                iZzc2 += 8;
                                            }
                                            if (iZzc2 != i50) {
                                                throw zzkc.zzh();
                                            }
                                        }
                                        i53 = i49;
                                        i75 = i75;
                                        i76 = iZza4;
                                        iZza4 = iZzc2;
                                        if (iZza4 == i76) {
                                            i72 = i53;
                                            i71 = i48;
                                            i8 = iZza4;
                                            unsafe = unsafe11;
                                            zzigVar2 = zzigVar4;
                                            i73 = i30;
                                            i7 = i16;
                                            t2 = t;
                                        } else {
                                            i72 = i53;
                                            i70 = i3;
                                            i2 = i47;
                                            unsafe13 = unsafe11;
                                            zzigVar = zzigVar4;
                                            i73 = i30;
                                            i74 = i16;
                                            i71 = i48;
                                            t2 = t;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        i47 = i2;
                                        i3 = i3;
                                        i48 = i26;
                                        iZza4 = i76;
                                        i49 = i31 == true ? 1 : 0;
                                        unsafe11 = unsafe5;
                                        if (i79 == 2) {
                                            if (i79 == 5) {
                                                zzjqVar = (zzjq) zzkdVar;
                                                zzjqVar.zza(zzid.zzb(bArr, iZza4));
                                                iZzc2 = iZza4 + 4;
                                                while (iZzc2 < i47) {
                                                    iZzc4 = zzid.zzc(bArr, iZzc2, zzigVar4);
                                                    if (i49 == zzigVar4.zza) {
                                                        zzjqVar.zza(zzid.zzb(bArr, iZzc4));
                                                        iZzc2 = iZzc4 + 4;
                                                    }
                                                }
                                            } else {
                                                i53 = i49;
                                                i75 = i75;
                                                i76 = iZza4;
                                            }
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        } else {
                                            zzjqVar2 = (zzjq) zzkdVar;
                                            iZzc2 = zzid.zzc(bArr, iZza4, zzigVar4);
                                            i51 = zzigVar4.zza + iZzc2;
                                            while (iZzc2 < i51) {
                                                zzjqVar2.zza(zzid.zzb(bArr, iZzc2));
                                                iZzc2 += 4;
                                            }
                                            if (iZzc2 != i51) {
                                                throw zzkc.zzh();
                                            }
                                        }
                                        i53 = i49;
                                        i75 = i75;
                                        i76 = iZza4;
                                        iZza4 = iZzc2;
                                        if (iZza4 == i76) {
                                            i72 = i53;
                                            i71 = i48;
                                            i8 = iZza4;
                                            unsafe = unsafe11;
                                            zzigVar2 = zzigVar4;
                                            i73 = i30;
                                            i7 = i16;
                                            t2 = t;
                                        } else {
                                            i72 = i53;
                                            i70 = i3;
                                            i2 = i47;
                                            unsafe13 = unsafe11;
                                            zzigVar = zzigVar4;
                                            i73 = i30;
                                            i74 = i16;
                                            i71 = i48;
                                            t2 = t;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        i47 = i2;
                                        i3 = i3;
                                        i48 = i26;
                                        iZza4 = i76;
                                        i49 = i31 == true ? 1 : 0;
                                        unsafe11 = unsafe5;
                                        if (i79 == 2) {
                                            if (i79 == 0) {
                                                zzksVar = (zzks) zzkdVar;
                                                iZzc2 = zzid.zzd(bArr, iZza4, zzigVar4);
                                                zzksVar.zza(zzigVar4.zzb);
                                                while (iZzc2 < i47) {
                                                    iZzc5 = zzid.zzc(bArr, iZzc2, zzigVar4);
                                                    if (i49 == zzigVar4.zza) {
                                                        iZzc2 = zzid.zzd(bArr, iZzc5, zzigVar4);
                                                        zzksVar.zza(zzigVar4.zzb);
                                                    }
                                                }
                                            } else {
                                                i53 = i49;
                                                i75 = i75;
                                                i76 = iZza4;
                                            }
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        } else {
                                            zzksVar2 = (zzks) zzkdVar;
                                            iZzc2 = zzid.zzc(bArr, iZza4, zzigVar4);
                                            i52 = zzigVar4.zza + iZzc2;
                                            while (iZzc2 < i52) {
                                                iZzc2 = zzid.zzd(bArr, iZzc2, zzigVar4);
                                                zzksVar2.zza(zzigVar4.zzb);
                                            }
                                            if (iZzc2 != i52) {
                                                throw zzkc.zzh();
                                            }
                                        }
                                        i53 = i49;
                                        i75 = i75;
                                        i76 = iZza4;
                                        iZza4 = iZzc2;
                                        if (iZza4 == i76) {
                                            i72 = i53;
                                            i71 = i48;
                                            i8 = iZza4;
                                            unsafe = unsafe11;
                                            zzigVar2 = zzigVar4;
                                            i73 = i30;
                                            i7 = i16;
                                            t2 = t;
                                        } else {
                                            i72 = i53;
                                            i70 = i3;
                                            i2 = i47;
                                            unsafe13 = unsafe11;
                                            zzigVar = zzigVar4;
                                            i73 = i30;
                                            i74 = i16;
                                            i71 = i48;
                                            t2 = t;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        i54 = i2;
                                        i3 = i3;
                                        i48 = i26;
                                        i76 = i76;
                                        i53 = i31 == true ? 1 : 0;
                                        unsafe12 = unsafe5;
                                        if (i79 == 2) {
                                            if (i79 == 0) {
                                                unsafe11 = unsafe12;
                                                i49 = i53 == true ? 1 : 0;
                                                iZza4 = i76;
                                                i3 = i3;
                                                i47 = i54;
                                                iZzc2 = zzid.zza(i53 == true ? 1 : 0, bArr, i76, i2, (zzkd<?>) zzkdVar, zzigVar);
                                                i53 = i49;
                                                i75 = i75;
                                                i76 = iZza4;
                                                iZza4 = iZzc2;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            }
                                            unsafe11 = unsafe12;
                                            i49 = i53;
                                            iZza4 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                        } else {
                                            iZza4 = zzid.zza(bArr, i76, (zzkd<?>) zzkdVar, zzigVar4);
                                            unsafe11 = unsafe12;
                                            i76 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i75 = i75;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        i54 = i2;
                                        i3 = i3;
                                        i48 = i26;
                                        i76 = i76;
                                        i53 = i31 == true ? 1 : 0;
                                        unsafe12 = unsafe5;
                                        if (i79 == 2) {
                                            if (i79 == 1) {
                                                zzksVar3 = (zzks) zzkdVar;
                                                zzksVar3.zza(zzid.zzd(bArr, i76));
                                                i55 = i76 + 8;
                                                while (i55 < i54) {
                                                    iZzc6 = zzid.zzc(bArr, i55, zzigVar4);
                                                    if (i53 == zzigVar4.zza) {
                                                        unsafe11 = unsafe12;
                                                        i3 = i3;
                                                        i47 = i54;
                                                        iZza4 = i55;
                                                        i75 = i75;
                                                        i76 = i76;
                                                        if (iZza4 == i76) {
                                                            i72 = i53;
                                                            i71 = i48;
                                                            i8 = iZza4;
                                                            unsafe = unsafe11;
                                                            zzigVar2 = zzigVar4;
                                                            i73 = i30;
                                                            i7 = i16;
                                                            t2 = t;
                                                        } else {
                                                            i72 = i53;
                                                            i70 = i3;
                                                            i2 = i47;
                                                            unsafe13 = unsafe11;
                                                            zzigVar = zzigVar4;
                                                            i73 = i30;
                                                            i74 = i16;
                                                            i71 = i48;
                                                            t2 = t;
                                                        }
                                                    } else {
                                                        zzksVar3.zza(zzid.zzd(bArr, iZzc6));
                                                        i55 = iZzc6 + 8;
                                                    }
                                                    break;
                                                }
                                                unsafe11 = unsafe12;
                                                i3 = i3;
                                                i47 = i54;
                                                iZza4 = i55;
                                                i75 = i75;
                                                i76 = i76;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            }
                                            unsafe11 = unsafe12;
                                            i49 = i53;
                                            iZza4 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                        } else {
                                            zzksVar4 = (zzks) zzkdVar;
                                            iZzc7 = zzid.zzc(bArr, i76, zzigVar4);
                                            i56 = zzigVar4.zza + iZzc7;
                                            while (iZzc7 < i56) {
                                                zzksVar4.zza(zzid.zzd(bArr, iZzc7));
                                                iZzc7 += 8;
                                            }
                                            if (iZzc7 != i56) {
                                                throw zzkc.zzh();
                                            }
                                            iZza4 = iZzc7;
                                            unsafe11 = unsafe12;
                                            i76 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i75 = i75;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        i54 = i2;
                                        i3 = i3;
                                        i48 = i26;
                                        i76 = i76;
                                        i53 = i31 == true ? 1 : 0;
                                        unsafe12 = unsafe5;
                                        if (i79 == 2) {
                                            if (i79 == 5) {
                                                zzjvVar = (zzjv) zzkdVar;
                                                zzjvVar.zzd(zzid.zzc(bArr, i76));
                                                i55 = i76 + 4;
                                                while (i55 < i54) {
                                                    iZzc8 = zzid.zzc(bArr, i55, zzigVar4);
                                                    if (i53 == zzigVar4.zza) {
                                                        unsafe11 = unsafe12;
                                                        i3 = i3;
                                                        i47 = i54;
                                                        iZza4 = i55;
                                                        i75 = i75;
                                                        i76 = i76;
                                                        if (iZza4 == i76) {
                                                            i72 = i53;
                                                            i71 = i48;
                                                            i8 = iZza4;
                                                            unsafe = unsafe11;
                                                            zzigVar2 = zzigVar4;
                                                            i73 = i30;
                                                            i7 = i16;
                                                            t2 = t;
                                                        } else {
                                                            i72 = i53;
                                                            i70 = i3;
                                                            i2 = i47;
                                                            unsafe13 = unsafe11;
                                                            zzigVar = zzigVar4;
                                                            i73 = i30;
                                                            i74 = i16;
                                                            i71 = i48;
                                                            t2 = t;
                                                        }
                                                    } else {
                                                        zzjvVar.zzd(zzid.zzc(bArr, iZzc8));
                                                        i55 = iZzc8 + 4;
                                                    }
                                                    break;
                                                }
                                                unsafe11 = unsafe12;
                                                i3 = i3;
                                                i47 = i54;
                                                iZza4 = i55;
                                                i75 = i75;
                                                i76 = i76;
                                                if (iZza4 == i76) {
                                                    i72 = i53;
                                                    i71 = i48;
                                                    i8 = iZza4;
                                                    unsafe = unsafe11;
                                                    zzigVar2 = zzigVar4;
                                                    i73 = i30;
                                                    i7 = i16;
                                                    t2 = t;
                                                } else {
                                                    i72 = i53;
                                                    i70 = i3;
                                                    i2 = i47;
                                                    unsafe13 = unsafe11;
                                                    zzigVar = zzigVar4;
                                                    i73 = i30;
                                                    i74 = i16;
                                                    i71 = i48;
                                                    t2 = t;
                                                }
                                            }
                                            unsafe11 = unsafe12;
                                            i49 = i53;
                                            iZza4 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                            break;
                                        } else {
                                            zzjvVar2 = (zzjv) zzkdVar;
                                            iZzc7 = zzid.zzc(bArr, i76, zzigVar4);
                                            i57 = zzigVar4.zza + iZzc7;
                                            while (iZzc7 < i57) {
                                                zzjvVar2.zzd(zzid.zzc(bArr, iZzc7));
                                                iZzc7 += 4;
                                            }
                                            if (iZzc7 != i57) {
                                                throw zzkc.zzh();
                                            }
                                            iZza4 = iZzc7;
                                            unsafe11 = unsafe12;
                                            i76 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i75 = i75;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        i54 = i2;
                                        i3 = i3;
                                        i48 = i26;
                                        i76 = i76;
                                        i53 = i31 == true ? 1 : 0;
                                        unsafe12 = unsafe5;
                                        if (i79 == 2) {
                                            if (i79 == 0) {
                                                zzifVar = (zzif) zzkdVar;
                                                int iZzd7 = zzid.zzd(bArr, i76, zzigVar4);
                                                if (zzigVar4.zzb != 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                zzifVar.zza(z3);
                                                iZza4 = iZzd7;
                                                while (iZza4 < i54) {
                                                    iZzc9 = zzid.zzc(bArr, iZza4, zzigVar4);
                                                    if (i53 == zzigVar4.zza) {
                                                        iZza4 = zzid.zzd(bArr, iZzc9, zzigVar4);
                                                        if (zzigVar4.zzb != 0) {
                                                            z4 = true;
                                                        } else {
                                                            z4 = false;
                                                        }
                                                        zzifVar.zza(z4);
                                                    }
                                                }
                                            }
                                            unsafe11 = unsafe12;
                                            i49 = i53;
                                            iZza4 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        } else {
                                            zzifVar2 = (zzif) zzkdVar;
                                            iZzc7 = zzid.zzc(bArr, i76, zzigVar4);
                                            i58 = zzigVar4.zza + iZzc7;
                                            while (iZzc7 < i58) {
                                                iZzc7 = zzid.zzd(bArr, iZzc7, zzigVar4);
                                                if (zzigVar4.zzb != 0) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                zzifVar2.zza(z5);
                                            }
                                            if (iZzc7 != i58) {
                                                throw zzkc.zzh();
                                            }
                                            iZza4 = iZzc7;
                                        }
                                        unsafe11 = unsafe12;
                                        i76 = i76;
                                        i3 = i3;
                                        i47 = i54;
                                        i75 = i75;
                                        if (iZza4 == i76) {
                                            i72 = i53;
                                            i71 = i48;
                                            i8 = iZza4;
                                            unsafe = unsafe11;
                                            zzigVar2 = zzigVar4;
                                            i73 = i30;
                                            i7 = i16;
                                            t2 = t;
                                        } else {
                                            i72 = i53;
                                            i70 = i3;
                                            i2 = i47;
                                            unsafe13 = unsafe11;
                                            zzigVar = zzigVar4;
                                            i73 = i30;
                                            i74 = i16;
                                            i71 = i48;
                                            t2 = t;
                                        }
                                        break;
                                    case 26:
                                        i54 = i2;
                                        i3 = i3;
                                        i48 = i26;
                                        i76 = i76;
                                        i53 = i31 == true ? 1 : 0;
                                        unsafe12 = unsafe5;
                                        if (i79 == 2) {
                                            if ((j3 & 536870912) == 0) {
                                                iZzc10 = zzid.zzc(bArr, i76, zzigVar4);
                                                i63 = zzigVar4.zza;
                                                if (i63 >= 0) {
                                                    throw zzkc.zzf();
                                                }
                                                if (i63 == 0) {
                                                    r10 = r5;
                                                    zzkdVar.add(r10);
                                                } else {
                                                    r10 = r5;
                                                    zzkdVar.add(new String(bArr, iZzc10, i63, zzjx.zza));
                                                    iZzc10 += i63;
                                                }
                                                while (iZzc10 < i54) {
                                                    iZzc12 = zzid.zzc(bArr, iZzc10, zzigVar4);
                                                    if (i53 == zzigVar4.zza) {
                                                        iZzc10 = zzid.zzc(bArr, iZzc12, zzigVar4);
                                                        i64 = zzigVar4.zza;
                                                        if (i64 >= 0) {
                                                            throw zzkc.zzf();
                                                        }
                                                        if (i64 == 0) {
                                                            zzkdVar.add(r10);
                                                        } else {
                                                            zzkdVar.add(new String(bArr, iZzc10, i64, zzjx.zza));
                                                            iZzc10 += i64;
                                                        }
                                                    }
                                                }
                                            } else {
                                                iZzc10 = zzid.zzc(bArr, i76, zzigVar4);
                                                i59 = zzigVar4.zza;
                                                if (i59 >= 0) {
                                                    throw zzkc.zzf();
                                                }
                                                if (i59 == 0) {
                                                    zzkdVar.add("");
                                                } else {
                                                    i60 = iZzc10 + i59;
                                                    if (zzne.zzc(bArr, iZzc10, i60)) {
                                                        throw zzkc.zzd();
                                                    }
                                                    zzkdVar.add(new String(bArr, iZzc10, i59, zzjx.zza));
                                                    iZzc10 = i60;
                                                }
                                                while (iZzc10 < i54) {
                                                    iZzc11 = zzid.zzc(bArr, iZzc10, zzigVar4);
                                                    if (i53 == zzigVar4.zza) {
                                                        iZzc10 = zzid.zzc(bArr, iZzc11, zzigVar4);
                                                        i61 = zzigVar4.zza;
                                                        if (i61 >= 0) {
                                                            throw zzkc.zzf();
                                                        }
                                                        if (i61 == 0) {
                                                            zzkdVar.add("");
                                                        } else {
                                                            i62 = iZzc10 + i61;
                                                            if (zzne.zzc(bArr, iZzc10, i62)) {
                                                                throw zzkc.zzd();
                                                            }
                                                            zzkdVar.add(new String(bArr, iZzc10, i61, zzjx.zza));
                                                            iZzc10 = i62;
                                                        }
                                                    } else {
                                                        i53 = i53 == true ? 1 : 0;
                                                        i76 = i76;
                                                        i75 = i75;
                                                    }
                                                }
                                                i53 = i53 == true ? 1 : 0;
                                                i76 = i76;
                                                i75 = i75;
                                            }
                                            iZza4 = iZzc10;
                                            i3 = i3;
                                            i48 = i48;
                                            i53 = i53;
                                            unsafe11 = unsafe12;
                                            i47 = i54;
                                        } else {
                                            unsafe11 = unsafe12;
                                            i49 = i53;
                                            iZza4 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                        }
                                        if (iZza4 == i76) {
                                            i72 = i53;
                                            i71 = i48;
                                            i8 = iZza4;
                                            unsafe = unsafe11;
                                            zzigVar2 = zzigVar4;
                                            i73 = i30;
                                            i7 = i16;
                                            t2 = t;
                                        } else {
                                            i72 = i53;
                                            i70 = i3;
                                            i2 = i47;
                                            unsafe13 = unsafe11;
                                            zzigVar = zzigVar4;
                                            i73 = i30;
                                            i74 = i16;
                                            i71 = i48;
                                            t2 = t;
                                        }
                                        break;
                                    case 27:
                                        i47 = i2;
                                        i48 = i26;
                                        if (i79 == 2) {
                                            zzlz zzlzVarZze4 = zze(i48);
                                            i3 = i3;
                                            i54 = i47;
                                            i76 = i76;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe12 = unsafe5;
                                            iZza4 = zzid.zza((zzlz<?>) zzlzVarZze4, i31 == true ? 1 : 0, bArr, i76, i2, (zzkd<?>) zzkdVar, zzigVar);
                                            zzigVar4 = zzigVar4;
                                            unsafe11 = unsafe12;
                                            i76 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i75 = i75;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        }
                                        i54 = i47;
                                        i76 = i76;
                                        i53 = i31 == true ? 1 : 0;
                                        unsafe12 = unsafe5;
                                        zzigVar4 = zzigVar4;
                                        unsafe11 = unsafe12;
                                        i49 = i53;
                                        iZza4 = i76;
                                        i3 = i3;
                                        i47 = i54;
                                        i53 = i49;
                                        i75 = i75;
                                        i76 = iZza4;
                                        if (iZza4 == i76) {
                                            i72 = i53;
                                            i71 = i48;
                                            i8 = iZza4;
                                            unsafe = unsafe11;
                                            zzigVar2 = zzigVar4;
                                            i73 = i30;
                                            i7 = i16;
                                            t2 = t;
                                        } else {
                                            i72 = i53;
                                            i70 = i3;
                                            i2 = i47;
                                            unsafe13 = unsafe11;
                                            zzigVar = zzigVar4;
                                            i73 = i30;
                                            i74 = i16;
                                            i71 = i48;
                                            t2 = t;
                                        }
                                        break;
                                    case 28:
                                        i47 = i2;
                                        i48 = i26;
                                        if (i79 == 2) {
                                            iZzc13 = zzid.zzc(bArr, i76, zzigVar4);
                                            i65 = zzigVar4.zza;
                                            if (i65 >= 0) {
                                                throw zzkc.zzf();
                                            }
                                            if (i65 <= bArr.length - iZzc13) {
                                                throw zzkc.zzh();
                                            }
                                            if (i65 == 0) {
                                                zzkdVar.add(zzih.zza);
                                            } else {
                                                zzkdVar.add(zzih.zza(bArr, iZzc13, i65));
                                                iZzc13 += i65;
                                            }
                                            while (iZzc13 < i47) {
                                                iZzc14 = zzid.zzc(bArr, iZzc13, zzigVar4);
                                                if (i31 == zzigVar4.zza) {
                                                    i3 = i3;
                                                    iZza4 = iZzc13;
                                                    i53 = i31 == true ? 1 : 0;
                                                    unsafe11 = unsafe5;
                                                    if (iZza4 == i76) {
                                                        i72 = i53;
                                                        i71 = i48;
                                                        i8 = iZza4;
                                                        unsafe = unsafe11;
                                                        zzigVar2 = zzigVar4;
                                                        i73 = i30;
                                                        i7 = i16;
                                                        t2 = t;
                                                    } else {
                                                        i72 = i53;
                                                        i70 = i3;
                                                        i2 = i47;
                                                        unsafe13 = unsafe11;
                                                        zzigVar = zzigVar4;
                                                        i73 = i30;
                                                        i74 = i16;
                                                        i71 = i48;
                                                        t2 = t;
                                                    }
                                                    break;
                                                } else {
                                                    iZzc13 = zzid.zzc(bArr, iZzc14, zzigVar4);
                                                    i66 = zzigVar4.zza;
                                                    if (i66 >= 0) {
                                                        throw zzkc.zzf();
                                                    }
                                                    if (i66 <= bArr.length - iZzc13) {
                                                        throw zzkc.zzh();
                                                    }
                                                    if (i66 == 0) {
                                                        zzkdVar.add(zzih.zza);
                                                    } else {
                                                        zzkdVar.add(zzih.zza(bArr, iZzc13, i66));
                                                        iZzc13 += i66;
                                                    }
                                                }
                                            }
                                            i3 = i3;
                                            iZza4 = iZzc13;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe11 = unsafe5;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        }
                                        i54 = i47;
                                        i76 = i76;
                                        i53 = i31 == true ? 1 : 0;
                                        unsafe12 = unsafe5;
                                        zzigVar4 = zzigVar4;
                                        unsafe11 = unsafe12;
                                        i49 = i53;
                                        iZza4 = i76;
                                        i3 = i3;
                                        i47 = i54;
                                        i53 = i49;
                                        i75 = i75;
                                        i76 = iZza4;
                                        if (iZza4 == i76) {
                                            i72 = i53;
                                            i71 = i48;
                                            i8 = iZza4;
                                            unsafe = unsafe11;
                                            zzigVar2 = zzigVar4;
                                            i73 = i30;
                                            i7 = i16;
                                            t2 = t;
                                        } else {
                                            i72 = i53;
                                            i70 = i3;
                                            i2 = i47;
                                            unsafe13 = unsafe11;
                                            zzigVar = zzigVar4;
                                            i73 = i30;
                                            i74 = i16;
                                            i71 = i48;
                                            t2 = t;
                                        }
                                        break;
                                    case 30:
                                    case 44:
                                        i47 = i2;
                                        i48 = i26;
                                        if (i79 == 2) {
                                            if (i79 == 0) {
                                                iZza3 = zzid.zza(i31 == true ? 1 : 0, bArr, i76, i2, (zzkd<?>) zzkdVar, zzigVar);
                                            }
                                            i54 = i47;
                                            i76 = i76;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe12 = unsafe5;
                                            zzigVar4 = zzigVar4;
                                            unsafe11 = unsafe12;
                                            i49 = i53;
                                            iZza4 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        } else {
                                            iZza3 = zzid.zza(bArr, i76, (zzkd<?>) zzkdVar, zzigVar4);
                                        }
                                        int i812 = iZza3;
                                        zzmb.zza(t, i16, zzkdVar, zzd(i48), null, this.zzq);
                                        iZzc13 = i812;
                                        i75 = i75;
                                        i3 = i3;
                                        iZza4 = iZzc13;
                                        i53 = i31 == true ? 1 : 0;
                                        unsafe11 = unsafe5;
                                        if (iZza4 == i76) {
                                            i72 = i53;
                                            i71 = i48;
                                            i8 = iZza4;
                                            unsafe = unsafe11;
                                            zzigVar2 = zzigVar4;
                                            i73 = i30;
                                            i7 = i16;
                                            t2 = t;
                                        } else {
                                            i72 = i53;
                                            i70 = i3;
                                            i2 = i47;
                                            unsafe13 = unsafe11;
                                            zzigVar = zzigVar4;
                                            i73 = i30;
                                            i74 = i16;
                                            i71 = i48;
                                            t2 = t;
                                        }
                                        break;
                                    case 33:
                                    case 47:
                                        i47 = i2;
                                        i48 = i26;
                                        if (i79 == 2) {
                                            if (i79 == 0) {
                                                zzjvVar3 = (zzjv) zzkdVar;
                                                iZzc13 = zzid.zzc(bArr, i76, zzigVar4);
                                                zzjvVar3.zzd(zziv.zza(zzigVar4.zza));
                                                while (iZzc13 < i47) {
                                                    iZzc15 = zzid.zzc(bArr, iZzc13, zzigVar4);
                                                    if (i31 == zzigVar4.zza) {
                                                        iZzc13 = zzid.zzc(bArr, iZzc15, zzigVar4);
                                                        zzjvVar3.zzd(zziv.zza(zzigVar4.zza));
                                                    }
                                                }
                                            }
                                            i54 = i47;
                                            i76 = i76;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe12 = unsafe5;
                                            zzigVar4 = zzigVar4;
                                            unsafe11 = unsafe12;
                                            i49 = i53;
                                            iZza4 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        } else {
                                            zzjvVar4 = (zzjv) zzkdVar;
                                            iZzc13 = zzid.zzc(bArr, i76, zzigVar4);
                                            i67 = zzigVar4.zza + iZzc13;
                                            while (iZzc13 < i67) {
                                                iZzc13 = zzid.zzc(bArr, iZzc13, zzigVar4);
                                                zzjvVar4.zzd(zziv.zza(zzigVar4.zza));
                                            }
                                            if (iZzc13 != i67) {
                                                throw zzkc.zzh();
                                            }
                                        }
                                        i75 = i75;
                                        i3 = i3;
                                        iZza4 = iZzc13;
                                        i53 = i31 == true ? 1 : 0;
                                        unsafe11 = unsafe5;
                                        if (iZza4 == i76) {
                                            i72 = i53;
                                            i71 = i48;
                                            i8 = iZza4;
                                            unsafe = unsafe11;
                                            zzigVar2 = zzigVar4;
                                            i73 = i30;
                                            i7 = i16;
                                            t2 = t;
                                        } else {
                                            i72 = i53;
                                            i70 = i3;
                                            i2 = i47;
                                            unsafe13 = unsafe11;
                                            zzigVar = zzigVar4;
                                            i73 = i30;
                                            i74 = i16;
                                            i71 = i48;
                                            t2 = t;
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        i47 = i2;
                                        i48 = i26;
                                        if (i79 == 2) {
                                            if (i79 == 0) {
                                                zzksVar5 = (zzks) zzkdVar;
                                                iZzc13 = zzid.zzd(bArr, i76, zzigVar4);
                                                zzksVar5.zza(zziv.zza(zzigVar4.zzb));
                                                while (iZzc13 < i47) {
                                                    iZzc16 = zzid.zzc(bArr, iZzc13, zzigVar4);
                                                    if (i31 == zzigVar4.zza) {
                                                        iZzc13 = zzid.zzd(bArr, iZzc16, zzigVar4);
                                                        zzksVar5.zza(zziv.zza(zzigVar4.zzb));
                                                    }
                                                }
                                            }
                                            i54 = i47;
                                            i76 = i76;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe12 = unsafe5;
                                            zzigVar4 = zzigVar4;
                                            unsafe11 = unsafe12;
                                            i49 = i53;
                                            iZza4 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        } else {
                                            zzksVar6 = (zzks) zzkdVar;
                                            iZzc13 = zzid.zzc(bArr, i76, zzigVar4);
                                            i68 = zzigVar4.zza + iZzc13;
                                            while (iZzc13 < i68) {
                                                iZzc13 = zzid.zzd(bArr, iZzc13, zzigVar4);
                                                zzksVar6.zza(zziv.zza(zzigVar4.zzb));
                                            }
                                            if (iZzc13 != i68) {
                                                throw zzkc.zzh();
                                            }
                                        }
                                        i75 = i75;
                                        i3 = i3;
                                        iZza4 = iZzc13;
                                        i53 = i31 == true ? 1 : 0;
                                        unsafe11 = unsafe5;
                                        if (iZza4 == i76) {
                                            i72 = i53;
                                            i71 = i48;
                                            i8 = iZza4;
                                            unsafe = unsafe11;
                                            zzigVar2 = zzigVar4;
                                            i73 = i30;
                                            i7 = i16;
                                            t2 = t;
                                        } else {
                                            i72 = i53;
                                            i70 = i3;
                                            i2 = i47;
                                            unsafe13 = unsafe11;
                                            zzigVar = zzigVar4;
                                            i73 = i30;
                                            i74 = i16;
                                            i71 = i48;
                                            t2 = t;
                                        }
                                        break;
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                        if (i79 == 3) {
                                            zzlzVarZze = zze(i26);
                                            i69 = ((i31 == true ? 1 : 0) & (-8)) | 4;
                                            i48 = i26;
                                            i47 = i2;
                                            iZzc13 = zzid.zza(zzlzVarZze, bArr, i76, i2, i69, zzigVar);
                                            zzkdVar.add(zzigVar4.zzc);
                                            while (iZzc13 < i47) {
                                                iZzc17 = zzid.zzc(bArr, iZzc13, zzigVar4);
                                                if (i31 == zzigVar4.zza) {
                                                    i75 = i75;
                                                    i3 = i3;
                                                    iZza4 = iZzc13;
                                                    i53 = i31 == true ? 1 : 0;
                                                    unsafe11 = unsafe5;
                                                    if (iZza4 == i76) {
                                                        i72 = i53;
                                                        i71 = i48;
                                                        i8 = iZza4;
                                                        unsafe = unsafe11;
                                                        zzigVar2 = zzigVar4;
                                                        i73 = i30;
                                                        i7 = i16;
                                                        t2 = t;
                                                    } else {
                                                        i72 = i53;
                                                        i70 = i3;
                                                        i2 = i47;
                                                        unsafe13 = unsafe11;
                                                        zzigVar = zzigVar4;
                                                        i73 = i30;
                                                        i74 = i16;
                                                        i71 = i48;
                                                        t2 = t;
                                                    }
                                                } else {
                                                    iZzc13 = zzid.zza(zzlzVarZze, bArr, iZzc17, i2, i69, zzigVar);
                                                    zzkdVar.add(zzigVar4.zzc);
                                                }
                                                break;
                                            }
                                            i75 = i75;
                                            i3 = i3;
                                            iZza4 = iZzc13;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe11 = unsafe5;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        } else {
                                            i48 = i26;
                                            i54 = i2;
                                            i76 = i76;
                                            i53 = i31 == true ? 1 : 0;
                                            unsafe12 = unsafe5;
                                            zzigVar4 = zzigVar4;
                                            unsafe11 = unsafe12;
                                            i49 = i53;
                                            iZza4 = i76;
                                            i3 = i3;
                                            i47 = i54;
                                            i53 = i49;
                                            i75 = i75;
                                            i76 = iZza4;
                                            if (iZza4 == i76) {
                                                i72 = i53;
                                                i71 = i48;
                                                i8 = iZza4;
                                                unsafe = unsafe11;
                                                zzigVar2 = zzigVar4;
                                                i73 = i30;
                                                i7 = i16;
                                                t2 = t;
                                            } else {
                                                i72 = i53;
                                                i70 = i3;
                                                i2 = i47;
                                                unsafe13 = unsafe11;
                                                zzigVar = zzigVar4;
                                                i73 = i30;
                                                i74 = i16;
                                                i71 = i48;
                                                t2 = t;
                                            }
                                        }
                                        break;
                                    default:
                                        i47 = i2;
                                        i3 = i3;
                                        i48 = i26;
                                        iZza4 = i76;
                                        i49 = i31 == true ? 1 : 0;
                                        unsafe11 = unsafe5;
                                        i53 = i49;
                                        i75 = i75;
                                        i76 = iZza4;
                                        if (iZza4 == i76) {
                                            i72 = i53;
                                            i71 = i48;
                                            i8 = iZza4;
                                            unsafe = unsafe11;
                                            zzigVar2 = zzigVar4;
                                            i73 = i30;
                                            i7 = i16;
                                            t2 = t;
                                        } else {
                                            i72 = i53;
                                            i70 = i3;
                                            i2 = i47;
                                            unsafe13 = unsafe11;
                                            zzigVar = zzigVar4;
                                            i73 = i30;
                                            i74 = i16;
                                            i71 = i48;
                                            t2 = t;
                                        }
                                        break;
                                }
                            } else {
                                i32 = i76;
                                i33 = i31 == true ? 1 : 0;
                                unsafe6 = unsafe5;
                                if (i10 == 50) {
                                    i28 = i26;
                                    i34 = i33 == true ? 1 : 0;
                                    t2 = t;
                                    unsafe7 = zzb;
                                    j2 = iArr[i28 + 2] & 1048575;
                                    switch (i10) {
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                            i28 = i28;
                                            zzigVar2 = zzigVar4;
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            i35 = i32;
                                            if (i79 == 1) {
                                                unsafe7.putObject(t2, j, Double.valueOf(zzid.zza(bArr, i35)));
                                                iZzd = i35 + 8;
                                                unsafe7.putInt(t2, j2, i7);
                                                iZza4 = iZzd;
                                            } else {
                                                iZza4 = i35;
                                            }
                                            if (iZza4 == i35) {
                                                i35 = i35;
                                                i7 = i7;
                                                i3 = i3;
                                                i8 = iZza4;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            } else {
                                                i35 = i35;
                                                i7 = i7;
                                                i70 = i3;
                                                i74 = i7;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            }
                                            break;
                                        case 52:
                                            i28 = i28;
                                            zzigVar2 = zzigVar4;
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            i35 = i32;
                                            if (i79 == 5) {
                                                unsafe7.putObject(t2, j, Float.valueOf(zzid.zzb(bArr, i35)));
                                                iZzd = i35 + 4;
                                                unsafe7.putInt(t2, j2, i7);
                                                iZza4 = iZzd;
                                            } else {
                                                iZza4 = i35;
                                            }
                                            if (iZza4 == i35) {
                                                i35 = i35;
                                                i7 = i7;
                                                i3 = i3;
                                                i8 = iZza4;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            } else {
                                                i35 = i35;
                                                i7 = i7;
                                                i70 = i3;
                                                i74 = i7;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            }
                                            break;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                        case 54:
                                            i28 = i28;
                                            zzigVar2 = zzigVar4;
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            i35 = i32;
                                            if (i79 == 0) {
                                                iZzd = zzid.zzd(bArr, i35, zzigVar2);
                                                unsafe7.putObject(t2, j, Long.valueOf(zzigVar2.zzb));
                                                unsafe7.putInt(t2, j2, i7);
                                                iZza4 = iZzd;
                                            } else {
                                                iZza4 = i35;
                                            }
                                            if (iZza4 == i35) {
                                                i35 = i35;
                                                i7 = i7;
                                                i3 = i3;
                                                i8 = iZza4;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            } else {
                                                i35 = i35;
                                                i7 = i7;
                                                i70 = i3;
                                                i74 = i7;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            }
                                            break;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                        case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                                            i28 = i28;
                                            zzigVar2 = zzigVar4;
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            i35 = i32;
                                            if (i79 == 0) {
                                                iZzd = zzid.zzc(bArr, i35, zzigVar2);
                                                unsafe7.putObject(t2, j, Integer.valueOf(zzigVar2.zza));
                                                unsafe7.putInt(t2, j2, i7);
                                                iZza4 = iZzd;
                                            } else {
                                                iZza4 = i35;
                                            }
                                            if (iZza4 == i35) {
                                                i35 = i35;
                                                i7 = i7;
                                                i3 = i3;
                                                i8 = iZza4;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            } else {
                                                i35 = i35;
                                                i7 = i7;
                                                i70 = i3;
                                                i74 = i7;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            }
                                            break;
                                        case 56:
                                        case 65:
                                            i28 = i28;
                                            zzigVar2 = zzigVar4;
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            i35 = i32;
                                            if (i79 == 1) {
                                                unsafe7.putObject(t2, j, Long.valueOf(zzid.zzd(bArr, i35)));
                                                iZzd = i35 + 8;
                                                unsafe7.putInt(t2, j2, i7);
                                                iZza4 = iZzd;
                                            } else {
                                                iZza4 = i35;
                                            }
                                            if (iZza4 == i35) {
                                                i35 = i35;
                                                i7 = i7;
                                                i3 = i3;
                                                i8 = iZza4;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            } else {
                                                i35 = i35;
                                                i7 = i7;
                                                i70 = i3;
                                                i74 = i7;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            i28 = i28;
                                            zzigVar2 = zzigVar4;
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            i35 = i32;
                                            if (i79 == 5) {
                                                unsafe7.putObject(t2, j, Integer.valueOf(zzid.zzc(bArr, i35)));
                                                iZzd = i35 + 4;
                                                unsafe7.putInt(t2, j2, i7);
                                                iZza4 = iZzd;
                                            } else {
                                                iZza4 = i35;
                                            }
                                            if (iZza4 == i35) {
                                                i35 = i35;
                                                i7 = i7;
                                                i3 = i3;
                                                i8 = iZza4;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            } else {
                                                i35 = i35;
                                                i7 = i7;
                                                i70 = i3;
                                                i74 = i7;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            }
                                            break;
                                        case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                                            i28 = i28;
                                            zzigVar2 = zzigVar4;
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            i35 = i32;
                                            if (i79 == 0) {
                                                iZzd = zzid.zzd(bArr, i35, zzigVar2);
                                                if (zzigVar2.zzb != 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                unsafe7.putObject(t2, j, Boolean.valueOf(z2));
                                                unsafe7.putInt(t2, j2, i7);
                                                iZza4 = iZzd;
                                            } else {
                                                iZza4 = i35;
                                            }
                                            if (iZza4 == i35) {
                                                i35 = i35;
                                                i7 = i7;
                                                i3 = i3;
                                                i8 = iZza4;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            } else {
                                                i35 = i35;
                                                i7 = i7;
                                                i70 = i3;
                                                i74 = i7;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            }
                                            break;
                                        case 59:
                                            i28 = i28;
                                            zzigVar2 = zzigVar4;
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            i35 = i32;
                                            if (i79 == 2) {
                                                iZzd = zzid.zzc(bArr, i35, zzigVar2);
                                                i36 = zzigVar2.zza;
                                                if (i36 == 0) {
                                                    unsafe7.putObject(t2, j, "");
                                                } else {
                                                    if ((i9 & 536870912) == 0) {
                                                    }
                                                    unsafe7.putObject(t2, j, new String(bArr, iZzd, i36, zzjx.zza));
                                                    iZzd += i36;
                                                }
                                                unsafe7.putInt(t2, j2, i7);
                                                iZza4 = iZzd;
                                            } else {
                                                iZza4 = i35;
                                            }
                                            if (iZza4 == i35) {
                                                i35 = i35;
                                                i7 = i7;
                                                i3 = i3;
                                                i8 = iZza4;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            } else {
                                                i35 = i35;
                                                i7 = i7;
                                                i70 = i3;
                                                i74 = i7;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            }
                                            break;
                                        case 60:
                                            zzigVar5 = zzigVar4;
                                            i37 = i34 == true ? 1 : 0;
                                            i35 = i32;
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            if (i79 == 2) {
                                                Object objZza7 = zza(t2, i7, i28);
                                                int iZza8 = zzid.zza(objZza7, zze(i28), bArr, i35, i2, zzigVar);
                                                zza(t2, i7, i28, objZza7);
                                                iZza4 = iZza8;
                                                i34 = i37 == true ? 1 : 0;
                                                zzigVar2 = zzigVar5;
                                                i28 = i28;
                                            } else {
                                                zzigVar6 = zzigVar5;
                                                i39 = i35;
                                                i40 = i7;
                                                i34 = i37;
                                                zzigVar2 = zzigVar6;
                                                i35 = i39;
                                                i7 = i40;
                                                i28 = i28;
                                                iZza4 = i35;
                                            }
                                            if (iZza4 == i35) {
                                                i35 = i35;
                                                i7 = i7;
                                                i3 = i3;
                                                i8 = iZza4;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            } else {
                                                i35 = i35;
                                                i7 = i7;
                                                i70 = i3;
                                                i74 = i7;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            }
                                            break;
                                        case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                            i37 = i34 == true ? 1 : 0;
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            zzigVar5 = zzigVar4;
                                            i35 = i32;
                                            if (i79 == 2) {
                                                iZza2 = zzid.zza(bArr, i35, zzigVar5);
                                                unsafe7.putObject(t2, j, zzigVar5.zzc);
                                                unsafe7.putInt(t2, j2, i7);
                                                iZza4 = iZza2;
                                                i34 = i37;
                                                zzigVar2 = zzigVar5;
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                            }
                                            zzigVar6 = zzigVar5;
                                            i39 = i35;
                                            i40 = i7;
                                            i34 = i37;
                                            zzigVar2 = zzigVar6;
                                            i35 = i39;
                                            i7 = i40;
                                            i28 = i28;
                                            iZza4 = i35;
                                            if (iZza4 == i35) {
                                                i35 = i35;
                                                i7 = i7;
                                                i3 = i3;
                                                i8 = iZza4;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            } else {
                                                i35 = i35;
                                                i7 = i7;
                                                i70 = i3;
                                                i74 = i7;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            }
                                            break;
                                        case 63:
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            zzigVar5 = zzigVar4;
                                            i35 = i32;
                                            if (i79 == 0) {
                                                iZza2 = zzid.zzc(bArr, i35, zzigVar5);
                                                i38 = zzigVar5.zza;
                                                zzjyVarZzd = zzd(i28);
                                                if (zzjyVarZzd != null) {
                                                    i37 = i34 == true ? 1 : 0;
                                                    unsafe7.putObject(t2, j, Integer.valueOf(i38));
                                                    unsafe7.putInt(t2, j2, i7);
                                                } else {
                                                    i37 = i34 == true ? 1 : 0;
                                                    unsafe7.putObject(t2, j, Integer.valueOf(i38));
                                                    unsafe7.putInt(t2, j2, i7);
                                                }
                                                iZza4 = iZza2;
                                                i34 = i37;
                                                zzigVar2 = zzigVar5;
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                            } else {
                                                i37 = i34 == true ? 1 : 0;
                                                zzigVar6 = zzigVar5;
                                                i39 = i35;
                                                i40 = i7;
                                                i34 = i37;
                                                zzigVar2 = zzigVar6;
                                                i35 = i39;
                                                i7 = i40;
                                                i28 = i28;
                                                iZza4 = i35;
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                            }
                                            break;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            zzigVar5 = zzigVar4;
                                            i35 = i32;
                                            if (i79 == 0) {
                                                iZza2 = zzid.zzc(bArr, i35, zzigVar5);
                                                unsafe7.putObject(t2, j, Integer.valueOf(zziv.zza(zzigVar5.zza)));
                                                unsafe7.putInt(t2, j2, i7);
                                                i37 = i34;
                                                iZza4 = iZza2;
                                                i34 = i37;
                                                zzigVar2 = zzigVar5;
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                            } else {
                                                zzigVar6 = zzigVar5;
                                                i39 = i35;
                                                i40 = i7;
                                                i37 = i34 == true ? 1 : 0;
                                                i34 = i37;
                                                zzigVar2 = zzigVar6;
                                                i35 = i39;
                                                i7 = i40;
                                                i28 = i28;
                                                iZza4 = i35;
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                            }
                                            break;
                                        case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                                            i37 = i34 == true ? 1 : 0;
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            zzigVar5 = zzigVar4;
                                            i35 = i32;
                                            if (i79 == 0) {
                                                iZza2 = zzid.zzd(bArr, i35, zzigVar5);
                                                i34 = i37 == true ? 1 : 0;
                                                unsafe7.putObject(t2, j, Long.valueOf(zziv.zza(zzigVar5.zzb)));
                                                unsafe7.putInt(t2, j2, i7);
                                                i37 = i34;
                                                iZza4 = iZza2;
                                                i34 = i37;
                                                zzigVar2 = zzigVar5;
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                            }
                                            zzigVar6 = zzigVar5;
                                            i39 = i35;
                                            i40 = i7;
                                            i34 = i37;
                                            zzigVar2 = zzigVar6;
                                            i35 = i39;
                                            i7 = i40;
                                            i28 = i28;
                                            iZza4 = i35;
                                            if (iZza4 == i35) {
                                                i35 = i35;
                                                i7 = i7;
                                                i3 = i3;
                                                i8 = iZza4;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            } else {
                                                i35 = i35;
                                                i7 = i7;
                                                i70 = i3;
                                                i74 = i7;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            }
                                            break;
                                        case 68:
                                            if (i79 == 3) {
                                                i7 = i16;
                                                Object objZza8 = zza(t2, i7, i28);
                                                i35 = i32;
                                                unsafe = unsafe6;
                                                zzigVar5 = zzigVar4;
                                                iZza4 = zzid.zza(objZza8, zze(i28), bArr, i32, i2, ((i34 == true ? 1 : 0) & (-8)) | 4, zzigVar);
                                                zza(t2, i7, i28, objZza8);
                                                zzigVar2 = zzigVar5;
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                            } else {
                                                unsafe = unsafe6;
                                                i28 = i28;
                                                zzigVar2 = zzigVar4;
                                                i35 = i32;
                                                i7 = i16;
                                                iZza4 = i35;
                                                if (iZza4 == i35) {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i3 = i3;
                                                    i8 = iZza4;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                } else {
                                                    i35 = i35;
                                                    i7 = i7;
                                                    i70 = i3;
                                                    i74 = i7;
                                                    i73 = i30;
                                                    i72 = i34;
                                                    i75 = i75;
                                                    i71 = i28;
                                                }
                                            }
                                            break;
                                        default:
                                            i28 = i28;
                                            zzigVar2 = zzigVar4;
                                            i35 = i32;
                                            i7 = i16;
                                            unsafe = unsafe6;
                                            iZza4 = i35;
                                            if (iZza4 == i35) {
                                                i35 = i35;
                                                i7 = i7;
                                                i3 = i3;
                                                i8 = iZza4;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            } else {
                                                i35 = i35;
                                                i7 = i7;
                                                i70 = i3;
                                                i74 = i7;
                                                i73 = i30;
                                                i72 = i34;
                                                i75 = i75;
                                                i71 = i28;
                                            }
                                            break;
                                    }
                                } else {
                                    if (i79 == 2) {
                                        unsafe8 = zzb;
                                        objZzf = zzf(i26);
                                        int i813 = i26;
                                        t2 = t;
                                        object = unsafe8.getObject(t2, j);
                                        if (this.zzs.zzf(object)) {
                                            Object objZzb2 = this.zzs.zzb(objZzf);
                                            this.zzs.zza(objZzb2, object);
                                            unsafe8.putObject(t2, j, objZzb2);
                                            object = objZzb2;
                                        }
                                        zzky<?, ?> zzkyVarZza2 = this.zzs.zza(objZzf);
                                        Map<?, ?> mapZze2 = this.zzs.zze(object);
                                        int iZzc19 = zzid.zzc(bArr, i32, zzigVar4);
                                        i42 = zzigVar4.zza;
                                        if (i42 >= 0) {
                                        }
                                        throw zzkc.zzh();
                                    }
                                    i28 = i26;
                                    i29 = i33 == true ? 1 : 0;
                                    unsafe4 = unsafe6;
                                    t2 = t;
                                    i41 = i32;
                                }
                                unsafe13 = unsafe;
                            }
                        } else if (i79 == 2) {
                            zzkdVarZza = (zzkd) unsafe5.getObject(t2, j);
                            if (!zzkdVarZza.zzc()) {
                                int size4 = zzkdVarZza.size();
                                zzkdVarZza = zzkdVarZza.zza(size4 != 0 ? size4 << 1 : 10);
                                unsafe5.putObject(t2, j, zzkdVarZza);
                            }
                            zzlz zzlzVarZze5 = zze(i26);
                            zzigVar = zzigVar;
                            unsafe3 = unsafe5;
                            i25 = i31 == true ? 1 : 0;
                            iZza4 = zzid.zza((zzlz<?>) zzlzVarZze5, i31 == true ? 1 : 0, bArr, i76, i2, (zzkd<?>) zzkdVarZza, zzigVar);
                            i73 = i73;
                            i75 = i75;
                            i70 = i3;
                            i71 = i26;
                            i72 = i25;
                            i74 = i16;
                            i2 = i2;
                            unsafe13 = unsafe3;
                        } else {
                            i75 = i75;
                            i30 = i73;
                            i28 = i26;
                            i29 = i31 == true ? 1 : 0;
                            zzigVar4 = zzigVar;
                            unsafe4 = unsafe5;
                            i41 = i76;
                        }
                        i8 = i41;
                        zzigVar2 = zzigVar4;
                        i73 = i30;
                        i72 = i29;
                        i7 = i16;
                        i75 = i75;
                        unsafe = unsafe4;
                        i71 = i28;
                    }
                }
                if (i72 == i3) {
                }
                if (!this.zzh) {
                    iZza4 = zzid.zza((i72 == true ? 1 : 0) == true ? 1 : 0, bArr, i8, i2, zze(t), zzigVar);
                } else {
                    iZza4 = zzid.zza((i72 == true ? 1 : 0) == true ? 1 : 0, bArr, i8, i2, zze(t), zzigVar);
                }
                i70 = i3;
                i74 = i7;
                unsafe13 = unsafe;
            } else {
                unsafe = unsafe13;
                i3 = i70;
            }
        }
        if (i75 != 1048575) {
            unsafe.putInt(t2, i75, i73);
        }
        zzmx zzmxVar = null;
        for (int i91 = this.zzm; i91 < this.zzn; i91++) {
            zzmxVar = (zzmx) zza(t, this.zzl[i91], zzmxVar, (zzmu<UT, zzmx>) this.zzq, t);
        }
        if (zzmxVar != null) {
            this.zzq.zzb(t2, zzmxVar);
        }
        if (i3 == 0) {
            if (iZza4 != i2) {
                throw zzkc.zzg();
            }
        } else if (iZza4 > i2 || i72 != i3) {
            throw zzkc.zzg();
        }
        return iZza4;
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    private final int zza(int i, int i2) {
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

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzd(T t, long j) {
        return ((Long) zzna.zze(t, j)).longValue();
    }

    private final zzjy zzd(int i) {
        return (zzjy) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Code duplicated, block: B:124:0x025e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0261  */
    /* JADX WARN: Code duplicated, block: B:128:0x027a  */
    /* JADX WARN: Code duplicated, block: B:129:0x027d  */
    static <T> zzll<T> zza(Class<T> cls, zzlf zzlfVar, zzlp zzlpVar, zzkm zzkmVar, zzmu<?, ?> zzmuVar, zzjj<?> zzjjVar, zzla zzlaVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr;
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
        int iObjectFieldOffset;
        boolean z;
        int iObjectFieldOffset2;
        int i18;
        int i19;
        Field fieldZza;
        int i20;
        char cCharAt9;
        int i21;
        int i22;
        int i23;
        Object obj;
        Field fieldZza2;
        int i24;
        Object obj2;
        Field fieldZza3;
        int i25;
        char cCharAt10;
        int i26;
        char cCharAt11;
        int i27;
        char cCharAt12;
        int i28;
        char cCharAt13;
        if (zzlfVar instanceof zzlx) {
            zzlx zzlxVar = (zzlx) zzlfVar;
            String strZzd = zzlxVar.zzd();
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
            int iCharAt4 = strZzd.charAt(i);
            if (iCharAt4 >= 55296) {
                int i31 = iCharAt4 & 8191;
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
                iCharAt4 = i31 | (cCharAt13 << i32);
                i30 = i28;
            }
            if (iCharAt4 == 0) {
                iCharAt2 = 0;
                iCharAt3 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i2 = i30;
                iArr = zza;
                iCharAt = 0;
            } else {
                int i33 = i30 + 1;
                iCharAt = strZzd.charAt(i30);
                if (iCharAt >= 55296) {
                    int i34 = iCharAt & 8191;
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
                    iCharAt = i34 | (cCharAt8 << i35);
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
                iCharAt2 = strZzd.charAt(i42);
                if (iCharAt2 >= 55296) {
                    int i46 = iCharAt2 & 8191;
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
                    iCharAt2 = i46 | (cCharAt4 << i47);
                    i45 = i10;
                }
                int i48 = i45 + 1;
                iCharAt3 = strZzd.charAt(i45);
                if (iCharAt3 >= 55296) {
                    int i49 = iCharAt3 & 8191;
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
                    iCharAt3 = i49 | (cCharAt3 << i50);
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
                i2 = i51 + 1;
                int iCharAt9 = strZzd.charAt(i51);
                if (iCharAt9 >= 55296) {
                    int i54 = iCharAt9 & 8191;
                    int i55 = 13;
                    while (true) {
                        i7 = i2 + 1;
                        cCharAt = strZzd.charAt(i2);
                        if (cCharAt < 55296) {
                            break;
                        }
                        i54 |= (cCharAt & 8191) << i55;
                        i55 += 13;
                        i2 = i7;
                    }
                    iCharAt9 = i54 | (cCharAt << i55);
                    i2 = i7;
                }
                i3 = (iCharAt << 1) + iCharAt5;
                i4 = iCharAt6;
                i5 = iCharAt7;
                iArr = new int[iCharAt9 + iCharAt3 + iCharAt8];
                i6 = iCharAt9;
            }
            Unsafe unsafe = zzb;
            Object[] objArrZze = zzlxVar.zze();
            Class<?> cls2 = zzlxVar.zza().getClass();
            int[] iArr2 = new int[iCharAt2 * 3];
            Object[] objArr = new Object[iCharAt2 << 1];
            int i56 = i6 + iCharAt3;
            int i57 = 0;
            int i58 = 0;
            int i59 = i6;
            int i60 = i56;
            while (i2 < length) {
                int i61 = i2 + 1;
                int iCharAt10 = strZzd.charAt(i2);
                if (iCharAt10 >= c) {
                    int i62 = iCharAt10 & 8191;
                    int i63 = i61;
                    int i64 = 13;
                    while (true) {
                        i27 = i63 + 1;
                        cCharAt12 = strZzd.charAt(i63);
                        if (cCharAt12 < c) {
                            break;
                        }
                        i62 |= (cCharAt12 & 8191) << i64;
                        i64 += 13;
                        i63 = i27;
                    }
                    iCharAt10 = i62 | (cCharAt12 << i64);
                    i15 = i27;
                } else {
                    i15 = i61;
                }
                int i65 = i15 + 1;
                int iCharAt11 = strZzd.charAt(i15);
                if (iCharAt11 >= c) {
                    int i66 = iCharAt11 & 8191;
                    int i67 = i65;
                    int i68 = 13;
                    while (true) {
                        i26 = i67 + 1;
                        cCharAt11 = strZzd.charAt(i67);
                        if (cCharAt11 < c) {
                            break;
                        }
                        i66 |= (cCharAt11 & 8191) << i68;
                        i68 += 13;
                        i67 = i26;
                    }
                    iCharAt11 = i66 | (cCharAt11 << i68);
                    i16 = i26;
                } else {
                    i16 = i65;
                }
                int i69 = iCharAt11 & 255;
                if ((iCharAt11 & 1024) != 0) {
                    iArr[i58] = i57;
                    i58++;
                }
                int i70 = length;
                if (i69 >= 51) {
                    int i71 = i16 + 1;
                    int iCharAt12 = strZzd.charAt(i16);
                    char c2 = 55296;
                    if (iCharAt12 >= 55296) {
                        int i72 = iCharAt12 & 8191;
                        int i73 = 13;
                        while (true) {
                            i25 = i71 + 1;
                            cCharAt10 = strZzd.charAt(i71);
                            if (cCharAt10 < c2) {
                                break;
                            }
                            i72 |= (cCharAt10 & 8191) << i73;
                            i73 += 13;
                            i71 = i25;
                            c2 = 55296;
                        }
                        iCharAt12 = i72 | (cCharAt10 << i73);
                        i71 = i25;
                    }
                    int i74 = i69 - 51;
                    i19 = i71;
                    if (i74 == 9 || i74 == 17) {
                        i22 = i3 + 1;
                        objArr[((i57 / 3) << 1) + 1] = objArrZze[i3];
                    } else {
                        if (i74 == 12 && (zzlxVar.zzb().equals(zzls.PROTO2) || (iCharAt11 & 2048) != 0)) {
                            i22 = i3 + 1;
                            objArr[((i57 / 3) << 1) + 1] = objArrZze[i3];
                        }
                        i23 = iCharAt12 << 1;
                        obj = objArrZze[i23];
                        if (obj instanceof Field) {
                            fieldZza2 = (Field) obj;
                        } else {
                            fieldZza2 = zza(cls2, (String) obj);
                            objArrZze[i23] = fieldZza2;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza2);
                        i24 = i23 + 1;
                        obj2 = objArrZze[i24];
                        if (obj2 instanceof Field) {
                            fieldZza3 = (Field) obj2;
                        } else {
                            fieldZza3 = zza(cls2, (String) obj2);
                            objArrZze[i24] = fieldZza3;
                        }
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                        strZzd = strZzd;
                        i17 = i3;
                        i18 = 0;
                        z = true;
                    }
                    i3 = i22;
                    i23 = iCharAt12 << 1;
                    obj = objArrZze[i23];
                    if (obj instanceof Field) {
                        fieldZza2 = (Field) obj;
                    } else {
                        fieldZza2 = zza(cls2, (String) obj);
                        objArrZze[i23] = fieldZza2;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza2);
                    i24 = i23 + 1;
                    obj2 = objArrZze[i24];
                    if (obj2 instanceof Field) {
                        fieldZza3 = (Field) obj2;
                    } else {
                        fieldZza3 = zza(cls2, (String) obj2);
                        objArrZze[i24] = fieldZza3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                    strZzd = strZzd;
                    i17 = i3;
                    i18 = 0;
                    z = true;
                } else {
                    i17 = i3 + 1;
                    Field fieldZza4 = zza(cls2, (String) objArrZze[i3]);
                    if (i69 == 9 || i69 == 17) {
                        objArr[((i57 / 3) << 1) + 1] = fieldZza4.getType();
                    } else {
                        if (i69 == 27 || i69 == 49) {
                            i21 = i3 + 2;
                            objArr[((i57 / 3) << 1) + 1] = objArrZze[i17];
                        } else if (i69 == 12 || i69 == 30 || i69 == 44) {
                            if (zzlxVar.zzb() == zzls.PROTO2 || (iCharAt11 & 2048) != 0) {
                                i21 = i3 + 2;
                                objArr[((i57 / 3) << 1) + 1] = objArrZze[i17];
                            }
                        } else if (i69 == 50) {
                            int i75 = i59 + 1;
                            iArr[i59] = i57;
                            int i76 = (i57 / 3) << 1;
                            int i77 = i3 + 2;
                            objArr[i76] = objArrZze[i17];
                            if ((iCharAt11 & 2048) != 0) {
                                i17 = i3 + 3;
                                objArr[i76 + 1] = objArrZze[i77];
                                i59 = i75;
                            } else {
                                i59 = i75;
                                i17 = i77;
                            }
                        }
                        i17 = i21;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                    if ((iCharAt11 & 4096) == 0 || i69 > 17) {
                        z = true;
                        iObjectFieldOffset2 = 1048575;
                        i18 = 0;
                    } else {
                        int i78 = i16 + 1;
                        int iCharAt13 = strZzd.charAt(i16);
                        if (iCharAt13 >= 55296) {
                            int i79 = iCharAt13 & 8191;
                            int i80 = 13;
                            while (true) {
                                i20 = i78 + 1;
                                cCharAt9 = strZzd.charAt(i78);
                                if (cCharAt9 < 55296) {
                                    break;
                                }
                                i79 |= (cCharAt9 & 8191) << i80;
                                i80 += 13;
                                i78 = i20;
                            }
                            iCharAt13 = i79 | (cCharAt9 << i80);
                            i78 = i20;
                        }
                        z = true;
                        int i81 = (iCharAt << 1) + (iCharAt13 / 32);
                        Object obj3 = objArrZze[i81];
                        if (obj3 instanceof Field) {
                            fieldZza = (Field) obj3;
                        } else {
                            fieldZza = zza(cls2, (String) obj3);
                            objArrZze[i81] = fieldZza;
                        }
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza);
                        i18 = iCharAt13 % 32;
                        i16 = i78;
                    }
                    if (i69 >= 18 && i69 <= 49) {
                        iArr[i60] = iObjectFieldOffset;
                        i60++;
                    }
                    i19 = i16;
                }
                iArr2[i57] = iCharAt10;
                iArr2[i57 + 1] = ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i69 << 20) | iObjectFieldOffset;
                iArr2[i57 + 2] = (i18 << 20) | iObjectFieldOffset2;
                i57 += 3;
                i3 = i17;
                strZzd = strZzd;
                length = i70;
                i2 = i19;
                iArr2 = iArr2;
                i58 = i58;
                c = 55296;
            }
            return new zzll<>(iArr2, objArr, i4, i5, zzlxVar.zza(), zzlxVar.zzb(), false, iArr, i6, i56, zzlpVar, zzkmVar, zzmuVar, zzjjVar, zzlaVar);
        }
        throw new NoSuchMethodError();
    }

    private final zzlz zze(int i) {
        int i2 = (i / 3) << 1;
        zzlz zzlzVar = (zzlz) this.zzd[i2];
        if (zzlzVar != null) {
            return zzlzVar;
        }
        zzlz<T> zzlzVarZza = zzlv.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzlzVarZza;
        return zzlzVarZza;
    }

    private static zzmx zze(Object obj) {
        zzju zzjuVar = (zzju) obj;
        zzmx zzmxVar = zzjuVar.zzb;
        if (zzmxVar != zzmx.zzc()) {
            return zzmxVar;
        }
        zzmx zzmxVarZzd = zzmx.zzd();
        zzjuVar.zzb = zzmxVarZzd;
        return zzmxVarZzd;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzmu<UT, UB> zzmuVar, Object obj2) {
        zzjy zzjyVarZzd;
        int i2 = this.zzc[i];
        Object objZze = zzna.zze(obj, zzc(i) & 1048575);
        return (objZze == null || (zzjyVarZzd = zzd(i)) == null) ? ub : (UB) zza(i, i2, this.zzs.zze(objZze), zzjyVarZzd, ub, zzmuVar, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzjy zzjyVar, UB ub, zzmu<UT, UB> zzmuVar, Object obj) {
        zzky<?, ?> zzkyVarZza = this.zzs.zza(zzf(i));
        Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<K, V> next = it2.next();
            if (!zzjyVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzmuVar.zzc(obj);
                }
                zziq zziqVarZzc = zzih.zzc(zzkz.zza(zzkyVarZza, next.getKey(), next.getValue()));
                try {
                    zzkz.zza(zziqVarZzc.zzb(), zzkyVarZza, next.getKey(), next.getValue());
                    zzmuVar.zza(ub, i2, zziqVarZzc.zza());
                    it2.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i) {
        zzlz zzlzVarZze = zze(i);
        long jZzc = zzc(i) & 1048575;
        if (!zzc((Object) t, i)) {
            return zzlzVarZze.zza();
        }
        Object object = zzb.getObject(t, jZzc);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzlzVarZze.zza();
        if (object != null) {
            zzlzVarZze.zza(objZza, object);
        }
        return objZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i, int i2) {
        zzlz zzlzVarZze = zze(i2);
        if (!zzc(t, i, i2)) {
            return zzlzVarZze.zza();
        }
        Object object = zzb.getObject(t, zzc(i2) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzlzVarZze.zza();
        if (object != null) {
            zzlzVarZze.zza(objZza, object);
        }
        return objZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final T zza() {
        return (T) this.zzo.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
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

    private zzll(int[] iArr, Object[] objArr, int i, int i2, zzlh zzlhVar, zzls zzlsVar, boolean z, int[] iArr2, int i3, int i4, zzlp zzlpVar, zzkm zzkmVar, zzmu<?, ?> zzmuVar, zzjj<?> zzjjVar, zzla zzlaVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzlhVar instanceof zzju;
        this.zzj = zzlsVar;
        this.zzh = zzjjVar != null && zzjjVar.zza(zzlhVar);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzlpVar;
        this.zzp = zzkmVar;
        this.zzq = zzmuVar;
        this.zzr = zzjjVar;
        this.zzg = zzlhVar;
        this.zzs = zzlaVar;
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlz
    public final void zzc(T t) {
        if (zzg(t)) {
            if (t instanceof zzju) {
                zzju zzjuVar = (zzju) t;
                zzjuVar.zzc(Integer.MAX_VALUE);
                zzjuVar.zza = 0;
                zzjuVar.zzci();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int iZzc = zzc(i);
                long j = 1048575 & iZzc;
                int i2 = (iZzc & 267386880) >>> 20;
                if (i2 != 9) {
                    if (i2 != 60 && i2 != 68) {
                        switch (i2) {
                            case 17:
                                if (zzc((Object) t, i)) {
                                    zze(i).zzc(zzb.getObject(t, j));
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
                                this.zzp.zzb(t, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(t, j);
                                if (object != null) {
                                    unsafe.putObject(t, j, this.zzs.zzc(object));
                                }
                                break;
                        }
                    } else if (zzc(t, this.zzc[i], i)) {
                        zze(i).zzc(zzb.getObject(t, j));
                    }
                } else if (zzc((Object) t, i)) {
                    zze(i).zzc(zzb.getObject(t, j));
                }
            }
            this.zzq.zzf(t);
            if (this.zzh) {
                this.zzr.zzc(t);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final void zza(T t, T t2) {
        zzf(t);
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzc = zzc(i);
            long j = 1048575 & iZzc;
            int i2 = this.zzc[i];
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((Object) t2, i)) {
                        zzna.zza(t, j, zzna.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 1:
                    if (zzc((Object) t2, i)) {
                        zzna.zza((Object) t, j, zzna.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 2:
                    if (zzc((Object) t2, i)) {
                        zzna.zza((Object) t, j, zzna.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 3:
                    if (zzc((Object) t2, i)) {
                        zzna.zza((Object) t, j, zzna.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 4:
                    if (zzc((Object) t2, i)) {
                        zzna.zza((Object) t, j, zzna.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 5:
                    if (zzc((Object) t2, i)) {
                        zzna.zza((Object) t, j, zzna.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 6:
                    if (zzc((Object) t2, i)) {
                        zzna.zza((Object) t, j, zzna.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 7:
                    if (zzc((Object) t2, i)) {
                        zzna.zzc(t, j, zzna.zzh(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 8:
                    if (zzc((Object) t2, i)) {
                        zzna.zza(t, j, zzna.zze(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zzc((Object) t2, i)) {
                        zzna.zza(t, j, zzna.zze(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 11:
                    if (zzc((Object) t2, i)) {
                        zzna.zza((Object) t, j, zzna.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 12:
                    if (zzc((Object) t2, i)) {
                        zzna.zza((Object) t, j, zzna.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 13:
                    if (zzc((Object) t2, i)) {
                        zzna.zza((Object) t, j, zzna.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 14:
                    if (zzc((Object) t2, i)) {
                        zzna.zza((Object) t, j, zzna.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 15:
                    if (zzc((Object) t2, i)) {
                        zzna.zza((Object) t, j, zzna.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 16:
                    if (zzc((Object) t2, i)) {
                        zzna.zza((Object) t, j, zzna.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 17:
                    zza(t, t2, i);
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
                    this.zzp.zza(t, t2, j);
                    break;
                case 50:
                    zzmb.zza(this.zzs, t, t2, j);
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
                    if (zzc(t2, i2, i)) {
                        zzna.zza(t, j, zzna.zze(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 60:
                    zzb(t, t2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                case 63:
                case 64:
                case 65:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (zzc(t2, i2, i)) {
                        zzna.zza(t, j, zzna.zze(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzmb.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzmb.zza(this.zzr, t, t2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:164:0x0628 A[Catch: all -> 0x02a3, TryCatch #2 {all -> 0x02a3, blocks: (B:151:0x05fc, B:162:0x0623, B:164:0x0628, B:165:0x062c, B:50:0x00ce, B:51:0x00e0, B:52:0x00f2, B:53:0x0104, B:54:0x0116, B:55:0x0128, B:57:0x0132, B:60:0x0139, B:61:0x0141, B:62:0x014f, B:63:0x0161, B:64:0x016f, B:65:0x0181, B:66:0x0189, B:67:0x019b, B:68:0x01ad, B:69:0x01bf, B:70:0x01d1, B:71:0x01e3, B:72:0x01f5, B:73:0x0207, B:74:0x0219, B:76:0x0229, B:80:0x024a, B:77:0x0233, B:79:0x023b, B:81:0x025a, B:82:0x026b, B:83:0x0278, B:84:0x0285, B:85:0x0292), top: B:192:0x05fc }] */
    /* JADX WARN: Code duplicated, block: B:170:0x0638 A[LOOP:5: B:168:0x0634->B:170:0x0638, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:172:0x064c  */
    /* JADX WARN: Code duplicated, block: B:207:0x0632 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.google.android.gms.internal.measurement.zzlw] */
    @Override // com.google.android.gms.internal.measurement.zzlz
    public final void zza(T t, zzlw zzlwVar, zzjh zzjhVar) throws Throwable {
        Object obj;
        zzmu zzmuVar;
        T t2;
        zzjj<?> zzjjVar;
        zzjh zzjhVar2;
        Object obj2;
        Object objZza;
        int i;
        zzmu zzmuVar2;
        T t3;
        T t4 = t;
        zzjh zzjhVar3 = zzjhVar;
        zzjhVar.getClass();
        zzf(t);
        zzmu zzmuVar3 = this.zzq;
        zzjj<?> zzjjVar2 = this.zzr;
        Object objZza2 = null;
        zzjk zzjkVarZzb = null;
        while (true) {
            try {
                int iZzc = zzlwVar.zzc();
                int iZza = zza(iZzc);
                if (iZza < 0) {
                    if (iZzc == Integer.MAX_VALUE) {
                        for (int i2 = this.zzm; i2 < this.zzn; i2++) {
                            objZza2 = zza(t, this.zzl[i2], objZza2, (zzmu<UT, Object>) zzmuVar3, t);
                        }
                        if (objZza2 != null) {
                            zzmuVar3.zzb(t4, objZza2);
                            return;
                        }
                        return;
                    }
                    try {
                        Object objZza3 = !this.zzh ? null : zzjjVar2.zza(zzjhVar3, this.zzg, iZzc);
                        if (objZza3 != null) {
                            if (zzjkVarZzb == null) {
                                zzjkVarZzb = zzjjVar2.zzb(t4);
                            }
                            zzjk zzjkVar = zzjkVarZzb;
                            zzmuVar2 = zzmuVar3;
                            t3 = t4;
                            try {
                                objZza2 = zzjjVar2.zza(t, zzlwVar, objZza3, zzjhVar, zzjkVar, objZza2, zzmuVar2);
                                zzjkVarZzb = zzjkVar;
                            } catch (Throwable th) {
                                th = th;
                                t2 = t3;
                                zzmuVar = zzmuVar2;
                            }
                        } else {
                            zzmuVar2 = zzmuVar3;
                            t3 = t4;
                            zzmuVar2.zza((zzlw) zzlwVar);
                            if (objZza2 == null) {
                                objZza2 = zzmuVar2.zzc(t3);
                            }
                            zzjkVarZzb = zzjkVarZzb;
                            if (!zzmuVar2.zza(objZza2, (zzlw) zzlwVar)) {
                                int i3 = this.zzm;
                                while (i3 < this.zzn) {
                                    zzmu zzmuVar4 = zzmuVar2;
                                    objZza2 = zza(t, this.zzl[i3], objZza2, (zzmu<UT, Object>) zzmuVar4, t);
                                    i3++;
                                    t3 = t3;
                                    zzmuVar2 = zzmuVar4;
                                }
                                T t5 = t3;
                                zzmu zzmuVar5 = zzmuVar2;
                                if (objZza2 != null) {
                                    zzmuVar5.zzb(t5, objZza2);
                                    return;
                                }
                                return;
                            }
                        }
                        zzmuVar = zzmuVar2;
                        t4 = t3;
                        zzmuVar3 = zzmuVar;
                        zzjkVarZzb = zzjkVarZzb;
                    } catch (Throwable th2) {
                        th = th2;
                        zzmuVar = zzmuVar3;
                        t2 = t4;
                        obj = objZza2;
                        objZza2 = obj;
                    }
                } else {
                    zzmuVar = zzmuVar3;
                    t2 = t4;
                    try {
                        int iZzc2 = zzc(iZza);
                        switch ((267386880 & iZzc2) >>> 20) {
                            case 0:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zza(t2, iZzc2 & 1048575, zzlwVar.zza());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 1:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zza((Object) t2, iZzc2 & 1048575, zzlwVar.zzb());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 2:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zza((Object) t2, iZzc2 & 1048575, zzlwVar.zzl());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 3:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zza((Object) t2, iZzc2 & 1048575, zzlwVar.zzo());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 4:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zza((Object) t2, iZzc2 & 1048575, zzlwVar.zzg());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 5:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zza((Object) t2, iZzc2 & 1048575, zzlwVar.zzk());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 6:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zza((Object) t2, iZzc2 & 1048575, zzlwVar.zzf());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 7:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zzc(t2, iZzc2 & 1048575, zzlwVar.zzs());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 8:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zza((Object) t2, iZzc2, (zzlw) zzlwVar);
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 9:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlh zzlhVar = (zzlh) zza((Object) t2, iZza);
                                zzlwVar.zzb(zzlhVar, zze(iZza), zzjhVar2);
                                zza(t2, iZza, zzlhVar);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 10:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zza(t2, iZzc2 & 1048575, zzlwVar.zzp());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 11:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zza((Object) t2, iZzc2 & 1048575, zzlwVar.zzj());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 12:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                int iZze = zzlwVar.zze();
                                zzjy zzjyVarZzd = zzd(iZza);
                                if (zzjyVarZzd != null && !zzjyVarZzd.zza(iZze)) {
                                    objZza = zzmb.zza(t2, iZzc, iZze, obj2, zzmuVar);
                                    objZza2 = objZza;
                                    t4 = t2;
                                    zzjjVar2 = zzjjVar;
                                    zzjhVar3 = zzjhVar2;
                                    zzmuVar3 = zzmuVar;
                                    zzjkVarZzb = zzjkVarZzb;
                                }
                                zzna.zza((Object) t2, iZzc2 & 1048575, iZze);
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 13:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zza((Object) t2, iZzc2 & 1048575, zzlwVar.zzh());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 14:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zza((Object) t2, iZzc2 & 1048575, zzlwVar.zzm());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 15:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zza((Object) t2, iZzc2 & 1048575, zzlwVar.zzi());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 16:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzna.zza((Object) t2, iZzc2 & 1048575, zzlwVar.zzn());
                                zzb((Object) t2, iZza);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 17:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlh zzlhVar2 = (zzlh) zza((Object) t2, iZza);
                                zzlwVar.zza(zzlhVar2, zze(iZza), zzjhVar2);
                                zza(t2, iZza, zzlhVar2);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 18:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzc(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 19:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzg(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 20:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzi(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 21:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzq(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 22:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzh(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 23:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzf(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 24:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zze(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 25:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zza(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 26:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                if (zzg(iZzc2)) {
                                    zzlwVar.zzo(this.zzp.zza(t2, iZzc2 & 1048575));
                                } else {
                                    zzlwVar.zzn(this.zzp.zza(t2, iZzc2 & 1048575));
                                }
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 27:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzb(this.zzp.zza(t2, iZzc2 & 1048575), zze(iZza), zzjhVar2);
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 28:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzb(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 29:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzp(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 30:
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                List listZza = this.zzp.zza(t2, iZzc2 & 1048575);
                                zzlwVar.zzd(listZza);
                                objZza = zzmb.zza(t, iZzc, listZza, zzd(iZza), objZza2, zzmuVar);
                                objZza2 = objZza;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 31:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzj(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 32:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzk(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 33:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzl(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 34:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzm(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 35:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzc(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 36:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzg(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 37:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzi(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 38:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzq(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 39:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzh(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 40:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzf(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 41:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zze(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 42:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zza(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 43:
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                zzlwVar.zzp(this.zzp.zza(t2, iZzc2 & 1048575));
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 44:
                                List listZza2 = this.zzp.zza(t2, iZzc2 & 1048575);
                                zzlwVar.zzd(listZza2);
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza = zzmb.zza(t, iZzc, listZza2, zzd(iZza), objZza2, zzmuVar);
                                objZza2 = objZza;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 45:
                                zzlwVar.zzj(this.zzp.zza(t2, iZzc2 & 1048575));
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 46:
                                zzlwVar.zzk(this.zzp.zza(t2, iZzc2 & 1048575));
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 47:
                                zzlwVar.zzl(this.zzp.zza(t2, iZzc2 & 1048575));
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 48:
                                zzlwVar.zzm(this.zzp.zza(t2, iZzc2 & 1048575));
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                zzlwVar.zza(this.zzp.zza(t2, iZzc2 & 1048575), zze(iZza), zzjhVar3);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 50:
                                Object objZzf = zzf(iZza);
                                long jZzc = zzc(iZza) & 1048575;
                                Object objZze = zzna.zze(t2, jZzc);
                                if (objZze == null) {
                                    objZze = this.zzs.zzb(objZzf);
                                    zzna.zza(t2, jZzc, objZze);
                                } else if (this.zzs.zzf(objZze)) {
                                    Object objZzb = this.zzs.zzb(objZzf);
                                    this.zzs.zza(objZzb, objZze);
                                    zzna.zza(t2, jZzc, objZzb);
                                    objZze = objZzb;
                                }
                                zzlwVar.zza(this.zzs.zze(objZze), this.zzs.zza(objZzf), zzjhVar3);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                zzna.zza(t2, iZzc2 & 1048575, Double.valueOf(zzlwVar.zza()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 52:
                                zzna.zza(t2, iZzc2 & 1048575, Float.valueOf(zzlwVar.zzb()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                zzna.zza(t2, iZzc2 & 1048575, Long.valueOf(zzlwVar.zzl()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 54:
                                zzna.zza(t2, iZzc2 & 1048575, Long.valueOf(zzlwVar.zzo()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                zzna.zza(t2, iZzc2 & 1048575, Integer.valueOf(zzlwVar.zzg()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 56:
                                zzna.zza(t2, iZzc2 & 1048575, Long.valueOf(zzlwVar.zzk()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 57:
                                zzna.zza(t2, iZzc2 & 1048575, Integer.valueOf(zzlwVar.zzf()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                                zzna.zza(t2, iZzc2 & 1048575, Boolean.valueOf(zzlwVar.zzs()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 59:
                                zza((Object) t2, iZzc2, (zzlw) zzlwVar);
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 60:
                                zzlh zzlhVar3 = (zzlh) zza(t2, iZzc, iZza);
                                zzlwVar.zzb(zzlhVar3, zze(iZza), zzjhVar3);
                                zza(t2, iZzc, iZza, zzlhVar3);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                zzna.zza(t2, iZzc2 & 1048575, zzlwVar.zzp());
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                                zzna.zza(t2, iZzc2 & 1048575, Integer.valueOf(zzlwVar.zzj()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 63:
                                int iZze2 = zzlwVar.zze();
                                zzjy zzjyVarZzd2 = zzd(iZza);
                                if (zzjyVarZzd2 != null && !zzjyVarZzd2.zza(iZze2)) {
                                    objZza = zzmb.zza(t2, iZzc, iZze2, objZza2, zzmuVar);
                                    zzjjVar = zzjjVar2;
                                    zzjhVar2 = zzjhVar3;
                                    objZza2 = objZza;
                                    t4 = t2;
                                    zzjjVar2 = zzjjVar;
                                    zzjhVar3 = zzjhVar2;
                                    zzmuVar3 = zzmuVar;
                                    zzjkVarZzb = zzjkVarZzb;
                                }
                                zzna.zza(t2, iZzc2 & 1048575, Integer.valueOf(iZze2));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 64:
                                zzna.zza(t2, iZzc2 & 1048575, Integer.valueOf(zzlwVar.zzh()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 65:
                                zzna.zza(t2, iZzc2 & 1048575, Long.valueOf(zzlwVar.zzm()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                zzna.zza(t2, iZzc2 & 1048575, Integer.valueOf(zzlwVar.zzi()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                                zzna.zza(t2, iZzc2 & 1048575, Long.valueOf(zzlwVar.zzn()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                objZza2 = obj2;
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            case 68:
                                try {
                                    zzlh zzlhVar4 = (zzlh) zza(t2, iZzc, iZza);
                                    zzlwVar.zza(zzlhVar4, zze(iZza), zzjhVar3);
                                    zza(t2, iZzc, iZza, zzlhVar4);
                                    obj2 = objZza2;
                                    zzjjVar = zzjjVar2;
                                    zzjhVar2 = zzjhVar3;
                                    objZza2 = obj2;
                                } catch (zzkf unused) {
                                    obj = objZza2;
                                    zzjjVar = zzjjVar2;
                                    zzjhVar2 = zzjhVar3;
                                    objZza2 = obj;
                                    zzmuVar.zza((zzlw) zzlwVar);
                                    if (objZza2 == null) {
                                        objZza2 = zzmuVar.zzc(t2);
                                    }
                                    if (!zzmuVar.zza(objZza2, (zzlw) zzlwVar)) {
                                        for (i = this.zzm; i < this.zzn; i++) {
                                            objZza2 = zza(t, this.zzl[i], objZza2, (zzmu<UT, Object>) zzmuVar, t);
                                        }
                                        if (objZza2 != null) {
                                            zzmuVar.zzb(t2, objZza2);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                t4 = t2;
                                zzjjVar2 = zzjjVar;
                                zzjhVar3 = zzjhVar2;
                                zzmuVar3 = zzmuVar;
                                zzjkVarZzb = zzjkVarZzb;
                                break;
                            default:
                                obj = objZza2;
                                zzjjVar = zzjjVar2;
                                zzjhVar2 = zzjhVar3;
                                if (obj == null) {
                                    try {
                                        objZza2 = zzmuVar.zzc(t2);
                                    } catch (zzkf unused2) {
                                        objZza2 = obj;
                                        zzmuVar.zza((zzlw) zzlwVar);
                                        if (objZza2 == null) {
                                            objZza2 = zzmuVar.zzc(t2);
                                        }
                                        if (!zzmuVar.zza(objZza2, (zzlw) zzlwVar)) {
                                            while (i < this.zzn) {
                                                objZza2 = zza(t, this.zzl[i], objZza2, (zzmu<UT, Object>) zzmuVar, t);
                                            }
                                            if (objZza2 != null) {
                                                zzmuVar.zzb(t2, objZza2);
                                                return;
                                            }
                                            return;
                                        }
                                        t4 = t2;
                                        zzjjVar2 = zzjjVar;
                                        zzjhVar3 = zzjhVar2;
                                        zzmuVar3 = zzmuVar;
                                        zzjkVarZzb = zzjkVarZzb;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        objZza2 = obj;
                                    }
                                } else {
                                    objZza2 = obj;
                                }
                                try {
                                    try {
                                        if (!zzmuVar.zza(objZza2, (zzlw) zzlwVar)) {
                                            for (int i4 = this.zzm; i4 < this.zzn; i4++) {
                                                objZza2 = zza(t, this.zzl[i4], objZza2, (zzmu<UT, Object>) zzmuVar, t);
                                            }
                                            if (objZza2 != null) {
                                                zzmuVar.zzb(t2, objZza2);
                                                return;
                                            }
                                            return;
                                        }
                                        objZza = objZza2;
                                        objZza2 = objZza;
                                        t4 = t2;
                                        zzjjVar2 = zzjjVar;
                                        zzjhVar3 = zzjhVar2;
                                        zzmuVar3 = zzmuVar;
                                        zzjkVarZzb = zzjkVarZzb;
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                } catch (zzkf unused3) {
                                    zzmuVar.zza((zzlw) zzlwVar);
                                    if (objZza2 == null) {
                                        objZza2 = zzmuVar.zzc(t2);
                                    }
                                    if (!zzmuVar.zza(objZza2, (zzlw) zzlwVar)) {
                                        while (i < this.zzn) {
                                            objZza2 = zza(t, this.zzl[i], objZza2, (zzmu<UT, Object>) zzmuVar, t);
                                        }
                                        if (objZza2 != null) {
                                            zzmuVar.zzb(t2, objZza2);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                break;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        obj = objZza2;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                obj = objZza2;
                zzmuVar = zzmuVar3;
                t2 = t4;
            }
            objZza2 = obj;
            for (int i5 = this.zzm; i5 < this.zzn; i5++) {
                objZza2 = zza(t, this.zzl[i5], objZza2, (zzmu<UT, Object>) zzmuVar, t);
            }
            if (objZza2 != null) {
                zzmuVar.zzb(t2, objZza2);
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final void zza(T t, byte[] bArr, int i, int i2, zzig zzigVar) throws IOException {
        zza(t, bArr, i, i2, 0, zzigVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t, T t2, int i) {
        if (zzc((Object) t2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzlz zzlzVarZze = zze(i);
            if (!zzc((Object) t, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzlzVarZze.zza();
                    zzlzVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb((Object) t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzlzVarZze.zza();
                zzlzVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzlzVarZze.zza(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t, T t2, int i) {
        int i2 = this.zzc[i];
        if (zzc(t2, i2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzlz zzlzVarZze = zze(i);
            if (!zzc(t, i2, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzlzVarZze.zza();
                    zzlzVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb(t, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzlzVarZze.zza();
                zzlzVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzlzVarZze.zza(object2, object);
        }
    }

    private final void zza(Object obj, int i, zzlw zzlwVar) throws IOException {
        if (zzg(i)) {
            zzna.zza(obj, i & 1048575, zzlwVar.zzr());
        } else if (this.zzi) {
            zzna.zza(obj, i & 1048575, zzlwVar.zzq());
        } else {
            zzna.zza(obj, i & 1048575, zzlwVar.zzp());
        }
    }

    private final void zzb(T t, int i) {
        int iZzb = zzb(i);
        long j = 1048575 & iZzb;
        if (j == 1048575) {
            return;
        }
        zzna.zza((Object) t, j, (1 << (iZzb >>> 20)) | zzna.zzc(t, j));
    }

    private final void zzb(T t, int i, int i2) {
        zzna.zza((Object) t, zzb(i2) & 1048575, i);
    }

    private final void zza(T t, int i, Object obj) {
        zzb.putObject(t, zzc(i) & 1048575, obj);
        zzb((Object) t, i);
    }

    private final void zza(T t, int i, int i2, Object obj) {
        zzb.putObject(t, zzc(i2) & 1048575, obj);
        zzb(t, i, i2);
    }

    private final <K, V> void zza(zznu zznuVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zznuVar.zza(i, this.zzs.zza(zzf(i2)), this.zzs.zzd(obj));
        }
    }

    private static void zza(int i, Object obj, zznu zznuVar) throws IOException {
        if (obj instanceof String) {
            zznuVar.zza(i, (String) obj);
        } else {
            zznuVar.zza(i, (zzih) obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:176:0x054b  */
    /* JADX WARN: Code duplicated, block: B:9:0x0037  */
    @Override // com.google.android.gms.internal.measurement.zzlz
    public final void zza(T t, zznu zznuVar) throws IOException {
        Map.Entry<?, ?> entry;
        Iterator it2;
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        Unsafe unsafe;
        boolean z2;
        Iterator itZzc;
        Map.Entry<?, ?> entry2;
        zznu zznuVar2 = zznuVar;
        int i5 = 267386880;
        int i6 = 1048575;
        if (zznuVar.zza() == zznt.zzb) {
            zza(this.zzq, t, zznuVar2);
            if (this.zzh) {
                zzjk<T> zzjkVarZza = this.zzr.zza(t);
                if (zzjkVarZza.zza.isEmpty()) {
                    itZzc = null;
                    entry2 = null;
                } else {
                    itZzc = zzjkVarZza.zzc();
                    entry2 = (Map.Entry) itZzc.next();
                }
            } else {
                itZzc = null;
                entry2 = null;
            }
            for (int length = this.zzc.length - 3; length >= 0; length -= 3) {
                int iZzc = zzc(length);
                int i7 = this.zzc[length];
                while (entry2 != null && this.zzr.zza(entry2) > i7) {
                    this.zzr.zza(zznuVar2, entry2);
                    entry2 = itZzc.hasNext() ? (Map.Entry) itZzc.next() : null;
                }
                switch ((iZzc & 267386880) >>> 20) {
                    case 0:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zza(i7, zzna.zza(t, iZzc & 1048575));
                        }
                        break;
                    case 1:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zza(i7, zzna.zzb(t, iZzc & 1048575));
                        }
                        break;
                    case 2:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zzb(i7, zzna.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 3:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zze(i7, zzna.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 4:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zzc(i7, zzna.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 5:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zza(i7, zzna.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 6:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zzb(i7, zzna.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 7:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zza(i7, zzna.zzh(t, iZzc & 1048575));
                        }
                        break;
                    case 8:
                        if (zzc((Object) t, length)) {
                            zza(i7, zzna.zze(t, iZzc & 1048575), zznuVar2);
                        }
                        break;
                    case 9:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zzb(i7, zzna.zze(t, iZzc & 1048575), zze(length));
                        }
                        break;
                    case 10:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zza(i7, (zzih) zzna.zze(t, iZzc & 1048575));
                        }
                        break;
                    case 11:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zzf(i7, zzna.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 12:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zza(i7, zzna.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 13:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zzd(i7, zzna.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 14:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zzc(i7, zzna.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 15:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zze(i7, zzna.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 16:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zzd(i7, zzna.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 17:
                        if (zzc((Object) t, length)) {
                            zznuVar2.zza(i7, zzna.zze(t, iZzc & 1048575), zze(length));
                        }
                        break;
                    case 18:
                        zzmb.zzb(this.zzc[length], (List<Double>) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 19:
                        zzmb.zzf(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 20:
                        zzmb.zzh(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 21:
                        zzmb.zzn(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 22:
                        zzmb.zzg(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 23:
                        zzmb.zze(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 24:
                        zzmb.zzd(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 25:
                        zzmb.zza(this.zzc[length], (List<Boolean>) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 26:
                        zzmb.zzb(this.zzc[length], (List<String>) zzna.zze(t, iZzc & 1048575), zznuVar2);
                        break;
                    case 27:
                        zzmb.zzb(this.zzc[length], (List<?>) zzna.zze(t, iZzc & 1048575), zznuVar2, zze(length));
                        break;
                    case 28:
                        zzmb.zza(this.zzc[length], (List<zzih>) zzna.zze(t, iZzc & 1048575), zznuVar2);
                        break;
                    case 29:
                        zzmb.zzm(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 30:
                        zzmb.zzc(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 31:
                        zzmb.zzi(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 32:
                        zzmb.zzj(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 33:
                        zzmb.zzk(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 34:
                        zzmb.zzl(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, false);
                        break;
                    case 35:
                        zzmb.zzb(this.zzc[length], (List<Double>) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case 36:
                        zzmb.zzf(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case 37:
                        zzmb.zzh(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case 38:
                        zzmb.zzn(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case 39:
                        zzmb.zzg(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case 40:
                        zzmb.zze(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case 41:
                        zzmb.zzd(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case 42:
                        zzmb.zza(this.zzc[length], (List<Boolean>) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case 43:
                        zzmb.zzm(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case 44:
                        zzmb.zzc(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case 45:
                        zzmb.zzi(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case 46:
                        zzmb.zzj(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case 47:
                        zzmb.zzk(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case 48:
                        zzmb.zzl(this.zzc[length], (List) zzna.zze(t, iZzc & 1048575), zznuVar2, true);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                        zzmb.zza(this.zzc[length], (List<?>) zzna.zze(t, iZzc & 1048575), zznuVar2, zze(length));
                        break;
                    case 50:
                        zza(zznuVar2, i7, zzna.zze(t, iZzc & 1048575), length);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zza(i7, zza(t, iZzc & 1048575));
                        }
                        break;
                    case 52:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zza(i7, zzb(t, iZzc & 1048575));
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zzb(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 54:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zze(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zzc(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 56:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zza(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 57:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zzb(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zza(i7, zze(t, iZzc & 1048575));
                        }
                        break;
                    case 59:
                        if (zzc(t, i7, length)) {
                            zza(i7, zzna.zze(t, iZzc & 1048575), zznuVar2);
                        }
                        break;
                    case 60:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zzb(i7, zzna.zze(t, iZzc & 1048575), zze(length));
                        }
                        break;
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zza(i7, (zzih) zzna.zze(t, iZzc & 1048575));
                        }
                        break;
                    case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zzf(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 63:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zza(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 64:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zzd(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 65:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zzc(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zze(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zzd(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 68:
                        if (zzc(t, i7, length)) {
                            zznuVar2.zza(i7, zzna.zze(t, iZzc & 1048575), zze(length));
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.zzr.zza(zznuVar2, entry2);
                entry2 = itZzc.hasNext() ? (Map.Entry) itZzc.next() : null;
            }
            return;
        }
        if (this.zzh) {
            zzjk<T> zzjkVarZza2 = this.zzr.zza(t);
            if (zzjkVarZza2.zza.isEmpty()) {
                entry = null;
                it2 = null;
            } else {
                Iterator itZzd = zzjkVarZza2.zzd();
                entry = (Map.Entry) itZzd.next();
                it2 = itZzd;
            }
        } else {
            entry = null;
            it2 = null;
        }
        int length2 = this.zzc.length;
        Unsafe unsafe2 = zzb;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1048575;
        while (i9 < length2) {
            int iZzc2 = zzc(i9);
            int[] iArr = this.zzc;
            int i11 = iArr[i9];
            int i12 = (iZzc2 & i5) >>> 20;
            if (i12 <= 17) {
                int i13 = iArr[i9 + 2];
                int i14 = i13 & i6;
                if (i14 != i10) {
                    i8 = i14 == i6 ? 0 : unsafe2.getInt(t, i14);
                    i10 = i14;
                }
                i2 = i8;
                i3 = 1 << (i13 >>> 20);
                i = i10;
            } else {
                i = i10;
                i2 = i8;
                i3 = 0;
            }
            while (entry != null && this.zzr.zza(entry) <= i11) {
                this.zzr.zza(zznuVar2, entry);
                entry = it2.hasNext() ? (Map.Entry) it2.next() : null;
            }
            long j = iZzc2 & 1048575;
            switch (i12) {
                case 0:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zza(i11, zzna.zza(t, j));
                    }
                    break;
                case 1:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zza(i11, zzna.zzb(t, j));
                    }
                    break;
                case 2:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zzb(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 3:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zze(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 4:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zzc(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 5:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zza(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 6:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zzb(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 7:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zza(i11, zzna.zzh(t, j));
                    }
                    break;
                case 8:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zza(i11, unsafe.getObject(t, j), zznuVar2);
                    }
                    break;
                case 9:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zzb(i11, unsafe.getObject(t, j), zze(i4));
                    }
                    break;
                case 10:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zza(i11, (zzih) unsafe.getObject(t, j));
                    }
                    break;
                case 11:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zzf(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 12:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zza(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 13:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zzd(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 14:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zzc(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 15:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zze(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 16:
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    i = i;
                    if (zza(t, i4, i, i2, i3)) {
                        zznuVar2.zzd(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 17:
                    z = false;
                    entry = entry;
                    i4 = i9;
                    length2 = length2;
                    unsafe = unsafe2;
                    if (zza(t, i9, i, i2, i3)) {
                        zznuVar2 = zznuVar;
                        zznuVar2.zza(i11, unsafe.getObject(t, j), zze(i4));
                    } else {
                        zznuVar2 = zznuVar;
                    }
                    i = i;
                    break;
                case 18:
                    z2 = false;
                    zzmb.zzb(this.zzc[i9], (List<Double>) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 19:
                    z2 = false;
                    zzmb.zzf(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 20:
                    z2 = false;
                    zzmb.zzh(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 21:
                    z2 = false;
                    zzmb.zzn(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 22:
                    z2 = false;
                    zzmb.zzg(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 23:
                    z2 = false;
                    zzmb.zze(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 24:
                    z2 = false;
                    zzmb.zzd(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 25:
                    z2 = false;
                    zzmb.zza(this.zzc[i9], (List<Boolean>) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 26:
                    zzmb.zzb(this.zzc[i9], (List<String>) unsafe2.getObject(t, j), zznuVar2);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 27:
                    zzmb.zzb(this.zzc[i9], (List<?>) unsafe2.getObject(t, j), zznuVar2, zze(i9));
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 28:
                    zzmb.zza(this.zzc[i9], (List<zzih>) unsafe2.getObject(t, j), zznuVar2);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 29:
                    z2 = false;
                    zzmb.zzm(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 30:
                    z2 = false;
                    zzmb.zzc(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 31:
                    z2 = false;
                    zzmb.zzi(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 32:
                    z2 = false;
                    zzmb.zzj(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 33:
                    z2 = false;
                    zzmb.zzk(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 34:
                    z2 = false;
                    zzmb.zzl(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 35:
                    zzmb.zzb(this.zzc[i9], (List<Double>) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 36:
                    zzmb.zzf(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 37:
                    zzmb.zzh(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 38:
                    zzmb.zzn(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 39:
                    zzmb.zzg(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 40:
                    zzmb.zze(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 41:
                    zzmb.zzd(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 42:
                    zzmb.zza(this.zzc[i9], (List<Boolean>) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 43:
                    zzmb.zzm(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 44:
                    zzmb.zzc(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 45:
                    zzmb.zzi(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 46:
                    zzmb.zzj(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 47:
                    zzmb.zzk(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 48:
                    zzmb.zzl(this.zzc[i9], (List) unsafe2.getObject(t, j), zznuVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    zzmb.zza(this.zzc[i9], (List<?>) unsafe2.getObject(t, j), zznuVar2, zze(i9));
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 50:
                    zza(zznuVar2, i11, unsafe2.getObject(t, j), i9);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zza(i11, zza(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 52:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zza(i11, zzb(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zzb(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 54:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zze(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zzc(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 56:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zza(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 57:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zzb(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zza(i11, zze(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 59:
                    if (zzc(t, i11, i9)) {
                        zza(i11, unsafe2.getObject(t, j), zznuVar2);
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 60:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zzb(i11, unsafe2.getObject(t, j), zze(i9));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zza(i11, (zzih) unsafe2.getObject(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zzf(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 63:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zza(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 64:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zzd(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 65:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zzc(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zze(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zzd(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 68:
                    if (zzc(t, i11, i9)) {
                        zznuVar2.zza(i11, unsafe2.getObject(t, j), zze(i9));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                default:
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
            }
            i9 = i4 + 3;
            i8 = i2;
            unsafe2 = unsafe;
            i6 = 1048575;
            it2 = it2;
            entry = entry;
            length2 = length2;
            i10 = i;
            i5 = 267386880;
        }
        Iterator it3 = it2;
        while (entry != null) {
            this.zzr.zza(zznuVar2, entry);
            entry = it3.hasNext() ? (Map.Entry) it3.next() : null;
        }
        zza(this.zzq, t, zznuVar2);
    }

    private static <UT, UB> void zza(zzmu<UT, UB> zzmuVar, T t, zznu zznuVar) throws IOException {
        zzmuVar.zzb(zzmuVar.zzd(t), zznuVar);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzc((Object) t, i) == zzc((Object) t2, i);
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final boolean zzb(T t, T t2) {
        boolean zZza;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzc = zzc(i);
            long j = iZzc & 1048575;
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (!zzc(t, t2, i) || Double.doubleToLongBits(zzna.zza(t, j)) != Double.doubleToLongBits(zzna.zza(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzc(t, t2, i) || Float.floatToIntBits(zzna.zzb(t, j)) != Float.floatToIntBits(zzna.zzb(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzc(t, t2, i) || zzna.zzd(t, j) != zzna.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzc(t, t2, i) || zzna.zzd(t, j) != zzna.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzc(t, t2, i) || zzna.zzc(t, j) != zzna.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzc(t, t2, i) || zzna.zzd(t, j) != zzna.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzc(t, t2, i) || zzna.zzc(t, j) != zzna.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzc(t, t2, i) || zzna.zzh(t, j) != zzna.zzh(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzc(t, t2, i) || !zzmb.zza(zzna.zze(t, j), zzna.zze(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzc(t, t2, i) || !zzmb.zza(zzna.zze(t, j), zzna.zze(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzc(t, t2, i) || !zzmb.zza(zzna.zze(t, j), zzna.zze(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzc(t, t2, i) || zzna.zzc(t, j) != zzna.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzc(t, t2, i) || zzna.zzc(t, j) != zzna.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzc(t, t2, i) || zzna.zzc(t, j) != zzna.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzc(t, t2, i) || zzna.zzd(t, j) != zzna.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzc(t, t2, i) || zzna.zzc(t, j) != zzna.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzc(t, t2, i) || zzna.zzd(t, j) != zzna.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzc(t, t2, i) || !zzmb.zza(zzna.zze(t, j), zzna.zze(t2, j))) {
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
                    zZza = zzmb.zza(zzna.zze(t, j), zzna.zze(t2, j));
                    break;
                case 50:
                    zZza = zzmb.zza(zzna.zze(t, j), zzna.zze(t2, j));
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
                    long jZzb = zzb(i) & 1048575;
                    if (zzna.zzc(t, jZzb) != zzna.zzc(t2, jZzb) || !zzmb.zza(zzna.zze(t, j), zzna.zze(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZza) {
                return false;
            }
        }
        if (!this.zzq.zzd(t).equals(this.zzq.zzd(t2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzr.zza(t).equals(this.zzr.zza(t2));
        }
        return true;
    }

    private final boolean zzc(T t, int i) {
        int iZzb = zzb(i);
        long j = iZzb & 1048575;
        if (j != 1048575) {
            return (zzna.zzc(t, j) & (1 << (iZzb >>> 20))) != 0;
        }
        int iZzc = zzc(i);
        long j2 = iZzc & 1048575;
        switch ((iZzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzna.zza(t, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzna.zzb(t, j2)) != 0;
            case 2:
                return zzna.zzd(t, j2) != 0;
            case 3:
                return zzna.zzd(t, j2) != 0;
            case 4:
                return zzna.zzc(t, j2) != 0;
            case 5:
                return zzna.zzd(t, j2) != 0;
            case 6:
                return zzna.zzc(t, j2) != 0;
            case 7:
                return zzna.zzh(t, j2);
            case 8:
                Object objZze = zzna.zze(t, j2);
                if (objZze instanceof String) {
                    return !((String) objZze).isEmpty();
                }
                if (objZze instanceof zzih) {
                    return !zzih.zza.equals(objZze);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzna.zze(t, j2) != null;
            case 10:
                return !zzih.zza.equals(zzna.zze(t, j2));
            case 11:
                return zzna.zzc(t, j2) != 0;
            case 12:
                return zzna.zzc(t, j2) != 0;
            case 13:
                return zzna.zzc(t, j2) != 0;
            case 14:
                return zzna.zzd(t, j2) != 0;
            case 15:
                return zzna.zzc(t, j2) != 0;
            case 16:
                return zzna.zzd(t, j2) != 0;
            case 17:
                return zzna.zze(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzc((Object) t, i);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f8 A[LOOP:2: B:52:0x00e7->B:57:0x00f8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzlz] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzlz] */
    @Override // com.google.android.gms.internal.measurement.zzlz
    public final boolean zzd(T t) {
        int i;
        int i2;
        List list;
        ?? Zze;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzm) {
            int i7 = this.zzl[i6];
            int i8 = this.zzc[i7];
            int iZzc = zzc(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(t, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iZzc) != 0 && !zza(t, i7, i, i2, i11)) {
                return false;
            }
            int i12 = (267386880 & iZzc) >>> 20;
            if (i12 == 9 || i12 == 17) {
                if (zza(t, i7, i, i2, i11) && !zza((Object) t, iZzc, zze(i7))) {
                    return false;
                }
            } else if (i12 == 27) {
                list = (List) zzna.zze(t, iZzc & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    Zze = zze(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!Zze.zzd(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (i12 == 60 || i12 == 68) {
                if (zzc(t, i8, i7) && !zza((Object) t, iZzc, zze(i7))) {
                    return false;
                }
            } else if (i12 == 49) {
                list = (List) zzna.zze(t, iZzc & 1048575);
                if (list.isEmpty()) {
                    Zze = zze(i7);
                    while (i3 < list.size()) {
                        if (!Zze.zzd(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (i12 != 50) {
                continue;
            } else {
                Map<?, ?> mapZzd = this.zzs.zzd(zzna.zze(t, iZzc & 1048575));
                if (mapZzd.isEmpty()) {
                    continue;
                } else if (this.zzs.zza(zzf(i7)).zzc.zzb() == zznr.MESSAGE) {
                    ?? Zza = 0;
                    for (Object obj : mapZzd.values()) {
                        if (Zza == 0) {
                            Zza = Zza;
                            Zza = zzlv.zza().zza((Class) obj.getClass());
                        }
                        Zza = Zza;
                        if (!Zza.zzd(obj)) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
        return !this.zzh || this.zzr.zza(t).zzg();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzlz zzlzVar) {
        return zzlzVar.zzd(zzna.zze(obj, i & 1048575));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzju) {
            return ((zzju) obj).zzcj();
        }
        return true;
    }

    private final boolean zzc(T t, int i, int i2) {
        return zzna.zzc(t, (long) (zzb(i2) & 1048575)) == i;
    }

    private static <T> boolean zze(T t, long j) {
        return ((Boolean) zzna.zze(t, j)).booleanValue();
    }
}
