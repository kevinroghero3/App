package androidx.work.impl.model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface WorkTagDao {
    void deleteByWorkSpecId(@NotNull String str);

    List<String> getTagsForWorkSpecId(@NotNull String str);

    List<String> getWorkSpecIdsWithTag(@NotNull String str);

    void insert(@NotNull WorkTag workTag);

    void insertTags(@NotNull String str, @NotNull Set<String> set);

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void insertTags(@NotNull WorkTagDao workTagDao, @NotNull String id, @NotNull Set<String> tags) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Iterator<T> it2 = tags.iterator();
            while (it2.hasNext()) {
                workTagDao.insert(new WorkTag((String) it2.next(), id));
            }
        }
    }
}
