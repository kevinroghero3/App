package com.salesforce.marketingcloud.storage.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
class c {
    private c() {
    }

    static String a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    static boolean a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(String.format(Locale.ENGLISH, "SELECT EXISTS(SELECT 1 FROM sqlite_master WHERE type='%s' and name='%s')", str, str2), null);
        boolean z = false;
        if (cursorRawQuery.moveToFirst() && cursorRawQuery.getInt(0) == 0) {
            z = true;
        }
        cursorRawQuery.close();
        return z;
    }
}
