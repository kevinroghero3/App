package net.openid.appauth;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ClientSecretPost implements ClientAuthentication {
    public static final String NAME = "client_secret_post";
    static final String PARAM_CLIENT_ID = "client_id";
    static final String PARAM_CLIENT_SECRET = "client_secret";
    private String mClientSecret;

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestHeaders(@NonNull String str) {
        return null;
    }

    public ClientSecretPost(@NonNull String str) {
        this.mClientSecret = (String) Preconditions.checkNotNull(str, "clientSecret cannot be null");
    }

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestParameters(@NonNull String str) {
        HashMap map = new HashMap();
        map.put("client_id", str);
        map.put(PARAM_CLIENT_SECRET, this.mClientSecret);
        return map;
    }
}
