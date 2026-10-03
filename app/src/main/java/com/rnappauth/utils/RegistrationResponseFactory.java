package com.rnappauth.utils;

import android.net.Uri;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import net.openid.appauth.RegistrationResponse;

/* JADX INFO: loaded from: classes6.dex */
public final class RegistrationResponseFactory {
    public static final WritableMap registrationResponseToMap(RegistrationResponse registrationResponse) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("clientId", registrationResponse.clientId);
        writableMapCreateMap.putMap("additionalParameters", MapUtil.createAdditionalParametersMap(registrationResponse.additionalParameters));
        Long l = registrationResponse.clientIdIssuedAt;
        if (l != null) {
            writableMapCreateMap.putString("clientIdIssuedAt", DateUtil.formatTimestamp(l));
        }
        String str = registrationResponse.clientSecret;
        if (str != null) {
            writableMapCreateMap.putString("clientSecret", str);
        }
        Long l2 = registrationResponse.clientSecretExpiresAt;
        if (l2 != null) {
            writableMapCreateMap.putString("clientSecretExpiresAt", DateUtil.formatTimestamp(l2));
        }
        String str2 = registrationResponse.registrationAccessToken;
        if (str2 != null) {
            writableMapCreateMap.putString("registrationAccessToken", str2);
        }
        Uri uri = registrationResponse.registrationClientUri;
        if (uri != null) {
            writableMapCreateMap.putString("registrationClientUri", uri.toString());
        }
        String str3 = registrationResponse.tokenEndpointAuthMethod;
        if (str3 != null) {
            writableMapCreateMap.putString("tokenEndpointAuthMethod", str3);
        }
        return writableMapCreateMap;
    }
}
