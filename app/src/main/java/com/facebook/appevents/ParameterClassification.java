package com.facebook.appevents;

/* JADX INFO: loaded from: classes2.dex */
public enum ParameterClassification {
    CustomData("custom_data"),
    OperationalData("operational_data"),
    CustomAndOperationalData("custom_and_operational_data");

    private final String value;

    ParameterClassification(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
