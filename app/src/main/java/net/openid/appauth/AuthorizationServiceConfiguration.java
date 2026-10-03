package net.openid.appauth;

import android.net.Uri;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import net.openid.appauth.connectivity.ConnectionBuilder;
import net.openid.appauth.connectivity.DefaultConnectionBuilder;
import net.openid.appauth.internal.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AuthorizationServiceConfiguration {
    private static final String KEY_AUTHORIZATION_ENDPOINT = "authorizationEndpoint";
    private static final String KEY_DISCOVERY_DOC = "discoveryDoc";
    private static final String KEY_END_SESSION_ENPOINT = "endSessionEndpoint";
    private static final String KEY_REGISTRATION_ENDPOINT = "registrationEndpoint";
    private static final String KEY_TOKEN_ENDPOINT = "tokenEndpoint";
    public static final String OPENID_CONFIGURATION_RESOURCE = "openid-configuration";
    public static final String WELL_KNOWN_PATH = ".well-known";
    public final Uri authorizationEndpoint;
    public final AuthorizationServiceDiscovery discoveryDoc;
    public final Uri endSessionEndpoint;
    public final Uri registrationEndpoint;
    public final Uri tokenEndpoint;

    /* JADX INFO: loaded from: classes6.dex */
    public interface RetrieveConfigurationCallback {
        void onFetchConfigurationCompleted(@Nullable AuthorizationServiceConfiguration authorizationServiceConfiguration, @Nullable AuthorizationException authorizationException);
    }

    public AuthorizationServiceConfiguration(@NonNull Uri uri, @NonNull Uri uri2) {
        this(uri, uri2, null);
    }

    public AuthorizationServiceConfiguration(@NonNull Uri uri, @NonNull Uri uri2, @Nullable Uri uri3) {
        this(uri, uri2, uri3, null);
    }

    public AuthorizationServiceConfiguration(@NonNull Uri uri, @NonNull Uri uri2, @Nullable Uri uri3, @Nullable Uri uri4) {
        this.authorizationEndpoint = (Uri) Preconditions.checkNotNull(uri);
        this.tokenEndpoint = (Uri) Preconditions.checkNotNull(uri2);
        this.registrationEndpoint = uri3;
        this.endSessionEndpoint = uri4;
        this.discoveryDoc = null;
    }

    public AuthorizationServiceConfiguration(@NonNull AuthorizationServiceDiscovery authorizationServiceDiscovery) {
        Preconditions.checkNotNull(authorizationServiceDiscovery, "docJson cannot be null");
        this.discoveryDoc = authorizationServiceDiscovery;
        this.authorizationEndpoint = authorizationServiceDiscovery.getAuthorizationEndpoint();
        this.tokenEndpoint = authorizationServiceDiscovery.getTokenEndpoint();
        this.registrationEndpoint = authorizationServiceDiscovery.getRegistrationEndpoint();
        this.endSessionEndpoint = authorizationServiceDiscovery.getEndSessionEndpoint();
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, KEY_AUTHORIZATION_ENDPOINT, this.authorizationEndpoint.toString());
        JsonUtil.put(jSONObject, KEY_TOKEN_ENDPOINT, this.tokenEndpoint.toString());
        Uri uri = this.registrationEndpoint;
        if (uri != null) {
            JsonUtil.put(jSONObject, KEY_REGISTRATION_ENDPOINT, uri.toString());
        }
        Uri uri2 = this.endSessionEndpoint;
        if (uri2 != null) {
            JsonUtil.put(jSONObject, KEY_END_SESSION_ENPOINT, uri2.toString());
        }
        AuthorizationServiceDiscovery authorizationServiceDiscovery = this.discoveryDoc;
        if (authorizationServiceDiscovery != null) {
            JsonUtil.put(jSONObject, KEY_DISCOVERY_DOC, authorizationServiceDiscovery.docJson);
        }
        return jSONObject;
    }

    public String toJsonString() {
        return toJson().toString();
    }

    public static AuthorizationServiceConfiguration fromJson(@NonNull JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json object cannot be null");
        if (jSONObject.has(KEY_DISCOVERY_DOC)) {
            try {
                return new AuthorizationServiceConfiguration(new AuthorizationServiceDiscovery(jSONObject.optJSONObject(KEY_DISCOVERY_DOC)));
            } catch (AuthorizationServiceDiscovery.MissingArgumentException e) {
                throw new JSONException("Missing required field in discovery doc: " + e.getMissingField());
            }
        }
        Preconditions.checkArgument(jSONObject.has(KEY_AUTHORIZATION_ENDPOINT), "missing authorizationEndpoint");
        Preconditions.checkArgument(jSONObject.has(KEY_TOKEN_ENDPOINT), "missing tokenEndpoint");
        return new AuthorizationServiceConfiguration(JsonUtil.getUri(jSONObject, KEY_AUTHORIZATION_ENDPOINT), JsonUtil.getUri(jSONObject, KEY_TOKEN_ENDPOINT), JsonUtil.getUriIfDefined(jSONObject, KEY_REGISTRATION_ENDPOINT), JsonUtil.getUriIfDefined(jSONObject, KEY_END_SESSION_ENPOINT));
    }

    public static AuthorizationServiceConfiguration fromJson(@NonNull String str) throws JSONException {
        Preconditions.checkNotNull(str, "json cannot be null");
        return fromJson(new JSONObject(str));
    }

    public static void fetchFromIssuer(@NonNull Uri uri, @NonNull RetrieveConfigurationCallback retrieveConfigurationCallback) {
        fetchFromUrl(buildConfigurationUriFromIssuer(uri), retrieveConfigurationCallback);
    }

    public static void fetchFromIssuer(@NonNull Uri uri, @NonNull RetrieveConfigurationCallback retrieveConfigurationCallback, @NonNull ConnectionBuilder connectionBuilder) {
        fetchFromUrl(buildConfigurationUriFromIssuer(uri), retrieveConfigurationCallback, connectionBuilder);
    }

    static Uri buildConfigurationUriFromIssuer(Uri uri) {
        return uri.buildUpon().appendPath(WELL_KNOWN_PATH).appendPath(OPENID_CONFIGURATION_RESOURCE).build();
    }

    public static void fetchFromUrl(@NonNull Uri uri, @NonNull RetrieveConfigurationCallback retrieveConfigurationCallback) {
        fetchFromUrl(uri, retrieveConfigurationCallback, DefaultConnectionBuilder.INSTANCE);
    }

    public static void fetchFromUrl(@NonNull Uri uri, @NonNull RetrieveConfigurationCallback retrieveConfigurationCallback, @NonNull ConnectionBuilder connectionBuilder) {
        Preconditions.checkNotNull(uri, "openIDConnectDiscoveryUri cannot be null");
        Preconditions.checkNotNull(retrieveConfigurationCallback, "callback cannot be null");
        Preconditions.checkNotNull(connectionBuilder, "connectionBuilder must not be null");
        new ConfigurationRetrievalAsyncTask(uri, connectionBuilder, retrieveConfigurationCallback).execute(new Void[0]);
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class ConfigurationRetrievalAsyncTask extends AsyncTask<Void, Void, AuthorizationServiceConfiguration> {
        private RetrieveConfigurationCallback mCallback;
        private ConnectionBuilder mConnectionBuilder;
        private AuthorizationException mException = null;
        private Uri mUri;

        ConfigurationRetrievalAsyncTask(Uri uri, ConnectionBuilder connectionBuilder, RetrieveConfigurationCallback retrieveConfigurationCallback) {
            this.mUri = uri;
            this.mConnectionBuilder = connectionBuilder;
            this.mCallback = retrieveConfigurationCallback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Not initialized variable reg: 1, insn: 0x0076: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x0076 */
        @Override // android.os.AsyncTask
        public AuthorizationServiceConfiguration doInBackground(Void... voidArr) throws Throwable {
            JSONException e;
            InputStream inputStream;
            AuthorizationServiceDiscovery.MissingArgumentException e2;
            IOException e3;
            InputStream inputStream2;
            InputStream inputStream3 = null;
            try {
                try {
                    HttpURLConnection httpURLConnectionOpenConnection = this.mConnectionBuilder.openConnection(this.mUri);
                    httpURLConnectionOpenConnection.setRequestMethod("GET");
                    httpURLConnectionOpenConnection.setDoInput(true);
                    httpURLConnectionOpenConnection.connect();
                    inputStream = httpURLConnectionOpenConnection.getInputStream();
                    try {
                        AuthorizationServiceConfiguration authorizationServiceConfiguration = new AuthorizationServiceConfiguration(new AuthorizationServiceDiscovery(new JSONObject(Utils.readInputStream(inputStream))));
                        Utils.closeQuietly(inputStream);
                        return authorizationServiceConfiguration;
                    } catch (IOException e4) {
                        e3 = e4;
                        Logger.errorWithStack(e3, "Network error when retrieving discovery document", new Object[0]);
                        this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.NETWORK_ERROR, e3);
                        Utils.closeQuietly(inputStream);
                        return null;
                    } catch (AuthorizationServiceDiscovery.MissingArgumentException e5) {
                        e2 = e5;
                        Logger.errorWithStack(e2, "Malformed discovery document", new Object[0]);
                        this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.INVALID_DISCOVERY_DOCUMENT, e2);
                        Utils.closeQuietly(inputStream);
                        return null;
                    } catch (JSONException e6) {
                        e = e6;
                        Logger.errorWithStack(e, "Error parsing discovery document", new Object[0]);
                        this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e);
                        Utils.closeQuietly(inputStream);
                        return null;
                    }
                } catch (IOException e7) {
                    e3 = e7;
                    inputStream = null;
                } catch (AuthorizationServiceDiscovery.MissingArgumentException e8) {
                    e2 = e8;
                    inputStream = null;
                } catch (JSONException e9) {
                    e = e9;
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    Utils.closeQuietly(inputStream3);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream3 = inputStream2;
                Utils.closeQuietly(inputStream3);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(AuthorizationServiceConfiguration authorizationServiceConfiguration) {
            AuthorizationException authorizationException = this.mException;
            if (authorizationException != null) {
                this.mCallback.onFetchConfigurationCompleted(null, authorizationException);
            } else {
                this.mCallback.onFetchConfigurationCompleted(authorizationServiceConfiguration, null);
            }
        }
    }
}
