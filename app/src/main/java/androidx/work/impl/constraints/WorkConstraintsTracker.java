package androidx.work.impl.constraints;

import androidx.work.impl.model.WorkSpec;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface WorkConstraintsTracker {
    void replace(@NotNull Iterable<WorkSpec> iterable);

    void reset();
}
