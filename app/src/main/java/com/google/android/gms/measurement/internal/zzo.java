package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzpz;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class zzo extends BroadcastReceiver {
    private final zzho zza;

    public zzo(zzho zzhoVar) {
        this.zza = zzhoVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            this.zza.zzj().zzu().zza("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            this.zza.zzj().zzu().zza("App receiver called with null action");
            return;
        }
        if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
            final zzho zzhoVar = this.zza;
            if (zzpz.zza() && zzhoVar.zzf().zzf(null, zzbh.zzch)) {
                zzhoVar.zzj().zzp().zza("App receiver notified triggers are available");
                zzhoVar.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzq
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzho zzhoVar2 = zzhoVar;
                        if (!zzhoVar2.zzt().zzw()) {
                            zzhoVar2.zzj().zzu().zza("registerTrigger called but app not eligible");
                            return;
                        }
                        final zzja zzjaVarZzp = zzhoVar2.zzp();
                        Objects.requireNonNull(zzjaVarZzp);
                        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzr
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzjaVarZzp.zzam();
                            }
                        }).start();
                    }
                });
                return;
            }
            return;
        }
        this.zza.zzj().zzu().zza("App receiver called with unknown action");
    }
}
