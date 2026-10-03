package com.google.crypto.tink.keyderivation;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.prf.PrfKey;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class PrfBasedKeyDerivationKey extends KeyDerivationKey {
    private final Integer idRequirementOrNull;
    private final PrfBasedKeyDerivationParameters parameters;
    private final PrfKey prfKey;

    public static PrfBasedKeyDerivationKey create(PrfBasedKeyDerivationParameters prfBasedKeyDerivationParameters, PrfKey prfKey, @Nullable Integer num) throws GeneralSecurityException {
        if (!prfBasedKeyDerivationParameters.getPrfParameters().equals(prfKey.getParameters())) {
            throw new GeneralSecurityException("PrfParameters of passed in PrfBasedKeyDerivationParameters and passed in prfKey parameters object must match. DerivationParameters gave: " + prfBasedKeyDerivationParameters.getPrfParameters() + ", key gives: " + prfKey.getParameters());
        }
        if (prfBasedKeyDerivationParameters.getDerivedKeyParameters().hasIdRequirement() && num == null) {
            throw new GeneralSecurityException("Derived key has an ID requirement, but no idRequirement was passed in on creation of this key");
        }
        if (!prfBasedKeyDerivationParameters.getDerivedKeyParameters().hasIdRequirement() && num != null) {
            throw new GeneralSecurityException("Derived key has no ID requirement, but idRequirement was passed in on creation of this key");
        }
        return new PrfBasedKeyDerivationKey(prfBasedKeyDerivationParameters, prfKey, num);
    }

    private PrfBasedKeyDerivationKey(PrfBasedKeyDerivationParameters prfBasedKeyDerivationParameters, PrfKey prfKey, @Nullable Integer num) {
        this.parameters = prfBasedKeyDerivationParameters;
        this.prfKey = prfKey;
        this.idRequirementOrNull = num;
    }

    public PrfKey getPrfKey() {
        return this.prfKey;
    }

    @Override // com.google.crypto.tink.keyderivation.KeyDerivationKey, com.google.crypto.tink.Key
    public PrfBasedKeyDerivationParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirementOrNull;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof PrfBasedKeyDerivationKey)) {
            return false;
        }
        PrfBasedKeyDerivationKey prfBasedKeyDerivationKey = (PrfBasedKeyDerivationKey) key;
        return prfBasedKeyDerivationKey.getParameters().equals(getParameters()) && prfBasedKeyDerivationKey.prfKey.equalsKey(this.prfKey) && Objects.equals(prfBasedKeyDerivationKey.idRequirementOrNull, this.idRequirementOrNull);
    }
}
