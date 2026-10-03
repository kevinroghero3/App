package io.legere.pdfiumandroid.util;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum AlreadyClosedBehavior {
    EXCEPTION,
    IGNORE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<AlreadyClosedBehavior> getEntries() {
        return $ENTRIES;
    }
}
