package net.openid.appauth;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.Map;
import net.openid.appauth.browser.BrowserDescriptor;
import net.openid.appauth.browser.BrowserSelector;
import net.openid.appauth.browser.CustomTabManager;
import net.openid.appauth.connectivity.ConnectionBuilder;
import net.openid.appauth.internal.Logger;
import net.openid.appauth.internal.UriUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AuthorizationService {
    private final BrowserDescriptor mBrowser;
    private final AppAuthConfiguration mClientConfiguration;
    Context mContext;
    private final CustomTabManager mCustomTabManager;
    private boolean mDisposed;

    /* JADX INFO: loaded from: classes6.dex */
    public interface RegistrationResponseCallback {
        void onRegistrationRequestCompleted(@Nullable RegistrationResponse registrationResponse, @Nullable AuthorizationException authorizationException);
    }

    public interface TokenResponseCallback {
        void onTokenRequestCompleted(@Nullable TokenResponse tokenResponse, @Nullable AuthorizationException authorizationException);
    }

    public AuthorizationService(@NonNull Context context) {
        this(context, AppAuthConfiguration.DEFAULT);
    }

    public AuthorizationService(@NonNull Context context, @NonNull AppAuthConfiguration appAuthConfiguration) {
        this(context, appAuthConfiguration, BrowserSelector.select(context, appAuthConfiguration.getBrowserMatcher()), new CustomTabManager(context));
    }

    AuthorizationService(@NonNull Context context, @NonNull AppAuthConfiguration appAuthConfiguration, @Nullable BrowserDescriptor browserDescriptor, @NonNull CustomTabManager customTabManager) {
        this.mDisposed = false;
        this.mContext = (Context) Preconditions.checkNotNull(context);
        this.mClientConfiguration = appAuthConfiguration;
        this.mCustomTabManager = customTabManager;
        this.mBrowser = browserDescriptor;
        if (browserDescriptor == null || !browserDescriptor.useCustomTab.booleanValue()) {
            return;
        }
        customTabManager.bind(browserDescriptor.packageName);
    }

    public CustomTabManager getCustomTabManager() {
        return this.mCustomTabManager;
    }

    public BrowserDescriptor getBrowserDescriptor() {
        return this.mBrowser;
    }

    public CustomTabsIntent.Builder createCustomTabsIntentBuilder(Uri... uriArr) {
        checkNotDisposed();
        return this.mCustomTabManager.createTabBuilder(uriArr);
    }

    public void performAuthorizationRequest(@NonNull AuthorizationRequest authorizationRequest, @NonNull PendingIntent pendingIntent) {
        performAuthorizationRequest(authorizationRequest, pendingIntent, null, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public void performAuthorizationRequest(@NonNull AuthorizationRequest authorizationRequest, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
        performAuthorizationRequest(authorizationRequest, pendingIntent, pendingIntent2, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public void performAuthorizationRequest(@NonNull AuthorizationRequest authorizationRequest, @NonNull PendingIntent pendingIntent, @NonNull CustomTabsIntent customTabsIntent) {
        performAuthorizationRequest(authorizationRequest, pendingIntent, null, customTabsIntent);
    }

    public void performAuthorizationRequest(@NonNull AuthorizationRequest authorizationRequest, @NonNull PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @NonNull CustomTabsIntent customTabsIntent) {
        performAuthManagementRequest(authorizationRequest, pendingIntent, pendingIntent2, customTabsIntent);
    }

    public void performEndSessionRequest(@NonNull EndSessionRequest endSessionRequest, @NonNull PendingIntent pendingIntent) {
        performEndSessionRequest(endSessionRequest, pendingIntent, null, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public void performEndSessionRequest(@NonNull EndSessionRequest endSessionRequest, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
        performEndSessionRequest(endSessionRequest, pendingIntent, pendingIntent2, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public void performEndSessionRequest(@NonNull EndSessionRequest endSessionRequest, @NonNull PendingIntent pendingIntent, @NonNull CustomTabsIntent customTabsIntent) {
        performEndSessionRequest(endSessionRequest, pendingIntent, null, customTabsIntent);
    }

    public void performEndSessionRequest(@NonNull EndSessionRequest endSessionRequest, @NonNull PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @NonNull CustomTabsIntent customTabsIntent) {
        performAuthManagementRequest(endSessionRequest, pendingIntent, pendingIntent2, customTabsIntent);
    }

    private void performAuthManagementRequest(@NonNull AuthorizationManagementRequest authorizationManagementRequest, @NonNull PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @NonNull CustomTabsIntent customTabsIntent) {
        checkNotDisposed();
        Preconditions.checkNotNull(authorizationManagementRequest);
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(customTabsIntent);
        Intent intentCreateStartIntent = AuthorizationManagementActivity.createStartIntent(this.mContext, authorizationManagementRequest, prepareAuthorizationRequestIntent(authorizationManagementRequest, customTabsIntent), pendingIntent, pendingIntent2);
        if (!isActivity(this.mContext)) {
            intentCreateStartIntent.addFlags(268435456);
        }
        this.mContext.startActivity(intentCreateStartIntent);
    }

    private boolean isActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return true;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return false;
    }

    public Intent getAuthorizationRequestIntent(@NonNull AuthorizationRequest authorizationRequest, @NonNull CustomTabsIntent customTabsIntent) {
        return AuthorizationManagementActivity.createStartForResultIntent(this.mContext, authorizationRequest, prepareAuthorizationRequestIntent(authorizationRequest, customTabsIntent));
    }

    public Intent getAuthorizationRequestIntent(@NonNull AuthorizationRequest authorizationRequest) {
        return getAuthorizationRequestIntent(authorizationRequest, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public Intent getEndSessionRequestIntent(@NonNull EndSessionRequest endSessionRequest, @NonNull CustomTabsIntent customTabsIntent) {
        return AuthorizationManagementActivity.createStartForResultIntent(this.mContext, endSessionRequest, prepareAuthorizationRequestIntent(endSessionRequest, customTabsIntent));
    }

    public Intent getEndSessionRequestIntent(@NonNull EndSessionRequest endSessionRequest) {
        return getEndSessionRequestIntent(endSessionRequest, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public void performTokenRequest(@NonNull TokenRequest tokenRequest, @NonNull TokenResponseCallback tokenResponseCallback) {
        performTokenRequest(tokenRequest, NoClientAuthentication.INSTANCE, tokenResponseCallback);
    }

    public void performTokenRequest(@NonNull TokenRequest tokenRequest, @NonNull ClientAuthentication clientAuthentication, @NonNull TokenResponseCallback tokenResponseCallback) {
        checkNotDisposed();
        Logger.debug("Initiating code exchange request to %s", tokenRequest.configuration.tokenEndpoint);
        new TokenRequestTask(tokenRequest, clientAuthentication, this.mClientConfiguration.getConnectionBuilder(), SystemClock.INSTANCE, tokenResponseCallback, Boolean.valueOf(this.mClientConfiguration.getSkipIssuerHttpsCheck())).execute(new Void[0]);
    }

    public void performRegistrationRequest(@NonNull RegistrationRequest registrationRequest, @NonNull RegistrationResponseCallback registrationResponseCallback) {
        checkNotDisposed();
        Logger.debug("Initiating dynamic client registration %s", registrationRequest.configuration.registrationEndpoint.toString());
        new RegistrationRequestTask(registrationRequest, this.mClientConfiguration.getConnectionBuilder(), registrationResponseCallback).execute(new Void[0]);
    }

    public void dispose() {
        if (this.mDisposed) {
            return;
        }
        this.mCustomTabManager.dispose();
        this.mDisposed = true;
    }

    private void checkNotDisposed() {
        if (this.mDisposed) {
            throw new IllegalStateException("Service has been disposed and rendered inoperable");
        }
    }

    private Intent prepareAuthorizationRequestIntent(AuthorizationManagementRequest authorizationManagementRequest, CustomTabsIntent customTabsIntent) {
        Intent intent;
        checkNotDisposed();
        if (this.mBrowser == null) {
            throw new ActivityNotFoundException();
        }
        Uri uri = authorizationManagementRequest.toUri();
        if (this.mBrowser.useCustomTab.booleanValue()) {
            intent = customTabsIntent.intent;
        } else {
            intent = new Intent("android.intent.action.VIEW");
        }
        intent.setPackage(this.mBrowser.packageName);
        intent.setData(uri);
        Logger.debug("Using %s as browser for auth, custom tab = %s", intent.getPackage(), this.mBrowser.useCustomTab.toString());
        return intent;
    }

    static class TokenRequestTask extends AsyncTask<Void, Void, JSONObject> {
        private TokenResponseCallback mCallback;
        private ClientAuthentication mClientAuthentication;
        private Clock mClock;
        private final ConnectionBuilder mConnectionBuilder;
        private AuthorizationException mException;
        private TokenRequest mRequest;
        private boolean mSkipIssuerHttpsCheck;

        TokenRequestTask(TokenRequest tokenRequest, @NonNull ClientAuthentication clientAuthentication, @NonNull ConnectionBuilder connectionBuilder, Clock clock, TokenResponseCallback tokenResponseCallback, Boolean bool) {
            this.mRequest = tokenRequest;
            this.mClientAuthentication = clientAuthentication;
            this.mConnectionBuilder = connectionBuilder;
            this.mClock = clock;
            this.mCallback = tokenResponseCallback;
            this.mSkipIssuerHttpsCheck = bool.booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Not initialized variable reg: 2, insn: 0x00ae: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:21:0x00ae */
        @Override // android.os.AsyncTask
        public JSONObject doInBackground(Void... voidArr) throws Throwable {
            JSONException e;
            InputStream errorStream;
            IOException e2;
            InputStream inputStream;
            InputStream inputStream2 = null;
            try {
                try {
                    HttpURLConnection httpURLConnectionOpenConnection = this.mConnectionBuilder.openConnection(this.mRequest.configuration.tokenEndpoint);
                    httpURLConnectionOpenConnection.setRequestMethod("POST");
                    httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
                    addJsonToAcceptHeader(httpURLConnectionOpenConnection);
                    httpURLConnectionOpenConnection.setDoOutput(true);
                    Map<String, String> requestHeaders = this.mClientAuthentication.getRequestHeaders(this.mRequest.clientId);
                    if (requestHeaders != null) {
                        for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
                            httpURLConnectionOpenConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    Map<String, String> requestParameters = this.mRequest.getRequestParameters();
                    Map<String, String> requestParameters2 = this.mClientAuthentication.getRequestParameters(this.mRequest.clientId);
                    if (requestParameters2 != null) {
                        requestParameters.putAll(requestParameters2);
                    }
                    String strFormUrlEncode = UriUtil.formUrlEncode(requestParameters);
                    httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(strFormUrlEncode.length()));
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnectionOpenConnection.getOutputStream());
                    outputStreamWriter.write(strFormUrlEncode);
                    outputStreamWriter.flush();
                    if (httpURLConnectionOpenConnection.getResponseCode() >= 200 && httpURLConnectionOpenConnection.getResponseCode() < 300) {
                        errorStream = httpURLConnectionOpenConnection.getInputStream();
                    } else {
                        errorStream = httpURLConnectionOpenConnection.getErrorStream();
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(Utils.readInputStream(errorStream));
                        Utils.closeQuietly(errorStream);
                        return jSONObject;
                    } catch (IOException e3) {
                        e2 = e3;
                        Logger.debugWithStack(e2, "Failed to complete exchange request", new Object[0]);
                        this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.NETWORK_ERROR, e2);
                        Utils.closeQuietly(errorStream);
                        return null;
                    } catch (JSONException e4) {
                        e = e4;
                        Logger.debugWithStack(e, "Failed to complete exchange request", new Object[0]);
                        this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e);
                        Utils.closeQuietly(errorStream);
                        return null;
                    }
                } catch (IOException e5) {
                    e2 = e5;
                    errorStream = null;
                } catch (JSONException e6) {
                    e = e6;
                    errorStream = null;
                } catch (Throwable th) {
                    th = th;
                    Utils.closeQuietly(inputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                Utils.closeQuietly(inputStream2);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(JSONObject jSONObject) {
            AuthorizationException authorizationExceptionFromTemplate;
            AuthorizationException authorizationException = this.mException;
            if (authorizationException != null) {
                this.mCallback.onTokenRequestCompleted(null, authorizationException);
                return;
            }
            if (jSONObject.has("error")) {
                try {
                    String string = jSONObject.getString("error");
                    authorizationExceptionFromTemplate = AuthorizationException.fromOAuthTemplate(AuthorizationException.TokenRequestErrors.byString(string), string, jSONObject.optString("error_description", null), UriUtil.parseUriIfAvailable(jSONObject.optString(AuthorizationException.PARAM_ERROR_URI)));
                } catch (JSONException e) {
                    authorizationExceptionFromTemplate = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e);
                }
                this.mCallback.onTokenRequestCompleted(null, authorizationExceptionFromTemplate);
                return;
            }
            try {
                TokenResponse tokenResponseBuild = new TokenResponse.Builder(this.mRequest).fromResponseJson(jSONObject).build();
                String str = tokenResponseBuild.idToken;
                if (str != null) {
                    try {
                        try {
                            IdToken.from(str).validate(this.mRequest, this.mClock, this.mSkipIssuerHttpsCheck);
                        } catch (AuthorizationException e2) {
                            this.mCallback.onTokenRequestCompleted(null, e2);
                            return;
                        }
                    } catch (IdToken.IdTokenException | JSONException e3) {
                        this.mCallback.onTokenRequestCompleted(null, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.ID_TOKEN_PARSING_ERROR, e3));
                        return;
                    }
                }
                Logger.debug("Token exchange with %s completed", this.mRequest.configuration.tokenEndpoint);
                this.mCallback.onTokenRequestCompleted(tokenResponseBuild, null);
            } catch (JSONException e4) {
                this.mCallback.onTokenRequestCompleted(null, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e4));
            }
        }

        private void addJsonToAcceptHeader(URLConnection uRLConnection) {
            if (TextUtils.isEmpty(uRLConnection.getRequestProperty(HttpHeaders.ACCEPT))) {
                uRLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
            }
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class RegistrationRequestTask extends AsyncTask<Void, Void, JSONObject> {
        private RegistrationResponseCallback mCallback;
        private final ConnectionBuilder mConnectionBuilder;
        private AuthorizationException mException;
        private RegistrationRequest mRequest;

        RegistrationRequestTask(RegistrationRequest registrationRequest, ConnectionBuilder connectionBuilder, RegistrationResponseCallback registrationResponseCallback) {
            this.mRequest = registrationRequest;
            this.mConnectionBuilder = connectionBuilder;
            this.mCallback = registrationResponseCallback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v2 */
        @Override // android.os.AsyncTask
        public JSONObject doInBackground(Void... voidArr) throws Throwable {
            JSONException e;
            InputStream inputStream;
            IOException e2;
            String jsonString = this.mRequest.toJsonString();
            ?? r2 = 0;
            try {
                try {
                    HttpURLConnection httpURLConnectionOpenConnection = this.mConnectionBuilder.openConnection(this.mRequest.configuration.registrationEndpoint);
                    httpURLConnectionOpenConnection.setRequestMethod("POST");
                    httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
                    httpURLConnectionOpenConnection.setDoOutput(true);
                    httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(jsonString.length()));
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnectionOpenConnection.getOutputStream());
                    outputStreamWriter.write(jsonString);
                    outputStreamWriter.flush();
                    inputStream = httpURLConnectionOpenConnection.getInputStream();
                    try {
                        JSONObject jSONObject = new JSONObject(Utils.readInputStream(inputStream));
                        Utils.closeQuietly(inputStream);
                        return jSONObject;
                    } catch (IOException e3) {
                        e2 = e3;
                        Logger.debugWithStack(e2, "Failed to complete registration request", new Object[0]);
                        this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.NETWORK_ERROR, e2);
                        Utils.closeQuietly(inputStream);
                        return null;
                    } catch (JSONException e4) {
                        e = e4;
                        Logger.debugWithStack(e, "Failed to complete registration request", new Object[0]);
                        this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e);
                        Utils.closeQuietly(inputStream);
                        return null;
                    }
                } catch (IOException e5) {
                    e2 = e5;
                    inputStream = null;
                } catch (JSONException e6) {
                    e = e6;
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    Utils.closeQuietly(r2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r2 = jsonString;
                Utils.closeQuietly(r2);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(JSONObject jSONObject) {
            AuthorizationException authorizationExceptionFromTemplate;
            AuthorizationException authorizationException = this.mException;
            if (authorizationException != null) {
                this.mCallback.onRegistrationRequestCompleted(null, authorizationException);
                return;
            }
            if (jSONObject.has("error")) {
                try {
                    String string = jSONObject.getString("error");
                    authorizationExceptionFromTemplate = AuthorizationException.fromOAuthTemplate(AuthorizationException.RegistrationRequestErrors.byString(string), string, jSONObject.getString("error_description"), UriUtil.parseUriIfAvailable(jSONObject.getString(AuthorizationException.PARAM_ERROR_URI)));
                } catch (JSONException e) {
                    authorizationExceptionFromTemplate = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e);
                }
                this.mCallback.onRegistrationRequestCompleted(null, authorizationExceptionFromTemplate);
                return;
            }
            try {
                RegistrationResponse registrationResponseBuild = new RegistrationResponse.Builder(this.mRequest).fromResponseJson(jSONObject).build();
                Logger.debug("Dynamic registration with %s completed", this.mRequest.configuration.registrationEndpoint);
                this.mCallback.onRegistrationRequestCompleted(registrationResponseBuild, null);
            } catch (RegistrationResponse.MissingArgumentException e2) {
                Logger.errorWithStack(e2, "Malformed registration response", new Object[0]);
                this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.INVALID_REGISTRATION_RESPONSE, e2);
            } catch (JSONException e3) {
                this.mCallback.onRegistrationRequestCompleted(null, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e3));
            }
        }
    }
}
