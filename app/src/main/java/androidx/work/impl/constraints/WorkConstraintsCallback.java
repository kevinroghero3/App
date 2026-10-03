package androidx.work.impl.constraints;

import androidx.work.impl.model.WorkSpec;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface WorkConstraintsCallback {
    void onAllConstraintsMet(@NotNull List<WorkSpec> list);

    void onAllConstraintsNotMet(@NotNull List<WorkSpec> list);
}
