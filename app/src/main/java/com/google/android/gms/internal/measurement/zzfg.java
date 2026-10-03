package com.google.android.gms.internal.measurement;

import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
public final class zzfg {

    public static final class zza extends zzju<zza, C0029zza> implements zzlj {
        private static final zza zzc;
        private static volatile zzlq<zza> zzd;
        private int zze;
        private int zzf;
        private zzkd<zze> zzg = zzju.zzce();
        private zzkd<zzb> zzh = zzju.zzce();
        private boolean zzi;
        private boolean zzj;

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzfg$zza$zza, reason: collision with other inner class name */
        public static final class C0029zza extends zzju.zza<zza, C0029zza> implements zzlj {
            public final int zza() {
                return ((zza) this.zza).zzb();
            }

            public final int zzb() {
                return ((zza) this.zza).zzc();
            }

            public final C0029zza zza(int i, zzb.zza zzaVar) {
                zzak();
                ((zza) this.zza).zza(i, (zzb) ((zzju) zzaVar.zzah()));
                return this;
            }

            public final C0029zza zza(int i, zze.zza zzaVar) {
                zzak();
                ((zza) this.zza).zza(i, (zze) ((zzju) zzaVar.zzah()));
                return this;
            }

            public final zzb zza(int i) {
                return ((zza) this.zza).zza(i);
            }

            public final zze zzb(int i) {
                return ((zza) this.zza).zzb(i);
            }

            private C0029zza() {
                super(zza.zzc);
            }

            /* synthetic */ C0029zza(zzfh zzfhVar) {
                this();
            }
        }

        public final int zza() {
            return this.zzf;
        }

        public final int zzb() {
            return this.zzh.size();
        }

        public final int zzc() {
            return this.zzg.size();
        }

        public final zzb zza(int i) {
            return this.zzh.get(i);
        }

        public final zze zzb(int i) {
            return this.zzg.get(i);
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfh zzfhVar = null;
            switch (zzfh.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0029zza(zzfhVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zze", "zzf", "zzg", zze.class, "zzh", zzb.class, "zzi", "zzj"});
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

        public final List<zzb> zze() {
            return this.zzh;
        }

        public final List<zze> zzf() {
            return this.zzg;
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzju.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zzb zzbVar) {
            zzbVar.getClass();
            zzkd<zzb> zzkdVar = this.zzh;
            if (!zzkdVar.zzc()) {
                this.zzh = zzju.zza(zzkdVar);
            }
            this.zzh.set(i, zzbVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zze zzeVar) {
            zzeVar.getClass();
            zzkd<zze> zzkdVar = this.zzg;
            if (!zzkdVar.zzc()) {
                this.zzg = zzju.zza(zzkdVar);
            }
            this.zzg.set(i, zzeVar);
        }

        public final boolean zzg() {
            return (this.zze & 1) != 0;
        }
    }

    public static final class zzb extends zzju<zzb, zza> implements zzlj {
        private static final zzb zzc;
        private static volatile zzlq<zzb> zzd;
        private int zze;
        private int zzf;
        private String zzg = "";
        private zzkd<zzc> zzh = zzju.zzce();
        private boolean zzi;
        private zzd zzj;
        private boolean zzk;
        private boolean zzl;
        private boolean zzm;

        public static final class zza extends zzju.zza<zzb, zza> implements zzlj {
            public final int zza() {
                return ((zzb) this.zza).zza();
            }

            public final zza zza(String str) {
                zzak();
                ((zzb) this.zza).zza(str);
                return this;
            }

            public final zza zza(int i, zzc zzcVar) {
                zzak();
                ((zzb) this.zza).zza(i, zzcVar);
                return this;
            }

            public final zzc zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final String zzb() {
                return ((zzb) this.zza).zzf();
            }

            private zza() {
                super(zzb.zzc);
            }

            /* synthetic */ zza(zzfh zzfhVar) {
                this();
            }
        }

        public final int zza() {
            return this.zzh.size();
        }

        public final int zzb() {
            return this.zzf;
        }

        public static zza zzc() {
            return zzc.zzbz();
        }

        public final zzc zza(int i) {
            return this.zzh.get(i);
        }

        public final zzd zze() {
            zzd zzdVar = this.zzj;
            return zzdVar == null ? zzd.zzc() : zzdVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfh zzfhVar = null;
            switch (zzfh.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzfhVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", zzc.class, "zzi", "zzj", "zzk", "zzl", "zzm"});
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

        public final String zzf() {
            return this.zzg;
        }

        public final List<zzc> zzg() {
            return this.zzh;
        }

        static {
            zzb zzbVar = new zzb();
            zzc = zzbVar;
            zzju.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 2;
            this.zzg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zzc zzcVar) {
            zzcVar.getClass();
            zzkd<zzc> zzkdVar = this.zzh;
            if (!zzkdVar.zzc()) {
                this.zzh = zzju.zza(zzkdVar);
            }
            this.zzh.set(i, zzcVar);
        }

        public final boolean zzh() {
            return this.zzk;
        }

        public final boolean zzi() {
            return this.zzl;
        }

        public final boolean zzj() {
            return this.zzm;
        }

        public final boolean zzk() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzl() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzm() {
            return (this.zze & 64) != 0;
        }
    }

    public static final class zzc extends zzju<zzc, zza> implements zzlj {
        private static final zzc zzc;
        private static volatile zzlq<zzc> zzd;
        private int zze;
        private zzf zzf;
        private zzd zzg;
        private boolean zzh;
        private String zzi = "";

        public static zzc zzb() {
            return zzc;
        }

        public static final class zza extends zzju.zza<zzc, zza> implements zzlj {
            public final zza zza(String str) {
                zzak();
                ((zzc) this.zza).zza(str);
                return this;
            }

            private zza() {
                super(zzc.zzc);
            }

            /* synthetic */ zza(zzfh zzfhVar) {
                this();
            }
        }

        public final zzd zzc() {
            zzd zzdVar = this.zzg;
            return zzdVar == null ? zzd.zzc() : zzdVar;
        }

        public final zzf zzd() {
            zzf zzfVar = this.zzf;
            return zzfVar == null ? zzf.zzd() : zzfVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfh zzfhVar = null;
            switch (zzfh.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzfhVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
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

        public final String zze() {
            return this.zzi;
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
            this.zze |= 8;
            this.zzi = str;
        }

        public final boolean zzf() {
            return this.zzh;
        }

        public final boolean zzg() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzh() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 1) != 0;
        }
    }

    public static final class zzd extends zzju<zzd, zzb> implements zzlj {
        private static final zzd zzc;
        private static volatile zzlq<zzd> zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";

        public final zza zza() {
            zza zzaVarZza = zza.zza(this.zzf);
            return zzaVarZza == null ? zza.UNKNOWN_COMPARISON_TYPE : zzaVarZza;
        }

        public static final class zzb extends zzju.zza<zzd, zzb> implements zzlj {
            private zzb() {
                super(zzd.zzc);
            }

            /* synthetic */ zzb(zzfh zzfhVar) {
                this();
            }
        }

        public static zzd zzc() {
            return zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfh zzfhVar = null;
            switch (zzfh.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zzb(zzfhVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zze", "zzf", zza.zzb(), "zzg", "zzh", "zzi", "zzj"});
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

        public enum zza implements zzjw {
            UNKNOWN_COMPARISON_TYPE(0),
            LESS_THAN(1),
            GREATER_THAN(2),
            EQUAL(3),
            BETWEEN(4);

            private static final zzjz<zza> zzf = new zzfj();
            private final int zzh;

            @Override // com.google.android.gms.internal.measurement.zzjw
            public final int zza() {
                return this.zzh;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return UNKNOWN_COMPARISON_TYPE;
                }
                if (i == 1) {
                    return LESS_THAN;
                }
                if (i == 2) {
                    return GREATER_THAN;
                }
                if (i == 3) {
                    return EQUAL;
                }
                if (i != 4) {
                    return null;
                }
                return BETWEEN;
            }

            public static zzjy zzb() {
                return zzfi.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzh = i;
            }
        }

        public final String zzd() {
            return this.zzh;
        }

        public final String zze() {
            return this.zzj;
        }

        public final String zzf() {
            return this.zzi;
        }

        static {
            zzd zzdVar = new zzd();
            zzc = zzdVar;
            zzju.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        public final boolean zzg() {
            return this.zzg;
        }

        public final boolean zzh() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzk() {
            return (this.zze & 16) != 0;
        }

        public final boolean zzl() {
            return (this.zze & 8) != 0;
        }
    }

    public static final class zze extends zzju<zze, zza> implements zzlj {
        private static final zze zzc;
        private static volatile zzlq<zze> zzd;
        private int zze;
        private int zzf;
        private String zzg = "";
        private zzc zzh;
        private boolean zzi;
        private boolean zzj;
        private boolean zzk;

        public final int zza() {
            return this.zzf;
        }

        public final zzc zzb() {
            zzc zzcVar = this.zzh;
            return zzcVar == null ? zzc.zzb() : zzcVar;
        }

        public static final class zza extends zzju.zza<zze, zza> implements zzlj {
            public final zza zza(String str) {
                zzak();
                ((zze) this.zza).zza(str);
                return this;
            }

            private zza() {
                super(zze.zzc);
            }

            /* synthetic */ zza(zzfh zzfhVar) {
                this();
            }
        }

        public static zza zzc() {
            return zzc.zzbz();
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfh zzfhVar = null;
            switch (zzfh.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzfhVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
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

        public final String zze() {
            return this.zzg;
        }

        static {
            zze zzeVar = new zze();
            zzc = zzeVar;
            zzju.zza((Class<zze>) zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 2;
            this.zzg = str;
        }

        public final boolean zzf() {
            return this.zzi;
        }

        public final boolean zzg() {
            return this.zzj;
        }

        public final boolean zzh() {
            return this.zzk;
        }

        public final boolean zzi() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 32) != 0;
        }
    }

    public static final class zzf extends zzju<zzf, zza> implements zzlj {
        private static final zzf zzc;
        private static volatile zzlq<zzf> zzd;
        private int zze;
        private int zzf;
        private boolean zzh;
        private String zzg = "";
        private zzkd<String> zzi = zzju.zzce();

        public final int zza() {
            return this.zzi.size();
        }

        public static final class zza extends zzju.zza<zzf, zza> implements zzlj {
            private zza() {
                super(zzf.zzc);
            }

            /* synthetic */ zza(zzfh zzfhVar) {
                this();
            }
        }

        public final zzb zzb() {
            zzb zzbVarZza = zzb.zza(this.zzf);
            return zzbVarZza == null ? zzb.UNKNOWN_MATCH_TYPE : zzbVarZza;
        }

        public static zzf zzd() {
            return zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfh zzfhVar = null;
            switch (zzfh.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzfhVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zze", "zzf", zzb.zzb(), "zzg", "zzh", "zzi"});
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

        public enum zzb implements zzjw {
            UNKNOWN_MATCH_TYPE(0),
            REGEXP(1),
            BEGINS_WITH(2),
            ENDS_WITH(3),
            PARTIAL(4),
            EXACT(5),
            IN_LIST(6);

            private static final zzjz<zzb> zzh = new zzfk();
            private final int zzj;

            @Override // com.google.android.gms.internal.measurement.zzjw
            public final int zza() {
                return this.zzj;
            }

            public static zzb zza(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_MATCH_TYPE;
                    case 1:
                        return REGEXP;
                    case 2:
                        return BEGINS_WITH;
                    case 3:
                        return ENDS_WITH;
                    case 4:
                        return PARTIAL;
                    case 5:
                        return EXACT;
                    case 6:
                        return IN_LIST;
                    default:
                        return null;
                }
            }

            public static zzjy zzb() {
                return zzfm.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzj + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzj = i;
            }
        }

        public final String zze() {
            return this.zzg;
        }

        public final List<String> zzf() {
            return this.zzi;
        }

        static {
            zzf zzfVar = new zzf();
            zzc = zzfVar;
            zzju.zza((Class<zzf>) zzf.class, zzfVar);
        }

        private zzf() {
        }

        public final boolean zzg() {
            return this.zzh;
        }

        public final boolean zzh() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 1) != 0;
        }
    }
}
