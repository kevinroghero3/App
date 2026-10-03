package com.google.android.gms.internal.fido;

import ch.qos.logback.core.CoreConstants;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes4.dex */
public final class zzaj {
    private final String zza;
    private final zzah zzb;
    private zzah zzc;

    /* synthetic */ zzaj(String str, zzai zzaiVar) {
        zzah zzahVar = new zzah(null);
        this.zzb = zzahVar;
        this.zzc = zzahVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append(CoreConstants.CURLY_LEFT);
        zzah zzahVar = this.zzb.zzc;
        String str = "";
        while (zzahVar != null) {
            Object obj = zzahVar.zzb;
            boolean z = zzahVar instanceof zzaf;
            sb.append(str);
            String str2 = zzahVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            zzahVar = zzahVar.zzc;
            str = ", ";
        }
        sb.append(CoreConstants.CURLY_RIGHT);
        return sb.toString();
    }

    public final zzaj zza(String str, int i) {
        zzaf zzafVar = new zzaf(null);
        this.zzc.zzc = zzafVar;
        this.zzc = zzafVar;
        zzafVar.zzb = String.valueOf(i);
        zzafVar.zza = "errorCode";
        return this;
    }

    public final zzaj zzb(String str, @CheckForNull Object obj) {
        zzah zzahVar = new zzah(null);
        this.zzc.zzc = zzahVar;
        this.zzc = zzahVar;
        zzahVar.zzb = obj;
        zzahVar.zza = str;
        return this;
    }
}
