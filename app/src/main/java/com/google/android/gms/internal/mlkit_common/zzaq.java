package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes2.dex */
final class zzaq extends zzai {
    static final zzai zza = new zzaq(null, new Object[0], 0);
    final transient Object[] zzb;

    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzaq(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX WARN: Code duplicated, block: B:73:0x018c A[PHI: r4
  0x018c: PHI (r4v3 ??) = (r4v2 ??), (r4v4 short[]) binds: [B:72:0x018a, B:55:0x012a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3 */
    static zzaq zzg(int i, Object[] objArr, zzah zzahVar) {
        int iHighestOneBit;
        short[] sArr;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return (zzaq) zza;
        }
        zzag zzagVar = null;
        ?? r3 = 0;
        zzag zzagVar2 = null;
        zzag zzagVar3 = null;
        if (i2 == 1) {
            Object obj = objArrCopyOf[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArrCopyOf[1];
            Objects.requireNonNull(obj2);
            zzw.zza(obj, obj2);
            return new zzaq(null, objArrCopyOf, 1);
        }
        zzt.zzb(i2, objArrCopyOf.length >> 1, FirebaseAnalytics.Param.INDEX);
        int iMax = Math.max(i2, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (((double) iHighestOneBit) * 0.7d < iMax);
        } else {
            iHighestOneBit = 1073741824;
            if (iMax >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i2 == 1) {
            Object obj3 = objArrCopyOf[0];
            Objects.requireNonNull(obj3);
            Object obj4 = objArrCopyOf[1];
            Objects.requireNonNull(obj4);
            zzw.zza(obj3, obj4);
            i2 = 1;
        } else {
            int i3 = iHighestOneBit - 1;
            byte b = -1;
            if (iHighestOneBit <= 128) {
                byte[] bArr = new byte[iHighestOneBit];
                Arrays.fill(bArr, (byte) -1);
                int i4 = 0;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = i4 + i4;
                    int i7 = i5 + i5;
                    Object obj5 = objArrCopyOf[i7];
                    Objects.requireNonNull(obj5);
                    Object obj6 = objArrCopyOf[i7 ^ 1];
                    Objects.requireNonNull(obj6);
                    zzw.zza(obj5, obj6);
                    int iZza = zzy.zza(obj5.hashCode());
                    while (true) {
                        int i8 = iZza & i3;
                        int i9 = bArr[i8] & 255;
                        if (i9 == 255) {
                            bArr[i8] = (byte) i6;
                            if (i4 < i5) {
                                objArrCopyOf[i6] = obj5;
                                objArrCopyOf[i6 ^ 1] = obj6;
                            }
                            i4++;
                            break;
                        }
                        if (obj5.equals(objArrCopyOf[i9 == true ? 1 : 0])) {
                            int i10 = ~i9;
                            Object obj7 = objArrCopyOf[i10 == true ? 1 : 0];
                            Objects.requireNonNull(obj7);
                            zzag zzagVar4 = new zzag(obj5, obj6, obj7);
                            objArrCopyOf[i10 == true ? 1 : 0] = obj6;
                            zzagVar2 = zzagVar4;
                            break;
                        }
                        iZza = i8 + 1;
                    }
                }
                r3 = i4 == i2 ? bArr : new Object[]{bArr, Integer.valueOf(i4), zzagVar2};
            } else if (iHighestOneBit <= 32768) {
                sArr = new short[iHighestOneBit];
                Arrays.fill(sArr, (short) -1);
                int i11 = 0;
                for (int i12 = 0; i12 < i2; i12++) {
                    int i13 = i11 + i11;
                    int i14 = i12 + i12;
                    Object obj8 = objArrCopyOf[i14];
                    Objects.requireNonNull(obj8);
                    Object obj9 = objArrCopyOf[i14 ^ 1];
                    Objects.requireNonNull(obj9);
                    zzw.zza(obj8, obj9);
                    int iZza2 = zzy.zza(obj8.hashCode());
                    while (true) {
                        int i15 = iZza2 & i3;
                        char c = (char) sArr[i15];
                        if (c == 65535) {
                            sArr[i15] = (short) i13;
                            if (i11 < i12) {
                                objArrCopyOf[i13] = obj8;
                                objArrCopyOf[i13 ^ 1] = obj9;
                            }
                            i11++;
                            break;
                        }
                        if (obj8.equals(objArrCopyOf[c])) {
                            int i16 = c ^ 1;
                            Object obj10 = objArrCopyOf[i16 == true ? 1 : 0];
                            Objects.requireNonNull(obj10);
                            zzag zzagVar5 = new zzag(obj8, obj9, obj10);
                            objArrCopyOf[i16 == true ? 1 : 0] = obj9;
                            zzagVar3 = zzagVar5;
                            break;
                        }
                        iZza2 = i15 + 1;
                    }
                }
                if (i11 == i2) {
                    r3 = sArr;
                } else {
                    r3 = new Object[]{sArr, Integer.valueOf(i11), zzagVar3};
                }
            } else {
                sArr = new int[iHighestOneBit];
                Arrays.fill((int[]) sArr, -1);
                int i17 = 0;
                int i18 = 0;
                while (i17 < i2) {
                    int i19 = i18 + i18;
                    int i20 = i17 + i17;
                    Object obj11 = objArrCopyOf[i20];
                    Objects.requireNonNull(obj11);
                    Object obj12 = objArrCopyOf[i20 ^ 1];
                    Objects.requireNonNull(obj12);
                    zzw.zza(obj11, obj12);
                    int iZza3 = zzy.zza(obj11.hashCode());
                    while (true) {
                        int i21 = iZza3 & i3;
                        ?? r15 = sArr[i21];
                        if (r15 == b) {
                            sArr[i21] = i19;
                            if (i18 < i17) {
                                objArrCopyOf[i19] = obj11;
                                objArrCopyOf[i19 ^ 1] = obj12;
                            }
                            i18++;
                            break;
                        }
                        if (obj11.equals(objArrCopyOf[r15])) {
                            int i22 = r15 ^ 1;
                            Object obj13 = objArrCopyOf[i22 == true ? 1 : 0];
                            Objects.requireNonNull(obj13);
                            zzag zzagVar6 = new zzag(obj11, obj12, obj13);
                            objArrCopyOf[i22 == true ? 1 : 0] = obj12;
                            zzagVar = zzagVar6;
                            break;
                        }
                        iZza3 = i21 + 1;
                        b = -1;
                    }
                    i17++;
                    b = -1;
                }
                if (i18 == i2) {
                    r3 = sArr;
                } else {
                    r3 = new Object[]{sArr, Integer.valueOf(i18), zzagVar};
                }
            }
        }
        boolean z = r3 instanceof Object[];
        ?? r4 = r3;
        if (z) {
            Object[] objArr2 = (Object[]) r3;
            zzag zzagVar7 = (zzag) objArr2[2];
            if (zzahVar == null) {
                throw zzagVar7.zza();
            }
            zzahVar.zzc = zzagVar7;
            Object obj14 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            r4 = obj14;
            i2 = iIntValue;
        }
        return new zzaq(r4, objArrCopyOf, i2);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x008f  */
    @Override // com.google.android.gms.internal.mlkit_common.zzai, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            int i = this.zzd;
            Object[] objArr = this.zzb;
            if (i == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                if (obj3.equals(obj)) {
                    obj2 = objArr[1];
                    Objects.requireNonNull(obj2);
                } else {
                    obj2 = null;
                }
            } else {
                Object obj4 = this.zzc;
                if (obj4 == null) {
                    obj2 = null;
                } else if (obj4 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj4;
                    int length = bArr.length;
                    int iZza = zzy.zza(obj.hashCode());
                    while (true) {
                        int i2 = iZza & (length - 1);
                        int i3 = bArr[i2] & 255;
                        if (i3 == 255) {
                            break;
                        }
                        if (obj.equals(objArr[i3])) {
                            obj2 = objArr[i3 ^ 1];
                        } else {
                            iZza = i2 + 1;
                        }
                    }
                    obj2 = null;
                } else if (obj4 instanceof short[]) {
                    short[] sArr = (short[]) obj4;
                    int length2 = sArr.length;
                    int iZza2 = zzy.zza(obj.hashCode());
                    while (true) {
                        int i4 = iZza2 & (length2 - 1);
                        char c = (char) sArr[i4];
                        if (c == 65535) {
                            break;
                        }
                        if (obj.equals(objArr[c])) {
                            obj2 = objArr[c ^ 1];
                        } else {
                            iZza2 = i4 + 1;
                        }
                    }
                    obj2 = null;
                } else {
                    int[] iArr = (int[]) obj4;
                    int length3 = iArr.length;
                    int iZza3 = zzy.zza(obj.hashCode());
                    while (true) {
                        int i5 = iZza3 & (length3 - 1);
                        int i6 = iArr[i5];
                        if (i6 == -1) {
                            break;
                        }
                        if (obj.equals(objArr[i6])) {
                            obj2 = objArr[i6 ^ 1];
                        } else {
                            iZza3 = i5 + 1;
                        }
                    }
                    obj2 = null;
                }
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    final zzab zza() {
        return new zzap(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    final zzaj zzd() {
        return new zzan(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    final zzaj zze() {
        return new zzao(this, new zzap(this.zzb, 0, this.zzd));
    }
}
