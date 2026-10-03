package androidx.work.impl;

import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public class WorkRequestHolder extends WorkRequest {
    public WorkRequestHolder(@NonNull UUID uuid, @NonNull WorkSpec workSpec, @NonNull Set<String> set) {
        super(uuid, workSpec, set);
    }
}
