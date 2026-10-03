package com.salesforce.marketingcloud.sfmcsdk.modules;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum ModuleIdentifier {
    PUSH,
    CDP;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<ModuleIdentifier> getEntries() {
        return $ENTRIES;
    }
}
