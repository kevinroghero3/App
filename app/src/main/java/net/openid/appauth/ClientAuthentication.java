package net.openid.appauth;

import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface ClientAuthentication {
    Map<String, String> getRequestHeaders(@NonNull String str);

    Map<String, String> getRequestParameters(@NonNull String str);

    /* JADX INFO: loaded from: classes6.dex */
    public static class UnsupportedAuthenticationMethod extends Exception {
        private String mAuthMethod;

        public UnsupportedAuthenticationMethod(String str) {
            super("Unsupported client authentication method: " + str);
            this.mAuthMethod = str;
        }

        public String getUnsupportedAuthenticationMethod() {
            return this.mAuthMethod;
        }
    }
}
