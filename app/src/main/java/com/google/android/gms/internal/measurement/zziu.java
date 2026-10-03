package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes4.dex */
class zziu extends zzis {
    protected final byte[] zzb;

    @Override // com.google.android.gms.internal.measurement.zzih
    public byte zza(int i) {
        return this.zzb[i];
    }

    protected int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    protected final int zzb(int i, int i2, int i3) {
        return zzjx.zza(i, this.zzb, zze(), i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public final zzih zza(int i, int i2) {
        int iZza = zzih.zza(0, i2, zzb());
        if (iZza == 0) {
            return zzih.zza;
        }
        return new zzil(this.zzb, zze(), iZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    protected final String zza(Charset charset) {
        return new String(this.zzb, zze(), zzb(), charset);
    }

    zziu(byte[] bArr) {
        super();
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final void zza(zzii zziiVar) throws IOException {
        zziiVar.zza(this.zzb, zze(), zzb());
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzih) || zzb() != ((zzih) obj).zzb()) {
            return false;
        }
        if (zzb() == 0) {
            return true;
        }
        if (obj instanceof zziu) {
            zziu zziuVar = (zziu) obj;
            int iZza = zza();
            int iZza2 = zziuVar.zza();
            if (iZza == 0 || iZza2 == 0 || iZza == iZza2) {
                return zza(zziuVar, 0, zzb());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzis
    final boolean zza(zzih zzihVar, int i, int i2) {
        if (i2 > zzihVar.zzb()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzb());
        }
        if (i2 > zzihVar.zzb()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + zzihVar.zzb());
        }
        if (zzihVar instanceof zziu) {
            zziu zziuVar = (zziu) zzihVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zziuVar.zzb;
            int iZze = zze();
            int iZze2 = zze();
            int iZze3 = zziuVar.zze();
            while (iZze2 < iZze + i2) {
                if (bArr[iZze2] != bArr2[iZze3]) {
                    return false;
                }
                iZze2++;
                iZze3++;
            }
            return true;
        }
        return zzihVar.zza(0, i2).equals(zza(0, i2));
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public final boolean zzd() {
        int iZze = zze();
        return zzne.zzc(this.zzb, iZze, zzb() + iZze);
    }
}
