package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes5.dex */
final class zzhm<V> extends FutureTask<V> implements Comparable<zzhm<V>> {
    final boolean zza;
    private final long zzb;
    private final String zzc;
    private final /* synthetic */ zzhh zzd;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        zzhm zzhmVar = (zzhm) obj;
        boolean z = this.zza;
        if (z != zzhmVar.zza) {
            return z ? -1 : 1;
        }
        long j = this.zzb;
        long j2 = zzhmVar.zzb;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzd.zzj().zzm().zza("Two tasks share the same index. index", Long.valueOf(this.zzb));
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhm(zzhh zzhhVar, Runnable runnable, boolean z, String str) {
        super(com.google.android.gms.internal.measurement.zzcy.zza().zza(runnable), null);
        this.zzd = zzhhVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzhh.zza.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzhhVar.zzj().zzg().zza("Tasks index overflow");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhm(zzhh zzhhVar, Callable<V> callable, boolean z, String str) {
        super(com.google.android.gms.internal.measurement.zzcy.zza().zza(callable));
        this.zzd = zzhhVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzhh.zza.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzhhVar.zzj().zzg().zza("Tasks index overflow");
        }
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzd.zzj().zzg().zza(this.zzc, th);
        if ((th instanceof zzhk) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }
}
