package com.transistorsoft.locationmanager.data.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.facebook.appevents.AppEventsConstants;
import com.transistorsoft.locationmanager.geofence.TSGeofence;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GeofenceDAO {
    private static GeofenceDAO c = null;
    private static final long d = 6371;
    private final Context a;
    private final List<String> b = new ArrayList();

    private GeofenceDAO(Context context) {
        this.a = context;
    }

    private static double a(double d2) {
        return (d2 * 3.141592653589793d) / 180.0d;
    }

    private SQLiteDatabase b() {
        return LocationOpenHelper.getInstance(this.a).getWritableDatabase();
    }

    public static GeofenceDAO getInstance(Context context) {
        if (c == null) {
            c = a(context);
        }
        return c;
    }

    public List<TSGeofence> all() {
        a();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            cursorQuery = b().query(false, LocationOpenHelper.GEOFENCES_TABLE_NAME, null, null, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(a(cursorQuery));
                } catch (TSGeofence.Exception e) {
                    TSLog.logger.error(TSLog.error(e.getMessage()));
                    e.printStackTrace();
                }
            }
            cursorQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public List<TSGeofence> allWithinRadius(double d2, double d3, double d4, int i) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabaseB = b();
        double dSin = Math.sin(a(d3));
        double dCos = Math.cos(a(d3));
        double dSin2 = Math.sin(a(d4));
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabaseB.rawQuery("SELECT identifier, radius, latitude, longitude, notifyOnEntry, notifyOnExit, notifyOnDwell, loiteringDelay, extras, vertices, (" + dSin + " * sin_latitude + " + dCos + " * cos_latitude * (cos_longitude * " + Math.cos(a(d4)) + " + sin_longitude * " + dSin2 + ")) AS distance FROM " + LocationOpenHelper.GEOFENCES_TABLE_NAME + " WHERE distance > " + Math.cos((d2 / 1000.0d) / 6371.0d) + " ORDER BY distance DESC LIMIT " + i, null);
            while (cursorRawQuery.moveToNext()) {
                try {
                    arrayList.add(a(cursorRawQuery));
                } catch (TSGeofence.Exception e) {
                    TSLog.logger.error(TSLog.error(e.getMessage()));
                    e.printStackTrace();
                }
            }
            cursorRawQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public int count() {
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = b().rawQuery("SELECT count(*) AS count FROM geofences", null);
            cursorRawQuery.moveToFirst();
            int i = cursorRawQuery.getInt(0);
            cursorRawQuery.close();
            return i;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public boolean create(TSGeofence tSGeofence) {
        long jInsertOrThrow;
        a();
        SQLiteDatabase sQLiteDatabaseB = b();
        try {
            ContentValues contentValuesA = a(tSGeofence);
            String string = contentValuesA.get("identifier").toString();
            if (exists(string)) {
                destroy(string);
            }
            jInsertOrThrow = sQLiteDatabaseB.insertOrThrow(LocationOpenHelper.GEOFENCES_TABLE_NAME, null, contentValuesA);
            try {
                TSLog.logger.info(TSLog.ok("INSERT geofence: " + string));
            } catch (SQLiteException e) {
                e = e;
                this.b.add(e.getMessage());
                TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
            } catch (Exception e2) {
                e = e2;
                TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
            }
        } catch (SQLiteException e3) {
            e = e3;
            jInsertOrThrow = 0;
        } catch (Exception e4) {
            e = e4;
            jInsertOrThrow = 0;
        }
        return jInsertOrThrow > 0;
    }

    public boolean destroy(String str) {
        a();
        int iDelete = b().delete(LocationOpenHelper.GEOFENCES_TABLE_NAME, "identifier = ?", new String[]{str});
        if (iDelete == 1) {
            TSLog.logger.info(TSLog.ok(str));
        } else if (iDelete == 0) {
            this.b.add("Failed to find geofence '" + str + "'");
            TSLog.logger.warn(TSLog.warn("failed to find " + str));
        } else {
            this.b.add("Failed to destroy geofence '" + str + "'");
            TSLog.logger.error(TSLog.error("FAIL " + str));
        }
        return iDelete == 1;
    }

    public boolean destroyAll() {
        a();
        int iDelete = b().delete(LocationOpenHelper.GEOFENCES_TABLE_NAME, null, null);
        if (iDelete >= 0) {
            TSLog.logger.info(TSLog.ICON_CHECK);
        } else {
            this.b.add("Destroy all geofences failed");
            TSLog.logger.error(TSLog.error("FAILED"));
        }
        return iDelete >= 0;
    }

    public boolean exists(String str) {
        if (str == null) {
            str = "";
        }
        Cursor cursorQuery = b().query(LocationOpenHelper.GEOFENCES_TABLE_NAME, new String[]{"id"}, "identifier=?", new String[]{str}, null, null, null, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        boolean z = cursorQuery.getCount() > 0;
        cursorQuery.close();
        return z;
    }

    public TSGeofence find(String str) {
        Throwable th;
        Cursor cursor = null;
        TSGeofence tSGeofenceA = null;
        try {
            Cursor cursorQuery = b().query(LocationOpenHelper.GEOFENCES_TABLE_NAME, null, "identifier=?", new String[]{str}, null, null, null, AppEventsConstants.EVENT_PARAM_VALUE_YES);
            try {
                if (cursorQuery.moveToFirst()) {
                    try {
                        tSGeofenceA = a(cursorQuery);
                    } catch (TSGeofence.Exception e) {
                        TSLog.logger.error(TSLog.error(e.getMessage()));
                        e.printStackTrace();
                        cursorQuery.close();
                        return null;
                    }
                }
                cursorQuery.close();
                return tSGeofenceA;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor == null) {
                    throw th;
                }
                cursor.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public List<String> getErrors() {
        return this.b;
    }

    public List<String> getIdentifiers() {
        a();
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = b().rawQuery("SELECT identifier from geofences", null);
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("identifier")));
            }
            cursorRawQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    private static GeofenceDAO a(Context context) {
        GeofenceDAO geofenceDAO;
        synchronized (GeofenceDAO.class) {
            if (c == null) {
                c = new GeofenceDAO(context.getApplicationContext());
            }
            geofenceDAO = c;
        }
        return geofenceDAO;
    }

    private void a() {
        this.b.clear();
    }

    private ContentValues a(TSGeofence tSGeofence) {
        JSONArray jSONArray = new JSONArray();
        if (tSGeofence.isPolygon()) {
            for (List<Double> list : tSGeofence.getVertices()) {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(list.get(0));
                jSONArray2.put(list.get(1));
                jSONArray.put(jSONArray2);
            }
        }
        ContentValues contentValues = new ContentValues();
        JSONObject extras = tSGeofence.getExtras();
        contentValues.put("identifier", tSGeofence.getIdentifier());
        contentValues.put(TSGeofence.FIELD_RADIUS, Float.valueOf(tSGeofence.getRadius()));
        contentValues.put("latitude", Double.valueOf(tSGeofence.getLatitude()));
        contentValues.put("sin_latitude", Double.valueOf(Math.sin(a(tSGeofence.getLatitude()))));
        contentValues.put("cos_latitude", Double.valueOf(Math.cos(a(tSGeofence.getLatitude()))));
        contentValues.put("longitude", Double.valueOf(tSGeofence.getLongitude()));
        contentValues.put("sin_longitude", Double.valueOf(Math.sin(a(tSGeofence.getLongitude()))));
        contentValues.put("cos_longitude", Double.valueOf(Math.cos(a(tSGeofence.getLongitude()))));
        contentValues.put(TSGeofence.FIELD_NOTIFY_ON_ENTRY, Boolean.valueOf(tSGeofence.getNotifyOnEntry()));
        contentValues.put(TSGeofence.FIELD_NOTIFY_ON_EXIT, Boolean.valueOf(tSGeofence.getNotifyOnExit()));
        contentValues.put(TSGeofence.FIELD_NOTIFY_ON_DWELL, Boolean.valueOf(tSGeofence.getNotifyOnDwell()));
        contentValues.put(TSGeofence.FIELD_LOITERING_DELAY, Integer.valueOf(tSGeofence.getLoiteringDelay()));
        contentValues.put("extras", extras != null ? extras.toString() : null);
        contentValues.put(TSGeofence.FIELD_VERTICES, jSONArray.toString());
        return contentValues;
    }

    public boolean exists(List<String> list) {
        Cursor cursorQuery = b().query(LocationOpenHelper.GEOFENCES_TABLE_NAME, new String[]{"id"}, "identifier IN(?)", new String[]{list.toString()}, null, null, null, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        boolean z = cursorQuery.getCount() == list.size();
        cursorQuery.close();
        return z;
    }

    public int create(List<TSGeofence> list) {
        a();
        SQLiteDatabase sQLiteDatabaseB = b();
        sQLiteDatabaseB.beginTransaction();
        int i = 0;
        for (TSGeofence tSGeofence : list) {
            try {
                ContentValues contentValuesA = a(tSGeofence);
                String identifier = tSGeofence.getIdentifier();
                if (exists(identifier)) {
                    destroy(identifier);
                }
                if (sQLiteDatabaseB.insertOrThrow(LocationOpenHelper.GEOFENCES_TABLE_NAME, null, contentValuesA) > 0) {
                    TSLog.logger.info(TSLog.ok(identifier));
                    i++;
                }
            } catch (SQLiteException e) {
                this.b.add(e.getMessage());
                TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
            } catch (Exception e2) {
                this.b.add(e2.getMessage());
                TSLog.logger.error(TSLog.error(e2.getMessage()), (Throwable) e2);
            }
        }
        sQLiteDatabaseB.setTransactionSuccessful();
        sQLiteDatabaseB.endTransaction();
        return i;
    }

    public List<TSGeofence> find(List<String> list) throws Throwable {
        Throwable th;
        SQLiteDatabase sQLiteDatabaseB = b();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor cursorQuery = sQLiteDatabaseB.query(LocationOpenHelper.GEOFENCES_TABLE_NAME, null, "identifier IN(?)", new String[]{list.toString()}, null, null, null, AppEventsConstants.EVENT_PARAM_VALUE_YES);
            try {
                if (cursorQuery.moveToFirst()) {
                    try {
                        arrayList.add(a(cursorQuery));
                    } catch (TSGeofence.Exception e) {
                        TSLog.logger.error(TSLog.error(e.getMessage()));
                        e.printStackTrace();
                        cursorQuery.close();
                        return null;
                    }
                }
                cursorQuery.close();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private TSGeofence a(Cursor cursor) throws TSGeofence.Exception {
        boolean z = cursor.getInt(cursor.getColumnIndex(TSGeofence.FIELD_NOTIFY_ON_ENTRY)) == 1;
        boolean z2 = cursor.getInt(cursor.getColumnIndex(TSGeofence.FIELD_NOTIFY_ON_EXIT)) == 1;
        boolean z3 = cursor.getInt(cursor.getColumnIndex(TSGeofence.FIELD_NOTIFY_ON_DWELL)) == 1;
        String string = cursor.getString(cursor.getColumnIndex(TSGeofence.FIELD_VERTICES));
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(Double.valueOf(jSONArray2.getDouble(0)));
                    arrayList2.add(Double.valueOf(jSONArray2.getDouble(1)));
                    arrayList.add(arrayList2);
                }
            } catch (JSONException e) {
                TSLog.logger.error(TSLog.error("Failed to parse TSGeofence vertices: " + e.getMessage()), (Throwable) e);
            }
        }
        return new TSGeofence.Builder().setIdentifier(cursor.getString(cursor.getColumnIndex("identifier"))).setRadius(cursor.getFloat(cursor.getColumnIndex(TSGeofence.FIELD_RADIUS))).setLatitude(cursor.getDouble(cursor.getColumnIndex("latitude"))).setLongitude(cursor.getDouble(cursor.getColumnIndex("longitude"))).setNotifyOnEntry(z).setNotifyOnExit(z2).setNotifyOnDwell(z3).setLoiteringDelay(cursor.getInt(cursor.getColumnIndex(TSGeofence.FIELD_LOITERING_DELAY))).setExtras(cursor.getString(cursor.getColumnIndex("extras"))).setVertices(arrayList).build();
    }
}
