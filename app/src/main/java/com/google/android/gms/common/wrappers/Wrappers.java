package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class Wrappers {
    private static final Wrappers zza = new Wrappers();
    private PackageManagerWrapper zzb = null;

    public static PackageManagerWrapper packageManager(@NonNull Context context) {
        return zza.zza(context);
    }

    public final PackageManagerWrapper zza(@NonNull Context context) {
        PackageManagerWrapper packageManagerWrapper;
        synchronized (this) {
            if (this.zzb == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.zzb = new PackageManagerWrapper(context);
            }
            packageManagerWrapper = this.zzb;
        }
        return packageManagerWrapper;
    }
}
