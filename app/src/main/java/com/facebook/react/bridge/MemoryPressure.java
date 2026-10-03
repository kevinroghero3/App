package com.facebook.react.bridge;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
public enum MemoryPressure {
    UI_HIDDEN,
    MODERATE,
    CRITICAL;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<MemoryPressure> getEntries() {
        return $ENTRIES;
    }
}
