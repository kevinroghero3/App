package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class zzjh {
    static final zzjh zza = new zzjh(true);
    private static volatile boolean zzb = false;
    private static boolean zzc = true;
    private static volatile zzjh zzd;
    private final Map<zza, zzju.zzd<?, ?>> zze;

    static final class zza {
        private final Object zza;
        private final int zzb;

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.zza == zzaVar.zza && this.zzb == zzaVar.zzb;
        }
    }

    public static zzjh zza() {
        zzjh zzjhVar = zzd;
        if (zzjhVar != null) {
            return zzjhVar;
        }
        synchronized (zzjh.class) {
            zzjh zzjhVar2 = zzd;
            if (zzjhVar2 != null) {
                return zzjhVar2;
            }
            zzjh zzjhVarZza = zzjt.zza(zzjh.class);
            zzd = zzjhVarZza;
            return zzjhVarZza;
        }
    }

    public final <ContainingType extends zzlh> zzju.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzju.zzd) this.zze.get(new zza(containingtype, i));
    }

    zzjh() {
        this.zze = new HashMap();
    }

    private zzjh(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
