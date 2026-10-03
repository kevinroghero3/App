package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzhi<T> {

    @Nullable
    private static volatile zzhp zzb = null;
    private static volatile boolean zzc = false;
    private final zzhq zzg;
    private final String zzh;
    private final T zzi;
    private volatile int zzj;
    private volatile T zzk;
    private final boolean zzl;
    private static final Object zza = new Object();
    private static final AtomicReference<Collection<zzhi<?>>> zzd = new AtomicReference<>();
    private static zzht zze = new zzht(new zzhw() { // from class: com.google.android.gms.internal.measurement.zzhj
        @Override // com.google.android.gms.internal.measurement.zzhw
        public final boolean zza() {
            return zzhi.zzd();
        }
    });
    private static final AtomicInteger zzf = new AtomicInteger();

    static /* synthetic */ boolean zzd() {
        return true;
    }

    abstract T zza(Object obj);

    static /* synthetic */ zzhi zza(zzhq zzhqVar, String str, Boolean bool, boolean z) {
        return new zzhl(zzhqVar, str, bool, true);
    }

    static /* synthetic */ zzhi zza(zzhq zzhqVar, String str, Double d, boolean z) {
        return new zzho(zzhqVar, str, d, true);
    }

    static /* synthetic */ zzhi zza(zzhq zzhqVar, String str, Long l, boolean z) {
        return new zzhm(zzhqVar, str, l, true);
    }

    static /* synthetic */ zzhi zza(zzhq zzhqVar, String str, String str2, boolean z) {
        return new zzhn(zzhqVar, str, str2, true);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0079 A[Catch: all -> 0x0090, TryCatch #0 {, blocks: (B:8:0x001c, B:10:0x0020, B:12:0x0029, B:14:0x0039, B:18:0x0052, B:20:0x005d, B:33:0x007b, B:36:0x0083, B:37:0x0086, B:38:0x008a, B:23:0x0064, B:32:0x0079, B:26:0x006b, B:29:0x0072, B:39:0x008e), top: B:46:0x001c }] */
    public final T zza() {
        T tZzb;
        if (!this.zzl) {
            Preconditions.checkState(zze.zza(this.zzh), "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error.");
        }
        int i = zzf.get();
        if (this.zzj < i) {
            synchronized (this) {
                if (this.zzj < i) {
                    zzhp zzhpVar = zzb;
                    Optional<zzhc> optionalAbsent = Optional.absent();
                    String strZza = null;
                    if (zzhpVar != null) {
                        optionalAbsent = zzhpVar.zzb().get();
                        if (optionalAbsent.isPresent()) {
                            zzhc zzhcVar = optionalAbsent.get();
                            zzhq zzhqVar = this.zzg;
                            strZza = zzhcVar.zza(zzhqVar.zzb, zzhqVar.zza, zzhqVar.zzd, this.zzh);
                        }
                    }
                    Preconditions.checkState(zzhpVar != null, "Must call PhenotypeFlagInitializer.maybeInit() first");
                    if (this.zzg.zzf) {
                        tZzb = zza(zzhpVar);
                        if (tZzb == null && (tZzb = zzb(zzhpVar)) == null) {
                            tZzb = this.zzi;
                        }
                    } else {
                        tZzb = zzb(zzhpVar);
                        if (tZzb == null && (tZzb = zza(zzhpVar)) == null) {
                            tZzb = this.zzi;
                        }
                    }
                    if (optionalAbsent.isPresent()) {
                        tZzb = strZza == null ? this.zzi : zza((Object) strZza);
                    }
                    this.zzk = tZzb;
                    this.zzj = i;
                }
            }
        }
        return this.zzk;
    }

    @Nullable
    private final T zza(zzhp zzhpVar) {
        Function<Context, Boolean> function;
        zzhq zzhqVar = this.zzg;
        if (!zzhqVar.zze && ((function = zzhqVar.zzh) == null || function.apply(zzhpVar.zza()).booleanValue())) {
            zzhb zzhbVarZza = zzhb.zza(zzhpVar.zza());
            zzhq zzhqVar2 = this.zzg;
            Object objZza = zzhbVarZza.zza(zzhqVar2.zze ? null : zza(zzhqVar2.zzc));
            if (objZza != null) {
                return zza(objZza);
            }
        }
        return null;
    }

    @Nullable
    private final T zzb(zzhp zzhpVar) {
        zzgw zzgwVarZza;
        Object objZza;
        if (this.zzg.zzb != null) {
            if (!zzhg.zza(zzhpVar.zza(), this.zzg.zzb)) {
                zzgwVarZza = null;
            } else if (this.zzg.zzg) {
                zzgwVarZza = zzgt.zza(zzhpVar.zza().getContentResolver(), zzhf.zza(zzhf.zza(zzhpVar.zza(), this.zzg.zzb.getLastPathSegment())), new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhh
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzhi.zzc();
                    }
                });
            } else {
                zzgwVarZza = zzgt.zza(zzhpVar.zza().getContentResolver(), this.zzg.zzb, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhh
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzhi.zzc();
                    }
                });
            }
        } else {
            zzgwVarZza = zzhr.zza(zzhpVar.zza(), this.zzg.zza, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhh
                @Override // java.lang.Runnable
                public final void run() {
                    zzhi.zzc();
                }
            });
        }
        if (zzgwVarZza == null || (objZza = zzgwVarZza.zza(zzb())) == null) {
            return null;
        }
        return zza(objZza);
    }

    public final String zzb() {
        return zza(this.zzg.zzd);
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzh;
        }
        return str + this.zzh;
    }

    private zzhi(zzhq zzhqVar, String str, T t, boolean z) {
        this.zzj = -1;
        String str2 = zzhqVar.zza;
        if (str2 == null && zzhqVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (str2 != null && zzhqVar.zzb != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.zzg = zzhqVar;
        this.zzh = str;
        this.zzi = t;
        this.zzl = z;
    }

    public static void zzc() {
        zzf.incrementAndGet();
    }

    public static void zzb(final Context context) {
        if (zzb != null || context == null) {
            return;
        }
        Object obj = zza;
        synchronized (obj) {
            if (zzb == null) {
                synchronized (obj) {
                    zzhp zzhpVar = zzb;
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    if (zzhpVar == null || zzhpVar.zza() != context) {
                        if (zzhpVar != null) {
                            zzgt.zzc();
                            zzhr.zza();
                            zzhb.zza();
                        }
                        zzb = new zzgq(context, Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzhk
                            @Override // com.google.common.base.Supplier
                            public final Object get() {
                                return zzhe.zza.zza(context);
                            }
                        }));
                        zzf.incrementAndGet();
                    }
                }
            }
        }
    }
}
