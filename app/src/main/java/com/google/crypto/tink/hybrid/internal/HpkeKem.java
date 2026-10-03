package com.google.crypto.tink.hybrid.internal;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public interface HpkeKem {
    byte[] authDecapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey, byte[] bArr2) throws GeneralSecurityException;

    HpkeKemEncapOutput authEncapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey) throws GeneralSecurityException;

    byte[] decapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey) throws GeneralSecurityException;

    HpkeKemEncapOutput encapsulate(byte[] bArr) throws GeneralSecurityException;

    byte[] getKemId() throws GeneralSecurityException;
}
