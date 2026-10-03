package com.salesforce.marketingcloud.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.appevents.AppEventsConstants;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends b implements com.salesforce.marketingcloud.storage.g {
    public static final String e = "location_table";
    private static final String f = "CREATE TABLE location_table (id INTEGER PRIMARY KEY CHECK (id = 0), latitude VARCHAR, longitude VARCHAR );";
    private static final String[] g = {"id", "latitude", "longitude"};
    private static final String h = com.salesforce.marketingcloud.g.a("LocationDbStorage");

    /* JADX INFO: loaded from: classes6.dex */
    public static class a {
        public static final String a = "id";
        public static final String b = "latitude";
        public static final String c = "longitude";
    }

    public h(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS location_table");
    }

    static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f);
    }

    private static boolean c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement(c.a("SELECT %s FROM %s", TextUtils.join(",", g), e));
            return true;
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.e(h, e2, "%s is invalid", e);
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
            com.salesforce.marketingcloud.g.b(h, e2, "Unable to recover %s", e);
            return zC;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.g
    public LatLon e(@NonNull Crypto crypto) {
        Cursor cursorA = a(g, String.format(Locale.ENGLISH, "%s = ?", "id"), new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO});
        LatLon latLon = null;
        if (cursorA != null) {
            if (cursorA.moveToFirst()) {
                try {
                    latLon = new LatLon(Double.valueOf(crypto.decString(cursorA.getString(cursorA.getColumnIndex("latitude")))).doubleValue(), Double.valueOf(crypto.decString(cursorA.getString(cursorA.getColumnIndex("longitude")))).doubleValue());
                } catch (Exception e2) {
                    com.salesforce.marketingcloud.g.b(h, e2, "Unable to read location from database.", new Object[0]);
                }
            }
            cursorA.close();
        }
        return latLon;
    }

    @Override // com.salesforce.marketingcloud.storage.g
    public int g() {
        return i(null);
    }

    @Override // com.salesforce.marketingcloud.storage.db.b
    String o() {
        return e;
    }

    @Override // com.salesforce.marketingcloud.storage.g
    public void a(@NonNull LatLon latLon, @NonNull Crypto crypto) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", (Integer) 0);
        contentValues.put("latitude", crypto.encString(Double.toString(latLon.latitude())));
        contentValues.put("longitude", crypto.encString(Double.toString(latLon.longitude())));
        if (a(contentValues, String.format(Locale.ENGLISH, "%s = ?", "id"), new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO}) == 0) {
            a(contentValues);
        }
    }
}
