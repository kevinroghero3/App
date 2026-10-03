package com.facebook.react.views.image;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes.dex */
public enum ImageResizeMethod {
    AUTO,
    RESIZE,
    SCALE,
    NONE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<ImageResizeMethod> getEntries() {
        return $ENTRIES;
    }
}
