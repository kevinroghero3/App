package androidx.work.impl.model;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface WorkNameDao {
    List<String> getNamesForWorkSpecId(@NotNull String str);

    List<String> getWorkSpecIdsWithName(@NotNull String str);

    void insert(@NotNull WorkName workName);
}
