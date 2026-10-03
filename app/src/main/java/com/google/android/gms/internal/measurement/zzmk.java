package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzmk implements Iterator<Map.Entry<Object, Object>> {
    private int zza;
    private boolean zzb;
    private Iterator<Map.Entry<Object, Object>> zzc;
    private final /* synthetic */ zzma zzd;

    @Override // java.util.Iterator
    public final /* synthetic */ Map.Entry<Object, Object> next() {
        this.zzb = true;
        int i = this.zza + 1;
        this.zza = i;
        return i < this.zzd.zzb.size() ? (Map.Entry) this.zzd.zzb.get(this.zza) : zza().next();
    }

    private final Iterator<Map.Entry<Object, Object>> zza() {
        if (this.zzc == null) {
            this.zzc = this.zzd.zzc.entrySet().iterator();
        }
        return this.zzc;
    }

    private zzmk(zzma zzmaVar) {
        this.zzd = zzmaVar;
        this.zza = -1;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzb) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzb = false;
        this.zzd.zzg();
        if (this.zza < this.zzd.zzb.size()) {
            zzma zzmaVar = this.zzd;
            int i = this.zza;
            this.zza = i - 1;
            zzmaVar.zzc(i);
            return;
        }
        zza().remove();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza + 1 < this.zzd.zzb.size() || (!this.zzd.zzc.isEmpty() && zza().hasNext());
    }
}
