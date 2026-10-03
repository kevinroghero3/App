package com.google.crypto.tink.signature;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class Ed25519PublicKey extends SignaturePublicKey {

    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final Ed25519Parameters parameters;
    private final Bytes publicKeyBytes;

    private Ed25519PublicKey(Ed25519Parameters ed25519Parameters, Bytes bytes, Bytes bytes2, @Nullable Integer num) {
        this.parameters = ed25519Parameters;
        this.publicKeyBytes = bytes;
        this.outputPrefix = bytes2;
        this.idRequirement = num;
    }

    private static Bytes createOutputPrefix(Ed25519Parameters ed25519Parameters, @Nullable Integer num) {
        if (ed25519Parameters.getVariant() == Ed25519Parameters.Variant.NO_PREFIX) {
            return OutputPrefixUtil.EMPTY_PREFIX;
        }
        if (ed25519Parameters.getVariant() == Ed25519Parameters.Variant.CRUNCHY || ed25519Parameters.getVariant() == Ed25519Parameters.Variant.LEGACY) {
            return OutputPrefixUtil.getLegacyOutputPrefix(num.intValue());
        }
        if (ed25519Parameters.getVariant() == Ed25519Parameters.Variant.TINK) {
            return OutputPrefixUtil.getTinkOutputPrefix(num.intValue());
        }
        throw new IllegalStateException("Unknown Variant: " + ed25519Parameters.getVariant());
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    public static Ed25519PublicKey create(Bytes bytes) throws GeneralSecurityException {
        return create(Ed25519Parameters.Variant.NO_PREFIX, bytes, null);
    }

    public static Ed25519PublicKey create(Ed25519Parameters.Variant variant, Bytes bytes, @Nullable Integer num) throws GeneralSecurityException {
        Ed25519Parameters ed25519ParametersCreate = Ed25519Parameters.create(variant);
        Ed25519Parameters.Variant variant2 = Ed25519Parameters.Variant.NO_PREFIX;
        if (!variant.equals(variant2) && num == null) {
            throw new GeneralSecurityException("For given Variant " + variant + " the value of idRequirement must be non-null");
        }
        if (variant.equals(variant2) && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (bytes.size() != 32) {
            throw new GeneralSecurityException("Ed25519 key must be constructed with key of length 32 bytes, not " + bytes.size());
        }
        return new Ed25519PublicKey(ed25519ParametersCreate, bytes, createOutputPrefix(ed25519ParametersCreate, num), num);
    }

    public Bytes getPublicKeyBytes() {
        return this.publicKeyBytes;
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey, com.google.crypto.tink.Key
    public Ed25519Parameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof Ed25519PublicKey)) {
            return false;
        }
        Ed25519PublicKey ed25519PublicKey = (Ed25519PublicKey) key;
        return ed25519PublicKey.parameters.equals(this.parameters) && ed25519PublicKey.publicKeyBytes.equals(this.publicKeyBytes) && Objects.equals(ed25519PublicKey.idRequirement, this.idRequirement);
    }
}
