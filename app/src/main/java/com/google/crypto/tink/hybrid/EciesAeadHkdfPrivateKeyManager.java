package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.aead.AesCtrHmacAeadParameters;
import com.google.crypto.tink.aead.AesGcmParameters;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.hybrid.internal.EciesProtoSerialization;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.internal.KeyCreator;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.proto.EciesAeadHkdfPrivateKey;
import com.google.crypto.tink.proto.EciesAeadHkdfPublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridDecrypt;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridEncrypt;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.util.SecretBigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class EciesAeadHkdfPrivateKeyManager {
    private static final PrimitiveConstructor<EciesPrivateKey, HybridDecrypt> HYBRID_DECRYPT_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager$$ExternalSyntheticLambda4
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return EciesAeadHkdfHybridDecrypt.create((EciesPrivateKey) key);
        }
    }, EciesPrivateKey.class, HybridDecrypt.class);
    private static final PrimitiveConstructor<EciesPublicKey, HybridEncrypt> HYBRID_ENCRYPT_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager$$ExternalSyntheticLambda5
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return EciesAeadHkdfHybridEncrypt.create((EciesPublicKey) key);
        }
    }, EciesPublicKey.class, HybridEncrypt.class);
    private static final PrivateKeyManager<HybridDecrypt> legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), HybridDecrypt.class, EciesAeadHkdfPrivateKey.parser());
    private static final KeyManager<HybridEncrypt> legacyPublicKeyManager = LegacyKeyManagerImpl.create(EciesAeadHkdfPublicKeyManager.getKeyType(), HybridEncrypt.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, EciesAeadHkdfPublicKey.parser());
    private static final KeyCreator<EciesParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager$$ExternalSyntheticLambda6
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return EciesAeadHkdfPrivateKeyManager.createKey((EciesParameters) parameters, num);
        }
    };

    private static final ECParameterSpec toParameterSpec(EciesParameters.CurveType curveType) throws GeneralSecurityException {
        if (curveType == EciesParameters.CurveType.NIST_P256) {
            return EllipticCurvesUtil.NIST_P256_PARAMS;
        }
        if (curveType == EciesParameters.CurveType.NIST_P384) {
            return EllipticCurvesUtil.NIST_P384_PARAMS;
        }
        if (curveType == EciesParameters.CurveType.NIST_P521) {
            return EllipticCurvesUtil.NIST_P521_PARAMS;
        }
        throw new GeneralSecurityException("Unsupported curve type: " + curveType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EciesPrivateKey createKey(EciesParameters eciesParameters, @Nullable Integer num) throws GeneralSecurityException {
        KeyPair keyPairGenerateKeyPair = EllipticCurves.generateKeyPair(toParameterSpec(eciesParameters.getCurveType()));
        return EciesPrivateKey.createForNistCurve(EciesPublicKey.createForNistCurve(eciesParameters, ((ECPublicKey) keyPairGenerateKeyPair.getPublic()).getW(), num), SecretBigInteger.fromBigInteger(((ECPrivateKey) keyPairGenerateKeyPair.getPrivate()).getS(), InsecureSecretKeyAccess.get()));
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        EciesParameters.Builder builder = EciesParameters.builder();
        EciesParameters.CurveType curveType = EciesParameters.CurveType.NIST_P256;
        EciesParameters.Builder curveType2 = builder.setCurveType(curveType);
        EciesParameters.HashType hashType = EciesParameters.HashType.SHA256;
        EciesParameters.Builder hashType2 = curveType2.setHashType(hashType);
        EciesParameters.PointFormat pointFormat = EciesParameters.PointFormat.UNCOMPRESSED;
        EciesParameters.Builder nistCurvePointFormat = hashType2.setNistCurvePointFormat(pointFormat);
        EciesParameters.Variant variant = EciesParameters.Variant.TINK;
        EciesParameters.Builder variant2 = nistCurvePointFormat.setVariant(variant);
        AesGcmParameters.Builder tagSizeBytes = AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16);
        AesGcmParameters.Variant variant3 = AesGcmParameters.Variant.NO_PREFIX;
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", variant2.setDemParameters(tagSizeBytes.setVariant(variant3).build()).build());
        EciesParameters.Builder nistCurvePointFormat2 = EciesParameters.builder().setCurveType(curveType).setHashType(hashType).setNistCurvePointFormat(pointFormat);
        EciesParameters.Variant variant4 = EciesParameters.Variant.NO_PREFIX;
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", nistCurvePointFormat2.setVariant(variant4).setDemParameters(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(variant3).build()).build());
        EciesParameters.Builder hashType3 = EciesParameters.builder().setCurveType(curveType).setHashType(hashType);
        EciesParameters.PointFormat pointFormat2 = EciesParameters.PointFormat.COMPRESSED;
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", hashType3.setNistCurvePointFormat(pointFormat2).setVariant(variant).setDemParameters(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(variant3).build()).build());
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", EciesParameters.builder().setCurveType(curveType).setHashType(hashType).setNistCurvePointFormat(pointFormat2).setVariant(variant4).setDemParameters(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(variant3).build()).build());
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", EciesParameters.builder().setCurveType(curveType).setHashType(hashType).setNistCurvePointFormat(pointFormat2).setVariant(variant4).setDemParameters(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(variant3).build()).build());
        EciesParameters.Builder variant5 = EciesParameters.builder().setCurveType(curveType).setHashType(hashType).setNistCurvePointFormat(pointFormat).setVariant(variant);
        AesCtrHmacAeadParameters.Builder ivSizeBytes = AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(16).setHmacKeySizeBytes(32).setTagSizeBytes(16).setIvSizeBytes(16);
        AesCtrHmacAeadParameters.HashType hashType4 = AesCtrHmacAeadParameters.HashType.SHA256;
        AesCtrHmacAeadParameters.Builder hashType5 = ivSizeBytes.setHashType(hashType4);
        AesCtrHmacAeadParameters.Variant variant6 = AesCtrHmacAeadParameters.Variant.NO_PREFIX;
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", variant5.setDemParameters(hashType5.setVariant(variant6).build()).build());
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", EciesParameters.builder().setCurveType(curveType).setHashType(hashType).setNistCurvePointFormat(pointFormat).setVariant(variant4).setDemParameters(AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(16).setHmacKeySizeBytes(32).setTagSizeBytes(16).setIvSizeBytes(16).setHashType(hashType4).setVariant(variant6).build()).build());
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", EciesParameters.builder().setCurveType(curveType).setHashType(hashType).setNistCurvePointFormat(pointFormat2).setVariant(variant).setDemParameters(AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(16).setHmacKeySizeBytes(32).setTagSizeBytes(16).setIvSizeBytes(16).setHashType(hashType4).setVariant(variant6).build()).build());
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", EciesParameters.builder().setCurveType(curveType).setHashType(hashType).setNistCurvePointFormat(pointFormat2).setVariant(variant4).setDemParameters(AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(16).setHmacKeySizeBytes(32).setTagSizeBytes(16).setIvSizeBytes(16).setHashType(hashType4).setVariant(variant6).build()).build());
        return Collections.unmodifiableMap(map);
    }

    public static void registerPair(boolean z) throws GeneralSecurityException {
        if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
            throw new GeneralSecurityException("Registering ECIES Hybrid Encryption is not supported in FIPS mode");
        }
        EciesProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(HYBRID_DECRYPT_PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(HYBRID_ENCRYPT_PRIMITIVE_CONSTRUCTOR);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, EciesParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPrivateKeyManager, z);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPublicKeyManager, false);
    }

    public static final KeyTemplate eciesP256HkdfHmacSha256Aes128GcmTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return EciesAeadHkdfPrivateKeyManager.lambda$eciesP256HkdfHmacSha256Aes128GcmTemplate$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$eciesP256HkdfHmacSha256Aes128GcmTemplate$0() throws Exception {
        return KeyTemplate.createFrom(EciesParameters.builder().setCurveType(EciesParameters.CurveType.NIST_P256).setHashType(EciesParameters.HashType.SHA256).setNistCurvePointFormat(EciesParameters.PointFormat.UNCOMPRESSED).setVariant(EciesParameters.Variant.TINK).setDemParameters(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.NO_PREFIX).build()).build());
    }

    public static final KeyTemplate rawEciesP256HkdfHmacSha256Aes128GcmCompressedTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return EciesAeadHkdfPrivateKeyManager.lambda$rawEciesP256HkdfHmacSha256Aes128GcmCompressedTemplate$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$rawEciesP256HkdfHmacSha256Aes128GcmCompressedTemplate$1() throws Exception {
        return KeyTemplate.createFrom(EciesParameters.builder().setCurveType(EciesParameters.CurveType.NIST_P256).setHashType(EciesParameters.HashType.SHA256).setNistCurvePointFormat(EciesParameters.PointFormat.COMPRESSED).setVariant(EciesParameters.Variant.NO_PREFIX).setDemParameters(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.NO_PREFIX).build()).build());
    }

    public static final KeyTemplate eciesP256HkdfHmacSha256Aes128CtrHmacSha256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return EciesAeadHkdfPrivateKeyManager.lambda$eciesP256HkdfHmacSha256Aes128CtrHmacSha256Template$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$eciesP256HkdfHmacSha256Aes128CtrHmacSha256Template$2() throws Exception {
        return KeyTemplate.createFrom(EciesParameters.builder().setCurveType(EciesParameters.CurveType.NIST_P256).setHashType(EciesParameters.HashType.SHA256).setNistCurvePointFormat(EciesParameters.PointFormat.UNCOMPRESSED).setVariant(EciesParameters.Variant.TINK).setDemParameters(AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(16).setHmacKeySizeBytes(32).setTagSizeBytes(16).setIvSizeBytes(16).setHashType(AesCtrHmacAeadParameters.HashType.SHA256).setVariant(AesCtrHmacAeadParameters.Variant.NO_PREFIX).build()).build());
    }

    public static final KeyTemplate rawEciesP256HkdfHmacSha256Aes128CtrHmacSha256CompressedTemplate() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return EciesAeadHkdfPrivateKeyManager.lambda$rawEciesP256HkdfHmacSha256Aes128CtrHmacSha256CompressedTemplate$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$rawEciesP256HkdfHmacSha256Aes128CtrHmacSha256CompressedTemplate$3() throws Exception {
        return KeyTemplate.createFrom(EciesParameters.builder().setCurveType(EciesParameters.CurveType.NIST_P256).setHashType(EciesParameters.HashType.SHA256).setNistCurvePointFormat(EciesParameters.PointFormat.COMPRESSED).setVariant(EciesParameters.Variant.NO_PREFIX).setDemParameters(AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(16).setHmacKeySizeBytes(32).setTagSizeBytes(16).setIvSizeBytes(16).setHashType(AesCtrHmacAeadParameters.HashType.SHA256).setVariant(AesCtrHmacAeadParameters.Variant.NO_PREFIX).build()).build());
    }

    private EciesAeadHkdfPrivateKeyManager() {
    }
}
