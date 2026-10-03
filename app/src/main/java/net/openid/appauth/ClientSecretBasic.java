package net.openid.appauth;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.google.common.net.HttpHeaders;
import java.util.Collections;
import java.util.Map;
import net.openid.appauth.internal.UriUtil;

/* JADX INFO: loaded from: classes3.dex */
public class ClientSecretBasic implements ClientAuthentication {
    public static final String NAME = "client_secret_basic";
    private String mClientSecret;

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestParameters(@NonNull String str) {
        return null;
    }

    public ClientSecretBasic(@NonNull String str) {
        this.mClientSecret = (String) Preconditions.checkNotNull(str, "mClientSecret cannot be null");
    }

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestHeaders(@NonNull String str) {
        return Collections.singletonMap(HttpHeaders.AUTHORIZATION, "Basic " + Base64.encodeToString((UriUtil.formUrlEncodeValue(str) + ":" + UriUtil.formUrlEncodeValue(this.mClientSecret)).getBytes(), 2));
    }
}
