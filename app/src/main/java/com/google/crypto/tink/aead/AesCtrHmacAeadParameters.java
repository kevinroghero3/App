package com.google.crypto.tink.aead;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AesCtrHmacAeadParameters extends AeadParameters {
    private static final int PREFIX_SIZE_IN_BYTES = 5;
    private final int aesKeySizeBytes;
    private final HashType hashType;
    private final int hmacKeySizeBytes;
    private final int ivSizeBytes;
    private final int tagSizeBytes;
    private final Variant variant;

    @Immutable
    public static final class Variant {
        private final String name;
        public static final Variant TINK = new Variant("TINK");
        public static final Variant CRUNCHY = new Variant("CRUNCHY");
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
        public static final HashType SHA1 = new HashType("SHA1");
        public static final HashType SHA224 = new HashType("SHA224");
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

    public static final class Builder {

        @Nullable
        private Integer aesKeySizeBytes;
        private HashType hashType;

        @Nullable
        private Integer hmacKeySizeBytes;

        @Nullable
        private Integer ivSizeBytes;

        @Nullable
        private Integer tagSizeBytes;
        private Variant variant;

        private Builder() {
            this.aesKeySizeBytes = null;
            this.hmacKeySizeBytes = null;
            this.ivSizeBytes = null;
            this.tagSizeBytes = null;
            this.hashType = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setAesKeySizeBytes(int i) throws GeneralSecurityException {
            if (i != 16 && i != 24 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
            }
            this.aesKeySizeBytes = Integer.valueOf(i);
            return this;
        }

        public Builder setHmacKeySizeBytes(int i) throws GeneralSecurityException {
            if (i < 16) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", Integer.valueOf(i)));
            }
            this.hmacKeySizeBytes = Integer.valueOf(i);
            return this;
        }

        public Builder setIvSizeBytes(int i) throws GeneralSecurityException {
            if (i < 12 || i > 16) {
                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", Integer.valueOf(i)));
            }
            this.ivSizeBytes = Integer.valueOf(i);
            return this;
        }

        public Builder setTagSizeBytes(int i) throws GeneralSecurityException {
            if (i < 10) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(i)));
            }
            this.tagSizeBytes = Integer.valueOf(i);
            return this;
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public Builder setHashType(HashType hashType) {
            this.hashType = hashType;
            return this;
        }

        private static void validateTagSizeBytes(int i, HashType hashType) throws GeneralSecurityException {
            if (hashType == HashType.SHA1) {
                if (i > 20) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", Integer.valueOf(i)));
                }
                return;
            }
            if (hashType == HashType.SHA224) {
                if (i > 28) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", Integer.valueOf(i)));
                }
                return;
            }
            if (hashType == HashType.SHA256) {
                if (i > 32) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", Integer.valueOf(i)));
                }
            } else if (hashType == HashType.SHA384) {
                if (i > 48) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", Integer.valueOf(i)));
                }
            } else {
                if (hashType != HashType.SHA512) {
                    throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
                }
                if (i > 64) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", Integer.valueOf(i)));
                }
            }
        }

        public AesCtrHmacAeadParameters build() throws GeneralSecurityException {
            if (this.aesKeySizeBytes == null) {
                throw new GeneralSecurityException("AES key size is not set");
            }
            if (this.hmacKeySizeBytes == null) {
                throw new GeneralSecurityException("HMAC key size is not set");
            }
            if (this.ivSizeBytes == null) {
                throw new GeneralSecurityException("iv size is not set");
            }
            Integer num = this.tagSizeBytes;
            if (num == null) {
                throw new GeneralSecurityException("tag size is not set");
            }
            if (this.hashType == null) {
                throw new GeneralSecurityException("hash type is not set");
            }
            if (this.variant == null) {
                throw new GeneralSecurityException("variant is not set");
            }
            validateTagSizeBytes(num.intValue(), this.hashType);
            return new AesCtrHmacAeadParameters(this.aesKeySizeBytes.intValue(), this.hmacKeySizeBytes.intValue(), this.ivSizeBytes.intValue(), this.tagSizeBytes.intValue(), this.variant, this.hashType);
        }
    }

    private AesCtrHmacAeadParameters(int i, int i2, int i3, int i4, Variant variant, HashType hashType) {
        this.aesKeySizeBytes = i;
        this.hmacKeySizeBytes = i2;
        this.ivSizeBytes = i3;
        this.tagSizeBytes = i4;
        this.variant = variant;
        this.hashType = hashType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getAesKeySizeBytes() {
        return this.aesKeySizeBytes;
    }

    public int getHmacKeySizeBytes() {
        return this.hmacKeySizeBytes;
    }

    public int getTagSizeBytes() {
        return this.tagSizeBytes;
    }

    public int getIvSizeBytes() {
        return this.ivSizeBytes;
    }

    public int getCiphertextOverheadSizeBytes() {
        Variant variant = this.variant;
        if (variant == Variant.NO_PREFIX) {
            return getTagSizeBytes() + getIvSizeBytes();
        }
        if (variant == Variant.TINK || variant == Variant.CRUNCHY) {
            return getTagSizeBytes() + getIvSizeBytes() + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public Variant getVariant() {
        return this.variant;
    }

    public HashType getHashType() {
        return this.hashType;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AesCtrHmacAeadParameters)) {
            return false;
        }
        AesCtrHmacAeadParameters aesCtrHmacAeadParameters = (AesCtrHmacAeadParameters) obj;
        return aesCtrHmacAeadParameters.getAesKeySizeBytes() == getAesKeySizeBytes() && aesCtrHmacAeadParameters.getHmacKeySizeBytes() == getHmacKeySizeBytes() && aesCtrHmacAeadParameters.getIvSizeBytes() == getIvSizeBytes() && aesCtrHmacAeadParameters.getTagSizeBytes() == getTagSizeBytes() && aesCtrHmacAeadParameters.getVariant() == getVariant() && aesCtrHmacAeadParameters.getHashType() == getHashType();
    }

    public int hashCode() {
        int i = this.aesKeySizeBytes;
        int i2 = this.hmacKeySizeBytes;
        int i3 = this.ivSizeBytes;
        int i4 = this.tagSizeBytes;
        return Objects.hash(AesCtrHmacAeadParameters.class, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), this.variant, this.hashType);
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public String toString() {
        return "AesCtrHmacAead Parameters (variant: " + this.variant + ", hashType: " + this.hashType + ", " + this.ivSizeBytes + "-byte IV, and " + this.tagSizeBytes + "-byte tags, and " + this.aesKeySizeBytes + "-byte AES key, and " + this.hmacKeySizeBytes + "-byte HMAC key)";
    }
}
