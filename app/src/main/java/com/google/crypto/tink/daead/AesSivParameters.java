package com.google.crypto.tink.daead;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AesSivParameters extends DeterministicAeadParameters {
    private final int keySizeBytes;
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

    public static final class Builder {

        @Nullable
        private Integer keySizeBytes;
        private Variant variant;

        private Builder() {
            this.keySizeBytes = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setKeySizeBytes(int i) throws GeneralSecurityException {
            if (i != 32 && i != 48 && i != 64) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 32-byte, 48-byte and 64-byte AES-SIV keys are supported", Integer.valueOf(i)));
            }
            this.keySizeBytes = Integer.valueOf(i);
            return this;
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public AesSivParameters build() throws GeneralSecurityException {
            Integer num = this.keySizeBytes;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            }
            if (this.variant == null) {
                throw new GeneralSecurityException("Variant is not set");
            }
            return new AesSivParameters(num.intValue(), this.variant);
        }
    }

    private AesSivParameters(int i, Variant variant) {
        this.keySizeBytes = i;
        this.variant = variant;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public Variant getVariant() {
        return this.variant;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AesSivParameters)) {
            return false;
        }
        AesSivParameters aesSivParameters = (AesSivParameters) obj;
        return aesSivParameters.getKeySizeBytes() == getKeySizeBytes() && aesSivParameters.getVariant() == getVariant();
    }

    public int hashCode() {
        int i = this.keySizeBytes;
        return Objects.hash(AesSivParameters.class, Integer.valueOf(i), this.variant);
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public String toString() {
        return "AesSiv Parameters (variant: " + this.variant + ", " + this.keySizeBytes + "-byte key)";
    }
}
