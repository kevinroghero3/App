package it.aep_italia.vts.sdk.internal.database.images;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class ImageDao_Impl implements ImageDao {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<StoredImage> b;
    private final EntityDeletionOrUpdateAdapter<StoredImage> c;
    private final EntityDeletionOrUpdateAdapter<StoredImage> d;

    class a extends EntityInsertionAdapter<StoredImage> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, StoredImage storedImage) {
            supportSQLiteStatement.bindLong(1, storedImage.getVTokenUID());
            supportSQLiteStatement.bindLong(2, storedImage.getByteSize());
            supportSQLiteStatement.bindLong(3, storedImage.getDownloadDate());
            supportSQLiteStatement.bindLong(4, storedImage.getUsageDate());
            supportSQLiteStatement.bindLong(5, storedImage.getSignatureCount());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `images` (`vTokenUID`,`byteSize`,`downloadDate`,`lastUsageDate`,`signatureCount`) VALUES (?,?,?,?,?)";
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<StoredImage> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, StoredImage storedImage) {
            supportSQLiteStatement.bindLong(1, storedImage.getVTokenUID());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `images` WHERE `vTokenUID` = ?";
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<StoredImage> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, StoredImage storedImage) {
            supportSQLiteStatement.bindLong(1, storedImage.getVTokenUID());
            supportSQLiteStatement.bindLong(2, storedImage.getByteSize());
            supportSQLiteStatement.bindLong(3, storedImage.getDownloadDate());
            supportSQLiteStatement.bindLong(4, storedImage.getUsageDate());
            supportSQLiteStatement.bindLong(5, storedImage.getSignatureCount());
            supportSQLiteStatement.bindLong(6, storedImage.getVTokenUID());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `images` SET `vTokenUID` = ?,`byteSize` = ?,`downloadDate` = ?,`lastUsageDate` = ?,`signatureCount` = ? WHERE `vTokenUID` = ?";
        }
    }

    public ImageDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // it.aep_italia.vts.sdk.internal.database.images.ImageDao
    public void deleteImages(List<StoredImage> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // it.aep_italia.vts.sdk.internal.database.images.ImageDao
    public List<StoredImage> readByNotUsedSince(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM images WHERE lastUsageDate < ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vTokenUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "byteSize");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadDate");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUsageDate");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signatureCount");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new StoredImage(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5)));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // it.aep_italia.vts.sdk.internal.database.images.ImageDao
    public StoredImage readByVTokenUID(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM images WHERE vTokenUID = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? new StoredImage(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "vTokenUID")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "byteSize")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadDate")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUsageDate")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "signatureCount"))) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // it.aep_italia.vts.sdk.internal.database.images.ImageDao
    public int readTotalSize() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT SUM(byteSize) FROM images", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // it.aep_italia.vts.sdk.internal.database.images.ImageDao
    public void saveImage(StoredImage storedImage) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(storedImage);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // it.aep_italia.vts.sdk.internal.database.images.ImageDao
    public void updateImage(StoredImage storedImage) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.d.handle(storedImage);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
