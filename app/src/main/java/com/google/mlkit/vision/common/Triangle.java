package com.google.mlkit.vision.common;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_common.zzp;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Triangle<T> {
    private final zzp zza;

    public Triangle(@NonNull T t, @NonNull T t2, @NonNull T t3) {
        this.zza = zzp.zzj(t, t2, t3);
    }

    public List<T> getAllPoints() {
        return this.zza;
    }
}
