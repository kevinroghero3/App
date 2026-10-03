package com.facebook.react;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes.dex */
public enum JSEngineResolutionAlgorithm {
    JSC,
    HERMES;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<JSEngineResolutionAlgorithm> getEntries() {
        return $ENTRIES;
    }
}
