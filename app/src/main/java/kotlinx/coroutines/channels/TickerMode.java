package kotlinx.coroutines.channels;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
public enum TickerMode {
    FIXED_PERIOD,
    FIXED_DELAY;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<TickerMode> getEntries() {
        return $ENTRIES;
    }
}
