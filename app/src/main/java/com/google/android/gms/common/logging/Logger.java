package com.google.android.gms.common.logging;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.GmsLogger;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Logger {
    private final String zza;
    private final String zzb;
    private final GmsLogger zzc;
    private final int zzd;

    public Logger(@NonNull String str, @NonNull String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str2 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str2);
            }
            sb.append("] ");
            string = sb.toString();
        }
        this.zzb = string;
        this.zza = str;
        this.zzc = new GmsLogger(str);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.zza, i)) {
            i++;
        }
        this.zzd = i;
    }

    public void d(@NonNull String str, @NonNull Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.zza, format(str, objArr));
        }
    }

    public void e(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        SentryLogcatAdapter.e(this.zza, format(str, objArr), th);
    }

    protected String format(@NonNull String str, @NonNull Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzb.concat(str);
    }

    public String getTag() {
        return this.zza;
    }

    public void i(@NonNull String str, @NonNull Object... objArr) {
        Log.i(this.zza, format(str, objArr));
    }

    public boolean isLoggable(int i) {
        return this.zzd <= i;
    }

    public void v(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.zza, format(str, objArr), th);
        }
    }

    public void w(@NonNull String str, @NonNull Object... objArr) {
        SentryLogcatAdapter.w(this.zza, format(str, objArr));
    }

    public void wtf(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        SentryLogcatAdapter.wtf(this.zza, format(str, objArr), th);
    }

    public void e(@NonNull String str, @NonNull Object... objArr) {
        SentryLogcatAdapter.e(this.zza, format(str, objArr));
    }

    public void wtf(@NonNull Throwable th) {
        SentryLogcatAdapter.wtf(this.zza, th);
    }

    public void v(@NonNull String str, @NonNull Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.zza, format(str, objArr));
        }
    }
}
