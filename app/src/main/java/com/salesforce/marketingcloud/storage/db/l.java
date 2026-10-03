package com.salesforce.marketingcloud.storage.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends SQLiteOpenHelper {
    public static final int e = 13;
    private static final String f = "mcsdk_%s.db";
    private static final String g = com.salesforce.marketingcloud.g.a("StorageSqliteOpenHelper");
    private final Context a;
    private final Crypto b;
    private final Crypto c;
    private boolean d;

    l(Context context, Crypto crypto, String str, int i, @Nullable Crypto crypto2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.a = context;
        this.b = crypto;
        this.c = crypto2;
    }

    public static String a(String str) {
        return String.format(Locale.ENGLISH, f, str);
    }

    public void b() throws Exception {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        a(writableDatabase);
        writableDatabase.execSQL("VACUUM");
        onCreate(writableDatabase);
    }

    public void c() throws IllegalStateException, com.salesforce.marketingcloud.storage.exceptions.a {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (!k.c(writableDatabase)) {
            com.salesforce.marketingcloud.g.e(g, "Database table %s was not initialized properly and will be dropped and recreated.  Some data may be lost.", k.e);
            try {
                b();
                if (!k.c(writableDatabase)) {
                    throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", k.e));
                }
                throw new com.salesforce.marketingcloud.storage.exceptions.a();
            } catch (Exception e2) {
                throw new IllegalStateException(e2.getMessage(), e2);
            }
        }
        if (!g.d(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", g.e));
        }
        if (!a.d(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", a.e));
        }
        if (!j.g(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", j.e));
        }
        if (!i.d(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", i.e));
        }
        if (!h.d(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", h.e));
        }
        if (!m.d(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", m.g));
        }
        if (!f.m(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", f.e));
        }
        if (!e.d(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", "device_stats"));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            k.b(sQLiteDatabase);
            g.b(sQLiteDatabase);
            a.b(sQLiteDatabase);
            j.d(sQLiteDatabase);
            i.b(sQLiteDatabase);
            h.b(sQLiteDatabase);
            f.i(sQLiteDatabase);
            m.b(sQLiteDatabase);
            e.b(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.salesforce.marketingcloud.g.e(g, "SQLite database being downgraded from %d to %d", Integer.valueOf(i2), Integer.valueOf(i));
        this.d = true;
        a(sQLiteDatabase);
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (sQLiteDatabase.isReadOnly()) {
            return;
        }
        sQLiteDatabase.execSQL("PRAGMA foreign_keys=ON");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws Throwable {
        if (i < 2) {
            Crypto crypto = this.c;
            if (crypto == null) {
                throw new IllegalStateException("Null crypto. Could not upgrade DB schema to 2.");
            }
            com.salesforce.marketingcloud.storage.db.upgrades.d.b(sQLiteDatabase, this.a, crypto);
        }
        if (i < 3) {
            com.salesforce.marketingcloud.storage.db.upgrades.e.f(sQLiteDatabase);
        }
        if (i < 4) {
            com.salesforce.marketingcloud.storage.db.upgrades.f.c(sQLiteDatabase);
        }
        if (i < 5) {
            com.salesforce.marketingcloud.storage.db.upgrades.g.b(sQLiteDatabase);
        }
        if (i < 6) {
            com.salesforce.marketingcloud.storage.db.upgrades.h.b(sQLiteDatabase);
        }
        if (i < 7) {
            com.salesforce.marketingcloud.storage.db.upgrades.i.b(sQLiteDatabase);
        }
        if (i < 8) {
            com.salesforce.marketingcloud.storage.db.upgrades.j.a(sQLiteDatabase);
        }
        if (i < 9) {
            com.salesforce.marketingcloud.storage.db.upgrades.k.b(sQLiteDatabase);
        }
        if (i < 10) {
            Crypto crypto2 = this.c;
            if (crypto2 == null) {
                throw new IllegalStateException("Null crypto. Could not upgrade DB schema to 10.");
            }
            com.salesforce.marketingcloud.storage.db.upgrades.l.b(sQLiteDatabase, crypto2);
        }
        if (i < 11) {
            Crypto crypto3 = this.c;
            if (crypto3 == null) {
                throw new IllegalStateException("Null crypto. Could not upgrade DB schema to 11.");
            }
            com.salesforce.marketingcloud.storage.db.upgrades.a.b(sQLiteDatabase, crypto3);
        }
        if (i < 12) {
            com.salesforce.marketingcloud.storage.db.upgrades.b.a(sQLiteDatabase, this.b, this.c);
        }
        if (i < 13) {
            com.salesforce.marketingcloud.storage.db.upgrades.c.c(sQLiteDatabase);
        }
    }

    public boolean a() {
        return this.d;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            k.a(sQLiteDatabase);
            g.a(sQLiteDatabase);
            a.a(sQLiteDatabase);
            j.c(sQLiteDatabase);
            i.a(sQLiteDatabase);
            h.a(sQLiteDatabase);
            f.e(sQLiteDatabase);
            m.a(sQLiteDatabase);
            e.a(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public l(Context context, Crypto crypto, String str) {
        this(context, crypto, a(str), 13, null);
    }

    public l(Context context, Crypto crypto, String str, @Nullable Crypto crypto2) {
        this(context, crypto, a(str), 13, crypto2);
    }
}
