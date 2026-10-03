package com.google.crypto.tink.util;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.subtle.Random;
import com.google.errorprone.annotations.Immutable;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class SecretBytes {
    private final Bytes bytes;

    private SecretBytes(Bytes bytes) {
        this.bytes = bytes;
    }

    public static SecretBytes copyFrom(byte[] bArr, SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return new SecretBytes(Bytes.copyFrom(bArr));
    }

    public static SecretBytes randomBytes(int i) {
        return new SecretBytes(Bytes.copyFrom(Random.randBytes(i)));
    }

    public byte[] toByteArray(SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return this.bytes.toByteArray();
    }

    public int size() {
        return this.bytes.size();
    }

    public boolean equalsSecretBytes(SecretBytes secretBytes) {
        return MessageDigest.isEqual(this.bytes.toByteArray(), secretBytes.bytes.toByteArray());
    }
}
