package com.google.crypto.tink.aead;

import com.google.crypto.tink.internal.TinkBugException;

/* JADX INFO: loaded from: classes2.dex */
public final class PredefinedAeadParameters {
    public static final XAesGcmParameters XAES_256_GCM_160_BIT_NONCE_NO_PREFIX;

    @Deprecated
    public static final XAesGcmParameters X_AES_GCM_8_BYTE_SALT_NO_PREFIX;
    public static final AesGcmParameters AES128_GCM = (AesGcmParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.PredefinedAeadParameters$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedAeadParameters.lambda$static$0();
        }
    });
    public static final AesGcmParameters AES256_GCM = (AesGcmParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.PredefinedAeadParameters$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedAeadParameters.lambda$static$1();
        }
    });
    public static final AesEaxParameters AES128_EAX = (AesEaxParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.PredefinedAeadParameters$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedAeadParameters.lambda$static$2();
        }
    });
    public static final AesEaxParameters AES256_EAX = (AesEaxParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.PredefinedAeadParameters$$ExternalSyntheticLambda3
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedAeadParameters.lambda$static$3();
        }
    });
    public static final AesCtrHmacAeadParameters AES128_CTR_HMAC_SHA256 = (AesCtrHmacAeadParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.PredefinedAeadParameters$$ExternalSyntheticLambda4
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedAeadParameters.lambda$static$4();
        }
    });
    public static final AesCtrHmacAeadParameters AES256_CTR_HMAC_SHA256 = (AesCtrHmacAeadParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.PredefinedAeadParameters$$ExternalSyntheticLambda5
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedAeadParameters.lambda$static$5();
        }
    });
    public static final ChaCha20Poly1305Parameters CHACHA20_POLY1305 = ChaCha20Poly1305Parameters.create(ChaCha20Poly1305Parameters.Variant.TINK);
    public static final XChaCha20Poly1305Parameters XCHACHA20_POLY1305 = XChaCha20Poly1305Parameters.create(XChaCha20Poly1305Parameters.Variant.TINK);
    public static final XAesGcmParameters XAES_256_GCM_192_BIT_NONCE = (XAesGcmParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.PredefinedAeadParameters$$ExternalSyntheticLambda6
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedAeadParameters.lambda$static$6();
        }
    });
    public static final XAesGcmParameters XAES_256_GCM_192_BIT_NONCE_NO_PREFIX = (XAesGcmParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.PredefinedAeadParameters$$ExternalSyntheticLambda7
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedAeadParameters.lambda$static$7();
        }
    });

    static {
        XAesGcmParameters xAesGcmParameters = (XAesGcmParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.aead.PredefinedAeadParameters$$ExternalSyntheticLambda8
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return PredefinedAeadParameters.lambda$static$8();
            }
        });
        XAES_256_GCM_160_BIT_NONCE_NO_PREFIX = xAesGcmParameters;
        X_AES_GCM_8_BYTE_SALT_NO_PREFIX = xAesGcmParameters;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesGcmParameters lambda$static$0() throws Exception {
        return AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesGcmParameters lambda$static$1() throws Exception {
        return AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesEaxParameters lambda$static$2() throws Exception {
        return AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesEaxParameters lambda$static$3() throws Exception {
        return AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesCtrHmacAeadParameters lambda$static$4() throws Exception {
        return AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(16).setHmacKeySizeBytes(32).setTagSizeBytes(16).setIvSizeBytes(16).setHashType(AesCtrHmacAeadParameters.HashType.SHA256).setVariant(AesCtrHmacAeadParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesCtrHmacAeadParameters lambda$static$5() throws Exception {
        return AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(32).setHmacKeySizeBytes(32).setTagSizeBytes(32).setIvSizeBytes(16).setHashType(AesCtrHmacAeadParameters.HashType.SHA256).setVariant(AesCtrHmacAeadParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XAesGcmParameters lambda$static$6() throws Exception {
        return XAesGcmParameters.create(XAesGcmParameters.Variant.TINK, 12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XAesGcmParameters lambda$static$7() throws Exception {
        return XAesGcmParameters.create(XAesGcmParameters.Variant.NO_PREFIX, 12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XAesGcmParameters lambda$static$8() throws Exception {
        return XAesGcmParameters.create(XAesGcmParameters.Variant.NO_PREFIX, 8);
    }

    private PredefinedAeadParameters() {
    }
}
