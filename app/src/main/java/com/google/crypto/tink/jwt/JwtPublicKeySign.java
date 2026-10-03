package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public interface JwtPublicKeySign {
    String signAndEncode(RawJwt rawJwt) throws GeneralSecurityException;
}
