package com.google.android.gms.auth.api.identity;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AuthorizationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AuthorizationRequest> CREATOR = new zbd();
    private final List zba;
    private final String zbb;
    private final boolean zbc;
    private final boolean zbd;
    private final Account zbe;
    private final String zbf;
    private final String zbg;
    private final boolean zbh;

    public static final class Builder {
        private List zba;
        private String zbb;
        private boolean zbc;
        private boolean zbd;
        private Account zbe;
        private String zbf;
        private String zbg;
        private boolean zbh;

        private final String zbc(String str) {
            Preconditions.checkNotNull(str);
            String str2 = this.zbb;
            Preconditions.checkArgument(str2 == null || str2.equals(str), "two different server client ids provided");
            return str;
        }

        public AuthorizationRequest build() {
            return new AuthorizationRequest(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg, this.zbh);
        }

        public Builder filterByHostedDomain(@NonNull String str) {
            this.zbf = Preconditions.checkNotEmpty(str);
            return this;
        }

        public Builder requestOfflineAccess(@NonNull String str) {
            requestOfflineAccess(str, false);
            return this;
        }

        public Builder setAccount(@NonNull Account account) {
            this.zbe = (Account) Preconditions.checkNotNull(account);
            return this;
        }

        public Builder setRequestedScopes(@NonNull List<Scope> list) {
            Preconditions.checkArgument((list == null || list.isEmpty()) ? false : true, "requestedScopes cannot be null or empty");
            this.zba = list;
            return this;
        }

        public final Builder zba(@NonNull String str) {
            zbc(str);
            this.zbb = str;
            this.zbd = true;
            return this;
        }

        public final Builder zbb(@NonNull String str) {
            this.zbg = str;
            return this;
        }

        public Builder requestOfflineAccess(@NonNull String str, boolean z) {
            zbc(str);
            this.zbb = str;
            this.zbc = true;
            this.zbh = z;
            return this;
        }
    }

    AuthorizationRequest(@SafeParcelable.Param(id = 1) List list, @Nullable @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) boolean z2, @Nullable @SafeParcelable.Param(id = 5) Account account, @Nullable @SafeParcelable.Param(id = 6) String str2, @Nullable @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) boolean z3) {
        Preconditions.checkArgument((list == null || list.isEmpty()) ? false : true, "requestedScopes cannot be null or empty");
        this.zba = list;
        this.zbb = str;
        this.zbc = z;
        this.zbd = z2;
        this.zbe = account;
        this.zbf = str2;
        this.zbg = str3;
        this.zbh = z3;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder zba(@NonNull AuthorizationRequest authorizationRequest) {
        Preconditions.checkNotNull(authorizationRequest);
        Builder builder = builder();
        builder.setRequestedScopes(authorizationRequest.getRequestedScopes());
        boolean zIsForceCodeForRefreshToken = authorizationRequest.isForceCodeForRefreshToken();
        String hostedDomain = authorizationRequest.getHostedDomain();
        Account account = authorizationRequest.getAccount();
        String serverClientId = authorizationRequest.getServerClientId();
        String str = authorizationRequest.zbg;
        if (str != null) {
            builder.zbb(str);
        }
        if (hostedDomain != null) {
            builder.filterByHostedDomain(hostedDomain);
        }
        if (account != null) {
            builder.setAccount(account);
        }
        if (authorizationRequest.zbd && serverClientId != null) {
            builder.zba(serverClientId);
        }
        if (authorizationRequest.isOfflineAccessRequested() && serverClientId != null) {
            builder.requestOfflineAccess(serverClientId, zIsForceCodeForRefreshToken);
        }
        return builder;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof AuthorizationRequest)) {
            return false;
        }
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) obj;
        return this.zba.size() == authorizationRequest.zba.size() && this.zba.containsAll(authorizationRequest.zba) && this.zbc == authorizationRequest.zbc && this.zbh == authorizationRequest.zbh && this.zbd == authorizationRequest.zbd && Objects.equal(this.zbb, authorizationRequest.zbb) && Objects.equal(this.zbe, authorizationRequest.zbe) && Objects.equal(this.zbf, authorizationRequest.zbf) && Objects.equal(this.zbg, authorizationRequest.zbg);
    }

    public Account getAccount() {
        return this.zbe;
    }

    public String getHostedDomain() {
        return this.zbf;
    }

    public List<Scope> getRequestedScopes() {
        return this.zba;
    }

    public String getServerClientId() {
        return this.zbb;
    }

    public int hashCode() {
        List list = this.zba;
        String str = this.zbb;
        boolean z = this.zbc;
        boolean z2 = this.zbh;
        boolean z3 = this.zbd;
        return Objects.hashCode(list, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), this.zbe, this.zbf, this.zbg);
    }

    public boolean isForceCodeForRefreshToken() {
        return this.zbh;
    }

    public boolean isOfflineAccessRequested() {
        return this.zbc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getRequestedScopes(), false);
        SafeParcelWriter.writeString(parcel, 2, getServerClientId(), false);
        SafeParcelWriter.writeBoolean(parcel, 3, isOfflineAccessRequested());
        SafeParcelWriter.writeBoolean(parcel, 4, this.zbd);
        SafeParcelWriter.writeParcelable(parcel, 5, getAccount(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getHostedDomain(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zbg, false);
        SafeParcelWriter.writeBoolean(parcel, 8, isForceCodeForRefreshToken());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
