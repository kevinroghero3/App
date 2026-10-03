package com.google.android.gms.common.util;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import io.sentry.android.core.SentryLogcatAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class CrashUtils {
    private static final String[] zza = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    @ResultIgnorabilityUnspecified
    public static boolean addDynamiteErrorToDropBox(@NonNull Context context, @NonNull Throwable th) {
        try {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(th);
            return false;
        } catch (Exception e) {
            SentryLogcatAdapter.e("CrashUtils", "Error adding exception to DropBox!", e);
            return false;
        }
    }
}
