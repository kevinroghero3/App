package com.google.crypto.tink.prf;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class HkdfPrfKey extends PrfKey {
    private final SecretBytes keyBytes;
    private final HkdfPrfParameters parameters;

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return null;
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Builder {

        @Nullable
        private SecretBytes keyBytes;

        @Nullable
        private HkdfPrfParameters parameters;

        private Builder() {
            this.parameters = null;
            this.keyBytes = null;
        }

        public Builder setParameters(HkdfPrfParameters hkdfPrfParameters) {
            this.parameters = hkdfPrfParameters;
            return this;
        }

        public Builder setKeyBytes(SecretBytes secretBytes) {
            this.keyBytes = secretBytes;
            return this;
        }

        public HkdfPrfKey build() throws GeneralSecurityException {
            HkdfPrfParameters hkdfPrfParameters = this.parameters;
            if (hkdfPrfParameters == null || this.keyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (hkdfPrfParameters.getKeySizeBytes() != this.keyBytes.size()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            return new HkdfPrfKey(this.parameters, this.keyBytes);
        }
    }

    private HkdfPrfKey(HkdfPrfParameters hkdfPrfParameters, SecretBytes secretBytes) {
        this.parameters = hkdfPrfParameters;
        this.keyBytes = secretBytes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.google.crypto.tink.prf.PrfKey, com.google.crypto.tink.Key
    public HkdfPrfParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof HkdfPrfKey)) {
            return false;
        }
        HkdfPrfKey hkdfPrfKey = (HkdfPrfKey) key;
        return hkdfPrfKey.parameters.equals(this.parameters) && hkdfPrfKey.keyBytes.equalsSecretBytes(this.keyBytes);
    }
}
