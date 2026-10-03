package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import com.google.common.base.Preconditions;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class zzgt implements zzgw {
    private static final Map<Uri, zzgt> zza = new ArrayMap();
    private static final String[] zzb = {"key", "value"};
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private final ContentObserver zzf;
    private final Object zzg;
    private volatile Map<String, String> zzh;
    private final List<zzgu> zzi;

    public static zzgt zza(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzgt zzgtVar;
        synchronized (zzgt.class) {
            Map<Uri, zzgt> map = zza;
            zzgtVar = map.get(uri);
            if (zzgtVar == null) {
                try {
                    zzgt zzgtVar2 = new zzgt(contentResolver, uri, runnable);
                    try {
                        map.put(uri, zzgtVar2);
                    } catch (SecurityException unused) {
                    }
                    zzgtVar = zzgtVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzgtVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzgw
    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }

    public final Map<String, String> zza() {
        Map<String, String> mapZze = this.zzh;
        if (mapZze == null) {
            synchronized (this.zzg) {
                mapZze = this.zzh;
                if (mapZze == null) {
                    mapZze = zze();
                    this.zzh = mapZze;
                }
            }
        }
        return mapZze != null ? mapZze : Collections.emptyMap();
    }

    final /* synthetic */ Map zzb() {
        Map map;
        Cursor cursorQuery = this.zzc.query(this.zzd, zzb, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (cursorQuery.moveToNext()) {
                map.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return map;
        } finally {
            cursorQuery.close();
        }
    }

    private final Map<String, String> zze() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return (Map) zzgz.zza(new zzgy() { // from class: com.google.android.gms.internal.measurement.zzgs
                @Override // com.google.android.gms.internal.measurement.zzgy
                public final Object zza() {
                    return this.zza.zzb();
                }
            });
        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
            SentryLogcatAdapter.e("ConfigurationContentLdr", "PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    private zzgt(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzgv zzgvVar = new zzgv(this, null);
        this.zzf = zzgvVar;
        this.zzg = new Object();
        this.zzi = new ArrayList();
        Preconditions.checkNotNull(contentResolver);
        Preconditions.checkNotNull(uri);
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
        contentResolver.registerContentObserver(uri, false, zzgvVar);
    }

    static void zzc() {
        synchronized (zzgt.class) {
            for (zzgt zzgtVar : zza.values()) {
                zzgtVar.zzc.unregisterContentObserver(zzgtVar.zzf);
            }
            zza.clear();
        }
    }

    public final void zzd() {
        synchronized (this.zzg) {
            this.zzh = null;
            this.zze.run();
        }
        synchronized (this) {
            Iterator<zzgu> it2 = this.zzi.iterator();
            while (it2.hasNext()) {
                it2.next().zza();
            }
        }
    }
}
