package com.salesforce.marketingcloud.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class m extends b implements com.salesforce.marketingcloud.storage.m {
    public static final String g = "triggers";
    private static final String h = com.salesforce.marketingcloud.g.a("TriggerDbStorage");
    private final SQLiteStatement e;
    private final SQLiteStatement f;

    public m(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        this.e = sQLiteDatabase.compileStatement("UPDATE triggers SET app_open_count = app_open_count + 1 WHERE (start_date IS NULL OR start_date < ?)");
        this.f = sQLiteDatabase.compileStatement("SELECT app_open_count FROM triggers WHERE id = ?");
    }

    static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS triggers");
    }

    static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE triggers(id TEXT PRIMARY KEY, _key TEXT, start_date INTEGER DEFAULT NULL, _trigger TEXT, app_open_count INTEGER DEFAULT 0);");
    }

    private static boolean c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT id,_key,start_date,_trigger,app_open_count FROM triggers");
            return true;
        } catch (Exception unused) {
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
        } catch (Exception e) {
            com.salesforce.marketingcloud.g.b(h, e, "Unable to recover %s", g);
            return zC;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.m
    public List<com.salesforce.marketingcloud.events.h> g(@NonNull String str) {
        ArrayList arrayList;
        Cursor cursorA = a(new String[]{"_trigger"}, "lower(_key) = lower(?) AND (start_date IS NULL OR start_date < ?)", new String[]{str, String.valueOf(System.currentTimeMillis())});
        try {
            if (cursorA.moveToFirst()) {
                arrayList = new ArrayList(cursorA.getCount());
                do {
                    arrayList.add(a(cursorA));
                } while (cursorA.moveToNext());
            } else {
                arrayList = null;
            }
            cursorA.close();
            return arrayList != null ? arrayList : Collections.emptyList();
        } catch (Throwable th) {
            cursorA.close();
            throw th;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.m
    public void k() {
        this.e.bindString(1, String.valueOf(System.currentTimeMillis()));
        this.e.execute();
    }

    @Override // com.salesforce.marketingcloud.storage.m
    public JSONArray m() {
        JSONArray jSONArray = new JSONArray();
        Cursor cursorA = a(new String[]{"_trigger", "app_open_count"}, (String) null);
        if (cursorA != null) {
            try {
                if (cursorA.moveToFirst()) {
                    int columnIndex = cursorA.getColumnIndex("_trigger");
                    int columnIndex2 = cursorA.getColumnIndex("app_open_count");
                    do {
                        try {
                            JSONObject jSONObject = new JSONObject(cursorA.getString(columnIndex));
                            jSONObject.put("appOpenCount", cursorA.getInt(columnIndex2));
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            com.salesforce.marketingcloud.g.b(h, e, "Unable to read trigger information from cursor.", new Object[0]);
                        }
                    } while (cursorA.moveToNext());
                }
                cursorA.close();
            } catch (Throwable th) {
                cursorA.close();
                throw th;
            }
        }
        return jSONArray;
    }

    @Override // com.salesforce.marketingcloud.storage.db.b
    String o() {
        return g;
    }

    private static com.salesforce.marketingcloud.events.h a(@NonNull Cursor cursor) {
        try {
            return new com.salesforce.marketingcloud.events.h(new JSONObject(cursor.getString(cursor.getColumnIndex("_trigger"))));
        } catch (Exception e) {
            com.salesforce.marketingcloud.g.b(h, e, "Unable to read trigger from DB", new Object[0]);
            return null;
        }
    }

    private static ContentValues c(com.salesforce.marketingcloud.events.h hVar) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", hVar.h());
        contentValues.put("_key", hVar.i());
        contentValues.put("start_date", hVar.l() != null ? Long.valueOf(hVar.l().getTime()) : null);
        contentValues.put("_trigger", hVar.m().toString());
        return contentValues;
    }

    @Override // com.salesforce.marketingcloud.storage.m
    public com.salesforce.marketingcloud.events.h b(@NonNull String str) {
        Cursor cursorA = a(new String[]{"_trigger"}, "id = ?", new String[]{str});
        com.salesforce.marketingcloud.events.h hVarA = null;
        if (cursorA != null) {
            hVarA = cursorA.moveToFirst() ? a(cursorA) : null;
            cursorA.close();
        }
        return hVarA;
    }

    @Override // com.salesforce.marketingcloud.storage.m
    public void a(@NonNull com.salesforce.marketingcloud.events.h hVar) throws Exception {
        ContentValues contentValuesC = c(hVar);
        if (a(contentValuesC, "id = ?", new String[]{hVar.h()}) == 0) {
            a(contentValuesC);
        }
    }

    @Override // com.salesforce.marketingcloud.storage.m
    public int b(@NonNull Collection<String> collection) {
        if (collection.size() == 0) {
            return i(null);
        }
        try {
            return a(o(), collection);
        } catch (Exception unused) {
            com.salesforce.marketingcloud.g.e(h, "Unable to clean up %s table.", o());
            return 0;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.m
    public int b(@NonNull com.salesforce.marketingcloud.events.h hVar) {
        if (hVar != null) {
            try {
                this.f.bindString(1, hVar.h());
                return (int) this.f.simpleQueryForLong();
            } catch (Exception unused) {
            }
        }
        return 0;
    }
}
