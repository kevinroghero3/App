package com.google.crypto.tink.hybrid;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class HpkeParameters extends HybridParameters {
    private final AeadId aead;
    private final KdfId kdf;
    private final KemId kem;
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
    static class AlgorithmIdentifier {
        protected final String name;
        protected final int value;

        private AlgorithmIdentifier(String str, int i) {
            this.name = str;
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public String toString() {
            return String.format("%s(0x%04x)", this.name, Integer.valueOf(this.value));
        }
    }

    @Immutable
    public static final class KemId extends AlgorithmIdentifier {
        public static final KemId DHKEM_P256_HKDF_SHA256 = new KemId("DHKEM_P256_HKDF_SHA256", 16);
        public static final KemId DHKEM_P384_HKDF_SHA384 = new KemId("DHKEM_P384_HKDF_SHA384", 17);
        public static final KemId DHKEM_P521_HKDF_SHA512 = new KemId("DHKEM_P521_HKDF_SHA512", 18);
        public static final KemId DHKEM_X25519_HKDF_SHA256 = new KemId("DHKEM_X25519_HKDF_SHA256", 32);

        @Override // com.google.crypto.tink.hybrid.HpkeParameters.AlgorithmIdentifier
        public /* bridge */ /* synthetic */ int getValue() {
            return super.getValue();
        }

        @Override // com.google.crypto.tink.hybrid.HpkeParameters.AlgorithmIdentifier
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        private KemId(String str, int i) {
            super(str, i);
        }
    }

    @Immutable
    public static final class KdfId extends AlgorithmIdentifier {
        public static final KdfId HKDF_SHA256 = new KdfId("HKDF_SHA256", 1);
        public static final KdfId HKDF_SHA384 = new KdfId("HKDF_SHA384", 2);
        public static final KdfId HKDF_SHA512 = new KdfId("HKDF_SHA512", 3);

        @Override // com.google.crypto.tink.hybrid.HpkeParameters.AlgorithmIdentifier
        public /* bridge */ /* synthetic */ int getValue() {
            return super.getValue();
        }

        @Override // com.google.crypto.tink.hybrid.HpkeParameters.AlgorithmIdentifier
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        private KdfId(String str, int i) {
            super(str, i);
        }
    }

    @Immutable
    public static final class AeadId extends AlgorithmIdentifier {
        public static final AeadId AES_128_GCM = new AeadId("AES_128_GCM", 1);
        public static final AeadId AES_256_GCM = new AeadId("AES_256_GCM", 2);
        public static final AeadId CHACHA20_POLY1305 = new AeadId("CHACHA20_POLY1305", 3);

        @Override // com.google.crypto.tink.hybrid.HpkeParameters.AlgorithmIdentifier
        public /* bridge */ /* synthetic */ int getValue() {
            return super.getValue();
        }

        @Override // com.google.crypto.tink.hybrid.HpkeParameters.AlgorithmIdentifier
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        private AeadId(String str, int i) {
            super(str, i);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Builder {
        private AeadId aead;
        private KdfId kdf;
        private KemId kem;
        private Variant variant;

        private Builder() {
            this.kem = null;
            this.kdf = null;
            this.aead = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setKemId(KemId kemId) {
            this.kem = kemId;
            return this;
        }

        public Builder setKdfId(KdfId kdfId) {
            this.kdf = kdfId;
            return this;
        }

        public Builder setAeadId(AeadId aeadId) {
            this.aead = aeadId;
            return this;
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public HpkeParameters build() throws GeneralSecurityException {
            KemId kemId = this.kem;
            if (kemId == null) {
                throw new GeneralSecurityException("HPKE KEM parameter is not set");
            }
            KdfId kdfId = this.kdf;
            if (kdfId == null) {
                throw new GeneralSecurityException("HPKE KDF parameter is not set");
            }
            AeadId aeadId = this.aead;
            if (aeadId == null) {
                throw new GeneralSecurityException("HPKE AEAD parameter is not set");
            }
            Variant variant = this.variant;
            if (variant == null) {
                throw new GeneralSecurityException("HPKE variant is not set");
            }
            return new HpkeParameters(kemId, kdfId, aeadId, variant);
        }
    }

    private HpkeParameters(KemId kemId, KdfId kdfId, AeadId aeadId, Variant variant) {
        this.kem = kemId;
        this.kdf = kdfId;
        this.aead = aeadId;
        this.variant = variant;
    }

    public static Builder builder() {
        return new Builder();
    }

    public KemId getKemId() {
        return this.kem;
    }

    public KdfId getKdfId() {
        return this.kdf;
    }

    public AeadId getAeadId() {
        return this.aead;
    }

    public Variant getVariant() {
        return this.variant;
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HpkeParameters)) {
            return false;
        }
        HpkeParameters hpkeParameters = (HpkeParameters) obj;
        return this.kem == hpkeParameters.kem && this.kdf == hpkeParameters.kdf && this.aead == hpkeParameters.aead && this.variant == hpkeParameters.variant;
    }

    public int hashCode() {
        return Objects.hash(HpkeParameters.class, this.kem, this.kdf, this.aead, this.variant);
    }

    public String toString() {
        return "HPKE Parameters (Variant: " + this.variant + ", KemId: " + this.kem + ", KdfId: " + this.kdf + ", AeadId: " + this.aead + ")";
    }
}
