package com.facebook.login;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes.dex */
public enum CodeChallengeMethod {
    S256(AuthorizationRequest.CODE_CHALLENGE_METHOD_S256),
    PLAIN(AuthorizationRequest.CODE_CHALLENGE_METHOD_PLAIN);

    CodeChallengeMethod(String str) {
    }

    /* synthetic */ CodeChallengeMethod(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AuthorizationRequest.CODE_CHALLENGE_METHOD_S256 : str);
    }
}
