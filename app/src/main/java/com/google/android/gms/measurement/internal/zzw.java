package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class zzw {
    private com.google.android.gms.internal.measurement.zzfs.zze zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzs zzd;

    final com.google.android.gms.internal.measurement.zzfs.zze zza(String str, com.google.android.gms.internal.measurement.zzfs.zze zzeVar) {
        Object obj;
        String strZzg = zzeVar.zzg();
        List<com.google.android.gms.internal.measurement.zzfs.zzg> listZzh = zzeVar.zzh();
        this.zzd.g_();
        Long l = (Long) zznt.zzb(zzeVar, "_eid");
        boolean z = l != null;
        if (z && strZzg.equals("_ep")) {
            Preconditions.checkNotNull(l);
            this.zzd.g_();
            strZzg = (String) zznt.zzb(zzeVar, "_en");
            if (TextUtils.isEmpty(strZzg)) {
                this.zzd.zzj().zzm().zza("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair<com.google.android.gms.internal.measurement.zzfs.zze, Long> pairZza = this.zzd.zzh().zza(str, l);
                if (pairZza == null || (obj = pairZza.first) == null) {
                    this.zzd.zzj().zzm().zza("Extra parameter without existing main event. eventName, eventId", strZzg, l);
                    return null;
                }
                this.zza = (com.google.android.gms.internal.measurement.zzfs.zze) obj;
                this.zzc = ((Long) pairZza.second).longValue();
                this.zzd.g_();
                this.zzb = (Long) zznt.zzb(this.zza, "_eid");
            }
            long j = this.zzc - 1;
            this.zzc = j;
            if (j <= 0) {
                zzan zzanVarZzh = this.zzd.zzh();
                zzanVarZzh.zzt();
                zzanVarZzh.zzj().zzp().zza("Clearing complex main event info. appId", str);
                try {
                    zzanVarZzh.e_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    zzanVarZzh.zzj().zzg().zza("Error clearing complex main event", e);
                }
            } else {
                this.zzd.zzh().zza(str, l, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.measurement.zzfs.zzg zzgVar : this.zza.zzh()) {
                this.zzd.g_();
                if (zznt.zza(zzeVar, zzgVar.zzg()) == null) {
                    arrayList.add(zzgVar);
                }
            }
            if (arrayList.isEmpty()) {
                this.zzd.zzj().zzm().zza("No unique parameters in main event. eventName", strZzg);
            } else {
                arrayList.addAll(listZzh);
                listZzh = arrayList;
            }
        } else if (z) {
            this.zzb = l;
            this.zza = zzeVar;
            this.zzd.g_();
            Object objZzb = zznt.zzb(zzeVar, "_epc");
            long jLongValue = ((Long) (objZzb != null ? objZzb : 0L)).longValue();
            this.zzc = jLongValue;
            if (jLongValue <= 0) {
                this.zzd.zzj().zzm().zza("Complex event with zero extra param count. eventName", strZzg);
            } else {
                this.zzd.zzh().zza(str, (Long) Preconditions.checkNotNull(l), this.zzc, zzeVar);
            }
        }
        return (com.google.android.gms.internal.measurement.zzfs.zze) ((com.google.android.gms.internal.measurement.zzju) zzeVar.zzca().zza(strZzg).zzd().zza(listZzh).zzah());
    }

    private zzw(zzs zzsVar) {
        this.zzd = zzsVar;
    }
}
