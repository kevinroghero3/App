package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class GoogleAuthUtil extends zzl {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";

    private GoogleAuthUtil() {
    }

    public static void clearToken(@NonNull Context context, @NonNull String str) throws GoogleAuthException, IOException {
        zzl.clearToken(context, str);
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(@NonNull Context context, int i, @NonNull String str) throws GoogleAuthException, IOException {
        return zzl.getAccountChangeEvents(context, i, str);
    }

    public static String getAccountId(@NonNull Context context, @NonNull String str) throws GoogleAuthException, IOException {
        return zzl.getAccountId(context, str);
    }

    public static String getToken(@NonNull Context context, @NonNull Account account, @NonNull String str) throws IOException, GoogleAuthException {
        return zzl.getToken(context, account, str);
    }

    public static String getTokenWithNotification(@NonNull Context context, @NonNull Account account, @NonNull String str, @NonNull Bundle bundle) throws IOException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        bundle2.putBoolean("handle_notification", true);
        return zzg(context, account, str, bundle2, 0L).zza();
    }

    @Deprecated
    public static void invalidateToken(@NonNull Context context, @NonNull String str) {
        zzl.invalidateToken(context, str);
    }

    public static Bundle removeAccount(@NonNull Context context, @NonNull Account account) throws GoogleAuthException, IOException {
        return zzl.removeAccount(context, account);
    }

    public static Boolean requestGoogleAccountsAccess(@NonNull Context context) throws GoogleAuthException, IOException {
        return zzl.requestGoogleAccountsAccess(context);
    }

    private static TokenData zzg(Context context, Account account, String str, Bundle bundle, long j) throws GoogleAuthException, IOException {
        try {
            TokenData tokenDataZza = zzl.zza(context, account, str, bundle, 0L, null);
            GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
            return tokenDataZza;
        } catch (GooglePlayServicesAvailabilityException e) {
            GooglePlayServicesUtil.showErrorNotification(e.getConnectionStatusCode(), context);
            SentryLogcatAdapter.w("GoogleAuthUtil", "Error when getting token", e);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.", e);
        } catch (UserRecoverableAuthException e2) {
            GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
            SentryLogcatAdapter.w("GoogleAuthUtil", "Error when getting token", e2);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.", e2);
        }
    }

    public static String getToken(@NonNull Context context, @NonNull Account account, @NonNull String str, @NonNull Bundle bundle) throws IOException, GoogleAuthException {
        return zzl.getToken(context, account, str, bundle);
    }

    @Deprecated
    public static String getToken(@NonNull Context context, @NonNull String str, @NonNull String str2) throws IOException, GoogleAuthException {
        return zzl.getToken(context, str, str2);
    }

    @Deprecated
    public static String getToken(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws IOException, GoogleAuthException {
        return zzl.getToken(context, str, str2, bundle);
    }

    public static String getTokenWithNotification(@NonNull Context context, @NonNull Account account, @NonNull String str, @NonNull Bundle bundle, @NonNull Intent intent) throws IOException, GoogleAuthException {
        zzl.zzf(intent);
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        bundle2.putParcelable("callback_intent", intent);
        bundle2.putBoolean("handle_notification", true);
        return zzg(context, account, str, bundle2, 0L).zza();
    }

    public static String getTokenWithNotification(@NonNull Context context, @NonNull Account account, @NonNull String str, @NonNull Bundle bundle, @NonNull String str2, @NonNull Bundle bundle2) throws IOException, GoogleAuthException {
        Preconditions.checkNotEmpty(str2, "Authority cannot be empty or null.");
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle3 = bundle;
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(bundle2);
        bundle3.putString("authority", str2);
        bundle3.putBundle("sync_extras", bundle2);
        bundle3.putBoolean("handle_notification", true);
        return zzg(context, account, str, bundle3, 0L).zza();
    }

    @Deprecated
    public static String getTokenWithNotification(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws IOException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle);
    }

    @Deprecated
    public static String getTokenWithNotification(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle, @NonNull Intent intent) throws IOException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, intent);
    }

    @Deprecated
    public static String getTokenWithNotification(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle, @NonNull String str3, @NonNull Bundle bundle2) throws IOException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, str3, bundle2);
    }
}
