package com.facebook.react.bridge;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes.dex */
public enum ReadableType {
    Null,
    Boolean,
    Number,
    String,
    Map,
    Array;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<ReadableType> getEntries() {
        return $ENTRIES;
    }
}
