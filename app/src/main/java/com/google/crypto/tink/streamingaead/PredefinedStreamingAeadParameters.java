package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.internal.TinkBugException;

/* JADX INFO: loaded from: classes5.dex */
public final class PredefinedStreamingAeadParameters {
    public static final AesCtrHmacStreamingParameters AES128_CTR_HMAC_SHA256_4KB = (AesCtrHmacStreamingParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.streamingaead.PredefinedStreamingAeadParameters$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedStreamingAeadParameters.lambda$static$0();
        }
    });
    public static final AesCtrHmacStreamingParameters AES128_CTR_HMAC_SHA256_1MB = (AesCtrHmacStreamingParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.streamingaead.PredefinedStreamingAeadParameters$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedStreamingAeadParameters.lambda$static$1();
        }
    });
    public static final AesCtrHmacStreamingParameters AES256_CTR_HMAC_SHA256_4KB = (AesCtrHmacStreamingParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.streamingaead.PredefinedStreamingAeadParameters$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedStreamingAeadParameters.lambda$static$2();
        }
    });
    public static final AesCtrHmacStreamingParameters AES256_CTR_HMAC_SHA256_1MB = (AesCtrHmacStreamingParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.streamingaead.PredefinedStreamingAeadParameters$$ExternalSyntheticLambda3
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedStreamingAeadParameters.lambda$static$3();
        }
    });
    public static final AesGcmHkdfStreamingParameters AES128_GCM_HKDF_4KB = (AesGcmHkdfStreamingParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.streamingaead.PredefinedStreamingAeadParameters$$ExternalSyntheticLambda4
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedStreamingAeadParameters.lambda$static$4();
        }
    });
    public static final AesGcmHkdfStreamingParameters AES128_GCM_HKDF_1MB = (AesGcmHkdfStreamingParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.streamingaead.PredefinedStreamingAeadParameters$$ExternalSyntheticLambda5
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedStreamingAeadParameters.lambda$static$5();
        }
    });
    public static final AesGcmHkdfStreamingParameters AES256_GCM_HKDF_4KB = (AesGcmHkdfStreamingParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.streamingaead.PredefinedStreamingAeadParameters$$ExternalSyntheticLambda6
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedStreamingAeadParameters.lambda$static$6();
        }
    });
    public static final AesGcmHkdfStreamingParameters AES256_GCM_HKDF_1MB = (AesGcmHkdfStreamingParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.streamingaead.PredefinedStreamingAeadParameters$$ExternalSyntheticLambda7
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedStreamingAeadParameters.lambda$static$7();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesCtrHmacStreamingParameters lambda$static$0() throws Exception {
        AesCtrHmacStreamingParameters.Builder derivedKeySizeBytes = AesCtrHmacStreamingParameters.builder().setKeySizeBytes(16).setDerivedKeySizeBytes(16);
        AesCtrHmacStreamingParameters.HashType hashType = AesCtrHmacStreamingParameters.HashType.SHA256;
        return derivedKeySizeBytes.setHkdfHashType(hashType).setHmacHashType(hashType).setHmacTagSizeBytes(32).setCiphertextSegmentSizeBytes(4096).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesCtrHmacStreamingParameters lambda$static$1() throws Exception {
        AesCtrHmacStreamingParameters.Builder derivedKeySizeBytes = AesCtrHmacStreamingParameters.builder().setKeySizeBytes(16).setDerivedKeySizeBytes(16);
        AesCtrHmacStreamingParameters.HashType hashType = AesCtrHmacStreamingParameters.HashType.SHA256;
        return derivedKeySizeBytes.setHkdfHashType(hashType).setHmacHashType(hashType).setHmacTagSizeBytes(32).setCiphertextSegmentSizeBytes(1048576).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesCtrHmacStreamingParameters lambda$static$2() throws Exception {
        AesCtrHmacStreamingParameters.Builder derivedKeySizeBytes = AesCtrHmacStreamingParameters.builder().setKeySizeBytes(32).setDerivedKeySizeBytes(32);
        AesCtrHmacStreamingParameters.HashType hashType = AesCtrHmacStreamingParameters.HashType.SHA256;
        return derivedKeySizeBytes.setHkdfHashType(hashType).setHmacHashType(hashType).setHmacTagSizeBytes(32).setCiphertextSegmentSizeBytes(4096).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesCtrHmacStreamingParameters lambda$static$3() throws Exception {
        AesCtrHmacStreamingParameters.Builder derivedKeySizeBytes = AesCtrHmacStreamingParameters.builder().setKeySizeBytes(32).setDerivedKeySizeBytes(32);
        AesCtrHmacStreamingParameters.HashType hashType = AesCtrHmacStreamingParameters.HashType.SHA256;
        return derivedKeySizeBytes.setHkdfHashType(hashType).setHmacHashType(hashType).setHmacTagSizeBytes(32).setCiphertextSegmentSizeBytes(1048576).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesGcmHkdfStreamingParameters lambda$static$4() throws Exception {
        return AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(16).setDerivedAesGcmKeySizeBytes(16).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).setCiphertextSegmentSizeBytes(4096).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesGcmHkdfStreamingParameters lambda$static$5() throws Exception {
        return AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(16).setDerivedAesGcmKeySizeBytes(16).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).setCiphertextSegmentSizeBytes(1048576).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesGcmHkdfStreamingParameters lambda$static$6() throws Exception {
        return AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(32).setDerivedAesGcmKeySizeBytes(32).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).setCiphertextSegmentSizeBytes(4096).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AesGcmHkdfStreamingParameters lambda$static$7() throws Exception {
        return AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(32).setDerivedAesGcmKeySizeBytes(32).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).setCiphertextSegmentSizeBytes(1048576).build();
    }

    private PredefinedStreamingAeadParameters() {
    }
}
