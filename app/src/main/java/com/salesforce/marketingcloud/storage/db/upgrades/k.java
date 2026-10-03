package com.salesforce.marketingcloud.storage.db.upgrades;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class k {
    private static final String a = com.salesforce.marketingcloud.g.a("Version8ToVersion9");

    private k() {
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("ALTER TABLE analytic_item ADD COLUMN predictive_intelligence_identifier VARCHAR DEFAULT NULL");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            com.salesforce.marketingcloud.g.b(a, e, "Unable to create analytic_item table", new Object[0]);
        } catch (SQLException e2) {
            com.salesforce.marketingcloud.g.b(a, e2, "Unable to update analytic_item table", new Object[0]);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS analytic_item");
            sQLiteDatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL);");
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static void b(@NonNull SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }
}
