package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class zzn extends zzap {
    private final zzac zza;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    @Override // com.google.android.gms.internal.measurement.zzap, com.google.android.gms.internal.measurement.zzaq
    public final zzaq zza(String str, zzh zzhVar, List<zzaq> list) {
        byte b;
        str.hashCode();
        switch (str) {
            case "getEventName":
                b = 0;
                break;
            case "getTimestamp":
                b = 1;
                break;
            case "getParamValue":
                b = 2;
                break;
            case "getParams":
                b = 3;
                break;
            case "setParamValue":
                b = 4;
                break;
            case "setEventName":
                b = 5;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            zzg.zza("getEventName", 0, list);
            return new zzas(this.zza.zzb().zzb());
        }
        if (b == 1) {
            zzg.zza("getTimestamp", 0, list);
            return new zzai(Double.valueOf(this.zza.zzb().zza()));
        }
        if (b == 2) {
            zzg.zza("getParamValue", 1, list);
            return zzj.zza(this.zza.zzb().zza(zzhVar.zza(list.get(0)).zzf()));
        }
        if (b == 3) {
            zzg.zza("getParams", 0, list);
            Map<String, Object> mapZzc = this.zza.zzb().zzc();
            zzap zzapVar = new zzap();
            for (String str2 : mapZzc.keySet()) {
                zzapVar.zza(str2, zzj.zza(mapZzc.get(str2)));
            }
            return zzapVar;
        }
        if (b == 4) {
            zzg.zza("setParamValue", 2, list);
            String strZzf = zzhVar.zza(list.get(0)).zzf();
            zzaq zzaqVarZza = zzhVar.zza(list.get(1));
            this.zza.zzb().zza(strZzf, zzg.zza(zzaqVarZza));
            return zzaqVarZza;
        }
        if (b != 5) {
            return super.zza(str, zzhVar, list);
        }
        zzg.zza("setEventName", 1, list);
        zzaq zzaqVarZza2 = zzhVar.zza(list.get(0));
        if (zzaq.zzc.equals(zzaqVarZza2) || zzaq.zzd.equals(zzaqVarZza2)) {
            throw new IllegalArgumentException("Illegal event name");
        }
        this.zza.zzb().zzb(zzaqVarZza2.zzf());
        return new zzas(zzaqVarZza2.zzf());
    }

    public zzn(zzac zzacVar) {
        this.zza = zzacVar;
    }
}
