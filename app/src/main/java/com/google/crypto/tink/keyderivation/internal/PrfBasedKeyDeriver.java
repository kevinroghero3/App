package com.google.crypto.tink.keyderivation.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.MutableKeyDerivationRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.keyderivation.PrfBasedKeyDerivationKey;
import com.google.crypto.tink.subtle.prf.StreamingPrf;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class PrfBasedKeyDeriver implements KeyDeriver {
    final PrfBasedKeyDerivationKey key;
    final StreamingPrf prf;

    private PrfBasedKeyDeriver(StreamingPrf streamingPrf, PrfBasedKeyDerivationKey prfBasedKeyDerivationKey) {
        this.prf = streamingPrf;
        this.key = prfBasedKeyDerivationKey;
    }

    public static KeyDeriver create(PrfBasedKeyDerivationKey prfBasedKeyDerivationKey) throws GeneralSecurityException {
        PrfBasedKeyDeriver prfBasedKeyDeriver = new PrfBasedKeyDeriver((StreamingPrf) MutablePrimitiveRegistry.globalInstance().getPrimitive(prfBasedKeyDerivationKey.getPrfKey(), StreamingPrf.class), prfBasedKeyDerivationKey);
        prfBasedKeyDeriver.deriveKey(new byte[]{1});
        return prfBasedKeyDeriver;
    }

    public static KeyDeriver createWithPrfPrimitiveRegistry(PrimitiveRegistry primitiveRegistry, PrfBasedKeyDerivationKey prfBasedKeyDerivationKey) throws GeneralSecurityException {
        PrfBasedKeyDeriver prfBasedKeyDeriver = new PrfBasedKeyDeriver((StreamingPrf) primitiveRegistry.getPrimitive(prfBasedKeyDerivationKey.getPrfKey(), StreamingPrf.class), prfBasedKeyDerivationKey);
        prfBasedKeyDeriver.deriveKey(new byte[]{1});
        return prfBasedKeyDeriver;
    }

    @Override // com.google.crypto.tink.keyderivation.internal.KeyDeriver
    public Key deriveKey(byte[] bArr) throws GeneralSecurityException {
        return MutableKeyDerivationRegistry.globalInstance().createKeyFromRandomness(this.key.getParameters().getDerivedKeyParameters(), this.prf.computePrf(bArr), this.key.getIdRequirementOrNull(), InsecureSecretKeyAccess.get());
    }
}
