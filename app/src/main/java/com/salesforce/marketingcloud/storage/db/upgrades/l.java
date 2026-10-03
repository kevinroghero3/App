package com.salesforce.marketingcloud.storage.db.upgrades;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class l {
    private static final String a = com.salesforce.marketingcloud.g.a("Version9ToVersion10");

    private l() {
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0226 A[EDGE_INSN: B:125:0x0226->B:66:0x0226 BREAK  A[LOOP:1: B:110:0x0036->B:67:0x0227], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x015d  */
    /* JADX WARN: Code duplicated, block: B:67:0x0227 A[LOOP:1: B:110:0x0036->B:67:0x0227, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x0261 A[Catch: all -> 0x0287, Exception -> 0x0289, TryCatch #3 {Exception -> 0x0289, blocks: (B:81:0x0258, B:83:0x0261, B:86:0x0269, B:88:0x0280, B:89:0x0283), top: B:105:0x0258, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0267  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void a(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull Crypto crypto) throws Throwable {
        String str;
        Cursor cursorRawQuery;
        String str2;
        String str3;
        String str4;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        String str5 = "url";
        String str6 = "end_date";
        String str7 = "id";
        try {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS inbox_messages;");
                sQLiteDatabase2.execSQL("CREATE TABLE inbox_messages(id TEXT PRIMARY KEY, start_date INTEGER DEFAULT NULL, end_date INTEGER DEFAULT NULL, is_deleted INTEGER DEFAULT 0, is_read INTEGER DEFAULT 0, is_dirty INTEGER DEFAULT 0, message_hash TEXT DEFAULT NULL, message_json TEXT);");
                Cursor cursorRawQuery2 = sQLiteDatabase2.rawQuery("SELECT * FROM cloud_page_messages", null);
                if (cursorRawQuery2 != null) {
                    if (cursorRawQuery2.moveToFirst()) {
                        while (true) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                ContentValues contentValues = new ContentValues();
                                try {
                                    try {
                                        String string = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex(str7));
                                        contentValues.put(str7, string);
                                        jSONObject.put(str7, string);
                                        String string2 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("start_date"));
                                        if (string2 != null) {
                                            try {
                                                str = str7;
                                                try {
                                                    contentValues.put("start_date", Long.valueOf(com.salesforce.marketingcloud.util.j.d(string2).getTime()));
                                                    jSONObject.put("startDateUtc", string2);
                                                } catch (Exception e) {
                                                    e = e;
                                                    sQLiteDatabase2 = sQLiteDatabase;
                                                    str3 = str5;
                                                    str4 = str6;
                                                    try {
                                                        com.salesforce.marketingcloud.g.b(a, e, "Unable to update Inbox message.", new Object[0]);
                                                        if (!cursorRawQuery2.moveToNext()) {
                                                            break;
                                                            cursorRawQuery2.close();
                                                            sQLiteDatabase.setTransactionSuccessful();
                                                            sQLiteDatabase.endTransaction();
                                                            sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS cloud_page_messages");
                                                            sQLiteDatabase.beginTransaction();
                                                            try {
                                                                cursorRawQuery = sQLiteDatabase2.rawQuery("SELECT id FROM inbox_message_status", null);
                                                                if (cursorRawQuery != null) {
                                                                    if (cursorRawQuery.moveToFirst()) {
                                                                        str2 = str;
                                                                        do {
                                                                            sQLiteDatabase2.execSQL("UPDATE inbox_messages SET is_dirty=1 WHERE id=?", new String[]{cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str2))});
                                                                        } while (cursorRawQuery.moveToNext());
                                                                    }
                                                                    cursorRawQuery.close();
                                                                }
                                                                sQLiteDatabase.setTransactionSuccessful();
                                                            } catch (Exception e2) {
                                                                com.salesforce.marketingcloud.g.b(a, e2, "Unable to update inbox status values", new Object[0]);
                                                            }
                                                            sQLiteDatabase.endTransaction();
                                                            sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS inbox_message_status");
                                                        }
                                                        str7 = str;
                                                        str5 = str3;
                                                        str6 = str4;
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        com.salesforce.marketingcloud.g.b(a, e, "Unable to update any Inbox messages.", new Object[0]);
                                                    }
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                                str = str7;
                                            }
                                        } else {
                                            str = str7;
                                        }
                                        String string3 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex(str6));
                                        if (string3 != null) {
                                            contentValues.put(str6, Long.valueOf(com.salesforce.marketingcloud.util.j.d(string3).getTime()));
                                            jSONObject.put("endDateUtc", string3);
                                        }
                                        jSONObject.put("messageType", 8);
                                        jSONObject.put("contentType", 2);
                                        jSONObject.put(str5, crypto.decString(cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex(str5))));
                                        jSONObject.put("subject", crypto.decString(cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("subject"))));
                                        contentValues.put("is_read", Integer.valueOf(cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndex("read"))));
                                        contentValues.put("is_deleted", Integer.valueOf(cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndex("message_deleted"))));
                                        jSONObject.put("custom", crypto.decString(cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("custom"))));
                                        String strDecString = crypto.decString(cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("keys")));
                                        if (strDecString != null) {
                                            try {
                                                Map<String, String> mapB = com.salesforce.marketingcloud.util.j.b(strDecString);
                                                if (mapB.isEmpty()) {
                                                    str3 = str5;
                                                    str4 = str6;
                                                } else {
                                                    JSONArray jSONArray = new JSONArray();
                                                    Iterator<Map.Entry<String, String>> it2 = mapB.entrySet().iterator();
                                                    while (it2.hasNext()) {
                                                        Map.Entry<String, String> next = it2.next();
                                                        Iterator<Map.Entry<String, String>> it3 = it2;
                                                        JSONObject jSONObject2 = new JSONObject();
                                                        str3 = str5;
                                                        str4 = str6;
                                                        try {
                                                            jSONObject2.put("key", next.getKey());
                                                            jSONObject2.put("value", next.getValue());
                                                            jSONArray.put(jSONObject2);
                                                            it2 = it3;
                                                            str5 = str3;
                                                            str6 = str4;
                                                        } catch (Exception e5) {
                                                            e = e5;
                                                            sQLiteDatabase2 = sQLiteDatabase;
                                                            com.salesforce.marketingcloud.g.b(a, e, "Unable to update Inbox message.", new Object[0]);
                                                            if (!cursorRawQuery2.moveToNext()) {
                                                                break;
                                                                cursorRawQuery2.close();
                                                                sQLiteDatabase.setTransactionSuccessful();
                                                                sQLiteDatabase.endTransaction();
                                                                sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS cloud_page_messages");
                                                                sQLiteDatabase.beginTransaction();
                                                                cursorRawQuery = sQLiteDatabase2.rawQuery("SELECT id FROM inbox_message_status", null);
                                                                if (cursorRawQuery != null) {
                                                                    if (cursorRawQuery.moveToFirst()) {
                                                                        str2 = str;
                                                                        do {
                                                                            sQLiteDatabase2.execSQL("UPDATE inbox_messages SET is_dirty=1 WHERE id=?", new String[]{cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str2))});
                                                                        } while (cursorRawQuery.moveToNext());
                                                                    }
                                                                    cursorRawQuery.close();
                                                                }
                                                                sQLiteDatabase.setTransactionSuccessful();
                                                                sQLiteDatabase.endTransaction();
                                                                sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS inbox_message_status");
                                                            }
                                                            str7 = str;
                                                            str5 = str3;
                                                            str6 = str4;
                                                        }
                                                    }
                                                    str3 = str5;
                                                    str4 = str6;
                                                    jSONObject.put("keys", jSONArray);
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                str3 = str5;
                                                str4 = str6;
                                            }
                                        } else {
                                            str3 = str5;
                                            str4 = str6;
                                        }
                                        jSONObject.put("title", crypto.decString(cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("title"))));
                                        jSONObject.put("alert", crypto.decString(cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("alert"))));
                                        jSONObject.put("sound", cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("sound")));
                                        String strDecString2 = crypto.decString(cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex(com.salesforce.marketingcloud.storage.db.i.a.e)));
                                        String strDecString3 = crypto.decString(cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex(com.salesforce.marketingcloud.storage.db.i.a.f)));
                                        if (strDecString2 != null || strDecString3 != null) {
                                            JSONObject jSONObject3 = new JSONObject();
                                            if (strDecString2 != null) {
                                                jSONObject3.put(com.salesforce.marketingcloud.messages.inbox.b.k, strDecString2);
                                            }
                                            if (strDecString3 != null) {
                                                jSONObject3.put(com.salesforce.marketingcloud.messages.inbox.b.l, strDecString3);
                                            }
                                            jSONObject.put("media", jSONObject3);
                                        }
                                        String string4 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("message_hash"));
                                        contentValues.put("message_hash", string4);
                                        jSONObject.put("hash", string4);
                                        jSONObject.put("requestId", cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex(SDKAnalyticsEvents.PARAMETER_REQUEST_ID)));
                                        contentValues.put("message_json", crypto.encString(jSONObject.toString()));
                                        sQLiteDatabase2 = sQLiteDatabase;
                                        try {
                                            sQLiteDatabase2.insert(com.salesforce.marketingcloud.storage.db.g.e, null, contentValues);
                                        } catch (Exception e7) {
                                            e = e7;
                                            com.salesforce.marketingcloud.g.b(a, e, "Unable to update Inbox message.", new Object[0]);
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        sQLiteDatabase2 = sQLiteDatabase;
                                        str3 = str5;
                                        str4 = str6;
                                        str = str7;
                                        com.salesforce.marketingcloud.g.b(a, e, "Unable to update Inbox message.", new Object[0]);
                                        if (!cursorRawQuery2.moveToNext()) {
                                            break;
                                            cursorRawQuery2.close();
                                            sQLiteDatabase.setTransactionSuccessful();
                                            sQLiteDatabase.endTransaction();
                                            sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS cloud_page_messages");
                                            sQLiteDatabase.beginTransaction();
                                            cursorRawQuery = sQLiteDatabase2.rawQuery("SELECT id FROM inbox_message_status", null);
                                            if (cursorRawQuery != null) {
                                                if (cursorRawQuery.moveToFirst()) {
                                                    str2 = str;
                                                    do {
                                                        sQLiteDatabase2.execSQL("UPDATE inbox_messages SET is_dirty=1 WHERE id=?", new String[]{cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str2))});
                                                    } while (cursorRawQuery.moveToNext());
                                                }
                                                cursorRawQuery.close();
                                            }
                                            sQLiteDatabase.setTransactionSuccessful();
                                            sQLiteDatabase.endTransaction();
                                            sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS inbox_message_status");
                                        }
                                        str7 = str;
                                        str5 = str3;
                                        str6 = str4;
                                    }
                                    if (!cursorRawQuery2.moveToNext()) {
                                        break;
                                    }
                                    str7 = str;
                                    str5 = str3;
                                    str6 = str4;
                                } catch (Throwable th) {
                                    th = th;
                                    sQLiteDatabase.endTransaction();
                                    throw th;
                                }
                            } catch (Exception e9) {
                                e = e9;
                            }
                        }
                    } else {
                        str = "id";
                    }
                    cursorRawQuery2.close();
                } else {
                    str = "id";
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e = e10;
            str = "id";
        }
        sQLiteDatabase.endTransaction();
        sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS cloud_page_messages");
        sQLiteDatabase.beginTransaction();
        try {
            cursorRawQuery = sQLiteDatabase2.rawQuery("SELECT id FROM inbox_message_status", null);
            if (cursorRawQuery != null) {
                if (cursorRawQuery.moveToFirst()) {
                    str2 = str;
                    do {
                        sQLiteDatabase2.execSQL("UPDATE inbox_messages SET is_dirty=1 WHERE id=?", new String[]{cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str2))});
                    } while (cursorRawQuery.moveToNext());
                }
                cursorRawQuery.close();
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS inbox_message_status");
        } catch (Throwable th3) {
            sQLiteDatabase.endTransaction();
            throw th3;
        }
    }

    public static void b(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull Crypto crypto) throws Throwable {
        a(sQLiteDatabase, crypto);
        b(sQLiteDatabase);
        a(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    private static void c(@NonNull SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("CREATE TABLE region_messages ( region_id TEXT, message_id TEXT, FOREIGN KEY (region_id) REFERENCES regions(id) ON DELETE CASCADE, PRIMARY KEY (region_id, message_id));");
            sQLiteDatabase.execSQL("INSERT INTO region_messages SELECT region_id,message_id FROM region_message;");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS region_message");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            com.salesforce.marketingcloud.g.b(a, e, "Unable to create region_messages table", new Object[0]);
        } catch (SQLException e2) {
            com.salesforce.marketingcloud.g.b(a, e2, "Unable to create region_messages table and migrate data from region_message.", new Object[0]);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS region_messages");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS region_message");
            sQLiteDatabase.execSQL("CREATE TABLE region_messages ( region_id TEXT, message_id TEXT, FOREIGN KEY (region_id) REFERENCES regions(id) ON DELETE CASCADE, PRIMARY KEY (region_id, message_id));");
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("CREATE TABLE triggers (id TEXT PRIMARY KEY, _key TEXT, start_date INTEGER DEFAULT NULL, _trigger TEXT, app_open_count INTEGER DEFAULT 0);");
                sQLiteDatabase.execSQL("CREATE TABLE in_app_messages(id TEXT PRIMARY KEY, priority INTEGER DEFAULT 999, start_date DATETIME, end_date DATETIME, modified_date DATETIME, display_limit INTEGER DEFAULT 1, media_url TEXT DEFAULT NULL, message_json TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE iam_state(id TEXT PRIMARY KEY, display_count integer DEFAULT 0, FOREIGN KEY (id) REFERENCES in_app_messages(id) ON DELETE CASCADE);");
                sQLiteDatabase.execSQL("CREATE TRIGGER iam_state_init AFTER INSERT ON in_app_messages BEGIN INSERT INTO iam_state (id) VALUES (NEW.id); END;");
                sQLiteDatabase.execSQL("CREATE VIEW iam_view AS SELECT in_app_messages.id,in_app_messages.priority,in_app_messages.start_date,in_app_messages.end_date,in_app_messages.modified_date,in_app_messages.display_limit,in_app_messages.message_json,iam_state.display_count FROM in_app_messages INNER JOIN iam_state ON iam_state.id = in_app_messages.id;");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(a, e, "Unable to create in app message table", new Object[0]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("CREATE TABLE device_stats(id INTEGER PRIMARY KEY, type INTEGER, date INTEGER, event_data TEXT, in_transit INTEGER DEFAULT 0, ready_to_send INTEGER DEFAULT 0);");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(a, e, "Unable to create device stats table.", new Object[0]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
