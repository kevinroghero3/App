package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes5.dex */
public final class zzlf extends zzg {
    private final zzma zza;
    private zzfq zzb;
    private volatile Boolean zzc;
    private final zzav zzd;
    private final zzmz zze;
    private final List<Runnable> zzf;
    private final zzav zzg;

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzz() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    private final zzn zzc(boolean z) {
        return zzg().zza(z ? zzj().zzx() : null);
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

    protected final zzal zzaa() {
        zzt();
        zzu();
        zzfq zzfqVar = this.zzb;
        if (zzfqVar == null) {
            zzad();
            zzj().zzc().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzn zznVarZzc = zzc(false);
        Preconditions.checkNotNull(zznVarZzc);
        try {
            zzal zzalVarZza = zzfqVar.zza(zznVarZzc);
            zzaq();
            return zzalVarZza;
        } catch (RemoteException e) {
            zzj().zzg().zza("Failed to get consents; remote exception", e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfv zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfu zzh() {
        return super.zzh();
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

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzja zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzkw zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzlf zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzmp zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zznw zzq() {
        return super.zzq();
    }

    final Boolean zzab() {
        return this.zzc;
    }

    static /* synthetic */ void zzd(zzlf zzlfVar) {
        zzlfVar.zzt();
        if (zzlfVar.zzak()) {
            zzlfVar.zzj().zzp().zza("Inactivity, disconnecting from the service");
            zzlfVar.zzae();
        }
    }

    static /* synthetic */ void zza(zzlf zzlfVar, ComponentName componentName) {
        zzlfVar.zzt();
        if (zzlfVar.zzb != null) {
            zzlfVar.zzb = null;
            zzlfVar.zzj().zzp().zza("Disconnected from device MeasurementService", componentName);
            zzlfVar.zzt();
            zzlfVar.zzad();
        }
    }

    protected zzlf(zzho zzhoVar) {
        super(zzhoVar);
        this.zzf = new ArrayList();
        this.zze = new zzmz(zzhoVar.zzb());
        this.zza = new zzma(this);
        this.zzd = new zzlg(this, zzhoVar);
        this.zzg = new zzlt(this, zzhoVar);
    }

    protected final void zzac() {
        zzt();
        zzu();
        zzn zznVarZzc = zzc(true);
        zzh().zzab();
        zza(new zzlo(this, zznVarZzc));
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    final void zzad() {
        zzt();
        zzu();
        if (zzak()) {
            return;
        }
        if (zzao()) {
            this.zza.zza();
            return;
        }
        if (zze().zzx()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = zza().getPackageManager().queryIntentServices(new Intent().setClassName(zza(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            intent.setComponent(new ComponentName(zza(), "com.google.android.gms.measurement.AppMeasurementService"));
            this.zza.zza(intent);
            return;
        }
        zzj().zzg().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    }

    public final void zzae() {
        zzt();
        zzu();
        this.zza.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(zza(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzap() {
        zzt();
        zzj().zzp().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        Iterator<Runnable> it2 = this.zzf.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().run();
            } catch (RuntimeException e) {
                zzj().zzg().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zza();
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        zzt();
        zzu();
        zza(new zzlp(this, zzc(false), zzdiVar));
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzt();
        zzu();
        zza(new zzlm(this, atomicReference, zzc(false)));
    }

    protected final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, String str, String str2) {
        zzt();
        zzu();
        zza(new zzly(this, str, str2, zzc(false), zzdiVar));
    }

    protected final void zza(AtomicReference<List<zzac>> atomicReference, String str, String str2, String str3) {
        zzt();
        zzu();
        zza(new zzlz(this, atomicReference, str, str2, str3, zzc(false)));
    }

    protected final void zza(AtomicReference<List<zzmy>> atomicReference, Bundle bundle) {
        zzt();
        zzu();
        zza(new zzll(this, atomicReference, zzc(false), bundle));
    }

    protected final void zza(AtomicReference<List<zznv>> atomicReference, boolean z) {
        zzt();
        zzu();
        zza(new zzli(this, atomicReference, zzc(false), z));
    }

    protected final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, String str, String str2, boolean z) {
        zzt();
        zzu();
        zza(new zzlj(this, str, str2, zzc(false), z, zzdiVar));
    }

    protected final void zza(AtomicReference<List<zznv>> atomicReference, String str, String str2, String str3, boolean z) {
        zzt();
        zzu();
        zza(new zzmb(this, atomicReference, str, str2, str3, zzc(false), z));
    }

    final /* synthetic */ void zzaf() {
        zzfq zzfqVar = this.zzb;
        if (zzfqVar == null) {
            zzj().zzg().zza("Failed to send Dma consent settings to service");
            return;
        }
        try {
            zzn zznVarZzc = zzc(false);
            Preconditions.checkNotNull(zznVarZzc);
            zzfqVar.zzf(zznVarZzc);
            zzaq();
        } catch (RemoteException e) {
            zzj().zzg().zza("Failed to send Dma consent settings to the service", e);
        }
    }

    final /* synthetic */ void zzag() {
        zzfq zzfqVar = this.zzb;
        if (zzfqVar == null) {
            zzj().zzg().zza("Failed to send storage consent settings to service");
            return;
        }
        try {
            zzn zznVarZzc = zzc(false);
            Preconditions.checkNotNull(zznVarZzc);
            zzfqVar.zzh(zznVarZzc);
            zzaq();
        } catch (RemoteException e) {
            zzj().zzg().zza("Failed to send storage consent settings to the service", e);
        }
    }

    protected final void zza(zzbf zzbfVar, String str) {
        Preconditions.checkNotNull(zzbfVar);
        zzt();
        zzu();
        zza(new zzlx(this, true, zzc(true), zzh().zza(zzbfVar), zzbfVar, str));
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, zzbf zzbfVar, String str) {
        zzt();
        zzu();
        if (zzq().zza(12451000) != 0) {
            zzj().zzu().zza("Not bundling data. Service unavailable or out of date");
            zzq().zza(zzdiVar, new byte[0]);
        } else {
            zza(new zzls(this, zzbfVar, str, zzdiVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaq() {
        zzt();
        this.zze.zzb();
        this.zzd.zza(zzbh.zzaj.zza(null).longValue());
    }

    protected final void zzah() {
        zzt();
        zzu();
        zzn zznVarZzc = zzc(false);
        zzh().zzaa();
        zza(new zzln(this, zznVarZzc));
    }

    private final void zza(Runnable runnable) throws IllegalStateException {
        zzt();
        if (zzak()) {
            runnable.run();
        } else {
            if (this.zzf.size() >= 1000) {
                zzj().zzg().zza("Discarding data. Max runnable queue size reached");
                return;
            }
            this.zzf.add(runnable);
            this.zzg.zza(60000L);
            zzad();
        }
    }

    final void zza(zzfq zzfqVar, AbstractSafeParcelable abstractSafeParcelable, zzn zznVar) {
        int size;
        zzt();
        zzu();
        int i = 100;
        int i2 = 0;
        while (i2 < 1001 && i == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> listZza = zzh().zza(100);
            if (listZza != null) {
                arrayList.addAll(listZza);
                size = listZza.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj = arrayList.get(i3);
                i3++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzbf) {
                    try {
                        zzfqVar.zza((zzbf) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e) {
                        zzj().zzg().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zznv) {
                    try {
                        zzfqVar.zza((zznv) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e2) {
                        zzj().zzg().zza("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        zzfqVar.zza((zzac) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e3) {
                        zzj().zzg().zza("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    zzj().zzg().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i = size;
        }
    }

    protected final void zza(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        zzt();
        zzu();
        zza(new zzlw(this, true, zzc(true), zzh().zza(zzacVar), new zzac(zzacVar), zzacVar));
    }

    protected final void zza(boolean z) {
        zzt();
        zzu();
        if ((!zzod.zza() || !zze().zza(zzbh.zzdf)) && z) {
            zzh().zzaa();
        }
        if (zzam()) {
            zza(new zzlu(this, zzc(false)));
        }
    }

    protected final void zza(zzkx zzkxVar) {
        zzt();
        zzu();
        zza(new zzlr(this, zzkxVar));
    }

    public final void zza(Bundle bundle) {
        zzt();
        zzu();
        zza(new zzlq(this, zzc(false), bundle));
    }

    protected final void zzai() {
        zzt();
        zzu();
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlh
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaf();
            }
        });
    }

    protected final void zzaj() {
        zzt();
        zzu();
        zza(new zzlv(this, zzc(true)));
    }

    protected final void zza(zzfq zzfqVar) {
        zzt();
        Preconditions.checkNotNull(zzfqVar);
        this.zzb = zzfqVar;
        zzaq();
        zzap();
    }

    protected final void zzb(boolean z) {
        zzt();
        zzu();
        if ((!zzod.zza() || !zze().zza(zzbh.zzdf)) && z) {
            zzh().zzaa();
        }
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzle
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzag();
            }
        });
    }

    protected final void zza(zznv zznvVar) {
        zzt();
        zzu();
        zza(new zzlk(this, zzc(true), zzh().zza(zznvVar), zznvVar));
    }

    public final boolean zzak() {
        zzt();
        zzu();
        return this.zzb != null;
    }

    final boolean zzal() {
        zzt();
        zzu();
        return !zzao() || zzq().zzg() >= 200900;
    }

    final boolean zzam() {
        zzt();
        zzu();
        return !zzao() || zzq().zzg() >= zzbh.zzbn.zza(null).intValue();
    }

    final boolean zzan() {
        zzt();
        zzu();
        return !zzao() || zzq().zzg() >= 241200;
    }

    final boolean zzao() {
        boolean z;
        zzt();
        zzu();
        if (this.zzc == null) {
            zzt();
            zzu();
            Boolean boolZzp = zzk().zzp();
            boolean z2 = true;
            if (boolZzp == null || !boolZzp.booleanValue()) {
                if (zzg().zzaa() == 1) {
                    z = true;
                } else {
                    zzj().zzp().zza("Checking service availability");
                    int iZza = zzq().zza(12451000);
                    if (iZza != 0) {
                        z = false;
                        if (iZza != 1) {
                            if (iZza == 2) {
                                zzj().zzc().zza("Service container out of date");
                                if (zzq().zzg() >= 17443) {
                                    if (boolZzp != null) {
                                    }
                                }
                            } else if (iZza == 3) {
                                zzj().zzu().zza("Service disabled");
                            } else if (iZza == 9) {
                                zzj().zzu().zza("Service invalid");
                            } else if (iZza == 18) {
                                zzj().zzu().zza("Service updating");
                            } else {
                                zzj().zzu().zza("Unexpected service status", Integer.valueOf(iZza));
                            }
                            z2 = false;
                        } else {
                            zzj().zzp().zza("Service missing");
                        }
                        z = true;
                        z2 = false;
                    } else {
                        zzj().zzp().zza("Service available");
                    }
                    z = true;
                }
                if (!z2 && zze().zzx()) {
                    zzj().zzg().zza("No way to upload. Consider using the full version of Analytics");
                } else if (z) {
                    zzk().zza(z2);
                }
            }
            this.zzc = Boolean.valueOf(z2);
        }
        return this.zzc.booleanValue();
    }
}
