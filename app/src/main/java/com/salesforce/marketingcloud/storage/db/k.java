package com.salesforce.marketingcloud.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.appevents.AppEventsConstants;
import com.salesforce.marketingcloud.registration.Registration;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends b implements com.salesforce.marketingcloud.storage.k {
    public static final String e = "registration";
    private static final String[] f = {"id", "platform", a.c, a.d, "timezone", a.f, "tags", "attributes", a.i, a.j, a.k, a.l, a.m, a.f92o, a.p, "app_version", a.r, a.s, "locale", "uuid"};
    private static final String g = "CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, proximity_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, signed_string VARCHAR, locale VARCHAR, uuid VARCHAR );";

    /* JADX INFO: loaded from: classes6.dex */
    public static class a {
        public static final String a = "id";
        public static final String b = "platform";
        public static final String c = "subscriber_key";
        public static final String d = "et_app_id";
        public static final String e = "timezone";
        public static final String f = "dst";
        public static final String g = "tags";
        public static final String h = "attributes";
        public static final String i = "platform_version";
        public static final String j = "push_enabled";
        public static final String k = "location_enabled";
        public static final String l = "proximity_enabled";
        public static final String m = "hwid";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f91n = "locale";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f92o = "system_token";
        public static final String p = "device_id";
        public static final String q = "app_version";
        public static final String r = "sdk_version";
        public static final String s = "signed_string";
        public static final String t = "uuid";
    }

    public k(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS registration");
    }

    static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(g);
    }

    static boolean c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement(a("SELECT %s FROM %s", TextUtils.join(",", f), e));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.k
    public Registration k(@NonNull Crypto crypto) throws Exception {
        Cursor cursorA = a(f, null, null, null, null, a("%s DESC", "id"), AppEventsConstants.EVENT_PARAM_VALUE_YES);
        Registration registrationD = null;
        if (cursorA != null) {
            registrationD = cursorA.moveToFirst() ? d.d(cursorA, crypto) : null;
            cursorA.close();
        }
        return registrationD;
    }

    @Override // com.salesforce.marketingcloud.storage.k
    public int n() {
        return i(null);
    }

    @Override // com.salesforce.marketingcloud.storage.db.b
    String o() {
        return e;
    }

    private static String a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    private static ContentValues c(Registration registration, @NonNull Crypto crypto) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put(a.c, crypto.encString(registration.contactKey()));
        contentValues.put(a.s, crypto.encString(registration.signedString()));
        contentValues.put(a.d, crypto.encString(registration.appId()));
        contentValues.put(a.f92o, crypto.encString(registration.systemToken()));
        contentValues.put("tags", crypto.encString(com.salesforce.marketingcloud.util.j.a(registration.tags())));
        contentValues.put("attributes", crypto.encString(com.salesforce.marketingcloud.util.j.a(registration.attributes())));
        contentValues.put(a.p, registration.deviceId());
        contentValues.put("platform", registration.platform());
        contentValues.put("timezone", Integer.valueOf(registration.timeZone()));
        contentValues.put(a.f, Integer.valueOf(registration.dst() ? 1 : 0));
        contentValues.put(a.i, registration.platformVersion());
        contentValues.put(a.j, Integer.valueOf(registration.pushEnabled() ? 1 : 0));
        contentValues.put(a.k, Integer.valueOf(registration.locationEnabled() ? 1 : 0));
        contentValues.put(a.l, Integer.valueOf(registration.proximityEnabled() ? 1 : 0));
        contentValues.put(a.m, registration.hwid());
        contentValues.put("locale", registration.locale());
        contentValues.put("app_version", registration.appVersion());
        contentValues.put(a.r, registration.sdkVersion());
        contentValues.put("uuid", com.salesforce.marketingcloud.internal.m.d(registration));
        return contentValues;
    }

    @Override // com.salesforce.marketingcloud.storage.k
    public int b(Registration registration, @NonNull Crypto crypto) throws Exception {
        return a(c(registration, crypto), a("%s = ?", "id"), new String[]{String.valueOf(com.salesforce.marketingcloud.internal.m.b(registration))});
    }

    @Override // com.salesforce.marketingcloud.storage.k
    public void a(Registration registration, @NonNull Crypto crypto) throws Exception {
        com.salesforce.marketingcloud.internal.m.a(registration, (int) a(c(registration, crypto)));
        c();
    }

    @Override // com.salesforce.marketingcloud.storage.k
    public int c() {
        return i(a("%1$s NOT IN ( SELECT %1$s FROM ( SELECT %1$s FROM %2$s ORDER BY %1$s DESC LIMIT 1))", "id", o()));
    }
}
