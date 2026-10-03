package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.errorprone.annotations.FormatString;
import io.sentry.android.core.SentryLogcatAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class GmsLogger {
    private final String zza;
    private final String zzb;

    public GmsLogger(@NonNull String str) {
        this(str, null);
    }

    private final String zza(String str) {
        String str2 = this.zzb;
        return str2 == null ? str : str2.concat(str);
    }

    private final String zzb(String str, Object... objArr) {
        String str2 = this.zzb;
        String str3 = String.format(str, objArr);
        return str2 == null ? str3 : str2.concat(str3);
    }

    public boolean canLog(int i) {
        return Log.isLoggable(this.zza, i);
    }

    public boolean canLogPii() {
        return false;
    }

    public void d(@NonNull String str, @NonNull String str2) {
        if (canLog(3)) {
            Log.d(str, zza(str2));
        }
    }

    public void e(@NonNull String str, @NonNull String str2) {
        if (canLog(6)) {
            SentryLogcatAdapter.e(str, zza(str2));
        }
    }

    public void efmt(@NonNull String str, @NonNull @FormatString String str2, @NonNull Object... objArr) {
        if (canLog(6)) {
            SentryLogcatAdapter.e(str, zzb(str2, objArr));
        }
    }

    public void i(@NonNull String str, @NonNull String str2) {
        if (canLog(4)) {
            Log.i(str, zza(str2));
        }
    }

    public void pii(@NonNull String str, @NonNull String str2) {
    }

    public void pii(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
    }

    public void v(@NonNull String str, @NonNull String str2) {
        if (canLog(2)) {
            Log.v(str, zza(str2));
        }
    }

    public void w(@NonNull String str, @NonNull String str2) {
        if (canLog(5)) {
            SentryLogcatAdapter.w(str, zza(str2));
        }
    }

    public void wfmt(@NonNull String str, @NonNull @FormatString String str2, @NonNull Object... objArr) {
        if (canLog(5)) {
            SentryLogcatAdapter.w(this.zza, zzb(str2, objArr));
        }
    }

    public void wtf(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(7)) {
            SentryLogcatAdapter.e(str, zza(str2), th);
            SentryLogcatAdapter.wtf(str, zza(str2), th);
        }
    }

    public GmsLogger(@NonNull String str, @Nullable String str2) {
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zza = str;
        this.zzb = (str2 == null || str2.length() <= 0) ? null : str2;
    }

    public void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(3)) {
            Log.d(str, zza(str2), th);
        }
    }

    public void e(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(6)) {
            SentryLogcatAdapter.e(str, zza(str2), th);
        }
    }

    public void i(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(4)) {
            Log.i(str, zza(str2), th);
        }
    }

    public void v(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(2)) {
            Log.v(str, zza(str2), th);
        }
    }

    public void w(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(5)) {
            SentryLogcatAdapter.w(str, zza(str2), th);
        }
    }
}
