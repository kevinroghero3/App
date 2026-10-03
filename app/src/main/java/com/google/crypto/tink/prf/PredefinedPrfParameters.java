package com.google.crypto.tink.prf;

import com.google.crypto.tink.internal.TinkBugException;

/* JADX INFO: loaded from: classes5.dex */
public final class PredefinedPrfParameters {
    public static final HkdfPrfParameters HKDF_SHA256 = (HkdfPrfParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.prf.PredefinedPrfParameters$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedPrfParameters.lambda$static$0();
        }
    });
    public static final HmacPrfParameters HMAC_SHA256_PRF = (HmacPrfParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.prf.PredefinedPrfParameters$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedPrfParameters.lambda$static$1();
        }
    });
    public static final HmacPrfParameters HMAC_SHA512_PRF = (HmacPrfParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.prf.PredefinedPrfParameters$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedPrfParameters.lambda$static$2();
        }
    });
    public static final AesCmacPrfParameters AES_CMAC_PRF = (AesCmacPrfParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.prf.PredefinedPrfParameters$$ExternalSyntheticLambda3
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedPrfParameters.lambda$static$3();
        }
    });

    private PredefinedPrfParameters() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HkdfPrfParameters lambda$static$0() throws Exception {
        return HkdfPrfParameters.builder().setKeySizeBytes(32).setHashType(HkdfPrfParameters.HashType.SHA256).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HmacPrfParameters lambda$static$1() throws Exception {
        return HmacPrfParameters.builder().setKeySizeBytes(32).setHashType(HmacPrfParameters.HashType.SHA256).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HmacPrfParameters lambda$static$2() throws Exception {
        return HmacPrfParameters.builder().setKeySizeBytes(64).setHashType(HmacPrfParameters.HashType.SHA512).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesCmacPrfParameters lambda$static$3() throws Exception {
        return AesCmacPrfParameters.create(32);
    }
}
