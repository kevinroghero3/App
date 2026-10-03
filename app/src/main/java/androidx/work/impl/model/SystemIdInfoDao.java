package androidx.work.impl.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface SystemIdInfoDao {
    SystemIdInfo getSystemIdInfo(@NotNull WorkGenerationalId workGenerationalId);

    SystemIdInfo getSystemIdInfo(@NotNull String str, int i);

    List<String> getWorkSpecIds();

    void insertSystemIdInfo(@NotNull SystemIdInfo systemIdInfo);

    void removeSystemIdInfo(@NotNull WorkGenerationalId workGenerationalId);

    void removeSystemIdInfo(@NotNull String str);

    void removeSystemIdInfo(@NotNull String str, int i);

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static SystemIdInfo getSystemIdInfo(@NotNull SystemIdInfoDao systemIdInfoDao, @NotNull WorkGenerationalId id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return systemIdInfoDao.getSystemIdInfo(id.getWorkSpecId(), id.getGeneration());
        }

        public static void removeSystemIdInfo(@NotNull SystemIdInfoDao systemIdInfoDao, @NotNull WorkGenerationalId id) {
            Intrinsics.checkNotNullParameter(id, "id");
            systemIdInfoDao.removeSystemIdInfo(id.getWorkSpecId(), id.getGeneration());
        }
    }
}
