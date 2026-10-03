package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpz;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
final class zzim implements Callable<List<zzmy>> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzhs zzc;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzmy> call() throws Exception {
        this.zzc.zza.zzr();
        zzng zzngVar = this.zzc.zza;
        zzn zznVar = this.zza;
        Bundle bundle = this.zzb;
        zzngVar.zzl().zzt();
        if (!zzpz.zza() || !zzngVar.zze().zze(zznVar.zza, zzbh.zzcg) || zznVar.zza == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    zzngVar.zzj().zzg().zza("Uri sources and timestamps do not match");
                } else {
                    for (int i = 0; i < intArray.length; i++) {
                        zzan zzanVarZzf = zzngVar.zzf();
                        String str = zznVar.zza;
                        int i2 = intArray[i];
                        long j = longArray[i];
                        Preconditions.checkNotEmpty(str);
                        zzanVarZzf.zzt();
                        zzanVarZzf.zzak();
                        try {
                            int iDelete = zzanVarZzf.e_().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)});
                            zzanVarZzf.zzj().zzp().zza("Pruned " + iDelete + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i2), Long.valueOf(j));
                        } catch (SQLiteException e) {
                            zzanVarZzf.zzj().zzg().zza("Error pruning trigger URIs. appId", zzgb.zza(str), e);
                        }
                    }
                }
            }
        }
        return zzngVar.zzf().zzi(zznVar.zza);
    }

    zzim(zzhs zzhsVar, zzn zznVar, Bundle bundle) {
        this.zza = zznVar;
        this.zzb = bundle;
        this.zzc = zzhsVar;
    }
}
