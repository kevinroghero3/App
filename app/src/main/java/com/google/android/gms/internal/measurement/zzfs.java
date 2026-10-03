package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
public final class zzfs {

    public static final class zza extends zzju<zza, C0034zza> implements zzlj {
        private static final zza zzc;
        private static volatile zzlq<zza> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzfs$zza$zza, reason: collision with other inner class name */
        public static final class C0034zza extends zzju.zza<zza, C0034zza> implements zzlj {
            private C0034zza() {
                super(zza.zzc);
            }

            /* synthetic */ C0034zza(zzfu zzfuVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0034zza(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
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
        private boolean zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;
        private boolean zzj;
        private boolean zzk;
        private boolean zzl;

        public static zza zza() {
            return zzc.zzbz();
        }

        public static final class zza extends zzju.zza<zzb, zza> implements zzlj {
            public final zza zza(boolean z) {
                zzak();
                ((zzb) this.zza).zza(z);
                return this;
            }

            public final zza zzb(boolean z) {
                zzak();
                ((zzb) this.zza).zzb(z);
                return this;
            }

            public final zza zzc(boolean z) {
                zzak();
                ((zzb) this.zza).zzc(z);
                return this;
            }

            public final zza zzd(boolean z) {
                zzak();
                ((zzb) this.zza).zzd(z);
                return this;
            }

            public final zza zze(boolean z) {
                zzak();
                ((zzb) this.zza).zze(z);
                return this;
            }

            public final zza zzf(boolean z) {
                zzak();
                ((zzb) this.zza).zzf(z);
                return this;
            }

            public final zza zzg(boolean z) {
                zzak();
                ((zzb) this.zza).zzg(z);
                return this;
            }

            private zza() {
                super(zzb.zzc);
            }

            /* synthetic */ zza(zzfu zzfuVar) {
                this();
            }
        }

        public static zzb zzc() {
            return zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
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

        static {
            zzb zzbVar = new zzb();
            zzc = zzbVar;
            zzju.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zze |= 32;
            this.zzk = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zze |= 16;
            this.zzj = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(boolean z) {
            this.zze |= 1;
            this.zzf = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(boolean z) {
            this.zze |= 64;
            this.zzl = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(boolean z) {
            this.zze |= 2;
            this.zzg = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(boolean z) {
            this.zze |= 4;
            this.zzh = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(boolean z) {
            this.zze |= 8;
            this.zzi = z;
        }

        public final boolean zzd() {
            return this.zzk;
        }

        public final boolean zze() {
            return this.zzj;
        }

        public final boolean zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return this.zzl;
        }

        public final boolean zzh() {
            return this.zzg;
        }

        public final boolean zzi() {
            return this.zzh;
        }

        public final boolean zzj() {
            return this.zzi;
        }
    }

    public static final class zzc extends zzju<zzc, zza> implements zzlj {
        private static final zzc zzc;
        private static volatile zzlq<zzc> zzd;
        private int zze;
        private int zzf;
        private zzl zzg;
        private zzl zzh;
        private boolean zzi;

        public final int zza() {
            return this.zzf;
        }

        public static zza zzb() {
            return zzc.zzbz();
        }

        public static final class zza extends zzju.zza<zzc, zza> implements zzlj {
            public final zza zza(int i) {
                zzak();
                ((zzc) this.zza).zza(i);
                return this;
            }

            public final zza zza(zzl.zza zzaVar) {
                zzak();
                ((zzc) this.zza).zza((zzl) ((zzju) zzaVar.zzah()));
                return this;
            }

            public final zza zza(boolean z) {
                zzak();
                ((zzc) this.zza).zza(z);
                return this;
            }

            public final zza zza(zzl zzlVar) {
                zzak();
                ((zzc) this.zza).zzb(zzlVar);
                return this;
            }

            private zza() {
                super(zzc.zzc);
            }

            /* synthetic */ zza(zzfu zzfuVar) {
                this();
            }
        }

        public final zzl zzd() {
            zzl zzlVar = this.zzg;
            return zzlVar == null ? zzl.zzg() : zzlVar;
        }

        public final zzl zze() {
            zzl zzlVar = this.zzh;
            return zzlVar == null ? zzl.zzg() : zzlVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i) {
            this.zze |= 1;
            this.zzf = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzl zzlVar) {
            zzlVar.getClass();
            this.zzg = zzlVar;
            this.zze |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zze |= 8;
            this.zzi = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzl zzlVar) {
            zzlVar.getClass();
            this.zzh = zzlVar;
            this.zze |= 4;
        }

        public final boolean zzf() {
            return this.zzi;
        }

        public final boolean zzg() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzh() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 4) != 0;
        }
    }

    public static final class zzd extends zzju<zzd, zza> implements zzlj {
        private static final zzd zzc;
        private static volatile zzlq<zzd> zzd;
        private int zze;
        private int zzf;
        private long zzg;

        public final int zza() {
            return this.zzf;
        }

        public final long zzb() {
            return this.zzg;
        }

        public static final class zza extends zzju.zza<zzd, zza> implements zzlj {
            public final zza zza(long j) {
                zzak();
                ((zzd) this.zza).zza(j);
                return this;
            }

            public final zza zza(int i) {
                zzak();
                ((zzd) this.zza).zza(i);
                return this;
            }

            private zza() {
                super(zzd.zzc);
            }

            /* synthetic */ zza(zzfu zzfuVar) {
                this();
            }
        }

        public static zza zzc() {
            return zzc.zzbz();
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
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

        static {
            zzd zzdVar = new zzd();
            zzc = zzdVar;
            zzju.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zze |= 2;
            this.zzg = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i) {
            this.zze |= 1;
            this.zzf = i;
        }

        public final boolean zze() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzf() {
            return (this.zze & 1) != 0;
        }
    }

    public static final class zze extends zzju<zze, zza> implements zzlj {
        private static final zze zzc;
        private static volatile zzlq<zze> zzd;
        private int zze;
        private zzkd<zzg> zzf = zzju.zzce();
        private String zzg = "";
        private long zzh;
        private long zzi;
        private int zzj;

        public static final class zza extends zzju.zza<zze, zza> implements zzlj {
            public final int zza() {
                return ((zze) this.zza).zzb();
            }

            public final long zzb() {
                return ((zze) this.zza).zzc();
            }

            public final long zzc() {
                return ((zze) this.zza).zzd();
            }

            public final zza zza(Iterable<? extends zzg> iterable) {
                zzak();
                ((zze) this.zza).zza(iterable);
                return this;
            }

            public final zza zza(zzg.zza zzaVar) {
                zzak();
                ((zze) this.zza).zza((zzg) ((zzju) zzaVar.zzah()));
                return this;
            }

            public final zza zza(zzg zzgVar) {
                zzak();
                ((zze) this.zza).zza(zzgVar);
                return this;
            }

            public final zza zzd() {
                zzak();
                ((zze) this.zza).zzl();
                return this;
            }

            public final zza zza(int i) {
                zzak();
                ((zze) this.zza).zzb(i);
                return this;
            }

            public final zza zza(String str) {
                zzak();
                ((zze) this.zza).zza(str);
                return this;
            }

            public final zza zza(int i, zzg.zza zzaVar) {
                zzak();
                ((zze) this.zza).zza(i, (zzg) ((zzju) zzaVar.zzah()));
                return this;
            }

            public final zza zza(int i, zzg zzgVar) {
                zzak();
                ((zze) this.zza).zza(i, zzgVar);
                return this;
            }

            public final zza zza(long j) {
                zzak();
                ((zze) this.zza).zza(j);
                return this;
            }

            public final zza zzb(long j) {
                zzak();
                ((zze) this.zza).zzb(j);
                return this;
            }

            public final zzg zzb(int i) {
                return ((zze) this.zza).zza(i);
            }

            public final String zze() {
                return ((zze) this.zza).zzg();
            }

            public final List<zzg> zzf() {
                return Collections.unmodifiableList(((zze) this.zza).zzh());
            }

            private zza() {
                super(zze.zzc);
            }

            /* synthetic */ zza(zzfu zzfuVar) {
                this();
            }

            public final boolean zzg() {
                return ((zze) this.zza).zzk();
            }
        }

        public final int zza() {
            return this.zzj;
        }

        public final int zzb() {
            return this.zzf.size();
        }

        public final long zzc() {
            return this.zzi;
        }

        public final long zzd() {
            return this.zzh;
        }

        public static zza zze() {
            return zzc.zzbz();
        }

        public final zzg zza(int i) {
            return this.zzf.get(i);
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zze", "zzf", zzg.class, "zzg", "zzh", "zzi", "zzj"});
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

        public final String zzg() {
            return this.zzg;
        }

        public final List<zzg> zzh() {
            return this.zzf;
        }

        static {
            zze zzeVar = new zze();
            zzc = zzeVar;
            zzju.zza((Class<zze>) zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zzg> iterable) {
            zzm();
            zzhy.zza(iterable, this.zzf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzg zzgVar) {
            zzgVar.getClass();
            zzm();
            this.zzf.add(zzgVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl() {
            this.zzf = zzju.zzce();
        }

        private final void zzm() {
            zzkd<zzg> zzkdVar = this.zzf;
            if (zzkdVar.zzc()) {
                return;
            }
            this.zzf = zzju.zza(zzkdVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(int i) {
            zzm();
            this.zzf.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 1;
            this.zzg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zzg zzgVar) {
            zzgVar.getClass();
            zzm();
            this.zzf.set(i, zzgVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zze |= 4;
            this.zzi = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(long j) {
            this.zze |= 2;
            this.zzh = j;
        }

        public final boolean zzi() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzk() {
            return (this.zze & 2) != 0;
        }
    }

    public static final class zzf extends zzju<zzf, zza> implements zzlj {
        private static final zzf zzc;
        private static volatile zzlq<zzf> zzd;
        private int zze;
        private String zzf = "";
        private long zzg;

        public static zza zza() {
            return zzc.zzbz();
        }

        public static final class zza extends zzju.zza<zzf, zza> implements zzlj {
            public final zza zza(long j) {
                zzak();
                ((zzf) this.zza).zza(j);
                return this;
            }

            public final zza zza(String str) {
                zzak();
                ((zzf) this.zza).zza(str);
                return this;
            }

            private zza() {
                super(zzf.zzc);
            }

            /* synthetic */ zza(zzfu zzfuVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zze |= 2;
            this.zzg = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 1;
            this.zzf = str;
        }
    }

    public static final class zzg extends zzju<zzg, zza> implements zzlj {
        private static final zzg zzc;
        private static volatile zzlq<zzg> zzd;
        private int zze;
        private long zzh;
        private float zzi;
        private double zzj;
        private String zzf = "";
        private String zzg = "";
        private zzkd<zzg> zzk = zzju.zzce();

        public static final class zza extends zzju.zza<zzg, zza> implements zzlj {
            public final int zza() {
                return ((zzg) this.zza).zzc();
            }

            public final zza zza(Iterable<? extends zzg> iterable) {
                zzak();
                ((zzg) this.zza).zza(iterable);
                return this;
            }

            public final zza zza(zza zzaVar) {
                zzak();
                ((zzg) this.zza).zze((zzg) ((zzju) zzaVar.zzah()));
                return this;
            }

            public final zza zzb() {
                zzak();
                ((zzg) this.zza).zzo();
                return this;
            }

            public final zza zzc() {
                zzak();
                ((zzg) this.zza).zzp();
                return this;
            }

            public final zza zzd() {
                zzak();
                ((zzg) this.zza).zzq();
                return this;
            }

            public final zza zze() {
                zzak();
                ((zzg) this.zza).zzr();
                return this;
            }

            public final zza zza(double d) {
                zzak();
                ((zzg) this.zza).zza(d);
                return this;
            }

            public final zza zza(long j) {
                zzak();
                ((zzg) this.zza).zza(j);
                return this;
            }

            public final zza zza(String str) {
                zzak();
                ((zzg) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzak();
                ((zzg) this.zza).zzb(str);
                return this;
            }

            public final String zzf() {
                return ((zzg) this.zza).zzg();
            }

            public final String zzg() {
                return ((zzg) this.zza).zzh();
            }

            private zza() {
                super(zzg.zzc);
            }

            /* synthetic */ zza(zzfu zzfuVar) {
                this();
            }
        }

        public final double zza() {
            return this.zzj;
        }

        public final float zzb() {
            return this.zzi;
        }

        public final int zzc() {
            return this.zzk.size();
        }

        public final long zzd() {
            return this.zzh;
        }

        public static zza zze() {
            return zzc.zzbz();
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzg.class});
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

        public final String zzg() {
            return this.zzf;
        }

        public final String zzh() {
            return this.zzg;
        }

        public final List<zzg> zzi() {
            return this.zzk;
        }

        static {
            zzg zzgVar = new zzg();
            zzc = zzgVar;
            zzju.zza((Class<zzg>) zzg.class, zzgVar);
        }

        private zzg() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zzg> iterable) {
            zzs();
            zzhy.zza(iterable, this.zzk);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(zzg zzgVar) {
            zzgVar.getClass();
            zzs();
            this.zzk.add(zzgVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo() {
            this.zze &= -17;
            this.zzj = 0.0d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp() {
            this.zze &= -5;
            this.zzh = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzq() {
            this.zzk = zzju.zzce();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzr() {
            this.zze &= -3;
            this.zzg = zzc.zzg;
        }

        private final void zzs() {
            zzkd<zzg> zzkdVar = this.zzk;
            if (zzkdVar.zzc()) {
                return;
            }
            this.zzk = zzju.zza(zzkdVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(double d) {
            this.zze |= 16;
            this.zzj = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zze |= 4;
            this.zzh = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 1;
            this.zzf = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zze |= 2;
            this.zzg = str;
        }

        public final boolean zzj() {
            return (this.zze & 16) != 0;
        }

        public final boolean zzk() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzl() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzm() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzn() {
            return (this.zze & 2) != 0;
        }
    }

    public static final class zzh extends zzju<zzh, zza> implements zzlj {
        private static final zzh zzc;
        private static volatile zzlq<zzh> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";
        private zza zzh;

        public static final class zza extends zzju.zza<zzh, zza> implements zzlj {
            private zza() {
                super(zzh.zzc);
            }

            /* synthetic */ zza(zzfu zzfuVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
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

        static {
            zzh zzhVar = new zzh();
            zzc = zzhVar;
            zzju.zza((Class<zzh>) zzh.class, zzhVar);
        }

        private zzh() {
        }
    }

    public static final class zzi extends zzju<zzi, zza> implements zzlj {
        private static final zzi zzc;
        private static volatile zzlq<zzi> zzd;
        private int zze;
        private zzkd<zzj> zzf = zzju.zzce();
        private String zzg = "";
        private String zzh = "";
        private int zzi;

        public static final class zza extends zzju.zza<zzi, zza> implements zzlj {
            public final int zza() {
                return ((zzi) this.zza).zza();
            }

            public final zza zza(zzj.zza zzaVar) {
                zzak();
                ((zzi) this.zza).zza((zzj) ((zzju) zzaVar.zzah()));
                return this;
            }

            public final zza zza(String str) {
                zzak();
                ((zzi) this.zza).zza(str);
                return this;
            }

            public final zzj zza(int i) {
                return ((zzi) this.zza).zza(0);
            }

            private zza() {
                super(zzi.zzc);
            }

            /* synthetic */ zza(zzfu zzfuVar) {
                this();
            }
        }

        public final int zza() {
            return this.zzf.size();
        }

        public static zza zzb() {
            return zzc.zzbz();
        }

        public enum zzb implements zzjw {
            SDK(0),
            SGTM(1);

            private static final zzjz<zzb> zzc = new zzfx();
            private final int zze;

            @Override // com.google.android.gms.internal.measurement.zzjw
            public final int zza() {
                return this.zze;
            }

            public static zzb zza(int i) {
                if (i == 0) {
                    return SDK;
                }
                if (i != 1) {
                    return null;
                }
                return SGTM;
            }

            public static zzjy zzb() {
                return zzfy.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zze = i;
            }
        }

        public final zzj zza(int i) {
            return this.zzf.get(0);
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zze", "zzf", zzj.class, "zzg", "zzh", "zzi", zzb.zzb()});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zzi> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzi.class) {
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
            return this.zzh;
        }

        public final List<zzj> zze() {
            return this.zzf;
        }

        static {
            zzi zziVar = new zzi();
            zzc = zziVar;
            zzju.zza((Class<zzi>) zzi.class, zziVar);
        }

        private zzi() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzj zzjVar) {
            zzjVar.getClass();
            zzkd<zzj> zzkdVar = this.zzf;
            if (!zzkdVar.zzc()) {
                this.zzf = zzju.zza(zzkdVar);
            }
            this.zzf.add(zzjVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 2;
            this.zzh = str;
        }

        public final boolean zzf() {
            return (this.zze & 2) != 0;
        }
    }

    public static final class zzj extends zzju<zzj, zza> implements zzlj {
        private static final zzj zzc;
        private static volatile zzlq<zzj> zzd;
        private long zzab;
        private int zzac;
        private boolean zzaf;
        private int zzai;
        private int zzaj;
        private int zzak;
        private long zzam;
        private long zzan;
        private int zzaq;
        private zzk zzas;
        private long zzau;
        private long zzav;
        private int zzay;
        private boolean zzaz;
        private boolean zzbb;
        private zzh zzbc;
        private long zzbg;
        private boolean zzbh;
        private boolean zzbj;
        private int zzbl;
        private zzb zzbn;
        private int zzbo;
        private int zze;
        private int zzf;
        private int zzg;
        private long zzj;
        private long zzk;
        private long zzl;
        private long zzm;
        private long zzn;
        private int zzs;
        private long zzw;
        private long zzx;
        private boolean zzz;
        private zzkd<zze> zzh = zzju.zzce();
        private zzkd<zzn> zzi = zzju.zzce();
        private String zzo = "";
        private String zzp = "";
        private String zzq = "";
        private String zzr = "";
        private String zzt = "";
        private String zzu = "";
        private String zzv = "";
        private String zzy = "";
        private String zzaa = "";
        private String zzad = "";
        private String zzae = "";
        private zzkd<zzc> zzag = zzju.zzce();
        private String zzah = "";
        private String zzal = "";
        private String zzao = "";
        private String zzap = "";
        private String zzar = "";
        private zzkb zzat = zzju.zzcc();
        private String zzaw = "";
        private String zzax = "";
        private String zzba = "";
        private String zzbd = "";
        private zzkd<String> zzbe = zzju.zzce();
        private String zzbf = "";
        private String zzbi = "";
        private String zzbk = "";
        private String zzbm = "";

        public static final class zza extends zzju.zza<zzj, zza> implements zzlj {
            public final int zza() {
                return ((zzj) this.zza).zza();
            }

            public final int zzb() {
                return ((zzj) this.zza).zzb();
            }

            public final int zzc() {
                return ((zzj) this.zza).zze();
            }

            public final int zzd() {
                return ((zzj) this.zza).zzi();
            }

            public final long zze() {
                return ((zzj) this.zza).zzm();
            }

            public final long zzf() {
                return ((zzj) this.zza).zzq();
            }

            public final zze zza(int i) {
                return ((zzj) this.zza).zza(i);
            }

            public final zza zza(Iterable<? extends zzc> iterable) {
                zzak();
                ((zzj) this.zza).zza(iterable);
                return this;
            }

            public final zza zzb(Iterable<? extends zze> iterable) {
                zzak();
                ((zzj) this.zza).zzb(iterable);
                return this;
            }

            public final zza zzc(Iterable<? extends Integer> iterable) {
                zzak();
                ((zzj) this.zza).zzc(iterable);
                return this;
            }

            public final zza zzd(Iterable<String> iterable) {
                zzak();
                ((zzj) this.zza).zzd(iterable);
                return this;
            }

            public final zza zze(Iterable<? extends zzn> iterable) {
                zzak();
                ((zzj) this.zza).zze(iterable);
                return this;
            }

            public final zza zza(zze.zza zzaVar) {
                zzak();
                ((zzj) this.zza).zza((zze) ((zzju) zzaVar.zzah()));
                return this;
            }

            public final zza zza(zzn.zza zzaVar) {
                zzak();
                ((zzj) this.zza).zza((zzn) ((zzju) zzaVar.zzah()));
                return this;
            }

            public final zza zza(zzn zznVar) {
                zzak();
                ((zzj) this.zza).zza(zznVar);
                return this;
            }

            public final zza zzg() {
                zzak();
                ((zzj) this.zza).zzck();
                return this;
            }

            public final zza zzh() {
                zzak();
                ((zzj) this.zza).zzcl();
                return this;
            }

            public final zza zzi() {
                zzak();
                ((zzj) this.zza).zzcm();
                return this;
            }

            public final zza zzj() {
                zzak();
                ((zzj) this.zza).zzcn();
                return this;
            }

            public final zza zzk() {
                zzak();
                ((zzj) this.zza).zzco();
                return this;
            }

            public final zza zzl() {
                zzak();
                ((zzj) this.zza).zzcp();
                return this;
            }

            public final zza zzm() {
                zzak();
                ((zzj) this.zza).zzcq();
                return this;
            }

            public final zza zzn() {
                zzak();
                ((zzj) this.zza).zzcr();
                return this;
            }

            public final zza zzo() {
                zzak();
                ((zzj) this.zza).zzcs();
                return this;
            }

            public final zza zzp() {
                zzak();
                ((zzj) this.zza).zzct();
                return this;
            }

            public final zza zzq() {
                zzak();
                ((zzj) this.zza).zzcu();
                return this;
            }

            public final zza zzr() {
                zzak();
                ((zzj) this.zza).zzcv();
                return this;
            }

            public final zza zzs() {
                zzak();
                ((zzj) this.zza).zzcw();
                return this;
            }

            public final zza zzb(int i) {
                zzak();
                ((zzj) this.zza).zzd(i);
                return this;
            }

            public final zza zzc(int i) {
                zzak();
                ((zzj) this.zza).zze(i);
                return this;
            }

            public final zza zzd(int i) {
                zzak();
                ((zzj) this.zza).zzf(i);
                return this;
            }

            public final zza zza(String str) {
                zzak();
                ((zzj) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzak();
                ((zzj) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                zzak();
                ((zzj) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                zzak();
                ((zzj) this.zza).zzd(str);
                return this;
            }

            public final zza zze(String str) {
                zzak();
                ((zzj) this.zza).zze(str);
                return this;
            }

            public final zza zze(int i) {
                zzak();
                ((zzj) this.zza).zzg(i);
                return this;
            }

            public final zza zza(zzb zzbVar) {
                zzak();
                ((zzj) this.zza).zza(zzbVar);
                return this;
            }

            public final zza zzf(int i) {
                zzak();
                ((zzj) this.zza).zzh(i);
                return this;
            }

            public final zza zza(long j) {
                zzak();
                ((zzj) this.zza).zza(j);
                return this;
            }

            public final zza zzb(long j) {
                zzak();
                ((zzj) this.zza).zzb(j);
                return this;
            }

            public final zza zzf(String str) {
                zzak();
                ((zzj) this.zza).zzf(str);
                return this;
            }

            public final zza zzg(String str) {
                zzak();
                ((zzj) this.zza).zzg(str);
                return this;
            }

            public final zza zzh(String str) {
                zzak();
                ((zzj) this.zza).zzh(str);
                return this;
            }

            public final zza zzg(int i) {
                zzak();
                ((zzj) this.zza).zzi(i);
                return this;
            }

            public final zza zzc(long j) {
                zzak();
                ((zzj) this.zza).zzc(j);
                return this;
            }

            public final zza zzi(String str) {
                zzak();
                ((zzj) this.zza).zzi(str);
                return this;
            }

            public final zza zzj(String str) {
                zzak();
                ((zzj) this.zza).zzj((String) null);
                return this;
            }

            public final zza zzd(long j) {
                zzak();
                ((zzj) this.zza).zzd(j);
                return this;
            }

            public final zza zza(boolean z) {
                zzak();
                ((zzj) this.zza).zza(z);
                return this;
            }

            public final zza zze(long j) {
                zzak();
                ((zzj) this.zza).zze(j);
                return this;
            }

            public final zza zzk(String str) {
                zzak();
                ((zzj) this.zza).zzk(str);
                return this;
            }

            public final zza zza(int i, zze.zza zzaVar) {
                zzak();
                ((zzj) this.zza).zza(i, (zze) ((zzju) zzaVar.zzah()));
                return this;
            }

            public final zza zza(int i, zze zzeVar) {
                zzak();
                ((zzj) this.zza).zza(i, zzeVar);
                return this;
            }

            public final zza zzl(String str) {
                zzak();
                ((zzj) this.zza).zzl(str);
                return this;
            }

            public final zza zzm(String str) {
                zzak();
                ((zzj) this.zza).zzm(str);
                return this;
            }

            public final zza zzf(long j) {
                zzak();
                ((zzj) this.zza).zzf(j);
                return this;
            }

            public final zza zzn(String str) {
                zzak();
                ((zzj) this.zza).zzn(str);
                return this;
            }

            public final zza zzb(boolean z) {
                zzak();
                ((zzj) this.zza).zzb(z);
                return this;
            }

            public final zza zzc(boolean z) {
                zzak();
                ((zzj) this.zza).zzc(z);
                return this;
            }

            public final zza zzo(String str) {
                zzak();
                ((zzj) this.zza).zzo(str);
                return this;
            }

            public final zza zzp(String str) {
                zzak();
                ((zzj) this.zza).zzp(str);
                return this;
            }

            public final zza zza(zzk.zzb zzbVar) {
                zzak();
                ((zzj) this.zza).zza((zzk) ((zzju) zzbVar.zzah()));
                return this;
            }

            public final zza zzg(long j) {
                zzak();
                ((zzj) this.zza).zzg(j);
                return this;
            }

            public final zza zzh(long j) {
                zzak();
                ((zzj) this.zza).zzh(j);
                return this;
            }

            public final zza zzh(int i) {
                zzak();
                ((zzj) this.zza).zzj(1);
                return this;
            }

            public final zza zzq(String str) {
                zzak();
                ((zzj) this.zza).zzq(str);
                return this;
            }

            public final zza zzi(int i) {
                zzak();
                ((zzj) this.zza).zzk(i);
                return this;
            }

            public final zza zzd(boolean z) {
                zzak();
                ((zzj) this.zza).zzd(z);
                return this;
            }

            public final zza zzr(String str) {
                zzak();
                ((zzj) this.zza).zzr(str);
                return this;
            }

            public final zza zzi(long j) {
                zzak();
                ((zzj) this.zza).zzi(j);
                return this;
            }

            public final zza zzj(long j) {
                zzak();
                ((zzj) this.zza).zzj(j);
                return this;
            }

            public final zza zzj(int i) {
                zzak();
                ((zzj) this.zza).zzl(i);
                return this;
            }

            public final zza zzk(long j) {
                zzak();
                ((zzj) this.zza).zzk(j);
                return this;
            }

            public final zza zzl(long j) {
                zzak();
                ((zzj) this.zza).zzl(j);
                return this;
            }

            public final zza zza(int i, zzn zznVar) {
                zzak();
                ((zzj) this.zza).zza(i, zznVar);
                return this;
            }

            public final zza zzs(String str) {
                zzak();
                ((zzj) this.zza).zzs(str);
                return this;
            }

            public final zzn zzk(int i) {
                return ((zzj) this.zza).zzb(i);
            }

            public final String zzt() {
                return ((zzj) this.zza).zzy();
            }

            public final String zzu() {
                return ((zzj) this.zza).zzz();
            }

            public final String zzv() {
                return ((zzj) this.zza).zzac();
            }

            public final String zzw() {
                return ((zzj) this.zza).zzae();
            }

            public final String zzx() {
                return ((zzj) this.zza).zzai();
            }

            public final String zzy() {
                return ((zzj) this.zza).zzak();
            }

            public final String zzz() {
                return ((zzj) this.zza).zzam();
            }

            public final List<zze> zzaa() {
                return Collections.unmodifiableList(((zzj) this.zza).zzaq());
            }

            public final List<zzn> zzab() {
                return Collections.unmodifiableList(((zzj) this.zza).zzar());
            }

            private zza() {
                super(zzj.zzc);
            }

            /* synthetic */ zza(zzfu zzfuVar) {
                this();
            }

            public final boolean zzac() {
                return ((zzj) this.zza).zzat();
            }

            public final boolean zzad() {
                return ((zzj) this.zza).zzau();
            }
        }

        public final int zza() {
            return this.zzbl;
        }

        public final int zzb() {
            return this.zzai;
        }

        public final int zzc() {
            return this.zzac;
        }

        public final int zzd() {
            return this.zzbo;
        }

        public final int zze() {
            return this.zzh.size();
        }

        public final int zzf() {
            return this.zzg;
        }

        public final int zzg() {
            return this.zzaq;
        }

        public final int zzh() {
            return this.zzs;
        }

        public final int zzi() {
            return this.zzi.size();
        }

        public final long zzj() {
            return this.zzam;
        }

        public final long zzk() {
            return this.zzab;
        }

        public final long zzl() {
            return this.zzau;
        }

        public final long zzm() {
            return this.zzl;
        }

        public final long zzn() {
            return this.zzw;
        }

        public final long zzo() {
            return this.zzn;
        }

        public final long zzp() {
            return this.zzm;
        }

        public final long zzq() {
            return this.zzk;
        }

        public final long zzr() {
            return this.zzbg;
        }

        public final long zzs() {
            return this.zzj;
        }

        public final long zzt() {
            return this.zzx;
        }

        public final zzb zzu() {
            zzb zzbVar = this.zzbn;
            return zzbVar == null ? zzb.zzc() : zzbVar;
        }

        public final zze zza(int i) {
            return this.zzh.get(i);
        }

        public static zza zzv() {
            return zzc.zzbz();
        }

        public final zzn zzb(int i) {
            return this.zzi.get(i);
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001=\u0000\u0002\u0001M=\u0000\u0005\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5᠌(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.Cဂ/Dဇ0Gဈ1Hဇ2Iဈ3Jင4Kဈ5Lဉ6Mင7", new Object[]{"zze", "zzf", "zzg", "zzh", zze.class, "zzi", zzn.class, "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzm", "zzaf", "zzag", zzc.class, "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzaw", "zzax", "zzay", zzft.zzb(), "zzaz", "zzba", "zzbb", "zzbc", "zzbd", "zzbe", "zzbf", "zzbg", "zzbh", "zzbi", "zzbj", "zzbk", "zzbl", "zzbm", "zzbn", "zzbo"});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zzj> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzj.class) {
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

        public final String zzx() {
            return this.zzar;
        }

        public final String zzy() {
            return this.zzu;
        }

        public final String zzz() {
            return this.zzaa;
        }

        public final String zzaa() {
            return this.zzt;
        }

        public final String zzab() {
            return this.zzv;
        }

        public final String zzac() {
            return this.zzbi;
        }

        public final String zzad() {
            return this.zzax;
        }

        public final String zzae() {
            return this.zzbk;
        }

        public final String zzaf() {
            return this.zzq;
        }

        public final String zzag() {
            return this.zzao;
        }

        public final String zzah() {
            return this.zzah;
        }

        public final String zzai() {
            return this.zzae;
        }

        public final String h_() {
            return this.zzad;
        }

        public final String zzak() {
            return this.zzp;
        }

        public final String zzal() {
            return this.zzo;
        }

        public final String zzam() {
            return this.zzy;
        }

        public final String zzan() {
            return this.zzbd;
        }

        public final String zzao() {
            return this.zzr;
        }

        public final List<zzc> zzap() {
            return this.zzag;
        }

        public final List<zze> zzaq() {
            return this.zzh;
        }

        public final List<zzn> zzar() {
            return this.zzi;
        }

        static {
            zzj zzjVar = new zzj();
            zzc = zzjVar;
            zzju.zza((Class<zzj>) zzj.class, zzjVar);
        }

        private zzj() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zzc> iterable) {
            zzkd<zzc> zzkdVar = this.zzag;
            if (!zzkdVar.zzc()) {
                this.zzag = zzju.zza(zzkdVar);
            }
            zzhy.zza(iterable, this.zzag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(Iterable<? extends zze> iterable) {
            zzcx();
            zzhy.zza(iterable, this.zzh);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(Iterable<? extends Integer> iterable) {
            zzkb zzkbVar = this.zzat;
            if (!zzkbVar.zzc()) {
                int size = zzkbVar.size();
                this.zzat = zzkbVar.zza(size == 0 ? 10 : size << 1);
            }
            zzhy.zza(iterable, this.zzat);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(Iterable<String> iterable) {
            zzkd<String> zzkdVar = this.zzbe;
            if (!zzkdVar.zzc()) {
                this.zzbe = zzju.zza(zzkdVar);
            }
            zzhy.zza(iterable, this.zzbe);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(Iterable<? extends zzn> iterable) {
            zzcy();
            zzhy.zza(iterable, this.zzi);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zze zzeVar) {
            zzeVar.getClass();
            zzcx();
            this.zzh.add(zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzn zznVar) {
            zznVar.getClass();
            zzcy();
            this.zzi.add(zznVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzck() {
            this.zze &= -262145;
            this.zzaa = zzc.zzaa;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcl() {
            this.zzag = zzju.zzce();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcm() {
            this.zze &= -257;
            this.zzq = zzc.zzq;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcn() {
            this.zze &= Integer.MAX_VALUE;
            this.zzao = zzc.zzao;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzco() {
            this.zzh = zzju.zzce();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcp() {
            this.zze &= -2097153;
            this.zzad = zzc.zzad;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcq() {
            this.zze &= -131073;
            this.zzz = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcr() {
            this.zze &= -129;
            this.zzp = zzc.zzp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcs() {
            this.zze &= -33;
            this.zzn = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzct() {
            this.zze &= -17;
            this.zzm = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcu() {
            this.zze &= -65537;
            this.zzy = zzc.zzy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcv() {
            this.zzf &= -8193;
            this.zzbd = zzc.zzbd;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcw() {
            this.zze &= -268435457;
            this.zzal = zzc.zzal;
        }

        private final void zzcx() {
            zzkd<zze> zzkdVar = this.zzh;
            if (zzkdVar.zzc()) {
                return;
            }
            this.zzh = zzju.zza(zzkdVar);
        }

        private final void zzcy() {
            zzkd<zzn> zzkdVar = this.zzi;
            if (zzkdVar.zzc()) {
                return;
            }
            this.zzi = zzju.zza(zzkdVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(int i) {
            zzcx();
            this.zzh.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(int i) {
            zzcy();
            this.zzi.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(int i) {
            this.zzf |= 1048576;
            this.zzbl = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzf |= 4;
            this.zzar = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zze |= 4096;
            this.zzu = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zze |= 262144;
            this.zzaa = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zze |= 2048;
            this.zzt = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zze |= 8192;
            this.zzv = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(int i) {
            this.zze |= 33554432;
            this.zzai = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            zzbVar.getClass();
            this.zzbn = zzbVar;
            this.zzf |= 4194304;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(int i) {
            this.zze |= 1048576;
            this.zzac = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzf |= 32;
            this.zzav = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(long j) {
            this.zze |= 536870912;
            this.zzam = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(String str) {
            str.getClass();
            this.zzf |= 131072;
            this.zzbi = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(String str) {
            str.getClass();
            this.zzf |= 128;
            this.zzax = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(String str) {
            str.getClass();
            this.zzf |= 524288;
            this.zzbk = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(int i) {
            this.zzf |= 8388608;
            this.zzbo = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(long j) {
            this.zze |= 524288;
            this.zzab = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(String str) {
            str.getClass();
            this.zze |= 256;
            this.zzq = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(String str) {
            str.getClass();
            this.zze |= Integer.MIN_VALUE;
            this.zzao = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzf |= 16;
            this.zzau = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzf |= 65536;
            this.zzbh = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(long j) {
            this.zze |= 8;
            this.zzl = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(String str) {
            str.getClass();
            this.zzf |= 16384;
            this.zzbf = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zze zzeVar) {
            zzeVar.getClass();
            zzcx();
            this.zzh.set(i, zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(String str) {
            str.getClass();
            this.zze |= 16777216;
            this.zzah = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm(String str) {
            str.getClass();
            this.zze |= 4194304;
            this.zzae = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(long j) {
            this.zze |= 16384;
            this.zzw = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zze |= 2097152;
            this.zzad = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzf |= 262144;
            this.zzbj = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(boolean z) {
            this.zze |= 131072;
            this.zzz = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo(String str) {
            str.getClass();
            this.zze |= 128;
            this.zzp = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp(String str) {
            str.getClass();
            this.zze |= 64;
            this.zzo = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzk zzkVar) {
            zzkVar.getClass();
            this.zzas = zzkVar;
            this.zzf |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(long j) {
            this.zze |= 32;
            this.zzn = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(long j) {
            this.zze |= 16;
            this.zzm = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(int i) {
            this.zze |= 1;
            this.zzg = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzq(String str) {
            str.getClass();
            this.zze |= 65536;
            this.zzy = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(int i) {
            this.zzf |= 2;
            this.zzaq = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(boolean z) {
            this.zze |= 8388608;
            this.zzaf = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzr(String str) {
            str.getClass();
            this.zzf |= 8192;
            this.zzbd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(long j) {
            this.zze |= 4;
            this.zzk = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(long j) {
            this.zzf |= 32768;
            this.zzbg = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(int i) {
            this.zze |= 1024;
            this.zzs = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(long j) {
            this.zze |= 2;
            this.zzj = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(long j) {
            this.zze |= 32768;
            this.zzx = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zzn zznVar) {
            zznVar.getClass();
            zzcy();
            this.zzi.set(i, zznVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzs(String str) {
            str.getClass();
            this.zze |= 512;
            this.zzr = str;
        }

        public final boolean zzas() {
            return this.zzbh;
        }

        public final boolean zzat() {
            return this.zzbj;
        }

        public final boolean zzau() {
            return this.zzz;
        }

        public final boolean zzav() {
            return this.zzaf;
        }

        public final boolean zzaw() {
            return (this.zze & 33554432) != 0;
        }

        public final boolean zzax() {
            return (this.zzf & 4194304) != 0;
        }

        public final boolean zzay() {
            return (this.zze & 1048576) != 0;
        }

        public final boolean zzaz() {
            return (this.zze & 536870912) != 0;
        }

        public final boolean zzba() {
            return (this.zzf & 131072) != 0;
        }

        public final boolean zzbb() {
            return (this.zzf & 128) != 0;
        }

        public final boolean zzbc() {
            return (this.zzf & 524288) != 0;
        }

        public final boolean zzbd() {
            return (this.zzf & 8388608) != 0;
        }

        public final boolean zzbe() {
            return (this.zze & 524288) != 0;
        }

        public final boolean zzbf() {
            return (this.zzf & 16) != 0;
        }

        public final boolean zzbg() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzbh() {
            return (this.zze & 16384) != 0;
        }

        public final boolean zzbi() {
            return (this.zzf & 262144) != 0;
        }

        public final boolean zzbj() {
            return (this.zze & 131072) != 0;
        }

        public final boolean zzbk() {
            return (this.zze & 32) != 0;
        }

        public final boolean zzbl() {
            return (this.zze & 16) != 0;
        }

        public final boolean zzbm() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzbn() {
            return (this.zzf & 2) != 0;
        }

        public final boolean zzbo() {
            return (this.zze & 8388608) != 0;
        }

        public final boolean zzbp() {
            return (this.zzf & 8192) != 0;
        }

        public final boolean zzbq() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzbr() {
            return (this.zzf & 32768) != 0;
        }

        public final boolean zzbs() {
            return (this.zze & 1024) != 0;
        }

        public final boolean zzbt() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzbu() {
            return (this.zze & 32768) != 0;
        }
    }

    public static final class zzk extends zzju<zzk, zzb> implements zzlj {
        private static final zzk zzc;
        private static volatile zzlq<zzk> zzd;
        private int zze;
        private int zzf = 1;
        private zzkd<zzf> zzg = zzju.zzce();

        public static zzb zza() {
            return zzc.zzbz();
        }

        public enum zza implements zzjw {
            RADS(1),
            PROVISIONING(2);

            private static final zzjz<zza> zzc = new zzga();
            private final int zze;

            @Override // com.google.android.gms.internal.measurement.zzjw
            public final int zza() {
                return this.zze;
            }

            public static zza zza(int i) {
                if (i == 1) {
                    return RADS;
                }
                if (i != 2) {
                    return null;
                }
                return PROVISIONING;
            }

            public static zzjy zzb() {
                return zzfz.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zze = i;
            }
        }

        public static final class zzb extends zzju.zza<zzk, zzb> implements zzlj {
            public final zzb zza(zzf.zza zzaVar) {
                zzak();
                ((zzk) this.zza).zza((zzf) ((zzju) zzaVar.zzah()));
                return this;
            }

            private zzb() {
                super(zzk.zzc);
            }

            /* synthetic */ zzb(zzfu zzfuVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zzb(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zze", "zzf", zza.zzb(), "zzg", zzf.class});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zzk> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzk.class) {
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
            zzk zzkVar = new zzk();
            zzc = zzkVar;
            zzju.zza((Class<zzk>) zzk.class, zzkVar);
        }

        private zzk() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzf zzfVar) {
            zzfVar.getClass();
            zzkd<zzf> zzkdVar = this.zzg;
            if (!zzkdVar.zzc()) {
                this.zzg = zzju.zza(zzkdVar);
            }
            this.zzg.add(zzfVar);
        }
    }

    public static final class zzl extends zzju<zzl, zza> implements zzlj {
        private static final zzl zzc;
        private static volatile zzlq<zzl> zzd;
        private zzka zze = zzju.zzcd();
        private zzka zzf = zzju.zzcd();
        private zzkd<zzd> zzg = zzju.zzce();
        private zzkd<zzm> zzh = zzju.zzce();

        public final int zza() {
            return this.zzg.size();
        }

        public final int zzb() {
            return this.zzf.size();
        }

        public static final class zza extends zzju.zza<zzl, zza> implements zzlj {
            public final zza zza(Iterable<? extends zzd> iterable) {
                zzak();
                ((zzl) this.zza).zza(iterable);
                return this;
            }

            public final zza zzb(Iterable<? extends Long> iterable) {
                zzak();
                ((zzl) this.zza).zzb(iterable);
                return this;
            }

            public final zza zzc(Iterable<? extends zzm> iterable) {
                zzak();
                ((zzl) this.zza).zzc(iterable);
                return this;
            }

            public final zza zzd(Iterable<? extends Long> iterable) {
                zzak();
                ((zzl) this.zza).zzd(iterable);
                return this;
            }

            public final zza zza() {
                zzak();
                ((zzl) this.zza).zzl();
                return this;
            }

            public final zza zzb() {
                zzak();
                ((zzl) this.zza).zzm();
                return this;
            }

            public final zza zzc() {
                zzak();
                ((zzl) this.zza).zzn();
                return this;
            }

            public final zza zzd() {
                zzak();
                ((zzl) this.zza).zzo();
                return this;
            }

            private zza() {
                super(zzl.zzc);
            }

            /* synthetic */ zza(zzfu zzfuVar) {
                this();
            }
        }

        public final int zzc() {
            return this.zzh.size();
        }

        public final int zzd() {
            return this.zze.size();
        }

        public static zza zze() {
            return zzc.zzbz();
        }

        public static zzl zzg() {
            return zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zze", "zzf", "zzg", zzd.class, "zzh", zzm.class});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zzl> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzl.class) {
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

        public final List<zzd> zzh() {
            return this.zzg;
        }

        public final List<Long> zzi() {
            return this.zzf;
        }

        public final List<zzm> zzj() {
            return this.zzh;
        }

        public final List<Long> zzk() {
            return this.zze;
        }

        static {
            zzl zzlVar = new zzl();
            zzc = zzlVar;
            zzju.zza((Class<zzl>) zzl.class, zzlVar);
        }

        private zzl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zzd> iterable) {
            zzkd<zzd> zzkdVar = this.zzg;
            if (!zzkdVar.zzc()) {
                this.zzg = zzju.zza(zzkdVar);
            }
            zzhy.zza(iterable, this.zzg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(Iterable<? extends Long> iterable) {
            zzka zzkaVar = this.zzf;
            if (!zzkaVar.zzc()) {
                this.zzf = zzju.zza(zzkaVar);
            }
            zzhy.zza(iterable, this.zzf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(Iterable<? extends zzm> iterable) {
            zzkd<zzm> zzkdVar = this.zzh;
            if (!zzkdVar.zzc()) {
                this.zzh = zzju.zza(zzkdVar);
            }
            zzhy.zza(iterable, this.zzh);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(Iterable<? extends Long> iterable) {
            zzka zzkaVar = this.zze;
            if (!zzkaVar.zzc()) {
                this.zze = zzju.zza(zzkaVar);
            }
            zzhy.zza(iterable, this.zze);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl() {
            this.zzg = zzju.zzce();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm() {
            this.zzf = zzju.zzcd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn() {
            this.zzh = zzju.zzce();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo() {
            this.zze = zzju.zzcd();
        }
    }

    public static final class zzm extends zzju<zzm, zza> implements zzlj {
        private static final zzm zzc;
        private static volatile zzlq<zzm> zzd;
        private int zze;
        private int zzf;
        private zzka zzg = zzju.zzcd();

        public final int zza() {
            return this.zzg.size();
        }

        public final int zzb() {
            return this.zzf;
        }

        public static final class zza extends zzju.zza<zzm, zza> implements zzlj {
            public final zza zza(Iterable<? extends Long> iterable) {
                zzak();
                ((zzm) this.zza).zza(iterable);
                return this;
            }

            public final zza zza(int i) {
                zzak();
                ((zzm) this.zza).zzb(i);
                return this;
            }

            private zza() {
                super(zzm.zzc);
            }

            /* synthetic */ zza(zzfu zzfuVar) {
                this();
            }
        }

        public final long zza(int i) {
            return this.zzg.zzb(i);
        }

        public static zza zzc() {
            return zzc.zzbz();
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zzm> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzm.class) {
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

        public final List<Long> zze() {
            return this.zzg;
        }

        static {
            zzm zzmVar = new zzm();
            zzc = zzmVar;
            zzju.zza((Class<zzm>) zzm.class, zzmVar);
        }

        private zzm() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            zzka zzkaVar = this.zzg;
            if (!zzkaVar.zzc()) {
                this.zzg = zzju.zza(zzkaVar);
            }
            zzhy.zza(iterable, this.zzg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(int i) {
            this.zze |= 1;
            this.zzf = i;
        }

        public final boolean zzf() {
            return (this.zze & 1) != 0;
        }
    }

    public static final class zzn extends zzju<zzn, zza> implements zzlj {
        private static final zzn zzc;
        private static volatile zzlq<zzn> zzd;
        private int zze;
        private long zzf;
        private String zzg = "";
        private String zzh = "";
        private long zzi;
        private float zzj;
        private double zzk;

        public final double zza() {
            return this.zzk;
        }

        public final float zzb() {
            return this.zzj;
        }

        public static final class zza extends zzju.zza<zzn, zza> implements zzlj {
            public final zza zza() {
                zzak();
                ((zzn) this.zza).zzn();
                return this;
            }

            public final zza zzb() {
                zzak();
                ((zzn) this.zza).zzo();
                return this;
            }

            public final zza zzc() {
                zzak();
                ((zzn) this.zza).zzp();
                return this;
            }

            public final zza zza(double d) {
                zzak();
                ((zzn) this.zza).zza(d);
                return this;
            }

            public final zza zza(long j) {
                zzak();
                ((zzn) this.zza).zza(j);
                return this;
            }

            public final zza zza(String str) {
                zzak();
                ((zzn) this.zza).zza(str);
                return this;
            }

            public final zza zzb(long j) {
                zzak();
                ((zzn) this.zza).zzb(j);
                return this;
            }

            public final zza zzb(String str) {
                zzak();
                ((zzn) this.zza).zzb(str);
                return this;
            }

            private zza() {
                super(zzn.zzc);
            }

            /* synthetic */ zza(zzfu zzfuVar) {
                this();
            }
        }

        public final long zzc() {
            return this.zzi;
        }

        public final long zzd() {
            return this.zzf;
        }

        public static zza zze() {
            return zzc.zzbz();
        }

        @Override // com.google.android.gms.internal.measurement.zzju
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfu zzfuVar = null;
            switch (zzfu.zza[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(zzfuVar);
                case 3:
                    return zzju.zza(zzc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzc;
                case 5:
                    zzlq<zzn> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzn.class) {
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

        public final String zzg() {
            return this.zzg;
        }

        public final String zzh() {
            return this.zzh;
        }

        static {
            zzn zznVar = new zzn();
            zzc = zznVar;
            zzju.zza((Class<zzn>) zzn.class, zznVar);
        }

        private zzn() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn() {
            this.zze &= -33;
            this.zzk = 0.0d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo() {
            this.zze &= -9;
            this.zzi = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp() {
            this.zze &= -5;
            this.zzh = zzc.zzh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(double d) {
            this.zze |= 32;
            this.zzk = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zze |= 8;
            this.zzi = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 2;
            this.zzg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(long j) {
            this.zze |= 1;
            this.zzf = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zze |= 4;
            this.zzh = str;
        }

        public final boolean zzi() {
            return (this.zze & 32) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 16) != 0;
        }

        public final boolean zzk() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzl() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzm() {
            return (this.zze & 4) != 0;
        }
    }
}
