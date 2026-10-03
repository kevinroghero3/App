package com.google.crypto.tink.signature;

import com.google.crypto.tink.internal.TinkBugException;

/* JADX INFO: loaded from: classes5.dex */
public final class PredefinedSignatureParameters {
    public static final EcdsaParameters ECDSA_P256 = (EcdsaParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$0();
        }
    });
    public static final EcdsaParameters ECDSA_P384 = (EcdsaParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda6
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$1();
        }
    });
    public static final EcdsaParameters ECDSA_P521 = (EcdsaParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda7
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$2();
        }
    });
    public static final EcdsaParameters ECDSA_P256_IEEE_P1363 = (EcdsaParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda8
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$3();
        }
    });
    public static final EcdsaParameters ECDSA_P384_IEEE_P1363 = (EcdsaParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda9
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$4();
        }
    });
    public static final EcdsaParameters ECDSA_P256_IEEE_P1363_WITHOUT_PREFIX = (EcdsaParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda10
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$5();
        }
    });
    public static final EcdsaParameters ECDSA_P521_IEEE_P1363 = (EcdsaParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda11
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$6();
        }
    });
    public static final Ed25519Parameters ED25519 = (Ed25519Parameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda12
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$7();
        }
    });
    public static final Ed25519Parameters ED25519WithRawOutput = (Ed25519Parameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda13
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$8();
        }
    });
    public static final RsaSsaPkcs1Parameters RSA_SSA_PKCS1_3072_SHA256_F4 = (RsaSsaPkcs1Parameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda14
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$9();
        }
    });
    public static final RsaSsaPkcs1Parameters RSA_SSA_PKCS1_3072_SHA256_F4_WITHOUT_PREFIX = (RsaSsaPkcs1Parameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$10();
        }
    });
    public static final RsaSsaPkcs1Parameters RSA_SSA_PKCS1_4096_SHA512_F4 = (RsaSsaPkcs1Parameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$11();
        }
    });
    public static final RsaSsaPssParameters RSA_SSA_PSS_3072_SHA256_SHA256_32_F4 = (RsaSsaPssParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda3
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$12();
        }
    });
    public static final RsaSsaPssParameters RSA_SSA_PSS_4096_SHA512_SHA512_64_F4 = (RsaSsaPssParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda4
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$13();
        }
    });
    public static final MlDsaParameters ML_DSA_65 = (MlDsaParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.PredefinedSignatureParameters$$ExternalSyntheticLambda5
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            return PredefinedSignatureParameters.lambda$static$14();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EcdsaParameters lambda$static$0() throws Exception {
        return EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA256).setCurveType(EcdsaParameters.CurveType.NIST_P256).setSignatureEncoding(EcdsaParameters.SignatureEncoding.DER).setVariant(EcdsaParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EcdsaParameters lambda$static$1() throws Exception {
        return EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA512).setCurveType(EcdsaParameters.CurveType.NIST_P384).setSignatureEncoding(EcdsaParameters.SignatureEncoding.DER).setVariant(EcdsaParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EcdsaParameters lambda$static$2() throws Exception {
        return EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA512).setCurveType(EcdsaParameters.CurveType.NIST_P521).setSignatureEncoding(EcdsaParameters.SignatureEncoding.DER).setVariant(EcdsaParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EcdsaParameters lambda$static$3() throws Exception {
        return EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setCurveType(EcdsaParameters.CurveType.NIST_P256).setHashType(EcdsaParameters.HashType.SHA256).setVariant(EcdsaParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EcdsaParameters lambda$static$4() throws Exception {
        return EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setCurveType(EcdsaParameters.CurveType.NIST_P384).setHashType(EcdsaParameters.HashType.SHA512).setVariant(EcdsaParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EcdsaParameters lambda$static$5() throws Exception {
        return EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setCurveType(EcdsaParameters.CurveType.NIST_P256).setHashType(EcdsaParameters.HashType.SHA256).setVariant(EcdsaParameters.Variant.NO_PREFIX).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EcdsaParameters lambda$static$6() throws Exception {
        return EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA512).setCurveType(EcdsaParameters.CurveType.NIST_P521).setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setVariant(EcdsaParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Ed25519Parameters lambda$static$7() throws Exception {
        return Ed25519Parameters.create(Ed25519Parameters.Variant.TINK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Ed25519Parameters lambda$static$8() throws Exception {
        return Ed25519Parameters.create(Ed25519Parameters.Variant.NO_PREFIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RsaSsaPkcs1Parameters lambda$static$9() throws Exception {
        return RsaSsaPkcs1Parameters.builder().setHashType(RsaSsaPkcs1Parameters.HashType.SHA256).setModulusSizeBits(3072).setPublicExponent(RsaSsaPkcs1Parameters.F4).setVariant(RsaSsaPkcs1Parameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RsaSsaPkcs1Parameters lambda$static$10() throws Exception {
        return RsaSsaPkcs1Parameters.builder().setHashType(RsaSsaPkcs1Parameters.HashType.SHA256).setModulusSizeBits(3072).setPublicExponent(RsaSsaPkcs1Parameters.F4).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RsaSsaPkcs1Parameters lambda$static$11() throws Exception {
        return RsaSsaPkcs1Parameters.builder().setHashType(RsaSsaPkcs1Parameters.HashType.SHA512).setModulusSizeBits(4096).setPublicExponent(RsaSsaPkcs1Parameters.F4).setVariant(RsaSsaPkcs1Parameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RsaSsaPssParameters lambda$static$12() throws Exception {
        RsaSsaPssParameters.Builder builder = RsaSsaPssParameters.builder();
        RsaSsaPssParameters.HashType hashType = RsaSsaPssParameters.HashType.SHA256;
        return builder.setSigHashType(hashType).setMgf1HashType(hashType).setSaltLengthBytes(32).setModulusSizeBits(3072).setPublicExponent(RsaSsaPssParameters.F4).setVariant(RsaSsaPssParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RsaSsaPssParameters lambda$static$13() throws Exception {
        RsaSsaPssParameters.Builder builder = RsaSsaPssParameters.builder();
        RsaSsaPssParameters.HashType hashType = RsaSsaPssParameters.HashType.SHA512;
        return builder.setSigHashType(hashType).setMgf1HashType(hashType).setSaltLengthBytes(64).setModulusSizeBits(4096).setPublicExponent(RsaSsaPssParameters.F4).setVariant(RsaSsaPssParameters.Variant.TINK).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MlDsaParameters lambda$static$14() throws Exception {
        return MlDsaParameters.create(MlDsaParameters.MlDsaInstance.ML_DSA_65, MlDsaParameters.Variant.TINK);
    }

    private PredefinedSignatureParameters() {
    }
}
