package net.openid.appauth;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import net.openid.appauth.internal.UriUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AuthorizationResponse extends AuthorizationManagementResponse {
    public static final String EXTRA_RESPONSE = "net.openid.appauth.AuthorizationResponse";
    static final String KEY_ACCESS_TOKEN = "access_token";
    static final String KEY_ADDITIONAL_PARAMETERS = "additional_parameters";
    static final String KEY_AUTHORIZATION_CODE = "code";
    static final String KEY_EXPIRES_AT = "expires_at";
    static final String KEY_EXPIRES_IN = "expires_in";
    static final String KEY_ID_TOKEN = "id_token";
    static final String KEY_REQUEST = "request";
    static final String KEY_SCOPE = "scope";
    static final String KEY_STATE = "state";
    public static final String TOKEN_TYPE_BEARER = "bearer";
    public final String accessToken;
    public final Long accessTokenExpirationTime;
    public final Map<String, String> additionalParameters;
    public final String authorizationCode;
    public final String idToken;
    public final AuthorizationRequest request;
    public final String scope;
    public final String state;
    public final String tokenType;
    static final String KEY_TOKEN_TYPE = "token_type";
    private static final Set<String> BUILT_IN_PARAMS = Collections.unmodifiableSet(new HashSet(Arrays.asList(KEY_TOKEN_TYPE, "state", "code", "access_token", "expires_in", "id_token", "scope")));

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Builder {
        private String mAccessToken;
        private Long mAccessTokenExpirationTime;
        private Map<String, String> mAdditionalParameters = new LinkedHashMap();
        private String mAuthorizationCode;
        private String mIdToken;
        private AuthorizationRequest mRequest;
        private String mScope;
        private String mState;
        private String mTokenType;

        public Builder(@NonNull AuthorizationRequest authorizationRequest) {
            this.mRequest = (AuthorizationRequest) Preconditions.checkNotNull(authorizationRequest, "authorization request cannot be null");
        }

        public Builder fromUri(@NonNull Uri uri) {
            return fromUri(uri, SystemClock.INSTANCE);
        }

        Builder fromUri(@NonNull Uri uri, @NonNull Clock clock) {
            setState(uri.getQueryParameter("state"));
            setTokenType(uri.getQueryParameter(AuthorizationResponse.KEY_TOKEN_TYPE));
            setAuthorizationCode(uri.getQueryParameter("code"));
            setAccessToken(uri.getQueryParameter("access_token"));
            setAccessTokenExpiresIn(UriUtil.getLongQueryParameter(uri, "expires_in"), clock);
            setIdToken(uri.getQueryParameter("id_token"));
            setScope(uri.getQueryParameter("scope"));
            setAdditionalParameters(AdditionalParamsProcessor.extractAdditionalParams(uri, (Set<String>) AuthorizationResponse.BUILT_IN_PARAMS));
            return this;
        }

        public Builder setState(@Nullable String str) {
            Preconditions.checkNullOrNotEmpty(str, "state must not be empty");
            this.mState = str;
            return this;
        }

        public Builder setTokenType(@Nullable String str) {
            Preconditions.checkNullOrNotEmpty(str, "tokenType must not be empty");
            this.mTokenType = str;
            return this;
        }

        public Builder setAuthorizationCode(@Nullable String str) {
            Preconditions.checkNullOrNotEmpty(str, "authorizationCode must not be empty");
            this.mAuthorizationCode = str;
            return this;
        }

        public Builder setAccessToken(@Nullable String str) {
            Preconditions.checkNullOrNotEmpty(str, "accessToken must not be empty");
            this.mAccessToken = str;
            return this;
        }

        public Builder setAccessTokenExpiresIn(@Nullable Long l) {
            return setAccessTokenExpiresIn(l, SystemClock.INSTANCE);
        }

        public Builder setAccessTokenExpiresIn(@Nullable Long l, @NonNull Clock clock) {
            if (l == null) {
                this.mAccessTokenExpirationTime = null;
            } else {
                this.mAccessTokenExpirationTime = Long.valueOf(clock.getCurrentTimeMillis() + TimeUnit.SECONDS.toMillis(l.longValue()));
            }
            return this;
        }

        public Builder setAccessTokenExpirationTime(@Nullable Long l) {
            this.mAccessTokenExpirationTime = l;
            return this;
        }

        public Builder setIdToken(@Nullable String str) {
            Preconditions.checkNullOrNotEmpty(str, "idToken cannot be empty");
            this.mIdToken = str;
            return this;
        }

        public Builder setScope(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                this.mScope = null;
            } else {
                setScopes(str.split(" +"));
            }
            return this;
        }

        public Builder setScopes(String... strArr) {
            if (strArr == null) {
                this.mScope = null;
            } else {
                setScopes(Arrays.asList(strArr));
            }
            return this;
        }

        public Builder setScopes(@Nullable Iterable<String> iterable) {
            this.mScope = AsciiStringListUtil.iterableToString(iterable);
            return this;
        }

        public Builder setAdditionalParameters(@Nullable Map<String, String> map) {
            this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(map, AuthorizationResponse.BUILT_IN_PARAMS);
            return this;
        }

        public AuthorizationResponse build() {
            return new AuthorizationResponse(this.mRequest, this.mState, this.mTokenType, this.mAuthorizationCode, this.mAccessToken, this.mAccessTokenExpirationTime, this.mIdToken, this.mScope, Collections.unmodifiableMap(this.mAdditionalParameters));
        }
    }

    private AuthorizationResponse(@NonNull AuthorizationRequest authorizationRequest, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Long l, @Nullable String str5, @Nullable String str6, @NonNull Map<String, String> map) {
        this.request = authorizationRequest;
        this.state = str;
        this.tokenType = str2;
        this.authorizationCode = str3;
        this.accessToken = str4;
        this.accessTokenExpirationTime = l;
        this.idToken = str5;
        this.scope = str6;
        this.additionalParameters = map;
    }

    public boolean hasAccessTokenExpired() {
        return hasAccessTokenExpired(SystemClock.INSTANCE);
    }

    boolean hasAccessTokenExpired(@NonNull Clock clock) {
        return this.accessTokenExpirationTime != null && ((Clock) Preconditions.checkNotNull(clock)).getCurrentTimeMillis() > this.accessTokenExpirationTime.longValue();
    }

    public Set<String> getScopeSet() {
        return AsciiStringListUtil.stringToSet(this.scope);
    }

    public TokenRequest createTokenExchangeRequest() {
        return createTokenExchangeRequest(Collections.emptyMap());
    }

    public TokenRequest createTokenExchangeRequest(@NonNull Map<String, String> map) {
        Preconditions.checkNotNull(map, "additionalExchangeParameters cannot be null");
        if (this.authorizationCode == null) {
            throw new IllegalStateException("authorizationCode not available for exchange request");
        }
        AuthorizationRequest authorizationRequest = this.request;
        return new TokenRequest.Builder(authorizationRequest.configuration, authorizationRequest.clientId).setGrantType(GrantTypeValues.AUTHORIZATION_CODE).setRedirectUri(this.request.redirectUri).setCodeVerifier(this.request.codeVerifier).setAuthorizationCode(this.authorizationCode).setAdditionalParameters(map).setNonce(this.request.nonce).build();
    }

    @Override // net.openid.appauth.AuthorizationManagementResponse
    public String getState() {
        return this.state;
    }

    @Override // net.openid.appauth.AuthorizationManagementResponse
    public JSONObject jsonSerialize() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, "request", this.request.jsonSerialize());
        JsonUtil.putIfNotNull(jSONObject, "state", this.state);
        JsonUtil.putIfNotNull(jSONObject, KEY_TOKEN_TYPE, this.tokenType);
        JsonUtil.putIfNotNull(jSONObject, "code", this.authorizationCode);
        JsonUtil.putIfNotNull(jSONObject, "access_token", this.accessToken);
        JsonUtil.putIfNotNull(jSONObject, KEY_EXPIRES_AT, this.accessTokenExpirationTime);
        JsonUtil.putIfNotNull(jSONObject, "id_token", this.idToken);
        JsonUtil.putIfNotNull(jSONObject, "scope", this.scope);
        JsonUtil.put(jSONObject, KEY_ADDITIONAL_PARAMETERS, JsonUtil.mapToJsonObject(this.additionalParameters));
        return jSONObject;
    }

    public static AuthorizationResponse jsonDeserialize(@NonNull JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("request")) {
            throw new IllegalArgumentException("authorization request not provided and not found in JSON");
        }
        return new AuthorizationResponse(AuthorizationRequest.jsonDeserialize(jSONObject.getJSONObject("request")), JsonUtil.getStringIfDefined(jSONObject, "state"), JsonUtil.getStringIfDefined(jSONObject, KEY_TOKEN_TYPE), JsonUtil.getStringIfDefined(jSONObject, "code"), JsonUtil.getStringIfDefined(jSONObject, "access_token"), JsonUtil.getLongIfDefined(jSONObject, KEY_EXPIRES_AT), JsonUtil.getStringIfDefined(jSONObject, "id_token"), JsonUtil.getStringIfDefined(jSONObject, "scope"), JsonUtil.getStringMap(jSONObject, KEY_ADDITIONAL_PARAMETERS));
    }

    public static AuthorizationResponse jsonDeserialize(@NonNull String str) throws JSONException {
        return jsonDeserialize(new JSONObject(str));
    }

    @Override // net.openid.appauth.AuthorizationManagementResponse
    public Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_RESPONSE, jsonSerializeString());
        return intent;
    }

    public static AuthorizationResponse fromIntent(@NonNull Intent intent) {
        Preconditions.checkNotNull(intent, "dataIntent must not be null");
        if (!intent.hasExtra(EXTRA_RESPONSE)) {
            return null;
        }
        try {
            return jsonDeserialize(intent.getStringExtra(EXTRA_RESPONSE));
        } catch (JSONException e) {
            throw new IllegalArgumentException("Intent contains malformed auth response", e);
        }
    }

    static boolean containsAuthorizationResponse(@NonNull Intent intent) {
        return intent.hasExtra(EXTRA_RESPONSE);
    }
}
