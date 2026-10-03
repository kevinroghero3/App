package com.mrousavy.camera.core.types;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum DeviceType implements JSUnionValue {
    ULTRA_WIDE_ANGLE("ultra-wide-angle-camera"),
    WIDE_ANGLE("wide-angle-camera"),
    TELEPHOTO("telephoto-camera");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String unionValue;

    public static EnumEntries<DeviceType> getEntries() {
        return $ENTRIES;
    }

    DeviceType(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }
}
