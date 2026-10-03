package com.google.api;

import com.google.protobuf.ExtensionRegistryLite;
import com.hitachiapp.exceptions.AppDebuggableException;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes5.dex */
public final class QuotaProto {
    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private QuotaProto() {
    }

    public static void $$a(long j, long j2) throws Throwable {
        try {
            Constructor declaredConstructor = AppDebuggableException.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            throw ((Throwable) declaredConstructor.newInstance(null));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }
}
