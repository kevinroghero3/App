package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class Objects {
    public static int IconCompatParcelizer;
    public static int writeTypedObject;

    public static final class ToStringHelper {
        private final List zza;
        private final Object zzb;

        /* synthetic */ ToStringHelper(Object obj, zzai zzaiVar) {
            Preconditions.checkNotNull(obj);
            this.zzb = obj;
            this.zza = new ArrayList();
        }

        public ToStringHelper add(@NonNull String str, @Nullable Object obj) {
            Preconditions.checkNotNull(str);
            this.zza.add(str + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.zzb.getClass().getSimpleName());
            sb.append(CoreConstants.CURLY_LEFT);
            int size = this.zza.size();
            for (int i = 0; i < size; i++) {
                sb.append((String) this.zza.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(CoreConstants.CURLY_RIGHT);
            return sb.toString();
        }
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
    }

    public static boolean checkBundlesEquality(@NonNull Bundle bundle, @NonNull Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return bundle == bundle2;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        Set<String> setKeySet = bundle.keySet();
        if (!setKeySet.containsAll(bundle2.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            if (!equal(bundle.get(str), bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(@NonNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(@NonNull Object obj) {
        return new ToStringHelper(obj, null);
    }

    public static int ICustomTabsCallbackStubProxy() {
        int i = writeTypedObject;
        int i2 = i % 8821049;
        writeTypedObject = i + 1;
        if (i2 != 0) {
            return IconCompatParcelizer;
        }
        int iMyTid = Process.myTid();
        IconCompatParcelizer = iMyTid;
        return iMyTid;
    }
}
