package androidx.sqlite.db;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteQuery {
    void bindTo(@NotNull SupportSQLiteProgram supportSQLiteProgram);

    int getArgCount();

    String getSql();
}
