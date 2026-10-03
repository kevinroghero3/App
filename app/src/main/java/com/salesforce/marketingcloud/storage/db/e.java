package com.salesforce.marketingcloud.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.henninghall.date_picker.props.DateProp;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class e extends b implements com.salesforce.marketingcloud.storage.c {
    static final String e = "device_stats";
    private static final String f = com.salesforce.marketingcloud.g.a("DeviceStatsDbStorage");

    public e(@NonNull SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS device_stats");
    }

    static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE device_stats(id INTEGER PRIMARY KEY, type INTEGER, date INTEGER, event_data TEXT, in_transit INTEGER DEFAULT 0, ready_to_send INTEGER DEFAULT 0);");
    }

    private static boolean c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT id,type,date,event_data,in_transit,ready_to_send FROM device_stats");
            return true;
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.e(f, e2, "%s is invalid", e);
            return false;
        }
    }

    static boolean d(SQLiteDatabase sQLiteDatabase) {
        boolean zC = c(sQLiteDatabase);
        if (zC) {
            return zC;
        }
        try {
            a(sQLiteDatabase);
            b(sQLiteDatabase);
            return c(sQLiteDatabase);
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(f, e2, "Unable to recover %s", e);
            return zC;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.c
    public int f() {
        return i((String) null);
    }

    @Override // com.salesforce.marketingcloud.storage.c
    public List<com.salesforce.marketingcloud.analytics.stats.b> i(@NonNull Crypto crypto) {
        List<com.salesforce.marketingcloud.analytics.stats.b> listEmptyList = Collections.emptyList();
        Cursor cursorRawQuery = this.c.rawQuery("SELECT * FROM device_stats WHERE ready_to_send=0", null);
        if (cursorRawQuery != null) {
            if (cursorRawQuery.moveToFirst()) {
                ArrayList arrayList = new ArrayList(cursorRawQuery.getCount());
                do {
                    arrayList.add(a(cursorRawQuery, crypto));
                } while (cursorRawQuery.moveToNext());
                listEmptyList = arrayList;
            }
            cursorRawQuery.close();
        }
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.storage.c
    public List<com.salesforce.marketingcloud.analytics.stats.b> j(@NonNull Crypto crypto) {
        return a(crypto, "SELECT * FROM device_stats WHERE ready_to_send=1 AND in_transit=0 AND type IN(100, 101, 102, 103, 104, 106, 107, 110, 111, 112)");
    }

    @Override // com.salesforce.marketingcloud.storage.c
    public List<com.salesforce.marketingcloud.analytics.stats.b> n(@NonNull Crypto crypto) {
        return a(crypto, "SELECT * FROM device_stats WHERE ready_to_send=1 AND in_transit=0 AND type IN(105)");
    }

    @Override // com.salesforce.marketingcloud.storage.db.b
    String o() {
        return e;
    }

    private static com.salesforce.marketingcloud.analytics.stats.b a(Cursor cursor, Crypto crypto) {
        try {
            int i = cursor.getInt(cursor.getColumnIndex("id"));
            int i2 = cursor.getInt(cursor.getColumnIndex("type"));
            Date date = new Date(cursor.getLong(cursor.getColumnIndex(DateProp.name)));
            com.salesforce.marketingcloud.analytics.stats.d dVarA = com.salesforce.marketingcloud.analytics.stats.d.a(crypto.decString(cursor.getString(cursor.getColumnIndex("event_data"))));
            boolean z = true;
            if (cursor.getInt(cursor.getColumnIndex(a.C0116a.f)) != 1) {
                z = false;
            }
            return com.salesforce.marketingcloud.analytics.stats.b.a(i, i2, date, dVarA, z);
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(f, e2, "Unable to read analytic item from cursor.", new Object[0]);
            return null;
        }
    }

    private static ContentValues b(com.salesforce.marketingcloud.analytics.stats.b bVar, Crypto crypto) throws Exception {
        ContentValues contentValues = new ContentValues();
        if (bVar.b() != null) {
            contentValues.put("id", bVar.b());
        }
        contentValues.put("type", Integer.valueOf(bVar.d()));
        contentValues.put(DateProp.name, Long.valueOf(bVar.a().getTime()));
        contentValues.put("event_data", crypto.encString(bVar.c().a()));
        contentValues.put(a.C0116a.f, Integer.valueOf(bVar.e() ? 1 : 0));
        return contentValues;
    }

    @Override // com.salesforce.marketingcloud.storage.c
    public void c(@NonNull String[] strArr) {
        if (strArr.length > 0) {
            try {
                com.salesforce.marketingcloud.g.c(f, "Deleted %d items of %d items", Integer.valueOf(strArr.length), Integer.valueOf(c(Arrays.asList(strArr))));
            } catch (Exception unused) {
                com.salesforce.marketingcloud.g.e(f, "Unable to clean up %s table.", o());
            }
        }
    }

    @Override // com.salesforce.marketingcloud.storage.c
    public void a(@NonNull com.salesforce.marketingcloud.analytics.stats.b bVar, @NonNull Crypto crypto) throws Exception {
        ContentValues contentValuesB = b(bVar, crypto);
        if (bVar.b() == null || a(contentValuesB, "id = ?", new String[]{bVar.b().toString()}) == 0) {
            a(contentValuesB);
        }
    }

    private List<com.salesforce.marketingcloud.analytics.stats.b> a(@NonNull Crypto crypto, @NonNull String str) {
        List<com.salesforce.marketingcloud.analytics.stats.b> listEmptyList = Collections.emptyList();
        Cursor cursorRawQuery = this.c.rawQuery(str, null);
        if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
            return listEmptyList;
        }
        int count = cursorRawQuery.getCount();
        int columnIndex = cursorRawQuery.getColumnIndex("id");
        String[] strArr = new String[count];
        ArrayList arrayList = new ArrayList(count);
        int i = 0;
        while (true) {
            arrayList.add(a(cursorRawQuery, crypto));
            strArr[i] = cursorRawQuery.getString(columnIndex);
            if (!cursorRawQuery.moveToNext() || i >= count) {
                break;
            }
            i++;
        }
        cursorRawQuery.close();
        return arrayList;
    }

    @Override // com.salesforce.marketingcloud.storage.c
    public void a(@NonNull String[] strArr, @NonNull Boolean bool) {
        if (strArr.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("in_transit", Integer.valueOf(bool.booleanValue() ? 1 : 0));
            try {
                a(contentValues, Arrays.asList(strArr));
            } catch (Exception unused) {
                com.salesforce.marketingcloud.g.e(f, "Unable to update %s table.", o());
            }
        }
    }

    @Override // com.salesforce.marketingcloud.storage.c
    public int a() {
        try {
            return a("(type = ? OR type = ?) AND in_transit = 0 AND date <= ?", new String[]{String.valueOf(com.salesforce.marketingcloud.analytics.stats.b.l), String.valueOf(107), String.valueOf(System.currentTimeMillis() - 1209600000)}) + a("type = ? AND ready_to_send = 0 AND date <= ?", new String[]{String.valueOf(100), String.valueOf(System.currentTimeMillis() - 1209600000)});
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(f, e2, "Unable to purge old debug/telemetry data.", new Object[0]);
            return 0;
        }
    }
}
