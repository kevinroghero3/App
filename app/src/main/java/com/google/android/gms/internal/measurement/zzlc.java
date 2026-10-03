package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
final class zzlc {
    private static final zzla zza = zzc();
    private static final zzla zzb = new zzld();

    static zzla zza() {
        return zza;
    }

    static zzla zzb() {
        return zzb;
    }

    private static zzla zzc() {
        try {
            return (zzla) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
