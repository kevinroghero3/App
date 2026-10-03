package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes4.dex */
public interface GoogleSignInApi {
    public static final String EXTRA_SIGN_IN_ACCOUNT = "signInAccount";

    Intent getSignInIntent(@NonNull GoogleApiClient googleApiClient);

    GoogleSignInResult getSignInResultFromIntent(@NonNull Intent intent);

    PendingResult<Status> revokeAccess(@NonNull GoogleApiClient googleApiClient);

    PendingResult<Status> signOut(@NonNull GoogleApiClient googleApiClient);

    OptionalPendingResult<GoogleSignInResult> silentSignIn(@NonNull GoogleApiClient googleApiClient);
}
