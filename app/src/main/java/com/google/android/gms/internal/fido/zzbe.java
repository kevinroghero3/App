package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes4.dex */
class zzbe extends zzbf {
    final zzbb zzb;

    @CheckForNull
    final Character zzc;

    zzbe(zzbb zzbbVar, @CheckForNull Character ch2) {
        this.zzb = zzbbVar;
        if (ch2 != null && zzbbVar.zzb('=')) {
            throw new IllegalArgumentException(zzan.zza("Padding character %s was already in alphabet", ch2));
        }
        this.zzc = ch2;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof zzbe)) {
            return false;
        }
        zzbe zzbeVar = (zzbe) obj;
        if (!this.zzb.equals(zzbeVar.zzb)) {
            return false;
        }
        Character ch2 = this.zzc;
        Character ch3 = zzbeVar.zzc;
        if (ch2 != ch3) {
            return ch2 != null && ch2.equals(ch3);
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode();
        Character ch2 = this.zzc;
        return iHashCode ^ (ch2 == null ? 0 : ch2.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.fido.zzbf
    void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzam.zze(0, i2, bArr.length);
        while (i3 < i2) {
            zzc(appendable, bArr, i3, Math.min(this.zzb.zzd, i2 - i3));
            i3 += this.zzb.zzd;
        }
    }

    @Override // com.google.android.gms.internal.fido.zzbf
    final int zzb(int i) {
        zzbb zzbbVar = this.zzb;
        return zzbbVar.zzc * zzbh.zza(i, zzbbVar.zzd, RoundingMode.CEILING);
    }

    final void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzam.zze(i, i + i2, bArr.length);
        int i3 = 0;
        zzam.zzc(i2 <= this.zzb.zzd);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | ((long) (bArr[i + i4] & 255))) << 8;
        }
        int i5 = this.zzb.zzb;
        while (i3 < i2 * 8) {
            zzbb zzbbVar = this.zzb;
            appendable.append(zzbbVar.zza(zzbbVar.zza & ((int) (j >>> ((((i2 + 1) * 8) - i5) - i3)))));
            i3 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i3 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append('=');
                i3 += this.zzb.zzb;
            }
        }
    }

    zzbe(String str, String str2, @CheckForNull Character ch2) {
        this(new zzbb(str, str2.toCharArray()), ch2);
    }
}
