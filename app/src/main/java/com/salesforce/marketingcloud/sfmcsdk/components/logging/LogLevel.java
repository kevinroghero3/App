package com.salesforce.marketingcloud.sfmcsdk.components.logging;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes.dex */
public enum LogLevel {
    DEBUG,
    WARN,
    ERROR,
    NONE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<LogLevel> getEntries() {
        return $ENTRIES;
    }
}
