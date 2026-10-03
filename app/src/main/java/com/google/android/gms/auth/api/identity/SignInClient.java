package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes4.dex */
public interface SignInClient extends HasApiKey<zbu> {
    Task<BeginSignInResult> beginSignIn(@NonNull BeginSignInRequest beginSignInRequest);

    String getPhoneNumberFromIntent(@Nullable Intent intent) throws ApiException;

    Task<PendingIntent> getPhoneNumberHintIntent(@NonNull GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest);

    SignInCredential getSignInCredentialFromIntent(@Nullable Intent intent) throws ApiException;

    Task<PendingIntent> getSignInIntent(@NonNull GetSignInIntentRequest getSignInIntentRequest);

    Task<Void> signOut();
}
