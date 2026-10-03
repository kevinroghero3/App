package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.signature.RsaSsaPssPrivateKey;
import com.google.crypto.tink.util.SecretBigInteger;
import java.security.GeneralSecurityException;
import java.util.Optional;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtRsaSsaPssPrivateKey extends JwtSignaturePrivateKey {
    private final JwtRsaSsaPssPublicKey publicKey;
    private final RsaSsaPssPrivateKey rsaSsaPssPrivateKey;

    public static class Builder {
        private Optional<SecretBigInteger> d;
        private Optional<SecretBigInteger> dP;
        private Optional<SecretBigInteger> dQ;
        private Optional<SecretBigInteger> p;
        private Optional<JwtRsaSsaPssPublicKey> publicKey;
        private Optional<SecretBigInteger> q;
        private Optional<SecretBigInteger> qInv;
        private Optional<RsaSsaPssPrivateKey> rsaSsaPssPrivateKey;

        private Builder() {
            this.publicKey = Optional.empty();
            this.d = Optional.empty();
            this.p = Optional.empty();
            this.q = Optional.empty();
            this.dP = Optional.empty();
            this.dQ = Optional.empty();
            this.qInv = Optional.empty();
            this.rsaSsaPssPrivateKey = Optional.empty();
        }

        public Builder setPublicKey(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) {
            this.publicKey = Optional.of(jwtRsaSsaPssPublicKey);
            return this;
        }

        public Builder setPrimes(SecretBigInteger secretBigInteger, SecretBigInteger secretBigInteger2) {
            this.p = Optional.of(secretBigInteger);
            this.q = Optional.of(secretBigInteger2);
            return this;
        }

        public Builder setPrivateExponent(SecretBigInteger secretBigInteger) {
            this.d = Optional.of(secretBigInteger);
            return this;
        }

        public Builder setPrimeExponents(SecretBigInteger secretBigInteger, SecretBigInteger secretBigInteger2) {
            this.dP = Optional.of(secretBigInteger);
            this.dQ = Optional.of(secretBigInteger2);
            return this;
        }

        public Builder setCrtCoefficient(SecretBigInteger secretBigInteger) {
            this.qInv = Optional.of(secretBigInteger);
            return this;
        }

        Builder setRsaSsaPssPrivateKey(RsaSsaPssPrivateKey rsaSsaPssPrivateKey) {
            this.rsaSsaPssPrivateKey = Optional.of(rsaSsaPssPrivateKey);
            return this;
        }

        public JwtRsaSsaPssPrivateKey build() throws GeneralSecurityException {
            if (!this.publicKey.isPresent()) {
                throw new GeneralSecurityException("Cannot build without a RSA SSA PSS public key");
            }
            if (this.rsaSsaPssPrivateKey.isPresent()) {
                if (this.p.isPresent() || this.q.isPresent() || this.d.isPresent() || this.dP.isPresent() || this.dQ.isPresent() || this.qInv.isPresent()) {
                    throw new GeneralSecurityException("Cannot build with a RSA SSA PSS private key and other private key components");
                }
                if (!this.rsaSsaPssPrivateKey.get().getPublicKey().equalsKey(this.publicKey.get().getRsaSsaPssPublicKey())) {
                    throw new GeneralSecurityException("public key does not match the private key");
                }
                return new JwtRsaSsaPssPrivateKey(this.publicKey.get(), this.rsaSsaPssPrivateKey.get());
            }
            if (!this.p.isPresent() || !this.q.isPresent()) {
                throw new GeneralSecurityException("Cannot build without prime factors");
            }
            if (!this.d.isPresent()) {
                throw new GeneralSecurityException("Cannot build without private exponent");
            }
            if (!this.dP.isPresent() || !this.dQ.isPresent()) {
                throw new GeneralSecurityException("Cannot build without prime exponents");
            }
            if (!this.qInv.isPresent()) {
                throw new GeneralSecurityException("Cannot build without CRT coefficient");
            }
            return new JwtRsaSsaPssPrivateKey(this.publicKey.get(), RsaSsaPssPrivateKey.builder().setPublicKey(this.publicKey.get().getRsaSsaPssPublicKey()).setPrimes(this.p.get(), this.q.get()).setPrivateExponent(this.d.get()).setPrimeExponents(this.dP.get(), this.dQ.get()).setCrtCoefficient(this.qInv.get()).build());
        }
    }

    private JwtRsaSsaPssPrivateKey(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey, RsaSsaPssPrivateKey rsaSsaPssPrivateKey) {
        this.publicKey = jwtRsaSsaPssPublicKey;
        this.rsaSsaPssPrivateKey = rsaSsaPssPrivateKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePrivateKey, com.google.crypto.tink.Key
    public JwtRsaSsaPssParameters getParameters() {
        return this.publicKey.getParameters();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public JwtRsaSsaPssPublicKey getPublicKey() {
        return this.publicKey;
    }

    public SecretBigInteger getPrimeP() {
        return this.rsaSsaPssPrivateKey.getPrimeP();
    }

    public SecretBigInteger getPrimeQ() {
        return this.rsaSsaPssPrivateKey.getPrimeQ();
    }

    public SecretBigInteger getPrivateExponent() {
        return this.rsaSsaPssPrivateKey.getPrivateExponent();
    }

    public SecretBigInteger getPrimeExponentP() {
        return this.rsaSsaPssPrivateKey.getPrimeExponentP();
    }

    public SecretBigInteger getPrimeExponentQ() {
        return this.rsaSsaPssPrivateKey.getPrimeExponentQ();
    }

    public SecretBigInteger getCrtCoefficient() {
        return this.rsaSsaPssPrivateKey.getCrtCoefficient();
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof JwtRsaSsaPssPrivateKey)) {
            return false;
        }
        JwtRsaSsaPssPrivateKey jwtRsaSsaPssPrivateKey = (JwtRsaSsaPssPrivateKey) key;
        return jwtRsaSsaPssPrivateKey.publicKey.equalsKey(this.publicKey) && jwtRsaSsaPssPrivateKey.rsaSsaPssPrivateKey.equalsKey(this.rsaSsaPssPrivateKey);
    }

    RsaSsaPssPrivateKey getRsaSsaPssPrivateKey() {
        return this.rsaSsaPssPrivateKey;
    }
}
