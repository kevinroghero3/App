package com.google.crypto.tink.signature;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class MlDsaPublicKey extends SignaturePublicKey {
    private static final int MLDSA65_PUBLIC_KEY_BYTES = 1952;
    private static final int MLDSA87_PUBLIC_KEY_BYTES = 2592;

    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final MlDsaParameters parameters;
    private final Bytes serializedPublicKey;

    private MlDsaPublicKey(MlDsaParameters mlDsaParameters, Bytes bytes, Bytes bytes2, @Nullable Integer num) {
        this.parameters = mlDsaParameters;
        this.serializedPublicKey = bytes;
        this.outputPrefix = bytes2;
        this.idRequirement = num;
    }

    public static class Builder {

        @Nullable
        private Integer idRequirement;

        @Nullable
        private MlDsaParameters parameters;

        @Nullable
        private Bytes serializedPublicKey;

        private Builder() {
            this.parameters = null;
            this.serializedPublicKey = null;
            this.idRequirement = null;
        }

        public Builder setParameters(MlDsaParameters mlDsaParameters) {
            this.parameters = mlDsaParameters;
            return this;
        }

        public Builder setSerializedPublicKey(Bytes bytes) {
            this.serializedPublicKey = bytes;
            return this;
        }

        public Builder setIdRequirement(@Nullable Integer num) {
            this.idRequirement = num;
            return this;
        }

        private Bytes getOutputPrefix() {
            if (this.parameters.getVariant() == MlDsaParameters.Variant.NO_PREFIX) {
                return OutputPrefixUtil.EMPTY_PREFIX;
            }
            if (this.parameters.getVariant() == MlDsaParameters.Variant.TINK) {
                return OutputPrefixUtil.getTinkOutputPrefix(this.idRequirement.intValue());
            }
            throw new IllegalStateException("Unknown MlDsaParameters.Variant: " + this.parameters.getVariant());
        }

        public MlDsaPublicKey build() throws GeneralSecurityException {
            MlDsaParameters mlDsaParameters = this.parameters;
            if (mlDsaParameters == null) {
                throw new GeneralSecurityException("Cannot build without parameters");
            }
            if (mlDsaParameters.getVariant() == MlDsaParameters.Variant.NO_PREFIX && this.idRequirement != null) {
                throw new GeneralSecurityException("Id requirement present for parameters' variant NO_PREFIX");
            }
            if (this.parameters.getVariant() == MlDsaParameters.Variant.TINK && this.idRequirement == null) {
                throw new GeneralSecurityException("Id requirement missing for parameters' variant TINK");
            }
            MlDsaParameters.MlDsaInstance mlDsaInstance = this.parameters.getMlDsaInstance();
            MlDsaParameters.MlDsaInstance mlDsaInstance2 = MlDsaParameters.MlDsaInstance.ML_DSA_65;
            if (mlDsaInstance != mlDsaInstance2 && this.parameters.getMlDsaInstance() != MlDsaParameters.MlDsaInstance.ML_DSA_87) {
                throw new GeneralSecurityException("Unknown ML-DSA instance: " + this.parameters.getMlDsaInstance() + ", only ML-DSA-{65,87} are supported");
            }
            if (this.serializedPublicKey == null) {
                throw new GeneralSecurityException("Cannot build without public key bytes");
            }
            if (this.parameters.getMlDsaInstance() == mlDsaInstance2 && this.serializedPublicKey.size() != MlDsaPublicKey.MLDSA65_PUBLIC_KEY_BYTES) {
                throw new GeneralSecurityException("Incorrect public key size for ML-DSA-65");
            }
            if (this.parameters.getMlDsaInstance() == MlDsaParameters.MlDsaInstance.ML_DSA_87 && this.serializedPublicKey.size() != MlDsaPublicKey.MLDSA87_PUBLIC_KEY_BYTES) {
                throw new GeneralSecurityException("Incorrect public key size for ML-DSA-87");
            }
            return new MlDsaPublicKey(this.parameters, this.serializedPublicKey, getOutputPrefix(), this.idRequirement);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public Bytes getSerializedPublicKey() {
        return this.serializedPublicKey;
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey, com.google.crypto.tink.Key
    public MlDsaParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof MlDsaPublicKey)) {
            return false;
        }
        MlDsaPublicKey mlDsaPublicKey = (MlDsaPublicKey) key;
        return mlDsaPublicKey.parameters.equals(this.parameters) && mlDsaPublicKey.serializedPublicKey.equals(this.serializedPublicKey) && Objects.equals(mlDsaPublicKey.idRequirement, this.idRequirement);
    }
}
