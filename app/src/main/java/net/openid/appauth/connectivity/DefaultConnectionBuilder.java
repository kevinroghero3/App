package net.openid.appauth.connectivity;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;
import net.openid.appauth.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultConnectionBuilder implements ConnectionBuilder {
    private static final int CONNECTION_TIMEOUT_MS;
    private static final String HTTPS_SCHEME = "https";
    public static final DefaultConnectionBuilder INSTANCE = new DefaultConnectionBuilder();
    private static final int READ_TIMEOUT_MS;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        CONNECTION_TIMEOUT_MS = (int) timeUnit.toMillis(15L);
        READ_TIMEOUT_MS = (int) timeUnit.toMillis(10L);
    }

    private DefaultConnectionBuilder() {
    }

    @Override // net.openid.appauth.connectivity.ConnectionBuilder
    public HttpURLConnection openConnection(@NonNull Uri uri) throws IOException {
        Preconditions.checkNotNull(uri, "url must not be null");
        Preconditions.checkArgument("https".equals(uri.getScheme()), "only https connections are permitted");
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(uri.toString()).openConnection()));
        httpURLConnection.setConnectTimeout(CONNECTION_TIMEOUT_MS);
        httpURLConnection.setReadTimeout(READ_TIMEOUT_MS);
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }
}
