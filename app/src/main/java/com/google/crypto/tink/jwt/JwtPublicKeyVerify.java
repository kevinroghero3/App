package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public interface JwtPublicKeyVerify {
    VerifiedJwt verifyAndDecode(String str, JwtValidator jwtValidator) throws GeneralSecurityException;
}
