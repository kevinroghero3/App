package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public final class EciesHkdfRecipientKem {
    private ECPrivateKey recipientPrivateKey;

    public EciesHkdfRecipientKem(ECPrivateKey eCPrivateKey) {
        this.recipientPrivateKey = eCPrivateKey;
    }

    public byte[] generateKey(byte[] bArr, String str, byte[] bArr2, byte[] bArr3, int i, EllipticCurves.PointFormatType pointFormatType) throws GeneralSecurityException {
        return Hkdf.computeEciesHkdfSymmetricKey(bArr, EllipticCurves.computeSharedSecret(this.recipientPrivateKey, EllipticCurves.getEcPublicKey(this.recipientPrivateKey.getParams(), pointFormatType, bArr)), str, bArr2, bArr3, i);
    }
}
