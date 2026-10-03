package androidx.work.impl.model;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface DependencyDao {
    List<String> getDependentWorkIds(@NotNull String str);

    List<String> getPrerequisites(@NotNull String str);

    boolean hasCompletedAllPrerequisites(@NotNull String str);

    boolean hasDependents(@NotNull String str);

    void insertDependency(@NotNull Dependency dependency);
}
