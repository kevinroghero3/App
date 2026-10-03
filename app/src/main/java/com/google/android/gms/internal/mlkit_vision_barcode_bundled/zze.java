package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.hitachiapp.exceptions.RunningOnEmulatorException;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes4.dex */
public final class zze extends zzeb implements zzfn {
    private zze() {
        throw null;
    }

    /* synthetic */ zze(zzd zzdVar) {
        super(zzf.zzb);
    }

    public static void $$a(long j, long j2) throws Throwable {
        try {
            Constructor declaredConstructor = RunningOnEmulatorException.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            throw ((Throwable) declaredConstructor.newInstance(null));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }
}
