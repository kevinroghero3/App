package com.rnappauth.utils;

import android.net.Uri;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import net.openid.appauth.EndSessionResponse;

/* JADX INFO: loaded from: classes3.dex */
public final class EndSessionResponseFactory {
    public static final WritableMap endSessionResponseToMap(EndSessionResponse endSessionResponse) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("state", endSessionResponse.state);
        writableMapCreateMap.putString("idTokenHint", endSessionResponse.request.idTokenHint);
        Uri uri = endSessionResponse.request.postLogoutRedirectUri;
        if (uri != null) {
            writableMapCreateMap.putString("postLogoutRedirectUri", uri.toString());
        }
        return writableMapCreateMap;
    }
}
