package com.google.android.gms.common.stats;

import ch.qos.logback.classic.net.SyslogAppender;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    public interface Types {
        public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;
        public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
    }

    public final String toString() {
        return zzb() + SyslogAppender.DEFAULT_STACKTRACE_PATTERN + zza() + "\t-1" + zzc();
    }

    public abstract int zza();

    public abstract long zzb();

    public abstract String zzc();
}
