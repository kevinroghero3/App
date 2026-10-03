package com.google.android.gms.auth.api.signin.internal;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class HashAccumulator {
    private int zaa = 1;

    public HashAccumulator addObject(@Nullable Object obj) {
        this.zaa = (this.zaa * 31) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int hash() {
        return this.zaa;
    }

    public final HashAccumulator zaa(boolean z) {
        this.zaa = (this.zaa * 31) + (z ? 1 : 0);
        return this;
    }
}
