package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zziv {
    private static volatile int zzd = 100;
    int zza;
    int zzb;
    zziz zzc;
    private int zze;
    private boolean zzf;

    public static int zza(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long zza(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public abstract double zza() throws IOException;

    public abstract float zzb() throws IOException;

    public abstract int zzb(int i) throws zzkc;

    public abstract int zzc();

    public abstract void zzc(int i) throws zzkc;

    public abstract int zzd() throws IOException;

    public abstract void zzd(int i);

    public abstract int zze() throws IOException;

    public abstract boolean zze(int i) throws IOException;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract long zzk() throws IOException;

    public abstract long zzl() throws IOException;

    abstract long zzm() throws IOException;

    public abstract long zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract zzih zzq() throws IOException;

    public abstract String zzr() throws IOException;

    public abstract String zzs() throws IOException;

    public abstract boolean zzt() throws IOException;

    public abstract boolean zzu() throws IOException;

    static zziv zza(byte[] bArr, int i, int i2, boolean z) {
        zziy zziyVar = new zziy(bArr, i2);
        try {
            zziyVar.zzb(i2);
            return zziyVar;
        } catch (zzkc e) {
            throw new IllegalArgumentException(e);
        }
    }

    private zziv() {
        this.zzb = zzd;
        this.zze = Integer.MAX_VALUE;
        this.zzf = false;
    }
}
