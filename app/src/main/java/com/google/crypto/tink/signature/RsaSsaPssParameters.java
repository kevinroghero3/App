package com.google.crypto.tink.signature;

import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class RsaSsaPssParameters extends SignatureParameters {
    public static final BigInteger F4 = BigInteger.valueOf(65537);
    private final HashType mgf1HashType;
    private final int modulusSizeBits;
    private final BigInteger publicExponent;
    private final int saltLengthBytes;
    private final HashType sigHashType;
    private final Variant variant;

    @Immutable
    public static final class Variant {
        private final String name;
        public static final Variant TINK = new Variant("TINK");
        public static final Variant CRUNCHY = new Variant("CRUNCHY");
        public static final Variant LEGACY = new Variant("LEGACY");
        public static final Variant NO_PREFIX = new Variant("NO_PREFIX");

        private Variant(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    @Immutable
    public static final class HashType {
        public static final HashType SHA256 = new HashType("SHA256");
        public static final HashType SHA384 = new HashType("SHA384");
        public static final HashType SHA512 = new HashType("SHA512");
        private final String name;

        private HashType(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Builder {
        private static final int MIN_RSA_MODULUS_SIZE = 2048;
        private static final BigInteger PUBLIC_EXPONENT_UPPER_BOUND;
        private static final BigInteger TWO;

        @Nullable
        private HashType mgf1HashType;

        @Nullable
        private Integer modulusSizeBits;

        @Nullable
        private BigInteger publicExponent;

        @Nullable
        private Integer saltLengthBytes;

        @Nullable
        private HashType sigHashType;
        private Variant variant;

        private Builder() {
            this.modulusSizeBits = null;
            this.publicExponent = RsaSsaPssParameters.F4;
            this.sigHashType = null;
            this.mgf1HashType = null;
            this.saltLengthBytes = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setModulusSizeBits(int i) {
            this.modulusSizeBits = Integer.valueOf(i);
            return this;
        }

        public Builder setPublicExponent(BigInteger bigInteger) {
            this.publicExponent = bigInteger;
            return this;
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public Builder setSigHashType(HashType hashType) {
            this.sigHashType = hashType;
            return this;
        }

        public Builder setMgf1HashType(HashType hashType) {
            this.mgf1HashType = hashType;
            return this;
        }

        public Builder setSaltLengthBytes(int i) throws GeneralSecurityException {
            if (i < 0) {
                throw new GeneralSecurityException(String.format("Invalid salt length in bytes %d; salt length must be positive", Integer.valueOf(i)));
            }
            this.saltLengthBytes = Integer.valueOf(i);
            return this;
        }

        static {
            BigInteger bigIntegerValueOf = BigInteger.valueOf(2L);
            TWO = bigIntegerValueOf;
            PUBLIC_EXPONENT_UPPER_BOUND = bigIntegerValueOf.pow(256);
        }

        private void validatePublicExponent(BigInteger bigInteger) throws InvalidAlgorithmParameterException {
            int iCompareTo = bigInteger.compareTo(RsaSsaPssParameters.F4);
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

        public RsaSsaPssParameters build() throws GeneralSecurityException {
            Integer num = this.modulusSizeBits;
            if (num == null) {
                throw new GeneralSecurityException("key size is not set");
            }
            if (this.publicExponent == null) {
                throw new GeneralSecurityException("publicExponent is not set");
            }
            if (this.sigHashType == null) {
                throw new GeneralSecurityException("signature hash type is not set");
            }
            if (this.mgf1HashType == null) {
                throw new GeneralSecurityException("mgf1 hash type is not set");
            }
            if (this.variant == null) {
                throw new GeneralSecurityException("variant is not set");
            }
            if (this.saltLengthBytes == null) {
                throw new GeneralSecurityException("salt length is not set");
            }
            if (num.intValue() < 2048) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least %d bits", this.modulusSizeBits, 2048));
            }
            if (this.sigHashType != this.mgf1HashType) {
                throw new GeneralSecurityException("MGF1 hash is different from signature hash");
            }
            validatePublicExponent(this.publicExponent);
            return new RsaSsaPssParameters(this.modulusSizeBits.intValue(), this.publicExponent, this.variant, this.sigHashType, this.mgf1HashType, this.saltLengthBytes.intValue());
        }
    }

    private RsaSsaPssParameters(int i, BigInteger bigInteger, Variant variant, HashType hashType, HashType hashType2, int i2) {
        this.modulusSizeBits = i;
        this.publicExponent = bigInteger;
        this.variant = variant;
        this.sigHashType = hashType;
        this.mgf1HashType = hashType2;
        this.saltLengthBytes = i2;
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

    public Variant getVariant() {
        return this.variant;
    }

    public HashType getSigHashType() {
        return this.sigHashType;
    }

    public HashType getMgf1HashType() {
        return this.mgf1HashType;
    }

    public int getSaltLengthBytes() {
        return this.saltLengthBytes;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RsaSsaPssParameters)) {
            return false;
        }
        RsaSsaPssParameters rsaSsaPssParameters = (RsaSsaPssParameters) obj;
        return rsaSsaPssParameters.getModulusSizeBits() == getModulusSizeBits() && Objects.equals(rsaSsaPssParameters.getPublicExponent(), getPublicExponent()) && Objects.equals(rsaSsaPssParameters.getVariant(), getVariant()) && Objects.equals(rsaSsaPssParameters.getSigHashType(), getSigHashType()) && Objects.equals(rsaSsaPssParameters.getMgf1HashType(), getMgf1HashType()) && rsaSsaPssParameters.getSaltLengthBytes() == getSaltLengthBytes();
    }

    public int hashCode() {
        int i = this.modulusSizeBits;
        return Objects.hash(RsaSsaPssParameters.class, Integer.valueOf(i), this.publicExponent, this.variant, this.sigHashType, this.mgf1HashType, Integer.valueOf(this.saltLengthBytes));
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public String toString() {
        return "RSA SSA PSS Parameters (variant: " + this.variant + ", signature hashType: " + this.sigHashType + ", mgf1 hashType: " + this.mgf1HashType + ", saltLengthBytes: " + this.saltLengthBytes + ", publicExponent: " + this.publicExponent + ", and " + this.modulusSizeBits + "-bit modulus)";
    }
}
