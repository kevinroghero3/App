package com.salesforce.marketingcloud.storage.db.upgrades;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.salesforce.marketingcloud.util.Crypto;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final String a = com.salesforce.marketingcloud.g.a("Version10ToVersion11");

    private a() {
    }

    private static void a(SQLiteDatabase sQLiteDatabase, Crypto crypto) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("CREATE TEMPORARY TABLE analytic_item_temp (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL)");
            sQLiteDatabase.execSQL("INSERT INTO analytic_item_temp SELECT id,event_date,analytic_product_type,analytic_type,value,ready_to_send,object_ids,json_payload,request_id,predictive_intelligence_identifier FROM analytic_item");
            sQLiteDatabase.execSQL("DROP TABLE analytic_item");
            sQLiteDatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, enc_json_pi_payload VARCHAR, enc_json_et_payload VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL)");
            String str = null;
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM analytic_item_temp", null);
            if (cursorRawQuery != null) {
                if (cursorRawQuery.moveToFirst()) {
                    while (true) {
                        ContentValues contentValues = new ContentValues();
                        try {
                            contentValues.put("id", Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("id"))));
                            contentValues.put(com.salesforce.marketingcloud.storage.db.a.C0116a.c, cursorRawQuery.getString(cursorRawQuery.getColumnIndex(com.salesforce.marketingcloud.storage.db.a.C0116a.c)));
                            contentValues.put(com.salesforce.marketingcloud.storage.db.a.C0116a.i, Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(com.salesforce.marketingcloud.storage.db.a.C0116a.i))));
                            contentValues.put(com.salesforce.marketingcloud.storage.db.a.C0116a.d, Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(com.salesforce.marketingcloud.storage.db.a.C0116a.d))));
                            contentValues.put("value", Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("value"))));
                            contentValues.put(com.salesforce.marketingcloud.storage.db.a.C0116a.f, Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(com.salesforce.marketingcloud.storage.db.a.C0116a.f))));
                            contentValues.put(com.salesforce.marketingcloud.storage.db.a.C0116a.e, cursorRawQuery.getString(cursorRawQuery.getColumnIndex(com.salesforce.marketingcloud.storage.db.a.C0116a.e)));
                            contentValues.put(com.salesforce.marketingcloud.storage.db.a.C0116a.h, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("json_payload")));
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(SDKAnalyticsEvents.PARAMETER_REQUEST_ID));
                            if (!TextUtils.isEmpty(string)) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("requestId", string);
                                try {
                                    contentValues.put(com.salesforce.marketingcloud.storage.db.a.C0116a.g, crypto.encString(jSONObject.toString()));
                                } catch (Exception e) {
                                    e = e;
                                    com.salesforce.marketingcloud.g.b(a, e, "Failed to update item in Analytics local storage during upgrade.", new Object[0]);
                                }
                            }
                            sQLiteDatabase.insert(com.salesforce.marketingcloud.storage.db.a.e, str, contentValues);
                        } catch (Exception e2) {
                            e = e2;
                        }
                        if (!cursorRawQuery.moveToNext()) {
                            break;
                        } else {
                            str = null;
                        }
                    }
                }
                cursorRawQuery.close();
            }
            sQLiteDatabase.execSQL("DROP TABLE analytic_item_temp");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e3) {
            com.salesforce.marketingcloud.g.b(a, e3, "Failed to upgrade Analytics local storage.  Starting fresh.  Some analytics items may have been lost.", new Object[0]);
            sQLiteDatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, enc_json_pi_payload VARCHAR, enc_json_et_payload VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL)");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e4) {
            com.salesforce.marketingcloud.g.b(a, e4, "Failed to create local storage for Analytics.", new Object[0]);
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static void b(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull Crypto crypto) {
        a(sQLiteDatabase, crypto);
    }
}
