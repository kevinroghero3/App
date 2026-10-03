package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public interface Mac {
    byte[] computeMac(byte[] bArr) throws GeneralSecurityException;

    void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException;
}
