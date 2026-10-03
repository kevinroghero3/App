package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class LegacyKmsEnvelopeAeadKey extends AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final LegacyKmsEnvelopeAeadParameters parameters;

    private LegacyKmsEnvelopeAeadKey(LegacyKmsEnvelopeAeadParameters legacyKmsEnvelopeAeadParameters, Bytes bytes, @Nullable Integer num) {
        this.parameters = legacyKmsEnvelopeAeadParameters;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    public static LegacyKmsEnvelopeAeadKey create(LegacyKmsEnvelopeAeadParameters legacyKmsEnvelopeAeadParameters, @Nullable Integer num) throws GeneralSecurityException {
        Bytes tinkOutputPrefix;
        if (legacyKmsEnvelopeAeadParameters.getVariant() == LegacyKmsEnvelopeAeadParameters.Variant.NO_PREFIX) {
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            tinkOutputPrefix = OutputPrefixUtil.EMPTY_PREFIX;
        } else {
            if (legacyKmsEnvelopeAeadParameters.getVariant() != LegacyKmsEnvelopeAeadParameters.Variant.TINK) {
                throw new GeneralSecurityException("Unknown Variant: " + legacyKmsEnvelopeAeadParameters.getVariant());
            }
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            tinkOutputPrefix = OutputPrefixUtil.getTinkOutputPrefix(num.intValue());
        }
        return new LegacyKmsEnvelopeAeadKey(legacyKmsEnvelopeAeadParameters, tinkOutputPrefix, num);
    }

    public static LegacyKmsEnvelopeAeadKey create(LegacyKmsEnvelopeAeadParameters legacyKmsEnvelopeAeadParameters) throws GeneralSecurityException {
        return create(legacyKmsEnvelopeAeadParameters, null);
    }

    @Override // com.google.crypto.tink.aead.AeadKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public LegacyKmsEnvelopeAeadParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof LegacyKmsEnvelopeAeadKey)) {
            return false;
        }
        LegacyKmsEnvelopeAeadKey legacyKmsEnvelopeAeadKey = (LegacyKmsEnvelopeAeadKey) key;
        return legacyKmsEnvelopeAeadKey.parameters.equals(this.parameters) && Objects.equals(legacyKmsEnvelopeAeadKey.idRequirement, this.idRequirement);
    }
}
