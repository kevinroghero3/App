package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes4.dex */
public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    private static final zbb zbb = new zbb(null);
    static int zba = 1;

    GoogleSignInClient(@NonNull Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    private final int zba() {
        int i;
        synchronized (this) {
            i = zba;
            if (i == 1) {
                Context applicationContext = getApplicationContext();
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
                int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(applicationContext, 12451000);
                if (iIsGooglePlayServicesAvailable == 0) {
                    i = 4;
                    zba = 4;
                } else if (googleApiAvailability.getErrorResolutionIntent(applicationContext, iIsGooglePlayServicesAvailable, null) != null || DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                    i = 2;
                    zba = 2;
                } else {
                    i = 3;
                    zba = 3;
                }
            }
        }
        return i;
    }

    public Intent getSignInIntent() {
        Context applicationContext = getApplicationContext();
        int iZba = zba();
        int i = iZba - 1;
        if (iZba == 0) {
            throw null;
        }
        if (i != 2) {
            return i != 3 ? zbm.zbb(applicationContext, getApiOptions()) : zbm.zbc(applicationContext, getApiOptions());
        }
        return zbm.zba(applicationContext, getApiOptions());
    }

    public Task<Void> revokeAccess() {
        return PendingResultUtil.toVoidTask(zbm.zbf(asGoogleApiClient(), getApplicationContext(), zba() == 3));
    }

    public Task<Void> signOut() {
        return PendingResultUtil.toVoidTask(zbm.zbg(asGoogleApiClient(), getApplicationContext(), zba() == 3));
    }

    public Task<GoogleSignInAccount> silentSignIn() {
        return PendingResultUtil.toTask(zbm.zbe(asGoogleApiClient(), getApplicationContext(), getApiOptions(), zba() == 3), zbb);
    }

    GoogleSignInClient(@NonNull Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }
}
