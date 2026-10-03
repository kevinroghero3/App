package com.google.crypto.tink.signature;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyCreator;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.signature.internal.EcdsaProtoSerialization;
import com.google.crypto.tink.subtle.EcdsaSignJce;
import com.google.crypto.tink.subtle.EcdsaVerifyJce;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.util.SecretBigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class EcdsaSignKeyManager {
    private static final PrimitiveConstructor<EcdsaPrivateKey, PublicKeySign> PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.signature.EcdsaSignKeyManager$$ExternalSyntheticLambda2
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return EcdsaSignJce.create((EcdsaPrivateKey) key);
        }
    }, EcdsaPrivateKey.class, PublicKeySign.class);
    private static final PrimitiveConstructor<EcdsaPublicKey, PublicKeyVerify> PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.signature.EcdsaSignKeyManager$$ExternalSyntheticLambda3
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return EcdsaVerifyJce.create((EcdsaPublicKey) key);
        }
    }, EcdsaPublicKey.class, PublicKeyVerify.class);
    private static final PrivateKeyManager<PublicKeySign> legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), PublicKeySign.class, com.google.crypto.tink.proto.EcdsaPrivateKey.parser());
    private static final KeyManager<PublicKeyVerify> legacyPublicKeyManager = LegacyKeyManagerImpl.create(EcdsaVerifyKeyManager.getKeyType(), PublicKeyVerify.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.EcdsaPublicKey.parser());
    private static final KeyCreator<EcdsaParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.signature.EcdsaSignKeyManager$$ExternalSyntheticLambda4
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return EcdsaSignKeyManager.createKey((EcdsaParameters) parameters, num);
        }
    };
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EcdsaPrivateKey createKey(EcdsaParameters ecdsaParameters, @Nullable Integer num) throws GeneralSecurityException {
        KeyPair keyPairGenerateKeyPair = EllipticCurves.generateKeyPair(ecdsaParameters.getCurveType().toParameterSpec());
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairGenerateKeyPair.getPrivate();
        return EcdsaPrivateKey.builder().setPublicKey(EcdsaPublicKey.builder().setParameters(ecdsaParameters).setIdRequirement(num).setPublicPoint(eCPublicKey.getW()).build()).setPrivateValue(SecretBigInteger.fromBigInteger(eCPrivateKey.getS(), InsecureSecretKeyAccess.get())).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("ECDSA_P256", PredefinedSignatureParameters.ECDSA_P256);
        map.put("ECDSA_P256_IEEE_P1363", PredefinedSignatureParameters.ECDSA_P256_IEEE_P1363);
        map.put("ECDSA_P256_RAW", EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA256).setCurveType(EcdsaParameters.CurveType.NIST_P256).setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setVariant(EcdsaParameters.Variant.NO_PREFIX).build());
        map.put("ECDSA_P256_IEEE_P1363_WITHOUT_PREFIX", PredefinedSignatureParameters.ECDSA_P256_IEEE_P1363_WITHOUT_PREFIX);
        map.put("ECDSA_P384", PredefinedSignatureParameters.ECDSA_P384);
        map.put("ECDSA_P384_IEEE_P1363", PredefinedSignatureParameters.ECDSA_P384_IEEE_P1363);
        EcdsaParameters.Builder hashType = EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA512);
        EcdsaParameters.CurveType curveType = EcdsaParameters.CurveType.NIST_P384;
        EcdsaParameters.Builder curveType2 = hashType.setCurveType(curveType);
        EcdsaParameters.SignatureEncoding signatureEncoding = EcdsaParameters.SignatureEncoding.DER;
        EcdsaParameters.Builder signatureEncoding2 = curveType2.setSignatureEncoding(signatureEncoding);
        EcdsaParameters.Variant variant = EcdsaParameters.Variant.TINK;
        map.put("ECDSA_P384_SHA512", signatureEncoding2.setVariant(variant).build());
        map.put("ECDSA_P384_SHA384", EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA384).setCurveType(curveType).setSignatureEncoding(signatureEncoding).setVariant(variant).build());
        map.put("ECDSA_P521", PredefinedSignatureParameters.ECDSA_P521);
        map.put("ECDSA_P521_IEEE_P1363", PredefinedSignatureParameters.ECDSA_P521_IEEE_P1363);
        return Collections.unmodifiableMap(map);
    }

    public static void registerPair(boolean z) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility algorithmFipsCompatibility = FIPS;
        if (!algorithmFipsCompatibility.isCompatible()) {
            throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto module is not available.");
        }
        EcdsaProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, EcdsaParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPrivateKeyManager, algorithmFipsCompatibility, z);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPublicKeyManager, algorithmFipsCompatibility, false);
    }

    public static final KeyTemplate ecdsaP256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.EcdsaSignKeyManager$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return EcdsaSignKeyManager.lambda$ecdsaP256Template$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$ecdsaP256Template$0() throws Exception {
        return KeyTemplate.createFrom(EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.DER).setCurveType(EcdsaParameters.CurveType.NIST_P256).setHashType(EcdsaParameters.HashType.SHA256).setVariant(EcdsaParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawEcdsaP256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.signature.EcdsaSignKeyManager$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return EcdsaSignKeyManager.lambda$rawEcdsaP256Template$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$rawEcdsaP256Template$1() throws Exception {
        return KeyTemplate.createFrom(EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setCurveType(EcdsaParameters.CurveType.NIST_P256).setHashType(EcdsaParameters.HashType.SHA256).setVariant(EcdsaParameters.Variant.NO_PREFIX).build());
    }

    private EcdsaSignKeyManager() {
    }
}
