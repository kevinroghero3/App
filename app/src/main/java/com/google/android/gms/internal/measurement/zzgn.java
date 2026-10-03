package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class zzgn implements zzgp {
    @Override // com.google.android.gms.internal.measurement.zzgp
    public final String zza(ContentResolver contentResolver, String str) throws zzgo {
        Cursor cursorQuery = contentResolver.query(zzgh.zza, null, null, new String[]{str}, null);
        try {
            if (cursorQuery == null) {
                throw new zzgo("Failed to connect to GservicesProvider");
            }
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return null;
            }
            String string = cursorQuery.getString(1);
            cursorQuery.close();
            return string;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzgp
    public final <T extends Map<String, String>> T zza(ContentResolver contentResolver, String[] strArr, zzgm<T> zzgmVar) throws zzgo {
        Cursor cursorQuery = contentResolver.query(zzgh.zzb, null, null, strArr, null);
        try {
            if (cursorQuery == null) {
                throw new zzgo("Failed to connect to GservicesProvider");
            }
            T t = (T) zzgmVar.zza(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                t.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            cursorQuery.close();
            return t;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
