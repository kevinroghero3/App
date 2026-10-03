package com.salesforce.marketingcloud.sfmcsdk;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum InitializationState {
    NONE,
    INITIALIZING,
    READY,
    ERROR;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<InitializationState> getEntries() {
        return $ENTRIES;
    }
}
