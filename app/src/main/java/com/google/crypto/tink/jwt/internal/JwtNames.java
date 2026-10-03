package com.google.crypto.tink.jwt.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtNames {
    public static final String CLAIM_AUDIENCE = "aud";
    public static final String CLAIM_EXPIRATION = "exp";
    public static final String CLAIM_ISSUED_AT = "iat";
    public static final String CLAIM_ISSUER = "iss";
    public static final String CLAIM_JWT_ID = "jti";
    public static final String CLAIM_NOT_BEFORE = "nbf";
    public static final String CLAIM_SUBJECT = "sub";
    public static final String HEADER_ALGORITHM = "alg";
    public static final String HEADER_CRITICAL = "crit";
    public static final String HEADER_KEY_ID = "kid";
    public static final String HEADER_TYPE = "typ";

    public static void validate(String str) {
        if (isRegisteredName(str)) {
            throw new IllegalArgumentException(String.format("claim '%s' is invalid because it's a registered name; use the corresponding setter method.", str));
        }
    }

    public static boolean isRegisteredName(String str) {
        return str.equals("iss") || str.equals("sub") || str.equals("aud") || str.equals("exp") || str.equals(CLAIM_NOT_BEFORE) || str.equals("iat") || str.equals("jti");
    }

    private JwtNames() {
    }
}
