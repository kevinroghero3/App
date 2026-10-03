package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzpa;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes5.dex */
public final class zzgb extends zzin {
    private char zza;
    private long zzb;
    private String zzc;
    private final zzgd zzd;
    private final zzgd zze;
    private final zzgd zzf;
    private final zzgd zzg;
    private final zzgd zzh;
    private final zzgd zzi;
    private final zzgd zzj;
    private final zzgd zzk;
    private final zzgd zzl;

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzin
    protected final boolean zzo() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
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

    public final zzgd zzc() {
        return this.zzk;
    }

    public final zzgd zzg() {
        return this.zzd;
    }

    public final zzgd zzh() {
        return this.zzf;
    }

    public final zzgd zzm() {
        return this.zze;
    }

    public final zzgd zzn() {
        return this.zzj;
    }

    public final zzgd zzp() {
        return this.zzl;
    }

    public final zzgd zzu() {
        return this.zzg;
    }

    public final zzgd zzv() {
        return this.zzi;
    }

    public final zzgd zzw() {
        return this.zzh;
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

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zznw zzq() {
        return super.zzq();
    }

    protected static Object zza(String str) {
        if (str == null) {
            return null;
        }
        return new zzgc(str);
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strZza = zza(z, obj);
        String strZza2 = zza(z, obj2);
        String strZza3 = zza(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strZza)) {
            sb.append(str2);
            sb.append(strZza);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strZza2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strZza2);
        }
        if (!TextUtils.isEmpty(strZza3)) {
            sb.append(str3);
            sb.append(strZza3);
        }
        return sb.toString();
    }

    private static String zza(boolean z, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) >= 100) {
                String str = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
                String strValueOf = String.valueOf(Math.abs(l.longValue()));
                return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
            }
            return String.valueOf(obj);
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String strZzb = zzb(zzho.class.getCanonicalName());
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzb(className).equals(strZzb)) {
                    sb.append(": ");
                    sb.append(stackTraceElement);
                    break;
                }
            }
            return sb.toString();
        }
        if (obj instanceof zzgc) {
            return ((zzgc) obj).zza;
        }
        return z ? "-" : String.valueOf(obj);
    }

    private static String zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf == -1) {
            return (zzpa.zza() && zzbh.zzcc.zza(null).booleanValue()) ? "" : str;
        }
        return str.substring(0, iLastIndexOf);
    }

    public final String zzx() {
        Pair<String, Long> pairZza;
        if (zzk().zzb == null || (pairZza = zzk().zzb.zza()) == null || pairZza == zzgm.zza) {
            return null;
        }
        return String.valueOf(pairZza.second) + ":" + ((String) pairZza.first);
    }

    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    private final String zzy() {
        String str;
        String strZzw;
        synchronized (this) {
            if (this.zzc == null) {
                if (this.zzu.zzw() != null) {
                    strZzw = this.zzu.zzw();
                } else {
                    strZzw = "FA";
                }
                this.zzc = strZzw;
            }
            Preconditions.checkNotNull(this.zzc);
            str = this.zzc;
        }
        return str;
    }

    zzgb(zzho zzhoVar) {
        super(zzhoVar);
        this.zza = (char) 0;
        this.zzb = -1L;
        this.zzd = new zzgd(this, 6, false, false);
        this.zze = new zzgd(this, 6, true, false);
        this.zzf = new zzgd(this, 6, false, true);
        this.zzg = new zzgd(this, 5, false, false);
        this.zzh = new zzgd(this, 5, true, false);
        this.zzi = new zzgd(this, 5, false, true);
        this.zzj = new zzgd(this, 4, false, false);
        this.zzk = new zzgd(this, 3, false, false);
        this.zzl = new zzgd(this, 2, false, false);
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

    protected final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zza(i)) {
            zza(i, zza(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        Preconditions.checkNotNull(str);
        zzhh zzhhVarZzo = this.zzu.zzo();
        if (zzhhVarZzo == null) {
            zza(6, "Scheduler not set. Not logging error/warn");
            return;
        }
        if (!zzhhVarZzo.zzaf()) {
            zza(6, "Scheduler not initialized. Not logging error/warn");
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i >= 9) {
            i = 8;
        }
        zzhhVarZzo.zzb(new zzga(this, i, str, obj, obj2, obj3));
    }

    protected final void zza(int i, String str) {
        Log.println(i, zzy(), str);
    }

    protected final boolean zza(int i) {
        return Log.isLoggable(zzy(), i);
    }
}
