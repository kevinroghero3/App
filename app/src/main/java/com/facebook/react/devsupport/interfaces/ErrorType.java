package com.facebook.react.devsupport.interfaces;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
public enum ErrorType {
    JS("JS"),
    NATIVE("Native");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String displayName;

    public static EnumEntries<ErrorType> getEntries() {
        return $ENTRIES;
    }

    ErrorType(String str) {
        this.displayName = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.displayName;
    }
}
