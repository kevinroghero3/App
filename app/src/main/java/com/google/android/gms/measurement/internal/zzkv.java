package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzql;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class zzkv extends zznf {
    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    @Override // com.google.android.gms.measurement.internal.zznf
    protected final boolean zzc() {
        return false;
    }

    public zzkv(zzng zzngVar) {
        super(zzngVar);
    }

    public final byte[] zza(@NonNull zzbf zzbfVar, @Size(min = 1) String str) {
        zznx next;
        long j;
        zzbb zzbbVarZza;
        zzt();
        this.zzu.zzy();
        Preconditions.checkNotNull(zzbfVar);
        Preconditions.checkNotEmpty(str);
        if (!zze().zze(str, zzbh.zzbe)) {
            zzj().zzc().zza("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzbfVar.zza) && !"_iapx".equals(zzbfVar.zza)) {
            zzj().zzc().zza("Generating a payload for this event is not available. package_name, event_name", str, zzbfVar.zza);
            return null;
        }
        com.google.android.gms.internal.measurement.zzfs.zzi.zza zzaVarZzb = com.google.android.gms.internal.measurement.zzfs.zzi.zzb();
        zzh().zzp();
        try {
            zzf zzfVarZze = zzh().zze(str);
            if (zzfVarZze == null) {
                zzj().zzc().zza("Log and bundle not available. package_name", str);
                byte[] bArr = new byte[0];
                zzh().zzu();
                return bArr;
            }
            if (!zzfVarZze.zzar()) {
                zzj().zzc().zza("Log and bundle disabled. package_name", str);
                byte[] bArr2 = new byte[0];
                zzh().zzu();
                return bArr2;
            }
            com.google.android.gms.internal.measurement.zzfs.zzj.zza zzaVarZzp = com.google.android.gms.internal.measurement.zzfs.zzj.zzv().zzh(1).zzp("android");
            if (!TextUtils.isEmpty(zzfVarZze.zzac())) {
                zzaVarZzp.zzb(zzfVarZze.zzac());
            }
            if (!TextUtils.isEmpty(zzfVarZze.zzae())) {
                zzaVarZzp.zzd((String) Preconditions.checkNotNull(zzfVarZze.zzae()));
            }
            if (!TextUtils.isEmpty(zzfVarZze.zzaf())) {
                zzaVarZzp.zze((String) Preconditions.checkNotNull(zzfVarZze.zzaf()));
            }
            if (zzfVarZze.zze() != -2147483648L) {
                zzaVarZzp.zze((int) zzfVarZze.zze());
            }
            zzaVarZzp.zzf(zzfVarZze.zzq()).zzd(zzfVarZze.zzo());
            String strZzah = zzfVarZze.zzah();
            String strZzaa = zzfVarZze.zzaa();
            if (!TextUtils.isEmpty(strZzah)) {
                zzaVarZzp.zzm(strZzah);
            } else if (!TextUtils.isEmpty(strZzaa)) {
                zzaVarZzp.zza(strZzaa);
            }
            zzaVarZzp.zzj(zzfVarZze.zzw());
            zzis zzisVarZzb = this.zzf.zzb(str);
            zzaVarZzp.zzc(zzfVarZze.zzn());
            if (this.zzu.zzac() && zze().zzk(zzaVarZzp.zzt()) && zzisVarZzb.zzi() && !TextUtils.isEmpty(null)) {
                zzaVarZzp.zzj((String) null);
            }
            zzaVarZzp.zzg(zzisVarZzb.zzg());
            if (zzisVarZzb.zzi() && zzfVarZze.zzaq()) {
                Pair<String, Boolean> pairZza = zzn().zza(zzfVarZze.zzac(), zzisVarZzb);
                if (zzfVarZze.zzaq() && pairZza != null && !TextUtils.isEmpty((CharSequence) pairZza.first)) {
                    try {
                        zzaVarZzp.zzq(zza((String) pairZza.first, Long.toString(zzbfVar.zzd)));
                        Object obj = pairZza.second;
                        if (obj != null) {
                            zzaVarZzp.zzc(((Boolean) obj).booleanValue());
                        }
                    } catch (SecurityException e) {
                        zzj().zzc().zza("Resettable device id encryption failed", e.getMessage());
                        byte[] bArr3 = new byte[0];
                        zzh().zzu();
                        return bArr3;
                    }
                }
            }
            zzf().zzac();
            com.google.android.gms.internal.measurement.zzfs.zzj.zza zzaVarZzi = zzaVarZzp.zzi(Build.MODEL);
            zzf().zzac();
            zzaVarZzi.zzo(Build.VERSION.RELEASE).zzj((int) zzf().zzg()).zzs(zzf().zzh());
            try {
                if (zzisVarZzb.zzj() && zzfVarZze.zzad() != null) {
                    zzaVarZzp.zzc(zza((String) Preconditions.checkNotNull(zzfVarZze.zzad()), Long.toString(zzbfVar.zzd)));
                }
                if (!TextUtils.isEmpty(zzfVarZze.zzag())) {
                    zzaVarZzp.zzl((String) Preconditions.checkNotNull(zzfVarZze.zzag()));
                }
                String strZzac = zzfVarZze.zzac();
                List<zznx> listZzj = zzh().zzj(strZzac);
                Iterator<zznx> it2 = listZzj.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!"_lte".equals(next.zzc));
                if (next == null || next.zze == null) {
                    zznx zznxVar = new zznx(strZzac, "auto", "_lte", zzb().currentTimeMillis(), 0L);
                    listZzj.add(zznxVar);
                    zzh().zza(zznxVar);
                }
                com.google.android.gms.internal.measurement.zzfs.zzn[] zznVarArr = new com.google.android.gms.internal.measurement.zzfs.zzn[listZzj.size()];
                for (int i = 0; i < listZzj.size(); i++) {
                    com.google.android.gms.internal.measurement.zzfs.zzn.zza zzaVarZzb2 = com.google.android.gms.internal.measurement.zzfs.zzn.zze().zza(listZzj.get(i).zzc).zzb(listZzj.get(i).zzd);
                    g_().zza(zzaVarZzb2, listZzj.get(i).zze);
                    zznVarArr[i] = (com.google.android.gms.internal.measurement.zzfs.zzn) ((com.google.android.gms.internal.measurement.zzju) zzaVarZzb2.zzah());
                }
                zzaVarZzp.zze(Arrays.asList(zznVarArr));
                g_().zza(zzaVarZzp);
                this.zzf.zza(zzfVarZze, zzaVarZzp);
                zzgf zzgfVarZza = zzgf.zza(zzbfVar);
                zzq().zza(zzgfVarZza.zzb, zzh().zzd(str));
                zzq().zza(zzgfVarZza, zze().zzb(str));
                Bundle bundle = zzgfVarZza.zzb;
                bundle.putLong("_c", 1L);
                zzj().zzc().zza("Marking in-app purchase as real-time");
                bundle.putLong(NotificationMessage.NOTIF_KEY_REQUEST_ID, 1L);
                bundle.putString("_o", zzbfVar.zzc);
                if (zzq().zzd(zzaVarZzp.zzt(), zzfVarZze.zzam())) {
                    zzq().zza(bundle, "_dbg", (Object) 1L);
                    zzq().zza(bundle, NotificationMessage.NOTIF_KEY_REQUEST_ID, (Object) 1L);
                }
                zzbb zzbbVarZzd = zzh().zzd(str, zzbfVar.zza);
                if (zzbbVarZzd == null) {
                    zzbbVarZza = new zzbb(str, zzbfVar.zza, 0L, 0L, zzbfVar.zzd, 0L, null, null, null, null);
                    j = 0;
                } else {
                    j = zzbbVarZzd.zzf;
                    zzbbVarZza = zzbbVarZzd.zza(zzbfVar.zzd);
                }
                zzh().zza(zzbbVarZza);
                zzay zzayVar = new zzay(this.zzu, zzbfVar.zzc, str, zzbfVar.zza, zzbfVar.zzd, j, bundle);
                com.google.android.gms.internal.measurement.zzfs.zze.zza zzaVarZza = com.google.android.gms.internal.measurement.zzfs.zze.zze().zzb(zzayVar.zzc).zza(zzayVar.zzb).zza(zzayVar.zzd);
                for (String str2 : zzayVar.zze) {
                    com.google.android.gms.internal.measurement.zzfs.zzg.zza zzaVarZza2 = com.google.android.gms.internal.measurement.zzfs.zzg.zze().zza(str2);
                    Object objZzc = zzayVar.zze.zzc(str2);
                    if (objZzc != null) {
                        g_().zza(zzaVarZza2, objZzc);
                        zzaVarZza.zza(zzaVarZza2);
                    }
                }
                zzaVarZzp.zza(zzaVarZza).zza(com.google.android.gms.internal.measurement.zzfs.zzk.zza().zza(com.google.android.gms.internal.measurement.zzfs.zzf.zza().zza(zzbbVarZza.zzc).zza(zzbfVar.zza)));
                zzaVarZzp.zza(zzg().zza(zzfVarZze.zzac(), Collections.emptyList(), zzaVarZzp.zzab(), Long.valueOf(zzaVarZza.zzc()), Long.valueOf(zzaVarZza.zzc())));
                if (zzaVarZza.zzg()) {
                    zzaVarZzp.zzi(zzaVarZza.zzc()).zze(zzaVarZza.zzc());
                }
                long jZzs = zzfVarZze.zzs();
                if (jZzs != 0) {
                    zzaVarZzp.zzg(jZzs);
                }
                long jZzu = zzfVarZze.zzu();
                if (jZzu != 0) {
                    zzaVarZzp.zzh(jZzu);
                } else if (jZzs != 0) {
                    zzaVarZzp.zzh(jZzs);
                }
                String strZzal = zzfVarZze.zzal();
                if (zzql.zza() && zze().zze(str, zzbh.zzbs) && strZzal != null) {
                    zzaVarZzp.zzr(strZzal);
                }
                zzfVarZze.zzap();
                zzaVarZzp.zzf((int) zzfVarZze.zzt()).zzl(88000L).zzk(zzb().currentTimeMillis()).zzd(true);
                if (zze().zza(zzbh.zzbx)) {
                    this.zzf.zza(zzaVarZzp.zzt(), zzaVarZzp);
                }
                zzaVarZzb.zza(zzaVarZzp);
                zzfVarZze.zzr(zzaVarZzp.zzf());
                zzfVarZze.zzp(zzaVarZzp.zze());
                zzh().zza(zzfVarZze);
                zzh().zzw();
                zzh().zzu();
                try {
                    return g_().zzb(((com.google.android.gms.internal.measurement.zzfs.zzi) ((com.google.android.gms.internal.measurement.zzju) zzaVarZzb.zzah())).zzbx());
                } catch (IOException e2) {
                    zzj().zzg().zza("Data loss. Failed to bundle and serialize. appId", zzgb.zza(str), e2);
                    return 0;
                }
            } catch (SecurityException e3) {
                zzj().zzc().zza("app instance id encryption failed", e3.getMessage());
                byte[] bArr4 = new byte[0];
                zzh().zzu();
                return bArr4;
            }
        } catch (Throwable th) {
            zzh().zzu();
            throw th;
        }
    }
}
