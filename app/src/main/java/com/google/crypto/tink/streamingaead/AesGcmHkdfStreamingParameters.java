package com.google.crypto.tink.streamingaead;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class AesGcmHkdfStreamingParameters extends StreamingAeadParameters {
    private final Integer ciphertextSegmentSizeBytes;
    private final Integer derivedAesGcmKeySizeBytes;
    private final HashType hkdfHashType;
    private final Integer keySizeBytes;

    @Immutable
    public static final class HashType {
        public static final HashType SHA1 = new HashType("SHA1");
        public static final HashType SHA256 = new HashType("SHA256");
        public static final HashType SHA512 = new HashType("SHA512");
        private final String name;

        private HashType(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Builder {

        @Nullable
        private Integer keySizeBytes = null;

        @Nullable
        private Integer derivedAesGcmKeySizeBytes = null;

        @Nullable
        private HashType hkdfHashType = null;

        @Nullable
        private Integer ciphertextSegmentSizeBytes = null;

        public Builder setKeySizeBytes(int i) {
            this.keySizeBytes = Integer.valueOf(i);
            return this;
        }

        public Builder setDerivedAesGcmKeySizeBytes(int i) {
            this.derivedAesGcmKeySizeBytes = Integer.valueOf(i);
            return this;
        }

        public Builder setHkdfHashType(HashType hashType) {
            this.hkdfHashType = hashType;
            return this;
        }

        public Builder setCiphertextSegmentSizeBytes(int i) {
            this.ciphertextSegmentSizeBytes = Integer.valueOf(i);
            return this;
        }

        public AesGcmHkdfStreamingParameters build() throws GeneralSecurityException {
            if (this.keySizeBytes == null) {
                throw new GeneralSecurityException("keySizeBytes needs to be set");
            }
            Integer num = this.derivedAesGcmKeySizeBytes;
            if (num == null) {
                throw new GeneralSecurityException("derivedAesGcmKeySizeBytes needs to be set");
            }
            if (this.hkdfHashType == null) {
                throw new GeneralSecurityException("hkdfHashType needs to be set");
            }
            if (this.ciphertextSegmentSizeBytes == null) {
                throw new GeneralSecurityException("ciphertextSegmentSizeBytes needs to be set");
            }
            if (num.intValue() != 16 && this.derivedAesGcmKeySizeBytes.intValue() != 32) {
                throw new GeneralSecurityException("derivedAesGcmKeySizeBytes needs to be 16 or 32, not " + this.derivedAesGcmKeySizeBytes);
            }
            if (this.keySizeBytes.intValue() < this.derivedAesGcmKeySizeBytes.intValue()) {
                throw new GeneralSecurityException("keySizeBytes needs to be at least derivedAesGcmKeySizeBytes, i.e., " + this.derivedAesGcmKeySizeBytes);
            }
            if (this.ciphertextSegmentSizeBytes.intValue() <= this.derivedAesGcmKeySizeBytes.intValue() + 24) {
                throw new GeneralSecurityException("ciphertextSegmentSizeBytes needs to be at least derivedAesGcmKeySizeBytes + 25, i.e., " + (this.derivedAesGcmKeySizeBytes.intValue() + 25));
            }
            return new AesGcmHkdfStreamingParameters(this.keySizeBytes, this.derivedAesGcmKeySizeBytes, this.hkdfHashType, this.ciphertextSegmentSizeBytes);
        }
    }

    private AesGcmHkdfStreamingParameters(Integer num, Integer num2, HashType hashType, Integer num3) {
        this.keySizeBytes = num;
        this.derivedAesGcmKeySizeBytes = num2;
        this.hkdfHashType = hashType;
        this.ciphertextSegmentSizeBytes = num3;
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes.intValue();
    }

    public int getDerivedAesGcmKeySizeBytes() {
        return this.derivedAesGcmKeySizeBytes.intValue();
    }

    public HashType getHkdfHashType() {
        return this.hkdfHashType;
    }

    public int getCiphertextSegmentSizeBytes() {
        return this.ciphertextSegmentSizeBytes.intValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AesGcmHkdfStreamingParameters)) {
            return false;
        }
        AesGcmHkdfStreamingParameters aesGcmHkdfStreamingParameters = (AesGcmHkdfStreamingParameters) obj;
        return aesGcmHkdfStreamingParameters.getKeySizeBytes() == getKeySizeBytes() && aesGcmHkdfStreamingParameters.getDerivedAesGcmKeySizeBytes() == getDerivedAesGcmKeySizeBytes() && aesGcmHkdfStreamingParameters.getHkdfHashType() == getHkdfHashType() && aesGcmHkdfStreamingParameters.getCiphertextSegmentSizeBytes() == getCiphertextSegmentSizeBytes();
    }

    public int hashCode() {
        return Objects.hash(AesGcmHkdfStreamingParameters.class, this.keySizeBytes, this.derivedAesGcmKeySizeBytes, this.hkdfHashType, this.ciphertextSegmentSizeBytes);
    }

    public String toString() {
        return "AesGcmHkdfStreaming Parameters (IKM size: " + this.keySizeBytes + ", " + this.derivedAesGcmKeySizeBytes + "-byte AES GCM key, " + this.hkdfHashType + " for HKDF " + this.ciphertextSegmentSizeBytes + "-byte ciphertexts)";
    }
}
