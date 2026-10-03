package com.transistorsoft.locationmanager.data.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.transistorsoft.locationmanager.logger.TSLog;

/* JADX INFO: loaded from: classes3.dex */
public class LocationOpenHelper extends SQLiteOpenHelper {
    public static final String GEOFENCES_TABLE_NAME = "geofences";
    public static final String LOCATION_TABLE_NAME = "locations";
    private static LocationOpenHelper a = null;
    private static final String b = "transistor_location_manager";
    private static final int c = 6;
    private static final String d = "id INTEGER PRIMARY KEY AUTOINCREMENT, uuid TEXT NOT NULL DEFAULT '', timestamp TEXT, json TEXT, data BLOB, encrypted BOOLEAN NOT NULL DEFAULT 0, locked BOOLEAN NOT NULL DEFAULT 0";
    private static final String e = "CREATE TABLE IF NOT EXISTS locations (id INTEGER PRIMARY KEY AUTOINCREMENT, uuid TEXT NOT NULL DEFAULT '', timestamp TEXT, json TEXT, data BLOB, encrypted BOOLEAN NOT NULL DEFAULT 0, locked BOOLEAN NOT NULL DEFAULT 0);";
    private static final String f = "DROP TABLE IF EXISTS locations";
    private static final String g = "id INTEGER PRIMARY KEY AUTOINCREMENT, identifier TEXT NOT NULL UNIQUE, latitude DOUBLE NOT NULL, sin_latitude DOUBLE NOT NULL, cos_latitude DOUBLE NOT NULL, longitude DOUBLE NOT NULL, sin_longitude DOUBLE NOT NULL, cos_longitude DOUBLE NOT NULL, radius DOUBLE NOT NULL, notifyOnEntry BOOLEAN NOT NULL DEFAULT 0, notifyOnExit BOOLEAN NOT NULL DEFAULT 0, notifyOnDwell BOOLEAN NOT NULL DEFAULT 0, loiteringDelay INTEGER NOT NULL DEFAULT 0, extras TEXT, vertices TEXT";
    private static final String h = "CREATE TABLE IF NOT EXISTS geofences (id INTEGER PRIMARY KEY AUTOINCREMENT, identifier TEXT NOT NULL UNIQUE, latitude DOUBLE NOT NULL, sin_latitude DOUBLE NOT NULL, cos_latitude DOUBLE NOT NULL, longitude DOUBLE NOT NULL, sin_longitude DOUBLE NOT NULL, cos_longitude DOUBLE NOT NULL, radius DOUBLE NOT NULL, notifyOnEntry BOOLEAN NOT NULL DEFAULT 0, notifyOnExit BOOLEAN NOT NULL DEFAULT 0, notifyOnDwell BOOLEAN NOT NULL DEFAULT 0, loiteringDelay INTEGER NOT NULL DEFAULT 0, extras TEXT, vertices TEXT);";
    private static final String i = "DROP TABLE IF EXISTS geofences";
    private static final String j = "ALTER TABLE locations ADD COLUMN uuid TEXT NOT NULL DEFAULT ''";
    private static final String k = "ALTER TABLE locations ADD COLUMN data BLOB";
    private static final String l = "ALTER TABLE locations ADD COLUMN encrypted BOOLEAN NOT NULL DEFAULT 0";
    private static final String m = "ALTER TABLE geofences ADD COLUMN vertices TEXT";

    private LocationOpenHelper(Context context) {
        super(context, b, (SQLiteDatabase.CursorFactory) null, 6);
    }

    private static LocationOpenHelper a(Context context) {
        LocationOpenHelper locationOpenHelper;
        synchronized (LocationOpenHelper.class) {
            if (a == null) {
                a = new LocationOpenHelper(context.getApplicationContext());
            }
            locationOpenHelper = a;
        }
        return locationOpenHelper;
    }

    public static LocationOpenHelper getInstance(Context context) {
        if (a == null) {
            a = a(context.getApplicationContext());
        }
        return a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase readableDatabase;
        synchronized (this) {
            readableDatabase = super.getReadableDatabase();
        }
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase writableDatabase;
        synchronized (this) {
            writableDatabase = super.getWritableDatabase();
        }
        return writableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(e);
        sQLiteDatabase.execSQL(h);
        TSLog.logger.debug(e);
        TSLog.logger.debug(h);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i3 == 1) {
            sQLiteDatabase.execSQL(i);
        }
        onCreate(sQLiteDatabase);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) throws Throwable {
        Cursor cursorQuery;
        String str = "🛠🛠🛠🛠🛠🛠🛠🛠🛠";
        Log.d("TSLocationManager", "🛠🛠🛠🛠🛠🛠🛠🛠🛠");
        Log.d("TSLocationManager", "🛠 onUpgrade database version: " + i2 + "->" + i3);
        switch (i2) {
            case 1:
                sQLiteDatabase.execSQL(h);
            case 2:
                try {
                    sQLiteDatabase.execSQL(j);
                    break;
                } catch (SQLiteException e2) {
                    Log.i("TSLocationManager", "Ignored SQLITE error: " + e2.getMessage());
                    break;
                }
            case 3:
                sQLiteDatabase.execSQL(h);
                try {
                    sQLiteDatabase.execSQL(j);
                    break;
                } catch (SQLiteException e3) {
                    Log.i("TSLocationManager", "Ignored SQLITE error: " + e3.getMessage());
                    break;
                }
            case 4:
                try {
                    Log.i("TSLocationManager", k);
                    Log.i("TSLocationManager", l);
                    sQLiteDatabase.execSQL(k);
                    sQLiteDatabase.execSQL(l);
                    try {
                        try {
                            cursorQuery = sQLiteDatabase.query(false, "locations", null, null, null, null, null, null, null);
                            while (cursorQuery.moveToNext()) {
                                try {
                                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("json"));
                                    int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("id"));
                                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("uuid"));
                                    TSLog.logger.debug(TSLog.ok("Migrate " + string2 + " JSON to data BLOB"));
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("data", string.getBytes());
                                    contentValues.put("encrypted", (Integer) 0);
                                    contentValues.put("json", "");
                                    sQLiteDatabase.update("locations", contentValues, "id=" + i4, null);
                                } catch (Throwable th) {
                                    th = th;
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    throw th;
                                }
                            }
                            cursorQuery.close();
                        } catch (Throwable th2) {
                            th = th2;
                            cursorQuery = null;
                        }
                    } catch (SQLiteException e4) {
                        e = e4;
                        Log.i("TSLocationManager", str + e.getMessage());
                    }
                } catch (SQLiteException e5) {
                    e = e5;
                    str = "Ignored SQLITE error: ";
                }
                try {
                    Log.i("TSLocationManager", m);
                    sQLiteDatabase.execSQL(m);
                    break;
                } catch (SQLiteException e6) {
                    Log.e("TSLocationManager", "SQLITE ERROR: " + e6.getMessage());
                }
                Log.d("TSLocationManager", "🛠🛠🛠🛠🛠🛠🛠🛠🛠");
                return;
            case 5:
            case 6:
                Log.i("TSLocationManager", m);
                sQLiteDatabase.execSQL(m);
                Log.d("TSLocationManager", "🛠🛠🛠🛠🛠🛠🛠🛠🛠");
                return;
            default:
                Log.d("TSLocationManager", "🛠🛠🛠🛠🛠🛠🛠🛠🛠");
                return;
        }
    }
}
