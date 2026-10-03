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
import com.google.crypto.tink.jwt.internal.JwtRsaSsaPkcs1ProtoSerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.RsaSsaPkcs1SignJce;
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
public final class JwtRsaSsaPkcs1SignKeyManager {
    private static final PrivateKeyManager<Void> legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), Void.class, com.google.crypto.tink.proto.JwtRsaSsaPkcs1PrivateKey.parser());
    private static final KeyManager<Void> legacyPublicKeyManager = LegacyKeyManagerImpl.create(JwtRsaSsaPkcs1VerifyKeyManager.getKeyType(), Void.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey.parser());
    private static final PrimitiveConstructor<JwtRsaSsaPkcs1PrivateKey, JwtPublicKeySign> PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1SignKeyManager$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return JwtRsaSsaPkcs1SignKeyManager.createFullPrimitive((JwtRsaSsaPkcs1PrivateKey) key);
        }
    }, JwtRsaSsaPkcs1PrivateKey.class, JwtPublicKeySign.class);
    private static final KeyCreator<JwtRsaSsaPkcs1Parameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1SignKeyManager$$ExternalSyntheticLambda1
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return JwtRsaSsaPkcs1SignKeyManager.createKey((JwtRsaSsaPkcs1Parameters) parameters, num);
        }
    };
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;

    static RsaSsaPkcs1PrivateKey toRsaSsaPkcs1PrivateKey(JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey) throws GeneralSecurityException {
        return jwtRsaSsaPkcs1PrivateKey.getRsaSsaPkcs1PrivateKey();
    }

    static JwtPublicKeySign createFullPrimitive(final JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey) throws GeneralSecurityException {
        final PublicKeySign publicKeySignCreate = RsaSsaPkcs1SignJce.create(toRsaSsaPkcs1PrivateKey(jwtRsaSsaPkcs1PrivateKey));
        final String standardName = jwtRsaSsaPkcs1PrivateKey.getParameters().getAlgorithm().getStandardName();
        return new JwtPublicKeySign() { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1SignKeyManager.1
            @Override // com.google.crypto.tink.jwt.JwtPublicKeySign
            public String signAndEncode(RawJwt rawJwt) throws GeneralSecurityException {
                String strCreateUnsignedCompact = JwtFormat.createUnsignedCompact(standardName, jwtRsaSsaPkcs1PrivateKey.getPublicKey().getKid(), rawJwt);
                return JwtFormat.createSignedCompact(strCreateUnsignedCompact, publicKeySignCreate.sign(strCreateUnsignedCompact.getBytes(StandardCharsets.US_ASCII)));
            }
        };
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PrivateKey";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtRsaSsaPkcs1PrivateKey createKey(JwtRsaSsaPkcs1Parameters jwtRsaSsaPkcs1Parameters, @Nullable Integer num) throws GeneralSecurityException {
        KeyPairGenerator engineFactory = EngineFactory.KEY_PAIR_GENERATOR.getInstance("RSA");
        engineFactory.initialize(new RSAKeyGenParameterSpec(jwtRsaSsaPkcs1Parameters.getModulusSizeBits(), new BigInteger(1, jwtRsaSsaPkcs1Parameters.getPublicExponent().toByteArray())));
        KeyPair keyPairGenerateKeyPair = engineFactory.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) keyPairGenerateKeyPair.getPublic();
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) keyPairGenerateKeyPair.getPrivate();
        JwtRsaSsaPkcs1PublicKey.Builder modulus = JwtRsaSsaPkcs1PublicKey.builder().setParameters(jwtRsaSsaPkcs1Parameters).setModulus(rSAPublicKey.getModulus());
        if (num != null) {
            modulus.setIdRequirement(num);
        }
        return JwtRsaSsaPkcs1PrivateKey.builder().setPublicKey(modulus.build()).setPrimes(SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrimeP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrimeQ(), InsecureSecretKeyAccess.get())).setPrivateExponent(SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrivateExponent(), InsecureSecretKeyAccess.get())).setPrimeExponents(SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrimeExponentP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getPrimeExponentQ(), InsecureSecretKeyAccess.get())).setCrtCoefficient(SecretBigInteger.fromBigInteger(rSAPrivateCrtKey.getCrtCoefficient(), InsecureSecretKeyAccess.get())).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        JwtRsaSsaPkcs1Parameters.Builder modulusSizeBits = JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(2048);
        BigInteger bigInteger = JwtRsaSsaPkcs1Parameters.F4;
        JwtRsaSsaPkcs1Parameters.Builder publicExponent = modulusSizeBits.setPublicExponent(bigInteger);
        JwtRsaSsaPkcs1Parameters.Algorithm algorithm = JwtRsaSsaPkcs1Parameters.Algorithm.RS256;
        JwtRsaSsaPkcs1Parameters.Builder algorithm2 = publicExponent.setAlgorithm(algorithm);
        JwtRsaSsaPkcs1Parameters.KidStrategy kidStrategy = JwtRsaSsaPkcs1Parameters.KidStrategy.IGNORED;
        map.put("JWT_RS256_2048_F4_RAW", algorithm2.setKidStrategy(kidStrategy).build());
        JwtRsaSsaPkcs1Parameters.Builder algorithm3 = JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(2048).setPublicExponent(bigInteger).setAlgorithm(algorithm);
        JwtRsaSsaPkcs1Parameters.KidStrategy kidStrategy2 = JwtRsaSsaPkcs1Parameters.KidStrategy.BASE64_ENCODED_KEY_ID;
        map.put("JWT_RS256_2048_F4", algorithm3.setKidStrategy(kidStrategy2).build());
        map.put("JWT_RS256_3072_F4_RAW", JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(3072).setPublicExponent(bigInteger).setAlgorithm(algorithm).setKidStrategy(kidStrategy).build());
        map.put("JWT_RS256_3072_F4", JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(3072).setPublicExponent(bigInteger).setAlgorithm(algorithm).setKidStrategy(kidStrategy2).build());
        JwtRsaSsaPkcs1Parameters.Builder publicExponent2 = JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(3072).setPublicExponent(bigInteger);
        JwtRsaSsaPkcs1Parameters.Algorithm algorithm4 = JwtRsaSsaPkcs1Parameters.Algorithm.RS384;
        map.put("JWT_RS384_3072_F4_RAW", publicExponent2.setAlgorithm(algorithm4).setKidStrategy(kidStrategy).build());
        map.put("JWT_RS384_3072_F4", JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(3072).setPublicExponent(bigInteger).setAlgorithm(algorithm4).setKidStrategy(kidStrategy2).build());
        JwtRsaSsaPkcs1Parameters.Builder publicExponent3 = JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(4096).setPublicExponent(bigInteger);
        JwtRsaSsaPkcs1Parameters.Algorithm algorithm5 = JwtRsaSsaPkcs1Parameters.Algorithm.RS512;
        map.put("JWT_RS512_4096_F4_RAW", publicExponent3.setAlgorithm(algorithm5).setKidStrategy(kidStrategy).build());
        map.put("JWT_RS512_4096_F4", JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(4096).setPublicExponent(bigInteger).setAlgorithm(algorithm5).setKidStrategy(kidStrategy2).build());
        return Collections.unmodifiableMap(map);
    }

    public static void registerPair(boolean z) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility algorithmFipsCompatibility = FIPS;
        if (!algorithmFipsCompatibility.isCompatible()) {
            throw new GeneralSecurityException("Can not use RSA SSA PKCS1 in FIPS-mode, as BoringCrypto module is not available.");
        }
        JwtRsaSsaPkcs1ProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(JwtRsaSsaPkcs1VerifyKeyManager.PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, JwtRsaSsaPkcs1Parameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPrivateKeyManager, algorithmFipsCompatibility, z);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPublicKeyManager, algorithmFipsCompatibility, false);
    }

    private JwtRsaSsaPkcs1SignKeyManager() {
    }
}
