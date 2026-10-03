package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzqw;
import java.util.HashMap;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes5.dex */
public final class zzne extends zznc {
    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    final Uri.Builder zza(String str) throws Throwable {
        String strZzf = zzm().zzf(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(zze().zzd(str, zzbh.zzax));
        if (TextUtils.isEmpty(strZzf)) {
            builder.authority(zze().zzd(str, zzbh.zzay));
        } else {
            builder.authority(strZzf + "." + zze().zzd(str, zzbh.zzay));
        }
        builder.path(zze().zzd(str, zzbh.zzaz));
        return builder;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x011e  */
    public final Pair<zznh, Boolean> zzb(String str) {
        zzf zzfVarZze;
        zznh zznhVar;
        if (zzqw.zza() && zze().zza(zzbh.zzbt)) {
            zzq();
            if (zznw.zzf(str)) {
                zzj().zzp().zza("sgtm feature flag enabled.");
                zzf zzfVarZze2 = zzh().zze(str);
                if (zzfVarZze2 == null) {
                    return Pair.create(new zznh(zzc(str)), Boolean.TRUE);
                }
                String strZzad = zzfVarZze2.zzad();
                com.google.android.gms.internal.measurement.zzfl.zzd zzdVarZzc = zzm().zzc(str);
                if (zzdVarZzc == null || (zzfVarZze = zzh().zze(str)) == null || ((!zzdVarZzc.zzr() || zzdVarZzc.zzh().zza() != 100) && !zzq().zzd(str, zzfVarZze.zzam()) && (TextUtils.isEmpty(strZzad) || strZzad.hashCode() % 100 >= zzdVarZzc.zzh().zza()))) {
                    return Pair.create(new zznh(zzc(str)), Boolean.TRUE);
                }
                if (zzfVarZze2.zzat()) {
                    zzj().zzp().zza("sgtm upload enabled in manifest.");
                    com.google.android.gms.internal.measurement.zzfl.zzd zzdVarZzc2 = zzm().zzc(zzfVarZze2.zzac());
                    if (zzdVarZzc2 == null || !zzdVarZzc2.zzr()) {
                        zznhVar = null;
                    } else {
                        String strZze = zzdVarZzc2.zzh().zze();
                        if (TextUtils.isEmpty(strZze)) {
                            zznhVar = null;
                        } else {
                            String strZzd = zzdVarZzc2.zzh().zzd();
                            zzj().zzp().zza("sgtm configured with upload_url, server_info", strZze, TextUtils.isEmpty(strZzd) ? "Y" : "N");
                            if (TextUtils.isEmpty(strZzd)) {
                                zznhVar = new zznh(strZze);
                            } else {
                                HashMap map = new HashMap();
                                map.put("x-sgtm-server-info", strZzd);
                                if (!TextUtils.isEmpty(zzfVarZze2.zzam())) {
                                    map.put("x-gtm-server-preview", zzfVarZze2.zzam());
                                }
                                zznhVar = new zznh(strZze, map);
                            }
                        }
                    }
                } else {
                    zznhVar = null;
                }
                if (zznhVar != null) {
                    return Pair.create(zznhVar, Boolean.FALSE);
                }
            }
        }
        return Pair.create(new zznh(zzc(str)), Boolean.TRUE);
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zznc
    public final /* bridge */ /* synthetic */ zzs zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zznc
    public final /* bridge */ /* synthetic */ zzan zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zznc
    public final /* bridge */ /* synthetic */ zzgy zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zznc
    public final /* bridge */ /* synthetic */ zzmg zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zznc
    public final /* bridge */ /* synthetic */ zzne zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zznc
    public final /* bridge */ /* synthetic */ zznt g_() {
        return super.g_();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zznw zzq() {
        return super.zzq();
    }

    private final String zzc(String str) throws Throwable {
        String strZzf = zzm().zzf(str);
        if (!TextUtils.isEmpty(strZzf)) {
            Uri uri = Uri.parse(zzbh.zzq.zza(null));
            Uri.Builder builderBuildUpon = uri.buildUpon();
            builderBuildUpon.authority(strZzf + "." + uri.getAuthority());
            return builderBuildUpon.build().toString();
        }
        return zzbh.zzq.zza(null);
    }

    zzne(zzng zzngVar) {
        super(zzngVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }
}
