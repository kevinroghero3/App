package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
public final class zzfl {

    public static final class zza extends zzju<zza, zzb> implements zzlj {
        private static final zza zzc;
        private static volatile zzlq<zza> zzd;
        private int zze;
        private boolean zzi;
        private zzkd<C0030zza> zzf = zzju.zzce();
        private zzkd<zzc> zzg = zzju.zzce();
        private zzkd<zzf> zzh = zzju.zzce();
        private zzkd<C0030zza> zzj = zzju.zzce();

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzfl$zza$zza, reason: collision with other inner class name */
        public static final class C0030zza extends zzju<C0030zza, C0031zza> implements zzlj {
            private static final C0030zza zzc;
            private static volatile zzlq<C0030zza> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzfl$zza$zza$zza, reason: collision with other inner class name */
            public static final class C0031zza extends zzju.zza<C0030zza, C0031zza> implements zzlj {
                private C0031zza() {
                    super(C0030zza.zzc);
                }

                /* synthetic */ C0031zza(zzfn zzfnVar) {
                    this();
                }
            }

            public final zzd zzb() {
                zzd zzdVarZza = zzd.zza(this.zzg);
                return zzdVarZza == null ? zzd.CONSENT_STATUS_UNSPECIFIED : zzdVarZza;
            }

            public final zze zzc() {
                zze zzeVarZza = zze.zza(this.zzf);
                return zzeVarZza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zzeVarZza;
            }

            @Override // com.google.android.gms.internal.measurement.zzju
            protected final Object zza(int i, Object obj, Object obj2) {
                zzfn zzfnVar = null;
                switch (zzfn.zza[i - 1]) {
                    case 1:
                        return new C0030zza();
                    case 2:
                        return new C0031zza(zzfnVar);
                    case 3:
                        return zzju.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zzd.zzb()});
                    case 4:
                        return zzc;
                    case 5:
                        zzlq<C0030zza> zzcVar = zzd;
                        if (zzcVar == null) {
                            synchronized (C0030zza.class) {
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

            static {
                C0030zza c0030zza = new C0030zza();
                zzc = c0030zza;
                zzju.zza((Class<C0030zza>) C0030zza.class, c0030zza);
            }

            private C0030zza() {
            }
        }

        public static final class zzc extends zzju<zzc, C0032zza> implements zzlj {
            private static final zzc zzc;
            private static volatile zzlq<zzc> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzfl$zza$zzc$zza, reason: collision with other inner class name */
            public static final class C0032zza extends zzju.zza<zzc, C0032zza> implements zzlj {
                private C0032zza() {
                    super(zzc.zzc);
                }

                /* synthetic */ C0032zza(zzfn zzfnVar) {
                    this();
                }
            }

            public final zze zzb() {
                zze zzeVarZza = zze.zza(this.zzg);
                return zzeVarZza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zzeVarZza;
            }

            public final zze zzc() {
                zze zzeVarZza = zze.zza(this.zzf);
                return zzeVarZza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zzeVarZza;
            }

            @Override // com.google.android.gms.internal.measurement.zzju
            protected final Object zza(int i, Object obj, Object obj2) {
                zzfn zzfnVar = null;
                switch (zzfn.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new C0032zza(zzfnVar);
                    case 3:
                        return zzju.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zze.zzb()});
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

            static {
                zzc zzcVar = new zzc();
                zzc = zzcVar;
                zzju.zza((Class<zzc>) zzc.class, zzcVar);
            }

            private zzc() {
            }
        }

        public static final class zzf extends zzju<zzf, C0033zza> implements zzlj {
            private static final zzf zzc;
            private static volatile zzlq<zzf> zzd;
            private int zze;
            private String zzf = "";
            private String zzg = "";

            /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzfl$zza$zzf$zza, reason: collision with other inner class name */
            public static final class C0033zza extends zzju.zza<zzf, C0033zza> implements zzlj {
                private C0033zza() {
                    super(zzf.zzc);
                }

                /* synthetic */ C0033zza(zzfn zzfnVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.measurement.zzju
            protected final Object zza(int i, Object obj, Object obj2) {
                zzfn zzfnVar = null;
                switch (zzfn.zza[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0033zza(zzfnVar);
                    case 3:
                        return zzju.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                    case 4:
                        return zzc;
                    case 5:
                        zzlq<zzf> zzcVar = zzd;
                        if (zzcVar == null) {
                            synchronized (zzf.class) {
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

            static {
                zzf zzfVar = new zzf();
                zzc = zzfVar;
                zzju.zza((Class<zzf>) zzf.class, zzfVar);
            }

            private zzf() {
            }
        }

        public static final class zzb extends zzju.zza<zza, zzb> implements zzlj {
            private zzb() {
                super(zza.zzc);
            }

            /* synthetic */ zzb(zzfn zzfnVar) {
                this();
            }
        }

        public static zza zzb() {
            return zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfn zzfnVar = null;
            switch (zzfn.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(zzfnVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zze", "zzf", C0030zza.class, "zzg", zzc.class, "zzh", zzf.class, "zzi", "zzj", C0030zza.class});
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

        public enum zzd implements zzjw {
            CONSENT_STATUS_UNSPECIFIED(0),
            GRANTED(1),
            DENIED(2);

            private static final zzjz<zzd> zzd = new zzfp();
            private final int zzf;

            @Override // com.google.android.gms.internal.measurement.zzjw
            public final int zza() {
                return this.zzf;
            }

            public static zzd zza(int i) {
                if (i == 0) {
                    return CONSENT_STATUS_UNSPECIFIED;
                }
                if (i == 1) {
                    return GRANTED;
                }
                if (i != 2) {
                    return null;
                }
                return DENIED;
            }

            public static zzjy zzb() {
                return zzfo.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            zzd(int i) {
                this.zzf = i;
            }
        }

        public enum zze implements zzjw {
            CONSENT_TYPE_UNSPECIFIED(0),
            AD_STORAGE(1),
            ANALYTICS_STORAGE(2),
            AD_USER_DATA(3),
            AD_PERSONALIZATION(4);

            private static final zzjz<zze> zzf = new zzfq();
            private final int zzh;

            @Override // com.google.android.gms.internal.measurement.zzjw
            public final int zza() {
                return this.zzh;
            }

            public static zze zza(int i) {
                if (i == 0) {
                    return CONSENT_TYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return AD_STORAGE;
                }
                if (i == 2) {
                    return ANALYTICS_STORAGE;
                }
                if (i == 3) {
                    return AD_USER_DATA;
                }
                if (i != 4) {
                    return null;
                }
                return AD_PERSONALIZATION;
            }

            public static zzjy zzb() {
                return zzfr.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            zze(int i) {
                this.zzh = i;
            }
        }

        public final List<zzf> zzc() {
            return this.zzh;
        }

        public final List<C0030zza> zzd() {
            return this.zzf;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final List<C0030zza> zzf() {
            return this.zzj;
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzju.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public final boolean zzg() {
            return this.zzi;
        }

        public final boolean zzh() {
            return (this.zze & 1) != 0;
        }
    }

    public static final class zzb extends zzju<zzb, zza> implements zzlj {
        private static final zzb zzc;
        private static volatile zzlq<zzb> zzd;
        private int zze;
        private String zzf = "";
        private zzkd<zzf> zzg = zzju.zzce();
        private boolean zzh;

        public static final class zza extends zzju.zza<zzb, zza> implements zzlj {
            private zza() {
                super(zzb.zzc);
            }

            /* synthetic */ zza(zzfn zzfnVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfn zzfnVar = null;
            switch (zzfn.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzfnVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", zzf.class, "zzh"});
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
        private String zzf = "";
        private boolean zzg;
        private boolean zzh;
        private int zzi;

        public static final class zza extends zzju.zza<zzc, zza> implements zzlj {
            public final int zza() {
                return ((zzc) this.zza).zza();
            }

            public final zza zza(String str) {
                zzak();
                ((zzc) this.zza).zza(str);
                return this;
            }

            public final String zzb() {
                return ((zzc) this.zza).zzc();
            }

            private zza() {
                super(zzc.zzc);
            }

            /* synthetic */ zza(zzfn zzfnVar) {
                this();
            }

            public final boolean zzc() {
                return ((zzc) this.zza).zzd();
            }

            public final boolean zzd() {
                return ((zzc) this.zza).zze();
            }

            public final boolean zze() {
                return ((zzc) this.zza).zzf();
            }

            public final boolean zzf() {
                return ((zzc) this.zza).zzg();
            }

            public final boolean zzg() {
                return ((zzc) this.zza).zzh();
            }
        }

        public final int zza() {
            return this.zzi;
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfn zzfnVar = null;
            switch (zzfn.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzfnVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
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

        public final String zzc() {
            return this.zzf;
        }

        static {
            zzc zzcVar = new zzc();
            zzc = zzcVar;
            zzju.zza((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 1;
            this.zzf = str;
        }

        public final boolean zzd() {
            return this.zzg;
        }

        public final boolean zze() {
            return this.zzh;
        }

        public final boolean zzf() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzg() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzh() {
            return (this.zze & 8) != 0;
        }
    }

    public static final class zzd extends zzju<zzd, zza> implements zzlj {
        private static final zzd zzc;
        private static volatile zzlq<zzd> zzd;
        private int zze;
        private long zzf;
        private int zzh;
        private boolean zzm;
        private zza zzr;
        private zze zzs;
        private zzh zzt;
        private zzf zzu;
        private String zzg = "";
        private zzkd<zzg> zzi = zzju.zzce();
        private zzkd<zzc> zzj = zzju.zzce();
        private zzkd<zzfg.zza> zzk = zzju.zzce();
        private String zzl = "";
        private zzkd<zzgc.zzc> zzn = zzju.zzce();
        private zzkd<zzb> zzo = zzju.zzce();
        private String zzp = "";
        private String zzq = "";

        public static final class zza extends zzju.zza<zzd, zza> implements zzlj {
            public final int zza() {
                return ((zzd) this.zza).zzb();
            }

            public final zzc zza(int i) {
                return ((zzd) this.zza).zza(i);
            }

            public final zza zzb() {
                zzak();
                ((zzd) this.zza).zzt();
                return this;
            }

            public final zza zza(int i, zzc.zza zzaVar) {
                zzak();
                ((zzd) this.zza).zza(i, (zzc) ((zzju) zzaVar.zzah()));
                return this;
            }

            public final String zzc() {
                return ((zzd) this.zza).zzj();
            }

            public final List<zzfg.zza> zzd() {
                return Collections.unmodifiableList(((zzd) this.zza).zzk());
            }

            public final List<zzb> zze() {
                return Collections.unmodifiableList(((zzd) this.zza).zzl());
            }

            private zza() {
                super(zzd.zzc);
            }

            /* synthetic */ zza(zzfn zzfnVar) {
                this();
            }
        }

        public final int zza() {
            return this.zzn.size();
        }

        public final int zzb() {
            return this.zzj.size();
        }

        public final long zzc() {
            return this.zzf;
        }

        public final zza zzd() {
            zza zzaVar = this.zzr;
            return zzaVar == null ? zza.zzb() : zzaVar;
        }

        public final zzc zza(int i) {
            return this.zzj.get(i);
        }

        public static zza zze() {
            return zzc.zzbz();
        }

        public static zzd zzg() {
            return zzc;
        }

        public final zzh zzh() {
            zzh zzhVar = this.zzt;
            return zzhVar == null ? zzh.zzc() : zzhVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfn zzfnVar = null;
            switch (zzfn.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzfnVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0010\u0000\u0001\u0001\u0012\u0010\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzg.class, "zzj", zzc.class, "zzk", zzfg.zza.class, "zzl", "zzm", "zzn", zzgc.zzc.class, "zzo", zzb.class, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu"});
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

        public final String zzi() {
            return this.zzg;
        }

        public final String zzj() {
            return this.zzp;
        }

        public final List<zzfg.zza> zzk() {
            return this.zzk;
        }

        public final List<zzb> zzl() {
            return this.zzo;
        }

        public final List<zzgc.zzc> zzm() {
            return this.zzn;
        }

        public final List<zzg> zzn() {
            return this.zzi;
        }

        static {
            zzd zzdVar = new zzd();
            zzc = zzdVar;
            zzju.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzt() {
            this.zzk = zzju.zzce();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zzc zzcVar) {
            zzcVar.getClass();
            zzkd<zzc> zzkdVar = this.zzj;
            if (!zzkdVar.zzc()) {
                this.zzj = zzju.zza(zzkdVar);
            }
            this.zzj.set(i, zzcVar);
        }

        public final boolean zzo() {
            return this.zzm;
        }

        public final boolean zzp() {
            return (this.zze & 128) != 0;
        }

        public final boolean zzq() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzr() {
            return (this.zze & 512) != 0;
        }

        public final boolean zzs() {
            return (this.zze & 1) != 0;
        }
    }

    public static final class zze extends zzju<zze, zza> implements zzlj {
        private static final zze zzc;
        private static volatile zzlq<zze> zzd;
        private int zze;
        private int zzf = 14;
        private int zzg = 11;
        private int zzh = 60;

        public static final class zza extends zzju.zza<zze, zza> implements zzlj {
            private zza() {
                super(zze.zzc);
            }

            /* synthetic */ zza(zzfn zzfnVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfn zzfnVar = null;
            switch (zzfn.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzfnVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zze> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zze.class) {
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

        static {
            zze zzeVar = new zze();
            zzc = zzeVar;
            zzju.zza((Class<zze>) zze.class, zzeVar);
        }

        private zze() {
        }
    }

    public static final class zzf extends zzju<zzf, zza> implements zzlj {
        private static final zzf zzc;
        private static volatile zzlq<zzf> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        public static final class zza extends zzju.zza<zzf, zza> implements zzlj {
            private zza() {
                super(zzf.zzc);
            }

            /* synthetic */ zza(zzfn zzfnVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfn zzfnVar = null;
            switch (zzfn.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzfnVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zzf> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzf.class) {
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

        static {
            zzf zzfVar = new zzf();
            zzc = zzfVar;
            zzju.zza((Class<zzf>) zzf.class, zzfVar);
        }

        private zzf() {
        }
    }

    public static final class zzg extends zzju<zzg, zza> implements zzlj {
        private static final zzg zzc;
        private static volatile zzlq<zzg> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        public static final class zza extends zzju.zza<zzg, zza> implements zzlj {
            private zza() {
                super(zzg.zzc);
            }

            /* synthetic */ zza(zzfn zzfnVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfn zzfnVar = null;
            switch (zzfn.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzfnVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zzg> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzg.class) {
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

        public final String zzc() {
            return this.zzg;
        }

        static {
            zzg zzgVar = new zzg();
            zzc = zzgVar;
            zzju.zza((Class<zzg>) zzg.class, zzgVar);
        }

        private zzg() {
        }
    }

    public static final class zzh extends zzju<zzh, zza> implements zzlj {
        private static final zzh zzc;
        private static volatile zzlq<zzh> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private int zzi;

        public final int zza() {
            return this.zzi;
        }

        public static final class zza extends zzju.zza<zzh, zza> implements zzlj {
            private zza() {
                super(zzh.zzc);
            }

            /* synthetic */ zza(zzfn zzfnVar) {
                this();
            }
        }

        public static zzh zzc() {
            return zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfn zzfnVar = null;
            switch (zzfn.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zzfnVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zzh> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzh.class) {
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

        public final String zzd() {
            return this.zzg;
        }

        public final String zze() {
            return this.zzf;
        }

        static {
            zzh zzhVar = new zzh();
            zzc = zzhVar;
            zzju.zza((Class<zzh>) zzh.class, zzhVar);
        }

        private zzh() {
        }
    }
}
