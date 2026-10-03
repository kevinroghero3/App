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
import com.google.crypto.tink.jwt.internal.JwtFormat;
import com.google.crypto.tink.jwt.internal.JwtRsaSsaPssProtoSerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.signature.RsaSsaPssPrivateKey;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.RsaSsaPssSignJce;
import com.google.crypto.tink.util.SecretBigInteger;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtRsaSsaPssSignKeyManager {
    private static final PrivateKeyManager<Void> legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), Void.class, com.google.crypto.tink.proto.JwtRsaSsaPssPrivateKey.parser());
    private static final KeyManager<Void> legacyPublicKeyManager = LegacyKeyManagerImpl.create(JwtRsaSsaPssVerifyKeyManager.getKeyType(), Void.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey.parser());
    private static final KeyCreator<JwtRsaSsaPssParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPssSignKeyManager$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return JwtRsaSsaPssSignKeyManager.createKey((JwtRsaSsaPssParameters) parameters, num);
        }
    };
    private static final PrimitiveConstructor<JwtRsaSsaPssPrivateKey, JwtPublicKeySign> PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPssSignKeyManager$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return JwtRsaSsaPssSignKeyManager.createFullPrimitive((JwtRsaSsaPssPrivateKey) key);
        }
    }, JwtRsaSsaPssPrivateKey.class, JwtPublicKeySign.class);
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtRsaSsaPssPrivateKey createKey(JwtRsaSsaPssParameters jwtRsaSsaPssParameters, @Nullable Integer num) throws GeneralSecurityException {
        KeyPairGenerator engineFactory = EngineFactory.KEY_PAIR_GENERATOR.getInstance("RSA");
        engineFactory.initialize(new RSAKeyGenParameterSpec(jwtRsaSsaPssParameters.getModulusSizeBits(), new BigInteger(1, jwtRsaSsaPssParameters.getPublicExponent().toByteArray())));
        KeyPair keyPairGenerateKeyPair = engineFactory.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) keyPairGenerateKeyPair.getPublic();
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) keyPairGenerateKeyPair.getPrivate();
        JwtRsaSsaPssPublicKey.Builder modulus = JwtRsaSsaPssPublicKey.builder().setParameters(jwtRsaSsaPssParameters).setModulus(rSAPublicKey.getModulus());
        if (num != null) {
            modulus.setIdRequirement(num);
        }
        return JwtRsaSsaPssPrivateKey.builder().setPublicKey(modulus.build()).setPrimes(SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrimeP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrimeQ(), InsecureSecretKeyAccess.get())).setPrivateExponent(SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrivateExponent(), InsecureSecretKeyAccess.get())).setPrimeExponents(SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrimeExponentP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrimeExponentQ(), InsecureSecretKeyAccess.get())).setCrtCoefficient(SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getCrtCoefficient(), InsecureSecretKeyAccess.get())).build();
    }

    private static RsaSsaPssPrivateKey toRsaSsaPssPrivateKey(JwtRsaSsaPssPrivateKey jwtRsaSsaPssPrivateKey) {
        return jwtRsaSsaPssPrivateKey.getRsaSsaPssPrivateKey();
    }

    static JwtPublicKeySign createFullPrimitive(final JwtRsaSsaPssPrivateKey jwtRsaSsaPssPrivateKey) throws GeneralSecurityException {
        final PublicKeySign publicKeySignCreate = RsaSsaPssSignJce.create(toRsaSsaPssPrivateKey(jwtRsaSsaPssPrivateKey));
        final String standardName = jwtRsaSsaPssPrivateKey.getParameters().getAlgorithm().getStandardName();
        return new JwtPublicKeySign() { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPssSignKeyManager.1
            @Override // com.google.crypto.tink.jwt.JwtPublicKeySign
            public String signAndEncode(RawJwt rawJwt) throws GeneralSecurityException {
                String strCreateUnsignedCompact = JwtFormat.createUnsignedCompact(standardName, jwtRsaSsaPssPrivateKey.getPublicKey().getKid(), rawJwt);
                return JwtFormat.createSignedCompact(strCreateUnsignedCompact, publicKeySignCreate.sign(strCreateUnsignedCompact.getBytes(StandardCharsets.US_ASCII)));
            }
        };
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPrivateKey";
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        JwtRsaSsaPssParameters.Builder modulusSizeBits = JwtRsaSsaPssParameters.builder().setModulusSizeBits(2048);
        BigInteger bigInteger = JwtRsaSsaPssParameters.F4;
        JwtRsaSsaPssParameters.Builder publicExponent = modulusSizeBits.setPublicExponent(bigInteger);
        JwtRsaSsaPssParameters.Algorithm algorithm = JwtRsaSsaPssParameters.Algorithm.PS256;
        JwtRsaSsaPssParameters.Builder algorithm2 = publicExponent.setAlgorithm(algorithm);
        JwtRsaSsaPssParameters.KidStrategy kidStrategy = JwtRsaSsaPssParameters.KidStrategy.IGNORED;
        map.put("JWT_PS256_2048_F4_RAW", algorithm2.setKidStrategy(kidStrategy).build());
        JwtRsaSsaPssParameters.Builder algorithm3 = JwtRsaSsaPssParameters.builder().setModulusSizeBits(2048).setPublicExponent(bigInteger).setAlgorithm(algorithm);
        JwtRsaSsaPssParameters.KidStrategy kidStrategy2 = JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID;
        map.put("JWT_PS256_2048_F4", algorithm3.setKidStrategy(kidStrategy2).build());
        map.put("JWT_PS256_3072_F4_RAW", JwtRsaSsaPssParameters.builder().setModulusSizeBits(3072).setPublicExponent(bigInteger).setAlgorithm(algorithm).setKidStrategy(kidStrategy).build());
        map.put("JWT_PS256_3072_F4", JwtRsaSsaPssParameters.builder().setModulusSizeBits(3072).setPublicExponent(bigInteger).setAlgorithm(algorithm).setKidStrategy(kidStrategy2).build());
        JwtRsaSsaPssParameters.Builder publicExponent2 = JwtRsaSsaPssParameters.builder().setModulusSizeBits(3072).setPublicExponent(bigInteger);
        JwtRsaSsaPssParameters.Algorithm algorithm4 = JwtRsaSsaPssParameters.Algorithm.PS384;
        map.put("JWT_PS384_3072_F4_RAW", publicExponent2.setAlgorithm(algorithm4).setKidStrategy(kidStrategy).build());
        map.put("JWT_PS384_3072_F4", JwtRsaSsaPssParameters.builder().setModulusSizeBits(3072).setPublicExponent(bigInteger).setAlgorithm(algorithm4).setKidStrategy(kidStrategy2).build());
        JwtRsaSsaPssParameters.Builder publicExponent3 = JwtRsaSsaPssParameters.builder().setModulusSizeBits(4096).setPublicExponent(bigInteger);
        JwtRsaSsaPssParameters.Algorithm algorithm5 = JwtRsaSsaPssParameters.Algorithm.PS512;
        map.put("JWT_PS512_4096_F4_RAW", publicExponent3.setAlgorithm(algorithm5).setKidStrategy(kidStrategy).build());
        map.put("JWT_PS512_4096_F4", JwtRsaSsaPssParameters.builder().setModulusSizeBits(4096).setPublicExponent(bigInteger).setAlgorithm(algorithm5).setKidStrategy(kidStrategy2).build());
        return Collections.unmodifiableMap(map);
    }

    public static void registerPair(boolean z) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility algorithmFipsCompatibility = FIPS;
        if (!algorithmFipsCompatibility.isCompatible()) {
            throw new GeneralSecurityException("Can not use RSA SSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        JwtRsaSsaPssProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(JwtRsaSsaPssVerifyKeyManager.PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, JwtRsaSsaPssParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPrivateKeyManager, algorithmFipsCompatibility, z);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPublicKeyManager, algorithmFipsCompatibility, false);
    }

    private JwtRsaSsaPssSignKeyManager() {
    }
}
