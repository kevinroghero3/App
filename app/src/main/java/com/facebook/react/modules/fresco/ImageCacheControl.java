package com.facebook.react.modules.fresco;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
public enum ImageCacheControl {
    DEFAULT,
    RELOAD,
    FORCE_CACHE,
    ONLY_IF_CACHED;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<ImageCacheControl> getEntries() {
        return $ENTRIES;
    }
}
