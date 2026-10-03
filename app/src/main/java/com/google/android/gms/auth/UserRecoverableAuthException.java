package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import io.sentry.android.core.SentryLogcatAdapter;

/* JADX INFO: loaded from: classes4.dex */
public class UserRecoverableAuthException extends GoogleAuthException {
    private final Intent zza;
    private final PendingIntent zzb;
    private final zzn zzc;

    public UserRecoverableAuthException(@Nullable String str, @Nullable Intent intent) {
        this(str, intent, null, zzn.LEGACY);
    }

    public static UserRecoverableAuthException zza(@Nullable String str, @NonNull Intent intent, @NonNull PendingIntent pendingIntent) {
        Preconditions.checkNotNull(intent);
        Preconditions.checkNotNull(pendingIntent);
        return new UserRecoverableAuthException(str, intent, pendingIntent, zzn.AUTH_INSTANTIATION);
    }

    public Intent getIntent() {
        Intent intent = this.zza;
        if (intent != null) {
            return new Intent(intent);
        }
        int iOrdinal = this.zzc.ordinal();
        if (iOrdinal == 0) {
            SentryLogcatAdapter.w("Auth", "Make sure that an intent was provided to class instantiation.");
            return null;
        }
        if (iOrdinal == 1) {
            SentryLogcatAdapter.e("Auth", "This shouldn't happen. Gms API throwing this exception should support the recovery Intent.");
            return null;
        }
        if (iOrdinal != 2) {
            return null;
        }
        SentryLogcatAdapter.e("Auth", "this instantiation of UserRecoverableAuthException doesn't support an Intent.");
        return null;
    }

    private UserRecoverableAuthException(@Nullable String str, @Nullable Intent intent, @Nullable PendingIntent pendingIntent, zzn zznVar) {
        super(str);
        this.zzb = pendingIntent;
        this.zza = intent;
        this.zzc = (zzn) Preconditions.checkNotNull(zznVar);
    }
}
