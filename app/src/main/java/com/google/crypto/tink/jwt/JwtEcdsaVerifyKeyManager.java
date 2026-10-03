package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.jwt.internal.JsonUtil;
import com.google.crypto.tink.jwt.internal.JwtFormat;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.google.crypto.tink.signature.EcdsaPublicKey;
import com.google.crypto.tink.subtle.EcdsaVerifyJce;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Enums;
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class JwtEcdsaVerifyKeyManager {
    static final PrimitiveConstructor<JwtEcdsaPublicKey, JwtPublicKeyVerify> PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.jwt.JwtEcdsaVerifyKeyManager$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return JwtEcdsaVerifyKeyManager.createFullPrimitive((JwtEcdsaPublicKey) key);
        }
    }, JwtEcdsaPublicKey.class, JwtPublicKeyVerify.class);

    static EcdsaPublicKey toEcdsaPublicKey(JwtEcdsaPublicKey jwtEcdsaPublicKey) throws GeneralSecurityException {
        return jwtEcdsaPublicKey.getEcdsaPublicKey();
    }

    static JwtPublicKeyVerify createFullPrimitive(final JwtEcdsaPublicKey jwtEcdsaPublicKey) throws GeneralSecurityException {
        final PublicKeyVerify publicKeyVerifyCreate = EcdsaVerifyJce.create(toEcdsaPublicKey(jwtEcdsaPublicKey));
        return new JwtPublicKeyVerify() { // from class: com.google.crypto.tink.jwt.JwtEcdsaVerifyKeyManager.1
            @Override // com.google.crypto.tink.jwt.JwtPublicKeyVerify
            public VerifiedJwt verifyAndDecode(String str, JwtValidator jwtValidator) throws GeneralSecurityException {
                JwtFormat.Parts partsSplitSignedCompact = JwtFormat.splitSignedCompact(str);
                publicKeyVerifyCreate.verify(partsSplitSignedCompact.signatureOrMac, partsSplitSignedCompact.unsignedCompact.getBytes(StandardCharsets.US_ASCII));
                JsonObject json = JsonUtil.parseJson(partsSplitSignedCompact.header);
                JwtFormat.validateHeader(json, jwtEcdsaPublicKey.getParameters().getAlgorithm().getStandardName(), jwtEcdsaPublicKey.getKid(), jwtEcdsaPublicKey.getParameters().allowKidAbsent());
                return jwtValidator.validate(RawJwt.fromJsonPayload(JwtFormat.getTypeHeader(json), partsSplitSignedCompact.payload));
            }
        };
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtEcdsaVerifyKeyManager$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm;

        static {
            int[] iArr = new int[JwtEcdsaAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = iArr;
            try {
                iArr[JwtEcdsaAlgorithm.ES256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static final EllipticCurves.CurveType getCurve(JwtEcdsaAlgorithm jwtEcdsaAlgorithm) throws GeneralSecurityException {
        int i = AnonymousClass2.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[jwtEcdsaAlgorithm.ordinal()];
        if (i == 1) {
            return EllipticCurves.CurveType.NIST_P256;
        }
        if (i == 2) {
            return EllipticCurves.CurveType.NIST_P384;
        }
        if (i == 3) {
            return EllipticCurves.CurveType.NIST_P521;
        }
        throw new GeneralSecurityException("unknown algorithm " + jwtEcdsaAlgorithm.name());
    }

    public static Enums.HashType hashForEcdsaAlgorithm(JwtEcdsaAlgorithm jwtEcdsaAlgorithm) throws GeneralSecurityException {
        int i = AnonymousClass2.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[jwtEcdsaAlgorithm.ordinal()];
        if (i == 1) {
            return Enums.HashType.SHA256;
        }
        if (i == 2) {
            return Enums.HashType.SHA384;
        }
        if (i == 3) {
            return Enums.HashType.SHA512;
        }
        throw new GeneralSecurityException("unknown algorithm " + jwtEcdsaAlgorithm.name());
    }

    static final void validateEcdsaAlgorithm(JwtEcdsaAlgorithm jwtEcdsaAlgorithm) throws GeneralSecurityException {
        hashForEcdsaAlgorithm(jwtEcdsaAlgorithm);
    }

    private JwtEcdsaVerifyKeyManager() {
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey";
    }
}
