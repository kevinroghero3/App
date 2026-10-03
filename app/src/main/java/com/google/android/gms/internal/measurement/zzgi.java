package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class zzgi implements zzgj {
    private final AtomicBoolean zza = new AtomicBoolean();
    private HashMap<String, String> zzb = null;
    private final HashMap<String, Boolean> zzc = new HashMap<>(16, 1.0f);
    private final HashMap<String, Integer> zzd = new HashMap<>(16, 1.0f);
    private final HashMap<String, Long> zze = new HashMap<>(16, 1.0f);
    private final HashMap<String, Float> zzf = new HashMap<>(16, 1.0f);
    private Object zzg = null;
    private boolean zzh = false;
    private String[] zzi = new String[0];
    private final ContentResolver zzj = null;
    private final zzgp zzk = new zzgn();

    @Override // com.google.android.gms.internal.measurement.zzgj
    public final String zza(@Nullable ContentResolver contentResolver, String str, @Nullable String str2) {
        if (contentResolver == null) {
            throw new IllegalStateException("ContentResolver needed with GservicesDelegateSupplier.init()");
        }
        synchronized (this) {
            if (this.zzb == null) {
                this.zza.set(false);
                this.zzb = new HashMap<>(16, 1.0f);
                this.zzg = new Object();
                contentResolver.registerContentObserver(zzgh.zza, true, new zzgk(this, null));
            } else if (this.zza.getAndSet(false)) {
                this.zzb.clear();
                this.zzc.clear();
                this.zzd.clear();
                this.zze.clear();
                this.zzf.clear();
                this.zzg = new Object();
                this.zzh = false;
            }
            Object obj = this.zzg;
            if (this.zzb.containsKey(str)) {
                String str3 = this.zzb.get(str);
                return str3 != null ? str3 : null;
            }
            for (String str4 : this.zzi) {
                if (str.startsWith(str4)) {
                    if (!this.zzh) {
                        try {
                            HashMap<String, String> map = (HashMap) this.zzk.zza(contentResolver, this.zzi, new zzgm() { // from class: com.google.android.gms.internal.measurement.zzgl
                                @Override // com.google.android.gms.internal.measurement.zzgm
                                public final Map zza(int i) {
                                    return new HashMap(i, 1.0f);
                                }
                            });
                            if (!map.isEmpty()) {
                                Set<String> setKeySet = map.keySet();
                                setKeySet.removeAll(this.zzc.keySet());
                                setKeySet.removeAll(this.zzd.keySet());
                                setKeySet.removeAll(this.zze.keySet());
                                setKeySet.removeAll(this.zzf.keySet());
                            }
                            if (!map.isEmpty()) {
                                if (this.zzb.isEmpty()) {
                                    this.zzb = map;
                                } else {
                                    this.zzb.putAll(map);
                                }
                            }
                            this.zzh = true;
                        } catch (zzgo unused) {
                        }
                        if (this.zzb.containsKey(str)) {
                            String str5 = this.zzb.get(str);
                            return str5 != null ? str5 : null;
                        }
                    }
                    return null;
                }
            }
            try {
                String strZza = this.zzk.zza(contentResolver, str);
                if (strZza != null && strZza.equals(null)) {
                    strZza = null;
                }
                synchronized (this) {
                    if (obj == this.zzg) {
                        this.zzb.put(str, strZza);
                    }
                }
                if (strZza != null) {
                    return strZza;
                }
                return null;
            } catch (zzgo unused2) {
                return null;
            }
        }
    }
}
