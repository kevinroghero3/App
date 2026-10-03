package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.signature.RsaSsaPssParameters;
import com.google.crypto.tink.signature.RsaSsaPssPublicKey;
import com.google.crypto.tink.subtle.Base64;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Optional;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtRsaSsaPssPublicKey extends JwtSignaturePublicKey {
    private final Optional<Integer> idRequirement;
    private final Optional<String> kid;
    private final JwtRsaSsaPssParameters parameters;
    private final RsaSsaPssPublicKey rsaSsaPssPublicKey;

    public static class Builder {
        private Optional<String> customKid;
        private Optional<Integer> idRequirement;
        private Optional<BigInteger> modulus;
        private Optional<JwtRsaSsaPssParameters> parameters;

        private Builder() {
            this.parameters = Optional.empty();
            this.modulus = Optional.empty();
            this.idRequirement = Optional.empty();
            this.customKid = Optional.empty();
        }

        public Builder setParameters(JwtRsaSsaPssParameters jwtRsaSsaPssParameters) {
            this.parameters = Optional.of(jwtRsaSsaPssParameters);
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
            if (this.parameters.get().getKidStrategy().equals(JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID)) {
                if (this.customKid.isPresent()) {
                    throw new GeneralSecurityException("customKid must not be set for KidStrategy BASE64_ENCODED_KEY_ID");
                }
                return Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(this.idRequirement.get().intValue()).array()));
            }
            if (this.parameters.get().getKidStrategy().equals(JwtRsaSsaPssParameters.KidStrategy.CUSTOM)) {
                if (!this.customKid.isPresent()) {
                    throw new GeneralSecurityException("customKid needs to be set for KidStrategy CUSTOM");
                }
                return this.customKid;
            }
            if (this.parameters.get().getKidStrategy().equals(JwtRsaSsaPssParameters.KidStrategy.IGNORED)) {
                if (this.customKid.isPresent()) {
                    throw new GeneralSecurityException("customKid must not be set for KidStrategy IGNORED");
                }
                return Optional.empty();
            }
            throw new IllegalStateException("Unknown kid strategy");
        }

        private static RsaSsaPssParameters.HashType getHashType(JwtRsaSsaPssParameters.Algorithm algorithm) throws GeneralSecurityException {
            if (algorithm.equals(JwtRsaSsaPssParameters.Algorithm.PS256)) {
                return RsaSsaPssParameters.HashType.SHA256;
            }
            if (algorithm.equals(JwtRsaSsaPssParameters.Algorithm.PS384)) {
                return RsaSsaPssParameters.HashType.SHA384;
            }
            if (algorithm.equals(JwtRsaSsaPssParameters.Algorithm.PS512)) {
                return RsaSsaPssParameters.HashType.SHA512;
            }
            throw new GeneralSecurityException("unknown algorithm " + algorithm);
        }

        private static int getSaltLengthBytes(JwtRsaSsaPssParameters.Algorithm algorithm) throws GeneralSecurityException {
            if (algorithm.equals(JwtRsaSsaPssParameters.Algorithm.PS256)) {
                return 32;
            }
            if (algorithm.equals(JwtRsaSsaPssParameters.Algorithm.PS384)) {
                return 48;
            }
            if (algorithm.equals(JwtRsaSsaPssParameters.Algorithm.PS512)) {
                return 64;
            }
            throw new GeneralSecurityException("unknown algorithm " + algorithm);
        }

        public JwtRsaSsaPssPublicKey build() throws GeneralSecurityException {
            if (!this.parameters.isPresent()) {
                throw new GeneralSecurityException("Cannot build without parameters");
            }
            if (!this.modulus.isPresent()) {
                throw new GeneralSecurityException("Cannot build without modulus");
            }
            RsaSsaPssParameters.HashType hashType = getHashType(this.parameters.get().getAlgorithm());
            RsaSsaPssPublicKey rsaSsaPssPublicKeyBuild = RsaSsaPssPublicKey.builder().setParameters(RsaSsaPssParameters.builder().setModulusSizeBits(this.parameters.get().getModulusSizeBits()).setPublicExponent(this.parameters.get().getPublicExponent()).setSigHashType(hashType).setMgf1HashType(hashType).setSaltLengthBytes(getSaltLengthBytes(this.parameters.get().getAlgorithm())).setVariant(RsaSsaPssParameters.Variant.NO_PREFIX).build()).setModulus(this.modulus.get()).build();
            if (this.parameters.get().hasIdRequirement() && !this.idRequirement.isPresent()) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.parameters.get().hasIdRequirement() && this.idRequirement.isPresent()) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new JwtRsaSsaPssPublicKey(this.parameters.get(), rsaSsaPssPublicKeyBuild, this.idRequirement, computeKid());
        }
    }

    private JwtRsaSsaPssPublicKey(JwtRsaSsaPssParameters jwtRsaSsaPssParameters, RsaSsaPssPublicKey rsaSsaPssPublicKey, Optional<Integer> optional, Optional<String> optional2) {
        this.parameters = jwtRsaSsaPssParameters;
        this.rsaSsaPssPublicKey = rsaSsaPssPublicKey;
        this.idRequirement = optional;
        this.kid = optional2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public BigInteger getModulus() {
        return this.rsaSsaPssPublicKey.getModulus();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey
    public Optional<String> getKid() {
        return this.kid;
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey, com.google.crypto.tink.Key
    public JwtRsaSsaPssParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement.orElse(null);
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof JwtRsaSsaPssPublicKey)) {
            return false;
        }
        JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey = (JwtRsaSsaPssPublicKey) key;
        return jwtRsaSsaPssPublicKey.parameters.equals(this.parameters) && jwtRsaSsaPssPublicKey.rsaSsaPssPublicKey.equalsKey(this.rsaSsaPssPublicKey) && jwtRsaSsaPssPublicKey.kid.equals(this.kid) && jwtRsaSsaPssPublicKey.idRequirement.equals(this.idRequirement);
    }

    RsaSsaPssPublicKey getRsaSsaPssPublicKey() {
        return this.rsaSsaPssPublicKey;
    }
}
