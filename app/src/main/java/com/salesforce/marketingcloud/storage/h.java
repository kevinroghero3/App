package com.salesforce.marketingcloud.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.util.Crypto;
import java.io.File;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class h extends l {
    private static final String w = "mcsdk_cache_%s";
    private final b j;
    private final SharedPreferences k;
    private final com.salesforce.marketingcloud.storage.db.l l;
    private final d m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.salesforce.marketingcloud.storage.db.a f93n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.salesforce.marketingcloud.storage.db.i f94o;
    private com.salesforce.marketingcloud.storage.db.j p;
    private com.salesforce.marketingcloud.storage.db.k q;
    private com.salesforce.marketingcloud.storage.db.h r;
    private com.salesforce.marketingcloud.storage.db.g s;
    private com.salesforce.marketingcloud.storage.db.f t;
    private com.salesforce.marketingcloud.storage.db.m u;
    private c v;

    public h(@NonNull Context context, Crypto crypto, @NonNull String str, @NonNull String str2, @NonNull com.salesforce.marketingcloud.internal.n nVar, @Nullable Crypto crypto2, boolean z) {
        super(context, crypto, str, str2);
        com.salesforce.marketingcloud.storage.db.l lVar = new com.salesforce.marketingcloud.storage.db.l(context, crypto, this.a, crypto2);
        this.l = lVar;
        lVar.getWritableDatabase();
        this.j = new b.a(context, crypto, this.a, crypto2, z);
        SharedPreferences sharedPreferences = context.getSharedPreferences(l.a(this.a), 0);
        this.k = sharedPreferences;
        this.m = new d(context, sharedPreferences, str, nVar);
        if (z) {
            try {
                com.salesforce.marketingcloud.g.a(l.f, "SFMC New Installation or Encryption Change detected. Resetting the SDK database.", new Object[0]);
                lVar.b();
            } catch (Exception unused) {
                com.salesforce.marketingcloud.g.e(l.f, "Failed to reset the SDK database.", new Object[0]);
            }
        }
        if (this.l.a()) {
            this.j.a();
            this.k.edit().clear().apply();
        }
    }

    private void g() throws Exception {
        File fileF = f();
        if (fileF.exists() && fileF.isDirectory()) {
            com.salesforce.marketingcloud.util.e.a(fileF);
        }
        r();
        this.l.b();
    }

    private void r() throws Exception {
        c().a();
        e().edit().clear().apply();
        a(this.c);
    }

    @Override // com.salesforce.marketingcloud.storage.l
    protected boolean a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("create_date", null);
        if (string == null) {
            return false;
        }
        try {
            this.c.decString(string);
            return true;
        } catch (Exception e) {
            com.salesforce.marketingcloud.g.b(l.f, e, "Failed to verify existing encryption key", new Object[0]);
            return false;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.l
    public Crypto b() {
        return this.c;
    }

    @Override // com.salesforce.marketingcloud.storage.l
    public b c() {
        return this.j;
    }

    @Override // com.salesforce.marketingcloud.storage.l
    protected SQLiteOpenHelper d() {
        return this.l;
    }

    @Override // com.salesforce.marketingcloud.storage.l
    public SharedPreferences e() {
        return this.k;
    }

    public File f() {
        return new File(this.b.getCacheDir(), String.format(Locale.ENGLISH, w, this.a));
    }

    public a h() {
        if (this.f93n == null) {
            this.f93n = new com.salesforce.marketingcloud.storage.db.a(this.l.getWritableDatabase());
        }
        return this.f93n;
    }

    public c i() {
        if (this.v == null) {
            this.v = new com.salesforce.marketingcloud.storage.db.e(this.l.getWritableDatabase());
        }
        return this.v;
    }

    public d j() {
        return this.m;
    }

    public e k() {
        if (this.t == null) {
            this.t = new com.salesforce.marketingcloud.storage.db.f(this.l.getWritableDatabase());
        }
        return this.t;
    }

    public f l() {
        if (this.s == null) {
            this.s = new com.salesforce.marketingcloud.storage.db.g(this.l.getWritableDatabase());
        }
        return this.s;
    }

    public g m() {
        if (this.r == null) {
            this.r = new com.salesforce.marketingcloud.storage.db.h(this.l.getWritableDatabase());
        }
        return this.r;
    }

    public i n() {
        if (this.f94o == null) {
            this.f94o = new com.salesforce.marketingcloud.storage.db.i(this.l.getWritableDatabase());
        }
        return this.f94o;
    }

    public j o() {
        if (this.p == null) {
            this.p = new com.salesforce.marketingcloud.storage.db.j(this.l.getWritableDatabase());
        }
        return this.p;
    }

    public k p() {
        if (this.q == null) {
            this.q = new com.salesforce.marketingcloud.storage.db.k(this.l.getWritableDatabase());
        }
        return this.q;
    }

    public m q() {
        if (this.u == null) {
            this.u = new com.salesforce.marketingcloud.storage.db.m(this.l.getWritableDatabase());
        }
        return this.u;
    }

    public final void s() {
        this.l.close();
    }

    public final void a(InitializationStatus.a aVar) {
        if (!a(this.k)) {
            boolean zContains = this.k.contains("create_date");
            aVar.a(zContains);
            if (zContains) {
                try {
                    g();
                } catch (Exception e) {
                    aVar.a(e);
                    aVar.f(true);
                    com.salesforce.marketingcloud.g.b(l.f, e, "Failed to recover from encryption change.", new Object[0]);
                    return;
                }
            }
        }
        try {
            try {
                this.l.c();
            } catch (com.salesforce.marketingcloud.storage.exceptions.a unused) {
                r();
            } catch (IllegalStateException e2) {
                aVar.a(e2);
                aVar.f(true);
                com.salesforce.marketingcloud.g.b(l.f, e2, "Could not create the necessary database table(s).", new Object[0]);
            }
        } catch (Exception e3) {
            aVar.a(e3);
            aVar.f(true);
            com.salesforce.marketingcloud.g.b(l.f, e3, "Failed to recover from data reset.", new Object[0]);
        }
    }

    private void a(Crypto crypto) throws Exception {
        this.k.edit().putString("create_date", crypto.encString(String.valueOf(System.currentTimeMillis()))).apply();
    }

    @Override // com.salesforce.marketingcloud.storage.l
    protected final Context a() {
        return this.b;
    }
}
