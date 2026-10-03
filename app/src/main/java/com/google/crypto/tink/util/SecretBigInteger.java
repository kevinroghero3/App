package com.google.crypto.tink.util;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class SecretBigInteger {
    private final BigInteger value;

    private SecretBigInteger(BigInteger bigInteger) {
        this.value = bigInteger;
    }

    public static SecretBigInteger fromBigInteger(BigInteger bigInteger, SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return new SecretBigInteger(bigInteger);
    }

    public BigInteger getBigInteger(SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return this.value;
    }

    public boolean equalsSecretBigInteger(SecretBigInteger secretBigInteger) {
        return MessageDigest.isEqual(this.value.toByteArray(), secretBigInteger.value.toByteArray());
    }
}
