package com.google.crypto.tink.jwt;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyCreator;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.jwt.internal.JwtEcdsaProtoSerialization;
import com.google.crypto.tink.jwt.internal.JwtFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.signature.EcdsaPrivateKey;
import com.google.crypto.tink.subtle.EcdsaSignJce;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.util.SecretBigInteger;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtEcdsaSignKeyManager {
    private static final PrivateKeyManager<Void> legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), Void.class, com.google.crypto.tink.proto.JwtEcdsaPrivateKey.parser());
    private static final KeyManager<Void> legacyPublicKeyManager = LegacyKeyManagerImpl.create(JwtEcdsaVerifyKeyManager.getKeyType(), Void.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.JwtEcdsaPublicKey.parser());
    private static final PrimitiveConstructor<JwtEcdsaPrivateKey, JwtPublicKeySign> PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.jwt.JwtEcdsaSignKeyManager$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return JwtEcdsaSignKeyManager.createFullPrimitive((JwtEcdsaPrivateKey) key);
        }
    }, JwtEcdsaPrivateKey.class, JwtPublicKeySign.class);
    private static final KeyCreator<JwtEcdsaParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.jwt.JwtEcdsaSignKeyManager$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return JwtEcdsaSignKeyManager.createKey((JwtEcdsaParameters) parameters, num);
        }
    };
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;

    private static EcdsaPrivateKey toEcdsaPrivateKey(JwtEcdsaPrivateKey jwtEcdsaPrivateKey) throws GeneralSecurityException {
        return jwtEcdsaPrivateKey.getEcdsaPrivateKey();
    }

    static JwtPublicKeySign createFullPrimitive(final JwtEcdsaPrivateKey jwtEcdsaPrivateKey) throws GeneralSecurityException {
        final PublicKeySign publicKeySignCreate = EcdsaSignJce.create(toEcdsaPrivateKey(jwtEcdsaPrivateKey));
        final String standardName = jwtEcdsaPrivateKey.getParameters().getAlgorithm().getStandardName();
        return new JwtPublicKeySign() { // from class: com.google.crypto.tink.jwt.JwtEcdsaSignKeyManager.1
            @Override // com.google.crypto.tink.jwt.JwtPublicKeySign
            public String signAndEncode(RawJwt rawJwt) throws GeneralSecurityException {
                String strCreateUnsignedCompact = JwtFormat.createUnsignedCompact(standardName, jwtEcdsaPrivateKey.getPublicKey().getKid(), rawJwt);
                return JwtFormat.createSignedCompact(strCreateUnsignedCompact, publicKeySignCreate.sign(strCreateUnsignedCompact.getBytes(StandardCharsets.US_ASCII)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtEcdsaPrivateKey createKey(JwtEcdsaParameters jwtEcdsaParameters, @Nullable Integer num) throws GeneralSecurityException {
        KeyPair keyPairGenerateKeyPair = EllipticCurves.generateKeyPair(jwtEcdsaParameters.getAlgorithm().getEcParameterSpec());
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairGenerateKeyPair.getPrivate();
        JwtEcdsaPublicKey.Builder publicPoint = JwtEcdsaPublicKey.builder().setParameters(jwtEcdsaParameters).setPublicPoint(eCPublicKey.getW());
        if (num != null) {
            publicPoint.setIdRequirement(num);
        }
        return JwtEcdsaPrivateKey.create(publicPoint.build(), SecretBigInteger.fromBigInteger(eCPrivateKey.getS(), InsecureSecretKeyAccess.get()));
    }

    private JwtEcdsaSignKeyManager() {
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtEcdsaPrivateKey";
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        JwtEcdsaParameters.Builder builder = JwtEcdsaParameters.builder();
        JwtEcdsaParameters.Algorithm algorithm = JwtEcdsaParameters.Algorithm.ES256;
        JwtEcdsaParameters.Builder algorithm2 = builder.setAlgorithm(algorithm);
        JwtEcdsaParameters.KidStrategy kidStrategy = JwtEcdsaParameters.KidStrategy.IGNORED;
        map.put("JWT_ES256_RAW", algorithm2.setKidStrategy(kidStrategy).build());
        JwtEcdsaParameters.Builder algorithm3 = JwtEcdsaParameters.builder().setAlgorithm(algorithm);
        JwtEcdsaParameters.KidStrategy kidStrategy2 = JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID;
        map.put("JWT_ES256", algorithm3.setKidStrategy(kidStrategy2).build());
        JwtEcdsaParameters.Builder builder2 = JwtEcdsaParameters.builder();
        JwtEcdsaParameters.Algorithm algorithm4 = JwtEcdsaParameters.Algorithm.ES384;
        map.put("JWT_ES384_RAW", builder2.setAlgorithm(algorithm4).setKidStrategy(kidStrategy).build());
        map.put("JWT_ES384", JwtEcdsaParameters.builder().setAlgorithm(algorithm4).setKidStrategy(kidStrategy2).build());
        JwtEcdsaParameters.Builder builder3 = JwtEcdsaParameters.builder();
        JwtEcdsaParameters.Algorithm algorithm5 = JwtEcdsaParameters.Algorithm.ES512;
        map.put("JWT_ES512_RAW", builder3.setAlgorithm(algorithm5).setKidStrategy(kidStrategy).build());
        map.put("JWT_ES512", JwtEcdsaParameters.builder().setAlgorithm(algorithm5).setKidStrategy(kidStrategy2).build());
        return Collections.unmodifiableMap(map);
    }

    public static void registerPair(boolean z) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility algorithmFipsCompatibility = FIPS;
        if (!algorithmFipsCompatibility.isCompatible()) {
            throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto module is not available.");
        }
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPrivateKeyManager, algorithmFipsCompatibility, z);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPublicKeyManager, algorithmFipsCompatibility, false);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, JwtEcdsaParameters.class);
        JwtEcdsaProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(JwtEcdsaVerifyKeyManager.PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
    }
}
