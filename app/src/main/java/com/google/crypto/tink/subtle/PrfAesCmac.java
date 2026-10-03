package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.prf.AesCmacPrfKey;
import com.google.crypto.tink.prf.AesCmacPrfParameters;
import com.google.crypto.tink.prf.Prf;
import com.google.crypto.tink.prf.internal.PrfAesCmacConscrypt;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class PrfAesCmac implements Prf {
    private final Prf prf;

    private static AesCmacPrfKey createAesCmacPrfKey(byte[] bArr) throws GeneralSecurityException {
        return AesCmacPrfKey.create(AesCmacPrfParameters.create(bArr.length), SecretBytes.copyFrom(bArr, InsecureSecretKeyAccess.get()));
    }

    private PrfAesCmac(AesCmacPrfKey aesCmacPrfKey) throws GeneralSecurityException {
        this.prf = create(aesCmacPrfKey);
    }

    public PrfAesCmac(byte[] bArr) throws GeneralSecurityException {
        this(createAesCmacPrfKey(bArr));
    }

    @Immutable
    static class PrfImplementation implements Prf {
        private static final int SMALL_DATA_SIZE = 64;
        final Prf large;
        final Prf small;

        @Override // com.google.crypto.tink.prf.Prf
        public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
            if (bArr.length <= 64) {
                return this.small.compute(bArr, i);
            }
            return this.large.compute(bArr, i);
        }

        private PrfImplementation(Prf prf, Prf prf2) {
            this.small = prf;
            this.large = prf2;
        }
    }

    public static Prf create(AesCmacPrfKey aesCmacPrfKey) throws GeneralSecurityException {
        Prf prfCreate = com.google.crypto.tink.prf.internal.PrfAesCmac.create(aesCmacPrfKey);
        try {
            return new PrfImplementation(prfCreate, PrfAesCmacConscrypt.create(aesCmacPrfKey));
        } catch (GeneralSecurityException unused) {
            return prfCreate;
        }
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
        return this.prf.compute(bArr, i);
    }
}
