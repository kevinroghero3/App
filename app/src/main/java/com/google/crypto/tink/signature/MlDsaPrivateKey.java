package com.google.crypto.tink.signature;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public class MlDsaPrivateKey extends SignaturePrivateKey {
    private static final int MLDSA_SEED_BYTES = 32;
    private final SecretBytes privateSeed;
    private final MlDsaPublicKey publicKey;

    private MlDsaPrivateKey(MlDsaPublicKey mlDsaPublicKey, SecretBytes secretBytes) {
        this.publicKey = mlDsaPublicKey;
        this.privateSeed = secretBytes;
    }

    public static MlDsaPrivateKey createWithoutVerification(MlDsaPublicKey mlDsaPublicKey, SecretBytes secretBytes) throws GeneralSecurityException {
        if (secretBytes.size() != 32) {
            throw new GeneralSecurityException("Incorrect private seed size for ML-DSA");
        }
        if (mlDsaPublicKey.getParameters().getMlDsaInstance() != MlDsaParameters.MlDsaInstance.ML_DSA_65 && mlDsaPublicKey.getParameters().getMlDsaInstance() != MlDsaParameters.MlDsaInstance.ML_DSA_87) {
            throw new GeneralSecurityException("Unknown ML-DSA instance: " + mlDsaPublicKey.getParameters().getMlDsaInstance() + ", only ML-DSA-{65,87} are supported");
        }
        return new MlDsaPrivateKey(mlDsaPublicKey, secretBytes);
    }

    public SecretBytes getPrivateSeed() {
        return this.privateSeed;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof MlDsaPrivateKey)) {
            return false;
        }
        MlDsaPrivateKey mlDsaPrivateKey = (MlDsaPrivateKey) key;
        return mlDsaPrivateKey.publicKey.equalsKey(this.publicKey) && this.privateSeed.equalsSecretBytes(mlDsaPrivateKey.privateSeed);
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.Key
    public MlDsaParameters getParameters() {
        return this.publicKey.getParameters();
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public MlDsaPublicKey getPublicKey() {
        return this.publicKey;
    }
}
