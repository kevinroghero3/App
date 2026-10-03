package com.google.firebase.remoteconfig.interop.rollouts;

import androidx.annotation.NonNull;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RolloutsState {
    public abstract Set<RolloutAssignment> getRolloutAssignments();

    public static RolloutsState create(@NonNull Set<RolloutAssignment> set) {
        return new AutoValue_RolloutsState(set);
    }
}
