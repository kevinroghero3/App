package com.google.android.play.core.review.internal;

import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
final class zzp extends zzj {
    final /* synthetic */ IBinder zza;
    final /* synthetic */ zzs zzb;

    zzp(zzs zzsVar, IBinder iBinder) {
        this.zzb = zzsVar;
        this.zza = iBinder;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void zza() {
        this.zzb.zza.zzn = zze.zzb(this.zza);
        zzt.zzn(this.zzb.zza);
        this.zzb.zza.zzh = false;
        Iterator it2 = this.zzb.zza.zze.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
        this.zzb.zza.zze.clear();
    }
}
