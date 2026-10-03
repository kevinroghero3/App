package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzih implements Serializable, Iterable<Byte> {
    public static final zzih zza = new zziu(zzjx.zzb);
    private static final zzio zzb = new zzit();
    private static final Comparator<zzih> zzc = new zzij();
    private int zzd = 0;

    static /* synthetic */ int zza(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i);

    public abstract zzih zza(int i, int i2);

    protected abstract String zza(Charset charset);

    abstract void zza(zzii zziiVar) throws IOException;

    abstract byte zzb(int i);

    public abstract int zzb();

    protected abstract int zzb(int i, int i2, int i3);

    public abstract boolean zzd();

    static int zza(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    public final int hashCode() {
        int iZzb = this.zzd;
        if (iZzb == 0) {
            int iZzb2 = zzb();
            iZzb = zzb(iZzb2, 0, iZzb2);
            if (iZzb == 0) {
                iZzb = 1;
            }
            this.zzd = iZzb;
        }
        return iZzb;
    }

    protected final int zza() {
        return this.zzd;
    }

    static zziq zzc(int i) {
        return new zziq(i);
    }

    public static zzih zza(byte[] bArr, int i, int i2) {
        zza(i, i + i2, bArr.length);
        return new zziu(zzb.zza(bArr, i, i2));
    }

    public static zzih zza(String str) {
        return new zziu(str.getBytes(zzjx.zza));
    }

    static zzih zza(byte[] bArr) {
        return new zziu(bArr);
    }

    public final String toString() {
        String strZza;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iZzb = zzb();
        if (zzb() <= 50) {
            strZza = zzmq.zza(this);
        } else {
            strZza = zzmq.zza(zza(0, 47)) + "...";
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", hexString, Integer.valueOf(iZzb), strZza);
    }

    public final String zzc() {
        return zzb() == 0 ? "" : zza(zzjx.zza);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzik(this);
    }

    zzih() {
    }
}
