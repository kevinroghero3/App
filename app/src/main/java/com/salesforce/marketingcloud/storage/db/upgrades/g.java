package com.salesforce.marketingcloud.storage.db.upgrades;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class g {
    private static final String a = com.salesforce.marketingcloud.g.a("Version4ToVersion5");

    private g() {
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN custom VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN keys VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN title VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN alert VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN sound VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN mediaUrl VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN mediaAlt VARCHAR;");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            com.salesforce.marketingcloud.g.b(a, e, "Unable to create cloud_page_messages table", new Object[0]);
        } catch (SQLException e2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cloud_page_messages");
            sQLiteDatabase.execSQL("CREATE TABLE cloud_page_messages (id VARCHAR PRIMARY KEY, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, subject VARCHAR, read SMALLINT, message_deleted SMALLINT, custom VARCHAR, keys VARCHAR, title VARCHAR, alert VARCHAR, sound VARCHAR, mediaUrl VARCHAR, mediaAlt VARCHAR, message_hash VARCHAR, request_id VARCHAR);");
            sQLiteDatabase.setTransactionSuccessful();
            com.salesforce.marketingcloud.g.b(a, e2, "Unable to update cloud_page_messages table", new Object[0]);
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static void b(@NonNull SQLiteDatabase sQLiteDatabase) {
        try {
            Cursor cursorQuery = sQLiteDatabase.query("cloud_page_messages", null, null, null, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.getColumnIndex("custom") == -1) {
                    a(sQLiteDatabase);
                }
                cursorQuery.close();
            }
        } catch (Exception unused) {
            com.salesforce.marketingcloud.g.b(a, "Failed to update cloud_page_messages table.", new Object[0]);
        }
    }
}
