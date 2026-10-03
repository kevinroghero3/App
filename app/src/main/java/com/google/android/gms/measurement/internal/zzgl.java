package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;

/* JADX INFO: loaded from: classes5.dex */
class zzgl extends BroadcastReceiver {
    private static final String zza = "com.google.android.gms.measurement.internal.zzgl";
    private final zzng zzb;
    private boolean zzc;
    private boolean zzd;

    zzgl(zzng zzngVar) {
        Preconditions.checkNotNull(zzngVar);
        this.zzb = zzngVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.zzb.zzs();
        String action = intent.getAction();
        this.zzb.zzj().zzp().zza("NetworkBroadcastReceiver received action", action);
        if (BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION.equals(action)) {
            boolean zZzu = this.zzb.zzh().zzu();
            if (this.zzd != zZzu) {
                this.zzd = zZzu;
                this.zzb.zzl().zzb(new zzgk(this, zZzu));
                return;
            }
            return;
        }
        this.zzb.zzj().zzu().zza("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void zza() {
        this.zzb.zzs();
        this.zzb.zzl().zzt();
        if (this.zzc) {
            return;
        }
        this.zzb.zza().registerReceiver(this, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
        this.zzd = this.zzb.zzh().zzu();
        this.zzb.zzj().zzp().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
        this.zzc = true;
    }

    public final void zzb() {
        this.zzb.zzs();
        this.zzb.zzl().zzt();
        this.zzb.zzl().zzt();
        if (this.zzc) {
            this.zzb.zzj().zzp().zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zza().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzb.zzj().zzg().zza("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
