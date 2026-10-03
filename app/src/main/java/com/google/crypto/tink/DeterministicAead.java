package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public interface DeterministicAead {
    byte[] decryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException;

    byte[] encryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException;
}
