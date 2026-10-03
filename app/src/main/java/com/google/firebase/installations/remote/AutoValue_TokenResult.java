package com.google.firebase.installations.remote;

import android.os.Process;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_TokenResult extends TokenResult {
    private final TokenResult.ResponseCode responseCode;
    private final String token;
    private final long tokenExpirationTimestamp;

    /* synthetic */ AutoValue_TokenResult(String str, long j, TokenResult.ResponseCode responseCode, AnonymousClass1 anonymousClass1) {
        this(str, j, responseCode);
    }

    private AutoValue_TokenResult(@Nullable String str, long j, @Nullable TokenResult.ResponseCode responseCode) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.responseCode = responseCode;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public String getToken() {
        return this.token;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public TokenResult.ResponseCode getResponseCode() {
        return this.responseCode;
    }

    public String toString() {
        return "TokenResult{token=" + this.token + ", tokenExpirationTimestamp=" + this.tokenExpirationTimestamp + ", responseCode=" + this.responseCode + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.token;
        if (str != null ? str.equals(tokenResult.getToken()) : tokenResult.getToken() == null) {
            if (this.tokenExpirationTimestamp == tokenResult.getTokenExpirationTimestamp()) {
                TokenResult.ResponseCode responseCode = this.responseCode;
                if (responseCode == null) {
                    if (tokenResult.getResponseCode() == null) {
                        return true;
                    }
                } else if (responseCode.equals(tokenResult.getResponseCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.token;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.tokenExpirationTimestamp;
        int i = (int) (j ^ (j >>> 32));
        TokenResult.ResponseCode responseCode = this.responseCode;
        return ((((iHashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ (responseCode != null ? responseCode.hashCode() : 0);
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public TokenResult.Builder toBuilder() {
        return new Builder(this, null);
    }

    /* JADX INFO: loaded from: classes5.dex */
    static final class Builder extends TokenResult.Builder {
        private TokenResult.ResponseCode responseCode;
        private String token;
        private Long tokenExpirationTimestamp;

        /* synthetic */ Builder(TokenResult tokenResult, AnonymousClass1 anonymousClass1) {
            this(tokenResult);
        }

        Builder() {
        }

        private Builder(TokenResult tokenResult) {
            this.token = tokenResult.getToken();
            this.tokenExpirationTimestamp = Long.valueOf(tokenResult.getTokenExpirationTimestamp());
            this.responseCode = tokenResult.getResponseCode();
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder setToken(String str) {
            this.token = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder setTokenExpirationTimestamp(long j) {
            this.tokenExpirationTimestamp = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder setResponseCode(TokenResult.ResponseCode responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult build() {
            String str = "";
            if (this.tokenExpirationTimestamp == null) {
                str = " tokenExpirationTimestamp";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_TokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.responseCode, null);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.installations.remote.AutoValue_TokenResult$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static int MediaBrowserCompatMediaBrowserImplBase;
        public static int forceCloseConnection;

        public static int notifyNotificationWithChannel() {
            int i = MediaBrowserCompatMediaBrowserImplBase;
            int i2 = i % 5006378;
            MediaBrowserCompatMediaBrowserImplBase = i + 1;
            if (i2 != 0) {
                return forceCloseConnection;
            }
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            forceCloseConnection = startElapsedRealtime;
            return startElapsedRealtime;
        }
    }
}
