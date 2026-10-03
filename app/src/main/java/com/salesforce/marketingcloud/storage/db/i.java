package com.salesforce.marketingcloud.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import ch.qos.logback.core.CoreConstants;
import com.facebook.appevents.AppEventsConstants;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends b implements com.salesforce.marketingcloud.storage.i {
    public static final String e = "messages";
    private static final String g = "CREATE TABLE messages (id VARCHAR PRIMARY KEY, title VARCHAR, alert VARCHAR, sound VARCHAR, mediaUrl VARCHAR, mediaAlt VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, notify_id INTEGER );";
    private static final String[] f = {"id", "title", "alert", "sound", a.e, a.f, a.g, "start_date", "end_date", "message_type", "content_type", "url", "custom", "keys", a.f90o, a.q, a.r, a.p, a.s, a.t, a.u, a.v, a.w, a.x, a.y};
    private static final String h = com.salesforce.marketingcloud.g.a("MessageDbStorage");

    /* JADX INFO: loaded from: classes6.dex */
    public static class a {
        public static final String a = "id";
        public static final String b = "title";
        public static final String c = "alert";
        public static final String d = "sound";
        public static final String e = "mediaUrl";
        public static final String f = "mediaAlt";
        public static final String g = "open_direct";
        public static final String h = "start_date";
        public static final String i = "end_date";
        public static final String j = "message_type";
        public static final String k = "content_type";
        public static final String l = "url";
        public static final String m = "custom";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f89n = "keys";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f90o = "period_show_count";
        public static final String p = "show_count";
        public static final String q = "last_shown_date";
        public static final String r = "next_allowed_show";
        public static final String s = "message_limit";
        public static final String t = "rolling_period";
        public static final String u = "period_type";
        public static final String v = "number_of_periods";
        public static final String w = "messages_per_period";
        public static final String x = "proximity";
        public static final String y = "notify_id";
    }

    public i(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages");
    }

    static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(g);
    }

    private static boolean c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement(c.a("SELECT %s FROM %s", TextUtils.join(",", f), e));
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

    @Override // com.salesforce.marketingcloud.storage.i
    public int e(int i) {
        return a(a("%s = ?", "message_type"), new String[]{String.valueOf(i)});
    }

    @Override // com.salesforce.marketingcloud.storage.db.b
    String o() {
        return e;
    }

    private static String a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    private static ContentValues b(Message message, @NonNull Crypto crypto) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", message.id());
        contentValues.put("title", crypto.encString(message.title()));
        contentValues.put("alert", crypto.encString(message.alert()));
        contentValues.put("sound", message.sound());
        if (message.media() != null) {
            contentValues.put(a.e, crypto.encString(message.media().url()));
            contentValues.put(a.f, crypto.encString(message.media().altText()));
        }
        contentValues.put("start_date", com.salesforce.marketingcloud.util.j.a(message.startDateUtc()));
        contentValues.put("end_date", com.salesforce.marketingcloud.util.j.a(message.endDateUtc()));
        contentValues.put("message_type", Integer.valueOf(message.messageType()));
        contentValues.put("content_type", Integer.valueOf(message.contentType()));
        contentValues.put("url", crypto.encString(message.url()));
        contentValues.put("custom", crypto.encString(message.custom()));
        contentValues.put(a.w, Integer.valueOf(message.messagesPerPeriod()));
        contentValues.put(a.v, Integer.valueOf(message.numberOfPeriods()));
        contentValues.put(a.u, Integer.valueOf(message.periodType()));
        contentValues.put(a.t, Integer.valueOf(message.isRollingPeriod() ? 1 : 0));
        contentValues.put(a.s, Integer.valueOf(message.messageLimit()));
        contentValues.put(a.x, Integer.valueOf(message.proximity()));
        contentValues.put(a.g, crypto.encString(message.openDirect()));
        contentValues.put("keys", crypto.encString(com.salesforce.marketingcloud.util.j.a(message.customKeys())));
        contentValues.put(a.r, com.salesforce.marketingcloud.util.j.a(com.salesforce.marketingcloud.internal.h.b(message)));
        contentValues.put(a.f90o, Integer.valueOf(com.salesforce.marketingcloud.internal.h.d(message)));
        contentValues.put(a.y, Integer.valueOf(com.salesforce.marketingcloud.internal.h.c(message)));
        contentValues.put(a.p, Integer.valueOf(com.salesforce.marketingcloud.internal.h.e(message)));
        contentValues.put(a.q, com.salesforce.marketingcloud.util.j.a(com.salesforce.marketingcloud.internal.h.a(message)));
        return contentValues;
    }

    @Override // com.salesforce.marketingcloud.storage.i
    public void a(@NonNull Message message, @NonNull Crypto crypto) throws Exception {
        ContentValues contentValuesB = b(message, crypto);
        if (a(contentValuesB, a("%s = ?", "id"), new String[]{message.id()}) == 0) {
            a(contentValuesB);
        }
    }

    @Override // com.salesforce.marketingcloud.storage.i
    public Message a(@NonNull String str, @NonNull Crypto crypto) {
        Cursor cursorA = a(f, a("%s = ?", "id"), new String[]{str}, null, null, null, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        Message messageB = null;
        if (cursorA != null) {
            messageB = cursorA.moveToFirst() ? d.b(cursorA, crypto) : null;
            cursorA.close();
        }
        return messageB;
    }

    @Override // com.salesforce.marketingcloud.storage.i
    public List<Message> a(@NonNull Crypto crypto) {
        List<Message> listEmptyList = Collections.emptyList();
        Cursor cursorA = a(f, a(3, 4));
        if (cursorA != null) {
            if (cursorA.moveToFirst()) {
                ArrayList arrayList = new ArrayList(cursorA.getCount());
                do {
                    Message messageB = d.b(cursorA, crypto);
                    if (messageB != null) {
                        arrayList.add(messageB);
                    }
                } while (cursorA.moveToNext());
                listEmptyList = arrayList;
            }
            cursorA.close();
        }
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.storage.i
    public List<Message> b(@NonNull Crypto crypto) {
        List<Message> listEmptyList = Collections.emptyList();
        Cursor cursorA = a(f, a(5));
        if (cursorA != null) {
            if (cursorA.moveToFirst()) {
                ArrayList arrayList = new ArrayList(cursorA.getCount());
                do {
                    Message messageB = d.b(cursorA, crypto);
                    if (messageB != null) {
                        arrayList.add(messageB);
                    }
                } while (cursorA.moveToNext());
                listEmptyList = arrayList;
            }
            cursorA.close();
        }
        return listEmptyList;
    }

    private String a(int... iArr) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (int i : iArr) {
            if (z) {
                sb.append("message_type");
                sb.append(" IN(");
                z = false;
            } else {
                sb.append(CoreConstants.COMMA_CHAR);
            }
            sb.append(i);
        }
        sb.append(");");
        return sb.toString();
    }

    @Override // com.salesforce.marketingcloud.storage.i
    public int a(@NonNull String str) {
        return a(a("%s = ?", "id"), new String[]{str});
    }

    @Override // com.salesforce.marketingcloud.storage.i
    public int a(@NonNull String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(a.y, Integer.valueOf(i));
        return a(contentValues, a("%s = ?", "id"), new String[]{str});
    }
}
