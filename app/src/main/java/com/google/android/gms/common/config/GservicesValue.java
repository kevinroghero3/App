package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;
import androidx.annotation.NonNull;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import io.sentry.android.core.SentryLogcatAdapter;

/* JADX INFO: loaded from: classes4.dex */
public abstract class GservicesValue<T> {
    private static final Object zzc = new Object();
    protected final String zza;
    protected final Object zzb;
    private Object zzd = null;

    protected GservicesValue(@NonNull String str, @NonNull Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    @ResultIgnorabilityUnspecified
    public static boolean isInitialized() {
        synchronized (zzc) {
        }
        return false;
    }

    public static GservicesValue<Float> value(@NonNull String str, @NonNull Float f) {
        return new zzd(str, f);
    }

    public static GservicesValue<Integer> value(@NonNull String str, @NonNull Integer num) {
        return new zzc(str, num);
    }

    public static GservicesValue<Long> value(@NonNull String str, @NonNull Long l) {
        return new zzb(str, l);
    }

    public static GservicesValue<String> value(@NonNull String str, @NonNull String str2) {
        return new zze(str, str2);
    }

    public static GservicesValue<Boolean> value(@NonNull String str, boolean z) {
        return new zza(str, Boolean.valueOf(z));
    }

    @ResultIgnorabilityUnspecified
    public final T get() {
        T t;
        T t2 = (T) this.zzd;
        if (t2 != null) {
            return t2;
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        Object obj = zzc;
        synchronized (obj) {
        }
        synchronized (obj) {
            try {
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                throw th;
            }
        }
        try {
            t = (T) zza(this.zza);
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                Object objZza = zza(this.zza);
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                t = (T) objZza;
            } catch (Throwable th2) {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                throw th2;
            }
        }
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        return t;
    }

    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    public void override(@NonNull T t) {
        SentryLogcatAdapter.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.zzd = t;
        Object obj = zzc;
        synchronized (obj) {
            synchronized (obj) {
            }
        }
    }

    public void resetOverride() {
        this.zzd = null;
    }

    protected abstract Object zza(@NonNull String str);
}
