package com.google.crypto.tink.aead.subtle;

import com.google.crypto.tink.Aead;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public interface AeadFactory {
    Aead createAead(byte[] bArr) throws GeneralSecurityException;

    int getKeySizeInBytes();
}
