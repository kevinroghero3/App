package net.openid.appauth.connectivity;

import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes3.dex */
public interface ConnectionBuilder {
    HttpURLConnection openConnection(@NonNull Uri uri) throws IOException;
}
