package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import com.hitachiapp.exceptions.AppHookedException;
import java.lang.reflect.Constructor;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class AesEaxKey extends AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final Bytes outputPrefix;
    private final AesEaxParameters parameters;

    /* synthetic */ AesEaxKey(AesEaxParameters aesEaxParameters, SecretBytes secretBytes, Bytes bytes, Integer num, AnonymousClass1 anonymousClass1) {
        this(aesEaxParameters, secretBytes, bytes, num);
    }

    public static class Builder {

        @Nullable
        private Integer idRequirement;

        @Nullable
        private SecretBytes keyBytes;

        @Nullable
        private AesEaxParameters parameters;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            this.parameters = null;
            this.keyBytes = null;
            this.idRequirement = null;
        }

        public Builder setParameters(AesEaxParameters aesEaxParameters) {
            this.parameters = aesEaxParameters;
            return this;
        }

        public Builder setKeyBytes(SecretBytes secretBytes) {
            this.keyBytes = secretBytes;
            return this;
        }

        public Builder setIdRequirement(@Nullable Integer num) {
            this.idRequirement = num;
            return this;
        }

        private Bytes getOutputPrefix() {
            if (this.parameters.getVariant() == AesEaxParameters.Variant.NO_PREFIX) {
                return OutputPrefixUtil.EMPTY_PREFIX;
            }
            if (this.parameters.getVariant() == AesEaxParameters.Variant.CRUNCHY) {
                return OutputPrefixUtil.getLegacyOutputPrefix(this.idRequirement.intValue());
            }
            if (this.parameters.getVariant() == AesEaxParameters.Variant.TINK) {
                return OutputPrefixUtil.getTinkOutputPrefix(this.idRequirement.intValue());
            }
            throw new IllegalStateException("Unknown AesEaxParameters.Variant: " + this.parameters.getVariant());
        }

        public AesEaxKey build() throws GeneralSecurityException {
            AesEaxParameters aesEaxParameters = this.parameters;
            if (aesEaxParameters == null || this.keyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (aesEaxParameters.getKeySizeBytes() != this.keyBytes.size()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.parameters.hasIdRequirement() && this.idRequirement == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.parameters.hasIdRequirement() && this.idRequirement != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new AesEaxKey(this.parameters, this.keyBytes, getOutputPrefix(), this.idRequirement, null);
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.AesEaxKey$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static void $$a(long j, long j2) throws Throwable {
            try {
                Constructor declaredConstructor = AppHookedException.class.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                throw ((Throwable) declaredConstructor.newInstance(null));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    private AesEaxKey(AesEaxParameters aesEaxParameters, SecretBytes secretBytes, Bytes bytes, @Nullable Integer num) {
        this.parameters = aesEaxParameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.google.crypto.tink.aead.AeadKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public AesEaxParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof AesEaxKey)) {
            return false;
        }
        AesEaxKey aesEaxKey = (AesEaxKey) key;
        return aesEaxKey.parameters.equals(this.parameters) && aesEaxKey.keyBytes.equalsSecretBytes(this.keyBytes) && Objects.equals(aesEaxKey.idRequirement, this.idRequirement);
    }
}
