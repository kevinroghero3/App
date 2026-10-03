package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import io.sentry.android.core.SentryLogcatAdapter;

/* JADX INFO: loaded from: classes4.dex */
final class zzdr extends zzds.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Context zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ zzds zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdr(zzds zzdsVar, String str, String str2, Context context, Bundle bundle) {
        super(zzdsVar);
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = bundle;
        this.zzg = zzdsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    public final void zza() {
        String str;
        String str2;
        String str3;
        try {
            if (this.zzg.zzc(this.zzc, this.zzd)) {
                str3 = this.zzd;
                str2 = this.zzc;
                str = this.zzg.zzc;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            Preconditions.checkNotNull(this.zze);
            zzds zzdsVar = this.zzg;
            zzdsVar.zzj = zzdsVar.zza(this.zze, true);
            if (this.zzg.zzj == null) {
                SentryLogcatAdapter.w(this.zzg.zzc, "Failed to connect to measurement client.");
                return;
            }
            int localVersion = DynamiteModule.getLocalVersion(this.zze, ModuleDescriptor.MODULE_ID);
            int remoteVersion = DynamiteModule.getRemoteVersion(this.zze, ModuleDescriptor.MODULE_ID);
            ((zzdd) Preconditions.checkNotNull(this.zzg.zzj)).initialize(ObjectWrapper.wrap(this.zze), new zzdq(88000L, Math.max(localVersion, remoteVersion), remoteVersion < localVersion, str, str2, str3, this.zzf, com.google.android.gms.measurement.internal.zzhi.zza(this.zze)), this.zza);
        } catch (Exception e) {
            this.zzg.zza(e, true, false);
        }
    }
}
