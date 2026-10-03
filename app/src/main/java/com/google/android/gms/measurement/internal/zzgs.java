package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
public final class zzgs {
    private final String zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;
    private final /* synthetic */ zzgm zze;

    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzg().getString(this.zza, null);
        }
        return this.zzd;
    }

    public zzgs(zzgm zzgmVar, String str, String str2) {
        this.zze = zzgmVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = null;
    }

    public final void zza(String str) {
        SharedPreferences.Editor editorEdit = this.zze.zzg().edit();
        editorEdit.putString(this.zza, str);
        editorEdit.apply();
        this.zzd = str;
    }
}
