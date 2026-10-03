package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyCreator;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.jwt.internal.JsonUtil;
import com.google.crypto.tink.jwt.internal.JwtFormat;
import com.google.crypto.tink.mac.HmacKey;
import com.google.crypto.tink.mac.HmacParameters;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtHmacKeyManager {
    private static final KeyManager<Void> legacyKeyManager = LegacyKeyManagerImpl.create("type.googleapis.com/google.crypto.tink.JwtHmacKey", Void.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.JwtHmacKey.parser());
    private static final PrimitiveConstructor<JwtHmacKey, JwtMac> PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.jwt.JwtHmacKeyManager$$ExternalSyntheticLambda3
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return JwtHmacKeyManager.createFullJwtHmac((JwtHmacKey) key);
        }
    }, JwtHmacKey.class, JwtMac.class);
    private static final KeyCreator<JwtHmacParameters> KEY_CREATOR = new KeyCreator() { // from class: com.google.crypto.tink.jwt.JwtHmacKeyManager$$ExternalSyntheticLambda4
        @Override // com.google.crypto.tink.internal.KeyCreator
        public final Key createKey(Parameters parameters, Integer num) {
            return JwtHmacKeyManager.createKey((JwtHmacParameters) parameters, num);
        }
    };
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;

    @Immutable
    static final class JwtHmac implements JwtMac {
        private final String algorithm;
        private final JwtHmacKey jwtHmacKey;
        private final Mac mac;

        private JwtHmac(Mac mac, JwtHmacKey jwtHmacKey) {
            this.algorithm = jwtHmacKey.getParameters().getAlgorithm().getStandardName();
            this.mac = mac;
            this.jwtHmacKey = jwtHmacKey;
        }

        @Override // com.google.crypto.tink.jwt.JwtMac
        public String computeMacAndEncode(RawJwt rawJwt) throws GeneralSecurityException {
            String strCreateUnsignedCompact = JwtFormat.createUnsignedCompact(this.algorithm, this.jwtHmacKey.getKid(), rawJwt);
            return JwtFormat.createSignedCompact(strCreateUnsignedCompact, this.mac.computeMac(strCreateUnsignedCompact.getBytes(StandardCharsets.US_ASCII)));
        }

        @Override // com.google.crypto.tink.jwt.JwtMac
        public VerifiedJwt verifyMacAndDecode(String str, JwtValidator jwtValidator) throws GeneralSecurityException {
            JwtFormat.Parts partsSplitSignedCompact = JwtFormat.splitSignedCompact(str);
            this.mac.verifyMac(partsSplitSignedCompact.signatureOrMac, partsSplitSignedCompact.unsignedCompact.getBytes(StandardCharsets.US_ASCII));
            JsonObject json = JsonUtil.parseJson(partsSplitSignedCompact.header);
            JwtFormat.validateHeader(json, this.jwtHmacKey.getParameters().getAlgorithm().getStandardName(), this.jwtHmacKey.getKid(), this.jwtHmacKey.getParameters().allowKidAbsent());
            return jwtValidator.validate(RawJwt.fromJsonPayload(JwtFormat.getTypeHeader(json), partsSplitSignedCompact.payload));
        }
    }

    private static void validate(JwtHmacParameters jwtHmacParameters) throws GeneralSecurityException {
        int i = jwtHmacParameters.getAlgorithm().equals(JwtHmacParameters.Algorithm.HS256) ? 32 : Integer.MAX_VALUE;
        if (jwtHmacParameters.getAlgorithm().equals(JwtHmacParameters.Algorithm.HS384)) {
            i = 48;
        }
        if (jwtHmacParameters.getAlgorithm().equals(JwtHmacParameters.Algorithm.HS512)) {
            i = 64;
        }
        if (jwtHmacParameters.getKeySizeBytes() >= i) {
            return;
        }
        throw new GeneralSecurityException("Key size must be at least " + i);
    }

    private static int getTagLength(JwtHmacParameters.Algorithm algorithm) throws GeneralSecurityException {
        if (algorithm.equals(JwtHmacParameters.Algorithm.HS256)) {
            return 32;
        }
        if (algorithm.equals(JwtHmacParameters.Algorithm.HS384)) {
            return 48;
        }
        if (algorithm.equals(JwtHmacParameters.Algorithm.HS512)) {
            return 64;
        }
        throw new GeneralSecurityException("Unsupported algorithm: " + algorithm);
    }

    private static HmacParameters.HashType getHmacHashType(JwtHmacParameters.Algorithm algorithm) throws GeneralSecurityException {
        if (algorithm.equals(JwtHmacParameters.Algorithm.HS256)) {
            return HmacParameters.HashType.SHA256;
        }
        if (algorithm.equals(JwtHmacParameters.Algorithm.HS384)) {
            return HmacParameters.HashType.SHA384;
        }
        if (algorithm.equals(JwtHmacParameters.Algorithm.HS512)) {
            return HmacParameters.HashType.SHA512;
        }
        throw new GeneralSecurityException("Unsupported algorithm: " + algorithm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtMac createFullJwtHmac(JwtHmacKey jwtHmacKey) throws GeneralSecurityException {
        validate(jwtHmacKey.getParameters());
        return new JwtHmac(PrfMac.create(HmacKey.builder().setParameters(HmacParameters.builder().setKeySizeBytes(jwtHmacKey.getParameters().getKeySizeBytes()).setHashType(getHmacHashType(jwtHmacKey.getParameters().getAlgorithm())).setTagSizeBytes(getTagLength(jwtHmacKey.getParameters().getAlgorithm())).build()).setKeyBytes(jwtHmacKey.getKeyBytes()).build()), jwtHmacKey);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtHmacKey";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtHmacKey createKey(JwtHmacParameters jwtHmacParameters, @Nullable Integer num) throws GeneralSecurityException {
        validate(jwtHmacParameters);
        JwtHmacKey.Builder keyBytes = JwtHmacKey.builder().setParameters(jwtHmacParameters).setKeyBytes(SecretBytes.randomBytes(jwtHmacParameters.getKeySizeBytes()));
        if (jwtHmacParameters.hasIdRequirement()) {
            if (num == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            keyBytes.setIdRequirement(num.intValue());
        }
        return keyBytes.build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap map = new HashMap();
        JwtHmacParameters.Builder keySizeBytes = JwtHmacParameters.builder().setKeySizeBytes(32);
        JwtHmacParameters.Algorithm algorithm = JwtHmacParameters.Algorithm.HS256;
        JwtHmacParameters.Builder algorithm2 = keySizeBytes.setAlgorithm(algorithm);
        JwtHmacParameters.KidStrategy kidStrategy = JwtHmacParameters.KidStrategy.IGNORED;
        map.put("JWT_HS256_RAW", algorithm2.setKidStrategy(kidStrategy).build());
        JwtHmacParameters.Builder algorithm3 = JwtHmacParameters.builder().setKeySizeBytes(32).setAlgorithm(algorithm);
        JwtHmacParameters.KidStrategy kidStrategy2 = JwtHmacParameters.KidStrategy.BASE64_ENCODED_KEY_ID;
        map.put("JWT_HS256", algorithm3.setKidStrategy(kidStrategy2).build());
        JwtHmacParameters.Builder keySizeBytes2 = JwtHmacParameters.builder().setKeySizeBytes(48);
        JwtHmacParameters.Algorithm algorithm4 = JwtHmacParameters.Algorithm.HS384;
        map.put("JWT_HS384_RAW", keySizeBytes2.setAlgorithm(algorithm4).setKidStrategy(kidStrategy).build());
        map.put("JWT_HS384", JwtHmacParameters.builder().setKeySizeBytes(48).setAlgorithm(algorithm4).setKidStrategy(kidStrategy2).build());
        JwtHmacParameters.Builder keySizeBytes3 = JwtHmacParameters.builder().setKeySizeBytes(64);
        JwtHmacParameters.Algorithm algorithm5 = JwtHmacParameters.Algorithm.HS512;
        map.put("JWT_HS512_RAW", keySizeBytes3.setAlgorithm(algorithm5).setKidStrategy(kidStrategy).build());
        map.put("JWT_HS512", JwtHmacParameters.builder().setKeySizeBytes(64).setAlgorithm(algorithm5).setKidStrategy(kidStrategy2).build());
        return Collections.unmodifiableMap(map);
    }

    public TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus() {
        return FIPS;
    }

    public static void register(boolean z) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility algorithmFipsCompatibility = FIPS;
        if (!algorithmFipsCompatibility.isCompatible()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        JwtHmacProtoSerialization.register();
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, JwtHmacParameters.class);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyKeyManager, algorithmFipsCompatibility, z);
    }

    public static final KeyTemplate hs256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.jwt.JwtHmacKeyManager$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return JwtHmacKeyManager.lambda$hs256Template$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$hs256Template$0() throws Exception {
        return KeyTemplate.createFrom(JwtHmacParameters.builder().setKeySizeBytes(32).setKidStrategy(JwtHmacParameters.KidStrategy.IGNORED).setAlgorithm(JwtHmacParameters.Algorithm.HS256).build());
    }

    public static final KeyTemplate hs384Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.jwt.JwtHmacKeyManager$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return JwtHmacKeyManager.lambda$hs384Template$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$hs384Template$1() throws Exception {
        return KeyTemplate.createFrom(JwtHmacParameters.builder().setKeySizeBytes(48).setKidStrategy(JwtHmacParameters.KidStrategy.IGNORED).setAlgorithm(JwtHmacParameters.Algorithm.HS384).build());
    }

    public static final KeyTemplate hs512Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.jwt.JwtHmacKeyManager$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
            public final Object get() {
                return JwtHmacKeyManager.lambda$hs512Template$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyTemplate lambda$hs512Template$2() throws Exception {
        return KeyTemplate.createFrom(JwtHmacParameters.builder().setKeySizeBytes(64).setKidStrategy(JwtHmacParameters.KidStrategy.IGNORED).setAlgorithm(JwtHmacParameters.Algorithm.HS512).build());
    }

    private JwtHmacKeyManager() {
    }
}
