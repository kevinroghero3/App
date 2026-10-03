package com.facebook.react.uimanager;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
public enum NativeKind {
    PARENT,
    LEAF,
    NONE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<NativeKind> getEntries() {
        return $ENTRIES;
    }
}
