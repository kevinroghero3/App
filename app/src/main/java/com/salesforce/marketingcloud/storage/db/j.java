package com.salesforce.marketingcloud.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.google.firebase.messaging.Constants;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.util.Crypto;
import com.transistorsoft.locationmanager.geofence.TSGeofence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends b implements com.salesforce.marketingcloud.storage.j {
    public static final String e = "regions";
    public static final String f = "region_messages";
    static final String g = com.salesforce.marketingcloud.g.a("RegionDbStorage");

    public j(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE region_messages (region_id TEXT,  message_id TEXT, FOREIGN KEY (region_id) REFERENCES regions(id) ON DELETE CASCADE, PRIMARY KEY (region_id, message_id));");
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE regions(id TEXT PRIMARY KEY, latitude TEXT, longitude TEXT, radius INTEGER, beacon_guid TEXT, beacon_major INTEGER, beacon_minor INTEGER, description TEXT, name TEXT, location_type INTEGER, is_inside SMALLINT);");
    }

    static void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS regions");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS region_messages");
    }

    static void d(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }

    private static boolean e(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT region_id,message_id FROM region_messages");
            return true;
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.e(g, e2, "%s is invalid", f);
            return false;
        }
    }

    private static boolean f(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT id,latitude,longitude,radius,beacon_guid,beacon_major,beacon_minor,description,name,location_type,is_inside FROM regions");
            return true;
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.e(g, e2, "%s is invalid", e);
            return false;
        }
    }

    static boolean g(SQLiteDatabase sQLiteDatabase) {
        boolean zF = f(sQLiteDatabase);
        if (!zF) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS regions");
                b(sQLiteDatabase);
                zF = f(sQLiteDatabase);
            } catch (Exception e2) {
                com.salesforce.marketingcloud.g.b(g, e2, "Unable to recover %s", e);
            }
        }
        boolean zE = e(sQLiteDatabase);
        if (zF && !zE) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS region_messages");
                a(sQLiteDatabase);
                zE = e(sQLiteDatabase);
            } catch (Exception e3) {
                com.salesforce.marketingcloud.g.b(g, e3, "Unable to recover %s", f);
            }
        }
        return zF && zE;
    }

    @Override // com.salesforce.marketingcloud.storage.j
    public Region l(@NonNull Crypto crypto) {
        Cursor cursorRawQuery = this.c.rawQuery("SELECT * FROM regions WHERE id=?", new String[]{Region.MAGIC_REGION_ID});
        Region regionA = null;
        if (cursorRawQuery != null) {
            if (cursorRawQuery.moveToFirst()) {
                try {
                    regionA = com.salesforce.marketingcloud.internal.l.a(new LatLon(Double.valueOf(crypto.decString(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("latitude")))).doubleValue(), Double.valueOf(crypto.decString(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("longitude")))).doubleValue()), cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(TSGeofence.FIELD_RADIUS)));
                } catch (Exception e2) {
                    com.salesforce.marketingcloud.g.b(g, e2, "Unable to read magic region from DB.", new Object[0]);
                }
            }
            cursorRawQuery.close();
        }
        return regionA;
    }

    @Override // com.salesforce.marketingcloud.storage.db.b
    String o() {
        return e;
    }

    private static ContentValues a(Region region, Message message) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("region_id", region.id());
        contentValues.put(Constants.MessagePayloadKeys.MSGID_SERVER, message.id());
        return contentValues;
    }

    private static ContentValues c(Region region, @NonNull Crypto crypto) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", region.id());
        contentValues.put("latitude", crypto.encString(String.valueOf(region.center().latitude())));
        contentValues.put("longitude", crypto.encString(String.valueOf(region.center().longitude())));
        contentValues.put(TSGeofence.FIELD_RADIUS, Integer.valueOf(region.radius()));
        contentValues.put("beacon_guid", crypto.encString(region.proximityUuid()));
        contentValues.put("beacon_major", Integer.valueOf(region.major()));
        contentValues.put("beacon_minor", Integer.valueOf(region.minor()));
        contentValues.put("description", crypto.encString(region.description()));
        contentValues.put("name", crypto.encString(region.name()));
        contentValues.put("location_type", Integer.valueOf(region.regionType()));
        contentValues.put("is_inside", Integer.valueOf(com.salesforce.marketingcloud.internal.l.a(region) ? 1 : 0));
        return contentValues;
    }

    @Override // com.salesforce.marketingcloud.storage.j
    public List<String> d(int i) {
        List<String> listEmptyList = Collections.emptyList();
        Cursor cursorRawQuery = this.c.rawQuery("SELECT id FROM regions WHERE location_type=?", new String[]{String.valueOf(i)});
        if (cursorRawQuery != null) {
            if (cursorRawQuery.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                int columnIndex = cursorRawQuery.getColumnIndex("id");
                do {
                    arrayList.add(cursorRawQuery.getString(columnIndex));
                } while (cursorRawQuery.moveToNext());
                listEmptyList = arrayList;
            }
            cursorRawQuery.close();
        }
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.storage.j
    public void a(@NonNull Region region, @NonNull Crypto crypto) throws Exception {
        this.c.insertWithOnConflict(e, null, c(region, crypto), 5);
        if (region.messages().isEmpty()) {
            return;
        }
        Iterator<Message> it2 = region.messages().iterator();
        while (it2.hasNext()) {
            this.c.insertWithOnConflict(f, null, a(region, it2.next()), 5);
        }
    }

    @Override // com.salesforce.marketingcloud.storage.j
    public int f(int i) {
        return this.c.delete(e, "location_type=?", new String[]{String.valueOf(i)});
    }

    @Override // com.salesforce.marketingcloud.storage.j
    public Region a(String str, @NonNull Crypto crypto) {
        Cursor cursorRawQuery = this.c.rawQuery("SELECT * FROM regions WHERE id=?", new String[]{str});
        Region regionC = null;
        if (cursorRawQuery != null) {
            regionC = cursorRawQuery.moveToFirst() ? d.c(cursorRawQuery, crypto) : null;
            cursorRawQuery.close();
        }
        return regionC;
    }

    @Override // com.salesforce.marketingcloud.storage.j
    public List<String> c(@NonNull String str, int i) {
        ArrayList arrayList;
        Cursor cursorRawQuery = this.c.rawQuery("SELECT message_id FROM region_messages INNER JOIN messages on region_messages.message_id = messages.id WHERE region_id = ? AND messages.message_type = ?", new String[]{str, String.valueOf(i)});
        if (cursorRawQuery.moveToFirst()) {
            arrayList = new ArrayList(cursorRawQuery.getCount());
            int columnIndex = cursorRawQuery.getColumnIndex(Constants.MessagePayloadKeys.MSGID_SERVER);
            do {
                arrayList.add(cursorRawQuery.getString(columnIndex));
            } while (cursorRawQuery.moveToNext());
        } else {
            arrayList = null;
        }
        cursorRawQuery.close();
        return arrayList != null ? arrayList : Collections.emptyList();
    }

    @Override // com.salesforce.marketingcloud.storage.j
    public void l() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_inside", (Integer) 0);
        this.c.update(e, contentValues, null, null);
    }

    @Override // com.salesforce.marketingcloud.storage.j
    public List<Region> a(int i, Crypto crypto) {
        List<Region> listEmptyList = Collections.emptyList();
        Cursor cursorRawQuery = this.c.rawQuery("SELECT * FROM regions WHERE location_type=?", new String[]{String.valueOf(i)});
        if (cursorRawQuery != null) {
            if (cursorRawQuery.moveToFirst()) {
                ArrayList arrayList = new ArrayList(cursorRawQuery.getCount());
                do {
                    Region regionC = d.c(cursorRawQuery, crypto);
                    if (regionC != null) {
                        arrayList.add(regionC);
                    }
                } while (cursorRawQuery.moveToNext());
                listEmptyList = arrayList;
            }
            cursorRawQuery.close();
        }
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.storage.j
    public void a(@NonNull String str, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_inside", Integer.valueOf(z ? 1 : 0));
        this.c.update(e, contentValues, "id=?", new String[]{str});
    }
}
