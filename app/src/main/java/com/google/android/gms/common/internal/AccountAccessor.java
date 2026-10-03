package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.sentry.android.core.SentryLogcatAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class AccountAccessor extends IAccountAccessor.Stub {
    public static Account getAccountBinderSafe(@NonNull IAccountAccessor iAccountAccessor) throws RemoteException {
        Account accountZzb = null;
        if (iAccountAccessor != null) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                accountZzb = iAccountAccessor.zzb();
            } catch (RemoteException unused) {
                SentryLogcatAdapter.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
        return accountZzb;
    }

    public final boolean equals(@Nullable Object obj) {
        throw null;
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public final Account zzb() {
        throw null;
    }
}
