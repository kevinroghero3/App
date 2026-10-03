package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.hybrid.HpkePrivateKey;
import com.google.crypto.tink.hybrid.HpkeProtoSerialization;
import com.google.crypto.tink.hybrid.HpkePublicKey;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.KeyCreator;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class HpkePrivateKeyManager {
    private static final PrimitiveConstructor<HpkePrivateKey, HybridDecrypt> HYBRID_DECRYPT_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return HpkeDecrypt.create((HpkePrivateKey) key);
        }
    }, HpkePrivateKey.class, HybridDecrypt.class);
    private static final PrimitiveConstructor<HpkePublicKey, HybridEncrypt> HYBRID_ENCRYPT_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return HpkeEncrypt.create((HpkePublicKey) key);
        }
    }, HpkePublicKey.class, HybridEncrypt.class);
    private static final PrivateKeyManager<HybridDecrypt> legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), HybridDecrypt.class, com.google.crypto.tink.proto.HpkePrivateKey.parser());
    private static final KeyManager<HybridEncrypt> legacyPublicKeyManager = LegacyKeyManagerImpl.create(HpkePublicKeyManager.getKeyType(), HybridEncrypt.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.HpkePublicKey.parser());
    private static final KeyCreator<HpkeParameters> KEY_CREATOR = new HpkePrivateKeyManager$$ExternalSyntheticLambda2();

    /* JADX INFO: Access modifiers changed from: private */
    public static HpkePrivateKey createKey(HpkeParameters hpkeParameters, @Nullable Integer num) throws GeneralSecurityException {
        Bytes bytesCopyFrom;
        SecretBytes secretBytesCopyFrom;
        if (hpkeParameters.getKemId().equals(HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256)) {
            byte[] bArrGeneratePrivateKey = com.google.crypto.tink.subtle.X25519.generatePrivateKey();
            secretBytesCopyFrom = SecretBytes.copyFrom(bArrGeneratePrivateKey, InsecureSecretKeyAccess.get());
            bytesCopyFrom = Bytes.copyFrom(com.google.crypto.tink.subtle.X25519.publicFromPrivate(bArrGeneratePrivateKey));
        } else if (hpkeParameters.getKemId().equals(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) || hpkeParameters.getKemId().equals(HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) || hpkeParameters.getKemId().equals(HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512)) {
            EllipticCurves.CurveType curveTypeNistHpkeKemToCurve = HpkeUtil.nistHpkeKemToCurve(hpkeParameters.getKemId());
            KeyPair keyPairGenerateKeyPair = EllipticCurves.generateKeyPair(curveTypeNistHpkeKemToCurve);
            bytesCopyFrom = Bytes.copyFrom(EllipticCurves.pointEncode(curveTypeNistHpkeKemToCurve, EllipticCurves.PointFormatType.UNCOMPRESSED, ((ECPublicKey) keyPairGenerateKeyPair.getPublic()).getW()));
            secretBytesCopyFrom = SecretBytes.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(((ECPrivateKey) keyPairGenerateKeyPair.getPrivate()).getS(), HpkeUtil.getEncodedPrivateKeyLength(hpkeParameters.getKemId())), InsecureSecretKeyAccess.get());
        } else {
            throw new GeneralSecurityException("Unknown KEM ID");
        }
        return HpkePrivateKey.create(HpkePublicKey.create(hpkeParameters, bytesCopyFrom, num), secretBytesCopyFrom);
    }

    public static void registerPair(boolean z) throws GeneralSecurityException {
        if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
            throw new GeneralSecurityException("Registering HPKE Hybrid Encryption is not supported in FIPS mode");
        }
        HpkeProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(HYBRID_DECRYPT_PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(HYBRID_ENCRYPT_PRIMITIVE_CONSTRUCTOR);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, HpkeParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPrivateKeyManager, z);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPublicKeyManager, false);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        HpkeParameters.Builder builder = HpkeParameters.builder();
        HpkeParameters.Variant variant = HpkeParameters.Variant.TINK;
        HpkeParameters.Builder variant2 = builder.setVariant(variant);
        HpkeParameters.KemId kemId = HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256;
        HpkeParameters.Builder kemId2 = variant2.setKemId(kemId);
        HpkeParameters.KdfId kdfId = HpkeParameters.KdfId.HKDF_SHA256;
        HpkeParameters.Builder kdfId2 = kemId2.setKdfId(kdfId);
        HpkeParameters.AeadId aeadId = HpkeParameters.AeadId.AES_128_GCM;
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", kdfId2.setAeadId(aeadId).build());
        HpkeParameters.Builder builder2 = HpkeParameters.builder();
        HpkeParameters.Variant variant3 = HpkeParameters.Variant.NO_PREFIX;
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", builder2.setVariant(variant3).setKemId(kemId).setKdfId(kdfId).setAeadId(aeadId).build());
        HpkeParameters.Builder kdfId3 = HpkeParameters.builder().setVariant(variant).setKemId(kemId).setKdfId(kdfId);
        HpkeParameters.AeadId aeadId2 = HpkeParameters.AeadId.AES_256_GCM;
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", kdfId3.setAeadId(aeadId2).build());
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", HpkeParameters.builder().setVariant(variant3).setKemId(kemId).setKdfId(kdfId).setAeadId(aeadId2).build());
        HpkeParameters.Builder kdfId4 = HpkeParameters.builder().setVariant(variant).setKemId(kemId).setKdfId(kdfId);
        HpkeParameters.AeadId aeadId3 = HpkeParameters.AeadId.CHACHA20_POLY1305;
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", kdfId4.setAeadId(aeadId3).build());
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", HpkeParameters.builder().setVariant(variant3).setKemId(kemId).setKdfId(kdfId).setAeadId(aeadId3).build());
        HpkeParameters.Builder variant4 = HpkeParameters.builder().setVariant(variant);
        HpkeParameters.KemId kemId3 = HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256;
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", variant4.setKemId(kemId3).setKdfId(kdfId).setAeadId(aeadId).build());
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", HpkeParameters.builder().setVariant(variant3).setKemId(kemId3).setKdfId(kdfId).setAeadId(aeadId).build());
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", HpkeParameters.builder().setVariant(variant).setKemId(kemId3).setKdfId(kdfId).setAeadId(aeadId2).build());
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", HpkeParameters.builder().setVariant(variant3).setKemId(kemId3).setKdfId(kdfId).setAeadId(aeadId2).build());
        HpkeParameters.Builder variant5 = HpkeParameters.builder().setVariant(variant);
        HpkeParameters.KemId kemId4 = HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384;
        HpkeParameters.Builder kemId5 = variant5.setKemId(kemId4);
        HpkeParameters.KdfId kdfId5 = HpkeParameters.KdfId.HKDF_SHA384;
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", kemId5.setKdfId(kdfId5).setAeadId(aeadId).build());
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", HpkeParameters.builder().setVariant(variant3).setKemId(kemId4).setKdfId(kdfId5).setAeadId(aeadId).build());
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", HpkeParameters.builder().setVariant(variant).setKemId(kemId4).setKdfId(kdfId5).setAeadId(aeadId2).build());
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", HpkeParameters.builder().setVariant(variant3).setKemId(kemId4).setKdfId(kdfId5).setAeadId(aeadId2).build());
        HpkeParameters.Builder variant6 = HpkeParameters.builder().setVariant(variant);
        HpkeParameters.KemId kemId6 = HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512;
        HpkeParameters.Builder kemId7 = variant6.setKemId(kemId6);
        HpkeParameters.KdfId kdfId6 = HpkeParameters.KdfId.HKDF_SHA512;
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", kemId7.setKdfId(kdfId6).setAeadId(aeadId).build());
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", HpkeParameters.builder().setVariant(variant3).setKemId(kemId6).setKdfId(kdfId6).setAeadId(aeadId).build());
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", HpkeParameters.builder().setVariant(variant).setKemId(kemId6).setKdfId(kdfId6).setAeadId(aeadId2).build());
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", HpkeParameters.builder().setVariant(variant3).setKemId(kemId6).setKdfId(kdfId6).setAeadId(aeadId2).build());
        return Collections.unmodifiableMap(map);
    }

    private HpkePrivateKeyManager() {
    }
}
