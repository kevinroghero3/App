package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Configuration;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.jwt.internal.JsonUtil;
import com.google.crypto.tink.jwt.internal.JwtFormat;
import com.google.crypto.tink.signature.EcdsaPrivateKey;
import com.google.crypto.tink.signature.EcdsaPublicKey;
import com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.signature.RsaSsaPssPrivateKey;
import com.google.crypto.tink.signature.RsaSsaPssPublicKey;
import com.google.crypto.tink.subtle.EcdsaSignJce;
import com.google.crypto.tink.subtle.EcdsaVerifyJce;
import com.google.crypto.tink.subtle.RsaSsaPkcs1SignJce;
import com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce;
import com.google.crypto.tink.subtle.RsaSsaPssSignJce;
import com.google.crypto.tink.subtle.RsaSsaPssVerifyJce;
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class JwtSignatureConfigurationV0 {
    private static final JwtPublicKeySignWrapper JWT_PUBLIC_KEY_SIGN_WRAPPER = new JwtPublicKeySignWrapper();
    private static final JwtPublicKeyVerifyWrapper JWT_PUBLIC_KEY_VERIFY_WRAPPER = new JwtPublicKeyVerifyWrapper();
    private static final Configuration CONFIGURATION = create();
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ JwtPublicKeyVerify access$200(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createJwtPublicKeyVerify(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ JwtPublicKeySign access$300(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return createJwtPublicKeySign(entry);
    }

    private JwtSignatureConfigurationV0() {
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtSignatureConfigurationV0$1, reason: invalid class name */
    class AnonymousClass1 implements Configuration {
        AnonymousClass1() {
        }

        @Override // com.google.crypto.tink.Configuration
        public <P> P createPrimitive(KeysetHandleInterface keysetHandleInterface, Class<P> cls) throws GeneralSecurityException {
            if (cls == JwtPublicKeySign.class) {
                return cls.cast(JwtSignatureConfigurationV0.JWT_PUBLIC_KEY_SIGN_WRAPPER.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.jwt.JwtSignatureConfigurationV0$1$$ExternalSyntheticLambda0
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return JwtSignatureConfigurationV0.access$300(entry);
                    }
                }));
            }
            if (cls == JwtPublicKeyVerify.class) {
                return cls.cast(JwtSignatureConfigurationV0.JWT_PUBLIC_KEY_VERIFY_WRAPPER.wrap(keysetHandleInterface, new PrimitiveWrapper.PrimitiveFactory() { // from class: com.google.crypto.tink.jwt.JwtSignatureConfigurationV0$1$$ExternalSyntheticLambda1
                    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
                    public final Object create(KeysetHandleInterface.Entry entry) {
                        return JwtSignatureConfigurationV0.access$200(entry);
                    }
                }));
            }
            throw new GeneralSecurityException("JwtSignatureConfigurationV0 can only create JwtPublicKeySign and JwtPublicKeyVerify");
        }
    }

    private static Configuration create() {
        return new AnonymousClass1();
    }

    private static EcdsaPublicKey toEcdsaPublicKey(JwtEcdsaPublicKey jwtEcdsaPublicKey) {
        return jwtEcdsaPublicKey.getEcdsaPublicKey();
    }

    private static EcdsaPrivateKey toEcdsaPrivateKey(JwtEcdsaPrivateKey jwtEcdsaPrivateKey) throws GeneralSecurityException {
        return jwtEcdsaPrivateKey.getEcdsaPrivateKey();
    }

    private static JwtPublicKeySign createJwtEcdsaSign(final JwtEcdsaPrivateKey jwtEcdsaPrivateKey) throws GeneralSecurityException {
        final PublicKeySign publicKeySignCreate = EcdsaSignJce.create(toEcdsaPrivateKey(jwtEcdsaPrivateKey));
        final String standardName = jwtEcdsaPrivateKey.getParameters().getAlgorithm().getStandardName();
        return new JwtPublicKeySign() { // from class: com.google.crypto.tink.jwt.JwtSignatureConfigurationV0$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.jwt.JwtPublicKeySign
            public final String signAndEncode(RawJwt rawJwt) {
                return JwtSignatureConfigurationV0.lambda$createJwtEcdsaSign$0(standardName, jwtEcdsaPrivateKey, publicKeySignCreate, rawJwt);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createJwtEcdsaSign$0(String str, JwtEcdsaPrivateKey jwtEcdsaPrivateKey, PublicKeySign publicKeySign, RawJwt rawJwt) throws GeneralSecurityException {
        String strCreateUnsignedCompact = JwtFormat.createUnsignedCompact(str, jwtEcdsaPrivateKey.getPublicKey().getKid(), rawJwt);
        return JwtFormat.createSignedCompact(strCreateUnsignedCompact, publicKeySign.sign(strCreateUnsignedCompact.getBytes(StandardCharsets.US_ASCII)));
    }

    private static RsaSsaPkcs1PrivateKey toRsaSsaPkcs1PrivateKey(JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey) {
        return jwtRsaSsaPkcs1PrivateKey.getRsaSsaPkcs1PrivateKey();
    }

    private static JwtPublicKeySign createJwtRsaSsaPkcs1Sign(final JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey) throws GeneralSecurityException {
        final PublicKeySign publicKeySignCreate = RsaSsaPkcs1SignJce.create(toRsaSsaPkcs1PrivateKey(jwtRsaSsaPkcs1PrivateKey));
        final String standardName = jwtRsaSsaPkcs1PrivateKey.getParameters().getAlgorithm().getStandardName();
        return new JwtPublicKeySign() { // from class: com.google.crypto.tink.jwt.JwtSignatureConfigurationV0$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.jwt.JwtPublicKeySign
            public final String signAndEncode(RawJwt rawJwt) {
                return JwtSignatureConfigurationV0.lambda$createJwtRsaSsaPkcs1Sign$1(standardName, jwtRsaSsaPkcs1PrivateKey, publicKeySignCreate, rawJwt);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createJwtRsaSsaPkcs1Sign$1(String str, JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey, PublicKeySign publicKeySign, RawJwt rawJwt) throws GeneralSecurityException {
        String strCreateUnsignedCompact = JwtFormat.createUnsignedCompact(str, jwtRsaSsaPkcs1PrivateKey.getPublicKey().getKid(), rawJwt);
        return JwtFormat.createSignedCompact(strCreateUnsignedCompact, publicKeySign.sign(strCreateUnsignedCompact.getBytes(StandardCharsets.US_ASCII)));
    }

    private static RsaSsaPssPrivateKey toRsaSsaPssPrivateKey(JwtRsaSsaPssPrivateKey jwtRsaSsaPssPrivateKey) {
        return jwtRsaSsaPssPrivateKey.getRsaSsaPssPrivateKey();
    }

    private static JwtPublicKeySign createJwtRsaSsaPssSign(final JwtRsaSsaPssPrivateKey jwtRsaSsaPssPrivateKey) throws GeneralSecurityException {
        final PublicKeySign publicKeySignCreate = RsaSsaPssSignJce.create(toRsaSsaPssPrivateKey(jwtRsaSsaPssPrivateKey));
        final String standardName = jwtRsaSsaPssPrivateKey.getParameters().getAlgorithm().getStandardName();
        return new JwtPublicKeySign() { // from class: com.google.crypto.tink.jwt.JwtSignatureConfigurationV0$$ExternalSyntheticLambda5
            @Override // com.google.crypto.tink.jwt.JwtPublicKeySign
            public final String signAndEncode(RawJwt rawJwt) {
                return JwtSignatureConfigurationV0.lambda$createJwtRsaSsaPssSign$2(standardName, jwtRsaSsaPssPrivateKey, publicKeySignCreate, rawJwt);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createJwtRsaSsaPssSign$2(String str, JwtRsaSsaPssPrivateKey jwtRsaSsaPssPrivateKey, PublicKeySign publicKeySign, RawJwt rawJwt) throws GeneralSecurityException {
        String strCreateUnsignedCompact = JwtFormat.createUnsignedCompact(str, jwtRsaSsaPssPrivateKey.getPublicKey().getKid(), rawJwt);
        return JwtFormat.createSignedCompact(strCreateUnsignedCompact, publicKeySign.sign(strCreateUnsignedCompact.getBytes(StandardCharsets.US_ASCII)));
    }

    private static JwtPublicKeyVerify createJwtEcdsaVerify(final JwtEcdsaPublicKey jwtEcdsaPublicKey) throws GeneralSecurityException {
        final PublicKeyVerify publicKeyVerifyCreate = EcdsaVerifyJce.create(toEcdsaPublicKey(jwtEcdsaPublicKey));
        return new JwtPublicKeyVerify() { // from class: com.google.crypto.tink.jwt.JwtSignatureConfigurationV0$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.jwt.JwtPublicKeyVerify
            public final VerifiedJwt verifyAndDecode(String str, JwtValidator jwtValidator) {
                return JwtSignatureConfigurationV0.lambda$createJwtEcdsaVerify$3(publicKeyVerifyCreate, jwtEcdsaPublicKey, str, jwtValidator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ VerifiedJwt lambda$createJwtEcdsaVerify$3(PublicKeyVerify publicKeyVerify, JwtEcdsaPublicKey jwtEcdsaPublicKey, String str, JwtValidator jwtValidator) throws GeneralSecurityException {
        JwtFormat.Parts partsSplitSignedCompact = JwtFormat.splitSignedCompact(str);
        publicKeyVerify.verify(partsSplitSignedCompact.signatureOrMac, partsSplitSignedCompact.unsignedCompact.getBytes(StandardCharsets.US_ASCII));
        JsonObject json = JsonUtil.parseJson(partsSplitSignedCompact.header);
        JwtFormat.validateHeader(json, jwtEcdsaPublicKey.getParameters().getAlgorithm().getStandardName(), jwtEcdsaPublicKey.getKid(), jwtEcdsaPublicKey.getParameters().allowKidAbsent());
        return jwtValidator.validate(RawJwt.fromJsonPayload(JwtFormat.getTypeHeader(json), partsSplitSignedCompact.payload));
    }

    private static RsaSsaPkcs1PublicKey toRsaSsaPkcs1PublicKey(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) {
        return jwtRsaSsaPkcs1PublicKey.getRsaSsaPkcs1PublicKey();
    }

    private static JwtPublicKeyVerify createJwtRsaSsaPkcs1Verify(final JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) throws GeneralSecurityException {
        final PublicKeyVerify publicKeyVerifyCreate = RsaSsaPkcs1VerifyJce.create(toRsaSsaPkcs1PublicKey(jwtRsaSsaPkcs1PublicKey));
        return new JwtPublicKeyVerify() { // from class: com.google.crypto.tink.jwt.JwtSignatureConfigurationV0$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.jwt.JwtPublicKeyVerify
            public final VerifiedJwt verifyAndDecode(String str, JwtValidator jwtValidator) {
                return JwtSignatureConfigurationV0.lambda$createJwtRsaSsaPkcs1Verify$4(publicKeyVerifyCreate, jwtRsaSsaPkcs1PublicKey, str, jwtValidator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ VerifiedJwt lambda$createJwtRsaSsaPkcs1Verify$4(PublicKeyVerify publicKeyVerify, JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey, String str, JwtValidator jwtValidator) throws GeneralSecurityException {
        JwtFormat.Parts partsSplitSignedCompact = JwtFormat.splitSignedCompact(str);
        publicKeyVerify.verify(partsSplitSignedCompact.signatureOrMac, partsSplitSignedCompact.unsignedCompact.getBytes(StandardCharsets.US_ASCII));
        JsonObject json = JsonUtil.parseJson(partsSplitSignedCompact.header);
        JwtFormat.validateHeader(json, jwtRsaSsaPkcs1PublicKey.getParameters().getAlgorithm().getStandardName(), jwtRsaSsaPkcs1PublicKey.getKid(), jwtRsaSsaPkcs1PublicKey.getParameters().allowKidAbsent());
        return jwtValidator.validate(RawJwt.fromJsonPayload(JwtFormat.getTypeHeader(json), partsSplitSignedCompact.payload));
    }

    private static RsaSsaPssPublicKey toRsaSsaPssPublicKey(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) {
        return jwtRsaSsaPssPublicKey.getRsaSsaPssPublicKey();
    }

    private static JwtPublicKeyVerify createJwtRsaSsaPssVerify(final JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) throws GeneralSecurityException {
        final PublicKeyVerify publicKeyVerifyCreate = RsaSsaPssVerifyJce.create(toRsaSsaPssPublicKey(jwtRsaSsaPssPublicKey));
        return new JwtPublicKeyVerify() { // from class: com.google.crypto.tink.jwt.JwtSignatureConfigurationV0$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.jwt.JwtPublicKeyVerify
            public final VerifiedJwt verifyAndDecode(String str, JwtValidator jwtValidator) {
                return JwtSignatureConfigurationV0.lambda$createJwtRsaSsaPssVerify$5(publicKeyVerifyCreate, jwtRsaSsaPssPublicKey, str, jwtValidator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ VerifiedJwt lambda$createJwtRsaSsaPssVerify$5(PublicKeyVerify publicKeyVerify, JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey, String str, JwtValidator jwtValidator) throws GeneralSecurityException {
        JwtFormat.Parts partsSplitSignedCompact = JwtFormat.splitSignedCompact(str);
        publicKeyVerify.verify(partsSplitSignedCompact.signatureOrMac, partsSplitSignedCompact.unsignedCompact.getBytes(StandardCharsets.US_ASCII));
        JsonObject json = JsonUtil.parseJson(partsSplitSignedCompact.header);
        JwtFormat.validateHeader(json, jwtRsaSsaPssPublicKey.getParameters().getAlgorithm().getStandardName(), jwtRsaSsaPssPublicKey.getKid(), jwtRsaSsaPssPublicKey.getParameters().allowKidAbsent());
        return jwtValidator.validate(RawJwt.fromJsonPayload(JwtFormat.getTypeHeader(json), partsSplitSignedCompact.payload));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtPublicKeySign createJwtPublicKeySign(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof JwtEcdsaPrivateKey) {
            return createJwtEcdsaSign((JwtEcdsaPrivateKey) key);
        }
        if (key instanceof JwtRsaSsaPkcs1PrivateKey) {
            return createJwtRsaSsaPkcs1Sign((JwtRsaSsaPkcs1PrivateKey) key);
        }
        if (key instanceof JwtRsaSsaPssPrivateKey) {
            return createJwtRsaSsaPssSign((JwtRsaSsaPssPrivateKey) key);
        }
        throw new GeneralSecurityException("Unknown key class: " + key.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JwtPublicKeyVerify createJwtPublicKeyVerify(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        Key key = entry.getKey();
        if (key instanceof JwtEcdsaPublicKey) {
            return createJwtEcdsaVerify((JwtEcdsaPublicKey) key);
        }
        if (key instanceof JwtRsaSsaPkcs1PublicKey) {
            return createJwtRsaSsaPkcs1Verify((JwtRsaSsaPkcs1PublicKey) key);
        }
        if (key instanceof JwtRsaSsaPssPublicKey) {
            return createJwtRsaSsaPssVerify((JwtRsaSsaPssPublicKey) key);
        }
        throw new GeneralSecurityException("Unknown key class: " + key.getClass());
    }

    public static Configuration get() throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Cannot use JwtSignatureConfigurationV0, as BoringCrypto module is needed for FIPS compatibility");
        }
        return CONFIGURATION;
    }
}
