package com.mrousavy.camera.core.types;

import com.facebook.internal.AnalyticsEvents;
import io.sentry.protocol.SentryStackTrace;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
public enum ShutterType implements JSUnionValue {
    PHOTO(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO),
    SNAPSHOT(SentryStackTrace.JsonKeys.SNAPSHOT);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String unionValue;

    public static EnumEntries<ShutterType> getEntries() {
        return $ENTRIES;
    }

    ShutterType(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }
}
