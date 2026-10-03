package com.google.android.gms.internal.common;

import java.util.Iterator;
import org.jspecify.nullness.NullMarked;

/* JADX INFO: loaded from: classes4.dex */
@NullMarked
public abstract class zzaj implements Iterator {
    protected zzaj() {
    }

    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
