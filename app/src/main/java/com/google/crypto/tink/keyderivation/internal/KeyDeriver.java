package com.google.crypto.tink.keyderivation.internal;

import com.google.crypto.tink.Key;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public interface KeyDeriver {
    Key deriveKey(byte[] bArr) throws GeneralSecurityException;
}
