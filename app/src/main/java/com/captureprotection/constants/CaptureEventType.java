package com.captureprotection.constants;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
public enum CaptureEventType {
    NONE(0),
    RECORDING(1),
    END_RECORDING(2),
    CAPTURED(3),
    APP_SWITCHING(4),
    UNKNOWN(5),
    ALLOW(8),
    PREVENT_SCREEN_CAPTURE(16),
    PREVENT_SCREEN_RECORDING(32),
    PREVENT_SCREEN_APP_SWITCHING(64);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int value;

    public static EnumEntries<CaptureEventType> getEntries() {
        return $ENTRIES;
    }

    CaptureEventType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
