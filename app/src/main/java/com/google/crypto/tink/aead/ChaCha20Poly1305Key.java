package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class ChaCha20Poly1305Key extends AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final Bytes outputPrefix;
    private final ChaCha20Poly1305Parameters parameters;

    private ChaCha20Poly1305Key(ChaCha20Poly1305Parameters chaCha20Poly1305Parameters, SecretBytes secretBytes, Bytes bytes, @Nullable Integer num) {
        this.parameters = chaCha20Poly1305Parameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    private static Bytes getOutputPrefix(ChaCha20Poly1305Parameters chaCha20Poly1305Parameters, @Nullable Integer num) {
        if (chaCha20Poly1305Parameters.getVariant() == ChaCha20Poly1305Parameters.Variant.NO_PREFIX) {
            return OutputPrefixUtil.EMPTY_PREFIX;
        }
        if (chaCha20Poly1305Parameters.getVariant() == ChaCha20Poly1305Parameters.Variant.CRUNCHY) {
            return OutputPrefixUtil.getLegacyOutputPrefix(num.intValue());
        }
        if (chaCha20Poly1305Parameters.getVariant() == ChaCha20Poly1305Parameters.Variant.TINK) {
            return OutputPrefixUtil.getTinkOutputPrefix(num.intValue());
        }
        throw new IllegalStateException("Unknown Variant: " + chaCha20Poly1305Parameters.getVariant());
    }

    @Override // com.google.crypto.tink.aead.AeadKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    public static ChaCha20Poly1305Key create(SecretBytes secretBytes) throws GeneralSecurityException {
        return create(ChaCha20Poly1305Parameters.Variant.NO_PREFIX, secretBytes, null);
    }

    public static ChaCha20Poly1305Key create(ChaCha20Poly1305Parameters.Variant variant, SecretBytes secretBytes, @Nullable Integer num) throws GeneralSecurityException {
        ChaCha20Poly1305Parameters.Variant variant2 = ChaCha20Poly1305Parameters.Variant.NO_PREFIX;
        if (variant != variant2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + variant + " the value of idRequirement must be non-null");
        }
        if (variant == variant2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (secretBytes.size() != 32) {
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + secretBytes.size());
        }
        ChaCha20Poly1305Parameters chaCha20Poly1305ParametersCreate = ChaCha20Poly1305Parameters.create(variant);
        return new ChaCha20Poly1305Key(chaCha20Poly1305ParametersCreate, secretBytes, getOutputPrefix(chaCha20Poly1305ParametersCreate, num), num);
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public ChaCha20Poly1305Parameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof ChaCha20Poly1305Key)) {
            return false;
        }
        ChaCha20Poly1305Key chaCha20Poly1305Key = (ChaCha20Poly1305Key) key;
        return chaCha20Poly1305Key.parameters.equals(this.parameters) && chaCha20Poly1305Key.keyBytes.equalsSecretBytes(this.keyBytes) && Objects.equals(chaCha20Poly1305Key.idRequirement, this.idRequirement);
    }
}
