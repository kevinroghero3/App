package com.google.crypto.tink.daead.subtle;

import com.google.crypto.tink.DeterministicAead;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public interface DeterministicAeads extends DeterministicAead {
    byte[] decryptDeterministicallyWithAssociatedDatas(byte[] bArr, byte[]... bArr2) throws GeneralSecurityException;

    byte[] encryptDeterministicallyWithAssociatedDatas(byte[] bArr, byte[]... bArr2) throws GeneralSecurityException;
}
