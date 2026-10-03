package com.hitachiapp.exceptions;

import java.lang.reflect.Constructor;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public class MyCiceroException extends Exception {
    public final ErrorCodes errorCode;

    public MyCiceroException(@NotNull ErrorCodes errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.errorCode = errorCode;
    }

    public static void $$a(long j, long j2) throws Throwable {
        try {
            Constructor declaredConstructor = SignedWithInvalidKeyException.class.getDeclaredConstructor(null);
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
