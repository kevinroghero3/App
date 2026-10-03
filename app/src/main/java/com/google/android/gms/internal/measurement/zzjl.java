package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
final class zzjl {
    private static final zzjj<?> zza = new zzji();
    private static final zzjj<?> zzb = zzc();

    static zzjj<?> zza() {
        zzjj<?> zzjjVar = zzb;
        if (zzjjVar != null) {
            return zzjjVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzjj<?> zzb() {
        return zza;
    }

    private static zzjj<?> zzc() {
        try {
            return (zzjj) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
