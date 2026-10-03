package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
final class zzlr {
    private static final zzlp zza = zzc();
    private static final zzlp zzb = new zzlo();

    static zzlp zza() {
        return zza;
    }

    static zzlp zzb() {
        return zzb;
    }

    private static zzlp zzc() {
        try {
            return (zzlp) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
