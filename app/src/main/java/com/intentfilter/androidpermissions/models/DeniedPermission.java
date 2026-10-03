package com.intentfilter.androidpermissions.models;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/* JADX INFO: loaded from: classes.dex */
@Parcel
public class DeniedPermission {
    final String permission;
    final boolean shouldShowRationale;

    @ParcelConstructor
    public DeniedPermission(String str, boolean z) {
        this.permission = str;
        this.shouldShowRationale = z;
    }

    public boolean shouldShowRationale() {
        return this.shouldShowRationale;
    }

    public String toString() {
        return this.permission;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return this.permission.equals(((DeniedPermission) obj).permission);
    }

    public int hashCode() {
        return this.permission.hashCode();
    }
}
