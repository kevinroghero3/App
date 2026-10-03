package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
final class zzjs implements zzle {
    private static final zzjs zza = new zzjs();

    public static zzjs zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzle
    public final zzlf zza(Class<?> cls) {
        if (!zzju.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (zzlf) zzju.zza(cls.asSubclass(zzju.class)).zza(zzju.zzf.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e);
        }
    }

    private zzjs() {
    }

    @Override // com.google.android.gms.internal.measurement.zzle
    public final boolean zzb(Class<?> cls) {
        return zzju.class.isAssignableFrom(cls);
    }
}
