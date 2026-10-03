package com.salesforce.marketingcloud.storage.db.upgrades;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class j {
    private static final String a = com.salesforce.marketingcloud.g.a("Version7ToVersion8");

    private j() {
    }

    public static void a(@NonNull SQLiteDatabase sQLiteDatabase) {
        boolean z;
        int i;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT id,read,message_deleted FROM cloud_page_messages WHERE message_type=1", null);
            if (cursorRawQuery != null) {
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        z = true;
                        try {
                            if (cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("message_deleted")) == 1) {
                                i = 2;
                            } else {
                                i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("read")) == 1 ? 1 : -1;
                            }
                            if (i != -1) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("id", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id")));
                                contentValues.put("status", Integer.valueOf(i));
                                sQLiteDatabase.insert("inbox_message_status", null, contentValues);
                            }
                        } catch (Exception e) {
                            e = e;
                            com.salesforce.marketingcloud.g.b(a, e, "Unable to set inbox message statuses for legacy messages", new Object[0]);
                        }
                    } while (cursorRawQuery.moveToNext());
                } else {
                    z = false;
                }
                cursorRawQuery.close();
                if (z) {
                    try {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("message_type", (Integer) 8);
                        sQLiteDatabase.update("cloud_page_messages", contentValues2, null, null);
                    } catch (Exception e2) {
                        com.salesforce.marketingcloud.g.b(a, e2, "Unable to update message_type for legacy Inbox messages.  Attempting to delete them.", new Object[0]);
                        try {
                            sQLiteDatabase.execSQL("DELETE FROM cloud_page_messages WHERE message_type=1", null);
                        } catch (Exception e3) {
                            com.salesforce.marketingcloud.g.b(a, e3, "Unable to delete legacy Inbox messages.", new Object[0]);
                        }
                    }
                }
            }
        } catch (Exception e4) {
            e = e4;
            z = false;
        }
        try {
            sQLiteDatabase.execSQL("DELETE FROM cloud_page_messages WHERE message_type=1", null);
        } catch (Exception e5) {
            com.salesforce.marketingcloud.g.b(a, e5, "Final attempt to delete legacy Inbox messages failed.", new Object[0]);
        }
    }
}
