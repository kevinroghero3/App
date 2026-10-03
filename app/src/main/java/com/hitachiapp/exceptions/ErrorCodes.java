package com.hitachiapp.exceptions;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum ErrorCodes {
    APP_DEBUGGABLE(-1),
    RUNNING_ON_EMULATOR(-2),
    SIGNED_WITH_DEBUG_KEY(-3),
    SIGNED_WITH_INVALID_KEY(-4),
    DEBUGGER_ATTACHED(-5),
    APP_HOOKED(-6),
    RUNNING_ON_ROOTED_DEVICE(-7),
    PINNING_INIT_ERROR(-8);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public final int code;

    public static EnumEntries<ErrorCodes> getEntries() {
        return $ENTRIES;
    }

    ErrorCodes(int i) {
        this.code = i;
    }
}
