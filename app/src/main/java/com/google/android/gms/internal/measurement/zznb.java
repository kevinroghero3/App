package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
final class zznb implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzmz zzb;

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }

    zznb(zzmz zzmzVar) {
        this.zzb = zzmzVar;
        this.zza = zzmzVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }
}
