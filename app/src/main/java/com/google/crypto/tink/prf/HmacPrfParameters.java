package com.google.crypto.tink.prf;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class HmacPrfParameters extends PrfParameters {
    private static final int MIN_KEY_SIZE = 16;
    private final HashType hashType;
    private final int keySizeBytes;

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return false;
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

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Builder {

        @Nullable
        private HashType hashType;

        @Nullable
        private Integer keySizeBytes;

        private Builder() {
            this.keySizeBytes = null;
            this.hashType = null;
        }

        public Builder setKeySizeBytes(int i) throws GeneralSecurityException {
            if (i < 16) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit or larger are supported", Integer.valueOf(i * 8)));
            }
            this.keySizeBytes = Integer.valueOf(i);
            return this;
        }

        public Builder setHashType(HashType hashType) {
            this.hashType = hashType;
            return this;
        }

        public HmacPrfParameters build() throws GeneralSecurityException {
            Integer num = this.keySizeBytes;
            if (num == null) {
                throw new GeneralSecurityException("key size is not set");
            }
            if (this.hashType == null) {
                throw new GeneralSecurityException("hash type is not set");
            }
            return new HmacPrfParameters(num.intValue(), this.hashType);
        }
    }

    private HmacPrfParameters(int i, HashType hashType) {
        this.keySizeBytes = i;
        this.hashType = hashType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public HashType getHashType() {
        return this.hashType;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HmacPrfParameters)) {
            return false;
        }
        HmacPrfParameters hmacPrfParameters = (HmacPrfParameters) obj;
        return hmacPrfParameters.getKeySizeBytes() == getKeySizeBytes() && hmacPrfParameters.getHashType() == getHashType();
    }

    public int hashCode() {
        int i = this.keySizeBytes;
        return Objects.hash(HmacPrfParameters.class, Integer.valueOf(i), this.hashType);
    }

    public String toString() {
        return "HMAC PRF Parameters (hashType: " + this.hashType + " and " + this.keySizeBytes + "-byte key)";
    }
}
