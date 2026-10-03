package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.signature.RsaSsaPkcs1Parameters;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.subtle.Base64;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Optional;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtRsaSsaPkcs1PublicKey extends JwtSignaturePublicKey {
    private final Optional<Integer> idRequirement;
    private final Optional<String> kid;
    private final JwtRsaSsaPkcs1Parameters parameters;
    private final RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey;

    private static RsaSsaPkcs1Parameters.HashType getHashType(JwtRsaSsaPkcs1Parameters.Algorithm algorithm) throws GeneralSecurityException {
        if (algorithm.equals(JwtRsaSsaPkcs1Parameters.Algorithm.RS256)) {
            return RsaSsaPkcs1Parameters.HashType.SHA256;
        }
        if (algorithm.equals(JwtRsaSsaPkcs1Parameters.Algorithm.RS384)) {
            return RsaSsaPkcs1Parameters.HashType.SHA384;
        }
        if (algorithm.equals(JwtRsaSsaPkcs1Parameters.Algorithm.RS512)) {
            return RsaSsaPkcs1Parameters.HashType.SHA512;
        }
        throw new GeneralSecurityException("unknown algorithm " + algorithm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RsaSsaPkcs1PublicKey toRsaSsaPkcs1PublicKey(JwtRsaSsaPkcs1Parameters jwtRsaSsaPkcs1Parameters, BigInteger bigInteger) throws GeneralSecurityException {
        return RsaSsaPkcs1PublicKey.builder().setParameters(RsaSsaPkcs1Parameters.builder().setModulusSizeBits(jwtRsaSsaPkcs1Parameters.getModulusSizeBits()).setPublicExponent(jwtRsaSsaPkcs1Parameters.getPublicExponent()).setHashType(getHashType(jwtRsaSsaPkcs1Parameters.getAlgorithm())).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build()).setModulus(bigInteger).build();
    }

    public static class Builder {
        private Optional<String> customKid;
        private Optional<Integer> idRequirement;
        private Optional<BigInteger> modulus;
        private Optional<JwtRsaSsaPkcs1Parameters> parameters;

        private Builder() {
            this.parameters = Optional.empty();
            this.modulus = Optional.empty();
            this.idRequirement = Optional.empty();
            this.customKid = Optional.empty();
        }

        public Builder setParameters(JwtRsaSsaPkcs1Parameters jwtRsaSsaPkcs1Parameters) {
            this.parameters = Optional.of(jwtRsaSsaPkcs1Parameters);
            return this;
        }

        public Builder setModulus(BigInteger bigInteger) {
            this.modulus = Optional.of(bigInteger);
            return this;
        }

        public Builder setIdRequirement(Integer num) {
            this.idRequirement = Optional.of(num);
            return this;
        }

        public Builder setCustomKid(String str) {
            this.customKid = Optional.of(str);
            return this;
        }

        private Optional<String> computeKid() throws GeneralSecurityException {
            if (this.parameters.get().getKidStrategy().equals(JwtRsaSsaPkcs1Parameters.KidStrategy.BASE64_ENCODED_KEY_ID)) {
                if (this.customKid.isPresent()) {
                    throw new GeneralSecurityException("customKid must not be set for KidStrategy BASE64_ENCODED_KEY_ID");
                }
                return Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(this.idRequirement.get().intValue()).array()));
            }
            if (this.parameters.get().getKidStrategy().equals(JwtRsaSsaPkcs1Parameters.KidStrategy.CUSTOM)) {
                if (!this.customKid.isPresent()) {
                    throw new GeneralSecurityException("customKid needs to be set for KidStrategy CUSTOM");
                }
                return this.customKid;
            }
            if (this.parameters.get().getKidStrategy().equals(JwtRsaSsaPkcs1Parameters.KidStrategy.IGNORED)) {
                if (this.customKid.isPresent()) {
                    throw new GeneralSecurityException("customKid must not be set for KidStrategy IGNORED");
                }
                return Optional.empty();
            }
            throw new IllegalStateException("Unknown kid strategy");
        }

        public JwtRsaSsaPkcs1PublicKey build() throws GeneralSecurityException {
            if (!this.parameters.isPresent()) {
                throw new GeneralSecurityException("Cannot build without parameters");
            }
            if (this.modulus.isPresent()) {
                RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey = JwtRsaSsaPkcs1PublicKey.toRsaSsaPkcs1PublicKey(this.parameters.get(), this.modulus.get());
                if (this.parameters.get().hasIdRequirement() && !this.idRequirement.isPresent()) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (!this.parameters.get().hasIdRequirement() && this.idRequirement.isPresent()) {
                    throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                }
                return new JwtRsaSsaPkcs1PublicKey(this.parameters.get(), rsaSsaPkcs1PublicKey, this.idRequirement, computeKid());
            }
            throw new GeneralSecurityException("Cannot build without modulus");
        }
    }

    private JwtRsaSsaPkcs1PublicKey(JwtRsaSsaPkcs1Parameters jwtRsaSsaPkcs1Parameters, RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey, Optional<Integer> optional, Optional<String> optional2) {
        this.parameters = jwtRsaSsaPkcs1Parameters;
        this.rsaSsaPkcs1PublicKey = rsaSsaPkcs1PublicKey;
        this.idRequirement = optional;
        this.kid = optional2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public BigInteger getModulus() {
        return this.rsaSsaPkcs1PublicKey.getModulus();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey
    public Optional<String> getKid() {
        return this.kid;
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey, com.google.crypto.tink.Key
    public JwtRsaSsaPkcs1Parameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement.orElse(null);
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof JwtRsaSsaPkcs1PublicKey)) {
            return false;
        }
        JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey = (JwtRsaSsaPkcs1PublicKey) key;
        return jwtRsaSsaPkcs1PublicKey.parameters.equals(this.parameters) && jwtRsaSsaPkcs1PublicKey.rsaSsaPkcs1PublicKey.equalsKey(this.rsaSsaPkcs1PublicKey) && jwtRsaSsaPkcs1PublicKey.kid.equals(this.kid) && jwtRsaSsaPkcs1PublicKey.idRequirement.equals(this.idRequirement);
    }

    RsaSsaPkcs1PublicKey getRsaSsaPkcs1PublicKey() {
        return this.rsaSsaPkcs1PublicKey;
    }
}
