package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.aead.AesCtrHmacAeadParameters;
import com.google.crypto.tink.aead.AesGcmParameters;
import com.google.crypto.tink.aead.XChaCha20Poly1305Parameters;
import com.google.crypto.tink.daead.AesSivParameters;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class EciesParameters extends HybridParameters {
    private static final Set<Parameters> acceptedDemParameters = (Set) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.hybrid.EciesParameters$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return EciesParameters.listAcceptedDemParameters();
        }
    });
    private final CurveType curveType;
    private final Parameters demParameters;
    private final HashType hashType;

    @Nullable
    private final PointFormat nistCurvePointFormat;

    @Nullable
    private final Bytes salt;
    private final Variant variant;

    /* JADX INFO: Access modifiers changed from: private */
    public static Set<Parameters> listAcceptedDemParameters() throws GeneralSecurityException {
        HashSet hashSet = new HashSet();
        AesGcmParameters.Builder tagSizeBytes = AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16);
        AesGcmParameters.Variant variant = AesGcmParameters.Variant.NO_PREFIX;
        hashSet.add(tagSizeBytes.setVariant(variant).build());
        hashSet.add(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(variant).build());
        AesCtrHmacAeadParameters.Builder ivSizeBytes = AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(16).setHmacKeySizeBytes(32).setTagSizeBytes(16).setIvSizeBytes(16);
        AesCtrHmacAeadParameters.HashType hashType = AesCtrHmacAeadParameters.HashType.SHA256;
        AesCtrHmacAeadParameters.Builder hashType2 = ivSizeBytes.setHashType(hashType);
        AesCtrHmacAeadParameters.Variant variant2 = AesCtrHmacAeadParameters.Variant.NO_PREFIX;
        hashSet.add(hashType2.setVariant(variant2).build());
        hashSet.add(AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(32).setHmacKeySizeBytes(32).setTagSizeBytes(32).setIvSizeBytes(16).setHashType(hashType).setVariant(variant2).build());
        hashSet.add(XChaCha20Poly1305Parameters.create());
        hashSet.add(AesSivParameters.builder().setKeySizeBytes(64).setVariant(AesSivParameters.Variant.NO_PREFIX).build());
        return Collections.unmodifiableSet(hashSet);
    }

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
    public static final class CurveType {
        public static final CurveType NIST_P256 = new CurveType("NIST_P256");
        public static final CurveType NIST_P384 = new CurveType("NIST_P384");
        public static final CurveType NIST_P521 = new CurveType("NIST_P521");
        public static final CurveType X25519 = new CurveType("X25519");
        private final String name;

        private CurveType(String str) {
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

    @Immutable
    public static final class PointFormat {
        private final String name;
        public static final PointFormat COMPRESSED = new PointFormat("COMPRESSED");
        public static final PointFormat UNCOMPRESSED = new PointFormat("UNCOMPRESSED");
        public static final PointFormat LEGACY_UNCOMPRESSED = new PointFormat("LEGACY_UNCOMPRESSED");

        private PointFormat(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Builder {
        private CurveType curveType;
        private Parameters demParameters;
        private HashType hashType;
        private PointFormat nistCurvePointFormat;

        @Nullable
        private Bytes salt;
        private Variant variant;

        private Builder() {
            this.curveType = null;
            this.hashType = null;
            this.nistCurvePointFormat = null;
            this.demParameters = null;
            this.variant = Variant.NO_PREFIX;
            this.salt = null;
        }

        public Builder setCurveType(CurveType curveType) {
            this.curveType = curveType;
            return this;
        }

        public Builder setHashType(HashType hashType) {
            this.hashType = hashType;
            return this;
        }

        public Builder setNistCurvePointFormat(PointFormat pointFormat) {
            this.nistCurvePointFormat = pointFormat;
            return this;
        }

        public Builder setDemParameters(Parameters parameters) throws GeneralSecurityException {
            if (!EciesParameters.acceptedDemParameters.contains(parameters)) {
                throw new GeneralSecurityException("Invalid DEM parameters " + parameters + "; only AES128_GCM_RAW, AES256_GCM_RAW, AES128_CTR_HMAC_SHA256_RAW, AES256_CTR_HMAC_SHA256_RAW XCHACHA20_POLY1305_RAW and AES256_SIV_RAW are currently supported.");
            }
            this.demParameters = parameters;
            return this;
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public Builder setSalt(Bytes bytes) {
            if (bytes.size() == 0) {
                this.salt = null;
                return this;
            }
            this.salt = bytes;
            return this;
        }

        public EciesParameters build() throws GeneralSecurityException {
            CurveType curveType = this.curveType;
            if (curveType == null) {
                throw new GeneralSecurityException("Elliptic curve type is not set");
            }
            if (this.hashType == null) {
                throw new GeneralSecurityException("Hash type is not set");
            }
            if (this.demParameters == null) {
                throw new GeneralSecurityException("DEM parameters are not set");
            }
            if (this.variant == null) {
                throw new GeneralSecurityException("Variant is not set");
            }
            CurveType curveType2 = CurveType.X25519;
            if (curveType != curveType2 && this.nistCurvePointFormat == null) {
                throw new GeneralSecurityException("Point format is not set");
            }
            if (curveType == curveType2 && this.nistCurvePointFormat != null) {
                throw new GeneralSecurityException("For Curve25519 point format must not be set");
            }
            return new EciesParameters(this.curveType, this.hashType, this.nistCurvePointFormat, this.demParameters, this.variant, this.salt);
        }
    }

    private EciesParameters(CurveType curveType, HashType hashType, @Nullable PointFormat pointFormat, Parameters parameters, Variant variant, Bytes bytes) {
        this.curveType = curveType;
        this.hashType = hashType;
        this.nistCurvePointFormat = pointFormat;
        this.demParameters = parameters;
        this.variant = variant;
        this.salt = bytes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public CurveType getCurveType() {
        return this.curveType;
    }

    public HashType getHashType() {
        return this.hashType;
    }

    @Nullable
    public PointFormat getNistCurvePointFormat() {
        return this.nistCurvePointFormat;
    }

    public Parameters getDemParameters() {
        return this.demParameters;
    }

    public Variant getVariant() {
        return this.variant;
    }

    @Nullable
    public Bytes getSalt() {
        return this.salt;
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EciesParameters)) {
            return false;
        }
        EciesParameters eciesParameters = (EciesParameters) obj;
        return Objects.equals(eciesParameters.getCurveType(), getCurveType()) && Objects.equals(eciesParameters.getHashType(), getHashType()) && Objects.equals(eciesParameters.getNistCurvePointFormat(), getNistCurvePointFormat()) && Objects.equals(eciesParameters.getDemParameters(), getDemParameters()) && Objects.equals(eciesParameters.getVariant(), getVariant()) && Objects.equals(eciesParameters.getSalt(), getSalt());
    }

    public int hashCode() {
        return Objects.hash(EciesParameters.class, this.curveType, this.hashType, this.nistCurvePointFormat, this.demParameters, this.variant, this.salt);
    }

    public String toString() {
        return String.format("EciesParameters(curveType=%s, hashType=%s, pointFormat=%s, demParameters=%s, variant=%s, salt=%s)", this.curveType, this.hashType, this.nistCurvePointFormat, this.demParameters, this.variant, this.salt);
    }
}
