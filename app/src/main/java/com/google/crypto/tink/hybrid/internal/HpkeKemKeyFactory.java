package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.hybrid.HpkePrivateKey;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public final class HpkeKemKeyFactory {
    public static HpkeKemPrivateKey createPrivate(HpkePrivateKey hpkePrivateKey) throws GeneralSecurityException {
        HpkeParameters.KemId kemId = hpkePrivateKey.getParameters().getKemId();
        if (kemId == HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256 || kemId == HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256 || kemId == HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384 || kemId == HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) {
            return new HpkeKemPrivateKey(Bytes.copyFrom(hpkePrivateKey.getPrivateKeyBytes().toByteArray(InsecureSecretKeyAccess.get())), hpkePrivateKey.getPublicKey().getPublicKeyBytes());
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    private HpkeKemKeyFactory() {
    }
}
