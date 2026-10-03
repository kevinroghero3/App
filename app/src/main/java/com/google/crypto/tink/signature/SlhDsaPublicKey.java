package com.google.crypto.tink.signature;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class SlhDsaPublicKey extends SignaturePublicKey {
    private static final int SLH_DSA_SHA2_128S_PUBLIC_KEY_BYTES = 32;

    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final SlhDsaParameters parameters;
    private final Bytes serializedPublicKey;

    private SlhDsaPublicKey(SlhDsaParameters slhDsaParameters, Bytes bytes, Bytes bytes2, @Nullable Integer num) {
        this.parameters = slhDsaParameters;
        this.serializedPublicKey = bytes;
        this.outputPrefix = bytes2;
        this.idRequirement = num;
    }

    public static class Builder {

        @Nullable
        private Integer idRequirement;

        @Nullable
        private SlhDsaParameters parameters;

        @Nullable
        private Bytes serializedPublicKey;

        private Builder() {
            this.parameters = null;
            this.serializedPublicKey = null;
            this.idRequirement = null;
        }

        public Builder setParameters(SlhDsaParameters slhDsaParameters) {
            this.parameters = slhDsaParameters;
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
            if (this.parameters.getVariant() == SlhDsaParameters.Variant.NO_PREFIX) {
                return OutputPrefixUtil.EMPTY_PREFIX;
            }
            if (this.parameters.getVariant() == SlhDsaParameters.Variant.TINK) {
                return OutputPrefixUtil.getTinkOutputPrefix(this.idRequirement.intValue());
            }
            throw new IllegalStateException("Unknown SlhDsaParameters.Variant: " + this.parameters.getVariant());
        }

        public SlhDsaPublicKey build() throws GeneralSecurityException {
            SlhDsaParameters slhDsaParameters = this.parameters;
            if (slhDsaParameters == null) {
                throw new GeneralSecurityException("Cannot build without parameters");
            }
            if (slhDsaParameters.getVariant() == SlhDsaParameters.Variant.NO_PREFIX && this.idRequirement != null) {
                throw new GeneralSecurityException("IdRequirement must be null for variant NO_PREFIX");
            }
            if (this.parameters.getVariant() == SlhDsaParameters.Variant.TINK && this.idRequirement == null) {
                throw new GeneralSecurityException("Id requirement missing for parameters' variant TINK");
            }
            if (this.serializedPublicKey == null) {
                throw new GeneralSecurityException("Cannot build without public key bytes");
            }
            if (this.parameters.getHashType() != SlhDsaParameters.HashType.SHA2) {
                throw new GeneralSecurityException("Unknown SLH-DSA hash type option " + this.parameters.getHashType() + "; only SHA2 is currently supported");
            }
            if (this.parameters.getPrivateKeySize() != 64) {
                throw new GeneralSecurityException("Unknown SLH-DSA private key size " + this.parameters.getPrivateKeySize() + "; only security level 128 (private key size 64) is currently supported");
            }
            if (this.parameters.getSignatureType() != SlhDsaParameters.SignatureType.SMALL_SIGNATURE) {
                throw new GeneralSecurityException("Unknown SLH-DSA signature type " + this.parameters.getSignatureType() + "; only \"S\" (SMALL_SIGNATURE) is currently supported");
            }
            if (this.serializedPublicKey.size() != 32) {
                throw new GeneralSecurityException("Incorrect public key size for SLH-DSA-SHA2-128S: should be 32, but was " + this.serializedPublicKey.size());
            }
            return new SlhDsaPublicKey(this.parameters, this.serializedPublicKey, getOutputPrefix(), this.idRequirement);
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
    public SlhDsaParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof SlhDsaPublicKey)) {
            return false;
        }
        SlhDsaPublicKey slhDsaPublicKey = (SlhDsaPublicKey) key;
        return slhDsaPublicKey.parameters.equals(this.parameters) && slhDsaPublicKey.serializedPublicKey.equals(this.serializedPublicKey) && Objects.equals(slhDsaPublicKey.idRequirement, this.idRequirement);
    }
}
