package androidx.sqlite.db;

import java.io.Closeable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i, @NotNull byte[] bArr);

    void bindDouble(int i, double d);

    void bindLong(int i, long j);

    void bindNull(int i);

    void bindString(int i, @NotNull String str);

    void clearBindings();
}
