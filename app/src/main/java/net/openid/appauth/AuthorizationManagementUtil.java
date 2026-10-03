package net.openid.appauth;

import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import androidx.annotation.NonNull;
import java.security.SecureRandom;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
class AuthorizationManagementUtil {
    public static final String REQUEST_TYPE_AUTHORIZATION = "authorization";
    public static final String REQUEST_TYPE_END_SESSION = "end_session";
    private static final int STATE_LENGTH = 16;

    AuthorizationManagementUtil() {
    }

    static String generateRandomState() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }

    static String requestTypeFor(AuthorizationManagementRequest authorizationManagementRequest) {
        if (authorizationManagementRequest instanceof AuthorizationRequest) {
            return "authorization";
        }
        if (authorizationManagementRequest instanceof EndSessionRequest) {
            return REQUEST_TYPE_END_SESSION;
        }
        return null;
    }

    static AuthorizationManagementRequest requestFrom(String str, String str2) throws JSONException {
        Preconditions.checkNotNull(str, "jsonStr can not be null");
        JSONObject jSONObject = new JSONObject(str);
        if ("authorization".equals(str2)) {
            return AuthorizationRequest.jsonDeserialize(jSONObject);
        }
        if (REQUEST_TYPE_END_SESSION.equals(str2)) {
            return EndSessionRequest.jsonDeserialize(jSONObject);
        }
        throw new IllegalArgumentException("No AuthorizationManagementRequest found matching to this json schema");
    }

    static AuthorizationManagementResponse responseWith(AuthorizationManagementRequest authorizationManagementRequest, Uri uri) {
        if (authorizationManagementRequest instanceof AuthorizationRequest) {
            return new AuthorizationResponse.Builder((AuthorizationRequest) authorizationManagementRequest).fromUri(uri).build();
        }
        if (authorizationManagementRequest instanceof EndSessionRequest) {
            return new EndSessionResponse.Builder((EndSessionRequest) authorizationManagementRequest).fromUri(uri).build();
        }
        throw new IllegalArgumentException("Malformed request or uri");
    }

    static AuthorizationManagementResponse responseFrom(@NonNull Intent intent) {
        if (EndSessionResponse.containsEndSessionResponse(intent)) {
            return EndSessionResponse.fromIntent(intent);
        }
        if (AuthorizationResponse.containsAuthorizationResponse(intent)) {
            return AuthorizationResponse.fromIntent(intent);
        }
        throw new IllegalArgumentException("Malformed intent");
    }
}
