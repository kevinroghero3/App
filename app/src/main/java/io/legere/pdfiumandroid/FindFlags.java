package io.legere.pdfiumandroid;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
public enum FindFlags {
    MatchCase(1),
    MatchWholeWord(2),
    Consecutive(4);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int value;

    public static EnumEntries<FindFlags> getEntries() {
        return $ENTRIES;
    }

    FindFlags(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
