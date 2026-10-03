package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.signature.EcdsaParameters;
import com.google.crypto.tink.signature.EcdsaPublicKey;
import com.google.crypto.tink.subtle.Base64;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.util.Optional;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class JwtEcdsaPublicKey extends JwtSignaturePublicKey {
    private final EcdsaPublicKey ecdsaPublicKey;
    private final Optional<Integer> idRequirement;
    private final Optional<String> kid;
    private final JwtEcdsaParameters parameters;

    public static class Builder {
        private Optional<String> customKid;
        private Optional<Integer> idRequirement;
        private Optional<JwtEcdsaParameters> parameters;
        private Optional<ECPoint> publicPoint;

        private Builder() {
            this.parameters = Optional.empty();
            this.publicPoint = Optional.empty();
            this.idRequirement = Optional.empty();
            this.customKid = Optional.empty();
        }

        public Builder setParameters(JwtEcdsaParameters jwtEcdsaParameters) {
            this.parameters = Optional.of(jwtEcdsaParameters);
            return this;
        }

        public Builder setPublicPoint(ECPoint eCPoint) {
            this.publicPoint = Optional.of(eCPoint);
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
            if (this.parameters.get().getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID)) {
                if (this.customKid.isPresent()) {
                    throw new GeneralSecurityException("customKid must not be set for KidStrategy BASE64_ENCODED_KEY_ID");
                }
                return Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(this.idRequirement.get().intValue()).array()));
            }
            if (this.parameters.get().getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.CUSTOM)) {
                if (!this.customKid.isPresent()) {
                    throw new GeneralSecurityException("customKid needs to be set for KidStrategy CUSTOM");
                }
                return this.customKid;
            }
            if (this.parameters.get().getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.IGNORED)) {
                if (this.customKid.isPresent()) {
                    throw new GeneralSecurityException("customKid must not be set for KidStrategy IGNORED");
                }
                return Optional.empty();
            }
            throw new IllegalStateException("Unknown kid strategy");
        }

        private static EcdsaParameters.CurveType getCurveType(JwtEcdsaParameters jwtEcdsaParameters) throws GeneralSecurityException {
            if (jwtEcdsaParameters.getAlgorithm().equals(JwtEcdsaParameters.Algorithm.ES256)) {
                return EcdsaParameters.CurveType.NIST_P256;
            }
            if (jwtEcdsaParameters.getAlgorithm().equals(JwtEcdsaParameters.Algorithm.ES384)) {
                return EcdsaParameters.CurveType.NIST_P384;
            }
            if (jwtEcdsaParameters.getAlgorithm().equals(JwtEcdsaParameters.Algorithm.ES512)) {
                return EcdsaParameters.CurveType.NIST_P521;
            }
            throw new GeneralSecurityException("unknown algorithm in parameters: " + jwtEcdsaParameters);
        }

        private static EcdsaParameters.HashType getHashType(JwtEcdsaParameters jwtEcdsaParameters) throws GeneralSecurityException {
            if (jwtEcdsaParameters.getAlgorithm().equals(JwtEcdsaParameters.Algorithm.ES256)) {
                return EcdsaParameters.HashType.SHA256;
            }
            if (jwtEcdsaParameters.getAlgorithm().equals(JwtEcdsaParameters.Algorithm.ES384)) {
                return EcdsaParameters.HashType.SHA384;
            }
            if (jwtEcdsaParameters.getAlgorithm().equals(JwtEcdsaParameters.Algorithm.ES512)) {
                return EcdsaParameters.HashType.SHA512;
            }
            throw new GeneralSecurityException("unknown algorithm in parameters: " + jwtEcdsaParameters);
        }

        public JwtEcdsaPublicKey build() throws GeneralSecurityException {
            if (!this.parameters.isPresent()) {
                throw new GeneralSecurityException("Cannot build without parameters");
            }
            if (!this.publicPoint.isPresent()) {
                throw new GeneralSecurityException("Cannot build without public point");
            }
            if (this.parameters.get().hasIdRequirement() && !this.idRequirement.isPresent()) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.parameters.get().hasIdRequirement() && this.idRequirement.isPresent()) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new JwtEcdsaPublicKey(this.parameters.get(), EcdsaPublicKey.builder().setParameters(EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setCurveType(getCurveType(this.parameters.get())).setHashType(getHashType(this.parameters.get())).build()).setPublicPoint(this.publicPoint.get()).build(), computeKid(), this.idRequirement);
        }
    }

    private JwtEcdsaPublicKey(JwtEcdsaParameters jwtEcdsaParameters, EcdsaPublicKey ecdsaPublicKey, Optional<String> optional, Optional<Integer> optional2) {
        this.parameters = jwtEcdsaParameters;
        this.ecdsaPublicKey = ecdsaPublicKey;
        this.kid = optional;
        this.idRequirement = optional2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ECPoint getPublicPoint() {
        return this.ecdsaPublicKey.getPublicPoint();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey
    public Optional<String> getKid() {
        return this.kid;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement.orElse(null);
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey, com.google.crypto.tink.Key
    public JwtEcdsaParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof JwtEcdsaPublicKey)) {
            return false;
        }
        JwtEcdsaPublicKey jwtEcdsaPublicKey = (JwtEcdsaPublicKey) key;
        return jwtEcdsaPublicKey.parameters.equals(this.parameters) && jwtEcdsaPublicKey.ecdsaPublicKey.equalsKey(this.ecdsaPublicKey) && jwtEcdsaPublicKey.kid.equals(this.kid);
    }

    EcdsaPublicKey getEcdsaPublicKey() {
        return this.ecdsaPublicKey;
    }
}
