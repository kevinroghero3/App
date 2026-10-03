package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
final class zzkv implements zzly {
    private static final zzle zza = new zzku();
    private final zzle zzb;

    private static zzle zza() {
        try {
            return (zzle) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return zza;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzly
    public final <T> zzlz<T> zza(Class<T> cls) {
        zzmb.zza((Class<?>) cls);
        zzlf zzlfVarZza = this.zzb.zza(cls);
        if (zzlfVarZza.zzc()) {
            if (zzju.class.isAssignableFrom(cls)) {
                return zzln.zza(zzmb.zzb(), zzjl.zzb(), zzlfVarZza.zza());
            }
            return zzln.zza(zzmb.zza(), zzjl.zza(), zzlfVarZza.zza());
        }
        if (zzju.class.isAssignableFrom(cls)) {
            if (zza(zzlfVarZza)) {
                return zzll.zza(cls, zzlfVarZza, zzlr.zzb(), zzkm.zzb(), zzmb.zzb(), zzjl.zzb(), zzlc.zzb());
            }
            return zzll.zza(cls, zzlfVarZza, zzlr.zzb(), zzkm.zzb(), zzmb.zzb(), (zzjj<?>) null, zzlc.zzb());
        }
        if (zza(zzlfVarZza)) {
            return zzll.zza(cls, zzlfVarZza, zzlr.zza(), zzkm.zza(), zzmb.zza(), zzjl.zza(), zzlc.zza());
        }
        return zzll.zza(cls, zzlfVarZza, zzlr.zza(), zzkm.zza(), zzmb.zza(), (zzjj<?>) null, zzlc.zza());
    }

    public zzkv() {
        this(new zzkw(zzjs.zza(), zza()));
    }

    private zzkv(zzle zzleVar) {
        this.zzb = (zzle) zzjx.zza(zzleVar, "messageInfoFactory");
    }

    private static boolean zza(zzlf zzlfVar) {
        return zzkx.zza[zzlfVar.zzb().ordinal()] != 1;
    }
}
