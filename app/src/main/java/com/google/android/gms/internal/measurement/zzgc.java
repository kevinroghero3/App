package com.google.android.gms.internal.measurement;

import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
public final class zzgc {

    public static final class zza extends zzju<zza, C0035zza> implements zzlj {
        private static final zza zzc;
        private static volatile zzlq<zza> zzd;
        private zzkd<zzb> zze = zzju.zzce();

        public final int zza() {
            return this.zze.size();
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzgc$zza$zza, reason: collision with other inner class name */
        public static final class C0035zza extends zzju.zza<zza, C0035zza> implements zzlj {
            private C0035zza() {
                super(zza.zzc);
            }

            /* synthetic */ C0035zza(zzgb zzgbVar) {
                this();
            }
        }

        public static zza zzc() {
            return zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgb zzgbVar = null;
            switch (zzgb.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0035zza(zzgbVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzb.class});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zza> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zza.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzju.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                            break;
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final List<zzb> zzd() {
            return this.zze;
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzju.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }
    }

    public static final class zzb extends zzju<zzb, zza> implements zzlj {
        private static final zzb zzc;
        private static volatile zzlq<zzb> zzd;
        private int zze;
        private String zzf = "";
        private zzkd<zzd> zzg = zzju.zzce();

        public static final class zza extends zzju.zza<zzb, zza> implements zzlj {
            private zza() {
                super(zzb.zzc);
            }

            /* synthetic */ zza(zzgb zzgbVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgb zzgbVar = null;
            switch (zzgb.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzgbVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", zzd.class});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zzb> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzb.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzju.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                            break;
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zzb() {
            return this.zzf;
        }

        public final List<zzd> zzc() {
            return this.zzg;
        }

        static {
            zzb zzbVar = new zzb();
            zzc = zzbVar;
            zzju.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }
    }

    public static final class zzc extends zzju<zzc, zza> implements zzlj {
        private static final zzc zzc;
        private static volatile zzlq<zzc> zzd;
        private int zze;
        private zzkd<zzd> zzf = zzju.zzce();
        private zza zzg;

        public final zza zza() {
            zza zzaVar = this.zzg;
            return zzaVar == null ? zza.zzc() : zzaVar;
        }

        public static final class zza extends zzju.zza<zzc, zza> implements zzlj {
            private zza() {
                super(zzc.zzc);
            }

            /* synthetic */ zza(zzgb zzgbVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgb zzgbVar = null;
            switch (zzgb.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzgbVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zze", "zzf", zzd.class, "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zzc> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzc.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzju.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                            break;
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final List<zzd> zzc() {
            return this.zzf;
        }

        static {
            zzc zzcVar = new zzc();
            zzc = zzcVar;
            zzju.zza((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }
    }

    public static final class zzd extends zzju<zzd, zza> implements zzlj {
        private static final zzd zzc;
        private static volatile zzlq<zzd> zzd;
        private int zze;
        private int zzf;
        private zzkd<zzd> zzg = zzju.zzce();
        private String zzh = "";
        private String zzi = "";
        private boolean zzj;
        private double zzk;

        public final double zza() {
            return this.zzk;
        }

        public static final class zza extends zzju.zza<zzd, zza> implements zzlj {
            private zza() {
                super(zzd.zzc);
            }

            /* synthetic */ zza(zzgb zzgbVar) {
                this();
            }
        }

        public final zzb zzb() {
            zzb zzbVarZza = zzb.zza(this.zzf);
            return zzbVarZza == null ? zzb.UNKNOWN : zzbVarZza;
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgb zzgbVar = null;
            switch (zzgb.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzgbVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zze", "zzf", zzb.zzb(), "zzg", zzd.class, "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zzd> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzd.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzju.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                            break;
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public enum zzb implements zzjw {
            UNKNOWN(0),
            STRING(1),
            NUMBER(2),
            BOOLEAN(3),
            STATEMENT(4);

            private static final zzjz<zzb> zzf = new zzgd();
            private final int zzh;

            @Override // com.google.android.gms.internal.measurement.zzjw
            public final int zza() {
                return this.zzh;
            }

            public static zzb zza(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return STRING;
                }
                if (i == 2) {
                    return NUMBER;
                }
                if (i == 3) {
                    return BOOLEAN;
                }
                if (i != 4) {
                    return null;
                }
                return STATEMENT;
            }

            public static zzjy zzb() {
                return zzgf.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzh = i;
            }
        }

        public final String zzd() {
            return this.zzh;
        }

        public final String zze() {
            return this.zzi;
        }

        public final List<zzd> zzf() {
            return this.zzg;
        }

        static {
            zzd zzdVar = new zzd();
            zzc = zzdVar;
            zzju.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        public final boolean zzg() {
            return this.zzj;
        }

        public final boolean zzh() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 16) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 4) != 0;
        }
    }
}
