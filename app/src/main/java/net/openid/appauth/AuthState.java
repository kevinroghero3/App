package net.openid.appauth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.openid.appauth.internal.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class AuthState {
    public static final int EXPIRY_TIME_TOLERANCE_MS = 60000;
    private static final String KEY_AUTHORIZATION_EXCEPTION = "mAuthorizationException";
    private static final String KEY_CONFIG = "config";
    private static final String KEY_LAST_AUTHORIZATION_RESPONSE = "lastAuthorizationResponse";
    private static final String KEY_LAST_REGISTRATION_RESPONSE = "lastRegistrationResponse";
    private static final String KEY_LAST_TOKEN_RESPONSE = "mLastTokenResponse";
    private static final String KEY_REFRESH_TOKEN = "refreshToken";
    private static final String KEY_SCOPE = "scope";
    private AuthorizationException mAuthorizationException;
    private AuthorizationServiceConfiguration mConfig;
    private AuthorizationResponse mLastAuthorizationResponse;
    private RegistrationResponse mLastRegistrationResponse;
    private TokenResponse mLastTokenResponse;
    private boolean mNeedsTokenRefreshOverride;
    private List<AuthStateAction> mPendingActions;
    private final Object mPendingActionsSyncObject;
    private String mRefreshToken;
    private String mScope;

    public interface AuthStateAction {
        void execute(@Nullable String str, @Nullable String str2, @Nullable AuthorizationException authorizationException);
    }

    public AuthState() {
        this.mPendingActionsSyncObject = new Object();
    }

    public AuthState(@NonNull AuthorizationServiceConfiguration authorizationServiceConfiguration) {
        this.mPendingActionsSyncObject = new Object();
        this.mConfig = authorizationServiceConfiguration;
    }

    public AuthState(@Nullable AuthorizationResponse authorizationResponse, @Nullable AuthorizationException authorizationException) {
        this.mPendingActionsSyncObject = new Object();
        Preconditions.checkArgument((authorizationException != null) ^ (authorizationResponse != null), "exactly one of authResponse or authError should be non-null");
        this.mPendingActions = null;
        update(authorizationResponse, authorizationException);
    }

    public AuthState(@NonNull RegistrationResponse registrationResponse) {
        this.mPendingActionsSyncObject = new Object();
        update(registrationResponse);
    }

    public AuthState(@NonNull AuthorizationResponse authorizationResponse, @Nullable TokenResponse tokenResponse, @Nullable AuthorizationException authorizationException) {
        this(authorizationResponse, null);
        update(tokenResponse, authorizationException);
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getScope() {
        return this.mScope;
    }

    public Set<String> getScopeSet() {
        return AsciiStringListUtil.stringToSet(this.mScope);
    }

    public AuthorizationResponse getLastAuthorizationResponse() {
        return this.mLastAuthorizationResponse;
    }

    public TokenResponse getLastTokenResponse() {
        return this.mLastTokenResponse;
    }

    public RegistrationResponse getLastRegistrationResponse() {
        return this.mLastRegistrationResponse;
    }

    public AuthorizationServiceConfiguration getAuthorizationServiceConfiguration() {
        AuthorizationResponse authorizationResponse = this.mLastAuthorizationResponse;
        if (authorizationResponse != null) {
            return authorizationResponse.request.configuration;
        }
        return this.mConfig;
    }

    public String getAccessToken() {
        String str;
        if (this.mAuthorizationException != null) {
            return null;
        }
        TokenResponse tokenResponse = this.mLastTokenResponse;
        if (tokenResponse != null && (str = tokenResponse.accessToken) != null) {
            return str;
        }
        AuthorizationResponse authorizationResponse = this.mLastAuthorizationResponse;
        if (authorizationResponse != null) {
            return authorizationResponse.accessToken;
        }
        return null;
    }

    public Long getAccessTokenExpirationTime() {
        if (this.mAuthorizationException != null) {
            return null;
        }
        TokenResponse tokenResponse = this.mLastTokenResponse;
        if (tokenResponse != null && tokenResponse.accessToken != null) {
            return tokenResponse.accessTokenExpirationTime;
        }
        AuthorizationResponse authorizationResponse = this.mLastAuthorizationResponse;
        if (authorizationResponse == null || authorizationResponse.accessToken == null) {
            return null;
        }
        return authorizationResponse.accessTokenExpirationTime;
    }

    public String getIdToken() {
        String str;
        if (this.mAuthorizationException != null) {
            return null;
        }
        TokenResponse tokenResponse = this.mLastTokenResponse;
        if (tokenResponse != null && (str = tokenResponse.idToken) != null) {
            return str;
        }
        AuthorizationResponse authorizationResponse = this.mLastAuthorizationResponse;
        if (authorizationResponse != null) {
            return authorizationResponse.idToken;
        }
        return null;
    }

    public IdToken getParsedIdToken() {
        String idToken = getIdToken();
        if (idToken != null) {
            try {
                return IdToken.from(idToken);
            } catch (IdToken.IdTokenException | JSONException unused) {
            }
        }
        return null;
    }

    public String getClientSecret() {
        RegistrationResponse registrationResponse = this.mLastRegistrationResponse;
        if (registrationResponse != null) {
            return registrationResponse.clientSecret;
        }
        return null;
    }

    public Long getClientSecretExpirationTime() {
        RegistrationResponse registrationResponse = this.mLastRegistrationResponse;
        if (registrationResponse != null) {
            return registrationResponse.clientSecretExpiresAt;
        }
        return null;
    }

    public boolean isAuthorized() {
        return this.mAuthorizationException == null && !(getAccessToken() == null && getIdToken() == null);
    }

    public AuthorizationException getAuthorizationException() {
        return this.mAuthorizationException;
    }

    public boolean getNeedsTokenRefresh() {
        return getNeedsTokenRefresh(SystemClock.INSTANCE);
    }

    boolean getNeedsTokenRefresh(Clock clock) {
        if (this.mNeedsTokenRefreshOverride) {
            return true;
        }
        if (getAccessTokenExpirationTime() == null) {
            return getAccessToken() == null;
        }
        return getAccessTokenExpirationTime().longValue() <= clock.getCurrentTimeMillis() + 60000;
    }

    public void setNeedsTokenRefresh(boolean z) {
        this.mNeedsTokenRefreshOverride = z;
    }

    public boolean hasClientSecretExpired() {
        return hasClientSecretExpired(SystemClock.INSTANCE);
    }

    boolean hasClientSecretExpired(Clock clock) {
        return (getClientSecretExpirationTime() == null || getClientSecretExpirationTime().longValue() == 0 || getClientSecretExpirationTime().longValue() > clock.getCurrentTimeMillis()) ? false : true;
    }

    public void update(@Nullable AuthorizationResponse authorizationResponse, @Nullable AuthorizationException authorizationException) {
        Preconditions.checkArgument((authorizationException != null) ^ (authorizationResponse != null), "exactly one of authResponse or authException should be non-null");
        if (authorizationException != null) {
            if (authorizationException.type == 1) {
                this.mAuthorizationException = authorizationException;
                return;
            }
            return;
        }
        this.mLastAuthorizationResponse = authorizationResponse;
        this.mConfig = null;
        this.mLastTokenResponse = null;
        this.mRefreshToken = null;
        this.mAuthorizationException = null;
        String str = authorizationResponse.scope;
        if (str == null) {
            str = authorizationResponse.request.scope;
        }
        this.mScope = str;
    }

    public void update(@Nullable TokenResponse tokenResponse, @Nullable AuthorizationException authorizationException) {
        Preconditions.checkArgument((authorizationException != null) ^ (tokenResponse != null), "exactly one of tokenResponse or authException should be non-null");
        AuthorizationException authorizationException2 = this.mAuthorizationException;
        if (authorizationException2 != null) {
            Logger.warn("AuthState.update should not be called in an error state (%s), call updatewith the result of the fresh authorization response first", authorizationException2);
            this.mAuthorizationException = null;
        }
        if (authorizationException != null) {
            if (authorizationException.type == 2) {
                this.mAuthorizationException = authorizationException;
                return;
            }
            return;
        }
        this.mLastTokenResponse = tokenResponse;
        String str = tokenResponse.scope;
        if (str != null) {
            this.mScope = str;
        }
        String str2 = tokenResponse.refreshToken;
        if (str2 != null) {
            this.mRefreshToken = str2;
        }
    }

    public void update(@Nullable RegistrationResponse registrationResponse) {
        this.mLastRegistrationResponse = registrationResponse;
        this.mConfig = getAuthorizationServiceConfiguration();
        this.mRefreshToken = null;
        this.mScope = null;
        this.mLastAuthorizationResponse = null;
        this.mLastTokenResponse = null;
        this.mAuthorizationException = null;
    }

    public void performActionWithFreshTokens(@NonNull AuthorizationService authorizationService, @NonNull AuthStateAction authStateAction) {
        performActionWithFreshTokens(authorizationService, NoClientAuthentication.INSTANCE, Collections.emptyMap(), SystemClock.INSTANCE, authStateAction);
    }

    public void performActionWithFreshTokens(@NonNull AuthorizationService authorizationService, @NonNull ClientAuthentication clientAuthentication, @NonNull AuthStateAction authStateAction) {
        performActionWithFreshTokens(authorizationService, clientAuthentication, Collections.emptyMap(), SystemClock.INSTANCE, authStateAction);
    }

    public void performActionWithFreshTokens(@NonNull AuthorizationService authorizationService, @NonNull Map<String, String> map, @NonNull AuthStateAction authStateAction) {
        try {
            performActionWithFreshTokens(authorizationService, getClientAuthentication(), map, SystemClock.INSTANCE, authStateAction);
        } catch (ClientAuthentication.UnsupportedAuthenticationMethod e) {
            authStateAction.execute(null, null, AuthorizationException.fromTemplate(AuthorizationException.TokenRequestErrors.CLIENT_ERROR, e));
        }
    }

    public void performActionWithFreshTokens(@NonNull AuthorizationService authorizationService, @NonNull ClientAuthentication clientAuthentication, @NonNull Map<String, String> map, @NonNull AuthStateAction authStateAction) {
        performActionWithFreshTokens(authorizationService, clientAuthentication, map, SystemClock.INSTANCE, authStateAction);
    }

    void performActionWithFreshTokens(@NonNull AuthorizationService authorizationService, @NonNull ClientAuthentication clientAuthentication, @NonNull Map<String, String> map, @NonNull Clock clock, @NonNull AuthStateAction authStateAction) {
        Preconditions.checkNotNull(authorizationService, "service cannot be null");
        Preconditions.checkNotNull(clientAuthentication, "client authentication cannot be null");
        Preconditions.checkNotNull(map, "additional params cannot be null");
        Preconditions.checkNotNull(clock, "clock cannot be null");
        Preconditions.checkNotNull(authStateAction, "action cannot be null");
        if (!getNeedsTokenRefresh(clock)) {
            authStateAction.execute(getAccessToken(), getIdToken(), null);
            return;
        }
        if (this.mRefreshToken == null) {
            authStateAction.execute(null, null, AuthorizationException.fromTemplate(AuthorizationException.AuthorizationRequestErrors.CLIENT_ERROR, new IllegalStateException("No refresh token available and token have expired")));
            return;
        }
        Preconditions.checkNotNull(this.mPendingActionsSyncObject, "pending actions sync object cannot be null");
        synchronized (this.mPendingActionsSyncObject) {
            List<AuthStateAction> list = this.mPendingActions;
            if (list != null) {
                list.add(authStateAction);
                return;
            }
            ArrayList arrayList = new ArrayList();
            this.mPendingActions = arrayList;
            arrayList.add(authStateAction);
            authorizationService.performTokenRequest(createTokenRefreshRequest(map), clientAuthentication, new AuthorizationService.TokenResponseCallback() { // from class: net.openid.appauth.AuthState.1
                @Override // net.openid.appauth.AuthorizationService.TokenResponseCallback
                public void onTokenRequestCompleted(@Nullable TokenResponse tokenResponse, @Nullable AuthorizationException authorizationException) {
                    String str;
                    String idToken;
                    List list2;
                    AuthState.this.update(tokenResponse, authorizationException);
                    if (authorizationException == null) {
                        AuthState.this.mNeedsTokenRefreshOverride = false;
                        String accessToken = AuthState.this.getAccessToken();
                        idToken = AuthState.this.getIdToken();
                        str = accessToken;
                        authorizationException = null;
                    } else {
                        str = null;
                        idToken = null;
                    }
                    synchronized (AuthState.this.mPendingActionsSyncObject) {
                        list2 = AuthState.this.mPendingActions;
                        AuthState.this.mPendingActions = null;
                    }
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        ((AuthStateAction) it2.next()).execute(str, idToken, authorizationException);
                    }
                }
            });
        }
    }

    public TokenRequest createTokenRefreshRequest() {
        return createTokenRefreshRequest(Collections.emptyMap());
    }

    public TokenRequest createTokenRefreshRequest(@NonNull Map<String, String> map) {
        if (this.mRefreshToken == null) {
            throw new IllegalStateException("No refresh token available for refresh request");
        }
        AuthorizationResponse authorizationResponse = this.mLastAuthorizationResponse;
        if (authorizationResponse == null) {
            throw new IllegalStateException("No authorization configuration available for refresh request");
        }
        AuthorizationRequest authorizationRequest = authorizationResponse.request;
        return new TokenRequest.Builder(authorizationRequest.configuration, authorizationRequest.clientId).setGrantType(GrantTypeValues.REFRESH_TOKEN).setScope(null).setRefreshToken(this.mRefreshToken).setAdditionalParameters(map).build();
    }

    public JSONObject jsonSerialize() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.putIfNotNull(jSONObject, "refreshToken", this.mRefreshToken);
        JsonUtil.putIfNotNull(jSONObject, "scope", this.mScope);
        AuthorizationServiceConfiguration authorizationServiceConfiguration = this.mConfig;
        if (authorizationServiceConfiguration != null) {
            JsonUtil.put(jSONObject, KEY_CONFIG, authorizationServiceConfiguration.toJson());
        }
        AuthorizationException authorizationException = this.mAuthorizationException;
        if (authorizationException != null) {
            JsonUtil.put(jSONObject, KEY_AUTHORIZATION_EXCEPTION, authorizationException.toJson());
        }
        AuthorizationResponse authorizationResponse = this.mLastAuthorizationResponse;
        if (authorizationResponse != null) {
            JsonUtil.put(jSONObject, KEY_LAST_AUTHORIZATION_RESPONSE, authorizationResponse.jsonSerialize());
        }
        TokenResponse tokenResponse = this.mLastTokenResponse;
        if (tokenResponse != null) {
            JsonUtil.put(jSONObject, KEY_LAST_TOKEN_RESPONSE, tokenResponse.jsonSerialize());
        }
        RegistrationResponse registrationResponse = this.mLastRegistrationResponse;
        if (registrationResponse != null) {
            JsonUtil.put(jSONObject, KEY_LAST_REGISTRATION_RESPONSE, registrationResponse.jsonSerialize());
        }
        return jSONObject;
    }

    public String jsonSerializeString() {
        return jsonSerialize().toString();
    }

    public static AuthState jsonDeserialize(@NonNull JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json cannot be null");
        AuthState authState = new AuthState();
        authState.mRefreshToken = JsonUtil.getStringIfDefined(jSONObject, "refreshToken");
        authState.mScope = JsonUtil.getStringIfDefined(jSONObject, "scope");
        if (jSONObject.has(KEY_CONFIG)) {
            authState.mConfig = AuthorizationServiceConfiguration.fromJson(jSONObject.getJSONObject(KEY_CONFIG));
        }
        if (jSONObject.has(KEY_AUTHORIZATION_EXCEPTION)) {
            authState.mAuthorizationException = AuthorizationException.fromJson(jSONObject.getJSONObject(KEY_AUTHORIZATION_EXCEPTION));
        }
        if (jSONObject.has(KEY_LAST_AUTHORIZATION_RESPONSE)) {
            authState.mLastAuthorizationResponse = AuthorizationResponse.jsonDeserialize(jSONObject.getJSONObject(KEY_LAST_AUTHORIZATION_RESPONSE));
        }
        if (jSONObject.has(KEY_LAST_TOKEN_RESPONSE)) {
            authState.mLastTokenResponse = TokenResponse.jsonDeserialize(jSONObject.getJSONObject(KEY_LAST_TOKEN_RESPONSE));
        }
        if (jSONObject.has(KEY_LAST_REGISTRATION_RESPONSE)) {
            authState.mLastRegistrationResponse = RegistrationResponse.jsonDeserialize(jSONObject.getJSONObject(KEY_LAST_REGISTRATION_RESPONSE));
        }
        return authState;
    }

    public static AuthState jsonDeserialize(@NonNull String str) throws JSONException {
        Preconditions.checkNotEmpty(str, "jsonStr cannot be null or empty");
        return jsonDeserialize(new JSONObject(str));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    public ClientAuthentication getClientAuthentication() throws ClientAuthentication.UnsupportedAuthenticationMethod {
        byte b;
        if (getClientSecret() == null) {
            return NoClientAuthentication.INSTANCE;
        }
        String str = this.mLastRegistrationResponse.tokenEndpointAuthMethod;
        if (str == null) {
            return new ClientSecretBasic(getClientSecret());
        }
        str.hashCode();
        int iHashCode = str.hashCode();
        if (iHashCode != -2034587045) {
            if (iHashCode != 3387192) {
                if (iHashCode == 1338964435 && str.equals(ClientSecretBasic.NAME)) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("none")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals(ClientSecretPost.NAME)) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            return new ClientSecretPost(getClientSecret());
        }
        if (b == 1) {
            return NoClientAuthentication.INSTANCE;
        }
        if (b == 2) {
            return new ClientSecretBasic(getClientSecret());
        }
        throw new ClientAuthentication.UnsupportedAuthenticationMethod(this.mLastRegistrationResponse.tokenEndpointAuthMethod);
    }
}
