package com.google.crypto.tink.signature;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public class SlhDsaPrivateKey extends SignaturePrivateKey {
    private static final int SLH_DSA_SHA2_128S_PRIVATE_KEY_BYTES = 64;
    private final SecretBytes privateKeyBytes;
    private final SlhDsaPublicKey publicKey;

    private SlhDsaPrivateKey(SlhDsaPublicKey slhDsaPublicKey, SecretBytes secretBytes) {
        this.publicKey = slhDsaPublicKey;
        this.privateKeyBytes = secretBytes;
    }

    public static SlhDsaPrivateKey createWithoutVerification(SlhDsaPublicKey slhDsaPublicKey, SecretBytes secretBytes) throws GeneralSecurityException {
        if (secretBytes.size() != 64) {
            throw new GeneralSecurityException("Incorrect private key size for SLH-DSA");
        }
        if (slhDsaPublicKey.getParameters().getHashType() != SlhDsaParameters.HashType.SHA2 || slhDsaPublicKey.getParameters().getPrivateKeySize() != 64 || slhDsaPublicKey.getParameters().getSignatureType() != SlhDsaParameters.SignatureType.SMALL_SIGNATURE) {
            throw new GeneralSecurityException("Unknown SKH-DSA instance; only SLH-DSA-SHA2-128S is currently supported");
        }
        return new SlhDsaPrivateKey(slhDsaPublicKey, secretBytes);
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public SlhDsaPublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.Key
    public SlhDsaParameters getParameters() {
        return this.publicKey.getParameters();
    }

    public SecretBytes getPrivateKeyBytes() {
        return this.privateKeyBytes;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof SlhDsaPrivateKey)) {
            return false;
        }
        SlhDsaPrivateKey slhDsaPrivateKey = (SlhDsaPrivateKey) key;
        return slhDsaPrivateKey.publicKey.equalsKey(this.publicKey) && this.privateKeyBytes.equalsSecretBytes(slhDsaPrivateKey.privateKeyBytes);
    }
}
