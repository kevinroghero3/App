package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class zzas {
    private static Set<String> zza(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
        try {
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    static void zza(zzgb zzgbVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (zzgbVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!zza(zzgbVar, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            Set<String> setZza = zza(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!setZza.remove(str4)) {
                    throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                }
            }
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i += 2) {
                    if (!setZza.remove(strArr[i])) {
                        sQLiteDatabase.execSQL(strArr[i + 1]);
                    }
                }
            }
            if (setZza.isEmpty()) {
                return;
            }
            zzgbVar.zzu().zza("Table has extra columns. table, columns", str, TextUtils.join(", ", setZza));
        } catch (SQLiteException e) {
            zzgbVar.zzg().zza("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    static void zza(zzgb zzgbVar, SQLiteDatabase sQLiteDatabase) {
        if (zzgbVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(com.google.android.gms.internal.measurement.zzci.zza().zza(sQLiteDatabase.getPath()));
        if (!file.setReadable(false, false)) {
            zzgbVar.zzu().zza("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzgbVar.zzu().zza("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzgbVar.zzu().zza("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzgbVar.zzu().zza("Failed to turn on database write permission for owner");
    }

    private static boolean zza(zzgb zzgbVar, SQLiteDatabase sQLiteDatabase, String str) {
        if (zzgbVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                boolean zMoveToFirst = cursorQuery.moveToFirst();
                cursorQuery.close();
                return zMoveToFirst;
            } catch (SQLiteException e) {
                zzgbVar.zzu().zza("Error querying for table", str, e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
