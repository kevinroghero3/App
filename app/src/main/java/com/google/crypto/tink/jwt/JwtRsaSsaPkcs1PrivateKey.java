package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.util.SecretBigInteger;
import java.security.GeneralSecurityException;
import java.util.Optional;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtRsaSsaPkcs1PrivateKey extends JwtSignaturePrivateKey {
    private final JwtRsaSsaPkcs1PublicKey publicKey;
    private final RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey;

    public static class Builder {
        public static int MediaBrowserCompatItemCallbackStubApi23;
        public static int onServiceConnected;
        private Optional<SecretBigInteger> d;
        private Optional<SecretBigInteger> dP;
        private Optional<SecretBigInteger> dQ;
        private Optional<SecretBigInteger> p;
        private Optional<JwtRsaSsaPkcs1PublicKey> publicKey;
        private Optional<SecretBigInteger> q;
        private Optional<SecretBigInteger> qInv;
        private Optional<RsaSsaPkcs1PrivateKey> rsaSsaPkcs1PrivateKey;

        private Builder() {
            this.publicKey = Optional.empty();
            this.d = Optional.empty();
            this.p = Optional.empty();
            this.q = Optional.empty();
            this.dP = Optional.empty();
            this.dQ = Optional.empty();
            this.qInv = Optional.empty();
            this.rsaSsaPkcs1PrivateKey = Optional.empty();
        }

        public Builder setPublicKey(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) {
            this.publicKey = Optional.of(jwtRsaSsaPkcs1PublicKey);
            return this;
        }

        Builder setRsaSsaPkcs1PrivateKey(RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey) {
            this.rsaSsaPkcs1PrivateKey = Optional.of(rsaSsaPkcs1PrivateKey);
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

        public JwtRsaSsaPkcs1PrivateKey build() throws GeneralSecurityException {
            if (!this.publicKey.isPresent()) {
                throw new GeneralSecurityException("Cannot build without a RSA SSA PKCS1 public key");
            }
            if (this.rsaSsaPkcs1PrivateKey.isPresent()) {
                if (this.p.isPresent() || this.q.isPresent() || this.d.isPresent() || this.dP.isPresent() || this.dQ.isPresent() || this.qInv.isPresent()) {
                    throw new GeneralSecurityException("Cannot build with a RSA SSA PKCS1 private key and other private key components");
                }
                if (!this.rsaSsaPkcs1PrivateKey.get().getPublicKey().equalsKey(this.publicKey.get().getRsaSsaPkcs1PublicKey())) {
                    throw new GeneralSecurityException("public key does not match the private key");
                }
                return new JwtRsaSsaPkcs1PrivateKey(this.publicKey.get(), this.rsaSsaPkcs1PrivateKey.get());
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
            return new JwtRsaSsaPkcs1PrivateKey(this.publicKey.get(), RsaSsaPkcs1PrivateKey.builder().setPublicKey(this.publicKey.get().getRsaSsaPkcs1PublicKey()).setPrimes(this.p.get(), this.q.get()).setPrivateExponent(this.d.get()).setPrimeExponents(this.dP.get(), this.dQ.get()).setCrtCoefficient(this.qInv.get()).build());
        }

        public static int ITrustedWebActivityCallbackDefault() {
            int i = MediaBrowserCompatItemCallbackStubApi23;
            int i2 = i % 6759232;
            MediaBrowserCompatItemCallbackStubApi23 = i + 1;
            if (i2 != 0) {
                return onServiceConnected;
            }
            int i3 = (int) Runtime.getRuntime().totalMemory();
            onServiceConnected = i3;
            return i3;
        }
    }

    private JwtRsaSsaPkcs1PrivateKey(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey, RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey) {
        this.publicKey = jwtRsaSsaPkcs1PublicKey;
        this.rsaSsaPkcs1PrivateKey = rsaSsaPkcs1PrivateKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePrivateKey, com.google.crypto.tink.Key
    public JwtRsaSsaPkcs1Parameters getParameters() {
        return this.publicKey.getParameters();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public JwtRsaSsaPkcs1PublicKey getPublicKey() {
        return this.publicKey;
    }

    public SecretBigInteger getPrimeP() {
        return this.rsaSsaPkcs1PrivateKey.getPrimeP();
    }

    public SecretBigInteger getPrimeQ() {
        return this.rsaSsaPkcs1PrivateKey.getPrimeQ();
    }

    public SecretBigInteger getPrivateExponent() {
        return this.rsaSsaPkcs1PrivateKey.getPrivateExponent();
    }

    public SecretBigInteger getPrimeExponentP() {
        return this.rsaSsaPkcs1PrivateKey.getPrimeExponentP();
    }

    public SecretBigInteger getPrimeExponentQ() {
        return this.rsaSsaPkcs1PrivateKey.getPrimeExponentQ();
    }

    public SecretBigInteger getCrtCoefficient() {
        return this.rsaSsaPkcs1PrivateKey.getCrtCoefficient();
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof JwtRsaSsaPkcs1PrivateKey)) {
            return false;
        }
        JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey = (JwtRsaSsaPkcs1PrivateKey) key;
        return jwtRsaSsaPkcs1PrivateKey.publicKey.equalsKey(this.publicKey) && jwtRsaSsaPkcs1PrivateKey.rsaSsaPkcs1PrivateKey.equalsKey(this.rsaSsaPkcs1PrivateKey);
    }

    RsaSsaPkcs1PrivateKey getRsaSsaPkcs1PrivateKey() {
        return this.rsaSsaPkcs1PrivateKey;
    }
}
