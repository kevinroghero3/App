package com.salesforce.marketingcloud.storage.db.upgrades;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.salesforce.marketingcloud.util.Crypto;
import java.security.GeneralSecurityException;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final b a = new b();
    private static final String b = com.salesforce.marketingcloud.g.a("Version11ToVersion12");
    private static SQLiteDatabase c;
    private static Crypto d;
    private static Crypto e;

    static final class a extends Lambda implements Function0<String> {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(0);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Attempting to migrate " + this.b + " ...";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.upgrades.b$b, reason: collision with other inner class name */
    static final class C0117b extends Lambda implements Function0<String> {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0117b(String str) {
            super(0);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Migration required for " + this.b + " ...";
        }
    }

    static final class c extends Lambda implements Function0<String> {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to migrate row from " + this.b + ". Removing row and continuing ...";
        }
    }

    static final class d extends Lambda implements Function0<String> {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(0);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Migration NOT required for " + this.b + ".";
        }
    }

    static final class e extends Lambda implements Function0<String> {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str) {
            super(0);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Migration complete for " + this.b + ".";
        }
    }

    static final class f extends Lambda implements Function0<String> {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(0);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to migrate " + this.b + ". Dropping table ...";
        }
    }

    static final class g extends Lambda implements Function0<String> {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str) {
            super(0);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return this.b + " ready.";
        }
    }

    static final class h extends Lambda implements Function0<String> {
        public static final h b = new h();

        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Migrating from legacyCrypto to SFMC encryption";
        }
    }

    static final class i extends Lambda implements Function0<String> {
        public static final i b = new i();

        i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "The data migration cannot be executed due to the unavailability of the legacyCrypto reference.";
        }
    }

    static final class j extends Lambda implements Function0<String> {
        final /* synthetic */ Exception b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(Exception exc) {
            super(0);
            this.b = exc;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return String.valueOf(this.b.getMessage());
        }
    }

    private b() {
    }

    /* JADX WARN: Code duplicated, block: B:22:0x016a  */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(Unknown Source)
    	at java.base/java.util.HashMap.getNode(Unknown Source)
    	at java.base/java.util.HashMap.containsKey(Unknown Source)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
     */
    @JvmStatic
    public static final void a(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull Crypto crypto, @Nullable Crypto crypto2) {
        SQLiteDatabase sQLiteDatabase2;
        SQLiteDatabase sQLiteDatabase3;
        SQLiteDatabase sQLiteDatabase4;
        SQLiteDatabase db = sQLiteDatabase;
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(crypto, "crypto");
        com.salesforce.marketingcloud.g gVar = com.salesforce.marketingcloud.g.a;
        String str = b;
        com.salesforce.marketingcloud.g.c(gVar, str, null, h.b, 2, null);
        c = db;
        if (crypto2 == null) {
            com.salesforce.marketingcloud.g.b(gVar, str, null, i.b, 2, null);
            a.a();
            return;
        }
        d = crypto;
        e = crypto2;
        if (db == null) {
            try {
                try {
                    Intrinsics.throwUninitializedPropertyAccessException("database");
                    db = null;
                } catch (Exception e2) {
                    com.salesforce.marketingcloud.g.a.b(b, e2, new j(e2));
                    sQLiteDatabase3 = c;
                    if (sQLiteDatabase3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("database");
                        sQLiteDatabase4 = null;
                    }
                    sQLiteDatabase4.endTransaction();
                }
            } catch (Throwable th) {
                SQLiteDatabase sQLiteDatabase5 = c;
                if (sQLiteDatabase5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("database");
                    sQLiteDatabase2 = null;
                } else {
                    sQLiteDatabase2 = sQLiteDatabase5;
                }
                sQLiteDatabase2.endTransaction();
                throw th;
            }
        }
        db.beginTransaction();
        b bVar = a;
        a(bVar, com.salesforce.marketingcloud.storage.db.g.e, "SELECT * FROM inbox_messages;", null, SetsKt__SetsJVMKt.setOf("message_json"), 4, null);
        a(bVar, com.salesforce.marketingcloud.storage.db.i.e, "SELECT * FROM messages;", null, SetsKt__SetsKt.setOf((Object[]) new String[]{"title", "alert", com.salesforce.marketingcloud.storage.db.i.a.e, com.salesforce.marketingcloud.storage.db.i.a.f, "url", "custom", com.salesforce.marketingcloud.storage.db.i.a.g, "keys"}), 4, null);
        a(bVar, com.salesforce.marketingcloud.storage.db.k.e, "SELECT * FROM registration;", null, SetsKt__SetsKt.setOf((Object[]) new String[]{com.salesforce.marketingcloud.storage.db.k.a.c, com.salesforce.marketingcloud.storage.db.k.a.s, com.salesforce.marketingcloud.storage.db.k.a.d, com.salesforce.marketingcloud.storage.db.k.a.f92o, "tags", "attributes"}), 4, null);
        a(bVar, "device_stats", "SELECT * FROM device_stats;", null, SetsKt__SetsJVMKt.setOf("event_data"), 4, null);
        a(bVar, com.salesforce.marketingcloud.storage.db.f.e, "SELECT * FROM in_app_messages;", null, SetsKt__SetsKt.setOf((Object[]) new String[]{"media_url", "message_json"}), 4, null);
        a(bVar, com.salesforce.marketingcloud.storage.db.a.e, "SELECT * FROM analytic_item;", null, SetsKt__SetsKt.setOf((Object[]) new String[]{com.salesforce.marketingcloud.storage.db.a.C0116a.g, "predictive_intelligence_identifier", com.salesforce.marketingcloud.storage.db.a.C0116a.h}), 4, null);
        a(bVar, com.salesforce.marketingcloud.storage.db.j.e, "SELECT * FROM regions;", null, SetsKt__SetsKt.setOf((Object[]) new String[]{"latitude", "longitude", "beacon_guid", "description", "name"}), 4, null);
        a(bVar, com.salesforce.marketingcloud.storage.db.h.e, "SELECT * FROM location_table;", null, SetsKt__SetsKt.setOf((Object[]) new String[]{"latitude", "longitude"}), 4, null);
        SQLiteDatabase sQLiteDatabase6 = c;
        if (sQLiteDatabase6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("database");
            sQLiteDatabase6 = null;
        }
        sQLiteDatabase6.setTransactionSuccessful();
        sQLiteDatabase3 = c;
        if (sQLiteDatabase3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("database");
            sQLiteDatabase4 = null;
        } else {
            sQLiteDatabase4 = sQLiteDatabase3;
        }
        sQLiteDatabase4.endTransaction();
    }

    private final String b(String str, Crypto crypto) {
        return crypto.encString(str);
    }

    private final void a() {
        SQLiteDatabase sQLiteDatabase = c;
        SQLiteDatabase sQLiteDatabase2 = null;
        if (sQLiteDatabase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("database");
            sQLiteDatabase = null;
        }
        sQLiteDatabase.beginTransaction();
        try {
            SQLiteDatabase sQLiteDatabase3 = c;
            if (sQLiteDatabase3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("database");
                sQLiteDatabase3 = null;
            }
            sQLiteDatabase3.execSQL("DELETE FROM inbox_messages;");
            SQLiteDatabase sQLiteDatabase4 = c;
            if (sQLiteDatabase4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("database");
                sQLiteDatabase4 = null;
            }
            sQLiteDatabase4.execSQL("DELETE FROM messages;");
            SQLiteDatabase sQLiteDatabase5 = c;
            if (sQLiteDatabase5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("database");
                sQLiteDatabase5 = null;
            }
            sQLiteDatabase5.execSQL("DELETE FROM registration;");
            SQLiteDatabase sQLiteDatabase6 = c;
            if (sQLiteDatabase6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("database");
                sQLiteDatabase6 = null;
            }
            sQLiteDatabase6.execSQL("DELETE FROM device_stats;");
            SQLiteDatabase sQLiteDatabase7 = c;
            if (sQLiteDatabase7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("database");
                sQLiteDatabase7 = null;
            }
            sQLiteDatabase7.execSQL("DELETE FROM in_app_messages;");
            SQLiteDatabase sQLiteDatabase8 = c;
            if (sQLiteDatabase8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("database");
                sQLiteDatabase8 = null;
            }
            sQLiteDatabase8.execSQL("DELETE FROM analytic_item;");
            SQLiteDatabase sQLiteDatabase9 = c;
            if (sQLiteDatabase9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("database");
                sQLiteDatabase9 = null;
            }
            sQLiteDatabase9.execSQL("DELETE FROM regions;");
            SQLiteDatabase sQLiteDatabase10 = c;
            if (sQLiteDatabase10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("database");
                sQLiteDatabase10 = null;
            }
            sQLiteDatabase10.execSQL("DELETE FROM location_table;");
            SQLiteDatabase sQLiteDatabase11 = c;
            if (sQLiteDatabase11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("database");
                sQLiteDatabase11 = null;
            }
            sQLiteDatabase11.setTransactionSuccessful();
        } finally {
            SQLiteDatabase sQLiteDatabase12 = c;
            if (sQLiteDatabase12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("database");
            } else {
                sQLiteDatabase2 = sQLiteDatabase12;
            }
            sQLiteDatabase2.endTransaction();
        }
    }

    static /* synthetic */ void a(b bVar, String str, String str2, String[] strArr, Set set, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            strArr = null;
        }
        bVar.a(str, str2, strArr, set);
    }

    private final void a(String str, String str2, String[] strArr, Set<String> set) {
        String strA;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            com.salesforce.marketingcloud.g.d(com.salesforce.marketingcloud.g.a, b, null, new a(str), 2, null);
            SQLiteDatabase sQLiteDatabase2 = c;
            if (sQLiteDatabase2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("database");
                sQLiteDatabase2 = null;
            }
            Cursor cursorRawQuery = sQLiteDatabase2.rawQuery(str2, strArr);
            Boolean boolValueOf = null;
            while (cursorRawQuery.moveToNext()) {
                try {
                    if (boolValueOf == null) {
                        boolValueOf = Boolean.valueOf(a.a(set));
                    }
                    if (boolValueOf.booleanValue()) {
                        com.salesforce.marketingcloud.g.d(com.salesforce.marketingcloud.g.a, b, null, new C0117b(str), 2, null);
                        try {
                            ContentValues contentValues = new ContentValues();
                            for (String str3 : set) {
                                Intrinsics.checkNotNull(cursorRawQuery);
                                String strB = com.salesforce.marketingcloud.storage.db.d.b(cursorRawQuery, str3);
                                if (strB == null) {
                                    strA = null;
                                    break;
                                    break;
                                }
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= strB.length()) {
                                        strA = null;
                                        break;
                                    }
                                    char cCharAt = strB.charAt(i2);
                                    if (!Character.isWhitespace(cCharAt) && cCharAt != 160 && cCharAt != 8199 && cCharAt != 8239) {
                                        strA = a.a(strB);
                                        break;
                                    }
                                    i2++;
                                }
                                contentValues.put(str3, strA);
                            }
                            SQLiteDatabase sQLiteDatabase3 = c;
                            if (sQLiteDatabase3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("database");
                                sQLiteDatabase3 = null;
                            }
                            Intrinsics.checkNotNull(cursorRawQuery);
                            sQLiteDatabase3.update(str, contentValues, "id=?", new String[]{com.salesforce.marketingcloud.storage.db.d.b(cursorRawQuery, "id")});
                        } catch (Exception e2) {
                            com.salesforce.marketingcloud.g.a.b(b, e2, new c(str));
                            SQLiteDatabase sQLiteDatabase4 = c;
                            if (sQLiteDatabase4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("database");
                                sQLiteDatabase4 = null;
                            }
                            Intrinsics.checkNotNull(cursorRawQuery);
                            sQLiteDatabase4.delete(str, "id=?", new String[]{com.salesforce.marketingcloud.storage.db.d.b(cursorRawQuery, "id")});
                        }
                    } else {
                        com.salesforce.marketingcloud.g.d(com.salesforce.marketingcloud.g.a, b, null, new d(str), 2, null);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorRawQuery, th);
                        throw th2;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursorRawQuery, null);
            com.salesforce.marketingcloud.g.d(com.salesforce.marketingcloud.g.a, b, null, new e(str), 2, null);
        } catch (Exception e3) {
            com.salesforce.marketingcloud.g gVar = com.salesforce.marketingcloud.g.a;
            String str4 = b;
            gVar.b(str4, e3, new f(str));
            SQLiteDatabase sQLiteDatabase5 = c;
            if (sQLiteDatabase5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("database");
            } else {
                sQLiteDatabase = sQLiteDatabase5;
            }
            sQLiteDatabase.execSQL("DELETE FROM " + str + ";");
            com.salesforce.marketingcloud.g.d(gVar, str4, null, new g(str), 2, null);
        }
    }

    private final boolean a(Set<String> set) {
        try {
            Crypto crypto = d;
            if (crypto == null) {
                Intrinsics.throwUninitializedPropertyAccessException("crypto");
                crypto = null;
            }
            return crypto.decString((String) CollectionsKt___CollectionsKt.first(set)) == null;
        } catch (Exception unused) {
        }
    }

    private final String a(String str) throws GeneralSecurityException {
        try {
            Crypto crypto = e;
            Crypto crypto2 = null;
            if (crypto == null) {
                Intrinsics.throwUninitializedPropertyAccessException("legacyCrypto");
                crypto = null;
            }
            String strA = a(str, crypto);
            if (strA == null) {
                return null;
            }
            b bVar = a;
            Crypto crypto3 = d;
            if (crypto3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("crypto");
            } else {
                crypto2 = crypto3;
            }
            return bVar.b(strA, crypto2);
        } catch (Exception unused) {
            throw new GeneralSecurityException("Failed to migrate data.");
        }
    }

    private final String a(String str, Crypto crypto) {
        return crypto.decString(str);
    }
}
