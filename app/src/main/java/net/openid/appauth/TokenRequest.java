package net.openid.appauth;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TokenRequest {
    public static final String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";
    public static final String GRANT_TYPE_PASSWORD = "password";
    static final String KEY_ADDITIONAL_PARAMETERS = "additionalParameters";
    static final String KEY_AUTHORIZATION_CODE = "authorizationCode";
    static final String KEY_CLIENT_ID = "clientId";
    static final String KEY_CODE_VERIFIER = "codeVerifier";
    static final String KEY_CONFIGURATION = "configuration";
    static final String KEY_GRANT_TYPE = "grantType";
    static final String KEY_NONCE = "nonce";
    static final String KEY_REDIRECT_URI = "redirectUri";
    static final String KEY_REFRESH_TOKEN = "refreshToken";
    static final String KEY_SCOPE = "scope";
    public static final String PARAM_CLIENT_ID = "client_id";
    static final String PARAM_CODE = "code";
    static final String PARAM_REDIRECT_URI = "redirect_uri";
    static final String PARAM_REFRESH_TOKEN = "refresh_token";
    static final String PARAM_SCOPE = "scope";
    public final Map<String, String> additionalParameters;
    public final String authorizationCode;
    public final String clientId;
    public final String codeVerifier;
    public final AuthorizationServiceConfiguration configuration;
    public final String grantType;
    public final String nonce;
    public final Uri redirectUri;
    public final String refreshToken;
    public final String scope;
    static final String PARAM_CODE_VERIFIER = "code_verifier";
    static final String PARAM_GRANT_TYPE = "grant_type";
    private static final Set<String> BUILT_IN_PARAMS = Collections.unmodifiableSet(new HashSet(Arrays.asList("client_id", "code", PARAM_CODE_VERIFIER, PARAM_GRANT_TYPE, "redirect_uri", "refresh_token", "scope")));

    public static final class Builder {
        private Map<String, String> mAdditionalParameters;
        private String mAuthorizationCode;
        private String mClientId;
        private String mCodeVerifier;
        private AuthorizationServiceConfiguration mConfiguration;
        private String mGrantType;
        private String mNonce;
        private Uri mRedirectUri;
        private String mRefreshToken;
        private String mScope;

        public Builder(@NonNull AuthorizationServiceConfiguration authorizationServiceConfiguration, @NonNull String str) {
            setConfiguration(authorizationServiceConfiguration);
            setClientId(str);
            this.mAdditionalParameters = new LinkedHashMap();
        }

        public Builder setConfiguration(@NonNull AuthorizationServiceConfiguration authorizationServiceConfiguration) {
            this.mConfiguration = (AuthorizationServiceConfiguration) Preconditions.checkNotNull(authorizationServiceConfiguration);
            return this;
        }

        public Builder setClientId(@NonNull String str) {
            this.mClientId = Preconditions.checkNotEmpty(str, "clientId cannot be null or empty");
            return this;
        }

        public Builder setNonce(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                this.mNonce = null;
            } else {
                this.mNonce = str;
            }
            return this;
        }

        public Builder setGrantType(@NonNull String str) {
            this.mGrantType = Preconditions.checkNotEmpty(str, "grantType cannot be null or empty");
            return this;
        }

        public Builder setRedirectUri(@Nullable Uri uri) {
            if (uri != null) {
                Preconditions.checkNotNull(uri.getScheme(), "redirectUri must have a scheme");
            }
            this.mRedirectUri = uri;
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
                strArr = new String[0];
            }
            setScopes(Arrays.asList(strArr));
            return this;
        }

        public Builder setScopes(@Nullable Iterable<String> iterable) {
            this.mScope = AsciiStringListUtil.iterableToString(iterable);
            return this;
        }

        public Builder setAuthorizationCode(@Nullable String str) {
            Preconditions.checkNullOrNotEmpty(str, "authorization code must not be empty");
            this.mAuthorizationCode = str;
            return this;
        }

        public Builder setRefreshToken(@Nullable String str) {
            if (str != null) {
                Preconditions.checkNotEmpty(str, "refresh token cannot be empty if defined");
            }
            this.mRefreshToken = str;
            return this;
        }

        public Builder setCodeVerifier(@Nullable String str) {
            if (str != null) {
                CodeVerifierUtil.checkCodeVerifier(str);
            }
            this.mCodeVerifier = str;
            return this;
        }

        public Builder setAdditionalParameters(@Nullable Map<String, String> map) {
            this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(map, TokenRequest.BUILT_IN_PARAMS);
            return this;
        }

        public TokenRequest build() {
            String strInferGrantType = inferGrantType();
            if (GrantTypeValues.AUTHORIZATION_CODE.equals(strInferGrantType)) {
                Preconditions.checkNotNull(this.mAuthorizationCode, "authorization code must be specified for grant_type = authorization_code");
            }
            if ("refresh_token".equals(strInferGrantType)) {
                Preconditions.checkNotNull(this.mRefreshToken, "refresh token must be specified for grant_type = refresh_token");
            }
            if (strInferGrantType.equals(GrantTypeValues.AUTHORIZATION_CODE) && this.mRedirectUri == null) {
                throw new IllegalStateException("no redirect URI specified on token request for code exchange");
            }
            return new TokenRequest(this.mConfiguration, this.mClientId, this.mNonce, strInferGrantType, this.mRedirectUri, this.mScope, this.mAuthorizationCode, this.mRefreshToken, this.mCodeVerifier, Collections.unmodifiableMap(this.mAdditionalParameters));
        }

        private String inferGrantType() {
            String str = this.mGrantType;
            if (str != null) {
                return str;
            }
            if (this.mAuthorizationCode != null) {
                return GrantTypeValues.AUTHORIZATION_CODE;
            }
            if (this.mRefreshToken != null) {
                return "refresh_token";
            }
            throw new IllegalStateException("grant type not specified and cannot be inferred");
        }
    }

    private TokenRequest(@NonNull AuthorizationServiceConfiguration authorizationServiceConfiguration, @NonNull String str, @Nullable String str2, @NonNull String str3, @Nullable Uri uri, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @NonNull Map<String, String> map) {
        this.configuration = authorizationServiceConfiguration;
        this.clientId = str;
        this.nonce = str2;
        this.grantType = str3;
        this.redirectUri = uri;
        this.scope = str4;
        this.authorizationCode = str5;
        this.refreshToken = str6;
        this.codeVerifier = str7;
        this.additionalParameters = map;
    }

    public Set<String> getScopeSet() {
        return AsciiStringListUtil.stringToSet(this.scope);
    }

    public Map<String, String> getRequestParameters() {
        HashMap map = new HashMap();
        map.put(PARAM_GRANT_TYPE, this.grantType);
        putIfNotNull(map, "redirect_uri", this.redirectUri);
        putIfNotNull(map, "code", this.authorizationCode);
        putIfNotNull(map, "refresh_token", this.refreshToken);
        putIfNotNull(map, PARAM_CODE_VERIFIER, this.codeVerifier);
        putIfNotNull(map, "scope", this.scope);
        for (Map.Entry<String, String> entry : this.additionalParameters.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    private void putIfNotNull(Map<String, String> map, String str, Object obj) {
        if (obj != null) {
            map.put(str, obj.toString());
        }
    }

    public JSONObject jsonSerialize() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, KEY_CONFIGURATION, this.configuration.toJson());
        JsonUtil.put(jSONObject, KEY_CLIENT_ID, this.clientId);
        JsonUtil.putIfNotNull(jSONObject, "nonce", this.nonce);
        JsonUtil.put(jSONObject, KEY_GRANT_TYPE, this.grantType);
        JsonUtil.putIfNotNull(jSONObject, KEY_REDIRECT_URI, this.redirectUri);
        JsonUtil.putIfNotNull(jSONObject, "scope", this.scope);
        JsonUtil.putIfNotNull(jSONObject, KEY_AUTHORIZATION_CODE, this.authorizationCode);
        JsonUtil.putIfNotNull(jSONObject, "refreshToken", this.refreshToken);
        JsonUtil.putIfNotNull(jSONObject, KEY_CODE_VERIFIER, this.codeVerifier);
        JsonUtil.put(jSONObject, KEY_ADDITIONAL_PARAMETERS, JsonUtil.mapToJsonObject(this.additionalParameters));
        return jSONObject;
    }

    public String jsonSerializeString() {
        return jsonSerialize().toString();
    }

    public static TokenRequest jsonDeserialize(JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json object cannot be null");
        return new TokenRequest(AuthorizationServiceConfiguration.fromJson(jSONObject.getJSONObject(KEY_CONFIGURATION)), JsonUtil.getString(jSONObject, KEY_CLIENT_ID), JsonUtil.getStringIfDefined(jSONObject, "nonce"), JsonUtil.getString(jSONObject, KEY_GRANT_TYPE), JsonUtil.getUriIfDefined(jSONObject, KEY_REDIRECT_URI), JsonUtil.getStringIfDefined(jSONObject, "scope"), JsonUtil.getStringIfDefined(jSONObject, KEY_AUTHORIZATION_CODE), JsonUtil.getStringIfDefined(jSONObject, "refreshToken"), JsonUtil.getStringIfDefined(jSONObject, KEY_CODE_VERIFIER), JsonUtil.getStringMap(jSONObject, KEY_ADDITIONAL_PARAMETERS));
    }

    public static TokenRequest jsonDeserialize(@NonNull String str) throws JSONException {
        Preconditions.checkNotNull(str, "json string cannot be null");
        return jsonDeserialize(new JSONObject(str));
    }
}
