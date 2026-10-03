package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class zzfo<V> {
    private static final Object zza = new Object();
    private final String zzb;
    private final zzfm<V> zzc;
    private final V zzd;
    private final V zze;
    private final Object zzf;
    private volatile V zzg;
    private volatile V zzh;

    public final V zza(V v) {
        V vZza;
        synchronized (this.zzf) {
        }
        if (v != null) {
            return v;
        }
        if (zzfp.zza == null) {
            return this.zzd;
        }
        synchronized (zza) {
            if (zzad.zza()) {
                return this.zzh == null ? this.zzd : this.zzh;
            }
            try {
                for (zzfo zzfoVar : zzbh.zzdh) {
                    if (zzad.zza()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    try {
                        zzfm<V> zzfmVar = zzfoVar.zzc;
                        vZza = zzfmVar != null ? zzfmVar.zza() : null;
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (zza) {
                        zzfoVar.zzh = vZza;
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzfm<V> zzfmVar2 = this.zzc;
            if (zzfmVar2 == null) {
                return this.zzd;
            }
            try {
                return zzfmVar2.zza();
            } catch (IllegalStateException unused3) {
                return this.zzd;
            } catch (SecurityException unused4) {
                return this.zzd;
            }
        }
    }

    public final String zza() {
        return this.zzb;
    }

    private zzfo(String str, V v, V v2, zzfm<V> zzfmVar) {
        this.zzf = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zzb = str;
        this.zzd = v;
        this.zze = v2;
        this.zzc = zzfmVar;
    }
}
