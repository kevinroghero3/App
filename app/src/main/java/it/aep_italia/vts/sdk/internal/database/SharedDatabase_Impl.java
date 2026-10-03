package it.aep_italia.vts.sdk.internal.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import io.sentry.protocol.DebugMeta;
import it.aep_italia.vts.sdk.internal.database.images.ImageDao;
import it.aep_italia.vts.sdk.internal.database.images.ImageDao_Impl;
import it.aep_italia.vts.sdk.internal.database.properties.PropertyDao;
import it.aep_italia.vts.sdk.internal.database.properties.PropertyDao_Impl;
import it.aep_italia.vts.sdk.internal.database.receipts.ReceiptDao;
import it.aep_italia.vts.sdk.internal.database.receipts.ReceiptDao_Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public final class SharedDatabase_Impl extends SharedDatabase {
    private volatile ImageDao b;
    private volatile ReceiptDao c;
    private volatile PropertyDao d;

    class a extends RoomOpenHelper.Delegate {
        a(int i) {
            super(i);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `images` (`vTokenUID` INTEGER NOT NULL, `byteSize` INTEGER NOT NULL, `downloadDate` INTEGER NOT NULL, `lastUsageDate` INTEGER NOT NULL, `signatureCount` INTEGER NOT NULL, PRIMARY KEY(`vTokenUID`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `receipts` (`receiptUID` INTEGER NOT NULL, `contractID` INTEGER NOT NULL, `groupUID` INTEGER NOT NULL, `receiptType` TEXT, PRIMARY KEY(`receiptUID`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `properties` (`name` TEXT NOT NULL, `value` INTEGER NOT NULL, `lastUpdated` INTEGER NOT NULL, PRIMARY KEY(`name`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1cdfc57603280508865f8a86ebca6555')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `images`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `receipts`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `properties`");
            List list = SharedDatabase_Impl.this.mCallbacks;
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ((RoomDatabase.Callback) it2.next()).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            List list = SharedDatabase_Impl.this.mCallbacks;
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ((RoomDatabase.Callback) it2.next()).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            SharedDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
            SharedDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            List list = SharedDatabase_Impl.this.mCallbacks;
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ((RoomDatabase.Callback) it2.next()).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public RoomOpenHelper.ValidationResult onValidateSchema(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap map = new HashMap(5);
            map.put("vTokenUID", new TableInfo.Column("vTokenUID", "INTEGER", true, 1, null, 1));
            map.put("byteSize", new TableInfo.Column("byteSize", "INTEGER", true, 0, null, 1));
            map.put("downloadDate", new TableInfo.Column("downloadDate", "INTEGER", true, 0, null, 1));
            map.put("lastUsageDate", new TableInfo.Column("lastUsageDate", "INTEGER", true, 0, null, 1));
            map.put("signatureCount", new TableInfo.Column("signatureCount", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo(DebugMeta.JsonKeys.IMAGES, map, new HashSet(0), new HashSet(0));
            TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, DebugMeta.JsonKeys.IMAGES);
            if (!tableInfo.equals(tableInfo2)) {
                return new RoomOpenHelper.ValidationResult(false, "images(it.aep_italia.vts.sdk.internal.database.images.StoredImage).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
            }
            HashMap map2 = new HashMap(4);
            map2.put("receiptUID", new TableInfo.Column("receiptUID", "INTEGER", true, 1, null, 1));
            map2.put("contractID", new TableInfo.Column("contractID", "INTEGER", true, 0, null, 1));
            map2.put("groupUID", new TableInfo.Column("groupUID", "INTEGER", true, 0, null, 1));
            map2.put("receiptType", new TableInfo.Column("receiptType", "TEXT", false, 0, null, 1));
            TableInfo tableInfo3 = new TableInfo("receipts", map2, new HashSet(0), new HashSet(0));
            TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, "receipts");
            if (!tableInfo3.equals(tableInfo4)) {
                return new RoomOpenHelper.ValidationResult(false, "receipts(it.aep_italia.vts.sdk.internal.database.receipts.StoredReceipt).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
            }
            HashMap map3 = new HashMap(3);
            map3.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
            map3.put("value", new TableInfo.Column("value", "INTEGER", true, 0, null, 1));
            map3.put("lastUpdated", new TableInfo.Column("lastUpdated", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo5 = new TableInfo("properties", map3, new HashSet(0), new HashSet(0));
            TableInfo tableInfo6 = TableInfo.read(supportSQLiteDatabase, "properties");
            if (tableInfo5.equals(tableInfo6)) {
                return new RoomOpenHelper.ValidationResult(true, null);
            }
            return new RoomOpenHelper.ValidationResult(false, "properties(it.aep_italia.vts.sdk.internal.database.properties.StoredProperty).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
        }
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `images`");
            writableDatabase.execSQL("DELETE FROM `receipts`");
            writableDatabase.execSQL("DELETE FROM `properties`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), DebugMeta.JsonKeys.IMAGES, "receipts", "properties");
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(1), "1cdfc57603280508865f8a86ebca6555", "de6c490a5511ba1df709c79d6db7736e")).build());
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(ImageDao.class, ImageDao_Impl.getRequiredConverters());
        map.put(ReceiptDao.class, ReceiptDao_Impl.getRequiredConverters());
        map.put(PropertyDao.class, PropertyDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // it.aep_italia.vts.sdk.internal.database.SharedDatabase
    public ImageDao imageDao() {
        ImageDao imageDao;
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b == null) {
                this.b = new ImageDao_Impl(this);
            }
            imageDao = this.b;
        }
        return imageDao;
    }

    @Override // it.aep_italia.vts.sdk.internal.database.SharedDatabase
    public PropertyDao propertyDao() {
        PropertyDao propertyDao;
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = new PropertyDao_Impl(this);
            }
            propertyDao = this.d;
        }
        return propertyDao;
    }

    @Override // it.aep_italia.vts.sdk.internal.database.SharedDatabase
    public ReceiptDao receiptDao() {
        ReceiptDao receiptDao;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            if (this.c == null) {
                this.c = new ReceiptDao_Impl(this);
            }
            receiptDao = this.c;
        }
        return receiptDao;
    }
}
