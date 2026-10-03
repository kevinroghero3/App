package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtRsaSsaPssParameters extends JwtSignatureParameters {
    public static final BigInteger F4 = BigInteger.valueOf(65537);
    private final Algorithm algorithm;
    private final KidStrategy kidStrategy;
    private final int modulusSizeBits;
    private final BigInteger publicExponent;

    @Immutable
    public static final class KidStrategy {
        private final String name;
        public static final KidStrategy BASE64_ENCODED_KEY_ID = new KidStrategy("BASE64_ENCODED_KEY_ID");
        public static final KidStrategy IGNORED = new KidStrategy("IGNORED");
        public static final KidStrategy CUSTOM = new KidStrategy("CUSTOM");

        private KidStrategy(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    @Immutable
    public static final class Algorithm {
        public static final Algorithm PS256 = new Algorithm("PS256");
        public static final Algorithm PS384 = new Algorithm("PS384");
        public static final Algorithm PS512 = new Algorithm("PS512");
        private final String name;

        private Algorithm(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }

        public String getStandardName() {
            return this.name;
        }
    }

    public static final class Builder {
        private static final BigInteger PUBLIC_EXPONENT_UPPER_BOUND;
        private static final BigInteger TWO;
        Optional<Algorithm> algorithm;
        Optional<KidStrategy> kidStrategy;
        Optional<Integer> modulusSizeBits;
        Optional<BigInteger> publicExponent;

        private Builder() {
            this.modulusSizeBits = Optional.empty();
            this.publicExponent = Optional.of(JwtRsaSsaPssParameters.F4);
            this.kidStrategy = Optional.empty();
            this.algorithm = Optional.empty();
        }

        public Builder setModulusSizeBits(int i) {
            this.modulusSizeBits = Optional.of(Integer.valueOf(i));
            return this;
        }

        public Builder setPublicExponent(BigInteger bigInteger) {
            this.publicExponent = Optional.of(bigInteger);
            return this;
        }

        public Builder setKidStrategy(KidStrategy kidStrategy) {
            this.kidStrategy = Optional.of(kidStrategy);
            return this;
        }

        public Builder setAlgorithm(Algorithm algorithm) {
            this.algorithm = Optional.of(algorithm);
            return this;
        }

        static {
            BigInteger bigIntegerValueOf = BigInteger.valueOf(2L);
            TWO = bigIntegerValueOf;
            PUBLIC_EXPONENT_UPPER_BOUND = bigIntegerValueOf.pow(256);
        }

        private void validatePublicExponent(BigInteger bigInteger) throws InvalidAlgorithmParameterException {
            int iCompareTo = bigInteger.compareTo(JwtRsaSsaPssParameters.F4);
            if (iCompareTo == 0) {
                return;
            }
            if (iCompareTo < 0) {
                throw new InvalidAlgorithmParameterException("Public exponent must be at least 65537.");
            }
            if (bigInteger.mod(TWO).equals(BigInteger.ZERO)) {
                throw new InvalidAlgorithmParameterException("Invalid public exponent");
            }
            if (bigInteger.compareTo(PUBLIC_EXPONENT_UPPER_BOUND) > 0) {
                throw new InvalidAlgorithmParameterException("Public exponent cannot be larger than 2^256.");
            }
        }

        public JwtRsaSsaPssParameters build() throws GeneralSecurityException {
            if (!this.modulusSizeBits.isPresent()) {
                throw new GeneralSecurityException("key size is not set");
            }
            if (!this.publicExponent.isPresent()) {
                throw new GeneralSecurityException("publicExponent is not set");
            }
            if (!this.algorithm.isPresent()) {
                throw new GeneralSecurityException("Algorithm must be set");
            }
            if (!this.kidStrategy.isPresent()) {
                throw new GeneralSecurityException("KidStrategy must be set");
            }
            if (this.modulusSizeBits.get().intValue() < 2048) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid modulus size in bits %d; must be at least 2048 bits", this.modulusSizeBits.get()));
            }
            validatePublicExponent(this.publicExponent.get());
            return new JwtRsaSsaPssParameters(this.modulusSizeBits.get().intValue(), this.publicExponent.get(), this.kidStrategy.get(), this.algorithm.get());
        }
    }

    private JwtRsaSsaPssParameters(int i, BigInteger bigInteger, KidStrategy kidStrategy, Algorithm algorithm) {
        this.modulusSizeBits = i;
        this.publicExponent = bigInteger;
        this.kidStrategy = kidStrategy;
        this.algorithm = algorithm;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getModulusSizeBits() {
        return this.modulusSizeBits;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public KidStrategy getKidStrategy() {
        return this.kidStrategy;
    }

    public Algorithm getAlgorithm() {
        return this.algorithm;
    }

    @Override // com.google.crypto.tink.jwt.JwtSignatureParameters
    public boolean allowKidAbsent() {
        return this.kidStrategy.equals(KidStrategy.CUSTOM) || this.kidStrategy.equals(KidStrategy.IGNORED);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JwtRsaSsaPssParameters)) {
            return false;
        }
        JwtRsaSsaPssParameters jwtRsaSsaPssParameters = (JwtRsaSsaPssParameters) obj;
        return jwtRsaSsaPssParameters.getModulusSizeBits() == getModulusSizeBits() && Objects.equals(jwtRsaSsaPssParameters.getPublicExponent(), getPublicExponent()) && jwtRsaSsaPssParameters.kidStrategy.equals(this.kidStrategy) && jwtRsaSsaPssParameters.algorithm.equals(this.algorithm);
    }

    public int hashCode() {
        int i = this.modulusSizeBits;
        return Objects.hash(JwtRsaSsaPssParameters.class, Integer.valueOf(i), this.publicExponent, this.kidStrategy, this.algorithm);
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.kidStrategy.equals(KidStrategy.BASE64_ENCODED_KEY_ID);
    }

    public String toString() {
        return "JWT RSA SSA PSS Parameters (kidStrategy: " + this.kidStrategy + ", algorithm " + this.algorithm + ", publicExponent: " + this.publicExponent + ", and " + this.modulusSizeBits + "-bit modulus)";
    }
}
