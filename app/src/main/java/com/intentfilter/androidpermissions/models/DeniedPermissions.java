package com.intentfilter.androidpermissions.models;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.parceler.Parcel;

/* JADX INFO: loaded from: classes.dex */
@Parcel
public class DeniedPermissions extends HashSet<DeniedPermission> {
    public static DeniedPermissions create(@NonNull DeniedPermission... deniedPermissionArr) {
        DeniedPermissions deniedPermissions = new DeniedPermissions();
        deniedPermissions.addAll(Arrays.asList(deniedPermissionArr));
        return deniedPermissions;
    }

    public Set<String> stripped() {
        HashSet hashSet = new HashSet();
        Iterator<DeniedPermission> it2 = iterator();
        while (it2.hasNext()) {
            hashSet.add(it2.next().permission);
        }
        return hashSet;
    }
}
