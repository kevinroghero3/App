package com.salesforce.marketingcloud.sfmcsdk.components.behaviors;

import java.util.EnumSet;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface BehaviorManager {
    void registerForBehaviors(@NotNull EnumSet<BehaviorType> enumSet, @NotNull BehaviorListener behaviorListener);

    void unregisterForAllBehaviors(@NotNull BehaviorListener behaviorListener);
}
