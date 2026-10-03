package com.salesforce.marketingcloud.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import com.salesforce.marketingcloud.util.Crypto;
import io.sentry.protocol.SentryThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class f extends b implements com.salesforce.marketingcloud.storage.e {
    public static final String e = "in_app_messages";
    public static final String f = "iam_state";
    public static final String g = "iam_view";
    public static final String h = "iam_state_init";
    private static final String i = com.salesforce.marketingcloud.g.a("InAppMessageDbStorage");
    private static final String j = "id IN (%s) AND (display_count < display_limit) AND (start_date IS NULL OR start_date < ?) AND (end_date IS NULL OR end_date > ?) ORDER BY   priority ASC,  modified_date DESC LIMIT 1";

    public f(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE iam_state(id TEXT PRIMARY KEY, display_count integer default 0, FOREIGN KEY (id) REFERENCES in_app_messages(id) ON DELETE CASCADE);");
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TRIGGER iam_state_init AFTER INSERT ON in_app_messages BEGIN INSERT INTO iam_state (id) VALUES (NEW.id); END;");
    }

    private static void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE VIEW iam_view AS SELECT in_app_messages.id,in_app_messages.priority,in_app_messages.start_date,in_app_messages.end_date,in_app_messages.modified_date,in_app_messages.display_limit,in_app_messages.message_json,iam_state.display_count FROM in_app_messages INNER JOIN iam_state ON iam_state.id = in_app_messages.id;");
    }

    private static void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE in_app_messages(id TEXT PRIMARY KEY, priority INTEGER DEFAULT 999, start_date INTEGER DEFAULT NULL, end_date INTEGER DEFAULT NULL, modified_date INTEGER DEFAULT NULL, display_limit INTEGER DEFAULT 1, media_url TEXT DEFAULT NULL, message_json TEXT);");
    }

    static void e(SQLiteDatabase sQLiteDatabase) {
        h(sQLiteDatabase);
        f(sQLiteDatabase);
        g(sQLiteDatabase);
        sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS iam_state_init");
    }

    private static void f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS iam_state");
    }

    private static void g(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP VIEW IF EXISTS iam_view");
    }

    private static void h(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS in_app_messages");
    }

    static void i(SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase);
        a(sQLiteDatabase);
        b(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    private static boolean j(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT id,display_count FROM iam_state");
            return false;
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.e(i, e2, "%s is invalid", f);
            return true;
        }
    }

    private static boolean k(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT id,priority,start_date,end_date,modified_date,display_limit,media_url,message_json FROM in_app_messages");
            return false;
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.e(i, e2, "%s is invalid", e);
            return true;
        }
    }

    private static boolean l(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT id,priority,start_date,end_date,modified_date,display_limit,message_json,display_count FROM iam_view");
            return false;
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.e(i, e2, "%s is invalid", g);
            return true;
        }
    }

    static boolean m(SQLiteDatabase sQLiteDatabase) {
        boolean z;
        if (k(sQLiteDatabase)) {
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    h(sQLiteDatabase);
                    d(sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e2) {
                    com.salesforce.marketingcloud.g.b(i, e2, "Unable to recover %s", e);
                }
                sQLiteDatabase.endTransaction();
                if (k(sQLiteDatabase)) {
                    return false;
                }
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
        }
        if (j(sQLiteDatabase)) {
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    f(sQLiteDatabase);
                    a(sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e3) {
                    com.salesforce.marketingcloud.g.b(i, e3, "Unable to recover %s", f);
                }
                sQLiteDatabase.endTransaction();
                if (j(sQLiteDatabase)) {
                    return false;
                }
                z = true;
            } catch (Throwable th2) {
                sQLiteDatabase.endTransaction();
                throw th2;
            }
        } else {
            z = false;
        }
        if (l(sQLiteDatabase)) {
            try {
                g(sQLiteDatabase);
                c(sQLiteDatabase);
            } catch (Exception e4) {
                com.salesforce.marketingcloud.g.b(i, e4, "Unable to recover %s", g);
            }
            if (l(sQLiteDatabase)) {
                return false;
            }
        }
        try {
            if (!c.a(sQLiteDatabase, com.salesforce.marketingcloud.messages.inbox.b.f71n, h)) {
                if (z) {
                }
                return true;
            }
            try {
                b(sQLiteDatabase);
            } catch (Exception e5) {
                com.salesforce.marketingcloud.g.b(i, e5, "Unable to recover %s", h);
            }
            if (c.a(sQLiteDatabase, com.salesforce.marketingcloud.messages.inbox.b.f71n, h)) {
                return false;
            }
            sQLiteDatabase.execSQL("INSERT OR IGNORE INTO iam_state(id) SELECT id FROM in_app_messages;");
        } catch (Exception e6) {
            com.salesforce.marketingcloud.g.b(i, e6, "Unable to correct relationship between iam data and iam state.", new Object[0]);
        }
        return true;
    }

    @Override // com.salesforce.marketingcloud.storage.db.b
    String o() {
        return null;
    }

    private static String a(@NonNull Cursor cursor, @NonNull Crypto crypto) {
        try {
            return crypto.decString(cursor.getString(cursor.getColumnIndex("media_url")));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(i, e2, "Unable to retrieve media_url from db cursor", new Object[0]);
            return null;
        }
    }

    private static ContentValues b(InAppMessage inAppMessage, @NonNull Crypto crypto) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", inAppMessage.id());
        contentValues.put(SentryThread.JsonKeys.PRIORITY, Integer.valueOf(inAppMessage.priority()));
        contentValues.put("start_date", inAppMessage.startDateUtc() != null ? Long.valueOf(inAppMessage.startDateUtc().getTime()) : null);
        contentValues.put("end_date", inAppMessage.endDateUtc() != null ? Long.valueOf(inAppMessage.endDateUtc().getTime()) : null);
        contentValues.put("modified_date", Long.valueOf(inAppMessage.modifiedDateUtc().getTime()));
        contentValues.put("display_limit", Integer.valueOf(inAppMessage.displayLimit()));
        InAppMessage.Media media = inAppMessage.media();
        if (media != null && !TextUtils.isEmpty(media.url())) {
            contentValues.put("media_url", crypto.encString(media.url()));
        }
        contentValues.put("message_json", crypto.encString(com.salesforce.marketingcloud.internal.c.b(inAppMessage).toString()));
        return contentValues;
    }

    @Override // com.salesforce.marketingcloud.storage.e
    public JSONArray c(@NonNull Crypto crypto) {
        JSONArray jSONArray = new JSONArray();
        Cursor cursorA = a(g, new String[]{"message_json", "display_count"}, null, null);
        if (cursorA != null) {
            try {
                if (cursorA.moveToFirst()) {
                    int columnIndex = cursorA.getColumnIndex("message_json");
                    int columnIndex2 = cursorA.getColumnIndex("display_count");
                    do {
                        try {
                            JSONObject jSONObject = new JSONObject(crypto.decString(cursorA.getString(columnIndex)));
                            jSONObject.put("displayCount", cursorA.getInt(columnIndex2));
                            jSONArray.put(jSONObject);
                        } catch (Exception e2) {
                            com.salesforce.marketingcloud.g.b(i, e2, "Unable to read message information from cursor.", new Object[0]);
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

    @Override // com.salesforce.marketingcloud.storage.e
    public List<String> d(@NonNull Crypto crypto) {
        ArrayList arrayList = null;
        Cursor cursorA = a(e, new String[]{"media_url"}, "media_url IS NOT NULL", null);
        try {
            if (cursorA.moveToFirst()) {
                arrayList = new ArrayList(cursorA.getCount());
                do {
                    String strA = a(cursorA, crypto);
                    if (strA != null) {
                        arrayList.add(strA);
                    }
                } while (cursorA.moveToNext());
            }
            cursorA.close();
            return arrayList != null ? arrayList : Collections.emptyList();
        } catch (Throwable th) {
            cursorA.close();
            throw th;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.e
    public int a(@NonNull InAppMessage inAppMessage, @NonNull Crypto crypto) throws Exception {
        ContentValues contentValuesB = b(inAppMessage, crypto);
        if (this.c.update(e, contentValuesB, "id = ?", new String[]{inAppMessage.id()}) != 0) {
            return 2;
        }
        this.c.insert(e, null, contentValuesB);
        return 1;
    }

    @Override // com.salesforce.marketingcloud.storage.e
    public InAppMessage a(@NonNull String str, @NonNull Crypto crypto) {
        Cursor cursorA = a(e, new String[]{"message_json"}, "id = ?", new String[]{str});
        InAppMessage inAppMessageB = null;
        if (cursorA != null) {
            inAppMessageB = cursorA.moveToFirst() ? b(cursorA, crypto) : null;
            cursorA.close();
        }
        return inAppMessageB;
    }

    private static InAppMessage b(@NonNull Cursor cursor, @NonNull Crypto crypto) {
        try {
            return new InAppMessage(new JSONObject(crypto.decString(cursor.getString(cursor.getColumnIndex("message_json")))));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(i, e2, "Unable to retrieve InAppMessage from db cursor", new Object[0]);
            return null;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.e
    public void b(@NonNull String str, int i2) {
        if (str == null || i2 < 0) {
            return;
        }
        this.c.execSQL("UPDATE iam_state SET display_count = MAX(display_count, ?) WHERE id = ?", new Object[]{Integer.valueOf(i2), str});
    }

    @Override // com.salesforce.marketingcloud.storage.e
    public int a(@NonNull Collection<String> collection) {
        if (collection.size() == 0) {
            return this.c.delete(e, null, null);
        }
        try {
            return a(e, collection);
        } catch (SQLException unused) {
            com.salesforce.marketingcloud.g.e(i, "Unable to clean up %s table.", e);
            return 0;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.e
    public InAppMessage a(@NonNull Collection<String> collection, @NonNull Crypto crypto) {
        InAppMessage inAppMessageB = null;
        if (collection.size() > 0) {
            this.c.beginTransaction();
            b(g, collection);
            String strA = c.a(j, c.a("SELECT %1$s.id FROM %1$s LEFT JOIN tmp_%1$s ON %1$s.id = tmp_%1$s.id WHERE tmp_%1$s.id IS NOT NULL", g));
            String strValueOf = String.valueOf(System.currentTimeMillis());
            Cursor cursorA = a(g, new String[]{"message_json"}, strA, new String[]{strValueOf, strValueOf});
            if (cursorA != null) {
                inAppMessageB = cursorA.moveToFirst() ? b(cursorA, crypto) : null;
                cursorA.close();
            }
            h(g);
            this.c.setTransactionSuccessful();
            this.c.endTransaction();
        }
        return inAppMessageB;
    }

    @Override // com.salesforce.marketingcloud.storage.e
    public void a(@NonNull InAppMessage inAppMessage) {
        if (inAppMessage != null) {
            this.c.execSQL("UPDATE iam_state SET display_count = display_count + 1 WHERE id = ?", new String[]{inAppMessage.id()});
        }
    }
}
