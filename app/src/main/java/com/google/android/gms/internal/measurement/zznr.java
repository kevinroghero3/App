package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public enum zznr {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzih.zza),
    ENUM(null),
    MESSAGE(null);

    private final Object zzk;

    zznr(Object obj) {
        this.zzk = obj;
    }
}
