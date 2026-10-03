package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzjb extends zzii {
    private static final Logger zzb = Logger.getLogger(zzjb.class.getName());
    private static final boolean zzc = zzna.zzc();
    zzjd zza;

    static final class zzb extends zzjb {
        private final byte[] zzb;
        private final int zzc;
        private final int zzd;
        private int zze;

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final int zza() {
            return this.zzd - this.zze;
        }

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i2) | i2) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.zzb = bArr;
            this.zzc = 0;
            this.zze = 0;
            this.zzd = i2;
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zza(byte b) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                this.zze = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
            }
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zze, i2);
                this.zze += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzb(int i, boolean z) throws IOException {
            zzj(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzk(i2);
            zzc(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzc(int i, zzih zzihVar) throws IOException {
            zzj(i, 2);
            zzb(zzihVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzb(zzih zzihVar) throws IOException {
            zzk(zzihVar.zzb());
            zzihVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzg(int i, int i2) throws IOException {
            zzj(i, 5);
            zzh(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzh(int i) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i2 = this.zze;
                bArr[i2] = (byte) i;
                bArr[i2 + 1] = (byte) (i >> 8);
                bArr[i2 + 2] = (byte) (i >> 16);
                this.zze = i2 + 4;
                bArr[i2 + 3] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzf(int i, long j) throws IOException {
            zzj(i, 1);
            zzf(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzf(long j) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                bArr[i] = (byte) j;
                bArr[i + 1] = (byte) (j >> 8);
                bArr[i + 2] = (byte) (j >> 16);
                bArr[i + 3] = (byte) (j >> 24);
                bArr[i + 4] = (byte) (j >> 32);
                bArr[i + 5] = (byte) (j >> 40);
                bArr[i + 6] = (byte) (j >> 48);
                this.zze = i + 8;
                bArr[i + 7] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzh(int i, int i2) throws IOException {
            zzj(i, 0);
            zzi(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzi(int i) throws IOException {
            if (i >= 0) {
                zzk(i);
            } else {
                zzh(i);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzii
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        final void zzc(int i, zzlh zzlhVar, zzlz zzlzVar) throws IOException {
            zzj(i, 2);
            zzk(((zzhy) zzlhVar).zza(zzlzVar));
            zzlzVar.zza(zzlhVar, this.zza);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzc(zzlh zzlhVar) throws IOException {
            zzk(zzlhVar.zzby());
            zzlhVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzb(int i, zzlh zzlhVar) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzj(3, 2);
            zzc(zzlhVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzd(int i, zzih zzihVar) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzc(3, zzihVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzb(int i, String str) throws IOException {
            zzj(i, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzb(String str) throws IOException {
            int i = this.zze;
            try {
                int iZzg = zzjb.zzg(str.length() * 3);
                int iZzg2 = zzjb.zzg(str.length());
                if (iZzg2 == iZzg) {
                    int i2 = i + iZzg2;
                    this.zze = i2;
                    int iZza = zzne.zza(str, this.zzb, i2, zza());
                    this.zze = i;
                    zzk((iZza - i) - iZzg2);
                    this.zze = iZza;
                    return;
                }
                zzk(zzne.zza(str));
                this.zze = zzne.zza(str, this.zzb, this.zze, zza());
            } catch (zzni e) {
                this.zze = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzj(int i, int i2) throws IOException {
            zzk((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzk(int i, int i2) throws IOException {
            zzj(i, 0);
            zzk(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzk(int i) throws IOException {
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i2 = this.zze;
                    this.zze = i2 + 1;
                    bArr[i2] = (byte) (i | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
                }
            }
            byte[] bArr2 = this.zzb;
            int i3 = this.zze;
            this.zze = i3 + 1;
            bArr2[i3] = (byte) i;
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzh(int i, long j) throws IOException {
            zzj(i, 0);
            zzh(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzjb
        public final void zzh(long j) throws IOException {
            if (zzjb.zzc && zza() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i = this.zze;
                    this.zze = i + 1;
                    zzna.zza(bArr, i, (byte) (((int) j) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i2 = this.zze;
                this.zze = i2 + 1;
                zzna.zza(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.zzb;
                    int i3 = this.zze;
                    this.zze = i3 + 1;
                    bArr3[i3] = (byte) (((int) j) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
                }
            }
            byte[] bArr4 = this.zzb;
            int i4 = this.zze;
            this.zze = i4 + 1;
            bArr4[i4] = (byte) j;
        }
    }

    public static int zza(double d) {
        return 8;
    }

    public static int zza(float f) {
        return 4;
    }

    public static int zza(long j) {
        return 8;
    }

    public static int zza(boolean z) {
        return 1;
    }

    public static int zzb(int i) {
        return 4;
    }

    public static int zzc(long j) {
        return 8;
    }

    public static int zzd(int i) {
        return 4;
    }

    private static long zzi(long j) {
        return (j << 1) ^ (j >> 63);
    }

    private static int zzl(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public abstract int zza();

    public abstract void zza(byte b) throws IOException;

    public abstract void zzb(int i, zzlh zzlhVar) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzih zzihVar) throws IOException;

    public abstract void zzb(String str) throws IOException;

    abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc(int i, zzih zzihVar) throws IOException;

    abstract void zzc(int i, zzlh zzlhVar, zzlz zzlzVar) throws IOException;

    public abstract void zzc(zzlh zzlhVar) throws IOException;

    public abstract void zzd(int i, zzih zzihVar) throws IOException;

    public abstract void zzf(int i, long j) throws IOException;

    public abstract void zzf(long j) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract void zzh(int i) throws IOException;

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzh(long j) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzk(int i, int i2) throws IOException;

    public static final class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        public zza(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    public static int zza(int i, boolean z) {
        return zzg(i << 3) + 1;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzg(length) + length;
    }

    public static int zza(int i, zzih zzihVar) {
        int iZzg = zzg(i << 3);
        int iZzb = zzihVar.zzb();
        return iZzg + zzg(iZzb) + iZzb;
    }

    public static int zza(zzih zzihVar) {
        int iZzb = zzihVar.zzb();
        return zzg(iZzb) + iZzb;
    }

    public static int zza(int i, double d) {
        return zzg(i << 3) + 8;
    }

    public static int zza(int i, int i2) {
        return zzg(i << 3) + zze(i2);
    }

    public static int zza(int i) {
        return zze(i);
    }

    public static int zzb(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    public static int zza(int i, long j) {
        return zzg(i << 3) + 8;
    }

    public static int zza(int i, float f) {
        return zzg(i << 3) + 4;
    }

    @Deprecated
    static int zza(int i, zzlh zzlhVar, zzlz zzlzVar) {
        return (zzg(i << 3) << 1) + ((zzhy) zzlhVar).zza(zzlzVar);
    }

    @Deprecated
    public static int zza(zzlh zzlhVar) {
        return zzlhVar.zzby();
    }

    public static int zzc(int i, int i2) {
        return zzg(i << 3) + zze(i2);
    }

    public static int zzc(int i) {
        return zze(i);
    }

    public static int zzb(int i, long j) {
        return zzg(i << 3) + zze(j);
    }

    public static int zzb(long j) {
        return zze(j);
    }

    public static int zza(int i, zzkl zzklVar) {
        return (zzg(8) << 1) + zzf(2, i) + zzb(3, zzklVar);
    }

    public static int zzb(int i, zzkl zzklVar) {
        int iZzg = zzg(i << 3);
        int iZzb = zzklVar.zzb();
        return iZzg + zzg(iZzb) + iZzb;
    }

    public static int zza(zzkl zzklVar) {
        int iZzb = zzklVar.zzb();
        return zzg(iZzb) + iZzb;
    }

    public static int zza(int i, zzlh zzlhVar) {
        int iZzg = zzg(8);
        return (iZzg << 1) + zzf(2, i) + zzg(24) + zzb(zzlhVar);
    }

    static int zzb(int i, zzlh zzlhVar, zzlz zzlzVar) {
        return zzg(i << 3) + zza(zzlhVar, zzlzVar);
    }

    public static int zzb(zzlh zzlhVar) {
        int iZzby = zzlhVar.zzby();
        return zzg(iZzby) + iZzby;
    }

    static int zza(zzlh zzlhVar, zzlz zzlzVar) {
        int iZza = ((zzhy) zzlhVar).zza(zzlzVar);
        return zzg(iZza) + iZza;
    }

    public static int zzb(int i, zzih zzihVar) {
        return (zzg(8) << 1) + zzf(2, i) + zza(3, zzihVar);
    }

    public static int zzd(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    public static int zzc(int i, long j) {
        return zzg(i << 3) + 8;
    }

    public static int zze(int i, int i2) {
        return zzg(i << 3) + zzg(zzl(i2));
    }

    public static int zze(int i) {
        return zzg(zzl(i));
    }

    public static int zzd(int i, long j) {
        return zzg(i << 3) + zze(zzi(j));
    }

    public static int zzd(long j) {
        return zze(zzi(j));
    }

    public static int zza(int i, String str) {
        return zzg(i << 3) + zza(str);
    }

    public static int zza(String str) {
        int length;
        try {
            length = zzne.zza(str);
        } catch (zzni unused) {
            length = str.getBytes(zzjx.zza).length;
        }
        return zzg(length) + length;
    }

    public static int zzf(int i) {
        return zzg(i << 3);
    }

    public static int zzf(int i, int i2) {
        return zzg(i << 3) + zzg(i2);
    }

    public static int zzg(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zze(int i, long j) {
        return zzg(i << 3) + zze(j);
    }

    public static int zze(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static zzjb zzb(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    private zzjb() {
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zza(String str, zzni zzniVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzniVar);
        byte[] bytes = str.getBytes(zzjx.zza);
        try {
            zzk(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zza(e);
        }
    }

    public final void zzb(boolean z) throws IOException {
        zza(z ? (byte) 1 : (byte) 0);
    }

    public final void zzb(int i, double d) throws IOException {
        zzf(i, Double.doubleToRawLongBits(d));
    }

    public final void zzb(double d) throws IOException {
        zzf(Double.doubleToRawLongBits(d));
    }

    public final void zzb(int i, float f) throws IOException {
        zzg(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(float f) throws IOException {
        zzh(Float.floatToRawIntBits(f));
    }

    public final void zzi(int i, int i2) throws IOException {
        zzk(i, zzl(i2));
    }

    public final void zzj(int i) throws IOException {
        zzk(zzl(i));
    }

    public final void zzg(int i, long j) throws IOException {
        zzh(i, zzi(j));
    }

    public final void zzg(long j) throws IOException {
        zzh(zzi(j));
    }
}
