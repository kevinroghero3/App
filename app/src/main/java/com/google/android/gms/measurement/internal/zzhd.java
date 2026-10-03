package com.google.android.gms.measurement.internal;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class zzhd implements com.google.android.gms.internal.measurement.zzv {
    private final /* synthetic */ zzgy zza;

    zzhd(zzgy zzgyVar) {
        this.zza = zzgyVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str, List<String> list, boolean z, boolean z2) {
        zzgd zzgdVarZzc;
        int i = zzhf.zza[zzsVar.ordinal()];
        if (i == 1) {
            zzgdVarZzc = this.zza.zzj().zzc();
        } else if (i != 2) {
            if (i != 3) {
                zzgdVarZzc = i != 4 ? this.zza.zzj().zzn() : this.zza.zzj().zzp();
            } else if (z) {
                zzgdVarZzc = this.zza.zzj().zzw();
            } else {
                zzgdVarZzc = !z2 ? this.zza.zzj().zzv() : this.zza.zzj().zzu();
            }
        } else if (z) {
            zzgdVarZzc = this.zza.zzj().zzm();
        } else {
            zzgdVarZzc = !z2 ? this.zza.zzj().zzh() : this.zza.zzj().zzg();
        }
        int size = list.size();
        if (size == 1) {
            zzgdVarZzc.zza(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzgdVarZzc.zza(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzgdVarZzc.zza(str);
        } else {
            zzgdVarZzc.zza(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
