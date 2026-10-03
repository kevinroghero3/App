package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public interface IndCpaCipher {
    byte[] decrypt(byte[] bArr) throws GeneralSecurityException;

    byte[] encrypt(byte[] bArr) throws GeneralSecurityException;
}
