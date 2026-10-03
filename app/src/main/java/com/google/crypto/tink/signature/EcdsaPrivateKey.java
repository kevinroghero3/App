package com.google.crypto.tink.signature;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.util.SecretBigInteger;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class EcdsaPrivateKey extends SignaturePrivateKey {
    private final SecretBigInteger privateValue;
    private final EcdsaPublicKey publicKey;

    /* JADX INFO: loaded from: classes5.dex */
    public static class Builder {
        private SecretBigInteger privateValue;
        private EcdsaPublicKey publicKey;

        private Builder() {
            this.publicKey = null;
            this.privateValue = null;
        }

        public Builder setPublicKey(EcdsaPublicKey ecdsaPublicKey) {
            this.publicKey = ecdsaPublicKey;
            return this;
        }

        public Builder setPrivateValue(SecretBigInteger secretBigInteger) {
            this.privateValue = secretBigInteger;
            return this;
        }

        private static void validatePrivateValue(BigInteger bigInteger, ECPoint eCPoint, EcdsaParameters.CurveType curveType) throws GeneralSecurityException {
            BigInteger order = curveType.toParameterSpec().getOrder();
            if (bigInteger.signum() <= 0 || bigInteger.compareTo(order) >= 0) {
                throw new GeneralSecurityException("Invalid private value");
            }
            if (!EllipticCurvesUtil.multiplyByGenerator(bigInteger, curveType.toParameterSpec()).equals(eCPoint)) {
                throw new GeneralSecurityException("Invalid private value");
            }
        }

        public EcdsaPrivateKey build() throws GeneralSecurityException {
            if (this.publicKey == null) {
                throw new GeneralSecurityException("Cannot build without a ecdsa public key");
            }
            SecretBigInteger secretBigInteger = this.privateValue;
            if (secretBigInteger == null) {
                throw new GeneralSecurityException("Cannot build without a private value");
            }
            validatePrivateValue(secretBigInteger.getBigInteger(InsecureSecretKeyAccess.get()), this.publicKey.getPublicPoint(), this.publicKey.getParameters().getCurveType());
            return new EcdsaPrivateKey(this.publicKey, this.privateValue);
        }
    }

    private EcdsaPrivateKey(EcdsaPublicKey ecdsaPublicKey, SecretBigInteger secretBigInteger) {
        this.publicKey = ecdsaPublicKey;
        this.privateValue = secretBigInteger;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.Key
    public EcdsaParameters getParameters() {
        return this.publicKey.getParameters();
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public EcdsaPublicKey getPublicKey() {
        return this.publicKey;
    }

    public SecretBigInteger getPrivateValue() {
        return this.privateValue;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof EcdsaPrivateKey)) {
            return false;
        }
        EcdsaPrivateKey ecdsaPrivateKey = (EcdsaPrivateKey) key;
        return ecdsaPrivateKey.publicKey.equalsKey(this.publicKey) && this.privateValue.equalsSecretBigInteger(ecdsaPrivateKey.privateValue);
    }
}
