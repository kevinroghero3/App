package com.facebook.react.common;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes.dex */
public enum LifecycleState {
    BEFORE_CREATE,
    BEFORE_RESUME,
    RESUMED;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<LifecycleState> getEntries() {
        return $ENTRIES;
    }
}
