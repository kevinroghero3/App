package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzim implements zzin {
    @Override // java.util.Iterator
    public /* synthetic */ Byte next() {
        return Byte.valueOf(zza());
    }

    zzim() {
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
