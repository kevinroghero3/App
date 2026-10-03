package com.salesforce.marketingcloud.storage.db.upgrades;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import java.util.UUID;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final c a = new c();
    private static final String b = com.salesforce.marketingcloud.g.a("Version12ToVersion13");
    private static SQLiteDatabase c;

    static final class a extends Lambda implements Function0<String> {
        public static final a b = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to alter the inbox_message table";
        }
    }

    static final class b extends Lambda implements Function0<String> {
        public static final b b = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "InboxMessage storage reset.";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.upgrades.c$c, reason: collision with other inner class name */
    static final class C0118c extends Lambda implements Function0<String> {
        public static final C0118c b = new C0118c();

        C0118c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to create local storage for inbox_messages";
        }
    }

    static final class d extends Lambda implements Function0<String> {
        public static final d b = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Migration complete for registration ...";
        }
    }

    static final class e extends Lambda implements Function0<String> {
        public static final e b = new e();

        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to migrate registration table. Dropping table ...";
        }
    }

    static final class f extends Lambda implements Function0<String> {
        public static final f b = new f();

        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to create local storage for Registration.";
        }
    }

    static final class g extends Lambda implements Function0<String> {
        public static final g b = new g();

        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "upgrade DB Migration ...";
        }
    }

    private c() {
    }

    private final void a(SQLiteDatabase sQLiteDatabase) {
        InboxMessage.InboxMessageType inboxMessageType = InboxMessage.InboxMessageType.LEGACY;
        String str = "CREATE TABLE inbox_messages (id TEXT PRIMARY KEY, start_date INTEGER DEFAULT NULL, end_date INTEGER DEFAULT NULL, is_deleted INTEGER DEFAULT 0, is_read INTEGER DEFAULT 0, is_dirty INTEGER DEFAULT 0, message_type INTEGER DEFAULT " + inboxMessageType.getIndex() + ", message_hash TEXT DEFAULT NULL, notification_message_json TEXT DEFAULT NULL, message_json TEXT);";
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("ALTER TABLE inbox_messages ADD COLUMN message_type INTEGER DEFAULT " + inboxMessageType.getIndex() + ";");
            sQLiteDatabase.execSQL("ALTER TABLE inbox_messages ADD COLUMN notification_message_json TEXT DEFAULT NULL;");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g gVar = com.salesforce.marketingcloud.g.a;
            String str2 = b;
            gVar.b(str2, e2, a.b);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS inbox_messages");
            sQLiteDatabase.execSQL(str);
            com.salesforce.marketingcloud.g.e(gVar, str2, null, b.b, 2, null);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e3) {
            com.salesforce.marketingcloud.g.a.b(b, e3, C0118c.b);
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @JvmStatic
    public static final void c(@NotNull SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        com.salesforce.marketingcloud.g.c(com.salesforce.marketingcloud.g.a, b, null, g.b, 2, null);
        c = db;
        c cVar = a;
        SQLiteDatabase sQLiteDatabase = null;
        if (db == null) {
            Intrinsics.throwUninitializedPropertyAccessException("database");
            db = null;
        }
        cVar.b(db);
        SQLiteDatabase sQLiteDatabase2 = c;
        if (sQLiteDatabase2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("database");
        } else {
            sQLiteDatabase = sQLiteDatabase2;
        }
        cVar.a(sQLiteDatabase);
    }

    private final void b(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("ALTER TABLE registration ADD COLUMN uuid VARCHAR");
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT id FROM registration ORDER BY id DESC LIMIT 1", null);
                try {
                    Integer numValueOf = cursorRawQuery.moveToFirst() ? Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("id"))) : null;
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursorRawQuery, null);
                    if (numValueOf != null) {
                        int iIntValue = numValueOf.intValue();
                        sQLiteDatabase.execSQL("DELETE FROM registration WHERE id != " + iIntValue);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uuid", UUID.randomUUID().toString());
                        sQLiteDatabase.update(com.salesforce.marketingcloud.storage.db.k.e, contentValues, "id=?", new String[]{String.valueOf(iIntValue)});
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    com.salesforce.marketingcloud.g.c(com.salesforce.marketingcloud.g.a, b, null, d.b, 2, null);
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorRawQuery, th);
                        throw th2;
                    }
                }
            } catch (Exception e2) {
                com.salesforce.marketingcloud.g.a.b(b, e2, e.b);
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS registration");
                    sQLiteDatabase.execSQL("CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR,  attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT,  location_enabled SMALLINT, proximity_enabled SMALLINT, hwid VARCHAR,  system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR,  signed_string VARCHAR, locale VARCHAR, uuid VARCHAR)");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e3) {
                    com.salesforce.marketingcloud.g.a.b(b, e3, f.b);
                }
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable th3) {
            sQLiteDatabase.endTransaction();
            throw th3;
        }
    }
}
