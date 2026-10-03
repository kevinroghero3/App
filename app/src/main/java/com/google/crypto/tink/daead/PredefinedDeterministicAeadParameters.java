package com.google.crypto.tink.daead;

import com.google.crypto.tink.internal.TinkBugException;

/* JADX INFO: loaded from: classes2.dex */
public final class PredefinedDeterministicAeadParameters {
    public static final AesSivParameters AES256_SIV = (AesSivParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.daead.PredefinedDeterministicAeadParameters$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedDeterministicAeadParameters.lambda$static$0();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesSivParameters lambda$static$0() throws Exception {
        return AesSivParameters.builder().setKeySizeBytes(64).setVariant(AesSivParameters.Variant.TINK).build();
    }

    private PredefinedDeterministicAeadParameters() {
    }
}
