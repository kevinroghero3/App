package com.facebook.imagepipeline.core;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes.dex */
public enum DownsampleMode {
    ALWAYS,
    AUTO,
    NEVER;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<DownsampleMode> getEntries() {
        return $ENTRIES;
    }
}
