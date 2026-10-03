package com.facebook.appevents.cloudbridge;

import com.salesforce.marketingcloud.config.a;

/* JADX INFO: loaded from: classes2.dex */
public enum SettingsAPIFields {
    URL(a.i),
    ENABLED("is_enabled"),
    DATASETID("dataset_id"),
    ACCESSKEY("access_key");

    private final String rawValue;

    SettingsAPIFields(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
