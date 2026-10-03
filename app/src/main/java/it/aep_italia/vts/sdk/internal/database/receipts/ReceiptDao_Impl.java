package it.aep_italia.vts.sdk.internal.database.receipts;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public final class ReceiptDao_Impl implements ReceiptDao {
    public static int MediaSessionCompat1;
    public static int MediaSessionCompat2;
    private final RoomDatabase a;
    private final EntityInsertionAdapter<StoredReceipt> b;
    private final EntityDeletionOrUpdateAdapter<StoredReceipt> c;
    private final SharedSQLiteStatement d;

    class a extends EntityInsertionAdapter<StoredReceipt> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, StoredReceipt storedReceipt) {
            supportSQLiteStatement.bindLong(1, storedReceipt.getReceiptUID());
            supportSQLiteStatement.bindLong(2, storedReceipt.getContractID());
            supportSQLiteStatement.bindLong(3, storedReceipt.getGroupUID());
            if (storedReceipt.getType() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, storedReceipt.getType());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `receipts` (`receiptUID`,`contractID`,`groupUID`,`receiptType`) VALUES (?,?,?,?)";
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<StoredReceipt> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, StoredReceipt storedReceipt) {
            supportSQLiteStatement.bindLong(1, storedReceipt.getReceiptUID());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `receipts` WHERE `receiptUID` = ?";
        }
    }

    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM receipts WHERE receiptUID = ?";
        }
    }

    public ReceiptDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // it.aep_italia.vts.sdk.internal.database.receipts.ReceiptDao
    public void deleteByReceiptUID(long j) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.d.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        try {
            this.a.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.a.setTransactionSuccessful();
                this.a.endTransaction();
                this.d.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.a.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.d.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // it.aep_italia.vts.sdk.internal.database.receipts.ReceiptDao
    public void deleteReceipts(Collection<StoredReceipt> collection) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(collection);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // it.aep_italia.vts.sdk.internal.database.receipts.ReceiptDao
    public StoredReceipt readByContractID(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM receipts WHERE contractID = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.a.assertNotSuspendingTransaction();
        StoredReceipt storedReceipt = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "receiptUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contractID");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupUID");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "receiptType");
            if (cursorQuery.moveToFirst()) {
                storedReceipt = new StoredReceipt(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getLong(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
            }
            return storedReceipt;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // it.aep_italia.vts.sdk.internal.database.receipts.ReceiptDao
    public List<StoredReceipt> readByGroupUID(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM receipts WHERE groupUID = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "receiptUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contractID");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupUID");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "receiptType");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new StoredReceipt(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getLong(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // it.aep_italia.vts.sdk.internal.database.receipts.ReceiptDao
    public StoredReceipt readByReceiptUID(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM receipts WHERE receiptUID = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.a.assertNotSuspendingTransaction();
        StoredReceipt storedReceipt = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "receiptUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contractID");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupUID");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "receiptType");
            if (cursorQuery.moveToFirst()) {
                storedReceipt = new StoredReceipt(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getLong(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
            }
            return storedReceipt;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // it.aep_italia.vts.sdk.internal.database.receipts.ReceiptDao
    public void saveReceipt(StoredReceipt storedReceipt) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(storedReceipt);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public static int MediaBrowserCompatMediaBrowserImplBase() {
        int i = MediaSessionCompat1;
        int i2 = i % 7773645;
        MediaSessionCompat1 = i + 1;
        if (i2 != 0) {
            return MediaSessionCompat2;
        }
        int iNextInt = new Random().nextInt();
        MediaSessionCompat2 = iNextInt;
        return iNextInt;
    }
}
