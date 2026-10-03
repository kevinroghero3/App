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
public final class XAesGcmKey extends AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final Bytes outputPrefix;
    private final XAesGcmParameters parameters;

    private XAesGcmKey(XAesGcmParameters xAesGcmParameters, SecretBytes secretBytes, Bytes bytes, @Nullable Integer num) {
        this.parameters = xAesGcmParameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    private static Bytes getOutputPrefix(XAesGcmParameters xAesGcmParameters, @Nullable Integer num) {
        if (xAesGcmParameters.getVariant() == XAesGcmParameters.Variant.NO_PREFIX) {
            return OutputPrefixUtil.EMPTY_PREFIX;
        }
        if (xAesGcmParameters.getVariant() == XAesGcmParameters.Variant.TINK) {
            return OutputPrefixUtil.getTinkOutputPrefix(num.intValue());
        }
        throw new IllegalStateException("Unknown Variant: " + xAesGcmParameters.getVariant());
    }

    @Override // com.google.crypto.tink.aead.AeadKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    public static XAesGcmKey create(XAesGcmParameters xAesGcmParameters, SecretBytes secretBytes, @Nullable Integer num) throws GeneralSecurityException {
        XAesGcmParameters.Variant variant = xAesGcmParameters.getVariant();
        XAesGcmParameters.Variant variant2 = XAesGcmParameters.Variant.NO_PREFIX;
        if (variant != variant2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + xAesGcmParameters.getVariant() + " the value of idRequirement must be non-null");
        }
        if (xAesGcmParameters.getVariant() == variant2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (secretBytes.size() != 32) {
            throw new GeneralSecurityException("XAesGcmKey key must be constructed with key of length 32 bytes, not " + secretBytes.size());
        }
        return new XAesGcmKey(xAesGcmParameters, secretBytes, getOutputPrefix(xAesGcmParameters, num), num);
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public XAesGcmParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof XAesGcmKey)) {
            return false;
        }
        XAesGcmKey xAesGcmKey = (XAesGcmKey) key;
        return xAesGcmKey.parameters.equals(this.parameters) && xAesGcmKey.keyBytes.equalsSecretBytes(this.keyBytes) && Objects.equals(xAesGcmKey.idRequirement, this.idRequirement);
    }
}
