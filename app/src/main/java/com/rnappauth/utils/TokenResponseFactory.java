package com.rnappauth.utils;

import android.text.TextUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.transistorsoft.locationmanager.config.TSAuthorization;
import net.openid.appauth.AuthorizationResponse;
import net.openid.appauth.TokenResponse;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class TokenResponseFactory {
    private static final WritableArray createScopeArray(String str) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(StringUtils.SPACE)) {
                writableArrayCreateArray.pushString(str2);
            }
        }
        return writableArrayCreateArray;
    }

    public static final WritableMap tokenResponseToMap(TokenResponse tokenResponse) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("accessToken", tokenResponse.accessToken);
        writableMapCreateMap.putMap("additionalParameters", MapUtil.createAdditionalParametersMap(tokenResponse.additionalParameters));
        writableMapCreateMap.putString("idToken", tokenResponse.idToken);
        writableMapCreateMap.putString(TSAuthorization.FIELD_REFRESH_TOKEN, tokenResponse.refreshToken);
        writableMapCreateMap.putString("tokenType", tokenResponse.tokenType);
        Long l = tokenResponse.accessTokenExpirationTime;
        if (l != null) {
            writableMapCreateMap.putString("accessTokenExpirationDate", DateUtil.formatTimestamp(l));
        }
        return writableMapCreateMap;
    }

    public static final WritableMap tokenResponseToMap(TokenResponse tokenResponse, AuthorizationResponse authorizationResponse) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("accessToken", tokenResponse.accessToken);
        writableMapCreateMap.putMap("authorizeAdditionalParameters", MapUtil.createAdditionalParametersMap(authorizationResponse.additionalParameters));
        writableMapCreateMap.putMap("tokenAdditionalParameters", MapUtil.createAdditionalParametersMap(tokenResponse.additionalParameters));
        writableMapCreateMap.putString("idToken", tokenResponse.idToken);
        writableMapCreateMap.putString(TSAuthorization.FIELD_REFRESH_TOKEN, tokenResponse.refreshToken);
        writableMapCreateMap.putString("tokenType", tokenResponse.tokenType);
        writableMapCreateMap.putArray("scopes", createScopeArray(authorizationResponse.scope));
        Long l = tokenResponse.accessTokenExpirationTime;
        if (l != null) {
            writableMapCreateMap.putString("accessTokenExpirationDate", DateUtil.formatTimestamp(l));
        }
        return writableMapCreateMap;
    }

    public static final WritableMap authorizationResponseToMap(AuthorizationResponse authorizationResponse) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("authorizationCode", authorizationResponse.authorizationCode);
        writableMapCreateMap.putString("accessToken", authorizationResponse.accessToken);
        writableMapCreateMap.putMap("additionalParameters", MapUtil.createAdditionalParametersMap(authorizationResponse.additionalParameters));
        writableMapCreateMap.putString("idToken", authorizationResponse.idToken);
        writableMapCreateMap.putString("tokenType", authorizationResponse.tokenType);
        writableMapCreateMap.putArray("scopes", createScopeArray(authorizationResponse.scope));
        Long l = authorizationResponse.accessTokenExpirationTime;
        if (l != null) {
            writableMapCreateMap.putString("accessTokenExpirationTime", DateUtil.formatTimestamp(l));
        }
        return writableMapCreateMap;
    }

    public static final WritableMap authorizationCodeResponseToMap(AuthorizationResponse authorizationResponse, String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("authorizationCode", authorizationResponse.authorizationCode);
        writableMapCreateMap.putString("accessToken", authorizationResponse.accessToken);
        writableMapCreateMap.putMap("additionalParameters", MapUtil.createAdditionalParametersMap(authorizationResponse.additionalParameters));
        writableMapCreateMap.putString("idToken", authorizationResponse.idToken);
        writableMapCreateMap.putString("tokenType", authorizationResponse.tokenType);
        writableMapCreateMap.putArray("scopes", createScopeArray(authorizationResponse.scope));
        Long l = authorizationResponse.accessTokenExpirationTime;
        if (l != null) {
            writableMapCreateMap.putString("accessTokenExpirationTime", DateUtil.formatTimestamp(l));
        }
        if (!TextUtils.isEmpty(str)) {
            writableMapCreateMap.putString("codeVerifier", str);
        }
        return writableMapCreateMap;
    }
}
