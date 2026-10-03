package com.rnappauth.utils;

import android.net.Uri;
import androidx.annotation.NonNull;
import ch.qos.logback.core.net.ssl.SSL;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import net.openid.appauth.Preconditions;
import net.openid.appauth.connectivity.ConnectionBuilder;

/* JADX INFO: loaded from: classes3.dex */
public final class UnsafeConnectionBuilder implements ConnectionBuilder {
    private static final TrustManager[] ANY_CERT_MANAGER;
    private static final HostnameVerifier ANY_HOSTNAME_VERIFIER;
    private static final int CONNECTION_TIMEOUT_MS;
    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    public static final UnsafeConnectionBuilder INSTANCE = new UnsafeConnectionBuilder();
    private static final int READ_TIMEOUT_MS;
    private static final String TAG = "ConnBuilder";
    private static final SSLContext TRUSTING_CONTEXT;

    static {
        SSLContext sSLContext;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        CONNECTION_TIMEOUT_MS = (int) timeUnit.toMillis(15L);
        READ_TIMEOUT_MS = (int) timeUnit.toMillis(10L);
        ANY_CERT_MANAGER = new TrustManager[]{new X509TrustManager() { // from class: com.rnappauth.utils.UnsafeConnectionBuilder.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }};
        ANY_HOSTNAME_VERIFIER = new HostnameVerifier() { // from class: com.rnappauth.utils.UnsafeConnectionBuilder.2
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        };
        SSLContext sSLContext2 = null;
        try {
            sSLContext = SSLContext.getInstance(SSL.DEFAULT_PROTOCOL);
        } catch (NoSuchAlgorithmException unused) {
            SentryLogcatAdapter.e(TAG, "Unable to acquire SSL context");
            sSLContext = null;
        }
        if (sSLContext != null) {
            try {
                sSLContext.init(null, ANY_CERT_MANAGER, new SecureRandom());
                sSLContext2 = sSLContext;
            } catch (KeyManagementException unused2) {
                SentryLogcatAdapter.e(TAG, "Failed to initialize trusting SSL context");
            }
        }
        TRUSTING_CONTEXT = sSLContext2;
    }

    private UnsafeConnectionBuilder() {
    }

    @Override // net.openid.appauth.connectivity.ConnectionBuilder
    public HttpURLConnection openConnection(@NonNull Uri uri) throws IOException {
        SSLContext sSLContext;
        Preconditions.checkNotNull(uri, "url must not be null");
        Preconditions.checkArgument("http".equals(uri.getScheme()) || "https".equals(uri.getScheme()), "scheme or uri must be http or https");
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(uri.toString()).openConnection()));
        httpURLConnection.setConnectTimeout(CONNECTION_TIMEOUT_MS);
        httpURLConnection.setReadTimeout(READ_TIMEOUT_MS);
        httpURLConnection.setInstanceFollowRedirects(false);
        if ((httpURLConnection instanceof HttpsURLConnection) && (sSLContext = TRUSTING_CONTEXT) != null) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(ANY_HOSTNAME_VERIFIER);
        }
        return httpURLConnection;
    }
}
