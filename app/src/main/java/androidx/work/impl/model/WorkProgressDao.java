package androidx.work.impl.model;

import androidx.work.Data;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface WorkProgressDao {
    void delete(@NotNull String str);

    void deleteAll();

    Data getProgressForWorkSpecId(@NotNull String str);

    void insert(@NotNull WorkProgress workProgress);
}
