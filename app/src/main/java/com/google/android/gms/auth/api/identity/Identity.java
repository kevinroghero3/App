package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p000authapi.zbaa;
import com.google.android.gms.internal.p000authapi.zbag;
import com.google.android.gms.internal.p000authapi.zbaq;

/* JADX INFO: loaded from: classes4.dex */
public final class Identity {
    private Identity() {
    }

    public static AuthorizationClient getAuthorizationClient(@NonNull Activity activity) {
        return new zbaa((Activity) Preconditions.checkNotNull(activity), new zbb(null).zbb());
    }

    public static CredentialSavingClient getCredentialSavingClient(@NonNull Activity activity) {
        return new zbag((Activity) Preconditions.checkNotNull(activity), new zbh());
    }

    public static SignInClient getSignInClient(@NonNull Activity activity) {
        return new zbaq((Activity) Preconditions.checkNotNull(activity), new zbu());
    }

    public static AuthorizationClient getAuthorizationClient(@NonNull Context context) {
        return new zbaa((Context) Preconditions.checkNotNull(context), new zbb(null).zbb());
    }

    public static CredentialSavingClient getCredentialSavingClient(@NonNull Context context) {
        return new zbag((Context) Preconditions.checkNotNull(context), new zbh());
    }

    public static SignInClient getSignInClient(@NonNull Context context) {
        return new zbaq((Context) Preconditions.checkNotNull(context), new zbu());
    }
}
