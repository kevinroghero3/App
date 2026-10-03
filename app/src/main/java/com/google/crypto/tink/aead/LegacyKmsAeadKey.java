package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.util.Bytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class LegacyKmsAeadKey extends AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final LegacyKmsAeadParameters parameters;

    private LegacyKmsAeadKey(LegacyKmsAeadParameters legacyKmsAeadParameters, Bytes bytes, @Nullable Integer num) {
        this.parameters = legacyKmsAeadParameters;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    public static LegacyKmsAeadKey create(LegacyKmsAeadParameters legacyKmsAeadParameters, @Nullable Integer num) throws GeneralSecurityException {
        Bytes bytesCopyFrom;
        if (legacyKmsAeadParameters.variant() == LegacyKmsAeadParameters.Variant.TINK) {
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            bytesCopyFrom = Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        } else {
            if (legacyKmsAeadParameters.variant() != LegacyKmsAeadParameters.Variant.NO_PREFIX) {
                throw new GeneralSecurityException("Unknown Variant: " + legacyKmsAeadParameters.variant());
            }
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            bytesCopyFrom = Bytes.copyFrom(new byte[0]);
        }
        return new LegacyKmsAeadKey(legacyKmsAeadParameters, bytesCopyFrom, num);
    }

    public static LegacyKmsAeadKey create(LegacyKmsAeadParameters legacyKmsAeadParameters) throws GeneralSecurityException {
        return create(legacyKmsAeadParameters, null);
    }

    @Override // com.google.crypto.tink.aead.AeadKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public LegacyKmsAeadParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof LegacyKmsAeadKey)) {
            return false;
        }
        LegacyKmsAeadKey legacyKmsAeadKey = (LegacyKmsAeadKey) key;
        return legacyKmsAeadKey.parameters.equals(this.parameters) && Objects.equals(legacyKmsAeadKey.idRequirement, this.idRequirement);
    }
}
