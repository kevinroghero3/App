package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
final class zzae implements Iterator<zzaq> {
    private final /* synthetic */ Iterator zza;
    private final /* synthetic */ Iterator zzb;

    @Override // java.util.Iterator
    public final /* synthetic */ zzaq next() {
        if (this.zza.hasNext()) {
            return new zzas(((Integer) this.zza.next()).toString());
        }
        if (this.zzb.hasNext()) {
            return new zzas((String) this.zzb.next());
        }
        throw new NoSuchElementException();
    }

    zzae(zzaf zzafVar, Iterator it2, Iterator it3) {
        this.zza = it2;
        this.zzb = it3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zza.hasNext()) {
            return true;
        }
        return this.zzb.hasNext();
    }
}
