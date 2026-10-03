package com.salesforce.marketingcloud.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends b implements com.salesforce.marketingcloud.storage.a {
    public static final String e = "analytic_item";
    static final int f = 999;
    private static final String h = "CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, enc_json_pi_payload VARCHAR, enc_json_et_payload VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL);";
    private static final String[] g = {"id", C0116a.c, C0116a.i, C0116a.d, "value", C0116a.f, C0116a.e, C0116a.h, C0116a.g, "predictive_intelligence_identifier"};
    private static final String i = com.salesforce.marketingcloud.g.a("AnalyticItemDbStorage");

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes6.dex */
    public static class C0116a {
        public static final String a = "id";
        public static final String b = "value";
        public static final String c = "event_date";
        public static final String d = "analytic_type";
        public static final String e = "object_ids";
        public static final String f = "ready_to_send";
        public static final String g = "enc_json_et_payload";
        public static final String h = "enc_json_pi_payload";
        public static final String i = "analytic_product_type";
        public static final String j = "predictive_intelligence_identifier";
    }

    public a(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS analytic_item");
    }

    static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(h);
    }

    private static boolean c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement(c.a("SELECT %s FROM %s", TextUtils.join(",", g), e));
            return true;
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.e(i, e2, "%s is invalid", e);
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
            com.salesforce.marketingcloud.g.b(i, e2, "Unable to recover %s", e);
            return zC;
        }
    }

    private int h(int i2) {
        return (int) DatabaseUtils.queryNumEntries(this.c, e, a("%s=%s", C0116a.i, Integer.valueOf(i2)));
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public int e() {
        return h(1);
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public List<com.salesforce.marketingcloud.analytics.b> f(@NonNull Crypto crypto) {
        return b(0, crypto);
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public int g(int i2) {
        return a(a("%s = ?", C0116a.i), new String[]{String.valueOf(i2)});
    }

    @Override // com.salesforce.marketingcloud.storage.db.b
    String o() {
        return e;
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    List<com.salesforce.marketingcloud.analytics.b> b(Cursor cursor, @Nullable Crypto crypto) {
        List<com.salesforce.marketingcloud.analytics.b> listEmptyList = Collections.emptyList();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                do {
                    com.salesforce.marketingcloud.analytics.b bVarA = a(cursor, crypto);
                    if (bVarA != null) {
                        arrayList.add(bVarA);
                    } else {
                        int i2 = cursor.getInt(cursor.getColumnIndex("id"));
                        if (i2 >= 0) {
                            a(a("%s = ?", "id"), new String[]{String.valueOf(i2)});
                        }
                    }
                } while (cursor.moveToNext());
                listEmptyList = arrayList;
            }
            cursor.close();
        }
        return listEmptyList;
    }

    private static com.salesforce.marketingcloud.analytics.b a(Cursor cursor, @Nullable Crypto crypto) {
        String strOptString;
        String str;
        com.salesforce.marketingcloud.analytics.b bVarA;
        try {
            int i2 = cursor.getInt(cursor.getColumnIndex(C0116a.d));
            int i3 = cursor.getInt(cursor.getColumnIndex(C0116a.i)) == 0 ? 0 : 1;
            Date dateD = com.salesforce.marketingcloud.util.j.d(cursor.getString(cursor.getColumnIndex(C0116a.c)));
            boolean z = cursor.getInt(cursor.getColumnIndex(C0116a.f)) == 1;
            List listEmptyList = Collections.emptyList();
            JSONArray jSONArray = new JSONArray(cursor.getString(cursor.getColumnIndex(C0116a.e)));
            if (jSONArray.length() > 0) {
                listEmptyList = new ArrayList();
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    listEmptyList.add(jSONArray.getString(i4));
                }
            }
            List list = listEmptyList;
            if (crypto != null) {
                String strDecString = crypto.decString(cursor.getString(cursor.getColumnIndex(C0116a.g)));
                strOptString = !TextUtils.isEmpty(strDecString) ? new JSONObject(strDecString).optString("requestId") : null;
                str = strDecString;
            } else {
                strOptString = null;
                str = null;
            }
            if (!TextUtils.isEmpty(strOptString)) {
                bVarA = com.salesforce.marketingcloud.analytics.b.a(dateD, i3, i2, list, strOptString, z);
            } else if (list.size() > 0) {
                bVarA = com.salesforce.marketingcloud.analytics.b.a(dateD, i3, i2, (List<String>) list, z);
            } else {
                bVarA = com.salesforce.marketingcloud.analytics.b.a(dateD, i3, i2);
                bVarA.a(z);
            }
            bVarA.a(cursor.getInt(cursor.getColumnIndex("id")));
            bVarA.b(cursor.getInt(cursor.getColumnIndex("value")));
            bVarA.b(str);
            if (i3 == 1 && crypto != null) {
                bVarA.d(crypto.decString(cursor.getString(cursor.getColumnIndex("predictive_intelligence_identifier"))));
                String string = cursor.getString(cursor.getColumnIndex(C0116a.h));
                if (!TextUtils.isEmpty(string)) {
                    bVarA.c(crypto.decString(string));
                }
            }
            return bVarA;
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(i, e2, "Failed to create our analytic item from storage.", new Object[0]);
            return null;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public List<com.salesforce.marketingcloud.analytics.b> g(@NonNull Crypto crypto) {
        return b(a(g, a("(%1$s=? OR %1$s=?) AND %2$s=?", C0116a.d, C0116a.f), new String[]{String.valueOf(13), String.valueOf(11), String.valueOf(0)}), crypto);
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public List<com.salesforce.marketingcloud.analytics.b> h(@NonNull Crypto crypto) {
        return b(1, crypto);
    }

    private static ContentValues c(@NonNull com.salesforce.marketingcloud.analytics.b bVar, @NonNull Crypto crypto) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C0116a.c, com.salesforce.marketingcloud.util.j.a(bVar.b()));
        contentValues.put(C0116a.i, Integer.valueOf(bVar.j()));
        contentValues.put(C0116a.d, Integer.valueOf(bVar.a()));
        contentValues.put("value", Integer.valueOf(bVar.g()));
        contentValues.put(C0116a.f, Integer.valueOf(bVar.h() ? 1 : 0));
        contentValues.put(C0116a.e, new JSONArray((Collection) bVar.i()).toString());
        if (bVar.j() == 0) {
            if (bVar.c() != null) {
                contentValues.put(C0116a.g, crypto.encString(bVar.c()));
            }
            contentValues.put("predictive_intelligence_identifier", (String) null);
            contentValues.put(C0116a.h, (String) null);
        } else if (bVar.j() == 1) {
            contentValues.put("predictive_intelligence_identifier", crypto.encString(bVar.f()));
            contentValues.put(C0116a.h, crypto.encString(bVar.e()));
            contentValues.put(C0116a.g, (String) null);
        }
        return contentValues;
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public int d() {
        return h(0);
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public int b(com.salesforce.marketingcloud.analytics.b bVar, @NonNull Crypto crypto) throws Exception {
        return a(c(bVar, crypto), a("%s = ?", "id"), new String[]{String.valueOf(bVar.d())});
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public boolean c(int i2) {
        return DatabaseUtils.queryNumEntries(this.c, o(), a("(%1$s=? OR %1$s=?) AND %2$s=? AND %3$s=? AND %4$s=?", C0116a.d, C0116a.i, "value", C0116a.f), new String[]{String.valueOf(4), String.valueOf(5), String.valueOf(i2), String.valueOf(0), String.valueOf(0)}) > 0;
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public List<com.salesforce.marketingcloud.analytics.b> b(@NonNull Crypto crypto, int i2) {
        return b(a(g, a("%s=? AND %s=?", C0116a.i, C0116a.f), new String[]{String.valueOf(0), AppEventsConstants.EVENT_PARAM_VALUE_YES}, null, null, a("%s ASC", "id"), String.valueOf(i2)), crypto);
    }

    private List<com.salesforce.marketingcloud.analytics.b> b(int i2, @Nullable Crypto crypto) {
        return b(a(g, a("(%1$s=? OR %1$s=?) AND %2$s=? AND %3$s=? AND %4$s=?", C0116a.d, C0116a.i, "value", C0116a.f), new String[]{String.valueOf(4), String.valueOf(5), String.valueOf(i2), String.valueOf(0), String.valueOf(0)}, null, null, a("%s ASC", "id")), crypto);
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public List<com.salesforce.marketingcloud.analytics.b> b(@NonNull Region region, @NonNull Crypto crypto) {
        return b(a(g, a("(%1$s=? OR %1$s=?) AND %2$s LIKE ? AND %3$s=?", C0116a.d, C0116a.e, C0116a.f), new String[]{String.valueOf(13), String.valueOf(11), a("%%%s%%", region.id()), String.valueOf(0)}), crypto);
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public void a(com.salesforce.marketingcloud.analytics.b bVar, @NonNull Crypto crypto) throws Exception {
        int i2 = bVar.j() == 0 ? 0 : 1;
        int iH = h(i2);
        if (iH + 1 > 999) {
            a(iH, 999, i2);
        }
        bVar.a((int) a(c(bVar, crypto)));
    }

    private void a(int i2, int i3, int i4) throws Exception {
        i(a("%s IN ( SELECT %s FROM %s WHERE %s=%d ORDER BY %s ASC LIMIT %d )", "id", "id", e, C0116a.i, Integer.valueOf(i4), "id", Integer.valueOf((i2 + 1) - i3)));
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public int b(int i2) {
        return a(a("%s = ? AND %s IN (%s)", C0116a.i, C0116a.d, TextUtils.join(",", com.salesforce.marketingcloud.analytics.b.C)), new String[]{String.valueOf(i2)});
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public List<com.salesforce.marketingcloud.analytics.b> a(@NonNull Crypto crypto, int i2) {
        return b(a(g, a("%s=? AND %s=?", C0116a.i, C0116a.f), new String[]{String.valueOf(1), String.valueOf(1)}, null, null, a("%s ASC", C0116a.c), String.valueOf(i2)), crypto);
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public int a(String[] strArr) {
        return i(a("%s IN (%s)", "id", TextUtils.join(",", strArr)));
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public int a() {
        try {
            return a("analytic_product_type =? AND event_date <= ?", new String[]{String.valueOf(1), com.salesforce.marketingcloud.util.j.a(new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(14L)))});
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(i, e2, "Unable to purge old analytic data.", new Object[0]);
            return 0;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.a
    public int a(int i2) {
        return a(a("%s = ? AND %s NOT IN (%s)", C0116a.i, C0116a.d, TextUtils.join(",", com.salesforce.marketingcloud.analytics.b.C)), new String[]{String.valueOf(i2)});
    }
}
